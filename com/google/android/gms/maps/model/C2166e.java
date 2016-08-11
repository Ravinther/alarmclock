package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C1488b;

/* renamed from: com.google.android.gms.maps.model.e */
public class C2166e {
    static void m9129a(LatLng latLng, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, 1, latLng.getVersionCode());
        C1488b.m6357a(parcel, 2, latLng.latitude);
        C1488b.m6357a(parcel, 3, latLng.longitude);
        C1488b.m6355F(parcel, p);
    }
}
