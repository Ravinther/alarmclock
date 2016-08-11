package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.google.android.gms.internal.ih.C1985b;
import com.google.android.gms.internal.ih.C1985b.C1983a;
import com.google.android.gms.internal.ih.C1985b.C1984b;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;
import java.util.HashSet;
import java.util.Set;

public class ik implements Creator {
    static void m8791a(C1985b c1985b, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        Set ja = c1985b.ja();
        if (ja.contains(Integer.valueOf(1))) {
            C1488b.m6378c(parcel, 1, c1985b.getVersionCode());
        }
        if (ja.contains(Integer.valueOf(2))) {
            C1488b.m6363a(parcel, 2, c1985b.jE(), i, true);
        }
        if (ja.contains(Integer.valueOf(3))) {
            C1488b.m6363a(parcel, 3, c1985b.jF(), i, true);
        }
        if (ja.contains(Integer.valueOf(4))) {
            C1488b.m6378c(parcel, 4, c1985b.getLayout());
        }
        C1488b.m6355F(parcel, p);
    }

    public C1985b aP(Parcel parcel) {
        C1984b c1984b = null;
        int i = 0;
        int o = C1487a.m6340o(parcel);
        Set hashSet = new HashSet();
        C1983a c1983a = null;
        int i2 = 0;
        while (parcel.dataPosition() < o) {
            int n = C1487a.m6338n(parcel);
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    i2 = C1487a.m6331g(parcel, n);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case Base64.NO_WRAP /*2*/:
                    C1983a c1983a2 = (C1983a) C1487a.m6320a(parcel, n, C1983a.CREATOR);
                    hashSet.add(Integer.valueOf(2));
                    c1983a = c1983a2;
                    break;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    C1984b c1984b2 = (C1984b) C1487a.m6320a(parcel, n, C1984b.CREATOR);
                    hashSet.add(Integer.valueOf(3));
                    c1984b = c1984b2;
                    break;
                case Base64.CRLF /*4*/:
                    i = C1487a.m6331g(parcel, n);
                    hashSet.add(Integer.valueOf(4));
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C1985b(hashSet, i2, c1983a, c1984b, i);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public C1985b[] bS(int i) {
        return new C1985b[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aP(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bS(x0);
    }
}
