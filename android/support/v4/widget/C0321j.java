package android.support.v4.widget;

import android.content.Context;
import android.support.v4.view.C0247m;
import android.support.v4.view.C0252p;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import com.google.android.gms.location.LocationStatusCodes;
import java.util.Arrays;

/* renamed from: android.support.v4.widget.j */
public class C0321j {
    private static final Interpolator f588v;
    private int f589a;
    private int f590b;
    private int f591c;
    private float[] f592d;
    private float[] f593e;
    private float[] f594f;
    private float[] f595g;
    private int[] f596h;
    private int[] f597i;
    private int[] f598j;
    private int f599k;
    private VelocityTracker f600l;
    private float f601m;
    private float f602n;
    private int f603o;
    private int f604p;
    private C0317h f605q;
    private final C0287a f606r;
    private View f607s;
    private boolean f608t;
    private final ViewGroup f609u;
    private final Runnable f610w;

    /* renamed from: android.support.v4.widget.j.a */
    public static abstract class C0287a {
        public abstract boolean m1220a(View view, int i);

        public void m1216a(int state) {
        }

        public void m1219a(View changedView, int left, int top, int dx, int dy) {
        }

        public void m1224b(View capturedChild, int activePointerId) {
        }

        public void m1218a(View releasedChild, float xvel, float yvel) {
        }

        public void m1217a(int edgeFlags, int pointerId) {
        }

        public boolean m1225b(int edgeFlags) {
            return false;
        }

        public void m1223b(int edgeFlags, int pointerId) {
        }

        public int m1226c(int index) {
            return index;
        }

        public int m1214a(View child) {
            return 0;
        }

        public int m1221b(View child) {
            return 0;
        }

        public int m1215a(View child, int left, int dx) {
            return 0;
        }

        public int m1222b(View child, int top, int dy) {
            return 0;
        }
    }

    /* renamed from: android.support.v4.widget.j.1 */
    static class C03191 implements Interpolator {
        C03191() {
        }

        public float getInterpolation(float t) {
            t -= 1.0f;
            return ((((t * t) * t) * t) * t) + 1.0f;
        }
    }

    /* renamed from: android.support.v4.widget.j.2 */
    class C03202 implements Runnable {
        final /* synthetic */ C0321j f587a;

        C03202(C0321j c0321j) {
            this.f587a = c0321j;
        }

        public void run() {
            this.f587a.m1427c(0);
        }
    }

    static {
        f588v = new C03191();
    }

    public static C0321j m1396a(ViewGroup forParent, C0287a cb) {
        return new C0321j(forParent.getContext(), forParent, cb);
    }

    public static C0321j m1395a(ViewGroup forParent, float sensitivity, C0287a cb) {
        C0321j helper = C0321j.m1396a(forParent, cb);
        helper.f590b = (int) (((float) helper.f590b) * (1.0f / sensitivity));
        return helper;
    }

