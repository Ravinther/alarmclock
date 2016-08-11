package com.mopub.mobileads;

import android.content.Context;
import android.os.Build;
import android.provider.Settings.Secure;
import android.webkit.WebView;
import com.google.android.gms.location.LocationStatusCodes;
import com.mopub.common.MoPub;
import com.mopub.common.util.DateAndTime;
import com.mopub.common.util.ResponseHeader;
import com.mopub.common.util.Utils;
import com.mopub.common.util.VersionCode;
import com.mopub.mobileads.util.HttpResponses;
import java.io.Serializable;
import java.util.Map;
import org.apache.http.HttpResponse;

public class AdConfiguration implements Serializable {
    private static final int DEFAULT_REFRESH_TIME_MILLISECONDS = 60000;
    private static final int MINIMUM_REFRESH_TIME_MILLISECONDS = 10000;
    private static final String mPlatform = "Android";
    private static final long serialVersionUID = 0;
    private Integer mAdTimeoutDelay;
    private String mAdType;
    private String mAdUnitId;
    private long mBroadcastIdentifier;
    private String mClickthroughUrl;
    private final String mDeviceLocale;
    private final String mDeviceModel;
    private String mDspCreativeId;
    private String mFailUrl;
    private final String mHashedUdid;
    private int mHeight;
    private String mImpressionUrl;
    private String mNetworkType;
    private final int mPlatformVersion;
    private String mRedirectUrl;
    private int mRefreshTimeMilliseconds;
    private String mResponseString;
    private final String mSdkVersion;
    private long mTimeStamp;
    private final String mUserAgent;
    private int mWidth;

    static AdConfiguration extractFromMap(Map map) {
        if (map == null) {
            return null;
        }
        Object adConfiguration = map.get(AdFetcher.AD_CONFIGURATION_KEY);
        return adConfiguration instanceof AdConfiguration ? (AdConfiguration) adConfiguration : null;
    }

    AdConfiguration(Context context) {
        setDefaults();
        if (context != null) {
            String udid = Secure.getString(context.getContentResolver(), "android_id");
            if (udid == null) {
                udid = "";
            }
            this.mHashedUdid = Utils.sha1(udid);
            this.mUserAgent = new WebView(context).getSettings().getUserAgentString();
            this.mDeviceLocale = context.getResources().getConfiguration().locale.toString();
        } else {
            this.mHashedUdid = null;
            this.mUserAgent = null;
            this.mDeviceLocale = null;
        }
        this.mBroadcastIdentifier = Utils.generateUniqueId();
        this.mDeviceModel = Build.MANUFACTURER + " " + Build.MODEL;
        this.mPlatformVersion = VersionCode.currentApiLevel().getApiLevel();
        this.mSdkVersion = MoPub.SDK_VERSION;
    }

    void cleanup() {
        setDefaults();
    }

    void addHttpResponse(HttpResponse httpResponse) {
        this.mAdType = HttpResponses.extractHeader(httpResponse, ResponseHeader.AD_TYPE);
        this.mNetworkType = HttpResponses.extractHeader(httpResponse, ResponseHeader.NETWORK_TYPE);
        this.mRedirectUrl = HttpResponses.extractHeader(httpResponse, ResponseHeader.REDIRECT_URL);
        this.mClickthroughUrl = HttpResponses.extractHeader(httpResponse, ResponseHeader.CLICKTHROUGH_URL);
        this.mFailUrl = HttpResponses.extractHeader(httpResponse, ResponseHeader.FAIL_URL);
        this.mImpressionUrl = HttpResponses.extractHeader(httpResponse, ResponseHeader.IMPRESSION_URL);
        this.mTimeStamp = DateAndTime.now().getTime();
        this.mWidth = HttpResponses.extractIntHeader(httpResponse, ResponseHeader.WIDTH, 0);
        this.mHeight = HttpResponses.extractIntHeader(httpResponse, ResponseHeader.HEIGHT, 0);
        this.mAdTimeoutDelay = HttpResponses.extractIntegerHeader(httpResponse, ResponseHeader.AD_TIMEOUT);
        if (httpResponse.containsHeader(ResponseHeader.REFRESH_TIME.getKey())) {
            this.mRefreshTimeMilliseconds = HttpResponses.extractIntHeader(httpResponse, ResponseHeader.REFRESH_TIME, 0) * LocationStatusCodes.GEOFENCE_NOT_AVAILABLE;
            this.mRefreshTimeMilliseconds = Math.max(this.mRefreshTimeMilliseconds, MINIMUM_REFRESH_TIME_MILLISECONDS);
        } else {
            this.mRefreshTimeMilliseconds = 0;
        }
        this.mDspCreativeId = HttpResponses.extractHeader(httpResponse, ResponseHeader.DSP_CREATIVE_ID);
    }

    String getAdUnitId() {
        return this.mAdUnitId;
    }

    void setAdUnitId(String adUnitId) {
        this.mAdUnitId = adUnitId;
    }

    String getResponseString() {
        return this.mResponseString;
    }

    void setResponseString(String responseString) {
        this.mResponseString = responseString;
    }

    long getBroadcastIdentifier() {
        return this.mBroadcastIdentifier;
    }

    String getAdType() {
        return this.mAdType;
    }

    String getNetworkType() {
        return this.mNetworkType;
    }

    String getRedirectUrl() {
        return this.mRedirectUrl;
    }

    String getClickthroughUrl() {
        return this.mClickthroughUrl;
    }

    @Deprecated
    void setClickthroughUrl(String clickthroughUrl) {
        this.mClickthroughUrl = clickthroughUrl;
    }

    String getFailUrl() {
        return this.mFailUrl;
    }

    void setFailUrl(String failUrl) {
        this.mFailUrl = failUrl;
    }

    String getImpressionUrl() {
        return this.mImpressionUrl;
    }

    long getTimeStamp() {
        return this.mTimeStamp;
    }

    int getWidth() {
        return this.mWidth;
    }

    int getHeight() {
        return this.mHeight;
    }

    Integer getAdTimeoutDelay() {
        return this.mAdTimeoutDelay;
    }

    int getRefreshTimeMilliseconds() {
        return this.mRefreshTimeMilliseconds;
    }

    @Deprecated
    void setRefreshTimeMilliseconds(int refreshTimeMilliseconds) {
        this.mRefreshTimeMilliseconds = refreshTimeMilliseconds;
    }

    String getDspCreativeId() {
        return this.mDspCreativeId;
    }

    String getHashedUdid() {
        return this.mHashedUdid;
    }

    String getUserAgent() {
        return this.mUserAgent;
    }

    String getDeviceLocale() {
        return this.mDeviceLocale;
    }

    String getDeviceModel() {
        return this.mDeviceModel;
    }

    int getPlatformVersion() {
        return this.mPlatformVersion;
    }

    String getPlatform() {
        return mPlatform;
    }

    String getSdkVersion() {
        return this.mSdkVersion;
    }

    private void setDefaults() {
        this.mBroadcastIdentifier = 0;
        this.mAdUnitId = null;
        this.mResponseString = null;
        this.mAdType = null;
        this.mNetworkType = null;
        this.mRedirectUrl = null;
        this.mClickthroughUrl = null;
        this.mImpressionUrl = null;
        this.mTimeStamp = DateAndTime.now().getTime();
        this.mWidth = 0;
        this.mHeight = 0;
        this.mAdTimeoutDelay = null;
        this.mRefreshTimeMilliseconds = DEFAULT_REFRESH_TIME_MILLISECONDS;
        this.mFailUrl = null;
        this.mDspCreativeId = null;
    }
}
