package com.mopub.mobileads;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.webkit.WebViewDatabase;
import android.widget.FrameLayout;
import com.mopub.common.LocationService.LocationAwareness;
import com.mopub.common.util.ManifestUtils;
import com.mopub.common.util.ResponseHeader;
import com.mopub.mobileads.factories.AdViewControllerFactory;
import com.mopub.mobileads.factories.CustomEventBannerAdapterFactory;
import java.util.Collections;
import java.util.Map;

public class MoPubView extends FrameLayout {
    public static final String AD_HANDLER = "/m/ad";
    public static final int DEFAULT_LOCATION_PRECISION = 6;
    public static final String HOST = "ads.mopub.com";
    public static final String HOST_FOR_TESTING = "testing.ads.mopub.com";
    protected AdViewController mAdViewController;
    private BannerAdListener mBannerAdListener;
    private Context mContext;
    protected CustomEventBannerAdapter mCustomEventBannerAdapter;
    private boolean mIsInForeground;
    private LocationAwareness mLocationAwareness;
    private OnAdClickedListener mOnAdClickedListener;
    private OnAdClosedListener mOnAdClosedListener;
    private OnAdFailedListener mOnAdFailedListener;
    private OnAdLoadedListener mOnAdLoadedListener;
    private OnAdPresentedOverlayListener mOnAdPresentedOverlayListener;
    private OnAdWillLoadListener mOnAdWillLoadListener;
    private BroadcastReceiver mScreenStateReceiver;

    public interface BannerAdListener {
        void onBannerClicked(MoPubView moPubView);

        void onBannerCollapsed(MoPubView moPubView);

        void onBannerExpanded(MoPubView moPubView);

        void onBannerFailed(MoPubView moPubView, MoPubErrorCode moPubErrorCode);

        void onBannerLoaded(MoPubView moPubView);
    }

    /* renamed from: com.mopub.mobileads.MoPubView.1 */
    class C26051 extends BroadcastReceiver {
        C26051() {
        }

        public void onReceive(Context context, Intent intent) {
            if (MoPubView.this.mIsInForeground && intent != null) {
                String action = intent.getAction();
                if ("android.intent.action.USER_PRESENT".equals(action)) {
                    MoPubView.this.setAdVisibility(true);
                } else if ("android.intent.action.SCREEN_OFF".equals(action)) {
                    MoPubView.this.setAdVisibility(false);
                }
            }
        }
    }

    @Deprecated
    public interface OnAdClickedListener {
        void OnAdClicked(MoPubView moPubView);
    }

    @Deprecated
    public interface OnAdClosedListener {
        void OnAdClosed(MoPubView moPubView);
    }

    @Deprecated
    public interface OnAdFailedListener {
        void OnAdFailed(MoPubView moPubView);
    }

    @Deprecated
    public interface OnAdLoadedListener {
        void OnAdLoaded(MoPubView moPubView);
    }

    @Deprecated
    public interface OnAdPresentedOverlayListener {
        void OnAdPresentedOverlay(MoPubView moPubView);
    }

    @Deprecated
    public interface OnAdWillLoadListener {
        void OnAdWillLoad(MoPubView moPubView, String str);
    }

    public MoPubView(Context context) {
        this(context, null);
    }

    public MoPubView(Context context, AttributeSet attrs) {
        super(context, attrs);
        ManifestUtils.checkWebViewActivitiesDeclared(context);
        this.mContext = context;
        this.mIsInForeground = getVisibility() == 0;
        this.mLocationAwareness = LocationAwareness.NORMAL;
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        if (WebViewDatabase.getInstance(context) == null) {
            Log.e("MoPub", "Disabling MoPub. Local cache file is inaccessible so MoPub will fail if we try to create a WebView. Details of this Android bug found at:http://code.google.com/p/android/issues/detail?id=10789");
            return;
        }
        this.mAdViewController = AdViewControllerFactory.create(context, this);
        registerScreenStateBroadcastReceiver();
    }

    private void registerScreenStateBroadcastReceiver() {
        this.mScreenStateReceiver = new C26051();
        IntentFilter filter = new IntentFilter("android.intent.action.SCREEN_OFF");
        filter.addAction("android.intent.action.USER_PRESENT");
        this.mContext.registerReceiver(this.mScreenStateReceiver, filter);
    }

    private void unregisterScreenStateBroadcastReceiver() {
        try {
            this.mContext.unregisterReceiver(this.mScreenStateReceiver);
        } catch (Exception e) {
            Log.d("MoPub", "Failed to unregister screen state broadcast receiver (never registered).");
        }
    }

    public void loadAd() {
        if (this.mAdViewController != null) {
            this.mAdViewController.loadAd();
        }
    }

    public void destroy() {
        unregisterScreenStateBroadcastReceiver();
        removeAllViews();
        if (this.mAdViewController != null) {
            this.mAdViewController.cleanup();
            this.mAdViewController = null;
        }
        if (this.mCustomEventBannerAdapter != null) {
            this.mCustomEventBannerAdapter.invalidate();
            this.mCustomEventBannerAdapter = null;
        }
    }

