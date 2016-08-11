package com.google.android.gms.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.dynamic.C1615d;
import com.google.android.gms.dynamic.C1618e;

public final class at {
    private AdListener lF;
    private AppEventListener lV;
    private AdSize[] lW;
    private String lX;
    private final bp ml;
    private final aj mm;
    private ap mn;
    private ViewGroup mo;
    private InAppPurchaseListener mp;

    public at(ViewGroup viewGroup) {
        this(viewGroup, null, false, aj.az());
    }

    public at(ViewGroup viewGroup, AttributeSet attributeSet, boolean z) {
        this(viewGroup, attributeSet, z, aj.az());
    }

    at(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, aj ajVar) {
        this.ml = new bp();
        this.mo = viewGroup;
        this.mm = ajVar;
        if (attributeSet != null) {
            Context context = viewGroup.getContext();
            try {
                an anVar = new an(context, attributeSet);
                this.lW = anVar.m7836e(z);
                this.lX = anVar.getAdUnitId();
                if (viewGroup.isInEditMode()) {
                    dv.m8208a(viewGroup, new ak(context, this.lW[0]), "Ads by Google");
                }
            } catch (IllegalArgumentException e) {
                dv.m8210a(viewGroup, new ak(context, AdSize.BANNER), e.getMessage(), e.getMessage());
            }
        }
    }

    private void aF() {
        try {
            C1615d Q = this.mn.m7837Q();
            if (Q != null) {
                this.mo.addView((View) C1618e.m6733d(Q));
            }
        } catch (Throwable e) {
            dw.m8215c("Failed to get an ad frame.", e);
        }
    }

    private void aG() {
        if ((this.lW == null || this.lX == null) && this.mn == null) {
            throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
        }
        Context context = this.mo.getContext();
        this.mn = ag.m7820a(context, new ak(context, this.lW), this.lX, this.ml);
        if (this.lF != null) {
            this.mn.m7840a(new af(this.lF));
        }
        if (this.lV != null) {
            this.mn.m7841a(new am(this.lV));
        }
        if (this.mp != null) {
            this.mn.m7842a(new cp(this.mp));
        }
        aF();
    }

    public void m7877a(as asVar) {
        try {
            if (this.mn == null) {
                aG();
            }
            if (this.mn.m7843a(this.mm.m7827a(this.mo.getContext(), asVar))) {
                this.ml.m7929c(asVar.aC());
                this.ml.m7930d(asVar.aD());
            }
        } catch (Throwable e) {
            dw.m8215c("Failed to load ad.", e);
        }
    }

    public void m7878a(AdSize... adSizeArr) {
        this.lW = adSizeArr;
        try {
            if (this.mn != null) {
                this.mn.m7839a(new ak(this.mo.getContext(), this.lW));
            }
        } catch (Throwable e) {
            dw.m8215c("Failed to set the ad size.", e);
        }
        this.mo.requestLayout();
    }

    public void destroy() {
        try {
            if (this.mn != null) {
                this.mn.destroy();
            }
        } catch (Throwable e) {
            dw.m8215c("Failed to destroy AdView.", e);
        }
    }

    public AdListener getAdListener() {
        return this.lF;
    }

    public AdSize getAdSize() {
        try {
            if (this.mn != null) {
                return this.mn.m7838R().aA();
            }
        } catch (Throwable e) {
            dw.m8215c("Failed to get the current AdSize.", e);
        }
        return this.lW != null ? this.lW[0] : null;
    }

    public AdSize[] getAdSizes() {
        return this.lW;
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

    public void pause() {
        try {
            if (this.mn != null) {
                this.mn.pause();
            }
        } catch (Throwable e) {
            dw.m8215c("Failed to call pause.", e);
        }
    }

    public void recordManualImpression() {
        try {
            this.mn.ac();
        } catch (Throwable e) {
            dw.m8215c("Failed to record impression.", e);
        }
    }

    public void resume() {
        try {
            if (this.mn != null) {
                this.mn.resume();
            }
        } catch (Throwable e) {
            dw.m8215c("Failed to call resume.", e);
        }
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

    public void setAdSizes(AdSize... adSizes) {
        if (this.lW != null) {
            throw new IllegalStateException("The ad size can only be set once on AdView.");
        }
        m7878a(adSizes);
    }

    public void setAdUnitId(String adUnitId) {
        if (this.lX != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
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
}
