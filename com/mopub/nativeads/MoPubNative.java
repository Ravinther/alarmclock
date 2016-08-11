package com.mopub.nativeads;

import android.content.Context;
import android.view.View;
import com.mopub.common.DownloadResponse;
import com.mopub.common.DownloadTask;
import com.mopub.common.DownloadTask.DownloadTaskListener;
import com.mopub.common.GpsHelper;
import com.mopub.common.GpsHelper.GpsHelperListener;
import com.mopub.common.util.AsyncTasks;
import com.mopub.common.util.DeviceUtils;
import com.mopub.common.util.ManifestUtils;
import com.mopub.common.util.MoPubLog;
import com.mopub.common.util.ResponseHeader;
import com.mopub.mobileads.MoPubView;
import com.mopub.nativeads.CustomEventNative.CustomEventNativeListener;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;

public final class MoPubNative {
    private final String mAdUnitId;
    private final WeakReference mContext;
    private Map mLocalExtras;
    private MoPubNativeListener mMoPubNativeListener;

    /* renamed from: com.mopub.nativeads.MoPubNative.1 */
    class C26441 implements DownloadTaskListener {

        /* renamed from: com.mopub.nativeads.MoPubNative.1.1 */
        class C26431 implements CustomEventNativeListener {
            final /* synthetic */ DownloadResponse val$downloadResponse;

            C26431(DownloadResponse downloadResponse) {
                this.val$downloadResponse = downloadResponse;
            }

            public void onNativeAdLoaded(NativeAdInterface nativeAd) {
                Context context = MoPubNative.this.getContextOrDestroy();
                if (context != null) {
                    MoPubNative.this.mMoPubNativeListener.onNativeLoad(new NativeResponse(context, this.val$downloadResponse, nativeAd, MoPubNative.this.mMoPubNativeListener));
                }
            }

            public void onNativeAdFailed(NativeErrorCode errorCode) {
                MoPubNative.this.requestNativeAd(this.val$downloadResponse.getFirstHeader(ResponseHeader.FAIL_URL));
            }
        }

        C26441() {
        }

        public void onComplete(String url, DownloadResponse downloadResponse) {
            if (downloadResponse == null) {
                MoPubNative.this.mMoPubNativeListener.onNativeFail(NativeErrorCode.UNSPECIFIED);
            } else if (downloadResponse.getStatusCode() >= 500 && downloadResponse.getStatusCode() < 600) {
                MoPubNative.this.mMoPubNativeListener.onNativeFail(NativeErrorCode.SERVER_ERROR_RESPONSE_CODE);
            } else if (downloadResponse.getStatusCode() != 200) {
                MoPubNative.this.mMoPubNativeListener.onNativeFail(NativeErrorCode.UNEXPECTED_RESPONSE_CODE);
            } else if (downloadResponse.getContentLength() == 0) {
                MoPubNative.this.mMoPubNativeListener.onNativeFail(NativeErrorCode.EMPTY_AD_RESPONSE);
            } else {
                CustomEventNativeListener customEventNativeListener = new C26431(downloadResponse);
                Context context = MoPubNative.this.getContextOrDestroy();
                if (context != null) {
                    CustomEventNativeAdapter.loadNativeAd(context, MoPubNative.this.mLocalExtras, downloadResponse, customEventNativeListener);
                }
            }
        }
    }

    public interface MoPubNativeListener {
        public static final MoPubNativeListener EMPTY_MOPUB_NATIVE_LISTENER;

        /* renamed from: com.mopub.nativeads.MoPubNative.MoPubNativeListener.1 */
        static class C26451 implements MoPubNativeListener {
            C26451() {
            }

            public void onNativeLoad(NativeResponse nativeResponse) {
            }

            public void onNativeFail(NativeErrorCode errorCode) {
            }

            public void onNativeImpression(View view) {
            }

            public void onNativeClick(View view) {
            }
        }

        void onNativeClick(View view);

        void onNativeFail(NativeErrorCode nativeErrorCode);

