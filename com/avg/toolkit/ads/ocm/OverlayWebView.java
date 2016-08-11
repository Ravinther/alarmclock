package com.avg.toolkit.ads.ocm;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class OverlayWebView extends WebView {
    private boolean f2791a;
    private boolean f2792b;
    private WebSettings f2793c;

    public OverlayWebView(Context context) {
        this(context, null);
    }

    public OverlayWebView(Context context, AttributeSet attrs) {
        this(context, attrs, 16842885);
    }

    public OverlayWebView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.f2791a = false;
        this.f2792b = false;
        if (!isInEditMode()) {
            this.f2793c = getSettings();
        }
    }
}
