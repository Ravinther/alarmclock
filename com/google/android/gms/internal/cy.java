package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

public class cy implements Creator {
    static void m8099a(cx cxVar, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, 1, cxVar.versionCode);
        C1488b.m6360a(parcel, 2, cxVar.pf, false);
        C1488b.m6363a(parcel, 3, cxVar.pg, i, false);
        C1488b.m6363a(parcel, 4, cxVar.kN, i, false);
        C1488b.m6366a(parcel, 5, cxVar.kH, false);
        C1488b.m6363a(parcel, 6, cxVar.applicationInfo, i, false);
        C1488b.m6363a(parcel, 7, cxVar.ph, i, false);
        C1488b.m6366a(parcel, 8, cxVar.pi, false);
        C1488b.m6366a(parcel, 9, cxVar.pj, false);
        C1488b.m6366a(parcel, 10, cxVar.pk, false);
        C1488b.m6363a(parcel, 11, cxVar.kK, i, false);
        C1488b.m6360a(parcel, 12, cxVar.pl, false);
        C1488b.m6355F(parcel, p);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m8100f(x0);
    }

    public cx m8100f(Parcel parcel) {
        int o = C1487a.m6340o(parcel);
        int i = 0;
        Bundle bundle = null;
        ah ahVar = null;
        ak akVar = null;
        String str = null;
        ApplicationInfo applicationInfo = null;
        PackageInfo packageInfo = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        dx dxVar = null;
        Bundle bundle2 = null;
        while (parcel.dataPosition() < o) {
            int n = C1487a.m6338n(parcel);
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    i = C1487a.m6331g(parcel, n);
                    break;
                case Base64.NO_WRAP /*2*/:
                    bundle = C1487a.m6342p(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    ahVar = (ah) C1487a.m6320a(parcel, n, ah.CREATOR);
                    break;
                case Base64.CRLF /*4*/:
                    akVar = (ak) C1487a.m6320a(parcel, n, ak.CREATOR);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    str = C1487a.m6339n(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                    applicationInfo = (ApplicationInfo) C1487a.m6320a(parcel, n, ApplicationInfo.CREATOR);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                    packageInfo = (PackageInfo) C1487a.m6320a(parcel, n, PackageInfo.CREATOR);
                    break;
                case Base64.URL_SAFE /*8*/:
                    str2 = C1487a.m6339n(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor /*9*/:
                    str3 = C1487a.m6339n(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                    str4 = C1487a.m6339n(parcel, n);
                    break;
                case C2625R.styleable.MapAttrs_uiZoomGestures /*11*/:
                    dxVar = (dx) C1487a.m6320a(parcel, n, dx.CREATOR);
                    break;
                case C2625R.styleable.MapAttrs_useViewLifecycle /*12*/:
                    bundle2 = C1487a.m6342p(parcel, n);
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new cx(i, bundle, ahVar, akVar, str, applicationInfo, packageInfo, str2, str3, str4, dxVar, bundle2);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public cx[] m8101k(int i) {
        return new cx[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m8101k(x0);
    }
}
