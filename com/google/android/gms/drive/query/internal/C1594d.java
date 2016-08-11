package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.google.android.gms.location.LocationStatusCodes;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

/* renamed from: com.google.android.gms.drive.query.internal.d */
public class C1594d implements Creator {
    static void m6700a(FilterHolder filterHolder, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6363a(parcel, 1, filterHolder.GK, i, false);
        C1488b.m6378c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, filterHolder.xH);
        C1488b.m6363a(parcel, 2, filterHolder.GL, i, false);
        C1488b.m6363a(parcel, 3, filterHolder.GM, i, false);
        C1488b.m6363a(parcel, 4, filterHolder.GN, i, false);
        C1488b.m6363a(parcel, 5, filterHolder.GO, i, false);
        C1488b.m6363a(parcel, 6, filterHolder.GP, i, false);
        C1488b.m6355F(parcel, p);
    }

    public FilterHolder[] aL(int i) {
        return new FilterHolder[i];
    }

    public FilterHolder ah(Parcel parcel) {
        MatchAllFilter matchAllFilter = null;
        int o = C1487a.m6340o(parcel);
        int i = 0;
        InFilter inFilter = null;
        NotFilter notFilter = null;
        LogicalFilter logicalFilter = null;
        FieldOnlyFilter fieldOnlyFilter = null;
        ComparisonFilter comparisonFilter = null;
        while (parcel.dataPosition() < o) {
            int n = C1487a.m6338n(parcel);
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    comparisonFilter = (ComparisonFilter) C1487a.m6320a(parcel, n, ComparisonFilter.CREATOR);
                    break;
                case Base64.NO_WRAP /*2*/:
                    fieldOnlyFilter = (FieldOnlyFilter) C1487a.m6320a(parcel, n, FieldOnlyFilter.CREATOR);
                    break;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    logicalFilter = (LogicalFilter) C1487a.m6320a(parcel, n, LogicalFilter.CREATOR);
                    break;
                case Base64.CRLF /*4*/:
                    notFilter = (NotFilter) C1487a.m6320a(parcel, n, NotFilter.CREATOR);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    inFilter = (InFilter) C1487a.m6320a(parcel, n, InFilter.CREATOR);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                    matchAllFilter = (MatchAllFilter) C1487a.m6320a(parcel, n, MatchAllFilter.CREATOR);
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
            return new FilterHolder(i, comparisonFilter, fieldOnlyFilter, logicalFilter, notFilter, inFilter, matchAllFilter);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ah(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aL(x0);
    }
}
