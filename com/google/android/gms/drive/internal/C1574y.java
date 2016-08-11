package com.google.android.gms.drive.internal;

import com.avg.ui.general.C1091c.C1087k;
import com.google.ads.AdSize;
import com.google.android.gms.internal.kn;
import com.google.android.gms.internal.ko;
import com.google.android.gms.internal.kp;
import com.google.android.gms.internal.kt;
import com.millennialmedia.android.MMException;
import com.mopub.mobileads.util.Base64;

/* renamed from: com.google.android.gms.drive.internal.y */
public final class C1574y extends kp {
    public String FC;
    public long FD;
    public long FE;
    public int versionCode;

    public C1574y() {
        fH();
    }

    public static C1574y m6624g(byte[] bArr) {
        return (C1574y) kt.m6614a(new C1574y(), bArr);
    }

    public void m6625a(ko koVar) {
        koVar.m8935i(1, this.versionCode);
        koVar.m8930b(2, this.FC);
        koVar.m8932c(3, this.FD);
        koVar.m8932c(4, this.FE);
        super.m6622a(koVar);
    }

    public /* synthetic */ kt m6626b(kn knVar) {
        return m6628m(knVar);
    }

    public int m6627c() {
        int c = (((super.m6620c() + ko.m8921j(1, this.versionCode)) + ko.m8920g(2, this.FC)) + ko.m8919e(3, this.FD)) + ko.m8919e(4, this.FE);
        this.adY = c;
        return c;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof C1574y)) {
            return false;
        }
        C1574y c1574y = (C1574y) o;
        if (this.versionCode != c1574y.versionCode) {
            return false;
        }
        if (this.FC == null) {
            if (c1574y.FC != null) {
                return false;
            }
        } else if (!this.FC.equals(c1574y.FC)) {
            return false;
        }
        if (this.FD != c1574y.FD || this.FE != c1574y.FE) {
            return false;
        }
        if (this.adU == null || this.adU.isEmpty()) {
            return c1574y.adU == null || c1574y.adU.isEmpty();
        } else {
            return this.adU.equals(c1574y.adU);
        }
    }

    public C1574y fH() {
        this.versionCode = 1;
        this.FC = "";
        this.FD = -1;
        this.FE = -1;
        this.adU = null;
        this.adY = -1;
        return this;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((((this.FC == null ? 0 : this.FC.hashCode()) + ((this.versionCode + 527) * 31)) * 31) + ((int) (this.FD ^ (this.FD >>> 32)))) * 31) + ((int) (this.FE ^ (this.FE >>> 32)))) * 31;
        if (!(this.adU == null || this.adU.isEmpty())) {
            i = this.adU.hashCode();
        }
        return hashCode + i;
    }

    public C1574y m6628m(kn knVar) {
        while (true) {
            int mh = knVar.mh();
            switch (mh) {
                case Base64.DEFAULT /*0*/:
                    break;
                case Base64.URL_SAFE /*8*/:
                    this.versionCode = knVar.mk();
                    continue;
                case C1087k.ActionBar_itemPadding /*18*/:
                    this.FC = knVar.readString();
                    continue;
                case MMException.DISPLAY_AD_NOT_PERMITTED /*24*/:
                    this.FD = knVar.mm();
                    continue;
                case AdSize.LANDSCAPE_AD_HEIGHT /*32*/:
                    this.FE = knVar.mm();
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
}
