package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.VelocityTracker;

/* renamed from: android.support.v4.view.p */
public class C0252p {
    static final C0249c f488a;

    /* renamed from: android.support.v4.view.p.c */
    interface C0249c {
        float m1094a(VelocityTracker velocityTracker, int i);

        float m1095b(VelocityTracker velocityTracker, int i);
    }

    /* renamed from: android.support.v4.view.p.a */
    static class C0250a implements C0249c {
        C0250a() {
        }

        public float m1096a(VelocityTracker tracker, int pointerId) {
            return tracker.getXVelocity();
        }

        public float m1097b(VelocityTracker tracker, int pointerId) {
            return tracker.getYVelocity();
        }
    }

    /* renamed from: android.support.v4.view.p.b */
    static class C0251b implements C0249c {
        C0251b() {
        }

        public float m1098a(VelocityTracker tracker, int pointerId) {
            return C0253q.m1102a(tracker, pointerId);
        }

        public float m1099b(VelocityTracker tracker, int pointerId) {
            return C0253q.m1103b(tracker, pointerId);
        }
    }

    static {
        if (VERSION.SDK_INT >= 11) {
            f488a = new C0251b();
        } else {
            f488a = new C0250a();
        }
    }

    public static float m1100a(VelocityTracker tracker, int pointerId) {
        return f488a.m1094a(tracker, pointerId);
    }

    public static float m1101b(VelocityTracker tracker, int pointerId) {
        return f488a.m1095b(tracker, pointerId);
    }
}
