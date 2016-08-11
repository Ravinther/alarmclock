package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import com.google.android.gms.location.LocationStatusCodes;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

/* renamed from: com.google.android.gms.drive.query.a */
public class C1589a implements Creator {
    static void m6695a(Query query, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, query.xH);
        C1488b.m6363a(parcel, 1, query.GA, i, false);
        C1488b.m6366a(parcel, 3, query.GB, false);
        C1488b.m6363a(parcel, 4, query.GC, i, false);
        C1488b.m6355F(parcel, p);
    }

    public Query[] aG(int i) {
        return new Query[i];
    }

    public Query ac(Parcel parcel) {
        SortOrder sortOrder = null;
        int o = C1487a.m6340o(parcel);
        int i = 0;
        String str = null;
        LogicalFilter logicalFilter = null;
        while (parcel.dataPosition() < o) {
            int i2;
            LogicalFilter logicalFilter2;
            SortOrder sortOrder2;
            String str2;
            int n = C1487a.m6338n(parcel);
            SortOrder sortOrder3;
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    i2 = i;
                    String str3 = str;
                    logicalFilter2 = (LogicalFilter) C1487a.m6320a(parcel, n, LogicalFilter.CREATOR);
                    sortOrder2 = sortOrder;
                    str2 = str3;
                    break;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    logicalFilter2 = logicalFilter;
                    i2 = i;
                    sortOrder3 = sortOrder;
                    str2 = C1487a.m6339n(parcel, n);
                    sortOrder2 = sortOrder3;
                    break;
                case Base64.CRLF /*4*/:
                    sortOrder2 = (SortOrder) C1487a.m6320a(parcel, n, SortOrder.CREATOR);
                    str2 = str;
                    logicalFilter2 = logicalFilter;
                    i2 = i;
                    break;
                case LocationStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    sortOrder3 = sortOrder;
                    str2 = str;
                    logicalFilter2 = logicalFilter;
                    i2 = C1487a.m6331g(parcel, n);
                    sortOrder2 = sortOrder3;
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    sortOrder2 = sortOrder;
                    str2 = str;
                    logicalFilter2 = logicalFilter;
                    i2 = i;
                    break;
            }
            i = i2;
            logicalFilter = logicalFilter2;
            str = str2;
            sortOrder = sortOrder2;
        }
        if (parcel.dataPosition() == o) {
            return new Query(i, logicalFilter, str, sortOrder);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ac(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aG(x0);
    }
}