        void onNativeImpression(View view);

        void onNativeLoad(NativeResponse nativeResponse);

        static {
            EMPTY_MOPUB_NATIVE_LISTENER = new C26451();
        }
    }

    class NativeGpsHelperListener implements GpsHelperListener {
        private RequestParameters mRequestParameters;

        NativeGpsHelperListener(RequestParameters requestParameters) {
            this.mRequestParameters = requestParameters;
        }

        public void onFetchAdInfoCompleted() {
            MoPubNative.this.loadNativeAd(this.mRequestParameters);
        }
    }

    public MoPubNative(Context context, String adUnitId, MoPubNativeListener moPubNativeListener) {
        ImpressionTrackingManager.start();
        if (context == null) {
            throw new IllegalArgumentException("Context may not be null.");
        } else if (adUnitId == null) {
            throw new IllegalArgumentException("AdUnitId may not be null.");
        } else if (moPubNativeListener == null) {
            throw new IllegalArgumentException("MoPubNativeListener may not be null.");
        } else {
            ManifestUtils.checkNativeActivitiesDeclared(context);
            this.mContext = new WeakReference(context);
            this.mAdUnitId = adUnitId;
            this.mMoPubNativeListener = moPubNativeListener;
            GpsHelper.asyncFetchAdvertisingInfo(context);
        }
    }

    public void destroy() {
        this.mContext.clear();
        this.mMoPubNativeListener = MoPubNativeListener.EMPTY_MOPUB_NATIVE_LISTENER;
    }

    public void setLocalExtras(Map localExtras) {
        this.mLocalExtras = new HashMap(localExtras);
    }

    public void makeRequest() {
        makeRequest(null);
    }

    public void makeRequest(RequestParameters requestParameters) {
        makeRequest(new NativeGpsHelperListener(requestParameters));
    }

    void makeRequest(NativeGpsHelperListener nativeGpsHelperListener) {
        Context context = getContextOrDestroy();
        if (context != null) {
            if (DeviceUtils.isNetworkAvailable(context)) {
                GpsHelper.asyncFetchAdvertisingInfoIfNotCached(context, nativeGpsHelperListener);
            } else {
                this.mMoPubNativeListener.onNativeFail(NativeErrorCode.CONNECTION_ERROR);
            }
        }
    }

    void loadNativeAd(RequestParameters requestParameters) {
        Context context = getContextOrDestroy();
        if (context != null) {
            String endpointUrl = new NativeUrlGenerator(context).withAdUnitId(this.mAdUnitId).withRequest(requestParameters).generateUrlString(MoPubView.HOST);
            if (endpointUrl != null) {
                MoPubLog.m9729d("Loading ad from: " + endpointUrl);
            }
            requestNativeAd(endpointUrl);
        }
    }

    private void requestNativeAd(String endpointUrl) {
        try {
            downloadJson(new HttpGet(endpointUrl));
        } catch (IllegalArgumentException e) {
            this.mMoPubNativeListener.onNativeFail(NativeErrorCode.INVALID_REQUEST_URL);
        }
    }

    private void downloadJson(HttpUriRequest httpUriRequest) {
        DownloadTask jsonDownloadTask = new DownloadTask(new C26441());
        try {
            AsyncTasks.safeExecuteOnExecutor(jsonDownloadTask, httpUriRequest);
        } catch (Exception e) {
            MoPubLog.m9730d("Failed to download json", e);
            this.mMoPubNativeListener.onNativeFail(NativeErrorCode.UNSPECIFIED);
        }
    }

    Context getContextOrDestroy() {
        Context context = (Context) this.mContext.get();
        if (context == null) {
            destroy();
            MoPubLog.m9729d("Weak reference to Activity Context in MoPubNative became null. This instance of MoPubNative is destroyed and No more requests will be processed.");
        }
        return context;
    }

    @Deprecated
    MoPubNativeListener getMoPubNativeListener() {
        return this.mMoPubNativeListener;
    }
}
