package com.anglelabs.alarmclock.redesign.model;

import android.net.Uri;
import android.provider.BaseColumns;

/* renamed from: com.anglelabs.alarmclock.redesign.model.b */
public class C0775b {

    /* renamed from: com.anglelabs.alarmclock.redesign.model.b.a */
    public static class C0774a implements BaseColumns {
        public static final Uri f2036a;
        public static final String[] f2037b;

        static {
            f2036a = Uri.parse("content://com.alarmclock.xtreme.free/alarm");
            f2037b = new String[]{"_id", "hour", "minutes", "daysofweek", "alarmtime", "enabled", "vibrate", "message", "snooze", "shakeduration", "dismiss", "dismissspeed", "soundtype", "music", "alert", "timeoutduration", "snoozeduration", "increaseshake", "crescendo", "volume", "silentmode", "incall", "timer", "maxsnoozes", "decreasesnooze", "playlistid", "dismisscode", "numbermathdismiss", "numbermathsnooze", "increasemath", "volumerampfreq", "autosnoozeduration", "playlist", "application", "restartmath", "vibratedelay", "use_large_snooze", "keep_screen_on", "allow_passing_questions"};
        }
    }
}
