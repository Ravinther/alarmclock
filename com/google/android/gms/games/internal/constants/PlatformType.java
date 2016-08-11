package com.google.android.gms.games.internal.constants;

import com.mopub.mobileads.util.Base64;

public final class PlatformType {
    private PlatformType() {
    }

    public static String bd(int i) {
        switch (i) {
            case Base64.DEFAULT /*0*/:
                return "ANDROID";
            case Base64.NO_PADDING /*1*/:
                return "IOS";
            case Base64.NO_WRAP /*2*/:
                return "WEB_APP";
            default:
                throw new IllegalArgumentException("Unknown platform type: " + i);
        }
    }
}