    private C0321j(Context context, ViewGroup forParent, C0287a cb) {
        this.f591c = -1;
        this.f610w = new C03202(this);
        if (forParent == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (cb == null) {
            throw new IllegalArgumentException("Callback may not be null");
        } else {
            this.f609u = forParent;
            this.f606r = cb;
            ViewConfiguration vc = ViewConfiguration.get(context);
            this.f603o = (int) ((20.0f * context.getResources().getDisplayMetrics().density) + 0.5f);
            this.f590b = vc.getScaledTouchSlop();
            this.f601m = (float) vc.getScaledMaximumFlingVelocity();
            this.f602n = (float) vc.getScaledMinimumFlingVelocity();
            this.f605q = C0317h.m1376a(context, f588v);
        }
    }

    public void m1413a(float minVel) {
        this.f602n = minVel;
    }

    public int m1412a() {
        return this.f589a;
    }

    public void m1414a(int edgeFlags) {
        this.f604p = edgeFlags;
    }

    public int m1420b() {
        return this.f603o;
    }

    public void m1415a(View childView, int activePointerId) {
        if (childView.getParent() != this.f609u) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f609u + ")");
        }
        this.f607s = childView;
        this.f591c = activePointerId;
        this.f606r.m1224b(childView, activePointerId);
        m1427c(1);
    }

    public View m1426c() {
        return this.f607s;
    }

    public int m1429d() {
        return this.f590b;
    }

    public void m1432e() {
        this.f591c = -1;
        m1410g();
        if (this.f600l != null) {
            this.f600l.recycle();
            this.f600l = null;
        }
    }

    public void m1433f() {
        m1432e();
        if (this.f589a == 2) {
            int oldX = this.f605q.m1377a();
            int oldY = this.f605q.m1379b();
            this.f605q.m1383f();
            int newX = this.f605q.m1377a();
            int newY = this.f605q.m1379b();
            this.f606r.m1219a(this.f607s, newX, newY, newX - oldX, newY - oldY);
        }
        m1427c(0);
    }

    public boolean m1418a(View child, int finalLeft, int finalTop) {
        this.f607s = child;
        this.f591c = -1;
        boolean continueSliding = m1400a(finalLeft, finalTop, 0, 0);
        if (!(continueSliding || this.f589a != 0 || this.f607s == null)) {
            this.f607s = null;
        }
        return continueSliding;
    }

    public boolean m1416a(int finalLeft, int finalTop) {
        if (this.f608t) {
            return m1400a(finalLeft, finalTop, (int) C0252p.m1100a(this.f600l, this.f591c), (int) C0252p.m1101b(this.f600l, this.f591c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    private boolean m1400a(int finalLeft, int finalTop, int xvel, int yvel) {
        int startLeft = this.f607s.getLeft();
        int startTop = this.f607s.getTop();
        int dx = finalLeft - startLeft;
        int dy = finalTop - startTop;
        if (dx == 0 && dy == 0) {
            this.f605q.m1383f();
            m1427c(0);
            return false;
        }
        this.f605q.m1378a(startLeft, startTop, dx, dy, m1394a(this.f607s, dx, dy, xvel, yvel));
        m1427c(2);
        return true;
    }

    private int m1394a(View child, int dx, int dy, int xvel, int yvel) {
        xvel = m1403b(xvel, (int) this.f602n, (int) this.f601m);
        yvel = m1403b(yvel, (int) this.f602n, (int) this.f601m);
        int absDx = Math.abs(dx);
        int absDy = Math.abs(dy);
        int absXVel = Math.abs(xvel);
        int absYVel = Math.abs(yvel);
        int addedVel = absXVel + absYVel;
        int addedDistance = absDx + absDy;
        return (int) ((((float) m1393a(dx, xvel, this.f606r.m1214a(child))) * (xvel != 0 ? ((float) absXVel) / ((float) addedVel) : ((float) absDx) / ((float) addedDistance))) + (((float) m1393a(dy, yvel, this.f606r.m1221b(child))) * (yvel != 0 ? ((float) absYVel) / ((float) addedVel) : ((float) absDy) / ((float) addedDistance))));
    }

    private int m1393a(int delta, int velocity, int motionRange) {
        if (delta == 0) {
            return 0;
        }
        int duration;
        int width = this.f609u.getWidth();
        int halfWidth = width / 2;
        float distance = ((float) halfWidth) + (((float) halfWidth) * m1402b(Math.min(1.0f, ((float) Math.abs(delta)) / ((float) width))));
        velocity = Math.abs(velocity);
        if (velocity > 0) {
            duration = Math.round(1000.0f * Math.abs(distance / ((float) velocity))) * 4;
        } else {
            duration = (int) (((((float) Math.abs(delta)) / ((float) motionRange)) + 1.0f) * 256.0f);
        }
        return Math.min(duration, 600);
    }

    private int m1403b(int value, int absMin, int absMax) {
        int absValue = Math.abs(value);
        if (absValue < absMin) {
            return 0;
        }
        if (absValue <= absMax) {
            return value;
        }
        if (value <= 0) {
            return -absMax;
        }
        return absMax;
    }

    private float m1392a(float value, float absMin, float absMax) {
        float absValue = Math.abs(value);
        if (absValue < absMin) {
            return 0.0f;
        }
        if (absValue <= absMax) {
            return value;
        }
        if (value <= 0.0f) {
            return -absMax;
        }
        return absMax;
    }

    private float m1402b(float f) {
        return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
    }

    public boolean m1419a(boolean deferCallbacks) {
        if (this.f589a == 2) {
            boolean keepGoing = this.f605q.m1382e();
            int x = this.f605q.m1377a();
            int y = this.f605q.m1379b();
            int dx = x - this.f607s.getLeft();
            int dy = y - this.f607s.getTop();
            if (dx != 0) {
                this.f607s.offsetLeftAndRight(dx);
            }
            if (dy != 0) {
                this.f607s.offsetTopAndBottom(dy);
            }
            if (!(dx == 0 && dy == 0)) {
                this.f606r.m1219a(this.f607s, x, y, dx, dy);
            }
            if (keepGoing && x == this.f605q.m1380c() && y == this.f605q.m1381d()) {
                this.f605q.m1383f();
                keepGoing = false;
            }
            if (!keepGoing) {
                if (deferCallbacks) {
                    this.f609u.post(this.f610w);
                } else {
                    m1427c(0);
                }
            }
        }
        return this.f589a == 2;
    }

    private void m1397a(float xvel, float yvel) {
        this.f608t = true;
        this.f606r.m1218a(this.f607s, xvel, yvel);
        this.f608t = false;
        if (this.f589a == 1) {
            m1427c(0);
        }
    }

    private void m1410g() {
        if (this.f592d != null) {
            Arrays.fill(this.f592d, 0.0f);
            Arrays.fill(this.f593e, 0.0f);
            Arrays.fill(this.f594f, 0.0f);
            Arrays.fill(this.f595g, 0.0f);
            Arrays.fill(this.f596h, 0);
            Arrays.fill(this.f597i, 0);
            Arrays.fill(this.f598j, 0);
            this.f599k = 0;
        }
    }

    private void m1408e(int pointerId) {
        if (this.f592d != null) {
            this.f592d[pointerId] = 0.0f;
            this.f593e[pointerId] = 0.0f;
            this.f594f[pointerId] = 0.0f;
            this.f595g[pointerId] = 0.0f;
            this.f596h[pointerId] = 0;
            this.f597i[pointerId] = 0;
            this.f598j[pointerId] = 0;
            this.f599k &= (1 << pointerId) ^ -1;
        }
    }

    private void m1409f(int pointerId) {
        if (this.f592d == null || this.f592d.length <= pointerId) {
            float[] imx = new float[(pointerId + 1)];
            float[] imy = new float[(pointerId + 1)];
            float[] lmx = new float[(pointerId + 1)];
            float[] lmy = new float[(pointerId + 1)];
            int[] iit = new int[(pointerId + 1)];
            int[] edip = new int[(pointerId + 1)];
            int[] edl = new int[(pointerId + 1)];
            if (this.f592d != null) {
                System.arraycopy(this.f592d, 0, imx, 0, this.f592d.length);
                System.arraycopy(this.f593e, 0, imy, 0, this.f593e.length);
                System.arraycopy(this.f594f, 0, lmx, 0, this.f594f.length);
                System.arraycopy(this.f595g, 0, lmy, 0, this.f595g.length);
                System.arraycopy(this.f596h, 0, iit, 0, this.f596h.length);
                System.arraycopy(this.f597i, 0, edip, 0, this.f597i.length);
                System.arraycopy(this.f598j, 0, edl, 0, this.f598j.length);
            }
            this.f592d = imx;
            this.f593e = imy;
            this.f594f = lmx;
            this.f595g = lmy;
            this.f596h = iit;
            this.f597i = edip;
            this.f598j = edl;
        }
    }

    private void m1398a(float x, float y, int pointerId) {
        m1409f(pointerId);
        float[] fArr = this.f592d;
        this.f594f[pointerId] = x;
        fArr[pointerId] = x;
        fArr = this.f593e;
        this.f595g[pointerId] = y;
        fArr[pointerId] = y;
        this.f596h[pointerId] = m1407e((int) x, (int) y);
        this.f599k |= 1 << pointerId;
    }

    private void m1406c(MotionEvent ev) {
        int pointerCount = C0247m.m1087c(ev);
        for (int i = 0; i < pointerCount; i++) {
            int pointerId = C0247m.m1085b(ev, i);
            float x = C0247m.m1086c(ev, i);
            float y = C0247m.m1088d(ev, i);
            this.f594f[pointerId] = x;
            this.f595g[pointerId] = y;
        }
    }

    public boolean m1422b(int pointerId) {
        return (this.f599k & (1 << pointerId)) != 0;
    }

    void m1427c(int state) {
        if (this.f589a != state) {
            this.f589a = state;
            this.f606r.m1216a(state);
            if (this.f589a == 0) {
                this.f607s = null;
            }
        }
    }

    boolean m1424b(View toCapture, int pointerId) {
        if (toCapture == this.f607s && this.f591c == pointerId) {
            return true;
        }
        if (toCapture == null || !this.f606r.m1220a(toCapture, pointerId)) {
            return false;
        }
        this.f591c = pointerId;
        m1415a(toCapture, pointerId);
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean m1417a(android.view.MotionEvent r27) {
        /*
        r26 = this;
        r4 = android.support.v4.view.C0247m.m1082a(r27);
        r5 = android.support.v4.view.C0247m.m1084b(r27);
        if (r4 != 0) goto L_0x000d;
    L_0x000a:
        r26.m1432e();
    L_0x000d:
        r0 = r26;
        r0 = r0.f600l;
        r24 = r0;
        if (r24 != 0) goto L_0x001f;
    L_0x0015:
        r24 = android.view.VelocityTracker.obtain();
        r0 = r24;
        r1 = r26;
        r1.f600l = r0;
    L_0x001f:
        r0 = r26;
        r0 = r0.f600l;
        r24 = r0;
        r0 = r24;
        r1 = r27;
        r0.addMovement(r1);
        switch(r4) {
            case 0: goto L_0x0040;
            case 1: goto L_0x023b;
            case 2: goto L_0x0148;
            case 3: goto L_0x023b;
            case 4: goto L_0x002f;
            case 5: goto L_0x00bf;
            case 6: goto L_0x022c;
            default: goto L_0x002f;
        };
    L_0x002f:
        r0 = r26;
        r0 = r0.f589a;
        r24 = r0;
        r25 = 1;
        r0 = r24;
        r1 = r25;
        if (r0 != r1) goto L_0x0240;
    L_0x003d:
        r24 = 1;
    L_0x003f:
        return r24;
    L_0x0040:
        r22 = r27.getX();
        r23 = r27.getY();
        r24 = 0;
        r0 = r27;
        r1 = r24;
        r17 = android.support.v4.view.C0247m.m1085b(r0, r1);
        r0 = r26;
        r1 = r22;
        r2 = r23;
        r3 = r17;
        r0.m1398a(r1, r2, r3);
        r0 = r22;
        r0 = (int) r0;
        r24 = r0;
        r0 = r23;
        r0 = (int) r0;
        r25 = r0;
        r0 = r26;
        r1 = r24;
        r2 = r25;
        r20 = r0.m1430d(r1, r2);
        r0 = r26;
        r0 = r0.f607s;
        r24 = r0;
        r0 = r20;
        r1 = r24;
        if (r0 != r1) goto L_0x0094;
    L_0x007d:
        r0 = r26;
        r0 = r0.f589a;
        r24 = r0;
        r25 = 2;
        r0 = r24;
        r1 = r25;
        if (r0 != r1) goto L_0x0094;
    L_0x008b:
        r0 = r26;
        r1 = r20;
        r2 = r17;
        r0.m1424b(r1, r2);
    L_0x0094:
        r0 = r26;
        r0 = r0.f596h;
        r24 = r0;
        r8 = r24[r17];
        r0 = r26;
        r0 = r0.f604p;
        r24 = r0;
        r24 = r24 & r8;
        if (r24 == 0) goto L_0x002f;
    L_0x00a6:
        r0 = r26;
        r0 = r0.f606r;
        r24 = r0;
        r0 = r26;
        r0 = r0.f604p;
        r25 = r0;
        r25 = r25 & r8;
        r0 = r24;
        r1 = r25;
        r2 = r17;
        r0.m1217a(r1, r2);
        goto L_0x002f;
    L_0x00bf:
        r0 = r27;
        r17 = android.support.v4.view.C0247m.m1085b(r0, r5);
        r0 = r27;
        r22 = android.support.v4.view.C0247m.m1086c(r0, r5);
        r0 = r27;
        r23 = android.support.v4.view.C0247m.m1088d(r0, r5);
        r0 = r26;
        r1 = r22;
        r2 = r23;
        r3 = r17;
        r0.m1398a(r1, r2, r3);
        r0 = r26;
        r0 = r0.f589a;
        r24 = r0;
        if (r24 != 0) goto L_0x010f;
    L_0x00e4:
        r0 = r26;
        r0 = r0.f596h;
        r24 = r0;
        r8 = r24[r17];
        r0 = r26;
        r0 = r0.f604p;
        r24 = r0;
        r24 = r24 & r8;
        if (r24 == 0) goto L_0x002f;
    L_0x00f6:
        r0 = r26;
        r0 = r0.f606r;
        r24 = r0;
        r0 = r26;
        r0 = r0.f604p;
        r25 = r0;
        r25 = r25 & r8;
        r0 = r24;
        r1 = r25;
        r2 = r17;
        r0.m1217a(r1, r2);
        goto L_0x002f;
    L_0x010f:
        r0 = r26;
        r0 = r0.f589a;
        r24 = r0;
        r25 = 2;
        r0 = r24;
        r1 = r25;
        if (r0 != r1) goto L_0x002f;
    L_0x011d:
        r0 = r22;
        r0 = (int) r0;
        r24 = r0;
        r0 = r23;
        r0 = (int) r0;
        r25 = r0;
        r0 = r26;
        r1 = r24;
        r2 = r25;
        r20 = r0.m1430d(r1, r2);
        r0 = r26;
        r0 = r0.f607s;
        r24 = r0;
        r0 = r20;
        r1 = r24;
        if (r0 != r1) goto L_0x002f;
    L_0x013d:
        r0 = r26;
        r1 = r20;
        r2 = r17;
        r0.m1424b(r1, r2);
        goto L_0x002f;
    L_0x0148:
        r16 = android.support.v4.view.C0247m.m1087c(r27);
        r10 = 0;
    L_0x014d:
        r0 = r16;
        if (r10 >= r0) goto L_0x01fe;
    L_0x0151:
        r0 = r27;
        r17 = android.support.v4.view.C0247m.m1085b(r0, r10);
        r0 = r27;
        r22 = android.support.v4.view.C0247m.m1086c(r0, r10);
        r0 = r27;
        r23 = android.support.v4.view.C0247m.m1088d(r0, r10);
        r0 = r26;
        r0 = r0.f592d;
        r24 = r0;
        r24 = r24[r17];
        r6 = r22 - r24;
        r0 = r26;
        r0 = r0.f593e;
        r24 = r0;
        r24 = r24[r17];
        r7 = r23 - r24;
        r0 = r22;
        r0 = (int) r0;
        r24 = r0;
        r0 = r23;
        r0 = (int) r0;
        r25 = r0;
        r0 = r26;
        r1 = r24;
        r2 = r25;
        r20 = r0.m1430d(r1, r2);
        if (r20 == 0) goto L_0x0203;
    L_0x018d:
        r0 = r26;
        r1 = r20;
        r24 = r0.m1401a(r1, r6, r7);
        if (r24 == 0) goto L_0x0203;
    L_0x0197:
        r15 = 1;
    L_0x0198:
        if (r15 == 0) goto L_0x0205;
    L_0x019a:
        r13 = r20.getLeft();
        r0 = (int) r6;
        r24 = r0;
        r18 = r13 + r24;
        r0 = r26;
        r0 = r0.f606r;
        r24 = r0;
        r0 = (int) r6;
        r25 = r0;
        r0 = r24;
        r1 = r20;
        r2 = r18;
        r3 = r25;
        r11 = r0.m1215a(r1, r2, r3);
        r14 = r20.getTop();
        r0 = (int) r7;
        r24 = r0;
        r19 = r14 + r24;
        r0 = r26;
        r0 = r0.f606r;
        r24 = r0;
        r0 = (int) r7;
        r25 = r0;
        r0 = r24;
        r1 = r20;
        r2 = r19;
        r3 = r25;
        r12 = r0.m1222b(r1, r2, r3);
        r0 = r26;
        r0 = r0.f606r;
        r24 = r0;
        r0 = r24;
        r1 = r20;
        r9 = r0.m1214a(r1);
        r0 = r26;
        r0 = r0.f606r;
        r24 = r0;
        r0 = r24;
        r1 = r20;
        r21 = r0.m1221b(r1);
        if (r9 == 0) goto L_0x01f8;
    L_0x01f4:
        if (r9 <= 0) goto L_0x0205;
    L_0x01f6:
        if (r11 != r13) goto L_0x0205;
    L_0x01f8:
        if (r21 == 0) goto L_0x01fe;
    L_0x01fa:
        if (r21 <= 0) goto L_0x0205;
    L_0x01fc:
        if (r12 != r14) goto L_0x0205;
    L_0x01fe:
        r26.m1406c(r27);
        goto L_0x002f;
    L_0x0203:
        r15 = 0;
        goto L_0x0198;
    L_0x0205:
        r0 = r26;
        r1 = r17;
        r0.m1404b(r6, r7, r1);
        r0 = r26;
        r0 = r0.f589a;
        r24 = r0;
        r25 = 1;
        r0 = r24;
        r1 = r25;
        if (r0 == r1) goto L_0x01fe;
    L_0x021a:
        if (r15 == 0) goto L_0x0228;
    L_0x021c:
        r0 = r26;
        r1 = r20;
        r2 = r17;
        r24 = r0.m1424b(r1, r2);
        if (r24 != 0) goto L_0x01fe;
    L_0x0228:
        r10 = r10 + 1;
        goto L_0x014d;
    L_0x022c:
        r0 = r27;
        r17 = android.support.v4.view.C0247m.m1085b(r0, r5);
        r0 = r26;
        r1 = r17;
        r0.m1408e(r1);
        goto L_0x002f;
    L_0x023b:
        r26.m1432e();
        goto L_0x002f;
    L_0x0240:
        r24 = 0;
        goto L_0x003f;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.j.a(android.view.MotionEvent):boolean");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m1421b(android.view.MotionEvent r22) {
        /*
        r21 = this;
        r3 = android.support.v4.view.C0247m.m1082a(r22);
        r4 = android.support.v4.view.C0247m.m1084b(r22);
        if (r3 != 0) goto L_0x000d;
    L_0x000a:
        r21.m1432e();
    L_0x000d:
        r0 = r21;
        r0 = r0.f600l;
        r19 = r0;
        if (r19 != 0) goto L_0x001f;
    L_0x0015:
        r19 = android.view.VelocityTracker.obtain();
        r0 = r19;
        r1 = r21;
        r1.f600l = r0;
    L_0x001f:
        r0 = r21;
        r0 = r0.f600l;
        r19 = r0;
        r0 = r19;
        r1 = r22;
        r0.addMovement(r1);
        switch(r3) {
            case 0: goto L_0x0030;
            case 1: goto L_0x0287;
            case 2: goto L_0x011a;
            case 3: goto L_0x029d;
            case 4: goto L_0x002f;
            case 5: goto L_0x008e;
            case 6: goto L_0x01fe;
            default: goto L_0x002f;
        };
    L_0x002f:
        return;
    L_0x0030:
        r17 = r22.getX();
        r18 = r22.getY();
        r19 = 0;
        r0 = r22;
        r1 = r19;
        r15 = android.support.v4.view.C0247m.m1085b(r0, r1);
        r0 = r17;
        r0 = (int) r0;
        r19 = r0;
        r0 = r18;
        r0 = (int) r0;
        r20 = r0;
        r0 = r21;
        r1 = r19;
        r2 = r20;
        r16 = r0.m1430d(r1, r2);
        r0 = r21;
        r1 = r17;
        r2 = r18;
        r0.m1398a(r1, r2, r15);
        r0 = r21;
        r1 = r16;
        r0.m1424b(r1, r15);
        r0 = r21;
        r0 = r0.f596h;
        r19 = r0;
        r7 = r19[r15];
        r0 = r21;
        r0 = r0.f604p;
        r19 = r0;
        r19 = r19 & r7;
        if (r19 == 0) goto L_0x002f;
    L_0x0078:
        r0 = r21;
        r0 = r0.f606r;
        r19 = r0;
        r0 = r21;
        r0 = r0.f604p;
        r20 = r0;
        r20 = r20 & r7;
        r0 = r19;
        r1 = r20;
        r0.m1217a(r1, r15);
        goto L_0x002f;
    L_0x008e:
        r0 = r22;
        r15 = android.support.v4.view.C0247m.m1085b(r0, r4);
        r0 = r22;
        r17 = android.support.v4.view.C0247m.m1086c(r0, r4);
        r0 = r22;
        r18 = android.support.v4.view.C0247m.m1088d(r0, r4);
        r0 = r21;
        r1 = r17;
        r2 = r18;
        r0.m1398a(r1, r2, r15);
        r0 = r21;
        r0 = r0.f589a;
        r19 = r0;
        if (r19 != 0) goto L_0x00f5;
    L_0x00b1:
        r0 = r17;
        r0 = (int) r0;
        r19 = r0;
        r0 = r18;
        r0 = (int) r0;
        r20 = r0;
        r0 = r21;
        r1 = r19;
        r2 = r20;
        r16 = r0.m1430d(r1, r2);
        r0 = r21;
        r1 = r16;
        r0.m1424b(r1, r15);
        r0 = r21;
        r0 = r0.f596h;
        r19 = r0;
        r7 = r19[r15];
        r0 = r21;
        r0 = r0.f604p;
        r19 = r0;
        r19 = r19 & r7;
        if (r19 == 0) goto L_0x002f;
    L_0x00de:
        r0 = r21;
        r0 = r0.f606r;
        r19 = r0;
        r0 = r21;
        r0 = r0.f604p;
        r20 = r0;
        r20 = r20 & r7;
        r0 = r19;
        r1 = r20;
        r0.m1217a(r1, r15);
        goto L_0x002f;
    L_0x00f5:
        r0 = r17;
        r0 = (int) r0;
        r19 = r0;
        r0 = r18;
        r0 = (int) r0;
        r20 = r0;
        r0 = r21;
        r1 = r19;
        r2 = r20;
        r19 = r0.m1428c(r1, r2);
        if (r19 == 0) goto L_0x002f;
    L_0x010b:
        r0 = r21;
        r0 = r0.f607s;
        r19 = r0;
        r0 = r21;
        r1 = r19;
        r0.m1424b(r1, r15);
        goto L_0x002f;
    L_0x011a:
        r0 = r21;
        r0 = r0.f589a;
        r19 = r0;
        r20 = 1;
        r0 = r19;
        r1 = r20;
        if (r0 != r1) goto L_0x018e;
    L_0x0128:
        r0 = r21;
        r0 = r0.f591c;
        r19 = r0;
        r0 = r22;
        r1 = r19;
        r12 = android.support.v4.view.C0247m.m1083a(r0, r1);
        r0 = r22;
        r17 = android.support.v4.view.C0247m.m1086c(r0, r12);
        r0 = r22;
        r18 = android.support.v4.view.C0247m.m1088d(r0, r12);
        r0 = r21;
        r0 = r0.f594f;
        r19 = r0;
        r0 = r21;
        r0 = r0.f591c;
        r20 = r0;
        r19 = r19[r20];
        r19 = r17 - r19;
        r0 = r19;
        r10 = (int) r0;
        r0 = r21;
        r0 = r0.f595g;
        r19 = r0;
        r0 = r21;
        r0 = r0.f591c;
        r20 = r0;
        r19 = r19[r20];
        r19 = r18 - r19;
        r0 = r19;
        r11 = (int) r0;
        r0 = r21;
        r0 = r0.f607s;
        r19 = r0;
        r19 = r19.getLeft();
        r19 = r19 + r10;
        r0 = r21;
        r0 = r0.f607s;
        r20 = r0;
        r20 = r20.getTop();
        r20 = r20 + r11;
        r0 = r21;
        r1 = r19;
        r2 = r20;
        r0.m1405b(r1, r2, r10, r11);
        r21.m1406c(r22);
        goto L_0x002f;
    L_0x018e:
        r14 = android.support.v4.view.C0247m.m1087c(r22);
        r8 = 0;
    L_0x0193:
        if (r8 >= r14) goto L_0x01ce;
    L_0x0195:
        r0 = r22;
        r15 = android.support.v4.view.C0247m.m1085b(r0, r8);
        r0 = r22;
        r17 = android.support.v4.view.C0247m.m1086c(r0, r8);
        r0 = r22;
        r18 = android.support.v4.view.C0247m.m1088d(r0, r8);
        r0 = r21;
        r0 = r0.f592d;
        r19 = r0;
        r19 = r19[r15];
        r5 = r17 - r19;
        r0 = r21;
        r0 = r0.f593e;
        r19 = r0;
        r19 = r19[r15];
        r6 = r18 - r19;
        r0 = r21;
        r0.m1404b(r5, r6, r15);
        r0 = r21;
        r0 = r0.f589a;
        r19 = r0;
        r20 = 1;
        r0 = r19;
        r1 = r20;
        if (r0 != r1) goto L_0x01d3;
    L_0x01ce:
        r21.m1406c(r22);
        goto L_0x002f;
    L_0x01d3:
        r0 = r17;
        r0 = (int) r0;
        r19 = r0;
        r0 = r18;
        r0 = (int) r0;
        r20 = r0;
        r0 = r21;
        r1 = r19;
        r2 = r20;
        r16 = r0.m1430d(r1, r2);
        r0 = r21;
        r1 = r16;
        r19 = r0.m1401a(r1, r5, r6);
        if (r19 == 0) goto L_0x01fb;
    L_0x01f1:
        r0 = r21;
        r1 = r16;
        r19 = r0.m1424b(r1, r15);
        if (r19 != 0) goto L_0x01ce;
    L_0x01fb:
        r8 = r8 + 1;
        goto L_0x0193;
    L_0x01fe:
        r0 = r22;
        r15 = android.support.v4.view.C0247m.m1085b(r0, r4);
        r0 = r21;
        r0 = r0.f589a;
        r19 = r0;
        r20 = 1;
        r0 = r19;
        r1 = r20;
        if (r0 != r1) goto L_0x0280;
    L_0x0212:
        r0 = r21;
        r0 = r0.f591c;
        r19 = r0;
        r0 = r19;
        if (r15 != r0) goto L_0x0280;
    L_0x021c:
        r13 = -1;
        r14 = android.support.v4.view.C0247m.m1087c(r22);
        r8 = 0;
    L_0x0222:
        if (r8 >= r14) goto L_0x0277;
    L_0x0224:
        r0 = r22;
        r9 = android.support.v4.view.C0247m.m1085b(r0, r8);
        r0 = r21;
        r0 = r0.f591c;
        r19 = r0;
        r0 = r19;
        if (r9 != r0) goto L_0x0237;
    L_0x0234:
        r8 = r8 + 1;
        goto L_0x0222;
    L_0x0237:
        r0 = r22;
        r17 = android.support.v4.view.C0247m.m1086c(r0, r8);
        r0 = r22;
        r18 = android.support.v4.view.C0247m.m1088d(r0, r8);
        r0 = r17;
        r0 = (int) r0;
        r19 = r0;
        r0 = r18;
        r0 = (int) r0;
        r20 = r0;
        r0 = r21;
        r1 = r19;
        r2 = r20;
        r19 = r0.m1430d(r1, r2);
        r0 = r21;
        r0 = r0.f607s;
        r20 = r0;
        r0 = r19;
        r1 = r20;
        if (r0 != r1) goto L_0x0234;
    L_0x0263:
        r0 = r21;
        r0 = r0.f607s;
        r19 = r0;
        r0 = r21;
        r1 = r19;
        r19 = r0.m1424b(r1, r9);
        if (r19 == 0) goto L_0x0234;
    L_0x0273:
        r0 = r21;
        r13 = r0.f591c;
    L_0x0277:
        r19 = -1;
        r0 = r19;
        if (r13 != r0) goto L_0x0280;
    L_0x027d:
        r21.m1411h();
    L_0x0280:
        r0 = r21;
        r0.m1408e(r15);
        goto L_0x002f;
    L_0x0287:
        r0 = r21;
        r0 = r0.f589a;
        r19 = r0;
        r20 = 1;
        r0 = r19;
        r1 = r20;
        if (r0 != r1) goto L_0x0298;
    L_0x0295:
        r21.m1411h();
    L_0x0298:
        r21.m1432e();
        goto L_0x002f;
    L_0x029d:
        r0 = r21;
        r0 = r0.f589a;
        r19 = r0;
        r20 = 1;
        r0 = r19;
        r1 = r20;
        if (r0 != r1) goto L_0x02b8;
    L_0x02ab:
        r19 = 0;
        r20 = 0;
        r0 = r21;
        r1 = r19;
        r2 = r20;
        r0.m1397a(r1, r2);
    L_0x02b8:
        r21.m1432e();
        goto L_0x002f;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.j.b(android.view.MotionEvent):void");
    }

    private void m1404b(float dx, float dy, int pointerId) {
        int dragsStarted = 0;
        if (m1399a(dx, dy, pointerId, 1)) {
            dragsStarted = 0 | 1;
        }
        if (m1399a(dy, dx, pointerId, 4)) {
            dragsStarted |= 4;
        }
        if (m1399a(dx, dy, pointerId, 2)) {
            dragsStarted |= 2;
        }
        if (m1399a(dy, dx, pointerId, 8)) {
            dragsStarted |= 8;
        }
        if (dragsStarted != 0) {
            int[] iArr = this.f597i;
            iArr[pointerId] = iArr[pointerId] | dragsStarted;
            this.f606r.m1223b(dragsStarted, pointerId);
        }
    }

    private boolean m1399a(float delta, float odelta, int pointerId, int edge) {
        float absDelta = Math.abs(delta);
        float absODelta = Math.abs(odelta);
        if ((this.f596h[pointerId] & edge) != edge || (this.f604p & edge) == 0 || (this.f598j[pointerId] & edge) == edge || (this.f597i[pointerId] & edge) == edge) {
            return false;
        }
        if (absDelta <= ((float) this.f590b) && absODelta <= ((float) this.f590b)) {
            return false;
        }
        if (absDelta < 0.5f * absODelta && this.f606r.m1225b(edge)) {
            int[] iArr = this.f598j;
            iArr[pointerId] = iArr[pointerId] | edge;
            return false;
        } else if ((this.f597i[pointerId] & edge) != 0 || absDelta <= ((float) this.f590b)) {
            return false;
        } else {
            return true;
        }
    }

    private boolean m1401a(View child, float dx, float dy) {
        if (child == null) {
            return false;
        }
        boolean checkHorizontal;
        boolean checkVertical;
        if (this.f606r.m1214a(child) > 0) {
            checkHorizontal = true;
        } else {
            checkHorizontal = false;
        }
        if (this.f606r.m1221b(child) > 0) {
            checkVertical = true;
        } else {
            checkVertical = false;
        }
        if (checkHorizontal && checkVertical) {
            if ((dx * dx) + (dy * dy) <= ((float) (this.f590b * this.f590b))) {
                return false;
            }
            return true;
        } else if (checkHorizontal) {
            if (Math.abs(dx) <= ((float) this.f590b)) {
                return false;
            }
            return true;
        } else if (!checkVertical) {
            return false;
        } else {
            if (Math.abs(dy) <= ((float) this.f590b)) {
                return false;
            }
            return true;
        }
    }

    public boolean m1431d(int directions) {
        int count = this.f592d.length;
        for (int i = 0; i < count; i++) {
            if (m1423b(directions, i)) {
                return true;
            }
        }
        return false;
    }

    public boolean m1423b(int directions, int pointerId) {
        if (!m1422b(pointerId)) {
            return false;
        }
        boolean checkHorizontal;
        boolean checkVertical;
        if ((directions & 1) == 1) {
            checkHorizontal = true;
        } else {
            checkHorizontal = false;
        }
        if ((directions & 2) == 2) {
            checkVertical = true;
        } else {
            checkVertical = false;
        }
        float dx = this.f594f[pointerId] - this.f592d[pointerId];
        float dy = this.f595g[pointerId] - this.f593e[pointerId];
        if (checkHorizontal && checkVertical) {
            if ((dx * dx) + (dy * dy) <= ((float) (this.f590b * this.f590b))) {
                return false;
            }
            return true;
        } else if (checkHorizontal) {
            if (Math.abs(dx) <= ((float) this.f590b)) {
                return false;
            }
            return true;
        } else if (!checkVertical) {
            return false;
        } else {
            if (Math.abs(dy) <= ((float) this.f590b)) {
                return false;
            }
            return true;
        }
    }

    private void m1411h() {
        this.f600l.computeCurrentVelocity(LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, this.f601m);
        m1397a(m1392a(C0252p.m1100a(this.f600l, this.f591c), this.f602n, this.f601m), m1392a(C0252p.m1101b(this.f600l, this.f591c), this.f602n, this.f601m));
    }

    private void m1405b(int left, int top, int dx, int dy) {
        int clampedX = left;
        int clampedY = top;
        int oldLeft = this.f607s.getLeft();
        int oldTop = this.f607s.getTop();
        if (dx != 0) {
            clampedX = this.f606r.m1215a(this.f607s, left, dx);
            this.f607s.offsetLeftAndRight(clampedX - oldLeft);
        }
        if (dy != 0) {
            clampedY = this.f606r.m1222b(this.f607s, top, dy);
            this.f607s.offsetTopAndBottom(clampedY - oldTop);
        }
        if (dx != 0 || dy != 0) {
            this.f606r.m1219a(this.f607s, clampedX, clampedY, clampedX - oldLeft, clampedY - oldTop);
        }
    }

    public boolean m1428c(int x, int y) {
        return m1425b(this.f607s, x, y);
    }

    public boolean m1425b(View view, int x, int y) {
        if (view != null && x >= view.getLeft() && x < view.getRight() && y >= view.getTop() && y < view.getBottom()) {
            return true;
        }
        return false;
    }

    public View m1430d(int x, int y) {
        for (int i = this.f609u.getChildCount() - 1; i >= 0; i--) {
            View child = this.f609u.getChildAt(this.f606r.m1226c(i));
            if (x >= child.getLeft() && x < child.getRight() && y >= child.getTop() && y < child.getBottom()) {
                return child;
            }
        }
        return null;
    }

    private int m1407e(int x, int y) {
        int result = 0;
        if (x < this.f609u.getLeft() + this.f603o) {
            result = 0 | 1;
        }
        if (y < this.f609u.getTop() + this.f603o) {
            result |= 4;
        }
        if (x > this.f609u.getRight() - this.f603o) {
            result |= 2;
        }
        if (y > this.f609u.getBottom() - this.f603o) {
            return result | 8;
        }
        return result;
    }
}
