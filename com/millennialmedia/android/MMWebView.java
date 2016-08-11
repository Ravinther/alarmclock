package com.millennialmedia.android;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;
import com.millennialmedia.google.gson.Gson;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import org.json.JSONObject;

class MMWebView extends WebView {
    static final String JS_INTERFACE_NAME = "interface";
    static final String PROPERTY_BANNER_TYPE = "PROPERTY_BANNER_TYPE";
    static final String PROPERTY_EXPANDING = "PROPERTY_EXPANDING";
    static final String PROPERTY_STATE = "PROPERTY_STATE";
    private HttpMMHeaders _lastHeaders;
    long creatorAdImplId;
    int currentColor;
    String currentUrl;
    boolean hadFirstRecordingCreation;
    boolean hadFirstSpeechKitCreation;
    volatile boolean isExpanding;
    boolean isSendingSize;
    volatile boolean isUserClosedResize;
    volatile boolean isVisible;
    volatile String mraidState;
    int oldHeight;
    int oldWidth;
    volatile boolean requiresPreAdSizeFix;
    final GestureDetector tapDetector;
    final String userAgent;

    /* renamed from: com.millennialmedia.android.MMWebView.1 */
    class C24931 implements Runnable {
        final /* synthetic */ MMAdImpl val$adImpl;
        final /* synthetic */ String val$baseUrl;
        final /* synthetic */ String val$finalContent;

        C24931(MMAdImpl mMAdImpl, String str, String str2) {
            this.val$adImpl = mMAdImpl;
            this.val$baseUrl = str;
            this.val$finalContent = str2;
        }

        public void run() {
            if (HandShake.sharedHandShake(MMWebView.this.getContext()).hardwareAccelerationEnabled) {
                MMWebView.this.enableHardwareAcceleration();
            } else if (MMWebView.this.currentColor == 0) {
                MMWebView.this.enableSoftwareAcceleration();
            } else {
                MMWebView.this.disableAllAcceleration();
            }
            MMAd ad = this.val$adImpl.getCallingAd();
            if (ad != null && (ad instanceof MMLayout)) {
                ((MMLayout) ad).removeVideo();
            }
            MMWebView.this.isSendingSize = true;
            MMWebView.this.loadDataWithBaseURL(this.val$baseUrl, this.val$finalContent, "text/html", "UTF-8", null);
        }
    }

    /* renamed from: com.millennialmedia.android.MMWebView.2 */
    class C24942 implements Runnable {
        final /* synthetic */ String val$finalBaseUrl;
        final /* synthetic */ String val$finalContent;

        C24942(String str, String str2) {
            this.val$finalBaseUrl = str;
            this.val$finalContent = str2;
        }

        public void run() {
            if (HandShake.sharedHandShake(MMWebView.this.getContext()).hardwareAccelerationEnabled) {
                MMWebView.this.enableHardwareAcceleration();
            } else if (MMWebView.this.currentColor == 0) {
                MMWebView.this.enableSoftwareAcceleration();
            } else {
                MMWebView.this.disableAllAcceleration();
            }
            MMWebView.this.isSendingSize = true;
            MMWebView.this.loadDataWithBaseURL(this.val$finalBaseUrl, this.val$finalContent, "text/html", "UTF-8", null);
        }
    }

    /* renamed from: com.millennialmedia.android.MMWebView.3 */
    class C24953 implements Callable {
        final /* synthetic */ MMAdImpl val$adImpl;

        C24953(MMAdImpl mMAdImpl) {
            this.val$adImpl = mMAdImpl;
        }

        public Void call() {
            try {
                MMWebView.this.buildDrawingCache();
                Bitmap cache = MMWebView.this.getDrawingCache();
                if (cache != null) {
                    this.val$adImpl.prepareTransition(Bitmap.createBitmap(cache));
                }
                MMWebView.this.destroyDrawingCache();
            } catch (Throwable e) {
                Log.m9713d(e);
            }
            return null;
        }
    }

    /* renamed from: com.millennialmedia.android.MMWebView.4 */
    class C24964 implements Runnable {
        final /* synthetic */ MMAdView val$adView;
        final /* synthetic */ DTOResizeParameters val$resizeParams;

