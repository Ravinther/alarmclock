package com.avg.toolkit.license.p053a;

import com.avg.toolkit.license.p053a.C1010h.C1001a;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;
import java.util.Vector;

/* renamed from: com.avg.toolkit.license.a.b */
public class C0990b {
    Vector f2975a;
    C1001a f2976b;
    private char[] f2977c;
    private char[] f2978d;

    /* renamed from: com.avg.toolkit.license.a.b.1 */
    static /* synthetic */ class C09891 {
        static final /* synthetic */ int[] f2974a;

        static {
            f2974a = new int[C1001a.values().length];
            try {
                f2974a[C1001a.LIC_AVG_8.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f2974a[C1001a.LIC_AVG_9.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f2974a[C1001a.LIC_AVG_10.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public C0990b(C1001a licAvgVersion) {
        this.f2975a = new Vector();
        this.f2977c = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '2', '3', '4', '6', '7', '8', '9'};
        this.f2978d = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '2', '3', '4', '6', '7', '9'};
        this.f2976b = licAvgVersion;
    }

    public void m4389a(C0990b that) {
        this.f2975a.clear();
        this.f2975a = that.f2975a;
    }

    public int m4384a() {
        return this.f2975a.size();
    }

    void m4387a(int anumber, int count) {
        this.f2975a.clear();
        m4388a(anumber, 0, count);
    }

    public void m4388a(int anumber, int apos, int count) {
        int currPos = apos;
        int mask = 1;
        for (int i = 0; i < count; i++) {
            Byte newValue = Byte.valueOf((byte) ((anumber & mask) != 0 ? 1 : 0));
            if (currPos < this.f2975a.size()) {
                this.f2975a.set(currPos, newValue);
            } else {
                this.f2975a.add(newValue);
            }
            currPos++;
            mask *= 2;
        }
    }

    public int m4390b(int pos, int count) {
        if (pos + count > this.f2975a.size()) {
            throw new C0988a(999);
        }
        int anumber = 0;
        int mask = 1;
        for (int i = 0; i < count; i++) {
            if (((Byte) this.f2975a.get(pos + i)).byteValue() != null) {
                anumber |= mask;
            }
            mask *= 2;
        }
        return anumber;
    }

    public char m4383a(int pos) {
        int number = m4390b(pos * 5, 5);
        if (number < m4393c()) {
            return m4392b()[number];
        }
        throw new C0988a(999);
    }

    public void m4386a(char achar) {
        int index = m4385a(m4392b(), achar, m4393c());
        if (index == -1) {
            throw new C0988a(999);
        }
        C0990b arrNumber = new C0990b(this.f2976b);
        arrNumber.m4387a(index, 5);
        m4391b(arrNumber);
    }

    int m4385a(char[] chars, char chartofind, int chars_size) {
        for (int i = 0; i < chars_size; i++) {
            if (chartofind == chars[i]) {
                return i;
            }
        }
        return -1;
    }

    void m4391b(C0990b that) {
        for (int iter = 0; iter < that.f2975a.size(); iter++) {
            this.f2975a.add(that.f2975a.get(iter));
        }
    }

    char[] m4392b() {
        switch (C09891.f2974a[this.f2976b.ordinal()]) {
            case Base64.NO_PADDING /*1*/:
            case Base64.NO_WRAP /*2*/:
                return this.f2977c;
            case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                return this.f2978d;
            default:
                throw new C0988a(999);
        }
    }

    int m4393c() {
        switch (C09891.f2974a[this.f2976b.ordinal()]) {
            case Base64.NO_PADDING /*1*/:
            case Base64.NO_WRAP /*2*/:
                return this.f2977c.length;
            case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                return this.f2978d.length;
            default:
                throw new C0988a(999);
        }
    }
}
