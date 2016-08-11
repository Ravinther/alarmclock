package com.google.android.gms.internal;

import com.google.android.gms.cast.Cast;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

public final class kn {
    private int adK;
    private int adL;
    private int adM;
    private int adN;
    private int adO;
    private int adP;
    private int adQ;
    private int adR;
    private int adS;
    private final byte[] buffer;

    private kn(byte[] bArr, int i, int i2) {
        this.adP = Integer.MAX_VALUE;
        this.adR = 64;
        this.adS = 67108864;
        this.buffer = bArr;
        this.adK = i;
        this.adL = i + i2;
        this.adN = i;
    }

    public static kn m8901a(byte[] bArr, int i, int i2) {
        return new kn(bArr, i, i2);
    }

    private void mr() {
        this.adL += this.adM;
        int i = this.adL;
        if (i > this.adP) {
            this.adM = i - this.adP;
            this.adL -= this.adM;
            return;
        }
        this.adM = 0;
    }

    public static kn m8902n(byte[] bArr) {
        return m8901a(bArr, 0, bArr.length);
    }

    public static long m8903x(long j) {
        return (j >>> 1) ^ (-(1 & j));
    }

    public void m8904a(kt ktVar) {
        int mn = mn();
        if (this.adQ >= this.adR) {
            throw ks.mE();
        }
        mn = cR(mn);
        this.adQ++;
        ktVar.m6619b(this);
        cP(0);
        this.adQ--;
        cS(mn);
    }

    public void m8905a(kt ktVar, int i) {
        if (this.adQ >= this.adR) {
            throw ks.mE();
        }
        this.adQ++;
        ktVar.m6619b(this);
        cP(kw.m8948l(i, 4));
        this.adQ--;
    }

    public void cP(int i) {
        if (this.adO != i) {
            throw ks.mC();
        }
    }

    public boolean cQ(int i) {
        switch (kw.de(i)) {
            case Base64.DEFAULT /*0*/:
                mk();
                return true;
            case Base64.NO_PADDING /*1*/:
                mq();
                return true;
            case Base64.NO_WRAP /*2*/:
                cV(mn());
                return true;
            case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                mi();
                cP(kw.m8948l(kw.df(i), 4));
                return true;
            case Base64.CRLF /*4*/:
                return false;
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                mp();
                return true;
            default:
                throw ks.mD();
        }
    }

    public int cR(int i) {
        if (i < 0) {
            throw ks.mz();
        }
        int i2 = this.adN + i;
        int i3 = this.adP;
        if (i2 > i3) {
            throw ks.my();
        }
        this.adP = i2;
        mr();
        return i3;
    }

    public void cS(int i) {
        this.adP = i;
        mr();
    }

    public void cT(int i) {
        if (i > this.adN - this.adK) {
            throw new IllegalArgumentException("Position " + i + " is beyond current " + (this.adN - this.adK));
        } else if (i < 0) {
            throw new IllegalArgumentException("Bad position " + i);
        } else {
            this.adN = this.adK + i;
        }
    }

    public byte[] cU(int i) {
        if (i < 0) {
            throw ks.mz();
        } else if (this.adN + i > this.adP) {
            cV(this.adP - this.adN);
            throw ks.my();
        } else if (i <= this.adL - this.adN) {
            Object obj = new byte[i];
            System.arraycopy(this.buffer, this.adN, obj, 0, i);
            this.adN += i;
            return obj;
        } else {
            throw ks.my();
        }
    }

    public void cV(int i) {
        if (i < 0) {
            throw ks.mz();
        } else if (this.adN + i > this.adP) {
            cV(this.adP - this.adN);
            throw ks.my();
        } else if (i <= this.adL - this.adN) {
            this.adN += i;
        } else {
            throw ks.my();
        }
    }

    public int getPosition() {
        return this.adN - this.adK;
    }

    public byte[] m8906h(int i, int i2) {
        if (i2 == 0) {
            return kw.aeh;
        }
        Object obj = new byte[i2];
        System.arraycopy(this.buffer, this.adK + i, obj, 0, i2);
        return obj;
    }

    public int mh() {
        if (mt()) {
            this.adO = 0;
            return 0;
        }
        this.adO = mn();
        if (this.adO != 0) {
            return this.adO;
        }
        throw ks.mB();
    }

    public void mi() {
        int mh;
        do {
            mh = mh();
            if (mh == 0) {
                return;
            }
        } while (cQ(mh));
    }

    public long mj() {
        return mo();
    }

    public int mk() {
        return mn();
    }

    public boolean ml() {
        return mn() != 0;
    }

    public long mm() {
        return m8903x(mo());
    }

    public int mn() {
        byte mu = mu();
        if (mu >= null) {
            return mu;
        }
        int i = mu & 127;
        byte mu2 = mu();
        if (mu2 >= null) {
            return i | (mu2 << 7);
        }
        i |= (mu2 & 127) << 7;
        mu2 = mu();
        if (mu2 >= null) {
            return i | (mu2 << 14);
        }
        i |= (mu2 & 127) << 14;
        mu2 = mu();
        if (mu2 >= null) {
            return i | (mu2 << 21);
        }
        i |= (mu2 & 127) << 21;
        mu2 = mu();
        i |= mu2 << 28;
        if (mu2 >= null) {
            return i;
        }
        for (int i2 = 0; i2 < 5; i2++) {
            if (mu() >= null) {
                return i;
            }
        }
        throw ks.mA();
    }

    public long mo() {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte mu = mu();
            j |= ((long) (mu & 127)) << i;
            if ((mu & Cast.MAX_NAMESPACE_LENGTH) == 0) {
                return j;
            }
        }
        throw ks.mA();
    }

    public int mp() {
        return (((mu() & 255) | ((mu() & 255) << 8)) | ((mu() & 255) << 16)) | ((mu() & 255) << 24);
    }

    public long mq() {
        byte mu = mu();
        byte mu2 = mu();
        return ((((((((((long) mu2) & 255) << 8) | (((long) mu) & 255)) | ((((long) mu()) & 255) << 16)) | ((((long) mu()) & 255) << 24)) | ((((long) mu()) & 255) << 32)) | ((((long) mu()) & 255) << 40)) | ((((long) mu()) & 255) << 48)) | ((((long) mu()) & 255) << 56);
    }

    public int ms() {
        if (this.adP == Integer.MAX_VALUE) {
            return -1;
        }
        return this.adP - this.adN;
    }

    public boolean mt() {
        return this.adN == this.adL;
    }

    public byte mu() {
        if (this.adN == this.adL) {
            throw ks.my();
        }
        byte[] bArr = this.buffer;
        int i = this.adN;
        this.adN = i + 1;
        return bArr[i];
    }

    public float readFloat() {
        return Float.intBitsToFloat(mp());
    }

    public String readString() {
        int mn = mn();
        if (mn > this.adL - this.adN || mn <= 0) {
            return new String(cU(mn), "UTF-8");
        }
        String str = new String(this.buffer, this.adN, mn, "UTF-8");
        this.adN = mn + this.adN;
        return str;
    }
}
