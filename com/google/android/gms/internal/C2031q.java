package com.google.android.gms.internal;

import java.io.IOException;

/* renamed from: com.google.android.gms.internal.q */
class C2031q implements C2028o {
    private ko kk;
    private byte[] kl;
    private final int km;

    public C2031q(int i) {
        this.km = i;
        reset();
    }

    public void m8961b(int i, long j) {
        this.kk.m8929b(i, j);
    }

    public void m8962b(int i, String str) {
        this.kk.m8930b(i, str);
    }

    public void reset() {
        this.kl = new byte[this.km];
        this.kk = ko.m8922o(this.kl);
    }

    public byte[] m8963z() {
        int mv = this.kk.mv();
        if (mv < 0) {
            throw new IOException();
        } else if (mv == 0) {
            return this.kl;
        } else {
            Object obj = new byte[(this.kl.length - mv)];
            System.arraycopy(this.kl, 0, obj, 0, obj.length);
            return obj;
        }
    }
}
