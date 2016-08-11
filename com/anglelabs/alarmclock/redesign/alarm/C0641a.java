package com.anglelabs.alarmclock.redesign.alarm;

import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.anglelabs.alarmclock.redesign.utils.C0850q;

/* renamed from: com.anglelabs.alarmclock.redesign.alarm.a */
public class C0641a {
    private static WakeLock f1717a;

    public static PowerManager m2944a(Context context) {
        return (PowerManager) context.getSystemService("power");
    }

    public static WakeLock m2946b(Context context) {
        C0850q.m3986a("creating partial WakeLock");
        return ((PowerManager) context.getSystemService("power")).newWakeLock(1, "AlarmAlertWakeLock");
    }

    public static void m2947c(Context context) {
        if (f1717a != null) {
            C0850q.m3988c("called when cpuLock already exists!");
            return;
        }
        f1717a = C0641a.m2946b(context);
        f1717a.acquire();
        C0850q.m3986a("lock acquired");
    }

    public static void m2948d(Context context) {
        if (f1717a != null) {
            C0850q.m3988c("called when cpuLock already exists!");
            return;
        }
        f1717a = ((PowerManager) context.getSystemService("power")).newWakeLock(805306369, "AlarmAlertWakeLock");
        f1717a.acquire();
        C0850q.m3986a("screen lock acquired");
    }

    public static void m2945a() {
        if (f1717a != null) {
            f1717a.release();
            C0850q.m3986a("cpuLock released");
            f1717a = null;
        }
    }
}
