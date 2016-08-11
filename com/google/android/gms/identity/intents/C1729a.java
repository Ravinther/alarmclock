package com.google.android.gms.identity.intents;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import com.mopub.mobileads.util.Base64;
import java.util.List;

/* renamed from: com.google.android.gms.identity.intents.a */
public class C1729a implements Creator {
    static void m7780a(UserAddressRequest userAddressRequest, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, 1, userAddressRequest.getVersionCode());
        C1488b.m6377b(parcel, 2, userAddressRequest.Ny, false);
        C1488b.m6355F(parcel, p);
    }

    public UserAddressRequest ay(Parcel parcel) {
        int o = C1487a.m6340o(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < o) {
            int n = C1487a.m6338n(parcel);
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    i = C1487a.m6331g(parcel, n);
                    break;
                case Base64.NO_WRAP /*2*/:
                    list = C1487a.m6326c(parcel, n, CountrySpecification.CREATOR);
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new UserAddressRequest(i, list);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public UserAddressRequest[] bs(int i) {
        return new UserAddressRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ay(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bs(x0);
    }
}
