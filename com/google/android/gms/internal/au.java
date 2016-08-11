package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;

public final class au {
    private AdListener lF;
    private AppEventListener lV;
    private String lX;
    private final Context mContext;
    private final bp ml;
    private final aj mm;
    private ap mn;
    private InAppPurchaseListener mp;

    public au(Context context) {
        this(context, aj.az());
    }

    public au(Context context, aj ajVar) {
        this.ml = new bp();
        this.mContext = context;
        this.mm = ajVar;
    }

    private void m7879k(String str) {
        if (this.lX == null) {
            m7880l(str);
        }
        this.mn = ag.m7820a(this.mContext, new ak(), this.lX, this.ml);
        if (this.lF != null) {
            this.mn.m7840a(new af(this.lF));
        }
        if (this.lV != null) {
            this.mn.m7841a(new am(this.lV));
        }
        if (this.mp != null) {
            this.mn.m7842a(new cp(this.mp));
        }
    }

    private void m7880l(String str) {
        if (this.mn == null) {
            throw new IllegalStateException("The ad unit ID must be set on InterstitialAd before " + str + " is called.");
        }
    }

    public void m7881a(as asVar) {
        try {
            if (this.mn == null) {
                m7879k("loadAd");
            }
            if (this.mn.m7843a(this.mm.m7827a(this.mContext, asVar))) {
                this.ml.m7929c(asVar.aC());
                this.ml.m7930d(asVar.aD());
            }
        } catch (Throwable e) {
            dw.m8215c("Failed to load ad.", e);
        }
    }

    public AdListener getAdListener() {
        return this.lF;
    }

    public String getAdUnitId() {
        return this.lX;
    }

    public AppEventListener getAppEventListener() {
        return this.lV;
    }

    public InAppPurchaseListener getInAppPurchaseListener() {
        return this.mp;
    }

    public boolean isLoaded() {
        boolean z = false;
        try {
            if (this.mn != null) {
                z = this.mn.isReady();
            }
        } catch (Throwable e) {
            dw.m8215c("Failed to check if ad is ready.", e);
        }
        return z;
    }

    public void setAdListener(AdListener adListener) {
        try {
            this.lF = adListener;
            if (this.mn != null) {
                this.mn.m7840a(adListener != null ? new af(adListener) : null);
            }
        } catch (Throwable e) {
            dw.m8215c("Failed to set the AdListener.", e);
        }
    }

    public void setAdUnitId(String adUnitId) {
        if (this.lX != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
        }
        this.lX = adUnitId;
    }

    public void setAppEventListener(AppEventListener appEventListener) {
        try {
            this.lV = appEventListener;
            if (this.mn != null) {
                this.mn.m7841a(appEventListener != null ? new am(appEventListener) : null);
            }
        } catch (Throwable e) {
            dw.m8215c("Failed to set the AppEventListener.", e);
        }
    }

    public void setInAppPurchaseListener(InAppPurchaseListener inAppPurchaseListener) {
        try {
            this.mp = inAppPurchaseListener;
            if (this.mn != null) {
                this.mn.m7842a(inAppPurchaseListener != null ? new cp(inAppPurchaseListener) : null);
            }
        } catch (Throwable e) {
            dw.m8215c("Failed to set the InAppPurchaseListener.", e);
        }
    }

    public void show() {
        try {
            m7880l("show");
            this.mn.showInterstitial();
        } catch (Throwable e) {
            dw.m8215c("Failed to show interstitial.", e);
        }
    }
}
