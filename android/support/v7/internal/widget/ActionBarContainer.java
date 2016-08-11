package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.p014b.C0364a.C0358e;
import android.support.v7.p014b.C0364a.C0363j;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;

public class ActionBarContainer extends FrameLayout {
    private boolean f967a;
    private View f968b;
    private ActionBarView f969c;
    private Drawable f970d;
    private Drawable f971e;
    private Drawable f972f;
    private boolean f973g;
    private boolean f974h;

    public ActionBarContainer(Context context) {
        this(context, null);
    }

    public ActionBarContainer(Context context, AttributeSet attrs) {
        boolean z = true;
        super(context, attrs);
        setBackgroundDrawable(null);
        TypedArray a = context.obtainStyledAttributes(attrs, C0363j.ActionBar);
        this.f970d = a.getDrawable(10);
        this.f971e = a.getDrawable(11);
        if (getId() == C0358e.split_action_bar) {
            this.f973g = true;
            this.f972f = a.getDrawable(12);
        }
        a.recycle();
        if (this.f973g) {
            if (this.f972f != null) {
                z = false;
            }
        } else if (!(this.f970d == null && this.f971e == null)) {
            z = false;
        }
        setWillNotDraw(z);
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.f969c = (ActionBarView) findViewById(C0358e.action_bar);
    }

