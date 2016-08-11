package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C1488b;

/* renamed from: com.google.android.gms.maps.model.b */
public class C2163b {
    static void m9126a(CircleOptions circleOptions, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, 1, circleOptions.getVersionCode());
        C1488b.m6363a(parcel, 2, circleOptions.getCenter(), i, false);
        C1488b.m6357a(parcel, 3, circleOptions.getRadius());
        C1488b.m6358a(parcel, 4, circleOptions.getStrokeWidth());
        C1488b.m6378c(parcel, 5, circleOptions.getStrokeColor());
        C1488b.m6378c(parcel, 6, circleOptions.getFillColor());
        C1488b.m6358a(parcel, 7, circleOptions.getZIndex());
        C1488b.m6369a(parcel, 8, circleOptions.isVisible());
        C1488b.m6355F(parcel, p);
    }
}
