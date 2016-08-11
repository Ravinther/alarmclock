package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.google.android.gms.identity.intents.model.UserAddress;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

/* renamed from: com.google.android.gms.wallet.f */
public class C2349f implements Creator {
    static void m9621a(FullWallet fullWallet, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, 1, fullWallet.getVersionCode());
        C1488b.m6366a(parcel, 2, fullWallet.abh, false);
        C1488b.m6366a(parcel, 3, fullWallet.abi, false);
        C1488b.m6363a(parcel, 4, fullWallet.abj, i, false);
        C1488b.m6366a(parcel, 5, fullWallet.abk, false);
        C1488b.m6363a(parcel, 6, fullWallet.abl, i, false);
        C1488b.m6363a(parcel, 7, fullWallet.abm, i, false);
        C1488b.m6373a(parcel, 8, fullWallet.abn, false);
        C1488b.m6363a(parcel, 9, fullWallet.abo, i, false);
        C1488b.m6363a(parcel, 10, fullWallet.abp, i, false);
        C1488b.m6372a(parcel, 11, fullWallet.abq, i, false);
        C1488b.m6355F(parcel, p);
    }

    public FullWallet bb(Parcel parcel) {
        InstrumentInfo[] instrumentInfoArr = null;
        int o = C1487a.m6340o(parcel);
        int i = 0;
        UserAddress userAddress = null;
        UserAddress userAddress2 = null;
        String[] strArr = null;
        Address address = null;
        Address address2 = null;
        String str = null;
        ProxyCard proxyCard = null;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < o) {
            int n = C1487a.m6338n(parcel);
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    i = C1487a.m6331g(parcel, n);
                    break;
                case Base64.NO_WRAP /*2*/:
                    str3 = C1487a.m6339n(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    str2 = C1487a.m6339n(parcel, n);
                    break;
                case Base64.CRLF /*4*/:
                    proxyCard = (ProxyCard) C1487a.m6320a(parcel, n, ProxyCard.CREATOR);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    str = C1487a.m6339n(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                    address2 = (Address) C1487a.m6320a(parcel, n, Address.CREATOR);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                    address = (Address) C1487a.m6320a(parcel, n, Address.CREATOR);
                    break;
                case Base64.URL_SAFE /*8*/:
                    strArr = C1487a.m6352z(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor /*9*/:
                    userAddress2 = (UserAddress) C1487a.m6320a(parcel, n, UserAddress.CREATOR);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                    userAddress = (UserAddress) C1487a.m6320a(parcel, n, UserAddress.CREATOR);
                    break;
                case C2625R.styleable.MapAttrs_uiZoomGestures /*11*/:
                    instrumentInfoArr = (InstrumentInfo[]) C1487a.m6325b(parcel, n, InstrumentInfo.CREATOR);
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new FullWallet(i, str3, str2, proxyCard, str, address2, address, strArr, userAddress2, userAddress, instrumentInfoArr);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public FullWallet[] cn(int i) {
        return new FullWallet[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bb(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cn(x0);
    }
}
