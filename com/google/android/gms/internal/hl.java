package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationStatusCodes;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

public class hl implements Creator {
    static void m8692a(hk hkVar, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, hkVar.xH);
        C1488b.m6363a(parcel, 2, hkVar.hZ(), i, false);
        C1488b.m6359a(parcel, 3, hkVar.getInterval());
        C1488b.m6378c(parcel, 4, hkVar.getPriority());
        C1488b.m6355F(parcel, p);
    }

    public hk aF(Parcel parcel) {
        int o = C1487a.m6340o(parcel);
        int i = 0;
        hg hgVar = null;
        long j = hk.OF;
        int i2 = LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY;
        while (parcel.dataPosition() < o) {
            int n = C1487a.m6338n(parcel);
            switch (C1487a.m6318R(n)) {
                case Base64.NO_WRAP /*2*/:
                    hgVar = (hg) C1487a.m6320a(parcel, n, hg.CREATOR);
                    break;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    j = C1487a.m6333i(parcel, n);
                    break;
                case Base64.CRLF /*4*/:
                    i2 = C1487a.m6331g(parcel, n);
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
            return new hk(i, hgVar, j, i2);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public hk[] bG(int i) {
        return new hk[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aF(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bG(x0);
    }
}
