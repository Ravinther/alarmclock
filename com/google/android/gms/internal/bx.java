package com.google.android.gms.internal;

import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;

public final class bx implements MediationBannerListener, MediationInterstitialListener {
    private final bs nG;

    /* renamed from: com.google.android.gms.internal.bx.10 */
    class AnonymousClass10 implements Runnable {
        final /* synthetic */ bx nJ;
        final /* synthetic */ ErrorCode nK;

        AnonymousClass10(bx bxVar, ErrorCode errorCode) {
            this.nJ = bxVar;
            this.nK = errorCode;
        }

        public void run() {
            try {
                this.nJ.nG.onAdFailedToLoad(by.m7954a(this.nK));
            } catch (Throwable e) {
                dw.m8215c("Could not call onAdFailedToLoad.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.bx.1 */
    class C17681 implements Runnable {
        final /* synthetic */ bx nJ;

        C17681(bx bxVar) {
            this.nJ = bxVar;
        }

        public void run() {
            try {
                this.nJ.nG.m7907P();
            } catch (Throwable e) {
                dw.m8215c("Could not call onAdClicked.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.bx.2 */
    class C17692 implements Runnable {
        final /* synthetic */ bx nJ;

        C17692(bx bxVar) {
            this.nJ = bxVar;
        }

        public void run() {
            try {
                this.nJ.nG.onAdOpened();
            } catch (Throwable e) {
                dw.m8215c("Could not call onAdOpened.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.bx.3 */
    class C17703 implements Runnable {
        final /* synthetic */ bx nJ;

        C17703(bx bxVar) {
            this.nJ = bxVar;
        }

        public void run() {
            try {
                this.nJ.nG.onAdLoaded();
            } catch (Throwable e) {
                dw.m8215c("Could not call onAdLoaded.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.bx.4 */
    class C17714 implements Runnable {
        final /* synthetic */ bx nJ;

        C17714(bx bxVar) {
            this.nJ = bxVar;
        }

        public void run() {
            try {
                this.nJ.nG.onAdClosed();
            } catch (Throwable e) {
                dw.m8215c("Could not call onAdClosed.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.bx.5 */
    class C17725 implements Runnable {
        final /* synthetic */ bx nJ;
        final /* synthetic */ ErrorCode nK;

        C17725(bx bxVar, ErrorCode errorCode) {
            this.nJ = bxVar;
            this.nK = errorCode;
        }

        public void run() {
            try {
                this.nJ.nG.onAdFailedToLoad(by.m7954a(this.nK));
            } catch (Throwable e) {
                dw.m8215c("Could not call onAdFailedToLoad.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.bx.6 */
    class C17736 implements Runnable {
        final /* synthetic */ bx nJ;

        C17736(bx bxVar) {
            this.nJ = bxVar;
        }

        public void run() {
            try {
                this.nJ.nG.onAdLeftApplication();
            } catch (Throwable e) {
                dw.m8215c("Could not call onAdLeftApplication.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.bx.7 */
    class C17747 implements Runnable {
        final /* synthetic */ bx nJ;

        C17747(bx bxVar) {
            this.nJ = bxVar;
        }

        public void run() {
            try {
                this.nJ.nG.onAdOpened();
            } catch (Throwable e) {
                dw.m8215c("Could not call onAdOpened.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.bx.8 */
    class C17758 implements Runnable {
        final /* synthetic */ bx nJ;

        C17758(bx bxVar) {
            this.nJ = bxVar;
        }

        public void run() {
            try {
                this.nJ.nG.onAdLoaded();
            } catch (Throwable e) {
                dw.m8215c("Could not call onAdLoaded.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.bx.9 */
    class C17769 implements Runnable {
        final /* synthetic */ bx nJ;

        C17769(bx bxVar) {
            this.nJ = bxVar;
        }

        public void run() {
            try {
                this.nJ.nG.onAdClosed();
            } catch (Throwable e) {
                dw.m8215c("Could not call onAdClosed.", e);
            }
        }
    }

    public bx(bs bsVar) {
        this.nG = bsVar;
    }

    public void onClick(MediationBannerAdapter adapter) {
        dw.m8217v("Adapter called onClick.");
        if (dv.bD()) {
            try {
                this.nG.m7907P();
                return;
            } catch (Throwable e) {
                dw.m8215c("Could not call onAdClicked.", e);
                return;
            }
        }
        dw.m8221z("onClick must be called on the main UI thread.");
        dv.rp.post(new C17681(this));
    }

    public void onDismissScreen(MediationBannerAdapter adapter) {
        dw.m8217v("Adapter called onDismissScreen.");
        if (dv.bD()) {
            try {
                this.nG.onAdClosed();
                return;
            } catch (Throwable e) {
                dw.m8215c("Could not call onAdClosed.", e);
                return;
            }
        }
        dw.m8221z("onDismissScreen must be called on the main UI thread.");
        dv.rp.post(new C17714(this));
    }

    public void onDismissScreen(MediationInterstitialAdapter adapter) {
        dw.m8217v("Adapter called onDismissScreen.");
        if (dv.bD()) {
            try {
                this.nG.onAdClosed();
                return;
            } catch (Throwable e) {
                dw.m8215c("Could not call onAdClosed.", e);
                return;
            }
        }
        dw.m8221z("onDismissScreen must be called on the main UI thread.");
        dv.rp.post(new C17769(this));
    }

    public void onFailedToReceiveAd(MediationBannerAdapter adapter, ErrorCode errorCode) {
        dw.m8217v("Adapter called onFailedToReceiveAd with error. " + errorCode);
        if (dv.bD()) {
            try {
                this.nG.onAdFailedToLoad(by.m7954a(errorCode));
                return;
            } catch (Throwable e) {
                dw.m8215c("Could not call onAdFailedToLoad.", e);
                return;
            }
        }
        dw.m8221z("onFailedToReceiveAd must be called on the main UI thread.");
        dv.rp.post(new C17725(this, errorCode));
    }

    public void onFailedToReceiveAd(MediationInterstitialAdapter adapter, ErrorCode errorCode) {
        dw.m8217v("Adapter called onFailedToReceiveAd with error " + errorCode + ".");
        if (dv.bD()) {
            try {
                this.nG.onAdFailedToLoad(by.m7954a(errorCode));
                return;
            } catch (Throwable e) {
                dw.m8215c("Could not call onAdFailedToLoad.", e);
                return;
            }
        }
        dw.m8221z("onFailedToReceiveAd must be called on the main UI thread.");
        dv.rp.post(new AnonymousClass10(this, errorCode));
    }

    public void onLeaveApplication(MediationBannerAdapter adapter) {
        dw.m8217v("Adapter called onLeaveApplication.");
        if (dv.bD()) {
            try {
                this.nG.onAdLeftApplication();
                return;
            } catch (Throwable e) {
                dw.m8215c("Could not call onAdLeftApplication.", e);
                return;
            }
        }
        dw.m8221z("onLeaveApplication must be called on the main UI thread.");
        dv.rp.post(new C17736(this));
    }

    public void onLeaveApplication(MediationInterstitialAdapter adapter) {
        dw.m8217v("Adapter called onLeaveApplication.");
        if (dv.bD()) {
            try {
                this.nG.onAdLeftApplication();
                return;
            } catch (Throwable e) {
                dw.m8215c("Could not call onAdLeftApplication.", e);
                return;
            }
        }
        dw.m8221z("onLeaveApplication must be called on the main UI thread.");
        dv.rp.post(new Runnable() {
            final /* synthetic */ bx nJ;

            {
                this.nJ = r1;
            }

            public void run() {
                try {
                    this.nJ.nG.onAdLeftApplication();
                } catch (Throwable e) {
                    dw.m8215c("Could not call onAdLeftApplication.", e);
                }
            }
        });
    }

    public void onPresentScreen(MediationBannerAdapter adapter) {
        dw.m8217v("Adapter called onPresentScreen.");
        if (dv.bD()) {
            try {
                this.nG.onAdOpened();
                return;
            } catch (Throwable e) {
                dw.m8215c("Could not call onAdOpened.", e);
                return;
            }
        }
        dw.m8221z("onPresentScreen must be called on the main UI thread.");
        dv.rp.post(new C17747(this));
    }

    public void onPresentScreen(MediationInterstitialAdapter adapter) {
        dw.m8217v("Adapter called onPresentScreen.");
        if (dv.bD()) {
            try {
                this.nG.onAdOpened();
                return;
            } catch (Throwable e) {
                dw.m8215c("Could not call onAdOpened.", e);
                return;
            }
        }
        dw.m8221z("onPresentScreen must be called on the main UI thread.");
        dv.rp.post(new C17692(this));
    }

    public void onReceivedAd(MediationBannerAdapter adapter) {
        dw.m8217v("Adapter called onReceivedAd.");
        if (dv.bD()) {
            try {
                this.nG.onAdLoaded();
                return;
            } catch (Throwable e) {
                dw.m8215c("Could not call onAdLoaded.", e);
                return;
            }
        }
        dw.m8221z("onReceivedAd must be called on the main UI thread.");
        dv.rp.post(new C17758(this));
    }

    public void onReceivedAd(MediationInterstitialAdapter adapter) {
        dw.m8217v("Adapter called onReceivedAd.");
        if (dv.bD()) {
            try {
                this.nG.onAdLoaded();
                return;
            } catch (Throwable e) {
                dw.m8215c("Could not call onAdLoaded.", e);
                return;
            }
        }
        dw.m8221z("onReceivedAd must be called on the main UI thread.");
        dv.rp.post(new C17703(this));
    }
}
