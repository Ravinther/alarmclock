package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.avg.ui.general.C1091c.C1087k;
import com.google.ads.AdSize;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.millennialmedia.android.C2513R;
import com.millennialmedia.android.MMException;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class id implements Creator {
    static void m8764a(ic icVar, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        Set ja = icVar.ja();
        if (ja.contains(Integer.valueOf(1))) {
            C1488b.m6378c(parcel, 1, icVar.getVersionCode());
        }
        if (ja.contains(Integer.valueOf(2))) {
            C1488b.m6363a(parcel, 2, icVar.jb(), i, true);
        }
        if (ja.contains(Integer.valueOf(3))) {
            C1488b.m6367a(parcel, 3, icVar.getAdditionalName(), true);
        }
        if (ja.contains(Integer.valueOf(4))) {
            C1488b.m6363a(parcel, 4, icVar.jc(), i, true);
        }
        if (ja.contains(Integer.valueOf(5))) {
            C1488b.m6366a(parcel, 5, icVar.getAddressCountry(), true);
        }
        if (ja.contains(Integer.valueOf(6))) {
            C1488b.m6366a(parcel, 6, icVar.getAddressLocality(), true);
        }
        if (ja.contains(Integer.valueOf(7))) {
            C1488b.m6366a(parcel, 7, icVar.getAddressRegion(), true);
        }
        if (ja.contains(Integer.valueOf(8))) {
            C1488b.m6377b(parcel, 8, icVar.jd(), true);
        }
        if (ja.contains(Integer.valueOf(9))) {
            C1488b.m6378c(parcel, 9, icVar.getAttendeeCount());
        }
        if (ja.contains(Integer.valueOf(10))) {
            C1488b.m6377b(parcel, 10, icVar.je(), true);
        }
        if (ja.contains(Integer.valueOf(11))) {
            C1488b.m6363a(parcel, 11, icVar.jf(), i, true);
        }
        if (ja.contains(Integer.valueOf(12))) {
            C1488b.m6377b(parcel, 12, icVar.jg(), true);
        }
        if (ja.contains(Integer.valueOf(13))) {
            C1488b.m6366a(parcel, 13, icVar.getBestRating(), true);
        }
        if (ja.contains(Integer.valueOf(14))) {
            C1488b.m6366a(parcel, 14, icVar.getBirthDate(), true);
        }
        if (ja.contains(Integer.valueOf(15))) {
            C1488b.m6363a(parcel, 15, icVar.jh(), i, true);
        }
        if (ja.contains(Integer.valueOf(17))) {
            C1488b.m6366a(parcel, 17, icVar.getContentSize(), true);
        }
        if (ja.contains(Integer.valueOf(16))) {
            C1488b.m6366a(parcel, 16, icVar.getCaption(), true);
        }
        if (ja.contains(Integer.valueOf(19))) {
            C1488b.m6377b(parcel, 19, icVar.ji(), true);
        }
        if (ja.contains(Integer.valueOf(18))) {
            C1488b.m6366a(parcel, 18, icVar.getContentUrl(), true);
        }
        if (ja.contains(Integer.valueOf(21))) {
            C1488b.m6366a(parcel, 21, icVar.getDateModified(), true);
        }
        if (ja.contains(Integer.valueOf(20))) {
            C1488b.m6366a(parcel, 20, icVar.getDateCreated(), true);
        }
        if (ja.contains(Integer.valueOf(23))) {
            C1488b.m6366a(parcel, 23, icVar.getDescription(), true);
        }
        if (ja.contains(Integer.valueOf(22))) {
            C1488b.m6366a(parcel, 22, icVar.getDatePublished(), true);
        }
        if (ja.contains(Integer.valueOf(25))) {
            C1488b.m6366a(parcel, 25, icVar.getEmbedUrl(), true);
        }
        if (ja.contains(Integer.valueOf(24))) {
            C1488b.m6366a(parcel, 24, icVar.getDuration(), true);
        }
        if (ja.contains(Integer.valueOf(27))) {
            C1488b.m6366a(parcel, 27, icVar.getFamilyName(), true);
        }
        if (ja.contains(Integer.valueOf(26))) {
            C1488b.m6366a(parcel, 26, icVar.getEndDate(), true);
        }
        if (ja.contains(Integer.valueOf(29))) {
            C1488b.m6363a(parcel, 29, icVar.jj(), i, true);
        }
        if (ja.contains(Integer.valueOf(28))) {
            C1488b.m6366a(parcel, 28, icVar.getGender(), true);
        }
        if (ja.contains(Integer.valueOf(31))) {
            C1488b.m6366a(parcel, 31, icVar.getHeight(), true);
        }
        if (ja.contains(Integer.valueOf(30))) {
            C1488b.m6366a(parcel, 30, icVar.getGivenName(), true);
        }
        if (ja.contains(Integer.valueOf(34))) {
            C1488b.m6363a(parcel, 34, icVar.jk(), i, true);
        }
        if (ja.contains(Integer.valueOf(32))) {
            C1488b.m6366a(parcel, 32, icVar.getId(), true);
        }
        if (ja.contains(Integer.valueOf(33))) {
            C1488b.m6366a(parcel, 33, icVar.getImage(), true);
        }
        if (ja.contains(Integer.valueOf(38))) {
            C1488b.m6357a(parcel, 38, icVar.getLongitude());
        }
        if (ja.contains(Integer.valueOf(39))) {
            C1488b.m6366a(parcel, 39, icVar.getName(), true);
        }
        if (ja.contains(Integer.valueOf(36))) {
            C1488b.m6357a(parcel, 36, icVar.getLatitude());
        }
        if (ja.contains(Integer.valueOf(37))) {
            C1488b.m6363a(parcel, 37, icVar.jl(), i, true);
        }
        if (ja.contains(Integer.valueOf(42))) {
            C1488b.m6366a(parcel, 42, icVar.getPlayerType(), true);
        }
        if (ja.contains(Integer.valueOf(43))) {
            C1488b.m6366a(parcel, 43, icVar.getPostOfficeBoxNumber(), true);
        }
        if (ja.contains(Integer.valueOf(40))) {
            C1488b.m6363a(parcel, 40, icVar.jm(), i, true);
        }
        if (ja.contains(Integer.valueOf(41))) {
            C1488b.m6377b(parcel, 41, icVar.jn(), true);
        }
        if (ja.contains(Integer.valueOf(46))) {
            C1488b.m6363a(parcel, 46, icVar.jo(), i, true);
        }
        if (ja.contains(Integer.valueOf(47))) {
            C1488b.m6366a(parcel, 47, icVar.getStartDate(), true);
        }
        if (ja.contains(Integer.valueOf(44))) {
            C1488b.m6366a(parcel, 44, icVar.getPostalCode(), true);
        }
        if (ja.contains(Integer.valueOf(45))) {
            C1488b.m6366a(parcel, 45, icVar.getRatingValue(), true);
        }
        if (ja.contains(Integer.valueOf(51))) {
            C1488b.m6366a(parcel, 51, icVar.getThumbnailUrl(), true);
        }
        if (ja.contains(Integer.valueOf(50))) {
            C1488b.m6363a(parcel, 50, icVar.jp(), i, true);
        }
        if (ja.contains(Integer.valueOf(49))) {
            C1488b.m6366a(parcel, 49, icVar.getText(), true);
        }
        if (ja.contains(Integer.valueOf(48))) {
            C1488b.m6366a(parcel, 48, icVar.getStreetAddress(), true);
        }
        if (ja.contains(Integer.valueOf(55))) {
            C1488b.m6366a(parcel, 55, icVar.getWidth(), true);
        }
        if (ja.contains(Integer.valueOf(54))) {
            C1488b.m6366a(parcel, 54, icVar.getUrl(), true);
        }
        if (ja.contains(Integer.valueOf(53))) {
            C1488b.m6366a(parcel, 53, icVar.getType(), true);
        }
        if (ja.contains(Integer.valueOf(52))) {
            C1488b.m6366a(parcel, 52, icVar.getTickerSymbol(), true);
        }
        if (ja.contains(Integer.valueOf(56))) {
            C1488b.m6366a(parcel, 56, icVar.getWorstRating(), true);
        }
        C1488b.m6355F(parcel, p);
    }

    public ic aL(Parcel parcel) {
        int o = C1487a.m6340o(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        ic icVar = null;
        List list = null;
        ic icVar2 = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        List list2 = null;
        int i2 = 0;
        List list3 = null;
        ic icVar3 = null;
        List list4 = null;
        String str4 = null;
        String str5 = null;
        ic icVar4 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        List list5 = null;
        String str9 = null;
        String str10 = null;
        String str11 = null;
        String str12 = null;
        String str13 = null;
        String str14 = null;
        String str15 = null;
        String str16 = null;
        String str17 = null;
        ic icVar5 = null;
        String str18 = null;
        String str19 = null;
        String str20 = null;
        String str21 = null;
        ic icVar6 = null;
        double d = 0.0d;
        ic icVar7 = null;
        double d2 = 0.0d;
        String str22 = null;
        ic icVar8 = null;
        List list6 = null;
        String str23 = null;
        String str24 = null;
        String str25 = null;
        String str26 = null;
        ic icVar9 = null;
        String str27 = null;
        String str28 = null;
        String str29 = null;
        ic icVar10 = null;
        String str30 = null;
        String str31 = null;
        String str32 = null;
        String str33 = null;
        String str34 = null;
        String str35 = null;
        while (parcel.dataPosition() < o) {
            int n = C1487a.m6338n(parcel);
            ic icVar11;
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    i = C1487a.m6331g(parcel, n);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case Base64.NO_WRAP /*2*/:
                    icVar11 = (ic) C1487a.m6320a(parcel, n, ic.CREATOR);
                    hashSet.add(Integer.valueOf(2));
                    icVar = icVar11;
                    break;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    list = C1487a.m6315A(parcel, n);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case Base64.CRLF /*4*/:
                    icVar11 = (ic) C1487a.m6320a(parcel, n, ic.CREATOR);
                    hashSet.add(Integer.valueOf(4));
                    icVar2 = icVar11;
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    str = C1487a.m6339n(parcel, n);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                    str2 = C1487a.m6339n(parcel, n);
                    hashSet.add(Integer.valueOf(6));
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                    str3 = C1487a.m6339n(parcel, n);
                    hashSet.add(Integer.valueOf(7));
                    break;
                case Base64.URL_SAFE /*8*/:
                    list2 = C1487a.m6326c(parcel, n, ic.CREATOR);
                    hashSet.add(Integer.valueOf(8));
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor /*9*/:
                    i2 = C1487a.m6331g(parcel, n);
                    hashSet.add(Integer.valueOf(9));
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                    list3 = C1487a.m6326c(parcel, n, ic.CREATOR);
                    hashSet.add(Integer.valueOf(10));
                    break;
                case C2625R.styleable.MapAttrs_uiZoomGestures /*11*/:
                    icVar11 = (ic) C1487a.m6320a(parcel, n, ic.CREATOR);
                    hashSet.add(Integer.valueOf(11));
                    icVar3 = icVar11;
                    break;
                case C2625R.styleable.MapAttrs_useViewLifecycle /*12*/:
                    list4 = C1487a.m6326c(parcel, n, ic.CREATOR);
                    hashSet.add(Integer.valueOf(12));
                    break;
                case C2625R.styleable.MapAttrs_zOrderOnTop /*13*/:
                    str4 = C1487a.m6339n(parcel, n);
                    hashSet.add(Integer.valueOf(13));
                    break;
                case C2513R.styleable.MMAdView_height /*14*/:
                    str5 = C1487a.m6339n(parcel, n);
                    hashSet.add(Integer.valueOf(14));
                    break;
                case C2513R.styleable.MMAdView_width /*15*/:
                    icVar11 = (ic) C1487a.m6320a(parcel, n, ic.CREATOR);
                    hashSet.add(Integer.valueOf(15));
                    icVar4 = icVar11;
                    break;
                case Base64.NO_CLOSE /*16*/:
                    str6 = C1487a.m6339n(parcel, n);
                    hashSet.add(Integer.valueOf(16));
                    break;
                case MMException.CACHE_NOT_EMPTY /*17*/:
                    str7 = C1487a.m6339n(parcel, n);
                    hashSet.add(Integer.valueOf(17));
                    break;
                case C1087k.ActionBar_itemPadding /*18*/:
                    str8 = C1487a.m6339n(parcel, n);
                    hashSet.add(Integer.valueOf(18));
                    break;
                case Encoder.LINE_GROUPS /*19*/:
                    list5 = C1487a.m6326c(parcel, n, ic.CREATOR);
                    hashSet.add(Integer.valueOf(19));
                    break;
                case MMException.DISPLAY_AD_NOT_READY /*20*/:
                    str9 = C1487a.m6339n(parcel, n);
                    hashSet.add(Integer.valueOf(20));
                    break;
                case MMException.DISPLAY_AD_EXPIRED /*21*/:
                    str10 = C1487a.m6339n(parcel, n);
                    hashSet.add(Integer.valueOf(21));
                    break;
                case MMException.DISPLAY_AD_NOT_FOUND /*22*/:
                    str11 = C1487a.m6339n(parcel, n);
                    hashSet.add(Integer.valueOf(22));
                    break;
                case MMException.DISPLAY_AD_ALREADY_DISPLAYED /*23*/:
                    str12 = C1487a.m6339n(parcel, n);
                    hashSet.add(Integer.valueOf(23));
                    break;
                case MMException.DISPLAY_AD_NOT_PERMITTED /*24*/:
                    str13 = C1487a.m6339n(parcel, n);
                    hashSet.add(Integer.valueOf(24));
                    break;
                case MMException.AD_BROKEN_REFERENCE /*25*/:
                    str14 = C1487a.m6339n(parcel, n);
                    hashSet.add(Integer.valueOf(25));
                    break;
                case MMException.AD_NO_ACTIVITY /*26*/:
                    str15 = C1487a.m6339n(parcel, n);
                    hashSet.add(Integer.valueOf(26));
                    break;
                case 27:
                    str16 = C1487a.m6339n(parcel, n);
                    hashSet.add(Integer.valueOf(27));
                    break;
                case 28:
                    str17 = C1487a.m6339n(parcel, n);
                    hashSet.add(Integer.valueOf(28));
                    break;
                case 29:
                    icVar11 = (ic) C1487a.m6320a(parcel, n, ic.CREATOR);
                    hashSet.add(Integer.valueOf(29));
                    icVar5 = icVar11;
                    break;
                case 30:
                    str18 = C1487a.m6339n(parcel, n);
                    hashSet.add(Integer.valueOf(30));
                    break;
                case 31:
                    str19 = C1487a.m6339n(parcel, n);
                    hashSet.add(Integer.valueOf(31));
                    break;
                case AdSize.LANDSCAPE_AD_HEIGHT /*32*/:
                    str20 = C1487a.m6339n(parcel, n);
                    hashSet.add(Integer.valueOf(32));
                    break;
                case 33:
                    str21 = C1487a.m6339n(parcel, n);
                    hashSet.add(Integer.valueOf(33));
                    break;
                case 34:
                    icVar11 = (ic) C1487a.m6320a(parcel, n, ic.CREATOR);
                    hashSet.add(Integer.valueOf(34));
                    icVar6 = icVar11;
                    break;
                case 36:
                    d = C1487a.m6336l(parcel, n);
                    hashSet.add(Integer.valueOf(36));
                    break;
                case 37:
                    icVar11 = (ic) C1487a.m6320a(parcel, n, ic.CREATOR);
                    hashSet.add(Integer.valueOf(37));
                    icVar7 = icVar11;
                    break;
                case 38:
                    d2 = C1487a.m6336l(parcel, n);
                    hashSet.add(Integer.valueOf(38));
                    break;
                case 39:
                    str22 = C1487a.m6339n(parcel, n);
                    hashSet.add(Integer.valueOf(39));
                    break;
                case 40:
                    icVar11 = (ic) C1487a.m6320a(parcel, n, ic.CREATOR);
                    hashSet.add(Integer.valueOf(40));
                    icVar8 = icVar11;
                    break;
                case 41:
                    list6 = C1487a.m6326c(parcel, n, ic.CREATOR);
                    hashSet.add(Integer.valueOf(41));
                    break;
                case 42:
                    str23 = C1487a.m6339n(parcel, n);
                    hashSet.add(Integer.valueOf(42));
                    break;
                case 43:
                    str24 = C1487a.m6339n(parcel, n);
                    hashSet.add(Integer.valueOf(43));
                    break;
                case 44:
                    str25 = C1487a.m6339n(parcel, n);
                    hashSet.add(Integer.valueOf(44));
                    break;
                case 45:
                    str26 = C1487a.m6339n(parcel, n);
                    hashSet.add(Integer.valueOf(45));
                    break;
                case 46:
                    icVar11 = (ic) C1487a.m6320a(parcel, n, ic.CREATOR);
                    hashSet.add(Integer.valueOf(46));
                    icVar9 = icVar11;
                    break;
                case 47:
                    str27 = C1487a.m6339n(parcel, n);
                    hashSet.add(Integer.valueOf(47));
                    break;
                case 48:
                    str28 = C1487a.m6339n(parcel, n);
                    hashSet.add(Integer.valueOf(48));
                    break;
                case 49:
                    str29 = C1487a.m6339n(parcel, n);
                    hashSet.add(Integer.valueOf(49));
                    break;
                case AdSize.PORTRAIT_AD_HEIGHT /*50*/:
                    icVar11 = (ic) C1487a.m6320a(parcel, n, ic.CREATOR);
                    hashSet.add(Integer.valueOf(50));
                    icVar10 = icVar11;
                    break;
                case 51:
                    str30 = C1487a.m6339n(parcel, n);
                    hashSet.add(Integer.valueOf(51));
                    break;
                case 52:
                    str31 = C1487a.m6339n(parcel, n);
                    hashSet.add(Integer.valueOf(52));
                    break;
                case 53:
                    str32 = C1487a.m6339n(parcel, n);
                    hashSet.add(Integer.valueOf(53));
                    break;
                case 54:
                    str33 = C1487a.m6339n(parcel, n);
                    hashSet.add(Integer.valueOf(54));
                    break;
                case 55:
                    str34 = C1487a.m6339n(parcel, n);
                    hashSet.add(Integer.valueOf(55));
                    break;
                case 56:
                    str35 = C1487a.m6339n(parcel, n);
                    hashSet.add(Integer.valueOf(56));
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new ic(hashSet, i, icVar, list, icVar2, str, str2, str3, list2, i2, list3, icVar3, list4, str4, str5, icVar4, str6, str7, str8, list5, str9, str10, str11, str12, str13, str14, str15, str16, str17, icVar5, str18, str19, str20, str21, icVar6, d, icVar7, d2, str22, icVar8, list6, str23, str24, str25, str26, icVar9, str27, str28, str29, icVar10, str30, str31, str32, str33, str34, str35);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public ic[] bO(int i) {
        return new ic[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aL(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bO(x0);
    }
}