        C24964(MMAdView mMAdView, DTOResizeParameters dTOResizeParameters) {
            this.val$adView = mMAdView;
            this.val$resizeParams = dTOResizeParameters;
        }

        public void run() {
            synchronized (MMWebView.this) {
                MMWebView.this.isSendingSize = true;
                this.val$adView.handleMraidResize(this.val$resizeParams);
                handleMraidResize(this.val$resizeParams);
                MMWebView.this.loadUrl("javascript:MMJS.sdk.setState('resized');");
                MMWebView.this.mraidState = "resized";
            }
        }

        private void handleMraidResize(DTOResizeParameters resizeParams) {
            MMAdView mMAdView = this.val$adView;
            mMAdView.getClass();
            BannerBounds bounds = new BannerBounds(resizeParams);
            setUnresizeParameters();
            bounds.modifyLayoutParams(MMWebView.this.getLayoutParams());
        }

        private void setUnresizeParameters() {
            if (MMWebView.this.hasDefaultResizeParams()) {
                LayoutParams oldParams = MMWebView.this.getLayoutParams();
                MMWebView.this.oldWidth = oldParams.width;
                MMWebView.this.oldHeight = oldParams.height;
                if (MMWebView.this.oldWidth <= 0) {
                    MMWebView.this.oldWidth = MMWebView.this.getWidth();
                }
                if (MMWebView.this.oldHeight <= 0) {
                    MMWebView.this.oldHeight = MMWebView.this.getHeight();
                }
            }
        }
    }

    /* renamed from: com.millennialmedia.android.MMWebView.5 */
    class C24975 implements Runnable {
        final /* synthetic */ MMAdView val$adView;

        C24975(MMAdView mMAdView) {
            this.val$adView = mMAdView;
        }

        public void run() {
            synchronized (MMWebView.this) {
                this.val$adView.handleUnresize();
                handleUnresize();
                MMWebView.this.setMraidDefault();
                MMWebView.this.isSendingSize = true;
                MMWebView.this.invalidate();
            }
        }

        void handleUnresize() {
            if (MMSDK.hasSetTranslationMethod() && !MMWebView.this.hasDefaultResizeParams()) {
                LayoutParams params = MMWebView.this.getLayoutParams();
                params.width = MMWebView.this.oldWidth;
                params.height = MMWebView.this.oldHeight;
                MMWebView.this.oldWidth = -50;
                MMWebView.this.oldHeight = -50;
                MMWebView.this.requestLayout();
            }
        }
    }

    /* renamed from: com.millennialmedia.android.MMWebView.6 */
    class C24986 implements Runnable {
        final /* synthetic */ String val$url;

        C24986(String str) {
            this.val$url = str;
        }

        public void run() {
            MMWebView.this.loadUrl(this.val$url);
        }
    }

    /* renamed from: com.millennialmedia.android.MMWebView.7 */
    class C24997 implements Runnable {
        C24997() {
        }

        public void run() {
            MMWebView.this.isSendingSize = false;
        }
    }

    private static class MyWebChromeClient extends WebChromeClient {
        private static final String KEY_USE_GEO = "mm_use_geo_location";
        WeakReference webRef;

        /* renamed from: com.millennialmedia.android.MMWebView.MyWebChromeClient.1 */
        class C25001 implements OnClickListener {
            final /* synthetic */ Callback val$callback;
            final /* synthetic */ String val$origin;

            C25001(Callback callback, String str) {
                this.val$callback = callback;
                this.val$origin = str;
            }

            public void onClick(DialogInterface dialog, int id) {
                MyWebChromeClient.this.saveUseGeo(false);
                this.val$callback.invoke(this.val$origin, false, false);
            }
        }

        /* renamed from: com.millennialmedia.android.MMWebView.MyWebChromeClient.2 */
        class C25012 implements OnClickListener {
            final /* synthetic */ Callback val$callback;
            final /* synthetic */ String val$origin;

            C25012(Callback callback, String str) {
                this.val$callback = callback;
                this.val$origin = str;
            }

