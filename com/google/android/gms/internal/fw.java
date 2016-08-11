package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.mopub.mobileads.util.Base64;

public class fw implements Creator {
    static void m8534a(fv fvVar, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, 1, fvVar.getVersionCode());
        C1488b.m6363a(parcel, 2, fvVar.eT(), i, false);
        C1488b.m6355F(parcel, p);
    }

    public fv[] m8535S(int i) {
        return new fv[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m8536q(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m8535S(x0);
    }

    public fv m8536q(Parcel parcel) {
        int o = C1487a.m6340o(parcel);
        int i = 0;
        fx fxVar = null;
        while (parcel.dataPosition() < o) {
            int n = C1487a.m6338n(parcel);
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    i = C1487a.m6331g(parcel, n);
                    break;
                case Base64.NO_WRAP /*2*/:
                    fxVar = (fx) C1487a.m6320a(parcel, n, fx.CREATOR);
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new fv(i, fxVar);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }
}
