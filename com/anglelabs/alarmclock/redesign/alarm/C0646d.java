package com.anglelabs.alarmclock.redesign.alarm;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import com.anglelabs.alarmclock.redesign.model.C0775b.C0774a;
import com.anglelabs.alarmclock.redesign.model.RedesignAlarm;
import com.anglelabs.alarmclock.redesign.p039d.C0694b;
import com.anglelabs.alarmclock.redesign.utils.ac;
import com.avg.toolkit.p049e.C0970a;
import java.util.ArrayList;
import java.util.Map.Entry;

/* renamed from: com.anglelabs.alarmclock.redesign.alarm.d */
public class C0646d {
    private static SharedPreferences m2980b(Context context) {
        return ac.m3774b(context.getApplicationContext());
    }

    public static int m2975a(Context context, int alarmId) {
        return C0646d.m2980b(context).getInt("times_snoozed_" + alarmId, 0);
    }

    public static void m2981b(Context context, int id) {
        SharedPreferences prefs = C0646d.m2980b(context);
        prefs.edit().putInt("times_snoozed_" + id, prefs.getInt("times_snoozed_" + id, 0) + 1).commit();
    }

    public static void m2984c(Context context, int alarmId) {
        C0646d.m2980b(context).edit().putInt("times_snoozed_" + alarmId, 0).commit();
    }

    public static void m2978a(Context context, int id, long time) {
        C0646d.m2980b(context).edit().putInt("snooze_id_" + id, id).putLong("snooze_time_" + id, time).remove("active_id_" + id).commit();
        AlarmStateManager.m2789a(context, false);
    }

    public static ArrayList m2977a(Context context, SharedPreferences prefs) {
        ArrayList alarms = new ArrayList();
        Cursor cursor = C0694b.m3147b(context.getContentResolver());
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    RedesignAlarm a = new RedesignAlarm(cursor);
                    if (prefs.getInt("snooze_id_" + a.f2010k, -1) != -1) {
                        alarms.add(a);
                    }
                } while (cursor.moveToNext());
            }
            cursor.close();
        }
        return alarms;
    }

    public static void m2983b(Context context, SharedPreferences prefs) {
        Editor ed = prefs.edit();
        Cursor cursor = C0694b.m3147b(context.getContentResolver());
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    ed.remove("active_id_" + new RedesignAlarm(cursor).f2010k);
                } while (cursor.moveToNext());
            }
            cursor.close();
        }
        ed.commit();
        AlarmStateManager.m2789a(context, false);
    }

    public static RedesignAlarm m2976a(Context context) {
        RedesignAlarm activeAlarm = null;
        int id = -1;
        for (Entry stringEntry : C0646d.m2980b(context).getAll().entrySet()) {
            if (((String) stringEntry.getKey()).startsWith("active_id_")) {
                try {
                    id = Integer.valueOf(stringEntry.getValue().toString()).intValue();
                    break;
                } catch (Exception e) {
                    C0970a.m4322a(e);
                }
            }
        }
        if (id != -1) {
            Cursor cursor = context.getContentResolver().query(C0774a.f2036a, C0774a.f2037b, "_id =?", new String[]{String.valueOf(id)}, null);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    activeAlarm = new RedesignAlarm(cursor);
                }
                cursor.close();
            }
        }
        return activeAlarm;
    }

    public static void m2985d(Context context, int id) {
        SharedPreferences prefs = C0646d.m2980b(context);
        int snoozeId = prefs.getInt("snooze_id_" + id, -1);
        if (snoozeId != -1) {
            if (snoozeId == id) {
                C0646d.m2986e(context, id);
            }
            AlarmStateManager.m2784a(context, prefs);
        }
    }

    public static void m2986e(Context context, int id) {
        C0646d.m2979a(context, id, false);
    }

    public static void m2979a(Context context, int id, boolean async) {
        Editor editor = C0646d.m2980b(context).edit().remove("snooze_id_" + id).remove("snooze_time_" + id);
        if (async) {
            editor.apply();
        } else {
            editor.commit();
        }
    }

    public static boolean m2987f(Context context, int alarmId) {
        return C0646d.m2980b(context).getInt(new StringBuilder().append("snooze_id_").append(alarmId).toString(), -1) != -1;
    }

    public static long m2988g(Context context, int alarmId) {
        return C0646d.m2980b(context).getLong("snooze_time_" + alarmId, -1);
    }

    public static void m2982b(Context context, int id, boolean active) {
        Editor ed = C0646d.m2980b(context).edit();
        if (active) {
            ed.putInt("active_id_" + id, id);
        } else {
            ed.remove("active_id_" + id);
        }
        ed.commit();
    }

    public static boolean m2989h(Context context, int alarmId) {
        return C0646d.m2980b(context).getInt(new StringBuilder().append("active_id_").append(alarmId).toString(), -1) != -1;
    }
}
