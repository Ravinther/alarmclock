package com.mopub.common.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.drive.DriveFile;

public class IntentUtils {
    private static final String HTTP = "http";
    private static final String HTTPS = "https";
    private static final String MARKET = "market";
    private static final String MARKET_ANDROID_COM = "market.android.com";
    private static final String PLAY_GOOGLE_COM = "play.google.com";
    private static final String TWITTER_APPLICATION_DEEPLINK_URL = "twitter://timeline";

    private IntentUtils() {
    }

    public static Intent getStartActivityIntent(Context context, Class clazz, Bundle extras) {
        Intent intent = new Intent(context, clazz);
        if (!(context instanceof Activity)) {
            intent.addFlags(DriveFile.MODE_READ_ONLY);
        }
        if (extras != null) {
            intent.putExtras(extras);
        }
        return intent;
    }

    public static boolean deviceCanHandleIntent(Context context, Intent intent) {
        try {
            if (context.getPackageManager().queryIntentActivities(intent, 0).isEmpty()) {
                return false;
            }
            return true;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public static boolean isHttpUrl(String url) {
        if (url == null) {
            return false;
        }
        String scheme = Uri.parse(url).getScheme();
        if (HTTP.equals(scheme) || HTTPS.equals(scheme)) {
            return true;
        }
        return false;
    }

    private static boolean isAppStoreUrl(String url) {
        if (url == null) {
            return false;
        }
        Uri uri = Uri.parse(url);
        String scheme = uri.getScheme();
        String host = uri.getHost();
        if (PLAY_GOOGLE_COM.equals(host) || MARKET_ANDROID_COM.equals(host)) {
            return true;
        }
        if (MARKET.equals(scheme)) {
            return true;
        }
        return false;
    }

    public static boolean isDeepLink(String url) {
        return isAppStoreUrl(url) || !isHttpUrl(url);
    }

    public static boolean canHandleTwitterUrl(Context context) {
        return canHandleApplicationUrl(context, TWITTER_APPLICATION_DEEPLINK_URL, false);
    }

    public static boolean canHandleApplicationUrl(Context context, String url) {
        return canHandleApplicationUrl(context, url, true);
    }

    public static boolean canHandleApplicationUrl(Context context, String url, boolean logError) {
        if (deviceCanHandleIntent(context, new Intent("android.intent.action.VIEW", Uri.parse(url)))) {
            return true;
        }
        if (logError) {
            Log.w("MoPub", "Could not handle application specific action: " + url + ". " + "You may be running in the emulator or another device which does not " + "have the required application.");
        }
        return false;
    }
}
