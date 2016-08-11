package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;
import java.util.ArrayList;
import java.util.List;

public class PolygonOptionsCreator implements Creator {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m9113a(PolygonOptions polygonOptions, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, 1, polygonOptions.getVersionCode());
        C1488b.m6377b(parcel, 2, polygonOptions.getPoints(), false);
        C1488b.m6379c(parcel, 3, polygonOptions.iF(), false);
        C1488b.m6358a(parcel, 4, polygonOptions.getStrokeWidth());
        C1488b.m6378c(parcel, 5, polygonOptions.getStrokeColor());
        C1488b.m6378c(parcel, 6, polygonOptions.getFillColor());
        C1488b.m6358a(parcel, 7, polygonOptions.getZIndex());
        C1488b.m6369a(parcel, 8, polygonOptions.isVisible());
        C1488b.m6369a(parcel, 9, polygonOptions.isGeodesic());
        C1488b.m6355F(parcel, p);
    }

    public PolygonOptions createFromParcel(Parcel parcel) {
        float f = 0.0f;
        boolean z = false;
        int o = C1487a.m6340o(parcel);
        List list = null;
        List arrayList = new ArrayList();
        boolean z2 = false;
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
                    list = C1487a.m6326c(parcel, n, LatLng.CREATOR);
                    break;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    C1487a.m6323a(parcel, n, arrayList, getClass().getClassLoader());
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
                    z2 = C1487a.m6327c(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor /*9*/:
                    z = C1487a.m6327c(parcel, n);
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new PolygonOptions(i3, list, arrayList, f2, i2, i, f, z2, z);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public PolygonOptions[] newArray(int size) {
        return new PolygonOptions[size];
    }
}
