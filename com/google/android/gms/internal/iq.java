package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.google.android.gms.internal.ih.C1990g;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;
import java.util.HashSet;
import java.util.Set;

public class iq implements Creator {
    static void m8797a(C1990g c1990g, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        Set ja = c1990g.ja();
        if (ja.contains(Integer.valueOf(1))) {
            C1488b.m6378c(parcel, 1, c1990g.getVersionCode());
        }
        if (ja.contains(Integer.valueOf(2))) {
            C1488b.m6369a(parcel, 2, c1990g.isPrimary());
        }
        if (ja.contains(Integer.valueOf(3))) {
            C1488b.m6366a(parcel, 3, c1990g.getValue(), true);
        }
        C1488b.m6355F(parcel, p);
    }

    public C1990g aV(Parcel parcel) {
        boolean z = false;
        int o = C1487a.m6340o(parcel);
        Set hashSet = new HashSet();
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < o) {
            int n = C1487a.m6338n(parcel);
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    i = C1487a.m6331g(parcel, n);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case Base64.NO_WRAP /*2*/:
                    z = C1487a.m6327c(parcel, n);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    str = C1487a.m6339n(parcel, n);
                    hashSet.add(Integer.valueOf(3));
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C1990g(hashSet, i, z, str);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public C1990g[] bY(int i) {
        return new C1990g[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aV(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bY(x0);
    }
}
