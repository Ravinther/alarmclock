package com.anglelabs.alarmclock.redesign.p039d;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import com.alarmclock.xtreme.free.R;
import com.anglelabs.alarmclock.redesign.alarm.AlarmStateManager;
import com.anglelabs.alarmclock.redesign.model.C0773a;
import com.anglelabs.alarmclock.redesign.model.C0775b.C0774a;
import com.anglelabs.alarmclock.redesign.model.RedesignAlarm;
import com.anglelabs.alarmclock.redesign.utils.C0808f;
import com.anglelabs.alarmclock.redesign.utils.C0850q;
import com.anglelabs.alarmclock.redesign.utils.C0860w;
import com.anglelabs.alarmclock.redesign.utils.ac;
import com.avg.toolkit.p049e.C0970a;
import com.avg.ui.general.rateus.C1186c;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/* renamed from: com.anglelabs.alarmclock.redesign.d.b */
public class C0694b {

    /* renamed from: com.anglelabs.alarmclock.redesign.d.b.1 */
    static class C06931 implements Runnable {
        final /* synthetic */ Context f1801a;
        final /* synthetic */ int f1802b;
        final /* synthetic */ ContentValues f1803c;

        C06931(Context context, int i, ContentValues contentValues) {
            this.f1801a = context;
            this.f1802b = i;
            this.f1803c = contentValues;
        }

        public void run() {
            this.f1801a.getContentResolver().update(ContentUris.withAppendedId(C0774a.f2036a, (long) this.f1802b), this.f1803c, null, null);
        }
    }

    public static void m3141a(Context context, ContentResolver contentResolver, RedesignAlarm alarm, int alarmId) {
        if (alarm == null) {
            try {
                alarm = C0694b.m3129a(contentResolver, (long) alarmId);
                if (alarm == null) {
                    return;
                }
            } catch (Exception e) {
                return;
            }
        }
        RedesignAlarm copyAlarm = RedesignAlarm.m3610b(alarm);
        RedesignAlarm defaultAlarm = C0694b.m3131a(context, contentResolver);
        if (defaultAlarm != null) {
            copyAlarm.f2010k = defaultAlarm.f2010k;
        } else {
            copyAlarm.f2010k = Integer.parseInt((String) C0694b.m3154d(contentResolver).getPathSegments().get(1));
        }
        copyAlarm.f2000a = 2;
        C0694b.m3153c(context, copyAlarm);
    }

    public static RedesignAlarm m3134a(Context context, RedesignAlarm alarmToBePreviewed) {
        long previewAlarmId = C0694b.m3146b(context);
        RedesignAlarm previewAlarm = RedesignAlarm.m3610b(alarmToBePreviewed);
        previewAlarm.f2010k = (int) previewAlarmId;
        previewAlarm.f2000a = 3;
        previewAlarm.f2005f = new C0773a(0);
        previewAlarm.m3618d(context);
        context.getContentResolver().update(ContentUris.withAppendedId(C0774a.f2036a, previewAlarmId), previewAlarm.m3611a(), null, null);
        return previewAlarm;
    }

    private static long m3146b(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        Uri uri = C0774a.f2036a;
        long j = C0774a.f2037b;
        Cursor cursor = contentResolver.query(uri, j, "timer=3", null, null);
        RedesignAlarm previewAlarm = null;
        if (cursor != null) {
            try {
                if (cursor.moveToFirst()) {
                    previewAlarm = new RedesignAlarm(cursor);
                }
                if (previewAlarm != null) {
                    j = cursor.getLong(cursor.getColumnIndex("_id"));
                    return j;
                }
                cursor.close();
            } finally {
                cursor.close();
            }
        }
        return Long.parseLong((String) contentResolver.insert(C0774a.f2036a, new RedesignAlarm(3).m3611a()).getPathSegments().get(1));
    }

