package com.mopub.mobileads;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import com.google.android.gms.location.LocationStatusCodes;
import com.mopub.common.util.Json;
import com.mopub.mobileads.CustomEventBanner.CustomEventBannerListener;
import com.mopub.mobileads.factories.CustomEventBannerFactory;
import java.util.HashMap;
import java.util.Map;

public class CustomEventBannerAdapter implements CustomEventBannerListener {
    public static final int DEFAULT_BANNER_TIMEOUT_DELAY = 10000;
    private Context mContext;
    private CustomEventBanner mCustomEventBanner;
    private final Handler mHandler;
    private boolean mInvalidated;
    private Map mLocalExtras;
    private MoPubView mMoPubView;
    private Map mServerExtras;
    private boolean mStoredAutorefresh;
    private final Runnable mTimeout;

    /* renamed from: com.mopub.mobileads.CustomEventBannerAdapter.1 */
    class C25951 implements Runnable {
        C25951() {
        }

        public void run() {
            Log.d("MoPub", "Third-party network timed out.");
            CustomEventBannerAdapter.this.onBannerFailed(MoPubErrorCode.NETWORK_TIMEOUT);
            CustomEventBannerAdapter.this.invalidate();
        }
    }

    public CustomEventBannerAdapter(MoPubView moPubView, String className, String classData) {
        this.mHandler = new Handler();
        this.mMoPubView = moPubView;
        this.mContext = moPubView.getContext();
        this.mLocalExtras = new HashMap();
        this.mServerExtras = new HashMap();
        this.mTimeout = new C25951();
        Log.d("MoPub", "Attempting to invoke custom event: " + className);
        try {
            this.mCustomEventBanner = CustomEventBannerFactory.create(className);
            try {
                this.mServerExtras = Json.jsonStringToMap(classData);
            } catch (Exception exception) {
                Log.d("MoPub", "Failed to create Map from JSON: " + classData + exception.toString());
            }
            this.mLocalExtras = this.mMoPubView.getLocalExtras();
            if (this.mMoPubView.getLocation() != null) {
                this.mLocalExtras.put("location", this.mMoPubView.getLocation());
            }
            if (this.mMoPubView.getAdViewController() != null) {
                this.mLocalExtras.put(AdFetcher.AD_CONFIGURATION_KEY, this.mMoPubView.getAdViewController().getAdConfiguration());
            }
        } catch (Exception e) {
            Log.d("MoPub", "Couldn't locate or instantiate custom event: " + className + ".");
            this.mMoPubView.loadFailUrl(MoPubErrorCode.ADAPTER_NOT_FOUND);
        }
    }

    void loadAd() {
        if (!isInvalidated() && this.mCustomEventBanner != null) {
            if (getTimeoutDelayMilliseconds() > 0) {
                this.mHandler.postDelayed(this.mTimeout, (long) getTimeoutDelayMilliseconds());
            }
            this.mCustomEventBanner.loadBanner(this.mContext, this, this.mLocalExtras, this.mServerExtras);
        }
    }

    void invalidate() {
        if (this.mCustomEventBanner != null) {
            this.mCustomEventBanner.onInvalidate();
        }
        this.mContext = null;
        this.mCustomEventBanner = null;
        this.mLocalExtras = null;
        this.mServerExtras = null;
        this.mInvalidated = true;
    }

    boolean isInvalidated() {
        return this.mInvalidated;
    }

    private void cancelTimeout() {
        this.mHandler.removeCallbacks(this.mTimeout);
    }

    private int getTimeoutDelayMilliseconds() {
        if (this.mMoPubView == null || this.mMoPubView.getAdTimeoutDelay() == null || this.mMoPubView.getAdTimeoutDelay().intValue() < 0) {
            return DEFAULT_BANNER_TIMEOUT_DELAY;
        }
        return this.mMoPubView.getAdTimeoutDelay().intValue() * LocationStatusCodes.GEOFENCE_NOT_AVAILABLE;
    }

    public void onBannerLoaded(View bannerView) {
        if (!isInvalidated()) {
            cancelTimeout();
            if (this.mMoPubView != null) {
                this.mMoPubView.nativeAdLoaded();
                this.mMoPubView.setAdContentView(bannerView);
                if (!(bannerView instanceof HtmlBannerWebView)) {
                    this.mMoPubView.trackNativeImpression();
                }
            }
        }
    }

    public void onBannerFailed(MoPubErrorCode errorCode) {
        if (!isInvalidated() && this.mMoPubView != null) {
            if (errorCode == null) {
                errorCode = MoPubErrorCode.UNSPECIFIED;
            }
            cancelTimeout();
            this.mMoPubView.loadFailUrl(errorCode);
        }
    }

    public void onBannerExpanded() {
        if (!isInvalidated()) {
            this.mStoredAutorefresh = this.mMoPubView.getAutorefreshEnabled();
            this.mMoPubView.setAutorefreshEnabled(false);
            this.mMoPubView.adPresentedOverlay();
        }
    }

    public void onBannerCollapsed() {
        if (!isInvalidated()) {
            this.mMoPubView.setAutorefreshEnabled(this.mStoredAutorefresh);
            this.mMoPubView.adClosed();
        }
    }

    public void onBannerClicked() {
        if (!isInvalidated() && this.mMoPubView != null) {
            this.mMoPubView.registerClick();
        }
    }

    public void onLeaveApplication() {
        onBannerClicked();
    }
}
