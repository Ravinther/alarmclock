package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.util.Log;
import com.mopub.common.LocationService.LocationAwareness;
import com.mopub.common.util.ResponseHeader;
import com.mopub.mobileads.factories.CustomEventInterstitialAdapterFactory;
import com.mopub.mobileads.util.Base64;
import java.util.Map;

public class MoPubInterstitial implements CustomEventInterstitialAdapterListener {
    private Activity mActivity;
    private String mAdUnitId;
    private InterstitialState mCurrentInterstitialState;
    private CustomEventInterstitialAdapter mCustomEventInterstitialAdapter;
    private InterstitialAdListener mInterstitialAdListener;
    private MoPubInterstitialView mInterstitialView;
    private boolean mIsDestroyed;
    private MoPubInterstitialListener mListener;

    public interface InterstitialAdListener {
        void onInterstitialClicked(MoPubInterstitial moPubInterstitial);

        void onInterstitialDismissed(MoPubInterstitial moPubInterstitial);

        void onInterstitialFailed(MoPubInterstitial moPubInterstitial, MoPubErrorCode moPubErrorCode);

        void onInterstitialLoaded(MoPubInterstitial moPubInterstitial);

        void onInterstitialShown(MoPubInterstitial moPubInterstitial);
    }

    /* renamed from: com.mopub.mobileads.MoPubInterstitial.1 */
    static /* synthetic */ class C26041 {
        static final /* synthetic */ int[] f4306xe6f223c6;

        static {
            f4306xe6f223c6 = new int[InterstitialState.values().length];
            try {
                f4306xe6f223c6[InterstitialState.CUSTOM_EVENT_AD_READY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
        }
    }

    private enum InterstitialState {
        CUSTOM_EVENT_AD_READY,
        NOT_READY;

        boolean isReady() {
            return this != NOT_READY;
        }
    }

    @Deprecated
    public interface MoPubInterstitialListener {
        void OnInterstitialFailed();

        void OnInterstitialLoaded();
    }

    public class MoPubInterstitialView extends MoPubView {
        public MoPubInterstitialView(Context context) {
            super(context);
            setAutorefreshEnabled(false);
        }

        protected void loadCustomEvent(Map paramsMap) {
            if (paramsMap == null) {
                Log.d("MoPub", "Couldn't invoke custom event because the server did not specify one.");
                loadFailUrl(MoPubErrorCode.ADAPTER_NOT_FOUND);
                return;
            }
            if (MoPubInterstitial.this.mCustomEventInterstitialAdapter != null) {
                MoPubInterstitial.this.mCustomEventInterstitialAdapter.invalidate();
            }
            Log.d("MoPub", "Loading custom event interstitial adapter.");
            MoPubInterstitial.this.mCustomEventInterstitialAdapter = CustomEventInterstitialAdapterFactory.create(MoPubInterstitial.this, (String) paramsMap.get(ResponseHeader.CUSTOM_EVENT_NAME.getKey()), (String) paramsMap.get(ResponseHeader.CUSTOM_EVENT_DATA.getKey()));
            MoPubInterstitial.this.mCustomEventInterstitialAdapter.setAdapterListener(MoPubInterstitial.this);
            MoPubInterstitial.this.mCustomEventInterstitialAdapter.loadInterstitial();
        }

        protected void trackImpression() {
            Log.d("MoPub", "Tracking impression for interstitial.");
            if (this.mAdViewController != null) {
                this.mAdViewController.trackImpression();
            }
        }

        protected void adFailed(MoPubErrorCode errorCode) {
            if (MoPubInterstitial.this.mInterstitialAdListener != null) {
                MoPubInterstitial.this.mInterstitialAdListener.onInterstitialFailed(MoPubInterstitial.this, errorCode);
            }
        }
    }

    public MoPubInterstitial(Activity activity, String id) {
        this.mActivity = activity;
        this.mAdUnitId = id;
        this.mInterstitialView = new MoPubInterstitialView(this.mActivity);
        this.mInterstitialView.setAdUnitId(this.mAdUnitId);
        this.mCurrentInterstitialState = InterstitialState.NOT_READY;
    }

    public void load() {
        resetCurrentInterstitial();
        this.mInterstitialView.loadAd();
    }

    public void forceRefresh() {
        resetCurrentInterstitial();
        this.mInterstitialView.forceRefresh();
    }

    private void resetCurrentInterstitial() {
        this.mCurrentInterstitialState = InterstitialState.NOT_READY;
        if (this.mCustomEventInterstitialAdapter != null) {
            this.mCustomEventInterstitialAdapter.invalidate();
            this.mCustomEventInterstitialAdapter = null;
        }
        this.mIsDestroyed = false;
    }

    public boolean isReady() {
        return this.mCurrentInterstitialState.isReady();
    }

    boolean isDestroyed() {
        return this.mIsDestroyed;
    }

    public boolean show() {
        switch (C26041.f4306xe6f223c6[this.mCurrentInterstitialState.ordinal()]) {
            case Base64.NO_PADDING /*1*/:
                showCustomEventInterstitial();
                return true;
            default:
                return false;
        }
    }

    private void showCustomEventInterstitial() {
        if (this.mCustomEventInterstitialAdapter != null) {
            this.mCustomEventInterstitialAdapter.showInterstitial();
        }
    }

    Integer getAdTimeoutDelay() {
        return this.mInterstitialView.getAdTimeoutDelay();
    }

    MoPubInterstitialView getMoPubInterstitialView() {
        return this.mInterstitialView;
    }

    public void setKeywords(String keywords) {
        this.mInterstitialView.setKeywords(keywords);
    }

    public String getKeywords() {
        return this.mInterstitialView.getKeywords();
    }

    public void setFacebookSupported(boolean enabled) {
        this.mInterstitialView.setFacebookSupported(enabled);
    }

    public boolean isFacebookSupported() {
        return this.mInterstitialView.isFacebookSupported();
    }

    public Activity getActivity() {
        return this.mActivity;
    }

    public Location getLocation() {
        return this.mInterstitialView.getLocation();
    }

    public void destroy() {
        this.mIsDestroyed = true;
        if (this.mCustomEventInterstitialAdapter != null) {
            this.mCustomEventInterstitialAdapter.invalidate();
            this.mCustomEventInterstitialAdapter = null;
        }
        this.mInterstitialView.setBannerAdListener(null);
        this.mInterstitialView.destroy();
    }

    public void setInterstitialAdListener(InterstitialAdListener listener) {
        this.mInterstitialAdListener = listener;
    }

    public InterstitialAdListener getInterstitialAdListener() {
        return this.mInterstitialAdListener;
    }

    public void setLocationAwareness(LocationAwareness awareness) {
        this.mInterstitialView.setLocationAwareness(awareness);
    }

    public LocationAwareness getLocationAwareness() {
        return this.mInterstitialView.getLocationAwareness();
    }

    public void setLocationPrecision(int precision) {
        this.mInterstitialView.setLocationPrecision(precision);
    }

    public int getLocationPrecision() {
        return this.mInterstitialView.getLocationPrecision();
    }

    public void setTesting(boolean testing) {
        this.mInterstitialView.setTesting(testing);
    }

    public boolean getTesting() {
        return this.mInterstitialView.getTesting();
    }

    public void setLocalExtras(Map extras) {
        this.mInterstitialView.setLocalExtras(extras);
    }

    public Map getLocalExtras() {
        return this.mInterstitialView.getLocalExtras();
    }

    public void onCustomEventInterstitialLoaded() {
        if (!this.mIsDestroyed) {
            this.mCurrentInterstitialState = InterstitialState.CUSTOM_EVENT_AD_READY;
            if (this.mInterstitialAdListener != null) {
                this.mInterstitialAdListener.onInterstitialLoaded(this);
            } else if (this.mListener != null) {
                this.mListener.OnInterstitialLoaded();
            }
        }
    }

    public void onCustomEventInterstitialFailed(MoPubErrorCode errorCode) {
        if (!isDestroyed()) {
            this.mCurrentInterstitialState = InterstitialState.NOT_READY;
            this.mInterstitialView.loadFailUrl(errorCode);
        }
    }

    public void onCustomEventInterstitialShown() {
        if (!isDestroyed()) {
            this.mInterstitialView.trackImpression();
            if (this.mInterstitialAdListener != null) {
                this.mInterstitialAdListener.onInterstitialShown(this);
            }
        }
    }

    public void onCustomEventInterstitialClicked() {
        if (!isDestroyed()) {
            this.mInterstitialView.registerClick();
            if (this.mInterstitialAdListener != null) {
                this.mInterstitialAdListener.onInterstitialClicked(this);
            }
        }
    }

    public void onCustomEventInterstitialDismissed() {
        if (!isDestroyed()) {
            this.mCurrentInterstitialState = InterstitialState.NOT_READY;
            if (this.mInterstitialAdListener != null) {
                this.mInterstitialAdListener.onInterstitialDismissed(this);
            }
        }
    }

    @Deprecated
    void setInterstitialView(MoPubInterstitialView interstitialView) {
        this.mInterstitialView = interstitialView;
    }

    @Deprecated
    public void setListener(MoPubInterstitialListener listener) {
        this.mListener = listener;
    }

    @Deprecated
    public MoPubInterstitialListener getListener() {
        return this.mListener;
    }

    @Deprecated
    public void customEventDidLoadAd() {
        if (this.mInterstitialView != null) {
            this.mInterstitialView.trackImpression();
        }
    }

    @Deprecated
    public void customEventDidFailToLoadAd() {
        if (this.mInterstitialView != null) {
            this.mInterstitialView.loadFailUrl(MoPubErrorCode.UNSPECIFIED);
        }
    }

    @Deprecated
    public void customEventActionWillBegin() {
        if (this.mInterstitialView != null) {
            this.mInterstitialView.registerClick();
        }
    }
}
