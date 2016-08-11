package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import com.mopub.mobileads.CustomEventBannerAdapter;

public class ProgressBarICS extends View {
    private static final int[] f1059f;
    int f1060a;
    int f1061b;
    int f1062c;
    int f1063d;
    Bitmap f1064e;
    private int f1065g;
    private int f1066h;
    private int f1067i;
    private int f1068j;
    private int f1069k;
    private boolean f1070l;
    private boolean f1071m;
    private Transformation f1072n;
    private AlphaAnimation f1073o;
    private Drawable f1074p;
    private Drawable f1075q;
    private Drawable f1076r;
    private boolean f1077s;
    private Interpolator f1078t;
    private C0427a f1079u;
    private long f1080v;
    private boolean f1081w;
    private long f1082x;
    private boolean f1083y;

    static class SavedState extends BaseSavedState {
        public static final Creator CREATOR;
        int f1053a;
        int f1054b;

        /* renamed from: android.support.v7.internal.widget.ProgressBarICS.SavedState.1 */
        static class C04261 implements Creator {
            C04261() {
            }

            public /* synthetic */ Object createFromParcel(Parcel x0) {
                return m2090a(x0);
            }

            public /* synthetic */ Object[] newArray(int x0) {
                return m2091a(x0);
            }

            public SavedState m2090a(Parcel in) {
                return new SavedState(null);
            }

            public SavedState[] m2091a(int size) {
                return new SavedState[size];
            }
        }

        SavedState(Parcelable superState) {
            super(superState);
        }

        private SavedState(Parcel in) {
            super(in);
            this.f1053a = in.readInt();
            this.f1054b = in.readInt();
        }

        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeInt(this.f1053a);
            out.writeInt(this.f1054b);
        }

