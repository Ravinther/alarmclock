package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

public class TileCreator implements Creator {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m9119a(Tile tile, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, 1, tile.getVersionCode());
        C1488b.m6378c(parcel, 2, tile.width);
        C1488b.m6378c(parcel, 3, tile.height);
        C1488b.m6370a(parcel, 4, tile.data, false);
        C1488b.m6355F(parcel, p);
    }

    public Tile createFromParcel(Parcel parcel) {
        int i = 0;
        int o = C1487a.m6340o(parcel);
        byte[] bArr = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < o) {
            int n = C1487a.m6338n(parcel);
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    i3 = C1487a.m6331g(parcel, n);
                    break;
                case Base64.NO_WRAP /*2*/:
                    i2 = C1487a.m6331g(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    i = C1487a.m6331g(parcel, n);
                    break;
                case Base64.CRLF /*4*/:
                    bArr = C1487a.m6343q(parcel, n);
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new Tile(i3, i2, i, bArr);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public Tile[] newArray(int size) {
        return new Tile[size];
    }
}
