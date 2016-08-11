package com.anglelabs.alarmclock.redesign.utils;

import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ViewSwitcher;
import com.p037b.p038a.C0673b;
import com.p037b.p038a.C1193a;
import com.p037b.p038a.C1193a.C0672a;
import com.p037b.p038a.C1200c;
import com.p037b.p038a.C1210n;
import com.p037b.p038a.C1210n.C0803b;
import com.p037b.p038a.C1211j;
import com.p037b.p038a.C1226l;
import com.p037b.p063c.C1237a;
import com.p037b.p063c.C1238b;

/* renamed from: com.anglelabs.alarmclock.redesign.utils.e */
public class C0807e {
    private static final AccelerateInterpolator f2124a;

    /* renamed from: com.anglelabs.alarmclock.redesign.utils.e.b */
    public static abstract class C0730b {
        public void m3394a(C1193a animation) {
        }

        public void m3395b(C1193a animation) {
        }

        public void m3396c(C1193a animation) {
        }

        public void m3397d(C1193a animation) {
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.utils.e.1 */
    static class C07971 extends C0673b {
        final /* synthetic */ View f2107a;

        C07971(View view) {
            this.f2107a = view;
        }

        public void m3792a(C1193a animation) {
            super.m3047a(animation);
            C1237a.m5280c(this.f2107a, 1.0f);
            C1237a.m5281d(this.f2107a, 1.0f);
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.utils.e.2 */
    static class C07982 extends C0673b {
        final /* synthetic */ View f2108a;

        C07982(View view) {
            this.f2108a = view;
        }

        public void m3793b(C1193a animation) {
            super.m3048b(animation);
            this.f2108a.setVisibility(0);
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.utils.e.3 */
    static class C07993 extends C0673b {
        final /* synthetic */ View f2109a;

        C07993(View view) {
            this.f2109a = view;
        }

        public void m3794a(C1193a animation) {
            C1237a.m5278a(this.f2109a, 1.0f);
            C1237a.m5282e(this.f2109a, 0.0f);
            C1237a.m5279b(this.f2109a, 0.0f);
            C1237a.m5280c(this.f2109a, 1.0f);
            C1237a.m5281d(this.f2109a, 1.0f);
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.utils.e.4 */
    static class C08004 extends C0673b {
        final /* synthetic */ View f2110a;
        final /* synthetic */ long f2111b;
        final /* synthetic */ C0730b f2112c;

        C08004(View view, long j, C0730b c0730b) {
            this.f2110a = view;
            this.f2111b = j;
            this.f2112c = c0730b;
        }

        public void m3795a(C1193a animation) {
            C0807e.m3816b(this.f2110a, this.f2111b, this.f2112c).m5289a();
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.utils.e.5 */
    static class C08015 extends C0673b {
        final /* synthetic */ View f2113a;

        C08015(View view) {
            this.f2113a = view;
        }

        public void m3796a(C1193a animation) {
            C1237a.m5278a(this.f2113a, 1.0f);
            C1237a.m5282e(this.f2113a, 0.0f);
            C1237a.m5279b(this.f2113a, 0.0f);
            C1237a.m5280c(this.f2113a, 1.0f);
            C1237a.m5281d(this.f2113a, 1.0f);
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.utils.e.6 */
    static class C08026 extends C0673b {
        final /* synthetic */ View f2114a;

        C08026(View view) {
            this.f2114a = view;
        }

        public void m3797b(C1193a animation) {
            this.f2114a.setVisibility(0);
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.utils.e.7 */
    static class C08047 implements C0803b {
        final /* synthetic */ View f2115a;

        C08047(View view) {
            this.f2115a = view;
        }

        public void m3799a(C1210n animator) {
            this.f2115a.getLayoutParams().width = ((Integer) animator.m5117k()).intValue();
            this.f2115a.requestLayout();
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.utils.e.8 */
    static class C08058 implements C0803b {
        final /* synthetic */ int f2116a;
        final /* synthetic */ View f2117b;

        C08058(int i, View view) {
            this.f2116a = i;
            this.f2117b = view;
        }

        public void m3800a(C1210n animator) {
            int value = ((Integer) animator.m5117k()).intValue();
            if (value == this.f2116a) {
                this.f2117b.getLayoutParams().width = -2;
            } else {
                this.f2117b.getLayoutParams().width = value;
            }
            this.f2117b.requestLayout();
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.utils.e.a */
    private static class C0806a implements C0672a {
        final C0730b f2118a;
        C0673b f2119b;
        boolean f2120c;
        boolean f2121d;
        boolean f2122e;
        boolean f2123f;

        public C0806a(C0730b extender, C0673b adapter) {
            this.f2118a = extender;
            this.f2119b = adapter;
        }

        public void m3802b(C1193a animator) {
            if (!this.f2120c) {
                if (this.f2119b != null) {
                    this.f2119b.m3048b(animator);
                }
                if (this.f2118a != null) {
                    this.f2118a.m3395b(animator);
                }
                this.f2120c = true;
            }
        }

        public void m3801a(C1193a animator) {
            if (!this.f2121d) {
                if (this.f2119b != null) {
                    this.f2119b.m3047a(animator);
                }
                if (this.f2118a != null) {
                    this.f2118a.m3394a(animator);
                }
                this.f2121d = true;
            }
        }

        public void m3803c(C1193a animator) {
            if (!this.f2122e) {
                if (this.f2119b != null) {
                    this.f2119b.m3049c(animator);
                }
                if (this.f2118a != null) {
                    this.f2118a.m3396c(animator);
                }
                this.f2122e = true;
            }
        }

        public void m3804d(C1193a animator) {
            if (!this.f2123f) {
                if (this.f2119b != null) {
                    this.f2119b.m3050d(animator);
                }
                if (this.f2118a != null) {
                    this.f2118a.m3397d(animator);
                }
                this.f2123f = true;
            }
        }
    }

    static {
        f2124a = new AccelerateInterpolator();
    }

    public static int m3805a(View view) {
        view.measure(0, MeasureSpec.makeMeasureSpec(-1, 1073741824));
        return view.getMeasuredHeight();
    }

    public static C1200c m3808a(View v, float howMuchToShake) {
        C1211j moveLeftAnim = C1211j.m5119a((Object) v, "translationX", -howMuchToShake);
        C1211j moveRightAnim = C1211j.m5119a((Object) v, "translationX", 0.75f * howMuchToShake);
        C1211j moveLeftAgainAnim = C1211j.m5119a((Object) v, "translationX", -(0.5f * howMuchToShake));
        C1211j returnAnim = C1211j.m5119a((Object) v, "translationX", 0.0f);
        C1200c sequentialSet = new C1200c();
        sequentialSet.m5037b(moveLeftAnim, moveRightAnim, moveLeftAgainAnim, returnAnim);
        sequentialSet.m5035b(150).m5032a(f2124a);
        return sequentialSet;
    }

    public static C1211j m3815b(View view) {
        return C0807e.m3809a(view, -1);
    }

    public static C1211j m3809a(View view, long animationTime) {
        C1226l scaleX = C1226l.m5202a("scaleX", 0.0f);
        C1226l scaleY = C1226l.m5202a("scaleY", 0.0f);
        C1211j anim = C1211j.m5121a(view, scaleX, scaleY);
        if (animationTime > 0) {
            anim.m5129b(animationTime);
        }
        anim.m5001a(new C07971(view));
        return anim;
    }

    public static C1211j m3819c(View view) {
        C1226l scaleX = C1226l.m5202a("scaleX", 0.0f, 1.0f);
        C1226l scaleY = C1226l.m5202a("scaleY", 0.0f, 1.0f);
        return C1211j.m5121a(view, scaleX, scaleY);
    }

    public static C1193a m3820d(View v) {
        return C0807e.m3806a(v, 300);
    }

    public static C1193a m3806a(View v, int duration) {
        C1211j showErrorAnim = C1211j.m5119a((Object) v, "alpha", 0.6f, 1.0f);
        showErrorAnim.m5129b((long) duration).m5101a(new LinearInterpolator());
        showErrorAnim.m5001a(new C07982(v));
        return showErrorAnim;
    }

    public static C1238b m3811a(View view, boolean dismissRight, long animationTime, C0730b hook) {
        int viewWidth = view.getMeasuredWidth();
        return C1238b.m5284a(view).m5290b(dismissRight ? (float) viewWidth : (float) (-viewWidth)).m5294f(0.0f).m5292d(0.25f).m5293e(0.25f).m5285a(dismissRight ? 20.0f : -20.0f).m5287a(new LinearInterpolator()).m5286a((long) (((double) animationTime) / 1.5d)).m5288a(new C0806a(hook, new C07993(view)));
    }

    public static C1238b m3817b(View view, boolean dismissRight, long animationTime, C0730b hook) {
        int viewWidth = view.getMeasuredWidth();
        return C1238b.m5284a(view).m5290b(dismissRight ? (float) viewWidth : (float) (-viewWidth)).m5294f(0.0f).m5292d(0.25f).m5293e(0.25f).m5285a(dismissRight ? 20.0f : -20.0f).m5287a(new LinearInterpolator()).m5286a((long) (((double) animationTime) / 1.5d)).m5288a(new C08004(view, animationTime, hook));
    }

    private static C1238b m3816b(View view, long animationTime, C0730b hook) {
        return C1238b.m5284a(view).m5290b(0.0f).m5294f(1.0f).m5292d(1.0f).m5293e(1.0f).m5285a(0.0f).m5287a(new LinearInterpolator()).m5286a((long) (((double) animationTime) / 1.5d)).m5288a(new C0806a(hook, new C08015(view)));
    }

    public static C1193a m3822e(View v) {
        return C0807e.m3814b(v, 300);
    }

    public static C1193a m3814b(View v, int duration) {
        C1211j showErrorAnim = C1211j.m5119a((Object) v, "alpha", 0.0f);
        showErrorAnim.m5129b((long) duration).m5101a(new LinearInterpolator());
        showErrorAnim.m5001a(new C08026(v));
        return showErrorAnim;
    }

    public static C1193a m3818c(View view, int scrollBy) {
        return C0807e.m3807a(view, scrollBy, 800);
    }

    public static C1193a m3807a(View view, int scrollBy, int duration) {
        if (view.getAnimation() != null) {
            view.getAnimation().cancel();
        }
        C1211j animator = C1211j.m5120a((Object) view, "scrollX", view.getScrollX() - scrollBy);
        animator.m5129b((long) duration);
        return animator;
    }

    public static C1193a m3821d(View v, int targetSize) {
        C1210n animator = C1210n.m5086b(v.getWidth(), targetSize);
        animator.m5111e(150);
        animator.m5107c(150);
        animator.m5101a(f2124a);
        animator.m5102a(new C08047(v));
        return animator;
    }

    public static C1193a m3823f(View v) {
        int startingWidth = v.getWidth();
        v.measure(MeasureSpec.makeMeasureSpec(-2, 1073741824), 0);
        C1210n animator = C1210n.m5086b(startingWidth, v.getMeasuredWidth());
        animator.m5111e(150);
        animator.m5107c(500);
        animator.m5101a(f2124a);
        animator.m5102a(new C08058(endSize, v));
        return animator;
    }

    public static void m3824g(View v) {
        v.measure(MeasureSpec.makeMeasureSpec(-2, 1073741824), 0);
        v.getLayoutParams().width = -2;
        v.requestLayout();
    }

    public static void m3813a(Context context, ViewSwitcher switcher, int animInResId, int animOutResId) {
        Animation animIn = AnimationUtils.loadAnimation(context, animInResId);
        Animation animOut = AnimationUtils.loadAnimation(context, animOutResId);
        switcher.setInAnimation(animIn);
        switcher.setOutAnimation(animOut);
    }

    public static void m3812a(Context context, ViewSwitcher switcher) {
        Animation animIn = AnimationUtils.loadAnimation(context, 17432576);
        Animation animOut = AnimationUtils.loadAnimation(context, 17432577);
        switcher.setInAnimation(animIn);
        switcher.setOutAnimation(animOut);
    }
}
