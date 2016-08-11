package com.google.android.gms.internal;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.internal.cr.C1804a;
import com.google.android.gms.internal.cu.C1811a;
import com.google.android.gms.internal.cx.C1815a;
import com.google.android.gms.internal.ea.C1739a;
import com.mopub.mobileads.util.Base64;
import org.json.JSONException;
import org.json.JSONObject;

public class cs extends C1810do implements C1811a, C1739a {
    private final bq ky;
    private final dz lC;
    private final Object li;
    private final Context mContext;
    private bj mR;
    private final C1804a oG;
    private final Object oH;
    private final C1815a oI;
    private final C2026l oJ;
    private C1810do oK;
    private cz oL;
    private boolean oM;
    private bh oN;
    private bn oO;

    /* renamed from: com.google.android.gms.internal.cs.1 */
    class C18051 implements Runnable {
        final /* synthetic */ cs oP;

        C18051(cs csVar) {
            this.oP = csVar;
        }

        public void run() {
            this.oP.onStop();
        }
    }

    /* renamed from: com.google.android.gms.internal.cs.2 */
    class C18062 implements Runnable {
        final /* synthetic */ cs oP;
        final /* synthetic */ dh oQ;

        C18062(cs csVar, dh dhVar) {
            this.oP = csVar;
            this.oQ = dhVar;
        }

