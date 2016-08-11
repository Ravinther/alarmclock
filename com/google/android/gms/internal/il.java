package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.google.android.gms.internal.ih.C1985b.C1983a;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;
import java.util.HashSet;
import java.util.Set;

public class il implements Creator {
    static void m8792a(C1983a c1983a, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        Set ja = c1983a.ja();
        if (ja.contains(Integer.valueOf(1))) {
            C1488b.m6378c(parcel, 1, c1983a.getVersionCode());
        }
        if (ja.contains(Integer.valueOf(2))) {
            C1488b.m6378c(parcel, 2, c1983a.getLeftImageOffset());
        }
        if (ja.contains(Integer.valueOf(3))) {
            C1488b.m6378c(parcel, 3, c1983a.getTopImageOffset());
        }
        C1488b.m6355F(parcel, p);
    }

    public C1983a aQ(Parcel parcel) {
        int i = 0;
        int o = C1487a.m6340o(parcel);
        Set hashSet = new HashSet();
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < o) {
            int n = C1487a.m6338n(parcel);
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    i3 = C1487a.m6331g(parcel, n);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case Base64.NO_WRAP /*2*/:
                    i2 = C1487a.m6331g(parcel, n);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    i = C1487a.m6331g(parcel, n);
                    hashSet.add(Integer.valueOf(3));
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C1983a(hashSet, i3, i2, i);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public C1983a[] bT(int i) {
        return new C1983a[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aQ(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bT(x0);
    }
}
