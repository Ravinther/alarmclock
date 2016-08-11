package com.mopub.mobileads;

import com.mopub.mobileads.MraidView.PlacementType;
import com.mopub.mobileads.util.Base64;
import java.util.Map;

class MraidCommandPlayVideo extends MraidCommand {

    /* renamed from: com.mopub.mobileads.MraidCommandPlayVideo.1 */
    static /* synthetic */ class C26131 {
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

    public MraidCommandPlayVideo(Map params, MraidView view) {
        super(params, view);
    }

    void execute() {
        String url = getStringFromParamsForKey("uri");
        if (url == null || url.equals("")) {
            this.mView.fireErrorEvent(MraidJavascriptCommand.PLAY_VIDEO, "Video can't be played with null or empty URL");
        } else {
            this.mView.getDisplayController().showVideo(url);
        }
    }

    protected boolean isCommandDependentOnUserClick(PlacementType placementType) {
        switch (C26131.$SwitchMap$com$mopub$mobileads$MraidView$PlacementType[placementType.ordinal()]) {
            case Base64.NO_PADDING /*1*/:
                return true;
            case Base64.NO_WRAP /*2*/:
                return false;
            default:
                return super.isCommandDependentOnUserClick(placementType);
        }
    }
}
