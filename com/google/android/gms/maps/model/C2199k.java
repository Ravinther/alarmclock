package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C1488b;

/* renamed from: com.google.android.gms.maps.model.k */
public class C2199k {
    static void m9159a(VisibleRegion visibleRegion, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, 1, visibleRegion.getVersionCode());
        C1488b.m6363a(parcel, 2, visibleRegion.nearLeft, i, false);
        C1488b.m6363a(parcel, 3, visibleRegion.nearRight, i, false);
        C1488b.m6363a(parcel, 4, visibleRegion.farLeft, i, false);
        C1488b.m6363a(parcel, 5, visibleRegion.farRight, i, false);
        C1488b.m6363a(parcel, 6, visibleRegion.latLngBounds, i, false);
        C1488b.m6355F(parcel, p);
    }
}
