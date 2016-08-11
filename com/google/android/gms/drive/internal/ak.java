package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.google.android.gms.drive.DriveId;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

public class ak implements Creator {
    static void m6421a(RemoveEventListenerRequest removeEventListenerRequest, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, 1, removeEventListenerRequest.xH);
        C1488b.m6363a(parcel, 2, removeEventListenerRequest.Ew, i, false);
        C1488b.m6378c(parcel, 3, removeEventListenerRequest.ES);
        C1488b.m6355F(parcel, p);
    }

    public RemoveEventListenerRequest m6422Y(Parcel parcel) {
        int i = 0;
        int o = C1487a.m6340o(parcel);
        DriveId driveId = null;
        int i2 = 0;
        while (parcel.dataPosition() < o) {
            DriveId driveId2;
            int g;
            int n = C1487a.m6338n(parcel);
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    int i3 = i;
                    driveId2 = driveId;
                    g = C1487a.m6331g(parcel, n);
                    n = i3;
                    break;
                case Base64.NO_WRAP /*2*/:
                    g = i2;
                    DriveId driveId3 = (DriveId) C1487a.m6320a(parcel, n, DriveId.CREATOR);
                    n = i;
                    driveId2 = driveId3;
                    break;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    n = C1487a.m6331g(parcel, n);
                    driveId2 = driveId;
                    g = i2;
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    n = i;
                    driveId2 = driveId;
                    g = i2;
                    break;
            }
            i2 = g;
            driveId = driveId2;
            i = n;
        }
        if (parcel.dataPosition() == o) {
            return new RemoveEventListenerRequest(i2, driveId, i);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public RemoveEventListenerRequest[] aC(int i) {
        return new RemoveEventListenerRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m6422Y(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aC(x0);
    }
}
