package com.anglelabs.alarmclock.contentproviders;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.UriMatcher;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.media.AudioManager;
import android.media.RingtoneManager;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.text.format.DateFormat;
import com.alarmclock.xtreme.free.R;
import com.anglelabs.alarmclock.redesign.model.C0775b.C0774a;
import com.anglelabs.alarmclock.redesign.model.RedesignAlarm;
import com.anglelabs.alarmclock.redesign.p039d.C0695c;
import com.anglelabs.alarmclock.redesign.utils.C0850q;
import com.avg.toolkit.ITKSvc;
import com.millennialmedia.android.MMRequest;
import com.mopub.mobileads.util.Base64;
import java.util.Map;

public class AlarmProvider extends ContentProvider {
    private static final UriMatcher f1324b;
    private SQLiteOpenHelper f1325a;

    /* renamed from: com.anglelabs.alarmclock.contentproviders.AlarmProvider.a */
    private static class C0500a extends SQLiteOpenHelper {
        private final Context f1323a;

        public C0500a(Context context) {
            super(context, "alarms.db", null, 16);
            this.f1323a = context;
        }

        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE alarms (_id INTEGER PRIMARY KEY,hour INTEGER, minutes INTEGER, daysofweek INTEGER, alarmtime INTEGER, enabled INTEGER, vibrate INTEGER, message TEXT, snooze TEXT, shakeduration INTEGER, dismiss TEXT, dismissspeed INTEGER, soundtype TEXT, music TEXT, alert TEXT, dismisscode TEXT, timeoutduration INTEGER, snoozeduration INTEGER, increaseshake INTEGER, crescendo INTEGER, volume INTEGER, silentmode INTEGER, incall TEXT, playlistid INTEGER, timer INTEGER, timessnoozed INTEGER, maxsnoozes INTEGER, decreasesnooze INTEGER, numbermathdismiss INTEGER, numbermathsnooze INTEGER, increasemath INTEGER, volumerampfreq INTEGER, autosnoozeduration INTEGER, album TEXT, playlist TEXT, application TEXT, website TEXT, restartmath INTEGER, multiplechoice INTEGER, vibratestrength INTEGER, vibratedelay INTEGER, soundondismiss INTEGER, sendtweet INTEGER, use_large_snooze INTEGER, keep_screen_on INTEGER, allow_passing_questions INTEGER, tweettext TEXT);");
            C0500a.m2380d(db);
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int currentVersion) {
            C0850q.m3986a("Upgrading alarms database from version " + oldVersion + " to " + currentVersion);
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this.f1323a);
            Editor edit = prefs.edit();
            if (oldVersion < 6) {
                m2382e(db, prefs, edit);
            }
            if (oldVersion < 7) {
                C0500a.m2378c(db);
            }
            if (oldVersion < 8) {
                m2381d(db, prefs, edit);
            }
            if (oldVersion < 9) {
                m2379c(db, prefs, edit);
            }
            if (oldVersion < 10) {
                C0500a.m2374a(db, edit);
            }
            if (oldVersion < 11) {
                m2377b(db, prefs, edit);
            }
            if (oldVersion < 12) {
                m2370a(edit);
            }
            if (oldVersion < 13) {
                C0500a.m2380d(db);
            }
            if (oldVersion < 14) {
                db.execSQL("UPDATE alarms SET minutes = minutes * 60 WHERE timer = 1");
            }
            if (oldVersion < 15) {
                m2375a(db, prefs, edit);
            }
            if (oldVersion < 16) {
                m2373a(db);
                m2372a(prefs, edit);
                m2371a(prefs);
            }
            if (oldVersion < 15) {
                m2376b(db);
            }
            edit.apply();
        }

        private void m2371a(SharedPreferences prefs) {
            Editor editor = prefs.edit();
            if (!prefs.getBoolean("show_next_alarm_notification", true)) {
                editor.putString("show_notification_dialog", "1\u201a\u2017\u201a2").apply();
            }
        }

        private void m2372a(SharedPreferences prefs, Editor edit) {
            if (prefs.contains("suspend_alarms")) {
                edit.putBoolean("vacation_mode", prefs.getBoolean("suspend_alarms", false)).remove("suspend_alarms");
            }
        }

        private void m2373a(SQLiteDatabase db) {
            db.execSQL("ALTER TABLE alarms ADD COLUMN allow_passing_questions INTEGER DEFAULT 1");
        }

        private void m2375a(SQLiteDatabase db, SharedPreferences prefs, Editor editor) {
            int i;
            boolean useLargeSnoozeCompat = prefs.getBoolean("large_snooze", true);
            StringBuilder append = new StringBuilder().append("ALTER TABLE alarms ADD COLUMN use_large_snooze INTEGER DEFAULT ");
            if (useLargeSnoozeCompat) {
                i = 1;
            } else {
                i = 0;
            }
            db.execSQL(append.append(i).toString());
            boolean timerKeepScreenOn = prefs.getBoolean("show_countdown", false);
            append = new StringBuilder().append("ALTER TABLE alarms ADD COLUMN keep_screen_on INTEGER DEFAULT ");
            if (timerKeepScreenOn) {
                i = 1;
            } else {
                i = 0;
            }
            db.execSQL(append.append(i).toString());
            if (prefs.contains("notification")) {
                editor.putBoolean("show_next_alarm_notification", prefs.getBoolean("notification", true));
                editor.remove("notification");
            }
            if (prefs.contains("unlock")) {
                editor.putBoolean("unlock_phone_on_alarm", prefs.getBoolean("unlock", true));
                editor.remove("unlock");
            }
            if (prefs.contains("speakers")) {
                editor.putBoolean("use_phone_speaker", prefs.getBoolean("speakers", true));
                editor.remove("speakers");
            }
            if (prefs.contains("date_time_24hour")) {
                editor.putBoolean("use_24_hours", prefs.getBoolean("date_time_24hour", DateFormat.is24HourFormat(this.f1323a)));
                editor.remove("date_time_24hour");
            }
            if (prefs.contains("use_volume_control")) {
                editor.putBoolean("control_with_volume", prefs.getBoolean("use_volume_control", false));
                editor.remove("use_volume_control");
            }
            if (prefs.contains("keep_awake")) {
                editor.putBoolean("keep_screen_on", prefs.getBoolean("keep_awake", true));
                editor.remove("keep_awake");
            }
            editor.remove("color");
            editor.remove("screen_brightness");
            editor.remove(MMRequest.KEY_ORIENTATION);
            editor.remove("save_on_back");
            editor.remove("notification_icon");
            editor.remove("clear_math_difficulty");
            editor.remove("clear_num_math_dismiss");
            editor.remove("shake_sensitivity");
            editor.remove("allow_pass");
            editor.remove("shake_sensitivity");
            editor.remove("mute_length");
            editor.remove("show_countdown");
            editor.remove("clear_method");
            editor.remove("vibrate_intensity");
            editor.remove("show_snooze_screen");
            editor.remove("times_opened");
            editor.remove("next_alarm_type");
            editor.remove("large_snooze");
            editor.apply();
        }

        private void m2376b(SQLiteDatabase db) {
            Cursor c = db.query("alarms", null, null, null, null, null, null);
            if (c != null) {
                try {
                    db.beginTransaction();
                    while (c.moveToNext()) {
                        RedesignAlarm alarm = new RedesignAlarm(c);
                        if (alarm.f1994G == 0) {
                            alarm.m3618d(this.f1323a);
                            db.execSQL("UPDATE alarms SET alarmtime= " + alarm.f1994G + " WHERE _ID = " + alarm.f2010k);
                        }
                    }
                    db.setTransactionSuccessful();
                } catch (Exception e) {
                    C0850q.m3985a(e, "Crashes at updating DB updateVersion15 to version current version: 16 1");
                } finally {
                    c.close();
                    db.endTransaction();
                }
            }
        }

        private void m2370a(Editor edit) {
            try {
                SharedPreferences otherPrefs = this.f1323a.getSharedPreferences("AlarmClock", 0);
                Editor otherPrefsEditor = this.f1323a.getSharedPreferences("AlarmClock", 0).edit();
                edit.putString("next_alarm_time", otherPrefs.getString("next_alarm_time", ""));
                edit.putBoolean("skip_next", otherPrefs.getBoolean("skip_next", false));
                Map allPrefs = otherPrefs.getAll();
                for (String p : allPrefs.keySet()) {
                    if (p.startsWith("snooze_id_") || p.startsWith("active_id_")) {
                        edit.putInt(p, ((Integer) allPrefs.get(p)).intValue());
                    } else if (p.startsWith("snooze_time_")) {
                        edit.putLong(p, ((Long) allPrefs.get(p)).longValue());
                    }
                }
                otherPrefsEditor.clear();
                otherPrefsEditor.commit();
            } catch (Exception e) {
                C0850q.m3985a(e, "Crashes at updating DB updateVersion12 to version current version: 16");
            }
        }

        private void m2377b(SQLiteDatabase db, SharedPreferences prefs, Editor edit) {
            try {
                int maxVolume = ((AudioManager) this.f1323a.getSystemService("audio")).getStreamMaxVolume(4);
                int defaultVolume = prefs.getInt("default_alarm_volume", maxVolume);
                if (defaultVolume <= maxVolume) {
                    edit.putInt("default_alarm_volume", (defaultVolume * 100) / maxVolume);
                    db.execSQL("UPDATE alarms SET volume = (volume * 100) / " + maxVolume);
                } else {
                    edit.putInt("default_alarm_volume", maxVolume);
                    db.execSQL("UPDATE alarms SET volume = " + maxVolume);
                }
                edit.remove("show_advanced");
                db.execSQL("UPDATE alarms SET volumerampfreq = 60000");
            } catch (Exception e) {
                C0850q.m3985a(e, "Crashes at updating DB updateVersion11 to version current version: 16");
            }
        }

        private static void m2374a(SQLiteDatabase db, Editor edit) {
            try {
                edit.remove("timer_time");
                db.execSQL("UPDATE alarms SET daysofweek = 0, alarmtime = 0, enabled = 0 where timer = 1");
            } catch (Exception e) {
                C0850q.m3985a(e, "Crashes at updating DB updateVersion10 to version current version: 16");
            }
        }

        private void m2379c(SQLiteDatabase db, SharedPreferences prefs, Editor edit) {
            try {
                db.execSQL("UPDATE alarms SET vibratedelay = 1 where decreasesnooze = 1");
                String autoSnoozeDuration = prefs.getString("default_auto_snooze", ITKSvc.CODEREVISION);
                boolean decreaseSnooze = prefs.getBoolean("default_decrease_snooze", false);
                if (autoSnoozeDuration.equals(ITKSvc.CODEREVISION)) {
                    edit.putString("default_auto_snooze", ITKSvc.CODEREVISION);
                } else {
                    edit.putString("default_auto_snooze", "1");
                }
                if (decreaseSnooze) {
                    edit.putString("default_decrease_snooze_duration", "1");
                } else {
                    edit.putString("default_decrease_snooze_duration", ITKSvc.CODEREVISION);
                }
                SharedPreferences otherPrefs = this.f1323a.getSharedPreferences("AlarmClock", 0);
                Editor otherPrefsEditor = this.f1323a.getSharedPreferences("AlarmClock", 0).edit();
                if (otherPrefs.getInt("default_hour", -1) != -1) {
                    edit.putInt("default_hour", otherPrefs.getInt("default_hour", 8));
                    otherPrefsEditor.remove("default_hour");
                }
                if (otherPrefs.getInt("default_hour", -1) != -1) {
                    edit.putInt("default_minutes", otherPrefs.getInt("default_minutes", 0));
                    otherPrefsEditor.remove("default_minutes");
                }
                if (otherPrefs.getInt("default_alarm_volume", -1) != -1) {
                    edit.putInt("default_alarm_volume", otherPrefs.getInt("default_alarm_volume", ((AudioManager) this.f1323a.getSystemService("audio")).getStreamMaxVolume(4)));
                    otherPrefsEditor.remove("default_alarm_volume");
                }
                edit.remove("intro_dismissed");
                otherPrefsEditor.commit();
            } catch (Exception e) {
                C0850q.m3985a(e, "Crashes at updating DB updateVersion9 to version current version: 16");
            }
        }

        private void m2381d(SQLiteDatabase db, SharedPreferences prefs, Editor edit) {
            try {
                db.execSQL("UPDATE alarms SET timeoutduration = timeoutduration * 60000");
                edit.putString("default_timeout_duration", Integer.toString(Integer.parseInt(prefs.getString("default_timeout_duration", ITKSvc.CODEREVISION)) * 60000));
            } catch (Exception e) {
                C0850q.m3985a(e, "Crashes at updating DB updateVersion8 to version current version: 16");
            }
        }

        private static void m2378c(SQLiteDatabase db) {
            try {
                db.execSQL("ALTER TABLE alarms ADD decreasesnooze INTEGER");
                db.execSQL("ALTER TABLE alarms ADD numbermathdismiss INTEGER");
                db.execSQL("ALTER TABLE alarms ADD numbermathsnooze INTEGER");
                db.execSQL("ALTER TABLE alarms ADD increasemath INTEGER");
                db.execSQL("ALTER TABLE alarms ADD volumerampfreq INTEGER");
                db.execSQL("ALTER TABLE alarms ADD autosnoozeduration INTEGER");
                db.execSQL("ALTER TABLE alarms ADD album TEXT");
                db.execSQL("ALTER TABLE alarms ADD playlist TEXT");
                db.execSQL("ALTER TABLE alarms ADD application TEXT");
                db.execSQL("ALTER TABLE alarms ADD website TEXT");
                db.execSQL("ALTER TABLE alarms ADD restartmath INTEGER");
                db.execSQL("ALTER TABLE alarms ADD multiplechoice INTEGER");
                db.execSQL("ALTER TABLE alarms ADD vibratestrength INTEGER");
                db.execSQL("ALTER TABLE alarms ADD vibratedelay INTEGER");
                db.execSQL("ALTER TABLE alarms ADD soundondismiss INTEGER");
                db.execSQL("ALTER TABLE alarms ADD sendtweet INTEGER");
                db.execSQL("ALTER TABLE alarms ADD tweettext TEXT");
                db.execSQL("UPDATE alarms SET decreasesnooze = 0");
                db.execSQL("UPDATE alarms SET numbermathdismiss = 1");
                db.execSQL("UPDATE alarms SET numbermathsnooze = 1");
                db.execSQL("UPDATE alarms SET increasemath = 0");
                db.execSQL("UPDATE alarms SET volumerampfreq = 90000");
                db.execSQL("UPDATE alarms SET autosnoozeduration = 0");
                db.execSQL("UPDATE alarms SET album = ''");
                db.execSQL("UPDATE alarms SET playlist = ''");
                db.execSQL("UPDATE alarms SET application = ''");
                db.execSQL("UPDATE alarms SET website = ''");
                db.execSQL("UPDATE alarms SET restartmath = 0");
                db.execSQL("UPDATE alarms SET multiplechoice = 0");
                db.execSQL("UPDATE alarms SET vibratestrength = 0");
                db.execSQL("UPDATE alarms SET vibratedelay = 0");
                db.execSQL("UPDATE alarms SET soundondismiss = 0");
                db.execSQL("UPDATE alarms SET sendtweet = 0");
                db.execSQL("UPDATE alarms SET tweettext = ''");
            } catch (Exception e) {
                C0850q.m3985a(e, "Crashes at updating DB updateVersion7 to version current version: 16");
            }
        }

        private void m2382e(SQLiteDatabase db, SharedPreferences prefs, Editor edit) {
            int silentModeSetting = 1;
            try {
                int volumeCrescendoSetting;
                db.execSQL("ALTER TABLE alarms ADD dismisscode TEXT");
                db.execSQL("ALTER TABLE alarms ADD timeoutduration INTEGER");
                db.execSQL("ALTER TABLE alarms ADD snoozeduration INTEGER");
                db.execSQL("ALTER TABLE alarms ADD increaseshake INTEGER");
                db.execSQL("ALTER TABLE alarms ADD crescendo INTEGER");
                db.execSQL("ALTER TABLE alarms ADD volume INTEGER");
                db.execSQL("ALTER TABLE alarms ADD silentmode INTEGER");
                db.execSQL("ALTER TABLE alarms ADD incall TEXT");
                db.execSQL("ALTER TABLE alarms ADD playlistid INTEGER");
                db.execSQL("ALTER TABLE alarms ADD timer INTEGER");
                db.execSQL("ALTER TABLE alarms ADD timessnoozed INTEGER");
                db.execSQL("ALTER TABLE alarms ADD maxsnoozes INTEGER");
                String snoozeSetting = prefs.getString("snooze_duration", "10");
                if (prefs.getBoolean("gradually_increase_volume", true)) {
                    volumeCrescendoSetting = 1;
                } else {
                    volumeCrescendoSetting = 0;
                }
                if (!prefs.getBoolean("alarm_in_silent_mode", true)) {
                    silentModeSetting = 0;
                }
                edit.remove("snooze_duration");
                edit.remove("gradually_increase_volume");
                edit.remove("alarm_in_silent_mode");
                int volume = ((AudioManager) this.f1323a.getSystemService("audio")).getStreamVolume(4);
                db.execSQL("UPDATE alarms SET snoozeduration = " + snoozeSetting);
                db.execSQL("UPDATE alarms SET increaseshake = 0");
                db.execSQL("UPDATE alarms SET timeoutduration = 0");
                db.execSQL("UPDATE alarms SET crescendo = " + volumeCrescendoSetting);
                db.execSQL("UPDATE alarms SET volume = " + volume);
                db.execSQL("UPDATE alarms SET silentmode = " + silentModeSetting);
                db.execSQL("UPDATE alarms SET playlistid = 0");
                db.execSQL("UPDATE alarms SET timer = 0");
                db.execSQL("UPDATE alarms SET timessnoozed = 0");
                db.execSQL("UPDATE alarms SET maxsnoozes = 0");
                db.execSQL("UPDATE alarms SET dismisscode = ''");
                db.execSQL("UPDATE alarms SET incall = '" + this.f1323a.getResources().getInteger(R.integer.incall_default) + "'");
                db.execSQL("UPDATE alarms SET snooze = '1' WHERE snooze = 'Press button'");
                db.execSQL("UPDATE alarms SET snooze = '3' WHERE snooze = 'Shake phone'");
                db.execSQL("UPDATE alarms SET dismiss = '1' WHERE dismiss = 'Press button'");
                db.execSQL("UPDATE alarms SET dismiss = '2' WHERE dismiss = 'Minimum speed'");
                db.execSQL("UPDATE alarms SET dismiss = '3' WHERE dismiss = 'Place in car dock'");
                db.execSQL("UPDATE alarms SET soundtype = '1' WHERE soundtype = 'Ringtone'");
                db.execSQL("UPDATE alarms SET soundtype = '2' WHERE soundtype = 'Music'");
                db.execSQL("UPDATE alarms SET soundtype = '3' WHERE soundtype = 'Silent'");
            } catch (Exception e) {
                C0850q.m3985a(e, "Crashes at updating DB updateVersion6 to version current version: 16");
            }
        }

        private static void m2380d(SQLiteDatabase db) {
            try {
                db.execSQL("CREATE INDEX IF NOT EXISTS timer_idx ON alarms (timer)");
                db.execSQL("CREATE INDEX IF NOT EXISTS hour_min_idx ON alarms (hour, minutes)");
            } catch (Exception e) {
                C0850q.m3985a(e, "createIndices current version: 16");
            }
        }
    }

    static {
        f1324b = new UriMatcher(-1);
        f1324b.addURI("com.alarmclock.xtreme.free", "alarm", 1);
        f1324b.addURI("com.alarmclock.xtreme.free", "alarm/#", 2);
    }

    public boolean onCreate() {
        this.f1325a = new C0500a(getContext());
        return true;
    }

    public Cursor query(Uri url, String[] projectionIn, String selection, String[] selectionArgs, String sort) {
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        switch (f1324b.match(url)) {
            case Base64.NO_PADDING /*1*/:
                qb.setTables("alarms");
                break;
            case Base64.NO_WRAP /*2*/:
                qb.setTables("alarms");
                qb.appendWhere("_id=");
                qb.appendWhere((CharSequence) url.getPathSegments().get(1));
                break;
            default:
                throw new IllegalArgumentException("Unknown URL " + url);
        }
        Cursor ret = qb.query(this.f1325a.getReadableDatabase(), projectionIn, selection, selectionArgs, null, null, sort);
        if (ret == null) {
            C0850q.m3988c("Alarms.query failed with query: " + C0695c.m3157a(url, projectionIn, selection, selectionArgs, sort));
        } else {
            ret.setNotificationUri(getContext().getContentResolver(), url);
        }
        return ret;
    }

    public String getType(Uri url) {
        switch (f1324b.match(url)) {
            case Base64.NO_PADDING /*1*/:
                return "vnd.android.cursor.dir/alarms";
            case Base64.NO_WRAP /*2*/:
                return "vnd.android.cursor.item/alarms";
            default:
                throw new IllegalArgumentException("Unknown URL");
        }
    }

    public int update(Uri url, ContentValues values, String where, String[] whereArgs) {
        int match = f1324b.match(url);
        SQLiteDatabase db = this.f1325a.getWritableDatabase();
        switch (match) {
            case Base64.NO_WRAP /*2*/:
                int count = db.update("alarms", values, "_id=" + Long.parseLong((String) url.getPathSegments().get(1)), null);
                getContext().getContentResolver().notifyChange(url, null);
                return count;
            default:
                throw new UnsupportedOperationException("Cannot update URL: " + url);
        }
    }

    public Uri insert(Uri url, ContentValues initialValues) {
        if (f1324b.match(url) == 1) {
            ContentValues values;
            if (initialValues != null) {
                values = new ContentValues(initialValues);
            } else {
                values = new ContentValues();
            }
            if (!values.containsKey("hour")) {
                values.put("hour", Integer.valueOf(8));
            }
            if (!values.containsKey("minutes")) {
                values.put("minutes", Integer.valueOf(0));
            }
            if (!values.containsKey("daysofweek")) {
                values.put("daysofweek", Integer.valueOf(0));
            }
            if (!values.containsKey("alarmtime")) {
                values.put("alarmtime", Integer.valueOf(0));
            }
            if (!values.containsKey("enabled")) {
                values.put("enabled", Integer.valueOf(0));
            }
            if (!values.containsKey("vibrate")) {
                values.put("vibrate", Integer.valueOf(0));
            }
            if (!values.containsKey("message")) {
                values.put("message", "");
            }
            Resources resources = getContext().getResources();
            if (!values.containsKey("snooze")) {
                values.put("snooze", Integer.valueOf(resources.getInteger(R.integer.snooze_method_default)));
            }
            if (!values.containsKey("shakeduration")) {
                values.put("shakeduration", Integer.valueOf(resources.getInteger(R.integer.shake_duration_default)));
            }
            if (!values.containsKey("dismiss")) {
                values.put("dismiss", Integer.valueOf(resources.getInteger(R.integer.dismiss_method_default)));
            }
            if (!values.containsKey("dismissspeed")) {
                values.put("dismissspeed", Integer.valueOf(resources.getInteger(R.integer.dismiss_speed_default)));
            }
            if (!values.containsKey("soundtype")) {
                values.put("soundtype", Integer.valueOf(resources.getInteger(R.integer.sound_type_default)));
            }
            String ringtone = "";
            try {
                Uri ringtoneUri = RingtoneManager.getDefaultUri(4);
                if (ringtoneUri != null) {
                    ringtone = ringtoneUri.toString();
                }
            } catch (Exception e) {
            }
            if (!values.containsKey("alert")) {
                values.put("alert", ringtone);
            }
            if (!values.containsKey("music")) {
                values.put("music", "");
            }
            if (!values.containsKey("timeoutduration")) {
                values.put("timeoutduration", Integer.valueOf(0));
            }
            if (!values.containsKey("snoozeduration")) {
                values.put("snoozeduration", Integer.valueOf(10));
            }
            if (!values.containsKey("crescendo")) {
                values.put("crescendo", Integer.valueOf(1));
            }
            if (!values.containsKey("volume")) {
                values.put("volume", Integer.valueOf(100));
            }
            if (!values.containsKey("silentmode")) {
                values.put("silentmode", Integer.valueOf(1));
            }
            if (!values.containsKey("incall")) {
                values.put("incall", Integer.valueOf(resources.getInteger(R.integer.incall_default)));
            }
            if (!values.containsKey("increaseshake")) {
                values.put("increaseshake", Integer.valueOf(0));
            }
            if (!values.containsKey("timer")) {
                values.put("timer", Integer.valueOf(0));
            }
            if (!values.containsKey("maxsnoozes")) {
                values.put("maxsnoozes", Integer.valueOf(0));
            }
            if (!values.containsKey("decreasesnooze")) {
                values.put("decreasesnooze", Integer.valueOf(0));
            }
            if (!values.containsKey("playlistid")) {
                values.put("playlistid", Integer.valueOf(resources.getInteger(R.integer.math_difficulty_default)));
            }
            if (!values.containsKey("dismisscode")) {
                values.put("dismisscode", "");
            }
            if (!values.containsKey("application")) {
                values.put("application", "");
            }
            if (!values.containsKey("numbermathdismiss")) {
                values.put("numbermathdismiss", Integer.valueOf(1));
            }
            if (!values.containsKey("numbermathsnooze")) {
                values.put("numbermathsnooze", Integer.valueOf(1));
            }
            if (!values.containsKey("increasemath")) {
                values.put("increasemath", Integer.valueOf(0));
            }
            if (!values.containsKey("volumerampfreq")) {
                values.put("volumerampfreq", Integer.valueOf(60000));
            }
            if (!values.containsKey("autosnoozeduration")) {
                values.put("autosnoozeduration", Integer.valueOf(0));
            }
            if (!values.containsKey("playlist")) {
                values.put("playlist", "");
            }
            if (!values.containsKey("restartmath")) {
                values.put("restartmath", Integer.valueOf(0));
            }
            if (!values.containsKey("vibratedelay")) {
                values.put("vibratedelay", Integer.valueOf(0));
            }
            long rowId = this.f1325a.getWritableDatabase().insert("alarms", "message", values);
            if (rowId < 0) {
                throw new SQLException("Failed to insert row into " + url);
            }
            Uri newUrl = ContentUris.withAppendedId(C0774a.f2036a, rowId);
            getContext().getContentResolver().notifyChange(newUrl, null);
            return newUrl;
        }
        throw new IllegalArgumentException("Cannot insert into URL: " + url);
    }

    public int delete(Uri url, String where, String[] whereArgs) {
        int count;
        SQLiteDatabase db = this.f1325a.getWritableDatabase();
        switch (f1324b.match(url)) {
            case Base64.NO_PADDING /*1*/:
                count = db.delete("alarms", where, whereArgs);
                break;
            case Base64.NO_WRAP /*2*/:
                String whereClause;
                String segment = (String) url.getPathSegments().get(1);
                if (TextUtils.isEmpty(where)) {
                    whereClause = "_id=" + segment;
                } else {
                    whereClause = "_id=" + segment + " AND (" + where + ")";
                }
                count = db.delete("alarms", whereClause, whereArgs);
                break;
            default:
                throw new IllegalArgumentException("Cannot delete from URL: " + url);
        }
        getContext().getContentResolver().notifyChange(url, null);
        return count;
    }
}