    public void setPrimaryBackground(Drawable bg) {
        boolean z = true;
        if (this.f970d != null) {
            this.f970d.setCallback(null);
            unscheduleDrawable(this.f970d);
        }
        this.f970d = bg;
        if (bg != null) {
            bg.setCallback(this);
            if (this.f969c != null) {
                this.f970d.setBounds(this.f969c.getLeft(), this.f969c.getTop(), this.f969c.getRight(), this.f969c.getBottom());
            }
        }
        if (this.f973g) {
            if (this.f972f != null) {
                z = false;
            }
        } else if (!(this.f970d == null && this.f971e == null)) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setStackedBackground(Drawable bg) {
        boolean z = true;
        if (this.f971e != null) {
            this.f971e.setCallback(null);
            unscheduleDrawable(this.f971e);
        }
        this.f971e = bg;
        if (bg != null) {
            bg.setCallback(this);
            if (this.f974h && this.f971e != null) {
                this.f971e.setBounds(this.f968b.getLeft(), this.f968b.getTop(), this.f968b.getRight(), this.f968b.getBottom());
            }
        }
        if (this.f973g) {
            if (this.f972f != null) {
                z = false;
            }
        } else if (!(this.f970d == null && this.f971e == null)) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setSplitBackground(Drawable bg) {
        boolean z = true;
        if (this.f972f != null) {
            this.f972f.setCallback(null);
            unscheduleDrawable(this.f972f);
        }
        this.f972f = bg;
        if (bg != null) {
            bg.setCallback(this);
            if (this.f973g && this.f972f != null) {
                this.f972f.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (this.f973g) {
            if (this.f972f != null) {
                z = false;
            }
        } else if (!(this.f970d == null && this.f971e == null)) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setVisibility(int visibility) {
        boolean isVisible;
        super.setVisibility(visibility);
        if (visibility == 0) {
            isVisible = true;
        } else {
            isVisible = false;
        }
        if (this.f970d != null) {
            this.f970d.setVisible(isVisible, false);
        }
        if (this.f971e != null) {
            this.f971e.setVisible(isVisible, false);
        }
        if (this.f972f != null) {
            this.f972f.setVisible(isVisible, false);
        }
    }

    protected boolean verifyDrawable(Drawable who) {
        return (who == this.f970d && !this.f973g) || ((who == this.f971e && this.f974h) || ((who == this.f972f && this.f973g) || super.verifyDrawable(who)));
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f970d != null && this.f970d.isStateful()) {
            this.f970d.setState(getDrawableState());
        }
        if (this.f971e != null && this.f971e.isStateful()) {
            this.f971e.setState(getDrawableState());
        }
        if (this.f972f != null && this.f972f.isStateful()) {
            this.f972f.setState(getDrawableState());
        }
    }

    public void setTransitioning(boolean isTransitioning) {
        this.f967a = isTransitioning;
        setDescendantFocusability(isTransitioning ? 393216 : 262144);
    }

    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return this.f967a || super.onInterceptTouchEvent(ev);
    }

    public boolean onTouchEvent(MotionEvent ev) {
        super.onTouchEvent(ev);
        return true;
    }

    public boolean onHoverEvent(MotionEvent ev) {
        return true;
    }

    public void setTabContainer(ScrollingTabContainerView tabView) {
        if (this.f968b != null) {
            removeView(this.f968b);
        }
        this.f968b = tabView;
        if (tabView != null) {
            addView(tabView);
            LayoutParams lp = tabView.getLayoutParams();
            lp.width = -1;
            lp.height = -2;
            tabView.setAllowCollapse(false);
        }
    }

    public View getTabContainer() {
        return this.f968b;
    }

    public void onDraw(Canvas canvas) {
        if (getWidth() != 0 && getHeight() != 0) {
            if (!this.f973g) {
                if (this.f970d != null) {
                    m2019a(this.f970d, canvas);
                }
                if (this.f971e != null && this.f974h) {
                    m2019a(this.f971e, canvas);
                }
            } else if (this.f972f != null) {
                m2019a(this.f972f, canvas);
            }
        }
    }

    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (this.f969c != null) {
            FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) this.f969c.getLayoutParams();
            int actionBarViewHeight = this.f969c.m2089m() ? 0 : (this.f969c.getMeasuredHeight() + lp.topMargin) + lp.bottomMargin;
            if (this.f968b != null && this.f968b.getVisibility() != 8 && MeasureSpec.getMode(heightMeasureSpec) == Integer.MIN_VALUE) {
                setMeasuredDimension(getMeasuredWidth(), Math.min(this.f968b.getMeasuredHeight() + actionBarViewHeight, MeasureSpec.getSize(heightMeasureSpec)));
            }
        }
    }

    public void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        boolean hasTabs = (this.f968b == null || this.f968b.getVisibility() == 8) ? false : true;
        if (!(this.f968b == null || this.f968b.getVisibility() == 8)) {
            int containerHeight = getMeasuredHeight();
            int tabHeight = this.f968b.getMeasuredHeight();
            if ((this.f969c.getDisplayOptions() & 2) == 0) {
                int count = getChildCount();
                for (int i = 0; i < count; i++) {
                    View child = getChildAt(i);
                    if (!(child == this.f968b || this.f969c.m2089m())) {
                        child.offsetTopAndBottom(tabHeight);
                    }
                }
                this.f968b.layout(l, 0, r, tabHeight);
            } else {
                this.f968b.layout(l, containerHeight - tabHeight, r, containerHeight);
            }
        }
        boolean needsInvalidate = false;
        if (!this.f973g) {
            if (this.f970d != null) {
                this.f970d.setBounds(this.f969c.getLeft(), this.f969c.getTop(), this.f969c.getRight(), this.f969c.getBottom());
                needsInvalidate = true;
            }
            boolean z = hasTabs && this.f971e != null;
            this.f974h = z;
            if (z) {
                this.f971e.setBounds(this.f968b.getLeft(), this.f968b.getTop(), this.f968b.getRight(), this.f968b.getBottom());
                needsInvalidate = true;
            }
        } else if (this.f972f != null) {
            this.f972f.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            needsInvalidate = true;
        }
        if (needsInvalidate) {
            invalidate();
        }
    }

    private void m2019a(Drawable d, Canvas canvas) {
        Rect bounds = d.getBounds();
        if (!(d instanceof ColorDrawable) || bounds.isEmpty() || VERSION.SDK_INT >= 11) {
            d.draw(canvas);
            return;
        }
        canvas.save();
        canvas.clipRect(bounds);
        d.draw(canvas);
        canvas.restore();
    }
}
