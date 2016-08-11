package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

/* renamed from: com.google.android.gms.drive.internal.i */
public class C1510i implements Creator {
    static void m6456a(CreateFolderRequest createFolderRequest, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, 1, createFolderRequest.xH);
        C1488b.m6363a(parcel, 2, createFolderRequest.Fa, i, false);
        C1488b.m6363a(parcel, 3, createFolderRequest.EZ, i, false);
        C1488b.m6355F(parcel, p);
    }

    public CreateFolderRequest m6457J(Parcel parcel) {
        MetadataBundle metadataBundle = null;
        int o = C1487a.m6340o(parcel);
        int i = 0;
        DriveId driveId = null;
        while (parcel.dataPosition() < o) {
            DriveId driveId2;
            int g;
            MetadataBundle metadataBundle2;
            int n = C1487a.m6338n(parcel);
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    MetadataBundle metadataBundle3 = metadataBundle;
                    driveId2 = driveId;
                    g = C1487a.m6331g(parcel, n);
                    metadataBundle2 = metadataBundle3;
                    break;
                case Base64.NO_WRAP /*2*/:
                    g = i;
                    DriveId driveId3 = (DriveId) C1487a.m6320a(parcel, n, DriveId.CREATOR);
                    metadataBundle2 = metadataBundle;
                    driveId2 = driveId3;
                    break;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    metadataBundle2 = (MetadataBundle) C1487a.m6320a(parcel, n, MetadataBundle.CREATOR);
                    driveId2 = driveId;
                    g = i;
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    metadataBundle2 = metadataBundle;
                    driveId2 = driveId;
                    g = i;
                    break;
            }
            i = g;
            driveId = driveId2;
            metadataBundle = metadataBundle2;
        }
        if (parcel.dataPosition() == o) {
            return new CreateFolderRequest(i, driveId, metadataBundle);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public CreateFolderRequest[] an(int i) {
        return new CreateFolderRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m6457J(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return an(x0);
    }
}
