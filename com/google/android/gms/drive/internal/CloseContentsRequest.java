package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;

public class CloseContentsRequest implements SafeParcelable {
    public static final Creator CREATOR;
    final Contents EX;
    final Boolean EY;
    final int xH;

    static {
        CREATOR = new C1506e();
    }

    CloseContentsRequest(int versionCode, Contents contentsReference, Boolean saveResults) {
        this.xH = versionCode;
        this.EX = contentsReference;
        this.EY = saveResults;
    }

    public CloseContentsRequest(Contents contentsReference, boolean saveResults) {
        this(1, contentsReference, Boolean.valueOf(saveResults));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C1506e.m6448a(this, dest, flags);
    }
}
