package com.google.android.gms.games.internal.constants;

import com.mopub.mobileads.util.Base64;

public final class TimeSpan {
    private TimeSpan() {
        throw new AssertionError("Uninstantiable");
    }

    public static String bd(int i) {
        switch (i) {
            case Base64.DEFAULT /*0*/:
                return "DAILY";
            case Base64.NO_PADDING /*1*/:
                return "WEEKLY";
            case Base64.NO_WRAP /*2*/:
                return "ALL_TIME";
            default:
                throw new IllegalArgumentException("Unknown time span " + i);
        }
    }
}
