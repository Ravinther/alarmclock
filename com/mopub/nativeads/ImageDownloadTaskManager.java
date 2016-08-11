package com.mopub.nativeads;

import android.graphics.Bitmap;
import com.mopub.common.DownloadResponse;
import com.mopub.common.DownloadTask;
import com.mopub.common.DownloadTask.DownloadTaskListener;
import com.mopub.common.HttpResponses;
import com.mopub.common.util.AsyncTasks;
import com.mopub.common.util.MoPubLog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;

class ImageDownloadTaskManager extends ImageTaskManager {
    private final Map mDownloadTasks;

    private class ImageDownloadTaskListener implements DownloadTaskListener {
        private ImageDownloadTaskListener() {
        }

        public void onComplete(String url, DownloadResponse downloadResponse) {
            if (downloadResponse == null || downloadResponse.getStatusCode() != 200) {
                MoPubLog.m9729d("Failed to download image: " + url);
                ImageDownloadTaskManager.this.failAllTasks();
                return;
            }
            Bitmap bitmap = HttpResponses.asBitmap(downloadResponse);
            if (bitmap == null) {
                MoPubLog.m9729d("Failed to decode bitmap from response for image: " + url);
                ImageDownloadTaskManager.this.failAllTasks();
                return;
            }
            MoPubLog.m9729d("Successfully downloaded image: " + url);
            ImageDownloadTaskManager.this.mImages.put(url, bitmap);
            if (ImageDownloadTaskManager.this.mCompletedCount.incrementAndGet() == ImageDownloadTaskManager.this.mSize) {
                ImageDownloadTaskManager.this.mImageTaskManagerListener.onSuccess(ImageDownloadTaskManager.this.mImages);
            }
        }
    }

    ImageDownloadTaskManager(List urls, ImageTaskManagerListener imageTaskManagerListener) {
        super(urls, imageTaskManagerListener);
        DownloadTaskListener downloadTaskListener = new ImageDownloadTaskListener();
        this.mDownloadTasks = new HashMap(urls.size());
        for (String url : urls) {
            this.mDownloadTasks.put(new HttpGet(url), new DownloadTask(downloadTaskListener));
        }
    }

    void execute() {
        if (this.mDownloadTasks.isEmpty()) {
            this.mImageTaskManagerListener.onSuccess(this.mImages);
        }
        for (Entry entry : this.mDownloadTasks.entrySet()) {
            try {
                AsyncTasks.safeExecuteOnExecutor((DownloadTask) entry.getValue(), (HttpUriRequest) ((Entry) i$.next()).getKey());
            } catch (Exception e) {
                MoPubLog.m9730d("Failed to download image", e);
                this.mImageTaskManagerListener.onFail();
            }
        }
    }

    void failAllTasks() {
        if (this.mFailed.compareAndSet(false, true)) {
            for (DownloadTask downloadTask : this.mDownloadTasks.values()) {
                downloadTask.cancel(true);
            }
            this.mImageTaskManagerListener.onFail();
        }
    }
}
