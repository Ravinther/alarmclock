package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.google.android.gms.internal.ga.C1912a;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

public class gb implements Creator {
    static void m8564a(C1912a c1912a, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, 1, c1912a.getVersionCode());
        C1488b.m6378c(parcel, 2, c1912a.eW());
        C1488b.m6369a(parcel, 3, c1912a.fc());
        C1488b.m6378c(parcel, 4, c1912a.eX());
        C1488b.m6369a(parcel, 5, c1912a.fd());
        C1488b.m6366a(parcel, 6, c1912a.fe(), false);
        C1488b.m6378c(parcel, 7, c1912a.ff());
        C1488b.m6366a(parcel, 8, c1912a.fh(), false);
        C1488b.m6363a(parcel, 9, c1912a.fj(), i, false);
        C1488b.m6355F(parcel, p);
    }

    public C1912a[] m8565V(int i) {
        return new C1912a[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m8566t(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m8565V(x0);
    }

    public C1912a m8566t(Parcel parcel) {
        fv fvVar = null;
        int i = 0;
        int o = C1487a.m6340o(parcel);
        String str = null;
        String str2 = null;
        boolean z = false;
        int i2 = 0;
        boolean z2 = false;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < o) {
            int n = C1487a.m6338n(parcel);
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    i4 = C1487a.m6331g(parcel, n);
                    break;
                case Base64.NO_WRAP /*2*/:
                    i3 = C1487a.m6331g(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    z2 = C1487a.m6327c(parcel, n);
                    break;
                case Base64.CRLF /*4*/:
                    i2 = C1487a.m6331g(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    z = C1487a.m6327c(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                    str2 = C1487a.m6339n(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                    i = C1487a.m6331g(parcel, n);
                    break;
                case Base64.URL_SAFE /*8*/:
                    str = C1487a.m6339n(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor /*9*/:
                    fvVar = (fv) C1487a.m6320a(parcel, n, fv.CREATOR);
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C1912a(i4, i3, z2, i2, z, str2, i, str, fvVar);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }
}
