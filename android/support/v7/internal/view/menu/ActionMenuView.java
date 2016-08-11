package android.support.v7.internal.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v7.internal.view.menu.C0397f.C0390b;
import android.support.v7.internal.widget.LinearLayoutICS;
import android.support.v7.p014b.C0364a.C0355b;
import android.support.v7.p014b.C0364a.C0363j;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout.LayoutParams;

public class ActionMenuView extends LinearLayoutICS implements C0390b, C0391m {
    private C0397f f806a;
    private boolean f807b;
    private ActionMenuPresenter f808c;
    private boolean f809d;
    private int f810e;
    private int f811f;
    private int f812g;
    private int f813h;
    private int f814i;

    /* renamed from: android.support.v7.internal.view.menu.ActionMenuView.a */
    public interface C0376a {
        boolean m1740c();

        boolean m1741d();
    }

    /* renamed from: android.support.v7.internal.view.menu.ActionMenuView.b */
    public static class C0389b extends LayoutParams {
        @ExportedProperty
        public boolean f795a;
        @ExportedProperty
        public int f796b;
        @ExportedProperty
        public int f797c;
        @ExportedProperty
        public boolean f798d;
        @ExportedProperty
        public boolean f799e;
        public boolean f800f;

        public C0389b(Context c, AttributeSet attrs) {
            super(c, attrs);
        }

        public C0389b(C0389b other) {
            super(other);
            this.f795a = other.f795a;
        }

        public C0389b(int width, int height) {
            super(width, height);
            this.f795a = false;
        }
    }

