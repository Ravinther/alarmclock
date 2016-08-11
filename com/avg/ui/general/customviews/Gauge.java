package com.avg.ui.general.customviews;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.avg.ui.general.C1091c.C1080d;
import com.avg.ui.general.C1091c.C1081e;
import com.avg.ui.general.C1091c.C1082f;
import com.avg.ui.general.C1091c.C1083g;
import com.avg.ui.general.C1091c.C1084h;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

public class Gauge extends FrameLayout {
    private static Handler f3411o;
    Runnable f3412a;
    private float f3413b;
    private float f3414c;
    private int f3415d;
    private C1127a f3416e;
    private int f3417f;
    private int f3418g;
    private int f3419h;
    private int f3420i;
    private boolean f3421j;
    private Paint f3422k;
    private RectF f3423l;
    private C1128a f3424m;
    private ImageView f3425n;

    /* renamed from: com.avg.ui.general.customviews.Gauge.1 */
    static class C11241 extends Handler {
        C11241() {
        }

        public void handleMessage(Message msg) {
        }
    }

    /* renamed from: com.avg.ui.general.customviews.Gauge.2 */
    class C11252 implements Runnable {
        final /* synthetic */ Gauge f3399a;

        C11252(Gauge gauge) {
            this.f3399a = gauge;
        }

        public void run() {
            if (this.f3399a.f3420i != this.f3399a.f3419h) {
                if (this.f3399a.f3421j) {
                    this.f3399a.f3420i = this.f3399a.f3420i + 6;
                    if (this.f3399a.f3420i < this.f3399a.f3419h) {
                        Gauge.f3411o.postDelayed(this.f3399a.f3412a, (long) this.f3399a.f3415d);
                    }
                } else {
                    this.f3399a.f3420i = this.f3399a.f3420i - 6;
                    if (this.f3399a.f3420i > this.f3399a.f3419h) {
                        Gauge.f3411o.postDelayed(this.f3399a.f3412a, (long) this.f3399a.f3415d);
                    }
                }
                this.f3399a.postInvalidate();
            }
        }
    }

    /* renamed from: com.avg.ui.general.customviews.Gauge.3 */
    static /* synthetic */ class C11263 {
        static final /* synthetic */ int[] f3400a;

        static {
            f3400a = new int[C1127a.values().length];
            try {
                f3400a[C1127a.eGreen.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f3400a[C1127a.eRed.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f3400a[C1127a.eAmber.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* renamed from: com.avg.ui.general.customviews.Gauge.a */
    public interface C1128a {

        /* renamed from: com.avg.ui.general.customviews.Gauge.a.a */
        public enum C1127a {
            eGreen,
            eRed,
            eAmber
        }

        int m4765a();

        int m4766b();
    }

    /* renamed from: com.avg.ui.general.customviews.Gauge.b */
    public enum C1129b {
        eSmall(C1083g.refreshRateSmall, C1083g.circleWidthSmall, C1083g.paddingSmall),
        eBig(C1083g.refreshRateBig, C1083g.circleWidthBig, C1083g.paddingBig);
        
        private final int f3408c;
        private final int f3409d;
        private final int f3410e;

        private C1129b(int refreshRate, int circleWidthInDP, int paddingInDP) {
            this.f3408c = refreshRate;
            this.f3409d = circleWidthInDP;
            this.f3410e = paddingInDP;
        }
    }

    static {
        f3411o = new C11241();
    }

    public Gauge(Context context) {
        super(context);
        this.f3413b = 0.0f;
        this.f3414c = 0.0f;
        this.f3415d = 2;
        this.f3416e = null;
        this.f3420i = 0;
        this.f3422k = new Paint();
        this.f3423l = new RectF();
        this.f3424m = null;
        this.f3425n = null;
        this.f3412a = new C11252(this);
        setupUi(context);
    }

    public Gauge(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f3413b = 0.0f;
        this.f3414c = 0.0f;
        this.f3415d = 2;
        this.f3416e = null;
        this.f3420i = 0;
        this.f3422k = new Paint();
        this.f3423l = new RectF();
        this.f3424m = null;
        this.f3425n = null;
        this.f3412a = new C11252(this);
        setupUi(context);
    }

    public Gauge(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.f3413b = 0.0f;
        this.f3414c = 0.0f;
        this.f3415d = 2;
        this.f3416e = null;
        this.f3420i = 0;
        this.f3422k = new Paint();
        this.f3423l = new RectF();
        this.f3424m = null;
        this.f3425n = null;
        this.f3412a = new C11252(this);
        setupUi(context);
    }

    private void setupUi(Context context) {
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(C1084h.gauge_view, this);
        this.f3425n = (ImageView) findViewById(C1082f.gauge_icon);
        setWillNotDraw(false);
    }

    private void setResourcesBySize(C1129b eSize) {
        Resources resources = getContext().getResources();
        this.f3415d = resources.getInteger(eSize.f3408c);
        this.f3413b = m4770a((float) resources.getInteger(eSize.f3409d));
        this.f3414c = m4770a((float) resources.getInteger(eSize.f3410e));
        if (eSize == C1129b.eSmall) {
            this.f3425n.setImageResource(this.f3424m.m4765a());
        } else {
            this.f3425n.setImageResource(this.f3424m.m4766b());
            ((ImageView) findViewById(C1082f.outer_circle)).setImageResource(C1081e.outer_circle_large);
        }
        m4775b();
    }

    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.f3418g = w;
        this.f3417f = h;
        m4775b();
        if (!isInEditMode()) {
            setupCirclePaint(this.f3416e);
        }
    }

    private void m4775b() {
        float xDelta = (((float) ((this.f3418g - Math.min(this.f3417f, this.f3418g)) / 2)) + this.f3413b) + this.f3414c;
        float yDelta = (((float) ((this.f3417f - Math.min(this.f3417f, this.f3418g)) / 2)) + this.f3413b) + this.f3414c;
        this.f3423l = new RectF(xDelta, yDelta, ((float) this.f3418g) - xDelta, ((float) this.f3417f) - yDelta);
    }

    private void setupCirclePaint(C1127a eColor) {
        int colorTop = 0;
        int colorBottom = 0;
        if (eColor == null) {
            eColor = C1127a.eGreen;
        }
        switch (C11263.f3400a[eColor.ordinal()]) {
            case Base64.NO_PADDING /*1*/:
                colorTop = getResources().getColor(C1080d.gauge_green_top);
                colorBottom = getResources().getColor(C1080d.gauge_green_bottom);
                break;
            case Base64.NO_WRAP /*2*/:
                colorTop = getResources().getColor(C1080d.gauge_red_top);
                colorBottom = getResources().getColor(C1080d.gauge_red_bottom);
                break;
            case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                colorTop = getResources().getColor(C1080d.gauge_orange_top);
                colorBottom = getResources().getColor(C1080d.gauge_orange_bottom);
                break;
        }
        this.f3422k.setAntiAlias(true);
        this.f3422k.setStyle(Style.STROKE);
        this.f3422k.setStrokeWidth(this.f3413b);
        this.f3422k.setShader(new LinearGradient(0.0f, this.f3423l.top, 0.0f, this.f3423l.bottom, colorTop, colorBottom, TileMode.CLAMP));
    }

    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.f3423l, -90.0f, (float) this.f3420i, false, this.f3422k);
    }

    private float m4770a(float dpi) {
        return TypedValue.applyDimension(1, dpi, getResources().getDisplayMetrics());
    }
}
