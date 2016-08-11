package com.google.analytics.tracking.android;

import android.os.Build.VERSION;
import java.io.File;

class FutureApis {
    private FutureApis() {
    }

    public static int m5638a() {
        try {
            return Integer.parseInt(VERSION.SDK);
        } catch (NumberFormatException e) {
            Log.m5753c("Invalid version number: " + VERSION.SDK);
            return 0;
        }
    }

    static boolean m5639a(String path) {
        if (m5638a() < 9) {
            return false;
        }
        File file = new File(path);
        file.setReadable(false, false);
        file.setWritable(false, false);
        file.setReadable(true, true);
        file.setWritable(true, true);
        return true;
    }
}
