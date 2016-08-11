package com.p037b.p038a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AndroidRuntimeException;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.mopub.mobileads.util.Base64;
import com.p037b.p038a.C1193a.C0672a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* renamed from: com.b.a.n */
public class C1210n extends C1193a {
    private static ThreadLocal f3666h;
    private static final ThreadLocal f3667i;
    private static final ThreadLocal f3668j;
    private static final ThreadLocal f3669k;
    private static final ThreadLocal f3670l;
    private static final ThreadLocal f3671m;
    private static final Interpolator f3672n;
    private static final C1201m f3673o;
    private static final C1201m f3674p;
    private static long f3675z;
    private int f3676A;
    private int f3677B;
    private Interpolator f3678C;
    private ArrayList f3679D;
    long f3680b;
    long f3681c;
    int f3682d;
    boolean f3683e;
    C1226l[] f3684f;
    HashMap f3685g;
    private boolean f3686q;
    private int f3687r;
    private float f3688s;
    private boolean f3689t;
    private long f3690u;
    private boolean f3691v;
    private boolean f3692w;
    private long f3693x;
    private long f3694y;

    /* renamed from: com.b.a.n.b */
    public interface C0803b {
        void m3798a(C1210n c1210n);
    }

    /* renamed from: com.b.a.n.1 */
    static class C12291 extends ThreadLocal {
        C12291() {
        }

        protected /* synthetic */ Object initialValue() {
            return m5234a();
        }

        protected ArrayList m5234a() {
            return new ArrayList();
        }
    }

    /* renamed from: com.b.a.n.2 */
    static class C12302 extends ThreadLocal {
        C12302() {
        }

        protected /* synthetic */ Object initialValue() {
            return m5235a();
        }

        protected ArrayList m5235a() {
            return new ArrayList();
        }
    }

    /* renamed from: com.b.a.n.3 */
    static class C12313 extends ThreadLocal {
        C12313() {
        }

        protected /* synthetic */ Object initialValue() {
            return m5236a();
        }

        protected ArrayList m5236a() {
            return new ArrayList();
        }
    }

    /* renamed from: com.b.a.n.4 */
    static class C12324 extends ThreadLocal {
        C12324() {
        }

        protected /* synthetic */ Object initialValue() {
            return m5237a();
        }

        protected ArrayList m5237a() {
            return new ArrayList();
        }
    }

    /* renamed from: com.b.a.n.5 */
    static class C12335 extends ThreadLocal {
        C12335() {
        }

        protected /* synthetic */ Object initialValue() {
            return m5238a();
        }

        protected ArrayList m5238a() {
            return new ArrayList();
        }
    }

    /* renamed from: com.b.a.n.a */
    private static class C1234a extends Handler {
        private C1234a() {
        }

