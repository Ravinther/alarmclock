package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

public class VisibleRegionCreator implements Creator {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m9124a(VisibleRegion visibleRegion, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, 1, visibleRegion.getVersionCode());
        C1488b.m6363a(parcel, 2, visibleRegion.nearLeft, i, false);
        C1488b.m6363a(parcel, 3, visibleRegion.nearRight, i, false);
        C1488b.m6363a(parcel, 4, visibleRegion.farLeft, i, false);
        C1488b.m6363a(parcel, 5, visibleRegion.farRight, i, false);
        C1488b.m6363a(parcel, 6, visibleRegion.latLngBounds, i, false);
        C1488b.m6355F(parcel, p);
    }

    public VisibleRegion createFromParcel(Parcel parcel) {
        LatLngBounds latLngBounds = null;
        int o = C1487a.m6340o(parcel);
        int i = 0;
        LatLng latLng = null;
        LatLng latLng2 = null;
        LatLng latLng3 = null;
        LatLng latLng4 = null;
        while (parcel.dataPosition() < o) {
            int n = C1487a.m6338n(parcel);
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    i = C1487a.m6331g(parcel, n);
                    break;
                case Base64.NO_WRAP /*2*/:
                    latLng4 = (LatLng) C1487a.m6320a(parcel, n, LatLng.CREATOR);
                    break;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    latLng3 = (LatLng) C1487a.m6320a(parcel, n, LatLng.CREATOR);
                    break;
                case Base64.CRLF /*4*/:
                    latLng2 = (LatLng) C1487a.m6320a(parcel, n, LatLng.CREATOR);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    latLng = (LatLng) C1487a.m6320a(parcel, n, LatLng.CREATOR);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                    latLngBounds = (LatLngBounds) C1487a.m6320a(parcel, n, LatLngBounds.CREATOR);
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new VisibleRegion(i, latLng4, latLng3, latLng2, latLng, latLngBounds);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public VisibleRegion[] newArray(int size) {
        return new VisibleRegion[size];
    }
}
