package android.support.v7.internal.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v7.internal.widget.C0416d.C0448a;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.Adapter;
import android.widget.SpinnerAdapter;

abstract class AbsSpinnerICS extends C0416d {
    private DataSetObserver f956E;
    SpinnerAdapter f957a;
    int f958b;
    int f959c;
    boolean f960d;
    int f961e;
    int f962f;
    int f963g;
    int f964h;
    final Rect f965i;
    final C0415a f966j;

    static class SavedState extends BaseSavedState {
        public static final Creator CREATOR;
        long f927a;
        int f928b;

        /* renamed from: android.support.v7.internal.widget.AbsSpinnerICS.SavedState.1 */
        static class C04141 implements Creator {
            C04141() {
            }

            public /* synthetic */ Object createFromParcel(Parcel x0) {
                return m1980a(x0);
            }

            public /* synthetic */ Object[] newArray(int x0) {
                return m1981a(x0);
            }

            public SavedState m1980a(Parcel in) {
                return new SavedState(null);
            }

            public SavedState[] m1981a(int size) {
                return new SavedState[size];
            }
        }

        SavedState(Parcelable superState) {
            super(superState);
        }

        private SavedState(Parcel in) {
            super(in);
            this.f927a = in.readLong();
            this.f928b = in.readInt();
        }

        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeLong(this.f927a);
            out.writeInt(this.f928b);
        }

