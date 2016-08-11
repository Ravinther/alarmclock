package com.millennialmedia.android;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.plus.PlusShare;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.Callable;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.json.JSONArray;

class BridgeMMCachedVideo extends MMJSObject implements AdCacheTaskListener {
    private boolean success;

    /* renamed from: com.millennialmedia.android.BridgeMMCachedVideo.1 */
    class C24421 extends Iterator {
        final /* synthetic */ JSONArray val$array;
        final /* synthetic */ Context val$context;

        C24421(Context context, JSONArray jSONArray) {
            this.val$context = context;
            this.val$array = jSONArray;
        }

        boolean callback(CachedAd ad) {
            if ((ad instanceof VideoAd) && ad.isOnDisk(this.val$context) && !ad.isExpired()) {
                this.val$array.put(ad.getId());
            }
            return true;
        }
    }

    /* renamed from: com.millennialmedia.android.BridgeMMCachedVideo.2 */
    class C24432 implements Callable {
        final /* synthetic */ VideoPlayerActivity val$vpa;

        C24432(VideoPlayerActivity videoPlayerActivity) {
            this.val$vpa = videoPlayerActivity;
        }

        public MMJSResponse call() {
            this.val$vpa.resumeVideo();
            return MMJSResponse.responseWithSuccess();
        }
    }

    /* renamed from: com.millennialmedia.android.BridgeMMCachedVideo.3 */
    class C24443 implements Callable {
        final /* synthetic */ VideoPlayerActivity val$vpa;

        C24443(VideoPlayerActivity videoPlayerActivity) {
            this.val$vpa = videoPlayerActivity;
        }

        public MMJSResponse call() {
            this.val$vpa.endVideo();
            return MMJSResponse.responseWithSuccess();
        }
    }

    /* renamed from: com.millennialmedia.android.BridgeMMCachedVideo.4 */
    class C24454 implements Callable {
        final /* synthetic */ VideoPlayerActivity val$vpa;

        C24454(VideoPlayerActivity videoPlayerActivity) {
            this.val$vpa = videoPlayerActivity;
        }

        public MMJSResponse call() {
            this.val$vpa.pauseVideoByUser();
            return MMJSResponse.responseWithSuccess();
        }
    }

    /* renamed from: com.millennialmedia.android.BridgeMMCachedVideo.5 */
    class C24465 implements Callable {
        final /* synthetic */ VideoPlayerActivity val$vpa;

        C24465(VideoPlayerActivity videoPlayerActivity) {
            this.val$vpa = videoPlayerActivity;
        }

        public MMJSResponse call() {
            this.val$vpa.restartVideo();
            return MMJSResponse.responseWithSuccess();
        }
    }

    BridgeMMCachedVideo() {
    }

    @Deprecated
    public MMJSResponse videoIdExists(HashMap arguments) {
        Context context = (Context) this.contextRef.get();
        String videoId = (String) arguments.get("videoId");
        if (!(videoId == null || context == null)) {
            VideoAd ad = (VideoAd) AdCache.load(context, videoId);
            if (!(ad == null || !ad.isOnDisk(context) || ad.isExpired())) {
                return MMJSResponse.responseWithSuccess(videoId);
            }
        }
        return null;
    }

    public MMJSResponse availableCachedVideos(HashMap arguments) {
        Context context = (Context) this.contextRef.get();
        if (context == null) {
            return null;
        }
        JSONArray array = new JSONArray();
        AdCache.iterateCachedAds(context, 2, new C24421(context, array));
        MMJSResponse response = new MMJSResponse();
        response.result = 1;
        response.response = array;
        return response;
    }

    public MMJSResponse playCachedVideo(HashMap arguments) {
        Context context = (Context) this.contextRef.get();
        String videoId = (String) arguments.get("videoId");
        if (videoId == null || context == null) {
            return null;
        }
        VideoAd ad = (VideoAd) AdCache.load(context, videoId);
        if (ad == null || !ad.canShow(context, null, false)) {
            return null;
        }
        ad.show(context, getAdImplId((String) arguments.get("PROPERTY_EXPANDING")));
        return MMJSResponse.responseWithSuccess(String.format("Playing Video(%s)", new Object[]{videoId}));
    }

    public void downloadCompleted(CachedAd ad, boolean success) {
        synchronized (this) {
            Context context = (Context) this.contextRef.get();
            if (success && context != null) {
                AdCache.save(context, ad);
            }
            this.success = success;
            notify();
        }
    }

