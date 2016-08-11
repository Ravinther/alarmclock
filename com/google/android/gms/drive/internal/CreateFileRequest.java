package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.fq;

public class CreateFileRequest implements SafeParcelable {
    public static final Creator CREATOR;
    final Contents EX;
    final MetadataBundle EZ;
    final DriveId Fa;
    final int xH;

    static {
        CREATOR = new C1509h();
    }

    CreateFileRequest(int versionCode, DriveId parentDriveId, MetadataBundle metadata, Contents contentsReference) {
        this.xH = versionCode;
        this.Fa = (DriveId) fq.m8520f(parentDriveId);
        this.EZ = (MetadataBundle) fq.m8520f(metadata);
        this.EX = (Contents) fq.m8520f(contentsReference);
    }

    public CreateFileRequest(DriveId parentDriveId, MetadataBundle metadata, Contents contentsReference) {
        this(1, parentDriveId, metadata, contentsReference);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C1509h.m6454a(this, dest, flags);
    }
}
