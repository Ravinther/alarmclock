package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.google.android.gms.drive.DriveId;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

public class ai implements Creator {
    static void m6417a(OpenFileIntentSenderRequest openFileIntentSenderRequest, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, 1, openFileIntentSenderRequest.xH);
        C1488b.m6366a(parcel, 2, openFileIntentSenderRequest.EB, false);
        C1488b.m6373a(parcel, 3, openFileIntentSenderRequest.EQ, false);
        C1488b.m6363a(parcel, 4, openFileIntentSenderRequest.EC, i, false);
        C1488b.m6355F(parcel, p);
    }

    public OpenFileIntentSenderRequest m6418W(Parcel parcel) {
        DriveId driveId = null;
        int o = C1487a.m6340o(parcel);
        int i = 0;
        String[] strArr = null;
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
                    strArr = C1487a.m6352z(parcel, n);
                    break;
                case Base64.CRLF /*4*/:
                    driveId = (DriveId) C1487a.m6320a(parcel, n, DriveId.CREATOR);
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new OpenFileIntentSenderRequest(i, str, strArr, driveId);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public OpenFileIntentSenderRequest[] aA(int i) {
        return new OpenFileIntentSenderRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m6418W(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aA(x0);
    }
}
