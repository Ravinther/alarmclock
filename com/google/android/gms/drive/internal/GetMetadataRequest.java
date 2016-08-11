package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class GetMetadataRequest implements SafeParcelable {
    public static final Creator CREATOR;
    final DriveId EV;
    final int xH;

    static {
        CREATOR = new C1567t();
    }

    GetMetadataRequest(int versionCode, DriveId id) {
        this.xH = versionCode;
        this.EV = id;
    }

    public GetMetadataRequest(DriveId id) {
        this(1, id);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C1567t.m6562a(this, dest, flags);
    }
}
