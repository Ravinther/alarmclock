package com.p037b.p063c;

import android.view.View;
import android.view.animation.Interpolator;
import com.google.ads.AdSize;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.cast.Cast;
import com.mopub.mobileads.util.Base64;
import com.p037b.p038a.C1193a;
import com.p037b.p038a.C1193a.C0672a;
import com.p037b.p038a.C1210n;
import com.p037b.p038a.C1210n.C0803b;
import com.p037b.p063c.p064a.C1236a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: com.b.c.e */
class C1250e extends C1238b {
    ArrayList f3786a;
    private final C1236a f3787b;
    private final WeakReference f3788c;
    private long f3789d;
    private boolean f3790e;
    private long f3791f;
    private boolean f3792g;
    private Interpolator f3793h;
    private boolean f3794i;
    private C0672a f3795j;
    private C1247a f3796k;
    private Runnable f3797l;
    private HashMap f3798m;

    /* renamed from: com.b.c.e.1 */
    class C12461 implements Runnable {
        final /* synthetic */ C1250e f3779a;

        C12461(C1250e c1250e) {
            this.f3779a = c1250e;
        }

        public void run() {
            this.f3779a.m5345b();
        }
    }

    /* renamed from: com.b.c.e.a */
    private class C1247a implements C0672a, C0803b {
        final /* synthetic */ C1250e f3780a;

        private C1247a(C1250e c1250e) {
            this.f3780a = c1250e;
        }

        public void m5334b(C1193a animation) {
            if (this.f3780a.f3795j != null) {
                this.f3780a.f3795j.m3044b(animation);
            }
        }

        public void m5335c(C1193a animation) {
            if (this.f3780a.f3795j != null) {
                this.f3780a.f3795j.m3045c(animation);
            }
        }

        public void m5336d(C1193a animation) {
            if (this.f3780a.f3795j != null) {
                this.f3780a.f3795j.m3046d(animation);
            }
        }

        public void m5332a(C1193a animation) {
            if (this.f3780a.f3795j != null) {
                this.f3780a.f3795j.m3043a(animation);
            }
            this.f3780a.f3798m.remove(animation);
            if (this.f3780a.f3798m.isEmpty()) {
                this.f3780a.f3795j = null;
            }
        }

        public void m5333a(C1210n animation) {
            View v;
            float fraction = animation.m5118l();
            C1249c propertyBundle = (C1249c) this.f3780a.f3798m.get(animation);
            if ((propertyBundle.f3784a & 511) != 0) {
                v = (View) this.f3780a.f3788c.get();
                if (v != null) {
                    v.invalidate();
                }
            }
            ArrayList valueList = propertyBundle.f3785b;
            if (valueList != null) {
                int count = valueList.size();
                for (int i = 0; i < count; i++) {
                    C1248b values = (C1248b) valueList.get(i);
                    this.f3780a.m5346b(values.f3781a, values.f3782b + (values.f3783c * fraction));
                }
            }
            v = (View) this.f3780a.f3788c.get();
            if (v != null) {
                v.invalidate();
            }
        }
    }

    /* renamed from: com.b.c.e.b */
    private static class C1248b {
        int f3781a;
        float f3782b;
        float f3783c;

        C1248b(int nameConstant, float fromValue, float deltaValue) {
            this.f3781a = nameConstant;
            this.f3782b = fromValue;
            this.f3783c = deltaValue;
        }
    }

    /* renamed from: com.b.c.e.c */
    private static class C1249c {
        int f3784a;
        ArrayList f3785b;

        C1249c(int propertyMask, ArrayList nameValuesHolder) {
            this.f3784a = propertyMask;
            this.f3785b = nameValuesHolder;
        }

        boolean m5337a(int propertyConstant) {
            if (!((this.f3784a & propertyConstant) == 0 || this.f3785b == null)) {
                int count = this.f3785b.size();
                for (int i = 0; i < count; i++) {
                    if (((C1248b) this.f3785b.get(i)).f3781a == propertyConstant) {
                        this.f3785b.remove(i);
                        this.f3784a &= propertyConstant ^ -1;
                        return true;
                    }
                }
            }
            return false;
        }
    }

    C1250e(View view) {
        this.f3790e = false;
        this.f3791f = 0;
        this.f3792g = false;
        this.f3794i = false;
        this.f3795j = null;
        this.f3796k = new C1247a();
        this.f3786a = new ArrayList();
        this.f3797l = new C12461(this);
        this.f3798m = new HashMap();
        this.f3788c = new WeakReference(view);
        this.f3787b = C1236a.m5245a(view);
    }

    public C1238b m5350a(long duration) {
        if (duration < 0) {
            throw new IllegalArgumentException("Animators cannot have negative duration: " + duration);
        }
        this.f3790e = true;
        this.f3789d = duration;
        return this;
    }

