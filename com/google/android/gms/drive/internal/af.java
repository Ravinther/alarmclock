package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.mopub.mobileads.util.Base64;

public class af implements Creator {
    static void m6411a(OnMetadataResponse onMetadataResponse, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, 1, onMetadataResponse.xH);
        C1488b.m6363a(parcel, 2, onMetadataResponse.EZ, i, false);
        C1488b.m6355F(parcel, p);
    }

    public OnMetadataResponse m6412T(Parcel parcel) {
        int o = C1487a.m6340o(parcel);
        int i = 0;
        MetadataBundle metadataBundle = null;
        while (parcel.dataPosition() < o) {
            int n = C1487a.m6338n(parcel);
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    i = C1487a.m6331g(parcel, n);
                    break;
                case Base64.NO_WRAP /*2*/:
                    metadataBundle = (MetadataBundle) C1487a.m6320a(parcel, n, MetadataBundle.CREATOR);
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new OnMetadataResponse(i, metadataBundle);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public OnMetadataResponse[] ax(int i) {
        return new OnMetadataResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m6412T(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ax(x0);
    }
}
