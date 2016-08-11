package com.google.android.gms.internal;

import com.google.android.gms.cast.Cast;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public final class ko {
    private final int adT;
    private final byte[] buffer;
    private int position;

    /* renamed from: com.google.android.gms.internal.ko.a */
    public static class C2025a extends IOException {
        C2025a(int i, int i2) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space (pos " + i + " limit " + i2 + ").");
        }
    }

    private ko(byte[] bArr, int i, int i2) {
        this.buffer = bArr;
        this.position = i;
        this.adT = i + i2;
    }

    public static int m8907A(long j) {
        return m8909D(j);
    }

    public static int m8908B(long j) {
        return m8909D(m8911E(j));
    }

    public static int m8909D(long j) {
        return (-128 & j) == 0 ? 1 : (-16384 & j) == 0 ? 2 : (-2097152 & j) == 0 ? 3 : (-268435456 & j) == 0 ? 4 : (-34359738368L & j) == 0 ? 5 : (-4398046511104L & j) == 0 ? 6 : (-562949953421312L & j) == 0 ? 7 : (-72057594037927936L & j) == 0 ? 8 : (Long.MIN_VALUE & j) == 0 ? 9 : 10;
    }

    public static int m8910E(boolean z) {
        return 1;
    }

    public static long m8911E(long j) {
        return (j << 1) ^ (j >> 63);
    }

    public static int m8912b(int i, kt ktVar) {
        return cZ(i) + m8916c(ktVar);
    }

    public static int m8913b(int i, boolean z) {
        return cZ(i) + m8910E(z);
    }

    public static ko m8914b(byte[] bArr, int i, int i2) {
        return new ko(bArr, i, i2);
    }

    public static int m8915c(int i, float f) {
        return cZ(i) + m8918e(f);
    }

    public static int m8916c(kt ktVar) {
        int c = ktVar.m6620c();
        return c + db(c);
    }

    public static int cX(int i) {
        return i >= 0 ? db(i) : 10;
    }

    public static int cZ(int i) {
        return db(kw.m8948l(i, 0));
    }

    public static int cf(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            return bytes.length + db(bytes.length);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported.");
        }
    }

    public static int m8917d(int i, long j) {
        return cZ(i) + m8907A(j);
    }

    public static int db(int i) {
        return (i & -128) == 0 ? 1 : (i & -16384) == 0 ? 2 : (-2097152 & i) == 0 ? 3 : (-268435456 & i) == 0 ? 4 : 5;
    }

    public static int m8918e(float f) {
        return 4;
    }

    public static int m8919e(int i, long j) {
        return cZ(i) + m8908B(j);
    }

    public static int m8920g(int i, String str) {
        return cZ(i) + cf(str);
    }

    public static int m8921j(int i, int i2) {
        return cZ(i) + cX(i2);
    }

    public static ko m8922o(byte[] bArr) {
        return m8914b(bArr, 0, bArr.length);
    }

    public void m8923C(long j) {
        while ((-128 & j) != 0) {
            cY((((int) j) & 127) | Cast.MAX_NAMESPACE_LENGTH);
            j >>>= 7;
        }
        cY((int) j);
    }

    public void m8924D(boolean z) {
        cY(z ? 1 : 0);
    }

    public void m8925a(int i, kt ktVar) {
        m8936k(i, 2);
        m8931b(ktVar);
    }

    public void m8926a(int i, boolean z) {
        m8936k(i, 0);
        m8924D(z);
    }

    public void m8927b(byte b) {
        if (this.position == this.adT) {
            throw new C2025a(this.position, this.adT);
        }
        byte[] bArr = this.buffer;
        int i = this.position;
        this.position = i + 1;
        bArr[i] = b;
    }

    public void m8928b(int i, float f) {
        m8936k(i, 5);
        m8934d(f);
    }

    public void m8929b(int i, long j) {
        m8936k(i, 0);
        m8938y(j);
    }

    public void m8930b(int i, String str) {
        m8936k(i, 2);
        ce(str);
    }

    public void m8931b(kt ktVar) {
        da(ktVar.mF());
        ktVar.m6618a(this);
    }

    public void m8932c(int i, long j) {
        m8936k(i, 0);
        m8939z(j);
    }

    public void m8933c(byte[] bArr, int i, int i2) {
        if (this.adT - this.position >= i2) {
            System.arraycopy(bArr, i, this.buffer, this.position, i2);
            this.position += i2;
            return;
        }
        throw new C2025a(this.position, this.adT);
    }

    public void cW(int i) {
        if (i >= 0) {
            da(i);
        } else {
            m8923C((long) i);
        }
    }

    public void cY(int i) {
        m8927b((byte) i);
    }

    public void ce(String str) {
        byte[] bytes = str.getBytes("UTF-8");
        da(bytes.length);
        m8937p(bytes);
    }

    public void m8934d(float f) {
        dc(Float.floatToIntBits(f));
    }

    public void da(int i) {
        while ((i & -128) != 0) {
            cY((i & 127) | Cast.MAX_NAMESPACE_LENGTH);
            i >>>= 7;
        }
        cY(i);
    }

    public void dc(int i) {
        cY(i & 255);
        cY((i >> 8) & 255);
        cY((i >> 16) & 255);
        cY((i >> 24) & 255);
    }

    public void m8935i(int i, int i2) {
        m8936k(i, 0);
        cW(i2);
    }

    public void m8936k(int i, int i2) {
        da(kw.m8948l(i, i2));
    }

    public int mv() {
        return this.adT - this.position;
    }

    public void mw() {
        if (mv() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public void m8937p(byte[] bArr) {
        m8933c(bArr, 0, bArr.length);
    }

    public void m8938y(long j) {
        m8923C(j);
    }

    public void m8939z(long j) {
        m8923C(m8911E(j));
    }
}
