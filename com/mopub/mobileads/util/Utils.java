package com.mopub.mobileads.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.google.android.gms.drive.DriveFile;

public class Utils {
    private Utils() {
    }

    public static boolean executeIntent(Context context, Intent intent, String errorMessage) {
        try {
            if (!(context instanceof Activity)) {
                intent.addFlags(DriveFile.MODE_READ_ONLY);
            }
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            String str = "MoPub";
            if (errorMessage == null) {
                errorMessage = "Unable to start intent.";
            }
            Log.d(str, errorMessage);
            return false;
        }
    }
}
