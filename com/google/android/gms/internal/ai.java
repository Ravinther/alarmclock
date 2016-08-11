package com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;
import java.util.List;

public class ai implements Creator {
    static void m7824a(ah ahVar, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, 1, ahVar.versionCode);
        C1488b.m6359a(parcel, 2, ahVar.lH);
        C1488b.m6360a(parcel, 3, ahVar.extras, false);
        C1488b.m6378c(parcel, 4, ahVar.lI);
        C1488b.m6367a(parcel, 5, ahVar.lJ, false);
        C1488b.m6369a(parcel, 6, ahVar.lK);
        C1488b.m6378c(parcel, 7, ahVar.lL);
        C1488b.m6369a(parcel, 8, ahVar.lM);
        C1488b.m6366a(parcel, 9, ahVar.lN, false);
        C1488b.m6363a(parcel, 10, ahVar.lO, i, false);
        C1488b.m6363a(parcel, 11, ahVar.lP, i, false);
        C1488b.m6366a(parcel, 12, ahVar.lQ, false);
        C1488b.m6355F(parcel, p);
    }

    public ah m7825a(Parcel parcel) {
        int o = C1487a.m6340o(parcel);
        int i = 0;
        long j = 0;
        Bundle bundle = null;
        int i2 = 0;
        List list = null;
        boolean z = false;
        int i3 = 0;
        boolean z2 = false;
        String str = null;
        av avVar = null;
        Location location = null;
        String str2 = null;
        while (parcel.dataPosition() < o) {
            int n = C1487a.m6338n(parcel);
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    i = C1487a.m6331g(parcel, n);
                    break;
                case Base64.NO_WRAP /*2*/:
                    j = C1487a.m6333i(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    bundle = C1487a.m6342p(parcel, n);
                    break;
                case Base64.CRLF /*4*/:
                    i2 = C1487a.m6331g(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    list = C1487a.m6315A(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                    z = C1487a.m6327c(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                    i3 = C1487a.m6331g(parcel, n);
                    break;
                case Base64.URL_SAFE /*8*/:
                    z2 = C1487a.m6327c(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor /*9*/:
                    str = C1487a.m6339n(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                    avVar = (av) C1487a.m6320a(parcel, n, av.CREATOR);
                    break;
                case C2625R.styleable.MapAttrs_uiZoomGestures /*11*/:
                    location = (Location) C1487a.m6320a(parcel, n, Location.CREATOR);
                    break;
                case C2625R.styleable.MapAttrs_useViewLifecycle /*12*/:
                    str2 = C1487a.m6339n(parcel, n);
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new ah(i, j, bundle, i2, list, z, i3, z2, str, avVar, location, str2);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public ah[] m7826b(int i) {
        return new ah[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m7825a(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m7826b(x0);
    }
}
