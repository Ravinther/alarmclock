package com.anglelabs.alarmclock.redesign.utils;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.util.SparseArray;
import com.avg.toolkit.p049e.C0970a;
import java.lang.ref.SoftReference;

/* renamed from: com.anglelabs.alarmclock.redesign.utils.x */
public class C0861x {
    private static final Object f2469b;
    private final SparseArray f2470a;

    public C0861x() {
        this.f2470a = new SparseArray(2);
    }

    static {
        f2469b = new Object();
    }

    public BitmapDrawable m4045a(Activity activity, int resId) {
        int orientation = activity.getResources().getConfiguration().orientation;
        if (orientation == 1 || orientation == 2) {
            BitmapDrawable bitmapDrawable;
            synchronized (f2469b) {
                if (this.f2470a.get(orientation) == null || ((SoftReference) this.f2470a.get(orientation)).get() == null) {
                    this.f2470a.put(orientation, new SoftReference(C0831l.m3902a(activity.getResources(), resId, activity)));
                }
                bitmapDrawable = (BitmapDrawable) ((SoftReference) this.f2470a.get(orientation)).get();
            }
            return bitmapDrawable;
        }
        C0970a.m4325b("orientation was not clear, aborting background image");
        throw new NullPointerException("orientation is not clear");
    }

    public void m4046a() {
        this.f2470a.clear();
    }
}
