package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

public class al implements Creator {
    static void m7831a(ak akVar, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, 1, akVar.versionCode);
        C1488b.m6366a(parcel, 2, akVar.lS, false);
        C1488b.m6378c(parcel, 3, akVar.height);
        C1488b.m6378c(parcel, 4, akVar.heightPixels);
        C1488b.m6369a(parcel, 5, akVar.lT);
        C1488b.m6378c(parcel, 6, akVar.width);
        C1488b.m6378c(parcel, 7, akVar.widthPixels);
        C1488b.m6372a(parcel, 8, akVar.lU, i, false);
        C1488b.m6355F(parcel, p);
    }

    public ak m7832b(Parcel parcel) {
        ak[] akVarArr = null;
        int i = 0;
        int o = C1487a.m6340o(parcel);
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        int i4 = 0;
        String str = null;
        int i5 = 0;
        while (parcel.dataPosition() < o) {
            int n = C1487a.m6338n(parcel);
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    i5 = C1487a.m6331g(parcel, n);
                    break;
                case Base64.NO_WRAP /*2*/:
                    str = C1487a.m6339n(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    i4 = C1487a.m6331g(parcel, n);
                    break;
                case Base64.CRLF /*4*/:
                    i3 = C1487a.m6331g(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    z = C1487a.m6327c(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                    i2 = C1487a.m6331g(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                    i = C1487a.m6331g(parcel, n);
                    break;
                case Base64.URL_SAFE /*8*/:
                    akVarArr = (ak[]) C1487a.m6325b(parcel, n, ak.CREATOR);
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new ak(i5, str, i4, i3, z, i2, i, akVarArr);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public ak[] m7833c(int i) {
        return new ak[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m7832b(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m7833c(x0);
    }
}
