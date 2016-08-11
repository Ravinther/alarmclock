package com.google.android.gms.internal;

import com.avg.ui.general.C1091c.C1087k;
import com.google.ads.AdSize;
import com.millennialmedia.android.C2513R;
import com.millennialmedia.android.MMException;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

/* renamed from: com.google.android.gms.internal.d */
public interface C1817d {

    /* renamed from: com.google.android.gms.internal.d.a */
    public static final class C1816a extends kp {
        private static volatile C1816a[] fM;
        public String fN;
        public C1816a[] fO;
        public C1816a[] fP;
        public C1816a[] fQ;
        public String fR;
        public String fS;
        public long fT;
        public boolean fU;
        public C1816a[] fV;
        public int[] fW;
        public boolean fX;
        public int type;

        public C1816a() {
            m8107s();
        }

        public static C1816a[] m8102r() {
            if (fM == null) {
                synchronized (kr.adX) {
                    if (fM == null) {
                        fM = new C1816a[0];
                    }
                }
            }
            return fM;
        }

        public void m8103a(ko koVar) {
            int i = 0;
            koVar.m8935i(1, this.type);
            if (!this.fN.equals("")) {
                koVar.m8930b(2, this.fN);
            }
            if (this.fO != null && this.fO.length > 0) {
                for (kt ktVar : this.fO) {
                    if (ktVar != null) {
                        koVar.m8925a(3, ktVar);
                    }
                }
            }
            if (this.fP != null && this.fP.length > 0) {
                for (kt ktVar2 : this.fP) {
                    if (ktVar2 != null) {
                        koVar.m8925a(4, ktVar2);
                    }
                }
            }
            if (this.fQ != null && this.fQ.length > 0) {
                for (kt ktVar22 : this.fQ) {
                    if (ktVar22 != null) {
                        koVar.m8925a(5, ktVar22);
                    }
                }
            }
            if (!this.fR.equals("")) {
                koVar.m8930b(6, this.fR);
            }
            if (!this.fS.equals("")) {
                koVar.m8930b(7, this.fS);
            }
            if (this.fT != 0) {
                koVar.m8929b(8, this.fT);
            }
            if (this.fX) {
                koVar.m8926a(9, this.fX);
            }
            if (this.fW != null && this.fW.length > 0) {
                for (int i2 : this.fW) {
                    koVar.m8935i(10, i2);
                }
            }
            if (this.fV != null && this.fV.length > 0) {
                while (i < this.fV.length) {
                    kt ktVar3 = this.fV[i];
                    if (ktVar3 != null) {
                        koVar.m8925a(11, ktVar3);
                    }
                    i++;
                }
            }
            if (this.fU) {
                koVar.m8926a(12, this.fU);
            }
            super.m6622a(koVar);
        }

        public /* synthetic */ kt m8104b(kn knVar) {
            return m8106l(knVar);
        }

