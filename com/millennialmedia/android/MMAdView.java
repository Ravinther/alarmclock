package com.millennialmedia.android;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import com.mopub.mobileads.CustomEventBannerAdapter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Random;

public final class MMAdView extends MMLayout implements OnClickListener, AnimationListener {
    static final int DEFAULT_RESIZE_PARAM_VALUES = -50;
    public static final int TRANSITION_DOWN = 3;
    public static final int TRANSITION_FADE = 1;
    public static final int TRANSITION_NONE = 0;
    public static final int TRANSITION_RANDOM = 4;
    public static final int TRANSITION_UP = 2;
    int height;
    int oldHeight;
    int oldWidth;
    ImageView refreshAnimationimageView;
    int transitionType;
    ResizeView view;
    int width;

    /* renamed from: com.millennialmedia.android.MMAdView.1 */
    class C24761 implements Runnable {
        C24761() {
        }

        public void run() {
            float density = MMAdView.this.getContext().getResources().getDisplayMetrics().density;
            if (MMAdView.this.width <= 0) {
                MMAdView.this.width = (int) (((float) MMAdView.this.getWidth()) / density);
            }
            if (MMAdView.this.height <= 0) {
                MMAdView.this.height = (int) (((float) MMAdView.this.getHeight()) / density);
            }
        }
    }

    class BannerBounds {
        DTOResizeParameters resizeParams;
        int translationX;
        int translationY;

        private class BoundsResult {
            int size;
            int translation;

            private BoundsResult() {
            }
        }

        BannerBounds(DTOResizeParameters resizeParams) {
            this.resizeParams = resizeParams;
            this.translationX = resizeParams.offsetX;
            this.translationY = resizeParams.offsetY;
        }

        void calculateOnScreenBounds() {
            calculateXBounds();
            calculateYBounds();
        }

        private void calculateXBounds() {
            int[] loc = new int[MMAdView.TRANSITION_UP];
            MMAdView.this.getLocationInWindow(loc);
            BoundsResult resultX = calculateBounds(loc[MMAdView.TRANSITION_NONE], this.resizeParams.offsetX, this.resizeParams.width, this.resizeParams.xMax);
            this.resizeParams.width = resultX.size;
            this.translationX = resultX.translation;
        }

        private void calculateYBounds() {
            int[] loc = new int[MMAdView.TRANSITION_UP];
            MMAdView.this.getLocationInWindow(loc);
            BoundsResult resultY = calculateBounds(loc[MMAdView.TRANSITION_FADE], this.resizeParams.offsetY, this.resizeParams.height, this.resizeParams.yMax);
            this.resizeParams.height = resultY.size;
            this.translationY = resultY.translation;
        }

        private BoundsResult calculateBounds(int screenPos, int offset, int size, int max) {
            int newStart = screenPos;
            int newSize = size;
            if ((screenPos + size) + offset > max) {
                newStart = (max - size) + offset;
                if (newStart < 0) {
                    newStart = MMAdView.TRANSITION_NONE;
                    newSize = max;
                } else if (newStart + size > max) {
                    newStart = max - size;
                }
            } else if (offset > 0) {
                newStart = offset;
            }
            BoundsResult result = new BoundsResult();
            result.translation = newStart - screenPos;
            result.size = newSize;
            return result;
        }

        LayoutParams modifyLayoutParams(LayoutParams oldParams) {
            oldParams.width = this.resizeParams.width;
            oldParams.height = this.resizeParams.height;
            return oldParams;
        }
    }

    class MMAdViewMMAdImpl extends MMLayoutMMAdImpl {

        /* renamed from: com.millennialmedia.android.MMAdView.MMAdViewMMAdImpl.1 */
        class C24771 implements Runnable {
            final /* synthetic */ Animation val$animFinal;

            C24771(Animation animation) {
                this.val$animFinal = animation;
            }

            public void run() {
                MMAdView.this.refreshAnimationimageView.startAnimation(this.val$animFinal);
            }
        }

        public MMAdViewMMAdImpl(Context context) {
            super(context);
            this.mmWebViewClientListener = new MMAdViewWebViewClientListener(this);
        }

        String getRequestFailedAction() {
            return MMBroadcastReceiver.ACTION_GETAD_FAILED;
        }

        String getRequestCompletedAction() {
            return MMBroadcastReceiver.ACTION_GETAD_SUCCEEDED;
        }

        String getReqType() {
            return "getad";
        }

        boolean isTransitionAnimated() {
            return MMAdView.this.transitionType != 0;
        }

