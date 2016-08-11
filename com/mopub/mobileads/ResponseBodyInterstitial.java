package com.mopub.mobileads;

import android.content.Context;
import com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener;
import java.util.Map;

abstract class ResponseBodyInterstitial extends CustomEventInterstitial {
    protected AdConfiguration mAdConfiguration;
    long mBroadcastIdentifier;
    private EventForwardingBroadcastReceiver mBroadcastReceiver;
    protected Context mContext;

    protected abstract void extractExtras(Map map);

    protected abstract void preRenderHtml(CustomEventInterstitialListener customEventInterstitialListener);

    protected abstract void showInterstitial();

    ResponseBodyInterstitial() {
    }

    protected void loadInterstitial(Context context, CustomEventInterstitialListener customEventInterstitialListener, Map localExtras, Map serverExtras) {
        this.mContext = context;
        if (extrasAreValid(serverExtras)) {
            extractExtras(serverExtras);
            this.mAdConfiguration = AdConfiguration.extractFromMap(localExtras);
            if (this.mAdConfiguration != null) {
                this.mBroadcastIdentifier = this.mAdConfiguration.getBroadcastIdentifier();
            }
            this.mBroadcastReceiver = new EventForwardingBroadcastReceiver(customEventInterstitialListener, this.mBroadcastIdentifier);
            this.mBroadcastReceiver.register(context);
            preRenderHtml(customEventInterstitialListener);
            return;
        }
        customEventInterstitialListener.onInterstitialFailed(MoPubErrorCode.NETWORK_INVALID_STATE);
    }

    protected void onInvalidate() {
        if (this.mBroadcastReceiver != null) {
            this.mBroadcastReceiver.unregister();
        }
    }

    private boolean extrasAreValid(Map serverExtras) {
        return serverExtras.containsKey(AdFetcher.HTML_RESPONSE_BODY_KEY);
    }
}
