package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.internal.view.menu.ActionMenuPresenter;
import android.support.v7.internal.view.menu.ActionMenuView;
import android.support.v7.internal.view.menu.C0397f;
import android.support.v7.p013c.C0342a;
import android.support.v7.p014b.C0364a.C0355b;
import android.support.v7.p014b.C0364a.C0358e;
import android.support.v7.p014b.C0364a.C0360g;
import android.support.v7.p014b.C0364a.C0363j;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ActionBarContextView extends C0418a {
    private CharSequence f983g;
    private CharSequence f984h;
    private View f985i;
    private View f986j;
    private LinearLayout f987k;
    private TextView f988l;
    private TextView f989m;
    private int f990n;
    private int f991o;
    private Drawable f992p;
    private boolean f993q;

    /* renamed from: android.support.v7.internal.widget.ActionBarContextView.1 */
    class C04171 implements OnClickListener {
        final /* synthetic */ C0342a f975a;
        final /* synthetic */ ActionBarContextView f976b;

        C04171(ActionBarContextView actionBarContextView, C0342a c0342a) {
            this.f976b = actionBarContextView;
            this.f975a = c0342a;
        }

        public void onClick(View v) {
            this.f975a.m1584c();
        }
    }

    public /* bridge */ /* synthetic */ void m2034b() {
        super.m2024b();
    }

    public /* bridge */ /* synthetic */ boolean m2037e() {
        return super.m2028e();
    }

    public /* bridge */ /* synthetic */ void m2038f() {
        super.m2029f();
    }

    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public /* bridge */ /* synthetic */ void setSplitView(ActionBarContainer x0) {
        super.setSplitView(x0);
    }

    public /* bridge */ /* synthetic */ void setSplitWhenNarrow(boolean x0) {
        super.setSplitWhenNarrow(x0);
    }

    public /* bridge */ /* synthetic */ void setVisibility(int x0) {
        super.setVisibility(x0);
    }

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    public ActionBarContextView(Context context, AttributeSet attrs) {
        this(context, attrs, C0355b.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TypedArray a = context.obtainStyledAttributes(attrs, C0363j.ActionMode, defStyle, 0);
        setBackgroundDrawable(a.getDrawable(3));
        this.f990n = a.getResourceId(1, 0);
        this.f991o = a.getResourceId(2, 0);
        this.f = a.getLayoutDimension(0, 0);
        this.f992p = a.getDrawable(4);
        a.recycle();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.b != null) {
            this.b.m1818b();
            this.b.m1822d();
        }
    }

    public void setSplitActionBar(boolean split) {
        if (this.d != split) {
            if (this.b != null) {
                LayoutParams layoutParams = new LayoutParams(-2, -1);
                ViewGroup oldParent;
                if (split) {
                    this.b.m1807a(getContext().getResources().getDisplayMetrics().widthPixels, true);
                    this.b.m1806a(Integer.MAX_VALUE);
                    layoutParams.width = -1;
                    layoutParams.height = this.f;
                    this.a = (ActionMenuView) this.b.m1804a((ViewGroup) this);
                    this.a.setBackgroundDrawable(this.f992p);
                    oldParent = (ViewGroup) this.a.getParent();
                    if (oldParent != null) {
                        oldParent.removeView(this.a);
                    }
                    this.c.addView(this.a, layoutParams);
                } else {
                    this.a = (ActionMenuView) this.b.m1804a((ViewGroup) this);
                    this.a.setBackgroundDrawable(null);
                    oldParent = (ViewGroup) this.a.getParent();
                    if (oldParent != null) {
                        oldParent.removeView(this.a);
                    }
                    addView(this.a, layoutParams);
                }
            }
            super.setSplitActionBar(split);
        }
    }

    public void setContentHeight(int height) {
        this.f = height;
    }

    public void setCustomView(View view) {
        if (this.f986j != null) {
            removeView(this.f986j);
        }
        this.f986j = view;
        if (this.f987k != null) {
            removeView(this.f987k);
            this.f987k = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setTitle(CharSequence title) {
        this.f983g = title;
        m2030i();
    }

    public void setSubtitle(CharSequence subtitle) {
        this.f984h = subtitle;
        m2030i();
    }

    public CharSequence getTitle() {
        return this.f983g;
    }

    public CharSequence getSubtitle() {
        return this.f984h;
    }

    private void m2030i() {
        boolean hasTitle;
        boolean hasSubtitle;
        int i;
        int i2 = 8;
        if (this.f987k == null) {
            LayoutInflater.from(getContext()).inflate(C0360g.abc_action_bar_title_item, this);
            this.f987k = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f988l = (TextView) this.f987k.findViewById(C0358e.action_bar_title);
            this.f989m = (TextView) this.f987k.findViewById(C0358e.action_bar_subtitle);
            if (this.f990n != 0) {
                this.f988l.setTextAppearance(getContext(), this.f990n);
            }
            if (this.f991o != 0) {
                this.f989m.setTextAppearance(getContext(), this.f991o);
            }
        }
        this.f988l.setText(this.f983g);
        this.f989m.setText(this.f984h);
        if (TextUtils.isEmpty(this.f983g)) {
            hasTitle = false;
        } else {
            hasTitle = true;
        }
        if (TextUtils.isEmpty(this.f984h)) {
            hasSubtitle = false;
        } else {
            hasSubtitle = true;
        }
        TextView textView = this.f989m;
        if (hasSubtitle) {
            i = 0;
        } else {
            i = 8;
        }
        textView.setVisibility(i);
        LinearLayout linearLayout = this.f987k;
        if (hasTitle || hasSubtitle) {
            i2 = 0;
        }
        linearLayout.setVisibility(i2);
        if (this.f987k.getParent() == null) {
            addView(this.f987k);
        }
    }

    public void m2032a(C0342a mode) {
        if (this.f985i == null) {
            this.f985i = LayoutInflater.from(getContext()).inflate(C0360g.abc_action_mode_close_item, this, false);
            addView(this.f985i);
        } else if (this.f985i.getParent() == null) {
            addView(this.f985i);
        }
        this.f985i.findViewById(C0358e.action_mode_close_button).setOnClickListener(new C04171(this, mode));
        C0397f menu = (C0397f) mode.m1583b();
        if (this.b != null) {
            this.b.m1820c();
        }
        this.b = new ActionMenuPresenter(getContext());
        this.b.m1817b(true);
        LayoutParams layoutParams = new LayoutParams(-2, -1);
        if (this.d) {
            this.b.m1807a(getContext().getResources().getDisplayMetrics().widthPixels, true);
            this.b.m1806a(Integer.MAX_VALUE);
            layoutParams.width = -1;
            layoutParams.height = this.f;
            menu.m1891a(this.b);
            this.a = (ActionMenuView) this.b.m1804a((ViewGroup) this);
            this.a.setBackgroundDrawable(this.f992p);
            this.c.addView(this.a, layoutParams);
            return;
        }
        menu.m1891a(this.b);
        this.a = (ActionMenuView) this.b.m1804a((ViewGroup) this);
        this.a.setBackgroundDrawable(null);
        addView(this.a, layoutParams);
    }

    public void m2039g() {
        if (this.f985i == null) {
            m2040h();
        }
    }

    public void m2040h() {
        removeAllViews();
        if (this.c != null) {
            this.c.removeView(this.a);
        }
        this.f986j = null;
        this.a = null;
    }

    public boolean m2033a() {
        if (this.b != null) {
            return this.b.m1813a();
        }
        return false;
    }

    public boolean m2035c() {
        if (this.b != null) {
            return this.b.m1818b();
        }
        return false;
    }

    public boolean m2036d() {
        if (this.b != null) {
            return this.b.m1823e();
        }
        return false;
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(-1, -2);
    }

    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(), attrs);
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (MeasureSpec.getMode(widthMeasureSpec) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with android:layout_width=\"FILL_PARENT\" (or fill_parent)");
        } else if (MeasureSpec.getMode(heightMeasureSpec) == 0) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with android:layout_height=\"wrap_content\"");
        } else {
            int contentWidth = MeasureSpec.getSize(widthMeasureSpec);
            int maxHeight = this.f > 0 ? this.f : MeasureSpec.getSize(heightMeasureSpec);
            int verticalPadding = getPaddingTop() + getPaddingBottom();
            int availableWidth = (contentWidth - getPaddingLeft()) - getPaddingRight();
            int height = maxHeight - verticalPadding;
            int childSpecHeight = MeasureSpec.makeMeasureSpec(height, Integer.MIN_VALUE);
            if (this.f985i != null) {
                MarginLayoutParams lp = (MarginLayoutParams) this.f985i.getLayoutParams();
                availableWidth = m2020a(this.f985i, availableWidth, childSpecHeight, 0) - (lp.leftMargin + lp.rightMargin);
            }
            if (this.a != null) {
                if (this.a.getParent() == this) {
                    availableWidth = m2020a(this.a, availableWidth, childSpecHeight, 0);
                }
            }
            if (this.f987k != null && this.f986j == null) {
                if (this.f993q) {
                    this.f987k.measure(MeasureSpec.makeMeasureSpec(0, 0), childSpecHeight);
                    int titleWidth = this.f987k.getMeasuredWidth();
                    boolean titleFits = titleWidth <= availableWidth;
                    if (titleFits) {
                        availableWidth -= titleWidth;
                    }
                    this.f987k.setVisibility(titleFits ? 0 : 8);
                } else {
                    availableWidth = m2020a(this.f987k, availableWidth, childSpecHeight, 0);
                }
            }
            if (this.f986j != null) {
                int customWidth;
                int customHeight;
                LayoutParams lp2 = this.f986j.getLayoutParams();
                int i = lp2.width;
                int customWidthMode = r0 != -2 ? 1073741824 : Integer.MIN_VALUE;
                if (lp2.width >= 0) {
                    customWidth = Math.min(lp2.width, availableWidth);
                } else {
                    customWidth = availableWidth;
                }
                i = lp2.height;
                int customHeightMode = r0 != -2 ? 1073741824 : Integer.MIN_VALUE;
                if (lp2.height >= 0) {
                    customHeight = Math.min(lp2.height, height);
                } else {
                    customHeight = height;
                }
                this.f986j.measure(MeasureSpec.makeMeasureSpec(customWidth, customWidthMode), MeasureSpec.makeMeasureSpec(customHeight, customHeightMode));
            }
            if (this.f <= 0) {
                int measuredHeight = 0;
                int count = getChildCount();
                for (int i2 = 0; i2 < count; i2++) {
                    int paddedViewHeight = getChildAt(i2).getMeasuredHeight() + verticalPadding;
                    if (paddedViewHeight > measuredHeight) {
                        measuredHeight = paddedViewHeight;
                    }
                }
                setMeasuredDimension(contentWidth, measuredHeight);
                return;
            }
            setMeasuredDimension(contentWidth, maxHeight);
        }
    }

    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int x = getPaddingLeft();
        int y = getPaddingTop();
        int contentHeight = ((b - t) - getPaddingTop()) - getPaddingBottom();
        if (!(this.f985i == null || this.f985i.getVisibility() == 8)) {
            MarginLayoutParams lp = (MarginLayoutParams) this.f985i.getLayoutParams();
            x += lp.leftMargin;
            x = (x + m2023b(this.f985i, x, y, contentHeight)) + lp.rightMargin;
        }
        if (!(this.f987k == null || this.f986j != null || this.f987k.getVisibility() == 8)) {
            x += m2023b(this.f987k, x, y, contentHeight);
        }
        if (this.f986j != null) {
            x += m2023b(this.f986j, x, y, contentHeight);
        }
        x = (r - l) - getPaddingRight();
        if (this.a != null) {
            x -= m2025c(this.a, x, y, contentHeight);
        }
    }

    public void setTitleOptional(boolean titleOptional) {
        if (titleOptional != this.f993q) {
            requestLayout();
        }
        this.f993q = titleOptional;
    }
}
