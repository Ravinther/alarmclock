package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.google.android.gms.internal.fx.C1909a;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

public class fz implements Creator {
    static void m8545a(C1909a c1909a, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, 1, c1909a.versionCode);
        C1488b.m6366a(parcel, 2, c1909a.DW, false);
        C1488b.m6378c(parcel, 3, c1909a.DX);
        C1488b.m6355F(parcel, p);
    }

    public C1909a[] m8546U(int i) {
        return new C1909a[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m8547s(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m8546U(x0);
    }

    public C1909a m8547s(Parcel parcel) {
        int i = 0;
        int o = C1487a.m6340o(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < o) {
            int n = C1487a.m6338n(parcel);
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    i2 = C1487a.m6331g(parcel, n);
                    break;
                case Base64.NO_WRAP /*2*/:
                    str = C1487a.m6339n(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    i = C1487a.m6331g(parcel, n);
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C1909a(i2, str, i);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }
}