        public int m8105c() {
            int i;
            int i2 = 0;
            int c = super.m6620c() + ko.m8921j(1, this.type);
            if (!this.fN.equals("")) {
                c += ko.m8920g(2, this.fN);
            }
            if (this.fO != null && this.fO.length > 0) {
                i = c;
                for (kt ktVar : this.fO) {
                    if (ktVar != null) {
                        i += ko.m8912b(3, ktVar);
                    }
                }
                c = i;
            }
            if (this.fP != null && this.fP.length > 0) {
                i = c;
                for (kt ktVar2 : this.fP) {
                    if (ktVar2 != null) {
                        i += ko.m8912b(4, ktVar2);
                    }
                }
                c = i;
            }
            if (this.fQ != null && this.fQ.length > 0) {
                i = c;
                for (kt ktVar22 : this.fQ) {
                    if (ktVar22 != null) {
                        i += ko.m8912b(5, ktVar22);
                    }
                }
                c = i;
            }
            if (!this.fR.equals("")) {
                c += ko.m8920g(6, this.fR);
            }
            if (!this.fS.equals("")) {
                c += ko.m8920g(7, this.fS);
            }
            if (this.fT != 0) {
                c += ko.m8917d(8, this.fT);
            }
            if (this.fX) {
                c += ko.m8913b(9, this.fX);
            }
            if (this.fW != null && this.fW.length > 0) {
                int i3 = 0;
                for (int cX : this.fW) {
                    i3 += ko.cX(cX);
                }
                c = (c + i3) + (this.fW.length * 1);
            }
            if (this.fV != null && this.fV.length > 0) {
                while (i2 < this.fV.length) {
                    kt ktVar3 = this.fV[i2];
                    if (ktVar3 != null) {
                        c += ko.m8912b(11, ktVar3);
                    }
                    i2++;
                }
            }
            if (this.fU) {
                c += ko.m8913b(12, this.fU);
            }
            this.adY = c;
            return c;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C1816a)) {
                return false;
            }
            C1816a c1816a = (C1816a) o;
            if (this.type != c1816a.type) {
                return false;
            }
            if (this.fN == null) {
                if (c1816a.fN != null) {
                    return false;
                }
            } else if (!this.fN.equals(c1816a.fN)) {
                return false;
            }
            if (!kr.equals(this.fO, c1816a.fO) || !kr.equals(this.fP, c1816a.fP) || !kr.equals(this.fQ, c1816a.fQ)) {
                return false;
            }
            if (this.fR == null) {
                if (c1816a.fR != null) {
                    return false;
                }
            } else if (!this.fR.equals(c1816a.fR)) {
                return false;
            }
            if (this.fS == null) {
                if (c1816a.fS != null) {
                    return false;
                }
            } else if (!this.fS.equals(c1816a.fS)) {
                return false;
            }
            if (this.fT != c1816a.fT || this.fU != c1816a.fU || !kr.equals(this.fV, c1816a.fV) || !kr.equals(this.fW, c1816a.fW) || this.fX != c1816a.fX) {
                return false;
            }
            if (this.adU == null || this.adU.isEmpty()) {
                return c1816a.adU == null || c1816a.adU.isEmpty();
            } else {
                return this.adU.equals(c1816a.adU);
            }
        }

        public int hashCode() {
            int i = 1231;
            int i2 = 0;
            int hashCode = ((((((this.fU ? 1231 : 1237) + (((((this.fS == null ? 0 : this.fS.hashCode()) + (((this.fR == null ? 0 : this.fR.hashCode()) + (((((((((this.fN == null ? 0 : this.fN.hashCode()) + ((this.type + 527) * 31)) * 31) + kr.hashCode(this.fO)) * 31) + kr.hashCode(this.fP)) * 31) + kr.hashCode(this.fQ)) * 31)) * 31)) * 31) + ((int) (this.fT ^ (this.fT >>> 32)))) * 31)) * 31) + kr.hashCode(this.fV)) * 31) + kr.hashCode(this.fW)) * 31;
            if (!this.fX) {
                i = 1237;
            }
            hashCode = (hashCode + i) * 31;
            if (!(this.adU == null || this.adU.isEmpty())) {
                i2 = this.adU.hashCode();
            }
            return hashCode + i2;
        }

        public C1816a m8106l(kn knVar) {
            while (true) {
                int mh = knVar.mh();
                int b;
                Object obj;
                int i;
                switch (mh) {
                    case Base64.DEFAULT /*0*/:
                        break;
                    case Base64.URL_SAFE /*8*/:
                        mh = knVar.mk();
                        switch (mh) {
                            case Base64.NO_PADDING /*1*/:
                            case Base64.NO_WRAP /*2*/:
                            case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                            case Base64.CRLF /*4*/:
                            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                            case Base64.URL_SAFE /*8*/:
                                this.type = mh;
                                break;
                            default:
                                continue;
                        }
                    case C1087k.ActionBar_itemPadding /*18*/:
                        this.fN = knVar.readString();
                        continue;
                    case MMException.AD_NO_ACTIVITY /*26*/:
                        b = kw.m8947b(knVar, 26);
                        mh = this.fO == null ? 0 : this.fO.length;
                        obj = new C1816a[(b + mh)];
                        if (mh != 0) {
                            System.arraycopy(this.fO, 0, obj, 0, mh);
                        }
                        while (mh < obj.length - 1) {
                            obj[mh] = new C1816a();
                            knVar.m8904a(obj[mh]);
                            knVar.mh();
                            mh++;
                        }
                        obj[mh] = new C1816a();
                        knVar.m8904a(obj[mh]);
                        this.fO = obj;
                        continue;
                    case 34:
                        b = kw.m8947b(knVar, 34);
                        mh = this.fP == null ? 0 : this.fP.length;
                        obj = new C1816a[(b + mh)];
                        if (mh != 0) {
                            System.arraycopy(this.fP, 0, obj, 0, mh);
                        }
                        while (mh < obj.length - 1) {
                            obj[mh] = new C1816a();
                            knVar.m8904a(obj[mh]);
                            knVar.mh();
                            mh++;
                        }
                        obj[mh] = new C1816a();
                        knVar.m8904a(obj[mh]);
                        this.fP = obj;
                        continue;
                    case 42:
                        b = kw.m8947b(knVar, 42);
                        mh = this.fQ == null ? 0 : this.fQ.length;
                        obj = new C1816a[(b + mh)];
                        if (mh != 0) {
                            System.arraycopy(this.fQ, 0, obj, 0, mh);
                        }
                        while (mh < obj.length - 1) {
                            obj[mh] = new C1816a();
                            knVar.m8904a(obj[mh]);
                            knVar.mh();
                            mh++;
                        }
                        obj[mh] = new C1816a();
                        knVar.m8904a(obj[mh]);
                        this.fQ = obj;
                        continue;
                    case AdSize.PORTRAIT_AD_HEIGHT /*50*/:
                        this.fR = knVar.readString();
                        continue;
                    case 58:
                        this.fS = knVar.readString();
                        continue;
                    case 64:
                        this.fT = knVar.mj();
                        continue;
                    case 72:
                        this.fX = knVar.ml();
                        continue;
                    case 80:
                        int b2 = kw.m8947b(knVar, 80);
                        Object obj2 = new int[b2];
                        i = 0;
                        b = 0;
                        while (i < b2) {
                            if (i != 0) {
                                knVar.mh();
                            }
                            int mk = knVar.mk();
                            switch (mk) {
                                case Base64.NO_PADDING /*1*/:
                                case Base64.NO_WRAP /*2*/:
                                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                                case Base64.CRLF /*4*/:
                                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                                case Base64.URL_SAFE /*8*/:
                                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor /*9*/:
                                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                                case C2625R.styleable.MapAttrs_uiZoomGestures /*11*/:
                                case C2625R.styleable.MapAttrs_useViewLifecycle /*12*/:
                                case C2625R.styleable.MapAttrs_zOrderOnTop /*13*/:
                                case C2513R.styleable.MMAdView_height /*14*/:
                                case C2513R.styleable.MMAdView_width /*15*/:
                                case Base64.NO_CLOSE /*16*/:
                                case MMException.CACHE_NOT_EMPTY /*17*/:
                                    mh = b + 1;
                                    obj2[b] = mk;
                                    break;
                                default:
                                    mh = b;
                                    break;
                            }
                            i++;
                            b = mh;
                        }
                        if (b != 0) {
                            mh = this.fW == null ? 0 : this.fW.length;
                            if (mh != 0 || b != obj2.length) {
                                Object obj3 = new int[(mh + b)];
                                if (mh != 0) {
                                    System.arraycopy(this.fW, 0, obj3, 0, mh);
                                }
                                System.arraycopy(obj2, 0, obj3, mh, b);
                                this.fW = obj3;
                                break;
                            }
                            this.fW = obj2;
                            break;
                        }
                        continue;
                    case 82:
                        i = knVar.cR(knVar.mn());
                        b = knVar.getPosition();
                        mh = 0;
                        while (knVar.ms() > 0) {
                            switch (knVar.mk()) {
                                case Base64.NO_PADDING /*1*/:
                                case Base64.NO_WRAP /*2*/:
                                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                                case Base64.CRLF /*4*/:
                                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                                case Base64.URL_SAFE /*8*/:
                                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor /*9*/:
                                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                                case C2625R.styleable.MapAttrs_uiZoomGestures /*11*/:
                                case C2625R.styleable.MapAttrs_useViewLifecycle /*12*/:
                                case C2625R.styleable.MapAttrs_zOrderOnTop /*13*/:
                                case C2513R.styleable.MMAdView_height /*14*/:
                                case C2513R.styleable.MMAdView_width /*15*/:
                                case Base64.NO_CLOSE /*16*/:
                                case MMException.CACHE_NOT_EMPTY /*17*/:
                                    mh++;
                                    break;
                                default:
                                    break;
                            }
                        }
                        if (mh != 0) {
                            knVar.cT(b);
                            b = this.fW == null ? 0 : this.fW.length;
                            Object obj4 = new int[(mh + b)];
                            if (b != 0) {
                                System.arraycopy(this.fW, 0, obj4, 0, b);
                            }
                            while (knVar.ms() > 0) {
                                int mk2 = knVar.mk();
                                switch (mk2) {
                                    case Base64.NO_PADDING /*1*/:
                                    case Base64.NO_WRAP /*2*/:
                                    case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                                    case Base64.CRLF /*4*/:
                                    case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                                    case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                                    case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                                    case Base64.URL_SAFE /*8*/:
                                    case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor /*9*/:
                                    case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                                    case C2625R.styleable.MapAttrs_uiZoomGestures /*11*/:
                                    case C2625R.styleable.MapAttrs_useViewLifecycle /*12*/:
                                    case C2625R.styleable.MapAttrs_zOrderOnTop /*13*/:
                                    case C2513R.styleable.MMAdView_height /*14*/:
                                    case C2513R.styleable.MMAdView_width /*15*/:
                                    case Base64.NO_CLOSE /*16*/:
                                    case MMException.CACHE_NOT_EMPTY /*17*/:
                                        mh = b + 1;
                                        obj4[b] = mk2;
                                        b = mh;
                                        break;
                                    default:
                                        break;
                                }
                            }
                            this.fW = obj4;
                        }
                        knVar.cS(i);
                        continue;
                    case AdSize.LARGE_AD_HEIGHT /*90*/:
                        b = kw.m8947b(knVar, 90);
                        mh = this.fV == null ? 0 : this.fV.length;
                        obj = new C1816a[(b + mh)];
                        if (mh != 0) {
                            System.arraycopy(this.fV, 0, obj, 0, mh);
                        }
                        while (mh < obj.length - 1) {
                            obj[mh] = new C1816a();
                            knVar.m8904a(obj[mh]);
                            knVar.mh();
                            mh++;
                        }
                        obj[mh] = new C1816a();
                        knVar.m8904a(obj[mh]);
                        this.fV = obj;
                        continue;
                    case 96:
                        this.fU = knVar.ml();
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

        public C1816a m8107s() {
            this.type = 1;
            this.fN = "";
            this.fO = C1816a.m8102r();
            this.fP = C1816a.m8102r();
            this.fQ = C1816a.m8102r();
            this.fR = "";
            this.fS = "";
            this.fT = 0;
            this.fU = false;
            this.fV = C1816a.m8102r();
            this.fW = kw.aea;
            this.fX = false;
            this.adU = null;
            this.adY = -1;
            return this;
        }
    }
}
