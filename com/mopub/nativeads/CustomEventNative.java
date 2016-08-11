package com.mopub.nativeads;

import android.content.Context;
import java.util.List;
import java.util.Map;

public abstract class CustomEventNative {

    /* renamed from: com.mopub.nativeads.CustomEventNative.1 */
    class C26381 implements ImageServiceListener {
        final /* synthetic */ ImageListener val$imageListener;

        C26381(ImageListener imageListener) {
            this.val$imageListener = imageListener;
        }

        public void onSuccess(Map bitmaps) {
            this.val$imageListener.onImagesCached();
        }

        public void onFail() {
            this.val$imageListener.onImagesFailedToCache(NativeErrorCode.IMAGE_DOWNLOAD_FAILURE);
        }
    }

    public interface CustomEventNativeListener {
        void onNativeAdFailed(NativeErrorCode nativeErrorCode);

        void onNativeAdLoaded(NativeAdInterface nativeAdInterface);
    }

    public interface ImageListener {
        void onImagesCached();

        void onImagesFailedToCache(NativeErrorCode nativeErrorCode);
    }

    protected abstract void loadNativeAd(Context context, CustomEventNativeListener customEventNativeListener, Map map, Map map2);

    final void preCacheImages(Context context, List imageUrls, ImageListener imageListener) {
        ImageService.get(context, imageUrls, new C26381(imageListener));
    }
}
