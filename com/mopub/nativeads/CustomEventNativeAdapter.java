package com.mopub.nativeads;

import android.content.Context;
import com.mopub.common.DownloadResponse;
import com.mopub.common.HttpResponses;
import com.mopub.common.util.Json;
import com.mopub.common.util.MoPubLog;
import com.mopub.common.util.ResponseHeader;
import com.mopub.nativeads.CustomEventNative.CustomEventNativeListener;
import com.mopub.nativeads.factories.CustomEventNativeFactory;
import java.util.HashMap;
import java.util.Map;

final class CustomEventNativeAdapter {
    static final String RESPONSE_BODY_KEY = "response_body_key";

    private CustomEventNativeAdapter() {
    }

    public static void loadNativeAd(Context context, Map localExtras, DownloadResponse downloadResponse, CustomEventNativeListener customEventNativeListener) {
        String customEventNativeData = downloadResponse.getFirstHeader(ResponseHeader.CUSTOM_EVENT_DATA);
        String customEventNativeClassName = downloadResponse.getFirstHeader(ResponseHeader.CUSTOM_EVENT_NAME);
        try {
            CustomEventNative customEventNative = CustomEventNativeFactory.create(customEventNativeClassName);
            Map serverExtras = new HashMap();
            try {
                serverExtras = Json.jsonStringToMap(customEventNativeData);
            } catch (Exception e) {
                MoPubLog.m9734w("Failed to create Map from JSON: " + customEventNativeData, e);
            }
            serverExtras.put(RESPONSE_BODY_KEY, HttpResponses.asResponseString(downloadResponse));
            customEventNative.loadNativeAd(context, customEventNativeListener, localExtras, serverExtras);
        } catch (Exception e2) {
            MoPubLog.m9733w("Failed to load Custom Event Native class: " + customEventNativeClassName);
            customEventNativeListener.onNativeAdFailed(NativeErrorCode.NATIVE_ADAPTER_NOT_FOUND);
        }
    }
}
