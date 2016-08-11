package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

public class kj implements Creator {
    static void m8898a(ki kiVar, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, 1, kiVar.xH);
        C1488b.m6378c(parcel, 2, kiVar.fA());
        C1488b.m6366a(parcel, 3, kiVar.getPath(), false);
        C1488b.m6370a(parcel, 4, kiVar.getData(), false);
        C1488b.m6366a(parcel, 5, kiVar.getSource(), false);
        C1488b.m6355F(parcel, p);
    }

    public ki by(Parcel parcel) {
        int i = 0;
        String str = null;
        int o = C1487a.m6340o(parcel);
        byte[] bArr = null;
        String str2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < o) {
            int n = C1487a.m6338n(parcel);
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    i2 = C1487a.m6331g(parcel, n);
                    break;
                case Base64.NO_WRAP /*2*/:
                    i = C1487a.m6331g(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    str2 = C1487a.m6339n(parcel, n);
                    break;
                case Base64.CRLF /*4*/:
                    bArr = C1487a.m6343q(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    str = C1487a.m6339n(parcel, n);
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new ki(i2, i, str2, bArr, str);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public ki[] cN(int i) {
        return new ki[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return by(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cN(x0);
    }
}
