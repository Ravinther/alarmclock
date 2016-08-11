package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.C0247m;
import android.support.v4.view.C0264r;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.mopub.mobileads.util.Base64;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class SlidingPaneLayout extends ViewGroup {
    static final C0295d f547a;
    private int f548b;
    private int f549c;
    private Drawable f550d;
    private Drawable f551e;
    private final int f552f;
    private boolean f553g;
    private View f554h;
    private float f555i;
    private float f556j;
    private int f557k;
    private boolean f558l;
    private int f559m;
    private float f560n;
    private float f561o;
    private C0294c f562p;
    private final C0321j f563q;
    private boolean f564r;
    private boolean f565s;
    private final Rect f566t;
    private final ArrayList f567u;

    static class SavedState extends BaseSavedState {
        public static final Creator CREATOR;
        boolean f537a;

        /* renamed from: android.support.v4.widget.SlidingPaneLayout.SavedState.1 */
        static class C02911 implements Creator {
            C02911() {
            }

            public /* synthetic */ Object createFromParcel(Parcel x0) {
                return m1275a(x0);
            }

            public /* synthetic */ Object[] newArray(int x0) {
                return m1276a(x0);
            }

            public SavedState m1275a(Parcel in) {
                return new SavedState(null);
            }

            public SavedState[] m1276a(int size) {
                return new SavedState[size];
            }
        }

        SavedState(Parcelable superState) {
            super(superState);
        }

        private SavedState(Parcel in) {
            super(in);
            this.f537a = in.readInt() != 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeInt(this.f537a ? 1 : 0);
        }

        static {
            CREATOR = new C02911();
        }
    }

    /* renamed from: android.support.v4.widget.SlidingPaneLayout.a */
    private class C0292a implements Runnable {
        final View f538a;
        final /* synthetic */ SlidingPaneLayout f539b;

        C0292a(SlidingPaneLayout slidingPaneLayout, View childView) {
            this.f539b = slidingPaneLayout;
            this.f538a = childView;
        }

        public void run() {
            if (this.f538a.getParent() == this.f539b) {
                C0264r.m1155a(this.f538a, 0, null);
                this.f539b.m1288d(this.f538a);
            }
            this.f539b.f567u.remove(this);
        }
    }

    /* renamed from: android.support.v4.widget.SlidingPaneLayout.b */
    public static class C0293b extends MarginLayoutParams {
        private static final int[] f540e;
        public float f541a;
        boolean f542b;
        boolean f543c;
        Paint f544d;

        static {
            f540e = new int[]{16843137};
        }

        public C0293b() {
            super(-1, -1);
            this.f541a = 0.0f;
        }

        public C0293b(LayoutParams source) {
            super(source);
            this.f541a = 0.0f;
        }

        public C0293b(MarginLayoutParams source) {
            super(source);
            this.f541a = 0.0f;
        }

        public C0293b(Context c, AttributeSet attrs) {
            super(c, attrs);
            this.f541a = 0.0f;
            TypedArray a = c.obtainStyledAttributes(attrs, f540e);
            this.f541a = a.getFloat(0, 0.0f);
            a.recycle();
        }
    }

    /* renamed from: android.support.v4.widget.SlidingPaneLayout.c */
    public interface C0294c {
    }

    /* renamed from: android.support.v4.widget.SlidingPaneLayout.d */
    interface C0295d {
        void m1277a(SlidingPaneLayout slidingPaneLayout, View view);
    }

    /* renamed from: android.support.v4.widget.SlidingPaneLayout.e */
    static class C0296e implements C0295d {
        C0296e() {
        }

        public void m1278a(SlidingPaneLayout parent, View child) {
            C0264r.m1154a(parent, child.getLeft(), child.getTop(), child.getRight(), child.getBottom());
        }
    }

    /* renamed from: android.support.v4.widget.SlidingPaneLayout.f */
    static class C0297f extends C0296e {
        private Method f545a;
        private Field f546b;

        C0297f() {
            try {
                this.f545a = View.class.getDeclaredMethod("getDisplayList", (Class[]) null);
            } catch (NoSuchMethodException e) {
                Log.e("SlidingPaneLayout", "Couldn't fetch getDisplayList method; dimming won't work right.", e);
            }
            try {
                this.f546b = View.class.getDeclaredField("mRecreateDisplayList");
                this.f546b.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.e("SlidingPaneLayout", "Couldn't fetch mRecreateDisplayList field; dimming will be slow.", e2);
            }
        }

        public void m1279a(SlidingPaneLayout parent, View child) {
            if (this.f545a == null || this.f546b == null) {
                child.invalidate();
                return;
            }
            try {
                this.f546b.setBoolean(child, true);
                this.f545a.invoke(child, (Object[]) null);
            } catch (Exception e) {
                Log.e("SlidingPaneLayout", "Error refreshing display list state", e);
            }
            super.m1278a(parent, child);
        }
    }

    /* renamed from: android.support.v4.widget.SlidingPaneLayout.g */
    static class C0298g extends C0296e {
        C0298g() {
        }

        public void m1280a(SlidingPaneLayout parent, View child) {
            C0264r.m1156a(child, ((C0293b) child.getLayoutParams()).f544d);
        }
    }

    static {
        int deviceVersion = VERSION.SDK_INT;
        if (deviceVersion >= 17) {
            f547a = new C0298g();
        } else if (deviceVersion >= 16) {
            f547a = new C0297f();
        } else {
            f547a = new C0296e();
        }
    }

    public void setParallaxDistance(int parallaxBy) {
        this.f559m = parallaxBy;
        requestLayout();
    }

    public int getParallaxDistance() {
        return this.f559m;
    }

    public void setSliderFadeColor(int color) {
        this.f548b = color;
    }

    public int getSliderFadeColor() {
        return this.f548b;
    }

    public void setCoveredFadeColor(int color) {
        this.f549c = color;
    }

    public int getCoveredFadeColor() {
        return this.f549c;
    }

    public void setPanelSlideListener(C0294c listener) {
        this.f562p = listener;
    }

    void m1291a(View panel) {
        int endBound;
        int left;
        boolean isLayoutRtl = m1289f();
        int startBound = isLayoutRtl ? getWidth() - getPaddingRight() : getPaddingLeft();
        if (isLayoutRtl) {
            endBound = getPaddingLeft();
        } else {
            endBound = getWidth() - getPaddingRight();
        }
        int topBound = getPaddingTop();
        int bottomBound = getHeight() - getPaddingBottom();
        int bottom;
        int top;
        int right;
        if (panel == null || !m1287c(panel)) {
            bottom = 0;
            top = 0;
            right = 0;
            left = 0;
        } else {
            left = panel.getLeft();
            right = panel.getRight();
            top = panel.getTop();
            bottom = panel.getBottom();
        }
        int i = 0;
        int childCount = getChildCount();
        while (i < childCount) {
            View child = getChildAt(i);
            if (child != panel) {
                int i2;
                int vis;
                if (isLayoutRtl) {
                    i2 = endBound;
                } else {
                    i2 = startBound;
                }
                int clampedChildLeft = Math.max(i2, child.getLeft());
                int clampedChildTop = Math.max(topBound, child.getTop());
                if (isLayoutRtl) {
                    i2 = startBound;
                } else {
                    i2 = endBound;
                }
                int clampedChildRight = Math.min(i2, child.getRight());
                int clampedChildBottom = Math.min(bottomBound, child.getBottom());
                if (clampedChildLeft < left || clampedChildTop < top || clampedChildRight > right || clampedChildBottom > bottom) {
                    vis = 0;
                } else {
                    vis = 4;
                }
                child.setVisibility(vis);
                i++;
            } else {
                return;
            }
        }
    }

    void m1290a() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            if (child.getVisibility() == 4) {
                child.setVisibility(0);
            }
        }
    }

    private static boolean m1287c(View v) {
        if (C0264r.m1166g(v)) {
            return true;
        }
        if (VERSION.SDK_INT >= 18) {
            return false;
        }
        Drawable bg = v.getBackground();
        if (bg == null) {
            return false;
        }
        if (bg.getOpacity() != -1) {
            return false;
        }
        return true;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f565s = true;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f565s = true;
        int count = this.f567u.size();
        for (int i = 0; i < count; i++) {
            ((C0292a) this.f567u.get(i)).run();
        }
        this.f567u.clear();
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int i;
        int i2;
        int childWidthSpec;
        int childHeightSpec;
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        if (widthMode != 1073741824) {
            if (!isInEditMode()) {
                throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
            } else if (widthMode != Integer.MIN_VALUE) {
                if (widthMode == 0) {
                    widthSize = 300;
                }
            }
        } else if (heightMode == 0) {
            if (!isInEditMode()) {
                throw new IllegalStateException("Height must not be UNSPECIFIED");
            } else if (heightMode == 0) {
                heightMode = Integer.MIN_VALUE;
                heightSize = 300;
            }
        }
        int layoutHeight = 0;
        int maxLayoutHeight = -1;
        switch (heightMode) {
            case Integer.MIN_VALUE:
                maxLayoutHeight = (heightSize - getPaddingTop()) - getPaddingBottom();
                break;
            case 1073741824:
                maxLayoutHeight = (heightSize - getPaddingTop()) - getPaddingBottom();
                layoutHeight = maxLayoutHeight;
                break;
        }
        float weightSum = 0.0f;
        boolean canSlide = false;
        int widthAvailable = (widthSize - getPaddingLeft()) - getPaddingRight();
        int widthRemaining = widthAvailable;
        int childCount = getChildCount();
        if (childCount > 2) {
            Log.e("SlidingPaneLayout", "onMeasure: More than two child views are not supported.");
        }
        this.f554h = null;
        for (i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            C0293b lp = (C0293b) child.getLayoutParams();
            if (child.getVisibility() == 8) {
                lp.f543c = false;
            } else {
                if (lp.f541a > 0.0f) {
                    weightSum += lp.f541a;
                    if (lp.width == 0) {
                    }
                }
                int horizontalMargin = lp.leftMargin + lp.rightMargin;
                i2 = lp.width;
                if (r0 == -2) {
                    childWidthSpec = MeasureSpec.makeMeasureSpec(widthAvailable - horizontalMargin, Integer.MIN_VALUE);
                } else {
                    i2 = lp.width;
                    if (r0 == -1) {
                        childWidthSpec = MeasureSpec.makeMeasureSpec(widthAvailable - horizontalMargin, 1073741824);
                    } else {
                        childWidthSpec = MeasureSpec.makeMeasureSpec(lp.width, 1073741824);
                    }
                }
                i2 = lp.height;
                if (r0 == -2) {
                    childHeightSpec = MeasureSpec.makeMeasureSpec(maxLayoutHeight, Integer.MIN_VALUE);
                } else {
                    i2 = lp.height;
                    if (r0 == -1) {
                        childHeightSpec = MeasureSpec.makeMeasureSpec(maxLayoutHeight, 1073741824);
                    } else {
                        childHeightSpec = MeasureSpec.makeMeasureSpec(lp.height, 1073741824);
                    }
                }
                child.measure(childWidthSpec, childHeightSpec);
                int childWidth = child.getMeasuredWidth();
                int childHeight = child.getMeasuredHeight();
                if (heightMode == Integer.MIN_VALUE && childHeight > layoutHeight) {
                    layoutHeight = Math.min(childHeight, maxLayoutHeight);
                }
                widthRemaining -= childWidth;
                boolean z = widthRemaining < 0;
                lp.f542b = z;
                canSlide |= z;
                if (lp.f542b) {
                    this.f554h = child;
                }
            }
        }
        if (canSlide || weightSum > 0.0f) {
            int fixedPanelWidthLimit = widthAvailable - this.f552f;
            for (i = 0; i < childCount; i++) {
                child = getChildAt(i);
                if (child.getVisibility() != 8) {
                    lp = (C0293b) child.getLayoutParams();
                    if (child.getVisibility() != 8) {
                        boolean skippedFirstPass;
                        int measuredWidth;
                        View view;
                        int newWidth;
                        if (lp.width == 0) {
                            if (lp.f541a > 0.0f) {
                                skippedFirstPass = true;
                                measuredWidth = skippedFirstPass ? 0 : child.getMeasuredWidth();
                                if (canSlide) {
                                    view = this.f554h;
                                    if (child != r0) {
                                        if (lp.width >= 0) {
                                            if (measuredWidth <= fixedPanelWidthLimit) {
                                                if (lp.f541a <= 0.0f) {
                                                }
                                            }
                                            if (skippedFirstPass) {
                                                childHeightSpec = MeasureSpec.makeMeasureSpec(child.getMeasuredHeight(), 1073741824);
                                            } else {
                                                i2 = lp.height;
                                                if (r0 != -2) {
                                                    childHeightSpec = MeasureSpec.makeMeasureSpec(maxLayoutHeight, Integer.MIN_VALUE);
                                                } else {
                                                    i2 = lp.height;
                                                    if (r0 != -1) {
                                                        childHeightSpec = MeasureSpec.makeMeasureSpec(maxLayoutHeight, 1073741824);
                                                    } else {
                                                        childHeightSpec = MeasureSpec.makeMeasureSpec(lp.height, 1073741824);
                                                    }
                                                }
                                            }
                                            child.measure(MeasureSpec.makeMeasureSpec(fixedPanelWidthLimit, 1073741824), childHeightSpec);
                                        }
                                    }
                                }
                                if (lp.f541a <= 0.0f) {
                                    if (lp.width != 0) {
                                        i2 = lp.height;
                                        if (r0 != -2) {
                                            childHeightSpec = MeasureSpec.makeMeasureSpec(maxLayoutHeight, Integer.MIN_VALUE);
                                        } else {
                                            i2 = lp.height;
                                            if (r0 != -1) {
                                                childHeightSpec = MeasureSpec.makeMeasureSpec(maxLayoutHeight, 1073741824);
                                            } else {
                                                childHeightSpec = MeasureSpec.makeMeasureSpec(lp.height, 1073741824);
                                            }
                                        }
                                    } else {
                                        childHeightSpec = MeasureSpec.makeMeasureSpec(child.getMeasuredHeight(), 1073741824);
                                    }
                                    if (canSlide) {
                                        child.measure(MeasureSpec.makeMeasureSpec(measuredWidth + ((int) ((lp.f541a * ((float) Math.max(0, widthRemaining))) / weightSum)), 1073741824), childHeightSpec);
                                    } else {
                                        newWidth = widthAvailable - (lp.leftMargin + lp.rightMargin);
                                        childWidthSpec = MeasureSpec.makeMeasureSpec(newWidth, 1073741824);
                                        if (measuredWidth != newWidth) {
                                            child.measure(childWidthSpec, childHeightSpec);
                                        }
                                    }
                                }
                            }
                        }
                        skippedFirstPass = false;
                        if (skippedFirstPass) {
                        }
                        if (canSlide) {
                            view = this.f554h;
                            if (child != r0) {
                                if (lp.width >= 0) {
                                    if (measuredWidth <= fixedPanelWidthLimit) {
                                        if (lp.f541a <= 0.0f) {
                                        }
                                    }
                                    if (skippedFirstPass) {
                                        childHeightSpec = MeasureSpec.makeMeasureSpec(child.getMeasuredHeight(), 1073741824);
                                    } else {
                                        i2 = lp.height;
                                        if (r0 != -2) {
                                            i2 = lp.height;
                                            if (r0 != -1) {
                                                childHeightSpec = MeasureSpec.makeMeasureSpec(lp.height, 1073741824);
                                            } else {
                                                childHeightSpec = MeasureSpec.makeMeasureSpec(maxLayoutHeight, 1073741824);
                                            }
                                        } else {
                                            childHeightSpec = MeasureSpec.makeMeasureSpec(maxLayoutHeight, Integer.MIN_VALUE);
                                        }
                                    }
                                    child.measure(MeasureSpec.makeMeasureSpec(fixedPanelWidthLimit, 1073741824), childHeightSpec);
                                }
                            }
                        }
                        if (lp.f541a <= 0.0f) {
                            if (lp.width != 0) {
                                childHeightSpec = MeasureSpec.makeMeasureSpec(child.getMeasuredHeight(), 1073741824);
                            } else {
                                i2 = lp.height;
                                if (r0 != -2) {
                                    i2 = lp.height;
                                    if (r0 != -1) {
                                        childHeightSpec = MeasureSpec.makeMeasureSpec(lp.height, 1073741824);
                                    } else {
                                        childHeightSpec = MeasureSpec.makeMeasureSpec(maxLayoutHeight, 1073741824);
                                    }
                                } else {
                                    childHeightSpec = MeasureSpec.makeMeasureSpec(maxLayoutHeight, Integer.MIN_VALUE);
                                }
                            }
                            if (canSlide) {
                                child.measure(MeasureSpec.makeMeasureSpec(measuredWidth + ((int) ((lp.f541a * ((float) Math.max(0, widthRemaining))) / weightSum)), 1073741824), childHeightSpec);
                            } else {
                                newWidth = widthAvailable - (lp.leftMargin + lp.rightMargin);
                                childWidthSpec = MeasureSpec.makeMeasureSpec(newWidth, 1073741824);
                                if (measuredWidth != newWidth) {
                                    child.measure(childWidthSpec, childHeightSpec);
                                }
                            }
                        }
                    }
                }
            }
        }
        setMeasuredDimension(widthSize, (getPaddingTop() + layoutHeight) + getPaddingBottom());
        this.f553g = canSlide;
        if (this.f563q.m1412a() != 0 && !canSlide) {
            this.f563q.m1433f();
        }
    }

    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int i;
        boolean isLayoutRtl = m1289f();
        if (isLayoutRtl) {
            this.f563q.m1414a(2);
        } else {
            this.f563q.m1414a(1);
        }
        int width = r - l;
        int paddingStart = isLayoutRtl ? getPaddingRight() : getPaddingLeft();
        int paddingEnd = isLayoutRtl ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        int xStart = paddingStart;
        int nextXStart = xStart;
        if (this.f565s) {
            float f = (this.f553g && this.f564r) ? 1.0f : 0.0f;
            this.f555i = f;
        }
        for (i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            if (child.getVisibility() != 8) {
                int childRight;
                int childLeft;
                C0293b lp = (C0293b) child.getLayoutParams();
                int childWidth = child.getMeasuredWidth();
                int offset = 0;
                if (lp.f542b) {
                    int range = (Math.min(nextXStart, (width - paddingEnd) - this.f552f) - xStart) - (lp.leftMargin + lp.rightMargin);
                    this.f557k = range;
                    int lpMargin = isLayoutRtl ? lp.rightMargin : lp.leftMargin;
                    lp.f543c = ((xStart + lpMargin) + range) + (childWidth / 2) > width - paddingEnd;
                    int pos = (int) (((float) range) * this.f555i);
                    xStart += pos + lpMargin;
                    this.f555i = ((float) pos) / ((float) this.f557k);
                } else if (!this.f553g || this.f559m == 0) {
                    xStart = nextXStart;
                } else {
                    offset = (int) ((1.0f - this.f555i) * ((float) this.f559m));
                    xStart = nextXStart;
                }
                if (isLayoutRtl) {
                    childRight = (width - xStart) + offset;
                    childLeft = childRight - childWidth;
                } else {
                    childLeft = xStart - offset;
                    childRight = childLeft + childWidth;
                }
                child.layout(childLeft, paddingTop, childRight, paddingTop + child.getMeasuredHeight());
                nextXStart += child.getWidth();
            }
        }
        if (this.f565s) {
            if (this.f553g) {
                if (this.f559m != 0) {
                    m1282a(this.f555i);
                }
                if (((C0293b) this.f554h.getLayoutParams()).f543c) {
                    m1284a(this.f554h, this.f555i, this.f548b);
                }
            } else {
                for (i = 0; i < childCount; i++) {
                    m1284a(getChildAt(i), 0.0f, this.f548b);
                }
            }
            m1291a(this.f554h);
        }
        this.f565s = false;
    }

    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (w != oldw) {
            this.f565s = true;
        }
    }

    public void requestChildFocus(View child, View focused) {
        super.requestChildFocus(child, focused);
        if (!isInTouchMode() && !this.f553g) {
            this.f564r = child == this.f554h;
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int action = C0247m.m1082a(ev);
        if (!this.f553g && action == 0 && getChildCount() > 1) {
            View secondChild = getChildAt(1);
            if (secondChild != null) {
                this.f564r = !this.f563q.m1425b(secondChild, (int) ev.getX(), (int) ev.getY());
            }
        }
        if (!this.f553g || (this.f558l && action != 0)) {
            this.f563q.m1432e();
            return super.onInterceptTouchEvent(ev);
        } else if (action == 3 || action == 1) {
            this.f563q.m1432e();
            return false;
        } else {
            boolean interceptTap = false;
            float x;
            float y;
            switch (action) {
                case Base64.DEFAULT /*0*/:
                    this.f558l = false;
                    x = ev.getX();
                    y = ev.getY();
                    this.f560n = x;
                    this.f561o = y;
                    if (this.f563q.m1425b(this.f554h, (int) x, (int) y) && m1294b(this.f554h)) {
                        interceptTap = true;
                        break;
                    }
                case Base64.NO_WRAP /*2*/:
                    x = ev.getX();
                    y = ev.getY();
                    float adx = Math.abs(x - this.f560n);
                    float ady = Math.abs(y - this.f561o);
                    if (adx > ((float) this.f563q.m1429d()) && ady > adx) {
                        this.f563q.m1432e();
                        this.f558l = true;
                        return false;
                    }
            }
            if (this.f563q.m1417a(ev) || interceptTap) {
                return true;
            }
            return false;
        }
    }

    public boolean onTouchEvent(MotionEvent ev) {
        if (!this.f553g) {
            return super.onTouchEvent(ev);
        }
        this.f563q.m1421b(ev);
        float x;
        float y;
        switch (ev.getAction() & 255) {
            case Base64.DEFAULT /*0*/:
                x = ev.getX();
                y = ev.getY();
                this.f560n = x;
                this.f561o = y;
                return true;
            case Base64.NO_PADDING /*1*/:
                if (!m1294b(this.f554h)) {
                    return true;
                }
                x = ev.getX();
                y = ev.getY();
                float dx = x - this.f560n;
                float dy = y - this.f561o;
                int slop = this.f563q.m1429d();
                if ((dx * dx) + (dy * dy) >= ((float) (slop * slop)) || !this.f563q.m1425b(this.f554h, (int) x, (int) y)) {
                    return true;
                }
                m1285a(this.f554h, 0);
                return true;
            default:
                return true;
        }
    }

    private boolean m1285a(View pane, int initialVelocity) {
        if (!this.f565s && !m1292a(0.0f, initialVelocity)) {
            return false;
        }
        this.f564r = false;
        return true;
    }

    private boolean m1286b(View pane, int initialVelocity) {
        if (!this.f565s && !m1292a(1.0f, initialVelocity)) {
            return false;
        }
        this.f564r = true;
        return true;
    }

    public boolean m1293b() {
        return m1286b(this.f554h, 0);
    }

    public boolean m1295c() {
        return m1285a(this.f554h, 0);
    }

    public boolean m1296d() {
        return !this.f553g || this.f555i == 1.0f;
    }

    public boolean m1297e() {
        return this.f553g;
    }

    private void m1284a(View v, float mag, int fadeColor) {
        C0293b lp = (C0293b) v.getLayoutParams();
        if (mag > 0.0f && fadeColor != 0) {
            int color = (((int) (((float) ((-16777216 & fadeColor) >>> 24)) * mag)) << 24) | (16777215 & fadeColor);
            if (lp.f544d == null) {
                lp.f544d = new Paint();
            }
            lp.f544d.setColorFilter(new PorterDuffColorFilter(color, Mode.SRC_OVER));
            if (C0264r.m1163d(v) != 2) {
                C0264r.m1155a(v, 2, lp.f544d);
            }
            m1288d(v);
        } else if (C0264r.m1163d(v) != 0) {
            if (lp.f544d != null) {
                lp.f544d.setColorFilter(null);
            }
            Runnable dlr = new C0292a(this, v);
            this.f567u.add(dlr);
            C0264r.m1158a((View) this, dlr);
        }
    }

    protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
        boolean result;
        C0293b lp = (C0293b) child.getLayoutParams();
        int save = canvas.save(2);
        if (!(!this.f553g || lp.f542b || this.f554h == null)) {
            canvas.getClipBounds(this.f566t);
            if (m1289f()) {
                this.f566t.left = Math.max(this.f566t.left, this.f554h.getRight());
            } else {
                this.f566t.right = Math.min(this.f566t.right, this.f554h.getLeft());
            }
            canvas.clipRect(this.f566t);
        }
        if (VERSION.SDK_INT >= 11) {
            result = super.drawChild(canvas, child, drawingTime);
        } else if (!lp.f543c || this.f555i <= 0.0f) {
            if (child.isDrawingCacheEnabled()) {
                child.setDrawingCacheEnabled(false);
            }
            result = super.drawChild(canvas, child, drawingTime);
        } else {
            if (!child.isDrawingCacheEnabled()) {
                child.setDrawingCacheEnabled(true);
            }
            Bitmap cache = child.getDrawingCache();
            if (cache != null) {
                canvas.drawBitmap(cache, (float) child.getLeft(), (float) child.getTop(), lp.f544d);
                result = false;
            } else {
                Log.e("SlidingPaneLayout", "drawChild: child view " + child + " returned null drawing cache");
                result = super.drawChild(canvas, child, drawingTime);
            }
        }
        canvas.restoreToCount(save);
        return result;
    }

    private void m1288d(View v) {
        f547a.m1277a(this, v);
    }

    boolean m1292a(float slideOffset, int velocity) {
        if (!this.f553g) {
            return false;
        }
        int x;
        C0293b lp = (C0293b) this.f554h.getLayoutParams();
        if (m1289f()) {
            x = (int) (((float) getWidth()) - ((((float) (getPaddingRight() + lp.rightMargin)) + (((float) this.f557k) * slideOffset)) + ((float) this.f554h.getWidth())));
        } else {
            x = (int) (((float) (getPaddingLeft() + lp.leftMargin)) + (((float) this.f557k) * slideOffset));
        }
        if (!this.f563q.m1418a(this.f554h, x, this.f554h.getTop())) {
            return false;
        }
        m1290a();
        C0264r.m1160b(this);
        return true;
    }

    public void computeScroll() {
        if (!this.f563q.m1419a(true)) {
            return;
        }
        if (this.f553g) {
            C0264r.m1160b(this);
        } else {
            this.f563q.m1433f();
        }
    }

    @Deprecated
    public void setShadowDrawable(Drawable d) {
        setShadowDrawableLeft(d);
    }

    public void setShadowDrawableLeft(Drawable d) {
        this.f550d = d;
    }

    public void setShadowDrawableRight(Drawable d) {
        this.f551e = d;
    }

    @Deprecated
    public void setShadowResource(int resId) {
        setShadowDrawable(getResources().getDrawable(resId));
    }

    public void setShadowResourceLeft(int resId) {
        setShadowDrawableLeft(getResources().getDrawable(resId));
    }

    public void setShadowResourceRight(int resId) {
        setShadowDrawableRight(getResources().getDrawable(resId));
    }

    public void draw(Canvas c) {
        Drawable shadowDrawable;
        super.draw(c);
        if (m1289f()) {
            shadowDrawable = this.f551e;
        } else {
            shadowDrawable = this.f550d;
        }
        View shadowView = getChildCount() > 1 ? getChildAt(1) : null;
        if (shadowView != null && shadowDrawable != null) {
            int left;
            int right;
            int top = shadowView.getTop();
            int bottom = shadowView.getBottom();
            int shadowWidth = shadowDrawable.getIntrinsicWidth();
            if (m1289f()) {
                left = shadowView.getRight();
                right = left + shadowWidth;
            } else {
                right = shadowView.getLeft();
                left = right - shadowWidth;
            }
            shadowDrawable.setBounds(left, top, right, bottom);
            shadowDrawable.draw(c);
        }
    }

    private void m1282a(float slideOffset) {
        boolean dimViews;
        int childCount;
        int i;
        View v;
        int dx;
        boolean isLayoutRtl = m1289f();
        C0293b slideLp = (C0293b) this.f554h.getLayoutParams();
        if (slideLp.f543c) {
            if ((isLayoutRtl ? slideLp.rightMargin : slideLp.leftMargin) <= 0) {
                dimViews = true;
                childCount = getChildCount();
                for (i = 0; i < childCount; i++) {
                    v = getChildAt(i);
                    if (v == this.f554h) {
                        int oldOffset = (int) ((1.0f - this.f556j) * ((float) this.f559m));
                        this.f556j = slideOffset;
                        dx = oldOffset - ((int) ((1.0f - slideOffset) * ((float) this.f559m)));
                        if (isLayoutRtl) {
                            dx = -dx;
                        }
                        v.offsetLeftAndRight(dx);
                        if (!dimViews) {
                            m1284a(v, isLayoutRtl ? this.f556j - 1.0f : 1.0f - this.f556j, this.f549c);
                        }
                    }
                }
            }
        }
        dimViews = false;
        childCount = getChildCount();
        for (i = 0; i < childCount; i++) {
            v = getChildAt(i);
            if (v == this.f554h) {
                int oldOffset2 = (int) ((1.0f - this.f556j) * ((float) this.f559m));
                this.f556j = slideOffset;
                dx = oldOffset2 - ((int) ((1.0f - slideOffset) * ((float) this.f559m)));
                if (isLayoutRtl) {
                    dx = -dx;
                }
                v.offsetLeftAndRight(dx);
                if (!dimViews) {
                    if (isLayoutRtl) {
                    }
                    m1284a(v, isLayoutRtl ? this.f556j - 1.0f : 1.0f - this.f556j, this.f549c);
                }
            }
        }
    }

    boolean m1294b(View child) {
        if (child == null) {
            return false;
        }
        C0293b lp = (C0293b) child.getLayoutParams();
        if (this.f553g && lp.f543c && this.f555i > 0.0f) {
            return true;
        }
        return false;
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new C0293b();
    }

    protected LayoutParams generateLayoutParams(LayoutParams p) {
        return p instanceof MarginLayoutParams ? new C0293b((MarginLayoutParams) p) : new C0293b(p);
    }

    protected boolean checkLayoutParams(LayoutParams p) {
        return (p instanceof C0293b) && super.checkLayoutParams(p);
    }

    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new C0293b(getContext(), attrs);
    }

    protected Parcelable onSaveInstanceState() {
        SavedState ss = new SavedState(super.onSaveInstanceState());
        ss.f537a = m1297e() ? m1296d() : this.f564r;
        return ss;
    }

    protected void onRestoreInstanceState(Parcelable state) {
        SavedState ss = (SavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());
        if (ss.f537a) {
            m1293b();
        } else {
            m1295c();
        }
        this.f564r = ss.f537a;
    }

    private boolean m1289f() {
        return C0264r.m1164e(this) == 1;
    }
}
