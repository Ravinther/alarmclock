package com.google.android.gms.wallet.fragment;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

/* renamed from: com.google.android.gms.wallet.fragment.b */
public class C2361b implements Creator {
    static void m9691a(WalletFragmentOptions walletFragmentOptions, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, 1, walletFragmentOptions.xH);
        C1488b.m6378c(parcel, 2, walletFragmentOptions.getEnvironment());
        C1488b.m6378c(parcel, 3, walletFragmentOptions.getTheme());
        C1488b.m6363a(parcel, 4, walletFragmentOptions.getFragmentStyle(), i, false);
        C1488b.m6378c(parcel, 5, walletFragmentOptions.getMode());
        C1488b.m6355F(parcel, p);
    }

    public WalletFragmentOptions bo(Parcel parcel) {
        int i = 1;
        int i2 = 0;
        int o = C1487a.m6340o(parcel);
        WalletFragmentStyle walletFragmentStyle = null;
        int i3 = 1;
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
                    i2 = C1487a.m6331g(parcel, n);
                    break;
                case Base64.CRLF /*4*/:
                    walletFragmentStyle = (WalletFragmentStyle) C1487a.m6320a(parcel, n, WalletFragmentStyle.CREATOR);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    i = C1487a.m6331g(parcel, n);
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new WalletFragmentOptions(i4, i3, i2, walletFragmentStyle, i);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public WalletFragmentOptions[] cB(int i) {
        return new WalletFragmentOptions[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bo(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cB(x0);
    }
}
