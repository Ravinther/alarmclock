package com.google.android.gms.analytics;

import android.text.TextUtils;

/* renamed from: com.google.android.gms.analytics.x */
class C1395x {
    private String vh;
    private final long vi;
    private final long vj;
    private String vk;

    C1395x(String str, long j, long j2) {
        this.vk = "https:";
        this.vh = str;
        this.vi = j;
        this.vj = j2;
    }

    void m6041J(String str) {
        this.vh = str;
    }

    void m6042K(String str) {
        if (str != null && !TextUtils.isEmpty(str.trim()) && str.toLowerCase().startsWith("http:")) {
            this.vk = "http:";
        }
    }

    String cO() {
        return this.vh;
    }

    long cP() {
        return this.vi;
    }

    long cQ() {
        return this.vj;
    }

    String cR() {
        return this.vk;
    }
}
