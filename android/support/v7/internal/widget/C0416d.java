package android.support.v7.internal.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewDebug.CapturedViewProperty;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

/* renamed from: android.support.v7.internal.widget.d */
abstract class C0416d extends ViewGroup {
    int f931A;
    int f932B;
    long f933C;
    boolean f934D;
    private int f935a;
    private View f936b;
    private boolean f937c;
    private boolean f938d;
    private C0450e f939e;
    @ExportedProperty(category = "scrolling")
    int f940k;
    int f941l;
    int f942m;
    long f943n;
    long f944o;
    boolean f945p;
    int f946q;
    boolean f947r;
    C0419d f948s;
    C0431b f949t;
    boolean f950u;
    @ExportedProperty(category = "list")
    int f951v;
    long f952w;
    @ExportedProperty(category = "list")
    int f953x;
    long f954y;
    @ExportedProperty(category = "list")
    int f955z;

    /* renamed from: android.support.v7.internal.widget.d.d */
    public interface C0419d {
        void m2042a(C0416d c0416d);

        void m2043a(C0416d c0416d, View view, int i, long j);
    }

    /* renamed from: android.support.v7.internal.widget.d.b */
    public interface C0431b {
        void m2109a(C0416d c0416d, View view, int i, long j);
    }

    /* renamed from: android.support.v7.internal.widget.d.a */
    class C0448a extends DataSetObserver {
        final /* synthetic */ C0416d f1157a;
        private Parcelable f1158b;

        C0448a(C0416d c0416d) {
            this.f1157a = c0416d;
            this.f1158b = null;
        }

        public void onChanged() {
            this.f1157a.f950u = true;
            this.f1157a.f931A = this.f1157a.f955z;
            this.f1157a.f955z = this.f1157a.m1998e().getCount();
            if (!this.f1157a.m1998e().hasStableIds() || this.f1158b == null || this.f1157a.f931A != 0 || this.f1157a.f955z <= 0) {
                this.f1157a.m2007n();
            } else {
                this.f1157a.onRestoreInstanceState(this.f1158b);
                this.f1158b = null;
            }
            this.f1157a.m2002i();
            this.f1157a.requestLayout();
        }

        public void onInvalidated() {
            this.f1157a.f950u = true;
            if (this.f1157a.m1998e().hasStableIds()) {
                this.f1158b = this.f1157a.onSaveInstanceState();
            }
            this.f1157a.f931A = this.f1157a.f955z;
            this.f1157a.f955z = 0;
            this.f1157a.f953x = -1;
            this.f1157a.f954y = Long.MIN_VALUE;
            this.f1157a.f951v = -1;
            this.f1157a.f952w = Long.MIN_VALUE;
            this.f1157a.f945p = false;
            this.f1157a.m2002i();
            this.f1157a.requestLayout();
        }
    }

    /* renamed from: android.support.v7.internal.widget.d.c */
    class C0449c implements OnItemClickListener {
        final /* synthetic */ C0416d f1159a;
        private final C0431b f1160b;

        public C0449c(C0416d c0416d, C0431b listener) {
            this.f1159a = c0416d;
            this.f1160b = listener;
        }

        public void onItemClick(AdapterView parent, View view, int position, long id) {
            this.f1160b.m2109a(this.f1159a, view, position, id);
        }
    }

    /* renamed from: android.support.v7.internal.widget.d.e */
    private class C0450e implements Runnable {
        final /* synthetic */ C0416d f1161a;

        private C0450e(C0416d c0416d) {
            this.f1161a = c0416d;
        }

        public void run() {
            if (!this.f1161a.f950u) {
                this.f1161a.m1986a();
            } else if (this.f1161a.m1998e() != null) {
                this.f1161a.post(this);
            }
        }
    }

    public abstract View m1995c();

    public abstract Adapter m1998e();

    C0416d(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.f940k = 0;
        this.f943n = Long.MIN_VALUE;
        this.f945p = false;
        this.f947r = false;
        this.f951v = -1;
        this.f952w = Long.MIN_VALUE;
        this.f953x = -1;
        this.f954y = Long.MIN_VALUE;
        this.f932B = -1;
        this.f933C = Long.MIN_VALUE;
        this.f934D = false;
    }

    public void m1991a(C0431b listener) {
        this.f949t = listener;
    }

