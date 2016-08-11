package android.support.v7.p012a;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.app.C0066l;
import android.support.v4.app.C0075i;
import android.support.v7.p014b.C0364a.C0363j;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;

/* renamed from: android.support.v7.a.a */
public abstract class C0328a {

    /* renamed from: android.support.v7.a.a.a */
    interface C0322a {
        C0075i m1434g();
    }

    /* renamed from: android.support.v7.a.a.b */
    public static class C0323b extends MarginLayoutParams {
        public int f611a;

        public C0323b(Context c, AttributeSet attrs) {
            super(c, attrs);
            this.f611a = -1;
            TypedArray a = c.obtainStyledAttributes(attrs, C0363j.ActionBarLayout);
            this.f611a = a.getInt(0, -1);
            a.recycle();
        }

        public C0323b(int width, int height, int gravity) {
            super(width, height);
            this.f611a = -1;
            this.f611a = gravity;
        }

        public C0323b(int gravity) {
            this(-2, -1, gravity);
        }
    }

    /* renamed from: android.support.v7.a.a.c */
    public interface C0324c {
        void m1435a(boolean z);
    }

    /* renamed from: android.support.v7.a.a.d */
    public interface C0325d {
        boolean m1436a(int i, long j);
    }

    /* renamed from: android.support.v7.a.a.e */
    public static abstract class C0326e {
        public abstract int m1437a();

        public abstract C0326e m1438a(int i);

        public abstract C0326e m1439a(Object obj);

        public abstract Drawable m1440b();

        public abstract CharSequence m1441c();

        public abstract View m1442d();

        public abstract Object m1443e();

        public abstract void m1444f();

        public abstract CharSequence m1445g();
    }

    /* renamed from: android.support.v7.a.a.f */
    public interface C0327f {
        void m1446a(C0326e c0326e, C0066l c0066l);

        void m1447b(C0326e c0326e, C0066l c0066l);

        void m1448c(C0326e c0326e, C0066l c0066l);
    }

    public abstract View m1449a();

    public abstract void m1450a(int i);

    public abstract void m1451a(C0324c c0324c);

    public abstract void m1452a(CharSequence charSequence);

    public abstract void m1453a(boolean z);

    public abstract int m1454b();

    public abstract void m1455b(int i);

    public abstract void m1456b(C0324c c0324c);

    public abstract void m1457b(CharSequence charSequence);

    public abstract void m1458b(boolean z);

    public abstract C0326e m1459c();

    public abstract void m1460c(int i);

    public abstract void m1461c(boolean z);

    public abstract void m1462d();

    public abstract void m1463d(boolean z);

    public abstract void m1464e();

    public abstract void m1465e(boolean z);

    public void m1467f(boolean enabled) {
    }

    public Context m1466f() {
        return null;
    }
}
