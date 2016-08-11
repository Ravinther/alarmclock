package com.mopub.mobileads;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.mopub.common.BaseUrlGenerator;
import com.mopub.common.GpsHelper;
import com.mopub.common.GpsHelper.GpsHelperListener;
import com.mopub.common.SharedPreferencesHelper;
import com.mopub.mobileads.factories.HttpClientFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;

public class MoPubConversionTracker {
    private static final String TRACK_HANDLER = "/m/open";
    private static final String TRACK_HOST = "ads.mopub.com";
    private Context mContext;
    private ConversionTrackerGpsHelperListener mConversionTrackerGpsHelperListener;
    private String mIsTrackedKey;
    private String mPackageName;
    private SharedPreferences mSharedPreferences;

    class ConversionTrackerGpsHelperListener implements GpsHelperListener {
        ConversionTrackerGpsHelperListener() {
        }

        public void onFetchAdInfoCompleted() {
            new Thread(new TrackOpen(null)).start();
        }
    }

    private class ConversionUrlGenerator extends BaseUrlGenerator {
        private ConversionUrlGenerator() {
        }

        public String generateUrlString(String serverHostname) {
            initUrlString(serverHostname, MoPubConversionTracker.TRACK_HANDLER);
            setApiVersion("6");
            setPackageId(MoPubConversionTracker.this.mPackageName);
            setUdid(getUdidFromContext(MoPubConversionTracker.this.mContext));
            setDoNotTrack(GpsHelper.isLimitAdTrackingEnabled(MoPubConversionTracker.this.mContext));
            setAppVersion(getAppVersionFromContext(MoPubConversionTracker.this.mContext));
            return getFinalUrlString();
        }

        private void setPackageId(String packageName) {
            addParam("id", packageName);
        }
    }

    private class TrackOpen implements Runnable {
        private TrackOpen() {
        }

        public void run() {
            String url = new ConversionUrlGenerator(null).generateUrlString(MoPubConversionTracker.TRACK_HOST);
            Log.d("MoPub", "Conversion track: " + url);
            try {
                HttpResponse response = HttpClientFactory.create().execute(new HttpGet(url));
                if (response.getStatusLine().getStatusCode() != 200) {
                    Log.d("MoPub", "Conversion track failed: Status code != 200.");
                    return;
                }
                HttpEntity entity = response.getEntity();
                if (entity == null || entity.getContentLength() == 0) {
                    Log.d("MoPub", "Conversion track failed: Response was empty.");
                    return;
                }
                Log.d("MoPub", "Conversion track successful.");
                MoPubConversionTracker.this.mSharedPreferences.edit().putBoolean(MoPubConversionTracker.this.mIsTrackedKey, true).commit();
            } catch (Exception e) {
                Log.d("MoPub", "Conversion track failed [" + e.getClass().getSimpleName() + "]: " + url);
            }
        }
    }

    public MoPubConversionTracker() {
        this.mConversionTrackerGpsHelperListener = new ConversionTrackerGpsHelperListener();
    }

    public void reportAppOpen(Context context) {
        if (context != null) {
            this.mContext = context;
            this.mPackageName = this.mContext.getPackageName();
            this.mIsTrackedKey = this.mPackageName + " tracked";
            this.mSharedPreferences = SharedPreferencesHelper.getSharedPreferences(this.mContext);
            if (isAlreadyTracked()) {
                Log.d("MoPub", "Conversion already tracked");
            } else {
                GpsHelper.asyncFetchAdvertisingInfo(this.mContext, this.mConversionTrackerGpsHelperListener);
            }
        }
    }

    private boolean isAlreadyTracked() {
        return this.mSharedPreferences.getBoolean(this.mIsTrackedKey, false);
    }
}
