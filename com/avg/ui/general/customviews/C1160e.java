package com.avg.ui.general.customviews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import com.avg.ui.general.customviews.SlidingTabLayout.C1136c;

/* renamed from: com.avg.ui.general.customviews.e */
class C1160e extends LinearLayout {
    private final int f3512a;
    private final Paint f3513b;
    private final int f3514c;
    private final Paint f3515d;
    private final Paint f3516e;
    private final float f3517f;
    private int f3518g;
    private float f3519h;
    private C1136c f3520i;
    private final C1159a f3521j;

    /* renamed from: com.avg.ui.general.customviews.e.a */
    private static class C1159a implements C1136c {
        private int[] f3510a;
        private int[] f3511b;

        private C1159a() {
        }

        public final int m4856a(int position) {
            return this.f3510a[position % this.f3510a.length];
        }

        public final int m4858b(int position) {
            return this.f3511b[position % this.f3511b.length];
        }

        void m4857a(int... colors) {
            this.f3510a = colors;
        }

        void m4859b(int... colors) {
            this.f3511b = colors;
        }
    }

    C1160e(Context context) {
        this(context, null);
    }

    C1160e(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);
        float density = getResources().getDisplayMetrics().density;
        TypedValue outValue = new TypedValue();
        context.getTheme().resolveAttribute(16842800, outValue, true);
        int mDefaultBottomBorderColor = C1160e.m4860a(outValue.data, (byte) 38);
        this.f3521j = new C1159a();
        this.f3521j.m4857a(-13388315);
        this.f3521j.m4859b(C1160e.m4860a(themeForegroundColor, (byte) 32));
        this.f3512a = (int) (2.0f * density);
        this.f3513b = new Paint();
        this.f3513b.setColor(mDefaultBottomBorderColor);
        this.f3514c = (int) (8.0f * density);
        this.f3515d = new Paint();
        this.f3517f = 0.5f;
        this.f3516e = new Paint();
        this.f3516e.setStrokeWidth((float) ((int) (1.0f * density)));
    }

    void m4863a(C1136c customTabColorizer) {
        this.f3520i = customTabColorizer;
        invalidate();
    }

    void m4864a(int... colors) {
        this.f3520i = null;
        this.f3521j.m4857a(colors);
        invalidate();
    }

    void m4865b(int... colors) {
        this.f3520i = null;
        this.f3521j.m4859b(colors);
        invalidate();
    }

    void m4862a(int position, float positionOffset) {
        this.f3518g = position;
        this.f3519h = positionOffset;
        invalidate();
    }

    protected void onDraw(Canvas canvas) {
        int height = getHeight();
        int childCount = getChildCount();
        int dividerHeightPx = (int) (Math.min(Math.max(0.0f, this.f3517f), 1.0f) * ((float) height));
        if (this.f3520i != null) {
            C1136c tabColorizer = this.f3520i;
        } else {
            Object tabColorizer2 = this.f3521j;
        }
        if (childCount > 0) {
            View selectedTitle = getChildAt(this.f3518g);
            int left = selectedTitle.getLeft();
            int right = selectedTitle.getRight();
            int color = tabColorizer.m4801a(this.f3518g);
            if (this.f3519h > 0.0f && this.f3518g < getChildCount() - 1) {
                int nextColor = tabColorizer.m4801a(this.f3518g + 1);
                if (color != nextColor) {
                    color = C1160e.m4861a(nextColor, color, this.f3519h);
                }
                View nextTitle = getChildAt(this.f3518g + 1);
                left = (int) ((this.f3519h * ((float) nextTitle.getLeft())) + ((1.0f - this.f3519h) * ((float) left)));
                right = (int) ((this.f3519h * ((float) nextTitle.getRight())) + ((1.0f - this.f3519h) * ((float) right)));
            }
            this.f3515d.setColor(color);
            canvas.drawRect((float) left, (float) (height - this.f3514c), (float) right, (float) height, this.f3515d);
        }
        canvas.drawRect(0.0f, (float) (height - this.f3512a), (float) getWidth(), (float) height, this.f3513b);
        int separatorTop = (height - dividerHeightPx) / 2;
        for (int i = 0; i < childCount - 1; i++) {
            View child = getChildAt(i);
            this.f3516e.setColor(tabColorizer.m4802b(i));
            canvas.drawLine((float) child.getRight(), (float) separatorTop, (float) child.getRight(), (float) (separatorTop + dividerHeightPx), this.f3516e);
        }
    }

    private static int m4860a(int color, byte alpha) {
        return Color.argb(alpha, Color.red(color), Color.green(color), Color.blue(color));
    }

    private static int m4861a(int color1, int color2, float ratio) {
        float inverseRation = 1.0f - ratio;
        return Color.rgb((int) ((((float) Color.red(color1)) * ratio) + (((float) Color.red(color2)) * inverseRation)), (int) ((((float) Color.green(color1)) * ratio) + (((float) Color.green(color2)) * inverseRation)), (int) ((((float) Color.blue(color1)) * ratio) + (((float) Color.blue(color2)) * inverseRation)));
    }
}
