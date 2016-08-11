package com.anglelabs.alarmclock.redesign.utils;

import android.os.Handler;
import android.os.HandlerThread;

/* renamed from: com.anglelabs.alarmclock.redesign.utils.f */
public final class C0808f {
    private static final HandlerThread f2125a;
    private static final Handler f2126b;

    static {
        f2125a = new HandlerThread("AsyncHandler");
        f2125a.start();
        f2126b = new Handler(f2125a.getLooper());
    }

    public static void m3825a(Runnable r) {
        f2126b.post(r);
    }
}
