package com.avg.ui.license.qrreader.general;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.avg.ui.general.C1091c.C1080d;
import com.avg.ui.license.qrreader.p061a.C1188b;
import com.google.android.gms.cast.Cast;
import com.google.p065a.C1310a;
import java.util.ArrayList;
import java.util.List;

public final class ViewfinderView extends View {
    private static final int[] f3594a;
    private C1188b f3595b;
    private final Paint f3596c;
    private Bitmap f3597d;
    private final int f3598e;
    private final int f3599f;
    private final int f3600g;
    private final int f3601h;
    private final int f3602i;
    private int f3603j;
    private List f3604k;
    private List f3605l;

    static {
        f3594a = new int[]{0, 64, Cast.MAX_NAMESPACE_LENGTH, 192, 255, 192, Cast.MAX_NAMESPACE_LENGTH, 64};
    }

    public ViewfinderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f3596c = new Paint(1);
        Resources resources = getResources();
        this.f3598e = resources.getColor(C1080d.viewfinder_mask);
        this.f3599f = resources.getColor(C1080d.result_view);
        this.f3600g = resources.getColor(C1080d.viewfinder_frame);
        this.f3601h = resources.getColor(C1080d.viewfinder_laser);
        this.f3602i = resources.getColor(C1080d.possible_result_points);
        this.f3603j = 0;
        this.f3604k = new ArrayList(5);
        this.f3605l = null;
    }

    public void setCameraManager(C1188b cameraManager) {
        this.f3595b = cameraManager;
    }

    public void onDraw(Canvas canvas) {
        Rect frame = this.f3595b.m4993a();
        if (frame != null) {
            int i;
            int width = canvas.getWidth();
            int height = canvas.getHeight();
            Paint paint = this.f3596c;
            if (this.f3597d != null) {
                i = this.f3599f;
            } else {
                i = this.f3598e;
            }
            paint.setColor(i);
            canvas.drawRect(0.0f, 0.0f, (float) width, (float) frame.top, this.f3596c);
            canvas.drawRect(0.0f, (float) frame.top, (float) frame.left, (float) (frame.bottom + 1), this.f3596c);
            canvas.drawRect((float) (frame.right + 1), (float) frame.top, (float) width, (float) (frame.bottom + 1), this.f3596c);
            canvas.drawRect(0.0f, (float) (frame.bottom + 1), (float) width, (float) height, this.f3596c);
            if (this.f3597d != null) {
                this.f3596c.setAlpha(160);
                canvas.drawBitmap(this.f3597d, null, frame, this.f3596c);
                return;
            }
            this.f3596c.setColor(this.f3600g);
            canvas.drawRect((float) frame.left, (float) frame.top, (float) (frame.right + 1), (float) (frame.top + 2), this.f3596c);
            canvas.drawRect((float) frame.left, (float) (frame.top + 2), (float) (frame.left + 2), (float) (frame.bottom - 1), this.f3596c);
            canvas.drawRect((float) (frame.right - 1), (float) frame.top, (float) (frame.right + 1), (float) (frame.bottom - 1), this.f3596c);
            canvas.drawRect((float) frame.left, (float) (frame.bottom - 1), (float) (frame.right + 1), (float) (frame.bottom + 1), this.f3596c);
            this.f3596c.setColor(this.f3601h);
            this.f3596c.setAlpha(f3594a[this.f3603j]);
            this.f3603j = (this.f3603j + 1) % f3594a.length;
            int middle = (frame.height() / 2) + frame.top;
            canvas.drawRect((float) (frame.left + 2), (float) (middle - 1), (float) (frame.right - 1), (float) (middle + 2), this.f3596c);
            Rect previewFrame = this.f3595b.m4994b();
            float scaleX = ((float) frame.width()) / ((float) previewFrame.width());
            float scaleY = ((float) frame.height()) / ((float) previewFrame.height());
            List<C1310a> currentPossible = this.f3604k;
            List<C1310a> currentLast = this.f3605l;
            int frameLeft = frame.left;
            int frameTop = frame.top;
            if (currentPossible.isEmpty()) {
                this.f3605l = null;
            } else {
                this.f3604k = new ArrayList(5);
                this.f3605l = currentPossible;
                this.f3596c.setAlpha(160);
                this.f3596c.setColor(this.f3602i);
                synchronized (currentPossible) {
                    for (C1310a point : currentPossible) {
                        canvas.drawCircle((float) (((int) (point.m5550a() * scaleX)) + frameLeft), (float) (((int) (point.m5551b() * scaleY)) + frameTop), 6.0f, this.f3596c);
                    }
                }
            }
            if (currentLast != null) {
                this.f3596c.setAlpha(80);
                this.f3596c.setColor(this.f3602i);
                synchronized (currentLast) {
                    for (C1310a point2 : currentLast) {
                        canvas.drawCircle((float) (((int) (point2.m5550a() * scaleX)) + frameLeft), (float) (((int) (point2.m5551b() * scaleY)) + frameTop), 3.0f, this.f3596c);
                    }
                }
            }
            postInvalidateDelayed(80, frame.left - 6, frame.top - 6, frame.right + 6, frame.bottom + 6);
        }
    }
}
