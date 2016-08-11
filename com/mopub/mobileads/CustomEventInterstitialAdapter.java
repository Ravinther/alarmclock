package com.mopub.mobileads;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import com.google.android.gms.location.LocationStatusCodes;
import com.mopub.common.util.Json;
import com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener;
import com.mopub.mobileads.factories.CustomEventInterstitialFactory;
import java.util.HashMap;
import java.util.Map;

public class CustomEventInterstitialAdapter implements CustomEventInterstitialListener {
    public static final int DEFAULT_INTERSTITIAL_TIMEOUT_DELAY = 30000;
    private Context mContext;
    private CustomEventInterstitial mCustomEventInterstitial;
    private CustomEventInterstitialAdapterListener mCustomEventInterstitialAdapterListener;
    private final Handler mHandler;
    private boolean mInvalidated;
    private Map mLocalExtras;
    private final MoPubInterstitial mMoPubInterstitial;
    private Map mServerExtras;
    private final Runnable mTimeout;

    /* renamed from: com.mopub.mobileads.CustomEventInterstitialAdapter.1 */
    class C25961 implements Runnable {
        C25961() {
        }

        public void run() {
            Log.d("MoPub", "Third-party network timed out.");
            CustomEventInterstitialAdapter.this.onInterstitialFailed(MoPubErrorCode.NETWORK_TIMEOUT);
            CustomEventInterstitialAdapter.this.invalidate();
        }
    }

    interface CustomEventInterstitialAdapterListener {
        void onCustomEventInterstitialClicked();

        void onCustomEventInterstitialDismissed();

        void onCustomEventInterstitialFailed(MoPubErrorCode moPubErrorCode);

        void onCustomEventInterstitialLoaded();

        void onCustomEventInterstitialShown();
    }

    public CustomEventInterstitialAdapter(MoPubInterstitial moPubInterstitial, String className, String jsonParams) {
        this.mHandler = new Handler();
        this.mMoPubInterstitial = moPubInterstitial;
        this.mServerExtras = new HashMap();
        this.mLocalExtras = new HashMap();
        this.mContext = moPubInterstitial.getActivity();
        this.mTimeout = new C25961();
        Log.d("MoPub", "Attempting to invoke custom event: " + className);
        try {
            this.mCustomEventInterstitial = CustomEventInterstitialFactory.create(className);
        } catch (Exception e) {
            Log.d("MoPub", "Couldn't locate or instantiate custom event: " + className + ".");
            if (this.mCustomEventInterstitialAdapterListener != null) {
                this.mCustomEventInterstitialAdapterListener.onCustomEventInterstitialFailed(MoPubErrorCode.ADAPTER_NOT_FOUND);
            }
        }
        try {
            this.mServerExtras = Json.jsonStringToMap(jsonParams);
        } catch (Exception e2) {
            Log.d("MoPub", "Failed to create Map from JSON: " + jsonParams);
        }
        this.mLocalExtras = moPubInterstitial.getLocalExtras();
        if (moPubInterstitial.getLocation() != null) {
            this.mLocalExtras.put("location", moPubInterstitial.getLocation());
        }
        AdViewController adViewController = moPubInterstitial.getMoPubInterstitialView().getAdViewController();
        if (adViewController != null) {
            this.mLocalExtras.put(AdFetcher.AD_CONFIGURATION_KEY, adViewController.getAdConfiguration());
        }
    }

    void loadInterstitial() {
        if (!isInvalidated() && this.mCustomEventInterstitial != null) {
            if (getTimeoutDelayMilliseconds() > 0) {
                this.mHandler.postDelayed(this.mTimeout, (long) getTimeoutDelayMilliseconds());
            }
            this.mCustomEventInterstitial.loadInterstitial(this.mContext, this, this.mLocalExtras, this.mServerExtras);
        }
    }

    void showInterstitial() {
        if (!isInvalidated() && this.mCustomEventInterstitial != null) {
            this.mCustomEventInterstitial.showInterstitial();
        }
    }

    void invalidate() {
        if (this.mCustomEventInterstitial != null) {
            this.mCustomEventInterstitial.onInvalidate();
        }
        this.mCustomEventInterstitial = null;
        this.mContext = null;
        this.mServerExtras = null;
        this.mLocalExtras = null;
        this.mCustomEventInterstitialAdapterListener = null;
        this.mInvalidated = true;
    }

    boolean isInvalidated() {
        return this.mInvalidated;
    }

    void setAdapterListener(CustomEventInterstitialAdapterListener listener) {
        this.mCustomEventInterstitialAdapterListener = listener;
    }

    private void cancelTimeout() {
        this.mHandler.removeCallbacks(this.mTimeout);
    }

    private int getTimeoutDelayMilliseconds() {
        if (this.mMoPubInterstitial == null || this.mMoPubInterstitial.getAdTimeoutDelay() == null || this.mMoPubInterstitial.getAdTimeoutDelay().intValue() < 0) {
            return DEFAULT_INTERSTITIAL_TIMEOUT_DELAY;
        }
        return this.mMoPubInterstitial.getAdTimeoutDelay().intValue() * LocationStatusCodes.GEOFENCE_NOT_AVAILABLE;
    }

    public void onInterstitialLoaded() {
        if (!isInvalidated()) {
            cancelTimeout();
            if (this.mCustomEventInterstitialAdapterListener != null) {
                this.mCustomEventInterstitialAdapterListener.onCustomEventInterstitialLoaded();
            }
        }
    }

    public void onInterstitialFailed(MoPubErrorCode errorCode) {
        if (!isInvalidated() && this.mCustomEventInterstitialAdapterListener != null) {
            if (errorCode == null) {
                errorCode = MoPubErrorCode.UNSPECIFIED;
            }
            cancelTimeout();
            this.mCustomEventInterstitialAdapterListener.onCustomEventInterstitialFailed(errorCode);
        }
    }

    public void onInterstitialShown() {
        if (!isInvalidated() && this.mCustomEventInterstitialAdapterListener != null) {
            this.mCustomEventInterstitialAdapterListener.onCustomEventInterstitialShown();
        }
    }

    public void onInterstitialClicked() {
        if (!isInvalidated() && this.mCustomEventInterstitialAdapterListener != null) {
            this.mCustomEventInterstitialAdapterListener.onCustomEventInterstitialClicked();
        }
    }

    public void onLeaveApplication() {
        onInterstitialClicked();
    }

    public void onInterstitialDismissed() {
        if (!isInvalidated() && this.mCustomEventInterstitialAdapterListener != null) {
            this.mCustomEventInterstitialAdapterListener.onCustomEventInterstitialDismissed();
        }
    }

    @Deprecated
    void setCustomEventInterstitial(CustomEventInterstitial interstitial) {
        this.mCustomEventInterstitial = interstitial;
    }
}
