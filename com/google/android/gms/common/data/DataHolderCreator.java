package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.google.android.gms.location.LocationStatusCodes;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

public class DataHolderCreator implements Creator {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m6274a(DataHolder dataHolder, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6373a(parcel, 1, dataHolder.er(), false);
        C1488b.m6378c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, dataHolder.getVersionCode());
        C1488b.m6372a(parcel, 2, dataHolder.es(), i, false);
        C1488b.m6378c(parcel, 3, dataHolder.getStatusCode());
        C1488b.m6360a(parcel, 4, dataHolder.getMetadata(), false);
        C1488b.m6355F(parcel, p);
    }

    public DataHolder createFromParcel(Parcel parcel) {
        int i = 0;
        Bundle bundle = null;
        int o = C1487a.m6340o(parcel);
        CursorWindow[] cursorWindowArr = null;
        String[] strArr = null;
        int i2 = 0;
        while (parcel.dataPosition() < o) {
            int n = C1487a.m6338n(parcel);
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    strArr = C1487a.m6352z(parcel, n);
                    break;
                case Base64.NO_WRAP /*2*/:
                    cursorWindowArr = (CursorWindow[]) C1487a.m6325b(parcel, n, CursorWindow.CREATOR);
                    break;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    i = C1487a.m6331g(parcel, n);
                    break;
                case Base64.CRLF /*4*/:
                    bundle = C1487a.m6342p(parcel, n);
                    break;
                case LocationStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i2 = C1487a.m6331g(parcel, n);
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() != o) {
            throw new C1486a("Overread allowed size end=" + o, parcel);
        }
        DataHolder dataHolder = new DataHolder(i2, strArr, cursorWindowArr, i, bundle);
        dataHolder.validateContents();
        return dataHolder;
    }

    public DataHolder[] newArray(int size) {
        return new DataHolder[size];
    }
}
