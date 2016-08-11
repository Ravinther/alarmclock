package com.google.android.gms.maps;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C1488b;

/* renamed from: com.google.android.gms.maps.a */
public class C2112a {
    static void m9064a(GoogleMapOptions googleMapOptions, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, 1, googleMapOptions.getVersionCode());
        C1488b.m6356a(parcel, 2, googleMapOptions.ig());
        C1488b.m6356a(parcel, 3, googleMapOptions.ih());
        C1488b.m6378c(parcel, 4, googleMapOptions.getMapType());
        C1488b.m6363a(parcel, 5, googleMapOptions.getCamera(), i, false);
        C1488b.m6356a(parcel, 6, googleMapOptions.ii());
        C1488b.m6356a(parcel, 7, googleMapOptions.ij());
        C1488b.m6356a(parcel, 8, googleMapOptions.ik());
        C1488b.m6356a(parcel, 9, googleMapOptions.il());
        C1488b.m6356a(parcel, 10, googleMapOptions.im());
        C1488b.m6356a(parcel, 11, googleMapOptions.in());
        C1488b.m6355F(parcel, p);
    }
}
