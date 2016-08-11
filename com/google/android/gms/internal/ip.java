package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.google.android.gms.internal.ih.C1989f;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;
import java.util.HashSet;
import java.util.Set;

public class ip implements Creator {
    static void m8796a(C1989f c1989f, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        Set ja = c1989f.ja();
        if (ja.contains(Integer.valueOf(1))) {
            C1488b.m6378c(parcel, 1, c1989f.getVersionCode());
        }
        if (ja.contains(Integer.valueOf(2))) {
            C1488b.m6366a(parcel, 2, c1989f.getDepartment(), true);
        }
        if (ja.contains(Integer.valueOf(3))) {
            C1488b.m6366a(parcel, 3, c1989f.getDescription(), true);
        }
        if (ja.contains(Integer.valueOf(4))) {
            C1488b.m6366a(parcel, 4, c1989f.getEndDate(), true);
        }
        if (ja.contains(Integer.valueOf(5))) {
            C1488b.m6366a(parcel, 5, c1989f.getLocation(), true);
        }
        if (ja.contains(Integer.valueOf(6))) {
            C1488b.m6366a(parcel, 6, c1989f.getName(), true);
        }
        if (ja.contains(Integer.valueOf(7))) {
            C1488b.m6369a(parcel, 7, c1989f.isPrimary());
        }
        if (ja.contains(Integer.valueOf(8))) {
            C1488b.m6366a(parcel, 8, c1989f.getStartDate(), true);
        }
        if (ja.contains(Integer.valueOf(9))) {
            C1488b.m6366a(parcel, 9, c1989f.getTitle(), true);
        }
        if (ja.contains(Integer.valueOf(10))) {
            C1488b.m6378c(parcel, 10, c1989f.getType());
        }
        C1488b.m6355F(parcel, p);
    }

    public C1989f aU(Parcel parcel) {
        int i = 0;
        String str = null;
        int o = C1487a.m6340o(parcel);
        Set hashSet = new HashSet();
        String str2 = null;
        boolean z = false;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        int i2 = 0;
        while (parcel.dataPosition() < o) {
            int n = C1487a.m6338n(parcel);
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    i2 = C1487a.m6331g(parcel, n);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case Base64.NO_WRAP /*2*/:
                    str7 = C1487a.m6339n(parcel, n);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    str6 = C1487a.m6339n(parcel, n);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case Base64.CRLF /*4*/:
                    str5 = C1487a.m6339n(parcel, n);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    str4 = C1487a.m6339n(parcel, n);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                    str3 = C1487a.m6339n(parcel, n);
                    hashSet.add(Integer.valueOf(6));
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                    z = C1487a.m6327c(parcel, n);
                    hashSet.add(Integer.valueOf(7));
                    break;
                case Base64.URL_SAFE /*8*/:
                    str2 = C1487a.m6339n(parcel, n);
                    hashSet.add(Integer.valueOf(8));
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor /*9*/:
                    str = C1487a.m6339n(parcel, n);
                    hashSet.add(Integer.valueOf(9));
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                    i = C1487a.m6331g(parcel, n);
                    hashSet.add(Integer.valueOf(10));
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C1989f(hashSet, i2, str7, str6, str5, str4, str3, z, str2, str, i);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public C1989f[] bX(int i) {
        return new C1989f[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aU(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bX(x0);
    }
}