        public void handleMessage(Message msg) {
            int i;
            C1210n anim;
            boolean callAgain = true;
            ArrayList animations = (ArrayList) C1210n.f3667i.get();
            ArrayList delayedAnims = (ArrayList) C1210n.f3669k.get();
            switch (msg.what) {
                case Base64.DEFAULT /*0*/:
                    ArrayList pendingAnimations = (ArrayList) C1210n.f3668j.get();
                    if (animations.size() > 0 || delayedAnims.size() > 0) {
                        callAgain = false;
                    }
                    while (pendingAnimations.size() > 0) {
                        ArrayList pendingCopy = (ArrayList) pendingAnimations.clone();
                        pendingAnimations.clear();
                        int count = pendingCopy.size();
                        for (i = 0; i < count; i++) {
                            anim = (C1210n) pendingCopy.get(i);
                            if (anim.f3694y == 0) {
                                anim.m5097s();
                            } else {
                                delayedAnims.add(anim);
                            }
                        }
                    }
                    break;
                case Base64.NO_PADDING /*1*/:
                    break;
                default:
                    return;
            }
            long currentTime = AnimationUtils.currentAnimationTimeMillis();
            ArrayList readyAnims = (ArrayList) C1210n.f3671m.get();
            ArrayList endingAnims = (ArrayList) C1210n.f3670l.get();
            int numDelayedAnims = delayedAnims.size();
            for (i = 0; i < numDelayedAnims; i++) {
                anim = (C1210n) delayedAnims.get(i);
                if (anim.m5088b(currentTime)) {
                    readyAnims.add(anim);
                }
            }
            int numReadyAnims = readyAnims.size();
            if (numReadyAnims > 0) {
                for (i = 0; i < numReadyAnims; i++) {
                    anim = (C1210n) readyAnims.get(i);
                    anim.m5097s();
                    anim.f3691v = true;
                    delayedAnims.remove(anim);
                }
                readyAnims.clear();
            }
            int numAnims = animations.size();
            i = 0;
            while (i < numAnims) {
                anim = (C1210n) animations.get(i);
                if (anim.m5113f(currentTime)) {
                    endingAnims.add(anim);
                }
                if (animations.size() == numAnims) {
                    i++;
                } else {
                    numAnims--;
                    endingAnims.remove(anim);
                }
            }
            if (endingAnims.size() > 0) {
                for (i = 0; i < endingAnims.size(); i++) {
                    ((C1210n) endingAnims.get(i)).m5090h();
                }
                endingAnims.clear();
            }
            if (!callAgain) {
                return;
            }
            if (!animations.isEmpty() || !delayedAnims.isEmpty()) {
                sendEmptyMessageDelayed(1, Math.max(0, C1210n.f3675z - (AnimationUtils.currentAnimationTimeMillis() - currentTime)));
            }
        }
    }

    public /* synthetic */ C1193a m5098a(long x0) {
        return m5107c(x0);
    }

    public /* synthetic */ Object clone() {
        return m5115i();
    }

    public /* synthetic */ C1193a m5112f() {
        return m5115i();
    }

    static {
        f3666h = new ThreadLocal();
        f3667i = new C12291();
        f3668j = new C12302();
        f3669k = new C12313();
        f3670l = new C12324();
        f3671m = new C12335();
        f3672n = new AccelerateDecelerateInterpolator();
        f3673o = new C1205f();
        f3674p = new C1202d();
        f3675z = 10;
    }

    public C1210n() {
        this.f3681c = -1;
        this.f3686q = false;
        this.f3687r = 0;
        this.f3688s = 0.0f;
        this.f3689t = false;
        this.f3682d = 0;
        this.f3691v = false;
        this.f3692w = false;
        this.f3683e = false;
        this.f3693x = 300;
        this.f3694y = 0;
        this.f3676A = 0;
        this.f3677B = 1;
        this.f3678C = f3672n;
        this.f3679D = null;
    }

    public static C1210n m5086b(int... values) {
        C1210n anim = new C1210n();
        anim.m5104a(values);
        return anim;
    }

    public static C1210n m5085b(float... values) {
        C1210n anim = new C1210n();
        anim.m5103a(values);
        return anim;
    }

    public void m5104a(int... values) {
        if (values != null && values.length != 0) {
            if (this.f3684f == null || this.f3684f.length == 0) {
                m5105a(C1226l.m5203a("", values));
            } else {
                this.f3684f[0].m5215a(values);
            }
            this.f3683e = false;
        }
    }

    public void m5103a(float... values) {
        if (values != null && values.length != 0) {
            if (this.f3684f == null || this.f3684f.length == 0) {
                m5105a(C1226l.m5202a("", values));
            } else {
                this.f3684f[0].m5214a(values);
            }
            this.f3683e = false;
        }
    }

    public void m5105a(C1226l... values) {
        this.f3684f = values;
        this.f3685g = new HashMap(numValues);
        for (C1226l valuesHolder : values) {
            this.f3685g.put(valuesHolder.m5218c(), valuesHolder);
        }
        this.f3683e = false;
    }

