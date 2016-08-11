package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.wallet.b */
public class C2345b implements Creator {
    static void m9618a(Cart cart, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, 1, cart.getVersionCode());
        C1488b.m6366a(parcel, 2, cart.abc, false);
        C1488b.m6366a(parcel, 3, cart.abd, false);
        C1488b.m6377b(parcel, 4, cart.abe, false);
        C1488b.m6355F(parcel, p);
    }

    public Cart aY(Parcel parcel) {
        String str = null;
        int o = C1487a.m6340o(parcel);
        int i = 0;
        ArrayList arrayList = new ArrayList();
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
                case Base64.CRLF /*4*/:
                    arrayList = C1487a.m6326c(parcel, n, LineItem.CREATOR);
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new Cart(i, str2, str, arrayList);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public Cart[] ck(int i) {
        return new Cart[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aY(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ck(x0);
    }
}
