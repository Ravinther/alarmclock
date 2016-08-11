package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.ViewConfiguration;

/* renamed from: android.support.v4.view.y */
public class C0276y {
    static final C0271e f492a;

    /* renamed from: android.support.v4.view.y.e */
    interface C0271e {
        int m1184a(ViewConfiguration viewConfiguration);
    }

    /* renamed from: android.support.v4.view.y.a */
    static class C0272a implements C0271e {
        C0272a() {
        }

        public int m1185a(ViewConfiguration config) {
            return config.getScaledTouchSlop();
        }
    }

    /* renamed from: android.support.v4.view.y.b */
    static class C0273b extends C0272a {
        C0273b() {
        }

        public int m1186a(ViewConfiguration config) {
            return C0277z.m1188a(config);
        }
    }

    /* renamed from: android.support.v4.view.y.c */
    static class C0274c extends C0273b {
        C0274c() {
        }
    }

    /* renamed from: android.support.v4.view.y.d */
    static class C0275d extends C0274c {
        C0275d() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 14) {
            f492a = new C0275d();
        } else if (VERSION.SDK_INT >= 11) {
            f492a = new C0274c();
        } else if (VERSION.SDK_INT >= 8) {
            f492a = new C0273b();
        } else {
            f492a = new C0272a();
        }
    }

    public static int m1187a(ViewConfiguration config) {
        return f492a.m1184a(config);
    }
}
