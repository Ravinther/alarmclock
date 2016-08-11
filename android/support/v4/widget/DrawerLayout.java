package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.v4.p006a.C0008b;
import android.support.v4.view.C0162a;
import android.support.v4.view.C0224e;
import android.support.v4.view.C0230g;
import android.support.v4.view.C0247m;
import android.support.v4.view.C0264r;
import android.support.v4.view.aa;
import android.support.v4.view.p011a.C0184a;
import android.support.v4.widget.C0321j.C0287a;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;
import java.util.List;

public class DrawerLayout extends ViewGroup implements C0289d {
    static final C0281c f508a;
    private static final int[] f509b;
    private static final boolean f510c;
    private CharSequence f511A;
    private Object f512B;
    private boolean f513C;
    private final C0280b f514d;
    private int f515e;
    private int f516f;
    private float f517g;
    private Paint f518h;
    private final C0321j f519i;
    private final C0321j f520j;
    private final C0288h f521k;
    private final C0288h f522l;
    private int f523m;
    private boolean f524n;
    private boolean f525o;
    private int f526p;
    private int f527q;
    private boolean f528r;
    private boolean f529s;
    private C0284f f530t;
    private float f531u;
    private float f532v;
    private Drawable f533w;
    private Drawable f534x;
    private Drawable f535y;
    private CharSequence f536z;

    protected static class SavedState extends BaseSavedState {
        public static final Creator CREATOR;
        int f493a;
        int f494b;
        int f495c;

        /* renamed from: android.support.v4.widget.DrawerLayout.SavedState.1 */
        static class C02781 implements Creator {
            C02781() {
            }

            public /* synthetic */ Object createFromParcel(Parcel x0) {
                return m1189a(x0);
            }

            public /* synthetic */ Object[] newArray(int x0) {
                return m1190a(x0);
            }

            public SavedState m1189a(Parcel source) {
                return new SavedState(source);
            }

            public SavedState[] m1190a(int size) {
                return new SavedState[size];
            }
        }

        public SavedState(Parcel in) {
            super(in);
            this.f493a = 0;
            this.f494b = 0;
            this.f495c = 0;
            this.f493a = in.readInt();
        }

        public SavedState(Parcelable superState) {
            super(superState);
            this.f493a = 0;
            this.f494b = 0;
            this.f495c = 0;
        }

        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeInt(this.f493a);
        }

