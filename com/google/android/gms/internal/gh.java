package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

public class gh implements Creator {
    static void m8592a(gg ggVar, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, 1, ggVar.getVersionCode());
        C1488b.m6362a(parcel, 2, ggVar.fq(), false);
        C1488b.m6363a(parcel, 3, ggVar.fr(), i, false);
        C1488b.m6355F(parcel, p);
    }

    public gg[] m8593Z(int i) {
        return new gg[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m8594x(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m8593Z(x0);
    }

    public gg m8594x(Parcel parcel) {
        gd gdVar = null;
        int o = C1487a.m6340o(parcel);
        int i = 0;
        Parcel parcel2 = null;
        while (parcel.dataPosition() < o) {
            int n = C1487a.m6338n(parcel);
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    i = C1487a.m6331g(parcel, n);
                    break;
                case Base64.NO_WRAP /*2*/:
                    parcel2 = C1487a.m6316B(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    gdVar = (gd) C1487a.m6320a(parcel, n, gd.CREATOR);
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new gg(i, parcel2, gdVar);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }
}
