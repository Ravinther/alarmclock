package com.mopub.common.util;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.mopub.common.MoPubBrowser;
import com.mopub.mobileads.MoPubActivity;
import com.mopub.mobileads.MraidActivity;
import com.mopub.mobileads.MraidVideoPlayerActivity;
import java.util.ArrayList;
import java.util.List;

public class ManifestUtils {
    private static final List REQUIRED_NATIVE_SDK_ACTIVITIES;
    private static final List REQUIRED_WEB_VIEW_SDK_ACTIVITIES;

    private ManifestUtils() {
    }

    static {
        REQUIRED_WEB_VIEW_SDK_ACTIVITIES = new ArrayList(4);
        REQUIRED_WEB_VIEW_SDK_ACTIVITIES.add(MoPubActivity.class);
        REQUIRED_WEB_VIEW_SDK_ACTIVITIES.add(MraidActivity.class);
        REQUIRED_WEB_VIEW_SDK_ACTIVITIES.add(MraidVideoPlayerActivity.class);
        REQUIRED_WEB_VIEW_SDK_ACTIVITIES.add(MoPubBrowser.class);
        REQUIRED_NATIVE_SDK_ACTIVITIES = new ArrayList(1);
        REQUIRED_NATIVE_SDK_ACTIVITIES.add(MoPubBrowser.class);
    }

    public static void checkWebViewActivitiesDeclared(Context context) {
        displayWarningForMissingActivities(context, REQUIRED_WEB_VIEW_SDK_ACTIVITIES);
    }

    public static void checkNativeActivitiesDeclared(Context context) {
        displayWarningForMissingActivities(context, REQUIRED_NATIVE_SDK_ACTIVITIES);
    }

    static void displayWarningForMissingActivities(Context context, List requiredActivities) {
        if (context != null) {
            List undeclaredActivities = getUndeclaredActivities(context, requiredActivities);
            if (!undeclaredActivities.isEmpty()) {
                if (isDebuggable(context)) {
                    String message = "ERROR: YOUR MOPUB INTEGRATION IS INCOMPLETE.\nCheck logcat and update your AndroidManifest.xml with the correct activities.";
                    Toast toast = Toast.makeText(context, "ERROR: YOUR MOPUB INTEGRATION IS INCOMPLETE.\nCheck logcat and update your AndroidManifest.xml with the correct activities.", 1);
                    toast.setGravity(7, 0, 0);
                    toast.show();
                }
                logMissingActivities(undeclaredActivities);
            }
        }
    }

    static boolean isDebuggable(Context context) {
        if (context == null || context.getApplicationInfo() == null) {
            return false;
        }
        return Utils.bitMaskContainsFlag(context.getApplicationInfo().flags, 2);
    }

    private static List getUndeclaredActivities(Context context, List requiredActivities) {
        List undeclaredActivities = new ArrayList();
        for (Class activityClass : requiredActivities) {
            if (!IntentUtils.deviceCanHandleIntent(context, new Intent(context, activityClass))) {
                undeclaredActivities.add(activityClass.getName());
            }
        }
        return undeclaredActivities;
    }

    private static void logMissingActivities(List undeclaredActivities) {
        StringBuilder stringBuilder = new StringBuilder("AndroidManifest permissions for the following required MoPub activities are missing:\n");
        for (String activity : undeclaredActivities) {
            stringBuilder.append("\n\t").append(activity);
        }
        stringBuilder.append("\n\nPlease update your manifest to include them.");
        MoPubLog.m9733w(stringBuilder.toString());
    }

    @Deprecated
    static List getRequiredWebViewSdkActivities() {
        return REQUIRED_WEB_VIEW_SDK_ACTIVITIES;
    }

    @Deprecated
    static List getRequiredNativeSdkActivities() {
        return REQUIRED_NATIVE_SDK_ACTIVITIES;
    }
}
