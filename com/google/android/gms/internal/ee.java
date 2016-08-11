package com.google.android.gms.internal;

import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.net.URI;
import java.net.URISyntaxException;

public class ee extends WebViewClient {
    private final dz lC;
    private final String rM;
    private boolean rN;
    private final ct rO;

    public ee(ct ctVar, dz dzVar, String str) {
        this.rM = m8254B(str);
        this.rN = false;
        this.lC = dzVar;
        this.rO = ctVar;
    }

    private String m8254B(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                if (str.endsWith("/")) {
                    str = str.substring(0, str.length() - 1);
                }
            } catch (IndexOutOfBoundsException e) {
                dw.m8218w(e.getMessage());
            }
        }
        return str;
    }

    protected boolean m8255A(String str) {
        Object B = m8254B(str);
        if (TextUtils.isEmpty(B)) {
            return false;
        }
        try {
            URI uri = new URI(B);
            if ("passback".equals(uri.getScheme())) {
                dw.m8217v("Passback received");
                this.rO.bb();
                return true;
            } else if (TextUtils.isEmpty(this.rM)) {
                return false;
            } else {
                URI uri2 = new URI(this.rM);
                String host = uri2.getHost();
                String host2 = uri.getHost();
                String path = uri2.getPath();
                String path2 = uri.getPath();
                if (!fo.equal(host, host2) || !fo.equal(path, path2)) {
                    return false;
                }
                dw.m8217v("Passback received");
                this.rO.bb();
                return true;
            }
        } catch (URISyntaxException e) {
            dw.m8218w(e.getMessage());
            return false;
        }
    }

    public void onLoadResource(WebView view, String url) {
        dw.m8217v("JavascriptAdWebViewClient::onLoadResource: " + url);
        if (!m8255A(url)) {
            this.lC.bI().onLoadResource(this.lC, url);
        }
    }

    public void onPageFinished(WebView view, String url) {
        dw.m8217v("JavascriptAdWebViewClient::onPageFinished: " + url);
        if (!this.rN) {
            this.rO.ba();
            this.rN = true;
        }
    }

    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        dw.m8217v("JavascriptAdWebViewClient::shouldOverrideUrlLoading: " + url);
        if (!m8255A(url)) {
            return this.lC.bI().shouldOverrideUrlLoading(this.lC, url);
        }
        dw.m8217v("shouldOverrideUrlLoading: received passback url");
        return true;
    }
}
