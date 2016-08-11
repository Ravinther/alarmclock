package com.mopub.mobileads;

import android.os.AsyncTask;
import android.util.Log;
import com.mopub.common.util.ResponseHeader;
import com.mopub.mobileads.factories.HttpClientFactory;
import com.mopub.mobileads.util.Base64;
import com.mopub.mobileads.util.HttpResponses;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ClientConnectionManager;

public class AdFetchTask extends AsyncTask {
    private static final double EXPONENTIAL_BACKOFF_FACTOR = 1.5d;
    private static final int MAXIMUM_REFRESH_TIME_MILLISECONDS = 600000;
    private AdViewController mAdViewController;
    private Exception mException;
    private FetchStatus mFetchStatus;
    private HttpClient mHttpClient;
    private long mTaskId;
    private TaskTracker mTaskTracker;
    private String mUserAgent;

    /* renamed from: com.mopub.mobileads.AdFetchTask.1 */
    static /* synthetic */ class C25881 {
        static final /* synthetic */ int[] $SwitchMap$com$mopub$mobileads$AdFetcher$FetchStatus;

        static {
            $SwitchMap$com$mopub$mobileads$AdFetcher$FetchStatus = new int[FetchStatus.values().length];
            try {
                $SwitchMap$com$mopub$mobileads$AdFetcher$FetchStatus[FetchStatus.NOT_SET.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$mopub$mobileads$AdFetcher$FetchStatus[FetchStatus.FETCH_CANCELLED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$mopub$mobileads$AdFetcher$FetchStatus[FetchStatus.INVALID_SERVER_RESPONSE_BACKOFF.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$mopub$mobileads$AdFetcher$FetchStatus[FetchStatus.INVALID_SERVER_RESPONSE_NOBACKOFF.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$mopub$mobileads$AdFetcher$FetchStatus[FetchStatus.CLEAR_AD_TYPE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$mopub$mobileads$AdFetcher$FetchStatus[FetchStatus.AD_WARMING_UP.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    public AdFetchTask(TaskTracker taskTracker, AdViewController adViewController, String userAgent, int timeoutMilliseconds) {
        this.mFetchStatus = FetchStatus.NOT_SET;
        this.mTaskTracker = taskTracker;
        this.mAdViewController = adViewController;
        this.mHttpClient = HttpClientFactory.create(timeoutMilliseconds);
        this.mTaskId = this.mTaskTracker.getCurrentTaskId();
        this.mUserAgent = userAgent;
    }

    protected AdLoadTask doInBackground(String... urls) {
        AdLoadTask result = null;
        try {
            result = fetch(urls[0]);
        } catch (Exception exception) {
            this.mException = exception;
        } finally {
            shutdownHttpClient();
        }
        return result;
    }

    private AdLoadTask fetch(String url) {
        HttpGet httpget = new HttpGet(url);
        httpget.addHeader(ResponseHeader.USER_AGENT.getKey(), this.mUserAgent);
        if (!isStateValid()) {
            return null;
        }
        HttpResponse response = this.mHttpClient.execute(httpget);
        if (!isResponseValid(response)) {
            return null;
        }
        this.mAdViewController.configureUsingHttpResponse(response);
        if (responseContainsContent(response)) {
            return AdLoadTask.fromHttpResponse(response, this.mAdViewController);
        }
        return null;
    }

    private boolean responseContainsContent(HttpResponse response) {
        if ("1".equals(HttpResponses.extractHeader(response, ResponseHeader.WARMUP))) {
            Log.d("MoPub", "Ad Unit (" + this.mAdViewController.getAdUnitId() + ") is still warming up. " + "Please try again in a few minutes.");
            this.mFetchStatus = FetchStatus.AD_WARMING_UP;
            return false;
        }
        if (!"clear".equals(HttpResponses.extractHeader(response, ResponseHeader.AD_TYPE))) {
            return true;
        }
        Log.d("MoPub", "No inventory found for adunit (" + this.mAdViewController.getAdUnitId() + ").");
        this.mFetchStatus = FetchStatus.CLEAR_AD_TYPE;
        return false;
    }

    private boolean isResponseValid(HttpResponse response) {
        if (response == null || response.getEntity() == null) {
            Log.d("MoPub", "MoPub server returned null response.");
            this.mFetchStatus = FetchStatus.INVALID_SERVER_RESPONSE_NOBACKOFF;
            return false;
        }
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode >= 400) {
            Log.d("MoPub", "Server error: returned HTTP status code " + Integer.toString(statusCode) + ". Please try again.");
            this.mFetchStatus = FetchStatus.INVALID_SERVER_RESPONSE_BACKOFF;
            return false;
        } else if (statusCode == 200) {
            return true;
        } else {
            Log.d("MoPub", "MoPub server returned invalid response: HTTP status code " + Integer.toString(statusCode) + ".");
            this.mFetchStatus = FetchStatus.INVALID_SERVER_RESPONSE_NOBACKOFF;
            return false;
        }
    }

    private boolean isStateValid() {
        if (isCancelled()) {
            this.mFetchStatus = FetchStatus.FETCH_CANCELLED;
            return false;
        } else if (this.mAdViewController != null && !this.mAdViewController.isDestroyed()) {
            return true;
        } else {
            Log.d("MoPub", "Error loading ad: AdViewController has already been GCed or destroyed.");
            return false;
        }
    }

    protected void onPostExecute(AdLoadTask adLoadTask) {
        if (!isMostCurrentTask()) {
            Log.d("MoPub", "Ad response is stale.");
            cleanup();
        } else if (this.mAdViewController == null || this.mAdViewController.isDestroyed()) {
            if (adLoadTask != null) {
                adLoadTask.cleanup();
            }
            this.mTaskTracker.markTaskCompleted(this.mTaskId);
            cleanup();
        } else {
            if (adLoadTask == null) {
                MoPubErrorCode errorCode;
                if (this.mException != null) {
                    Log.d("MoPub", "Exception caught while loading ad: " + this.mException);
                }
                switch (C25881.$SwitchMap$com$mopub$mobileads$AdFetcher$FetchStatus[this.mFetchStatus.ordinal()]) {
                    case Base64.NO_PADDING /*1*/:
                        errorCode = MoPubErrorCode.UNSPECIFIED;
                        break;
                    case Base64.NO_WRAP /*2*/:
                        errorCode = MoPubErrorCode.CANCELLED;
                        break;
                    case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    case Base64.CRLF /*4*/:
                        errorCode = MoPubErrorCode.SERVER_ERROR;
                        break;
                    case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                        errorCode = MoPubErrorCode.NO_FILL;
                        break;
                    default:
                        errorCode = MoPubErrorCode.UNSPECIFIED;
                        break;
                }
                this.mAdViewController.adDidFail(errorCode);
                if (this.mFetchStatus == FetchStatus.INVALID_SERVER_RESPONSE_BACKOFF) {
                    exponentialBackoff();
                    this.mFetchStatus = FetchStatus.NOT_SET;
                }
            } else {
                adLoadTask.execute();
                adLoadTask.cleanup();
            }
            this.mTaskTracker.markTaskCompleted(this.mTaskId);
            cleanup();
        }
    }

    protected void onCancelled() {
        if (isMostCurrentTask()) {
            Log.d("MoPub", "Ad loading was cancelled.");
            if (this.mException != null) {
                Log.d("MoPub", "Exception caught while loading ad: " + this.mException);
            }
            this.mTaskTracker.markTaskCompleted(this.mTaskId);
            cleanup();
            return;
        }
        Log.d("MoPub", "Ad response is stale.");
        cleanup();
    }

    private void exponentialBackoff() {
        if (this.mAdViewController != null) {
            int refreshTimeMilliseconds = (int) (((double) this.mAdViewController.getRefreshTimeMilliseconds()) * EXPONENTIAL_BACKOFF_FACTOR);
            if (refreshTimeMilliseconds > MAXIMUM_REFRESH_TIME_MILLISECONDS) {
                refreshTimeMilliseconds = MAXIMUM_REFRESH_TIME_MILLISECONDS;
            }
            this.mAdViewController.setRefreshTimeMilliseconds(refreshTimeMilliseconds);
        }
    }

    private void cleanup() {
        this.mTaskTracker = null;
        this.mException = null;
        this.mFetchStatus = FetchStatus.NOT_SET;
    }

    private void shutdownHttpClient() {
        if (this.mHttpClient != null) {
            ClientConnectionManager manager = this.mHttpClient.getConnectionManager();
            if (manager != null) {
                manager.shutdown();
            }
            this.mHttpClient = null;
        }
    }

    private boolean isMostCurrentTask() {
        return this.mTaskTracker == null ? false : this.mTaskTracker.isMostCurrentTask(this.mTaskId);
    }
}
