package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.p014b.C0364a.C0363j;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class LinearLayoutICS extends LinearLayout {
    private final Drawable f801a;
    private final int f802b;
    private final int f803c;
    private final int f804d;
    private final int f805e;

    public LinearLayoutICS(Context context, AttributeSet attrs) {
        boolean z = true;
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, C0363j.LinearLayoutICS);
        this.f801a = a.getDrawable(0);
        if (this.f801a != null) {
            this.f802b = this.f801a.getIntrinsicWidth();
            this.f803c = this.f801a.getIntrinsicHeight();
        } else {
            this.f802b = 0;
            this.f803c = 0;
        }
        this.f804d = a.getInt(1, 0);
        this.f805e = a.getDimensionPixelSize(2, 0);
        a.recycle();
        if (this.f801a != null) {
            z = false;
        }
        setWillNotDraw(z);
    }

    public int getSupportDividerWidth() {
        return this.f802b;
    }

    protected void onDraw(Canvas canvas) {
        if (this.f801a != null) {
            if (getOrientation() == 1) {
                m1826a(canvas);
            } else {
                m1829b(canvas);
            }
        }
    }

    protected void measureChildWithMargins(View child, int parentWidthMeasureSpec, int widthUsed, int parentHeightMeasureSpec, int heightUsed) {
        if (this.f801a != null) {
            int childIndex = indexOfChild(child);
            int count = getChildCount();
            LayoutParams params = (LayoutParams) child.getLayoutParams();
            if (getOrientation() == 1) {
                if (m1828a(childIndex)) {
                    params.topMargin = this.f803c;
                } else if (childIndex == count - 1 && m1828a(count)) {
                    params.bottomMargin = this.f803c;
                }
            } else if (m1828a(childIndex)) {
                params.leftMargin = this.f802b;
            } else if (childIndex == count - 1 && m1828a(count)) {
                params.rightMargin = this.f802b;
            }
        }
        super.measureChildWithMargins(child, parentWidthMeasureSpec, widthUsed, parentHeightMeasureSpec, heightUsed);
    }

    void m1826a(Canvas canvas) {
        int count = getChildCount();
        int i = 0;
        while (i < count) {
            View child = getChildAt(i);
            if (!(child == null || child.getVisibility() == 8 || !m1828a(i))) {
                m1827a(canvas, child.getTop() - ((LayoutParams) child.getLayoutParams()).topMargin);
            }
            i++;
        }
        if (m1828a(count)) {
            int bottom;
            child = getChildAt(count - 1);
            if (child == null) {
                bottom = (getHeight() - getPaddingBottom()) - this.f803c;
            } else {
                bottom = child.getBottom();
            }
            m1827a(canvas, bottom);
        }
    }

    void m1829b(Canvas canvas) {
        int count = getChildCount();
        int i = 0;
        while (i < count) {
            View child = getChildAt(i);
            if (!(child == null || child.getVisibility() == 8 || !m1828a(i))) {
                m1830b(canvas, child.getLeft() - ((LayoutParams) child.getLayoutParams()).leftMargin);
            }
            i++;
        }
        if (m1828a(count)) {
            int right;
            child = getChildAt(count - 1);
            if (child == null) {
                right = (getWidth() - getPaddingRight()) - this.f802b;
            } else {
                right = child.getRight();
            }
            m1830b(canvas, right);
        }
    }

    void m1827a(Canvas canvas, int top) {
        this.f801a.setBounds(getPaddingLeft() + this.f805e, top, (getWidth() - getPaddingRight()) - this.f805e, this.f803c + top);
        this.f801a.draw(canvas);
    }

    void m1830b(Canvas canvas, int left) {
        this.f801a.setBounds(left, getPaddingTop() + this.f805e, this.f802b + left, (getHeight() - getPaddingBottom()) - this.f805e);
        this.f801a.draw(canvas);
    }

    protected boolean m1828a(int childIndex) {
        if (childIndex == 0) {
            if ((this.f804d & 1) != 0) {
                return true;
            }
            return false;
        } else if (childIndex == getChildCount()) {
            if ((this.f804d & 4) == 0) {
                return false;
            }
            return true;
        } else if ((this.f804d & 2) == 0) {
            return false;
        } else {
            boolean hasVisibleViewBefore = false;
            for (int i = childIndex - 1; i >= 0; i--) {
                if (getChildAt(i).getVisibility() != 8) {
                    hasVisibleViewBefore = true;
                    break;
                }
            }
            return hasVisibleViewBefore;
        }
    }
}
