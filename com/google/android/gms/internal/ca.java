package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

public class ca implements Creator {
    static void m8016a(cb cbVar, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, 1, cbVar.versionCode);
        C1488b.m6366a(parcel, 2, cbVar.nN, false);
        C1488b.m6366a(parcel, 3, cbVar.nO, false);
        C1488b.m6366a(parcel, 4, cbVar.mimeType, false);
        C1488b.m6366a(parcel, 5, cbVar.packageName, false);
        C1488b.m6366a(parcel, 6, cbVar.nP, false);
        C1488b.m6366a(parcel, 7, cbVar.nQ, false);
        C1488b.m6366a(parcel, 8, cbVar.nR, false);
        C1488b.m6355F(parcel, p);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m8017d(x0);
    }

    public cb m8017d(Parcel parcel) {
        String str = null;
        int o = C1487a.m6340o(parcel);
        int i = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        while (parcel.dataPosition() < o) {
            int n = C1487a.m6338n(parcel);
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    i = C1487a.m6331g(parcel, n);
                    break;
                case Base64.NO_WRAP /*2*/:
                    str7 = C1487a.m6339n(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    str6 = C1487a.m6339n(parcel, n);
                    break;
                case Base64.CRLF /*4*/:
                    str5 = C1487a.m6339n(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    str4 = C1487a.m6339n(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                    str3 = C1487a.m6339n(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                    str2 = C1487a.m6339n(parcel, n);
                    break;
                case Base64.URL_SAFE /*8*/:
                    str = C1487a.m6339n(parcel, n);
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new cb(i, str7, str6, str5, str4, str3, str2, str);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public cb[] m8018h(int i) {
        return new cb[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m8018h(x0);
    }
}