        static {
            CREATOR = new C04261();
        }
    }

    /* renamed from: android.support.v7.internal.widget.ProgressBarICS.a */
    private class C0427a implements Runnable {
        final /* synthetic */ ProgressBarICS f1055a;
        private int f1056b;
        private int f1057c;
        private boolean f1058d;

        C0427a(ProgressBarICS progressBarICS, int id, int progress, boolean fromUser) {
            this.f1055a = progressBarICS;
            this.f1056b = id;
            this.f1057c = progress;
            this.f1058d = fromUser;
        }

        public void run() {
            this.f1055a.m2098a(this.f1056b, this.f1057c, this.f1058d, true);
            this.f1055a.f1079u = this;
        }

        public void m2092a(int id, int progress, boolean fromUser) {
            this.f1056b = id;
            this.f1057c = progress;
            this.f1058d = fromUser;
        }
    }

    static {
        f1059f = new int[]{16843062, 16843063, 16843064, 16843065, 16843066, 16843067, 16843068, 16843069, 16843070, 16843071, 16843039, 16843072, 16843040, 16843073};
    }

    public ProgressBarICS(Context context, AttributeSet attrs, int defStyle, int styleRes) {
        boolean z = false;
        super(context, attrs, defStyle);
        this.f1080v = Thread.currentThread().getId();
        m2100c();
        TypedArray a = context.obtainStyledAttributes(attrs, f1059f, defStyle, styleRes);
        this.f1077s = true;
        setMax(a.getInt(0, this.f1067i));
        setProgress(a.getInt(1, this.f1065g));
        setSecondaryProgress(a.getInt(2, this.f1066h));
        boolean indeterminate = a.getBoolean(3, this.f1070l);
        this.f1071m = a.getBoolean(4, this.f1071m);
        Drawable drawable = a.getDrawable(5);
        if (drawable != null) {
            setIndeterminateDrawable(m2093a(drawable));
        }
        drawable = a.getDrawable(6);
        if (drawable != null) {
            setProgressDrawable(m2094a(drawable, false));
        }
        this.f1069k = a.getInt(7, this.f1069k);
        this.f1068j = a.getInt(8, this.f1068j);
        this.f1060a = a.getDimensionPixelSize(9, this.f1060a);
        this.f1061b = a.getDimensionPixelSize(10, this.f1061b);
        this.f1062c = a.getDimensionPixelSize(11, this.f1062c);
        this.f1063d = a.getDimensionPixelSize(12, this.f1063d);
        int resID = a.getResourceId(13, 17432587);
        if (resID > 0) {
            m2104a(context, resID);
        }
        a.recycle();
        this.f1077s = false;
        if (this.f1071m || indeterminate) {
            z = true;
        }
        setIndeterminate(z);
    }

    private Drawable m2094a(Drawable drawable, boolean clip) {
        if (drawable instanceof LayerDrawable) {
            int i;
            LayerDrawable background = (LayerDrawable) drawable;
            int N = background.getNumberOfLayers();
            Drawable[] outDrawables = new Drawable[N];
            for (i = 0; i < N; i++) {
                int id = background.getId(i);
                Drawable drawable2 = background.getDrawable(i);
                boolean z = id == 16908301 || id == 16908303;
                outDrawables[i] = m2094a(drawable2, z);
            }
            Drawable layerDrawable = new LayerDrawable(outDrawables);
            for (i = 0; i < N; i++) {
                layerDrawable.setId(i, background.getId(i));
            }
            return layerDrawable;
        } else if (!(drawable instanceof BitmapDrawable)) {
            return drawable;
        } else {
            Bitmap tileBitmap = ((BitmapDrawable) drawable).getBitmap();
            if (this.f1064e == null) {
                this.f1064e = tileBitmap;
            }
            Drawable shapeDrawable = new ShapeDrawable(getDrawableShape());
            shapeDrawable.getPaint().setShader(new BitmapShader(tileBitmap, TileMode.REPEAT, TileMode.CLAMP));
            if (clip) {
                shapeDrawable = new ClipDrawable(shapeDrawable, 3, 1);
            }
            return shapeDrawable;
        }
    }

    Shape getDrawableShape() {
        return new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null);
    }

    private Drawable m2093a(Drawable drawable) {
        if (!(drawable instanceof AnimationDrawable)) {
            return drawable;
        }
        AnimationDrawable background = (AnimationDrawable) drawable;
        int N = background.getNumberOfFrames();
        Drawable newBg = new AnimationDrawable();
        newBg.setOneShot(background.isOneShot());
        for (int i = 0; i < N; i++) {
            Drawable frame = m2094a(background.getFrame(i), true);
            frame.setLevel(CustomEventBannerAdapter.DEFAULT_BANNER_TIMEOUT_DELAY);
            newBg.addFrame(frame, background.getDuration(i));
        }
        newBg.setLevel(CustomEventBannerAdapter.DEFAULT_BANNER_TIMEOUT_DELAY);
        return newBg;
    }

    private void m2100c() {
        this.f1067i = 100;
        this.f1065g = 0;
        this.f1066h = 0;
        this.f1070l = false;
        this.f1071m = false;
        this.f1069k = 4000;
        this.f1068j = 1;
        this.f1060a = 24;
        this.f1061b = 48;
        this.f1062c = 24;
        this.f1063d = 48;
    }

    public synchronized void setIndeterminate(boolean indeterminate) {
        if (!((this.f1071m && this.f1070l) || indeterminate == this.f1070l)) {
            this.f1070l = indeterminate;
            if (indeterminate) {
                this.f1076r = this.f1074p;
                m2102a();
            } else {
                this.f1076r = this.f1075q;
                m2105b();
            }
        }
    }

    public Drawable getIndeterminateDrawable() {
        return this.f1074p;
    }

    public void setIndeterminateDrawable(Drawable d) {
        if (d != null) {
            d.setCallback(this);
        }
        this.f1074p = d;
        if (this.f1070l) {
            this.f1076r = d;
            postInvalidate();
        }
    }

    public Drawable getProgressDrawable() {
        return this.f1075q;
    }

    public void setProgressDrawable(Drawable d) {
        boolean needUpdate;
        if (this.f1075q == null || d == this.f1075q) {
            needUpdate = false;
        } else {
            this.f1075q.setCallback(null);
            needUpdate = true;
        }
        if (d != null) {
            d.setCallback(this);
            int drawableHeight = d.getMinimumHeight();
            if (this.f1063d < drawableHeight) {
                this.f1063d = drawableHeight;
                requestLayout();
            }
        }
        this.f1075q = d;
        if (!this.f1070l) {
            this.f1076r = d;
            postInvalidate();
        }
        if (needUpdate) {
            m2096a(getWidth(), getHeight());
            m2101d();
            m2098a(16908301, this.f1065g, false, false);
            m2098a(16908303, this.f1066h, false, false);
        }
    }

    protected boolean verifyDrawable(Drawable who) {
        return who == this.f1075q || who == this.f1074p || super.verifyDrawable(who);
    }

    public void postInvalidate() {
        if (!this.f1077s) {
            super.postInvalidate();
        }
    }

    private synchronized void m2098a(int id, int progress, boolean fromUser, boolean callBackToApp) {
        float scale = this.f1067i > 0 ? ((float) progress) / ((float) this.f1067i) : 0.0f;
        Drawable d = this.f1076r;
        if (d != null) {
            Drawable progressDrawable = null;
            if (d instanceof LayerDrawable) {
                progressDrawable = ((LayerDrawable) d).findDrawableByLayerId(id);
            }
            int level = (int) (10000.0f * scale);
            if (progressDrawable == null) {
                progressDrawable = d;
            }
            progressDrawable.setLevel(level);
        } else {
            invalidate();
        }
    }

    private synchronized void m2097a(int id, int progress, boolean fromUser) {
        if (this.f1080v == Thread.currentThread().getId()) {
            m2098a(id, progress, fromUser, true);
        } else {
            C0427a r;
            if (this.f1079u != null) {
                r = this.f1079u;
                this.f1079u = null;
                r.m2092a(id, progress, fromUser);
            } else {
                r = new C0427a(this, id, progress, fromUser);
            }
            post(r);
        }
    }

    public synchronized void setProgress(int progress) {
        m2103a(progress, false);
    }

    synchronized void m2103a(int progress, boolean fromUser) {
        if (!this.f1070l) {
            if (progress < 0) {
                progress = 0;
            }
            if (progress > this.f1067i) {
                progress = this.f1067i;
            }
            if (progress != this.f1065g) {
                this.f1065g = progress;
                m2097a(16908301, this.f1065g, fromUser);
            }
        }
    }

    public synchronized void setSecondaryProgress(int secondaryProgress) {
        if (!this.f1070l) {
            if (secondaryProgress < 0) {
                secondaryProgress = 0;
            }
            if (secondaryProgress > this.f1067i) {
                secondaryProgress = this.f1067i;
            }
            if (secondaryProgress != this.f1066h) {
                this.f1066h = secondaryProgress;
                m2097a(16908303, this.f1066h, false);
            }
        }
    }

    public synchronized int getProgress() {
        return this.f1070l ? 0 : this.f1065g;
    }

    public synchronized int getSecondaryProgress() {
        return this.f1070l ? 0 : this.f1066h;
    }

    public synchronized int getMax() {
        return this.f1067i;
    }

    public synchronized void setMax(int max) {
        if (max < 0) {
            max = 0;
        }
        if (max != this.f1067i) {
            this.f1067i = max;
            postInvalidate();
            if (this.f1065g > max) {
                this.f1065g = max;
            }
            m2097a(16908301, this.f1065g, false);
        }
    }

    void m2102a() {
        if (getVisibility() == 0) {
            if (this.f1074p instanceof Animatable) {
                this.f1081w = true;
                this.f1073o = null;
            } else {
                if (this.f1078t == null) {
                    this.f1078t = new LinearInterpolator();
                }
                this.f1072n = new Transformation();
                this.f1073o = new AlphaAnimation(0.0f, 1.0f);
                this.f1073o.setRepeatMode(this.f1068j);
                this.f1073o.setRepeatCount(-1);
                this.f1073o.setDuration((long) this.f1069k);
                this.f1073o.setInterpolator(this.f1078t);
                this.f1073o.setStartTime(-1);
            }
            postInvalidate();
        }
    }

    void m2105b() {
        this.f1073o = null;
        this.f1072n = null;
        if (this.f1074p instanceof Animatable) {
            ((Animatable) this.f1074p).stop();
            this.f1081w = false;
        }
        postInvalidate();
    }

    public void m2104a(Context context, int resID) {
        setInterpolator(AnimationUtils.loadInterpolator(context, resID));
    }

    public void setInterpolator(Interpolator interpolator) {
        this.f1078t = interpolator;
    }

    public Interpolator getInterpolator() {
        return this.f1078t;
    }

    public void setVisibility(int v) {
        if (getVisibility() != v) {
            super.setVisibility(v);
            if (!this.f1070l) {
                return;
            }
            if (v == 8 || v == 4) {
                m2105b();
            } else {
                m2102a();
            }
        }
    }

    protected void onVisibilityChanged(View changedView, int visibility) {
        super.onVisibilityChanged(changedView, visibility);
        if (!this.f1070l) {
            return;
        }
        if (visibility == 8 || visibility == 4) {
            m2105b();
        } else {
            m2102a();
        }
    }

    public void invalidateDrawable(Drawable dr) {
        if (!this.f1083y) {
            if (verifyDrawable(dr)) {
                Rect dirty = dr.getBounds();
                int scrollX = getScrollX() + getPaddingLeft();
                int scrollY = getScrollY() + getPaddingTop();
                invalidate(dirty.left + scrollX, dirty.top + scrollY, dirty.right + scrollX, dirty.bottom + scrollY);
                return;
            }
            super.invalidateDrawable(dr);
        }
    }

    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        m2096a(w, h);
    }

    private void m2096a(int w, int h) {
        int right = (w - getPaddingRight()) - getPaddingLeft();
        int bottom = (h - getPaddingBottom()) - getPaddingTop();
        int top = 0;
        int left = 0;
        if (this.f1074p != null) {
            if (this.f1071m && !(this.f1074p instanceof AnimationDrawable)) {
                float intrinsicAspect = ((float) this.f1074p.getIntrinsicWidth()) / ((float) this.f1074p.getIntrinsicHeight());
                float boundAspect = ((float) w) / ((float) h);
                if (intrinsicAspect != boundAspect) {
                    if (boundAspect > intrinsicAspect) {
                        int width = (int) (((float) h) * intrinsicAspect);
                        left = (w - width) / 2;
                        right = left + width;
                    } else {
                        int height = (int) (((float) w) * (1.0f / intrinsicAspect));
                        top = (h - height) / 2;
                        bottom = top + height;
                    }
                }
            }
            this.f1074p.setBounds(left, top, right, bottom);
        }
        if (this.f1075q != null) {
            this.f1075q.setBounds(0, 0, right, bottom);
        }
    }

    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Drawable d = this.f1076r;
        if (d != null) {
            canvas.save();
            canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            long time = getDrawingTime();
            if (this.f1073o != null) {
                this.f1073o.getTransformation(time, this.f1072n);
                float scale = this.f1072n.getAlpha();
                try {
                    this.f1083y = true;
                    d.setLevel((int) (10000.0f * scale));
                    this.f1083y = false;
                    if (SystemClock.uptimeMillis() - this.f1082x >= 200) {
                        this.f1082x = SystemClock.uptimeMillis();
                        postInvalidateDelayed(200);
                    }
                } catch (Throwable th) {
                    this.f1083y = false;
                }
            }
            d.draw(canvas);
            canvas.restore();
            if (this.f1081w && (d instanceof Animatable)) {
                ((Animatable) d).start();
                this.f1081w = false;
            }
        }
    }

    protected synchronized void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Drawable d = this.f1076r;
        int dw = 0;
        int dh = 0;
        if (d != null) {
            dw = Math.max(this.f1060a, Math.min(this.f1061b, d.getIntrinsicWidth()));
            dh = Math.max(this.f1062c, Math.min(this.f1063d, d.getIntrinsicHeight()));
        }
        m2101d();
        setMeasuredDimension(resolveSize(dw + (getPaddingLeft() + getPaddingRight()), widthMeasureSpec), resolveSize(dh + (getPaddingTop() + getPaddingBottom()), heightMeasureSpec));
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        m2101d();
    }

    private void m2101d() {
        int[] state = getDrawableState();
        if (this.f1075q != null && this.f1075q.isStateful()) {
            this.f1075q.setState(state);
        }
        if (this.f1074p != null && this.f1074p.isStateful()) {
            this.f1074p.setState(state);
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState ss = new SavedState(super.onSaveInstanceState());
        ss.f1053a = this.f1065g;
        ss.f1054b = this.f1066h;
        return ss;
    }

    public void onRestoreInstanceState(Parcelable state) {
        SavedState ss = (SavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());
        setProgress(ss.f1053a);
        setSecondaryProgress(ss.f1054b);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f1070l) {
            m2102a();
        }
    }

    protected void onDetachedFromWindow() {
        if (this.f1070l) {
            m2105b();
        }
        if (this.f1079u != null) {
            removeCallbacks(this.f1079u);
        }
        super.onDetachedFromWindow();
    }
}