    Integer getAdTimeoutDelay() {
        return this.mAdViewController != null ? this.mAdViewController.getAdTimeoutDelay() : null;
    }

    protected void loadFailUrl(MoPubErrorCode errorCode) {
        if (this.mAdViewController != null) {
            this.mAdViewController.loadFailUrl(errorCode);
        }
    }

    protected void loadCustomEvent(Map paramsMap) {
        if (paramsMap == null) {
            Log.d("MoPub", "Couldn't invoke custom event because the server did not specify one.");
            loadFailUrl(MoPubErrorCode.ADAPTER_NOT_FOUND);
            return;
        }
        if (this.mCustomEventBannerAdapter != null) {
            this.mCustomEventBannerAdapter.invalidate();
        }
        Log.d("MoPub", "Loading custom event adapter.");
        this.mCustomEventBannerAdapter = CustomEventBannerAdapterFactory.create(this, (String) paramsMap.get(ResponseHeader.CUSTOM_EVENT_NAME.getKey()), (String) paramsMap.get(ResponseHeader.CUSTOM_EVENT_DATA.getKey()));
        this.mCustomEventBannerAdapter.loadAd();
    }

    protected void registerClick() {
        if (this.mAdViewController != null) {
            this.mAdViewController.registerClick();
            adClicked();
        }
    }

    protected void trackNativeImpression() {
        Log.d("MoPub", "Tracking impression for native adapter.");
        if (this.mAdViewController != null) {
            this.mAdViewController.trackImpression();
        }
    }

    protected void onWindowVisibilityChanged(int visibility) {
        boolean isVisible = visibility == 0;
        this.mIsInForeground = isVisible;
        setAdVisibility(isVisible);
    }

    private void setAdVisibility(boolean isVisible) {
        if (this.mAdViewController != null) {
            if (isVisible) {
                this.mAdViewController.unpauseRefresh();
            } else {
                this.mAdViewController.pauseRefresh();
            }
        }
    }

    protected void adLoaded() {
        Log.d("MoPub", "adLoaded");
        if (this.mBannerAdListener != null) {
            this.mBannerAdListener.onBannerLoaded(this);
        } else if (this.mOnAdLoadedListener != null) {
            this.mOnAdLoadedListener.OnAdLoaded(this);
        }
    }

    protected void adFailed(MoPubErrorCode errorCode) {
        if (this.mBannerAdListener != null) {
            this.mBannerAdListener.onBannerFailed(this, errorCode);
        } else if (this.mOnAdFailedListener != null) {
            this.mOnAdFailedListener.OnAdFailed(this);
        }
    }

    protected void adPresentedOverlay() {
        if (this.mBannerAdListener != null) {
            this.mBannerAdListener.onBannerExpanded(this);
        } else if (this.mOnAdPresentedOverlayListener != null) {
            this.mOnAdPresentedOverlayListener.OnAdPresentedOverlay(this);
        }
    }

    protected void adClosed() {
        if (this.mBannerAdListener != null) {
            this.mBannerAdListener.onBannerCollapsed(this);
        } else if (this.mOnAdClosedListener != null) {
            this.mOnAdClosedListener.OnAdClosed(this);
        }
    }

    protected void adClicked() {
        if (this.mBannerAdListener != null) {
            this.mBannerAdListener.onBannerClicked(this);
        } else if (this.mOnAdClickedListener != null) {
            this.mOnAdClickedListener.OnAdClicked(this);
        }
    }

    protected void nativeAdLoaded() {
        if (this.mAdViewController != null) {
            this.mAdViewController.scheduleRefreshTimerIfEnabled();
        }
        adLoaded();
    }

    public void setAdUnitId(String adUnitId) {
        if (this.mAdViewController != null) {
            this.mAdViewController.setAdUnitId(adUnitId);
        }
    }

    public String getAdUnitId() {
        return this.mAdViewController != null ? this.mAdViewController.getAdUnitId() : null;
    }

    public void setKeywords(String keywords) {
        if (this.mAdViewController != null) {
            this.mAdViewController.setKeywords(keywords);
        }
    }

    public String getKeywords() {
        return this.mAdViewController != null ? this.mAdViewController.getKeywords() : null;
    }

    public void setFacebookSupported(boolean enabled) {
        if (this.mAdViewController != null) {
            this.mAdViewController.setFacebookSupported(enabled);
        }
    }

    public boolean isFacebookSupported() {
        return this.mAdViewController != null ? this.mAdViewController.isFacebookSupported() : false;
    }

    public void setLocation(Location location) {
        if (this.mAdViewController != null) {
            this.mAdViewController.setLocation(location);
        }
    }

    public Location getLocation() {
        return this.mAdViewController != null ? this.mAdViewController.getLocation() : null;
    }

