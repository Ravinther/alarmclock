package com.mopub.mobileads;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.plus.PlusShare;
import com.mopub.common.MoPubBrowser;
import com.mopub.common.util.IntentUtils;
import com.mopub.mobileads.util.Utils;

class HtmlWebViewClient extends WebViewClient {
    static final String MOPUB_FAIL_LOAD = "mopub://failLoad";
    static final String MOPUB_FINISH_LOAD = "mopub://finishLoad";
    private final String mClickthroughUrl;
    private final Context mContext;
    private BaseHtmlWebView mHtmlWebView;
    private HtmlWebViewListener mHtmlWebViewListener;
    private final String mRedirectUrl;

    HtmlWebViewClient(HtmlWebViewListener htmlWebViewListener, BaseHtmlWebView htmlWebView, String clickthrough, String redirect) {
        this.mHtmlWebViewListener = htmlWebViewListener;
        this.mHtmlWebView = htmlWebView;
        this.mClickthroughUrl = clickthrough;
        this.mRedirectUrl = redirect;
        this.mContext = htmlWebView.getContext();
    }

    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if (!(handleSpecialMoPubScheme(url) || handlePhoneScheme(url) || handleNativeBrowserScheme(url))) {
            Log.d("MoPub", "Ad clicked. Click URL: " + url);
            if (!(!isWebSiteUrl(url) && IntentUtils.canHandleApplicationUrl(this.mContext, url) && launchApplicationUrl(url))) {
                showMoPubBrowserForUrl(url);
            }
        }
        return true;
    }

    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        if (this.mRedirectUrl != null && url.startsWith(this.mRedirectUrl)) {
            view.stopLoading();
            showMoPubBrowserForUrl(url);
        }
    }

    private boolean isSpecialMoPubScheme(String url) {
        return url.startsWith("mopub://");
    }

    private boolean handleSpecialMoPubScheme(String url) {
        if (!isSpecialMoPubScheme(url)) {
            return false;
        }
        Uri uri = Uri.parse(url);
        String host = uri.getHost();
        if ("finishLoad".equals(host)) {
            this.mHtmlWebViewListener.onLoaded(this.mHtmlWebView);
        } else if ("close".equals(host)) {
            this.mHtmlWebViewListener.onCollapsed();
        } else if ("failLoad".equals(host)) {
            this.mHtmlWebViewListener.onFailed(MoPubErrorCode.UNSPECIFIED);
        } else if ("custom".equals(host)) {
            handleCustomIntentFromUri(uri);
        }
        return true;
    }

    private boolean isPhoneScheme(String url) {
        return url.startsWith("tel:") || url.startsWith("voicemail:") || url.startsWith("sms:") || url.startsWith("mailto:") || url.startsWith("geo:") || url.startsWith("google.streetview:");
    }

    private boolean handlePhoneScheme(String url) {
        if (!isPhoneScheme(url)) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(url));
        intent.addFlags(DriveFile.MODE_READ_ONLY);
        launchIntentForUserClick(this.mContext, intent, "Could not handle intent with URI: " + url + ". Is this intent supported on your phone?");
        return true;
    }

    private boolean isNativeBrowserScheme(String url) {
        return url.startsWith("mopubnativebrowser://");
    }

    private boolean handleNativeBrowserScheme(String url) {
        if (!isNativeBrowserScheme(url)) {
            return false;
        }
        Uri uri = Uri.parse(url);
        try {
            String urlToOpenInNativeBrowser = uri.getQueryParameter(PlusShare.KEY_CALL_TO_ACTION_URL);
            if (!"navigate".equals(uri.getHost()) || urlToOpenInNativeBrowser == null) {
                return false;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(urlToOpenInNativeBrowser));
            intent.setFlags(DriveFile.MODE_READ_ONLY);
            launchIntentForUserClick(this.mContext, intent, "Could not handle intent with URI: " + url + ". Is this intent supported on your phone?");
            return true;
        } catch (UnsupportedOperationException e) {
            Log.w("MoPub", "Could not handle url: " + url);
            return false;
        }
    }

    private boolean isWebSiteUrl(String url) {
        return url.startsWith("http://") || url.startsWith("https://");
    }

    private boolean launchApplicationUrl(String url) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(url));
        intent.addFlags(DriveFile.MODE_READ_ONLY);
        return launchIntentForUserClick(this.mContext, intent, "Unable to open intent.");
    }

    private void showMoPubBrowserForUrl(String url) {
        if (url == null || url.equals("")) {
            url = "about:blank";
        }
        Log.d("MoPub", "Final URI to show in browser: " + url);
        Intent intent = new Intent(this.mContext, MoPubBrowser.class);
        intent.putExtra(MoPubBrowser.DESTINATION_URL_KEY, url);
        intent.addFlags(DriveFile.MODE_READ_ONLY);
        if (!launchIntentForUserClick(this.mContext, intent, "Could not handle intent action. . Perhaps you forgot to declare com.mopub.common.MoPubBrowser in your Android manifest file.")) {
            intent = new Intent("android.intent.action.VIEW", Uri.parse("about:blank"));
            intent.setFlags(DriveFile.MODE_READ_ONLY);
            launchIntentForUserClick(this.mContext, intent, null);
        }
    }

    private void handleCustomIntentFromUri(Uri uri) {
        try {
            String action = uri.getQueryParameter("fnc");
            String adData = uri.getQueryParameter("data");
            Intent customIntent = new Intent(action);
            customIntent.addFlags(DriveFile.MODE_READ_ONLY);
            customIntent.putExtra(HtmlBannerWebView.EXTRA_AD_CLICK_DATA, adData);
            launchIntentForUserClick(this.mContext, customIntent, "Could not handle custom intent: " + action + ". Is your intent spelled correctly?");
        } catch (UnsupportedOperationException e) {
            Log.w("MoPub", "Could not handle custom intent with uri: " + uri);
        }
    }

    boolean launchIntentForUserClick(Context context, Intent intent, String errorMessage) {
        if (!this.mHtmlWebView.wasClicked()) {
            return false;
        }
        boolean wasIntentStarted = Utils.executeIntent(context, intent, errorMessage);
        if (!wasIntentStarted) {
            return wasIntentStarted;
        }
        this.mHtmlWebViewListener.onClicked();
        this.mHtmlWebView.onResetUserClick();
        return wasIntentStarted;
    }
}
