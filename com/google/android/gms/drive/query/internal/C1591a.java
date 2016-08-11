package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.location.LocationStatusCodes;
import com.mopub.mobileads.util.Base64;

/* renamed from: com.google.android.gms.drive.query.internal.a */
public class C1591a implements Creator {
    static void m6697a(ComparisonFilter comparisonFilter, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, comparisonFilter.xH);
        C1488b.m6363a(parcel, 1, comparisonFilter.GG, i, false);
        C1488b.m6363a(parcel, 2, comparisonFilter.GH, i, false);
        C1488b.m6355F(parcel, p);
    }

    public ComparisonFilter[] aI(int i) {
        return new ComparisonFilter[i];
    }

    public ComparisonFilter ae(Parcel parcel) {
        MetadataBundle metadataBundle = null;
        int o = C1487a.m6340o(parcel);
        int i = 0;
        Operator operator = null;
        while (parcel.dataPosition() < o) {
            int i2;
            MetadataBundle metadataBundle2;
            Operator operator2;
            int n = C1487a.m6338n(parcel);
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    i2 = i;
                    Operator operator3 = (Operator) C1487a.m6320a(parcel, n, Operator.CREATOR);
                    metadataBundle2 = metadataBundle;
                    operator2 = operator3;
                    break;
                case Base64.NO_WRAP /*2*/:
                    metadataBundle2 = (MetadataBundle) C1487a.m6320a(parcel, n, MetadataBundle.CREATOR);
                    operator2 = operator;
                    i2 = i;
                    break;
                case LocationStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    MetadataBundle metadataBundle3 = metadataBundle;
                    operator2 = operator;
                    i2 = C1487a.m6331g(parcel, n);
                    metadataBundle2 = metadataBundle3;
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    metadataBundle2 = metadataBundle;
                    operator2 = operator;
                    i2 = i;
                    break;
            }
            i = i2;
            operator = operator2;
            metadataBundle = metadataBundle2;
        }
        if (parcel.dataPosition() == o) {
            return new ComparisonFilter(i, operator, metadataBundle);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ae(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aI(x0);
    }
}
