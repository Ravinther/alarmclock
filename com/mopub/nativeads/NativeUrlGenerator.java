package com.mopub.nativeads;

import android.content.Context;
import android.location.Location;
import android.os.Build;
import com.mopub.common.AdUrlGenerator;
import com.mopub.common.GpsHelper;
import com.mopub.common.LocationService;
import com.mopub.common.LocationService.LocationAwareness;
import com.mopub.common.MoPub;
import com.mopub.common.util.Strings;
import com.mopub.mobileads.MoPubView;

class NativeUrlGenerator extends AdUrlGenerator {
    private static LocationAwareness sLocationAwareness;
    private static int sLocationPrecision;
    private String mDesiredAssets;

    static {
        sLocationPrecision = 6;
        sLocationAwareness = LocationAwareness.NORMAL;
    }

    NativeUrlGenerator(Context context) {
        super(context);
    }

    public NativeUrlGenerator withAdUnitId(String adUnitId) {
        this.mAdUnitId = adUnitId;
        return this;
    }

    NativeUrlGenerator withRequest(RequestParameters requestParameters) {
        if (requestParameters != null) {
            this.mKeywords = requestParameters.getKeywords();
            this.mLocation = requestParameters.getLocation();
            this.mDesiredAssets = requestParameters.getDesiredAssets();
        }
        return this;
    }

    public String generateUrlString(String serverHostname) {
        initUrlString(serverHostname, MoPubView.AD_HANDLER);
        setAdUnitId(this.mAdUnitId);
        setSdkVersion(MoPub.SDK_VERSION);
        setDeviceInfo(Build.MANUFACTURER, Build.MODEL, Build.PRODUCT);
        setUdid(getUdidFromContext(this.mContext));
        setDoNotTrack(GpsHelper.isLimitAdTrackingEnabled(this.mContext));
        setKeywords(this.mKeywords);
        Location location = this.mLocation;
        if (location == null) {
            location = LocationService.getLastKnownLocation(this.mContext, sLocationPrecision, sLocationAwareness);
        }
        setLocation(location);
        setTimezone(AdUrlGenerator.getTimeZoneOffsetString());
        setOrientation(this.mContext.getResources().getConfiguration().orientation);
        setDensity(this.mContext.getResources().getDisplayMetrics().density);
        String networkOperator = getNetworkOperator();
        setMccCode(networkOperator);
        setMncCode(networkOperator);
        setIsoCountryCode(this.mTelephonyManager.getNetworkCountryIso());
        setCarrierName(this.mTelephonyManager.getNetworkOperatorName());
        setNetworkType(getActiveNetworkType());
        setAppVersion(getAppVersionFromContext(this.mContext));
        setTwitterAppInstalledFlag();
        setDesiredAssets();
        return getFinalUrlString();
    }

    private void setDesiredAssets() {
        if (this.mDesiredAssets != null && !Strings.isEmpty(this.mDesiredAssets)) {
            addParam("assets", this.mDesiredAssets);
        }
    }

    protected void setSdkVersion(String sdkVersion) {
        addParam("nsv", sdkVersion);
    }
}
