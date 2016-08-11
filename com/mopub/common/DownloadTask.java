package com.mopub.common;

import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;
import com.mopub.common.util.MoPubLog;
import org.apache.http.client.methods.HttpUriRequest;

public class DownloadTask extends AsyncTask {
    private final DownloadTaskListener mDownloadTaskListener;
    private String mUrl;

    public interface DownloadTaskListener {
        void onComplete(String str, DownloadResponse downloadResponse);
    }

    public DownloadTask(DownloadTaskListener downloadTaskListener) {
        if (downloadTaskListener == null) {
            throw new IllegalArgumentException("DownloadTaskListener must not be null.");
        }
        this.mDownloadTaskListener = downloadTaskListener;
    }

    protected DownloadResponse doInBackground(HttpUriRequest... httpUriRequests) {
        if (httpUriRequests == null || httpUriRequests.length == 0 || httpUriRequests[0] == null) {
            MoPubLog.m9729d("Download task tried to execute null or empty url");
            return null;
        }
        HttpUriRequest httpUriRequest = httpUriRequests[0];
        this.mUrl = httpUriRequest.getURI().toString();
        AndroidHttpClient httpClient = null;
        try {
            httpClient = HttpClient.getHttpClient();
            DownloadResponse downloadResponse = new DownloadResponse(httpClient.execute(httpUriRequest));
            if (httpClient == null) {
                return downloadResponse;
            }
            httpClient.close();
            return downloadResponse;
        } catch (Exception e) {
            MoPubLog.m9729d("Download task threw an internal exception");
            cancel(true);
            return null;
        } finally {
            if (httpClient != null) {
                httpClient.close();
            }
        }
    }

    protected void onPostExecute(DownloadResponse downloadResponse) {
        if (isCancelled()) {
            onCancelled();
        } else {
            this.mDownloadTaskListener.onComplete(this.mUrl, downloadResponse);
        }
    }

    protected void onCancelled() {
        this.mDownloadTaskListener.onComplete(this.mUrl, null);
    }
}
