package com.mopub.nativeads;

import android.view.View;
import java.util.Map;
import java.util.Set;

interface NativeAdInterface {
    void destroy();

    String getCallToAction();

    String getClickDestinationUrl();

    Object getExtra(String str);

    Map getExtras();

    String getIconImageUrl();

    int getImpressionMinPercentageViewed();

    int getImpressionMinTimeViewed();

    Set getImpressionTrackers();

    String getMainImageUrl();

    Double getStarRating();

    String getText();

    String getTitle();

    void handleClick(View view);

    void prepareImpression(View view);

    void recordImpression();
}
