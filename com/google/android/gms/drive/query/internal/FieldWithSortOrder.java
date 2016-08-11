package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class FieldWithSortOrder implements SafeParcelable {
    public static final C1593c CREATOR;
    final String FM;
    final boolean GJ;
    final int xH;

    static {
        CREATOR = new C1593c();
    }

    FieldWithSortOrder(int versionCode, String fieldName, boolean isSortAscending) {
        this.xH = versionCode;
        this.FM = fieldName;
        this.GJ = isSortAscending;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        C1593c.m6699a(this, out, flags);
    }
}
