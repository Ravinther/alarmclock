package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.google.android.gms.drive.query.internal.FieldWithSortOrder;
import com.google.android.gms.location.LocationStatusCodes;
import com.mopub.mobileads.util.Base64;
import java.util.List;

/* renamed from: com.google.android.gms.drive.query.b */
public class C1590b implements Creator {
    static void m6696a(SortOrder sortOrder, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, sortOrder.xH);
        C1488b.m6377b(parcel, 1, sortOrder.GF, false);
        C1488b.m6355F(parcel, p);
    }

    public SortOrder[] aH(int i) {
        return new SortOrder[i];
    }

    public SortOrder ad(Parcel parcel) {
        int o = C1487a.m6340o(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < o) {
            int n = C1487a.m6338n(parcel);
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    list = C1487a.m6326c(parcel, n, FieldWithSortOrder.CREATOR);
                    break;
                case LocationStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i = C1487a.m6331g(parcel, n);
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new SortOrder(i, list);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ad(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aH(x0);
    }
}
