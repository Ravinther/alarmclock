package com.mopub.common.util;

import android.util.Log;

public class MoPubLog {
    private static final String LOGTAG = "MoPub";

    public static int m9729d(String message) {
        return m9730d(message, null);
    }

    public static int m9730d(String message, Throwable throwable) {
        return Log.d(LOGTAG, message, throwable);
    }

    public static int m9733w(String message) {
        return m9734w(message, null);
    }

    public static int m9734w(String message, Throwable throwable) {
        return Log.w(LOGTAG, message, throwable);
    }

    public static int m9731e(String message) {
        return m9732e(message, null);
    }

    public static int m9732e(String message, Throwable throwable) {
        return Log.e(LOGTAG, message, throwable);
    }
}
