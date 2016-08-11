package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.google.android.gms.internal.ga.C1912a;
import com.google.android.gms.internal.gd.C1914b;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

public class gc implements Creator {
    static void m8567a(C1914b c1914b, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, 1, c1914b.versionCode);
        C1488b.m6366a(parcel, 2, c1914b.eM, false);
        C1488b.m6363a(parcel, 3, c1914b.Em, i, false);
        C1488b.m6355F(parcel, p);
    }

    public C1914b[] m8568W(int i) {
        return new C1914b[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m8569u(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m8568W(x0);
    }

    public C1914b m8569u(Parcel parcel) {
        C1912a c1912a = null;
        int o = C1487a.m6340o(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < o) {
            int n = C1487a.m6338n(parcel);
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    i = C1487a.m6331g(parcel, n);
                    break;
                case Base64.NO_WRAP /*2*/:
                    str = C1487a.m6339n(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    c1912a = (C1912a) C1487a.m6320a(parcel, n, C1912a.CREATOR);
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C1914b(i, str, c1912a);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }
}
