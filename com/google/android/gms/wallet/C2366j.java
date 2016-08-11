package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.avg.ui.general.C1091c.C1087k;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.google.android.gms.internal.gi;
import com.google.android.gms.internal.jm;
import com.google.android.gms.internal.jo;
import com.google.android.gms.internal.js;
import com.google.android.gms.internal.ju;
import com.google.android.gms.internal.jw;
import com.google.android.gms.internal.jy;
import com.google.android.gms.maps.model.LatLng;
import com.millennialmedia.android.C2513R;
import com.millennialmedia.android.MMException;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.wallet.j */
public class C2366j implements Creator {
    static void m9696a(LoyaltyWalletObject loyaltyWalletObject, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, 1, loyaltyWalletObject.getVersionCode());
        C1488b.m6366a(parcel, 2, loyaltyWalletObject.eC, false);
        C1488b.m6366a(parcel, 3, loyaltyWalletObject.abz, false);
        C1488b.m6366a(parcel, 4, loyaltyWalletObject.abA, false);
        C1488b.m6366a(parcel, 5, loyaltyWalletObject.abB, false);
        C1488b.m6366a(parcel, 6, loyaltyWalletObject.abC, false);
        C1488b.m6366a(parcel, 7, loyaltyWalletObject.abD, false);
        C1488b.m6366a(parcel, 8, loyaltyWalletObject.abE, false);
        C1488b.m6366a(parcel, 9, loyaltyWalletObject.abF, false);
        C1488b.m6366a(parcel, 10, loyaltyWalletObject.abG, false);
        C1488b.m6366a(parcel, 11, loyaltyWalletObject.abH, false);
        C1488b.m6378c(parcel, 12, loyaltyWalletObject.state);
        C1488b.m6377b(parcel, 13, loyaltyWalletObject.abI, false);
        C1488b.m6363a(parcel, 14, loyaltyWalletObject.abJ, i, false);
        C1488b.m6377b(parcel, 15, loyaltyWalletObject.abK, false);
        C1488b.m6366a(parcel, 17, loyaltyWalletObject.abM, false);
        C1488b.m6366a(parcel, 16, loyaltyWalletObject.abL, false);
        C1488b.m6369a(parcel, 19, loyaltyWalletObject.abO);
        C1488b.m6377b(parcel, 18, loyaltyWalletObject.abN, false);
        C1488b.m6377b(parcel, 21, loyaltyWalletObject.abQ, false);
        C1488b.m6377b(parcel, 20, loyaltyWalletObject.abP, false);
        C1488b.m6363a(parcel, 23, loyaltyWalletObject.abS, i, false);
        C1488b.m6377b(parcel, 22, loyaltyWalletObject.abR, false);
        C1488b.m6355F(parcel, p);
    }

    public LoyaltyWalletObject bf(Parcel parcel) {
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
        int i2 = 0;
        ArrayList fs = gi.fs();
        ju juVar = null;
        ArrayList fs2 = gi.fs();
        String str11 = null;
        String str12 = null;
        ArrayList fs3 = gi.fs();
        boolean z = false;
        ArrayList fs4 = gi.fs();
        ArrayList fs5 = gi.fs();
        ArrayList fs6 = gi.fs();
        jo joVar = null;
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
                    i2 = C1487a.m6331g(parcel, n);
                    break;
                case C2625R.styleable.MapAttrs_zOrderOnTop /*13*/:
                    fs = C1487a.m6326c(parcel, n, jy.CREATOR);
                    break;
                case C2513R.styleable.MMAdView_height /*14*/:
                    juVar = (ju) C1487a.m6320a(parcel, n, ju.CREATOR);
                    break;
                case C2513R.styleable.MMAdView_width /*15*/:
                    fs2 = C1487a.m6326c(parcel, n, LatLng.CREATOR);
                    break;
                case Base64.NO_CLOSE /*16*/:
                    str11 = C1487a.m6339n(parcel, n);
                    break;
                case MMException.CACHE_NOT_EMPTY /*17*/:
                    str12 = C1487a.m6339n(parcel, n);
                    break;
                case C1087k.ActionBar_itemPadding /*18*/:
                    fs3 = C1487a.m6326c(parcel, n, jm.CREATOR);
                    break;
                case Encoder.LINE_GROUPS /*19*/:
                    z = C1487a.m6327c(parcel, n);
                    break;
                case MMException.DISPLAY_AD_NOT_READY /*20*/:
                    fs4 = C1487a.m6326c(parcel, n, jw.CREATOR);
                    break;
                case MMException.DISPLAY_AD_EXPIRED /*21*/:
                    fs5 = C1487a.m6326c(parcel, n, js.CREATOR);
                    break;
                case MMException.DISPLAY_AD_NOT_FOUND /*22*/:
                    fs6 = C1487a.m6326c(parcel, n, jw.CREATOR);
                    break;
                case MMException.DISPLAY_AD_ALREADY_DISPLAYED /*23*/:
                    joVar = (jo) C1487a.m6320a(parcel, n, jo.CREATOR);
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new LoyaltyWalletObject(i, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, i2, fs, juVar, fs2, str11, str12, fs3, z, fs4, fs5, fs6, joVar);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public LoyaltyWalletObject[] cr(int i) {
        return new LoyaltyWalletObject[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bf(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cr(x0);
    }
}