    public synchronized MMJSResponse cacheVideo(HashMap arguments) {
        MMJSResponse mMJSResponse = null;
        synchronized (this) {
            Context context = (Context) this.contextRef.get();
            String url = (String) arguments.get(PlusShare.KEY_CALL_TO_ACTION_URL);
            if (!(url == null || context == null)) {
                try {
                    HttpResponse httpResponse = new HttpGetRequest().get(url);
                    if (httpResponse == null) {
                        Log.m9717i("HTTP response is null");
                    } else {
                        HttpEntity httpEntity = httpResponse.getEntity();
                        if (httpEntity == null) {
                            Log.m9711d("Null HTTP entity");
                        } else if (httpEntity.getContentLength() == 0) {
                            Log.m9711d("Millennial ad return failed. Zero content length returned.");
                        } else {
                            Header httpHeader = httpEntity.getContentType();
                            if (!(httpHeader == null || httpHeader.getValue() == null || !httpHeader.getValue().equalsIgnoreCase("application/json"))) {
                                try {
                                    VideoAd videoAd = new VideoAd(HttpGetRequest.convertStreamToString(httpEntity.getContent()));
                                    if (videoAd != null && videoAd.isValid()) {
                                        videoAd.downloadPriority = 3;
                                        if (AdCache.startDownloadTask(context, null, videoAd, this)) {
                                            try {
                                                wait();
                                                if (this.success) {
                                                    mMJSResponse = MMJSResponse.responseWithSuccess(String.format("Cached video(%s)", new Object[]{url}));
                                                } else {
                                                    notify();
                                                }
                                            } catch (Throwable e) {
                                                Log.m9716e(e);
                                                Log.m9715e("Caching interrupted: %s", e.getMessage());
                                            } finally {
                                                notify();
                                            }
                                        } else {
                                            mMJSResponse = MMJSResponse.responseWithError(String.format("Unable to start download for Cached video(%s)", new Object[]{url}));
                                        }
                                    }
                                } catch (IllegalStateException e1) {
                                    e1.printStackTrace();
                                    Log.m9711d("Millennial ad return failed. Invalid response data.");
                                } catch (IOException e12) {
                                    e12.printStackTrace();
                                    Log.m9711d("Millennial ad return failed. Invalid response data.");
                                }
                            }
                        }
                    }
                } catch (Exception e2) {
                    Log.m9711d("HTTP error: " + e2.getMessage());
                }
            }
        }
        return mMJSResponse;
    }

    public MMJSResponse playVideo(HashMap arguments) {
        VideoPlayerActivity vpa = getVPA();
        if (vpa != null) {
            return runOnUiThreadFuture(new C24432(vpa));
        }
        return null;
    }

    public MMJSResponse endVideo(HashMap arguments) {
        VideoPlayerActivity vpa = getVPA();
        if (vpa != null) {
            return runOnUiThreadFuture(new C24443(vpa));
        }
        return null;
    }

    public MMJSResponse pauseVideo(HashMap arguments) {
        VideoPlayerActivity vpa = getVPA();
        if (vpa != null) {
            return runOnUiThreadFuture(new C24454(vpa));
        }
        return null;
    }

    public MMJSResponse restartVideo(HashMap arguments) {
        VideoPlayerActivity vpa = getVPA();
        if (vpa != null) {
            return runOnUiThreadFuture(new C24465(vpa));
        }
        return null;
    }

    private VideoPlayerActivity getVPA() {
        if (this.mmWebViewRef == null || this.mmWebViewRef.get() == null || !(((MMWebView) this.mmWebViewRef.get()).getActivity() instanceof MMActivity)) {
            return null;
        }
        MMWebView webView = (MMWebView) this.mmWebViewRef.get();
        if (webView == null) {
            return null;
        }
        Activity activity = webView.getActivity();
        if (activity == null || !(activity instanceof MMActivity)) {
            return null;
        }
        MMActivity mmActivity = (MMActivity) activity;
        if (mmActivity.getWrappedActivity() == null || !(mmActivity.getWrappedActivity() instanceof VideoPlayerActivity)) {
            return null;
        }
        return (VideoPlayerActivity) mmActivity.getWrappedActivity();
    }

    public void downloadStart(CachedAd ad) {
    }
}
