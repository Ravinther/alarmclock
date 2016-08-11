package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.google.android.gms.location.LocationStatusCodes;
import com.mopub.mobileads.util.Base64;

/* renamed from: com.google.android.gms.drive.query.internal.j */
public class C1600j implements Creator {
    static void m6706a(Operator operator, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, operator.xH);
        C1488b.m6366a(parcel, 1, operator.mTag, false);
        C1488b.m6355F(parcel, p);
    }

    public Operator[] aQ(int i) {
        return new Operator[i];
    }

    public Operator am(Parcel parcel) {
        int o = C1487a.m6340o(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < o) {
            int n = C1487a.m6338n(parcel);
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    str = C1487a.m6339n(parcel, n);
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
            return new Operator(i, str);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return am(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aQ(x0);
    }
}
