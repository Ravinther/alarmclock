package com.mopub.mobileads;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.drive.DriveFile;
import com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener;
import com.mopub.mobileads.factories.HtmlInterstitialWebViewFactory;

public class MoPubActivity extends BaseInterstitialActivity {
    private HtmlInterstitialWebView mHtmlInterstitialWebView;

    /* renamed from: com.mopub.mobileads.MoPubActivity.1 */
    static class C26011 implements MoPubUriJavascriptFireFinishLoadListener {
        final /* synthetic */ CustomEventInterstitialListener val$customEventInterstitialListener;

        C26011(CustomEventInterstitialListener customEventInterstitialListener) {
            this.val$customEventInterstitialListener = customEventInterstitialListener;
        }

        public void onInterstitialLoaded() {
            this.val$customEventInterstitialListener.onInterstitialLoaded();
        }
    }

    /* renamed from: com.mopub.mobileads.MoPubActivity.2 */
    static class C26022 extends WebViewClient {
        final /* synthetic */ CustomEventInterstitialListener val$customEventInterstitialListener;

        C26022(CustomEventInterstitialListener customEventInterstitialListener) {
            this.val$customEventInterstitialListener = customEventInterstitialListener;
        }

        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (url.equals("mopub://finishLoad")) {
                this.val$customEventInterstitialListener.onInterstitialLoaded();
            } else if (url.equals("mopub://failLoad")) {
                this.val$customEventInterstitialListener.onInterstitialFailed(null);
            }
            return true;
        }
    }

    class BroadcastingInterstitialListener implements CustomEventInterstitialListener {
        BroadcastingInterstitialListener() {
        }

        public void onInterstitialLoaded() {
            MoPubActivity.this.mHtmlInterstitialWebView.loadUrl(JavaScriptWebViewCallbacks.WEB_VIEW_DID_APPEAR.getUrl());
        }

        public void onInterstitialFailed(MoPubErrorCode errorCode) {
            EventForwardingBroadcastReceiver.broadcastAction(MoPubActivity.this, MoPubActivity.this.getBroadcastIdentifier(), "com.mopub.action.interstitial.fail");
            MoPubActivity.this.finish();
        }

        public void onInterstitialShown() {
        }

        public void onInterstitialClicked() {
            EventForwardingBroadcastReceiver.broadcastAction(MoPubActivity.this, MoPubActivity.this.getBroadcastIdentifier(), "com.mopub.action.interstitial.click");
        }

        public void onLeaveApplication() {
        }

        public void onInterstitialDismissed() {
        }
    }

    public static void start(Context context, String htmlData, boolean isScrollable, String redirectUrl, String clickthroughUrl, AdConfiguration adConfiguration) {
        try {
            context.startActivity(createIntent(context, htmlData, isScrollable, redirectUrl, clickthroughUrl, adConfiguration));
        } catch (ActivityNotFoundException e) {
            Log.d("MoPubActivity", "MoPubActivity not found - did you declare it in AndroidManifest.xml?");
        }
    }

    static Intent createIntent(Context context, String htmlData, boolean isScrollable, String redirectUrl, String clickthroughUrl, AdConfiguration adConfiguration) {
        Intent intent = new Intent(context, MoPubActivity.class);
        intent.putExtra(AdFetcher.HTML_RESPONSE_BODY_KEY, htmlData);
        intent.putExtra(AdFetcher.SCROLLABLE_KEY, isScrollable);
        intent.putExtra(AdFetcher.CLICKTHROUGH_URL_KEY, clickthroughUrl);
        intent.putExtra(AdFetcher.REDIRECT_URL_KEY, redirectUrl);
        intent.putExtra(AdFetcher.AD_CONFIGURATION_KEY, adConfiguration);
        intent.addFlags(DriveFile.MODE_READ_ONLY);
        return intent;
    }

    static void preRenderHtml(Context context, CustomEventInterstitialListener customEventInterstitialListener, String htmlData) {
        HtmlInterstitialWebView dummyWebView = HtmlInterstitialWebViewFactory.create(context, customEventInterstitialListener, false, null, null, null);
        dummyWebView.enablePlugins(false);
        dummyWebView.addMoPubUriJavascriptInterface(new C26011(customEventInterstitialListener));
        dummyWebView.setWebViewClient(new C26022(customEventInterstitialListener));
        dummyWebView.loadHtmlResponse(htmlData);
    }

    public View getAdView() {
        Intent intent = getIntent();
        boolean isScrollable = intent.getBooleanExtra(AdFetcher.SCROLLABLE_KEY, false);
        String redirectUrl = intent.getStringExtra(AdFetcher.REDIRECT_URL_KEY);
        String clickthroughUrl = intent.getStringExtra(AdFetcher.CLICKTHROUGH_URL_KEY);
        String htmlResponse = intent.getStringExtra(AdFetcher.HTML_RESPONSE_BODY_KEY);
        this.mHtmlInterstitialWebView = HtmlInterstitialWebViewFactory.create(getApplicationContext(), new BroadcastingInterstitialListener(), isScrollable, redirectUrl, clickthroughUrl, getAdConfiguration());
        this.mHtmlInterstitialWebView.loadHtmlResponse(htmlResponse);
        return this.mHtmlInterstitialWebView;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventForwardingBroadcastReceiver.broadcastAction(this, getBroadcastIdentifier(), "com.mopub.action.interstitial.show");
    }

    protected void onDestroy() {
        this.mHtmlInterstitialWebView.loadUrl(JavaScriptWebViewCallbacks.WEB_VIEW_DID_CLOSE.getUrl());
        this.mHtmlInterstitialWebView.destroy();
        EventForwardingBroadcastReceiver.broadcastAction(this, getBroadcastIdentifier(), "com.mopub.action.interstitial.dismiss");
        super.onDestroy();
    }
}
