package com.mopub.mobileads;

import android.content.Context;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.mopub.common.GpsHelper;
import com.mopub.common.GpsHelper.GpsHelperListener;
import com.mopub.common.LocationService;
import com.mopub.common.LocationService.LocationAwareness;
import com.mopub.common.util.Dips;
import com.mopub.common.util.MoPubLog;
import com.mopub.mobileads.factories.AdFetcherFactory;
import com.mopub.mobileads.factories.HttpClientFactory;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class AdViewController {
    static final int DEFAULT_REFRESH_TIME_MILLISECONDS = 60000;
    static final int MINIMUM_REFRESH_TIME_MILLISECONDS = 10000;
    private static final LayoutParams WRAP_AND_CENTER_LAYOUT_PARAMS;
    private static WeakHashMap sViewShouldHonorServerDimensions;
    private AdConfiguration mAdConfiguration;
    private AdFetcher mAdFetcher;
    private boolean mAdWasLoaded;
    private boolean mAutoRefreshEnabled;
    private final Context mContext;
    private GpsHelperListener mGpsHelperListener;
    private Handler mHandler;
    private boolean mIsDestroyed;
    private boolean mIsFacebookSupported;
    private boolean mIsLoading;
    private boolean mIsTesting;
    private String mKeywords;
    private Map mLocalExtras;
    private Location mLocation;
    private LocationAwareness mLocationAwareness;
    private int mLocationPrecision;
    private MoPubView mMoPubView;
    private boolean mPreviousAutoRefreshSetting;
    private final Runnable mRefreshRunnable;
    private String mUrl;
    private final WebViewAdUrlGenerator mUrlGenerator;

    /* renamed from: com.mopub.mobileads.AdViewController.1 */
    class C25891 implements Runnable {
        C25891() {
        }

        public void run() {
            AdViewController.this.loadAd();
        }
    }

    /* renamed from: com.mopub.mobileads.AdViewController.2 */
    class C25902 implements Runnable {
        C25902() {
        }

        public void run() {
            if (AdViewController.this.mAdConfiguration.getImpressionUrl() != null) {
                DefaultHttpClient httpClient = HttpClientFactory.create();
                try {
                    HttpGet httpget = new HttpGet(AdViewController.this.mAdConfiguration.getImpressionUrl());
                    httpget.addHeader("User-Agent", AdViewController.this.mAdConfiguration.getUserAgent());
                    httpClient.execute(httpget);
                } catch (Exception e) {
                    Log.d("MoPub", "Impression tracking failed : " + AdViewController.this.mAdConfiguration.getImpressionUrl(), e);
                } finally {
                    httpClient.getConnectionManager().shutdown();
                }
            }
        }
    }

    /* renamed from: com.mopub.mobileads.AdViewController.3 */
    class C25913 implements Runnable {
        C25913() {
        }

        public void run() {
            if (AdViewController.this.mAdConfiguration.getClickthroughUrl() != null) {
                DefaultHttpClient httpClient = HttpClientFactory.create();
                try {
                    Log.d("MoPub", "Tracking click for: " + AdViewController.this.mAdConfiguration.getClickthroughUrl());
                    HttpGet httpget = new HttpGet(AdViewController.this.mAdConfiguration.getClickthroughUrl());
                    httpget.addHeader("User-Agent", AdViewController.this.mAdConfiguration.getUserAgent());
                    httpClient.execute(httpget);
                } catch (Exception e) {
                    Log.d("MoPub", "Click tracking failed: " + AdViewController.this.mAdConfiguration.getClickthroughUrl(), e);
                } finally {
                    httpClient.getConnectionManager().shutdown();
                }
            }
        }
    }

    /* renamed from: com.mopub.mobileads.AdViewController.4 */
    class C25924 implements Runnable {
        final /* synthetic */ View val$view;

        C25924(View view) {
            this.val$view = view;
        }

        public void run() {
            MoPubView moPubView = AdViewController.this.getMoPubView();
            if (moPubView != null) {
                moPubView.removeAllViews();
                moPubView.addView(this.val$view, AdViewController.this.getAdLayoutParams(this.val$view));
            }
        }
    }

    class AdViewControllerGpsHelperListener implements GpsHelperListener {
        AdViewControllerGpsHelperListener() {
        }

        public void onFetchAdInfoCompleted() {
            AdViewController.this.loadNonJavascript(AdViewController.this.generateAdUrl());
        }
    }

    static {
        WRAP_AND_CENTER_LAYOUT_PARAMS = new LayoutParams(-2, -2, 17);
        sViewShouldHonorServerDimensions = new WeakHashMap();
    }

    protected static void setShouldHonorServerDimensions(View view) {
        sViewShouldHonorServerDimensions.put(view, Boolean.valueOf(true));
    }

    private static boolean getShouldHonorServerDimensions(View view) {
        return sViewShouldHonorServerDimensions.get(view) != null;
    }

    public AdViewController(Context context, MoPubView view) {
        this.mLocalExtras = new HashMap();
        this.mAutoRefreshEnabled = true;
        this.mPreviousAutoRefreshSetting = true;
        this.mLocationAwareness = LocationAwareness.NORMAL;
        this.mLocationPrecision = 6;
        this.mIsFacebookSupported = true;
        this.mContext = context;
        this.mMoPubView = view;
        this.mUrlGenerator = new WebViewAdUrlGenerator(context);
        this.mAdConfiguration = new AdConfiguration(this.mContext);
        this.mAdFetcher = AdFetcherFactory.create(this, this.mAdConfiguration.getUserAgent());
        this.mGpsHelperListener = new AdViewControllerGpsHelperListener();
        GpsHelper.asyncFetchAdvertisingInfo(this.mContext);
        this.mRefreshRunnable = new C25891();
        this.mHandler = new Handler();
    }

    public MoPubView getMoPubView() {
        return this.mMoPubView;
    }

    public void loadAd() {
        this.mAdWasLoaded = true;
        if (this.mAdConfiguration.getAdUnitId() == null) {
            Log.d("MoPub", "Can't load an ad in this ad view because the ad unit ID is null. Did you forget to call setAdUnitId()?");
        } else if (isNetworkAvailable()) {
            if (this.mLocation == null) {
                this.mLocation = LocationService.getLastKnownLocation(this.mContext, this.mLocationPrecision, this.mLocationAwareness);
            }
            GpsHelper.asyncFetchAdvertisingInfoIfNotCached(this.mContext, this.mGpsHelperListener);
        } else {
            Log.d("MoPub", "Can't load an ad because there is no network connectivity.");
            scheduleRefreshTimerIfEnabled();
        }
    }

    void loadNonJavascript(String url) {
        if (url != null) {
            Log.d("MoPub", "Loading url: " + url);
            if (!this.mIsLoading) {
                this.mUrl = url;
                this.mAdConfiguration.setFailUrl(null);
                this.mIsLoading = true;
                fetchAd(this.mUrl);
            } else if (this.mAdConfiguration.getAdUnitId() != null) {
                Log.i("MoPub", "Already loading an ad for " + this.mAdConfiguration.getAdUnitId() + ", wait to finish.");
            }
        }
    }

    public void reload() {
        Log.d("MoPub", "Reload ad: " + this.mUrl);
        loadNonJavascript(this.mUrl);
    }

    void loadFailUrl(MoPubErrorCode errorCode) {
        this.mIsLoading = false;
        Log.v("MoPub", "MoPubErrorCode: " + (errorCode == null ? "" : errorCode.toString()));
        if (this.mAdConfiguration.getFailUrl() != null) {
            Log.d("MoPub", "Loading failover url: " + this.mAdConfiguration.getFailUrl());
            loadNonJavascript(this.mAdConfiguration.getFailUrl());
            return;
        }
        adDidFail(MoPubErrorCode.NO_FILL);
    }

    void setFailUrl(String failUrl) {
        this.mAdConfiguration.setFailUrl(failUrl);
    }

    void setNotLoading() {
        this.mIsLoading = false;
    }

    public String getKeywords() {
        return this.mKeywords;
    }

    public void setKeywords(String keywords) {
        this.mKeywords = keywords;
    }

    public boolean isFacebookSupported() {
        return this.mIsFacebookSupported;
    }

    public void setFacebookSupported(boolean enabled) {
        this.mIsFacebookSupported = enabled;
    }

    public Location getLocation() {
        return this.mLocation;
    }

    public void setLocation(Location location) {
        this.mLocation = location;
    }

    public String getAdUnitId() {
        return this.mAdConfiguration.getAdUnitId();
    }

    public void setAdUnitId(String adUnitId) {
        this.mAdConfiguration.setAdUnitId(adUnitId);
    }

    public void setTimeout(int milliseconds) {
        if (this.mAdFetcher != null) {
            this.mAdFetcher.setTimeout(milliseconds);
        }
    }

    public int getAdWidth() {
        return this.mAdConfiguration.getWidth();
    }

    public int getAdHeight() {
        return this.mAdConfiguration.getHeight();
    }

    public String getClickthroughUrl() {
        return this.mAdConfiguration.getClickthroughUrl();
    }

    @Deprecated
    public void setClickthroughUrl(String clickthroughUrl) {
        this.mAdConfiguration.setClickthroughUrl(clickthroughUrl);
    }

    public String getRedirectUrl() {
        return this.mAdConfiguration.getRedirectUrl();
    }

    public String getResponseString() {
        return this.mAdConfiguration.getResponseString();
    }

    public boolean getAutorefreshEnabled() {
        return this.mAutoRefreshEnabled;
    }

    void pauseRefresh() {
        this.mPreviousAutoRefreshSetting = this.mAutoRefreshEnabled;
        setAutorefreshEnabled(false);
    }

    void unpauseRefresh() {
        setAutorefreshEnabled(this.mPreviousAutoRefreshSetting);
    }

    void forceSetAutorefreshEnabled(boolean enabled) {
        this.mPreviousAutoRefreshSetting = enabled;
        setAutorefreshEnabled(enabled);
    }

    private void setAutorefreshEnabled(boolean enabled) {
        boolean autorefreshChanged = this.mAdWasLoaded && this.mAutoRefreshEnabled != enabled;
        if (autorefreshChanged) {
            MoPubLog.m9729d("Refresh " + (enabled ? "enabled" : "disabled") + " for ad unit (" + (this.mAdConfiguration != null ? this.mAdConfiguration.getAdUnitId() : null) + ").");
        }
        this.mAutoRefreshEnabled = enabled;
        if (this.mAdWasLoaded && this.mAutoRefreshEnabled) {
            scheduleRefreshTimerIfEnabled();
        } else if (!this.mAutoRefreshEnabled) {
            cancelRefreshTimer();
        }
    }

    public boolean getTesting() {
        return this.mIsTesting;
    }

    public void setTesting(boolean enabled) {
        this.mIsTesting = enabled;
    }

    int getLocationPrecision() {
        return this.mLocationPrecision;
    }

    void setLocationPrecision(int precision) {
        this.mLocationPrecision = Math.max(0, precision);
    }

    AdConfiguration getAdConfiguration() {
        return this.mAdConfiguration;
    }

    boolean isDestroyed() {
        return this.mIsDestroyed;
    }

    void cleanup() {
        if (!this.mIsDestroyed) {
            setAutorefreshEnabled(false);
            cancelRefreshTimer();
            this.mAdFetcher.cleanup();
            this.mAdFetcher = null;
            this.mAdConfiguration.cleanup();
            this.mMoPubView = null;
            this.mIsDestroyed = true;
        }
    }

    void configureUsingHttpResponse(HttpResponse response) {
        this.mAdConfiguration.addHttpResponse(response);
    }

    Integer getAdTimeoutDelay() {
        return this.mAdConfiguration.getAdTimeoutDelay();
    }

    int getRefreshTimeMilliseconds() {
        return this.mAdConfiguration.getRefreshTimeMilliseconds();
    }

    @Deprecated
    void setRefreshTimeMilliseconds(int refreshTimeMilliseconds) {
        this.mAdConfiguration.setRefreshTimeMilliseconds(refreshTimeMilliseconds);
    }

    void trackImpression() {
        new Thread(new C25902()).start();
    }

    void registerClick() {
        new Thread(new C25913()).start();
    }

    void fetchAd(String mUrl) {
        if (this.mAdFetcher != null) {
            this.mAdFetcher.fetchAdForUrl(mUrl);
        }
    }

    void forceRefresh() {
        setNotLoading();
        loadAd();
    }

    String generateAdUrl() {
        return this.mUrlGenerator.withAdUnitId(this.mAdConfiguration.getAdUnitId()).withKeywords(this.mKeywords).withFacebookSupported(this.mIsFacebookSupported).withLocation(this.mLocation).generateUrlString(getServerHostname());
    }

    void adDidFail(MoPubErrorCode errorCode) {
        Log.i("MoPub", "Ad failed to load.");
        setNotLoading();
        scheduleRefreshTimerIfEnabled();
        getMoPubView().adFailed(errorCode);
    }

    void scheduleRefreshTimerIfEnabled() {
        cancelRefreshTimer();
        if (this.mAutoRefreshEnabled && this.mAdConfiguration.getRefreshTimeMilliseconds() > 0) {
            this.mHandler.postDelayed(this.mRefreshRunnable, (long) this.mAdConfiguration.getRefreshTimeMilliseconds());
        }
    }

    void setLocalExtras(Map localExtras) {
        this.mLocalExtras = localExtras != null ? new HashMap(localExtras) : new HashMap();
    }

    Map getLocalExtras() {
        return this.mLocalExtras != null ? new HashMap(this.mLocalExtras) : new HashMap();
    }

    private void cancelRefreshTimer() {
        this.mHandler.removeCallbacks(this.mRefreshRunnable);
    }

    private String getServerHostname() {
        return this.mIsTesting ? MoPubView.HOST_FOR_TESTING : MoPubView.HOST;
    }

    private boolean isNetworkAvailable() {
        if (this.mContext.checkCallingPermission("android.permission.ACCESS_NETWORK_STATE") == -1) {
            return true;
        }
        NetworkInfo networkInfo = ((ConnectivityManager) this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (networkInfo == null || !networkInfo.isConnected()) {
            return false;
        }
        return true;
    }

    void setAdContentView(View view) {
        this.mHandler.post(new C25924(view));
    }

    private LayoutParams getAdLayoutParams(View view) {
        int width = this.mAdConfiguration.getWidth();
        int height = this.mAdConfiguration.getHeight();
        if (!getShouldHonorServerDimensions(view) || width <= 0 || height <= 0) {
            return WRAP_AND_CENTER_LAYOUT_PARAMS;
        }
        return new LayoutParams(Dips.asIntPixels((float) width, this.mContext), Dips.asIntPixels((float) height, this.mContext), 17);
    }

    @Deprecated
    void setGpsHelperListener(GpsHelperListener gpsHelperListener) {
        this.mGpsHelperListener = gpsHelperListener;
    }

    @Deprecated
    public void customEventDidLoadAd() {
        setNotLoading();
        trackImpression();
        scheduleRefreshTimerIfEnabled();
    }

    @Deprecated
    public void customEventDidFailToLoadAd() {
        loadFailUrl(MoPubErrorCode.UNSPECIFIED);
    }

    @Deprecated
    public void customEventActionWillBegin() {
        registerClick();
    }
}
