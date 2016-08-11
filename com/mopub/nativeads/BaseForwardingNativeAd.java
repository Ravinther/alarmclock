package com.mopub.nativeads;

import android.view.View;
import com.google.android.gms.location.LocationStatusCodes;
import com.mopub.common.util.MoPubLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

abstract class BaseForwardingNativeAd implements NativeAdInterface {
    private static final int IMPRESSION_MIN_PERCENTAGE_VIEWED = 50;
    static final double MAX_STAR_RATING = 5.0d;
    static final double MIN_STAR_RATING = 0.0d;
    private String mCallToAction;
    private String mClickDestinationUrl;
    private final Map mExtras;
    private String mIconImageUrl;
    private int mImpressionMinTimeViewed;
    private final Set mImpressionTrackers;
    private String mMainImageUrl;
    private Double mStarRating;
    private String mText;
    private String mTitle;

    BaseForwardingNativeAd() {
        this.mImpressionMinTimeViewed = LocationStatusCodes.GEOFENCE_NOT_AVAILABLE;
        this.mImpressionTrackers = new HashSet();
        this.mExtras = new HashMap();
    }

    public final String getMainImageUrl() {
        return this.mMainImageUrl;
    }

    public final String getIconImageUrl() {
        return this.mIconImageUrl;
    }

    public final Set getImpressionTrackers() {
        return new HashSet(this.mImpressionTrackers);
    }

    public final String getClickDestinationUrl() {
        return this.mClickDestinationUrl;
    }

    public final String getCallToAction() {
        return this.mCallToAction;
    }

    public final String getTitle() {
        return this.mTitle;
    }

    public final String getText() {
        return this.mText;
    }

    public final Double getStarRating() {
        return this.mStarRating;
    }

    public final int getImpressionMinPercentageViewed() {
        return IMPRESSION_MIN_PERCENTAGE_VIEWED;
    }

    public final int getImpressionMinTimeViewed() {
        return this.mImpressionMinTimeViewed;
    }

    public final Object getExtra(String key) {
        return this.mExtras.get(key);
    }

    public final Map getExtras() {
        return new HashMap(this.mExtras);
    }

    final void setMainImageUrl(String mainImageUrl) {
        this.mMainImageUrl = mainImageUrl;
    }

    final void setIconImageUrl(String iconImageUrl) {
        this.mIconImageUrl = iconImageUrl;
    }

    final void setClickDestinationUrl(String clickDestinationUrl) {
        this.mClickDestinationUrl = clickDestinationUrl;
    }

    final void setCallToAction(String callToAction) {
        this.mCallToAction = callToAction;
    }

    final void setTitle(String title) {
        this.mTitle = title;
    }

    final void setText(String text) {
        this.mText = text;
    }

    final void setStarRating(Double starRating) {
        if (starRating == null) {
            this.mStarRating = null;
        } else if (starRating.doubleValue() < 0.0d || starRating.doubleValue() > MAX_STAR_RATING) {
            MoPubLog.m9729d("Ignoring attempt to set invalid star rating (" + starRating + "). Must be " + "between " + 0.0d + " and " + MAX_STAR_RATING + ".");
        } else {
            this.mStarRating = starRating;
        }
    }

    final void addExtra(String key, Object value) {
        this.mExtras.put(key, value);
    }

    final void addImpressionTracker(String url) {
        this.mImpressionTrackers.add(url);
    }

    final void setImpressionMinTimeViewed(int impressionMinTimeViewed) {
        if (impressionMinTimeViewed >= 0) {
            this.mImpressionMinTimeViewed = impressionMinTimeViewed;
        }
    }

    public void prepareImpression(View view) {
    }

    public void recordImpression() {
    }

    public void handleClick(View view) {
    }

    public void destroy() {
    }
}
