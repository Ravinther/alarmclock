package com.p037b.p063c;

import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Interpolator;
import com.p037b.p038a.C1193a.C0672a;
import java.util.WeakHashMap;

/* renamed from: com.b.c.b */
public abstract class C1238b {
    private static final WeakHashMap f3756a;

    public abstract C1238b m5285a(float f);

    public abstract C1238b m5286a(long j);

    public abstract C1238b m5287a(Interpolator interpolator);

    public abstract C1238b m5288a(C0672a c0672a);

    public abstract void m5289a();

    public abstract C1238b m5290b(float f);

    public abstract C1238b m5291c(float f);

    public abstract C1238b m5292d(float f);

    public abstract C1238b m5293e(float f);

    public abstract C1238b m5294f(float f);

    static {
        f3756a = new WeakHashMap(0);
    }

    public static C1238b m5284a(View view) {
        C1238b animator = (C1238b) f3756a.get(view);
        if (animator == null) {
            int version = Integer.valueOf(VERSION.SDK).intValue();
            if (version >= 14) {
                animator = new C1245d(view);
            } else if (version >= 11) {
                animator = new C1243c(view);
            } else {
                animator = new C1250e(view);
            }
            f3756a.put(view, animator);
        }
        return animator;
    }
}
