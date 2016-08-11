package com.mopub.common;

import android.net.http.AndroidHttpClient;
import android.os.Handler;
import android.os.Looper;
import com.mopub.common.DownloadTask.DownloadTaskListener;
import com.mopub.common.util.AsyncTasks;
import com.mopub.common.util.DeviceUtils;
import com.mopub.common.util.MoPubLog;
import java.util.Arrays;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class HttpClient {
    private static final int CONNECTION_TIMEOUT = 10000;
    private static final int SOCKET_TIMEOUT = 10000;

    /* renamed from: com.mopub.common.HttpClient.1 */
    static class C25781 implements DownloadTaskListener {
        C25781() {
        }

        public void onComplete(String url, DownloadResponse downloadResponse) {
            if (downloadResponse == null || downloadResponse.getStatusCode() != 200) {
                MoPubLog.m9729d("Failed to hit tracking endpoint: " + url);
            } else if (HttpResponses.asResponseString(downloadResponse) != null) {
                MoPubLog.m9729d("Successfully hit tracking endpoint: " + url);
            } else {
                MoPubLog.m9729d("Failed to hit tracking endpoint: " + url);
            }
        }
    }

    /* renamed from: com.mopub.common.HttpClient.2 */
    static class C25792 implements Runnable {
        final /* synthetic */ DownloadTaskListener val$downloadTaskListener;
        final /* synthetic */ Iterable val$urls;

        C25792(Iterable iterable, DownloadTaskListener downloadTaskListener) {
            this.val$urls = iterable;
            this.val$downloadTaskListener = downloadTaskListener;
        }

        public void run() {
            for (String url : this.val$urls) {
                try {
                    HttpGet httpGet = new HttpGet(url);
                    AsyncTasks.safeExecuteOnExecutor(new DownloadTask(this.val$downloadTaskListener), httpGet);
                } catch (Exception e) {
                    MoPubLog.m9729d("Failed to hit tracking endpoint: " + url);
                }
            }
        }
    }

    public static AndroidHttpClient getHttpClient() {
        AndroidHttpClient httpClient = AndroidHttpClient.newInstance(DeviceUtils.getUserAgent());
        HttpParams params = httpClient.getParams();
        HttpConnectionParams.setConnectionTimeout(params, SOCKET_TIMEOUT);
        HttpConnectionParams.setSoTimeout(params, SOCKET_TIMEOUT);
        HttpClientParams.setRedirecting(params, true);
        return httpClient;
    }

    public static void makeTrackingHttpRequest(Iterable urls) {
        if (urls != null) {
            new Handler(Looper.getMainLooper()).post(new C25792(urls, new C25781()));
        }
    }

    public static void makeTrackingHttpRequest(String url) {
        makeTrackingHttpRequest(Arrays.asList(new String[]{url}));
    }
}
