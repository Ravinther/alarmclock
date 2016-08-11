package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;

/* renamed from: android.support.v4.widget.e */
public class C0310e {
    private static final C0307c f580b;
    private Object f581a;

    /* renamed from: android.support.v4.widget.e.c */
    interface C0307c {
        Object m1316a(Context context);

        void m1317a(Object obj, int i, int i2);

        boolean m1318a(Object obj);

        boolean m1319a(Object obj, float f);

        boolean m1320a(Object obj, Canvas canvas);

        void m1321b(Object obj);

        boolean m1322c(Object obj);
    }

    /* renamed from: android.support.v4.widget.e.a */
    static class C0308a implements C0307c {
        C0308a() {
        }

        public Object m1323a(Context context) {
            return null;
        }

        public void m1324a(Object edgeEffect, int width, int height) {
        }

        public boolean m1325a(Object edgeEffect) {
            return true;
        }

        public void m1328b(Object edgeEffect) {
        }

        public boolean m1326a(Object edgeEffect, float deltaDistance) {
            return false;
        }

        public boolean m1329c(Object edgeEffect) {
            return false;
        }

        public boolean m1327a(Object edgeEffect, Canvas canvas) {
            return false;
        }
    }

    /* renamed from: android.support.v4.widget.e.b */
    static class C0309b implements C0307c {
        C0309b() {
        }

        public Object m1330a(Context context) {
            return C0311f.m1343a(context);
        }

        public void m1331a(Object edgeEffect, int width, int height) {
            C0311f.m1344a(edgeEffect, width, height);
        }

        public boolean m1332a(Object edgeEffect) {
            return C0311f.m1345a(edgeEffect);
        }

        public void m1335b(Object edgeEffect) {
            C0311f.m1348b(edgeEffect);
        }

        public boolean m1333a(Object edgeEffect, float deltaDistance) {
            return C0311f.m1346a(edgeEffect, deltaDistance);
        }

        public boolean m1336c(Object edgeEffect) {
            return C0311f.m1349c(edgeEffect);
        }

        public boolean m1334a(Object edgeEffect, Canvas canvas) {
            return C0311f.m1347a(edgeEffect, canvas);
        }
    }

    static {
        if (VERSION.SDK_INT >= 14) {
            f580b = new C0309b();
        } else {
            f580b = new C0308a();
        }
    }

    public C0310e(Context context) {
        this.f581a = f580b.m1316a(context);
    }

    public void m1337a(int width, int height) {
        f580b.m1317a(this.f581a, width, height);
    }

    public boolean m1338a() {
        return f580b.m1318a(this.f581a);
    }

    public void m1341b() {
        f580b.m1321b(this.f581a);
    }

    public boolean m1339a(float deltaDistance) {
        return f580b.m1319a(this.f581a, deltaDistance);
    }

    public boolean m1342c() {
        return f580b.m1322c(this.f581a);
    }

    public boolean m1340a(Canvas canvas) {
        return f580b.m1320a(this.f581a, canvas);
    }
}
