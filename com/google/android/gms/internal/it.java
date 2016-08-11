package com.google.android.gms.internal;

import com.avg.ui.general.C1091c.C1087k;
import com.google.android.gms.internal.C1788c.C1783f;
import com.google.android.gms.internal.C1788c.C1787j;
import com.millennialmedia.android.MMException;
import com.mopub.mobileads.util.Base64;

public interface it {

    /* renamed from: com.google.android.gms.internal.it.a */
    public static final class C1992a extends kp {
        public long aaY;
        public C1787j aaZ;
        public C1783f fK;

        public C1992a() {
            lV();
        }

        public static C1992a m8799l(byte[] bArr) {
            return (C1992a) kt.m6614a(new C1992a(), bArr);
        }

        public void m8800a(ko koVar) {
            koVar.m8929b(1, this.aaY);
            if (this.fK != null) {
                koVar.m8925a(2, this.fK);
            }
            if (this.aaZ != null) {
                koVar.m8925a(3, this.aaZ);
            }
            super.m6622a(koVar);
        }

        public /* synthetic */ kt m8801b(kn knVar) {
            return m8803n(knVar);
        }

        public int m8802c() {
            int c = super.m6620c() + ko.m8917d(1, this.aaY);
            if (this.fK != null) {
                c += ko.m8912b(2, this.fK);
            }
            if (this.aaZ != null) {
                c += ko.m8912b(3, this.aaZ);
            }
            this.adY = c;
            return c;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C1992a)) {
                return false;
            }
            C1992a c1992a = (C1992a) o;
            if (this.aaY != c1992a.aaY) {
                return false;
            }
            if (this.fK == null) {
                if (c1992a.fK != null) {
                    return false;
                }
            } else if (!this.fK.equals(c1992a.fK)) {
                return false;
            }
            if (this.aaZ == null) {
                if (c1992a.aaZ != null) {
                    return false;
                }
            } else if (!this.aaZ.equals(c1992a.aaZ)) {
                return false;
            }
            if (this.adU == null || this.adU.isEmpty()) {
                return c1992a.adU == null || c1992a.adU.isEmpty();
            } else {
                return this.adU.equals(c1992a.adU);
            }
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.aaZ == null ? 0 : this.aaZ.hashCode()) + (((this.fK == null ? 0 : this.fK.hashCode()) + ((((int) (this.aaY ^ (this.aaY >>> 32))) + 527) * 31)) * 31)) * 31;
            if (!(this.adU == null || this.adU.isEmpty())) {
                i = this.adU.hashCode();
            }
            return hashCode + i;
        }

        public C1992a lV() {
            this.aaY = 0;
            this.fK = null;
            this.aaZ = null;
            this.adU = null;
            this.adY = -1;
            return this;
        }

        public C1992a m8803n(kn knVar) {
            while (true) {
                int mh = knVar.mh();
                switch (mh) {
                    case Base64.DEFAULT /*0*/:
                        break;
                    case Base64.URL_SAFE /*8*/:
                        this.aaY = knVar.mj();
                        continue;
                    case C1087k.ActionBar_itemPadding /*18*/:
                        if (this.fK == null) {
                            this.fK = new C1783f();
                        }
                        knVar.m8904a(this.fK);
                        continue;
                    case MMException.AD_NO_ACTIVITY /*26*/:
                        if (this.aaZ == null) {
                            this.aaZ = new C1787j();
                        }
                        knVar.m8904a(this.aaZ);
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
}
