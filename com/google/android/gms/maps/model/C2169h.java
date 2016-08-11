package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C1488b;

/* renamed from: com.google.android.gms.maps.model.h */
public class C2169h {
    static void m9132a(PolylineOptions polylineOptions, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, 1, polylineOptions.getVersionCode());
        C1488b.m6377b(parcel, 2, polylineOptions.getPoints(), false);
        C1488b.m6358a(parcel, 3, polylineOptions.getWidth());
        C1488b.m6378c(parcel, 4, polylineOptions.getColor());
        C1488b.m6358a(parcel, 5, polylineOptions.getZIndex());
        C1488b.m6369a(parcel, 6, polylineOptions.isVisible());
        C1488b.m6369a(parcel, 7, polylineOptions.isGeodesic());
        C1488b.m6355F(parcel, p);
    }
}
