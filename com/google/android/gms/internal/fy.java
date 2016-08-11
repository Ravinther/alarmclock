package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.google.android.gms.internal.fx.C1909a;
import com.mopub.mobileads.util.Base64;
import java.util.ArrayList;

public class fy implements Creator {
    static void m8542a(fx fxVar, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, 1, fxVar.getVersionCode());
        C1488b.m6377b(parcel, 2, fxVar.eV(), false);
        C1488b.m6355F(parcel, p);
    }

    public fx[] m8543T(int i) {
        return new fx[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m8544r(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m8543T(x0);
    }

    public fx m8544r(Parcel parcel) {
        int o = C1487a.m6340o(parcel);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < o) {
            int n = C1487a.m6338n(parcel);
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    i = C1487a.m6331g(parcel, n);
                    break;
                case Base64.NO_WRAP /*2*/:
                    arrayList = C1487a.m6326c(parcel, n, C1909a.CREATOR);
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new fx(i, arrayList);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }
}
