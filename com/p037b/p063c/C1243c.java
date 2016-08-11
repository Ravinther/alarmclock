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
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: com.b.c.c */
class C1243c extends C1238b {
    ArrayList f3764a;
    private final WeakReference f3765b;
    private long f3766c;
    private boolean f3767d;
    private long f3768e;
    private boolean f3769f;
    private Interpolator f3770g;
    private boolean f3771h;
    private C0672a f3772i;
    private C1240a f3773j;
    private Runnable f3774k;
    private HashMap f3775l;

    /* renamed from: com.b.c.c.1 */
    class C12391 implements Runnable {
        final /* synthetic */ C1243c f3757a;

        C12391(C1243c c1243c) {
            this.f3757a = c1243c;
        }

        public void run() {
            this.f3757a.m5308b();
        }
    }

    /* renamed from: com.b.c.c.a */
    private class C1240a implements C0672a, C0803b {
        final /* synthetic */ C1243c f3758a;

        private C1240a(C1243c c1243c) {
            this.f3758a = c1243c;
        }

        public void m5297b(C1193a animation) {
            if (this.f3758a.f3772i != null) {
                this.f3758a.f3772i.m3044b(animation);
            }
        }

        public void m5298c(C1193a animation) {
            if (this.f3758a.f3772i != null) {
                this.f3758a.f3772i.m3045c(animation);
            }
        }

        public void m5299d(C1193a animation) {
            if (this.f3758a.f3772i != null) {
                this.f3758a.f3772i.m3046d(animation);
            }
        }

        public void m5295a(C1193a animation) {
            if (this.f3758a.f3772i != null) {
                this.f3758a.f3772i.m3043a(animation);
            }
            this.f3758a.f3775l.remove(animation);
            if (this.f3758a.f3775l.isEmpty()) {
                this.f3758a.f3772i = null;
            }
        }

        public void m5296a(C1210n animation) {
            View v;
            float fraction = animation.m5118l();
            C1242c propertyBundle = (C1242c) this.f3758a.f3775l.get(animation);
            if ((propertyBundle.f3762a & 511) != 0) {
                v = (View) this.f3758a.f3765b.get();
                if (v != null) {
                    v.invalidate();
                }
            }
            ArrayList valueList = propertyBundle.f3763b;
            if (valueList != null) {
                int count = valueList.size();
                for (int i = 0; i < count; i++) {
                    C1241b values = (C1241b) valueList.get(i);
                    this.f3758a.m5309b(values.f3759a, values.f3760b + (values.f3761c * fraction));
                }
            }
            v = (View) this.f3758a.f3765b.get();
            if (v != null) {
                v.invalidate();
            }
        }
    }

    /* renamed from: com.b.c.c.b */
    private static class C1241b {
        int f3759a;
        float f3760b;
        float f3761c;

        C1241b(int nameConstant, float fromValue, float deltaValue) {
            this.f3759a = nameConstant;
            this.f3760b = fromValue;
            this.f3761c = deltaValue;
        }
    }

    /* renamed from: com.b.c.c.c */
    private static class C1242c {
        int f3762a;
        ArrayList f3763b;

        C1242c(int propertyMask, ArrayList nameValuesHolder) {
            this.f3762a = propertyMask;
            this.f3763b = nameValuesHolder;
        }

        boolean m5300a(int propertyConstant) {
            if (!((this.f3762a & propertyConstant) == 0 || this.f3763b == null)) {
                int count = this.f3763b.size();
                for (int i = 0; i < count; i++) {
                    if (((C1241b) this.f3763b.get(i)).f3759a == propertyConstant) {
                        this.f3763b.remove(i);
                        this.f3762a &= propertyConstant ^ -1;
                        return true;
                    }
                }
            }
            return false;
        }
    }

    C1243c(View view) {
        this.f3767d = false;
        this.f3768e = 0;
        this.f3769f = false;
        this.f3771h = false;
        this.f3772i = null;
        this.f3773j = new C1240a();
        this.f3764a = new ArrayList();
        this.f3774k = new C12391(this);
        this.f3775l = new HashMap();
        this.f3765b = new WeakReference(view);
    }

    public C1238b m5313a(long duration) {
        if (duration < 0) {
            throw new IllegalArgumentException("Animators cannot have negative duration: " + duration);
        }
        this.f3767d = true;
        this.f3766c = duration;
        return this;
    }

    public C1238b m5314a(Interpolator interpolator) {
        this.f3771h = true;
        this.f3770g = interpolator;
        return this;
    }

