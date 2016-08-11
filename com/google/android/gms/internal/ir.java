package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.google.android.gms.internal.ih.C1991h;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;
import java.util.HashSet;
import java.util.Set;

public class ir implements Creator {
    static void m8798a(C1991h c1991h, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        Set ja = c1991h.ja();
        if (ja.contains(Integer.valueOf(1))) {
            C1488b.m6378c(parcel, 1, c1991h.getVersionCode());
        }
        if (ja.contains(Integer.valueOf(3))) {
            C1488b.m6378c(parcel, 3, c1991h.jN());
        }
        if (ja.contains(Integer.valueOf(4))) {
            C1488b.m6366a(parcel, 4, c1991h.getValue(), true);
        }
        if (ja.contains(Integer.valueOf(5))) {
            C1488b.m6366a(parcel, 5, c1991h.getLabel(), true);
        }
        if (ja.contains(Integer.valueOf(6))) {
            C1488b.m6378c(parcel, 6, c1991h.getType());
        }
        C1488b.m6355F(parcel, p);
    }

    public C1991h aW(Parcel parcel) {
        String str = null;
        int i = 0;
        int o = C1487a.m6340o(parcel);
        Set hashSet = new HashSet();
        int i2 = 0;
        String str2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < o) {
            int n = C1487a.m6338n(parcel);
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    i3 = C1487a.m6331g(parcel, n);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    i = C1487a.m6331g(parcel, n);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case Base64.CRLF /*4*/:
                    str = C1487a.m6339n(parcel, n);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    str2 = C1487a.m6339n(parcel, n);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                    i2 = C1487a.m6331g(parcel, n);
                    hashSet.add(Integer.valueOf(6));
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C1991h(hashSet, i3, str2, i2, str, i);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public C1991h[] bZ(int i) {
        return new C1991h[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aW(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bZ(x0);
    }
}
