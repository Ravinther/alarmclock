package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.if */
public class C1981if implements Creator {
    static void m8767a(ie ieVar, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        Set ja = ieVar.ja();
        if (ja.contains(Integer.valueOf(1))) {
            C1488b.m6378c(parcel, 1, ieVar.getVersionCode());
        }
        if (ja.contains(Integer.valueOf(2))) {
            C1488b.m6366a(parcel, 2, ieVar.getId(), true);
        }
        if (ja.contains(Integer.valueOf(4))) {
            C1488b.m6363a(parcel, 4, ieVar.jr(), i, true);
        }
        if (ja.contains(Integer.valueOf(5))) {
            C1488b.m6366a(parcel, 5, ieVar.getStartDate(), true);
        }
        if (ja.contains(Integer.valueOf(6))) {
            C1488b.m6363a(parcel, 6, ieVar.js(), i, true);
        }
        if (ja.contains(Integer.valueOf(7))) {
            C1488b.m6366a(parcel, 7, ieVar.getType(), true);
        }
        C1488b.m6355F(parcel, p);
    }

    public ie aM(Parcel parcel) {
        String str = null;
        int o = C1487a.m6340o(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        ic icVar = null;
        String str2 = null;
        ic icVar2 = null;
        String str3 = null;
        while (parcel.dataPosition() < o) {
            int n = C1487a.m6338n(parcel);
            ic icVar3;
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    i = C1487a.m6331g(parcel, n);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case Base64.NO_WRAP /*2*/:
                    str3 = C1487a.m6339n(parcel, n);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case Base64.CRLF /*4*/:
                    icVar3 = (ic) C1487a.m6320a(parcel, n, ic.CREATOR);
                    hashSet.add(Integer.valueOf(4));
                    icVar2 = icVar3;
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    str2 = C1487a.m6339n(parcel, n);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                    icVar3 = (ic) C1487a.m6320a(parcel, n, ic.CREATOR);
                    hashSet.add(Integer.valueOf(6));
                    icVar = icVar3;
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                    str = C1487a.m6339n(parcel, n);
                    hashSet.add(Integer.valueOf(7));
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new ie(hashSet, i, str3, icVar2, str2, icVar, str);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public ie[] bP(int i) {
        return new ie[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aM(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bP(x0);
    }
}
