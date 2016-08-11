package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

public class CircleOptionsCreator implements Creator {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m9100a(CircleOptions circleOptions, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, 1, circleOptions.getVersionCode());
        C1488b.m6363a(parcel, 2, circleOptions.getCenter(), i, false);
        C1488b.m6357a(parcel, 3, circleOptions.getRadius());
        C1488b.m6358a(parcel, 4, circleOptions.getStrokeWidth());
        C1488b.m6378c(parcel, 5, circleOptions.getStrokeColor());
        C1488b.m6378c(parcel, 6, circleOptions.getFillColor());
        C1488b.m6358a(parcel, 7, circleOptions.getZIndex());
        C1488b.m6369a(parcel, 8, circleOptions.isVisible());
        C1488b.m6355F(parcel, p);
    }

    public CircleOptions createFromParcel(Parcel parcel) {
        float f = 0.0f;
        boolean z = false;
        int o = C1487a.m6340o(parcel);
        LatLng latLng = null;
        double d = 0.0d;
        int i = 0;
        int i2 = 0;
        float f2 = 0.0f;
        int i3 = 0;
        while (parcel.dataPosition() < o) {
            int n = C1487a.m6338n(parcel);
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    i3 = C1487a.m6331g(parcel, n);
                    break;
                case Base64.NO_WRAP /*2*/:
                    latLng = (LatLng) C1487a.m6320a(parcel, n, LatLng.CREATOR);
                    break;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    d = C1487a.m6336l(parcel, n);
                    break;
                case Base64.CRLF /*4*/:
                    f2 = C1487a.m6335k(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    i2 = C1487a.m6331g(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                    i = C1487a.m6331g(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                    f = C1487a.m6335k(parcel, n);
                    break;
                case Base64.URL_SAFE /*8*/:
                    z = C1487a.m6327c(parcel, n);
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new CircleOptions(i3, latLng, d, f2, i2, i, f, z);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public CircleOptions[] newArray(int size) {
        return new CircleOptions[size];
    }
}
