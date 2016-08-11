package com.google.android.gms.games.internal.constants;

import com.google.android.gms.games.internal.GamesLog;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

public final class TurnBasedMatchTurnStatus {
    public static String bd(int i) {
        switch (i) {
            case Base64.DEFAULT /*0*/:
                return "TURN_STATUS_INVITED";
            case Base64.NO_PADDING /*1*/:
                return "TURN_STATUS_MY_TURN";
            case Base64.NO_WRAP /*2*/:
                return "TURN_STATUS_THEIR_TURN";
            case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                return "TURN_STATUS_COMPLETE";
            default:
                GamesLog.m7101h("MatchTurnStatus", "Unknown match turn status: " + i);
                return "TURN_STATUS_UNKNOWN";
        }
    }
}
