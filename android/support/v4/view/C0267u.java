package android.support.v4.view;

import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.view.View;

/* renamed from: android.support.v4.view.u */
class C0267u {
    static long m1171a() {
        return ValueAnimator.getFrameDelay();
    }

    public static void m1172a(View view, int layerType, Paint paint) {
        view.setLayerType(layerType, paint);
    }

    public static int m1170a(View view) {
        return view.getLayerType();
    }
}
