package com.anglelabs.alarmclock.redesign.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.format.DateFormat;

/* renamed from: com.anglelabs.alarmclock.redesign.utils.w */
public class C0860w {
    public static boolean m4036a(SharedPreferences prefs) {
        if (prefs == null) {
            return false;
        }
        return prefs.getBoolean("vacation_mode", false);
    }

    public static void m4032a(Context context, boolean enable) {
        C0860w.m4031a(context, "vacation_mode", enable);
    }

    public static boolean m4039b(SharedPreferences prefs) {
        if (prefs == null) {
            return true;
        }
        return prefs.getBoolean("use_phone_speaker", true);
    }

    public static boolean m4041c(SharedPreferences prefs) {
        if (prefs == null) {
            return true;
        }
        return prefs.getBoolean("unlock_phone_on_alarm", true);
    }

    public static boolean m4042d(SharedPreferences prefs) {
        if (prefs == null) {
            return true;
        }
        return prefs.getBoolean("show_next_alarm_notification", true);
    }

    public static void m4035a(SharedPreferences prefs, boolean enable) {
        C0860w.m4034a(prefs, "show_next_alarm_notification", enable);
    }

    public static boolean m4043e(SharedPreferences prefs) {
        if (prefs == null) {
            return true;
        }
        return prefs.getBoolean("show_stopwatch_notification", true);
    }

    public static void m4037b(SharedPreferences prefs, boolean enable) {
        C0860w.m4034a(prefs, "show_stopwatch_notification", enable);
    }

    public static boolean m4044f(SharedPreferences prefs) {
        if (prefs == null) {
            return true;
        }
        return prefs.getBoolean("show_timer_notification", true);
    }

    public static void m4040c(SharedPreferences prefs, boolean enable) {
        C0860w.m4034a(prefs, "show_timer_notification", enable);
    }

    public static void m4030a(Context context, String firstDay) {
        ac.m3774b(context).edit().putString("first_day_of_week", firstDay).commit();
    }

    public static String m4029a(Context context) {
        return ac.m3774b(context).getString("first_day_of_week", String.valueOf(2));
    }

    public static boolean m4038b(Context context) {
        try {
            return ac.m3774b(context).getBoolean("use_24_hours", DateFormat.is24HourFormat(context));
        } catch (NullPointerException e) {
            return true;
        }
    }

    public static void m4031a(Context context, String key, boolean value) {
        C0860w.m4033a(ac.m3774b(context).edit(), key, value, true);
    }

    public static void m4034a(SharedPreferences prefs, String key, boolean value) {
        C0860w.m4033a(prefs.edit(), key, value, true);
    }

    public static void m4033a(Editor edit, String key, boolean value, boolean commit) {
        edit.putBoolean(key, value);
        if (commit) {
            edit.commit();
        }
    }
}
