package com.anglelabs.alarmclock.redesign.utils;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.animation.OvershootInterpolator;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.anglelabs.alarmclock.redesign.utils.C0807e.C0730b;
import com.google.android.gms.location.LocationStatusCodes;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;
import com.p037b.p038a.C0673b;
import com.p037b.p038a.C1193a;
import com.p037b.p063c.C1237a;
import com.p037b.p063c.C1238b;

/* renamed from: com.anglelabs.alarmclock.redesign.utils.y */
public class C0868y implements OnTouchListener {
    private final int f2482a;
    private final int f2483b;
    private final int f2484c;
    private final long f2485d;
    private final ListView f2486e;
    private final C0670a f2487f;
    private int f2488g;
    private boolean f2489h;
    private boolean f2490i;
    private float f2491j;
    private float f2492k;
    private boolean f2493l;
    private VelocityTracker f2494m;
    private int f2495n;
    private View f2496o;
    private boolean f2497p;
    private int f2498q;
    private boolean f2499r;
    private int f2500s;
    private boolean f2501t;

    /* renamed from: com.anglelabs.alarmclock.redesign.utils.y.a */
    public interface C0670a {
        void m3033a(int i);

        void m3034a(View view, int i);

        void m3035a(boolean z);

        boolean m3036b(int i);

        boolean m3037c(int i);
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.utils.y.1 */
    class C08621 implements OnScrollListener {
        final /* synthetic */ C0868y f2471a;

        C08621(C0868y c0868y) {
            this.f2471a = c0868y;
        }

        public void onScrollStateChanged(AbsListView absListView, int scrollState) {
            this.f2471a.m4056a(scrollState != 1);
            if (scrollState == 2) {
                this.f2471a.f2487f.m3035a(true);
                this.f2471a.f2501t = true;
                return;
            }
            this.f2471a.f2487f.m3035a(false);
            this.f2471a.f2501t = false;
        }

