package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

public class GroundOverlayOptionsCreator implements Creator {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m9102a(GroundOverlayOptions groundOverlayOptions, Parcel parcel, int i) {
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

    public GroundOverlayOptions createFromParcel(Parcel parcel) {
        int o = C1487a.m6340o(parcel);
        int i = 0;
        IBinder iBinder = null;
        LatLng latLng = null;
        float f = 0.0f;
        float f2 = 0.0f;
        LatLngBounds latLngBounds = null;
        float f3 = 0.0f;
        float f4 = 0.0f;
        boolean z = false;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        while (parcel.dataPosition() < o) {
            int n = C1487a.m6338n(parcel);
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    i = C1487a.m6331g(parcel, n);
                    break;
                case Base64.NO_WRAP /*2*/:
                    iBinder = C1487a.m6341o(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    latLng = (LatLng) C1487a.m6320a(parcel, n, LatLng.CREATOR);
                    break;
                case Base64.CRLF /*4*/:
                    f = C1487a.m6335k(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    f2 = C1487a.m6335k(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                    latLngBounds = (LatLngBounds) C1487a.m6320a(parcel, n, LatLngBounds.CREATOR);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                    f3 = C1487a.m6335k(parcel, n);
                    break;
                case Base64.URL_SAFE /*8*/:
                    f4 = C1487a.m6335k(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor /*9*/:
                    z = C1487a.m6327c(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                    f5 = C1487a.m6335k(parcel, n);
                    break;
                case C2625R.styleable.MapAttrs_uiZoomGestures /*11*/:
                    f6 = C1487a.m6335k(parcel, n);
                    break;
                case C2625R.styleable.MapAttrs_useViewLifecycle /*12*/:
                    f7 = C1487a.m6335k(parcel, n);
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new GroundOverlayOptions(i, iBinder, latLng, f, f2, latLngBounds, f3, f4, z, f5, f6, f7);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public GroundOverlayOptions[] newArray(int size) {
        return new GroundOverlayOptions[size];
    }
}
