package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

public class LatLngBoundsCreator implements Creator {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m9110a(LatLngBounds latLngBounds, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, 1, latLngBounds.getVersionCode());
        C1488b.m6363a(parcel, 2, latLngBounds.southwest, i, false);
        C1488b.m6363a(parcel, 3, latLngBounds.northeast, i, false);
        C1488b.m6355F(parcel, p);
    }

    public LatLngBounds createFromParcel(Parcel parcel) {
        LatLng latLng = null;
        int o = C1487a.m6340o(parcel);
        int i = 0;
        LatLng latLng2 = null;
        while (parcel.dataPosition() < o) {
            int g;
            LatLng latLng3;
            int n = C1487a.m6338n(parcel);
            LatLng latLng4;
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    latLng4 = latLng;
                    latLng = latLng2;
                    g = C1487a.m6331g(parcel, n);
                    latLng3 = latLng4;
                    break;
                case Base64.NO_WRAP /*2*/:
                    g = i;
                    latLng4 = (LatLng) C1487a.m6320a(parcel, n, LatLng.CREATOR);
                    latLng3 = latLng;
                    latLng = latLng4;
                    break;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    latLng3 = (LatLng) C1487a.m6320a(parcel, n, LatLng.CREATOR);
                    latLng = latLng2;
                    g = i;
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    latLng3 = latLng;
                    latLng = latLng2;
                    g = i;
                    break;
            }
            i = g;
            latLng2 = latLng;
            latLng = latLng3;
        }
        if (parcel.dataPosition() == o) {
            return new LatLngBounds(i, latLng2, latLng);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public LatLngBounds[] newArray(int size) {
        return new LatLngBounds[size];
    }
}
