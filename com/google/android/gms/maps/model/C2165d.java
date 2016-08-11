package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C1488b;

/* renamed from: com.google.android.gms.maps.model.d */
public class C2165d {
    static void m9128a(LatLngBounds latLngBounds, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, 1, latLngBounds.getVersionCode());
        C1488b.m6363a(parcel, 2, latLngBounds.southwest, i, false);
        C1488b.m6363a(parcel, 3, latLngBounds.northeast, i, false);
        C1488b.m6355F(parcel, p);
    }
}
