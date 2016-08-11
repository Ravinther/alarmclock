package com.avg.ui.general.customviews;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.avg.toolkit.p049e.C0970a;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.plus.PlusShare;

public class MoreAVGAppsWebView extends WebView {
    private boolean f3427a;
    private boolean f3428b;
    private WebSettings f3429c;
    private Context f3430d;
    private C1118a f3431e;

    /* renamed from: com.avg.ui.general.customviews.MoreAVGAppsWebView.a */
    public interface C1118a {
        void m4747a(int i);

        void m4748a(boolean z);
    }

    /* renamed from: com.avg.ui.general.customviews.MoreAVGAppsWebView.1 */
    class C11301 extends WebViewClient {
        final /* synthetic */ MoreAVGAppsWebView f3426a;

        C11301(MoreAVGAppsWebView moreAVGAppsWebView) {
            this.f3426a = moreAVGAppsWebView;
        }

        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (this.f3426a.f3428b) {
                try {
                    if (url.startsWith("avg-android://")) {
                        String packageName = "";
                        String appUrl = "";
                        for (String entrie : url.substring(14).split(",")) {
                            if (entrie.startsWith("package")) {
                                packageName = entrie.substring(entrie.indexOf("=") + 1);
                            } else if (entrie.startsWith(PlusShare.KEY_CALL_TO_ACTION_URL)) {
                                appUrl = entrie.substring(entrie.indexOf("=") + 1);
                            }
                        }
                        m4779a(packageName, appUrl);
                    } else if (url.startsWith("avg-pc://")) {
                        int couponID = -1;
                        for (String entrie2 : url.substring(9).split(",")) {
                            if (entrie2.startsWith("coupon")) {
                                try {
                                    couponID = Integer.parseInt(entrie2.substring(entrie2.indexOf("=") + 1));
                                } catch (NumberFormatException e) {
                                    C0970a.m4325b("Coupon ID is not an integer number. cannot send coupon mail");
                                }
                            }
                        }
                        m4778a(couponID);
                    } else {
                        view.loadUrl(url);
                    }
                } catch (Exception e2) {
                    C0970a.m4322a(e2);
                }
            } else {
                view.loadUrl(url);
            }
            return true;
        }

        private void m4778a(int couponID) {
            if (couponID != -1 && this.f3426a.f3431e != null) {
                this.f3426a.f3431e.m4747a(couponID);
            }
        }

        private void m4779a(String packageName, String url) {
            if (this.f3426a.m4783a(packageName)) {
                this.f3426a.m4786b(packageName);
                return;
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(url));
            this.f3426a.f3430d.startActivity(intent);
        }

        public void onPageFinished(WebView webView, String url) {
            boolean error = false;
            if (this.f3426a.f3427a) {
                this.f3426a.clearCache(true);
                error = true;
            } else {
                this.f3426a.f3428b = true;
            }
            if (this.f3426a.f3431e != null) {
                this.f3426a.f3431e.m4748a(error);
            }
        }

        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            this.f3426a.f3427a = true;
        }
    }

    public MoreAVGAppsWebView(Context ctx) {
        super(ctx);
        this.f3427a = false;
        this.f3428b = false;
        this.f3430d = ctx;
        this.f3429c = getSettings();
    }

    public MoreAVGAppsWebView(Context ctx, AttributeSet attrs) {
        super(ctx, attrs);
        this.f3427a = false;
        this.f3428b = false;
        this.f3430d = ctx;
        this.f3429c = getSettings();
    }

    public void setRequestLoginCallback(C1118a requestLoginCallback) {
        this.f3431e = requestLoginCallback;
    }

    @SuppressLint({"NewApi"})
    public void m4790a(String adUrl, boolean useCache) {
        if (VERSION.SDK_INT >= 11) {
            setLayerType(1, null);
            setBackgroundColor(Color.argb(0, 0, 0, 0));
        }
        this.f3429c.setLoadsImagesAutomatically(true);
        this.f3429c.setJavaScriptEnabled(false);
        this.f3429c.setBuiltInZoomControls(false);
        this.f3429c.setUseWideViewPort(true);
        this.f3429c.setLoadWithOverviewMode(true);
        if (useCache) {
            this.f3429c.setCacheMode(-1);
        } else {
            this.f3429c.setCacheMode(2);
        }
        setVerticalScrollBarEnabled(true);
        setHorizontalScrollBarEnabled(true);
        setScrollBarStyle(33554432);
        setFocusable(false);
        setWebViewClient(new C11301(this));
        reload();
        loadUrl(adUrl);
    }

    private boolean m4783a(String packageName) {
        try {
            this.f3430d.getPackageManager().getPackageInfo(packageName, Cast.MAX_NAMESPACE_LENGTH);
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    private void m4786b(String packageName) {
        try {
            this.f3430d.startActivity(this.f3430d.getPackageManager().getLaunchIntentForPackage(packageName));
        } catch (Exception e) {
        }
    }
}
