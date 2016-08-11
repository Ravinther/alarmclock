package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.millennialmedia.android.C2513R;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

public class MarkerOptionsCreator implements Creator {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m9112a(MarkerOptions markerOptions, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, 1, markerOptions.getVersionCode());
        C1488b.m6363a(parcel, 2, markerOptions.getPosition(), i, false);
        C1488b.m6366a(parcel, 3, markerOptions.getTitle(), false);
        C1488b.m6366a(parcel, 4, markerOptions.getSnippet(), false);
        C1488b.m6361a(parcel, 5, markerOptions.iE(), false);
        C1488b.m6358a(parcel, 6, markerOptions.getAnchorU());
        C1488b.m6358a(parcel, 7, markerOptions.getAnchorV());
        C1488b.m6369a(parcel, 8, markerOptions.isDraggable());
        C1488b.m6369a(parcel, 9, markerOptions.isVisible());
        C1488b.m6369a(parcel, 10, markerOptions.isFlat());
        C1488b.m6358a(parcel, 11, markerOptions.getRotation());
        C1488b.m6358a(parcel, 12, markerOptions.getInfoWindowAnchorU());
        C1488b.m6358a(parcel, 13, markerOptions.getInfoWindowAnchorV());
        C1488b.m6358a(parcel, 14, markerOptions.getAlpha());
        C1488b.m6355F(parcel, p);
    }

    public MarkerOptions createFromParcel(Parcel parcel) {
        int o = C1487a.m6340o(parcel);
        int i = 0;
        LatLng latLng = null;
        String str = null;
        String str2 = null;
        IBinder iBinder = null;
        float f = 0.0f;
        float f2 = 0.0f;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        float f3 = 0.0f;
        float f4 = 0.5f;
        float f5 = 0.0f;
        float f6 = 1.0f;
        while (parcel.dataPosition() < o) {
            int n = C1487a.m6338n(parcel);
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    i = C1487a.m6331g(parcel, n);
                    break;
                case Base64.NO_WRAP /*2*/:
                    latLng = (LatLng) C1487a.m6320a(parcel, n, LatLng.CREATOR);
                    break;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    str = C1487a.m6339n(parcel, n);
                    break;
                case Base64.CRLF /*4*/:
                    str2 = C1487a.m6339n(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    iBinder = C1487a.m6341o(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                    f = C1487a.m6335k(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                    f2 = C1487a.m6335k(parcel, n);
                    break;
                case Base64.URL_SAFE /*8*/:
                    z = C1487a.m6327c(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor /*9*/:
                    z2 = C1487a.m6327c(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                    z3 = C1487a.m6327c(parcel, n);
                    break;
                case C2625R.styleable.MapAttrs_uiZoomGestures /*11*/:
                    f3 = C1487a.m6335k(parcel, n);
                    break;
                case C2625R.styleable.MapAttrs_useViewLifecycle /*12*/:
                    f4 = C1487a.m6335k(parcel, n);
                    break;
                case C2625R.styleable.MapAttrs_zOrderOnTop /*13*/:
                    f5 = C1487a.m6335k(parcel, n);
                    break;
                case C2513R.styleable.MMAdView_height /*14*/:
                    f6 = C1487a.m6335k(parcel, n);
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new MarkerOptions(i, latLng, str, str2, iBinder, f, f2, z, z2, z3, f3, f4, f5, f6);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public MarkerOptions[] newArray(int size) {
        return new MarkerOptions[size];
    }
}
