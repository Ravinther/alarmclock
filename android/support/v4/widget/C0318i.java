package android.support.v4.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.OverScroller;

/* renamed from: android.support.v4.widget.i */
class C0318i {
    public static Object m1385a(Context context, Interpolator interpolator) {
        return interpolator != null ? new OverScroller(context, interpolator) : new OverScroller(context);
    }

    public static int m1384a(Object scroller) {
        return ((OverScroller) scroller).getCurrX();
    }

    public static int m1387b(Object scroller) {
        return ((OverScroller) scroller).getCurrY();
    }

    public static boolean m1388c(Object scroller) {
        return ((OverScroller) scroller).computeScrollOffset();
    }

    public static void m1386a(Object scroller, int startX, int startY, int dx, int dy, int duration) {
        ((OverScroller) scroller).startScroll(startX, startY, dx, dy, duration);
    }

    public static void m1389d(Object scroller) {
        ((OverScroller) scroller).abortAnimation();
    }

    public static int m1390e(Object scroller) {
        return ((OverScroller) scroller).getFinalX();
    }

    public static int m1391f(Object scroller) {
        return ((OverScroller) scroller).getFinalY();
    }
}
