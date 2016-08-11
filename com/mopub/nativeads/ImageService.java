package com.mopub.nativeads;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.mopub.common.CacheService;
import com.mopub.common.util.MoPubLog;
import com.mopub.common.util.Streams;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class ImageService {
    private static int COMPRESSION_QUALITY;

    interface ImageServiceListener {
        void onFail();

        void onSuccess(Map map);
    }

    private static class ImageDiskTaskManagerListener implements ImageTaskManagerListener {
        private final Map mBitmaps;
        private final ImageServiceListener mImageServiceListener;

        ImageDiskTaskManagerListener(ImageServiceListener imageServiceListener, Map bitmaps) {
            this.mImageServiceListener = imageServiceListener;
            this.mBitmaps = bitmaps;
        }

        public void onSuccess(Map diskBitmaps) {
            List urlDiskMisses = new ArrayList();
            for (Entry entry : diskBitmaps.entrySet()) {
                if (entry.getValue() == null) {
                    urlDiskMisses.add(entry.getKey());
                } else {
                    ImageService.putBitmapInCache((String) entry.getKey(), (Bitmap) entry.getValue());
                    this.mBitmaps.put(entry.getKey(), entry.getValue());
                }
            }
            if (urlDiskMisses.isEmpty()) {
                this.mImageServiceListener.onSuccess(this.mBitmaps);
                return;
            }
            try {
                new ImageDownloadTaskManager(urlDiskMisses, new ImageNetworkTaskManagerListener(this.mImageServiceListener, this.mBitmaps)).execute();
            } catch (IllegalArgumentException e) {
                MoPubLog.m9730d("Unable to initialize ImageDownloadTaskManager", e);
                this.mImageServiceListener.onFail();
            }
        }

        public void onFail() {
            this.mImageServiceListener.onFail();
        }
    }

    private static class ImageNetworkTaskManagerListener implements ImageTaskManagerListener {
        private final Map mBitmaps;
        private final ImageServiceListener mImageServiceListener;

        ImageNetworkTaskManagerListener(ImageServiceListener imageServiceListener, Map bitmaps) {
            this.mImageServiceListener = imageServiceListener;
            this.mBitmaps = bitmaps;
        }

        public void onSuccess(Map images) {
            ImageService.putBitmapsInCache(images);
            this.mBitmaps.putAll(images);
            this.mImageServiceListener.onSuccess(this.mBitmaps);
        }

        public void onFail() {
            this.mImageServiceListener.onFail();
        }
    }

    ImageService() {
    }

    static {
        COMPRESSION_QUALITY = 25;
    }

    static void get(Context context, List urls, ImageServiceListener imageServiceListener) {
        CacheService.initializeCaches(context);
        get(urls, imageServiceListener);
    }

    static void get(List urls, ImageServiceListener imageServiceListener) {
        Map cacheBitmaps = new HashMap(urls.size());
        List urlCacheMisses = getBitmapsFromMemoryCache(urls, cacheBitmaps);
        if (urlCacheMisses.isEmpty()) {
            imageServiceListener.onSuccess(cacheBitmaps);
            return;
        }
        try {
            new ImageDiskTaskManager(urlCacheMisses, new ImageDiskTaskManagerListener(imageServiceListener, cacheBitmaps)).execute();
        } catch (IllegalArgumentException e) {
            MoPubLog.m9730d("Unable to initialize ImageDiskTaskManager", e);
            imageServiceListener.onFail();
        }
    }

    static void putBitmapsInCache(Map bitmaps) {
        for (Entry entry : bitmaps.entrySet()) {
            MoPubLog.m9729d("Caching bitmap: " + ((String) entry.getKey()));
            putBitmapInCache((String) entry.getKey(), (Bitmap) entry.getValue());
        }
    }

    static void putBitmapInCache(String key, Bitmap bitmap) {
        CacheService.put(key, bitmapToByteArray(bitmap));
    }

    static List getBitmapsFromMemoryCache(List urls, Map hits) {
        List cacheMisses = new ArrayList();
        for (String url : urls) {
            Bitmap bitmap = getBitmapFromMemoryCache(url);
            if (bitmap != null) {
                hits.put(url, bitmap);
            } else {
                cacheMisses.add(url);
            }
        }
        return cacheMisses;
    }

    static Bitmap getBitmapFromMemoryCache(String key) {
        byte[] bytes = CacheService.getFromMemoryCache(key);
        if (bytes != null) {
            return byteArrayToBitmap(bytes);
        }
        return null;
    }

    static Bitmap byteArrayToBitmap(byte[] bytes) {
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
    }

    static byte[] bitmapToByteArray(Bitmap bitmap) {
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                bitmap.compress(CompressFormat.JPEG, COMPRESSION_QUALITY, byteArrayOutputStream2);
                byte[] toByteArray = byteArrayOutputStream2.toByteArray();
                Streams.closeStream(byteArrayOutputStream2);
                return toByteArray;
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = byteArrayOutputStream2;
                Streams.closeStream(byteArrayOutputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            Streams.closeStream(byteArrayOutputStream);
            throw th;
        }
    }

    @Deprecated
    static Bitmap getBitmapFromDiskCache(String key) {
        byte[] bytes = CacheService.getFromDiskCache(key);
        if (bytes != null) {
            return byteArrayToBitmap(bytes);
        }
        return null;
    }
}
