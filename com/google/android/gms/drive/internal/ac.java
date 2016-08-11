package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.ConflictEvent;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

public class ac implements Creator {
    static void m6405a(OnEventResponse onEventResponse, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, 1, onEventResponse.xH);
        C1488b.m6378c(parcel, 2, onEventResponse.ES);
        C1488b.m6363a(parcel, 3, onEventResponse.FH, i, false);
        C1488b.m6363a(parcel, 4, onEventResponse.FI, i, false);
        C1488b.m6355F(parcel, p);
    }

    public OnEventResponse m6406Q(Parcel parcel) {
        ConflictEvent conflictEvent = null;
        int i = 0;
        int o = C1487a.m6340o(parcel);
        ChangeEvent changeEvent = null;
        int i2 = 0;
        while (parcel.dataPosition() < o) {
            ChangeEvent changeEvent2;
            int i3;
            ConflictEvent conflictEvent2;
            int n = C1487a.m6338n(parcel);
            ConflictEvent conflictEvent3;
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    conflictEvent3 = conflictEvent;
                    changeEvent2 = changeEvent;
                    i3 = i;
                    i = C1487a.m6331g(parcel, n);
                    conflictEvent2 = conflictEvent3;
                    break;
                case Base64.NO_WRAP /*2*/:
                    i = i2;
                    ChangeEvent changeEvent3 = changeEvent;
                    i3 = C1487a.m6331g(parcel, n);
                    conflictEvent2 = conflictEvent;
                    changeEvent2 = changeEvent3;
                    break;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    i3 = i;
                    i = i2;
                    conflictEvent3 = conflictEvent;
                    changeEvent2 = (ChangeEvent) C1487a.m6320a(parcel, n, ChangeEvent.CREATOR);
                    conflictEvent2 = conflictEvent3;
                    break;
                case Base64.CRLF /*4*/:
                    conflictEvent2 = (ConflictEvent) C1487a.m6320a(parcel, n, ConflictEvent.CREATOR);
                    changeEvent2 = changeEvent;
                    i3 = i;
                    i = i2;
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    conflictEvent2 = conflictEvent;
                    changeEvent2 = changeEvent;
                    i3 = i;
                    i = i2;
                    break;
            }
            i2 = i;
            i = i3;
            changeEvent = changeEvent2;
            conflictEvent = conflictEvent2;
        }
        if (parcel.dataPosition() == o) {
            return new OnEventResponse(i2, i, changeEvent, conflictEvent);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public OnEventResponse[] au(int i) {
        return new OnEventResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m6406Q(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return au(x0);
    }
}
