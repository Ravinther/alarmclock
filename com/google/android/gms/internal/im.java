package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.google.android.gms.internal.ih.C1985b.C1984b;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;
import java.util.HashSet;
import java.util.Set;

public class im implements Creator {
    static void m8793a(C1984b c1984b, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        Set ja = c1984b.ja();
        if (ja.contains(Integer.valueOf(1))) {
            C1488b.m6378c(parcel, 1, c1984b.getVersionCode());
        }
        if (ja.contains(Integer.valueOf(2))) {
            C1488b.m6378c(parcel, 2, c1984b.getHeight());
        }
        if (ja.contains(Integer.valueOf(3))) {
            C1488b.m6366a(parcel, 3, c1984b.getUrl(), true);
        }
        if (ja.contains(Integer.valueOf(4))) {
            C1488b.m6378c(parcel, 4, c1984b.getWidth());
        }
        C1488b.m6355F(parcel, p);
    }

    public C1984b aR(Parcel parcel) {
        int i = 0;
        int o = C1487a.m6340o(parcel);
        Set hashSet = new HashSet();
        String str = null;
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
                    str = C1487a.m6339n(parcel, n);
                    hashSet.add(Integer.valueOf(3));
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
            return new C1984b(hashSet, i3, i2, str, i);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public C1984b[] bU(int i) {
        return new C1984b[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aR(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bU(x0);
    }
}