    public void setTimeout(int milliseconds) {
        if (this.mAdViewController != null) {
            this.mAdViewController.setTimeout(milliseconds);
        }
    }

    public int getAdWidth() {
        return this.mAdViewController != null ? this.mAdViewController.getAdWidth() : 0;
    }

    public int getAdHeight() {
        return this.mAdViewController != null ? this.mAdViewController.getAdHeight() : 0;
    }

    public String getResponseString() {
        return this.mAdViewController != null ? this.mAdViewController.getResponseString() : null;
    }

    public void setClickthroughUrl(String url) {
        if (this.mAdViewController != null) {
            this.mAdViewController.setClickthroughUrl(url);
        }
    }

    public String getClickthroughUrl() {
        return this.mAdViewController != null ? this.mAdViewController.getClickthroughUrl() : null;
    }

    public Activity getActivity() {
        return (Activity) this.mContext;
    }

    public void setBannerAdListener(BannerAdListener listener) {
        this.mBannerAdListener = listener;
    }

    public BannerAdListener getBannerAdListener() {
        return this.mBannerAdListener;
    }

    public void setLocationAwareness(LocationAwareness awareness) {
        this.mLocationAwareness = awareness;
    }

    public LocationAwareness getLocationAwareness() {
        return this.mLocationAwareness;
    }

    public void setLocationPrecision(int precision) {
        if (this.mAdViewController != null) {
            this.mAdViewController.setLocationPrecision(precision);
        }
    }

    public int getLocationPrecision() {
        return this.mAdViewController != null ? this.mAdViewController.getLocationPrecision() : 0;
    }

    public void setLocalExtras(Map localExtras) {
        if (this.mAdViewController != null) {
            this.mAdViewController.setLocalExtras(localExtras);
        }
    }

    public Map getLocalExtras() {
        if (this.mAdViewController != null) {
            return this.mAdViewController.getLocalExtras();
        }
        return Collections.emptyMap();
    }

    public void setAutorefreshEnabled(boolean enabled) {
        if (this.mAdViewController != null) {
            this.mAdViewController.forceSetAutorefreshEnabled(enabled);
        }
    }

    public boolean getAutorefreshEnabled() {
        if (this.mAdViewController != null) {
            return this.mAdViewController.getAutorefreshEnabled();
        }
        Log.d("MoPub", "Can't get autorefresh status for destroyed MoPubView. Returning false.");
        return false;
    }

    public void setAdContentView(View view) {
        if (this.mAdViewController != null) {
            this.mAdViewController.setAdContentView(view);
        }
    }

    public void setTesting(boolean testing) {
        if (this.mAdViewController != null) {
            this.mAdViewController.setTesting(testing);
        }
    }

    public boolean getTesting() {
        if (this.mAdViewController != null) {
            return this.mAdViewController.getTesting();
        }
        Log.d("MoPub", "Can't get testing status for destroyed MoPubView. Returning false.");
        return false;
    }

    public void forceRefresh() {
        if (this.mCustomEventBannerAdapter != null) {
            this.mCustomEventBannerAdapter.invalidate();
            this.mCustomEventBannerAdapter = null;
        }
        if (this.mAdViewController != null) {
            this.mAdViewController.forceRefresh();
        }
    }

    AdViewController getAdViewController() {
        return this.mAdViewController;
    }

    @Deprecated
    public void setOnAdWillLoadListener(OnAdWillLoadListener listener) {
        this.mOnAdWillLoadListener = listener;
    }

    @Deprecated
    public void setOnAdLoadedListener(OnAdLoadedListener listener) {
        this.mOnAdLoadedListener = listener;
    }

    @Deprecated
    public void setOnAdFailedListener(OnAdFailedListener listener) {
        this.mOnAdFailedListener = listener;
    }

    @Deprecated
    public void setOnAdPresentedOverlayListener(OnAdPresentedOverlayListener listener) {
        this.mOnAdPresentedOverlayListener = listener;
    }

    @Deprecated
    public void setOnAdClosedListener(OnAdClosedListener listener) {
        this.mOnAdClosedListener = listener;
    }

    @Deprecated
    public void setOnAdClickedListener(OnAdClickedListener listener) {
        this.mOnAdClickedListener = listener;
    }

    @Deprecated
    protected void adWillLoad(String url) {
        Log.d("MoPub", "adWillLoad: " + url);
        if (this.mOnAdWillLoadListener != null) {
            this.mOnAdWillLoadListener.OnAdWillLoad(this, url);
        }
    }

    @Deprecated
    public void customEventDidLoadAd() {
        if (this.mAdViewController != null) {
            this.mAdViewController.customEventDidLoadAd();
        }
    }

    @Deprecated
    public void customEventDidFailToLoadAd() {
        if (this.mAdViewController != null) {
            this.mAdViewController.customEventDidFailToLoadAd();
        }
    }

    @Deprecated
    public void customEventActionWillBegin() {
        if (this.mAdViewController != null) {
            this.mAdViewController.customEventActionWillBegin();
        }
    }
}
