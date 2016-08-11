package com.google.android.gms.internal;

import android.content.Context;
import android.view.View;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;

public final class ds {
    public static void m8199a(Context context, WebSettings webSettings) {
        webSettings.setAppCachePath(context.getCacheDir().getAbsolutePath());
        webSettings.setAppCacheMaxSize(0);
        webSettings.setAppCacheEnabled(true);
        webSettings.setDatabasePath(context.getDatabasePath("com.google.android.gms.ads.db").getAbsolutePath());
        webSettings.setDatabaseEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setDisplayZoomControls(false);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setSupportZoom(true);
    }

    public static void m8200a(Window window) {
        window.setFlags(16777216, 16777216);
    }

    public static void m8201a(WebView webView) {
        webView.onPause();
    }

    public static void m8202b(WebView webView) {
        webView.onResume();
    }

    public static void m8203d(View view) {
        view.setLayerType(1, null);
    }

    public static void m8204e(View view) {
        view.setLayerType(0, null);
    }
}
