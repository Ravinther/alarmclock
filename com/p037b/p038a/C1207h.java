package com.p037b.p038a;

import android.view.animation.Interpolator;

/* renamed from: com.b.a.h */
public abstract class C1207h implements Cloneable {
    float f3660a;
    Class f3661b;
    boolean f3662c;
    private Interpolator f3663d;

    /* renamed from: com.b.a.h.a */
    static class C1208a extends C1207h {
        float f3664d;

        public /* synthetic */ Object clone() {
            return m5075g();
        }

        public /* synthetic */ C1207h m5073e() {
            return m5075g();
        }

        C1208a(float fraction, float value) {
            this.a = fraction;
            this.f3664d = value;
            this.b = Float.TYPE;
            this.c = true;
        }

        C1208a(float fraction) {
            this.a = fraction;
            this.b = Float.TYPE;
        }

        public float m5074f() {
            return this.f3664d;
        }

        public Object m5072b() {
            return Float.valueOf(this.f3664d);
        }

        public void m5071a(Object value) {
            if (value != null && value.getClass() == Float.class) {
                this.f3664d = ((Float) value).floatValue();
                this.c = true;
            }
        }

        public C1208a m5075g() {
            C1208a kfClone = new C1208a(m5068c(), this.f3664d);
            kfClone.m5064a(m5069d());
            return kfClone;
        }
    }

    /* renamed from: com.b.a.h.b */
    static class C1209b extends C1207h {
        int f3665d;

        public /* synthetic */ Object clone() {
            return m5080g();
        }

        public /* synthetic */ C1207h m5078e() {
            return m5080g();
        }

        C1209b(float fraction, int value) {
            this.a = fraction;
            this.f3665d = value;
            this.b = Integer.TYPE;
            this.c = true;
        }

        C1209b(float fraction) {
            this.a = fraction;
            this.b = Integer.TYPE;
        }

        public int m5079f() {
            return this.f3665d;
        }

        public Object m5077b() {
            return Integer.valueOf(this.f3665d);
        }

        public void m5076a(Object value) {
            if (value != null && value.getClass() == Integer.class) {
                this.f3665d = ((Integer) value).intValue();
                this.c = true;
            }
        }

        public C1209b m5080g() {
            C1209b kfClone = new C1209b(m5068c(), this.f3665d);
            kfClone.m5064a(m5069d());
            return kfClone;
        }
    }

    public abstract void m5065a(Object obj);

    public abstract Object m5067b();

    public abstract C1207h m5070e();

    public C1207h() {
        this.f3663d = null;
        this.f3662c = false;
    }

    public /* synthetic */ Object clone() {
        return m5070e();
    }

    public static C1207h m5062a(float fraction, int value) {
        return new C1209b(fraction, value);
    }

    public static C1207h m5060a(float fraction) {
        return new C1209b(fraction);
    }

    public static C1207h m5061a(float fraction, float value) {
        return new C1208a(fraction, value);
    }

    public static C1207h m5063b(float fraction) {
        return new C1208a(fraction);
    }

    public boolean m5066a() {
        return this.f3662c;
    }

    public float m5068c() {
        return this.f3660a;
    }

    public Interpolator m5069d() {
        return this.f3663d;
    }

    public void m5064a(Interpolator interpolator) {
        this.f3663d = interpolator;
    }
}
