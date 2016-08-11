package com.mopub.mobileads;

import com.google.android.gms.plus.PlusShare;
import com.mopub.mobileads.MraidView.PlacementType;
import com.mopub.mobileads.util.Base64;
import java.util.Map;

class MraidCommandExpand extends MraidCommand {

    /* renamed from: com.mopub.mobileads.MraidCommandExpand.1 */
    static /* synthetic */ class C26111 {
        static final /* synthetic */ int[] $SwitchMap$com$mopub$mobileads$MraidView$PlacementType;

        static {
            $SwitchMap$com$mopub$mobileads$MraidView$PlacementType = new int[PlacementType.values().length];
            try {
                $SwitchMap$com$mopub$mobileads$MraidView$PlacementType[PlacementType.INLINE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$mopub$mobileads$MraidView$PlacementType[PlacementType.INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    MraidCommandExpand(Map params, MraidView view) {
        super(params, view);
    }

    void execute() {
        int width = getIntFromParamsForKey("w");
        int height = getIntFromParamsForKey("h");
        String url = getStringFromParamsForKey(PlusShare.KEY_CALL_TO_ACTION_URL);
        boolean shouldUseCustomClose = getBooleanFromParamsForKey("shouldUseCustomClose");
        boolean shouldLockOrientation = getBooleanFromParamsForKey("lockOrientation");
        if (width <= 0) {
            width = this.mView.getDisplayController().mScreenWidth;
        }
        if (height <= 0) {
            height = this.mView.getDisplayController().mScreenHeight;
        }
        this.mView.getDisplayController().expand(url, width, height, shouldUseCustomClose, shouldLockOrientation);
    }

    protected boolean isCommandDependentOnUserClick(PlacementType placementType) {
        switch (C26111.$SwitchMap$com$mopub$mobileads$MraidView$PlacementType[placementType.ordinal()]) {
            case Base64.NO_PADDING /*1*/:
                return true;
            case Base64.NO_WRAP /*2*/:
                return false;
            default:
                return super.isCommandDependentOnUserClick(placementType);
        }
    }
}
