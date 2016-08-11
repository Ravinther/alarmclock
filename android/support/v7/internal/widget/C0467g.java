package android.support.v7.internal.widget;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.internal.widget.C0416d.C0431b;
import android.support.v7.internal.widget.C0416d.C0449c;
import android.support.v7.p014b.C0364a.C0363j;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ListAdapter;
import android.widget.SpinnerAdapter;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

/* renamed from: android.support.v7.internal.widget.g */
class C0467g extends AbsSpinnerICS implements OnClickListener {
    int f1210E;
    private C0462d f1211F;
    private C0464b f1212G;
    private int f1213H;
    private Rect f1214I;

    /* renamed from: android.support.v7.internal.widget.g.d */
    private interface C0462d {
        void m2206a(ListAdapter listAdapter);

        void m2207a(CharSequence charSequence);

        void m2208c();

        void m2209d();

        boolean m2210f();
    }

    /* renamed from: android.support.v7.internal.widget.g.a */
    private class C0463a implements OnClickListener, C0462d {
        final /* synthetic */ C0467g f1199a;
        private AlertDialog f1200b;
        private ListAdapter f1201c;
        private CharSequence f1202d;

        private C0463a(C0467g c0467g) {
            this.f1199a = c0467g;
        }

        public void m2214d() {
            this.f1200b.dismiss();
            this.f1200b = null;
        }

        public boolean m2215f() {
            return this.f1200b != null ? this.f1200b.isShowing() : false;
        }

        public void m2211a(ListAdapter adapter) {
            this.f1201c = adapter;
        }

        public void m2212a(CharSequence hintText) {
            this.f1202d = hintText;
        }

        public void m2213c() {
            Builder builder = new Builder(this.f1199a.getContext());
            if (this.f1202d != null) {
                builder.setTitle(this.f1202d);
            }
            this.f1200b = builder.setSingleChoiceItems(this.f1201c, this.f1199a.m1999f(), this).show();
        }

        public void onClick(DialogInterface dialog, int which) {
            this.f1199a.m2012a(which);
            if (this.f1199a.t != null) {
                this.f1199a.m1993a(null, which, this.f1201c.getItemId(which));
            }
            m2214d();
        }
    }

    /* renamed from: android.support.v7.internal.widget.g.b */
    private static class C0464b implements ListAdapter, SpinnerAdapter {
        private SpinnerAdapter f1203a;
        private ListAdapter f1204b;

        public C0464b(SpinnerAdapter adapter) {
            this.f1203a = adapter;
            if (adapter instanceof ListAdapter) {
                this.f1204b = (ListAdapter) adapter;
            }
        }

        public int getCount() {
            return this.f1203a == null ? 0 : this.f1203a.getCount();
        }

        public Object getItem(int position) {
            return this.f1203a == null ? null : this.f1203a.getItem(position);
        }

        public long getItemId(int position) {
            return this.f1203a == null ? -1 : this.f1203a.getItemId(position);
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            return getDropDownView(position, convertView, parent);
        }

        public View getDropDownView(int position, View convertView, ViewGroup parent) {
            return this.f1203a == null ? null : this.f1203a.getDropDownView(position, convertView, parent);
        }

        public boolean hasStableIds() {
            return this.f1203a != null && this.f1203a.hasStableIds();
        }

        public void registerDataSetObserver(DataSetObserver observer) {
            if (this.f1203a != null) {
                this.f1203a.registerDataSetObserver(observer);
            }
        }

        public void unregisterDataSetObserver(DataSetObserver observer) {
            if (this.f1203a != null) {
                this.f1203a.unregisterDataSetObserver(observer);
            }
        }

        public boolean areAllItemsEnabled() {
            ListAdapter adapter = this.f1204b;
            if (adapter != null) {
                return adapter.areAllItemsEnabled();
            }
            return true;
        }

        public boolean isEnabled(int position) {
            ListAdapter adapter = this.f1204b;
            if (adapter != null) {
                return adapter.isEnabled(position);
            }
            return true;
        }

        public int getItemViewType(int position) {
            return 0;
        }

        public int getViewTypeCount() {
            return 1;
        }

        public boolean isEmpty() {
            return getCount() == 0;
        }
    }

    /* renamed from: android.support.v7.internal.widget.g.c */
    private class C0466c extends C0460f implements C0462d {
        final /* synthetic */ C0467g f1207b;
        private CharSequence f1208c;
        private ListAdapter f1209d;

