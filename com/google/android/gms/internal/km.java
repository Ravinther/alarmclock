package com.google.android.gms.internal;

public class km {
    private final byte[] adH;
    private int adI;
    private int adJ;

    public km(byte[] bArr) {
        int i;
        this.adH = new byte[256];
        for (i = 0; i < 256; i++) {
            this.adH[i] = (byte) i;
        }
        i = 0;
        for (int i2 = 0; i2 < 256; i2++) {
            i = ((i + this.adH[i2]) + bArr[i2 % bArr.length]) & 255;
            byte b = this.adH[i2];
            this.adH[i2] = this.adH[i];
            this.adH[i] = b;
        }
        this.adI = 0;
        this.adJ = 0;
    }

    public void m8900m(byte[] bArr) {
        int i = this.adI;
        int i2 = this.adJ;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i = (i + 1) & 255;
            i2 = (i2 + this.adH[i]) & 255;
            byte b = this.adH[i];
            this.adH[i] = this.adH[i2];
            this.adH[i2] = b;
            bArr[i3] = (byte) (bArr[i3] ^ this.adH[(this.adH[i] + this.adH[i2]) & 255]);
        }
        this.adI = i;
        this.adJ = i2;
    }
}
