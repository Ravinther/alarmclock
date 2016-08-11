package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C1488b;

/* renamed from: com.google.android.gms.maps.model.j */
public class C2198j {
    static void m9158a(TileOverlayOptions tileOverlayOptions, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, 1, tileOverlayOptions.getVersionCode());
        C1488b.m6361a(parcel, 2, tileOverlayOptions.iG(), false);
        C1488b.m6369a(parcel, 3, tileOverlayOptions.isVisible());
        C1488b.m6358a(parcel, 4, tileOverlayOptions.getZIndex());
        C1488b.m6355F(parcel, p);
    }
}
