package com.mopub.mobileads;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Handler;
import android.webkit.JavascriptInterface;
import com.mopub.common.util.VersionCode;
import com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener;

public class HtmlInterstitialWebView extends BaseHtmlWebView {
    protected static final String MOPUB_JS_INTERFACE_NAME = "mopubUriInterface";
    private Handler mHandler;

    interface MoPubUriJavascriptFireFinishLoadListener {
        void onInterstitialLoaded();
    }

    /* renamed from: com.mopub.mobileads.HtmlInterstitialWebView.1 */
    class C25991 implements MoPubUriJavascriptFireFinishLoadListener {
        final /* synthetic */ CustomEventInterstitialListener val$customEventInterstitialListener;

        C25991(CustomEventInterstitialListener customEventInterstitialListener) {
            this.val$customEventInterstitialListener = customEventInterstitialListener;
        }

        public void onInterstitialLoaded() {
            if (!HtmlInterstitialWebView.this.mIsDestroyed) {
                this.val$customEventInterstitialListener.onInterstitialLoaded();
            }
        }
    }

    /* renamed from: com.mopub.mobileads.HtmlInterstitialWebView.1MoPubUriJavascriptInterface */
    final class AnonymousClass1MoPubUriJavascriptInterface {
        final /* synthetic */ MoPubUriJavascriptFireFinishLoadListener val$moPubUriJavascriptFireFinishLoadListener;

        /* renamed from: com.mopub.mobileads.HtmlInterstitialWebView.1MoPubUriJavascriptInterface.1 */
        class C26001 implements Runnable {
            C26001() {
            }

            public void run() {
                AnonymousClass1MoPubUriJavascriptInterface.this.val$moPubUriJavascriptFireFinishLoadListener.onInterstitialLoaded();
            }
        }

        AnonymousClass1MoPubUriJavascriptInterface(MoPubUriJavascriptFireFinishLoadListener moPubUriJavascriptFireFinishLoadListener) {
            this.val$moPubUriJavascriptFireFinishLoadListener = moPubUriJavascriptFireFinishLoadListener;
        }

        @JavascriptInterface
        public boolean fireFinishLoad() {
            HtmlInterstitialWebView.this.postHandlerRunnable(new C26001());
            return true;
        }
    }

    static class HtmlInterstitialWebViewListener implements HtmlWebViewListener {
        private final CustomEventInterstitialListener mCustomEventInterstitialListener;

        public HtmlInterstitialWebViewListener(CustomEventInterstitialListener customEventInterstitialListener) {
            this.mCustomEventInterstitialListener = customEventInterstitialListener;
        }

        public void onLoaded(BaseHtmlWebView mHtmlWebView) {
            this.mCustomEventInterstitialListener.onInterstitialLoaded();
        }

        public void onFailed(MoPubErrorCode errorCode) {
            this.mCustomEventInterstitialListener.onInterstitialFailed(errorCode);
        }

        public void onClicked() {
            this.mCustomEventInterstitialListener.onInterstitialClicked();
        }

        public void onCollapsed() {
        }
    }

    public HtmlInterstitialWebView(Context context, AdConfiguration adConfiguration) {
        super(context, adConfiguration);
        this.mHandler = new Handler();
    }

    public void init(CustomEventInterstitialListener customEventInterstitialListener, boolean isScrollable, String redirectUrl, String clickthroughUrl) {
        super.init(isScrollable);
        setWebViewClient(new HtmlWebViewClient(new HtmlInterstitialWebViewListener(customEventInterstitialListener), this, clickthroughUrl, redirectUrl));
        addMoPubUriJavascriptInterface(new C25991(customEventInterstitialListener));
    }

    private void postHandlerRunnable(Runnable r) {
        this.mHandler.post(r);
    }

    void addMoPubUriJavascriptInterface(MoPubUriJavascriptFireFinishLoadListener moPubUriJavascriptFireFinishLoadListener) {
    }

    @TargetApi(11)
    public void destroy() {
        if (VersionCode.currentApiLevel().isAtLeast(VersionCode.HONEYCOMB)) {
            removeJavascriptInterface(MOPUB_JS_INTERFACE_NAME);
        }
        super.destroy();
    }
}