    void m5114g() {
        if (!this.f3683e) {
            for (C1226l b : this.f3684f) {
                b.m5216b();
            }
            this.f3683e = true;
        }
    }

    public C1210n m5107c(long duration) {
        if (duration < 0) {
            throw new IllegalArgumentException("Animators cannot have negative duration: " + duration);
        }
        this.f3693x = duration;
        return this;
    }

    public void m5109d(long playTime) {
        m5114g();
        long currentTime = AnimationUtils.currentAnimationTimeMillis();
        if (this.f3682d != 1) {
            this.f3681c = playTime;
            this.f3682d = 2;
        }
        this.f3680b = currentTime - playTime;
        m5113f(currentTime);
    }

    public long m5116j() {
        if (!this.f3683e || this.f3682d == 0) {
            return 0;
        }
        return AnimationUtils.currentAnimationTimeMillis() - this.f3680b;
    }

    public void m5111e(long startDelay) {
        this.f3694y = startDelay;
    }

    public Object m5117k() {
        if (this.f3684f == null || this.f3684f.length <= 0) {
            return null;
        }
        return this.f3684f[0].m5219d();
    }

    public void m5102a(C0803b listener) {
        if (this.f3679D == null) {
            this.f3679D = new ArrayList();
        }
        this.f3679D.add(listener);
    }

    public void m5101a(Interpolator value) {
        if (value != null) {
            this.f3678C = value;
        } else {
            this.f3678C = new LinearInterpolator();
        }
    }

    private void m5082a(boolean playBackwards) {
        if (Looper.myLooper() == null) {
            throw new AndroidRuntimeException("Animators may only be run on Looper threads");
        }
        this.f3686q = playBackwards;
        this.f3687r = 0;
        this.f3682d = 0;
        this.f3692w = true;
        this.f3689t = false;
        ((ArrayList) f3668j.get()).add(this);
        if (this.f3694y == 0) {
            m5109d(m5116j());
            this.f3682d = 0;
            this.f3691v = true;
            if (this.a != null) {
                ArrayList tmpListeners = (ArrayList) this.a.clone();
                int numListeners = tmpListeners.size();
                for (int i = 0; i < numListeners; i++) {
                    ((C0672a) tmpListeners.get(i)).m3044b(this);
                }
            }
        }
        C1234a animationHandler = (C1234a) f3666h.get();
        if (animationHandler == null) {
            animationHandler = new C1234a();
            f3666h.set(animationHandler);
        }
        animationHandler.sendEmptyMessage(0);
    }

    public void m5099a() {
        m5082a(false);
    }

    public void m5106b() {
        if (this.f3682d != 0 || ((ArrayList) f3668j.get()).contains(this) || ((ArrayList) f3669k.get()).contains(this)) {
            if (this.f3691v && this.a != null) {
                Iterator i$ = ((ArrayList) this.a.clone()).iterator();
                while (i$.hasNext()) {
                    ((C0672a) i$.next()).m3045c(this);
                }
            }
            m5090h();
        }
    }

    public boolean m5108c() {
        return this.f3682d == 1 || this.f3691v;
    }

    public boolean m5110d() {
        return this.f3692w;
    }

    private void m5090h() {
        ((ArrayList) f3667i.get()).remove(this);
        ((ArrayList) f3668j.get()).remove(this);
        ((ArrayList) f3669k.get()).remove(this);
        this.f3682d = 0;
        if (this.f3691v && this.a != null) {
            ArrayList tmpListeners = (ArrayList) this.a.clone();
            int numListeners = tmpListeners.size();
            for (int i = 0; i < numListeners; i++) {
                ((C0672a) tmpListeners.get(i)).m3043a(this);
            }
        }
        this.f3691v = false;
        this.f3692w = false;
    }

    private void m5097s() {
        m5114g();
        ((ArrayList) f3667i.get()).add(this);
        if (this.f3694y > 0 && this.a != null) {
            ArrayList tmpListeners = (ArrayList) this.a.clone();
            int numListeners = tmpListeners.size();
            for (int i = 0; i < numListeners; i++) {
                ((C0672a) tmpListeners.get(i)).m3044b(this);
            }
        }
    }

