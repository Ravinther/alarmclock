package com.google.android.gms.internal;

import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.HashMap;
import java.util.Map;

public class ea extends WebViewClient {
    protected final dz lC;
    private final Object li;
    private az mF;
    private bc mP;
    private C1739a oW;
    private final HashMap rA;
    private C2039u rB;
    private cf rC;
    private boolean rD;
    private boolean rE;
    private ci rF;

    /* renamed from: com.google.android.gms.internal.ea.a */
    public interface C1739a {
        void m7812a(dz dzVar);
    }

    /* renamed from: com.google.android.gms.internal.ea.1 */
    class C18351 implements Runnable {
        final /* synthetic */ cc rG;
        final /* synthetic */ ea rH;

        C18351(ea eaVar, cc ccVar) {
            this.rH = eaVar;
            this.rG = ccVar;
        }

        public void run() {
            this.rG.aM();
        }
    }

    public ea(dz dzVar, boolean z) {
        this.rA = new HashMap();
        this.li = new Object();
        this.rD = false;
        this.lC = dzVar;
        this.rE = z;
    }

    private static boolean m8238c(Uri uri) {
        String scheme = uri.getScheme();
        return "http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme);
    }

    private void m8239d(Uri uri) {
        String path = uri.getPath();
        bb bbVar = (bb) this.rA.get(path);
        if (bbVar != null) {
            Map b = dq.m8185b(uri);
            if (dw.m8216n(2)) {
                dw.m8220y("Received GMSG: " + path);
                for (String path2 : b.keySet()) {
                    dw.m8220y("  " + path2 + ": " + ((String) b.get(path2)));
                }
            }
            bbVar.m7788b(this.lC, b);
            return;
        }
        dw.m8220y("No GMSG handler found for GMSG: " + uri);
    }

    public final void m8240a(cb cbVar) {
        cf cfVar = null;
        boolean bL = this.lC.bL();
        C2039u c2039u = (!bL || this.lC.m8226R().lT) ? this.rB : null;
        if (!bL) {
            cfVar = this.rC;
        }
        m8241a(new ce(cbVar, c2039u, cfVar, this.rF, this.lC.bK()));
    }

    protected void m8241a(ce ceVar) {
        cc.m8023a(this.lC.getContext(), ceVar);
    }

    public final void m8242a(C1739a c1739a) {
        this.oW = c1739a;
    }

    public void m8243a(C2039u c2039u, cf cfVar, az azVar, ci ciVar, boolean z, bc bcVar) {
        m8244a("/appEvent", new ay(azVar));
        m8244a("/canOpenURLs", ba.mH);
        m8244a("/click", ba.mI);
        m8244a("/close", ba.mJ);
        m8244a("/customClose", ba.mK);
        m8244a("/httpTrack", ba.mL);
        m8244a("/log", ba.mM);
        m8244a("/open", new bd(bcVar));
        m8244a("/touch", ba.mN);
        m8244a("/video", ba.mO);
        this.rB = c2039u;
        this.rC = cfVar;
        this.mF = azVar;
        this.mP = bcVar;
        this.rF = ciVar;
        m8248q(z);
    }

    public final void m8244a(String str, bb bbVar) {
        this.rA.put(str, bbVar);
    }

    public final void m8245a(boolean z, int i) {
        C2039u c2039u = (!this.lC.bL() || this.lC.m8226R().lT) ? this.rB : null;
        m8241a(new ce(c2039u, this.rC, this.rF, this.lC, z, i, this.lC.bK()));
    }

    public final void m8246a(boolean z, int i, String str) {
        cf cfVar = null;
        boolean bL = this.lC.bL();
        C2039u c2039u = (!bL || this.lC.m8226R().lT) ? this.rB : null;
        if (!bL) {
            cfVar = this.rC;
        }
        m8241a(new ce(c2039u, cfVar, this.mF, this.rF, this.lC, z, i, str, this.lC.bK(), this.mP));
    }

    public final void m8247a(boolean z, int i, String str, String str2) {
        boolean bL = this.lC.bL();
        C2039u c2039u = (!bL || this.lC.m8226R().lT) ? this.rB : null;
        m8241a(new ce(c2039u, bL ? null : this.rC, this.mF, this.rF, this.lC, z, i, str, str2, this.lC.bK(), this.mP));
    }

    public final void aM() {
        synchronized (this.li) {
            this.rD = false;
            this.rE = true;
            cc bH = this.lC.bH();
            if (bH != null) {
                if (dv.bD()) {
                    bH.aM();
                } else {
                    dv.rp.post(new C18351(this, bH));
                }
            }
        }
    }

    public boolean bP() {
        boolean z;
        synchronized (this.li) {
            z = this.rE;
        }
        return z;
    }

    public final void onLoadResource(WebView webView, String url) {
        dw.m8220y("Loading resource: " + url);
        Uri parse = Uri.parse(url);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            m8239d(parse);
        }
    }

    public final void onPageFinished(WebView webView, String url) {
        if (this.oW != null) {
            this.oW.m7812a(this.lC);
            this.oW = null;
        }
    }

    public final void m8248q(boolean z) {
        this.rD = z;
    }

    public final void reset() {
        synchronized (this.li) {
            this.rA.clear();
            this.rB = null;
            this.rC = null;
            this.oW = null;
            this.mF = null;
            this.rD = false;
            this.rE = false;
            this.mP = null;
            this.rF = null;
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String url) {
        dw.m8220y("AdWebView shouldOverrideUrlLoading: " + url);
        Uri parse = Uri.parse(url);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            m8239d(parse);
        } else if (this.rD && webView == this.lC && m8238c(parse)) {
            return super.shouldOverrideUrlLoading(webView, url);
        } else {
            if (this.lC.willNotDraw()) {
                dw.m8221z("AdWebView unable to handle URL: " + url);
            } else {
                Uri uri;
                try {
                    C2026l bJ = this.lC.bJ();
                    if (bJ != null && bJ.m8953a(parse)) {
                        parse = bJ.m8951a(parse, this.lC.getContext());
                    }
                    uri = parse;
                } catch (C2027m e) {
                    dw.m8221z("Unable to append parameter to URL: " + url);
                    uri = parse;
                }
                m8240a(new cb("android.intent.action.VIEW", uri.toString(), null, null, null, null, null));
            }
        }
        return true;
    }
}
