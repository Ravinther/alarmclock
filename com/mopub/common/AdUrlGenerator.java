package com.mopub.common;

import android.content.Context;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.mopub.common.util.DateAndTime;
import com.mopub.common.util.IntentUtils;
import com.mopub.mobileads.util.Base64;
import java.text.SimpleDateFormat;

public abstract class AdUrlGenerator extends BaseUrlGenerator {
    public static final String DEVICE_ORIENTATION_LANDSCAPE = "l";
    public static final String DEVICE_ORIENTATION_PORTRAIT = "p";
    public static final String DEVICE_ORIENTATION_SQUARE = "s";
    public static final String DEVICE_ORIENTATION_UNKNOWN = "u";
    public static final int TYPE_DUMMY = 8;
    public static final int TYPE_ETHERNET = 9;
    public static final int TYPE_MOBILE_DUN = 4;
    public static final int TYPE_MOBILE_HIPRI = 5;
    public static final int TYPE_MOBILE_MMS = 2;
    public static final int TYPE_MOBILE_SUPL = 3;
    private static TwitterAppInstalledStatus sTwitterAppInstalledStatus;
    protected String mAdUnitId;
    protected ConnectivityManager mConnectivityManager;
    protected Context mContext;
    protected boolean mFacebookSupportEnabled;
    protected String mKeywords;
    protected Location mLocation;
    protected TelephonyManager mTelephonyManager;

    public enum MoPubNetworkType {
        UNKNOWN,
        ETHERNET,
        WIFI,
        MOBILE;

        public String toString() {
            return Integer.toString(ordinal());
        }
    }

    public enum TwitterAppInstalledStatus {
        UNKNOWN,
        NOT_INSTALLED,
        INSTALLED
    }

    static {
        sTwitterAppInstalledStatus = TwitterAppInstalledStatus.UNKNOWN;
    }

    public AdUrlGenerator(Context context) {
        this.mContext = context;
        this.mTelephonyManager = (TelephonyManager) this.mContext.getSystemService("phone");
        this.mConnectivityManager = (ConnectivityManager) this.mContext.getSystemService("connectivity");
    }

    public AdUrlGenerator withAdUnitId(String adUnitId) {
        this.mAdUnitId = adUnitId;
        return this;
    }

    public AdUrlGenerator withKeywords(String keywords) {
        this.mKeywords = keywords;
        return this;
    }

    public AdUrlGenerator withFacebookSupported(boolean enabled) {
        this.mFacebookSupportEnabled = enabled;
        return this;
    }

    public AdUrlGenerator withLocation(Location location) {
        this.mLocation = location;
        return this;
    }

    protected void setAdUnitId(String adUnitId) {
        addParam("id", adUnitId);
    }

    protected void setSdkVersion(String sdkVersion) {
        addParam("nv", sdkVersion);
    }

    protected void setKeywords(String keywords) {
        addParam("q", keywords);
    }

    protected void setLocation(Location location) {
        if (location != null) {
            addParam("ll", location.getLatitude() + "," + location.getLongitude());
            addParam("lla", "" + ((int) location.getAccuracy()));
        }
    }

    protected void setTimezone(String timeZoneOffsetString) {
        addParam("z", timeZoneOffsetString);
    }

    protected void setOrientation(int orientation) {
        String orString = DEVICE_ORIENTATION_UNKNOWN;
        if (orientation == 1) {
            orString = DEVICE_ORIENTATION_PORTRAIT;
        } else if (orientation == TYPE_MOBILE_MMS) {
            orString = DEVICE_ORIENTATION_LANDSCAPE;
        } else if (orientation == TYPE_MOBILE_SUPL) {
            orString = DEVICE_ORIENTATION_SQUARE;
        }
        addParam("o", orString);
    }

    protected void setDensity(float density) {
        addParam("sc_a", "" + density);
    }

    protected void setMraidFlag(boolean mraid) {
        if (mraid) {
            addParam("mr", "1");
        }
    }

    protected void setMccCode(String networkOperator) {
        addParam("mcc", networkOperator == null ? "" : networkOperator.substring(0, mncPortionLength(networkOperator)));
    }

    protected void setMncCode(String networkOperator) {
        addParam("mnc", networkOperator == null ? "" : networkOperator.substring(mncPortionLength(networkOperator)));
    }

    protected void setIsoCountryCode(String networkCountryIso) {
        addParam("iso", networkCountryIso);
    }

    protected void setCarrierName(String networkOperatorName) {
        addParam("cn", networkOperatorName);
    }

    protected void setNetworkType(int type) {
        switch (type) {
            case Base64.DEFAULT /*0*/:
            case TYPE_MOBILE_MMS /*2*/:
            case TYPE_MOBILE_SUPL /*3*/:
            case TYPE_MOBILE_DUN /*4*/:
            case TYPE_MOBILE_HIPRI /*5*/:
                addParam("ct", MoPubNetworkType.MOBILE);
            case Base64.NO_PADDING /*1*/:
                addParam("ct", MoPubNetworkType.WIFI);
            case TYPE_ETHERNET /*9*/:
                addParam("ct", MoPubNetworkType.ETHERNET);
            default:
                addParam("ct", MoPubNetworkType.UNKNOWN);
        }
    }

    private void addParam(String key, MoPubNetworkType value) {
        addParam(key, value.toString());
    }

    protected String getNetworkOperator() {
        String networkOperator = this.mTelephonyManager.getNetworkOperator();
        if (this.mTelephonyManager.getPhoneType() == TYPE_MOBILE_MMS && this.mTelephonyManager.getSimState() == TYPE_MOBILE_HIPRI) {
            return this.mTelephonyManager.getSimOperator();
        }
        return networkOperator;
    }

    private int mncPortionLength(String networkOperator) {
        return Math.min(TYPE_MOBILE_SUPL, networkOperator.length());
    }

    protected static String getTimeZoneOffsetString() {
        SimpleDateFormat format = new SimpleDateFormat("Z");
        format.setTimeZone(DateAndTime.localTimeZone());
        return format.format(DateAndTime.now());
    }

    protected int getActiveNetworkType() {
        if (this.mContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
            return TYPE_DUMMY;
        }
        NetworkInfo activeNetworkInfo = this.mConnectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            return activeNetworkInfo.getType();
        }
        return TYPE_DUMMY;
    }

    protected void setTwitterAppInstalledFlag() {
        if (sTwitterAppInstalledStatus == TwitterAppInstalledStatus.UNKNOWN) {
            sTwitterAppInstalledStatus = getTwitterAppInstallStatus();
        }
        if (sTwitterAppInstalledStatus == TwitterAppInstalledStatus.INSTALLED) {
            addParam("ts", "1");
        }
    }

    public TwitterAppInstalledStatus getTwitterAppInstallStatus() {
        return IntentUtils.canHandleTwitterUrl(this.mContext) ? TwitterAppInstalledStatus.INSTALLED : TwitterAppInstalledStatus.NOT_INSTALLED;
    }

    @Deprecated
    public static void setTwitterAppInstalledStatus(TwitterAppInstalledStatus status) {
        sTwitterAppInstalledStatus = status;
    }
}
