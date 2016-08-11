package com.mopub.nativeads;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

abstract class ImageTaskManager {
    protected final AtomicInteger mCompletedCount;
    protected final AtomicBoolean mFailed;
    protected final ImageTaskManagerListener mImageTaskManagerListener;
    protected final Map mImages;
    protected final int mSize;

    interface ImageTaskManagerListener {
        void onFail();

        void onSuccess(Map map);
    }

    abstract void execute();

    ImageTaskManager(List urls, ImageTaskManagerListener imageTaskManagerListener) {
        if (urls == null) {
            throw new IllegalArgumentException("Urls list cannot be null");
        } else if (urls.contains(null)) {
            throw new IllegalArgumentException("Urls list cannot contain null");
        } else if (imageTaskManagerListener == null) {
            throw new IllegalArgumentException("ImageTaskManagerListener cannot be null");
        } else {
            this.mSize = urls.size();
            this.mImageTaskManagerListener = imageTaskManagerListener;
            this.mCompletedCount = new AtomicInteger(0);
            this.mFailed = new AtomicBoolean(false);
            this.mImages = Collections.synchronizedMap(new HashMap(this.mSize));
        }
    }
}
