package com.mopub.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.google.android.gms.drive.DriveFile;
import com.mopub.common.util.Drawables;
import com.mopub.common.util.IntentUtils;
import com.mopub.common.util.MoPubLog;

public class MoPubBrowser extends Activity {
    public static final String DESTINATION_URL_KEY = "URL";
    private static final int INNER_LAYOUT_ID = 1;
    private ImageButton mBackButton;
    private ImageButton mCloseButton;
    private ImageButton mForwardButton;
    private ImageButton mRefreshButton;
    private WebView mWebView;

    /* renamed from: com.mopub.common.MoPubBrowser.1 */
    class C25801 extends WebViewClient {
        C25801() {
        }

        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            Toast.makeText(MoPubBrowser.this, "MoPubBrowser error: " + description, 0).show();
        }

        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (url == null) {
                return false;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(url));
            if (!IntentUtils.isDeepLink(url) || !IntentUtils.deviceCanHandleIntent(MoPubBrowser.this, intent)) {
                return false;
            }
            MoPubBrowser.this.startActivity(intent);
            MoPubBrowser.this.finish();
            return true;
        }

        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            MoPubBrowser.this.mForwardButton.setImageDrawable(Drawables.UNRIGHT_ARROW.decodeImage(MoPubBrowser.this));
        }

        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            MoPubBrowser.this.mBackButton.setImageDrawable(view.canGoBack() ? Drawables.LEFT_ARROW.decodeImage(MoPubBrowser.this) : Drawables.UNLEFT_ARROW.decodeImage(MoPubBrowser.this));
            MoPubBrowser.this.mForwardButton.setImageDrawable(view.canGoForward() ? Drawables.RIGHT_ARROW.decodeImage(MoPubBrowser.this) : Drawables.UNRIGHT_ARROW.decodeImage(MoPubBrowser.this));
        }
    }

    /* renamed from: com.mopub.common.MoPubBrowser.2 */
    class C25812 extends WebChromeClient {
        C25812() {
        }

        public void onProgressChanged(WebView webView, int progress) {
            MoPubBrowser.this.setTitle("Loading...");
            MoPubBrowser.this.setProgress(progress * 100);
            if (progress == 100) {
                MoPubBrowser.this.setTitle(webView.getUrl());
            }
        }
    }

    /* renamed from: com.mopub.common.MoPubBrowser.3 */
    class C25823 implements OnClickListener {
        C25823() {
        }

        public void onClick(View v) {
            if (MoPubBrowser.this.mWebView.canGoBack()) {
                MoPubBrowser.this.mWebView.goBack();
            }
        }
    }

    /* renamed from: com.mopub.common.MoPubBrowser.4 */
    class C25834 implements OnClickListener {
        C25834() {
        }

        public void onClick(View v) {
            if (MoPubBrowser.this.mWebView.canGoForward()) {
                MoPubBrowser.this.mWebView.goForward();
            }
        }
    }

    /* renamed from: com.mopub.common.MoPubBrowser.5 */
    class C25845 implements OnClickListener {
        C25845() {
        }

        public void onClick(View v) {
            MoPubBrowser.this.mWebView.reload();
        }
    }

    /* renamed from: com.mopub.common.MoPubBrowser.6 */
    class C25856 implements OnClickListener {
        C25856() {
        }

        public void onClick(View v) {
            MoPubBrowser.this.finish();
        }
    }

    public static void open(Context context, String url) {
        MoPubLog.m9729d("Opening url in MoPubBrowser: " + url);
        Intent intent = new Intent(context, MoPubBrowser.class);
        intent.putExtra(DESTINATION_URL_KEY, url);
        intent.addFlags(DriveFile.MODE_READ_ONLY);
        context.startActivity(intent);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setResult(-1);
        getWindow().requestFeature(2);
        getWindow().setFeatureInt(2, -1);
        setContentView(getMoPubBrowserView());
        initializeWebView();
        initializeButtons();
        enableCookies();
    }

    private void initializeWebView() {
        WebSettings webSettings = this.mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setUseWideViewPort(true);
        this.mWebView.loadUrl(getIntent().getStringExtra(DESTINATION_URL_KEY));
        this.mWebView.setWebViewClient(new C25801());
        this.mWebView.setWebChromeClient(new C25812());
    }

    private void initializeButtons() {
        this.mBackButton.setBackgroundColor(0);
        this.mBackButton.setOnClickListener(new C25823());
        this.mForwardButton.setBackgroundColor(0);
        this.mForwardButton.setOnClickListener(new C25834());
        this.mRefreshButton.setBackgroundColor(0);
        this.mRefreshButton.setOnClickListener(new C25845());
        this.mCloseButton.setBackgroundColor(0);
        this.mCloseButton.setOnClickListener(new C25856());
    }

    private void enableCookies() {
        CookieSyncManager.createInstance(this);
        CookieSyncManager.getInstance().startSync();
    }

    protected void onPause() {
        super.onPause();
        CookieSyncManager.getInstance().stopSync();
    }

    protected void onResume() {
        super.onResume();
        CookieSyncManager.getInstance().startSync();
    }

    private View getMoPubBrowserView() {
        LinearLayout moPubBrowserView = new LinearLayout(this);
        moPubBrowserView.setLayoutParams(new LayoutParams(-1, -1));
        moPubBrowserView.setOrientation(INNER_LAYOUT_ID);
        RelativeLayout outerLayout = new RelativeLayout(this);
        outerLayout.setLayoutParams(new LayoutParams(-1, -2));
        moPubBrowserView.addView(outerLayout);
        LinearLayout innerLayout = new LinearLayout(this);
        innerLayout.setId(INNER_LAYOUT_ID);
        RelativeLayout.LayoutParams innerLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
        innerLayoutParams.addRule(12);
        innerLayout.setLayoutParams(innerLayoutParams);
        innerLayout.setBackgroundDrawable(Drawables.BACKGROUND.decodeImage(this));
        outerLayout.addView(innerLayout);
        this.mBackButton = getButton(Drawables.LEFT_ARROW.decodeImage(this));
        this.mForwardButton = getButton(Drawables.RIGHT_ARROW.decodeImage(this));
        this.mRefreshButton = getButton(Drawables.REFRESH.decodeImage(this));
        this.mCloseButton = getButton(Drawables.CLOSE.decodeImage(this));
        innerLayout.addView(this.mBackButton);
        innerLayout.addView(this.mForwardButton);
        innerLayout.addView(this.mRefreshButton);
        innerLayout.addView(this.mCloseButton);
        this.mWebView = new WebView(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(2, INNER_LAYOUT_ID);
        this.mWebView.setLayoutParams(layoutParams);
        outerLayout.addView(this.mWebView);
        return moPubBrowserView;
    }

    private ImageButton getButton(Drawable drawable) {
        ImageButton imageButton = new ImageButton(this);
        LayoutParams layoutParams = new LayoutParams(-2, -2, 1.0f);
        layoutParams.gravity = 16;
        imageButton.setLayoutParams(layoutParams);
        imageButton.setImageDrawable(drawable);
        return imageButton;
    }
}
