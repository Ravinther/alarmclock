package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C1488b;

/* renamed from: com.google.android.gms.maps.model.i */
public class C2170i {
    static void m9133a(Tile tile, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, 1, tile.getVersionCode());
        C1488b.m6378c(parcel, 2, tile.width);
        C1488b.m6378c(parcel, 3, tile.height);
        C1488b.m6370a(parcel, 4, tile.data, false);
        C1488b.m6355F(parcel, p);
    }
}
