package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.google.android.gms.location.LocationStatusCodes;
import com.mopub.mobileads.util.Base64;

public class ht implements Creator {
    static void m8700a(hs hsVar, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6366a(parcel, 1, hsVar.Rl, false);
        C1488b.m6378c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, hsVar.versionCode);
        C1488b.m6366a(parcel, 2, hsVar.Rm, false);
        C1488b.m6355F(parcel, p);
    }

    public hs aI(Parcel parcel) {
        String str = null;
        int o = C1487a.m6340o(parcel);
        int i = 0;
        String str2 = null;
        while (parcel.dataPosition() < o) {
            int n = C1487a.m6338n(parcel);
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    str2 = C1487a.m6339n(parcel, n);
                    break;
                case Base64.NO_WRAP /*2*/:
                    str = C1487a.m6339n(parcel, n);
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
            return new hs(i, str2, str);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public hs[] bJ(int i) {
        return new hs[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aI(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bJ(x0);
    }
}
