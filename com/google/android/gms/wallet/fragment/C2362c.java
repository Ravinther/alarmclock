package com.google.android.gms.wallet.fragment;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

/* renamed from: com.google.android.gms.wallet.fragment.c */
public class C2362c implements Creator {
    static void m9692a(WalletFragmentStyle walletFragmentStyle, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, 1, walletFragmentStyle.xH);
        C1488b.m6360a(parcel, 2, walletFragmentStyle.acT, false);
        C1488b.m6378c(parcel, 3, walletFragmentStyle.acU);
        C1488b.m6355F(parcel, p);
    }

    public WalletFragmentStyle bp(Parcel parcel) {
        int i = 0;
        int o = C1487a.m6340o(parcel);
        Bundle bundle = null;
        int i2 = 0;
        while (parcel.dataPosition() < o) {
            int n = C1487a.m6338n(parcel);
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    i2 = C1487a.m6331g(parcel, n);
                    break;
                case Base64.NO_WRAP /*2*/:
                    bundle = C1487a.m6342p(parcel, n);
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
            return new WalletFragmentStyle(i2, bundle, i);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public WalletFragmentStyle[] cC(int i) {
        return new WalletFragmentStyle[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bp(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cC(x0);
    }
}
