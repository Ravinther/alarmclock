package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C1488b;

/* renamed from: com.google.android.gms.maps.model.c */
public class C2164c {
    static void m9127a(GroundOverlayOptions groundOverlayOptions, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, 1, groundOverlayOptions.getVersionCode());
        C1488b.m6361a(parcel, 2, groundOverlayOptions.iD(), false);
        C1488b.m6363a(parcel, 3, groundOverlayOptions.getLocation(), i, false);
        C1488b.m6358a(parcel, 4, groundOverlayOptions.getWidth());
        C1488b.m6358a(parcel, 5, groundOverlayOptions.getHeight());
        C1488b.m6363a(parcel, 6, groundOverlayOptions.getBounds(), i, false);
        C1488b.m6358a(parcel, 7, groundOverlayOptions.getBearing());
        C1488b.m6358a(parcel, 8, groundOverlayOptions.getZIndex());
        C1488b.m6369a(parcel, 9, groundOverlayOptions.isVisible());
        C1488b.m6358a(parcel, 10, groundOverlayOptions.getTransparency());
        C1488b.m6358a(parcel, 11, groundOverlayOptions.getAnchorU());
        C1488b.m6358a(parcel, 12, groundOverlayOptions.getAnchorV());
        C1488b.m6355F(parcel, p);
    }
}
