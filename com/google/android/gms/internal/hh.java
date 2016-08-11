package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.google.android.gms.location.LocationStatusCodes;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;
import java.util.List;

public class hh implements Creator {
    static void m8690a(hg hgVar, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6377b(parcel, 1, hgVar.OA, false);
        C1488b.m6378c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, hgVar.xH);
        C1488b.m6366a(parcel, 2, hgVar.hW(), false);
        C1488b.m6369a(parcel, 3, hgVar.hX());
        C1488b.m6355F(parcel, p);
    }

    public hg aD(Parcel parcel) {
        String str = null;
        boolean z = false;
        int o = C1487a.m6340o(parcel);
        List list = null;
        int i = 0;
        while (parcel.dataPosition() < o) {
            int n = C1487a.m6338n(parcel);
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    list = C1487a.m6326c(parcel, n, hm.CREATOR);
                    break;
                case Base64.NO_WRAP /*2*/:
                    str = C1487a.m6339n(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    z = C1487a.m6327c(parcel, n);
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
            return new hg(i, list, str, z);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public hg[] bE(int i) {
        return new hg[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aD(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bE(x0);
    }
}
