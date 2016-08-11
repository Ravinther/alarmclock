package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.avg.ui.general.C1091c.C1087k;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.google.android.gms.internal.ih.C1982a;
import com.google.android.gms.internal.ih.C1985b;
import com.google.android.gms.internal.ih.C1986c;
import com.google.android.gms.internal.ih.C1987d;
import com.google.android.gms.internal.ih.C1989f;
import com.google.android.gms.internal.ih.C1990g;
import com.google.android.gms.internal.ih.C1991h;
import com.millennialmedia.android.C2513R;
import com.millennialmedia.android.MMException;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ii implements Creator {
    static void m8789a(ih ihVar, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        Set ja = ihVar.ja();
        if (ja.contains(Integer.valueOf(1))) {
            C1488b.m6378c(parcel, 1, ihVar.getVersionCode());
        }
        if (ja.contains(Integer.valueOf(2))) {
            C1488b.m6366a(parcel, 2, ihVar.getAboutMe(), true);
        }
        if (ja.contains(Integer.valueOf(3))) {
            C1488b.m6363a(parcel, 3, ihVar.jv(), i, true);
        }
        if (ja.contains(Integer.valueOf(4))) {
            C1488b.m6366a(parcel, 4, ihVar.getBirthday(), true);
        }
        if (ja.contains(Integer.valueOf(5))) {
            C1488b.m6366a(parcel, 5, ihVar.getBraggingRights(), true);
        }
        if (ja.contains(Integer.valueOf(6))) {
            C1488b.m6378c(parcel, 6, ihVar.getCircledByCount());
        }
        if (ja.contains(Integer.valueOf(7))) {
            C1488b.m6363a(parcel, 7, ihVar.jw(), i, true);
        }
        if (ja.contains(Integer.valueOf(8))) {
            C1488b.m6366a(parcel, 8, ihVar.getCurrentLocation(), true);
        }
        if (ja.contains(Integer.valueOf(9))) {
            C1488b.m6366a(parcel, 9, ihVar.getDisplayName(), true);
        }
        if (ja.contains(Integer.valueOf(12))) {
            C1488b.m6378c(parcel, 12, ihVar.getGender());
        }
        if (ja.contains(Integer.valueOf(14))) {
            C1488b.m6366a(parcel, 14, ihVar.getId(), true);
        }
        if (ja.contains(Integer.valueOf(15))) {
            C1488b.m6363a(parcel, 15, ihVar.jx(), i, true);
        }
        if (ja.contains(Integer.valueOf(16))) {
            C1488b.m6369a(parcel, 16, ihVar.isPlusUser());
        }
        if (ja.contains(Integer.valueOf(19))) {
            C1488b.m6363a(parcel, 19, ihVar.jy(), i, true);
        }
        if (ja.contains(Integer.valueOf(18))) {
            C1488b.m6366a(parcel, 18, ihVar.getLanguage(), true);
        }
        if (ja.contains(Integer.valueOf(21))) {
            C1488b.m6378c(parcel, 21, ihVar.getObjectType());
        }
        if (ja.contains(Integer.valueOf(20))) {
            C1488b.m6366a(parcel, 20, ihVar.getNickname(), true);
        }
        if (ja.contains(Integer.valueOf(23))) {
            C1488b.m6377b(parcel, 23, ihVar.jA(), true);
        }
        if (ja.contains(Integer.valueOf(22))) {
            C1488b.m6377b(parcel, 22, ihVar.jz(), true);
        }
        if (ja.contains(Integer.valueOf(25))) {
            C1488b.m6378c(parcel, 25, ihVar.getRelationshipStatus());
        }
        if (ja.contains(Integer.valueOf(24))) {
            C1488b.m6378c(parcel, 24, ihVar.getPlusOneCount());
        }
        if (ja.contains(Integer.valueOf(27))) {
            C1488b.m6366a(parcel, 27, ihVar.getUrl(), true);
        }
        if (ja.contains(Integer.valueOf(26))) {
            C1488b.m6366a(parcel, 26, ihVar.getTagline(), true);
        }
        if (ja.contains(Integer.valueOf(29))) {
            C1488b.m6369a(parcel, 29, ihVar.isVerified());
        }
        if (ja.contains(Integer.valueOf(28))) {
            C1488b.m6377b(parcel, 28, ihVar.jB(), true);
        }
        C1488b.m6355F(parcel, p);
    }

    public ih aN(Parcel parcel) {
        int o = C1487a.m6340o(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        String str = null;
        C1982a c1982a = null;
        String str2 = null;
        String str3 = null;
        int i2 = 0;
        C1985b c1985b = null;
        String str4 = null;
        String str5 = null;
        int i3 = 0;
        String str6 = null;
        C1986c c1986c = null;
        boolean z = false;
        String str7 = null;
        C1987d c1987d = null;
        String str8 = null;
        int i4 = 0;
        List list = null;
        List list2 = null;
        int i5 = 0;
        int i6 = 0;
        String str9 = null;
        String str10 = null;
        List list3 = null;
        boolean z2 = false;
        while (parcel.dataPosition() < o) {
            int n = C1487a.m6338n(parcel);
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    i = C1487a.m6331g(parcel, n);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case Base64.NO_WRAP /*2*/:
                    str = C1487a.m6339n(parcel, n);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    C1982a c1982a2 = (C1982a) C1487a.m6320a(parcel, n, C1982a.CREATOR);
                    hashSet.add(Integer.valueOf(3));
                    c1982a = c1982a2;
                    break;
                case Base64.CRLF /*4*/:
                    str2 = C1487a.m6339n(parcel, n);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    str3 = C1487a.m6339n(parcel, n);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                    i2 = C1487a.m6331g(parcel, n);
                    hashSet.add(Integer.valueOf(6));
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                    C1985b c1985b2 = (C1985b) C1487a.m6320a(parcel, n, C1985b.CREATOR);
                    hashSet.add(Integer.valueOf(7));
                    c1985b = c1985b2;
                    break;
                case Base64.URL_SAFE /*8*/:
                    str4 = C1487a.m6339n(parcel, n);
                    hashSet.add(Integer.valueOf(8));
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor /*9*/:
                    str5 = C1487a.m6339n(parcel, n);
                    hashSet.add(Integer.valueOf(9));
                    break;
                case C2625R.styleable.MapAttrs_useViewLifecycle /*12*/:
                    i3 = C1487a.m6331g(parcel, n);
                    hashSet.add(Integer.valueOf(12));
                    break;
                case C2513R.styleable.MMAdView_height /*14*/:
                    str6 = C1487a.m6339n(parcel, n);
                    hashSet.add(Integer.valueOf(14));
                    break;
                case C2513R.styleable.MMAdView_width /*15*/:
                    C1986c c1986c2 = (C1986c) C1487a.m6320a(parcel, n, C1986c.CREATOR);
                    hashSet.add(Integer.valueOf(15));
                    c1986c = c1986c2;
                    break;
                case Base64.NO_CLOSE /*16*/:
                    z = C1487a.m6327c(parcel, n);
                    hashSet.add(Integer.valueOf(16));
                    break;
                case C1087k.ActionBar_itemPadding /*18*/:
                    str7 = C1487a.m6339n(parcel, n);
                    hashSet.add(Integer.valueOf(18));
                    break;
                case Encoder.LINE_GROUPS /*19*/:
                    C1987d c1987d2 = (C1987d) C1487a.m6320a(parcel, n, C1987d.CREATOR);
                    hashSet.add(Integer.valueOf(19));
                    c1987d = c1987d2;
                    break;
                case MMException.DISPLAY_AD_NOT_READY /*20*/:
                    str8 = C1487a.m6339n(parcel, n);
                    hashSet.add(Integer.valueOf(20));
                    break;
                case MMException.DISPLAY_AD_EXPIRED /*21*/:
                    i4 = C1487a.m6331g(parcel, n);
                    hashSet.add(Integer.valueOf(21));
                    break;
                case MMException.DISPLAY_AD_NOT_FOUND /*22*/:
                    list = C1487a.m6326c(parcel, n, C1989f.CREATOR);
                    hashSet.add(Integer.valueOf(22));
                    break;
                case MMException.DISPLAY_AD_ALREADY_DISPLAYED /*23*/:
                    list2 = C1487a.m6326c(parcel, n, C1990g.CREATOR);
                    hashSet.add(Integer.valueOf(23));
                    break;
                case MMException.DISPLAY_AD_NOT_PERMITTED /*24*/:
                    i5 = C1487a.m6331g(parcel, n);
                    hashSet.add(Integer.valueOf(24));
                    break;
                case MMException.AD_BROKEN_REFERENCE /*25*/:
                    i6 = C1487a.m6331g(parcel, n);
                    hashSet.add(Integer.valueOf(25));
                    break;
                case MMException.AD_NO_ACTIVITY /*26*/:
                    str9 = C1487a.m6339n(parcel, n);
                    hashSet.add(Integer.valueOf(26));
                    break;
                case 27:
                    str10 = C1487a.m6339n(parcel, n);
                    hashSet.add(Integer.valueOf(27));
                    break;
                case 28:
                    list3 = C1487a.m6326c(parcel, n, C1991h.CREATOR);
                    hashSet.add(Integer.valueOf(28));
                    break;
                case 29:
                    z2 = C1487a.m6327c(parcel, n);
                    hashSet.add(Integer.valueOf(29));
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new ih(hashSet, i, str, c1982a, str2, str3, i2, c1985b, str4, str5, i3, str6, c1986c, z, str7, c1987d, str8, i4, list, list2, i5, i6, str9, str10, list3, z2);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public ih[] bQ(int i) {
        return new ih[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aN(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bQ(x0);
    }
}
