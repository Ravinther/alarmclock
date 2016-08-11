package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.ViewGroup;

public class aa {
    static final C0208d f475a;

    /* renamed from: android.support.v4.view.aa.d */
    interface C0208d {
        void m967a(ViewGroup viewGroup, boolean z);
    }

    /* renamed from: android.support.v4.view.aa.f */
    static class C0209f implements C0208d {
        C0209f() {
        }

        public void m968a(ViewGroup group, boolean split) {
        }
    }

    /* renamed from: android.support.v4.view.aa.b */
    static class C0210b extends C0209f {
        C0210b() {
        }

        public void m969a(ViewGroup group, boolean split) {
            ab.m971a(group, split);
        }
    }

    /* renamed from: android.support.v4.view.aa.c */
    static class C0211c extends C0210b {
        C0211c() {
        }
    }

    /* renamed from: android.support.v4.view.aa.e */
    static class C0212e extends C0211c {
        C0212e() {
        }
    }

    /* renamed from: android.support.v4.view.aa.a */
    static class C0213a extends C0212e {
        C0213a() {
        }
    }

    static {
        int version = VERSION.SDK_INT;
        if (version >= 21) {
            f475a = new C0213a();
        } else if (version >= 18) {
            f475a = new C0212e();
        } else if (version >= 14) {
            f475a = new C0211c();
        } else if (version >= 11) {
            f475a = new C0210b();
        } else {
            f475a = new C0209f();
        }
    }

    public static void m970a(ViewGroup group, boolean split) {
        f475a.m967a(group, split);
    }
}
