package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.google.android.gms.internal.fc.C1889a;
import com.google.android.gms.location.LocationStatusCodes;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;
import java.util.List;

public class fp implements Creator {
    static void m8512a(C1889a c1889a, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6366a(parcel, 1, c1889a.getAccountName(), false);
        C1488b.m6378c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, c1889a.getVersionCode());
        C1488b.m6367a(parcel, 2, c1889a.eE(), false);
        C1488b.m6378c(parcel, 3, c1889a.eD());
        C1488b.m6366a(parcel, 4, c1889a.eG(), false);
        C1488b.m6355F(parcel, p);
    }

    public C1889a[] m8513Q(int i) {
        return new C1889a[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m8514m(x0);
    }

    public C1889a m8514m(Parcel parcel) {
        int i = 0;
        String str = null;
        int o = C1487a.m6340o(parcel);
        List list = null;
        String str2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < o) {
            int n = C1487a.m6338n(parcel);
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    str2 = C1487a.m6339n(parcel, n);
                    break;
                case Base64.NO_WRAP /*2*/:
                    list = C1487a.m6315A(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    i = C1487a.m6331g(parcel, n);
                    break;
                case Base64.CRLF /*4*/:
                    str = C1487a.m6339n(parcel, n);
                    break;
                case LocationStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i2 = C1487a.m6331g(parcel, n);
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C1889a(i2, str2, list, i, str);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m8513Q(x0);
    }
}
