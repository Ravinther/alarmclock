package com.mopub.nativeads;

import android.location.Location;
import android.text.TextUtils;
import com.google.android.gms.plus.PlusShare;
import java.util.EnumSet;

public final class RequestParameters {
    private final EnumSet mDesiredAssets;
    private final String mKeywords;
    private final Location mLocation;

    public static final class Builder {
        private EnumSet desiredAssets;
        private String keywords;
        private Location location;

        public final Builder keywords(String keywords) {
            this.keywords = keywords;
            return this;
        }

        public final Builder location(Location location) {
            this.location = location;
            return this;
        }

        public final Builder desiredAssets(EnumSet desiredAssets) {
            this.desiredAssets = EnumSet.copyOf(desiredAssets);
            return this;
        }

        public final RequestParameters build() {
            return new RequestParameters();
        }
    }

    public enum NativeAdAsset {
        TITLE(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE),
        TEXT("text"),
        ICON_IMAGE("iconimage"),
        MAIN_IMAGE("mainimage"),
        CALL_TO_ACTION_TEXT("ctatext"),
        STAR_RATING("starrating");
        
        private final String mAssetName;

        private NativeAdAsset(String assetName) {
            this.mAssetName = assetName;
        }

        public String toString() {
            return this.mAssetName;
        }
    }

    private RequestParameters(Builder builder) {
        this.mKeywords = builder.keywords;
        this.mLocation = builder.location;
        this.mDesiredAssets = builder.desiredAssets;
    }

    public final String getKeywords() {
        return this.mKeywords;
    }

    public final Location getLocation() {
        return this.mLocation;
    }

    public final String getDesiredAssets() {
        String result = "";
        if (this.mDesiredAssets != null) {
            return TextUtils.join(",", this.mDesiredAssets.toArray());
        }
        return result;
    }
}
