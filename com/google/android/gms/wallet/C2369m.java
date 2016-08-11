package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

/* renamed from: com.google.android.gms.wallet.m */
public class C2369m implements Creator {
    static void m9699a(NotifyTransactionStatusRequest notifyTransactionStatusRequest, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, 1, notifyTransactionStatusRequest.xH);
        C1488b.m6366a(parcel, 2, notifyTransactionStatusRequest.abh, false);
        C1488b.m6378c(parcel, 3, notifyTransactionStatusRequest.status);
        C1488b.m6366a(parcel, 4, notifyTransactionStatusRequest.ach, false);
        C1488b.m6355F(parcel, p);
    }

    public NotifyTransactionStatusRequest bi(Parcel parcel) {
        String str = null;
        int i = 0;
        int o = C1487a.m6340o(parcel);
        String str2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < o) {
            int n = C1487a.m6338n(parcel);
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    i2 = C1487a.m6331g(parcel, n);
                    break;
                case Base64.NO_WRAP /*2*/:
                    str2 = C1487a.m6339n(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    i = C1487a.m6331g(parcel, n);
                    break;
                case Base64.CRLF /*4*/:
                    str = C1487a.m6339n(parcel, n);
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new NotifyTransactionStatusRequest(i2, str2, i, str);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bi(x0);
    }

    public NotifyTransactionStatusRequest[] cu(int i) {
        return new NotifyTransactionStatusRequest[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cu(x0);
    }
}
