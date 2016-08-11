package android.support.v4.view;

import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewParent;
import java.util.WeakHashMap;

/* renamed from: android.support.v4.view.r */
public class C0264r {
    static final C0254j f491a;

    /* renamed from: android.support.v4.view.r.j */
    interface C0254j {
        int m1104a(View view);

        void m1105a(View view, int i, int i2, int i3, int i4);

        void m1106a(View view, int i, Paint paint);

        void m1107a(View view, Paint paint);

        void m1108a(View view, C0162a c0162a);

        void m1109a(View view, Runnable runnable);

        boolean m1110a(View view, int i);

        void m1111b(View view);

        void m1112b(View view, int i);

        int m1113c(View view);

        int m1114d(View view);

        int m1115e(View view);

        ViewParent m1116f(View view);

        boolean m1117g(View view);

        boolean m1118h(View view);
    }

    /* renamed from: android.support.v4.view.r.b */
    static class C0255b implements C0254j {
        WeakHashMap f489a;

        C0255b() {
            this.f489a = null;
        }

        public boolean m1126a(View v, int direction) {
            return false;
        }

        public int m1119a(View v) {
            return 2;
        }

        public void m1124a(View v, C0162a delegate) {
        }

        public void m1127b(View view) {
            view.invalidate();
        }

        public void m1121a(View view, int left, int top, int right, int bottom) {
            view.invalidate(left, top, right, bottom);
        }

        public void m1125a(View view, Runnable action) {
            view.postDelayed(action, m1120a());
        }

        long m1120a() {
            return 10;
        }

        public int m1129c(View view) {
            return 0;
        }

        public void m1128b(View view, int mode) {
        }

        public void m1122a(View view, int layerType, Paint paint) {
        }

        public int m1130d(View view) {
            return 0;
        }

        public void m1123a(View view, Paint p) {
        }

        public int m1131e(View view) {
            return 0;
        }

        public ViewParent m1132f(View view) {
            return view.getParent();
        }

        public boolean m1133g(View view) {
            Drawable bg = view.getBackground();
            if (bg == null || bg.getOpacity() != -1) {
                return false;
            }
            return true;
        }

        public boolean m1134h(View view) {
            return false;
        }
    }

    /* renamed from: android.support.v4.view.r.c */
    static class C0256c extends C0255b {
        C0256c() {
        }

        public boolean m1135g(View view) {
            return C0265s.m1168a(view);
        }
    }

    /* renamed from: android.support.v4.view.r.d */
    static class C0257d extends C0256c {
        C0257d() {
        }

        public int m1136a(View v) {
            return C0266t.m1169a(v);
        }
    }

    /* renamed from: android.support.v4.view.r.e */
    static class C0258e extends C0257d {
        C0258e() {
        }

        long m1137a() {
            return C0267u.m1171a();
        }

        public void m1138a(View view, int layerType, Paint paint) {
            C0267u.m1172a(view, layerType, paint);
        }

        public int m1140d(View view) {
            return C0267u.m1170a(view);
        }

        public void m1139a(View view, Paint paint) {
            m1138a(view, m1140d(view), paint);
            view.invalidate();
        }
    }

    /* renamed from: android.support.v4.view.r.f */
    static class C0259f extends C0258e {
        static boolean f490b;

        C0259f() {
        }

        static {
            f490b = false;
        }

        public boolean m1142a(View v, int direction) {
            return C0268v.m1174a(v, direction);
        }

        public void m1141a(View v, C0162a delegate) {
            C0268v.m1173a(v, delegate.m592a());
        }
    }

    /* renamed from: android.support.v4.view.r.g */
    static class C0260g extends C0259f {
        C0260g() {
        }

        public void m1145b(View view) {
            C0269w.m1175a(view);
        }

        public void m1143a(View view, int left, int top, int right, int bottom) {
            C0269w.m1177a(view, left, top, right, bottom);
        }

        public void m1144a(View view, Runnable action) {
            C0269w.m1178a(view, action);
        }

        public int m1147c(View view) {
            return C0269w.m1179b(view);
        }

        public void m1146b(View view, int mode) {
            if (mode == 4) {
                mode = 2;
            }
            C0269w.m1176a(view, mode);
        }

        public ViewParent m1148f(View view) {
            return C0269w.m1180c(view);
        }

        public boolean m1149h(View view) {
            return C0269w.m1181d(view);
        }
    }

    /* renamed from: android.support.v4.view.r.h */
    static class C0261h extends C0260g {
        C0261h() {
        }

        public void m1150a(View view, Paint paint) {
            C0270x.m1183a(view, paint);
        }

        public int m1151e(View view) {
            return C0270x.m1182a(view);
        }
    }

    /* renamed from: android.support.v4.view.r.i */
    static class C0262i extends C0261h {
        C0262i() {
        }

        public void m1152b(View view, int mode) {
            C0269w.m1176a(view, mode);
        }
    }

    /* renamed from: android.support.v4.view.r.a */
    static class C0263a extends C0262i {
        C0263a() {
        }
    }

    static {
        int version = VERSION.SDK_INT;
        if (version >= 21) {
            f491a = new C0263a();
        } else if (version >= 19) {
            f491a = new C0262i();
        } else if (version >= 17) {
            f491a = new C0261h();
        } else if (version >= 16) {
            f491a = new C0260g();
        } else if (version >= 14) {
            f491a = new C0259f();
        } else if (version >= 11) {
            f491a = new C0258e();
        } else if (version >= 9) {
            f491a = new C0257d();
        } else if (version >= 7) {
            f491a = new C0256c();
        } else {
            f491a = new C0255b();
        }
    }

    public static boolean m1159a(View v, int direction) {
        return f491a.m1110a(v, direction);
    }

    public static int m1153a(View v) {
        return f491a.m1104a(v);
    }

    public static void m1157a(View v, C0162a delegate) {
        f491a.m1108a(v, delegate);
    }

    public static void m1160b(View view) {
        f491a.m1111b(view);
    }

    public static void m1154a(View view, int left, int top, int right, int bottom) {
        f491a.m1105a(view, left, top, right, bottom);
    }

    public static void m1158a(View view, Runnable action) {
        f491a.m1109a(view, action);
    }

    public static int m1162c(View view) {
        return f491a.m1113c(view);
    }

    public static void m1161b(View view, int mode) {
        f491a.m1112b(view, mode);
    }

    public static void m1155a(View view, int layerType, Paint paint) {
        f491a.m1106a(view, layerType, paint);
    }

    public static int m1163d(View view) {
        return f491a.m1114d(view);
    }

    public static void m1156a(View view, Paint paint) {
        f491a.m1107a(view, paint);
    }

    public static int m1164e(View view) {
        return f491a.m1115e(view);
    }

    public static ViewParent m1165f(View view) {
        return f491a.m1116f(view);
    }

    public static boolean m1166g(View view) {
        return f491a.m1117g(view);
    }

    public static boolean m1167h(View v) {
        return f491a.m1118h(v);
    }
}
