package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.google.android.gms.maps.model.CameraPosition;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

public class GoogleMapOptionsCreator implements Creator {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m9052a(GoogleMapOptions googleMapOptions, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, 1, googleMapOptions.getVersionCode());
        C1488b.m6356a(parcel, 2, googleMapOptions.ig());
        C1488b.m6356a(parcel, 3, googleMapOptions.ih());
        C1488b.m6378c(parcel, 4, googleMapOptions.getMapType());
        C1488b.m6363a(parcel, 5, googleMapOptions.getCamera(), i, false);
        C1488b.m6356a(parcel, 6, googleMapOptions.ii());
        C1488b.m6356a(parcel, 7, googleMapOptions.ij());
        C1488b.m6356a(parcel, 8, googleMapOptions.ik());
        C1488b.m6356a(parcel, 9, googleMapOptions.il());
        C1488b.m6356a(parcel, 10, googleMapOptions.im());
        C1488b.m6356a(parcel, 11, googleMapOptions.in());
        C1488b.m6355F(parcel, p);
    }

    public GoogleMapOptions createFromParcel(Parcel parcel) {
        byte b = (byte) 0;
        int o = C1487a.m6340o(parcel);
        CameraPosition cameraPosition = null;
        byte b2 = (byte) 0;
        byte b3 = (byte) 0;
        byte b4 = (byte) 0;
        byte b5 = (byte) 0;
        byte b6 = (byte) 0;
        int i = 0;
        byte b7 = (byte) 0;
        byte b8 = (byte) 0;
        int i2 = 0;
        while (parcel.dataPosition() < o) {
            int n = C1487a.m6338n(parcel);
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    i2 = C1487a.m6331g(parcel, n);
                    break;
                case Base64.NO_WRAP /*2*/:
                    b8 = C1487a.m6329e(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    b7 = C1487a.m6329e(parcel, n);
                    break;
                case Base64.CRLF /*4*/:
                    i = C1487a.m6331g(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    cameraPosition = (CameraPosition) C1487a.m6320a(parcel, n, CameraPosition.CREATOR);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                    b6 = C1487a.m6329e(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                    b5 = C1487a.m6329e(parcel, n);
                    break;
                case Base64.URL_SAFE /*8*/:
                    b4 = C1487a.m6329e(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor /*9*/:
                    b3 = C1487a.m6329e(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                    b2 = C1487a.m6329e(parcel, n);
                    break;
                case C2625R.styleable.MapAttrs_uiZoomGestures /*11*/:
                    b = C1487a.m6329e(parcel, n);
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new GoogleMapOptions(i2, b8, b7, i, cameraPosition, b6, b5, b4, b3, b2, b);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public GoogleMapOptions[] newArray(int size) {
        return new GoogleMapOptions[size];
    }
}
