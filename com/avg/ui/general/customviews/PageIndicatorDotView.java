package com.avg.ui.general.customviews;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.avg.ui.general.C1091c.C1081e;

public class PageIndicatorDotView extends View {
    private int f3432a;
    private int f3433b;
    private Bitmap f3434c;
    private Bitmap f3435d;
    private Paint f3436e;

    public PageIndicatorDotView(Context context) {
        super(context);
        this.f3434c = null;
        this.f3435d = null;
        this.f3436e = null;
        m4791a();
    }

    public PageIndicatorDotView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f3434c = null;
        this.f3435d = null;
        this.f3436e = null;
        m4791a();
    }

    public PageIndicatorDotView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.f3434c = null;
        this.f3435d = null;
        this.f3436e = null;
        m4791a();
    }

    protected void onDraw(Canvas canvas) {
        m4792a(canvas);
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(resolveSize((this.f3432a * (this.f3434c.getWidth() + 5)) - 5, widthMeasureSpec), resolveSize(this.f3434c.getHeight(), heightMeasureSpec));
    }

    public void setNumberOfDots(int totalNoOfDots) {
        this.f3432a = totalNoOfDots;
    }

    public void setActiveDot(int activeDot) {
        this.f3433b = activeDot;
        invalidate();
    }

    private void m4791a() {
        this.f3433b = 0;
        this.f3436e = new Paint(1);
        this.f3434c = BitmapFactory.decodeResource(getResources(), C1081e.onboarding_indicator_icon);
        this.f3435d = BitmapFactory.decodeResource(getResources(), C1081e.onboarding_indicator_icon_disabled);
    }

    private void m4792a(Canvas canvas) {
        int x = 0;
        for (int i = 0; i < this.f3432a; i++) {
            if (i == this.f3433b) {
                canvas.drawBitmap(this.f3434c, (float) x, 0.0f, this.f3436e);
            } else {
                canvas.drawBitmap(this.f3435d, (float) x, 0.0f, this.f3436e);
            }
            x = (this.f3434c.getWidth() + x) + 5;
        }
    }
}