            public void onClick(DialogInterface dialog, int id) {
                MyWebChromeClient.this.saveUseGeo(true);
                this.val$callback.invoke(this.val$origin, true, true);
            }
        }

        MyWebChromeClient(MMWebView webView) {
            this.webRef = new WeakReference(webView);
        }

        public void onGeolocationPermissionsShowPrompt(String origin, Callback callback) {
            if (!isFirstGeoRequest()) {
                callback.invoke(origin, false, false);
            } else if (retrieveUseGeo()) {
                callback.invoke(origin, true, true);
            } else {
                MMWebView webView = (MMWebView) this.webRef.get();
                if (webView != null) {
                    Activity activity = webView.getActivity();
                    if (activity != null) {
                        Builder builder = new Builder(activity);
                        builder.setTitle(getApplicationName(activity));
                        builder.setMessage("Would like to use your Current Location.").setPositiveButton("Allow", new C25012(callback, origin)).setNegativeButton("Don't Allow", new C25001(callback, origin));
                        builder.create().show();
                    }
                }
            }
        }

        private boolean isFirstGeoRequest() {
            MMWebView webView = (MMWebView) this.webRef.get();
            if (webView == null || webView.getContext().getSharedPreferences("MillennialMediaSettings", 0).contains(KEY_USE_GEO)) {
                return false;
            }
            return true;
        }

        private boolean retrieveUseGeo() {
            MMWebView webView = (MMWebView) this.webRef.get();
            if (webView != null) {
                return webView.getContext().getSharedPreferences("MillennialMediaSettings", 0).getBoolean(KEY_USE_GEO, false);
            }
            return false;
        }

        private void saveUseGeo(boolean allow) {
            MMWebView webView = (MMWebView) this.webRef.get();
            if (webView != null) {
                Editor editor = webView.getContext().getSharedPreferences("MillennialMediaSettings", 0).edit();
                editor.putBoolean(KEY_USE_GEO, allow);
                editor.commit();
            }
        }

        private String getApplicationName(Context context) {
            ApplicationInfo ai;
            PackageManager pm = context.getApplicationContext().getPackageManager();
            try {
                ai = pm.getApplicationInfo(context.getPackageName(), 0);
            } catch (NameNotFoundException e) {
                ai = null;
            }
            return (String) (ai != null ? pm.getApplicationLabel(ai) : "This app");
        }

        public void onConsoleMessage(String message, int lineNumber, String sourceID) {
            super.onConsoleMessage(message, lineNumber, sourceID);
        }

        public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
            MMWebView webView = (MMWebView) this.webRef.get();
            if (webView != null) {
                if (webView.getContext() != webView.getContext().getApplicationContext()) {
                    return super.onJsAlert(view, url, message, result);
                }
                Toast.makeText(webView.getContext(), message, 0).show();
            }
            return true;
        }

        public boolean onJsBeforeUnload(WebView view, String url, String message, JsResult result) {
            MMWebView webView = (MMWebView) this.webRef.get();
            if (webView != null) {
                if (webView.getContext() != webView.getContext().getApplicationContext()) {
                    return super.onJsBeforeUnload(view, url, message, result);
                }
                Toast.makeText(webView.getContext(), message, 0).show();
            }
            return true;
        }

        public boolean onJsConfirm(WebView view, String url, String message, JsResult result) {
            MMWebView webView = (MMWebView) this.webRef.get();
            if (webView != null) {
                if (webView.getContext() != webView.getContext().getApplicationContext()) {
                    return super.onJsConfirm(view, url, message, result);
                }
                Toast.makeText(webView.getContext(), message, 0).show();
            }
            return true;
        }

