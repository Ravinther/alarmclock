package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

public class ad implements Creator {
    static void m6407a(OnListEntriesResponse onListEntriesResponse, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, 1, onListEntriesResponse.xH);
        C1488b.m6363a(parcel, 2, onListEntriesResponse.FJ, i, false);
        C1488b.m6369a(parcel, 3, onListEntriesResponse.Fg);
        C1488b.m6355F(parcel, p);
    }

    public OnListEntriesResponse m6408R(Parcel parcel) {
        boolean z = false;
        int o = C1487a.m6340o(parcel);
        DataHolder dataHolder = null;
        int i = 0;
        while (parcel.dataPosition() < o) {
            DataHolder dataHolder2;
            int g;
            boolean z2;
            int n = C1487a.m6338n(parcel);
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    boolean z3 = z;
                    dataHolder2 = dataHolder;
                    g = C1487a.m6331g(parcel, n);
                    z2 = z3;
                    break;
                case Base64.NO_WRAP /*2*/:
                    g = i;
                    DataHolder dataHolder3 = (DataHolder) C1487a.m6320a(parcel, n, DataHolder.CREATOR);
                    z2 = z;
                    dataHolder2 = dataHolder3;
                    break;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    z2 = C1487a.m6327c(parcel, n);
                    dataHolder2 = dataHolder;
                    g = i;
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    z2 = z;
                    dataHolder2 = dataHolder;
                    g = i;
                    break;
            }
            i = g;
            dataHolder = dataHolder2;
            z = z2;
        }
        if (parcel.dataPosition() == o) {
            return new OnListEntriesResponse(i, dataHolder, z);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public OnListEntriesResponse[] av(int i) {
        return new OnListEntriesResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m6408R(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return av(x0);
    }
}
