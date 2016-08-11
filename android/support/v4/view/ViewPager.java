package android.support.v4.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.p009c.C0131a;
import android.support.v4.p009c.C0132b;
import android.support.v4.view.p011a.C0184a;
import android.support.v4.view.p011a.C0206h;
import android.support.v4.widget.C0310e;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.millennialmedia.android.MMException;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.factories.HttpClientFactory;
import com.mopub.mobileads.util.Base64;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ViewPager extends ViewGroup {
    private static final int[] f409a;
    private static final C0168i af;
    private static final Comparator f410c;
    private static final Interpolator f411d;
    private boolean f412A;
    private boolean f413B;
    private int f414C;
    private int f415D;
    private int f416E;
    private float f417F;
    private float f418G;
    private float f419H;
    private float f420I;
    private int f421J;
    private VelocityTracker f422K;
    private int f423L;
    private int f424M;
    private int f425N;
    private int f426O;
    private boolean f427P;
    private C0310e f428Q;
    private C0310e f429R;
    private boolean f430S;
    private boolean f431T;
    private boolean f432U;
    private int f433V;
    private C0165f f434W;
    private C0165f f435Z;
    private C0164e aa;
    private C0166g ab;
    private Method ac;
    private int ad;
    private ArrayList ae;
    private final Runnable ag;
    private int ah;
    private int f436b;
    private final ArrayList f437e;
    private final C0160b f438f;
    private final Rect f439g;
    private C0083o f440h;
    private int f441i;
    private int f442j;
    private Parcelable f443k;
    private ClassLoader f444l;
    private Scroller f445m;
    private C0167h f446n;
    private int f447o;
    private Drawable f448p;
    private int f449q;
    private int f450r;
    private float f451s;
    private float f452t;
    private int f453u;
    private int f454v;
    private boolean f455w;
    private boolean f456x;
    private boolean f457y;
    private int f458z;

    /* renamed from: android.support.v4.view.ViewPager.1 */
    static class C01551 implements Comparator {
        C01551() {
        }

        public /* synthetic */ int compare(Object x0, Object x1) {
            return m586a((C0160b) x0, (C0160b) x1);
        }

        public int m586a(C0160b lhs, C0160b rhs) {
            return lhs.f394b - rhs.f394b;
        }
    }

    /* renamed from: android.support.v4.view.ViewPager.2 */
    static class C01562 implements Interpolator {
        C01562() {
        }

        public float getInterpolation(float t) {
            t -= 1.0f;
            return ((((t * t) * t) * t) * t) + 1.0f;
        }
    }

    /* renamed from: android.support.v4.view.ViewPager.3 */
    class C01573 implements Runnable {
        final /* synthetic */ ViewPager f389a;

        C01573(ViewPager viewPager) {
            this.f389a = viewPager;
        }

        public void run() {
            this.f389a.setScrollState(0);
            this.f389a.m644c();
        }
    }

    public static class SavedState extends BaseSavedState {
        public static final Creator CREATOR;
        int f390a;
        Parcelable f391b;
        ClassLoader f392c;

        /* renamed from: android.support.v4.view.ViewPager.SavedState.1 */
        static class C01581 implements C0132b {
            C01581() {
            }

            public /* synthetic */ Object m587a(Parcel x0, ClassLoader x1) {
                return m589b(x0, x1);
            }

            public /* synthetic */ Object[] m588a(int x0) {
                return m590b(x0);
            }

            public SavedState m589b(Parcel in, ClassLoader loader) {
                return new SavedState(in, loader);
            }

            public SavedState[] m590b(int size) {
                return new SavedState[size];
            }
        }

        public SavedState(Parcelable superState) {
            super(superState);
        }

        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeInt(this.f390a);
            out.writeParcelable(this.f391b, flags);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f390a + "}";
        }

        static {
            CREATOR = C0131a.m498a(new C01581());
        }

        SavedState(Parcel in, ClassLoader loader) {
            super(in);
            if (loader == null) {
                loader = getClass().getClassLoader();
            }
            this.f390a = in.readInt();
            this.f391b = in.readParcelable(loader);
            this.f392c = loader;
        }
    }

    /* renamed from: android.support.v4.view.ViewPager.a */
    interface C0159a {
    }

    /* renamed from: android.support.v4.view.ViewPager.b */
    static class C0160b {
        Object f393a;
        int f394b;
        boolean f395c;
        float f396d;
        float f397e;

        C0160b() {
        }
    }

    /* renamed from: android.support.v4.view.ViewPager.c */
    public static class C0161c extends LayoutParams {
        public boolean f398a;
        public int f399b;
        float f400c;
        boolean f401d;
        int f402e;
        int f403f;

        public C0161c() {
            super(-1, -1);
            this.f400c = 0.0f;
        }

        public C0161c(Context context, AttributeSet attrs) {
            super(context, attrs);
            this.f400c = 0.0f;
            TypedArray a = context.obtainStyledAttributes(attrs, ViewPager.f409a);
            this.f399b = a.getInteger(0, 48);
            a.recycle();
        }
    }

    /* renamed from: android.support.v4.view.ViewPager.d */
    class C0163d extends C0162a {
        final /* synthetic */ ViewPager f407b;

        C0163d(ViewPager viewPager) {
            this.f407b = viewPager;
        }

        public void m604d(View host, AccessibilityEvent event) {
            super.m600d(host, event);
            event.setClassName(ViewPager.class.getName());
            C0206h recordCompat = C0206h.m957a();
            recordCompat.m959a(m601b());
            if (event.getEventType() == 4096 && this.f407b.f440h != null) {
                recordCompat.m958a(this.f407b.f440h.m356b());
                recordCompat.m960b(this.f407b.f441i);
                recordCompat.m961c(this.f407b.f441i);
            }
        }

        public void m602a(View host, C0184a info) {
            super.m594a(host, info);
            info.m846b(ViewPager.class.getName());
            info.m864i(m601b());
            if (this.f407b.canScrollHorizontally(1)) {
                info.m838a(4096);
            }
            if (this.f407b.canScrollHorizontally(-1)) {
                info.m838a((int) HttpClientFactory.SOCKET_SIZE);
            }
        }

        public boolean m603a(View host, int action, Bundle args) {
            if (super.m596a(host, action, args)) {
                return true;
            }
            switch (action) {
                case 4096:
                    if (!this.f407b.canScrollHorizontally(1)) {
                        return false;
                    }
                    this.f407b.setCurrentItem(this.f407b.f441i + 1);
                    return true;
                case HttpClientFactory.SOCKET_SIZE /*8192*/:
                    if (!this.f407b.canScrollHorizontally(-1)) {
                        return false;
                    }
                    this.f407b.setCurrentItem(this.f407b.f441i - 1);
                    return true;
                default:
                    return false;
            }
        }

        private boolean m601b() {
            return this.f407b.f440h != null && this.f407b.f440h.m356b() > 1;
        }
    }

    /* renamed from: android.support.v4.view.ViewPager.e */
    interface C0164e {
        void m605a(C0083o c0083o, C0083o c0083o2);
    }

    /* renamed from: android.support.v4.view.ViewPager.f */
    public interface C0165f {
        void m606a(int i, float f, int i2);

        void a_(int i);

        void b_(int i);
    }

    /* renamed from: android.support.v4.view.ViewPager.g */
    public interface C0166g {
        void m607a(View view, float f);
    }

    /* renamed from: android.support.v4.view.ViewPager.h */
    private class C0167h extends DataSetObserver {
        final /* synthetic */ ViewPager f408a;

        private C0167h(ViewPager viewPager) {
            this.f408a = viewPager;
        }

        public void onChanged() {
            this.f408a.m643b();
        }

        public void onInvalidated() {
            this.f408a.m643b();
        }
    }

    /* renamed from: android.support.v4.view.ViewPager.i */
    static class C0168i implements Comparator {
        C0168i() {
        }

        public /* synthetic */ int compare(Object x0, Object x1) {
            return m608a((View) x0, (View) x1);
        }

        public int m608a(View lhs, View rhs) {
            C0161c llp = (C0161c) lhs.getLayoutParams();
            C0161c rlp = (C0161c) rhs.getLayoutParams();
            if (llp.f398a != rlp.f398a) {
                return llp.f398a ? 1 : -1;
            } else {
                return llp.f402e - rlp.f402e;
            }
        }
    }

    static {
        f409a = new int[]{16842931};
        f410c = new C01551();
        f411d = new C01562();
        af = new C0168i();
    }

    public ViewPager(Context context) {
        super(context);
        this.f437e = new ArrayList();
        this.f438f = new C0160b();
        this.f439g = new Rect();
        this.f442j = -1;
        this.f443k = null;
        this.f444l = null;
        this.f451s = -3.4028235E38f;
        this.f452t = Float.MAX_VALUE;
        this.f458z = 1;
        this.f421J = -1;
        this.f430S = true;
        this.f431T = false;
        this.ag = new C01573(this);
        this.ah = 0;
        m632a();
    }

    public ViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f437e = new ArrayList();
        this.f438f = new C0160b();
        this.f439g = new Rect();
        this.f442j = -1;
        this.f443k = null;
        this.f444l = null;
        this.f451s = -3.4028235E38f;
        this.f452t = Float.MAX_VALUE;
        this.f458z = 1;
        this.f421J = -1;
        this.f430S = true;
        this.f431T = false;
        this.ag = new C01573(this);
        this.ah = 0;
        m632a();
    }

    void m632a() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.f445m = new Scroller(context, f411d);
        ViewConfiguration configuration = ViewConfiguration.get(context);
        float density = context.getResources().getDisplayMetrics().density;
        this.f416E = C0276y.m1187a(configuration);
        this.f423L = (int) (400.0f * density);
        this.f424M = configuration.getScaledMaximumFlingVelocity();
        this.f428Q = new C0310e(context);
        this.f429R = new C0310e(context);
        this.f425N = (int) (25.0f * density);
        this.f426O = (int) (2.0f * density);
        this.f414C = (int) (16.0f * density);
        C0264r.m1157a((View) this, new C0163d(this));
        if (C0264r.m1162c(this) == 0) {
            C0264r.m1161b(this, 1);
        }
    }

    protected void onDetachedFromWindow() {
        removeCallbacks(this.ag);
        super.onDetachedFromWindow();
    }

    private void setScrollState(int newState) {
        if (this.ah != newState) {
            this.ah = newState;
            if (this.ab != null) {
                m620b(newState != 0);
            }
            if (this.f434W != null) {
                this.f434W.b_(newState);
            }
        }
    }

    public void setAdapter(C0083o adapter) {
        if (this.f440h != null) {
            this.f440h.m357b(this.f446n);
            this.f440h.m353a((ViewGroup) this);
            for (int i = 0; i < this.f437e.size(); i++) {
                C0160b ii = (C0160b) this.f437e.get(i);
                this.f440h.m354a((ViewGroup) this, ii.f394b, ii.f393a);
            }
            this.f440h.m360b((ViewGroup) this);
            this.f437e.clear();
            m625g();
            this.f441i = 0;
            scrollTo(0, 0);
        }
        C0083o oldAdapter = this.f440h;
        this.f440h = adapter;
        this.f436b = 0;
        if (this.f440h != null) {
            if (this.f446n == null) {
                this.f446n = new C0167h();
            }
            this.f440h.m349a(this.f446n);
            this.f457y = false;
            boolean wasFirstLayout = this.f430S;
            this.f430S = true;
            this.f436b = this.f440h.m356b();
            if (this.f442j >= 0) {
                this.f440h.m350a(this.f443k, this.f444l);
                m637a(this.f442j, false, true);
                this.f442j = -1;
                this.f443k = null;
                this.f444l = null;
            } else if (wasFirstLayout) {
                requestLayout();
            } else {
                m644c();
            }
        }
        if (this.aa != null && oldAdapter != adapter) {
            this.aa.m605a(oldAdapter, adapter);
        }
    }

    private void m625g() {
        int i = 0;
        while (i < getChildCount()) {
            if (!((C0161c) getChildAt(i).getLayoutParams()).f398a) {
                removeViewAt(i);
                i--;
            }
            i++;
        }
    }

    public C0083o getAdapter() {
        return this.f440h;
    }

    void setOnAdapterChangeListener(C0164e listener) {
        this.aa = listener;
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public void setCurrentItem(int item) {
        boolean z;
        this.f457y = false;
        if (this.f430S) {
            z = false;
        } else {
            z = true;
        }
        m637a(item, z, false);
    }

    public void m636a(int item, boolean smoothScroll) {
        this.f457y = false;
        m637a(item, smoothScroll, false);
    }

    public int getCurrentItem() {
        return this.f441i;
    }

    void m637a(int item, boolean smoothScroll, boolean always) {
        m638a(item, smoothScroll, always, 0);
    }

    void m638a(int item, boolean smoothScroll, boolean always, int velocity) {
        boolean dispatchSelected = true;
        if (this.f440h == null || this.f440h.m356b() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (always || this.f441i != item || this.f437e.size() == 0) {
            if (item < 0) {
                item = 0;
            } else if (item >= this.f440h.m356b()) {
                item = this.f440h.m356b() - 1;
            }
            int pageLimit = this.f458z;
            if (item > this.f441i + pageLimit || item < this.f441i - pageLimit) {
                for (int i = 0; i < this.f437e.size(); i++) {
                    ((C0160b) this.f437e.get(i)).f395c = true;
                }
            }
            if (this.f441i == item) {
                dispatchSelected = false;
            }
            if (this.f430S) {
                this.f441i = item;
                if (dispatchSelected && this.f434W != null) {
                    this.f434W.a_(item);
                }
                if (dispatchSelected && this.f435Z != null) {
                    this.f435Z.a_(item);
                }
                requestLayout();
                return;
            }
            m633a(item);
            m613a(item, smoothScroll, velocity, dispatchSelected);
        } else {
            setScrollingCacheEnabled(false);
        }
    }

    private void m613a(int item, boolean smoothScroll, int velocity, boolean dispatchSelected) {
        C0160b curInfo = m641b(item);
        int destX = 0;
        if (curInfo != null) {
            destX = (int) (((float) getClientWidth()) * Math.max(this.f451s, Math.min(curInfo.f397e, this.f452t)));
        }
        if (smoothScroll) {
            m635a(destX, 0, velocity);
            if (dispatchSelected && this.f434W != null) {
                this.f434W.a_(item);
            }
            if (dispatchSelected && this.f435Z != null) {
                this.f435Z.a_(item);
                return;
            }
            return;
        }
        if (dispatchSelected && this.f434W != null) {
            this.f434W.a_(item);
        }
        if (dispatchSelected && this.f435Z != null) {
            this.f435Z.a_(item);
        }
        m617a(false);
        scrollTo(destX, 0);
        m623d(destX);
    }

    public void setOnPageChangeListener(C0165f listener) {
        this.f434W = listener;
    }

    void setChildrenDrawingOrderEnabledCompat(boolean enable) {
        if (VERSION.SDK_INT >= 7) {
            if (this.ac == null) {
                try {
                    this.ac = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[]{Boolean.TYPE});
                } catch (NoSuchMethodException e) {
                    Log.e("ViewPager", "Can't find setChildrenDrawingOrderEnabled", e);
                }
            }
            try {
                this.ac.invoke(this, new Object[]{Boolean.valueOf(enable)});
            } catch (Exception e2) {
                Log.e("ViewPager", "Error changing children drawing order", e2);
            }
        }
    }

    protected int getChildDrawingOrder(int childCount, int i) {
        int index;
        if (this.ad == 2) {
            index = (childCount - 1) - i;
        } else {
            index = i;
        }
        return ((C0161c) ((View) this.ae.get(index)).getLayoutParams()).f403f;
    }

    public int getOffscreenPageLimit() {
        return this.f458z;
    }

    public void setOffscreenPageLimit(int limit) {
        if (limit < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + limit + " too small; defaulting to " + 1);
            limit = 1;
        }
        if (limit != this.f458z) {
            this.f458z = limit;
            m644c();
        }
    }

    public void setPageMargin(int marginPixels) {
        int oldMargin = this.f447o;
        this.f447o = marginPixels;
        int width = getWidth();
        m612a(width, width, marginPixels, oldMargin);
        requestLayout();
    }

    public int getPageMargin() {
        return this.f447o;
    }

    public void setPageMarginDrawable(Drawable d) {
        this.f448p = d;
        if (d != null) {
            refreshDrawableState();
        }
        setWillNotDraw(d == null);
        invalidate();
    }

    public void setPageMarginDrawable(int resId) {
        setPageMarginDrawable(getContext().getResources().getDrawable(resId));
    }

    protected boolean verifyDrawable(Drawable who) {
        return super.verifyDrawable(who) || who == this.f448p;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable d = this.f448p;
        if (d != null && d.isStateful()) {
            d.setState(getDrawableState());
        }
    }

    float m629a(float f) {
        return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
    }

    void m635a(int x, int y, int velocity) {
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        int sx = getScrollX();
        int sy = getScrollY();
        int dx = x - sx;
        int dy = y - sy;
        if (dx == 0 && dy == 0) {
            m617a(false);
            m644c();
            setScrollState(0);
            return;
        }
        int duration;
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int width = getClientWidth();
        int halfWidth = width / 2;
        float distance = ((float) halfWidth) + (((float) halfWidth) * m629a(Math.min(1.0f, (1.0f * ((float) Math.abs(dx))) / ((float) width))));
        velocity = Math.abs(velocity);
        if (velocity > 0) {
            duration = Math.round(1000.0f * Math.abs(distance / ((float) velocity))) * 4;
        } else {
            duration = (int) ((1.0f + (((float) Math.abs(dx)) / (((float) this.f447o) + (((float) width) * this.f440h.m364d(this.f441i))))) * 100.0f);
        }
        this.f445m.startScroll(sx, sy, dx, dy, Math.min(duration, 600));
        C0264r.m1160b(this);
    }

    C0160b m630a(int position, int index) {
        C0160b ii = new C0160b();
        ii.f394b = position;
        ii.f393a = this.f440h.m348a((ViewGroup) this, position);
        ii.f396d = this.f440h.m364d(position);
        if (index < 0 || index >= this.f437e.size()) {
            this.f437e.add(ii);
        } else {
            this.f437e.add(index, ii);
        }
        return ii;
    }

    void m643b() {
        boolean needPopulate;
        int adapterCount = this.f440h.m356b();
        this.f436b = adapterCount;
        if (this.f437e.size() >= (this.f458z * 2) + 1 || this.f437e.size() >= adapterCount) {
            needPopulate = false;
        } else {
            needPopulate = true;
        }
        int newCurrItem = this.f441i;
        boolean isUpdating = false;
        int i = 0;
        while (i < this.f437e.size()) {
            C0160b ii = (C0160b) this.f437e.get(i);
            int newPos = this.f440h.m345a(ii.f393a);
            if (newPos != -1) {
                if (newPos == -2) {
                    this.f437e.remove(i);
                    i--;
                    if (!isUpdating) {
                        this.f440h.m353a((ViewGroup) this);
                        isUpdating = true;
                    }
                    this.f440h.m354a((ViewGroup) this, ii.f394b, ii.f393a);
                    needPopulate = true;
                    if (this.f441i == ii.f394b) {
                        newCurrItem = Math.max(0, Math.min(this.f441i, adapterCount - 1));
                        needPopulate = true;
                    }
                } else if (ii.f394b != newPos) {
                    if (ii.f394b == this.f441i) {
                        newCurrItem = newPos;
                    }
                    ii.f394b = newPos;
                    needPopulate = true;
                }
            }
            i++;
        }
        if (isUpdating) {
            this.f440h.m360b((ViewGroup) this);
        }
        Collections.sort(this.f437e, f410c);
        if (needPopulate) {
            int childCount = getChildCount();
            for (i = 0; i < childCount; i++) {
                C0161c lp = (C0161c) getChildAt(i).getLayoutParams();
                if (!lp.f398a) {
                    lp.f400c = 0.0f;
                }
            }
            m637a(newCurrItem, false, true);
            requestLayout();
        }
    }

    void m644c() {
        m633a(this.f441i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void m633a(int r31) {
        /*
        r30 = this;
        r21 = 0;
        r15 = 2;
        r0 = r30;
        r0 = r0.f441i;
        r27 = r0;
        r0 = r27;
        r1 = r31;
        if (r0 == r1) goto L_0x0031;
    L_0x000f:
        r0 = r30;
        r0 = r0.f441i;
        r27 = r0;
        r0 = r27;
        r1 = r31;
        if (r0 >= r1) goto L_0x003d;
    L_0x001b:
        r15 = 66;
    L_0x001d:
        r0 = r30;
        r0 = r0.f441i;
        r27 = r0;
        r0 = r30;
        r1 = r27;
        r21 = r0.m641b(r1);
        r0 = r31;
        r1 = r30;
        r1.f441i = r0;
    L_0x0031:
        r0 = r30;
        r0 = r0.f440h;
        r27 = r0;
        if (r27 != 0) goto L_0x0040;
    L_0x0039:
        r30.m626h();
    L_0x003c:
        return;
    L_0x003d:
        r15 = 17;
        goto L_0x001d;
    L_0x0040:
        r0 = r30;
        r0 = r0.f457y;
        r27 = r0;
        if (r27 == 0) goto L_0x004c;
    L_0x0048:
        r30.m626h();
        goto L_0x003c;
    L_0x004c:
        r27 = r30.getWindowToken();
        if (r27 == 0) goto L_0x003c;
    L_0x0052:
        r0 = r30;
        r0 = r0.f440h;
        r27 = r0;
        r0 = r27;
        r1 = r30;
        r0.m353a(r1);
        r0 = r30;
        r0 = r0.f458z;
        r22 = r0;
        r27 = 0;
        r0 = r30;
        r0 = r0.f441i;
        r28 = r0;
        r28 = r28 - r22;
        r26 = java.lang.Math.max(r27, r28);
        r0 = r30;
        r0 = r0.f440h;
        r27 = r0;
        r4 = r27.m356b();
        r27 = r4 + -1;
        r0 = r30;
        r0 = r0.f441i;
        r28 = r0;
        r28 = r28 + r22;
        r12 = java.lang.Math.min(r27, r28);
        r0 = r30;
        r0 = r0.f436b;
        r27 = r0;
        r0 = r27;
        if (r4 == r0) goto L_0x0106;
    L_0x0095:
        r27 = r30.getResources();	 Catch:{ NotFoundException -> 0x00fc }
        r28 = r30.getId();	 Catch:{ NotFoundException -> 0x00fc }
        r24 = r27.getResourceName(r28);	 Catch:{ NotFoundException -> 0x00fc }
    L_0x00a1:
        r27 = new java.lang.IllegalStateException;
        r28 = new java.lang.StringBuilder;
        r28.<init>();
        r29 = "The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: ";
        r28 = r28.append(r29);
        r0 = r30;
        r0 = r0.f436b;
        r29 = r0;
        r28 = r28.append(r29);
        r29 = ", found: ";
        r28 = r28.append(r29);
        r0 = r28;
        r28 = r0.append(r4);
        r29 = " Pager id: ";
        r28 = r28.append(r29);
        r0 = r28;
        r1 = r24;
        r28 = r0.append(r1);
        r29 = " Pager class: ";
        r28 = r28.append(r29);
        r29 = r30.getClass();
        r28 = r28.append(r29);
        r29 = " Problematic adapter: ";
        r28 = r28.append(r29);
        r0 = r30;
        r0 = r0.f440h;
        r29 = r0;
        r29 = r29.getClass();
        r28 = r28.append(r29);
        r28 = r28.toString();
        r27.<init>(r28);
        throw r27;
    L_0x00fc:
        r11 = move-exception;
        r27 = r30.getId();
        r24 = java.lang.Integer.toHexString(r27);
        goto L_0x00a1;
    L_0x0106:
        r8 = -1;
        r9 = 0;
        r8 = 0;
    L_0x0109:
        r0 = r30;
        r0 = r0.f437e;
        r27 = r0;
        r27 = r27.size();
        r0 = r27;
        if (r8 >= r0) goto L_0x014b;
    L_0x0117:
        r0 = r30;
        r0 = r0.f437e;
        r27 = r0;
        r0 = r27;
        r17 = r0.get(r8);
        r17 = (android.support.v4.view.ViewPager.C0160b) r17;
        r0 = r17;
        r0 = r0.f394b;
        r27 = r0;
        r0 = r30;
        r0 = r0.f441i;
        r28 = r0;
        r0 = r27;
        r1 = r28;
        if (r0 < r1) goto L_0x0260;
    L_0x0137:
        r0 = r17;
        r0 = r0.f394b;
        r27 = r0;
        r0 = r30;
        r0 = r0.f441i;
        r28 = r0;
        r0 = r27;
        r1 = r28;
        if (r0 != r1) goto L_0x014b;
    L_0x0149:
        r9 = r17;
    L_0x014b:
        if (r9 != 0) goto L_0x015d;
    L_0x014d:
        if (r4 <= 0) goto L_0x015d;
    L_0x014f:
        r0 = r30;
        r0 = r0.f441i;
        r27 = r0;
        r0 = r30;
        r1 = r27;
        r9 = r0.m630a(r1, r8);
    L_0x015d:
        if (r9 == 0) goto L_0x01e1;
    L_0x015f:
        r13 = 0;
        r18 = r8 + -1;
        if (r18 < 0) goto L_0x0264;
    L_0x0164:
        r0 = r30;
        r0 = r0.f437e;
        r27 = r0;
        r0 = r27;
        r1 = r18;
        r27 = r0.get(r1);
        r27 = (android.support.v4.view.ViewPager.C0160b) r27;
        r17 = r27;
    L_0x0176:
        r7 = r30.getClientWidth();
        if (r7 > 0) goto L_0x0268;
    L_0x017c:
        r19 = 0;
    L_0x017e:
        r0 = r30;
        r0 = r0.f441i;
        r27 = r0;
        r23 = r27 + -1;
    L_0x0186:
        if (r23 < 0) goto L_0x0194;
    L_0x0188:
        r27 = (r13 > r19 ? 1 : (r13 == r19 ? 0 : -1));
        if (r27 < 0) goto L_0x02d9;
    L_0x018c:
        r0 = r23;
        r1 = r26;
        if (r0 >= r1) goto L_0x02d9;
    L_0x0192:
        if (r17 != 0) goto L_0x0282;
    L_0x0194:
        r14 = r9.f396d;
        r18 = r8 + 1;
        r27 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r27 = (r14 > r27 ? 1 : (r14 == r27 ? 0 : -1));
        if (r27 >= 0) goto L_0x01da;
    L_0x019e:
        r0 = r30;
        r0 = r0.f437e;
        r27 = r0;
        r27 = r27.size();
        r0 = r18;
        r1 = r27;
        if (r0 >= r1) goto L_0x0337;
    L_0x01ae:
        r0 = r30;
        r0 = r0.f437e;
        r27 = r0;
        r0 = r27;
        r1 = r18;
        r27 = r0.get(r1);
        r27 = (android.support.v4.view.ViewPager.C0160b) r27;
        r17 = r27;
    L_0x01c0:
        if (r7 > 0) goto L_0x033b;
    L_0x01c2:
        r25 = 0;
    L_0x01c4:
        r0 = r30;
        r0 = r0.f441i;
        r27 = r0;
        r23 = r27 + 1;
    L_0x01cc:
        r0 = r23;
        if (r0 >= r4) goto L_0x01da;
    L_0x01d0:
        r27 = (r14 > r25 ? 1 : (r14 == r25 ? 0 : -1));
        if (r27 < 0) goto L_0x03b0;
    L_0x01d4:
        r0 = r23;
        if (r0 <= r12) goto L_0x03b0;
    L_0x01d8:
        if (r17 != 0) goto L_0x034f;
    L_0x01da:
        r0 = r30;
        r1 = r21;
        r0.m614a(r9, r8, r1);
    L_0x01e1:
        r0 = r30;
        r0 = r0.f440h;
        r28 = r0;
        r0 = r30;
        r0 = r0.f441i;
        r29 = r0;
        if (r9 == 0) goto L_0x0428;
    L_0x01ef:
        r0 = r9.f393a;
        r27 = r0;
    L_0x01f3:
        r0 = r28;
        r1 = r30;
        r2 = r29;
        r3 = r27;
        r0.m361b(r1, r2, r3);
        r0 = r30;
        r0 = r0.f440h;
        r27 = r0;
        r0 = r27;
        r1 = r30;
        r0.m360b(r1);
        r6 = r30.getChildCount();
        r16 = 0;
    L_0x0211:
        r0 = r16;
        if (r0 >= r6) goto L_0x042c;
    L_0x0215:
        r0 = r30;
        r1 = r16;
        r5 = r0.getChildAt(r1);
        r20 = r5.getLayoutParams();
        r20 = (android.support.v4.view.ViewPager.C0161c) r20;
        r0 = r16;
        r1 = r20;
        r1.f403f = r0;
        r0 = r20;
        r0 = r0.f398a;
        r27 = r0;
        if (r27 != 0) goto L_0x025d;
    L_0x0231:
        r0 = r20;
        r0 = r0.f400c;
        r27 = r0;
        r28 = 0;
        r27 = (r27 > r28 ? 1 : (r27 == r28 ? 0 : -1));
        if (r27 != 0) goto L_0x025d;
    L_0x023d:
        r0 = r30;
        r17 = r0.m631a(r5);
        if (r17 == 0) goto L_0x025d;
    L_0x0245:
        r0 = r17;
        r0 = r0.f396d;
        r27 = r0;
        r0 = r27;
        r1 = r20;
        r1.f400c = r0;
        r0 = r17;
        r0 = r0.f394b;
        r27 = r0;
        r0 = r27;
        r1 = r20;
        r1.f402e = r0;
    L_0x025d:
        r16 = r16 + 1;
        goto L_0x0211;
    L_0x0260:
        r8 = r8 + 1;
        goto L_0x0109;
    L_0x0264:
        r17 = 0;
        goto L_0x0176;
    L_0x0268:
        r27 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r0 = r9.f396d;
        r28 = r0;
        r27 = r27 - r28;
        r28 = r30.getPaddingLeft();
        r0 = r28;
        r0 = (float) r0;
        r28 = r0;
        r0 = (float) r7;
        r29 = r0;
        r28 = r28 / r29;
        r19 = r27 + r28;
        goto L_0x017e;
    L_0x0282:
        r0 = r17;
        r0 = r0.f394b;
        r27 = r0;
        r0 = r23;
        r1 = r27;
        if (r0 != r1) goto L_0x02d2;
    L_0x028e:
        r0 = r17;
        r0 = r0.f395c;
        r27 = r0;
        if (r27 != 0) goto L_0x02d2;
    L_0x0296:
        r0 = r30;
        r0 = r0.f437e;
        r27 = r0;
        r0 = r27;
        r1 = r18;
        r0.remove(r1);
        r0 = r30;
        r0 = r0.f440h;
        r27 = r0;
        r0 = r17;
        r0 = r0.f393a;
        r28 = r0;
        r0 = r27;
        r1 = r30;
        r2 = r23;
        r3 = r28;
        r0.m354a(r1, r2, r3);
        r18 = r18 + -1;
        r8 = r8 + -1;
        if (r18 < 0) goto L_0x02d6;
    L_0x02c0:
        r0 = r30;
        r0 = r0.f437e;
        r27 = r0;
        r0 = r27;
        r1 = r18;
        r27 = r0.get(r1);
        r27 = (android.support.v4.view.ViewPager.C0160b) r27;
        r17 = r27;
    L_0x02d2:
        r23 = r23 + -1;
        goto L_0x0186;
    L_0x02d6:
        r17 = 0;
        goto L_0x02d2;
    L_0x02d9:
        if (r17 == 0) goto L_0x0309;
    L_0x02db:
        r0 = r17;
        r0 = r0.f394b;
        r27 = r0;
        r0 = r23;
        r1 = r27;
        if (r0 != r1) goto L_0x0309;
    L_0x02e7:
        r0 = r17;
        r0 = r0.f396d;
        r27 = r0;
        r13 = r13 + r27;
        r18 = r18 + -1;
        if (r18 < 0) goto L_0x0306;
    L_0x02f3:
        r0 = r30;
        r0 = r0.f437e;
        r27 = r0;
        r0 = r27;
        r1 = r18;
        r27 = r0.get(r1);
        r27 = (android.support.v4.view.ViewPager.C0160b) r27;
        r17 = r27;
    L_0x0305:
        goto L_0x02d2;
    L_0x0306:
        r17 = 0;
        goto L_0x0305;
    L_0x0309:
        r27 = r18 + 1;
        r0 = r30;
        r1 = r23;
        r2 = r27;
        r17 = r0.m630a(r1, r2);
        r0 = r17;
        r0 = r0.f396d;
        r27 = r0;
        r13 = r13 + r27;
        r8 = r8 + 1;
        if (r18 < 0) goto L_0x0334;
    L_0x0321:
        r0 = r30;
        r0 = r0.f437e;
        r27 = r0;
        r0 = r27;
        r1 = r18;
        r27 = r0.get(r1);
        r27 = (android.support.v4.view.ViewPager.C0160b) r27;
        r17 = r27;
    L_0x0333:
        goto L_0x02d2;
    L_0x0334:
        r17 = 0;
        goto L_0x0333;
    L_0x0337:
        r17 = 0;
        goto L_0x01c0;
    L_0x033b:
        r27 = r30.getPaddingRight();
        r0 = r27;
        r0 = (float) r0;
        r27 = r0;
        r0 = (float) r7;
        r28 = r0;
        r27 = r27 / r28;
        r28 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r25 = r27 + r28;
        goto L_0x01c4;
    L_0x034f:
        r0 = r17;
        r0 = r0.f394b;
        r27 = r0;
        r0 = r23;
        r1 = r27;
        if (r0 != r1) goto L_0x03a9;
    L_0x035b:
        r0 = r17;
        r0 = r0.f395c;
        r27 = r0;
        if (r27 != 0) goto L_0x03a9;
    L_0x0363:
        r0 = r30;
        r0 = r0.f437e;
        r27 = r0;
        r0 = r27;
        r1 = r18;
        r0.remove(r1);
        r0 = r30;
        r0 = r0.f440h;
        r27 = r0;
        r0 = r17;
        r0 = r0.f393a;
        r28 = r0;
        r0 = r27;
        r1 = r30;
        r2 = r23;
        r3 = r28;
        r0.m354a(r1, r2, r3);
        r0 = r30;
        r0 = r0.f437e;
        r27 = r0;
        r27 = r27.size();
        r0 = r18;
        r1 = r27;
        if (r0 >= r1) goto L_0x03ad;
    L_0x0397:
        r0 = r30;
        r0 = r0.f437e;
        r27 = r0;
        r0 = r27;
        r1 = r18;
        r27 = r0.get(r1);
        r27 = (android.support.v4.view.ViewPager.C0160b) r27;
        r17 = r27;
    L_0x03a9:
        r23 = r23 + 1;
        goto L_0x01cc;
    L_0x03ad:
        r17 = 0;
        goto L_0x03a9;
    L_0x03b0:
        if (r17 == 0) goto L_0x03ee;
    L_0x03b2:
        r0 = r17;
        r0 = r0.f394b;
        r27 = r0;
        r0 = r23;
        r1 = r27;
        if (r0 != r1) goto L_0x03ee;
    L_0x03be:
        r0 = r17;
        r0 = r0.f396d;
        r27 = r0;
        r14 = r14 + r27;
        r18 = r18 + 1;
        r0 = r30;
        r0 = r0.f437e;
        r27 = r0;
        r27 = r27.size();
        r0 = r18;
        r1 = r27;
        if (r0 >= r1) goto L_0x03eb;
    L_0x03d8:
        r0 = r30;
        r0 = r0.f437e;
        r27 = r0;
        r0 = r27;
        r1 = r18;
        r27 = r0.get(r1);
        r27 = (android.support.v4.view.ViewPager.C0160b) r27;
        r17 = r27;
    L_0x03ea:
        goto L_0x03a9;
    L_0x03eb:
        r17 = 0;
        goto L_0x03ea;
    L_0x03ee:
        r0 = r30;
        r1 = r23;
        r2 = r18;
        r17 = r0.m630a(r1, r2);
        r18 = r18 + 1;
        r0 = r17;
        r0 = r0.f396d;
        r27 = r0;
        r14 = r14 + r27;
        r0 = r30;
        r0 = r0.f437e;
        r27 = r0;
        r27 = r27.size();
        r0 = r18;
        r1 = r27;
        if (r0 >= r1) goto L_0x0425;
    L_0x0412:
        r0 = r30;
        r0 = r0.f437e;
        r27 = r0;
        r0 = r27;
        r1 = r18;
        r27 = r0.get(r1);
        r27 = (android.support.v4.view.ViewPager.C0160b) r27;
        r17 = r27;
    L_0x0424:
        goto L_0x03a9;
    L_0x0425:
        r17 = 0;
        goto L_0x0424;
    L_0x0428:
        r27 = 0;
        goto L_0x01f3;
    L_0x042c:
        r30.m626h();
        r27 = r30.hasFocus();
        if (r27 == 0) goto L_0x003c;
    L_0x0435:
        r10 = r30.findFocus();
        if (r10 == 0) goto L_0x048c;
    L_0x043b:
        r0 = r30;
        r17 = r0.m642b(r10);
    L_0x0441:
        if (r17 == 0) goto L_0x0455;
    L_0x0443:
        r0 = r17;
        r0 = r0.f394b;
        r27 = r0;
        r0 = r30;
        r0 = r0.f441i;
        r28 = r0;
        r0 = r27;
        r1 = r28;
        if (r0 == r1) goto L_0x003c;
    L_0x0455:
        r16 = 0;
    L_0x0457:
        r27 = r30.getChildCount();
        r0 = r16;
        r1 = r27;
        if (r0 >= r1) goto L_0x003c;
    L_0x0461:
        r0 = r30;
        r1 = r16;
        r5 = r0.getChildAt(r1);
        r0 = r30;
        r17 = r0.m631a(r5);
        if (r17 == 0) goto L_0x0489;
    L_0x0471:
        r0 = r17;
        r0 = r0.f394b;
        r27 = r0;
        r0 = r30;
        r0 = r0.f441i;
        r28 = r0;
        r0 = r27;
        r1 = r28;
        if (r0 != r1) goto L_0x0489;
    L_0x0483:
        r27 = r5.requestFocus(r15);
        if (r27 != 0) goto L_0x003c;
    L_0x0489:
        r16 = r16 + 1;
        goto L_0x0457;
    L_0x048c:
        r17 = 0;
        goto L_0x0441;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewPager.a(int):void");
    }

    private void m626h() {
        if (this.ad != 0) {
            if (this.ae == null) {
                this.ae = new ArrayList();
            } else {
                this.ae.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.ae.add(getChildAt(i));
            }
            Collections.sort(this.ae, af);
        }
    }

    private void m614a(C0160b curItem, int curIndex, C0160b oldCurInfo) {
        float offset;
        int pos;
        C0160b ii;
        int N = this.f440h.m356b();
        int width = getClientWidth();
        float marginOffset = width > 0 ? ((float) this.f447o) / ((float) width) : 0.0f;
        if (oldCurInfo != null) {
            int oldCurPosition = oldCurInfo.f394b;
            int itemIndex;
            if (oldCurPosition < curItem.f394b) {
                itemIndex = 0;
                offset = (oldCurInfo.f397e + oldCurInfo.f396d) + marginOffset;
                pos = oldCurPosition + 1;
                while (pos <= curItem.f394b && itemIndex < this.f437e.size()) {
                    ii = (C0160b) this.f437e.get(itemIndex);
                    while (pos > ii.f394b && itemIndex < this.f437e.size() - 1) {
                        itemIndex++;
                        ii = (C0160b) this.f437e.get(itemIndex);
                    }
                    while (pos < ii.f394b) {
                        offset += this.f440h.m364d(pos) + marginOffset;
                        pos++;
                    }
                    ii.f397e = offset;
                    offset += ii.f396d + marginOffset;
                    pos++;
                }
            } else if (oldCurPosition > curItem.f394b) {
                itemIndex = this.f437e.size() - 1;
                offset = oldCurInfo.f397e;
                pos = oldCurPosition - 1;
                while (pos >= curItem.f394b && itemIndex >= 0) {
                    ii = (C0160b) this.f437e.get(itemIndex);
                    while (pos < ii.f394b && itemIndex > 0) {
                        itemIndex--;
                        ii = (C0160b) this.f437e.get(itemIndex);
                    }
                    while (pos > ii.f394b) {
                        offset -= this.f440h.m364d(pos) + marginOffset;
                        pos--;
                    }
                    offset -= ii.f396d + marginOffset;
                    ii.f397e = offset;
                    pos--;
                }
            }
        }
        int itemCount = this.f437e.size();
        offset = curItem.f397e;
        pos = curItem.f394b - 1;
        this.f451s = curItem.f394b == 0 ? curItem.f397e : -3.4028235E38f;
        this.f452t = curItem.f394b == N + -1 ? (curItem.f397e + curItem.f396d) - 1.0f : Float.MAX_VALUE;
        int i = curIndex - 1;
        while (i >= 0) {
            ii = (C0160b) this.f437e.get(i);
            while (pos > ii.f394b) {
                offset -= this.f440h.m364d(pos) + marginOffset;
                pos--;
            }
            offset -= ii.f396d + marginOffset;
            ii.f397e = offset;
            if (ii.f394b == 0) {
                this.f451s = offset;
            }
            i--;
            pos--;
        }
        offset = (curItem.f397e + curItem.f396d) + marginOffset;
        pos = curItem.f394b + 1;
        i = curIndex + 1;
        while (i < itemCount) {
            ii = (C0160b) this.f437e.get(i);
            while (pos < ii.f394b) {
                offset += this.f440h.m364d(pos) + marginOffset;
                pos++;
            }
            if (ii.f394b == N - 1) {
                this.f452t = (ii.f396d + offset) - 1.0f;
            }
            ii.f397e = offset;
            offset += ii.f396d + marginOffset;
            i++;
            pos++;
        }
        this.f431T = false;
    }

    public Parcelable onSaveInstanceState() {
        SavedState ss = new SavedState(super.onSaveInstanceState());
        ss.f390a = this.f441i;
        if (this.f440h != null) {
            ss.f391b = this.f440h.m346a();
        }
        return ss;
    }

    public void onRestoreInstanceState(Parcelable state) {
        if (state instanceof SavedState) {
            SavedState ss = (SavedState) state;
            super.onRestoreInstanceState(ss.getSuperState());
            if (this.f440h != null) {
                this.f440h.m350a(ss.f391b, ss.f392c);
                m637a(ss.f390a, false, true);
                return;
            }
            this.f442j = ss.f390a;
            this.f443k = ss.f391b;
            this.f444l = ss.f392c;
            return;
        }
        super.onRestoreInstanceState(state);
    }

    public void addView(View child, int index, LayoutParams params) {
        if (!checkLayoutParams(params)) {
            params = generateLayoutParams(params);
        }
        C0161c lp = (C0161c) params;
        lp.f398a |= child instanceof C0159a;
        if (!this.f455w) {
            super.addView(child, index, params);
        } else if (lp == null || !lp.f398a) {
            lp.f401d = true;
            addViewInLayout(child, index, params);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
    }

    public void removeView(View view) {
        if (this.f455w) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    C0160b m631a(View child) {
        for (int i = 0; i < this.f437e.size(); i++) {
            C0160b ii = (C0160b) this.f437e.get(i);
            if (this.f440h.m355a(child, ii.f393a)) {
                return ii;
            }
        }
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    android.support.v4.view.ViewPager.C0160b m642b(android.view.View r3) {
        /*
        r2 = this;
    L_0x0000:
        r0 = r3.getParent();
        if (r0 == r2) goto L_0x0012;
    L_0x0006:
        if (r0 == 0) goto L_0x000c;
    L_0x0008:
        r1 = r0 instanceof android.view.View;
        if (r1 != 0) goto L_0x000e;
    L_0x000c:
        r1 = 0;
    L_0x000d:
        return r1;
    L_0x000e:
        r3 = r0;
        r3 = (android.view.View) r3;
        goto L_0x0000;
    L_0x0012:
        r1 = r2.m631a(r3);
        goto L_0x000d;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewPager.b(android.view.View):android.support.v4.view.ViewPager$b");
    }

    C0160b m641b(int position) {
        for (int i = 0; i < this.f437e.size(); i++) {
            C0160b ii = (C0160b) this.f437e.get(i);
            if (ii.f394b == position) {
                return ii;
            }
        }
        return null;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f430S = true;
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int i;
        setMeasuredDimension(getDefaultSize(0, widthMeasureSpec), getDefaultSize(0, heightMeasureSpec));
        int measuredWidth = getMeasuredWidth();
        this.f415D = Math.min(measuredWidth / 10, this.f414C);
        int childWidthSize = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int childHeightSize = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int size = getChildCount();
        for (i = 0; i < size; i++) {
            C0161c lp;
            View child = getChildAt(i);
            if (child.getVisibility() != 8) {
                lp = (C0161c) child.getLayoutParams();
                if (lp != null && lp.f398a) {
                    int hgrav = lp.f399b & 7;
                    int vgrav = lp.f399b & 112;
                    int widthMode = Integer.MIN_VALUE;
                    int heightMode = Integer.MIN_VALUE;
                    boolean consumeVertical = vgrav == 48 || vgrav == 80;
                    boolean consumeHorizontal = hgrav == 3 || hgrav == 5;
                    if (consumeVertical) {
                        widthMode = 1073741824;
                    } else if (consumeHorizontal) {
                        heightMode = 1073741824;
                    }
                    int widthSize = childWidthSize;
                    int heightSize = childHeightSize;
                    int i2 = lp.width;
                    if (r0 != -2) {
                        widthMode = 1073741824;
                        i2 = lp.width;
                        if (r0 != -1) {
                            widthSize = lp.width;
                        }
                    }
                    i2 = lp.height;
                    if (r0 != -2) {
                        heightMode = 1073741824;
                        i2 = lp.height;
                        if (r0 != -1) {
                            heightSize = lp.height;
                        }
                    }
                    child.measure(MeasureSpec.makeMeasureSpec(widthSize, widthMode), MeasureSpec.makeMeasureSpec(heightSize, heightMode));
                    if (consumeVertical) {
                        childHeightSize -= child.getMeasuredHeight();
                    } else if (consumeHorizontal) {
                        childWidthSize -= child.getMeasuredWidth();
                    }
                }
            }
        }
        this.f453u = MeasureSpec.makeMeasureSpec(childWidthSize, 1073741824);
        this.f454v = MeasureSpec.makeMeasureSpec(childHeightSize, 1073741824);
        this.f455w = true;
        m644c();
        this.f455w = false;
        size = getChildCount();
        for (i = 0; i < size; i++) {
            child = getChildAt(i);
            if (child.getVisibility() != 8) {
                lp = (C0161c) child.getLayoutParams();
                if (lp == null || !lp.f398a) {
                    child.measure(MeasureSpec.makeMeasureSpec((int) (((float) childWidthSize) * lp.f400c), 1073741824), this.f454v);
                }
            }
        }
    }

    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (w != oldw) {
            m612a(w, oldw, this.f447o, this.f447o);
        }
    }

    private void m612a(int width, int oldWidth, int margin, int oldMargin) {
        if (oldWidth <= 0 || this.f437e.isEmpty()) {
            C0160b ii = m641b(this.f441i);
            int scrollPos = (int) (((float) ((width - getPaddingLeft()) - getPaddingRight())) * (ii != null ? Math.min(ii.f397e, this.f452t) : 0.0f));
            if (scrollPos != getScrollX()) {
                m617a(false);
                scrollTo(scrollPos, getScrollY());
                return;
            }
            return;
        }
        int newOffsetPixels = (int) (((float) (((width - getPaddingLeft()) - getPaddingRight()) + margin)) * (((float) getScrollX()) / ((float) (((oldWidth - getPaddingLeft()) - getPaddingRight()) + oldMargin))));
        scrollTo(newOffsetPixels, getScrollY());
        if (!this.f445m.isFinished()) {
            this.f445m.startScroll(newOffsetPixels, 0, (int) (m641b(this.f441i).f397e * ((float) width)), 0, this.f445m.getDuration() - this.f445m.timePassed());
        }
    }

    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int i;
        C0161c lp;
        int count = getChildCount();
        int width = r - l;
        int height = b - t;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int decorCount = 0;
        for (i = 0; i < count; i++) {
            int childLeft;
            int childTop;
            View child = getChildAt(i);
            if (child.getVisibility() != 8) {
                lp = (C0161c) child.getLayoutParams();
                if (lp.f398a) {
                    int vgrav = lp.f399b & 112;
                    switch (lp.f399b & 7) {
                        case Base64.NO_PADDING /*1*/:
                            childLeft = Math.max((width - child.getMeasuredWidth()) / 2, paddingLeft);
                            break;
                        case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                            childLeft = paddingLeft;
                            paddingLeft += child.getMeasuredWidth();
                            break;
                        case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                            childLeft = (width - paddingRight) - child.getMeasuredWidth();
                            paddingRight += child.getMeasuredWidth();
                            break;
                        default:
                            childLeft = paddingLeft;
                            break;
                    }
                    switch (vgrav) {
                        case Base64.NO_CLOSE /*16*/:
                            childTop = Math.max((height - child.getMeasuredHeight()) / 2, paddingTop);
                            break;
                        case 48:
                            childTop = paddingTop;
                            paddingTop += child.getMeasuredHeight();
                            break;
                        case 80:
                            childTop = (height - paddingBottom) - child.getMeasuredHeight();
                            paddingBottom += child.getMeasuredHeight();
                            break;
                        default:
                            childTop = paddingTop;
                            break;
                    }
                    childLeft += scrollX;
                    child.layout(childLeft, childTop, child.getMeasuredWidth() + childLeft, child.getMeasuredHeight() + childTop);
                    decorCount++;
                }
            }
        }
        int childWidth = (width - paddingLeft) - paddingRight;
        for (i = 0; i < count; i++) {
            child = getChildAt(i);
            if (child.getVisibility() != 8) {
                lp = (C0161c) child.getLayoutParams();
                if (!lp.f398a) {
                    C0160b ii = m631a(child);
                    if (ii != null) {
                        childLeft = paddingLeft + ((int) (((float) childWidth) * ii.f397e));
                        childTop = paddingTop;
                        if (lp.f401d) {
                            lp.f401d = false;
                            int makeMeasureSpec = MeasureSpec.makeMeasureSpec((int) (((float) childWidth) * lp.f400c), 1073741824);
                            child.measure(widthSpec, MeasureSpec.makeMeasureSpec((height - paddingTop) - paddingBottom, 1073741824));
                        }
                        child.layout(childLeft, childTop, child.getMeasuredWidth() + childLeft, child.getMeasuredHeight() + childTop);
                    }
                }
            }
        }
        this.f449q = paddingTop;
        this.f450r = height - paddingBottom;
        this.f433V = decorCount;
        if (this.f430S) {
            m613a(this.f441i, false, 0, false);
        }
        this.f430S = false;
    }

    public void computeScroll() {
        if (this.f445m.isFinished() || !this.f445m.computeScrollOffset()) {
            m617a(true);
            return;
        }
        int oldX = getScrollX();
        int oldY = getScrollY();
        int x = this.f445m.getCurrX();
        int y = this.f445m.getCurrY();
        if (!(oldX == x && oldY == y)) {
            scrollTo(x, y);
            if (!m623d(x)) {
                this.f445m.abortAnimation();
                scrollTo(0, y);
            }
        }
        C0264r.m1160b(this);
    }

    private boolean m623d(int xpos) {
        if (this.f437e.size() == 0) {
            this.f432U = false;
            m634a(0, 0.0f, 0);
            if (this.f432U) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        C0160b ii = m627i();
        int width = getClientWidth();
        int widthWithMargin = width + this.f447o;
        float marginOffset = ((float) this.f447o) / ((float) width);
        int currentPage = ii.f394b;
        float pageOffset = ((((float) xpos) / ((float) width)) - ii.f397e) / (ii.f396d + marginOffset);
        int offsetPixels = (int) (((float) widthWithMargin) * pageOffset);
        this.f432U = false;
        m634a(currentPage, pageOffset, offsetPixels);
        if (this.f432U) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    protected void m634a(int position, float offset, int offsetPixels) {
        int scrollX;
        int childCount;
        int i;
        View child;
        if (this.f433V > 0) {
            scrollX = getScrollX();
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int width = getWidth();
            childCount = getChildCount();
            for (i = 0; i < childCount; i++) {
                child = getChildAt(i);
                C0161c lp = (C0161c) child.getLayoutParams();
                if (lp.f398a) {
                    int childLeft;
                    switch (lp.f399b & 7) {
                        case Base64.NO_PADDING /*1*/:
                            childLeft = Math.max((width - child.getMeasuredWidth()) / 2, paddingLeft);
                            break;
                        case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                            childLeft = paddingLeft;
                            paddingLeft += child.getWidth();
                            break;
                        case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                            childLeft = (width - paddingRight) - child.getMeasuredWidth();
                            paddingRight += child.getMeasuredWidth();
                            break;
                        default:
                            childLeft = paddingLeft;
                            break;
                    }
                    int childOffset = (childLeft + scrollX) - child.getLeft();
                    if (childOffset != 0) {
                        child.offsetLeftAndRight(childOffset);
                    }
                }
            }
        }
        if (this.f434W != null) {
            this.f434W.m606a(position, offset, offsetPixels);
        }
        if (this.f435Z != null) {
            this.f435Z.m606a(position, offset, offsetPixels);
        }
        if (this.ab != null) {
            scrollX = getScrollX();
            childCount = getChildCount();
            for (i = 0; i < childCount; i++) {
                child = getChildAt(i);
                if (!((C0161c) child.getLayoutParams()).f398a) {
                    this.ab.m607a(child, ((float) (child.getLeft() - scrollX)) / ((float) getClientWidth()));
                }
            }
        }
        this.f432U = true;
    }

    private void m617a(boolean postEvents) {
        boolean needPopulate;
        if (this.ah == 2) {
            needPopulate = true;
        } else {
            needPopulate = false;
        }
        if (needPopulate) {
            setScrollingCacheEnabled(false);
            this.f445m.abortAnimation();
            int oldX = getScrollX();
            int oldY = getScrollY();
            int x = this.f445m.getCurrX();
            int y = this.f445m.getCurrY();
            if (!(oldX == x && oldY == y)) {
                scrollTo(x, y);
            }
        }
        this.f457y = false;
        for (int i = 0; i < this.f437e.size(); i++) {
            C0160b ii = (C0160b) this.f437e.get(i);
            if (ii.f395c) {
                needPopulate = true;
                ii.f395c = false;
            }
        }
        if (!needPopulate) {
            return;
        }
        if (postEvents) {
            C0264r.m1158a((View) this, this.ag);
        } else {
            this.ag.run();
        }
    }

    private boolean m618a(float x, float dx) {
        return (x < ((float) this.f415D) && dx > 0.0f) || (x > ((float) (getWidth() - this.f415D)) && dx < 0.0f);
    }

    private void m620b(boolean enable) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            C0264r.m1155a(getChildAt(i), enable ? 2 : 0, null);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int action = ev.getAction() & 255;
        if (action == 3 || action == 1) {
            this.f412A = false;
            this.f413B = false;
            this.f421J = -1;
            if (this.f422K != null) {
                this.f422K.recycle();
                this.f422K = null;
            }
            return false;
        }
        if (action != 0) {
            if (this.f412A) {
                return true;
            }
            if (this.f413B) {
                return false;
            }
        }
        switch (action) {
            case Base64.DEFAULT /*0*/:
                float x = ev.getX();
                this.f419H = x;
                this.f417F = x;
                x = ev.getY();
                this.f420I = x;
                this.f418G = x;
                this.f421J = C0247m.m1085b(ev, 0);
                this.f413B = false;
                this.f445m.computeScrollOffset();
                if (this.ah == 2 && Math.abs(this.f445m.getFinalX() - this.f445m.getCurrX()) > this.f426O) {
                    this.f445m.abortAnimation();
                    this.f457y = false;
                    m644c();
                    this.f412A = true;
                    m622c(true);
                    setScrollState(1);
                    break;
                }
                m617a(false);
                this.f412A = false;
                break;
                break;
            case Base64.NO_WRAP /*2*/:
                int activePointerId = this.f421J;
                if (activePointerId != -1) {
                    int pointerIndex = C0247m.m1083a(ev, activePointerId);
                    float x2 = C0247m.m1086c(ev, pointerIndex);
                    float dx = x2 - this.f417F;
                    float xDiff = Math.abs(dx);
                    float y = C0247m.m1088d(ev, pointerIndex);
                    float yDiff = Math.abs(y - this.f420I);
                    if (dx == 0.0f || m618a(this.f417F, dx) || !m640a(this, false, (int) dx, (int) x2, (int) y)) {
                        if (xDiff > ((float) this.f416E) && 0.5f * xDiff > yDiff) {
                            this.f412A = true;
                            m622c(true);
                            setScrollState(1);
                            this.f417F = dx > 0.0f ? this.f419H + ((float) this.f416E) : this.f419H - ((float) this.f416E);
                            this.f418G = y;
                            setScrollingCacheEnabled(true);
                        } else if (yDiff > ((float) this.f416E)) {
                            this.f413B = true;
                        }
                        if (this.f412A && m621b(x2)) {
                            C0264r.m1160b(this);
                            break;
                        }
                    }
                    this.f417F = x2;
                    this.f418G = y;
                    this.f413B = true;
                    return false;
                }
                break;
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                m616a(ev);
                break;
        }
        if (this.f422K == null) {
            this.f422K = VelocityTracker.obtain();
        }
        this.f422K.addMovement(ev);
        return this.f412A;
    }

    public boolean onTouchEvent(MotionEvent ev) {
        if (this.f427P) {
            return true;
        }
        if (ev.getAction() == 0 && ev.getEdgeFlags() != 0) {
            return false;
        }
        if (this.f440h != null) {
            if (this.f440h.m356b() != 0) {
                if (this.f422K == null) {
                    this.f422K = VelocityTracker.obtain();
                }
                this.f422K.addMovement(ev);
                boolean needsInvalidate = false;
                float x;
                switch (ev.getAction() & 255) {
                    case Base64.DEFAULT /*0*/:
                        this.f445m.abortAnimation();
                        this.f457y = false;
                        m644c();
                        x = ev.getX();
                        this.f419H = x;
                        this.f417F = x;
                        x = ev.getY();
                        this.f420I = x;
                        this.f418G = x;
                        this.f421J = C0247m.m1085b(ev, 0);
                        break;
                    case Base64.NO_PADDING /*1*/:
                        if (this.f412A) {
                            VelocityTracker velocityTracker = this.f422K;
                            velocityTracker.computeCurrentVelocity(LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, (float) this.f424M);
                            int initialVelocity = (int) C0252p.m1100a(velocityTracker, this.f421J);
                            this.f457y = true;
                            int width = getClientWidth();
                            int scrollX = getScrollX();
                            C0160b ii = m627i();
                            int currentPage = ii.f394b;
                            x = (float) scrollX;
                            float f = (float) width;
                            f = ii.f397e;
                            float pageOffset = ((r0 / r0) - r0) / ii.f396d;
                            int activePointerIndex = C0247m.m1083a(ev, this.f421J);
                            m638a(m609a(currentPage, pageOffset, initialVelocity, (int) (C0247m.m1086c(ev, activePointerIndex) - this.f419H)), true, true, initialVelocity);
                            this.f421J = -1;
                            m628j();
                            needsInvalidate = this.f428Q.m1342c() | this.f429R.m1342c();
                            break;
                        }
                        break;
                    case Base64.NO_WRAP /*2*/:
                        if (!this.f412A) {
                            int pointerIndex = C0247m.m1083a(ev, this.f421J);
                            float x2 = C0247m.m1086c(ev, pointerIndex);
                            float xDiff = Math.abs(x2 - this.f417F);
                            float y = C0247m.m1088d(ev, pointerIndex);
                            float yDiff = Math.abs(y - this.f418G);
                            if (xDiff > ((float) this.f416E) && xDiff > yDiff) {
                                this.f412A = true;
                                m622c(true);
                                if (x2 - this.f419H > 0.0f) {
                                    x = this.f419H + ((float) this.f416E);
                                } else {
                                    x = this.f419H - ((float) this.f416E);
                                }
                                this.f417F = x;
                                this.f418G = y;
                                setScrollState(1);
                                setScrollingCacheEnabled(true);
                                ViewParent parent = getParent();
                                if (parent != null) {
                                    parent.requestDisallowInterceptTouchEvent(true);
                                }
                            }
                        }
                        if (this.f412A) {
                            needsInvalidate = false | m621b(C0247m.m1086c(ev, C0247m.m1083a(ev, this.f421J)));
                            break;
                        }
                        break;
                    case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                        if (this.f412A) {
                            m613a(this.f441i, true, 0, false);
                            this.f421J = -1;
                            m628j();
                            needsInvalidate = this.f428Q.m1342c() | this.f429R.m1342c();
                            break;
                        }
                        break;
                    case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                        int index = C0247m.m1084b(ev);
                        this.f417F = C0247m.m1086c(ev, index);
                        this.f421J = C0247m.m1085b(ev, index);
                        break;
                    case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                        m616a(ev);
                        this.f417F = C0247m.m1086c(ev, C0247m.m1083a(ev, this.f421J));
                        break;
                }
                if (needsInvalidate) {
                    C0264r.m1160b(this);
                }
                return true;
            }
        }
        return false;
    }

    private void m622c(boolean disallowIntercept) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(disallowIntercept);
        }
    }

    private boolean m621b(float x) {
        boolean needsInvalidate = false;
        float deltaX = this.f417F - x;
        this.f417F = x;
        float scrollX = ((float) getScrollX()) + deltaX;
        int width = getClientWidth();
        float leftBound = ((float) width) * this.f451s;
        float rightBound = ((float) width) * this.f452t;
        boolean leftAbsolute = true;
        boolean rightAbsolute = true;
        C0160b firstItem = (C0160b) this.f437e.get(0);
        C0160b lastItem = (C0160b) this.f437e.get(this.f437e.size() - 1);
        if (firstItem.f394b != 0) {
            leftAbsolute = false;
            leftBound = firstItem.f397e * ((float) width);
        }
        if (lastItem.f394b != this.f440h.m356b() - 1) {
            rightAbsolute = false;
            rightBound = lastItem.f397e * ((float) width);
        }
        float f;
        if (scrollX < leftBound) {
            if (leftAbsolute) {
                f = (float) width;
                needsInvalidate = this.f428Q.m1339a(Math.abs(leftBound - scrollX) / r0);
            }
            scrollX = leftBound;
        } else if (scrollX > rightBound) {
            if (rightAbsolute) {
                f = (float) width;
                needsInvalidate = this.f429R.m1339a(Math.abs(scrollX - rightBound) / r0);
            }
            scrollX = rightBound;
        }
        this.f417F += scrollX - ((float) ((int) scrollX));
        scrollTo((int) scrollX, getScrollY());
        m623d((int) scrollX);
        return needsInvalidate;
    }

    private C0160b m627i() {
        float scrollOffset;
        float marginOffset = 0.0f;
        int width = getClientWidth();
        if (width > 0) {
            scrollOffset = ((float) getScrollX()) / ((float) width);
        } else {
            scrollOffset = 0.0f;
        }
        if (width > 0) {
            marginOffset = ((float) this.f447o) / ((float) width);
        }
        int lastPos = -1;
        float lastOffset = 0.0f;
        float lastWidth = 0.0f;
        boolean first = true;
        C0160b lastItem = null;
        int i = 0;
        while (i < this.f437e.size()) {
            C0160b ii = (C0160b) this.f437e.get(i);
            if (!(first || ii.f394b == lastPos + 1)) {
                ii = this.f438f;
                ii.f397e = (lastOffset + lastWidth) + marginOffset;
                ii.f394b = lastPos + 1;
                ii.f396d = this.f440h.m364d(ii.f394b);
                i--;
            }
            float offset = ii.f397e;
            float leftBound = offset;
            float rightBound = (ii.f396d + offset) + marginOffset;
            if (!first && scrollOffset < leftBound) {
                return lastItem;
            }
            if (scrollOffset < rightBound || i == this.f437e.size() - 1) {
                return ii;
            }
            first = false;
            lastPos = ii.f394b;
            lastOffset = offset;
            lastWidth = ii.f396d;
            lastItem = ii;
            i++;
        }
        return lastItem;
    }

    private int m609a(int currentPage, float pageOffset, int velocity, int deltaX) {
        int targetPage;
        if (Math.abs(deltaX) <= this.f425N || Math.abs(velocity) <= this.f423L) {
            targetPage = (int) ((((float) currentPage) + pageOffset) + (currentPage >= this.f441i ? 0.4f : 0.6f));
        } else {
            targetPage = velocity > 0 ? currentPage : currentPage + 1;
        }
        if (this.f437e.size() <= 0) {
            return targetPage;
        }
        return Math.max(((C0160b) this.f437e.get(0)).f394b, Math.min(targetPage, ((C0160b) this.f437e.get(this.f437e.size() - 1)).f394b));
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        boolean needsInvalidate = false;
        int overScrollMode = C0264r.m1153a(this);
        if (overScrollMode == 0 || (overScrollMode == 1 && this.f440h != null && this.f440h.m356b() > 1)) {
            int restoreCount;
            int height;
            int width;
            if (!this.f428Q.m1338a()) {
                restoreCount = canvas.save();
                height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                width = getWidth();
                canvas.rotate(BitmapDescriptorFactory.HUE_VIOLET);
                canvas.translate((float) ((-height) + getPaddingTop()), this.f451s * ((float) width));
                this.f428Q.m1337a(height, width);
                needsInvalidate = false | this.f428Q.m1340a(canvas);
                canvas.restoreToCount(restoreCount);
            }
            if (!this.f429R.m1338a()) {
                restoreCount = canvas.save();
                width = getWidth();
                height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate((float) (-getPaddingTop()), (-(this.f452t + 1.0f)) * ((float) width));
                this.f429R.m1337a(height, width);
                needsInvalidate |= this.f429R.m1340a(canvas);
                canvas.restoreToCount(restoreCount);
            }
        } else {
            this.f428Q.m1341b();
            this.f429R.m1341b();
        }
        if (needsInvalidate) {
            C0264r.m1160b(this);
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f447o > 0 && this.f448p != null && this.f437e.size() > 0 && this.f440h != null) {
            int scrollX = getScrollX();
            int width = getWidth();
            float marginOffset = ((float) this.f447o) / ((float) width);
            int itemIndex = 0;
            C0160b ii = (C0160b) this.f437e.get(0);
            float offset = ii.f397e;
            int itemCount = this.f437e.size();
            int firstPos = ii.f394b;
            int lastPos = ((C0160b) this.f437e.get(itemCount - 1)).f394b;
            int pos = firstPos;
            while (pos < lastPos) {
                float drawAt;
                while (pos > ii.f394b && itemIndex < itemCount) {
                    itemIndex++;
                    ii = (C0160b) this.f437e.get(itemIndex);
                }
                if (pos == ii.f394b) {
                    drawAt = (ii.f397e + ii.f396d) * ((float) width);
                    offset = (ii.f397e + ii.f396d) + marginOffset;
                } else {
                    float widthFactor = this.f440h.m364d(pos);
                    drawAt = (offset + widthFactor) * ((float) width);
                    offset += widthFactor + marginOffset;
                }
                if (((float) this.f447o) + drawAt > ((float) scrollX)) {
                    this.f448p.setBounds((int) drawAt, this.f449q, (int) ((((float) this.f447o) + drawAt) + 0.5f), this.f450r);
                    this.f448p.draw(canvas);
                }
                if (drawAt <= ((float) (scrollX + width))) {
                    pos++;
                } else {
                    return;
                }
            }
        }
    }

    private void m616a(MotionEvent ev) {
        int pointerIndex = C0247m.m1084b(ev);
        if (C0247m.m1085b(ev, pointerIndex) == this.f421J) {
            int newPointerIndex = pointerIndex == 0 ? 1 : 0;
            this.f417F = C0247m.m1086c(ev, newPointerIndex);
            this.f421J = C0247m.m1085b(ev, newPointerIndex);
            if (this.f422K != null) {
                this.f422K.clear();
            }
        }
    }

    private void m628j() {
        this.f412A = false;
        this.f413B = false;
        if (this.f422K != null) {
            this.f422K.recycle();
            this.f422K = null;
        }
    }

    private void setScrollingCacheEnabled(boolean enabled) {
        if (this.f456x != enabled) {
            this.f456x = enabled;
        }
    }

    public boolean canScrollHorizontally(int direction) {
        boolean z = true;
        if (this.f440h == null) {
            return false;
        }
        int width = getClientWidth();
        int scrollX = getScrollX();
        if (direction < 0) {
            if (scrollX <= ((int) (((float) width) * this.f451s))) {
                z = false;
            }
            return z;
        } else if (direction <= 0) {
            return false;
        } else {
            if (scrollX >= ((int) (((float) width) * this.f452t))) {
                z = false;
            }
            return z;
        }
    }

    protected boolean m640a(View v, boolean checkV, int dx, int x, int y) {
        if (v instanceof ViewGroup) {
            ViewGroup group = (ViewGroup) v;
            int scrollX = v.getScrollX();
            int scrollY = v.getScrollY();
            for (int i = group.getChildCount() - 1; i >= 0; i--) {
                View child = group.getChildAt(i);
                if (x + scrollX >= child.getLeft() && x + scrollX < child.getRight() && y + scrollY >= child.getTop() && y + scrollY < child.getBottom()) {
                    if (m640a(child, true, dx, (x + scrollX) - child.getLeft(), (y + scrollY) - child.getTop())) {
                        return true;
                    }
                }
            }
        }
        return checkV && C0264r.m1159a(v, -dx);
    }

    public boolean dispatchKeyEvent(KeyEvent event) {
        return super.dispatchKeyEvent(event) || m639a(event);
    }

    public boolean m639a(KeyEvent event) {
        if (event.getAction() != 0) {
            return false;
        }
        switch (event.getKeyCode()) {
            case MMException.DISPLAY_AD_EXPIRED /*21*/:
                return m645c(17);
            case MMException.DISPLAY_AD_NOT_FOUND /*22*/:
                return m645c(66);
            case 61:
                if (VERSION.SDK_INT < 11) {
                    return false;
                }
                if (C0230g.m1015a(event)) {
                    return m645c(2);
                }
                if (C0230g.m1016a(event, 1)) {
                    return m645c(1);
                }
                return false;
            default:
                return false;
        }
    }

    public boolean m645c(int direction) {
        View currentFocused = findFocus();
        if (currentFocused == this) {
            currentFocused = null;
        } else if (currentFocused != null) {
            boolean isChild = false;
            for (ViewPager parent = currentFocused.getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
                if (parent == this) {
                    isChild = true;
                    break;
                }
            }
            if (!isChild) {
                StringBuilder sb = new StringBuilder();
                sb.append(currentFocused.getClass().getSimpleName());
                for (ViewParent parent2 = currentFocused.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                    sb.append(" => ").append(parent2.getClass().getSimpleName());
                }
                Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + sb.toString());
                currentFocused = null;
            }
        }
        boolean handled = false;
        View nextFocused = FocusFinder.getInstance().findNextFocus(this, currentFocused, direction);
        if (nextFocused == null || nextFocused == currentFocused) {
            if (direction == 17 || direction == 1) {
                handled = m646d();
            } else if (direction == 66 || direction == 2) {
                handled = m647e();
            }
        } else if (direction == 17) {
            handled = (currentFocused == null || m610a(this.f439g, nextFocused).left < m610a(this.f439g, currentFocused).left) ? nextFocused.requestFocus() : m646d();
        } else if (direction == 66) {
            handled = (currentFocused == null || m610a(this.f439g, nextFocused).left > m610a(this.f439g, currentFocused).left) ? nextFocused.requestFocus() : m647e();
        }
        if (handled) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(direction));
        }
        return handled;
    }

    private Rect m610a(Rect outRect, View child) {
        if (outRect == null) {
            outRect = new Rect();
        }
        if (child == null) {
            outRect.set(0, 0, 0, 0);
        } else {
            outRect.left = child.getLeft();
            outRect.right = child.getRight();
            outRect.top = child.getTop();
            outRect.bottom = child.getBottom();
            ViewGroup parent = child.getParent();
            while ((parent instanceof ViewGroup) && parent != this) {
                ViewGroup group = parent;
                outRect.left += group.getLeft();
                outRect.right += group.getRight();
                outRect.top += group.getTop();
                outRect.bottom += group.getBottom();
                parent = group.getParent();
            }
        }
        return outRect;
    }

    boolean m646d() {
        if (this.f441i <= 0) {
            return false;
        }
        m636a(this.f441i - 1, true);
        return true;
    }

    boolean m647e() {
        if (this.f440h == null || this.f441i >= this.f440h.m356b() - 1) {
            return false;
        }
        m636a(this.f441i + 1, true);
        return true;
    }

    public void addFocusables(ArrayList views, int direction, int focusableMode) {
        int focusableCount = views.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i = 0; i < getChildCount(); i++) {
                View child = getChildAt(i);
                if (child.getVisibility() == 0) {
                    C0160b ii = m631a(child);
                    if (ii != null && ii.f394b == this.f441i) {
                        child.addFocusables(views, direction, focusableMode);
                    }
                }
            }
        }
        if ((descendantFocusability == 262144 && focusableCount != views.size()) || !isFocusable()) {
            return;
        }
        if (((focusableMode & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) && views != null) {
            views.add(this);
        }
    }

    public void addTouchables(ArrayList views) {
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            if (child.getVisibility() == 0) {
                C0160b ii = m631a(child);
                if (ii != null && ii.f394b == this.f441i) {
                    child.addTouchables(views);
                }
            }
        }
    }

    protected boolean onRequestFocusInDescendants(int direction, Rect previouslyFocusedRect) {
        int index;
        int increment;
        int end;
        int count = getChildCount();
        if ((direction & 2) != 0) {
            index = 0;
            increment = 1;
            end = count;
        } else {
            index = count - 1;
            increment = -1;
            end = -1;
        }
        for (int i = index; i != end; i += increment) {
            View child = getChildAt(i);
            if (child.getVisibility() == 0) {
                C0160b ii = m631a(child);
                if (ii != null && ii.f394b == this.f441i && child.requestFocus(direction, previouslyFocusedRect)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        if (event.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(event);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            if (child.getVisibility() == 0) {
                C0160b ii = m631a(child);
                if (ii != null && ii.f394b == this.f441i && child.dispatchPopulateAccessibilityEvent(event)) {
                    return true;
                }
            }
        }
        return false;
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new C0161c();
    }

    protected LayoutParams generateLayoutParams(LayoutParams p) {
        return generateDefaultLayoutParams();
    }

    protected boolean checkLayoutParams(LayoutParams p) {
        return (p instanceof C0161c) && super.checkLayoutParams(p);
    }

    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new C0161c(getContext(), attrs);
    }
}
