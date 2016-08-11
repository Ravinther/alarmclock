package android.support.v4.view;

import android.view.MotionEvent;

/* renamed from: android.support.v4.view.n */
class C0248n {
    public static int m1090a(MotionEvent event, int pointerId) {
        return event.findPointerIndex(pointerId);
    }

    public static int m1091b(MotionEvent event, int pointerIndex) {
        return event.getPointerId(pointerIndex);
    }

    public static float m1092c(MotionEvent event, int pointerIndex) {
        return event.getX(pointerIndex);
    }

    public static float m1093d(MotionEvent event, int pointerIndex) {
        return event.getY(pointerIndex);
    }

    public static int m1089a(MotionEvent event) {
        return event.getPointerCount();
    }
}
