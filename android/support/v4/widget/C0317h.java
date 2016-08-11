package android.support.v4.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.animation.Interpolator;
import android.widget.Scroller;

/* renamed from: android.support.v4.widget.h */
public class C0317h {
    Object f585a;
    C0313a f586b;

    /* renamed from: android.support.v4.widget.h.a */
    interface C0313a {
        int m1352a(Object obj);

        Object m1353a(Context context, Interpolator interpolator);

        void m1354a(Object obj, int i, int i2, int i3, int i4, int i5);

        int m1355b(Object obj);

        boolean m1356c(Object obj);

        void m1357d(Object obj);

        int m1358e(Object obj);

        int m1359f(Object obj);
    }

    /* renamed from: android.support.v4.widget.h.b */
    static class C0314b implements C0313a {
        C0314b() {
        }

        public Object m1361a(Context context, Interpolator interpolator) {
            return interpolator != null ? new Scroller(context, interpolator) : new Scroller(context);
        }

        public int m1360a(Object scroller) {
            return ((Scroller) scroller).getCurrX();
        }

        public int m1363b(Object scroller) {
            return ((Scroller) scroller).getCurrY();
        }

        public boolean m1364c(Object scroller) {
            return ((Scroller) scroller).computeScrollOffset();
        }

        public void m1362a(Object scroller, int startX, int startY, int dx, int dy, int duration) {
            ((Scroller) scroller).startScroll(startX, startY, dx, dy, duration);
        }

        public void m1365d(Object scroller) {
            ((Scroller) scroller).abortAnimation();
        }

        public int m1366e(Object scroller) {
            return ((Scroller) scroller).getFinalX();
        }

        public int m1367f(Object scroller) {
            return ((Scroller) scroller).getFinalY();
        }
    }

    /* renamed from: android.support.v4.widget.h.c */
    static class C0315c implements C0313a {
        C0315c() {
        }

        public Object m1369a(Context context, Interpolator interpolator) {
            return C0318i.m1385a(context, interpolator);
        }

        public int m1368a(Object scroller) {
            return C0318i.m1384a(scroller);
        }

        public int m1371b(Object scroller) {
            return C0318i.m1387b(scroller);
        }

        public boolean m1372c(Object scroller) {
            return C0318i.m1388c(scroller);
        }

        public void m1370a(Object scroller, int startX, int startY, int dx, int dy, int duration) {
            C0318i.m1386a(scroller, startX, startY, dx, dy, duration);
        }

        public void m1373d(Object scroller) {
            C0318i.m1389d(scroller);
        }

        public int m1374e(Object scroller) {
            return C0318i.m1390e(scroller);
        }

        public int m1375f(Object scroller) {
            return C0318i.m1391f(scroller);
        }
    }

    /* renamed from: android.support.v4.widget.h.d */
    static class C0316d extends C0315c {
        C0316d() {
        }
    }

    public static C0317h m1376a(Context context, Interpolator interpolator) {
        return new C0317h(context, interpolator);
    }

    C0317h(Context context, Interpolator interpolator) {
        this(VERSION.SDK_INT, context, interpolator);
    }

    private C0317h(int apiVersion, Context context, Interpolator interpolator) {
        if (apiVersion >= 14) {
            this.f586b = new C0316d();
        } else if (apiVersion >= 9) {
            this.f586b = new C0315c();
        } else {
            this.f586b = new C0314b();
        }
        this.f585a = this.f586b.m1353a(context, interpolator);
    }

    public int m1377a() {
        return this.f586b.m1352a(this.f585a);
    }

    public int m1379b() {
        return this.f586b.m1355b(this.f585a);
    }

    public int m1380c() {
        return this.f586b.m1358e(this.f585a);
    }

    public int m1381d() {
        return this.f586b.m1359f(this.f585a);
    }

    public boolean m1382e() {
        return this.f586b.m1356c(this.f585a);
    }

    public void m1378a(int startX, int startY, int dx, int dy, int duration) {
        this.f586b.m1354a(this.f585a, startX, startY, dx, dy, duration);
    }

    public void m1383f() {
        this.f586b.m1357d(this.f585a);
    }
}
