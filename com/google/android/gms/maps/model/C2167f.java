package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C1488b;

/* renamed from: com.google.android.gms.maps.model.f */
public class C2167f {
    static void m9130a(MarkerOptions markerOptions, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, 1, markerOptions.getVersionCode());
        C1488b.m6363a(parcel, 2, markerOptions.getPosition(), i, false);
        C1488b.m6366a(parcel, 3, markerOptions.getTitle(), false);
        C1488b.m6366a(parcel, 4, markerOptions.getSnippet(), false);
        C1488b.m6361a(parcel, 5, markerOptions.iE(), false);
        C1488b.m6358a(parcel, 6, markerOptions.getAnchorU());
        C1488b.m6358a(parcel, 7, markerOptions.getAnchorV());
        C1488b.m6369a(parcel, 8, markerOptions.isDraggable());
        C1488b.m6369a(parcel, 9, markerOptions.isVisible());
        C1488b.m6355F(parcel, p);
    }
}
