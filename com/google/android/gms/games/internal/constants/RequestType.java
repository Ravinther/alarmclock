package com.google.android.gms.games.internal.constants;

import com.google.android.gms.games.internal.GamesLog;
import com.mopub.mobileads.util.Base64;

public final class RequestType {
    private RequestType() {
    }

    public static String bd(int i) {
        switch (i) {
            case Base64.NO_PADDING /*1*/:
                return "GIFT";
            case Base64.NO_WRAP /*2*/:
                return "WISH";
            default:
                GamesLog.m7101h("RequestType", "Unknown request type: " + i);
                return "UNKNOWN_TYPE";
        }
    }
}
