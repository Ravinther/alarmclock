package com.google.ads.mediation.customevent;

import android.app.Activity;
import android.view.View;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.customevent.CustomEventExtras;
import com.google.android.gms.internal.dw;

public final class CustomEventAdapter implements MediationBannerAdapter, MediationInterstitialAdapter {
    private View f4022n;
    private CustomEventBanner f4023o;
    private CustomEventInterstitial f4024p;

    /* renamed from: com.google.ads.mediation.customevent.CustomEventAdapter.a */
    private static final class C1313a implements CustomEventBannerListener {
        private final CustomEventAdapter f4017q;
        private final MediationBannerListener f4018r;

        public C1313a(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
            this.f4017q = customEventAdapter;
            this.f4018r = mediationBannerListener;
        }

        public void onClick() {
            dw.m8217v("Custom event adapter called onFailedToReceiveAd.");
            this.f4018r.onClick(this.f4017q);
        }

        public void onDismissScreen() {
            dw.m8217v("Custom event adapter called onFailedToReceiveAd.");
            this.f4018r.onDismissScreen(this.f4017q);
        }

        public void onFailedToReceiveAd() {
            dw.m8217v("Custom event adapter called onFailedToReceiveAd.");
            this.f4018r.onFailedToReceiveAd(this.f4017q, ErrorCode.NO_FILL);
        }

        public void onLeaveApplication() {
            dw.m8217v("Custom event adapter called onFailedToReceiveAd.");
            this.f4018r.onLeaveApplication(this.f4017q);
        }

        public void onPresentScreen() {
            dw.m8217v("Custom event adapter called onFailedToReceiveAd.");
            this.f4018r.onPresentScreen(this.f4017q);
        }

        public void onReceivedAd(View view) {
            dw.m8217v("Custom event adapter called onReceivedAd.");
            this.f4017q.m5555a(view);
            this.f4018r.onReceivedAd(this.f4017q);
        }
    }

    /* renamed from: com.google.ads.mediation.customevent.CustomEventAdapter.b */
    private class C1314b implements CustomEventInterstitialListener {
        private final CustomEventAdapter f4019q;
        private final MediationInterstitialListener f4020s;
        final /* synthetic */ CustomEventAdapter f4021t;

        public C1314b(CustomEventAdapter customEventAdapter, CustomEventAdapter customEventAdapter2, MediationInterstitialListener mediationInterstitialListener) {
            this.f4021t = customEventAdapter;
            this.f4019q = customEventAdapter2;
            this.f4020s = mediationInterstitialListener;
        }

        public void onDismissScreen() {
            dw.m8217v("Custom event adapter called onDismissScreen.");
            this.f4020s.onDismissScreen(this.f4019q);
        }

        public void onFailedToReceiveAd() {
            dw.m8217v("Custom event adapter called onFailedToReceiveAd.");
            this.f4020s.onFailedToReceiveAd(this.f4019q, ErrorCode.NO_FILL);
        }

        public void onLeaveApplication() {
            dw.m8217v("Custom event adapter called onLeaveApplication.");
            this.f4020s.onLeaveApplication(this.f4019q);
        }

        public void onPresentScreen() {
            dw.m8217v("Custom event adapter called onPresentScreen.");
            this.f4020s.onPresentScreen(this.f4019q);
        }

        public void onReceivedAd() {
            dw.m8217v("Custom event adapter called onReceivedAd.");
            this.f4020s.onReceivedAd(this.f4021t);
        }
    }

    private static Object m5554a(String str) {
        try {
            return Class.forName(str).newInstance();
        } catch (Throwable th) {
            dw.m8221z("Could not instantiate custom event adapter: " + str + ". " + th.getMessage());
            return null;
        }
    }

    private void m5555a(View view) {
        this.f4022n = view;
    }

    public void destroy() {
        if (this.f4023o != null) {
            this.f4023o.destroy();
        }
        if (this.f4024p != null) {
            this.f4024p.destroy();
        }
    }

    public Class getAdditionalParametersType() {
        return CustomEventExtras.class;
    }

    public View getBannerView() {
        return this.f4022n;
    }

    public Class getServerParametersType() {
        return CustomEventServerParameters.class;
    }

    public void requestBannerAd(MediationBannerListener listener, Activity activity, CustomEventServerParameters serverParameters, AdSize adSize, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        this.f4023o = (CustomEventBanner) m5554a(serverParameters.className);
        if (this.f4023o == null) {
            listener.onFailedToReceiveAd(this, ErrorCode.INTERNAL_ERROR);
        } else {
            this.f4023o.requestBannerAd(new C1313a(this, listener), activity, serverParameters.label, serverParameters.parameter, adSize, mediationAdRequest, customEventExtras == null ? null : customEventExtras.getExtra(serverParameters.label));
        }
    }

    public void requestInterstitialAd(MediationInterstitialListener listener, Activity activity, CustomEventServerParameters serverParameters, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        this.f4024p = (CustomEventInterstitial) m5554a(serverParameters.className);
        if (this.f4024p == null) {
            listener.onFailedToReceiveAd(this, ErrorCode.INTERNAL_ERROR);
        } else {
            this.f4024p.requestInterstitialAd(new C1314b(this, this, listener), activity, serverParameters.label, serverParameters.parameter, mediationAdRequest, customEventExtras == null ? null : customEventExtras.getExtra(serverParameters.label));
        }
    }

    public void showInterstitial() {
        this.f4024p.showInterstitial();
    }
}
