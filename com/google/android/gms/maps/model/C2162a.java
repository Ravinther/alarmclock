package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C1488b;

/* renamed from: com.google.android.gms.maps.model.a */
public class C2162a {
    static void m9125a(CameraPosition cameraPosition, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, 1, cameraPosition.getVersionCode());
        C1488b.m6363a(parcel, 2, cameraPosition.target, i, false);
        C1488b.m6358a(parcel, 3, cameraPosition.zoom);
        C1488b.m6358a(parcel, 4, cameraPosition.tilt);
        C1488b.m6358a(parcel, 5, cameraPosition.bearing);
        C1488b.m6355F(parcel, p);
    }
}
