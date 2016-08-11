package com.mopub.nativeads;

import android.os.AsyncTask;
import com.mopub.common.util.AsyncTasks;
import com.mopub.common.util.IntentUtils;
import com.mopub.common.util.MoPubLog;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

class UrlResolutionTask extends AsyncTask {
    private static final int REDIRECT_LIMIT = 10;
    private final UrlResolutionListener mListener;

    interface UrlResolutionListener {
        void onFailure();

        void onSuccess(String str);
    }

    public static void getResolvedUrl(String urlString, UrlResolutionListener listener) {
        try {
            AsyncTasks.safeExecuteOnExecutor(new UrlResolutionTask(listener), urlString);
        } catch (Exception e) {
            MoPubLog.m9730d("Failed to resolve url", e);
            listener.onFailure();
        }
    }

    UrlResolutionTask(UrlResolutionListener listener) {
        this.mListener = listener;
    }

    protected String doInBackground(String... urls) {
        if (urls == null || urls.length == 0) {
            return null;
        }
        String previousUrl = null;
        try {
            String locationUrl = urls[0];
            int redirectCount = 0;
            while (locationUrl != null && redirectCount < REDIRECT_LIMIT) {
                if (!IntentUtils.isHttpUrl(locationUrl)) {
                    return locationUrl;
                }
                previousUrl = locationUrl;
                locationUrl = getRedirectLocation(locationUrl);
                redirectCount++;
            }
            return previousUrl;
        } catch (IOException e) {
            return null;
        }
    }

    private String getRedirectLocation(String urlString) {
        HttpURLConnection httpUrlConnection = null;
        try {
            httpUrlConnection = (HttpURLConnection) new URL(urlString).openConnection();
            httpUrlConnection.setInstanceFollowRedirects(false);
            int responseCode = httpUrlConnection.getResponseCode();
            String str;
            if (responseCode < 300 || responseCode >= 400) {
                str = null;
                if (httpUrlConnection != null) {
                    httpUrlConnection.disconnect();
                }
                return str;
            }
            str = httpUrlConnection.getHeaderField("Location");
            return str;
        } finally {
            if (httpUrlConnection != null) {
                httpUrlConnection.disconnect();
            }
        }
    }

    protected void onPostExecute(String resolvedUrl) {
        super.onPostExecute(resolvedUrl);
        if (isCancelled() || resolvedUrl == null) {
            onCancelled();
        } else {
            this.mListener.onSuccess(resolvedUrl);
        }
    }

    protected void onCancelled() {
        super.onCancelled();
        this.mListener.onFailure();
    }
}