        /* renamed from: android.support.v7.internal.widget.g.c.1 */
        class C04651 implements C0431b {
            final /* synthetic */ C0467g f1205a;
            final /* synthetic */ C0466c f1206b;

            C04651(C0466c c0466c, C0467g c0467g) {
                this.f1206b = c0466c;
                this.f1205a = c0467g;
            }

            public void m2216a(C0416d parent, View v, int position, long id) {
                this.f1206b.f1207b.m2012a(position);
                if (this.f1206b.f1207b.t != null) {
                    this.f1206b.f1207b.m1993a(v, position, this.f1206b.f1209d.getItemId(position));
                }
                this.f1206b.m2197d();
            }
        }

        public C0466c(C0467g c0467g, Context context, AttributeSet attrs, int defStyleRes) {
            this.f1207b = c0467g;
            super(context, attrs, defStyleRes);
            m2188a((View) c0467g);
            m2192a(true);
            m2186a(0);
            m2189a(new C0449c(c0467g, new C04651(this, c0467g)));
        }

        public void m2218a(ListAdapter adapter) {
            super.m2190a(adapter);
            this.f1209d = adapter;
        }

        public void m2219a(CharSequence hintText) {
            this.f1208c = hintText;
        }

        public void m2220c() {
            int spinnerPaddingLeft = this.f1207b.getPaddingLeft();
            int spinnerWidth;
            if (this.f1207b.f1210E == -2) {
                spinnerWidth = this.f1207b.getWidth();
                m2200e(Math.max(this.f1207b.m2224a((SpinnerAdapter) this.f1209d, m2185a()), (spinnerWidth - spinnerPaddingLeft) - this.f1207b.getPaddingRight()));
            } else if (this.f1207b.f1210E == -1) {
                spinnerWidth = this.f1207b.getWidth();
                m2200e((spinnerWidth - spinnerPaddingLeft) - this.f1207b.getPaddingRight());
            } else {
                m2200e(this.f1207b.f1210E);
            }
            Drawable background = m2185a();
            int bgOffset = 0;
            if (background != null) {
                background.getPadding(this.f1207b.f1214I);
                bgOffset = -this.f1207b.f1214I.left;
            }
            m2194b(bgOffset + spinnerPaddingLeft);
            m2201f(2);
            super.m2195c();
            m2205h().setChoiceMode(1);
            m2203g(this.f1207b.m1999f());
        }
    }

    C0467g(Context context, AttributeSet attrs, int defStyle) {
        this(context, attrs, defStyle, -1);
    }

    C0467g(Context context, AttributeSet attrs, int defStyle, int mode) {
        super(context, attrs, defStyle);
        this.f1214I = new Rect();
        TypedArray a = context.obtainStyledAttributes(attrs, C0363j.Spinner, defStyle, 0);
        if (mode == -1) {
            mode = a.getInt(7, 0);
        }
        switch (mode) {
            case Base64.DEFAULT /*0*/:
                this.f1211F = new C0463a();
                break;
            case Base64.NO_PADDING /*1*/:
                C0466c popup = new C0466c(this, context, attrs, defStyle);
                this.f1210E = a.getLayoutDimension(3, -2);
                popup.m2187a(a.getDrawable(2));
                int verticalOffset = a.getDimensionPixelOffset(5, 0);
                if (verticalOffset != 0) {
                    popup.m2196c(verticalOffset);
                }
                int horizontalOffset = a.getDimensionPixelOffset(4, 0);
                if (horizontalOffset != 0) {
                    popup.m2194b(horizontalOffset);
                }
                this.f1211F = popup;
                break;
        }
        this.f1213H = a.getInt(0, 17);
        this.f1211F.m2207a(a.getString(6));
        a.recycle();
        if (this.f1212G != null) {
            this.f1211F.m2206a(this.f1212G);
            this.f1212G = null;
        }
    }

    public void m2226a(SpinnerAdapter adapter) {
        super.m2013a(adapter);
        if (this.f1211F != null) {
            this.f1211F.m2206a(new C0464b(adapter));
        } else {
            this.f1212G = new C0464b(adapter);
        }
    }

