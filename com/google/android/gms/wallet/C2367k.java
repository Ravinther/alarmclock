package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.google.android.gms.identity.intents.model.UserAddress;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

/* renamed from: com.google.android.gms.wallet.k */
public class C2367k implements Creator {
    static void m9697a(MaskedWallet maskedWallet, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, 1, maskedWallet.getVersionCode());
        C1488b.m6366a(parcel, 2, maskedWallet.abh, false);
        C1488b.m6366a(parcel, 3, maskedWallet.abi, false);
        C1488b.m6373a(parcel, 4, maskedWallet.abn, false);
        C1488b.m6366a(parcel, 5, maskedWallet.abk, false);
        C1488b.m6363a(parcel, 6, maskedWallet.abl, i, false);
        C1488b.m6363a(parcel, 7, maskedWallet.abm, i, false);
        C1488b.m6372a(parcel, 8, maskedWallet.abT, i, false);
        C1488b.m6372a(parcel, 9, maskedWallet.abU, i, false);
        C1488b.m6363a(parcel, 10, maskedWallet.abo, i, false);
        C1488b.m6363a(parcel, 11, maskedWallet.abp, i, false);
        C1488b.m6372a(parcel, 12, maskedWallet.abq, i, false);
        C1488b.m6355F(parcel, p);
    }

    public MaskedWallet bg(Parcel parcel) {
        int o = C1487a.m6340o(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String[] strArr = null;
        String str3 = null;
        Address address = null;
        Address address2 = null;
        LoyaltyWalletObject[] loyaltyWalletObjectArr = null;
        OfferWalletObject[] offerWalletObjectArr = null;
        UserAddress userAddress = null;
        UserAddress userAddress2 = null;
        InstrumentInfo[] instrumentInfoArr = null;
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
                    str2 = C1487a.m6339n(parcel, n);
                    break;
                case Base64.CRLF /*4*/:
                    strArr = C1487a.m6352z(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    str3 = C1487a.m6339n(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                    address = (Address) C1487a.m6320a(parcel, n, Address.CREATOR);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                    address2 = (Address) C1487a.m6320a(parcel, n, Address.CREATOR);
                    break;
                case Base64.URL_SAFE /*8*/:
                    loyaltyWalletObjectArr = (LoyaltyWalletObject[]) C1487a.m6325b(parcel, n, LoyaltyWalletObject.CREATOR);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor /*9*/:
                    offerWalletObjectArr = (OfferWalletObject[]) C1487a.m6325b(parcel, n, OfferWalletObject.CREATOR);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                    userAddress = (UserAddress) C1487a.m6320a(parcel, n, UserAddress.CREATOR);
                    break;
                case C2625R.styleable.MapAttrs_uiZoomGestures /*11*/:
                    userAddress2 = (UserAddress) C1487a.m6320a(parcel, n, UserAddress.CREATOR);
                    break;
                case C2625R.styleable.MapAttrs_useViewLifecycle /*12*/:
                    instrumentInfoArr = (InstrumentInfo[]) C1487a.m6325b(parcel, n, InstrumentInfo.CREATOR);
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new MaskedWallet(i, str, str2, strArr, str3, address, address2, loyaltyWalletObjectArr, offerWalletObjectArr, userAddress, userAddress2, instrumentInfoArr);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bg(x0);
    }

    public MaskedWallet[] cs(int i) {
        return new MaskedWallet[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cs(x0);
    }
}
