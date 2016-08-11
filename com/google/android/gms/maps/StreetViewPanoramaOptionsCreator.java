package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

public class StreetViewPanoramaOptionsCreator implements Creator {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m9058a(StreetViewPanoramaOptions streetViewPanoramaOptions, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, 1, streetViewPanoramaOptions.getVersionCode());
        C1488b.m6363a(parcel, 2, streetViewPanoramaOptions.getStreetViewPanoramaCamera(), i, false);
        C1488b.m6366a(parcel, 3, streetViewPanoramaOptions.getPanoramaId(), false);
        C1488b.m6363a(parcel, 4, streetViewPanoramaOptions.getPosition(), i, false);
        C1488b.m6365a(parcel, 5, streetViewPanoramaOptions.getRadius(), false);
        C1488b.m6356a(parcel, 6, streetViewPanoramaOptions.it());
        C1488b.m6356a(parcel, 7, streetViewPanoramaOptions.il());
        C1488b.m6356a(parcel, 8, streetViewPanoramaOptions.iu());
        C1488b.m6356a(parcel, 9, streetViewPanoramaOptions.iv());
        C1488b.m6356a(parcel, 10, streetViewPanoramaOptions.ih());
        C1488b.m6355F(parcel, p);
    }

    public StreetViewPanoramaOptions createFromParcel(Parcel parcel) {
        Integer num = null;
        byte b = (byte) 0;
        int o = C1487a.m6340o(parcel);
        byte b2 = (byte) 0;
        byte b3 = (byte) 0;
        byte b4 = (byte) 0;
        byte b5 = (byte) 0;
        LatLng latLng = null;
        String str = null;
        StreetViewPanoramaCamera streetViewPanoramaCamera = null;
        int i = 0;
        while (parcel.dataPosition() < o) {
            int n = C1487a.m6338n(parcel);
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    i = C1487a.m6331g(parcel, n);
                    break;
                case Base64.NO_WRAP /*2*/:
                    streetViewPanoramaCamera = (StreetViewPanoramaCamera) C1487a.m6320a(parcel, n, StreetViewPanoramaCamera.CREATOR);
                    break;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    str = C1487a.m6339n(parcel, n);
                    break;
                case Base64.CRLF /*4*/:
                    latLng = (LatLng) C1487a.m6320a(parcel, n, LatLng.CREATOR);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    num = C1487a.m6332h(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                    b5 = C1487a.m6329e(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                    b4 = C1487a.m6329e(parcel, n);
                    break;
                case Base64.URL_SAFE /*8*/:
                    b3 = C1487a.m6329e(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor /*9*/:
                    b2 = C1487a.m6329e(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                    b = C1487a.m6329e(parcel, n);
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new StreetViewPanoramaOptions(i, streetViewPanoramaCamera, str, latLng, num, b5, b4, b3, b2, b);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public StreetViewPanoramaOptions[] newArray(int size) {
        return new StreetViewPanoramaOptions[size];
    }
}