    public int getBaseline() {
        View child = null;
        if (getChildCount() > 0) {
            child = getChildAt(0);
        } else if (this.a != null && this.a.getCount() > 0) {
            child = m2223e(0);
            this.j.m1984a(0, child);
            removeAllViewsInLayout();
        }
        if (child == null) {
            return -1;
        }
        int childBaseline = child.getBaseline();
        if (childBaseline >= 0) {
            return child.getTop() + childBaseline;
        }
        return -1;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f1211F != null && this.f1211F.m2210f()) {
            this.f1211F.m2209d();
        }
    }

    public void m2225a(C0431b l) {
        throw new RuntimeException("setOnItemClickListener cannot be used with a spinner.");
    }

    void m2228b(C0431b l) {
        super.m1991a(l);
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (this.f1211F != null && MeasureSpec.getMode(widthMeasureSpec) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), m2224a(m2017d(), getBackground())), MeasureSpec.getSize(widthMeasureSpec)), getMeasuredHeight());
        }
    }

    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        this.r = true;
        m2227b(0, false);
        this.r = false;
    }

    void m2227b(int delta, boolean animate) {
        int childrenLeft = this.i.left;
        int childrenWidth = ((getRight() - getLeft()) - this.i.left) - this.i.right;
        if (this.u) {
            m2004k();
        }
        if (this.z == 0) {
            m2011a();
            return;
        }
        if (this.v >= 0) {
            m1996c(this.v);
        }
        m2015b();
        removeAllViewsInLayout();
        this.k = this.x;
        View sel = m2223e(this.x);
        int width = sel.getMeasuredWidth();
        int selectedOffset = childrenLeft;
        switch (this.f1213H & 7) {
            case Base64.NO_PADDING /*1*/:
                selectedOffset = ((childrenWidth / 2) + childrenLeft) - (width / 2);
                break;
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                selectedOffset = (childrenLeft + childrenWidth) - width;
                break;
        }
        sel.offsetLeftAndRight(selectedOffset);
        this.j.m1983a();
        invalidate();
        m2005l();
        this.u = false;
        this.p = false;
        m1997d(this.x);
    }

    private View m2223e(int position) {
        View child;
        if (!this.u) {
            child = this.j.m1982a(position);
            if (child != null) {
                m2222c(child);
                return child;
            }
        }
        child = this.a.getView(position, null, this);
        m2222c(child);
        return child;
    }

    private void m2222c(View child) {
        LayoutParams lp = child.getLayoutParams();
        if (lp == null) {
            lp = generateDefaultLayoutParams();
        }
        addViewInLayout(child, 0, lp);
        child.setSelected(hasFocus());
        child.measure(ViewGroup.getChildMeasureSpec(this.c, this.i.left + this.i.right, lp.width), ViewGroup.getChildMeasureSpec(this.b, this.i.top + this.i.bottom, lp.height));
        int childTop = this.i.top + ((((getMeasuredHeight() - this.i.bottom) - this.i.top) - child.getMeasuredHeight()) / 2);
        child.layout(0, childTop, 0 + child.getMeasuredWidth(), childTop + child.getMeasuredHeight());
    }

    public boolean performClick() {
        boolean handled = super.performClick();
        if (!handled) {
            handled = true;
            if (!this.f1211F.m2210f()) {
                this.f1211F.m2208c();
            }
        }
        return handled;
    }

    public void onClick(DialogInterface dialog, int which) {
        m2012a(which);
        dialog.dismiss();
    }

    int m2224a(SpinnerAdapter adapter, Drawable background) {
        if (adapter == null) {
            return 0;
        }
        int width = 0;
        View itemView = null;
        int itemType = 0;
        int widthMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        int heightMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        int start = Math.max(0, m1999f());
        int end = Math.min(adapter.getCount(), start + 15);
        for (int i = Math.max(0, start - (15 - (end - start))); i < end; i++) {
            int positionType = adapter.getItemViewType(i);
            if (positionType != itemType) {
                itemType = positionType;
                itemView = null;
            }
            itemView = adapter.getView(i, itemView, this);
            if (itemView.getLayoutParams() == null) {
                itemView.setLayoutParams(new LayoutParams(-2, -2));
            }
            itemView.measure(widthMeasureSpec, heightMeasureSpec);
            width = Math.max(width, itemView.getMeasuredWidth());
        }
        if (background == null) {
            return width;
        }
        background.getPadding(this.f1214I);
        return width + (this.f1214I.left + this.f1214I.right);
    }
}
