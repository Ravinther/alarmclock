package com.p044c.p045a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.widget.ImageView;
import com.p044c.p045a.C1295r.C1292d;

/* renamed from: com.c.a.s */
final class C1296s extends BitmapDrawable {
    private static final Paint f3921e;
    Drawable f3922a;
    long f3923b;
    boolean f3924c;
    int f3925d;
    private final boolean f3926f;
    private final float f3927g;
    private final C1292d f3928h;

    static {
        f3921e = new Paint();
    }

    static void m5511a(ImageView target, Context context, Bitmap bitmap, C1292d loadedFrom, boolean noFade, boolean debugging) {
        Drawable placeholder = target.getDrawable();
        if (placeholder instanceof AnimationDrawable) {
            ((AnimationDrawable) placeholder).stop();
        }
        target.setImageDrawable(new C1296s(context, bitmap, placeholder, loadedFrom, noFade, debugging));
    }

    static void m5510a(ImageView target, int placeholderResId, Drawable placeholderDrawable) {
        if (placeholderResId != 0) {
            target.setImageResource(placeholderResId);
        } else {
            target.setImageDrawable(placeholderDrawable);
        }
        if (target.getDrawable() instanceof AnimationDrawable) {
            ((AnimationDrawable) target.getDrawable()).start();
        }
    }

    C1296s(Context context, Bitmap bitmap, Drawable placeholder, C1292d loadedFrom, boolean noFade, boolean debugging) {
        super(context.getResources(), bitmap);
        this.f3925d = 255;
        this.f3926f = debugging;
        this.f3927g = context.getResources().getDisplayMetrics().density;
        this.f3928h = loadedFrom;
        boolean fade = (loadedFrom == C1292d.MEMORY || noFade) ? false : true;
        if (fade) {
            this.f3922a = placeholder;
            this.f3924c = true;
            this.f3923b = SystemClock.uptimeMillis();
        }
    }

    public void draw(Canvas canvas) {
        if (this.f3924c) {
            float normalized = ((float) (SystemClock.uptimeMillis() - this.f3923b)) / 200.0f;
            if (normalized >= 1.0f) {
                this.f3924c = false;
                this.f3922a = null;
                super.draw(canvas);
            } else {
                if (this.f3922a != null) {
                    this.f3922a.draw(canvas);
                }
                super.setAlpha((int) (((float) this.f3925d) * normalized));
                super.draw(canvas);
                super.setAlpha(this.f3925d);
                if (VERSION.SDK_INT <= 10) {
                    invalidateSelf();
                }
            }
        } else {
            super.draw(canvas);
        }
        if (this.f3926f) {
            m5509a(canvas);
        }
    }

    public void setAlpha(int alpha) {
        this.f3925d = alpha;
        if (this.f3922a != null) {
            this.f3922a.setAlpha(alpha);
        }
        super.setAlpha(alpha);
    }

    public void setColorFilter(ColorFilter cf) {
        if (this.f3922a != null) {
            this.f3922a.setColorFilter(cf);
        }
        super.setColorFilter(cf);
    }

    protected void onBoundsChange(Rect bounds) {
        if (this.f3922a != null) {
            this.f3922a.setBounds(bounds);
        }
        super.onBoundsChange(bounds);
    }

    private void m5509a(Canvas canvas) {
        f3921e.setColor(-1);
        canvas.drawPath(C1296s.m5508a(new Point(0, 0), (int) (16.0f * this.f3927g)), f3921e);
        f3921e.setColor(this.f3928h.f3904d);
        canvas.drawPath(C1296s.m5508a(new Point(0, 0), (int) (15.0f * this.f3927g)), f3921e);
    }

    private static Path m5508a(Point p1, int width) {
        Point p2 = new Point(p1.x + width, p1.y);
        Point p3 = new Point(p1.x, p1.y + width);
        Path path = new Path();
        path.moveTo((float) p1.x, (float) p1.y);
        path.lineTo((float) p2.x, (float) p2.y);
        path.lineTo((float) p3.x, (float) p3.y);
        return path;
    }
}
