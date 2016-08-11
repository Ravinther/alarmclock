package com.millennialmedia.android;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

abstract class MMWebViewClient extends WebViewClient {
    private ExecutorService cachedExecutor;
    boolean isLastMMCommandResize;
    MMWebViewClientListener mmWebViewClientListener;
    RedirectionListenerImpl redirectListenerImpl;

    static abstract class MMWebViewClientListener {
        MMWebViewClientListener() {
        }

        void onPageFinished(String url) {
        }

        void onPageStarted(String url) {
        }
    }

    abstract void setMraidState(MMWebView mMWebView);

    MMWebViewClient(MMWebViewClientListener mmWebViewClientListener, RedirectionListenerImpl redirListener) {
        this.cachedExecutor = Executors.newCachedThreadPool();
        this.mmWebViewClientListener = mmWebViewClientListener;
        this.redirectListenerImpl = redirListener;
    }

    public void onPageStarted(WebView webView, String urlString, Bitmap favicon) {
        Log.m9712d("onPageStarted: %s", urlString);
        this.mmWebViewClientListener.onPageStarted(urlString);
        MMWebView mmWebView = (MMWebView) webView;
        mmWebView.mraidState = "loading";
        mmWebView.requiresPreAdSizeFix = false;
        super.onPageStarted(webView, urlString, favicon);
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String url) {
        MMWebView mmWebView = (MMWebView) webView;
        if (mmWebView.isOriginalUrl(url)) {
            return true;
        }
        Log.m9723v("@@@@@@@@@@SHOULDOVERRIDELOADING@@@@@@@@@@@@@ Url is " + url + " for " + webView);
        if (url.substring(0, 6).equalsIgnoreCase("mmsdk:")) {
            Log.m9723v("Running JS bridge command: " + url);
            MMCommand command = new MMCommand((MMWebView) webView, url);
            this.isLastMMCommandResize = command.isResizeCommand();
            this.cachedExecutor.execute(command);
            return true;
        } else if (this.redirectListenerImpl.isExpandingToUrl()) {
            return false;
        } else {
            this.redirectListenerImpl.url = url;
            this.redirectListenerImpl.weakContext = new WeakReference(webView.getContext());
            this.redirectListenerImpl.creatorAdImplInternalId = mmWebView.creatorAdImplId;
            HttpRedirection.startActivityFromUri(this.redirectListenerImpl);
            return true;
        }
    }

    public void onReceivedError(WebView webView, int errorCode, String description, String failingUrl) {
        Log.m9715e("Error: %s %s %s", Integer.valueOf(errorCode), description, failingUrl);
    }

    public void onPageFinished(WebView webView, String url) {
        MMWebView mmWebView = (MMWebView) webView;
        if (!mmWebView.isOriginalUrl(url)) {
            this.mmWebViewClientListener.onPageFinished(url);
            Log.m9711d("onPageFinished webview: " + mmWebView.toString() + "url is " + url);
            mmWebView.setAdProperties(this.redirectListenerImpl.getAdProperties());
            setMraidState(mmWebView);
        }
        super.onPageFinished(webView, url);
    }
}
