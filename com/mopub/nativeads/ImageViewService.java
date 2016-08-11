package com.mopub.nativeads;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.mopub.common.util.MoPubLog;
import com.mopub.common.util.Utils;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Map;

class ImageViewService {
    private static final int VIEW_TAG_MOPUB_KEY = 817491827;

    private static class MyImageViewServiceListener implements ImageServiceListener {
        private final WeakReference mImageView;
        private final long mUniqueId;
        private final String mUrl;

        MyImageViewServiceListener(String url, ImageView imageView, long uniqueId) {
            this.mUrl = url;
            this.mImageView = new WeakReference(imageView);
            this.mUniqueId = uniqueId;
        }

        public void onSuccess(Map bitmaps) {
            ImageView imageView = (ImageView) this.mImageView.get();
            if (imageView != null && bitmaps != null && bitmaps.containsKey(this.mUrl)) {
                Long uniqueId = ImageViewService.getImageViewUniqueId(imageView);
                if (uniqueId != null && this.mUniqueId == uniqueId.longValue()) {
                    imageView.setImageBitmap((Bitmap) bitmaps.get(this.mUrl));
                }
            }
        }

        public void onFail() {
            MoPubLog.m9729d("Failed to load image for ImageView");
        }
    }

    private ImageViewService() {
    }

    static void loadImageView(String url, ImageView imageView) {
        if (imageView != null) {
            imageView.setImageDrawable(null);
            if (url != null) {
                setImageViewUniqueId(imageView);
                String[] strArr = new String[]{url};
                ImageService.get(Arrays.asList(strArr), new MyImageViewServiceListener(url, imageView, getImageViewUniqueId(imageView).longValue()));
            }
        }
    }

    static void setImageViewUniqueId(ImageView imageView) {
        if (imageView != null) {
            setViewTag(imageView, Long.valueOf(Utils.generateUniqueId()));
        }
    }

    static Long getImageViewUniqueId(ImageView imageView) {
        if (imageView != null) {
            Object object = getViewTag(imageView);
            if (object instanceof Long) {
                return (Long) object;
            }
        }
        return null;
    }

    static void setViewTag(View view, Object object) {
        view.setTag(VIEW_TAG_MOPUB_KEY, object);
    }

    static Object getViewTag(View view) {
        return view.getTag(VIEW_TAG_MOPUB_KEY);
    }
}
