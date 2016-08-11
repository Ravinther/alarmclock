package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.google.android.gms.drive.DriveId;
import com.mopub.mobileads.util.Base64;

/* renamed from: com.google.android.gms.drive.internal.t */
public class C1567t implements Creator {
    static void m6562a(GetMetadataRequest getMetadataRequest, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, 1, getMetadataRequest.xH);
        C1488b.m6363a(parcel, 2, getMetadataRequest.EV, i, false);
        C1488b.m6355F(parcel, p);
    }

    public GetMetadataRequest m6563L(Parcel parcel) {
        int o = C1487a.m6340o(parcel);
        int i = 0;
        DriveId driveId = null;
        while (parcel.dataPosition() < o) {
            int n = C1487a.m6338n(parcel);
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    i = C1487a.m6331g(parcel, n);
                    break;
                case Base64.NO_WRAP /*2*/:
                    driveId = (DriveId) C1487a.m6320a(parcel, n, DriveId.CREATOR);
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new GetMetadataRequest(i, driveId);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public GetMetadataRequest[] ap(int i) {
        return new GetMetadataRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m6563L(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ap(x0);
    }
}
