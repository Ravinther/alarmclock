package com.mopub.mobileads;

import android.content.Context;
import android.os.Build;
import com.mopub.common.AdUrlGenerator;
import com.mopub.common.GpsHelper;
import com.mopub.common.MoPub;
import com.mopub.mobileads.util.Mraids;

public class WebViewAdUrlGenerator extends AdUrlGenerator {
    public WebViewAdUrlGenerator(Context context) {
        super(context);
    }

    public String generateUrlString(String serverHostname) {
        initUrlString(serverHostname, MoPubView.AD_HANDLER);
        setApiVersion("6");
        setAdUnitId(this.mAdUnitId);
        setSdkVersion(MoPub.SDK_VERSION);
        setDeviceInfo(Build.MANUFACTURER, Build.MODEL, Build.PRODUCT);
        setUdid(getUdidFromContext(this.mContext));
        setDoNotTrack(GpsHelper.isLimitAdTrackingEnabled(this.mContext));
        setKeywords(addKeyword(this.mKeywords, getFacebookKeyword(this.mContext, this.mFacebookSupportEnabled)));
        setLocation(this.mLocation);
        setTimezone(AdUrlGenerator.getTimeZoneOffsetString());
        setOrientation(this.mContext.getResources().getConfiguration().orientation);
        setDensity(this.mContext.getResources().getDisplayMetrics().density);
        setMraidFlag(detectIsMraidSupported());
        String networkOperator = getNetworkOperator();
        setMccCode(networkOperator);
        setMncCode(networkOperator);
        setIsoCountryCode(this.mTelephonyManager.getNetworkCountryIso());
        setCarrierName(this.mTelephonyManager.getNetworkOperatorName());
        setNetworkType(getActiveNetworkType());
        setAppVersion(getAppVersionFromContext(this.mContext));
        setExternalStoragePermission(Mraids.isStorePictureSupported(this.mContext));
        setTwitterAppInstalledFlag();
        return getFinalUrlString();
    }

    private boolean detectIsMraidSupported() {
        try {
            Class.forName("com.mopub.mobileads.MraidView");
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    private static String getFacebookKeyword(Context context, boolean enabled) {
        if (!enabled) {
            return null;
        }
        try {
            Class facebookKeywordProviderClass = Class.forName("com.mopub.mobileads.FacebookKeywordProvider");
            return (String) facebookKeywordProviderClass.getMethod("getKeyword", new Class[]{Context.class}).invoke(facebookKeywordProviderClass, new Object[]{context});
        } catch (Exception e) {
            return null;
        }
    }

    private static String addKeyword(String keywords, String addition) {
        if (addition == null || addition.length() == 0) {
            return keywords;
        }
        return (keywords == null || keywords.length() == 0) ? addition : keywords + "," + addition;
    }
}
