package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

public class dy implements Creator {
    static void m8222a(dx dxVar, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, 1, dxVar.versionCode);
        C1488b.m6366a(parcel, 2, dxVar.rq, false);
        C1488b.m6378c(parcel, 3, dxVar.rr);
        C1488b.m6378c(parcel, 4, dxVar.rs);
        C1488b.m6369a(parcel, 5, dxVar.rt);
        C1488b.m6355F(parcel, p);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m8223h(x0);
    }

    public dx m8223h(Parcel parcel) {
        boolean z = false;
        int o = C1487a.m6340o(parcel);
        String str = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < o) {
            int n = C1487a.m6338n(parcel);
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    i3 = C1487a.m6331g(parcel, n);
                    break;
                case Base64.NO_WRAP /*2*/:
                    str = C1487a.m6339n(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    i2 = C1487a.m6331g(parcel, n);
                    break;
                case Base64.CRLF /*4*/:
                    i = C1487a.m6331g(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    z = C1487a.m6327c(parcel, n);
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new dx(i3, str, i2, i, z);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m8224o(x0);
    }

    public dx[] m8224o(int i) {
        return new dx[i];
    }
}
