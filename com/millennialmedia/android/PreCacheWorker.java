package com.millennialmedia.android;

import android.content.Context;
import android.text.TextUtils;
import java.io.IOException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

class PreCacheWorker extends Thread {
    private static boolean busy;
    private Context appContext;
    private DTOCachedVideo[] cachedVideos;
    private volatile boolean downloadedNewVideos;
    private String noVideosToCacheURL;

    /* renamed from: com.millennialmedia.android.PreCacheWorker.1 */
    class C25121 implements AdCacheTaskListener {
        final /* synthetic */ DTOCachedVideo val$cachedVideo;

        C25121(DTOCachedVideo dTOCachedVideo) {
            this.val$cachedVideo = dTOCachedVideo;
        }

        public void downloadStart(CachedAd ad) {
            Event.logEvent(this.val$cachedVideo.preCacheStartURL);
        }

        public synchronized void downloadCompleted(CachedAd ad, boolean success) {
            if (success) {
                AdCache.save(PreCacheWorker.this.appContext, ad);
                PreCacheWorker.this.downloadedNewVideos = true;
                Event.logEvent(this.val$cachedVideo.preCacheCompleteURL);
            } else {
                Event.logEvent(this.val$cachedVideo.preCacheFailedURL);
            }
            notify();
        }
    }

    static synchronized void preCacheVideos(DTOCachedVideo[] cachedVideos, Context context, String noVideosToCacheURL) {
        synchronized (PreCacheWorker.class) {
            if (!busy) {
                busy = true;
                new PreCacheWorker(cachedVideos, context, noVideosToCacheURL).start();
            }
        }
    }

    private PreCacheWorker(DTOCachedVideo[] cachedVideos, Context context, String noVideosToCacheURL) {
        this.downloadedNewVideos = false;
        this.cachedVideos = cachedVideos;
        this.noVideosToCacheURL = noVideosToCacheURL;
        this.appContext = context.getApplicationContext();
    }

    public synchronized void run() {
        if (this.cachedVideos != null) {
            for (DTOCachedVideo cachedVideo : this.cachedVideos) {
                try {
                    HttpResponse httpResponse = new HttpGetRequest().get(cachedVideo.url);
                    if (httpResponse == null) {
                        Log.m9711d("Pre cache worker: HTTP response is null");
                    } else {
                        HttpEntity httpEntity = httpResponse.getEntity();
                        if (httpEntity == null) {
                            Log.m9711d("Pre cache worker: Null HTTP entity");
                        } else if (httpEntity.getContentLength() == 0) {
                            Log.m9711d("Pre cache worker: Millennial ad return failed. Zero content length returned.");
                        } else {
                            handleContent(cachedVideo, httpEntity);
                        }
                    }
                } catch (Exception e) {
                    try {
                        Log.m9712d("Pre cache worker HTTP error: %s", e.getMessage());
                    } catch (Throwable th) {
                        synchronized (PreCacheWorker.class) {
                        }
                        busy = false;
                        if (!(this.downloadedNewVideos || TextUtils.isEmpty(this.noVideosToCacheURL) || this.cachedVideos != null)) {
                            Event.logEvent(this.noVideosToCacheURL);
                        }
                    }
                }
            }
        }
        synchronized (PreCacheWorker.class) {
            busy = false;
            if (!(this.downloadedNewVideos || TextUtils.isEmpty(this.noVideosToCacheURL) || this.cachedVideos != null)) {
                Event.logEvent(this.noVideosToCacheURL);
            }
        }
    }

    private void handleContent(DTOCachedVideo cachedVideo, HttpEntity httpEntity) {
        Header httpHeader = httpEntity.getContentType();
        if (httpHeader != null) {
            String contentType = httpHeader.getValue();
            if (contentType != null && contentType.equalsIgnoreCase("application/json")) {
                handleJson(cachedVideo, httpEntity);
            } else if (contentType != null && contentType.startsWith("video/")) {
                handleVideoFile(cachedVideo, httpEntity);
            }
        }
    }

    private void handleJson(DTOCachedVideo cachedVideo, HttpEntity httpEntity) {
        VideoAd videoAd = null;
        try {
            String json = HttpGetRequest.convertStreamToString(httpEntity.getContent());
            if (!TextUtils.isEmpty(json)) {
                videoAd = new VideoAd(json);
            }
            if (videoAd != null && videoAd.isValid()) {
                try {
                    videoAd.downloadPriority = 1;
                    if (AdCache.startDownloadTask(this.appContext, null, videoAd, new C25121(cachedVideo))) {
                        wait();
                        return;
                    }
                    Event.logEvent(cachedVideo.preCacheStartURL);
                    Event.logEvent(cachedVideo.preCacheFailedURL);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Log.m9715e("Pre cache worker interrupted: %s", e.getMessage());
                }
            }
        } catch (IllegalStateException e1) {
            e1.printStackTrace();
            Log.m9711d("Pre cache worker: Millennial ad return failed. Invalid response data.");
        } catch (IOException e12) {
            e12.printStackTrace();
            Log.m9711d("Pre cache worker: Millennial ad return failed. Invalid response data.");
        }
    }

    private void handleVideoFile(DTOCachedVideo cachedVideo, HttpEntity httpEntity) {
        if (!TextUtils.isEmpty(cachedVideo.videoFileId)) {
            Event.logEvent(cachedVideo.preCacheStartURL);
            if (AdCache.downloadComponentToCache(cachedVideo.url, cachedVideo.videoFileId + "video.dat", this.appContext)) {
                Event.logEvent(cachedVideo.preCacheCompleteURL);
            } else {
                Event.logEvent(cachedVideo.preCacheFailedURL);
            }
        }
    }
}
