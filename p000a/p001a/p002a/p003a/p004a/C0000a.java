package p000a.p001a.p002a.p003a.p004a;

import com.google.ads.AdSize;
import com.google.android.gms.location.LocationRequest;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.factories.HttpClientFactory;
import com.mopub.mobileads.util.Base64;

/* renamed from: a.a.a.a.a.a */
public class C0000a {
    static final byte[] f0a;
    private static final byte[] f1b;
    private static final byte[] f2c;
    private static final byte[] f3d;
    private final byte[] f4e;
    private final int f5f;
    private final byte[] f6g;
    private final int f7h;
    private final int f8i;
    private byte[] f9j;
    private int f10k;
    private int f11l;
    private int f12m;
    private int f13n;
    private boolean f14o;
    private int f15p;

    static {
        f0a = new byte[]{(byte) 13, (byte) 10};
        f1b = new byte[]{(byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, (byte) 120, (byte) 121, (byte) 122, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 43, (byte) 47};
        f2c = new byte[]{(byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, (byte) 120, (byte) 121, (byte) 122, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 45, (byte) 95};
        byte[] bArr = new byte[123];
        bArr[0] = (byte) -1;
        bArr[1] = (byte) -1;
        bArr[2] = (byte) -1;
        bArr[3] = (byte) -1;
        bArr[4] = (byte) -1;
        bArr[5] = (byte) -1;
        bArr[6] = (byte) -1;
        bArr[7] = (byte) -1;
        bArr[8] = (byte) -1;
        bArr[9] = (byte) -1;
        bArr[10] = (byte) -1;
        bArr[11] = (byte) -1;
        bArr[12] = (byte) -1;
        bArr[13] = (byte) -1;
        bArr[14] = (byte) -1;
        bArr[15] = (byte) -1;
        bArr[16] = (byte) -1;
        bArr[17] = (byte) -1;
        bArr[18] = (byte) -1;
        bArr[19] = (byte) -1;
        bArr[20] = (byte) -1;
        bArr[21] = (byte) -1;
        bArr[22] = (byte) -1;
        bArr[23] = (byte) -1;
        bArr[24] = (byte) -1;
        bArr[25] = (byte) -1;
        bArr[26] = (byte) -1;
        bArr[27] = (byte) -1;
        bArr[28] = (byte) -1;
        bArr[29] = (byte) -1;
        bArr[30] = (byte) -1;
        bArr[31] = (byte) -1;
        bArr[32] = (byte) -1;
        bArr[33] = (byte) -1;
        bArr[34] = (byte) -1;
        bArr[35] = (byte) -1;
        bArr[36] = (byte) -1;
        bArr[37] = (byte) -1;
        bArr[38] = (byte) -1;
        bArr[39] = (byte) -1;
        bArr[40] = (byte) -1;
        bArr[41] = (byte) -1;
        bArr[42] = (byte) -1;
        bArr[43] = (byte) 62;
        bArr[44] = (byte) -1;
        bArr[45] = (byte) 62;
        bArr[46] = (byte) -1;
        bArr[47] = (byte) 63;
        bArr[48] = (byte) 52;
        bArr[49] = (byte) 53;
        bArr[50] = (byte) 54;
        bArr[51] = (byte) 55;
        bArr[52] = (byte) 56;
        bArr[53] = (byte) 57;
        bArr[54] = (byte) 58;
        bArr[55] = (byte) 59;
        bArr[56] = (byte) 60;
        bArr[57] = (byte) 61;
        bArr[58] = (byte) -1;
        bArr[59] = (byte) -1;
        bArr[60] = (byte) -1;
        bArr[61] = (byte) -1;
        bArr[62] = (byte) -1;
        bArr[63] = (byte) -1;
        bArr[64] = (byte) -1;
        bArr[66] = (byte) 1;
        bArr[67] = (byte) 2;
        bArr[68] = (byte) 3;
        bArr[69] = (byte) 4;
        bArr[70] = (byte) 5;
        bArr[71] = (byte) 6;
        bArr[72] = (byte) 7;
        bArr[73] = (byte) 8;
        bArr[74] = (byte) 9;
        bArr[75] = (byte) 10;
        bArr[76] = (byte) 11;
        bArr[77] = (byte) 12;
        bArr[78] = (byte) 13;
        bArr[79] = (byte) 14;
        bArr[80] = (byte) 15;
        bArr[81] = (byte) 16;
        bArr[82] = (byte) 17;
        bArr[83] = (byte) 18;
        bArr[84] = (byte) 19;
        bArr[85] = (byte) 20;
        bArr[86] = (byte) 21;
        bArr[87] = (byte) 22;
        bArr[88] = (byte) 23;
        bArr[89] = (byte) 24;
        bArr[90] = (byte) 25;
        bArr[91] = (byte) -1;
        bArr[92] = (byte) -1;
        bArr[93] = (byte) -1;
        bArr[94] = (byte) -1;
        bArr[95] = (byte) 63;
        bArr[96] = (byte) -1;
        bArr[97] = (byte) 26;
        bArr[98] = (byte) 27;
        bArr[99] = (byte) 28;
        bArr[100] = (byte) 29;
        bArr[101] = (byte) 30;
        bArr[LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY] = (byte) 31;
        bArr[103] = (byte) 32;
        bArr[LocationRequest.PRIORITY_LOW_POWER] = (byte) 33;
        bArr[LocationRequest.PRIORITY_NO_POWER] = (byte) 34;
        bArr[106] = (byte) 35;
        bArr[107] = (byte) 36;
        bArr[108] = (byte) 37;
        bArr[109] = (byte) 38;
        bArr[110] = (byte) 39;
        bArr[111] = (byte) 40;
        bArr[112] = (byte) 41;
        bArr[113] = (byte) 42;
        bArr[114] = (byte) 43;
        bArr[115] = (byte) 44;
        bArr[116] = (byte) 45;
        bArr[117] = (byte) 46;
        bArr[118] = (byte) 47;
        bArr[119] = (byte) 48;
        bArr[120] = (byte) 49;
        bArr[121] = (byte) 50;
        bArr[122] = (byte) 51;
        f3d = bArr;
    }

    public C0000a() {
        this(false);
    }

    public C0000a(boolean urlSafe) {
        this(76, f0a, urlSafe);
    }

    public C0000a(int lineLength, byte[] lineSeparator, boolean urlSafe) {
        int i;
        if (lineSeparator == null) {
            lineLength = 0;
            lineSeparator = f0a;
        }
        if (lineLength > 0) {
            i = (lineLength / 4) * 4;
        } else {
            i = 0;
        }
        this.f5f = i;
        this.f6g = new byte[lineSeparator.length];
        System.arraycopy(lineSeparator, 0, this.f6g, 0, lineSeparator.length);
        if (lineLength > 0) {
            this.f8i = lineSeparator.length + 4;
        } else {
            this.f8i = 4;
        }
        this.f7h = this.f8i - 1;
        if (C0000a.m11e(lineSeparator)) {
            throw new IllegalArgumentException("lineSeperator must not contain base64 characters: [" + C0002c.m26a(lineSeparator) + "]");
        }
        this.f4e = urlSafe ? f2c : f1b;
    }

    public boolean m13a() {
        return this.f4e == f2c;
    }

    int m15b() {
        return this.f9j != null ? this.f10k - this.f11l : 0;
    }

    private void m9c() {
        if (this.f9j == null) {
            this.f9j = new byte[HttpClientFactory.SOCKET_SIZE];
            this.f10k = 0;
            this.f11l = 0;
            return;
        }
        byte[] b = new byte[(this.f9j.length * 2)];
        System.arraycopy(this.f9j, 0, b, 0, this.f9j.length);
        this.f9j = b;
    }

    int m12a(byte[] b, int bPos, int bAvail) {
        if (this.f9j != null) {
            int len = Math.min(m15b(), bAvail);
            if (this.f9j != b) {
                System.arraycopy(this.f9j, this.f11l, b, bPos, len);
                this.f11l += len;
                if (this.f11l < this.f10k) {
                    return len;
                }
                this.f9j = null;
                return len;
            }
            this.f9j = null;
            return len;
        }
        return this.f14o ? -1 : 0;
    }

    void m16b(byte[] out, int outPos, int outAvail) {
        if (out != null && out.length == outAvail) {
            this.f9j = out;
            this.f10k = outPos;
            this.f11l = outPos;
        }
    }

    void m17c(byte[] in, int inPos, int inAvail) {
        if (!this.f14o) {
            byte[] bArr;
            int i;
            if (inAvail < 0) {
                this.f14o = true;
                if (this.f9j == null || this.f9j.length - this.f10k < this.f8i) {
                    m9c();
                }
                switch (this.f13n) {
                    case Base64.NO_PADDING /*1*/:
                        bArr = this.f9j;
                        i = this.f10k;
                        this.f10k = i + 1;
                        bArr[i] = this.f4e[(this.f15p >> 2) & 63];
                        bArr = this.f9j;
                        i = this.f10k;
                        this.f10k = i + 1;
                        bArr[i] = this.f4e[(this.f15p << 4) & 63];
                        if (this.f4e == f1b) {
                            bArr = this.f9j;
                            i = this.f10k;
                            this.f10k = i + 1;
                            bArr[i] = (byte) 61;
                            bArr = this.f9j;
                            i = this.f10k;
                            this.f10k = i + 1;
                            bArr[i] = (byte) 61;
                            break;
                        }
                        break;
                    case Base64.NO_WRAP /*2*/:
                        bArr = this.f9j;
                        i = this.f10k;
                        this.f10k = i + 1;
                        bArr[i] = this.f4e[(this.f15p >> 10) & 63];
                        bArr = this.f9j;
                        i = this.f10k;
                        this.f10k = i + 1;
                        bArr[i] = this.f4e[(this.f15p >> 4) & 63];
                        bArr = this.f9j;
                        i = this.f10k;
                        this.f10k = i + 1;
                        bArr[i] = this.f4e[(this.f15p << 2) & 63];
                        if (this.f4e == f1b) {
                            bArr = this.f9j;
                            i = this.f10k;
                            this.f10k = i + 1;
                            bArr[i] = (byte) 61;
                            break;
                        }
                        break;
                }
                if (this.f5f > 0 && this.f10k > 0) {
                    System.arraycopy(this.f6g, 0, this.f9j, this.f10k, this.f6g.length);
                    this.f10k += this.f6g.length;
                    return;
                }
                return;
            }
            int i2 = 0;
            int inPos2 = inPos;
            while (i2 < inAvail) {
                if (this.f9j == null || this.f9j.length - this.f10k < this.f8i) {
                    m9c();
                }
                int i3 = this.f13n + 1;
                this.f13n = i3;
                this.f13n = i3 % 3;
                inPos = inPos2 + 1;
                int b = in[inPos2];
                if (b < 0) {
                    b += 256;
                }
                this.f15p = (this.f15p << 8) + b;
                if (this.f13n == 0) {
                    bArr = this.f9j;
                    i = this.f10k;
                    this.f10k = i + 1;
                    bArr[i] = this.f4e[(this.f15p >> 18) & 63];
                    bArr = this.f9j;
                    i = this.f10k;
                    this.f10k = i + 1;
                    bArr[i] = this.f4e[(this.f15p >> 12) & 63];
                    bArr = this.f9j;
                    i = this.f10k;
                    this.f10k = i + 1;
                    bArr[i] = this.f4e[(this.f15p >> 6) & 63];
                    bArr = this.f9j;
                    i = this.f10k;
                    this.f10k = i + 1;
                    bArr[i] = this.f4e[this.f15p & 63];
                    this.f12m += 4;
                    if (this.f5f > 0 && this.f5f <= this.f12m) {
                        System.arraycopy(this.f6g, 0, this.f9j, this.f10k, this.f6g.length);
                        this.f10k += this.f6g.length;
                        this.f12m = 0;
                    }
                }
                i2++;
                inPos2 = inPos;
            }
            inPos = inPos2;
        }
    }

    void m19d(byte[] in, int inPos, int inAvail) {
        if (!this.f14o) {
            byte[] bArr;
            int i;
            if (inAvail < 0) {
                this.f14o = true;
            }
            int i2 = 0;
            int inPos2 = inPos;
            while (i2 < inAvail) {
                if (this.f9j == null || this.f9j.length - this.f10k < this.f7h) {
                    m9c();
                }
                inPos = inPos2 + 1;
                byte b = in[inPos2];
                if (b == 61) {
                    this.f14o = true;
                    break;
                }
                if (b >= null && b < f3d.length) {
                    int result = f3d[b];
                    if (result >= 0) {
                        int i3 = this.f13n + 1;
                        this.f13n = i3;
                        this.f13n = i3 % 4;
                        this.f15p = (this.f15p << 6) + result;
                        if (this.f13n == 0) {
                            bArr = this.f9j;
                            i = this.f10k;
                            this.f10k = i + 1;
                            bArr[i] = (byte) ((this.f15p >> 16) & 255);
                            bArr = this.f9j;
                            i = this.f10k;
                            this.f10k = i + 1;
                            bArr[i] = (byte) ((this.f15p >> 8) & 255);
                            bArr = this.f9j;
                            i = this.f10k;
                            this.f10k = i + 1;
                            bArr[i] = (byte) (this.f15p & 255);
                        }
                    }
                }
                i2++;
                inPos2 = inPos;
            }
            inPos = inPos2;
            if (this.f14o && this.f13n != 0) {
                this.f15p <<= 6;
                switch (this.f13n) {
                    case Base64.NO_WRAP /*2*/:
                        this.f15p <<= 6;
                        bArr = this.f9j;
                        i = this.f10k;
                        this.f10k = i + 1;
                        bArr[i] = (byte) ((this.f15p >> 16) & 255);
                    case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                        bArr = this.f9j;
                        i = this.f10k;
                        this.f10k = i + 1;
                        bArr[i] = (byte) ((this.f15p >> 16) & 255);
                        bArr = this.f9j;
                        i = this.f10k;
                        this.f10k = i + 1;
                        bArr[i] = (byte) ((this.f15p >> 8) & 255);
                    default:
                }
            }
        }
    }

    public static boolean m1a(byte octet) {
        return octet == 61 || (octet >= null && octet < f3d.length && f3d[octet] != -1);
    }

    public static boolean m2a(byte[] arrayOctet) {
        int i = 0;
        while (i < arrayOctet.length) {
            if (!C0000a.m1a(arrayOctet[i]) && !C0000a.m6b(arrayOctet[i])) {
                return false;
            }
            i++;
        }
        return true;
    }

    private static boolean m11e(byte[] arrayOctet) {
        for (byte a : arrayOctet) {
            if (C0000a.m1a(a)) {
                return true;
            }
        }
        return false;
    }

    public static byte[] m8b(byte[] binaryData) {
        return C0000a.m3a(binaryData, false);
    }

    public byte[] m14a(String pArray) {
        return m18c(C0002c.m28a(pArray));
    }

    public byte[] m18c(byte[] pArray) {
        m10d();
        if (pArray == null || pArray.length == 0) {
            return pArray;
        }
        byte[] buf = new byte[((int) ((long) ((pArray.length * 3) / 4)))];
        m16b(buf, 0, buf.length);
        m19d(pArray, 0, pArray.length);
        m19d(pArray, 0, -1);
        byte[] result = new byte[this.f10k];
        m12a(result, 0, result.length);
        return result;
    }

    public static byte[] m3a(byte[] binaryData, boolean isChunked) {
        return C0000a.m4a(binaryData, isChunked, false);
    }

    public static byte[] m4a(byte[] binaryData, boolean isChunked, boolean urlSafe) {
        return C0000a.m5a(binaryData, isChunked, urlSafe, Integer.MAX_VALUE);
    }

    public static byte[] m5a(byte[] binaryData, boolean isChunked, boolean urlSafe, int maxResultSize) {
        if (binaryData == null || binaryData.length == 0) {
            return binaryData;
        }
        long len = C0000a.m0a(binaryData, 76, f0a);
        if (len > ((long) maxResultSize)) {
            throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + len + ") than the specified maxium size of " + maxResultSize);
        }
        return (isChunked ? new C0000a(urlSafe) : new C0000a(0, f0a, urlSafe)).m20d(binaryData);
    }

    public static byte[] m7b(String base64String) {
        return new C0000a().m14a(base64String);
    }

    private static boolean m6b(byte byteToCheck) {
        switch (byteToCheck) {
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor /*9*/:
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
            case C2625R.styleable.MapAttrs_zOrderOnTop /*13*/:
            case AdSize.LANDSCAPE_AD_HEIGHT /*32*/:
                return true;
            default:
                return false;
        }
    }

    public byte[] m20d(byte[] pArray) {
        m10d();
        if (pArray == null || pArray.length == 0) {
            return pArray;
        }
        byte[] buf = new byte[((int) C0000a.m0a(pArray, this.f5f, this.f6g))];
        m16b(buf, 0, buf.length);
        m17c(pArray, 0, pArray.length);
        m17c(pArray, 0, -1);
        if (this.f9j != buf) {
            m12a(buf, 0, buf.length);
        }
        if (!m13a() || this.f10k >= buf.length) {
            return buf;
        }
        byte[] smallerBuf = new byte[this.f10k];
        System.arraycopy(buf, 0, smallerBuf, 0, this.f10k);
        return smallerBuf;
    }

    private static long m0a(byte[] pArray, int chunkSize, byte[] chunkSeparator) {
        chunkSize = (chunkSize / 4) * 4;
        long len = (long) ((pArray.length * 4) / 3);
        long mod = len % 4;
        if (mod != 0) {
            len += 4 - mod;
        }
        if (chunkSize <= 0) {
            return len;
        }
        boolean lenChunksPerfectly = len % ((long) chunkSize) == 0;
        len += (len / ((long) chunkSize)) * ((long) chunkSeparator.length);
        if (lenChunksPerfectly) {
            return len;
        }
        return len + ((long) chunkSeparator.length);
    }

    private void m10d() {
        this.f9j = null;
        this.f10k = 0;
        this.f11l = 0;
        this.f12m = 0;
        this.f13n = 0;
        this.f14o = false;
    }
}
