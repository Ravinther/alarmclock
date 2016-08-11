package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

public class StreetViewPanoramaLinkCreator implements Creator {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m9116a(StreetViewPanoramaLink streetViewPanoramaLink, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, 1, streetViewPanoramaLink.getVersionCode());
        C1488b.m6366a(parcel, 2, streetViewPanoramaLink.panoId, false);
        C1488b.m6358a(parcel, 3, streetViewPanoramaLink.bearing);
        C1488b.m6355F(parcel, p);
    }

    public StreetViewPanoramaLink createFromParcel(Parcel parcel) {
        int o = C1487a.m6340o(parcel);
        int i = 0;
        String str = null;
        float f = 0.0f;
        while (parcel.dataPosition() < o) {
            int n = C1487a.m6338n(parcel);
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    i = C1487a.m6331g(parcel, n);
                    break;
                case Base64.NO_WRAP /*2*/:
                    str = C1487a.m6339n(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    f = C1487a.m6335k(parcel, n);
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new StreetViewPanoramaLink(i, str, f);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public StreetViewPanoramaLink[] newArray(int size) {
        return new StreetViewPanoramaLink[size];
    }
}
