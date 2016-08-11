package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.EdgeEffect;

/* renamed from: android.support.v4.widget.f */
class C0311f {
    public static Object m1343a(Context context) {
        return new EdgeEffect(context);
    }

    public static void m1344a(Object edgeEffect, int width, int height) {
        ((EdgeEffect) edgeEffect).setSize(width, height);
    }

    public static boolean m1345a(Object edgeEffect) {
        return ((EdgeEffect) edgeEffect).isFinished();
    }

    public static void m1348b(Object edgeEffect) {
        ((EdgeEffect) edgeEffect).finish();
    }

    public static boolean m1346a(Object edgeEffect, float deltaDistance) {
        ((EdgeEffect) edgeEffect).onPull(deltaDistance);
        return true;
    }

    public static boolean m1349c(Object edgeEffect) {
        EdgeEffect eff = (EdgeEffect) edgeEffect;
        eff.onRelease();
        return eff.isFinished();
    }

    public static boolean m1347a(Object edgeEffect, Canvas canvas) {
        return ((EdgeEffect) edgeEffect).draw(canvas);
    }
}
