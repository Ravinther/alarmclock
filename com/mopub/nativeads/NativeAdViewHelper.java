package com.mopub.nativeads;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import com.mopub.common.util.MoPubLog;
import com.mopub.nativeads.MoPubNative.MoPubNativeListener;

class NativeAdViewHelper {

    static class NativeViewClickListener implements OnClickListener {
        private final NativeResponse mNativeResponse;

        NativeViewClickListener(NativeResponse nativeResponse) {
            this.mNativeResponse = nativeResponse;
        }

        public void onClick(View view) {
            this.mNativeResponse.handleClick(view);
        }
    }

    private NativeAdViewHelper() {
    }

    static View getAdView(View convertView, ViewGroup parent, Context context, NativeResponse nativeResponse, ViewBinder viewBinder, MoPubNativeListener moPubNativeListener) {
        if (viewBinder == null) {
            MoPubLog.m9729d("ViewBinder is null, returning empty view.");
            return new View(context);
        }
        if (convertView == null) {
            convertView = createConvertView(context, parent, viewBinder);
        }
        NativeViewHolder nativeViewHolder = getOrCreateNativeViewHolder(convertView, viewBinder);
        removeClickListeners(convertView, nativeViewHolder);
        ImpressionTrackingManager.removeView(convertView);
        if (nativeResponse == null) {
            MoPubLog.m9729d("NativeResponse is null, returning hidden view.");
            convertView.setVisibility(8);
            return convertView;
        } else if (nativeResponse.isDestroyed()) {
            MoPubLog.m9729d("NativeResponse is destroyed, returning hidden view.");
            convertView.setVisibility(8);
            return convertView;
        } else if (nativeViewHolder == null) {
            MoPubLog.m9729d("Could not create NativeViewHolder, returning hidden view.");
            convertView.setVisibility(8);
            return convertView;
        } else {
            populateConvertViewSubViews(convertView, nativeViewHolder, nativeResponse, viewBinder);
            attachClickListeners(convertView, nativeViewHolder, nativeResponse);
            convertView.setVisibility(0);
            nativeResponse.prepareImpression(convertView);
            return convertView;
        }
    }

    private static View createConvertView(Context context, ViewGroup parent, ViewBinder viewBinder) {
        return LayoutInflater.from(context).inflate(viewBinder.layoutId, parent, false);
    }

    static NativeViewHolder getOrCreateNativeViewHolder(View convertView, ViewBinder viewBinder) {
        Object object = ImageViewService.getViewTag(convertView);
        if (object != null && (object instanceof NativeViewHolder)) {
            return (NativeViewHolder) object;
        }
        NativeViewHolder nativeViewHolder = NativeViewHolder.fromViewBinder(convertView, viewBinder);
        ImageViewService.setViewTag(convertView, nativeViewHolder);
        return nativeViewHolder;
    }

    private static void populateConvertViewSubViews(View convertView, NativeViewHolder nativeViewHolder, NativeResponse nativeResponse, ViewBinder viewBinder) {
        nativeViewHolder.update(nativeResponse);
        nativeViewHolder.updateExtras(convertView, nativeResponse, viewBinder);
    }

    private static void removeClickListeners(View view, NativeViewHolder nativeViewHolder) {
        if (view != null) {
            view.setOnClickListener(null);
            setCtaClickListener(nativeViewHolder, null);
        }
    }

    private static void attachClickListeners(View view, NativeViewHolder nativeViewHolder, NativeResponse nativeResponse) {
        if (view != null && nativeResponse != null) {
            NativeViewClickListener nativeViewClickListener = new NativeViewClickListener(nativeResponse);
            view.setOnClickListener(nativeViewClickListener);
            setCtaClickListener(nativeViewHolder, nativeViewClickListener);
        }
    }

    private static void setCtaClickListener(NativeViewHolder nativeViewHolder, NativeViewClickListener nativeViewClickListener) {
        if (nativeViewHolder != null && nativeViewClickListener != null && nativeViewHolder.callToActionView != null && (nativeViewHolder.callToActionView instanceof Button)) {
            nativeViewHolder.callToActionView.setOnClickListener(nativeViewClickListener);
        }
    }
}
