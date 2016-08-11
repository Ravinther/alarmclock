package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

public class jz implements Creator {
    static void m8890a(jy jyVar, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, 1, jyVar.getVersionCode());
        C1488b.m6366a(parcel, 2, jyVar.adn, false);
        C1488b.m6366a(parcel, 3, jyVar.pm, false);
        C1488b.m6363a(parcel, 4, jyVar.adr, i, false);
        C1488b.m6363a(parcel, 5, jyVar.ads, i, false);
        C1488b.m6363a(parcel, 6, jyVar.adt, i, false);
        C1488b.m6355F(parcel, p);
    }

    public jy bx(Parcel parcel) {
        jw jwVar = null;
        int o = C1487a.m6340o(parcel);
        int i = 0;
        jw jwVar2 = null;
        ju juVar = null;
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < o) {
            int n = C1487a.m6338n(parcel);
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    i = C1487a.m6331g(parcel, n);
                    break;
                case Base64.NO_WRAP /*2*/:
                    str2 = C1487a.m6339n(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    str = C1487a.m6339n(parcel, n);
                    break;
                case Base64.CRLF /*4*/:
                    juVar = (ju) C1487a.m6320a(parcel, n, ju.CREATOR);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    jwVar2 = (jw) C1487a.m6320a(parcel, n, jw.CREATOR);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                    jwVar = (jw) C1487a.m6320a(parcel, n, jw.CREATOR);
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new jy(i, str2, str, juVar, jwVar2, jwVar);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public jy[] cL(int i) {
        return new jy[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bx(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cL(x0);
    }
}
