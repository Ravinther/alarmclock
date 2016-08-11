package com.google.android.gms.internal;

import android.text.TextUtils;

public abstract class em {
    protected final er yY;
    private final String yZ;
    private et za;

    protected em(String str, String str2, String str3) {
        eo.m8363W(str);
        this.yZ = str;
        this.yY = new er(str2);
        if (!TextUtils.isEmpty(str3)) {
            this.yY.ab(str3);
        }
    }

    public void m6143U(String str) {
    }

    public void m6144a(long j, int i) {
    }

    public final void m6145a(et etVar) {
        this.za = etVar;
        if (this.za == null) {
            dF();
        }
    }

    protected final void m6146a(String str, long j, String str2) {
        this.yY.m8386a("Sending text message: %s to: %s", str, str2);
        this.za.m6188a(this.yZ, str, j, str2);
    }

    protected final long dE() {
        return this.za.dD();
    }

    public void dF() {
    }

    public final String getNamespace() {
        return this.yZ;
    }
}
