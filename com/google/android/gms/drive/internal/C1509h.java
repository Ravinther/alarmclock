package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

/* renamed from: com.google.android.gms.drive.internal.h */
public class C1509h implements Creator {
    static void m6454a(CreateFileRequest createFileRequest, Parcel parcel, int i) {
        int p = C1488b.m6380p(parcel);
        C1488b.m6378c(parcel, 1, createFileRequest.xH);
        C1488b.m6363a(parcel, 2, createFileRequest.Fa, i, false);
        C1488b.m6363a(parcel, 3, createFileRequest.EZ, i, false);
        C1488b.m6363a(parcel, 4, createFileRequest.EX, i, false);
        C1488b.m6355F(parcel, p);
    }

    public CreateFileRequest m6455I(Parcel parcel) {
        Contents contents = null;
        int o = C1487a.m6340o(parcel);
        int i = 0;
        MetadataBundle metadataBundle = null;
        DriveId driveId = null;
        while (parcel.dataPosition() < o) {
            MetadataBundle metadataBundle2;
            DriveId driveId2;
            int g;
            Contents contents2;
            int n = C1487a.m6338n(parcel);
            Contents contents3;
            switch (C1487a.m6318R(n)) {
                case Base64.NO_PADDING /*1*/:
                    contents3 = contents;
                    metadataBundle2 = metadataBundle;
                    driveId2 = driveId;
                    g = C1487a.m6331g(parcel, n);
                    contents2 = contents3;
                    break;
                case Base64.NO_WRAP /*2*/:
                    g = i;
                    MetadataBundle metadataBundle3 = metadataBundle;
                    driveId2 = (DriveId) C1487a.m6320a(parcel, n, DriveId.CREATOR);
                    contents2 = contents;
                    metadataBundle2 = metadataBundle3;
                    break;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    driveId2 = driveId;
                    g = i;
                    contents3 = contents;
                    metadataBundle2 = (MetadataBundle) C1487a.m6320a(parcel, n, MetadataBundle.CREATOR);
                    contents2 = contents3;
                    break;
                case Base64.CRLF /*4*/:
                    contents2 = (Contents) C1487a.m6320a(parcel, n, Contents.CREATOR);
                    metadataBundle2 = metadataBundle;
                    driveId2 = driveId;
                    g = i;
                    break;
                default:
                    C1487a.m6324b(parcel, n);
                    contents2 = contents;
                    metadataBundle2 = metadataBundle;
                    driveId2 = driveId;
                    g = i;
                    break;
            }
            i = g;
            driveId = driveId2;
            metadataBundle = metadataBundle2;
            contents = contents2;
        }
        if (parcel.dataPosition() == o) {
            return new CreateFileRequest(i, driveId, metadataBundle, contents);
        }
        throw new C1486a("Overread allowed size end=" + o, parcel);
    }

    public CreateFileRequest[] am(int i) {
        return new CreateFileRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m6455I(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return am(x0);
    }
}
