package com.mopub.mobileads;

import com.mopub.common.GpsHelper;
import com.mopub.mobileads.MoPubInterstitial.MoPubInterstitialView;

public class AdTypeTranslator {

    public enum CustomEventType {
        ADMOB_BANNER("admob_native_banner", "com.mopub.mobileads.GoogleAdMobBanner"),
        ADMOB_INTERSTITIAL("admob_full_interstitial", "com.mopub.mobileads.GoogleAdMobInterstitial"),
        GOOGLE_PLAY_BANNER("google_play_banner", "com.mopub.mobileads.GooglePlayServicesBanner"),
        GOOGLE_PLAY_INTERSTITIAL("google_play_interstitial", "com.mopub.mobileads.GooglePlayServicesInterstitial"),
        MILLENNIAL_BANNER("millennial_native_banner", "com.mopub.mobileads.MillennialBanner"),
        MILLENNIAL_INTERSTITIAL("millennial_full_interstitial", "com.mopub.mobileads.MillennialInterstitial"),
        MRAID_BANNER("mraid_banner", "com.mopub.mobileads.MraidBanner"),
        MRAID_INTERSTITIAL("mraid_interstitial", "com.mopub.mobileads.MraidInterstitial"),
        HTML_BANNER("html_banner", "com.mopub.mobileads.HtmlBanner"),
        HTML_INTERSTITIAL("html_interstitial", "com.mopub.mobileads.HtmlInterstitial"),
        VAST_VIDEO_INTERSTITIAL("vast_interstitial", "com.mopub.mobileads.VastVideoInterstitial"),
        UNSPECIFIED("", null);
        
        private final String mClassName;
        private final String mKey;

        private CustomEventType(String key, String className) {
            this.mKey = key;
            this.mClassName = className;
        }

        private static CustomEventType fromString(String key) {
            for (CustomEventType customEventType : values()) {
                if (customEventType.mKey.equals(key)) {
                    return customEventType;
                }
            }
            return UNSPECIFIED;
        }

        public String toString() {
            return this.mClassName;
        }
    }

    static String getAdNetworkType(String adType, String fullAdType) {
        String adNetworkType;
        if ("interstitial".equals(adType)) {
            adNetworkType = fullAdType;
        } else {
            adNetworkType = adType;
        }
        return adNetworkType != null ? adNetworkType : "unknown";
    }

    static String getCustomEventNameForAdType(MoPubView moPubView, String adType, String fullAdType) {
        CustomEventType customEventType;
        if ("html".equals(adType) || "mraid".equals(adType)) {
            customEventType = isInterstitial(moPubView) ? CustomEventType.fromString(adType + "_interstitial") : CustomEventType.fromString(adType + "_banner");
        } else {
            customEventType = "interstitial".equals(adType) ? CustomEventType.fromString(fullAdType + "_interstitial") : CustomEventType.fromString(adType + "_banner");
            if (moPubView != null) {
                customEventType = GpsHelper.convertAdMobToGooglePlayServices(moPubView.getContext(), customEventType);
            }
        }
        return customEventType.toString();
    }

    private static boolean isInterstitial(MoPubView moPubView) {
        return moPubView instanceof MoPubInterstitialView;
    }
}
