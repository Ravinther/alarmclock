package com.mopub.mobileads;

import android.content.Context;
import java.util.Map;

public abstract class CustomEventInterstitial {

    public interface CustomEventInterstitialListener {
        void onInterstitialClicked();

        void onInterstitialDismissed();

        void onInterstitialFailed(MoPubErrorCode moPubErrorCode);

        void onInterstitialLoaded();

        void onInterstitialShown();

        void onLeaveApplication();
    }

    protected abstract void loadInterstitial(Context context, CustomEventInterstitialListener customEventInterstitialListener, Map map, Map map2);

    protected abstract void onInvalidate();

    protected abstract void showInterstitial();
}
