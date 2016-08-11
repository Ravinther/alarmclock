package com.anglelabs.alarmclock.redesign.utils;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.support.v4.p010d.C0142e;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ListView;
import com.anglelabs.alarmclock.redesign.utils.o.AnonymousClass12;
import com.anglelabs.alarmclock.redesign.utils.o.AnonymousClass13;
import com.p037b.p038a.C0673b;
import com.p037b.p038a.C1193a;
import com.p037b.p063c.C1237a;
import com.p037b.p063c.C1238b;

/* renamed from: com.anglelabs.alarmclock.redesign.utils.o */
public class C0845o {
    private final ListView f2420a;
    private final AccelerateDecelerateInterpolator f2421b;
    private final C0668b f2422c;
    private boolean f2423d;
    private boolean f2424e;
    private boolean f2425f;
    private final C0142e f2426g;

    /* renamed from: com.anglelabs.alarmclock.redesign.utils.o.b */
    public interface C0668b {
        void m3023a();

        void m3024a(int i);

        void m3025a(int i, Object obj);

        void m3026a(boolean z);

        long m3027b(int i);
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.utils.o.12 */
    class AnonymousClass12 extends C0673b {
        final /* synthetic */ int f2390a;
        final /* synthetic */ Object f2391b;
        final /* synthetic */ int f2392c;
        final /* synthetic */ C0845o f2393d;

        AnonymousClass12(C0845o c0845o, int i, Object obj, int i2) {
            this.f2393d = c0845o;
            this.f2390a = i;
            this.f2391b = obj;
            this.f2392c = i2;
        }

