package com.p037b.p063c.p064a;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* renamed from: com.b.c.a.a */
public final class C1236a extends Animation {
    public static final boolean f3738a;
    private static final WeakHashMap f3739b;
    private final WeakReference f3740c;
    private final Camera f3741d;
    private boolean f3742e;
    private float f3743f;
    private float f3744g;
    private float f3745h;
    private float f3746i;
    private float f3747j;
    private float f3748k;
    private float f3749l;
    private float f3750m;
    private float f3751n;
    private float f3752o;
    private final RectF f3753p;
    private final RectF f3754q;
    private final Matrix f3755r;

    static {
        f3738a = Integer.valueOf(VERSION.SDK).intValue() < 11;
        f3739b = new WeakHashMap();
    }

    public static C1236a m5245a(View view) {
        Animation proxy = (C1236a) f3739b.get(view);
        if (proxy != null && proxy == view.getAnimation()) {
            return proxy;
        }
        C1236a proxy2 = new C1236a(view);
        f3739b.put(view, proxy2);
        return proxy2;
    }

    private C1236a(View view) {
        this.f3741d = new Camera();
        this.f3743f = 1.0f;
        this.f3749l = 1.0f;
        this.f3750m = 1.0f;
        this.f3753p = new RectF();
        this.f3754q = new RectF();
        this.f3755r = new Matrix();
        setDuration(0);
        setFillAfter(true);
        view.setAnimation(this);
        this.f3740c = new WeakReference(view);
    }

    public float m5250a() {
        return this.f3743f;
    }

    public void m5251a(float alpha) {
        if (this.f3743f != alpha) {
            this.f3743f = alpha;
            View view = (View) this.f3740c.get();
            if (view != null) {
                view.invalidate();
            }
        }
    }

    public float m5253b() {
        return this.f3744g;
    }

    public void m5254b(float pivotX) {
        if (!this.f3742e || this.f3744g != pivotX) {
            m5248o();
            this.f3742e = true;
            this.f3744g = pivotX;
            m5249p();
        }
    }

    public float m5256c() {
        return this.f3745h;
    }

    public void m5257c(float pivotY) {
        if (!this.f3742e || this.f3745h != pivotY) {
            m5248o();
            this.f3742e = true;
            this.f3745h = pivotY;
            m5249p();
        }
    }

    public float m5258d() {
        return this.f3748k;
    }

    public void m5259d(float rotation) {
        if (this.f3748k != rotation) {
            m5248o();
            this.f3748k = rotation;
            m5249p();
        }
    }

    public float m5260e() {
        return this.f3746i;
    }

    public void m5261e(float rotationX) {
        if (this.f3746i != rotationX) {
            m5248o();
            this.f3746i = rotationX;
            m5249p();
        }
    }

    public float m5262f() {
        return this.f3747j;
    }

    public void m5263f(float rotationY) {
        if (this.f3747j != rotationY) {
            m5248o();
            this.f3747j = rotationY;
            m5249p();
        }
    }

    public float m5264g() {
        return this.f3749l;
    }

    public void m5265g(float scaleX) {
        if (this.f3749l != scaleX) {
            m5248o();
            this.f3749l = scaleX;
            m5249p();
        }
    }

    public float m5266h() {
        return this.f3750m;
    }

    public void m5267h(float scaleY) {
        if (this.f3750m != scaleY) {
            m5248o();
            this.f3750m = scaleY;
            m5249p();
        }
    }

    public int m5268i() {
        View view = (View) this.f3740c.get();
        if (view == null) {
            return 0;
        }
        return view.getScrollX();
    }

    public void m5252a(int value) {
        View view = (View) this.f3740c.get();
        if (view != null) {
            view.scrollTo(value, view.getScrollY());
        }
    }

    public int m5270j() {
        View view = (View) this.f3740c.get();
        if (view == null) {
            return 0;
        }
        return view.getScrollY();
    }