    public static RedesignAlarm m3131a(Context context, ContentResolver contentResolver) {
        Cursor cursor = contentResolver.query(C0774a.f2036a, C0774a.f2037b, "timer=2", null, null);
        RedesignAlarm redesignAlarm = null;
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                redesignAlarm = new RedesignAlarm(cursor);
            }
            cursor.close();
        }
        if (redesignAlarm == null) {
            int defaultId = C0694b.m3128a(contentResolver);
            redesignAlarm = new RedesignAlarm(2);
            redesignAlarm.f2010k = defaultId;
            redesignAlarm.m3615b();
            redesignAlarm.m3612a(8, 0, new C0773a(0));
            redesignAlarm.f2020u = "";
            C0694b.m3141a(context, contentResolver, redesignAlarm, redesignAlarm.f2010k);
        }
        redesignAlarm.f2000a = 0;
        return redesignAlarm;
    }

    private static Uri m3154d(ContentResolver contentResolver) {
        ContentValues values = new ContentValues();
        values.put("timer", Integer.valueOf(2));
        values.put("minutes", Integer.valueOf(0));
        values.put("daysofweek", Integer.valueOf(0));
        return contentResolver.insert(C0774a.f2036a, values);
    }

    public static void m3138a(Context context, int id, ContentValues values, boolean async) {
        Context appContext = context.getApplicationContext();
        if (async) {
            C0808f.m3825a(new C06931(appContext, id, values));
        } else {
            appContext.getContentResolver().update(ContentUris.withAppendedId(C0774a.f2036a, (long) id), values, null, null);
        }
    }

    public static void m3142a(Context context, RedesignAlarm alarm, Uri uri) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("alert", uri.toString());
        context.getContentResolver().update(ContentUris.withAppendedId(C0774a.f2036a, (long) alarm.f2010k), contentValues, null, null);
    }

    public static int m3128a(ContentResolver contentResolver) {
        return Integer.parseInt((String) C0694b.m3154d(contentResolver).getPathSegments().get(1));
    }

    private static Uri m3155e(ContentResolver contentResolver) {
        ContentValues values = new ContentValues();
        values.put("timer", Integer.valueOf(0));
        return contentResolver.insert(C0774a.f2036a, values);
    }

    public static RedesignAlarm m3130a(Context context) {
        return C0694b.m3133a(context, ac.m3774b(context), null, false);
    }

    public static void m3137a(Context context, int alarmId) {
        if (context != null) {
            SharedPreferences prefs = ac.m3774b(context);
            ContentResolver contentResolver = context.getContentResolver();
            C0694b.m3139a(context, alarmId, prefs);
            contentResolver.delete(ContentUris.withAppendedId(C0774a.f2036a, (long) alarmId), "", null);
            AlarmStateManager.m2789a(context, false);
        }
    }

    public static void m3144a(Context context, List idsArray) {
        ContentResolver contentResolver = context.getContentResolver();
        ArrayList operationList = new ArrayList();
        for (Integer idToDelete : idsArray) {
            operationList.add(ContentProviderOperation.newDelete(ContentUris.withAppendedId(C0774a.f2036a, (long) idToDelete.intValue())).build());
        }
        try {
            contentResolver.applyBatch("com.alarmclock.xtreme.free", operationList);
        } catch (Exception e) {
            C0970a.m4322a(e);
            for (Integer idToDelete2 : idsArray) {
                C0694b.m3137a(context, idToDelete2.intValue());
            }
        }
    }

    public static RedesignAlarm m3148b(Context context, ContentResolver contentResolver) {
        Cursor cursor = contentResolver.query(C0774a.f2036a, C0774a.f2037b, "timer=1", null, null);
        RedesignAlarm defaultTimer = null;
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                defaultTimer = new RedesignAlarm(cursor);
            }
            cursor.close();
        }
        if (defaultTimer != null) {
            return defaultTimer;
        }
        int defaultId = Integer.parseInt(C0694b.m3155e(contentResolver).getLastPathSegment());
        defaultTimer = new RedesignAlarm(1);
        defaultTimer.f2010k = defaultId;
        defaultTimer.m3615b();
        C0694b.m3150b(context, defaultTimer);
        return defaultTimer;
    }

    public static void m3150b(Context context, RedesignAlarm alarm) {
        alarm.f2000a = 1;
        context.getContentResolver().update(ContentUris.withAppendedId(C0774a.f2036a, (long) alarm.f2010k), alarm.m3611a(), null, null);
        AlarmStateManager.m2789a(context, false);
    }

    public static void m3153c(Context context, RedesignAlarm alarm) {
        alarm.m3618d(context);
        context.getContentResolver().update(ContentUris.withAppendedId(C0774a.f2036a, (long) alarm.f2010k), alarm.m3611a(), null, null);
        AlarmStateManager.m2789a(context, false);
    }

    public static RedesignAlarm m3129a(ContentResolver contentResolver, long alarmId) {
        Cursor cursor = contentResolver.query(ContentUris.withAppendedId(C0774a.f2036a, alarmId), C0774a.f2037b, null, null, null);
        RedesignAlarm alarm = null;
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                alarm = new RedesignAlarm(cursor);
            }
            cursor.close();
        }
        if (alarm == null) {
            return null;
        }
        return alarm;
    }

    public static ArrayList m3135a(Context context, SharedPreferences prefs) {
        ArrayList alarms = new ArrayList();
        Cursor cursor = C0694b.m3147b(context.getContentResolver());
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    RedesignAlarm a = new RedesignAlarm(cursor);
                    if (prefs.getInt("snooze_id_" + a.f2010k, -1) != -1) {
                        alarms.add(a);
                    } else if (prefs.getInt("active_id_" + a.f2010k, -1) != -1) {
                        alarms.add(a);
                    }
                } while (cursor.moveToNext());
            }
            cursor.close();
        }
        return alarms;
    }

    public static RedesignAlarm m3149b(Context context, SharedPreferences prefs) {
        return C0694b.m3133a(context, prefs, null, true);
    }

    public static RedesignAlarm m3132a(Context context, SharedPreferences prefs, RedesignAlarm alarmToIgnore) {
        return C0694b.m3133a(context, prefs, alarmToIgnore, true);
    }

    public static RedesignAlarm m3133a(Context context, SharedPreferences prefs, RedesignAlarm alarmToIgnore, boolean includePreview) {
        Cursor cursor;
        RedesignAlarm alarm = null;
        long minTime = Long.MAX_VALUE;
        long now = System.currentTimeMillis();
        if (includePreview) {
            cursor = C0694b.m3147b(context.getContentResolver());
        } else {
            cursor = C0694b.m3152c(context.getContentResolver());
        }
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                boolean vacationMode = C0860w.m4036a(prefs);
                do {
                    RedesignAlarm a = new RedesignAlarm(cursor);
                    if (prefs.getInt("snooze_id_" + a.f2010k, -1) != -1) {
                        long snoozeTome = prefs.getLong("snooze_time_" + a.f2010k, 0);
                        if (1000 + snoozeTome < now) {
                            C0850q.m3987b("time expired for alarm: " + a.f2010k + " before:" + (snoozeTome - now));
                            C0694b.m3139a(context, a.f2010k, prefs);
                            C0694b.m3145a(prefs, a.f2010k);
                        } else {
                            a.f1994G = prefs.getLong("snooze_time_" + a.f2010k, 0);
                        }
                    } else if (a.f2012m) {
                        if (a.f2005f.m3661c()) {
                            if (!vacationMode) {
                                a.f1994G = C0694b.m3136a(a.f2009j, a.f2023x, a.f2005f).getTimeInMillis();
                            }
                        } else if (a.f1994G < now) {
                            C0694b.m3143a(context, a, false);
                            C0694b.m3145a(prefs, a.f2010k);
                        }
                    }
                    if (a.f1994G < minTime && !a.equals(alarmToIgnore)) {
                        minTime = a.f1994G;
                        alarm = a;
                    }
                } while (cursor.moveToNext());
            }
            cursor.close();
        }
        return alarm;
    }

    public static void m3140a(Context context, int id, boolean enabled) {
        C0694b.m3143a(context, C0694b.m3129a(context.getContentResolver(), (long) id), enabled);
        AlarmStateManager.m2789a(context, false);
    }

    private static void m3143a(Context context, RedesignAlarm alarm, boolean enabled) {
        int i = 1;
        if (alarm == null) {
            C0850q.m3987b("alarm is null, aborting!");
            return;
        }
        boolean alarmTurningOn;
        if (alarm.f2012m || !enabled) {
            alarmTurningOn = false;
        } else {
            alarmTurningOn = true;
        }
        if (alarmTurningOn) {
            C1186c.m4956a(context).m4986a((int) R.string.rate_us_key_alarm_set);
        }
        ContentResolver resolver = context.getContentResolver();
        ContentValues values = new ContentValues(2);
        String str = "enabled";
        if (!enabled) {
            i = 0;
        }
        values.put(str, Integer.valueOf(i));
        if (enabled) {
            long time = 0;
            if (!alarm.f2005f.m3661c()) {
                time = C0694b.m3136a(alarm.f2009j, alarm.f2023x, alarm.f2005f).getTimeInMillis();
            }
            values.put("alarmtime", Long.valueOf(time));
        }
        resolver.update(ContentUris.withAppendedId(C0774a.f2036a, (long) alarm.f2010k), values, null, null);
    }

    public static Calendar m3136a(int hour, int minute, C0773a daysOfWeek) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(System.currentTimeMillis());
        int nowHour = c.get(11);
        int nowMinute = c.get(12);
        if (hour < nowHour || (hour == nowHour && minute <= nowMinute)) {
            c.add(6, 1);
        }
        c.set(11, hour);
        c.set(12, minute);
        c.set(13, 0);
        c.set(14, 0);
        int addDays = daysOfWeek.m3654a(c);
        if (addDays > 0) {
            c.add(7, addDays);
        }
        return c;
    }

    public static void m3139a(Context context, int id, SharedPreferences prefs) {
        int snoozeId = prefs.getInt("snooze_id_" + id, -1);
        if (snoozeId != -1) {
            if (snoozeId == id) {
                C0694b.m3151b(prefs, id);
            }
            AlarmStateManager.m2784a(context, prefs);
        }
    }

    private static void m3151b(SharedPreferences prefs, int id) {
        prefs.edit().remove("snooze_id_" + id).remove("snooze_time_" + id).apply();
    }

    public static void m3145a(SharedPreferences prefs, int alarmId) {
        prefs.edit().remove("times_snoozed_" + alarmId).apply();
    }

    public static Cursor m3147b(ContentResolver contentResolver) {
        return contentResolver.query(C0774a.f2036a, C0774a.f2037b, "timer=0 OR timer=3", null, "hour ASC, minutes ASC");
    }

    public static Cursor m3152c(ContentResolver contentResolver) {
        return contentResolver.query(C0774a.f2036a, C0774a.f2037b, "timer=0", null, "hour ASC, minutes ASC");
    }
}
