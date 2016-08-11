package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

public class jr implements Creator {
    static void m8886a(jo joVar, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, 1, joVar.getVersionCode());
        C1488b.m6366a(parcel, 2, joVar.label, false);
        C1488b.m6363a(parcel, 3, joVar.adg, i, false);
        C1488b.m6366a(parcel, 4, joVar.type, false);
        C1488b.m6363a(parcel, 5, joVar.abJ, i, false);
        C1488b.m6355F(parcel, p);
    }

    public jo bt(Parcel parcel) {
        ju juVar = null;
        int o = C1487a.m6340o(parcel);
        int i = 0;
        String str = null;
        jp jpVar = null;
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
                    jpVar = (jp) C1487a.m6320a(parcel, n, jp.CREATOR);
                    break;
                case Base64.CRLF /*4*/:
                    str = C1487a.m6339n(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    juVar = (ju) C1487a.m6320a(parcel, n, ju.CREATOR);
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new jo(i, str2, jpVar, str, juVar);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public jo[] cH(int i) {
        return new jo[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bt(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cH(x0);
    }
}
