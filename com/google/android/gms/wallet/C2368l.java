package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import com.millennialmedia.android.C2513R;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.wallet.l */
public class C2368l implements Creator {
    static void m9698a(MaskedWalletRequest maskedWalletRequest, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, 1, maskedWalletRequest.getVersionCode());
        C1488b.m6366a(parcel, 2, maskedWalletRequest.abi, false);
        C1488b.m6369a(parcel, 3, maskedWalletRequest.abV);
        C1488b.m6369a(parcel, 4, maskedWalletRequest.abW);
        C1488b.m6369a(parcel, 5, maskedWalletRequest.abX);
        C1488b.m6366a(parcel, 6, maskedWalletRequest.abY, false);
        C1488b.m6366a(parcel, 7, maskedWalletRequest.abd, false);
        C1488b.m6366a(parcel, 8, maskedWalletRequest.abZ, false);
        C1488b.m6363a(parcel, 9, maskedWalletRequest.abr, i, false);
        C1488b.m6369a(parcel, 10, maskedWalletRequest.aca);
        C1488b.m6369a(parcel, 11, maskedWalletRequest.acb);
        C1488b.m6372a(parcel, 12, maskedWalletRequest.acc, i, false);
        C1488b.m6369a(parcel, 13, maskedWalletRequest.acd);
        C1488b.m6369a(parcel, 14, maskedWalletRequest.ace);
        C1488b.m6377b(parcel, 15, maskedWalletRequest.acf, false);
        C1488b.m6355F(parcel, p);
    }

    public MaskedWalletRequest bh(Parcel parcel) {
        int o = C1487a.m6340o(parcel);
        int i = 0;
        String str = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Cart cart = null;
        boolean z4 = false;
        boolean z5 = false;
        CountrySpecification[] countrySpecificationArr = null;
        boolean z6 = true;
        boolean z7 = true;
        ArrayList arrayList = null;
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
                    z = C1487a.m6327c(parcel, n);
                    break;
                case Base64.CRLF /*4*/:
                    z2 = C1487a.m6327c(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    z3 = C1487a.m6327c(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                    str2 = C1487a.m6339n(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                    str3 = C1487a.m6339n(parcel, n);
                    break;
                case Base64.URL_SAFE /*8*/:
                    str4 = C1487a.m6339n(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor /*9*/:
                    cart = (Cart) C1487a.m6320a(parcel, n, Cart.CREATOR);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                    z4 = C1487a.m6327c(parcel, n);
                    break;
                case C2625R.styleable.MapAttrs_uiZoomGestures /*11*/:
                    z5 = C1487a.m6327c(parcel, n);
                    break;
                case C2625R.styleable.MapAttrs_useViewLifecycle /*12*/:
                    countrySpecificationArr = (CountrySpecification[]) C1487a.m6325b(parcel, n, CountrySpecification.CREATOR);
                    break;
                case C2625R.styleable.MapAttrs_zOrderOnTop /*13*/:
                    z6 = C1487a.m6327c(parcel, n);
                    break;
                case C2513R.styleable.MMAdView_height /*14*/:
                    z7 = C1487a.m6327c(parcel, n);
                    break;
                case C2513R.styleable.MMAdView_width /*15*/:
                    arrayList = C1487a.m6326c(parcel, n, CountrySpecification.CREATOR);
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new MaskedWalletRequest(i, str, z, z2, z3, str2, str3, str4, cart, z4, z5, countrySpecificationArr, z6, z7, arrayList);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bh(x0);
    }

    public MaskedWalletRequest[] ct(int i) {
        return new MaskedWalletRequest[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ct(x0);
    }
}
