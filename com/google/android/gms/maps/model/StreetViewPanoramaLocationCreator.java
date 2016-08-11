package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

public class StreetViewPanoramaLocationCreator implements Creator {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m9117a(StreetViewPanoramaLocation streetViewPanoramaLocation, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, 1, streetViewPanoramaLocation.getVersionCode());
        C1488b.m6372a(parcel, 2, streetViewPanoramaLocation.links, i, false);
        C1488b.m6363a(parcel, 3, streetViewPanoramaLocation.position, i, false);
        C1488b.m6366a(parcel, 4, streetViewPanoramaLocation.panoId, false);
        C1488b.m6355F(parcel, p);
    }

    public StreetViewPanoramaLocation createFromParcel(Parcel parcel) {
        String str = null;
        int o = C1487a.m6340o(parcel);
        int i = 0;
        LatLng latLng = null;
        StreetViewPanoramaLink[] streetViewPanoramaLinkArr = null;
        while (parcel.dataPosition() < o) {
            LatLng latLng2;
            StreetViewPanoramaLink[] streetViewPanoramaLinkArr2;
            int g;
            String str2;
            int n = C1487a.m6338n(parcel);
            String str3;
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    str3 = str;
                    latLng2 = latLng;
                    streetViewPanoramaLinkArr2 = streetViewPanoramaLinkArr;
                    g = C1487a.m6331g(parcel, n);
                    str2 = str3;
                    break;
                case Base64.NO_WRAP /*2*/:
                    g = i;
                    LatLng latLng3 = latLng;
                    streetViewPanoramaLinkArr2 = (StreetViewPanoramaLink[]) C1487a.m6325b(parcel, n, StreetViewPanoramaLink.CREATOR);
                    str2 = str;
                    latLng2 = latLng3;
                    break;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    streetViewPanoramaLinkArr2 = streetViewPanoramaLinkArr;
                    g = i;
                    str3 = str;
                    latLng2 = (LatLng) C1487a.m6320a(parcel, n, LatLng.CREATOR);
                    str2 = str3;
                    break;
                case Base64.CRLF /*4*/:
                    str2 = C1487a.m6339n(parcel, n);
                    latLng2 = latLng;
                    streetViewPanoramaLinkArr2 = streetViewPanoramaLinkArr;
                    g = i;
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    str2 = str;
                    latLng2 = latLng;
                    streetViewPanoramaLinkArr2 = streetViewPanoramaLinkArr;
                    g = i;
                    break;
            }
            i = g;
            streetViewPanoramaLinkArr = streetViewPanoramaLinkArr2;
            latLng = latLng2;
            str = str2;
        }
        if (parcel.dataPosition() == o) {
            return new StreetViewPanoramaLocation(i, streetViewPanoramaLinkArr, latLng, str);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public StreetViewPanoramaLocation[] newArray(int size) {
        return new StreetViewPanoramaLocation[size];
    }
}
