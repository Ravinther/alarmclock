package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.google.android.gms.location.LocationStatusCodes;
import com.mopub.mobileads.util.Base64;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.drive.query.internal.g */
public class C1597g implements Creator {
    static void m6703a(LogicalFilter logicalFilter, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, logicalFilter.xH);
        C1488b.m6363a(parcel, 1, logicalFilter.GG, i, false);
        C1488b.m6377b(parcel, 2, logicalFilter.GS, false);
        C1488b.m6355F(parcel, p);
    }

    public LogicalFilter[] aN(int i) {
        return new LogicalFilter[i];
    }

    public LogicalFilter aj(Parcel parcel) {
        List list = null;
        int o = C1487a.m6340o(parcel);
        int i = 0;
        Operator operator = null;
        while (parcel.dataPosition() < o) {
            int i2;
            Operator operator2;
            ArrayList c;
            int n = C1487a.m6338n(parcel);
            List list2;
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    i2 = i;
                    Operator operator3 = (Operator) C1487a.m6320a(parcel, n, Operator.CREATOR);
                    list2 = list;
                    operator2 = operator3;
                    break;
                case Base64.NO_WRAP /*2*/:
                    c = C1487a.m6326c(parcel, n, FilterHolder.CREATOR);
                    operator2 = operator;
                    i2 = i;
                    break;
                case LocationStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    List list3 = list;
                    operator2 = operator;
                    i2 = C1487a.m6331g(parcel, n);
                    list2 = list3;
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    c = list;
                    operator2 = operator;
                    i2 = i;
                    break;
            }
            i = i2;
            operator = operator2;
            Object obj = c;
        }
        if (parcel.dataPosition() == o) {
            return new LogicalFilter(i, operator, list);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aj(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aN(x0);
    }
}