        static {
            CREATOR = new C02781();
        }
    }

    /* renamed from: android.support.v4.widget.DrawerLayout.a */
    class C0279a extends C0162a {
        final /* synthetic */ DrawerLayout f496b;
        private final Rect f497c;

        C0279a(DrawerLayout drawerLayout) {
            this.f496b = drawerLayout;
            this.f497c = new Rect();
        }

        public void m1193a(View host, C0184a info) {
            if (DrawerLayout.f510c) {
                super.m594a(host, info);
            } else {
                C0184a superNode = C0184a.m834a(info);
                super.m594a(host, superNode);
                info.m840a(host);
                ViewParent parent = C0264r.m1165f(host);
                if (parent instanceof View) {
                    info.m849c((View) parent);
                }
                m1191a(info, superNode);
                superNode.m875s();
                m1192a(info, (ViewGroup) host);
            }
            info.m846b(DrawerLayout.class.getName());
        }

        public void m1196d(View host, AccessibilityEvent event) {
            super.m600d(host, event);
            event.setClassName(DrawerLayout.class.getName());
        }

        public boolean m1195b(View host, AccessibilityEvent event) {
            if (event.getEventType() != 32) {
                return super.m598b(host, event);
            }
            List eventText = event.getText();
            View visibleDrawer = this.f496b.m1250h();
            if (visibleDrawer != null) {
                CharSequence title = this.f496b.m1256a(this.f496b.m1269e(visibleDrawer));
                if (title != null) {
                    eventText.add(title);
                }
            }
            return true;
        }

        public boolean m1194a(ViewGroup host, View child, AccessibilityEvent event) {
            if (DrawerLayout.f510c || DrawerLayout.m1253m(child)) {
                return super.m597a(host, child, event);
            }
            return false;
        }

        private void m1192a(C0184a info, ViewGroup v) {
            int childCount = v.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View child = v.getChildAt(i);
                if (DrawerLayout.m1253m(child)) {
                    info.m845b(child);
                }
            }
        }

        private void m1191a(C0184a dest, C0184a src) {
            Rect rect = this.f497c;
            src.m839a(rect);
            dest.m844b(rect);
            src.m848c(rect);
            dest.m853d(rect);
            dest.m851c(src.m861g());
            dest.m841a(src.m871o());
            dest.m846b(src.m872p());
            dest.m850c(src.m874r());
            dest.m862h(src.m868l());
            dest.m858f(src.m866j());
            dest.m842a(src.m857e());
            dest.m847b(src.m859f());
            dest.m854d(src.m863h());
            dest.m856e(src.m865i());
            dest.m860g(src.m867k());
            dest.m838a(src.m843b());
        }
    }

    /* renamed from: android.support.v4.widget.DrawerLayout.b */
    final class C0280b extends C0162a {
        final /* synthetic */ DrawerLayout f498b;

        C0280b(DrawerLayout drawerLayout) {
            this.f498b = drawerLayout;
        }

        public void m1197a(View child, C0184a info) {
            super.m594a(child, info);
            if (!DrawerLayout.m1253m(child)) {
                info.m849c(null);
            }
        }
    }

    /* renamed from: android.support.v4.widget.DrawerLayout.c */
    interface C0281c {
        int m1198a(Object obj);

        void m1199a(View view);

        void m1200a(View view, Object obj, int i);

        void m1201a(MarginLayoutParams marginLayoutParams, Object obj, int i);
    }

    /* renamed from: android.support.v4.widget.DrawerLayout.d */
    static class C0282d implements C0281c {
        C0282d() {
        }

        public void m1203a(View drawerLayout) {
            C0306c.m1313a(drawerLayout);
        }

        public void m1204a(View child, Object insets, int drawerGravity) {
            C0306c.m1314a(child, insets, drawerGravity);
        }

        public void m1205a(MarginLayoutParams lp, Object insets, int drawerGravity) {
            C0306c.m1315a(lp, insets, drawerGravity);
        }

        public int m1202a(Object insets) {
            return C0306c.m1312a(insets);
        }
    }

    /* renamed from: android.support.v4.widget.DrawerLayout.e */
    static class C0283e implements C0281c {
        C0283e() {
        }

        public void m1207a(View drawerLayout) {
        }

        public void m1208a(View child, Object insets, int drawerGravity) {
        }

        public void m1209a(MarginLayoutParams lp, Object insets, int drawerGravity) {
        }

        public int m1206a(Object insets) {
            return 0;
        }
    }

    /* renamed from: android.support.v4.widget.DrawerLayout.f */
    public interface C0284f {
        void m1210a(int i);

        void m1211a(View view);

        void m1212a(View view, float f);

        void m1213b(View view);
    }

    /* renamed from: android.support.v4.widget.DrawerLayout.g */
    public static class C0285g extends MarginLayoutParams {
        public int f499a;
        float f500b;
        boolean f501c;
        boolean f502d;

        public C0285g(Context c, AttributeSet attrs) {
            super(c, attrs);
            this.f499a = 0;
            TypedArray a = c.obtainStyledAttributes(attrs, DrawerLayout.f509b);
            this.f499a = a.getInt(0, 0);
            a.recycle();
        }

        public C0285g(int width, int height) {
            super(width, height);
            this.f499a = 0;
        }

        public C0285g(C0285g source) {
            super(source);
            this.f499a = 0;
            this.f499a = source.f499a;
        }

        public C0285g(LayoutParams source) {
            super(source);
            this.f499a = 0;
        }

        public C0285g(MarginLayoutParams source) {
            super(source);
            this.f499a = 0;
        }
    }

    /* renamed from: android.support.v4.widget.DrawerLayout.h */
    private class C0288h extends C0287a {
        final /* synthetic */ DrawerLayout f504a;
        private final int f505b;
        private C0321j f506c;
        private final Runnable f507d;

        /* renamed from: android.support.v4.widget.DrawerLayout.h.1 */
        class C02861 implements Runnable {
            final /* synthetic */ C0288h f503a;

            C02861(C0288h c0288h) {
                this.f503a = c0288h;
            }

            public void run() {
                this.f503a.m1229c();
            }
        }

        public C0288h(DrawerLayout drawerLayout, int gravity) {
            this.f504a = drawerLayout;
            this.f507d = new C02861(this);
            this.f505b = gravity;
        }

        public void m1235a(C0321j dragger) {
            this.f506c = dragger;
        }

        public void m1232a() {
            this.f504a.removeCallbacks(this.f507d);
        }

        public boolean m1238a(View child, int pointerId) {
            return this.f504a.m1271g(child) && this.f504a.m1261a(child, this.f505b) && this.f504a.m1254a(child) == 0;
        }

        public void m1233a(int state) {
            this.f504a.m1258a(this.f505b, state, this.f506c.m1426c());
        }

        public void m1237a(View changedView, int left, int top, int dx, int dy) {
            float offset;
            int childWidth = changedView.getWidth();
            if (this.f504a.m1261a(changedView, 3)) {
                offset = ((float) (childWidth + left)) / ((float) childWidth);
            } else {
                offset = ((float) (this.f504a.getWidth() - left)) / ((float) childWidth);
            }
            this.f504a.m1265b(changedView, offset);
            changedView.setVisibility(offset == 0.0f ? 4 : 0);
            this.f504a.invalidate();
        }

        public void m1241b(View capturedChild, int activePointerId) {
            ((C0285g) capturedChild.getLayoutParams()).f501c = false;
            m1228b();
        }

        private void m1228b() {
            int otherGrav = 3;
            if (this.f505b == 3) {
                otherGrav = 5;
            }
            View toClose = this.f504a.m1262b(otherGrav);
            if (toClose != null) {
                this.f504a.m1273i(toClose);
            }
        }

        public void m1236a(View releasedChild, float xvel, float yvel) {
            int left;
            float offset = this.f504a.m1268d(releasedChild);
            int childWidth = releasedChild.getWidth();
            if (this.f504a.m1261a(releasedChild, 3)) {
                left = (xvel > 0.0f || (xvel == 0.0f && offset > 0.5f)) ? 0 : -childWidth;
            } else {
                int width = this.f504a.getWidth();
                left = (xvel < 0.0f || (xvel == 0.0f && offset > 0.5f)) ? width - childWidth : width;
            }
            this.f506c.m1416a(left, releasedChild.getTop());
            this.f504a.invalidate();
        }

        public void m1234a(int edgeFlags, int pointerId) {
            this.f504a.postDelayed(this.f507d, 160);
        }

        private void m1229c() {
            boolean leftEdge;
            View toCapture;
            int childLeft;
            int i = 0;
            int peekDistance = this.f506c.m1420b();
            if (this.f505b == 3) {
                leftEdge = true;
            } else {
                leftEdge = false;
            }
            if (leftEdge) {
                toCapture = this.f504a.m1262b(3);
                if (toCapture != null) {
                    i = -toCapture.getWidth();
                }
                childLeft = i + peekDistance;
            } else {
                toCapture = this.f504a.m1262b(5);
                childLeft = this.f504a.getWidth() - peekDistance;
            }
            if (toCapture == null) {
                return;
            }
            if (((leftEdge && toCapture.getLeft() < childLeft) || (!leftEdge && toCapture.getLeft() > childLeft)) && this.f504a.m1254a(toCapture) == 0) {
                C0285g lp = (C0285g) toCapture.getLayoutParams();
                this.f506c.m1418a(toCapture, childLeft, toCapture.getTop());
                lp.f501c = true;
                this.f504a.invalidate();
                m1228b();
                this.f504a.m1266c();
            }
        }

        public boolean m1242b(int edgeFlags) {
            return false;
        }

        public void m1240b(int edgeFlags, int pointerId) {
            View toCapture;
            if ((edgeFlags & 1) == 1) {
                toCapture = this.f504a.m1262b(3);
            } else {
                toCapture = this.f504a.m1262b(5);
            }
            if (toCapture != null && this.f504a.m1254a(toCapture) == 0) {
                this.f506c.m1415a(toCapture, pointerId);
            }
        }

        public int m1230a(View child) {
            return this.f504a.m1271g(child) ? child.getWidth() : 0;
        }

        public int m1231a(View child, int left, int dx) {
            if (this.f504a.m1261a(child, 3)) {
                return Math.max(-child.getWidth(), Math.min(left, 0));
            }
            int width = this.f504a.getWidth();
            return Math.max(width - child.getWidth(), Math.min(left, width));
        }

        public int m1239b(View child, int top, int dy) {
            return child.getTop();
        }
    }

    static {
        boolean z = true;
        f509b = new int[]{16842931};
        if (VERSION.SDK_INT < 19) {
            z = false;
        }
        f510c = z;
        if (VERSION.SDK_INT >= 21) {
            f508a = new C0282d();
        } else {
            f508a = new C0283e();
        }
    }

    public DrawerLayout(Context context) {
        this(context, null);
    }

    public DrawerLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DrawerLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.f514d = new C0280b(this);
        this.f516f = -1728053248;
        this.f518h = new Paint();
        this.f525o = true;
        setDescendantFocusability(262144);
        float density = getResources().getDisplayMetrics().density;
        this.f515e = (int) ((64.0f * density) + 0.5f);
        float minVel = 400.0f * density;
        this.f521k = new C0288h(this, 3);
        this.f522l = new C0288h(this, 5);
        this.f519i = C0321j.m1395a((ViewGroup) this, 1.0f, this.f521k);
        this.f519i.m1414a(1);
        this.f519i.m1413a(minVel);
        this.f521k.m1235a(this.f519i);
        this.f520j = C0321j.m1395a((ViewGroup) this, 1.0f, this.f522l);
        this.f520j.m1414a(2);
        this.f520j.m1413a(minVel);
        this.f522l.m1235a(this.f520j);
        setFocusableInTouchMode(true);
        C0264r.m1161b(this, 1);
        C0264r.m1157a((View) this, new C0279a(this));
        aa.m970a(this, false);
        if (C0264r.m1167h(this)) {
            f508a.m1199a((View) this);
        }
    }

    public void setScrimColor(int color) {
        this.f516f = color;
        invalidate();
    }

    public void setDrawerListener(C0284f listener) {
        this.f530t = listener;
    }

    public void setDrawerLockMode(int lockMode) {
        m1257a(lockMode, 3);
        m1257a(lockMode, 5);
    }

    public void m1257a(int lockMode, int edgeGravity) {
        int absGravity = C0224e.m1001a(edgeGravity, C0264r.m1164e(this));
        if (absGravity == 3) {
            this.f526p = lockMode;
        } else if (absGravity == 5) {
            this.f527q = lockMode;
        }
        if (lockMode != 0) {
            (absGravity == 3 ? this.f519i : this.f520j).m1432e();
        }
        switch (lockMode) {
            case Base64.NO_PADDING /*1*/:
                View toClose = m1262b(absGravity);
                if (toClose != null) {
                    m1273i(toClose);
                }
            case Base64.NO_WRAP /*2*/:
                View toOpen = m1262b(absGravity);
                if (toOpen != null) {
                    m1272h(toOpen);
                }
            default:
        }
    }

    public int m1254a(View drawerView) {
        int absGravity = m1269e(drawerView);
        if (absGravity == 3) {
            return this.f526p;
        }
        if (absGravity == 5) {
            return this.f527q;
        }
        return 0;
    }

    public CharSequence m1256a(int edgeGravity) {
        int absGravity = C0224e.m1001a(edgeGravity, C0264r.m1164e(this));
        if (absGravity == 3) {
            return this.f536z;
        }
        if (absGravity == 5) {
            return this.f511A;
        }
        return null;
    }

    void m1258a(int forGravity, int activeState, View activeDrawer) {
        int state;
        int leftState = this.f519i.m1412a();
        int rightState = this.f520j.m1412a();
        if (leftState == 1 || rightState == 1) {
            state = 1;
        } else if (leftState == 2 || rightState == 2) {
            state = 2;
        } else {
            state = 0;
        }
        if (activeDrawer != null && activeState == 0) {
            C0285g lp = (C0285g) activeDrawer.getLayoutParams();
            if (lp.f500b == 0.0f) {
                m1264b(activeDrawer);
            } else if (lp.f500b == 1.0f) {
                m1267c(activeDrawer);
            }
        }
        if (state != this.f523m) {
            this.f523m = state;
            if (this.f530t != null) {
                this.f530t.m1210a(state);
            }
        }
    }

    void m1264b(View drawerView) {
        C0285g lp = (C0285g) drawerView.getLayoutParams();
        if (lp.f502d) {
            lp.f502d = false;
            if (this.f530t != null) {
                this.f530t.m1213b(drawerView);
            }
            m1244a(drawerView, false);
            if (hasWindowFocus()) {
                View rootView = getRootView();
                if (rootView != null) {
                    rootView.sendAccessibilityEvent(32);
                }
            }
        }
    }

    void m1267c(View drawerView) {
        C0285g lp = (C0285g) drawerView.getLayoutParams();
        if (!lp.f502d) {
            lp.f502d = true;
            if (this.f530t != null) {
                this.f530t.m1211a(drawerView);
            }
            m1244a(drawerView, true);
            drawerView.requestFocus();
        }
    }

    private void m1244a(View drawerView, boolean isDrawerOpen) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            if ((isDrawerOpen || m1271g(child)) && !(isDrawerOpen && child == drawerView)) {
                C0264r.m1161b(child, 4);
            } else {
                C0264r.m1161b(child, 1);
            }
        }
    }

    void m1259a(View drawerView, float slideOffset) {
        if (this.f530t != null) {
            this.f530t.m1212a(drawerView, slideOffset);
        }
    }

    void m1265b(View drawerView, float slideOffset) {
        C0285g lp = (C0285g) drawerView.getLayoutParams();
        if (slideOffset != lp.f500b) {
            lp.f500b = slideOffset;
            m1259a(drawerView, slideOffset);
        }
    }

    float m1268d(View drawerView) {
        return ((C0285g) drawerView.getLayoutParams()).f500b;
    }

    int m1269e(View drawerView) {
        return C0224e.m1001a(((C0285g) drawerView.getLayoutParams()).f499a, C0264r.m1164e(this));
    }

    boolean m1261a(View drawerView, int checkFor) {
        return (m1269e(drawerView) & checkFor) == checkFor;
    }

    View m1255a() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            if (((C0285g) child.getLayoutParams()).f502d) {
                return child;
            }
        }
        return null;
    }

    View m1262b(int gravity) {
        int absHorizGravity = C0224e.m1001a(gravity, C0264r.m1164e(this)) & 7;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            if ((m1269e(child) & 7) == absHorizGravity) {
                return child;
            }
        }
        return null;
    }

    static String m1245c(int gravity) {
        if ((gravity & 3) == 3) {
            return "LEFT";
        }
        if ((gravity & 5) == 5) {
            return "RIGHT";
        }
        return Integer.toHexString(gravity);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f525o = true;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f525o = true;
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        if (!(widthMode == 1073741824 && heightMode == 1073741824)) {
            if (isInEditMode()) {
                if (widthMode != Integer.MIN_VALUE) {
                    if (widthMode == 0) {
                        widthSize = 300;
                    }
                }
                if (heightMode != Integer.MIN_VALUE) {
                    if (heightMode == 0) {
                        heightSize = 300;
                    }
                }
            } else {
                throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
            }
        }
        setMeasuredDimension(widthSize, heightSize);
        boolean applyInsets = this.f512B != null && C0264r.m1167h(this);
        int layoutDirection = C0264r.m1164e(this);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            if (child.getVisibility() != 8) {
                MarginLayoutParams lp = (C0285g) child.getLayoutParams();
                if (applyInsets) {
                    int cgrav = C0224e.m1001a(lp.f499a, layoutDirection);
                    if (C0264r.m1167h(child)) {
                        f508a.m1200a(child, this.f512B, cgrav);
                    } else {
                        f508a.m1201a(lp, this.f512B, cgrav);
                    }
                }
                if (m1270f(child)) {
                    int i2 = lp.leftMargin;
                    child.measure(MeasureSpec.makeMeasureSpec((widthSize - r0) - lp.rightMargin, 1073741824), MeasureSpec.makeMeasureSpec((heightSize - lp.topMargin) - lp.bottomMargin, 1073741824));
                } else if (m1271g(child)) {
                    int childGravity = m1269e(child) & 7;
                    if ((0 & childGravity) != 0) {
                        throw new IllegalStateException("Child drawer has absolute gravity " + m1245c(childGravity) + " but this " + "DrawerLayout" + " already has a " + "drawer view along that edge");
                    }
                    child.measure(getChildMeasureSpec(widthMeasureSpec, (this.f515e + lp.leftMargin) + lp.rightMargin, lp.width), getChildMeasureSpec(heightMeasureSpec, lp.topMargin + lp.bottomMargin, lp.height));
                } else {
                    throw new IllegalStateException("Child " + child + " at index " + i + " does not have a valid layout_gravity - must be Gravity.LEFT, " + "Gravity.RIGHT or Gravity.NO_GRAVITY");
                }
            }
        }
    }

    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        this.f524n = true;
        int width = r - l;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            if (child.getVisibility() != 8) {
                C0285g lp = (C0285g) child.getLayoutParams();
                if (m1270f(child)) {
                    child.layout(lp.leftMargin, lp.topMargin, lp.leftMargin + child.getMeasuredWidth(), lp.topMargin + child.getMeasuredHeight());
                } else {
                    int childLeft;
                    float newOffset;
                    int childWidth = child.getMeasuredWidth();
                    int childHeight = child.getMeasuredHeight();
                    if (m1261a(child, 3)) {
                        childLeft = (-childWidth) + ((int) (((float) childWidth) * lp.f500b));
                        newOffset = ((float) (childWidth + childLeft)) / ((float) childWidth);
                    } else {
                        childLeft = width - ((int) (((float) childWidth) * lp.f500b));
                        newOffset = ((float) (width - childLeft)) / ((float) childWidth);
                    }
                    boolean changeOffset = newOffset != lp.f500b;
                    int height;
                    switch (lp.f499a & 112) {
                        case Base64.NO_CLOSE /*16*/:
                            height = b - t;
                            int childTop = (height - childHeight) / 2;
                            int i2 = lp.topMargin;
                            if (childTop < r0) {
                                childTop = lp.topMargin;
                            } else {
                                if (childTop + childHeight > height - lp.bottomMargin) {
                                    childTop = (height - lp.bottomMargin) - childHeight;
                                }
                            }
                            child.layout(childLeft, childTop, childLeft + childWidth, childTop + childHeight);
                            break;
                        case 80:
                            height = b - t;
                            child.layout(childLeft, (height - lp.bottomMargin) - child.getMeasuredHeight(), childLeft + childWidth, height - lp.bottomMargin);
                            break;
                        default:
                            child.layout(childLeft, lp.topMargin, childLeft + childWidth, lp.topMargin + childHeight);
                            break;
                    }
                    if (changeOffset) {
                        m1265b(child, newOffset);
                    }
                    int newVisibility = lp.f500b > 0.0f ? 0 : 4;
                    if (child.getVisibility() != newVisibility) {
                        child.setVisibility(newVisibility);
                    }
                }
            }
        }
        this.f524n = false;
        this.f525o = false;
    }

    public void requestLayout() {
        if (!this.f524n) {
            super.requestLayout();
        }
    }

    public void computeScroll() {
        int childCount = getChildCount();
        float scrimOpacity = 0.0f;
        for (int i = 0; i < childCount; i++) {
            scrimOpacity = Math.max(scrimOpacity, ((C0285g) getChildAt(i).getLayoutParams()).f500b);
        }
        this.f517g = scrimOpacity;
        if ((this.f519i.m1419a(true) | this.f520j.m1419a(true)) != 0) {
            C0264r.m1160b(this);
        }
    }

    private static boolean m1252l(View v) {
        Drawable bg = v.getBackground();
        if (bg == null || bg.getOpacity() != -1) {
            return false;
        }
        return true;
    }

    public void setStatusBarBackground(Drawable bg) {
        this.f535y = bg;
    }

    public void setStatusBarBackground(int resId) {
        this.f535y = resId != 0 ? C0008b.m96a(getContext(), resId) : null;
    }

    public void setStatusBarBackgroundColor(int color) {
        this.f535y = new ColorDrawable(color);
    }

    public void onDraw(Canvas c) {
        super.onDraw(c);
        if (this.f513C && this.f535y != null) {
            int inset = f508a.m1198a(this.f512B);
            if (inset > 0) {
                this.f535y.setBounds(0, 0, getWidth(), inset);
                this.f535y.draw(c);
            }
        }
    }

    protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
        int height = getHeight();
        boolean drawingContent = m1270f(child);
        int clipLeft = 0;
        int clipRight = getWidth();
        int restoreCount = canvas.save();
        if (drawingContent) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View v = getChildAt(i);
                if (v != child && v.getVisibility() == 0 && m1252l(v) && m1271g(v) && v.getHeight() >= height) {
                    if (m1261a(v, 3)) {
                        int vright = v.getRight();
                        if (vright > clipLeft) {
                            clipLeft = vright;
                        }
                    } else {
                        int vleft = v.getLeft();
                        if (vleft < clipRight) {
                            clipRight = vleft;
                        }
                    }
                }
            }
            canvas.clipRect(clipLeft, 0, clipRight, getHeight());
        }
        boolean result = super.drawChild(canvas, child, drawingTime);
        canvas.restoreToCount(restoreCount);
        if (this.f517g > 0.0f && drawingContent) {
            this.f518h.setColor((((int) (((float) ((this.f516f & -16777216) >>> 24)) * this.f517g)) << 24) | (this.f516f & 16777215));
            canvas.drawRect((float) clipLeft, 0.0f, (float) clipRight, (float) getHeight(), this.f518h);
        } else if (this.f533w != null && m1261a(child, 3)) {
            shadowWidth = this.f533w.getIntrinsicWidth();
            int childRight = child.getRight();
            alpha = Math.max(0.0f, Math.min(((float) childRight) / ((float) this.f519i.m1420b()), 1.0f));
            this.f533w.setBounds(childRight, child.getTop(), childRight + shadowWidth, child.getBottom());
            this.f533w.setAlpha((int) (255.0f * alpha));
            this.f533w.draw(canvas);
        } else if (this.f534x != null && m1261a(child, 5)) {
            shadowWidth = this.f534x.getIntrinsicWidth();
            int childLeft = child.getLeft();
            alpha = Math.max(0.0f, Math.min(((float) (getWidth() - childLeft)) / ((float) this.f520j.m1420b()), 1.0f));
            this.f534x.setBounds(childLeft - shadowWidth, child.getTop(), childLeft, child.getBottom());
            this.f534x.setAlpha((int) (255.0f * alpha));
            this.f534x.draw(canvas);
        }
        return result;
    }

    boolean m1270f(View child) {
        return ((C0285g) child.getLayoutParams()).f499a == 0;
    }

    boolean m1271g(View child) {
        return (C0224e.m1001a(((C0285g) child.getLayoutParams()).f499a, C0264r.m1164e(child)) & 7) != 0;
    }

    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean interceptForDrag = this.f519i.m1417a(ev) | this.f520j.m1417a(ev);
        boolean interceptForTap = false;
        switch (C0247m.m1082a(ev)) {
            case Base64.DEFAULT /*0*/:
                float x = ev.getX();
                float y = ev.getY();
                this.f531u = x;
                this.f532v = y;
                if (this.f517g > 0.0f) {
                    View child = this.f519i.m1430d((int) x, (int) y);
                    if (child != null && m1270f(child)) {
                        interceptForTap = true;
                    }
                }
                this.f528r = false;
                this.f529s = false;
                break;
            case Base64.NO_PADDING /*1*/:
            case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                m1260a(true);
                this.f528r = false;
                this.f529s = false;
                break;
            case Base64.NO_WRAP /*2*/:
                if (this.f519i.m1431d(3)) {
                    this.f521k.m1232a();
                    this.f522l.m1232a();
                    break;
                }
                break;
        }
        if (interceptForDrag || interceptForTap || m1248f() || this.f529s) {
            return true;
        }
        return false;
    }

    public boolean onTouchEvent(MotionEvent ev) {
        this.f519i.m1421b(ev);
        this.f520j.m1421b(ev);
        float x;
        float y;
        switch (ev.getAction() & 255) {
            case Base64.DEFAULT /*0*/:
                x = ev.getX();
                y = ev.getY();
                this.f531u = x;
                this.f532v = y;
                this.f528r = false;
                this.f529s = false;
                break;
            case Base64.NO_PADDING /*1*/:
                x = ev.getX();
                y = ev.getY();
                boolean peekingOnly = true;
                View touchedView = this.f519i.m1430d((int) x, (int) y);
                if (touchedView != null && m1270f(touchedView)) {
                    float dx = x - this.f531u;
                    float dy = y - this.f532v;
                    int slop = this.f519i.m1429d();
                    if ((dx * dx) + (dy * dy) < ((float) (slop * slop))) {
                        View openDrawer = m1255a();
                        if (openDrawer != null) {
                            peekingOnly = m1254a(openDrawer) == 2;
                        }
                    }
                }
                m1260a(peekingOnly);
                this.f528r = false;
                break;
            case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                m1260a(true);
                this.f528r = false;
                this.f529s = false;
                break;
        }
        return true;
    }

    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        super.requestDisallowInterceptTouchEvent(disallowIntercept);
        this.f528r = disallowIntercept;
        if (disallowIntercept) {
            m1260a(true);
        }
    }

    public void m1263b() {
        m1260a(false);
    }

    void m1260a(boolean peekingOnly) {
        boolean needsInvalidate = false;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            C0285g lp = (C0285g) child.getLayoutParams();
            if (m1271g(child) && (!peekingOnly || lp.f501c)) {
                int childWidth = child.getWidth();
                if (m1261a(child, 3)) {
                    needsInvalidate |= this.f519i.m1418a(child, -childWidth, child.getTop());
                } else {
                    needsInvalidate |= this.f520j.m1418a(child, getWidth(), child.getTop());
                }
                lp.f501c = false;
            }
        }
        this.f521k.m1232a();
        this.f522l.m1232a();
        if (needsInvalidate) {
            invalidate();
        }
    }

    public void m1272h(View drawerView) {
        if (m1271g(drawerView)) {
            if (this.f525o) {
                C0285g lp = (C0285g) drawerView.getLayoutParams();
                lp.f500b = 1.0f;
                lp.f502d = true;
                m1244a(drawerView, true);
            } else if (m1261a(drawerView, 3)) {
                this.f519i.m1418a(drawerView, 0, drawerView.getTop());
            } else {
                this.f520j.m1418a(drawerView, getWidth() - drawerView.getWidth(), drawerView.getTop());
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + drawerView + " is not a sliding drawer");
    }

    public void m1273i(View drawerView) {
        if (m1271g(drawerView)) {
            if (this.f525o) {
                C0285g lp = (C0285g) drawerView.getLayoutParams();
                lp.f500b = 0.0f;
                lp.f502d = false;
            } else if (m1261a(drawerView, 3)) {
                this.f519i.m1418a(drawerView, -drawerView.getWidth(), drawerView.getTop());
            } else {
                this.f520j.m1418a(drawerView, getWidth(), drawerView.getTop());
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + drawerView + " is not a sliding drawer");
    }

    public boolean m1274j(View drawer) {
        if (m1271g(drawer)) {
            return ((C0285g) drawer.getLayoutParams()).f500b > 0.0f;
        } else {
            throw new IllegalArgumentException("View " + drawer + " is not a drawer");
        }
    }

    private boolean m1248f() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (((C0285g) getChildAt(i).getLayoutParams()).f501c) {
                return true;
            }
        }
        return false;
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new C0285g(-1, -1);
    }

    protected LayoutParams generateLayoutParams(LayoutParams p) {
        if (p instanceof C0285g) {
            return new C0285g((C0285g) p);
        }
        return p instanceof MarginLayoutParams ? new C0285g((MarginLayoutParams) p) : new C0285g(p);
    }

    protected boolean checkLayoutParams(LayoutParams p) {
        return (p instanceof C0285g) && super.checkLayoutParams(p);
    }

    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new C0285g(getContext(), attrs);
    }

    private boolean m1249g() {
        return m1250h() != null;
    }

    private View m1250h() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            if (m1271g(child) && m1274j(child)) {
                return child;
            }
        }
        return null;
    }

    void m1266c() {
        if (!this.f529s) {
            long now = SystemClock.uptimeMillis();
            MotionEvent cancelEvent = MotionEvent.obtain(now, now, 3, 0.0f, 0.0f, 0);
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                getChildAt(i).dispatchTouchEvent(cancelEvent);
            }
            cancelEvent.recycle();
            this.f529s = true;
        }
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode != 4 || !m1249g()) {
            return super.onKeyDown(keyCode, event);
        }
        C0230g.m1017b(event);
        return true;
    }

    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode != 4) {
            return super.onKeyUp(keyCode, event);
        }
        View visibleDrawer = m1250h();
        if (visibleDrawer != null && m1254a(visibleDrawer) == 0) {
            m1263b();
        }
        return visibleDrawer != null;
    }

    protected void onRestoreInstanceState(Parcelable state) {
        SavedState ss = (SavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());
        if (ss.f493a != 0) {
            View toOpen = m1262b(ss.f493a);
            if (toOpen != null) {
                m1272h(toOpen);
            }
        }
        m1257a(ss.f494b, 3);
        m1257a(ss.f495c, 5);
    }

    protected Parcelable onSaveInstanceState() {
        SavedState ss = new SavedState(super.onSaveInstanceState());
        View openDrawer = m1255a();
        if (openDrawer != null) {
            ss.f493a = ((C0285g) openDrawer.getLayoutParams()).f499a;
        }
        ss.f494b = this.f526p;
        ss.f495c = this.f527q;
        return ss;
    }

    public void addView(View child, int index, LayoutParams params) {
        super.addView(child, index, params);
        if (m1255a() != null || m1271g(child)) {
            C0264r.m1161b(child, 4);
        } else {
            C0264r.m1161b(child, 1);
        }
        if (!f510c) {
            C0264r.m1157a(child, this.f514d);
        }
    }

    private static boolean m1253m(View child) {
        return (C0264r.m1162c(child) == 4 || C0264r.m1162c(child) == 2) ? false : true;
    }
}
