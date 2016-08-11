package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v7.internal.view.menu.ActionMenuPresenter;
import android.support.v7.internal.view.menu.ActionMenuView;
import android.support.v7.p014b.C0364a.C0354a;
import android.support.v7.p014b.C0364a.C0355b;
import android.support.v7.p014b.C0364a.C0356c;
import android.support.v7.p014b.C0364a.C0363j;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

/* renamed from: android.support.v7.internal.widget.a */
abstract class C0418a extends ViewGroup {
    protected ActionMenuView f977a;
    protected ActionMenuPresenter f978b;
    protected ActionBarContainer f979c;
    protected boolean f980d;
    protected boolean f981e;
    protected int f982f;

    /* renamed from: android.support.v7.internal.widget.a.1 */
    class C04321 implements Runnable {
        final /* synthetic */ C0418a f1103a;

        C04321(C0418a c0418a) {
            this.f1103a = c0418a;
        }

        public void run() {
            this.f1103a.m2022a();
        }
    }

    C0418a(Context context) {
        super(context);
    }

    C0418a(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    C0418a(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    protected void onConfigurationChanged(Configuration newConfig) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(newConfig);
        }
        TypedArray a = getContext().obtainStyledAttributes(null, C0363j.ActionBar, C0355b.actionBarStyle, 0);
        setContentHeight(a.getLayoutDimension(1, 0));
        a.recycle();
        if (this.f981e) {
            setSplitActionBar(getContext().getResources().getBoolean(C0356c.abc_split_action_bar_is_narrow));
        }
        if (this.f978b != null) {
            this.f978b.m1809a(newConfig);
        }
    }

    public void setSplitActionBar(boolean split) {
        this.f980d = split;
    }

    public void setSplitWhenNarrow(boolean splitWhenNarrow) {
        this.f981e = splitWhenNarrow;
    }

    public void setContentHeight(int height) {
        this.f982f = height;
        requestLayout();
    }

    public int getContentHeight() {
        return this.f982f;
    }

    public void setSplitView(ActionBarContainer splitView) {
        this.f979c = splitView;
    }

    public int getAnimatedVisibility() {
        return getVisibility();
    }

    public void m2021a(int visibility) {
        clearAnimation();
        if (visibility != getVisibility()) {
            Animation anim = AnimationUtils.loadAnimation(getContext(), visibility == 0 ? C0354a.abc_fade_in : C0354a.abc_fade_out);
            startAnimation(anim);
            setVisibility(visibility);
            if (this.f979c != null && this.f977a != null) {
                this.f977a.startAnimation(anim);
                this.f977a.setVisibility(visibility);
            }
        }
    }

    public void setVisibility(int visibility) {
        if (visibility != getVisibility()) {
            super.setVisibility(visibility);
        }
    }

    public boolean m2022a() {
        if (this.f978b != null) {
            return this.f978b.m1813a();
        }
        return false;
    }

    public void m2024b() {
        post(new C04321(this));
    }

    public boolean m2026c() {
        if (this.f978b != null) {
            return this.f978b.m1818b();
        }
        return false;
    }

    public boolean m2027d() {
        if (this.f978b != null) {
            return this.f978b.m1823e();
        }
        return false;
    }

    public boolean m2028e() {
        return this.f978b != null && this.f978b.m1824f();
    }

    public void m2029f() {
        if (this.f978b != null) {
            this.f978b.m1820c();
        }
    }

    protected int m2020a(View child, int availableWidth, int childSpecHeight, int spacing) {
        child.measure(MeasureSpec.makeMeasureSpec(availableWidth, Integer.MIN_VALUE), childSpecHeight);
        return Math.max(0, (availableWidth - child.getMeasuredWidth()) - spacing);
    }

    protected int m2023b(View child, int x, int y, int contentHeight) {
        int childWidth = child.getMeasuredWidth();
        int childHeight = child.getMeasuredHeight();
        int childTop = y + ((contentHeight - childHeight) / 2);
        child.layout(x, childTop, x + childWidth, childTop + childHeight);
        return childWidth;
    }

    protected int m2025c(View child, int x, int y, int contentHeight) {
        int childWidth = child.getMeasuredWidth();
        int childHeight = child.getMeasuredHeight();
        int childTop = y + ((contentHeight - childHeight) / 2);
        child.layout(x - childWidth, childTop, x, childTop + childHeight);
        return childWidth;
    }
}
