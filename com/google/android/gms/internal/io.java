package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.google.android.gms.internal.ih.C1987d;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;
import java.util.HashSet;
import java.util.Set;

public class io implements Creator {
    static void m8795a(C1987d c1987d, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        Set ja = c1987d.ja();
        if (ja.contains(Integer.valueOf(1))) {
            C1488b.m6378c(parcel, 1, c1987d.getVersionCode());
        }
        if (ja.contains(Integer.valueOf(2))) {
            C1488b.m6366a(parcel, 2, c1987d.getFamilyName(), true);
        }
        if (ja.contains(Integer.valueOf(3))) {
            C1488b.m6366a(parcel, 3, c1987d.getFormatted(), true);
        }
        if (ja.contains(Integer.valueOf(4))) {
            C1488b.m6366a(parcel, 4, c1987d.getGivenName(), true);
        }
        if (ja.contains(Integer.valueOf(5))) {
            C1488b.m6366a(parcel, 5, c1987d.getHonorificPrefix(), true);
        }
        if (ja.contains(Integer.valueOf(6))) {
            C1488b.m6366a(parcel, 6, c1987d.getHonorificSuffix(), true);
        }
        if (ja.contains(Integer.valueOf(7))) {
            C1488b.m6366a(parcel, 7, c1987d.getMiddleName(), true);
        }
        C1488b.m6355F(parcel, p);
    }

    public C1987d aT(Parcel parcel) {
        String str = null;
        int o = C1487a.m6340o(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        while (parcel.dataPosition() < o) {
            int n = C1487a.m6338n(parcel);
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    i = C1487a.m6331g(parcel, n);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case Base64.NO_WRAP /*2*/:
                    str6 = C1487a.m6339n(parcel, n);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    str5 = C1487a.m6339n(parcel, n);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case Base64.CRLF /*4*/:
                    str4 = C1487a.m6339n(parcel, n);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    str3 = C1487a.m6339n(parcel, n);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                    str2 = C1487a.m6339n(parcel, n);
                    hashSet.add(Integer.valueOf(6));
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                    str = C1487a.m6339n(parcel, n);
                    hashSet.add(Integer.valueOf(7));
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C1987d(hashSet, i, str6, str5, str4, str3, str2, str);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public C1987d[] bW(int i) {
        return new C1987d[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aT(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bW(x0);
    }
}
