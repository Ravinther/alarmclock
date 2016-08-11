package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

/* renamed from: com.google.android.gms.drive.d */
public class C1496d implements Creator {
    static void m6391a(DriveId driveId, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, 1, driveId.xH);
        C1488b.m6366a(parcel, 2, driveId.EH, false);
        C1488b.m6359a(parcel, 3, driveId.EI);
        C1488b.m6359a(parcel, 4, driveId.EJ);
        C1488b.m6355F(parcel, p);
    }

    public DriveId[] ad(int i) {
        return new DriveId[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m6392z(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ad(x0);
    }

    public DriveId m6392z(Parcel parcel) {
        long j = 0;
        int o = C1487a.m6340o(parcel);
        int i = 0;
        String str = null;
        long j2 = 0;
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
                    j2 = C1487a.m6333i(parcel, n);
                    break;
                case Base64.CRLF /*4*/:
                    j = C1487a.m6333i(parcel, n);
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new DriveId(i, str, j2, j);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }
}
