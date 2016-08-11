package com.google.android.gms.internal;

import android.util.Log;

public final class fj {
    private final String DH;

    public fj(String str) {
        this.DH = (String) fq.m8520f(str);
    }

    public boolean m8443P(int i) {
        return Log.isLoggable(this.DH, i);
    }

    public void m8444a(String str, String str2, Throwable th) {
        if (m8443P(6)) {
            Log.e(str, str2, th);
        }
    }

    public void m8445f(String str, String str2) {
        if (m8443P(2)) {
            Log.v(str, str2);
        }
    }

    public void m8446g(String str, String str2) {
        if (m8443P(5)) {
            Log.w(str, str2);
        }
    }

    public void m8447h(String str, String str2) {
        if (m8443P(6)) {
            Log.e(str, str2);
        }
    }
}
