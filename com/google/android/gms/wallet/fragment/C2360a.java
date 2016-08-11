package com.google.android.gms.wallet.fragment;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

/* renamed from: com.google.android.gms.wallet.fragment.a */
public class C2360a implements Creator {
    static void m9690a(WalletFragmentInitParams walletFragmentInitParams, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, 1, walletFragmentInitParams.xH);
        C1488b.m6366a(parcel, 2, walletFragmentInitParams.getAccountName(), false);
        C1488b.m6363a(parcel, 3, walletFragmentInitParams.getMaskedWalletRequest(), i, false);
        C1488b.m6378c(parcel, 4, walletFragmentInitParams.getMaskedWalletRequestCode());
        C1488b.m6363a(parcel, 5, walletFragmentInitParams.getMaskedWallet(), i, false);
        C1488b.m6355F(parcel, p);
    }

    public WalletFragmentInitParams bn(Parcel parcel) {
        MaskedWallet maskedWallet = null;
        int o = C1487a.m6340o(parcel);
        int i = 0;
        int i2 = -1;
        MaskedWalletRequest maskedWalletRequest = null;
        String str = null;
        while (parcel.dataPosition() < o) {
            int n = C1487a.m6338n(parcel);
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    i = C1487a.m6331g(parcel, n);
                    break;
                case Base64.NO_WRAP /*2*/:
                    str = C1487a.m6339n(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    maskedWalletRequest = (MaskedWalletRequest) C1487a.m6320a(parcel, n, MaskedWalletRequest.CREATOR);
                    break;
                case Base64.CRLF /*4*/:
                    i2 = C1487a.m6331g(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    maskedWallet = (MaskedWallet) C1487a.m6320a(parcel, n, MaskedWallet.CREATOR);
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new WalletFragmentInitParams(i, str, maskedWalletRequest, i2, maskedWallet);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public WalletFragmentInitParams[] cA(int i) {
        return new WalletFragmentInitParams[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bn(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cA(x0);
    }
}