        public void m3949a(C1193a animation) {
            this.f2393d.m3952a(this.f2390a, this.f2391b, this.f2392c);
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.utils.o.13 */
    class AnonymousClass13 implements AnimatorListener {
        final /* synthetic */ int f2394a;
        final /* synthetic */ Object f2395b;
        final /* synthetic */ int f2396c;
        final /* synthetic */ C0845o f2397d;

        AnonymousClass13(C0845o c0845o, int i, Object obj, int i2) {
            this.f2397d = c0845o;
            this.f2394a = i;
            this.f2395b = obj;
            this.f2396c = i2;
        }

        public void onAnimationStart(Animator animation) {
        }

        public void onAnimationEnd(Animator animation) {
            this.f2397d.m3952a(this.f2394a, this.f2395b, this.f2396c);
        }

        public void onAnimationCancel(Animator animation) {
        }

        public void onAnimationRepeat(Animator animation) {
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.utils.o.1 */
    class C08351 extends C0673b {
        final /* synthetic */ C0845o f2398a;

        C08351(C0845o c0845o) {
            this.f2398a = c0845o;
        }

        public void m3950a(C1193a animation) {
            this.f2398a.m3963b();
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.utils.o.2 */
    class C08362 implements Runnable {
        final /* synthetic */ int f2399a;
        final /* synthetic */ Object f2400b;
        final /* synthetic */ int f2401c;
        final /* synthetic */ C0845o f2402d;

        C08362(C0845o c0845o, int i, Object obj, int i2) {
            this.f2402d = c0845o;
            this.f2399a = i;
            this.f2400b = obj;
            this.f2401c = i2;
        }

        public void run() {
            this.f2402d.m3952a(this.f2399a, this.f2400b, this.f2401c);
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.utils.o.3 */
    class C08373 implements OnPreDrawListener {
        final /* synthetic */ ViewTreeObserver f2403a;
        final /* synthetic */ int f2404b;
        final /* synthetic */ C0845o f2405c;

        C08373(C0845o c0845o, ViewTreeObserver viewTreeObserver, int i) {
            this.f2405c = c0845o;
            this.f2403a = viewTreeObserver;
            this.f2404b = i;
        }

        public boolean onPreDraw() {
            this.f2403a.removeOnPreDrawListener(this);
            if (this.f2404b == this.f2405c.f2420a.getLastVisiblePosition()) {
                View child = this.f2405c.f2420a.getChildAt(this.f2405c.f2420a.getChildCount() - 1);
                this.f2405c.m3955a(child, child.getWidth(), C0844a.X);
                this.f2405c.m3954a(child, 0.0f, C0844a.X);
                this.f2405c.m3964b(child);
            } else {
                this.f2405c.m3967c();
            }
            return true;
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.utils.o.4 */
    class C08384 implements OnPreDrawListener {
        final /* synthetic */ ViewTreeObserver f2406a;
        final /* synthetic */ int f2407b;
        final /* synthetic */ int f2408c;
        final /* synthetic */ C0845o f2409d;

        C08384(C0845o c0845o, ViewTreeObserver viewTreeObserver, int i, int i2) {
            this.f2409d = c0845o;
            this.f2406a = viewTreeObserver;
            this.f2407b = i;
            this.f2408c = i2;
        }

        public boolean onPreDraw() {
            this.f2406a.removeOnPreDrawListener(this);
            View child = this.f2409d.f2420a.getChildAt(this.f2407b - this.f2408c);
            this.f2409d.m3955a(child, 0, C0844a.Y);
            this.f2409d.m3955a(child, child.getWidth(), C0844a.X);
            this.f2409d.m3954a(child, 0.0f, C0844a.X);
            this.f2409d.m3964b(child);
            return true;
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.utils.o.5 */
    class C08395 implements OnPreDrawListener {
        final /* synthetic */ ViewTreeObserver f2410a;
        final /* synthetic */ C0845o f2411b;

        C08395(C0845o c0845o, ViewTreeObserver viewTreeObserver) {
            this.f2411b = c0845o;
            this.f2410a = viewTreeObserver;
        }

        public boolean onPreDraw() {
            this.f2410a.removeOnPreDrawListener(this);
            View child0 = this.f2411b.f2420a.getChildAt(0);
            this.f2411b.m3955a(child0, -(child0.getHeight() + this.f2411b.f2420a.getDividerHeight()), C0844a.Y);
            this.f2411b.m3954a(child0, 0.0f, C0844a.Y);
            this.f2411b.m3964b(child0);
            return true;
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.utils.o.6 */
    class C08406 implements AnimatorListener {
        final /* synthetic */ C0845o f2412a;

        C08406(C0845o c0845o) {
            this.f2412a = c0845o;
        }

        public void onAnimationStart(Animator animation) {
        }

        public void onAnimationEnd(Animator animation) {
            this.f2412a.m3963b();
        }

        public void onAnimationCancel(Animator animation) {
        }

        public void onAnimationRepeat(Animator animation) {
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.utils.o.7 */
    class C08417 implements Runnable {
        final /* synthetic */ C0845o f2413a;

        C08417(C0845o c0845o) {
            this.f2413a = c0845o;
        }

        public void run() {
            this.f2413a.m3963b();
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.utils.o.8 */
    class C08428 implements OnPreDrawListener {
        final /* synthetic */ ViewTreeObserver f2414a;
        final /* synthetic */ C0845o f2415b;

        C08428(C0845o c0845o, ViewTreeObserver viewTreeObserver) {
            this.f2415b = c0845o;
            this.f2414a = viewTreeObserver;
        }

        public boolean onPreDraw() {
            this.f2414a.removeOnPreDrawListener(this);
            boolean firstAnimation = true;
            int firstVisiblePosition = this.f2415b.f2420a.getFirstVisiblePosition();
            boolean didAnimate = false;
            for (int i = 0; i < this.f2415b.f2420a.getChildCount(); i++) {
                View child = this.f2415b.f2420a.getChildAt(i);
                Integer startTop = (Integer) this.f2415b.f2426g.m553a(this.f2415b.f2422c.m3027b(firstVisiblePosition + i));
                int top = child.getTop();
                if (startTop == null) {
                    int childHeight = child.getHeight() + this.f2415b.f2420a.getDividerHeight();
                    if (i <= 0) {
                        childHeight = -childHeight;
                    }
                    this.f2415b.m3955a(child, Integer.valueOf(top + childHeight).intValue() - top, C0844a.Y);
                    this.f2415b.m3954a(child, 0.0f, C0844a.Y);
                    if (firstAnimation) {
                        this.f2415b.m3953a(child);
                        firstAnimation = false;
                    }
                } else if (startTop.intValue() != top) {
                    didAnimate = true;
                    this.f2415b.m3955a(child, startTop.intValue() - top, C0844a.Y);
                    this.f2415b.m3954a(child, 0.0f, C0844a.Y);
                    if (firstAnimation) {
                        this.f2415b.m3953a(child);
                        firstAnimation = false;
                    }
                }
            }
            if (!didAnimate) {
                this.f2415b.m3963b();
            }
            this.f2415b.f2426g.m558c();
            return true;
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.utils.o.9 */
    class C08439 extends C0673b {
        final /* synthetic */ C0845o f2416a;

        C08439(C0845o c0845o) {
            this.f2416a = c0845o;
        }

        public void m3951a(C1193a animation) {
            this.f2416a.m3967c();
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.utils.o.a */
    private enum C0844a {
        X,
        Y
    }

    public C0845o(ListView listView, C0668b callbacks) {
        this.f2421b = new AccelerateDecelerateInterpolator();
        this.f2423d = false;
        this.f2424e = false;
        this.f2425f = false;
        this.f2426g = new C0142e();
        if (VERSION.SDK_INT < 12) {
            this.f2423d = true;
        } else if (VERSION.SDK_INT < 16) {
            this.f2424e = true;
        }
        this.f2422c = callbacks;
        this.f2420a = listView;
    }

    public boolean m3972a() {
        return this.f2425f;
    }

    @SuppressLint({"NewApi"})
    private void m3955a(View view, int delta, C0844a axis) {
        if (this.f2423d) {
            if (axis == C0844a.X) {
                C1237a.m5282e(view, (float) delta);
                C1237a.m5278a(view, 0.0f);
                return;
            }
            C1237a.m5283f(view, (float) delta);
        } else if (axis == C0844a.X) {
            view.setTranslationX((float) delta);
            view.setAlpha(0.0f);
        } else {
            view.setTranslationY((float) delta);
        }
    }

    @SuppressLint({"NewApi"})
    private void m3954a(View view, float to, C0844a axis) {
        if (this.f2423d) {
            C1238b animator = C1238b.m5284a(view).m5286a(250).m5287a(this.f2421b);
            if (axis == C0844a.X) {
                animator.m5290b(to).m5294f(1.0f);
                return;
            } else {
                animator.m5291c(to);
                return;
            }
        }
        ViewPropertyAnimator animator2 = view.animate().setDuration(250).setInterpolator(this.f2421b);
        if (axis == C0844a.X) {
            animator2.translationX(to).alpha(1.0f);
        } else {
            animator2.translationY(to);
        }
    }

    @SuppressLint({"NewApi"})
    private void m3953a(View view) {
        if (this.f2423d) {
            C1238b.m5284a(view).m5288a(new C08351(this));
        } else if (this.f2424e) {
            view.animate().setListener(new C08406(this));
        } else {
            view.animate().withEndAction(new C08417(this));
        }
    }

    @SuppressLint({"NewApi"})
    public void m3970a(View viewToRemove, int adapterPos) {
        this.f2425f = true;
        this.f2422c.m3026a(false);
        int firstVisiblePosition = this.f2420a.getFirstVisiblePosition();
        int preDeleteChildCount = this.f2420a.getChildCount();
        for (int i = 0; i < preDeleteChildCount; i++) {
            View child = this.f2420a.getChildAt(i);
            if (child != viewToRemove) {
                this.f2426g.m557b(this.f2422c.m3027b(firstVisiblePosition + i), Integer.valueOf(child.getTop()));
            }
        }
        this.f2422c.m3024a(adapterPos);
        ViewTreeObserver observer = this.f2420a.getViewTreeObserver();
        observer.addOnPreDrawListener(new C08428(this, observer));
    }

    private void m3963b() {
        this.f2420a.setEnabled(true);
        this.f2422c.m3026a(true);
        this.f2422c.m3023a();
        this.f2425f = false;
    }

    private void m3967c() {
        this.f2422c.m3026a(true);
        this.f2420a.setEnabled(true);
    }

    @SuppressLint({"NewApi"})
    private void m3964b(View view) {
        if (this.f2423d) {
            C1238b.m5284a(view).m5288a(new C08439(this));
        } else if (this.f2424e) {
            view.animate().setListener(new AnimatorListener() {
                final /* synthetic */ C0845o f2388a;

                {
                    this.f2388a = r1;
                }

                public void onAnimationStart(Animator animation) {
                }

                public void onAnimationEnd(Animator animation) {
                    this.f2388a.m3967c();
                }

                public void onAnimationCancel(Animator animation) {
                }

                public void onAnimationRepeat(Animator animation) {
                }
            });
        } else {
            view.animate().withEndAction(new Runnable() {
                final /* synthetic */ C0845o f2389a;

                {
                    this.f2389a = r1;
                }

                public void run() {
                    this.f2389a.m3967c();
                }
            });
        }
    }

    @SuppressLint({"NewApi"})
    private void m3956a(View view, int pos, Object itemToAdd, int firstVisiblePosition) {
        if (this.f2423d) {
            C1238b.m5284a(view).m5288a(new AnonymousClass12(this, pos, itemToAdd, firstVisiblePosition));
        } else if (this.f2424e) {
            view.animate().setListener(new AnonymousClass13(this, pos, itemToAdd, firstVisiblePosition));
        } else {
            view.animate().withEndAction(new C08362(this, pos, itemToAdd, firstVisiblePosition));
        }
    }

    @SuppressLint({"NewApi"})
    public void m3971a(Object itemToAdd, int pos) {
        this.f2420a.setEnabled(false);
        this.f2422c.m3026a(false);
        int firstVisiblePosition = this.f2420a.getFirstVisiblePosition();
        int lastVisiblePosition = this.f2420a.getLastVisiblePosition();
        int childCount = this.f2420a.getChildCount();
        if (pos > lastVisiblePosition) {
            this.f2422c.m3025a(pos, itemToAdd);
            ViewTreeObserver observer = this.f2420a.getViewTreeObserver();
            observer.addOnPreDrawListener(new C08373(this, observer, pos));
            return;
        }
        boolean firstAnimation = true;
        this.f2420a.setEnabled(false);
        for (int i = 0; i < childCount; i++) {
            int position = firstVisiblePosition + i;
            View child = this.f2420a.getChildAt(i);
            if (position >= pos) {
                m3954a(child, (float) (child.getHeight() + this.f2420a.getDividerHeight()), C0844a.Y);
                if (firstAnimation) {
                    m3956a(child, pos, itemToAdd, firstVisiblePosition);
                    firstAnimation = false;
                }
            }
        }
    }

    @SuppressLint({"NewApi"})
    private void m3952a(int pos, Object itemToAdd, int firstVisiblePosition) {
        this.f2422c.m3025a(pos, itemToAdd);
        for (int i = 0; i < this.f2420a.getChildCount(); i++) {
            m3955a(this.f2420a.getChildAt(i), 0, C0844a.Y);
        }
        int firstPos = this.f2420a.getFirstVisiblePosition();
        int lastPos = this.f2420a.getLastVisiblePosition();
        ViewTreeObserver observer;
        if (firstPos <= pos && pos <= lastPos) {
            observer = this.f2420a.getViewTreeObserver();
            observer.addOnPreDrawListener(new C08384(this, observer, pos, firstPos));
        } else if (pos < firstVisiblePosition) {
            observer = this.f2420a.getViewTreeObserver();
            observer.addOnPreDrawListener(new C08395(this, observer));
        } else {
            m3967c();
        }
    }
}