    protected /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return m1835a();
    }

    protected /* synthetic */ LayoutParams m9735generateDefaultLayoutParams() {
        return m1835a();
    }

    public /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet x0) {
        return m1836a(x0);
    }

    protected /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams x0) {
        return m1837a(x0);
    }

    public /* synthetic */ LayoutParams m9736generateLayoutParams(AttributeSet x0) {
        return m1836a(x0);
    }

    protected /* synthetic */ LayoutParams m9737generateLayoutParams(ViewGroup.LayoutParams x0) {
        return m1837a(x0);
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    public ActionMenuView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setBaselineAligned(false);
        float density = context.getResources().getDisplayMetrics().density;
        this.f811f = (int) (56.0f * density);
        this.f812g = (int) (4.0f * density);
        TypedArray a = context.obtainStyledAttributes(attrs, C0363j.ActionBar, C0355b.actionBarStyle, 0);
        this.f814i = a.getDimensionPixelSize(1, 0);
        a.recycle();
    }

    public void setPresenter(ActionMenuPresenter presenter) {
        this.f808c = presenter;
    }

    public void onConfigurationChanged(Configuration newConfig) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(newConfig);
        }
        this.f808c.m1821d(false);
        if (this.f808c != null && this.f808c.m1823e()) {
            this.f808c.m1818b();
            this.f808c.m1813a();
        }
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        boolean z;
        boolean wasFormatted = this.f809d;
        if (MeasureSpec.getMode(widthMeasureSpec) == 1073741824) {
            z = true;
        } else {
            z = false;
        }
        this.f809d = z;
        if (wasFormatted != this.f809d) {
            this.f810e = 0;
        }
        int widthSize = MeasureSpec.getMode(widthMeasureSpec);
        if (!(!this.f809d || this.f806a == null || widthSize == this.f810e)) {
            this.f810e = widthSize;
            this.f806a.m1901b(true);
        }
        if (this.f809d) {
            m1834a(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            C0389b lp = (C0389b) getChildAt(i).getLayoutParams();
            lp.rightMargin = 0;
            lp.leftMargin = 0;
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    private void m1834a(int widthMeasureSpec, int heightMeasureSpec) {
        int itemHeightSpec;
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int widthPadding = getPaddingLeft() + getPaddingRight();
        int heightPadding = getPaddingTop() + getPaddingBottom();
        if (heightMode == 1073741824) {
            itemHeightSpec = MeasureSpec.makeMeasureSpec(heightSize - heightPadding, 1073741824);
        } else {
            itemHeightSpec = MeasureSpec.makeMeasureSpec(Math.min(this.f814i, heightSize - heightPadding), Integer.MIN_VALUE);
        }
        widthSize -= widthPadding;
        int cellCount = widthSize / this.f811f;
        int cellSizeRemaining = widthSize % this.f811f;
        if (cellCount == 0) {
            setMeasuredDimension(widthSize, 0);
            return;
        }
        int i;
        C0389b lp;
        int cellSize = this.f811f + (cellSizeRemaining / cellCount);
        int cellsRemaining = cellCount;
        int maxChildHeight = 0;
        int maxCellsUsed = 0;
        int expandableItemCount = 0;
        int visibleItemCount = 0;
        boolean hasOverflow = false;
        long smallestItemsAt = 0;
        int childCount = getChildCount();
        for (i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            if (child.getVisibility() != 8) {
                int cellsAvailable;
                boolean isGeneratedItem = child instanceof ActionMenuItemView;
                visibleItemCount++;
                if (isGeneratedItem) {
                    child.setPadding(this.f812g, 0, this.f812g, 0);
                }
                lp = (C0389b) child.getLayoutParams();
                lp.f800f = false;
                lp.f797c = 0;
                lp.f796b = 0;
                lp.f798d = false;
                lp.leftMargin = 0;
                lp.rightMargin = 0;
                boolean z = isGeneratedItem && ((ActionMenuItemView) child).m1747b();
                lp.f799e = z;
                if (lp.f795a) {
                    cellsAvailable = 1;
                } else {
                    cellsAvailable = cellsRemaining;
                }
                int cellsUsed = m1833a(child, cellSize, cellsAvailable, itemHeightSpec, heightPadding);
                maxCellsUsed = Math.max(maxCellsUsed, cellsUsed);
                if (lp.f798d) {
                    expandableItemCount++;
                }
                if (lp.f795a) {
                    hasOverflow = true;
                }
                cellsRemaining -= cellsUsed;
                maxChildHeight = Math.max(maxChildHeight, child.getMeasuredHeight());
                if (cellsUsed == 1) {
                    smallestItemsAt |= (long) (1 << i);
                }
            }
        }
        boolean centerSingleExpandedItem = hasOverflow && visibleItemCount == 2;
        boolean needsExpansion = false;
        while (expandableItemCount > 0 && cellsRemaining > 0) {
            int minCells = Integer.MAX_VALUE;
            long minCellsAt = 0;
            int minCellsItemCount = 0;
            for (i = 0; i < childCount; i++) {
                int i2;
                lp = (C0389b) getChildAt(i).getLayoutParams();
                if (lp.f798d) {
                    i2 = lp.f796b;
                    if (r0 < minCells) {
                        minCells = lp.f796b;
                        minCellsAt = (long) (1 << i);
                        minCellsItemCount = 1;
                    } else {
                        i2 = lp.f796b;
                        if (r0 == minCells) {
                            minCellsAt |= (long) (1 << i);
                            minCellsItemCount++;
                        }
                    }
                }
            }
            smallestItemsAt |= minCellsAt;
            if (minCellsItemCount > cellsRemaining) {
                break;
            }
            minCells++;
            for (i = 0; i < childCount; i++) {
                child = getChildAt(i);
                lp = (C0389b) child.getLayoutParams();
                if ((((long) (1 << i)) & minCellsAt) == 0) {
                    i2 = lp.f796b;
                    if (r0 == minCells) {
                        smallestItemsAt |= (long) (1 << i);
                    }
                } else {
                    if (centerSingleExpandedItem && lp.f799e && cellsRemaining == 1) {
                        child.setPadding(this.f812g + cellSize, 0, this.f812g, 0);
                    }
                    lp.f796b++;
                    lp.f800f = true;
                    cellsRemaining--;
                }
            }
            needsExpansion = true;
        }
        boolean singleItem = !hasOverflow && visibleItemCount == 1;
        if (cellsRemaining > 0 && smallestItemsAt != 0 && (cellsRemaining < visibleItemCount - 1 || singleItem || maxCellsUsed > 1)) {
            float expandCount = (float) Long.bitCount(smallestItemsAt);
            if (!singleItem) {
                if ((1 & smallestItemsAt) != 0) {
                    if (!((C0389b) getChildAt(0).getLayoutParams()).f799e) {
                        expandCount -= 0.5f;
                    }
                }
                if ((((long) (1 << (childCount - 1))) & smallestItemsAt) != 0) {
                    if (!((C0389b) getChildAt(childCount - 1).getLayoutParams()).f799e) {
                        expandCount -= 0.5f;
                    }
                }
            }
            int extraPixels = expandCount > 0.0f ? (int) (((float) (cellsRemaining * cellSize)) / expandCount) : 0;
            for (i = 0; i < childCount; i++) {
                if ((((long) (1 << i)) & smallestItemsAt) != 0) {
                    child = getChildAt(i);
                    lp = (C0389b) child.getLayoutParams();
                    if (child instanceof ActionMenuItemView) {
                        lp.f797c = extraPixels;
                        lp.f800f = true;
                        if (i == 0 && !lp.f799e) {
                            lp.leftMargin = (-extraPixels) / 2;
                        }
                        needsExpansion = true;
                    } else if (lp.f795a) {
                        lp.f797c = extraPixels;
                        lp.f800f = true;
                        lp.rightMargin = (-extraPixels) / 2;
                        needsExpansion = true;
                    } else {
                        if (i != 0) {
                            lp.leftMargin = extraPixels / 2;
                        }
                        if (i != childCount - 1) {
                            lp.rightMargin = extraPixels / 2;
                        }
                    }
                }
            }
            cellsRemaining = 0;
        }
        if (needsExpansion) {
            for (i = 0; i < childCount; i++) {
                child = getChildAt(i);
                lp = (C0389b) child.getLayoutParams();
                if (lp.f800f) {
                    child.measure(MeasureSpec.makeMeasureSpec((lp.f796b * cellSize) + lp.f797c, 1073741824), itemHeightSpec);
                }
            }
        }
        if (heightMode != 1073741824) {
            heightSize = maxChildHeight;
        }
        setMeasuredDimension(widthSize, heightSize);
        this.f813h = cellsRemaining * cellSize;
    }

    static int m1833a(View child, int cellSize, int cellsRemaining, int parentHeightMeasureSpec, int parentHeightPadding) {
        C0389b lp = (C0389b) child.getLayoutParams();
        int childHeightSpec = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(parentHeightMeasureSpec) - parentHeightPadding, MeasureSpec.getMode(parentHeightMeasureSpec));
        ActionMenuItemView itemView = child instanceof ActionMenuItemView ? (ActionMenuItemView) child : null;
        boolean hasText = itemView != null && itemView.m1747b();
        int cellsUsed = 0;
        if (cellsRemaining > 0 && (!hasText || cellsRemaining >= 2)) {
            child.measure(MeasureSpec.makeMeasureSpec(cellSize * cellsRemaining, Integer.MIN_VALUE), childHeightSpec);
            int measuredWidth = child.getMeasuredWidth();
            cellsUsed = measuredWidth / cellSize;
            if (measuredWidth % cellSize != 0) {
                cellsUsed++;
            }
            if (hasText && cellsUsed < 2) {
                cellsUsed = 2;
            }
        }
        boolean expandable = !lp.f795a && hasText;
        lp.f798d = expandable;
        lp.f796b = cellsUsed;
        child.measure(MeasureSpec.makeMeasureSpec(cellsUsed * cellSize, 1073741824), childHeightSpec);
        return cellsUsed;
    }

    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        if (this.f809d) {
            int i;
            View v;
            int height;
            int t;
            int childCount = getChildCount();
            int midVertical = (top + bottom) / 2;
            int dividerWidth = getSupportDividerWidth();
            int nonOverflowWidth = 0;
            int nonOverflowCount = 0;
            int widthRemaining = ((right - left) - getPaddingRight()) - getPaddingLeft();
            boolean hasOverflow = false;
            for (i = 0; i < childCount; i++) {
                v = getChildAt(i);
                if (v.getVisibility() != 8) {
                    C0389b p = (C0389b) v.getLayoutParams();
                    if (p.f795a) {
                        int overflowWidth = v.getMeasuredWidth();
                        if (m1839a(i)) {
                            overflowWidth += dividerWidth;
                        }
                        height = v.getMeasuredHeight();
                        int r = (getWidth() - getPaddingRight()) - p.rightMargin;
                        t = midVertical - (height / 2);
                        v.layout(r - overflowWidth, t, r, t + height);
                        widthRemaining -= overflowWidth;
                        hasOverflow = true;
                    } else {
                        int size = (v.getMeasuredWidth() + p.leftMargin) + p.rightMargin;
                        nonOverflowWidth += size;
                        widthRemaining -= size;
                        if (m1839a(i)) {
                            nonOverflowWidth += dividerWidth;
                        }
                        nonOverflowCount++;
                    }
                }
            }
            int width;
            if (childCount != 1 || hasOverflow) {
                int spacerCount = nonOverflowCount - (hasOverflow ? 0 : 1);
                int spacerSize = Math.max(0, spacerCount > 0 ? widthRemaining / spacerCount : 0);
                int startLeft = getPaddingLeft();
                for (i = 0; i < childCount; i++) {
                    v = getChildAt(i);
                    C0389b lp = (C0389b) v.getLayoutParams();
                    if (!(v.getVisibility() == 8 || lp.f795a)) {
                        startLeft += lp.leftMargin;
                        width = v.getMeasuredWidth();
                        height = v.getMeasuredHeight();
                        t = midVertical - (height / 2);
                        v.layout(startLeft, t, startLeft + width, t + height);
                        startLeft += (lp.rightMargin + width) + spacerSize;
                    }
                }
                return;
            }
            v = getChildAt(0);
            width = v.getMeasuredWidth();
            height = v.getMeasuredHeight();
            int l = ((right - left) / 2) - (width / 2);
            t = midVertical - (height / 2);
            v.layout(l, t, l + width, t + height);
            return;
        }
        super.onLayout(changed, left, top, right, bottom);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f808c.m1820c();
    }

    public void setOverflowReserved(boolean reserveOverflow) {
        this.f807b = reserveOverflow;
    }

    protected C0389b m1835a() {
        C0389b params = new C0389b(-2, -2);
        params.gravity = 16;
        return params;
    }

    public C0389b m1836a(AttributeSet attrs) {
        return new C0389b(getContext(), attrs);
    }

    protected C0389b m1837a(ViewGroup.LayoutParams p) {
        if (!(p instanceof C0389b)) {
            return m1835a();
        }
        C0389b result = new C0389b((C0389b) p);
        if (result.gravity > 0) {
            return result;
        }
        result.gravity = 16;
        return result;
    }

    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        return p != null && (p instanceof C0389b);
    }

    public C0389b m1841b() {
        C0389b result = m1835a();
        result.f795a = true;
        return result;
    }

    public boolean m1840a(C0399h item) {
        return this.f806a.m1896a((MenuItem) item, 0);
    }

    public int getWindowAnimations() {
        return 0;
    }

    public void m1838a(C0397f menu) {
        this.f806a = menu;
    }

    protected boolean m1839a(int childIndex) {
        View childBefore = getChildAt(childIndex - 1);
        View child = getChildAt(childIndex);
        boolean result = false;
        if (childIndex < getChildCount() && (childBefore instanceof C0376a)) {
            result = false | ((C0376a) childBefore).m1741d();
        }
        if (childIndex <= 0 || !(child instanceof C0376a)) {
            return result;
        }
        return result | ((C0376a) child).m1740c();
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        return false;
    }
}
