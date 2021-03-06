package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

public class jv implements Creator {
    static void m8888a(ju juVar, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, 1, juVar.getVersionCode());
        C1488b.m6359a(parcel, 2, juVar.ado);
        C1488b.m6359a(parcel, 3, juVar.adp);
        C1488b.m6355F(parcel, p);
    }

    public ju bv(Parcel parcel) {
        long j = 0;
        int o = C1487a.m6340o(parcel);
        int i = 0;
        long j2 = 0;
        while (parcel.dataPosition() < o) {
            int n = C1487a.m6338n(parcel);
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    i = C1487a.m6331g(parcel, n);
                    break;
                case Base64.NO_WRAP /*2*/:
                    j2 = C1487a.m6333i(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    j = C1487a.m6333i(parcel, n);
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new ju(i, j2, j);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public ju[] cJ(int i) {
        return new ju[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bv(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cJ(x0);
    }
}
