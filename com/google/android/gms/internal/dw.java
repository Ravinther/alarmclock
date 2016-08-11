package com.google.android.gms.internal;

import android.util.Log;
import com.google.ads.AdRequest;

public final class dw {
    public static void m8213a(String str, Throwable th) {
        if (m8216n(3)) {
            Log.d(AdRequest.LOGTAG, str, th);
        }
    }

    public static void m8214b(String str, Throwable th) {
        if (m8216n(6)) {
            Log.e(AdRequest.LOGTAG, str, th);
        }
    }

    public static void m8215c(String str, Throwable th) {
        if (m8216n(5)) {
            Log.w(AdRequest.LOGTAG, str, th);
        }
    }

    public static boolean m8216n(int i) {
        return (i >= 5 || Log.isLoggable(AdRequest.LOGTAG, i)) && i != 2;
    }

    public static void m8217v(String str) {
        if (m8216n(3)) {
            Log.d(AdRequest.LOGTAG, str);
        }
    }

    public static void m8218w(String str) {
        if (m8216n(6)) {
            Log.e(AdRequest.LOGTAG, str);
        }
    }

    public static void m8219x(String str) {
        if (m8216n(4)) {
            Log.i(AdRequest.LOGTAG, str);
        }
    }

    public static void m8220y(String str) {
        if (m8216n(2)) {
            Log.v(AdRequest.LOGTAG, str);
        }
    }

    public static void m8221z(String str) {
        if (m8216n(5)) {
            Log.w(AdRequest.LOGTAG, str);
        }
    }
}