        void prepareTransition(Bitmap bitmap) {
            MMAdView.this.refreshAnimationimageView.setImageBitmap(bitmap);
            MMAdView.this.refreshAnimationimageView.setVisibility(MMAdView.TRANSITION_NONE);
            MMAdView.this.refreshAnimationimageView.bringToFront();
        }

        public boolean isBanner() {
            return true;
        }

        public boolean hasCachedVideoSupport() {
            return false;
        }

        void insertUrlAdMetaValues(Map paramsMap) {
            if (MMAdView.this.height > 0) {
                paramsMap.put(MMRequest.KEY_HEIGHT, String.valueOf(MMAdView.this.height));
            }
            if (MMAdView.this.width > 0) {
                paramsMap.put(MMRequest.KEY_WIDTH, String.valueOf(MMAdView.this.width));
            }
            super.insertUrlAdMetaValues(paramsMap);
        }

        boolean isLifecycleObservable() {
            return MMAdView.this.getWindowToken() != null;
        }

        void animateTransition() {
            if (MMAdView.this.refreshAnimationimageView.getDrawable() != null) {
                Animation animation;
                int type = MMAdView.this.transitionType;
                if (type == MMAdView.TRANSITION_RANDOM) {
                    type = new Random().nextInt(MMAdView.TRANSITION_RANDOM);
                }
                switch (type) {
                    case MMAdView.TRANSITION_UP /*2*/:
                        animation = new TranslateAnimation(0.0f, 0.0f, 0.0f, -((float) MMAdView.this.getHeight()));
                        break;
                    case MMAdView.TRANSITION_DOWN /*3*/:
                        animation = new TranslateAnimation(0.0f, 0.0f, 0.0f, (float) MMAdView.this.getHeight());
                        break;
                    default:
                        animation = new AlphaAnimation(1.0f, 0.0f);
                        break;
                }
                animation.setDuration(1000);
                animation.setAnimationListener(MMAdView.this);
                animation.setFillEnabled(true);
                animation.setFillBefore(true);
                animation.setFillAfter(true);
                MMSDK.runOnUiThread(new C24771(animation));
            }
        }
    }

    private static class MMAdViewWebViewClientListener extends BasicWebViewClientListener {
        MMAdViewWebViewClientListener(MMAdImpl adImpl) {
            super(adImpl);
        }

        public void onPageFinished(String url) {
            super.onPageFinished(url);
            MMAdImpl adImpl = (MMAdImpl) this.adImplRef.get();
            if (adImpl != null && adImpl.isTransitionAnimated()) {
                adImpl.animateTransition();
            }
        }
    }

    class ResizeView extends View {
        public ResizeView(Context context) {
            super(context);
        }

        protected Parcelable onSaveInstanceState() {
            Log.m9711d("onSaveInstanceState");
            attachToContext(MMAdView.this);
            return super.onSaveInstanceState();
        }

        protected void onRestoreInstanceState(Parcelable state) {
            Log.m9711d("onRestoreInstanceState");
            MMAdView.this.attachToWindow(MMAdView.this);
            super.onRestoreInstanceState(state);
        }

        synchronized void attachToContext(View view) {
            MMAdView.this.detachFromParent(view);
            if (getParent() != null && (getParent() instanceof ViewGroup)) {
                ((ViewGroup) getParent()).addView(view);
            }
        }
    }

    public /* bridge */ /* synthetic */ void addBlackView() {
        super.addBlackView();
    }

    public /* bridge */ /* synthetic */ String getApid() {
        return super.getApid();
    }

    public /* bridge */ /* synthetic */ boolean getIgnoresDensityScaling() {
        return super.getIgnoresDensityScaling();
    }

    public /* bridge */ /* synthetic */ RequestListener getListener() {
        return super.getListener();
    }

