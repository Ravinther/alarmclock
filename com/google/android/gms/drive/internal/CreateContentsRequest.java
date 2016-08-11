package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class CreateContentsRequest implements SafeParcelable {
    public static final Creator CREATOR;
    final int xH;

    static {
        CREATOR = new C1507f();
    }

    public CreateContentsRequest() {
        this(1);
    }

    CreateContentsRequest(int versionCode) {
        this.xH = versionCode;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C1507f.m6450a(this, dest, flags);
    }
}
