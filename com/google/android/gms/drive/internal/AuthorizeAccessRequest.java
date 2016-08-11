package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class AuthorizeAccessRequest implements SafeParcelable {
    public static final Creator CREATOR;
    final long EU;
    final DriveId Ew;
    final int xH;

    static {
        CREATOR = new C1504b();
    }

    AuthorizeAccessRequest(int versionCode, long appId, DriveId driveId) {
        this.xH = versionCode;
        this.EU = appId;
        this.Ew = driveId;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C1504b.m6444a(this, dest, flags);
    }
}
