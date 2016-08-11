package com.google.android.gms.internal;

import com.avg.toolkit.ITKSvc;
import com.avg.ui.general.C1091c.C1087k;
import com.google.ads.AdSize;
import com.google.android.gms.internal.C1817d.C1816a;
import com.millennialmedia.android.MMException;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

/* renamed from: com.google.android.gms.internal.c */
public interface C1788c {

    /* renamed from: com.google.android.gms.internal.c.a */
    public static final class C1778a extends kp {
        public int eE;
        public int eF;
        public int level;

        public C1778a() {
            m7961b();
        }

        public C1778a m7959a(kn knVar) {
            while (true) {
                int mh = knVar.mh();
                switch (mh) {
                    case Base64.DEFAULT /*0*/:
                        break;
                    case Base64.URL_SAFE /*8*/:
                        mh = knVar.mk();
                        switch (mh) {
                            case Base64.NO_PADDING /*1*/:
                            case Base64.NO_WRAP /*2*/:
                            case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                                this.level = mh;
                                break;
                            default:
                                continue;
                        }
                    case Base64.NO_CLOSE /*16*/:
                        this.eE = knVar.mk();
                        continue;
                    case MMException.DISPLAY_AD_NOT_PERMITTED /*24*/:
                        this.eF = knVar.mk();
                        continue;
                    default:
                        if (!m6623a(knVar, mh)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public void m7960a(ko koVar) {
            if (this.level != 1) {
                koVar.m8935i(1, this.level);
            }
            if (this.eE != 0) {
                koVar.m8935i(2, this.eE);
            }
            if (this.eF != 0) {
                koVar.m8935i(3, this.eF);
            }
            super.m6622a(koVar);
        }

        public C1778a m7961b() {
            this.level = 1;
            this.eE = 0;
            this.eF = 0;
            this.adU = null;
            this.adY = -1;
            return this;
        }

        public /* synthetic */ kt m7962b(kn knVar) {
            return m7959a(knVar);
        }

        public int m7963c() {
            int c = super.m6620c();
            if (this.level != 1) {
                c += ko.m8921j(1, this.level);
            }
            if (this.eE != 0) {
                c += ko.m8921j(2, this.eE);
            }
            if (this.eF != 0) {
                c += ko.m8921j(3, this.eF);
            }
            this.adY = c;
            return c;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C1778a)) {
                return false;
            }
            C1778a c1778a = (C1778a) o;
            if (this.level != c1778a.level || this.eE != c1778a.eE || this.eF != c1778a.eF) {
                return false;
            }
            if (this.adU == null || this.adU.isEmpty()) {
                return c1778a.adU == null || c1778a.adU.isEmpty();
            } else {
                return this.adU.equals(c1778a.adU);
            }
        }

        public int hashCode() {
            int i = (((((this.level + 527) * 31) + this.eE) * 31) + this.eF) * 31;
            int hashCode = (this.adU == null || this.adU.isEmpty()) ? 0 : this.adU.hashCode();
            return hashCode + i;
        }
    }

    /* renamed from: com.google.android.gms.internal.c.b */
    public static final class C1779b extends kp {
        private static volatile C1779b[] eG;
        public int[] eH;
        public int eI;
        public boolean eJ;
        public boolean eK;
        public int name;

        public C1779b() {
            m7969e();
        }

        public static C1779b[] m7964d() {
            if (eG == null) {
                synchronized (kr.adX) {
                    if (eG == null) {
                        eG = new C1779b[0];
                    }
                }
            }
            return eG;
        }

        public void m7965a(ko koVar) {
            if (this.eK) {
                koVar.m8926a(1, this.eK);
            }
            koVar.m8935i(2, this.eI);
            if (this.eH != null && this.eH.length > 0) {
                for (int i : this.eH) {
                    koVar.m8935i(3, i);
                }
            }
            if (this.name != 0) {
                koVar.m8935i(4, this.name);
            }
            if (this.eJ) {
                koVar.m8926a(6, this.eJ);
            }
            super.m6622a(koVar);
        }

        public /* synthetic */ kt m7966b(kn knVar) {
            return m7968c(knVar);
        }

        public int m7967c() {
            int i = 0;
            int c = super.m6620c();
            if (this.eK) {
                c += ko.m8913b(1, this.eK);
            }
            int j = ko.m8921j(2, this.eI) + c;
            if (this.eH == null || this.eH.length <= 0) {
                c = j;
            } else {
                for (int cX : this.eH) {
                    i += ko.cX(cX);
                }
                c = (j + i) + (this.eH.length * 1);
            }
            if (this.name != 0) {
                c += ko.m8921j(4, this.name);
            }
            if (this.eJ) {
                c += ko.m8913b(6, this.eJ);
            }
            this.adY = c;
            return c;
        }

        public C1779b m7968c(kn knVar) {
            while (true) {
                int mh = knVar.mh();
                int b;
                switch (mh) {
                    case Base64.DEFAULT /*0*/:
                        break;
                    case Base64.URL_SAFE /*8*/:
                        this.eK = knVar.ml();
                        continue;
                    case Base64.NO_CLOSE /*16*/:
                        this.eI = knVar.mk();
                        continue;
                    case MMException.DISPLAY_AD_NOT_PERMITTED /*24*/:
                        b = kw.m8947b(knVar, 24);
                        mh = this.eH == null ? 0 : this.eH.length;
                        Object obj = new int[(b + mh)];
                        if (mh != 0) {
                            System.arraycopy(this.eH, 0, obj, 0, mh);
                        }
                        while (mh < obj.length - 1) {
                            obj[mh] = knVar.mk();
                            knVar.mh();
                            mh++;
                        }
                        obj[mh] = knVar.mk();
                        this.eH = obj;
                        continue;
                    case MMException.AD_NO_ACTIVITY /*26*/:
                        int cR = knVar.cR(knVar.mn());
                        b = knVar.getPosition();
                        mh = 0;
                        while (knVar.ms() > 0) {
                            knVar.mk();
                            mh++;
                        }
                        knVar.cT(b);
                        b = this.eH == null ? 0 : this.eH.length;
                        Object obj2 = new int[(mh + b)];
                        if (b != 0) {
                            System.arraycopy(this.eH, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = knVar.mk();
                            b++;
                        }
                        this.eH = obj2;
                        knVar.cS(cR);
                        continue;
                    case AdSize.LANDSCAPE_AD_HEIGHT /*32*/:
                        this.name = knVar.mk();
                        continue;
                    case 48:
                        this.eJ = knVar.ml();
                        continue;
                    default:
                        if (!m6623a(knVar, mh)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public C1779b m7969e() {
            this.eH = kw.aea;
            this.eI = 0;
            this.name = 0;
            this.eJ = false;
            this.eK = false;
            this.adU = null;
            this.adY = -1;
            return this;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C1779b)) {
                return false;
            }
            C1779b c1779b = (C1779b) o;
            if (!kr.equals(this.eH, c1779b.eH) || this.eI != c1779b.eI || this.name != c1779b.name || this.eJ != c1779b.eJ || this.eK != c1779b.eK) {
                return false;
            }
            if (this.adU == null || this.adU.isEmpty()) {
                return c1779b.adU == null || c1779b.adU.isEmpty();
            } else {
                return this.adU.equals(c1779b.adU);
            }
        }

        public int hashCode() {
            int i = 1231;
            int hashCode = ((this.eJ ? 1231 : 1237) + ((((((kr.hashCode(this.eH) + 527) * 31) + this.eI) * 31) + this.name) * 31)) * 31;
            if (!this.eK) {
                i = 1237;
            }
            i = (hashCode + i) * 31;
            hashCode = (this.adU == null || this.adU.isEmpty()) ? 0 : this.adU.hashCode();
            return hashCode + i;
        }
    }

    /* renamed from: com.google.android.gms.internal.c.c */
    public static final class C1780c extends kp {
        private static volatile C1780c[] eL;
        public String eM;
        public long eN;
        public long eO;
        public boolean eP;
        public long eQ;

        public C1780c() {
            m7975g();
        }

        public static C1780c[] m7970f() {
            if (eL == null) {
                synchronized (kr.adX) {
                    if (eL == null) {
                        eL = new C1780c[0];
                    }
                }
            }
            return eL;
        }

        public void m7971a(ko koVar) {
            if (!this.eM.equals("")) {
                koVar.m8930b(1, this.eM);
            }
            if (this.eN != 0) {
                koVar.m8929b(2, this.eN);
            }
            if (this.eO != 2147483647L) {
                koVar.m8929b(3, this.eO);
            }
            if (this.eP) {
                koVar.m8926a(4, this.eP);
            }
            if (this.eQ != 0) {
                koVar.m8929b(5, this.eQ);
            }
            super.m6622a(koVar);
        }

        public /* synthetic */ kt m7972b(kn knVar) {
            return m7974d(knVar);
        }

        public int m7973c() {
            int c = super.m6620c();
            if (!this.eM.equals("")) {
                c += ko.m8920g(1, this.eM);
            }
            if (this.eN != 0) {
                c += ko.m8917d(2, this.eN);
            }
            if (this.eO != 2147483647L) {
                c += ko.m8917d(3, this.eO);
            }
            if (this.eP) {
                c += ko.m8913b(4, this.eP);
            }
            if (this.eQ != 0) {
                c += ko.m8917d(5, this.eQ);
            }
            this.adY = c;
            return c;
        }

        public C1780c m7974d(kn knVar) {
            while (true) {
                int mh = knVar.mh();
                switch (mh) {
                    case Base64.DEFAULT /*0*/:
                        break;
                    case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                        this.eM = knVar.readString();
                        continue;
                    case Base64.NO_CLOSE /*16*/:
                        this.eN = knVar.mj();
                        continue;
                    case MMException.DISPLAY_AD_NOT_PERMITTED /*24*/:
                        this.eO = knVar.mj();
                        continue;
                    case AdSize.LANDSCAPE_AD_HEIGHT /*32*/:
                        this.eP = knVar.ml();
                        continue;
                    case 40:
                        this.eQ = knVar.mj();
                        continue;
                    default:
                        if (!m6623a(knVar, mh)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C1780c)) {
                return false;
            }
            C1780c c1780c = (C1780c) o;
            if (this.eM == null) {
                if (c1780c.eM != null) {
                    return false;
                }
            } else if (!this.eM.equals(c1780c.eM)) {
                return false;
            }
            if (this.eN != c1780c.eN || this.eO != c1780c.eO || this.eP != c1780c.eP || this.eQ != c1780c.eQ) {
                return false;
            }
            if (this.adU == null || this.adU.isEmpty()) {
                return c1780c.adU == null || c1780c.adU.isEmpty();
            } else {
                return this.adU.equals(c1780c.adU);
            }
        }

        public C1780c m7975g() {
            this.eM = "";
            this.eN = 0;
            this.eO = 2147483647L;
            this.eP = false;
            this.eQ = 0;
            this.adU = null;
            this.adY = -1;
            return this;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((((this.eP ? 1231 : 1237) + (((((((this.eM == null ? 0 : this.eM.hashCode()) + 527) * 31) + ((int) (this.eN ^ (this.eN >>> 32)))) * 31) + ((int) (this.eO ^ (this.eO >>> 32)))) * 31)) * 31) + ((int) (this.eQ ^ (this.eQ >>> 32)))) * 31;
            if (!(this.adU == null || this.adU.isEmpty())) {
                i = this.adU.hashCode();
            }
            return hashCode + i;
        }
    }

    /* renamed from: com.google.android.gms.internal.c.d */
    public static final class C1781d extends kp {
        public C1816a[] eR;
        public C1816a[] eS;
        public C1780c[] eT;

        public C1781d() {
            m7980h();
        }

        public void m7976a(ko koVar) {
            int i = 0;
            if (this.eR != null && this.eR.length > 0) {
                for (kt ktVar : this.eR) {
                    if (ktVar != null) {
                        koVar.m8925a(1, ktVar);
                    }
                }
            }
            if (this.eS != null && this.eS.length > 0) {
                for (kt ktVar2 : this.eS) {
                    if (ktVar2 != null) {
                        koVar.m8925a(2, ktVar2);
                    }
                }
            }
            if (this.eT != null && this.eT.length > 0) {
                while (i < this.eT.length) {
                    kt ktVar3 = this.eT[i];
                    if (ktVar3 != null) {
                        koVar.m8925a(3, ktVar3);
                    }
                    i++;
                }
            }
            super.m6622a(koVar);
        }

        public /* synthetic */ kt m7977b(kn knVar) {
            return m7979e(knVar);
        }

        public int m7978c() {
            int i;
            int i2 = 0;
            int c = super.m6620c();
            if (this.eR != null && this.eR.length > 0) {
                i = c;
                for (kt ktVar : this.eR) {
                    if (ktVar != null) {
                        i += ko.m8912b(1, ktVar);
                    }
                }
                c = i;
            }
            if (this.eS != null && this.eS.length > 0) {
                i = c;
                for (kt ktVar2 : this.eS) {
                    if (ktVar2 != null) {
                        i += ko.m8912b(2, ktVar2);
                    }
                }
                c = i;
            }
            if (this.eT != null && this.eT.length > 0) {
                while (i2 < this.eT.length) {
                    kt ktVar3 = this.eT[i2];
                    if (ktVar3 != null) {
                        c += ko.m8912b(3, ktVar3);
                    }
                    i2++;
                }
            }
            this.adY = c;
            return c;
        }

        public C1781d m7979e(kn knVar) {
            while (true) {
                int mh = knVar.mh();
                int b;
                Object obj;
                switch (mh) {
                    case Base64.DEFAULT /*0*/:
                        break;
                    case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                        b = kw.m8947b(knVar, 10);
                        mh = this.eR == null ? 0 : this.eR.length;
                        obj = new C1816a[(b + mh)];
                        if (mh != 0) {
                            System.arraycopy(this.eR, 0, obj, 0, mh);
                        }
                        while (mh < obj.length - 1) {
                            obj[mh] = new C1816a();
                            knVar.m8904a(obj[mh]);
                            knVar.mh();
                            mh++;
                        }
                        obj[mh] = new C1816a();
                        knVar.m8904a(obj[mh]);
                        this.eR = obj;
                        continue;
                    case C1087k.ActionBar_itemPadding /*18*/:
                        b = kw.m8947b(knVar, 18);
                        mh = this.eS == null ? 0 : this.eS.length;
                        obj = new C1816a[(b + mh)];
                        if (mh != 0) {
                            System.arraycopy(this.eS, 0, obj, 0, mh);
                        }
                        while (mh < obj.length - 1) {
                            obj[mh] = new C1816a();
                            knVar.m8904a(obj[mh]);
                            knVar.mh();
                            mh++;
                        }
                        obj[mh] = new C1816a();
                        knVar.m8904a(obj[mh]);
                        this.eS = obj;
                        continue;
                    case MMException.AD_NO_ACTIVITY /*26*/:
                        b = kw.m8947b(knVar, 26);
                        mh = this.eT == null ? 0 : this.eT.length;
                        obj = new C1780c[(b + mh)];
                        if (mh != 0) {
                            System.arraycopy(this.eT, 0, obj, 0, mh);
                        }
                        while (mh < obj.length - 1) {
                            obj[mh] = new C1780c();
                            knVar.m8904a(obj[mh]);
                            knVar.mh();
                            mh++;
                        }
                        obj[mh] = new C1780c();
                        knVar.m8904a(obj[mh]);
                        this.eT = obj;
                        continue;
                    default:
                        if (!m6623a(knVar, mh)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C1781d)) {
                return false;
            }
            C1781d c1781d = (C1781d) o;
            if (!kr.equals(this.eR, c1781d.eR) || !kr.equals(this.eS, c1781d.eS) || !kr.equals(this.eT, c1781d.eT)) {
                return false;
            }
            if (this.adU == null || this.adU.isEmpty()) {
                return c1781d.adU == null || c1781d.adU.isEmpty();
            } else {
                return this.adU.equals(c1781d.adU);
            }
        }

        public C1781d m7980h() {
            this.eR = C1816a.m8102r();
            this.eS = C1816a.m8102r();
            this.eT = C1780c.m7970f();
            this.adU = null;
            this.adY = -1;
            return this;
        }

        public int hashCode() {
            int hashCode = (((((kr.hashCode(this.eR) + 527) * 31) + kr.hashCode(this.eS)) * 31) + kr.hashCode(this.eT)) * 31;
            int hashCode2 = (this.adU == null || this.adU.isEmpty()) ? 0 : this.adU.hashCode();
            return hashCode2 + hashCode;
        }
    }

    /* renamed from: com.google.android.gms.internal.c.e */
    public static final class C1782e extends kp {
        private static volatile C1782e[] eU;
        public int key;
        public int value;

        public C1782e() {
            m7986j();
        }

        public static C1782e[] m7981i() {
            if (eU == null) {
                synchronized (kr.adX) {
                    if (eU == null) {
                        eU = new C1782e[0];
                    }
                }
            }
            return eU;
        }

        public void m7982a(ko koVar) {
            koVar.m8935i(1, this.key);
            koVar.m8935i(2, this.value);
            super.m6622a(koVar);
        }

        public /* synthetic */ kt m7983b(kn knVar) {
            return m7985f(knVar);
        }

        public int m7984c() {
            int c = (super.m6620c() + ko.m8921j(1, this.key)) + ko.m8921j(2, this.value);
            this.adY = c;
            return c;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C1782e)) {
                return false;
            }
            C1782e c1782e = (C1782e) o;
            if (this.key != c1782e.key || this.value != c1782e.value) {
                return false;
            }
            if (this.adU == null || this.adU.isEmpty()) {
                return c1782e.adU == null || c1782e.adU.isEmpty();
            } else {
                return this.adU.equals(c1782e.adU);
            }
        }

        public C1782e m7985f(kn knVar) {
            while (true) {
                int mh = knVar.mh();
                switch (mh) {
                    case Base64.DEFAULT /*0*/:
                        break;
                    case Base64.URL_SAFE /*8*/:
                        this.key = knVar.mk();
                        continue;
                    case Base64.NO_CLOSE /*16*/:
                        this.value = knVar.mk();
                        continue;
                    default:
                        if (!m6623a(knVar, mh)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public int hashCode() {
            int i = (((this.key + 527) * 31) + this.value) * 31;
            int hashCode = (this.adU == null || this.adU.isEmpty()) ? 0 : this.adU.hashCode();
            return hashCode + i;
        }

        public C1782e m7986j() {
            this.key = 0;
            this.value = 0;
            this.adU = null;
            this.adY = -1;
            return this;
        }
    }

    /* renamed from: com.google.android.gms.internal.c.f */
    public static final class C1783f extends kp {
        public String[] eV;
        public String[] eW;
        public C1816a[] eX;
        public C1782e[] eY;
        public C1779b[] eZ;
        public C1779b[] fa;
        public C1779b[] fb;
        public C1784g[] fc;
        public String fd;
        public String fe;
        public String ff;
        public String fg;
        public C1778a fh;
        public float fi;
        public boolean fj;
        public String[] fk;
        public int fl;

        public C1783f() {
            m7992k();
        }

        public static C1783f m7987a(byte[] bArr) {
            return (C1783f) kt.m6614a(new C1783f(), bArr);
        }

        public void m7988a(ko koVar) {
            int i = 0;
            if (this.eW != null && this.eW.length > 0) {
                for (String str : this.eW) {
                    if (str != null) {
                        koVar.m8930b(1, str);
                    }
                }
            }
            if (this.eX != null && this.eX.length > 0) {
                for (kt ktVar : this.eX) {
                    if (ktVar != null) {
                        koVar.m8925a(2, ktVar);
                    }
                }
            }
            if (this.eY != null && this.eY.length > 0) {
                for (kt ktVar2 : this.eY) {
                    if (ktVar2 != null) {
                        koVar.m8925a(3, ktVar2);
                    }
                }
            }
            if (this.eZ != null && this.eZ.length > 0) {
                for (kt ktVar22 : this.eZ) {
                    if (ktVar22 != null) {
                        koVar.m8925a(4, ktVar22);
                    }
                }
            }
            if (this.fa != null && this.fa.length > 0) {
                for (kt ktVar222 : this.fa) {
                    if (ktVar222 != null) {
                        koVar.m8925a(5, ktVar222);
                    }
                }
            }
            if (this.fb != null && this.fb.length > 0) {
                for (kt ktVar2222 : this.fb) {
                    if (ktVar2222 != null) {
                        koVar.m8925a(6, ktVar2222);
                    }
                }
            }
            if (this.fc != null && this.fc.length > 0) {
                for (kt ktVar22222 : this.fc) {
                    if (ktVar22222 != null) {
                        koVar.m8925a(7, ktVar22222);
                    }
                }
            }
            if (!this.fd.equals("")) {
                koVar.m8930b(9, this.fd);
            }
            if (!this.fe.equals("")) {
                koVar.m8930b(10, this.fe);
            }
            if (!this.ff.equals(ITKSvc.CODEREVISION)) {
                koVar.m8930b(12, this.ff);
            }
            if (!this.fg.equals("")) {
                koVar.m8930b(13, this.fg);
            }
            if (this.fh != null) {
                koVar.m8925a(14, this.fh);
            }
            if (Float.floatToIntBits(this.fi) != Float.floatToIntBits(0.0f)) {
                koVar.m8928b(15, this.fi);
            }
            if (this.fk != null && this.fk.length > 0) {
                for (String str2 : this.fk) {
                    if (str2 != null) {
                        koVar.m8930b(16, str2);
                    }
                }
            }
            if (this.fl != 0) {
                koVar.m8935i(17, this.fl);
            }
            if (this.fj) {
                koVar.m8926a(18, this.fj);
            }
            if (this.eV != null && this.eV.length > 0) {
                while (i < this.eV.length) {
                    String str3 = this.eV[i];
                    if (str3 != null) {
                        koVar.m8930b(19, str3);
                    }
                    i++;
                }
            }
            super.m6622a(koVar);
        }

        public /* synthetic */ kt m7989b(kn knVar) {
            return m7991g(knVar);
        }

        public int m7990c() {
            int i;
            int i2;
            int i3;
            int i4 = 0;
            int c = super.m6620c();
            if (this.eW == null || this.eW.length <= 0) {
                i = c;
            } else {
                i2 = 0;
                i3 = 0;
                for (String str : this.eW) {
                    if (str != null) {
                        i3++;
                        i2 += ko.cf(str);
                    }
                }
                i = (c + i2) + (i3 * 1);
            }
            if (this.eX != null && this.eX.length > 0) {
                i2 = i;
                for (kt ktVar : this.eX) {
                    if (ktVar != null) {
                        i2 += ko.m8912b(2, ktVar);
                    }
                }
                i = i2;
            }
            if (this.eY != null && this.eY.length > 0) {
                i2 = i;
                for (kt ktVar2 : this.eY) {
                    if (ktVar2 != null) {
                        i2 += ko.m8912b(3, ktVar2);
                    }
                }
                i = i2;
            }
            if (this.eZ != null && this.eZ.length > 0) {
                i2 = i;
                for (kt ktVar22 : this.eZ) {
                    if (ktVar22 != null) {
                        i2 += ko.m8912b(4, ktVar22);
                    }
                }
                i = i2;
            }
            if (this.fa != null && this.fa.length > 0) {
                i2 = i;
                for (kt ktVar222 : this.fa) {
                    if (ktVar222 != null) {
                        i2 += ko.m8912b(5, ktVar222);
                    }
                }
                i = i2;
            }
            if (this.fb != null && this.fb.length > 0) {
                i2 = i;
                for (kt ktVar2222 : this.fb) {
                    if (ktVar2222 != null) {
                        i2 += ko.m8912b(6, ktVar2222);
                    }
                }
                i = i2;
            }
            if (this.fc != null && this.fc.length > 0) {
                i2 = i;
                for (kt ktVar22222 : this.fc) {
                    if (ktVar22222 != null) {
                        i2 += ko.m8912b(7, ktVar22222);
                    }
                }
                i = i2;
            }
            if (!this.fd.equals("")) {
                i += ko.m8920g(9, this.fd);
            }
            if (!this.fe.equals("")) {
                i += ko.m8920g(10, this.fe);
            }
            if (!this.ff.equals(ITKSvc.CODEREVISION)) {
                i += ko.m8920g(12, this.ff);
            }
            if (!this.fg.equals("")) {
                i += ko.m8920g(13, this.fg);
            }
            if (this.fh != null) {
                i += ko.m8912b(14, this.fh);
            }
            if (Float.floatToIntBits(this.fi) != Float.floatToIntBits(0.0f)) {
                i += ko.m8915c(15, this.fi);
            }
            if (this.fk != null && this.fk.length > 0) {
                i3 = 0;
                c = 0;
                for (String str2 : this.fk) {
                    if (str2 != null) {
                        c++;
                        i3 += ko.cf(str2);
                    }
                }
                i = (i + i3) + (c * 2);
            }
            if (this.fl != 0) {
                i += ko.m8921j(17, this.fl);
            }
            if (this.fj) {
                i += ko.m8913b(18, this.fj);
            }
            if (this.eV != null && this.eV.length > 0) {
                i2 = 0;
                i3 = 0;
                while (i4 < this.eV.length) {
                    String str3 = this.eV[i4];
                    if (str3 != null) {
                        i3++;
                        i2 += ko.cf(str3);
                    }
                    i4++;
                }
                i = (i + i2) + (i3 * 2);
            }
            this.adY = i;
            return i;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C1783f)) {
                return false;
            }
            C1783f c1783f = (C1783f) o;
            if (!kr.equals(this.eV, c1783f.eV) || !kr.equals(this.eW, c1783f.eW) || !kr.equals(this.eX, c1783f.eX) || !kr.equals(this.eY, c1783f.eY) || !kr.equals(this.eZ, c1783f.eZ) || !kr.equals(this.fa, c1783f.fa) || !kr.equals(this.fb, c1783f.fb) || !kr.equals(this.fc, c1783f.fc)) {
                return false;
            }
            if (this.fd == null) {
                if (c1783f.fd != null) {
                    return false;
                }
            } else if (!this.fd.equals(c1783f.fd)) {
                return false;
            }
            if (this.fe == null) {
                if (c1783f.fe != null) {
                    return false;
                }
            } else if (!this.fe.equals(c1783f.fe)) {
                return false;
            }
            if (this.ff == null) {
                if (c1783f.ff != null) {
                    return false;
                }
            } else if (!this.ff.equals(c1783f.ff)) {
                return false;
            }
            if (this.fg == null) {
                if (c1783f.fg != null) {
                    return false;
                }
            } else if (!this.fg.equals(c1783f.fg)) {
                return false;
            }
            if (this.fh == null) {
                if (c1783f.fh != null) {
                    return false;
                }
            } else if (!this.fh.equals(c1783f.fh)) {
                return false;
            }
            if (Float.floatToIntBits(this.fi) != Float.floatToIntBits(c1783f.fi) || this.fj != c1783f.fj || !kr.equals(this.fk, c1783f.fk) || this.fl != c1783f.fl) {
                return false;
            }
            if (this.adU == null || this.adU.isEmpty()) {
                return c1783f.adU == null || c1783f.adU.isEmpty();
            } else {
                return this.adU.equals(c1783f.adU);
            }
        }

        public C1783f m7991g(kn knVar) {
            while (true) {
                int mh = knVar.mh();
                int b;
                Object obj;
                switch (mh) {
                    case Base64.DEFAULT /*0*/:
                        break;
                    case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                        b = kw.m8947b(knVar, 10);
                        mh = this.eW == null ? 0 : this.eW.length;
                        obj = new String[(b + mh)];
                        if (mh != 0) {
                            System.arraycopy(this.eW, 0, obj, 0, mh);
                        }
                        while (mh < obj.length - 1) {
                            obj[mh] = knVar.readString();
                            knVar.mh();
                            mh++;
                        }
                        obj[mh] = knVar.readString();
                        this.eW = obj;
                        continue;
                    case C1087k.ActionBar_itemPadding /*18*/:
                        b = kw.m8947b(knVar, 18);
                        mh = this.eX == null ? 0 : this.eX.length;
                        obj = new C1816a[(b + mh)];
                        if (mh != 0) {
                            System.arraycopy(this.eX, 0, obj, 0, mh);
                        }
                        while (mh < obj.length - 1) {
                            obj[mh] = new C1816a();
                            knVar.m8904a(obj[mh]);
                            knVar.mh();
                            mh++;
                        }
                        obj[mh] = new C1816a();
                        knVar.m8904a(obj[mh]);
                        this.eX = obj;
                        continue;
                    case MMException.AD_NO_ACTIVITY /*26*/:
                        b = kw.m8947b(knVar, 26);
                        mh = this.eY == null ? 0 : this.eY.length;
                        obj = new C1782e[(b + mh)];
                        if (mh != 0) {
                            System.arraycopy(this.eY, 0, obj, 0, mh);
                        }
                        while (mh < obj.length - 1) {
                            obj[mh] = new C1782e();
                            knVar.m8904a(obj[mh]);
                            knVar.mh();
                            mh++;
                        }
                        obj[mh] = new C1782e();
                        knVar.m8904a(obj[mh]);
                        this.eY = obj;
                        continue;
                    case 34:
                        b = kw.m8947b(knVar, 34);
                        mh = this.eZ == null ? 0 : this.eZ.length;
                        obj = new C1779b[(b + mh)];
                        if (mh != 0) {
                            System.arraycopy(this.eZ, 0, obj, 0, mh);
                        }
                        while (mh < obj.length - 1) {
                            obj[mh] = new C1779b();
                            knVar.m8904a(obj[mh]);
                            knVar.mh();
                            mh++;
                        }
                        obj[mh] = new C1779b();
                        knVar.m8904a(obj[mh]);
                        this.eZ = obj;
                        continue;
                    case 42:
                        b = kw.m8947b(knVar, 42);
                        mh = this.fa == null ? 0 : this.fa.length;
                        obj = new C1779b[(b + mh)];
                        if (mh != 0) {
                            System.arraycopy(this.fa, 0, obj, 0, mh);
                        }
                        while (mh < obj.length - 1) {
                            obj[mh] = new C1779b();
                            knVar.m8904a(obj[mh]);
                            knVar.mh();
                            mh++;
                        }
                        obj[mh] = new C1779b();
                        knVar.m8904a(obj[mh]);
                        this.fa = obj;
                        continue;
                    case AdSize.PORTRAIT_AD_HEIGHT /*50*/:
                        b = kw.m8947b(knVar, 50);
                        mh = this.fb == null ? 0 : this.fb.length;
                        obj = new C1779b[(b + mh)];
                        if (mh != 0) {
                            System.arraycopy(this.fb, 0, obj, 0, mh);
                        }
                        while (mh < obj.length - 1) {
                            obj[mh] = new C1779b();
                            knVar.m8904a(obj[mh]);
                            knVar.mh();
                            mh++;
                        }
                        obj[mh] = new C1779b();
                        knVar.m8904a(obj[mh]);
                        this.fb = obj;
                        continue;
                    case 58:
                        b = kw.m8947b(knVar, 58);
                        mh = this.fc == null ? 0 : this.fc.length;
                        obj = new C1784g[(b + mh)];
                        if (mh != 0) {
                            System.arraycopy(this.fc, 0, obj, 0, mh);
                        }
                        while (mh < obj.length - 1) {
                            obj[mh] = new C1784g();
                            knVar.m8904a(obj[mh]);
                            knVar.mh();
                            mh++;
                        }
                        obj[mh] = new C1784g();
                        knVar.m8904a(obj[mh]);
                        this.fc = obj;
                        continue;
                    case 74:
                        this.fd = knVar.readString();
                        continue;
                    case 82:
                        this.fe = knVar.readString();
                        continue;
                    case 98:
                        this.ff = knVar.readString();
                        continue;
                    case 106:
                        this.fg = knVar.readString();
                        continue;
                    case 114:
                        if (this.fh == null) {
                            this.fh = new C1778a();
                        }
                        knVar.m8904a(this.fh);
                        continue;
                    case 125:
                        this.fi = knVar.readFloat();
                        continue;
                    case 130:
                        b = kw.m8947b(knVar, 130);
                        mh = this.fk == null ? 0 : this.fk.length;
                        obj = new String[(b + mh)];
                        if (mh != 0) {
                            System.arraycopy(this.fk, 0, obj, 0, mh);
                        }
                        while (mh < obj.length - 1) {
                            obj[mh] = knVar.readString();
                            knVar.mh();
                            mh++;
                        }
                        obj[mh] = knVar.readString();
                        this.fk = obj;
                        continue;
                    case 136:
                        this.fl = knVar.mk();
                        continue;
                    case 144:
                        this.fj = knVar.ml();
                        continue;
                    case 154:
                        b = kw.m8947b(knVar, 154);
                        mh = this.eV == null ? 0 : this.eV.length;
                        obj = new String[(b + mh)];
                        if (mh != 0) {
                            System.arraycopy(this.eV, 0, obj, 0, mh);
                        }
                        while (mh < obj.length - 1) {
                            obj[mh] = knVar.readString();
                            knVar.mh();
                            mh++;
                        }
                        obj[mh] = knVar.readString();
                        this.eV = obj;
                        continue;
                    default:
                        if (!m6623a(knVar, mh)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((((((this.fj ? 1231 : 1237) + (((((this.fh == null ? 0 : this.fh.hashCode()) + (((this.fg == null ? 0 : this.fg.hashCode()) + (((this.ff == null ? 0 : this.ff.hashCode()) + (((this.fe == null ? 0 : this.fe.hashCode()) + (((this.fd == null ? 0 : this.fd.hashCode()) + ((((((((((((((((kr.hashCode(this.eV) + 527) * 31) + kr.hashCode(this.eW)) * 31) + kr.hashCode(this.eX)) * 31) + kr.hashCode(this.eY)) * 31) + kr.hashCode(this.eZ)) * 31) + kr.hashCode(this.fa)) * 31) + kr.hashCode(this.fb)) * 31) + kr.hashCode(this.fc)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31) + Float.floatToIntBits(this.fi)) * 31)) * 31) + kr.hashCode(this.fk)) * 31) + this.fl) * 31;
            if (!(this.adU == null || this.adU.isEmpty())) {
                i = this.adU.hashCode();
            }
            return hashCode + i;
        }

        public C1783f m7992k() {
            this.eV = kw.aef;
            this.eW = kw.aef;
            this.eX = C1816a.m8102r();
            this.eY = C1782e.m7981i();
            this.eZ = C1779b.m7964d();
            this.fa = C1779b.m7964d();
            this.fb = C1779b.m7964d();
            this.fc = C1784g.m7993l();
            this.fd = "";
            this.fe = "";
            this.ff = ITKSvc.CODEREVISION;
            this.fg = "";
            this.fh = null;
            this.fi = 0.0f;
            this.fj = false;
            this.fk = kw.aef;
            this.fl = 0;
            this.adU = null;
            this.adY = -1;
            return this;
        }
    }

    /* renamed from: com.google.android.gms.internal.c.g */
    public static final class C1784g extends kp {
        private static volatile C1784g[] fm;
        public int[] fn;
        public int[] fo;
        public int[] fp;
        public int[] fq;
        public int[] fr;
        public int[] fs;
        public int[] ft;
        public int[] fu;
        public int[] fv;
        public int[] fw;

        public C1784g() {
            m7998m();
        }

        public static C1784g[] m7993l() {
            if (fm == null) {
                synchronized (kr.adX) {
                    if (fm == null) {
                        fm = new C1784g[0];
                    }
                }
            }
            return fm;
        }

        public void m7994a(ko koVar) {
            int i = 0;
            if (this.fn != null && this.fn.length > 0) {
                for (int i2 : this.fn) {
                    koVar.m8935i(1, i2);
                }
            }
            if (this.fo != null && this.fo.length > 0) {
                for (int i22 : this.fo) {
                    koVar.m8935i(2, i22);
                }
            }
            if (this.fp != null && this.fp.length > 0) {
                for (int i222 : this.fp) {
                    koVar.m8935i(3, i222);
                }
            }
            if (this.fq != null && this.fq.length > 0) {
                for (int i2222 : this.fq) {
                    koVar.m8935i(4, i2222);
                }
            }
            if (this.fr != null && this.fr.length > 0) {
                for (int i22222 : this.fr) {
                    koVar.m8935i(5, i22222);
                }
            }
            if (this.fs != null && this.fs.length > 0) {
                for (int i222222 : this.fs) {
                    koVar.m8935i(6, i222222);
                }
            }
            if (this.ft != null && this.ft.length > 0) {
                for (int i2222222 : this.ft) {
                    koVar.m8935i(7, i2222222);
                }
            }
            if (this.fu != null && this.fu.length > 0) {
                for (int i22222222 : this.fu) {
                    koVar.m8935i(8, i22222222);
                }
            }
            if (this.fv != null && this.fv.length > 0) {
                for (int i222222222 : this.fv) {
                    koVar.m8935i(9, i222222222);
                }
            }
            if (this.fw != null && this.fw.length > 0) {
                while (i < this.fw.length) {
                    koVar.m8935i(10, this.fw[i]);
                    i++;
                }
            }
            super.m6622a(koVar);
        }

        public /* synthetic */ kt m7995b(kn knVar) {
            return m7997h(knVar);
        }

        public int m7996c() {
            int i;
            int i2;
            int i3 = 0;
            int c = super.m6620c();
            if (this.fn == null || this.fn.length <= 0) {
                i = c;
            } else {
                i2 = 0;
                for (int cX : this.fn) {
                    i2 += ko.cX(cX);
                }
                i = (c + i2) + (this.fn.length * 1);
            }
            if (this.fo != null && this.fo.length > 0) {
                c = 0;
                for (int cX2 : this.fo) {
                    c += ko.cX(cX2);
                }
                i = (i + c) + (this.fo.length * 1);
            }
            if (this.fp != null && this.fp.length > 0) {
                c = 0;
                for (int cX22 : this.fp) {
                    c += ko.cX(cX22);
                }
                i = (i + c) + (this.fp.length * 1);
            }
            if (this.fq != null && this.fq.length > 0) {
                c = 0;
                for (int cX222 : this.fq) {
                    c += ko.cX(cX222);
                }
                i = (i + c) + (this.fq.length * 1);
            }
            if (this.fr != null && this.fr.length > 0) {
                c = 0;
                for (int cX2222 : this.fr) {
                    c += ko.cX(cX2222);
                }
                i = (i + c) + (this.fr.length * 1);
            }
            if (this.fs != null && this.fs.length > 0) {
                c = 0;
                for (int cX22222 : this.fs) {
                    c += ko.cX(cX22222);
                }
                i = (i + c) + (this.fs.length * 1);
            }
            if (this.ft != null && this.ft.length > 0) {
                c = 0;
                for (int cX222222 : this.ft) {
                    c += ko.cX(cX222222);
                }
                i = (i + c) + (this.ft.length * 1);
            }
            if (this.fu != null && this.fu.length > 0) {
                c = 0;
                for (int cX2222222 : this.fu) {
                    c += ko.cX(cX2222222);
                }
                i = (i + c) + (this.fu.length * 1);
            }
            if (this.fv != null && this.fv.length > 0) {
                c = 0;
                for (int cX22222222 : this.fv) {
                    c += ko.cX(cX22222222);
                }
                i = (i + c) + (this.fv.length * 1);
            }
            if (this.fw != null && this.fw.length > 0) {
                i2 = 0;
                while (i3 < this.fw.length) {
                    i2 += ko.cX(this.fw[i3]);
                    i3++;
                }
                i = (i + i2) + (this.fw.length * 1);
            }
            this.adY = i;
            return i;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C1784g)) {
                return false;
            }
            C1784g c1784g = (C1784g) o;
            if (!kr.equals(this.fn, c1784g.fn) || !kr.equals(this.fo, c1784g.fo) || !kr.equals(this.fp, c1784g.fp) || !kr.equals(this.fq, c1784g.fq) || !kr.equals(this.fr, c1784g.fr) || !kr.equals(this.fs, c1784g.fs) || !kr.equals(this.ft, c1784g.ft) || !kr.equals(this.fu, c1784g.fu) || !kr.equals(this.fv, c1784g.fv) || !kr.equals(this.fw, c1784g.fw)) {
                return false;
            }
            if (this.adU == null || this.adU.isEmpty()) {
                return c1784g.adU == null || c1784g.adU.isEmpty();
            } else {
                return this.adU.equals(c1784g.adU);
            }
        }

        public C1784g m7997h(kn knVar) {
            while (true) {
                int mh = knVar.mh();
                int b;
                Object obj;
                int cR;
                Object obj2;
                switch (mh) {
                    case Base64.DEFAULT /*0*/:
                        break;
                    case Base64.URL_SAFE /*8*/:
                        b = kw.m8947b(knVar, 8);
                        mh = this.fn == null ? 0 : this.fn.length;
                        obj = new int[(b + mh)];
                        if (mh != 0) {
                            System.arraycopy(this.fn, 0, obj, 0, mh);
                        }
                        while (mh < obj.length - 1) {
                            obj[mh] = knVar.mk();
                            knVar.mh();
                            mh++;
                        }
                        obj[mh] = knVar.mk();
                        this.fn = obj;
                        continue;
                    case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                        cR = knVar.cR(knVar.mn());
                        b = knVar.getPosition();
                        mh = 0;
                        while (knVar.ms() > 0) {
                            knVar.mk();
                            mh++;
                        }
                        knVar.cT(b);
                        b = this.fn == null ? 0 : this.fn.length;
                        obj2 = new int[(mh + b)];
                        if (b != 0) {
                            System.arraycopy(this.fn, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = knVar.mk();
                            b++;
                        }
                        this.fn = obj2;
                        knVar.cS(cR);
                        continue;
                    case Base64.NO_CLOSE /*16*/:
                        b = kw.m8947b(knVar, 16);
                        mh = this.fo == null ? 0 : this.fo.length;
                        obj = new int[(b + mh)];
                        if (mh != 0) {
                            System.arraycopy(this.fo, 0, obj, 0, mh);
                        }
                        while (mh < obj.length - 1) {
                            obj[mh] = knVar.mk();
                            knVar.mh();
                            mh++;
                        }
                        obj[mh] = knVar.mk();
                        this.fo = obj;
                        continue;
                    case C1087k.ActionBar_itemPadding /*18*/:
                        cR = knVar.cR(knVar.mn());
                        b = knVar.getPosition();
                        mh = 0;
                        while (knVar.ms() > 0) {
                            knVar.mk();
                            mh++;
                        }
                        knVar.cT(b);
                        b = this.fo == null ? 0 : this.fo.length;
                        obj2 = new int[(mh + b)];
                        if (b != 0) {
                            System.arraycopy(this.fo, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = knVar.mk();
                            b++;
                        }
                        this.fo = obj2;
                        knVar.cS(cR);
                        continue;
                    case MMException.DISPLAY_AD_NOT_PERMITTED /*24*/:
                        b = kw.m8947b(knVar, 24);
                        mh = this.fp == null ? 0 : this.fp.length;
                        obj = new int[(b + mh)];
                        if (mh != 0) {
                            System.arraycopy(this.fp, 0, obj, 0, mh);
                        }
                        while (mh < obj.length - 1) {
                            obj[mh] = knVar.mk();
                            knVar.mh();
                            mh++;
                        }
                        obj[mh] = knVar.mk();
                        this.fp = obj;
                        continue;
                    case MMException.AD_NO_ACTIVITY /*26*/:
                        cR = knVar.cR(knVar.mn());
                        b = knVar.getPosition();
                        mh = 0;
                        while (knVar.ms() > 0) {
                            knVar.mk();
                            mh++;
                        }
                        knVar.cT(b);
                        b = this.fp == null ? 0 : this.fp.length;
                        obj2 = new int[(mh + b)];
                        if (b != 0) {
                            System.arraycopy(this.fp, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = knVar.mk();
                            b++;
                        }
                        this.fp = obj2;
                        knVar.cS(cR);
                        continue;
                    case AdSize.LANDSCAPE_AD_HEIGHT /*32*/:
                        b = kw.m8947b(knVar, 32);
                        mh = this.fq == null ? 0 : this.fq.length;
                        obj = new int[(b + mh)];
                        if (mh != 0) {
                            System.arraycopy(this.fq, 0, obj, 0, mh);
                        }
                        while (mh < obj.length - 1) {
                            obj[mh] = knVar.mk();
                            knVar.mh();
                            mh++;
                        }
                        obj[mh] = knVar.mk();
                        this.fq = obj;
                        continue;
                    case 34:
                        cR = knVar.cR(knVar.mn());
                        b = knVar.getPosition();
                        mh = 0;
                        while (knVar.ms() > 0) {
                            knVar.mk();
                            mh++;
                        }
                        knVar.cT(b);
                        b = this.fq == null ? 0 : this.fq.length;
                        obj2 = new int[(mh + b)];
                        if (b != 0) {
                            System.arraycopy(this.fq, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = knVar.mk();
                            b++;
                        }
                        this.fq = obj2;
                        knVar.cS(cR);
                        continue;
                    case 40:
                        b = kw.m8947b(knVar, 40);
                        mh = this.fr == null ? 0 : this.fr.length;
                        obj = new int[(b + mh)];
                        if (mh != 0) {
                            System.arraycopy(this.fr, 0, obj, 0, mh);
                        }
                        while (mh < obj.length - 1) {
                            obj[mh] = knVar.mk();
                            knVar.mh();
                            mh++;
                        }
                        obj[mh] = knVar.mk();
                        this.fr = obj;
                        continue;
                    case 42:
                        cR = knVar.cR(knVar.mn());
                        b = knVar.getPosition();
                        mh = 0;
                        while (knVar.ms() > 0) {
                            knVar.mk();
                            mh++;
                        }
                        knVar.cT(b);
                        b = this.fr == null ? 0 : this.fr.length;
                        obj2 = new int[(mh + b)];
                        if (b != 0) {
                            System.arraycopy(this.fr, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = knVar.mk();
                            b++;
                        }
                        this.fr = obj2;
                        knVar.cS(cR);
                        continue;
                    case 48:
                        b = kw.m8947b(knVar, 48);
                        mh = this.fs == null ? 0 : this.fs.length;
                        obj = new int[(b + mh)];
                        if (mh != 0) {
                            System.arraycopy(this.fs, 0, obj, 0, mh);
                        }
                        while (mh < obj.length - 1) {
                            obj[mh] = knVar.mk();
                            knVar.mh();
                            mh++;
                        }
                        obj[mh] = knVar.mk();
                        this.fs = obj;
                        continue;
                    case AdSize.PORTRAIT_AD_HEIGHT /*50*/:
                        cR = knVar.cR(knVar.mn());
                        b = knVar.getPosition();
                        mh = 0;
                        while (knVar.ms() > 0) {
                            knVar.mk();
                            mh++;
                        }
                        knVar.cT(b);
                        b = this.fs == null ? 0 : this.fs.length;
                        obj2 = new int[(mh + b)];
                        if (b != 0) {
                            System.arraycopy(this.fs, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = knVar.mk();
                            b++;
                        }
                        this.fs = obj2;
                        knVar.cS(cR);
                        continue;
                    case 56:
                        b = kw.m8947b(knVar, 56);
                        mh = this.ft == null ? 0 : this.ft.length;
                        obj = new int[(b + mh)];
                        if (mh != 0) {
                            System.arraycopy(this.ft, 0, obj, 0, mh);
                        }
                        while (mh < obj.length - 1) {
                            obj[mh] = knVar.mk();
                            knVar.mh();
                            mh++;
                        }
                        obj[mh] = knVar.mk();
                        this.ft = obj;
                        continue;
                    case 58:
                        cR = knVar.cR(knVar.mn());
                        b = knVar.getPosition();
                        mh = 0;
                        while (knVar.ms() > 0) {
                            knVar.mk();
                            mh++;
                        }
                        knVar.cT(b);
                        b = this.ft == null ? 0 : this.ft.length;
                        obj2 = new int[(mh + b)];
                        if (b != 0) {
                            System.arraycopy(this.ft, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = knVar.mk();
                            b++;
                        }
                        this.ft = obj2;
                        knVar.cS(cR);
                        continue;
                    case 64:
                        b = kw.m8947b(knVar, 64);
                        mh = this.fu == null ? 0 : this.fu.length;
                        obj = new int[(b + mh)];
                        if (mh != 0) {
                            System.arraycopy(this.fu, 0, obj, 0, mh);
                        }
                        while (mh < obj.length - 1) {
                            obj[mh] = knVar.mk();
                            knVar.mh();
                            mh++;
                        }
                        obj[mh] = knVar.mk();
                        this.fu = obj;
                        continue;
                    case 66:
                        cR = knVar.cR(knVar.mn());
                        b = knVar.getPosition();
                        mh = 0;
                        while (knVar.ms() > 0) {
                            knVar.mk();
                            mh++;
                        }
                        knVar.cT(b);
                        b = this.fu == null ? 0 : this.fu.length;
                        obj2 = new int[(mh + b)];
                        if (b != 0) {
                            System.arraycopy(this.fu, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = knVar.mk();
                            b++;
                        }
                        this.fu = obj2;
                        knVar.cS(cR);
                        continue;
                    case 72:
                        b = kw.m8947b(knVar, 72);
                        mh = this.fv == null ? 0 : this.fv.length;
                        obj = new int[(b + mh)];
                        if (mh != 0) {
                            System.arraycopy(this.fv, 0, obj, 0, mh);
                        }
                        while (mh < obj.length - 1) {
                            obj[mh] = knVar.mk();
                            knVar.mh();
                            mh++;
                        }
                        obj[mh] = knVar.mk();
                        this.fv = obj;
                        continue;
                    case 74:
                        cR = knVar.cR(knVar.mn());
                        b = knVar.getPosition();
                        mh = 0;
                        while (knVar.ms() > 0) {
                            knVar.mk();
                            mh++;
                        }
                        knVar.cT(b);
                        b = this.fv == null ? 0 : this.fv.length;
                        obj2 = new int[(mh + b)];
                        if (b != 0) {
                            System.arraycopy(this.fv, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = knVar.mk();
                            b++;
                        }
                        this.fv = obj2;
                        knVar.cS(cR);
                        continue;
                    case 80:
                        b = kw.m8947b(knVar, 80);
                        mh = this.fw == null ? 0 : this.fw.length;
                        obj = new int[(b + mh)];
                        if (mh != 0) {
                            System.arraycopy(this.fw, 0, obj, 0, mh);
                        }
                        while (mh < obj.length - 1) {
                            obj[mh] = knVar.mk();
                            knVar.mh();
                            mh++;
                        }
                        obj[mh] = knVar.mk();
                        this.fw = obj;
                        continue;
                    case 82:
                        cR = knVar.cR(knVar.mn());
                        b = knVar.getPosition();
                        mh = 0;
                        while (knVar.ms() > 0) {
                            knVar.mk();
                            mh++;
                        }
                        knVar.cT(b);
                        b = this.fw == null ? 0 : this.fw.length;
                        obj2 = new int[(mh + b)];
                        if (b != 0) {
                            System.arraycopy(this.fw, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = knVar.mk();
                            b++;
                        }
                        this.fw = obj2;
                        knVar.cS(cR);
                        continue;
                    default:
                        if (!m6623a(knVar, mh)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public int hashCode() {
            int hashCode = (((((((((((((((((((kr.hashCode(this.fn) + 527) * 31) + kr.hashCode(this.fo)) * 31) + kr.hashCode(this.fp)) * 31) + kr.hashCode(this.fq)) * 31) + kr.hashCode(this.fr)) * 31) + kr.hashCode(this.fs)) * 31) + kr.hashCode(this.ft)) * 31) + kr.hashCode(this.fu)) * 31) + kr.hashCode(this.fv)) * 31) + kr.hashCode(this.fw)) * 31;
            int hashCode2 = (this.adU == null || this.adU.isEmpty()) ? 0 : this.adU.hashCode();
            return hashCode2 + hashCode;
        }

        public C1784g m7998m() {
            this.fn = kw.aea;
            this.fo = kw.aea;
            this.fp = kw.aea;
            this.fq = kw.aea;
            this.fr = kw.aea;
            this.fs = kw.aea;
            this.ft = kw.aea;
            this.fu = kw.aea;
            this.fv = kw.aea;
            this.fw = kw.aea;
            this.adU = null;
            this.adY = -1;
            return this;
        }
    }

    /* renamed from: com.google.android.gms.internal.c.h */
    public static final class C1785h extends kp {
        public static final kq fx;
        private static final C1785h[] fy;
        public int[] fA;
        public int[] fB;
        public int fC;
        public int[] fD;
        public int fE;
        public int fF;
        public int[] fz;

        static {
            fx = kq.m8940a(11, C1785h.class, 810);
            fy = new C1785h[0];
        }

        public C1785h() {
            m8003n();
        }

        public void m7999a(ko koVar) {
            int i = 0;
            if (this.fz != null && this.fz.length > 0) {
                for (int i2 : this.fz) {
                    koVar.m8935i(1, i2);
                }
            }
            if (this.fA != null && this.fA.length > 0) {
                for (int i22 : this.fA) {
                    koVar.m8935i(2, i22);
                }
            }
            if (this.fB != null && this.fB.length > 0) {
                for (int i222 : this.fB) {
                    koVar.m8935i(3, i222);
                }
            }
            if (this.fC != 0) {
                koVar.m8935i(4, this.fC);
            }
            if (this.fD != null && this.fD.length > 0) {
                while (i < this.fD.length) {
                    koVar.m8935i(5, this.fD[i]);
                    i++;
                }
            }
            if (this.fE != 0) {
                koVar.m8935i(6, this.fE);
            }
            if (this.fF != 0) {
                koVar.m8935i(7, this.fF);
            }
            super.m6622a(koVar);
        }

        public /* synthetic */ kt m8000b(kn knVar) {
            return m8002i(knVar);
        }

        public int m8001c() {
            int i;
            int i2;
            int i3 = 0;
            int c = super.m6620c();
            if (this.fz == null || this.fz.length <= 0) {
                i = c;
            } else {
                i2 = 0;
                for (int cX : this.fz) {
                    i2 += ko.cX(cX);
                }
                i = (c + i2) + (this.fz.length * 1);
            }
            if (this.fA != null && this.fA.length > 0) {
                c = 0;
                for (int cX2 : this.fA) {
                    c += ko.cX(cX2);
                }
                i = (i + c) + (this.fA.length * 1);
            }
            if (this.fB != null && this.fB.length > 0) {
                c = 0;
                for (int cX22 : this.fB) {
                    c += ko.cX(cX22);
                }
                i = (i + c) + (this.fB.length * 1);
            }
            if (this.fC != 0) {
                i += ko.m8921j(4, this.fC);
            }
            if (this.fD != null && this.fD.length > 0) {
                i2 = 0;
                while (i3 < this.fD.length) {
                    i2 += ko.cX(this.fD[i3]);
                    i3++;
                }
                i = (i + i2) + (this.fD.length * 1);
            }
            if (this.fE != 0) {
                i += ko.m8921j(6, this.fE);
            }
            if (this.fF != 0) {
                i += ko.m8921j(7, this.fF);
            }
            this.adY = i;
            return i;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C1785h)) {
                return false;
            }
            C1785h c1785h = (C1785h) o;
            if (!kr.equals(this.fz, c1785h.fz) || !kr.equals(this.fA, c1785h.fA) || !kr.equals(this.fB, c1785h.fB) || this.fC != c1785h.fC || !kr.equals(this.fD, c1785h.fD) || this.fE != c1785h.fE || this.fF != c1785h.fF) {
                return false;
            }
            if (this.adU == null || this.adU.isEmpty()) {
                return c1785h.adU == null || c1785h.adU.isEmpty();
            } else {
                return this.adU.equals(c1785h.adU);
            }
        }

        public int hashCode() {
            int hashCode = (((((((((((((kr.hashCode(this.fz) + 527) * 31) + kr.hashCode(this.fA)) * 31) + kr.hashCode(this.fB)) * 31) + this.fC) * 31) + kr.hashCode(this.fD)) * 31) + this.fE) * 31) + this.fF) * 31;
            int hashCode2 = (this.adU == null || this.adU.isEmpty()) ? 0 : this.adU.hashCode();
            return hashCode2 + hashCode;
        }

        public C1785h m8002i(kn knVar) {
            while (true) {
                int mh = knVar.mh();
                int b;
                Object obj;
                int cR;
                Object obj2;
                switch (mh) {
                    case Base64.DEFAULT /*0*/:
                        break;
                    case Base64.URL_SAFE /*8*/:
                        b = kw.m8947b(knVar, 8);
                        mh = this.fz == null ? 0 : this.fz.length;
                        obj = new int[(b + mh)];
                        if (mh != 0) {
                            System.arraycopy(this.fz, 0, obj, 0, mh);
                        }
                        while (mh < obj.length - 1) {
                            obj[mh] = knVar.mk();
                            knVar.mh();
                            mh++;
                        }
                        obj[mh] = knVar.mk();
                        this.fz = obj;
                        continue;
                    case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                        cR = knVar.cR(knVar.mn());
                        b = knVar.getPosition();
                        mh = 0;
                        while (knVar.ms() > 0) {
                            knVar.mk();
                            mh++;
                        }
                        knVar.cT(b);
                        b = this.fz == null ? 0 : this.fz.length;
                        obj2 = new int[(mh + b)];
                        if (b != 0) {
                            System.arraycopy(this.fz, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = knVar.mk();
                            b++;
                        }
                        this.fz = obj2;
                        knVar.cS(cR);
                        continue;
                    case Base64.NO_CLOSE /*16*/:
                        b = kw.m8947b(knVar, 16);
                        mh = this.fA == null ? 0 : this.fA.length;
                        obj = new int[(b + mh)];
                        if (mh != 0) {
                            System.arraycopy(this.fA, 0, obj, 0, mh);
                        }
                        while (mh < obj.length - 1) {
                            obj[mh] = knVar.mk();
                            knVar.mh();
                            mh++;
                        }
                        obj[mh] = knVar.mk();
                        this.fA = obj;
                        continue;
                    case C1087k.ActionBar_itemPadding /*18*/:
                        cR = knVar.cR(knVar.mn());
                        b = knVar.getPosition();
                        mh = 0;
                        while (knVar.ms() > 0) {
                            knVar.mk();
                            mh++;
                        }
                        knVar.cT(b);
                        b = this.fA == null ? 0 : this.fA.length;
                        obj2 = new int[(mh + b)];
                        if (b != 0) {
                            System.arraycopy(this.fA, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = knVar.mk();
                            b++;
                        }
                        this.fA = obj2;
                        knVar.cS(cR);
                        continue;
                    case MMException.DISPLAY_AD_NOT_PERMITTED /*24*/:
                        b = kw.m8947b(knVar, 24);
                        mh = this.fB == null ? 0 : this.fB.length;
                        obj = new int[(b + mh)];
                        if (mh != 0) {
                            System.arraycopy(this.fB, 0, obj, 0, mh);
                        }
                        while (mh < obj.length - 1) {
                            obj[mh] = knVar.mk();
                            knVar.mh();
                            mh++;
                        }
                        obj[mh] = knVar.mk();
                        this.fB = obj;
                        continue;
                    case MMException.AD_NO_ACTIVITY /*26*/:
                        cR = knVar.cR(knVar.mn());
                        b = knVar.getPosition();
                        mh = 0;
                        while (knVar.ms() > 0) {
                            knVar.mk();
                            mh++;
                        }
                        knVar.cT(b);
                        b = this.fB == null ? 0 : this.fB.length;
                        obj2 = new int[(mh + b)];
                        if (b != 0) {
                            System.arraycopy(this.fB, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = knVar.mk();
                            b++;
                        }
                        this.fB = obj2;
                        knVar.cS(cR);
                        continue;
                    case AdSize.LANDSCAPE_AD_HEIGHT /*32*/:
                        this.fC = knVar.mk();
                        continue;
                    case 40:
                        b = kw.m8947b(knVar, 40);
                        mh = this.fD == null ? 0 : this.fD.length;
                        obj = new int[(b + mh)];
                        if (mh != 0) {
                            System.arraycopy(this.fD, 0, obj, 0, mh);
                        }
                        while (mh < obj.length - 1) {
                            obj[mh] = knVar.mk();
                            knVar.mh();
                            mh++;
                        }
                        obj[mh] = knVar.mk();
                        this.fD = obj;
                        continue;
                    case 42:
                        cR = knVar.cR(knVar.mn());
                        b = knVar.getPosition();
                        mh = 0;
                        while (knVar.ms() > 0) {
                            knVar.mk();
                            mh++;
                        }
                        knVar.cT(b);
                        b = this.fD == null ? 0 : this.fD.length;
                        obj2 = new int[(mh + b)];
                        if (b != 0) {
                            System.arraycopy(this.fD, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = knVar.mk();
                            b++;
                        }
                        this.fD = obj2;
                        knVar.cS(cR);
                        continue;
                    case 48:
                        this.fE = knVar.mk();
                        continue;
                    case 56:
                        this.fF = knVar.mk();
                        continue;
                    default:
                        if (!m6623a(knVar, mh)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public C1785h m8003n() {
            this.fz = kw.aea;
            this.fA = kw.aea;
            this.fB = kw.aea;
            this.fC = 0;
            this.fD = kw.aea;
            this.fE = 0;
            this.fF = 0;
            this.adU = null;
            this.adY = -1;
            return this;
        }
    }

    /* renamed from: com.google.android.gms.internal.c.i */
    public static final class C1786i extends kp {
        private static volatile C1786i[] fG;
        public C1816a fH;
        public C1781d fI;
        public String name;

        public C1786i() {
            m8009p();
        }

        public static C1786i[] m8004o() {
            if (fG == null) {
                synchronized (kr.adX) {
                    if (fG == null) {
                        fG = new C1786i[0];
                    }
                }
            }
            return fG;
        }

        public void m8005a(ko koVar) {
            if (!this.name.equals("")) {
                koVar.m8930b(1, this.name);
            }
            if (this.fH != null) {
                koVar.m8925a(2, this.fH);
            }
            if (this.fI != null) {
                koVar.m8925a(3, this.fI);
            }
            super.m6622a(koVar);
        }

        public /* synthetic */ kt m8006b(kn knVar) {
            return m8008j(knVar);
        }

        public int m8007c() {
            int c = super.m6620c();
            if (!this.name.equals("")) {
                c += ko.m8920g(1, this.name);
            }
            if (this.fH != null) {
                c += ko.m8912b(2, this.fH);
            }
            if (this.fI != null) {
                c += ko.m8912b(3, this.fI);
            }
            this.adY = c;
            return c;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C1786i)) {
                return false;
            }
            C1786i c1786i = (C1786i) o;
            if (this.name == null) {
                if (c1786i.name != null) {
                    return false;
                }
            } else if (!this.name.equals(c1786i.name)) {
                return false;
            }
            if (this.fH == null) {
                if (c1786i.fH != null) {
                    return false;
                }
            } else if (!this.fH.equals(c1786i.fH)) {
                return false;
            }
            if (this.fI == null) {
                if (c1786i.fI != null) {
                    return false;
                }
            } else if (!this.fI.equals(c1786i.fI)) {
                return false;
            }
            if (this.adU == null || this.adU.isEmpty()) {
                return c1786i.adU == null || c1786i.adU.isEmpty();
            } else {
                return this.adU.equals(c1786i.adU);
            }
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.fI == null ? 0 : this.fI.hashCode()) + (((this.fH == null ? 0 : this.fH.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + 527) * 31)) * 31)) * 31;
            if (!(this.adU == null || this.adU.isEmpty())) {
                i = this.adU.hashCode();
            }
            return hashCode + i;
        }

        public C1786i m8008j(kn knVar) {
            while (true) {
                int mh = knVar.mh();
                switch (mh) {
                    case Base64.DEFAULT /*0*/:
                        break;
                    case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                        this.name = knVar.readString();
                        continue;
                    case C1087k.ActionBar_itemPadding /*18*/:
                        if (this.fH == null) {
                            this.fH = new C1816a();
                        }
                        knVar.m8904a(this.fH);
                        continue;
                    case MMException.AD_NO_ACTIVITY /*26*/:
                        if (this.fI == null) {
                            this.fI = new C1781d();
                        }
                        knVar.m8904a(this.fI);
                        continue;
                    default:
                        if (!m6623a(knVar, mh)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public C1786i m8009p() {
            this.name = "";
            this.fH = null;
            this.fI = null;
            this.adU = null;
            this.adY = -1;
            return this;
        }
    }

    /* renamed from: com.google.android.gms.internal.c.j */
    public static final class C1787j extends kp {
        public C1786i[] fJ;
        public C1783f fK;
        public String fL;

        public C1787j() {
            m8015q();
        }

        public static C1787j m8010b(byte[] bArr) {
            return (C1787j) kt.m6614a(new C1787j(), bArr);
        }

        public void m8011a(ko koVar) {
            if (this.fJ != null && this.fJ.length > 0) {
                for (kt ktVar : this.fJ) {
                    if (ktVar != null) {
                        koVar.m8925a(1, ktVar);
                    }
                }
            }
            if (this.fK != null) {
                koVar.m8925a(2, this.fK);
            }
            if (!this.fL.equals("")) {
                koVar.m8930b(3, this.fL);
            }
            super.m6622a(koVar);
        }

        public /* synthetic */ kt m8012b(kn knVar) {
            return m8014k(knVar);
        }

        public int m8013c() {
            int c = super.m6620c();
            if (this.fJ != null && this.fJ.length > 0) {
                for (kt ktVar : this.fJ) {
                    if (ktVar != null) {
                        c += ko.m8912b(1, ktVar);
                    }
                }
            }
            if (this.fK != null) {
                c += ko.m8912b(2, this.fK);
            }
            if (!this.fL.equals("")) {
                c += ko.m8920g(3, this.fL);
            }
            this.adY = c;
            return c;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C1787j)) {
                return false;
            }
            C1787j c1787j = (C1787j) o;
            if (!kr.equals(this.fJ, c1787j.fJ)) {
                return false;
            }
            if (this.fK == null) {
                if (c1787j.fK != null) {
                    return false;
                }
            } else if (!this.fK.equals(c1787j.fK)) {
                return false;
            }
            if (this.fL == null) {
                if (c1787j.fL != null) {
                    return false;
                }
            } else if (!this.fL.equals(c1787j.fL)) {
                return false;
            }
            if (this.adU == null || this.adU.isEmpty()) {
                return c1787j.adU == null || c1787j.adU.isEmpty();
            } else {
                return this.adU.equals(c1787j.adU);
            }
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.fL == null ? 0 : this.fL.hashCode()) + (((this.fK == null ? 0 : this.fK.hashCode()) + ((kr.hashCode(this.fJ) + 527) * 31)) * 31)) * 31;
            if (!(this.adU == null || this.adU.isEmpty())) {
                i = this.adU.hashCode();
            }
            return hashCode + i;
        }

        public C1787j m8014k(kn knVar) {
            while (true) {
                int mh = knVar.mh();
                switch (mh) {
                    case Base64.DEFAULT /*0*/:
                        break;
                    case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                        int b = kw.m8947b(knVar, 10);
                        mh = this.fJ == null ? 0 : this.fJ.length;
                        Object obj = new C1786i[(b + mh)];
                        if (mh != 0) {
                            System.arraycopy(this.fJ, 0, obj, 0, mh);
                        }
                        while (mh < obj.length - 1) {
                            obj[mh] = new C1786i();
                            knVar.m8904a(obj[mh]);
                            knVar.mh();
                            mh++;
                        }
                        obj[mh] = new C1786i();
                        knVar.m8904a(obj[mh]);
                        this.fJ = obj;
                        continue;
                    case C1087k.ActionBar_itemPadding /*18*/:
                        if (this.fK == null) {
                            this.fK = new C1783f();
                        }
                        knVar.m8904a(this.fK);
                        continue;
                    case MMException.AD_NO_ACTIVITY /*26*/:
                        this.fL = knVar.readString();
                        continue;
                    default:
                        if (!m6623a(knVar, mh)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public C1787j m8015q() {
            this.fJ = C1786i.m8004o();
            this.fK = null;
            this.fL = "";
            this.adU = null;
            this.adY = -1;
            return this;
        }
    }
}
