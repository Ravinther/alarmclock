package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.mopub.mobileads.util.Base64;

public class ag implements Creator {
    static void m6413a(OnSyncMoreResponse onSyncMoreResponse, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, 1, onSyncMoreResponse.xH);
        C1488b.m6369a(parcel, 2, onSyncMoreResponse.Fg);
        C1488b.m6355F(parcel, p);
    }

    public OnSyncMoreResponse m6414U(Parcel parcel) {
        boolean z = false;
        int o = C1487a.m6340o(parcel);
        int i = 0;
        while (parcel.dataPosition() < o) {
            int n = C1487a.m6338n(parcel);
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    i = C1487a.m6331g(parcel, n);
                    break;
                case Base64.NO_WRAP /*2*/:
                    z = C1487a.m6327c(parcel, n);
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new OnSyncMoreResponse(i, z);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public OnSyncMoreResponse[] ay(int i) {
        return new OnSyncMoreResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m6414U(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ay(x0);
    }
}