    public C1238b m5351a(Interpolator interpolator) {
        this.f3794i = true;
        this.f3793h = interpolator;
        return this;
    }

    public C1238b m5352a(C0672a listener) {
        this.f3795j = listener;
        return this;
    }

    public void m5353a() {
        m5345b();
    }

    public C1238b m5349a(float value) {
        m5340a(16, value);
        return this;
    }

    public C1238b m5354b(float value) {
        m5340a(1, value);
        return this;
    }

    public C1238b m5355c(float value) {
        m5340a(2, value);
        return this;
    }

    public C1238b m5356d(float value) {
        m5340a(4, value);
        return this;
    }

    public C1238b m5357e(float value) {
        m5340a(8, value);
        return this;
    }

    public C1238b m5358f(float value) {
        m5340a((int) AdRequest.MAX_CONTENT_URL_LENGTH, value);
        return this;
    }

    private void m5345b() {
        C1210n animator = C1210n.m5085b(1.0f);
        ArrayList nameValueList = (ArrayList) this.f3786a.clone();
        this.f3786a.clear();
        int propertyMask = 0;
        for (int i = 0; i < nameValueList.size(); i++) {
            propertyMask |= ((C1248b) nameValueList.get(i)).f3781a;
        }
        this.f3798m.put(animator, new C1249c(propertyMask, nameValueList));
        animator.m5102a(this.f3796k);
        animator.m5001a(this.f3796k);
        if (this.f3792g) {
            animator.m5111e(this.f3791f);
        }
        if (this.f3790e) {
            animator.m5107c(this.f3789d);
        }
        if (this.f3794i) {
            animator.m5101a(this.f3793h);
        }
        animator.m5099a();
    }

    private void m5340a(int constantName, float toValue) {
        float fromValue = m5338a(constantName);
        m5341a(constantName, fromValue, toValue - fromValue);
    }

    private void m5341a(int constantName, float startValue, float byValue) {
        if (this.f3798m.size() > 0) {
            C1193a animatorToCancel = null;
            for (C1193a runningAnim : this.f3798m.keySet()) {
                C1249c bundle = (C1249c) this.f3798m.get(runningAnim);
                if (bundle.m5337a(constantName) && bundle.f3784a == 0) {
                    animatorToCancel = runningAnim;
                    break;
                }
            }
            if (animatorToCancel != null) {
                animatorToCancel.m5002b();
            }
        }
        this.f3786a.add(new C1248b(constantName, startValue, byValue));
        View v = (View) this.f3788c.get();
        if (v != null) {
            v.removeCallbacks(this.f3797l);
            v.post(this.f3797l);
        }
    }

    private void m5346b(int propertyConstant, float value) {
        switch (propertyConstant) {
            case Base64.NO_PADDING /*1*/:
                this.f3787b.m5269i(value);
            case Base64.NO_WRAP /*2*/:
                this.f3787b.m5271j(value);
            case Base64.CRLF /*4*/:
                this.f3787b.m5265g(value);
            case Base64.URL_SAFE /*8*/:
                this.f3787b.m5267h(value);
            case Base64.NO_CLOSE /*16*/:
                this.f3787b.m5259d(value);
            case AdSize.LANDSCAPE_AD_HEIGHT /*32*/:
                this.f3787b.m5261e(value);
            case 64:
                this.f3787b.m5263f(value);
            case Cast.MAX_NAMESPACE_LENGTH /*128*/:
                this.f3787b.m5273k(value);
            case 256:
                this.f3787b.m5275l(value);
            case AdRequest.MAX_CONTENT_URL_LENGTH /*512*/:
                this.f3787b.m5251a(value);
            default:
        }
    }

    private float m5338a(int propertyConstant) {
        switch (propertyConstant) {
            case Base64.NO_PADDING /*1*/:
                return this.f3787b.m5272k();
            case Base64.NO_WRAP /*2*/:
                return this.f3787b.m5274l();
            case Base64.CRLF /*4*/:
                return this.f3787b.m5264g();
            case Base64.URL_SAFE /*8*/:
                return this.f3787b.m5266h();
            case Base64.NO_CLOSE /*16*/:
                return this.f3787b.m5258d();
            case AdSize.LANDSCAPE_AD_HEIGHT /*32*/:
                return this.f3787b.m5260e();
            case 64:
                return this.f3787b.m5262f();
            case Cast.MAX_NAMESPACE_LENGTH /*128*/:
                return this.f3787b.m5276m();
            case 256:
                return this.f3787b.m5277n();
            case AdRequest.MAX_CONTENT_URL_LENGTH /*512*/:
                return this.f3787b.m5250a();
            default:
                return 0.0f;
        }
    }
}
