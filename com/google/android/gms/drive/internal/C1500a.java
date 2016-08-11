package com.google.android.gms.drive.internal;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.google.android.gms.drive.DriveId;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

/* renamed from: com.google.android.gms.drive.internal.a */
public class C1500a implements Creator {
    static void m6399a(AddEventListenerRequest addEventListenerRequest, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, 1, addEventListenerRequest.xH);
        C1488b.m6363a(parcel, 2, addEventListenerRequest.Ew, i, false);
        C1488b.m6378c(parcel, 3, addEventListenerRequest.ES);
        C1488b.m6363a(parcel, 4, addEventListenerRequest.ET, i, false);
        C1488b.m6355F(parcel, p);
    }

    public AddEventListenerRequest m6400C(Parcel parcel) {
        PendingIntent pendingIntent = null;
        int i = 0;
        int o = C1487a.m6340o(parcel);
        DriveId driveId = null;
        int i2 = 0;
        while (parcel.dataPosition() < o) {
            int i3;
            DriveId driveId2;
            int g;
            PendingIntent pendingIntent2;
            int n = C1487a.m6338n(parcel);
            PendingIntent pendingIntent3;
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    pendingIntent3 = pendingIntent;
                    i3 = i;
                    driveId2 = driveId;
                    g = C1487a.m6331g(parcel, n);
                    pendingIntent2 = pendingIntent3;
                    break;
                case Base64.NO_WRAP /*2*/:
                    g = i2;
                    int i4 = i;
                    driveId2 = (DriveId) C1487a.m6320a(parcel, n, DriveId.CREATOR);
                    pendingIntent2 = pendingIntent;
                    i3 = i4;
                    break;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    driveId2 = driveId;
                    g = i2;
                    pendingIntent3 = pendingIntent;
                    i3 = C1487a.m6331g(parcel, n);
                    pendingIntent2 = pendingIntent3;
                    break;
                case Base64.CRLF /*4*/:
                    pendingIntent2 = (PendingIntent) C1487a.m6320a(parcel, n, PendingIntent.CREATOR);
                    i3 = i;
                    driveId2 = driveId;
                    g = i2;
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    pendingIntent2 = pendingIntent;
                    i3 = i;
                    driveId2 = driveId;
                    g = i2;
                    break;
            }
            i2 = g;
            driveId = driveId2;
            i = i3;
            pendingIntent = pendingIntent2;
        }
        if (parcel.dataPosition() == o) {
            return new AddEventListenerRequest(i2, driveId, i, pendingIntent);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public AddEventListenerRequest[] ag(int i) {
        return new AddEventListenerRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m6400C(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ag(x0);
    }
}
