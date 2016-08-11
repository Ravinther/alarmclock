package com.p037b.p063c;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import com.p037b.p038a.C1193a.C0672a;
import java.lang.ref.WeakReference;

/* renamed from: com.b.c.d */
class C1245d extends C1238b {
    private final WeakReference f3778a;

    /* renamed from: com.b.c.d.1 */
    class C12441 implements AnimatorListener {
        final /* synthetic */ C0672a f3776a;
        final /* synthetic */ C1245d f3777b;

        C12441(C1245d c1245d, C0672a c0672a) {
            this.f3777b = c1245d;
            this.f3776a = c0672a;
        }

        public void onAnimationStart(Animator animation) {
            this.f3776a.m3044b(null);
        }

        public void onAnimationRepeat(Animator animation) {
            this.f3776a.m3046d(null);
        }

        public void onAnimationEnd(Animator animation) {
            this.f3776a.m3043a(null);
        }

        public void onAnimationCancel(Animator animation) {
            this.f3776a.m3045c(null);
        }
    }

    C1245d(View view) {
        this.f3778a = new WeakReference(view.animate());
    }

    public C1238b m5323a(long duration) {
        ViewPropertyAnimator n = (ViewPropertyAnimator) this.f3778a.get();
        if (n != null) {
            n.setDuration(duration);
        }
        return this;
    }

    public C1238b m5324a(Interpolator interpolator) {
        ViewPropertyAnimator n = (ViewPropertyAnimator) this.f3778a.get();
        if (n != null) {
            n.setInterpolator(interpolator);
        }
        return this;
    }

    public C1238b m5325a(C0672a listener) {
        ViewPropertyAnimator n = (ViewPropertyAnimator) this.f3778a.get();
        if (n != null) {
            if (listener == null) {
                n.setListener(null);
            } else {
                n.setListener(new C12441(this, listener));
            }
        }
        return this;
    }

    public void m5326a() {
        ViewPropertyAnimator n = (ViewPropertyAnimator) this.f3778a.get();
        if (n != null) {
            n.start();
        }
    }

    public C1238b m5322a(float value) {
        ViewPropertyAnimator n = (ViewPropertyAnimator) this.f3778a.get();
        if (n != null) {
            n.rotation(value);
        }
        return this;
    }

    public C1238b m5327b(float value) {
        ViewPropertyAnimator n = (ViewPropertyAnimator) this.f3778a.get();
        if (n != null) {
            n.translationX(value);
        }
        return this;
    }

    public C1238b m5328c(float value) {
        ViewPropertyAnimator n = (ViewPropertyAnimator) this.f3778a.get();
        if (n != null) {
            n.translationY(value);
        }
        return this;
    }

    public C1238b m5329d(float value) {
        ViewPropertyAnimator n = (ViewPropertyAnimator) this.f3778a.get();
        if (n != null) {
            n.scaleX(value);
        }
        return this;
    }

    public C1238b m5330e(float value) {
        ViewPropertyAnimator n = (ViewPropertyAnimator) this.f3778a.get();
        if (n != null) {
            n.scaleY(value);
        }
        return this;
    }

    public C1238b m5331f(float value) {
        ViewPropertyAnimator n = (ViewPropertyAnimator) this.f3778a.get();
        if (n != null) {
            n.alpha(value);
        }
        return this;
    }
}
