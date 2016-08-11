package com.google.android.gms.internal;

import java.io.IOException;

public abstract class kt {
    protected volatile int adY;

    public kt() {
        this.adY = -1;
    }

    public static final kt m6614a(kt ktVar, byte[] bArr) {
        return m6616b(ktVar, bArr, 0, bArr.length);
    }

    public static final void m6615a(kt ktVar, byte[] bArr, int i, int i2) {
        try {
            ko b = ko.m8914b(bArr, i, i2);
            ktVar.m6618a(b);
            b.mw();
        } catch (Throwable e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    public static final kt m6616b(kt ktVar, byte[] bArr, int i, int i2) {
        try {
            kn a = kn.m8901a(bArr, i, i2);
            ktVar.m6619b(a);
            a.cP(0);
            return ktVar;
        } catch (ks e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }

    public static final byte[] m6617d(kt ktVar) {
        byte[] bArr = new byte[ktVar.m6620c()];
        m6615a(ktVar, bArr, 0, bArr.length);
        return bArr;
    }

    public void m6618a(ko koVar) {
    }

    public abstract kt m6619b(kn knVar);

    public int m6620c() {
        int mx = mx();
        this.adY = mx;
        return mx;
    }

    public int mF() {
        if (this.adY < 0) {
            m6620c();
        }
        return this.adY;
    }

    protected int mx() {
        return 0;
    }

    public String toString() {
        return ku.m8946e(this);
    }
}
