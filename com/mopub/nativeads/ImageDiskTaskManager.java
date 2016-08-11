package com.mopub.nativeads;

import android.graphics.Bitmap;
import com.mopub.common.CacheService;
import com.mopub.common.CacheService.DiskLruCacheGetListener;
import java.util.List;

class ImageDiskTaskManager extends ImageTaskManager {
    private final List mUrls;

    private class ImageDiskTaskListener implements DiskLruCacheGetListener {
        private ImageDiskTaskListener() {
        }

        public void onComplete(String key, byte[] content) {
            if (key == null) {
                ImageDiskTaskManager.this.failAllTasks();
                return;
            }
            Bitmap bitmap = null;
            if (content != null) {
                bitmap = ImageService.byteArrayToBitmap(content);
            }
            ImageDiskTaskManager.this.mImages.put(key, bitmap);
            if (ImageDiskTaskManager.this.mCompletedCount.incrementAndGet() == ImageDiskTaskManager.this.mSize) {
                ImageDiskTaskManager.this.mImageTaskManagerListener.onSuccess(ImageDiskTaskManager.this.mImages);
            }
        }
    }

    ImageDiskTaskManager(List urls, ImageTaskManagerListener imageTaskManagerListener) {
        super(urls, imageTaskManagerListener);
        this.mUrls = urls;
    }

    void execute() {
        if (this.mUrls.isEmpty()) {
            this.mImageTaskManagerListener.onSuccess(this.mImages);
        }
        ImageDiskTaskListener imageDiskTaskListener = new ImageDiskTaskListener();
        for (String url : this.mUrls) {
            CacheService.getFromDiskCacheAsync(url, imageDiskTaskListener);
        }
    }

    void failAllTasks() {
        if (this.mFailed.compareAndSet(false, true)) {
            this.mImageTaskManagerListener.onFail();
        }
    }
}
