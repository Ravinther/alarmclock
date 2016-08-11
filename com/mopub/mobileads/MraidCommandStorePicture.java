package com.mopub.mobileads;

import android.util.Log;
import com.mopub.mobileads.MraidView.PlacementType;
import java.util.Map;

class MraidCommandStorePicture extends MraidCommand {
    public static final String MIME_TYPE_HEADER = "Content-Type";

    public MraidCommandStorePicture(Map params, MraidView view) {
        super(params, view);
    }

    void execute() {
        String url = getStringFromParamsForKey("uri");
        if (url == null || url.equals("")) {
            this.mView.fireErrorEvent(MraidJavascriptCommand.STORE_PICTURE, "Image can't be stored with null or empty URL");
            Log.d("MoPub", "Invalid URI for Mraid Store Picture.");
            return;
        }
        this.mView.getDisplayController().showUserDownloadImageAlert(url);
    }

    protected boolean isCommandDependentOnUserClick(PlacementType placementType) {
        return true;
    }
}
