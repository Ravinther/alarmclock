package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.google.android.gms.drive.DriveId;
import com.mopub.mobileads.util.Base64;

/* renamed from: com.google.android.gms.drive.internal.x */
public class C1573x implements Creator {
    static void m6612a(ListParentsRequest listParentsRequest, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, 1, listParentsRequest.xH);
        C1488b.m6363a(parcel, 2, listParentsRequest.FB, i, false);
        C1488b.m6355F(parcel, p);
    }

    public ListParentsRequest m6613M(Parcel parcel) {
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
            return new ListParentsRequest(i, driveId);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public ListParentsRequest[] aq(int i) {
        return new ListParentsRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m6613M(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aq(x0);
    }
}
