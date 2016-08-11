package com.google.android.gms.identity.intents.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.millennialmedia.android.C2513R;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

/* renamed from: com.google.android.gms.identity.intents.model.b */
public class C1731b implements Creator {
    static void m7782a(UserAddress userAddress, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, 1, userAddress.getVersionCode());
        C1488b.m6366a(parcel, 2, userAddress.name, false);
        C1488b.m6366a(parcel, 3, userAddress.NB, false);
        C1488b.m6366a(parcel, 4, userAddress.NC, false);
        C1488b.m6366a(parcel, 5, userAddress.ND, false);
        C1488b.m6366a(parcel, 6, userAddress.NE, false);
        C1488b.m6366a(parcel, 7, userAddress.NF, false);
        C1488b.m6366a(parcel, 8, userAddress.NG, false);
        C1488b.m6366a(parcel, 9, userAddress.NH, false);
        C1488b.m6366a(parcel, 10, userAddress.qd, false);
        C1488b.m6366a(parcel, 11, userAddress.NI, false);
        C1488b.m6366a(parcel, 12, userAddress.NJ, false);
        C1488b.m6366a(parcel, 13, userAddress.NK, false);
        C1488b.m6369a(parcel, 14, userAddress.NL);
        C1488b.m6366a(parcel, 15, userAddress.NM, false);
        C1488b.m6366a(parcel, 16, userAddress.NN, false);
        C1488b.m6355F(parcel, p);
    }

    public UserAddress aA(Parcel parcel) {
        int o = C1487a.m6340o(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        String str11 = null;
        String str12 = null;
        boolean z = false;
        String str13 = null;
        String str14 = null;
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
                    str3 = C1487a.m6339n(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    str4 = C1487a.m6339n(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                    str5 = C1487a.m6339n(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                    str6 = C1487a.m6339n(parcel, n);
                    break;
                case Base64.URL_SAFE /*8*/:
                    str7 = C1487a.m6339n(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor /*9*/:
                    str8 = C1487a.m6339n(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                    str9 = C1487a.m6339n(parcel, n);
                    break;
                case C2625R.styleable.MapAttrs_uiZoomGestures /*11*/:
                    str10 = C1487a.m6339n(parcel, n);
                    break;
                case C2625R.styleable.MapAttrs_useViewLifecycle /*12*/:
                    str11 = C1487a.m6339n(parcel, n);
                    break;
                case C2625R.styleable.MapAttrs_zOrderOnTop /*13*/:
                    str12 = C1487a.m6339n(parcel, n);
                    break;
                case C2513R.styleable.MMAdView_height /*14*/:
                    z = C1487a.m6327c(parcel, n);
                    break;
                case C2513R.styleable.MMAdView_width /*15*/:
                    str13 = C1487a.m6339n(parcel, n);
                    break;
                case Base64.NO_CLOSE /*16*/:
                    str14 = C1487a.m6339n(parcel, n);
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new UserAddress(i, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, z, str13, str14);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public UserAddress[] bu(int i) {
        return new UserAddress[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aA(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bu(x0);
    }
}