    public C1238b m5315a(C0672a listener) {
        this.f3772i = listener;
        return this;
    }

    public void m5316a() {
        m5308b();
    }

    public C1238b m5312a(float value) {
        m5303a(16, value);
        return this;
    }

    public C1238b m5317b(float value) {
        m5303a(1, value);
        return this;
    }

    public C1238b m5318c(float value) {
        m5303a(2, value);
        return this;
    }

    public C1238b m5319d(float value) {
        m5303a(4, value);
        return this;
    }

    public C1238b m5320e(float value) {
        m5303a(8, value);
        return this;
    }

    public C1238b m5321f(float value) {
        m5303a((int) AdRequest.MAX_CONTENT_URL_LENGTH, value);
        return this;
    }

    private void m5308b() {
        C1210n animator = C1210n.m5085b(1.0f);
        ArrayList nameValueList = (ArrayList) this.f3764a.clone();
        this.f3764a.clear();
        int propertyMask = 0;
        for (int i = 0; i < nameValueList.size(); i++) {
            propertyMask |= ((C1241b) nameValueList.get(i)).f3759a;
        }
        this.f3775l.put(animator, new C1242c(propertyMask, nameValueList));
        animator.m5102a(this.f3773j);
        animator.m5001a(this.f3773j);
        if (this.f3769f) {
            animator.m5111e(this.f3768e);
        }
        if (this.f3767d) {
            animator.m5107c(this.f3766c);
        }
        if (this.f3771h) {
            animator.m5101a(this.f3770g);
        }
        animator.m5099a();
    }

    private void m5303a(int constantName, float toValue) {
        float fromValue = m5301a(constantName);
        m5304a(constantName, fromValue, toValue - fromValue);
    }

    private void m5304a(int constantName, float startValue, float byValue) {
        if (this.f3775l.size() > 0) {
            C1193a animatorToCancel = null;
            for (C1193a runningAnim : this.f3775l.keySet()) {
                C1242c bundle = (C1242c) this.f3775l.get(runningAnim);
                if (bundle.m5300a(constantName) && bundle.f3762a == 0) {
                    animatorToCancel = runningAnim;
                    break;
                }
            }
            if (animatorToCancel != null) {
                animatorToCancel.m5002b();
            }
        }
        this.f3764a.add(new C1241b(constantName, startValue, byValue));
        View v = (View) this.f3765b.get();
        if (v != null) {
            v.removeCallbacks(this.f3774k);
            v.post(this.f3774k);
        }
    }

    private void m5309b(int propertyConstant, float value) {
        View v = (View) this.f3765b.get();
        if (v != null) {
            switch (propertyConstant) {
                case Base64.NO_PADDING /*1*/:
                    v.setTranslationX(value);
                case Base64.NO_WRAP /*2*/:
                    v.setTranslationY(value);
                case Base64.CRLF /*4*/:
                    v.setScaleX(value);
                case Base64.URL_SAFE /*8*/:
                    v.setScaleY(value);
                case Base64.NO_CLOSE /*16*/:
                    v.setRotation(value);
                case AdSize.LANDSCAPE_AD_HEIGHT /*32*/:
                    v.setRotationX(value);
                case 64:
                    v.setRotationY(value);
                case Cast.MAX_NAMESPACE_LENGTH /*128*/:
                    v.setX(value);
                case 256:
                    v.setY(value);
                case AdRequest.MAX_CONTENT_URL_LENGTH /*512*/:
                    v.setAlpha(value);
                default:
            }
        }
    }

    private float m5301a(int propertyConstant) {
        View v = (View) this.f3765b.get();
        if (v != null) {
            switch (propertyConstant) {
                case Base64.NO_PADDING /*1*/:
                    return v.getTranslationX();
                case Base64.NO_WRAP /*2*/:
                    return v.getTranslationY();
                case Base64.CRLF /*4*/:
                    return v.getScaleX();
                case Base64.URL_SAFE /*8*/:
                    return v.getScaleY();
                case Base64.NO_CLOSE /*16*/:
                    return v.getRotation();
                case AdSize.LANDSCAPE_AD_HEIGHT /*32*/:
                    return v.getRotationX();
                case 64:
                    return v.getRotationY();
                case Cast.MAX_NAMESPACE_LENGTH /*128*/:
                    return v.getX();
                case 256:
                    return v.getY();
                case AdRequest.MAX_CONTENT_URL_LENGTH /*512*/:
                    return v.getAlpha();
            }
        }
        return 0.0f;
    }
}
