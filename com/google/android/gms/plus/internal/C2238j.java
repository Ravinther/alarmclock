package com.google.android.gms.plus.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.google.android.gms.location.LocationStatusCodes;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

/* renamed from: com.google.android.gms.plus.internal.j */
public class C2238j implements Creator {
    static void m9269a(C2236h c2236h, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6366a(parcel, 1, c2236h.getAccountName(), false);
        C1488b.m6378c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, c2236h.getVersionCode());
        C1488b.m6373a(parcel, 2, c2236h.iP(), false);
        C1488b.m6373a(parcel, 3, c2236h.iQ(), false);
        C1488b.m6373a(parcel, 4, c2236h.iR(), false);
        C1488b.m6366a(parcel, 5, c2236h.iS(), false);
        C1488b.m6366a(parcel, 6, c2236h.iT(), false);
        C1488b.m6366a(parcel, 7, c2236h.iU(), false);
        C1488b.m6366a(parcel, 8, c2236h.iV(), false);
        C1488b.m6363a(parcel, 9, c2236h.iW(), i, false);
        C1488b.m6355F(parcel, p);
    }

    public C2236h aK(Parcel parcel) {
        PlusCommonExtras plusCommonExtras = null;
        int o = C1487a.m6340o(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String[] strArr = null;
        String[] strArr2 = null;
        String[] strArr3 = null;
        String str5 = null;
        while (parcel.dataPosition() < o) {
            int n = C1487a.m6338n(parcel);
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    str5 = C1487a.m6339n(parcel, n);
                    break;
                case Base64.NO_WRAP /*2*/:
                    strArr3 = C1487a.m6352z(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    strArr2 = C1487a.m6352z(parcel, n);
                    break;
                case Base64.CRLF /*4*/:
                    strArr = C1487a.m6352z(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    str4 = C1487a.m6339n(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                    str3 = C1487a.m6339n(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                    str2 = C1487a.m6339n(parcel, n);
                    break;
                case Base64.URL_SAFE /*8*/:
                    str = C1487a.m6339n(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor /*9*/:
                    plusCommonExtras = (PlusCommonExtras) C1487a.m6320a(parcel, n, PlusCommonExtras.CREATOR);
                    break;
                case LocationStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i = C1487a.m6331g(parcel, n);
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C2236h(i, str5, strArr3, strArr2, strArr, str4, str3, str2, str, plusCommonExtras);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public C2236h[] bN(int i) {
        return new C2236h[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aK(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bN(x0);
    }
}