    public void m5255b(int value) {
        View view = (View) this.f3740c.get();
        if (view != null) {
            view.scrollTo(view.getScrollX(), value);
        }
    }

    public float m5272k() {
        return this.f3751n;
    }

    public void m5269i(float translationX) {
        if (this.f3751n != translationX) {
            m5248o();
            this.f3751n = translationX;
            m5249p();
        }
    }

    public float m5274l() {
        return this.f3752o;
    }

    public void m5271j(float translationY) {
        if (this.f3752o != translationY) {
            m5248o();
            this.f3752o = translationY;
            m5249p();
        }
    }

    public float m5276m() {
        View view = (View) this.f3740c.get();
        if (view == null) {
            return 0.0f;
        }
        return ((float) view.getLeft()) + this.f3751n;
    }

    public void m5273k(float x) {
        View view = (View) this.f3740c.get();
        if (view != null) {
            m5269i(x - ((float) view.getLeft()));
        }
    }

    public float m5277n() {
        View view = (View) this.f3740c.get();
        if (view == null) {
            return 0.0f;
        }
        return ((float) view.getTop()) + this.f3752o;
    }

    public void m5275l(float y) {
        View view = (View) this.f3740c.get();
        if (view != null) {
            m5271j(y - ((float) view.getTop()));
        }
    }

    private void m5248o() {
        View view = (View) this.f3740c.get();
        if (view != null) {
            m5247a(this.f3753p, view);
        }
    }

    private void m5249p() {
        View view = (View) this.f3740c.get();
        if (view != null && view.getParent() != null) {
            RectF after = this.f3754q;
            m5247a(after, view);
            after.union(this.f3753p);
            ((View) view.getParent()).invalidate((int) Math.floor((double) after.left), (int) Math.floor((double) after.top), (int) Math.ceil((double) after.right), (int) Math.ceil((double) after.bottom));
        }
    }

    private void m5247a(RectF r, View view) {
        r.set(0.0f, 0.0f, (float) view.getWidth(), (float) view.getHeight());
        Matrix m = this.f3755r;
        m.reset();
        m5246a(m, view);
        this.f3755r.mapRect(r);
        r.offset((float) view.getLeft(), (float) view.getTop());
        if (r.right < r.left) {
            float f = r.right;
            r.right = r.left;
            r.left = f;
        }
        if (r.bottom < r.top) {
            f = r.top;
            r.top = r.bottom;
            r.bottom = f;
        }
    }

    private void m5246a(Matrix m, View view) {
        float w = (float) view.getWidth();
        float h = (float) view.getHeight();
        boolean hasPivot = this.f3742e;
        float pX = hasPivot ? this.f3744g : w / 2.0f;
        float pY = hasPivot ? this.f3745h : h / 2.0f;
        float rX = this.f3746i;
        float rY = this.f3747j;
        float rZ = this.f3748k;
        if (!(rX == 0.0f && rY == 0.0f && rZ == 0.0f)) {
            Camera camera = this.f3741d;
            camera.save();
            camera.rotateX(rX);
            camera.rotateY(rY);
            camera.rotateZ(-rZ);
            camera.getMatrix(m);
            camera.restore();
            m.preTranslate(-pX, -pY);
            m.postTranslate(pX, pY);
        }
        float sX = this.f3749l;
        float sY = this.f3750m;
        if (!(sX == 1.0f && sY == 1.0f)) {
            m.postScale(sX, sY);
            m.postTranslate((-(pX / w)) * ((sX * w) - w), (-(pY / h)) * ((sY * h) - h));
        }
        m.postTranslate(this.f3751n, this.f3752o);
    }

    protected void applyTransformation(float interpolatedTime, Transformation t) {
        View view = (View) this.f3740c.get();
        if (view != null) {
            t.setAlpha(this.f3743f);
            m5246a(t.getMatrix(), view);
        }
    }
}