    public boolean m1993a(View view, int position, long id) {
        if (this.f949t == null) {
            return false;
        }
        playSoundEffect(0);
        if (view != null) {
            view.sendAccessibilityEvent(1);
        }
        this.f949t.m2109a(this, view, position, id);
        return true;
    }

    public void m1992a(C0419d listener) {
        this.f948s = listener;
    }

    public void addView(View child) {
        throw new UnsupportedOperationException("addView(View) is not supported in AdapterView");
    }

    public void addView(View child, int index) {
        throw new UnsupportedOperationException("addView(View, int) is not supported in AdapterView");
    }

    public void addView(View child, LayoutParams params) {
        throw new UnsupportedOperationException("addView(View, LayoutParams) is not supported in AdapterView");
    }

    public void addView(View child, int index, LayoutParams params) {
        throw new UnsupportedOperationException("addView(View, int, LayoutParams) is not supported in AdapterView");
    }

    public void removeView(View child) {
        throw new UnsupportedOperationException("removeView(View) is not supported in AdapterView");
    }

    public void removeViewAt(int index) {
        throw new UnsupportedOperationException("removeViewAt(int) is not supported in AdapterView");
    }

    public void removeAllViews() {
        throw new UnsupportedOperationException("removeAllViews() is not supported in AdapterView");
    }

    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        this.f935a = getHeight();
    }

    @CapturedViewProperty
    public int m1999f() {
        return this.f951v;
    }

    @CapturedViewProperty
    public long m2000g() {
        return this.f952w;
    }

    boolean m2001h() {
        return false;
    }

    public void setFocusable(boolean focusable) {
        boolean z = true;
        Adapter adapter = m1998e();
        boolean empty;
        if (adapter == null || adapter.getCount() == 0) {
            empty = true;
        } else {
            empty = false;
        }
        this.f937c = focusable;
        if (!focusable) {
            this.f938d = false;
        }
        if (!focusable || (empty && !m2001h())) {
            z = false;
        }
        super.setFocusable(z);
    }

    public void setFocusableInTouchMode(boolean focusable) {
        boolean z = true;
        Adapter adapter = m1998e();
        boolean empty;
        if (adapter == null || adapter.getCount() == 0) {
            empty = true;
        } else {
            empty = false;
        }
        this.f938d = focusable;
        if (focusable) {
            this.f937c = true;
        }
        if (!focusable || (empty && !m2001h())) {
            z = false;
        }
        super.setFocusableInTouchMode(z);
    }

    void m2002i() {
        boolean empty;
        boolean focusable;
        boolean z;
        boolean z2 = false;
        Adapter adapter = m1998e();
        if (adapter == null || adapter.getCount() == 0) {
            empty = true;
        } else {
            empty = false;
        }
        if (!empty || m2001h()) {
            focusable = true;
        } else {
            focusable = false;
        }
        if (focusable && this.f938d) {
            z = true;
        } else {
            z = false;
        }
        super.setFocusableInTouchMode(z);
        if (focusable && this.f937c) {
            z = true;
        } else {
            z = false;
        }
        super.setFocusable(z);
        if (this.f936b != null) {
            if (adapter == null || adapter.isEmpty()) {
                z2 = true;
            }
            m1988a(z2);
        }
    }

    private void m1988a(boolean empty) {
        if (m2001h()) {
            empty = false;
        }
        if (empty) {
            if (this.f936b != null) {
                this.f936b.setVisibility(0);
                setVisibility(8);
            } else {
                setVisibility(0);
            }
            if (this.f950u) {
                onLayout(false, getLeft(), getTop(), getRight(), getBottom());
                return;
            }
            return;
        }
        if (this.f936b != null) {
            this.f936b.setVisibility(8);
        }
        setVisibility(0);
    }

    public long m1994b(int position) {
        Adapter adapter = m1998e();
        return (adapter == null || position < 0) ? Long.MIN_VALUE : adapter.getItemId(position);
    }

    public void setOnClickListener(OnClickListener l) {
        throw new RuntimeException("Don't call setOnClickListener for an AdapterView. You probably want setOnItemClickListener instead");
    }

    protected void dispatchSaveInstanceState(SparseArray container) {
        dispatchFreezeSelfOnly(container);
    }

    protected void dispatchRestoreInstanceState(SparseArray container) {
        dispatchThawSelfOnly(container);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f939e);
    }

    void m2003j() {
        if (this.f948s != null) {
            if (this.f947r || this.f934D) {
                if (this.f939e == null) {
                    this.f939e = new C0450e();
                }
                post(this.f939e);
            } else {
                m1986a();
            }
        }
        if (this.f953x != -1 && isShown() && !isInTouchMode()) {
            sendAccessibilityEvent(4);
        }
    }

    private void m1986a() {
        if (this.f948s != null) {
            int selection = m1999f();
            if (selection >= 0) {
                View v = m1995c();
                this.f948s.m2043a(this, v, selection, m1998e().getItemId(selection));
                return;
            }
            this.f948s.m2042a(this);
        }
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        View selectedView = m1995c();
        if (selectedView != null && selectedView.getVisibility() == 0 && selectedView.dispatchPopulateAccessibilityEvent(event)) {
            return true;
        }
        return false;
    }

    protected boolean canAnimate() {
        return super.canAnimate() && this.f955z > 0;
    }

    void m2004k() {
        int count = this.f955z;
        boolean found = false;
        if (count > 0) {
            int newPos;
            if (this.f945p) {
                this.f945p = false;
                newPos = m2006m();
                if (newPos >= 0 && m1990a(newPos, true) == newPos) {
                    m1997d(newPos);
                    found = true;
                }
            }
            if (!found) {
                newPos = m1999f();
                if (newPos >= count) {
                    newPos = count - 1;
                }
                if (newPos < 0) {
                    newPos = 0;
                }
                int selectablePos = m1990a(newPos, true);
                if (selectablePos < 0) {
                    selectablePos = m1990a(newPos, false);
                }
                if (selectablePos >= 0) {
                    m1997d(selectablePos);
                    m2005l();
                    found = true;
                }
            }
        }
        if (!found) {
            this.f953x = -1;
            this.f954y = Long.MIN_VALUE;
            this.f951v = -1;
            this.f952w = Long.MIN_VALUE;
            this.f945p = false;
            m2005l();
        }
    }

    void m2005l() {
        if (this.f953x != this.f932B || this.f954y != this.f933C) {
            m2003j();
            this.f932B = this.f953x;
            this.f933C = this.f954y;
        }
    }

    int m2006m() {
        int count = this.f955z;
        if (count == 0) {
            return -1;
        }
        long idToMatch = this.f943n;
        int seed = this.f942m;
        if (idToMatch == Long.MIN_VALUE) {
            return -1;
        }
        seed = Math.min(count - 1, Math.max(0, seed));
        long endTime = SystemClock.uptimeMillis() + 100;
        int first = seed;
        int last = seed;
        boolean next = false;
        Adapter adapter = m1998e();
        if (adapter == null) {
            return -1;
        }
        while (SystemClock.uptimeMillis() <= endTime) {
            if (adapter.getItemId(seed) != idToMatch) {
                boolean hitLast = last == count + -1;
                boolean hitFirst = first == 0;
                if (hitLast && hitFirst) {
                    break;
                } else if (hitFirst || (next && !hitLast)) {
                    last++;
                    seed = last;
                    next = false;
                } else if (hitLast || !(next || hitFirst)) {
                    first--;
                    seed = first;
                    next = true;
                }
            } else {
                return seed;
            }
        }
        return -1;
    }

    int m1990a(int position, boolean lookDown) {
        return position;
    }

    void m1996c(int position) {
        this.f953x = position;
        this.f954y = m1994b(position);
    }

    void m1997d(int position) {
        this.f951v = position;
        this.f952w = m1994b(position);
        if (this.f945p && this.f946q == 0 && position >= 0) {
            this.f942m = position;
            this.f943n = this.f952w;
        }
    }

    void m2007n() {
        if (getChildCount() > 0) {
            this.f945p = true;
            this.f944o = (long) this.f935a;
            View v;
            if (this.f953x >= 0) {
                v = getChildAt(this.f953x - this.f940k);
                this.f943n = this.f952w;
                this.f942m = this.f951v;
                if (v != null) {
                    this.f941l = v.getTop();
                }
                this.f946q = 0;
                return;
            }
            v = getChildAt(0);
            Adapter adapter = m1998e();
            if (this.f940k < 0 || this.f940k >= adapter.getCount()) {
                this.f943n = -1;
            } else {
                this.f943n = adapter.getItemId(this.f940k);
            }
            this.f942m = this.f940k;
            if (v != null) {
                this.f941l = v.getTop();
            }
            this.f946q = 1;
        }
    }
}
