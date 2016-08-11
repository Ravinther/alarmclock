package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

/* renamed from: com.google.android.gms.wallet.n */
public class C2370n implements Creator {
    static void m9700a(OfferWalletObject offerWalletObject, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, 1, offerWalletObject.getVersionCode());
        C1488b.m6366a(parcel, 2, offerWalletObject.eC, false);
        C1488b.m6366a(parcel, 3, offerWalletObject.acj, false);
        C1488b.m6355F(parcel, p);
    }

    public OfferWalletObject bj(Parcel parcel) {
        String str = null;
        int o = C1487a.m6340o(parcel);
        int i = 0;
        String str2 = null;
        while (parcel.dataPosition() < o) {
            int n = C1487a.m6338n(parcel);
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    i = C1487a.m6331g(parcel, n);
                    break;
                case Base64.NO_WRAP /*2*/:
                    str2 = C1487a.m6339n(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    str = C1487a.m6339n(parcel, n);
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new OfferWalletObject(i, str2, str);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bj(x0);
    }

    public OfferWalletObject[] cv(int i) {
        return new OfferWalletObject[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cv(x0);
    }
}
