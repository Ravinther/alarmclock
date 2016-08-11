package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.avg.ui.general.C1091c.C1087k;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.millennialmedia.android.C2513R;
import com.millennialmedia.android.MMException;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;
import java.util.List;

public class da implements Creator {
    static void m8108a(cz czVar, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, 1, czVar.versionCode);
        C1488b.m6366a(parcel, 2, czVar.ol, false);
        C1488b.m6366a(parcel, 3, czVar.pm, false);
        C1488b.m6367a(parcel, 4, czVar.ne, false);
        C1488b.m6378c(parcel, 5, czVar.errorCode);
        C1488b.m6367a(parcel, 6, czVar.nf, false);
        C1488b.m6359a(parcel, 7, czVar.pn);
        C1488b.m6369a(parcel, 8, czVar.po);
        C1488b.m6359a(parcel, 9, czVar.pp);
        C1488b.m6367a(parcel, 10, czVar.pq, false);
        C1488b.m6359a(parcel, 11, czVar.ni);
        C1488b.m6378c(parcel, 12, czVar.orientation);
        C1488b.m6366a(parcel, 13, czVar.pr, false);
        C1488b.m6359a(parcel, 14, czVar.ps);
        C1488b.m6366a(parcel, 15, czVar.pt, false);
        C1488b.m6366a(parcel, 19, czVar.pv, false);
        C1488b.m6369a(parcel, 18, czVar.pu);
        C1488b.m6366a(parcel, 21, czVar.pw, false);
        C1488b.m6355F(parcel, p);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m8109g(x0);
    }

    public cz m8109g(Parcel parcel) {
        int o = C1487a.m6340o(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        List list = null;
        int i2 = 0;
        List list2 = null;
        long j = 0;
        boolean z = false;
        long j2 = 0;
        List list3 = null;
        long j3 = 0;
        int i3 = 0;
        String str3 = null;
        long j4 = 0;
        String str4 = null;
        boolean z2 = false;
        String str5 = null;
        String str6 = null;
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
                    list = C1487a.m6315A(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    i2 = C1487a.m6331g(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                    list2 = C1487a.m6315A(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                    j = C1487a.m6333i(parcel, n);
                    break;
                case Base64.URL_SAFE /*8*/:
                    z = C1487a.m6327c(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor /*9*/:
                    j2 = C1487a.m6333i(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                    list3 = C1487a.m6315A(parcel, n);
                    break;
                case C2625R.styleable.MapAttrs_uiZoomGestures /*11*/:
                    j3 = C1487a.m6333i(parcel, n);
                    break;
                case C2625R.styleable.MapAttrs_useViewLifecycle /*12*/:
                    i3 = C1487a.m6331g(parcel, n);
                    break;
                case C2625R.styleable.MapAttrs_zOrderOnTop /*13*/:
                    str3 = C1487a.m6339n(parcel, n);
                    break;
                case C2513R.styleable.MMAdView_height /*14*/:
                    j4 = C1487a.m6333i(parcel, n);
                    break;
                case C2513R.styleable.MMAdView_width /*15*/:
                    str4 = C1487a.m6339n(parcel, n);
                    break;
                case C1087k.ActionBar_itemPadding /*18*/:
                    z2 = C1487a.m6327c(parcel, n);
                    break;
                case Encoder.LINE_GROUPS /*19*/:
                    str5 = C1487a.m6339n(parcel, n);
                    break;
                case MMException.DISPLAY_AD_EXPIRED /*21*/:
                    str6 = C1487a.m6339n(parcel, n);
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new cz(i, str, str2, list, i2, list2, j, z, j2, list3, j3, i3, str3, j4, str4, z2, str5, str6);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public cz[] m8110l(int i) {
        return new cz[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m8110l(x0);
    }
}
