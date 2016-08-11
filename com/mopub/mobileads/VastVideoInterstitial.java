package com.mopub.mobileads;

import android.net.Uri;
import com.mopub.common.CacheService;
import com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener;
import com.mopub.mobileads.factories.VastManagerFactory;
import com.mopub.mobileads.util.vast.VastManager;
import com.mopub.mobileads.util.vast.VastManager.VastManagerListener;
import com.mopub.mobileads.util.vast.VastVideoConfiguration;
import java.util.Map;

class VastVideoInterstitial extends ResponseBodyInterstitial implements VastManagerListener {
    private CustomEventInterstitialListener mCustomEventInterstitialListener;
    private VastManager mVastManager;
    private String mVastResponse;
    private VastVideoConfiguration mVastVideoConfiguration;

    VastVideoInterstitial() {
    }

    protected void extractExtras(Map serverExtras) {
        this.mVastResponse = Uri.decode((String) serverExtras.get(AdFetcher.HTML_RESPONSE_BODY_KEY));
    }

    protected void preRenderHtml(CustomEventInterstitialListener customEventInterstitialListener) {
        this.mCustomEventInterstitialListener = customEventInterstitialListener;
        if (CacheService.initializeDiskCache(this.mContext)) {
            this.mVastManager = VastManagerFactory.create(this.mContext);
            this.mVastManager.prepareVastVideoConfiguration(this.mVastResponse, this);
            return;
        }
        this.mCustomEventInterstitialListener.onInterstitialFailed(MoPubErrorCode.VIDEO_CACHE_ERROR);
    }

    protected void showInterstitial() {
        BaseVideoPlayerActivity.startVast(this.mContext, this.mVastVideoConfiguration, this.mAdConfiguration);
    }

    protected void onInvalidate() {
        if (this.mVastManager != null) {
            this.mVastManager.cancel();
        }
        super.onInvalidate();
    }

    public void onVastVideoConfigurationPrepared(VastVideoConfiguration vastVideoConfiguration) {
        if (vastVideoConfiguration == null) {
            this.mCustomEventInterstitialListener.onInterstitialFailed(MoPubErrorCode.VIDEO_DOWNLOAD_ERROR);
            return;
        }
        this.mVastVideoConfiguration = vastVideoConfiguration;
        this.mCustomEventInterstitialListener.onInterstitialLoaded();
    }

    @Deprecated
    String getVastResponse() {
        return this.mVastResponse;
    }

    @Deprecated
    void setVastManager(VastManager vastManager) {
        this.mVastManager = vastManager;
    }
}
