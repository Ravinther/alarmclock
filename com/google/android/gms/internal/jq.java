package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

public class jq implements Creator {
    static void m8885a(jp jpVar, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, 1, jpVar.getVersionCode());
        C1488b.m6378c(parcel, 2, jpVar.adh);
        C1488b.m6366a(parcel, 3, jpVar.adi, false);
        C1488b.m6357a(parcel, 4, jpVar.adj);
        C1488b.m6366a(parcel, 5, jpVar.adk, false);
        C1488b.m6359a(parcel, 6, jpVar.adl);
        C1488b.m6378c(parcel, 7, jpVar.adm);
        C1488b.m6355F(parcel, p);
    }

    public jp bs(Parcel parcel) {
        String str = null;
        int i = 0;
        int o = C1487a.m6340o(parcel);
        double d = 0.0d;
        long j = 0;
        int i2 = -1;
        String str2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < o) {
            int n = C1487a.m6338n(parcel);
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    i3 = C1487a.m6331g(parcel, n);
                    break;
                case Base64.NO_WRAP /*2*/:
                    i = C1487a.m6331g(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    str2 = C1487a.m6339n(parcel, n);
                    break;
                case Base64.CRLF /*4*/:
                    d = C1487a.m6336l(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    str = C1487a.m6339n(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                    j = C1487a.m6333i(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                    i2 = C1487a.m6331g(parcel, n);
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new jp(i3, i, str2, d, str, j, i2);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public jp[] cG(int i) {
        return new jp[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bs(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cG(x0);
    }
}
