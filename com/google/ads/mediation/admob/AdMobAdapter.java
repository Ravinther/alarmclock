package com.google.ads.mediation.admob;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.internal.dv;
import java.util.Date;
import java.util.Set;

public final class AdMobAdapter implements MediationBannerAdapter, MediationInterstitialAdapter {
    private AdView f4015i;
    private InterstitialAd f4016j;

    /* renamed from: com.google.ads.mediation.admob.AdMobAdapter.a */
    private static final class C1311a extends AdListener {
        private final AdMobAdapter f4011k;
        private final MediationBannerListener f4012l;

        public C1311a(AdMobAdapter adMobAdapter, MediationBannerListener mediationBannerListener) {
            this.f4011k = adMobAdapter;
            this.f4012l = mediationBannerListener;
        }

        public void onAdClosed() {
            this.f4012l.onAdClosed(this.f4011k);
        }

        public void onAdFailedToLoad(int errorCode) {
            this.f4012l.onAdFailedToLoad(this.f4011k, errorCode);
        }

        public void onAdLeftApplication() {
            this.f4012l.onAdLeftApplication(this.f4011k);
        }

        public void onAdLoaded() {
            this.f4012l.onAdLoaded(this.f4011k);
        }

        public void onAdOpened() {
            this.f4012l.onAdClicked(this.f4011k);
            this.f4012l.onAdOpened(this.f4011k);
        }
    }

    /* renamed from: com.google.ads.mediation.admob.AdMobAdapter.b */
    private static final class C1312b extends AdListener {
        private final AdMobAdapter f4013k;
        private final MediationInterstitialListener f4014m;

        public C1312b(AdMobAdapter adMobAdapter, MediationInterstitialListener mediationInterstitialListener) {
            this.f4013k = adMobAdapter;
            this.f4014m = mediationInterstitialListener;
        }

        public void onAdClosed() {
            this.f4014m.onAdClosed(this.f4013k);
        }

        public void onAdFailedToLoad(int errorCode) {
            this.f4014m.onAdFailedToLoad(this.f4013k, errorCode);
        }

        public void onAdLeftApplication() {
            this.f4014m.onAdLeftApplication(this.f4013k);
        }

        public void onAdLoaded() {
            this.f4014m.onAdLoaded(this.f4013k);
        }

        public void onAdOpened() {
            this.f4014m.onAdOpened(this.f4013k);
        }
    }

    private static AdRequest m5553a(Context context, MediationAdRequest mediationAdRequest, Bundle bundle, Bundle bundle2) {
        Builder builder = new Builder();
        Date birthday = mediationAdRequest.getBirthday();
        if (birthday != null) {
            builder.setBirthday(birthday);
        }
        int gender = mediationAdRequest.getGender();
        if (gender != 0) {
            builder.setGender(gender);
        }
        Set<String> keywords = mediationAdRequest.getKeywords();
        if (keywords != null) {
            for (String addKeyword : keywords) {
                builder.addKeyword(addKeyword);
            }
        }
        if (mediationAdRequest.isTesting()) {
            builder.addTestDevice(dv.m8211l(context));
        }
        if (bundle2.getInt("tagForChildDirectedTreatment") != -1) {
            builder.tagForChildDirectedTreatment(bundle2.getInt("tagForChildDirectedTreatment") == 1);
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putInt("gw", 1);
        bundle.putString("mad_hac", bundle2.getString("mad_hac"));
        if (!TextUtils.isEmpty(bundle2.getString("adJson"))) {
            bundle.putString("_ad", bundle2.getString("adJson"));
        }
        bundle.putBoolean("_noRefresh", true);
        builder.addNetworkExtrasBundle(AdMobAdapter.class, bundle);
        return builder.build();
    }

    public View getBannerView() {
        return this.f4015i;
    }

    public void onDestroy() {
        if (this.f4015i != null) {
            this.f4015i.destroy();
            this.f4015i = null;
        }
        if (this.f4016j != null) {
            this.f4016j = null;
        }
    }

    public void onPause() {
        if (this.f4015i != null) {
            this.f4015i.pause();
        }
    }

    public void onResume() {
        if (this.f4015i != null) {
            this.f4015i.resume();
        }
    }

    public void requestBannerAd(Context context, MediationBannerListener bannerListener, Bundle serverParameters, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle extras) {
        this.f4015i = new AdView(context);
        this.f4015i.setAdSize(new AdSize(adSize.getWidth(), adSize.getHeight()));
        this.f4015i.setAdUnitId(serverParameters.getString("pubid"));
        this.f4015i.setAdListener(new C1311a(this, bannerListener));
        this.f4015i.loadAd(m5553a(context, mediationAdRequest, extras, serverParameters));
    }

    public void requestInterstitialAd(Context context, MediationInterstitialListener interstitialListener, Bundle serverParameters, MediationAdRequest mediationAdRequest, Bundle extras) {
        this.f4016j = new InterstitialAd(context);
        this.f4016j.setAdUnitId(serverParameters.getString("pubid"));
        this.f4016j.setAdListener(new C1312b(this, interstitialListener));
        this.f4016j.loadAd(m5553a(context, mediationAdRequest, extras, serverParameters));
    }

    public void showInterstitial() {
        this.f4016j.show();
    }
}
