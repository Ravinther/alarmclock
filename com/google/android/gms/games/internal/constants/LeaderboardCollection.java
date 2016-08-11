package com.google.android.gms.games.internal.constants;

import com.mopub.mobileads.util.Base64;

public final class LeaderboardCollection {
    private LeaderboardCollection() {
    }

    public static String bd(int i) {
        switch (i) {
            case Base64.DEFAULT /*0*/:
                return "PUBLIC";
            case Base64.NO_PADDING /*1*/:
                return "SOCIAL";
            default:
                throw new IllegalArgumentException("Unknown leaderboard collection: " + i);
        }
    }
}
