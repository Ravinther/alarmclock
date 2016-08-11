package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.google.android.gms.internal.gd.C1913a;
import com.google.android.gms.internal.gd.C1914b;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;
import java.util.ArrayList;

public class gf implements Creator {
    static void m8577a(C1913a c1913a, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, 1, c1913a.versionCode);
        C1488b.m6366a(parcel, 2, c1913a.className, false);
        C1488b.m6377b(parcel, 3, c1913a.El, false);
        C1488b.m6355F(parcel, p);
    }

    public C1913a[] m8578Y(int i) {
        return new C1913a[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m8579w(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m8578Y(x0);
    }

    public C1913a m8579w(Parcel parcel) {
        ArrayList arrayList = null;
        int o = C1487a.m6340o(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < o) {
            int n = C1487a.m6338n(parcel);
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    i = C1487a.m6331g(parcel, n);
                    break;
                case Base64.NO_WRAP /*2*/:
                    str = C1487a.m6339n(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    arrayList = C1487a.m6326c(parcel, n, C1914b.CREATOR);
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C1913a(i, str, arrayList);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }
}