        public void run() {
            synchronized (this.oP.li) {
                this.oP.oG.m8064a(this.oQ);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.cs.3 */
    class C18073 implements Runnable {
        final /* synthetic */ cs oP;

        C18073(cs csVar) {
            this.oP = csVar;
        }

        public void run() {
            synchronized (this.oP.li) {
                if (this.oP.oL.errorCode != -2) {
                    return;
                }
                this.oP.lC.bI().m8242a(this.oP);
                if (this.oP.oL.errorCode == -3) {
                    dw.m8220y("Loading URL in WebView: " + this.oP.oL.ol);
                    this.oP.lC.loadUrl(this.oP.oL.ol);
                } else {
                    dw.m8220y("Loading HTML in WebView.");
                    this.oP.lC.loadDataWithBaseURL(dq.m8193r(this.oP.oL.ol), this.oP.oL.pm, "text/html", "UTF-8", null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.cs.4 */
    class C18084 implements Runnable {
        final /* synthetic */ cs oP;
        final /* synthetic */ ct oR;

        C18084(cs csVar, ct ctVar) {
            this.oP = csVar;
            this.oR = ctVar;
        }

        public void run() {
            synchronized (this.oP.li) {
                if (this.oP.oL.errorCode != -2) {
                    return;
                }
                this.oP.lC.bI().m8242a(this.oP);
                this.oR.m8091b(this.oP.oL);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.cs.a */
    private static final class C1809a extends Exception {
        private final int oS;

        public C1809a(String str, int i) {
            super(str);
            this.oS = i;
        }

        public int getErrorCode() {
            return this.oS;
        }
    }

    public cs(Context context, C1815a c1815a, C2026l c2026l, dz dzVar, bq bqVar, C1804a c1804a) {
        this.oH = new Object();
        this.li = new Object();
        this.oM = false;
        this.ky = bqVar;
        this.oG = c1804a;
        this.lC = dzVar;
        this.mContext = context;
        this.oI = c1815a;
        this.oJ = c2026l;
    }

    private ak m8068a(cx cxVar) {
        if (this.oL.pr == null) {
            throw new C1809a("The ad response must specify one of the supported ad sizes.", 0);
        }
        String[] split = this.oL.pr.split("x");
        if (split.length != 2) {
            throw new C1809a("Could not parse the ad size from the ad response: " + this.oL.pr, 0);
        }
        try {
            int parseInt = Integer.parseInt(split[0]);
            int parseInt2 = Integer.parseInt(split[1]);
            for (ak akVar : cxVar.kN.lU) {
                float f = this.mContext.getResources().getDisplayMetrics().density;
                int i = akVar.width == -1 ? (int) (((float) akVar.widthPixels) / f) : akVar.width;
                int i2 = akVar.height == -2 ? (int) (((float) akVar.heightPixels) / f) : akVar.height;
                if (parseInt == i && parseInt2 == i2) {
                    return new ak(akVar, cxVar.kN.lU);
                }
            }
            throw new C1809a("The ad size from the ad response was not one of the requested sizes: " + this.oL.pr, 0);
        } catch (NumberFormatException e) {
            throw new C1809a("Could not parse the ad size from the ad response: " + this.oL.pr, 0);
        }
    }

    private void m8070a(cx cxVar, long j) {
        synchronized (this.oH) {
            this.oN = new bh(this.mContext, cxVar, this.ky, this.mR);
        }
        this.oO = this.oN.m7902a(j, 60000);
        switch (this.oO.nw) {
            case Base64.DEFAULT /*0*/:
            case Base64.NO_PADDING /*1*/:
                throw new C1809a("No fill from any mediation ad networks.", 3);
            default:
                throw new C1809a("Unexpected mediation result: " + this.oO.nw, 0);
        }
    }

    private void aZ() {
        if (this.oL.errorCode != -3) {
            if (TextUtils.isEmpty(this.oL.pm)) {
                throw new C1809a("No fill from ad server.", 3);
            } else if (this.oL.po) {
                try {
                    this.mR = new bj(this.oL.pm);
                } catch (JSONException e) {
                    throw new C1809a("Could not parse mediation config: " + this.oL.pm, 0);
                }
            }
        }
    }

    private void m8072b(long j) {
        dv.rp.post(new C18073(this));
        m8076e(j);
    }

    private void m8075d(long j) {
        while (m8077f(j)) {
            if (this.oL != null) {
                synchronized (this.oH) {
                    this.oK = null;
                }
                if (this.oL.errorCode != -2 && this.oL.errorCode != -3) {
                    throw new C1809a("There was a problem getting an ad response. ErrorCode: " + this.oL.errorCode, this.oL.errorCode);
                }
                return;
            }
        }
        throw new C1809a("Timed out waiting for ad response.", 2);
    }

    private void m8076e(long j) {
        while (m8077f(j)) {
            if (this.oM) {
                return;
            }
        }
        throw new C1809a("Timed out waiting for WebView to finish loading.", 2);
    }

    private boolean m8077f(long j) {
        long elapsedRealtime = 60000 - (SystemClock.elapsedRealtime() - j);
        if (elapsedRealtime <= 0) {
            return false;
        }
        try {
            this.li.wait(elapsedRealtime);
            return true;
        } catch (InterruptedException e) {
            throw new C1809a("Ad request cancelled.", -1);
        }
    }

    public void m8078a(cz czVar) {
        synchronized (this.li) {
            dw.m8217v("Received ad response.");
            this.oL = czVar;
            this.li.notify();
        }
    }

    public void m8079a(dz dzVar) {
        synchronized (this.li) {
            dw.m8217v("WebView finished loading.");
            this.oM = true;
            this.li.notify();
        }
    }

    public void aY() {
        synchronized (this.li) {
            long j;
            ak akVar;
            dw.m8217v("AdLoaderBackgroundTask started.");
            cx cxVar = new cx(this.oI, this.oJ.m8954y().m8627a(this.mContext));
            ak akVar2 = null;
            int i = -2;
            long j2 = -1;
            try {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                C1810do a = cu.m8092a(this.mContext, cxVar, this);
                synchronized (this.oH) {
                    this.oK = a;
                    if (this.oK == null) {
                        throw new C1809a("Could not start the ad request service.", 0);
                    }
                }
                m8075d(elapsedRealtime);
                j2 = SystemClock.elapsedRealtime();
                aZ();
                if (cxVar.kN.lU != null) {
                    akVar2 = m8068a(cxVar);
                }
                if (this.oL.po) {
                    m8070a(cxVar, elapsedRealtime);
                } else if (this.oL.pu) {
                    m8080c(elapsedRealtime);
                } else {
                    m8072b(elapsedRealtime);
                }
                j = j2;
                akVar = akVar2;
            } catch (C1809a e) {
                i = e.getErrorCode();
                if (i == 3 || i == -1) {
                    dw.m8219x(e.getMessage());
                } else {
                    dw.m8221z(e.getMessage());
                }
                if (this.oL == null) {
                    this.oL = new cz(i);
                } else {
                    this.oL = new cz(i, this.oL.ni);
                }
                dv.rp.post(new C18051(this));
                j = j2;
                akVar = akVar2;
            }
            if (!TextUtils.isEmpty(this.oL.pw)) {
                try {
                    JSONObject jSONObject = new JSONObject(this.oL.pw);
                } catch (Throwable e2) {
                    dw.m8214b("Error parsing the JSON for Active View.", e2);
                }
                dv.rp.post(new C18062(this, new dh(cxVar.pg, this.lC, this.oL.ne, i, this.oL.nf, this.oL.pq, this.oL.orientation, this.oL.ni, cxVar.pj, this.oL.po, this.oO == null ? this.oO.nx : null, this.oO == null ? this.oO.ny : null, this.oO == null ? this.oO.nz : null, this.mR, this.oO == null ? this.oO.nA : null, this.oL.pp, akVar, this.oL.pn, j, this.oL.ps, this.oL.pt, r29)));
            }
            JSONObject jSONObject2 = null;
            if (this.oO == null) {
            }
            if (this.oO == null) {
            }
            if (this.oO == null) {
            }
            if (this.oO == null) {
            }
            dv.rp.post(new C18062(this, new dh(cxVar.pg, this.lC, this.oL.ne, i, this.oL.nf, this.oL.pq, this.oL.orientation, this.oL.ni, cxVar.pj, this.oL.po, this.oO == null ? this.oO.nx : null, this.oO == null ? this.oO.ny : null, this.oO == null ? this.oO.nz : null, this.mR, this.oO == null ? this.oO.nA : null, this.oL.pp, akVar, this.oL.pn, j, this.oL.ps, this.oL.pt, jSONObject2)));
        }
    }

    protected void m8080c(long j) {
        int i;
        int i2;
        ak R = this.lC.m8226R();
        if (R.lT) {
            i = this.mContext.getResources().getDisplayMetrics().widthPixels;
            i2 = this.mContext.getResources().getDisplayMetrics().heightPixels;
        } else {
            i = R.widthPixels;
            i2 = R.heightPixels;
        }
        ct ctVar = new ct(this, this.lC, i, i2);
        dv.rp.post(new C18084(this, ctVar));
        m8076e(j);
        if (ctVar.bc()) {
            dw.m8217v("Ad-Network indicated no fill with passback URL.");
            throw new C1809a("AdNetwork sent passback url", 3);
        } else if (!ctVar.bd()) {
            throw new C1809a("AdNetwork timed out", 2);
        }
    }

    public void onStop() {
        synchronized (this.oH) {
            if (this.oK != null) {
                this.oK.cancel();
            }
            this.lC.stopLoading();
            dq.m8179a(this.lC);
            if (this.oN != null) {
                this.oN.cancel();
            }
        }
    }
}
