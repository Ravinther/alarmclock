package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C1488b;

/* renamed from: com.google.android.gms.maps.model.g */
public class C2168g {
    static void m9131a(PolygonOptions polygonOptions, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, 1, polygonOptions.getVersionCode());
        C1488b.m6377b(parcel, 2, polygonOptions.getPoints(), false);
        C1488b.m6379c(parcel, 3, polygonOptions.iF(), false);
        C1488b.m6358a(parcel, 4, polygonOptions.getStrokeWidth());
        C1488b.m6378c(parcel, 5, polygonOptions.getStrokeColor());
        C1488b.m6378c(parcel, 6, polygonOptions.getFillColor());
        C1488b.m6358a(parcel, 7, polygonOptions.getZIndex());
        C1488b.m6369a(parcel, 8, polygonOptions.isVisible());
        C1488b.m6369a(parcel, 9, polygonOptions.isGeodesic());
        C1488b.m6355F(parcel, p);
    }
}
