package com.mopub.common;

import android.content.Context;
import android.net.Uri;
import android.provider.Settings.Secure;
import com.avg.toolkit.ITKSvc;
import com.mopub.common.util.Strings;
import com.mopub.common.util.Utils;

public abstract class BaseUrlGenerator {
    private static final String IFA_PREFIX = "ifa:";
    private static final String SHA_PREFIX = "sha:";
    private boolean mFirstParam;
    private StringBuilder mStringBuilder;

    public abstract String generateUrlString(String str);

    protected void initUrlString(String serverHostname, String handlerType) {
        this.mStringBuilder = new StringBuilder("http://" + serverHostname + handlerType);
        this.mFirstParam = true;
    }

    protected String getFinalUrlString() {
        return this.mStringBuilder.toString();
    }

    protected void addParam(String key, String value) {
        if (value != null && !Strings.isEmpty(value)) {
            this.mStringBuilder.append(getParamDelimiter());
            this.mStringBuilder.append(key);
            this.mStringBuilder.append("=");
            this.mStringBuilder.append(Uri.encode(value));
        }
    }

    private String getParamDelimiter() {
        if (!this.mFirstParam) {
            return "&";
        }
        this.mFirstParam = false;
        return "?";
    }

    protected void setApiVersion(String apiVersion) {
        addParam("v", apiVersion);
    }

    protected void setAppVersion(String appVersion) {
        addParam("av", appVersion);
    }

    protected void setExternalStoragePermission(boolean isExternalStoragePermissionGranted) {
        addParam("android_perms_ext_storage", isExternalStoragePermissionGranted ? "1" : ITKSvc.CODEREVISION);
    }

    protected void setDeviceInfo(String... info) {
        StringBuilder result = new StringBuilder();
        if (info != null && info.length >= 1) {
            for (int i = 0; i < info.length - 1; i++) {
                result.append(info[i]).append(",");
            }
            result.append(info[info.length - 1]);
            addParam("dn", result.toString());
        }
    }

    protected void setDoNotTrack(boolean dnt) {
        if (dnt) {
            addParam("dnt", "1");
        }
    }

    protected void setUdid(String udid) {
        addParam("udid", udid);
    }

    protected String getUdidFromContext(Context context) {
        String androidId = GpsHelper.getAdvertisingId(context);
        if (androidId != null) {
            return IFA_PREFIX + androidId;
        }
        String deviceId = Secure.getString(context.getContentResolver(), "android_id");
        return SHA_PREFIX + (deviceId == null ? "" : Utils.sha1(deviceId));
    }

    protected String getAppVersionFromContext(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e) {
            return null;
        }
    }
}
