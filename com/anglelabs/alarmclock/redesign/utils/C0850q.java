package com.anglelabs.alarmclock.redesign.utils;

import com.anglelabs.alarmclock.redesign.utils.C0849p.C0848b;
import com.avg.toolkit.p049e.C0970a;

/* renamed from: com.anglelabs.alarmclock.redesign.utils.q */
public class C0850q {
    public static void m3986a(String log) {
        C0849p.m3976a(C0848b.DEBUG, null, log);
    }

    public static void m3987b(String log) {
        C0970a.m4325b(log);
        C0849p.m3976a(C0848b.ERROR, null, log);
    }

    public static void m3984a(Exception e) {
        C0850q.m3985a(e, null);
    }

    public static void m3985a(Exception e, String log) {
        C0970a.m4322a(e);
        C0849p.m3976a(C0848b.EXCEPTION, e, log);
    }

    public static void m3988c(String log) {
        C0849p.m3976a(C0848b.WARNING, null, log);
    }
}