        public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
            MMWebView webView = (MMWebView) this.webRef.get();
            if (webView != null) {
                if (webView.getContext() != webView.getContext().getApplicationContext()) {
                    return super.onJsPrompt(view, url, message, defaultValue, result);
                }
                Toast.makeText(webView.getContext(), message, 0).show();
            }
            return true;
        }
    }

    private static class WebGestureListener extends SimpleOnGestureListener {
        WeakReference webRef;

        public boolean onSingleTapConfirmed(MotionEvent e) {
            MMWebView webView = (MMWebView) this.webRef.get();
            if (webView != null) {
                Event.adSingleTap(MMAdImplController.getAdImplWithId(webView.creatorAdImplId));
            }
            return false;
        }

        public WebGestureListener(MMWebView webView) {
            this.webRef = new WeakReference(webView);
        }
    }

    private static class WebTouchListener implements OnTouchListener {
        WeakReference webRef;

        WebTouchListener(MMWebView webView) {
            this.webRef = new WeakReference(webView);
        }

        public boolean onTouch(View v, MotionEvent event) {
            boolean consume;
            MMWebView webView = (MMWebView) this.webRef.get();
            if (event.getAction() == 2) {
                consume = true;
            } else {
                consume = false;
            }
            if (webView == null) {
                return consume;
            }
            if (consume && webView.canScroll()) {
                return true;
            }
            return false;
        }
    }

    public MMWebView(Context context, long internalId) {
        super(context);
        this.isSendingSize = true;
        this.oldHeight = -50;
        this.oldWidth = -50;
        this.isVisible = false;
        this.hadFirstSpeechKitCreation = false;
        this.hadFirstRecordingCreation = false;
        Log.m9711d("Setting isExpanding in constructor to " + this.isExpanding);
        setWillNotDraw(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setOnTouchListener(new WebTouchListener(this));
        this.mraidState = "loading";
        this.creatorAdImplId = internalId;
        Log.m9724v("Assigning WebView internal id: %d", Long.valueOf(this.creatorAdImplId));
        setId((int) (15063 + this.creatorAdImplId));
        if (HandShake.sharedHandShake(context).hardwareAccelerationEnabled) {
            enableHardwareAcceleration();
        } else {
            disableAllAcceleration();
        }
        setMediaPlaybackRequiresUserGesture(false);
        setWebChromeClient(new MyWebChromeClient(this));
        WebSettings webSettings = getSettings();
        this.userAgent = webSettings.getUserAgentString();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setCacheMode(-1);
        webSettings.setDefaultTextEncodingName("UTF-8");
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setGeolocationEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        this.tapDetector = new GestureDetector(context.getApplicationContext(), new WebGestureListener(this));
    }

    void setMediaPlaybackRequiresUserGesture(boolean requiresGesture) {
        try {
            WebView.class.getMethod("setMediaPlaybackRequiresUserGesture", new Class[]{Boolean.TYPE}).invoke(this, new Object[]{Boolean.valueOf(requiresGesture)});
        } catch (Exception e) {
        }
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int measuredHeight = getMeasuredHeight();
        if (measuredHeight == 0) {
            measuredHeight = heightSize;
        }
        int measuredWidth = widthSize;
        if (this.requiresPreAdSizeFix) {
            setMeasuredDimension(1, 1);
        } else {
            setMeasuredDimension(measuredWidth, measuredHeight);
        }
    }

    public void setBackgroundColor(int color) {
        this.currentColor = color;
        if (color == 0) {
            enableSoftwareAcceleration();
        }
        super.setBackgroundColor(color);
    }

    void disableAllAcceleration() {
        try {
            WebView.class.getMethod("setLayerType", new Class[]{Integer.TYPE, Paint.class}).invoke(this, new Object[]{Integer.valueOf(0), null});
            Log.m9711d("Remove allAcceleration");
        } catch (Exception e) {
        }
    }

    private boolean needsSamsungJBOpenGlFixNoAcceleration() {
        int version = Integer.parseInt(VERSION.SDK);
        if ("Nexus S".equals(Build.MODEL) && "samsung".equals(Build.MANUFACTURER) && (version == 16 || version == 17)) {
            return true;
        }
        return false;
    }

    void enableSoftwareAcceleration() {
        if (!needsSamsungJBOpenGlFixNoAcceleration()) {
            try {
                WebView.class.getMethod("setLayerType", new Class[]{Integer.TYPE, Paint.class}).invoke(this, new Object[]{Integer.valueOf(1), null});
                Log.m9711d("Enable softwareAcceleration");
            } catch (Exception e) {
            }
        }
    }

    void enableHardwareAcceleration() {
        if (!needsSamsungJBOpenGlFixNoAcceleration()) {
            try {
                WebView.class.getMethod("setLayerType", new Class[]{Integer.TYPE, Paint.class}).invoke(this, new Object[]{Integer.valueOf(2), null});
                Log.m9711d("Enabled hardwareAcceleration");
            } catch (Exception e) {
            }
        }
    }

    public boolean onTouchEvent(MotionEvent e) {
        if (e.getAction() == 0) {
            requestFocus();
        }
        if (this.tapDetector != null) {
            this.tapDetector.onTouchEvent(e);
        }
        if (e.getAction() == 1) {
            Log.m9724v("Ad clicked: action=%d x=%f y=%f", Integer.valueOf(e.getAction()), Float.valueOf(e.getX()), Float.valueOf(e.getY()));
        }
        return super.onTouchEvent(e);
    }

    void setWebViewContent(String webContent, String adUrl, MMAdImpl adImpl) {
        if (webContent != null && adUrl != null && adImpl != null) {
            String content;
            unresizeToDefault(adImpl);
            resetSpeechKit();
            String baseUrl = adUrl.substring(0, adUrl.lastIndexOf("/") + 1);
            if (MMSDK.logLevel >= 5) {
                Log.m9724v("Received ad with base url %s.", baseUrl);
                Log.m9723v(webContent);
            }
            if (adImpl.isTransitionAnimated()) {
                animateTransition(adImpl);
            }
            if (adImpl.ignoreDensityScaling) {
                content = "<head><meta name=\"viewport\" content=\"target-densitydpi=device-dpi\" /></head>" + webContent;
            } else {
                content = webContent;
            }
            if (MRaid.hasMraidLocally(adImpl.getContext())) {
                content = MRaid.injectMraidJs(adImpl.getContext(), content);
            } else {
                Log.m9714e("MMJS is not downloaded");
            }
            MMSDK.runOnUiThread(new C24931(adImpl, baseUrl, content));
        }
    }

    public void loadDataWithBaseURL(String baseUrl, String data, String mimeType, String encoding, String historyUrl) {
        this.currentUrl = baseUrl;
        super.loadDataWithBaseURL(baseUrl, data, mimeType, encoding, historyUrl);
    }

    void setWebViewContent(String webContent, String baseUrl, Context context) {
        if (webContent != null && baseUrl != null) {
            String finalBaseUrl = baseUrl.substring(0, baseUrl.lastIndexOf("/") + 1);
            resetSpeechKit();
            String content = webContent;
            if (MRaid.hasMraidLocally(context)) {
                content = MRaid.injectMraidJs(context, content);
            } else {
                Log.m9714e("MMJS is not downloaded");
            }
            String finalContent = content;
            if (MMSDK.logLevel >= 5) {
                Log.m9724v("Received ad with base url %s.", baseUrl);
                Log.m9723v(webContent);
            }
            MMSDK.runOnUiThread(new C24942(finalBaseUrl, finalContent));
        }
    }

    void resetSpeechKit() {
        BridgeMMSpeechkit.releaseSpeechKit();
        this.hadFirstSpeechKitCreation = false;
        this.hadFirstRecordingCreation = false;
    }

    void animateTransition(MMAdImpl adImpl) {
        FutureTask future = new FutureTask(new C24953(adImpl));
        MMSDK.runOnUiThread(future);
        try {
            future.get();
        } catch (InterruptedException e) {
        } catch (ExecutionException e2) {
        }
    }

    String getUserAgent() {
        return this.userAgent;
    }

    void updateArgumentsWithSettings(Map arguments) {
        arguments.put(PROPERTY_BANNER_TYPE, isParentBannerAd() ? "true" : "false");
        arguments.put(PROPERTY_STATE, this.mraidState);
        arguments.put(PROPERTY_EXPANDING, String.valueOf(this.creatorAdImplId));
    }

    boolean isParentBannerAd() {
        if (getParent() != null) {
            return ((ViewGroup) getParent()) instanceof MMAdView;
        }
        return false;
    }

    synchronized void setMraidResize(DTOResizeParameters resizeParams) {
        if (MMSDK.hasSetTranslationMethod()) {
            MMAdView adView = getMMAdView();
            this.isUserClosedResize = false;
            Log.m9711d("New DTOResizeParameters = " + resizeParams);
            if (adView != null) {
                MMSDK.runOnUiThread(new C24964(adView, resizeParams));
            }
        }
    }

    private boolean hasDefaultResizeParams() {
        return this.oldWidth == -50 && this.oldHeight == -50;
    }

    synchronized void unresizeToDefault(MMAdImpl adImpl) {
        if (MMSDK.hasSetTranslationMethod() && isMraidResized() && adImpl != null) {
            MMAd ad = adImpl.getCallingAd();
            if (ad instanceof MMAdView) {
                MMAdView adView = (MMAdView) ad;
                this.isUserClosedResize = true;
                MMSDK.runOnUiThread(new C24975(adView));
            }
        }
    }

    boolean canScroll() {
        return getParent() instanceof MMAdView;
    }

    MMAdView getMMAdView() {
        if (getParent() instanceof MMAdView) {
            return (MMAdView) getParent();
        }
        return null;
    }

    MMLayout getMMLayout() {
        if (getParent() instanceof MMLayout) {
            return (MMLayout) getParent();
        }
        return null;
    }

    synchronized Activity getActivity() {
        Activity context;
        ViewParent parent = getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            Context context2 = ((ViewGroup) parent).getContext();
            if (context2 != null && (context2 instanceof MMActivity)) {
                context = (MMActivity) context2;
            }
        }
        context = null;
        return context;
    }

    public void loadUrl(String url) {
        if (!TextUtils.isEmpty(url)) {
            if (url.startsWith("http")) {
                this.currentUrl = url;
            }
            Log.m9723v("loadUrl @@" + url);
            if (MMSDK.isUiThread()) {
                try {
                    super.loadUrl(url);
                    return;
                } catch (Exception e) {
                    return;
                }
            }
            MMSDK.runOnUiThread(new C24986(url));
        }
    }

    synchronized AdViewOverlayView getAdViewOverlayView() {
        AdViewOverlayView parent;
        ViewParent parent2 = getParent();
        if (parent2 == null || !(parent2 instanceof AdViewOverlayView)) {
            parent = null;
        } else {
            parent = (AdViewOverlayView) parent2;
        }
        return parent;
    }

    synchronized MMAdView getBanner() {
        MMAdView parent;
        ViewParent parent2 = getParent();
        if (parent2 == null || !(parent2 instanceof MMAdView)) {
            parent = null;
        } else {
            parent = (MMAdView) parent2;
        }
        return parent;
    }

    public void onPauseWebView() {
        if (VERSION.SDK_INT >= 11) {
            try {
                WebView.class.getMethod("onPause", new Class[0]).invoke(this, new Object[0]);
            } catch (Exception e) {
                Log.m9726w("No onPause()");
            }
        }
    }

    public void onResumeWebView() {
        if (VERSION.SDK_INT >= 11) {
            try {
                WebView.class.getMethod("onResume", new Class[0]).invoke(this, new Object[0]);
            } catch (Exception e) {
                Log.m9726w("No onResume()");
            }
        }
    }

    void setMraidPlacementTypeInterstitial() {
        loadUrl("javascript:MMJS.sdk.setPlacementType('interstitial');");
    }

    void setMraidPlacementTypeInline() {
        loadUrl("javascript:MMJS.sdk.setPlacementType('inline');");
    }

    void setMraidDefault() {
        loadUrl("javascript:MMJS.sdk.setState('default')");
        this.mraidState = "default";
        this.isSendingSize = true;
    }

    void setMraidHidden() {
        loadUrl("javascript:MMJS.sdk.setState('hidden')");
        this.mraidState = "hidden";
    }

    void setMraidViewableHidden() {
        loadUrl("javascript:MMJS.sdk.setViewable(false)");
        this.isVisible = false;
    }

    void setMraidViewableVisible() {
        loadUrl("javascript:MMJS.sdk.setViewable(true)");
        this.isVisible = true;
    }

    void setmicrophoneAudioLevelChange(double level) {
        loadUrl("javascript:MMJS.sdk.microphoneAudioLevelChange(" + level + ")");
    }

    void setmicrophoneStateChange(String state) {
        loadUrl("javascript:MMJS.sdk.microphoneStateChange('" + state + "')");
    }

    void setMraidExpanded() {
        Log.m9711d("Changing state to EXPANDED for ---- " + toString() + "---- of creatorId ---" + this.creatorAdImplId + " ----");
        loadUrl("javascript:MMJS.sdk.setState('expanded');");
        this.mraidState = "expanded";
        this.hadFirstSpeechKitCreation = false;
        this.hadFirstRecordingCreation = false;
        this.isSendingSize = true;
    }

    void setMraidReady() {
        loadUrl("javascript:MMJS.sdk.ready();");
    }

    void setAdProperties(JSONObject adProperties) {
        if (adProperties != null) {
            loadUrl("javascript:MMJS.sdk.setAdProperties(" + adProperties + ");");
        }
    }

    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        int[] location = new int[2];
        getLocationInWindow(location);
        DisplayMetrics metrics = MMSDK.getMetrics(getContext());
        if (metrics != null) {
            String gsonAdSize = new Gson().toJson(new DTOAdViewLayout((int) (((float) location[0]) / metrics.density), (int) (((float) location[1]) / metrics.density), (int) (((float) w) / metrics.density), (int) (((float) h) / metrics.density)));
            if (this.isSendingSize) {
                loadUrl("javascript:MMJS.sdk.setAdSize(" + gsonAdSize + ");");
                Log.m9726w(" @@@ SENDING IT!!!@@@@@  adSize ! " + gsonAdSize);
                if (!(getHeight() == 1 && getWidth() == 1)) {
                    MMSDK.runOnUiThreadDelayed(new C24997(), 800);
                }
            } else {
                Log.m9726w(" @@@ Not sending adSize ! " + gsonAdSize);
            }
        }
        super.onSizeChanged(w, h, oldw, oldh);
    }

    public String toString() {
        return "MMWebView originally from(" + this.creatorAdImplId + ") MRaidState(" + this.mraidState + ")." + super.toString();
    }

    boolean isCurrentParent(long internalId) {
        ViewParent parent = getParent();
        if (parent == null) {
            return false;
        }
        Log.m9726w("Id check for parent: " + internalId + " versus " + ((MMLayout) parent).adImpl.internalId);
        return internalId == ((MMLayout) parent).adImpl.internalId;
    }

    void removeFromParent() {
        ViewParent parent = getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(this);
        }
    }

    boolean isMraidResized() {
        return "resized".equals(this.mraidState);
    }

    boolean isOriginalUrl(String url) {
        return (!TextUtils.isEmpty(this.currentUrl) && url.equals(this.currentUrl + "?")) || url.equals(this.currentUrl + "#");
    }

    public void destroy() {
        try {
            resetSpeechKit();
        } catch (Exception e) {
        }
        super.destroy();
    }

    void setLastHeaders(HttpMMHeaders lastHeaders) {
        this._lastHeaders = lastHeaders;
    }

    HttpMMHeaders getLastHeaders() {
        return this._lastHeaders;
    }

    String getAdId() {
        if (this._lastHeaders == null || TextUtils.isEmpty(this._lastHeaders.acid)) {
            return "DEFAULT_AD_ID";
        }
        return this._lastHeaders.acid;
    }

    boolean allowSpeechCreationCommands() {
        if (this.hadFirstSpeechKitCreation) {
            return allowRecordingCommands();
        }
        this.hadFirstSpeechKitCreation = true;
        if (isInterstitial() && this.isVisible) {
            return true;
        }
        return false;
    }

    boolean allowMicrophoneCreationCommands() {
        if (this.hadFirstRecordingCreation) {
            return allowRecordingCommands();
        }
        this.hadFirstRecordingCreation = true;
        if (isInterstitial() && this.isVisible) {
            return true;
        }
        return false;
    }

    boolean allowRecordingCommands() {
        return hasWindowFocus() && isInterstitial();
    }

    private boolean isInterstitial() {
        return getBanner() == null;
    }

    void enableSendingSize() {
        this.isSendingSize = true;
    }
}
