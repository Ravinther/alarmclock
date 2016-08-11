package com.mopub.mobileads;

import android.annotation.TargetApi;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.drive.DriveFile;
import com.mopub.common.util.VersionCode;
import com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener;
import com.mopub.mobileads.MraidView.BaseMraidListener;
import com.mopub.mobileads.MraidView.ExpansionStyle;
import com.mopub.mobileads.MraidView.MraidListener;
import com.mopub.mobileads.MraidView.NativeCloseButtonStyle;
import com.mopub.mobileads.MraidView.OnCloseButtonStateChangeListener;
import com.mopub.mobileads.MraidView.PlacementType;
import com.mopub.mobileads.MraidView.ViewState;
import com.mopub.mobileads.factories.MraidViewFactory;
import com.mopub.mobileads.util.WebViews;

public class MraidActivity extends BaseInterstitialActivity {
    private MraidView mMraidView;

    /* renamed from: com.mopub.mobileads.MraidActivity.1 */
    static class C26061 implements MraidListener {
        final /* synthetic */ CustomEventInterstitialListener val$customEventInterstitialListener;

        C26061(CustomEventInterstitialListener customEventInterstitialListener) {
            this.val$customEventInterstitialListener = customEventInterstitialListener;
        }

        public void onReady(MraidView view) {
            this.val$customEventInterstitialListener.onInterstitialLoaded();
        }

        public void onFailure(MraidView view) {
            this.val$customEventInterstitialListener.onInterstitialFailed(null);
        }

        public void onExpand(MraidView view) {
        }

        public void onOpen(MraidView view) {
        }

        public void onClose(MraidView view, ViewState newViewState) {
        }
    }

    /* renamed from: com.mopub.mobileads.MraidActivity.2 */
    static class C26072 extends WebViewClient {
        final /* synthetic */ CustomEventInterstitialListener val$customEventInterstitialListener;

        C26072(CustomEventInterstitialListener customEventInterstitialListener) {
            this.val$customEventInterstitialListener = customEventInterstitialListener;
        }

        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return true;
        }

        public void onPageFinished(WebView view, String url) {
            this.val$customEventInterstitialListener.onInterstitialLoaded();
        }
    }

    /* renamed from: com.mopub.mobileads.MraidActivity.3 */
    class C26083 extends BaseMraidListener {
        C26083() {
        }

        public void onReady(MraidView view) {
            MraidActivity.this.mMraidView.loadUrl(JavaScriptWebViewCallbacks.WEB_VIEW_DID_APPEAR.getUrl());
            MraidActivity.this.showInterstitialCloseButton();
        }

        public void onOpen(MraidView view) {
            EventForwardingBroadcastReceiver.broadcastAction(MraidActivity.this, MraidActivity.this.getBroadcastIdentifier(), "com.mopub.action.interstitial.click");
        }

        public void onClose(MraidView view, ViewState newViewState) {
            MraidActivity.this.mMraidView.loadUrl(JavaScriptWebViewCallbacks.WEB_VIEW_DID_CLOSE.getUrl());
            MraidActivity.this.finish();
        }
    }

    /* renamed from: com.mopub.mobileads.MraidActivity.4 */
    class C26094 implements OnCloseButtonStateChangeListener {
        C26094() {
        }

        public void onCloseButtonStateChange(MraidView view, boolean enabled) {
            if (enabled) {
                MraidActivity.this.showInterstitialCloseButton();
            } else {
                MraidActivity.this.hideInterstitialCloseButton();
            }
        }
    }

    static void preRenderHtml(Context context, CustomEventInterstitialListener customEventInterstitialListener, String htmlData) {
        MraidView dummyMraidView = MraidViewFactory.create(context, null, ExpansionStyle.DISABLED, NativeCloseButtonStyle.ALWAYS_VISIBLE, PlacementType.INTERSTITIAL);
        dummyMraidView.enablePlugins(false);
        dummyMraidView.setMraidListener(new C26061(customEventInterstitialListener));
        dummyMraidView.setWebViewClient(new C26072(customEventInterstitialListener));
        dummyMraidView.loadHtmlData(htmlData);
    }

    public static void start(Context context, String htmlData, AdConfiguration adConfiguration) {
        try {
            context.startActivity(createIntent(context, htmlData, adConfiguration));
        } catch (ActivityNotFoundException e) {
            Log.d("MraidInterstitial", "MraidActivity.class not found. Did you declare MraidActivity in your manifest?");
        }
    }

    private static Intent createIntent(Context context, String htmlData, AdConfiguration adConfiguration) {
        Intent intent = new Intent(context, MraidActivity.class);
        intent.putExtra(AdFetcher.HTML_RESPONSE_BODY_KEY, htmlData);
        intent.putExtra(AdFetcher.AD_CONFIGURATION_KEY, adConfiguration);
        intent.addFlags(DriveFile.MODE_READ_ONLY);
        return intent;
    }

    public View getAdView() {
        this.mMraidView = MraidViewFactory.create(this, getAdConfiguration(), ExpansionStyle.DISABLED, NativeCloseButtonStyle.AD_CONTROLLED, PlacementType.INTERSTITIAL);
        this.mMraidView.setMraidListener(new C26083());
        this.mMraidView.setOnCloseButtonStateChange(new C26094());
        this.mMraidView.loadHtmlData(getIntent().getStringExtra(AdFetcher.HTML_RESPONSE_BODY_KEY));
        return this.mMraidView;
    }

    @TargetApi(11)
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventForwardingBroadcastReceiver.broadcastAction(this, getBroadcastIdentifier(), "com.mopub.action.interstitial.show");
        if (VersionCode.currentApiLevel().isAtLeast(VersionCode.ICE_CREAM_SANDWICH)) {
            getWindow().setFlags(16777216, 16777216);
        }
    }

    protected void onPause() {
        super.onPause();
        WebViews.onPause(this.mMraidView);
    }

    protected void onResume() {
        super.onResume();
        WebViews.onResume(this.mMraidView);
    }

    protected void onDestroy() {
        this.mMraidView.destroy();
        EventForwardingBroadcastReceiver.broadcastAction(this, getBroadcastIdentifier(), "com.mopub.action.interstitial.dismiss");
        super.onDestroy();
    }
}
