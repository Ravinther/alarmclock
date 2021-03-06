package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.google.android.gms.internal.ih.C1986c;
import com.mopub.mobileads.util.Base64;
import java.util.HashSet;
import java.util.Set;

public class in implements Creator {
    static void m8794a(C1986c c1986c, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        Set ja = c1986c.ja();
        if (ja.contains(Integer.valueOf(1))) {
            C1488b.m6378c(parcel, 1, c1986c.getVersionCode());
        }
        if (ja.contains(Integer.valueOf(2))) {
            C1488b.m6366a(parcel, 2, c1986c.getUrl(), true);
        }
        C1488b.m6355F(parcel, p);
    }

    public C1986c aS(Parcel parcel) {
        int o = C1487a.m6340o(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < o) {
            int n = C1487a.m6338n(parcel);
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    i = C1487a.m6331g(parcel, n);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case Base64.NO_WRAP /*2*/:
                    str = C1487a.m6339n(parcel, n);
                    hashSet.add(Integer.valueOf(2));
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C1986c(hashSet, i, str);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public C1986c[] bV(int i) {
        return new C1986c[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aS(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bV(x0);
    }
}
