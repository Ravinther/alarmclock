package com.anglelabs.alarmclock.redesign.utils;

import com.anglelabs.alarmclock.redesign.model.RedesignAlarm;
import com.google.gson.Gson;

/* renamed from: com.anglelabs.alarmclock.redesign.utils.d */
public class C0796d {
    public static String m3791a(RedesignAlarm alarm) {
        return new Gson().toJson((Object) alarm);
    }
}
