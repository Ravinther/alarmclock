package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.mopub.mobileads.util.Base64;

/* renamed from: com.google.android.gms.wallet.e */
public class C2348e implements Creator {
    static void m9620a(C2347d c2347d, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, 1, c2347d.getVersionCode());
        C1488b.m6363a(parcel, 2, c2347d.abg, i, false);
        C1488b.m6355F(parcel, p);
    }

    public C2347d ba(Parcel parcel) {
        int o = C1487a.m6340o(parcel);
        int i = 0;
        LoyaltyWalletObject loyaltyWalletObject = null;
        while (parcel.dataPosition() < o) {
            int n = C1487a.m6338n(parcel);
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    i = C1487a.m6331g(parcel, n);
                    break;
                case Base64.NO_WRAP /*2*/:
                    loyaltyWalletObject = (LoyaltyWalletObject) C1487a.m6320a(parcel, n, LoyaltyWalletObject.CREATOR);
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C2347d(i, loyaltyWalletObject);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public C2347d[] cm(int i) {
        return new C2347d[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ba(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cm(x0);
    }
}
