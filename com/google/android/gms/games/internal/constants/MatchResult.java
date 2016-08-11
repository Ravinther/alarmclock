package com.google.android.gms.games.internal.constants;

import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

public final class MatchResult {
    public static boolean isValid(int result) {
        switch (result) {
            case Base64.DEFAULT /*0*/:
            case Base64.NO_PADDING /*1*/:
            case Base64.NO_WRAP /*2*/:
            case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
            case Base64.CRLF /*4*/:
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                return true;
            default:
                return false;
        }
    }
}
