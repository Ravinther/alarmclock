package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.MotionEvent;

/* renamed from: android.support.v4.view.m */
public class C0247m {
    static final C0244c f487a;

    /* renamed from: android.support.v4.view.m.c */
    interface C0244c {
        int m1067a(MotionEvent motionEvent);

        int m1068a(MotionEvent motionEvent, int i);

        int m1069b(MotionEvent motionEvent, int i);

        float m1070c(MotionEvent motionEvent, int i);

        float m1071d(MotionEvent motionEvent, int i);
    }

    /* renamed from: android.support.v4.view.m.a */
    static class C0245a implements C0244c {
        C0245a() {
        }

        public int m1073a(MotionEvent event, int pointerId) {
            if (pointerId == 0) {
                return 0;
            }
            return -1;
        }

        public int m1074b(MotionEvent event, int pointerIndex) {
            if (pointerIndex == 0) {
                return 0;
            }
            throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
        }

        public float m1075c(MotionEvent event, int pointerIndex) {
            if (pointerIndex == 0) {
                return event.getX();
            }
            throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
        }

        public float m1076d(MotionEvent event, int pointerIndex) {
            if (pointerIndex == 0) {
                return event.getY();
            }
            throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
        }

        public int m1072a(MotionEvent event) {
            return 1;
        }
    }

    /* renamed from: android.support.v4.view.m.b */
    static class C0246b implements C0244c {
        C0246b() {
        }

        public int m1078a(MotionEvent event, int pointerId) {
            return C0248n.m1090a(event, pointerId);
        }

        public int m1079b(MotionEvent event, int pointerIndex) {
            return C0248n.m1091b(event, pointerIndex);
        }

        public float m1080c(MotionEvent event, int pointerIndex) {
            return C0248n.m1092c(event, pointerIndex);
        }

        public float m1081d(MotionEvent event, int pointerIndex) {
            return C0248n.m1093d(event, pointerIndex);
        }

        public int m1077a(MotionEvent event) {
            return C0248n.m1089a(event);
        }
    }

    static {
        if (VERSION.SDK_INT >= 5) {
            f487a = new C0246b();
        } else {
            f487a = new C0245a();
        }
    }

    public static int m1082a(MotionEvent event) {
        return event.getAction() & 255;
    }

    public static int m1084b(MotionEvent event) {
        return (event.getAction() & 65280) >> 8;
    }

    public static int m1083a(MotionEvent event, int pointerId) {
        return f487a.m1068a(event, pointerId);
    }

    public static int m1085b(MotionEvent event, int pointerIndex) {
        return f487a.m1069b(event, pointerIndex);
    }

    public static float m1086c(MotionEvent event, int pointerIndex) {
        return f487a.m1070c(event, pointerIndex);
    }

    public static float m1088d(MotionEvent event, int pointerIndex) {
        return f487a.m1071d(event, pointerIndex);
    }

    public static int m1087c(MotionEvent event) {
        return f487a.m1067a(event);
    }
}
