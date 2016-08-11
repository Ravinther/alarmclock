package android.support.v4.view;

import android.os.Build.VERSION;

/* renamed from: android.support.v4.view.e */
public class C0224e {
    static final C0221a f481a;

    /* renamed from: android.support.v4.view.e.a */
    interface C0221a {
        int m998a(int i, int i2);
    }

    /* renamed from: android.support.v4.view.e.b */
    static class C0222b implements C0221a {
        C0222b() {
        }

        public int m999a(int gravity, int layoutDirection) {
            return -8388609 & gravity;
        }
    }

    /* renamed from: android.support.v4.view.e.c */
    static class C0223c implements C0221a {
        C0223c() {
        }

        public int m1000a(int gravity, int layoutDirection) {
            return C0225f.m1002a(gravity, layoutDirection);
        }
    }

    static {
        if (VERSION.SDK_INT >= 17) {
            f481a = new C0223c();
        } else {
            f481a = new C0222b();
        }
    }

    public static int m1001a(int gravity, int layoutDirection) {
        return f481a.m998a(gravity, layoutDirection);
    }
}