    public /* bridge */ /* synthetic */ MMRequest getMMRequest() {
        return super.getMMRequest();
    }

    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent x0) {
        return super.onTouchEvent(x0);
    }

    public /* bridge */ /* synthetic */ void removeBlackView() {
        super.removeBlackView();
    }

    public /* bridge */ /* synthetic */ void setApid(String x0) {
        super.setApid(x0);
    }

    public /* bridge */ /* synthetic */ void setIgnoresDensityScaling(boolean x0) {
        super.setIgnoresDensityScaling(x0);
    }

    public /* bridge */ /* synthetic */ void setListener(RequestListener x0) {
        super.setListener(x0);
    }

    public /* bridge */ /* synthetic */ void setMMRequest(MMRequest x0) {
        super.setMMRequest(x0);
    }

    public MMAdView(Context context) {
        super(context);
        this.transitionType = TRANSITION_RANDOM;
        this.height = TRANSITION_NONE;
        this.width = TRANSITION_NONE;
        this.oldHeight = DEFAULT_RESIZE_PARAM_VALUES;
        this.oldWidth = DEFAULT_RESIZE_PARAM_VALUES;
        this.adImpl = new MMAdViewMMAdImpl(context);
        init(context);
    }

    @Deprecated
    public MMAdView(Context context, AttributeSet attrs) {
        this(context, attrs, TRANSITION_NONE);
    }

    @Deprecated
    public MMAdView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.transitionType = TRANSITION_RANDOM;
        this.height = TRANSITION_NONE;
        this.width = TRANSITION_NONE;
        this.oldHeight = DEFAULT_RESIZE_PARAM_VALUES;
        this.oldWidth = DEFAULT_RESIZE_PARAM_VALUES;
        if (isInEditMode()) {
            initEclipseAd(context);
            return;
        }
        Log.m9711d("Creating MMAdView from XML layout.");
        this.adImpl = new MMAdViewMMAdImpl(context);
        if (attrs != null) {
            String namespace = "http://millennialmedia.com/android/schema";
            setApid(attrs.getAttributeValue(namespace, "apid"));
            this.adImpl.ignoreDensityScaling = attrs.getAttributeBooleanValue(namespace, "ignoreDensityScaling", false);
            String heightIn = attrs.getAttributeValue(namespace, MMLayout.KEY_HEIGHT);
            String widthIn = attrs.getAttributeValue(namespace, MMLayout.KEY_WIDTH);
            try {
                if (!TextUtils.isEmpty(heightIn)) {
                    this.height = Integer.parseInt(heightIn);
                }
                if (!TextUtils.isEmpty(widthIn)) {
                    this.width = Integer.parseInt(widthIn);
                }
            } catch (NumberFormatException e) {
            }
            if (this.adImpl.mmRequest != null) {
                this.adImpl.mmRequest.age = attrs.getAttributeValue(namespace, MMRequest.KEY_AGE);
                this.adImpl.mmRequest.children = attrs.getAttributeValue(namespace, MMRequest.KEY_CHILDREN);
                this.adImpl.mmRequest.education = attrs.getAttributeValue(namespace, MMRequest.KEY_EDUCATION);
                this.adImpl.mmRequest.ethnicity = attrs.getAttributeValue(namespace, MMRequest.KEY_ETHNICITY);
                this.adImpl.mmRequest.gender = attrs.getAttributeValue(namespace, MMRequest.KEY_GENDER);
                this.adImpl.mmRequest.income = attrs.getAttributeValue(namespace, MMRequest.KEY_INCOME);
                this.adImpl.mmRequest.keywords = attrs.getAttributeValue(namespace, MMRequest.KEY_KEYWORDS);
                this.adImpl.mmRequest.orientation = attrs.getAttributeValue(namespace, MMRequest.KEY_ORIENTATION);
                this.adImpl.mmRequest.marital = attrs.getAttributeValue(namespace, MMRequest.KEY_MARITAL_STATUS);
                this.adImpl.mmRequest.politics = attrs.getAttributeValue(namespace, MMRequest.KEY_POLITICS);
                this.adImpl.mmRequest.vendor = attrs.getAttributeValue(namespace, MMRequest.KEY_VENDOR);
                this.adImpl.mmRequest.zip = attrs.getAttributeValue(namespace, MMRequest.KEY_ZIP_CODE);
            }
            this.goalId = attrs.getAttributeValue(namespace, "goalId");
        }
        this.adImpl.xmlLayout = true;
        init(context);
    }

    public void setBackgroundColor(int color) {
        super.setBackgroundColor(color);
        if (this.adImpl != null && this.adImpl.controller != null && this.adImpl.controller.webView != null) {
            this.adImpl.controller.webView.setBackgroundColor(color);
        }
    }

    private void init(Context context) {
        setBackgroundColor(TRANSITION_NONE);
        this.adImpl.adType = "b";
        setOnClickListener(this);
        setFocusable(true);
        this.refreshAnimationimageView = new ImageView(context);
        this.refreshAnimationimageView.setScaleType(ScaleType.FIT_XY);
        this.refreshAnimationimageView.setVisibility(8);
        addView(this.refreshAnimationimageView, new RelativeLayout.LayoutParams(-2, -2));
        setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
    }

    private void initEclipseAd(Context context) {
        Throwable th;
        ImageView logoForXML = new ImageView(context);
        String imageUrl = "http://images.millennialmedia.com/9513/192134.gif";
        InputStream is = null;
        OutputStream out = null;
        try {
            String dir = System.getProperty("java.io.tmpdir");
            if (!(dir == null || dir.endsWith(File.separator))) {
                dir = dir + File.separator;
            }
            File file = new File(dir + "millenial355jns6u3l1nmedia.png");
            if (!file.exists()) {
                HttpURLConnection conn = (HttpURLConnection) new URL("http://images.millennialmedia.com/9513/192134.gif").openConnection();
                conn.setDoOutput(true);
                conn.setConnectTimeout(CustomEventBannerAdapter.DEFAULT_BANNER_TIMEOUT_DELAY);
                conn.connect();
                is = conn.getInputStream();
                OutputStream out2 = new FileOutputStream(file);
                try {
                    byte[] buffer = new byte[1024];
                    while (true) {
                        int bytesRead = is.read(buffer);
                        if (bytesRead <= 0) {
                            break;
                        }
                        out2.write(buffer, TRANSITION_NONE, bytesRead);
                    }
                    out = out2;
                } catch (Exception e) {
                    out = out2;
                    if (is != null) {
                        try {
                            is.close();
                        } catch (Exception e2) {
                        }
                    }
                    if (out != null) {
                        out.close();
                    }
                    addView(logoForXML);
                } catch (Throwable th2) {
                    th = th2;
                    out = out2;
                    if (is != null) {
                        try {
                            is.close();
                        } catch (Exception e3) {
                            throw th;
                        }
                    }
                    if (out != null) {
                        out.close();
                    }
                    throw th;
                }
            }
            Bitmap bmp = BitmapFactory.decodeFile(file.getAbsolutePath());
            if (!(logoForXML == null || bmp == null)) {
                logoForXML.setImageBitmap(bmp);
            }
            if (is != null) {
                try {
                    is.close();
                } catch (Exception e4) {
                }
            }
            if (out != null) {
                out.close();
            }
        } catch (Exception e5) {
            if (is != null) {
                is.close();
            }
            if (out != null) {
                out.close();
            }
            addView(logoForXML);
        } catch (Throwable th3) {
            th = th3;
            if (is != null) {
                is.close();
            }
            if (out != null) {
                out.close();
            }
            throw th;
        }
        addView(logoForXML);
    }

    @Deprecated
    public void onClick(View v) {
        Log.m9711d("On click for " + v.getId() + " view, " + v + " adimpl" + this.adImpl);
        onTouchEvent(MotionEvent.obtain(0, System.currentTimeMillis(), TRANSITION_FADE, 0.0f, 0.0f, TRANSITION_NONE));
    }

    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        ThreadUtils.execute(new C24761());
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setTransitionType(int type) {
        this.transitionType = type;
    }

    void closeAreaTouched() {
        this.adImpl.unresizeToDefault();
    }

    @Deprecated
    public void onAnimationStart(Animation animation) {
    }

    @Deprecated
    public void onAnimationEnd(Animation animation) {
        this.refreshAnimationimageView.setVisibility(8);
    }

    @Deprecated
    public void onAnimationRepeat(Animation animation) {
    }

    public void getAd() {
        if (this.adImpl == null || this.adImpl.requestListener == null) {
            getAdInternal();
        } else {
            getAd(this.adImpl.requestListener);
        }
    }

    public void getAd(RequestListener listener) {
        if (this.adImpl != null) {
            this.adImpl.requestListener = listener;
        }
        getAdInternal();
    }

    private void getAdInternal() {
        if (this.adImpl != null) {
            this.adImpl.requestAd();
        }
    }

    public void onWindowFocusChanged(boolean windowInFocus) {
        super.onWindowFocusChanged(windowInFocus);
        if (windowInFocus && this.adImpl != null && this.adImpl.controller != null) {
            if (this.adImpl.controller.webView == null) {
                this.adImpl.controller.webView = MMAdImplController.getWebViewFromExistingAdImpl(this.adImpl);
            }
            if (this.adImpl.controller.webView != null && !this.adImpl.controller.webView.isCurrentParent(this.adImpl.internalId)) {
                this.adImpl.controller.webView.removeFromParent();
                addView(this.adImpl.controller.webView);
            }
        }
    }

    private synchronized void detachFromParent(View view) {
        if (view != null) {
            ViewParent parent = getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ViewGroup group = (ViewGroup) parent;
                if (view.getParent() != null) {
                    group.removeView(view);
                }
            }
        }
    }

    private synchronized void attachToWindow(View view) {
        detachFromParent(view);
        Context context = getContext();
        if (context != null && (context instanceof Activity)) {
            Window win = ((Activity) context).getWindow();
            if (win != null) {
                View decorView = win.getDecorView();
                if (decorView != null && (decorView instanceof ViewGroup)) {
                    ((ViewGroup) decorView).addView(view);
                }
            }
        }
    }

    synchronized void handleMraidResize(DTOResizeParameters resizeParams) {
        this.refreshAnimationimageView.setImageBitmap(null);
        if (MMSDK.hasSetTranslationMethod()) {
            if (this.view == null) {
                this.view = new ResizeView(getContext());
                this.view.setId(304025022);
                this.view.setLayoutParams(new RelativeLayout.LayoutParams(TRANSITION_FADE, TRANSITION_FADE));
                this.view.setBackgroundColor(TRANSITION_NONE);
            }
            if (this.view.getParent() == null) {
                ViewParent adViewParent = getParent();
                if (adViewParent != null && (adViewParent instanceof ViewGroup)) {
                    ((ViewGroup) adViewParent).addView(this.view);
                }
            }
            BannerBounds bounds = new BannerBounds(resizeParams);
            if (!resizeParams.allowOffScreen) {
                bounds.calculateOnScreenBounds();
            }
            int[] location = new int[TRANSITION_UP];
            getLocationInWindow(location);
            attachToWindow(this);
            int[] locAfterAttach = new int[TRANSITION_UP];
            getLocationInWindow(locAfterAttach);
            setUnresizeParameters();
            int xOld = location[TRANSITION_NONE] - locAfterAttach[TRANSITION_NONE];
            int yOld = location[TRANSITION_FADE] - locAfterAttach[TRANSITION_FADE];
            bounds.modifyLayoutParams(getLayoutParams());
            callSetTranslationX(bounds.translationX + xOld);
            callSetTranslationY(bounds.translationY + yOld);
            setCloseArea(resizeParams.customClosePosition);
        }
    }

    synchronized void handleUnresize() {
        if (MMSDK.hasSetTranslationMethod()) {
            removeCloseTouchDelegate();
            if (!hasDefaultResizeParams()) {
                LayoutParams params = getLayoutParams();
                params.width = this.oldWidth;
                params.height = this.oldHeight;
                callSetTranslationX(TRANSITION_NONE);
                callSetTranslationY(TRANSITION_NONE);
                this.oldWidth = DEFAULT_RESIZE_PARAM_VALUES;
                this.oldHeight = DEFAULT_RESIZE_PARAM_VALUES;
            }
            if (this.view != null) {
                this.isResizing = true;
                this.view.attachToContext(this);
                ViewParent parent = getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ViewGroup group = (ViewGroup) parent;
                    if (this.view.getParent() != null) {
                        group.removeView(this.view);
                    }
                }
                this.isResizing = false;
            }
        }
    }

    private void callSetTranslationX(int translationX) {
        try {
            Class[] clsArr = new Class[TRANSITION_FADE];
            clsArr[TRANSITION_NONE] = Float.TYPE;
            Method method = View.class.getMethod("setTranslationX", clsArr);
            Object[] objArr = new Object[TRANSITION_FADE];
            objArr[TRANSITION_NONE] = Integer.valueOf(translationX);
            method.invoke(this, objArr);
        } catch (Exception e) {
        }
    }

    private void callSetTranslationY(int translationY) {
        try {
            Class[] clsArr = new Class[TRANSITION_FADE];
            clsArr[TRANSITION_NONE] = Float.TYPE;
            Method method = View.class.getMethod("setTranslationY", clsArr);
            Object[] objArr = new Object[TRANSITION_FADE];
            objArr[TRANSITION_NONE] = Integer.valueOf(translationY);
            method.invoke(this, objArr);
        } catch (Exception e) {
        }
    }

    private void setUnresizeParameters() {
        if (hasDefaultResizeParams()) {
            LayoutParams oldParams = getLayoutParams();
            this.oldWidth = oldParams.width;
            this.oldHeight = oldParams.height;
            if (this.oldWidth <= 0) {
                this.oldWidth = getWidth();
            }
            if (this.oldHeight <= 0) {
                this.oldHeight = getHeight();
            }
        }
    }

    private boolean hasDefaultResizeParams() {
        return this.oldWidth == DEFAULT_RESIZE_PARAM_VALUES && this.oldHeight == DEFAULT_RESIZE_PARAM_VALUES;
    }
}