        public void onScroll(AbsListView absListView, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.utils.y.2 */
    class C08632 extends C0673b {
        final /* synthetic */ C0868y f2472a;

        C08632(C0868y c0868y) {
            this.f2472a = c0868y;
        }

        public void m4047a(C1193a animation) {
            C0868y.m4053b(this.f2472a);
            this.f2472a.f2487f.m3035a(false);
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.utils.y.3 */
    class C08643 implements AnimatorListener {
        final /* synthetic */ C0868y f2473a;

        C08643(C0868y c0868y) {
            this.f2473a = c0868y;
        }

        public void onAnimationStart(Animator animation) {
        }

        public void onAnimationRepeat(Animator animation) {
        }

        public void onAnimationEnd(Animator animation) {
            C0868y.m4053b(this.f2473a);
            this.f2473a.f2487f.m3035a(false);
        }

        public void onAnimationCancel(Animator animation) {
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.utils.y.4 */
    class C08654 implements Runnable {
        final /* synthetic */ C0868y f2474a;

        C08654(C0868y c0868y) {
            this.f2474a = c0868y;
        }

        public void run() {
            C0868y.m4053b(this.f2474a);
            if (!this.f2474a.f2501t) {
                this.f2474a.f2487f.m3035a(false);
            }
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.utils.y.5 */
    class C08665 extends C0730b {
        final /* synthetic */ boolean[] f2475a;
        final /* synthetic */ View f2476b;
        final /* synthetic */ int f2477c;
        final /* synthetic */ C0868y f2478d;

        C08665(C0868y c0868y, boolean[] zArr, View view, int i) {
            this.f2478d = c0868y;
            this.f2475a = zArr;
            this.f2476b = view;
            this.f2477c = i;
        }

        public void m4048a(C1193a animation) {
            if (!this.f2475a[0]) {
                C0868y.m4053b(this.f2478d);
                this.f2478d.f2487f.m3035a(false);
                this.f2478d.f2487f.m3034a(this.f2476b, this.f2477c);
                this.f2475a[0] = true;
            }
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.utils.y.6 */
    class C08676 extends C0730b {
        final /* synthetic */ boolean[] f2479a;
        final /* synthetic */ int f2480b;
        final /* synthetic */ C0868y f2481c;

        C08676(C0868y c0868y, boolean[] zArr, int i) {
            this.f2481c = c0868y;
            this.f2479a = zArr;
            this.f2480b = i;
        }

        public void m4049a(C1193a animation) {
            if (!this.f2479a[0]) {
                C0868y.m4053b(this.f2481c);
                this.f2481c.f2487f.m3035a(false);
                this.f2481c.f2487f.m3033a(this.f2480b);
                this.f2479a[0] = true;
            }
        }
    }

    static /* synthetic */ int m4053b(C0868y x0) {
        int i = x0.f2500s - 1;
        x0.f2500s = i;
        return i;
    }

    public C0868y(ListView listView, C0670a callbacks) {
        this.f2488g = 1;
        this.f2489h = false;
        this.f2490i = false;
        this.f2499r = false;
        this.f2500s = 0;
        this.f2501t = false;
        ViewConfiguration vc = ViewConfiguration.get(listView.getContext());
        this.f2482a = vc.getScaledTouchSlop();
        this.f2483b = vc.getScaledMinimumFlingVelocity() * 16;
        this.f2484c = vc.getScaledMaximumFlingVelocity();
        this.f2485d = (long) listView.getContext().getResources().getInteger(17694721);
        this.f2486e = listView;
        this.f2487f = callbacks;
        if (VERSION.SDK_INT < 12) {
            this.f2489h = true;
        } else if (VERSION.SDK_INT < 16) {
            this.f2490i = true;
        }
    }

    public void m4056a(boolean enabled) {
        this.f2497p = !enabled;
    }

    public OnScrollListener m4055a() {
        return new C08621(this);
    }

    @SuppressLint({"NewApi"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int i = this.f2488g;
        if (r0 < 2) {
            this.f2488g = this.f2486e.getWidth();
        }
        float deltaX;
        switch (motionEvent.getActionMasked()) {
            case Base64.DEFAULT /*0*/:
                if (this.f2497p || this.f2500s > 0) {
                    return false;
                }
                Rect rect = new Rect();
                int childCount = this.f2486e.getChildCount();
                int[] listViewCoords = new int[2];
                this.f2486e.getLocationOnScreen(listViewCoords);
                int x = ((int) motionEvent.getRawX()) - listViewCoords[0];
                int y = ((int) motionEvent.getRawY()) - listViewCoords[1];
                for (int i2 = 0; i2 < childCount; i2++) {
                    View child = this.f2486e.getChildAt(i2);
                    child.getHitRect(rect);
                    if (rect.contains(x, y)) {
                        this.f2496o = child;
                        if (this.f2496o != null) {
                            if (this.f2486e.getAdapter().getCount() > 0) {
                                if (this.f2496o.getParent() != null) {
                                    this.f2491j = motionEvent.getRawX();
                                    this.f2492k = motionEvent.getRawY();
                                    this.f2495n = this.f2486e.getPositionForView(this.f2496o);
                                    if (this.f2487f.m3037c(this.f2495n)) {
                                        this.f2496o = null;
                                    } else {
                                        this.f2494m = VelocityTracker.obtain();
                                        this.f2494m.addMovement(motionEvent);
                                    }
                                }
                            }
                        }
                        return false;
                    }
                }
                if (this.f2496o != null) {
                    if (this.f2486e.getAdapter().getCount() > 0) {
                        if (this.f2496o.getParent() != null) {
                            this.f2491j = motionEvent.getRawX();
                            this.f2492k = motionEvent.getRawY();
                            this.f2495n = this.f2486e.getPositionForView(this.f2496o);
                            if (this.f2487f.m3037c(this.f2495n)) {
                                this.f2496o = null;
                            } else {
                                this.f2494m = VelocityTracker.obtain();
                                this.f2494m.addMovement(motionEvent);
                            }
                        }
                    }
                }
                return false;
            case Base64.NO_PADDING /*1*/:
                if (this.f2494m != null) {
                    deltaX = motionEvent.getRawX() - this.f2491j;
                    this.f2494m.addMovement(motionEvent);
                    this.f2494m.computeCurrentVelocity(LocationStatusCodes.GEOFENCE_NOT_AVAILABLE);
                    float velocityX = this.f2494m.getXVelocity();
                    float absVelocityX = Math.abs(velocityX);
                    float absVelocityY = Math.abs(this.f2494m.getYVelocity());
                    boolean dismiss = false;
                    boolean dismissRight = false;
                    this.f2499r = false;
                    if (Math.abs(deltaX) <= ((float) (this.f2488g / 2)) || !this.f2493l) {
                        if (((float) this.f2483b) <= absVelocityX) {
                            if (absVelocityX <= ((float) this.f2484c) && absVelocityY < absVelocityX && this.f2493l) {
                                dismiss = ((velocityX > 0.0f ? 1 : (velocityX == 0.0f ? 0 : -1)) < 0 ? 1 : null) == ((deltaX > 0.0f ? 1 : (deltaX == 0.0f ? 0 : -1)) < 0 ? 1 : null);
                                dismissRight = this.f2494m.getXVelocity() > 0.0f;
                            }
                        }
                    } else {
                        dismiss = true;
                        dismissRight = deltaX > 0.0f;
                    }
                    this.f2487f.m3035a(true);
                    if (dismiss) {
                        i = this.f2495n;
                        if (r0 != -1) {
                            this.f2500s++;
                            m4051a(this.f2496o, this.f2495n, dismissRight);
                            this.f2494m.recycle();
                            this.f2494m = null;
                            this.f2491j = 0.0f;
                            this.f2492k = 0.0f;
                            this.f2496o = null;
                            this.f2495n = -1;
                            this.f2493l = false;
                            break;
                        }
                    }
                    this.f2500s++;
                    if (this.f2489h) {
                        C1238b.m5284a(this.f2496o).m5290b(0.0f).m5294f(1.0f).m5292d(1.0f).m5293e(1.0f).m5287a(new OvershootInterpolator(Math.min(deltaX >= 0.0f ? deltaX / 80.0f : (-deltaX) / 80.0f, 3.5f))).m5285a(0.0f).m5286a((long) ((((float) this.f2485d) / 1.4f) + (Math.abs(deltaX) / ((float) this.f2488g)))).m5288a(new C08632(this));
                    } else if (this.f2490i) {
                        this.f2496o.animate().translationX(0.0f).alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setInterpolator(new OvershootInterpolator(Math.min(deltaX >= 0.0f ? deltaX / 80.0f : (-deltaX) / 80.0f, 3.5f))).rotation(0.0f).setDuration((long) ((((float) this.f2485d) / 1.4f) + (Math.abs(deltaX) / ((float) this.f2488g)))).setListener(new C08643(this));
                    } else {
                        this.f2496o.animate().translationX(0.0f).alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setInterpolator(new OvershootInterpolator(Math.min(deltaX >= 0.0f ? deltaX / 80.0f : (-deltaX) / 80.0f, 3.5f))).rotation(0.0f).setDuration((long) ((((float) this.f2485d) / 1.4f) + (Math.abs(deltaX) / ((float) this.f2488g)))).withEndAction(new C08654(this));
                    }
                    this.f2494m.recycle();
                    this.f2494m = null;
                    this.f2491j = 0.0f;
                    this.f2492k = 0.0f;
                    this.f2496o = null;
                    this.f2495n = -1;
                    this.f2493l = false;
                }
                break;
            case Base64.NO_WRAP /*2*/:
                if (!(this.f2494m == null || this.f2497p)) {
                    this.f2494m.addMovement(motionEvent);
                    deltaX = motionEvent.getRawX() - this.f2491j;
                    float deltaY = motionEvent.getRawY() - this.f2492k;
                    if (Math.abs(deltaX) > ((float) this.f2482a) && Math.abs(deltaY) < Math.abs(deltaX) / 2.0f) {
                        int mSwipingSlop;
                        this.f2493l = true;
                        if (deltaX > 0.0f) {
                            mSwipingSlop = this.f2482a;
                        } else {
                            mSwipingSlop = -this.f2482a;
                        }
                        if (!this.f2499r) {
                            this.f2498q = mSwipingSlop;
                            this.f2499r = true;
                        }
                        this.f2486e.requestDisallowInterceptTouchEvent(true);
                        MotionEvent cancelEvent = MotionEvent.obtain(motionEvent);
                        cancelEvent.setAction((motionEvent.getActionIndex() << 8) | 3);
                        this.f2486e.onTouchEvent(cancelEvent);
                        cancelEvent.recycle();
                    }
                    if (this.f2493l) {
                        if (this.f2489h) {
                            C1237a.m5282e(this.f2496o, deltaX - ((float) this.f2498q));
                            C1237a.m5278a(this.f2496o, Math.max(0.0f, Math.min(1.0f, 1.0f - ((1.2f * Math.abs(deltaX - ((float) this.f2498q))) / ((float) this.f2488g)))));
                            C1237a.m5280c(this.f2496o, 1.0f - (1.05f * ((Math.abs(deltaX - ((float) this.f2498q)) / ((float) this.f2488g)) / 1.5f)));
                            C1237a.m5281d(this.f2496o, 1.0f - (1.05f * ((Math.abs(deltaX - ((float) this.f2498q)) / ((float) this.f2488g)) / 1.5f)));
                            C1237a.m5279b(this.f2496o, (float) Math.pow((double) ((deltaX - ((float) this.f2498q)) / ((float) (this.f2488g / 4))), 3.0d));
                        } else {
                            this.f2496o.setTranslationX(deltaX - ((float) this.f2498q));
                            this.f2496o.setAlpha(Math.max(0.0f, Math.min(1.0f, 1.0f - ((1.2f * Math.abs(deltaX - ((float) this.f2498q))) / ((float) this.f2488g)))));
                            this.f2496o.setScaleX(1.0f - (1.05f * ((Math.abs(deltaX - ((float) this.f2498q)) / ((float) this.f2488g)) / 1.5f)));
                            this.f2496o.setScaleY(1.0f - (1.05f * ((Math.abs(deltaX - ((float) this.f2498q)) / ((float) this.f2488g)) / 1.5f)));
                            this.f2496o.setRotation((float) Math.pow((double) ((deltaX - ((float) this.f2498q)) / ((float) (this.f2488g / 4))), 3.0d));
                        }
                        return true;
                    }
                }
                break;
            case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                if (this.f2494m != null) {
                    if (this.f2493l && this.f2496o != null) {
                        if (this.f2489h) {
                            C1238b.m5284a(this.f2496o).m5290b(0.0f).m5294f(1.0f).m5292d(1.0f).m5293e(1.0f).m5285a(0.0f).m5286a(this.f2485d).m5288a(null);
                        } else {
                            this.f2496o.animate().translationX(0.0f).alpha(1.0f).scaleX(1.0f).scaleY(1.0f).rotation(0.0f).setDuration(this.f2485d).setListener(null);
                        }
                    }
                    this.f2494m.recycle();
                    this.f2494m = null;
                    this.f2491j = 0.0f;
                    this.f2492k = 0.0f;
                    this.f2496o = null;
                    this.f2495n = -1;
                    this.f2493l = false;
                    this.f2499r = false;
                    break;
                }
                break;
        }
        return false;
    }

    @SuppressLint({"NewApi"})
    private void m4051a(View view, int position, boolean dismissRight) {
        if (view == null) {
            this.f2500s--;
            this.f2487f.m3035a(false);
            this.f2487f.m3034a(null, position);
            return;
        }
        boolean[] handlingFinished = new boolean[]{false};
        Context context = view.getContext();
        if (this.f2487f.m3036b(position)) {
            C0807e.m3811a(view, dismissRight, (long) (((double) this.f2485d) / 1.5d), new C08665(this, handlingFinished, view, position)).m5289a();
        } else {
            C0807e.m3817b(view, dismissRight, (long) (((double) this.f2485d) / 1.5d), new C08676(this, handlingFinished, position)).m5289a();
        }
    }
}
