package com.millennialmedia.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.TreeMap;

final class MMConversionTracker {
    private static final String KEY_REFERRER = "installReferrer";

    /* renamed from: com.millennialmedia.android.MMConversionTracker.1 */
    static class C24801 implements Runnable {
        final /* synthetic */ TreeMap val$extraParams;
        final /* synthetic */ String val$goalId;
        final /* synthetic */ long val$installTimeUTC;
        final /* synthetic */ boolean val$isFirstLaunch;

        C24801(String str, boolean z, long j, TreeMap treeMap) {
            this.val$goalId = str;
            this.val$isFirstLaunch = z;
            this.val$installTimeUTC = j;
            this.val$extraParams = treeMap;
        }

        public void run() {
            try {
                new HttpGetRequest().trackConversion(this.val$goalId, this.val$isFirstLaunch, this.val$installTimeUTC, this.val$extraParams);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    MMConversionTracker() {
    }

    protected static synchronized void trackConversion(Context context, String goalId, MMRequest request) {
        synchronized (MMConversionTracker.class) {
            long installTime = 0;
            if (!(context == null || goalId == null)) {
                if (goalId.length() != 0) {
                    SharedPreferences settings = context.getSharedPreferences("MillennialMediaSettings", 0);
                    boolean isFirstLaunch = settings.getBoolean("firstLaunch_" + goalId, true);
                    String referrerString = settings.getString(KEY_REFERRER, null);
                    TreeMap extraParams = new TreeMap();
                    if (request != null) {
                        request.getUrlParams(extraParams);
                        MMRequest.insertLocation(extraParams);
                    }
                    if (referrerString != null) {
                        for (String split : referrerString.split("&")) {
                            String[] subComponents = split.split("=");
                            if (subComponents.length >= 2) {
                                extraParams.put(subComponents[0], subComponents[1]);
                            }
                        }
                    }
                    if (isFirstLaunch) {
                        Editor editor = settings.edit();
                        editor.putBoolean("firstLaunch_" + goalId, false);
                        editor.commit();
                    }
                    try {
                        PackageInfo info = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                        try {
                            installTime = info.getClass().getField("firstInstallTime").getLong(info);
                        } catch (Exception e) {
                        }
                    } catch (NameNotFoundException e2) {
                    }
                    if (installTime > 0) {
                        GregorianCalendar calendar = new GregorianCalendar();
                        calendar.setTimeInMillis(installTime);
                        calendar.setTimeZone(TimeZone.getTimeZone("GMT"));
                        installTime = calendar.getTimeInMillis();
                    }
                    long installTimeUTC = installTime;
                    if (MMSDK.isConnected(context)) {
                        extraParams.put("ua", "Android:" + Build.MODEL);
                        extraParams.put("apid", HandShake.apid);
                        MMSDK.insertUrlCommonValues(context, extraParams);
                        ThreadUtils.execute(new C24801(goalId, isFirstLaunch, installTimeUTC, extraParams));
                    } else {
                        Log.m9726w("No network available for conversion tracking.");
                    }
                }
            }
        }
    }
}