    private boolean m5088b(long currentTime) {
        if (this.f3689t) {
            long deltaTime = currentTime - this.f3690u;
            if (deltaTime > this.f3694y) {
                this.f3680b = currentTime - (deltaTime - this.f3694y);
                this.f3682d = 1;
                return true;
            }
        }
        this.f3689t = true;
        this.f3690u = currentTime;
        return false;
    }

    boolean m5113f(long currentTime) {
        boolean done = false;
        if (this.f3682d == 0) {
            this.f3682d = 1;
            if (this.f3681c < 0) {
                this.f3680b = currentTime;
            } else {
                this.f3680b = currentTime - this.f3681c;
                this.f3681c = -1;
            }
        }
        switch (this.f3682d) {
            case Base64.NO_PADDING /*1*/:
            case Base64.NO_WRAP /*2*/:
                float fraction;
                if (this.f3693x > 0) {
                    fraction = ((float) (currentTime - this.f3680b)) / ((float) this.f3693x);
                } else {
                    fraction = 1.0f;
                }
                if (fraction >= 1.0f) {
                    if (this.f3687r < this.f3676A || this.f3676A == -1) {
                        if (this.a != null) {
                            int numListeners = this.a.size();
                            for (int i = 0; i < numListeners; i++) {
                                ((C0672a) this.a.get(i)).m3046d(this);
                            }
                        }
                        if (this.f3677B == 2) {
                            this.f3686q = !this.f3686q;
                        }
                        this.f3687r += (int) fraction;
                        fraction %= 1.0f;
                        this.f3680b += this.f3693x;
                    } else {
                        done = true;
                        fraction = Math.min(fraction, 1.0f);
                    }
                }
                if (this.f3686q) {
                    fraction = 1.0f - fraction;
                }
                m5100a(fraction);
                break;
        }
        return done;
    }

    public float m5118l() {
        return this.f3688s;
    }

    void m5100a(float fraction) {
        int i;
        fraction = this.f3678C.getInterpolation(fraction);
        this.f3688s = fraction;
        for (C1226l a : this.f3684f) {
            a.m5209a(fraction);
        }
        if (this.f3679D != null) {
            int numListeners = this.f3679D.size();
            for (i = 0; i < numListeners; i++) {
                ((C0803b) this.f3679D.get(i)).m3798a(this);
            }
        }
    }

    public C1210n m5115i() {
        int i;
        C1210n anim = (C1210n) super.m5007f();
        if (this.f3679D != null) {
            ArrayList oldListeners = this.f3679D;
            anim.f3679D = new ArrayList();
            int numListeners = oldListeners.size();
            for (i = 0; i < numListeners; i++) {
                anim.f3679D.add(oldListeners.get(i));
            }
        }
        anim.f3681c = -1;
        anim.f3686q = false;
        anim.f3687r = 0;
        anim.f3683e = false;
        anim.f3682d = 0;
        anim.f3689t = false;
        C1226l[] oldValues = this.f3684f;
        if (oldValues != null) {
            int numValues = oldValues.length;
            anim.f3684f = new C1226l[numValues];
            anim.f3685g = new HashMap(numValues);
            for (i = 0; i < numValues; i++) {
                C1226l newValuesHolder = oldValues[i].m5208a();
                anim.f3684f[i] = newValuesHolder;
                anim.f3685g.put(newValuesHolder.m5218c(), newValuesHolder);
            }
        }
        return anim;
    }

    public String toString() {
        String returnVal = "ValueAnimator@" + Integer.toHexString(hashCode());
        if (this.f3684f != null) {
            for (C1226l c1226l : this.f3684f) {
                returnVal = returnVal + "\n    " + c1226l.toString();
            }
        }
        return returnVal;
    }
}
