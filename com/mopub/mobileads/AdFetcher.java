package com.mopub.mobileads;

import android.util.Log;
import com.mopub.common.util.AsyncTasks;
import com.mopub.mobileads.factories.AdFetchTaskFactory;

public class AdFetcher {
    public static final String AD_CONFIGURATION_KEY = "Ad-Configuration";
    public static final String CLICKTHROUGH_URL_KEY = "Clickthrough-Url";
    public static final String HTML_RESPONSE_BODY_KEY = "Html-Response-Body";
    public static final String REDIRECT_URL_KEY = "Redirect-Url";
    public static final String SCROLLABLE_KEY = "Scrollable";
    private AdViewController mAdViewController;
    private AdFetchTask mCurrentTask;
    private final TaskTracker mTaskTracker;
    private int mTimeoutMilliseconds;
    private String mUserAgent;

    enum FetchStatus {
        NOT_SET,
        FETCH_CANCELLED,
        INVALID_SERVER_RESPONSE_BACKOFF,
        INVALID_SERVER_RESPONSE_NOBACKOFF,
        CLEAR_AD_TYPE,
        AD_WARMING_UP
    }

    public AdFetcher(AdViewController adview, String userAgent) {
        this.mTimeoutMilliseconds = CustomEventBannerAdapter.DEFAULT_BANNER_TIMEOUT_DELAY;
        this.mAdViewController = adview;
        this.mUserAgent = userAgent;
        this.mTaskTracker = new TaskTracker();
    }

    public void fetchAdForUrl(String url) {
        this.mTaskTracker.newTaskStarted();
        Log.i("MoPub", "Fetching ad for task #" + getCurrentTaskId());
        if (this.mCurrentTask != null) {
            this.mCurrentTask.cancel(true);
        }
        this.mCurrentTask = AdFetchTaskFactory.create(this.mTaskTracker, this.mAdViewController, this.mUserAgent, this.mTimeoutMilliseconds);
        try {
            AsyncTasks.safeExecuteOnExecutor(this.mCurrentTask, url);
        } catch (Exception exception) {
            Log.d("MoPub", "Error executing AdFetchTask", exception);
        }
    }

    public void cancelFetch() {
        if (this.mCurrentTask != null) {
            Log.i("MoPub", "Canceling fetch ad for task #" + getCurrentTaskId());
            this.mCurrentTask.cancel(true);
        }
    }

    void cleanup() {
        cancelFetch();
        this.mAdViewController = null;
        this.mUserAgent = "";
    }

    protected void setTimeout(int milliseconds) {
        this.mTimeoutMilliseconds = milliseconds;
    }

    private long getCurrentTaskId() {
        return this.mTaskTracker.getCurrentTaskId();
    }
}
