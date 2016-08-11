package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

/* renamed from: com.google.android.gms.drive.a */
public class C1493a implements Creator {
    static void m6388a(Contents contents, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, 1, contents.xH);
        C1488b.m6363a(parcel, 2, contents.Cj, i, false);
        C1488b.m6378c(parcel, 3, contents.Eu);
        C1488b.m6378c(parcel, 4, contents.Ev);
        C1488b.m6363a(parcel, 5, contents.Ew, i, false);
        C1488b.m6355F(parcel, p);
    }

    public Contents[] ac(int i) {
        return new Contents[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m6389y(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ac(x0);
    }

    public Contents m6389y(Parcel parcel) {
        DriveId driveId = null;
        int i = 0;
        int o = C1487a.m6340o(parcel);
        int i2 = 0;
        ParcelFileDescriptor parcelFileDescriptor = null;
        int i3 = 0;
        while (parcel.dataPosition() < o) {
            int n = C1487a.m6338n(parcel);
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    i3 = C1487a.m6331g(parcel, n);
                    break;
                case Base64.NO_WRAP /*2*/:
                    parcelFileDescriptor = (ParcelFileDescriptor) C1487a.m6320a(parcel, n, ParcelFileDescriptor.CREATOR);
                    break;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    i2 = C1487a.m6331g(parcel, n);
                    break;
                case Base64.CRLF /*4*/:
                    i = C1487a.m6331g(parcel, n);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    driveId = (DriveId) C1487a.m6320a(parcel, n, DriveId.CREATOR);
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new Contents(i3, parcelFileDescriptor, i2, i, driveId);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }
}