        public String toString() {
            return "AbsSpinner.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " selectedId=" + this.f927a + " position=" + this.f928b + "}";
        }

        static {
            CREATOR = new C04141();
        }
    }

    /* renamed from: android.support.v7.internal.widget.AbsSpinnerICS.a */
    class C0415a {
        final /* synthetic */ AbsSpinnerICS f929a;
        private final SparseArray f930b;

        C0415a(AbsSpinnerICS absSpinnerICS) {
            this.f929a = absSpinnerICS;
            this.f930b = new SparseArray();
        }

        public void m1984a(int position, View v) {
            this.f930b.put(position, v);
        }

        View m1982a(int position) {
            View result = (View) this.f930b.get(position);
            if (result != null) {
                this.f930b.delete(position);
            }
            return result;
        }

        void m1983a() {
            SparseArray scrapHeap = this.f930b;
            int count = scrapHeap.size();
            for (int i = 0; i < count; i++) {
                View view = (View) scrapHeap.valueAt(i);
                if (view != null) {
                    this.f929a.removeDetachedView(view, true);
                }
            }
            scrapHeap.clear();
        }
    }

    public /* synthetic */ Adapter m2018e() {
        return m2017d();
    }

    AbsSpinnerICS(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.f961e = 0;
        this.f962f = 0;
        this.f963g = 0;
        this.f964h = 0;
        this.f965i = new Rect();
        this.f966j = new C0415a(this);
        m2009o();
    }

    private void m2009o() {
        setFocusable(true);
        setWillNotDraw(false);
    }

    public void m2013a(SpinnerAdapter adapter) {
        int position = -1;
        if (this.f957a != null) {
            this.f957a.unregisterDataSetObserver(this.f956E);
            m2011a();
        }
        this.f957a = adapter;
        this.B = -1;
        this.C = Long.MIN_VALUE;
        if (this.f957a != null) {
            this.A = this.z;
            this.z = this.f957a.getCount();
            m2002i();
            this.f956E = new C0448a(this);
            this.f957a.registerDataSetObserver(this.f956E);
            if (this.z > 0) {
                position = 0;
            }
            m1996c(position);
            m1997d(position);
            if (this.z == 0) {
                m2005l();
            }
        } else {
            m2002i();
            m2011a();
            m2005l();
        }
        requestLayout();
    }

    void m2011a() {
        this.u = false;
        this.p = false;
        removeAllViewsInLayout();
        this.B = -1;
        this.C = Long.MIN_VALUE;
        m1996c(-1);
        m1997d(-1);
        invalidate();
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        Rect rect = this.f965i;
        int i = this.f961e;
        if (paddingLeft <= r0) {
            paddingLeft = this.f961e;
        }
        rect.left = paddingLeft;
        rect = this.f965i;
        i = this.f962f;
        if (paddingTop <= r0) {
            paddingTop = this.f962f;
        }
        rect.top = paddingTop;
        rect = this.f965i;
        i = this.f963g;
        if (paddingRight <= r0) {
            paddingRight = this.f963g;
        }
        rect.right = paddingRight;
        rect = this.f965i;
        i = this.f964h;
        if (paddingBottom <= r0) {
            paddingBottom = this.f964h;
        }
        rect.bottom = paddingBottom;
        if (this.u) {
            m2004k();
        }
        int preferredHeight = 0;
        int preferredWidth = 0;
        boolean needsMeasuring = true;
        int selectedPosition = m1999f();
        if (selectedPosition >= 0 && this.f957a != null && selectedPosition < this.f957a.getCount()) {
            View view = this.f966j.m1982a(selectedPosition);
            if (view == null) {
                view = this.f957a.getView(selectedPosition, null, this);
            }
            if (view != null) {
                this.f966j.m1984a(selectedPosition, view);
            }
            if (view != null) {
                if (view.getLayoutParams() == null) {
                    this.f960d = true;
                    view.setLayoutParams(generateDefaultLayoutParams());
                    this.f960d = false;
                }
                measureChild(view, widthMeasureSpec, heightMeasureSpec);
                i = this.f965i.top;
                preferredHeight = (m2010a(view) + r0) + this.f965i.bottom;
                i = this.f965i.left;
                preferredWidth = (m2014b(view) + r0) + this.f965i.right;
                needsMeasuring = false;
            }
        }
        if (needsMeasuring) {
            preferredHeight = this.f965i.top + this.f965i.bottom;
            if (widthMode == 0) {
                preferredWidth = this.f965i.left + this.f965i.right;
            }
        }
        preferredHeight = Math.max(preferredHeight, getSuggestedMinimumHeight());
        preferredWidth = Math.max(preferredWidth, getSuggestedMinimumWidth());
        int heightSize = resolveSize(preferredHeight, heightMeasureSpec);
        setMeasuredDimension(resolveSize(preferredWidth, widthMeasureSpec), heightSize);
        this.f958b = heightMeasureSpec;
        this.f959c = widthMeasureSpec;
    }

    int m2010a(View child) {
        return child.getMeasuredHeight();
    }

    int m2014b(View child) {
        return child.getMeasuredWidth();
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -2);
    }

    void m2015b() {
        int childCount = getChildCount();
        C0415a recycleBin = this.f966j;
        int position = this.k;
        for (int i = 0; i < childCount; i++) {
            recycleBin.m1984a(position + i, getChildAt(i));
        }
    }

    public void m2012a(int position) {
        m1997d(position);
        requestLayout();
        invalidate();
    }

    public View m2016c() {
        if (this.z <= 0 || this.x < 0) {
            return null;
        }
        return getChildAt(this.x - this.k);
    }

    public void requestLayout() {
        if (!this.f960d) {
            super.requestLayout();
        }
    }

    public SpinnerAdapter m2017d() {
        return this.f957a;
    }

    public Parcelable onSaveInstanceState() {
        SavedState ss = new SavedState(super.onSaveInstanceState());
        ss.f927a = m2000g();
        if (ss.f927a >= 0) {
            ss.f928b = m1999f();
        } else {
            ss.f928b = -1;
        }
        return ss;
    }

    public void onRestoreInstanceState(Parcelable state) {
        SavedState ss = (SavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());
        if (ss.f927a >= 0) {
            this.u = true;
            this.p = true;
            this.n = ss.f927a;
            this.m = ss.f928b;
            this.q = 0;
            requestLayout();
        }
    }
}
