package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.fq;

public class CreateFolderRequest implements SafeParcelable {
    public static final Creator CREATOR;
    final MetadataBundle EZ;
    final DriveId Fa;
    final int xH;

    static {
        CREATOR = new C1510i();
    }

    CreateFolderRequest(int versionCode, DriveId parentDriveId, MetadataBundle metadata) {
        this.xH = versionCode;
        this.Fa = (DriveId) fq.m8520f(parentDriveId);
        this.EZ = (MetadataBundle) fq.m8520f(metadata);
    }

    public CreateFolderRequest(DriveId parentDriveId, MetadataBundle metadata) {
        this(1, parentDriveId, metadata);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C1510i.m6456a(this, dest, flags);
    }
}
