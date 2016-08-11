package com.mopub.nativeads;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.plus.PlusShare;
import com.mopub.common.DownloadResponse;
import com.mopub.common.HttpClient;
import com.mopub.common.MoPubBrowser;
import com.mopub.common.util.IntentUtils;
import com.mopub.common.util.MoPubLog;
import com.mopub.common.util.ResponseHeader;
import com.mopub.nativeads.MoPubNative.MoPubNativeListener;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class NativeResponse {
    final Context mContext;
    boolean mIsClicked;
    boolean mIsDestroyed;
    final String mMoPubClickTracker;
    final Set mMoPubImpressionTrackers;
    MoPubNativeListener mMoPubNativeListener;
    final NativeAdInterface mNativeAd;
    boolean mRecordedImpression;

    private static class ClickDestinationUrlResolutionListener implements UrlResolutionListener {
        private final Context mContext;
        private final SoftReference mSpinningProgressView;
        private final Iterator mUrlIterator;

        public ClickDestinationUrlResolutionListener(Context context, Iterator urlIterator, SpinningProgressView spinningProgressView) {
            this.mContext = context.getApplicationContext();
            this.mUrlIterator = urlIterator;
            this.mSpinningProgressView = new SoftReference(spinningProgressView);
        }

        public void onSuccess(String resolvedUrl) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(resolvedUrl));
            intent.addFlags(DriveFile.MODE_READ_ONLY);
            if (IntentUtils.isDeepLink(resolvedUrl) && IntentUtils.deviceCanHandleIntent(this.mContext, intent)) {
                this.mContext.startActivity(intent);
            } else if (this.mUrlIterator.hasNext()) {
                UrlResolutionTask.getResolvedUrl((String) this.mUrlIterator.next(), this);
                return;
            } else {
                MoPubBrowser.open(this.mContext, resolvedUrl);
            }
            removeSpinningProgressView();
        }

        public void onFailure() {
            MoPubLog.m9729d("Failed to resolve URL for click.");
            removeSpinningProgressView();
        }

        private void removeSpinningProgressView() {
            SpinningProgressView spinningProgressView = (SpinningProgressView) this.mSpinningProgressView.get();
            if (spinningProgressView != null) {
                spinningProgressView.removeFromRoot();
            }
        }
    }

    enum Parameter {
        IMPRESSION_TRACKER("imptracker", true),
        CLICK_TRACKER("clktracker", true),
        TITLE(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, false),
        TEXT("text", false),
        MAIN_IMAGE("mainimage", false),
        ICON_IMAGE("iconimage", false),
        CLICK_DESTINATION("clk", false),
        FALLBACK("fallback", false),
        CALL_TO_ACTION("ctatext", false),
        STAR_RATING("starrating", false);
        
        static Set requiredKeys;
        final String name;
        final boolean required;

        static {
            requiredKeys = new HashSet();
            for (Parameter parameter : values()) {
                if (parameter.required) {
                    requiredKeys.add(parameter.name);
                }
            }
        }

        private Parameter(String name, boolean required) {
            this.name = name;
            this.required = required;
        }

        static Parameter from(String name) {
            for (Parameter parameter : values()) {
                if (parameter.name.equals(name)) {
                    return parameter;
                }
            }
            return null;
        }
    }

    public NativeResponse(Context context, DownloadResponse downloadResponse, NativeAdInterface nativeAd, MoPubNativeListener moPubNativeListener) {
        this.mContext = context.getApplicationContext();
        this.mMoPubNativeListener = moPubNativeListener;
        this.mNativeAd = nativeAd;
        this.mMoPubImpressionTrackers = new HashSet();
        this.mMoPubImpressionTrackers.add(downloadResponse.getFirstHeader(ResponseHeader.IMPRESSION_URL));
        this.mMoPubClickTracker = downloadResponse.getFirstHeader(ResponseHeader.CLICKTHROUGH_URL);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("\n");
        stringBuilder.append(Parameter.TITLE.name).append(":").append(getTitle()).append("\n");
        stringBuilder.append(Parameter.TEXT.name).append(":").append(getText()).append("\n");
        stringBuilder.append(Parameter.ICON_IMAGE.name).append(":").append(getIconImageUrl()).append("\n");
        stringBuilder.append(Parameter.MAIN_IMAGE.name).append(":").append(getMainImageUrl()).append("\n");
        stringBuilder.append(Parameter.STAR_RATING.name).append(":").append(getStarRating()).append("\n");
        stringBuilder.append(Parameter.IMPRESSION_TRACKER.name).append(":").append(getImpressionTrackers()).append("\n");
        stringBuilder.append(Parameter.CLICK_TRACKER.name).append(":").append(this.mMoPubClickTracker).append("\n");
        stringBuilder.append(Parameter.CLICK_DESTINATION.name).append(":").append(getClickDestinationUrl()).append("\n");
        stringBuilder.append(Parameter.CALL_TO_ACTION.name).append(":").append(getCallToAction()).append("\n");
        stringBuilder.append("recordedImpression").append(":").append(this.mRecordedImpression).append("\n");
        stringBuilder.append("extras").append(":").append(getExtras());
        return stringBuilder.toString();
    }

    public String getMainImageUrl() {
        return this.mNativeAd.getMainImageUrl();
    }

    public String getIconImageUrl() {
        return this.mNativeAd.getIconImageUrl();
    }

    public String getClickDestinationUrl() {
        return this.mNativeAd.getClickDestinationUrl();
    }

    public String getCallToAction() {
        return this.mNativeAd.getCallToAction();
    }

    public String getTitle() {
        return this.mNativeAd.getTitle();
    }

    public String getText() {
        return this.mNativeAd.getText();
    }

    public List getImpressionTrackers() {
        Set allImpressionTrackers = new HashSet();
        allImpressionTrackers.addAll(this.mMoPubImpressionTrackers);
        allImpressionTrackers.addAll(this.mNativeAd.getImpressionTrackers());
        return new ArrayList(allImpressionTrackers);
    }

    public String getClickTracker() {
        return this.mMoPubClickTracker;
    }

    public Double getStarRating() {
        return this.mNativeAd.getStarRating();
    }

    public int getImpressionMinTimeViewed() {
        return this.mNativeAd.getImpressionMinTimeViewed();
    }

    public int getImpressionMinPercentageViewed() {
        return this.mNativeAd.getImpressionMinPercentageViewed();
    }

    public Object getExtra(String key) {
        return this.mNativeAd.getExtra(key);
    }

    public Map getExtras() {
        return this.mNativeAd.getExtras();
    }

    public void prepareImpression(View view) {
        if (!getRecordedImpression() && !isDestroyed()) {
            ImpressionTrackingManager.addView(view, this);
            this.mNativeAd.prepareImpression(view);
        }
    }

    public void recordImpression(View view) {
        if (!getRecordedImpression() && !isDestroyed()) {
            for (String impressionTracker : getImpressionTrackers()) {
                HttpClient.makeTrackingHttpRequest(impressionTracker);
            }
            this.mNativeAd.recordImpression();
            this.mRecordedImpression = true;
            this.mMoPubNativeListener.onNativeImpression(view);
        }
    }

    public void handleClick(View view) {
        if (!isDestroyed()) {
            if (!isClicked()) {
                HttpClient.makeTrackingHttpRequest(this.mMoPubClickTracker);
            }
            openClickDestinationUrl(view);
            this.mNativeAd.handleClick(view);
            this.mIsClicked = true;
            this.mMoPubNativeListener.onNativeClick(view);
        }
    }

    public void destroy() {
        if (!isDestroyed()) {
            this.mMoPubNativeListener = MoPubNativeListener.EMPTY_MOPUB_NATIVE_LISTENER;
            this.mNativeAd.destroy();
            this.mIsDestroyed = true;
        }
    }

    public void loadMainImage(ImageView imageView) {
        loadImageView(getMainImageUrl(), imageView);
    }

    public void loadIconImage(ImageView imageView) {
        loadImageView(getIconImageUrl(), imageView);
    }

    public void loadExtrasImage(String key, ImageView imageView) {
        Object object = getExtra(key);
        if (object != null && (object instanceof String)) {
            loadImageView((String) object, imageView);
        }
    }

    public boolean getRecordedImpression() {
        return this.mRecordedImpression;
    }

    public boolean isClicked() {
        return this.mIsClicked;
    }

    public boolean isDestroyed() {
        return this.mIsDestroyed;
    }

    private void loadImageView(String url, ImageView imageView) {
        ImageViewService.loadImageView(url, imageView);
    }

    private void openClickDestinationUrl(View view) {
        if (getClickDestinationUrl() != null) {
            SpinningProgressView spinningProgressView = null;
            if (view != null) {
                spinningProgressView = new SpinningProgressView(this.mContext);
                spinningProgressView.addToRoot(view);
            }
            Iterator urlIterator = Arrays.asList(new String[]{getClickDestinationUrl()}).iterator();
            UrlResolutionTask.getResolvedUrl((String) urlIterator.next(), new ClickDestinationUrlResolutionListener(this.mContext, urlIterator, spinningProgressView));
        }
    }

    @Deprecated
    public String getSubtitle() {
        return this.mNativeAd.getText();
    }

    @Deprecated
    MoPubNativeListener getMoPubNativeListener() {
        return this.mMoPubNativeListener;
    }

    @Deprecated
    void setRecordedImpression(boolean recordedImpression) {
        this.mRecordedImpression = recordedImpression;
    }
}
