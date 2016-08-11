package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class SortOrder implements SafeParcelable {
    public static final Creator CREATOR;
    final List GF;
    final int xH;

    static {
        CREATOR = new C1590b();
    }

    SortOrder(int versionCode, List sortingFields) {
        this.xH = versionCode;
        this.GF = sortingFields;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        C1590b.m6696a(this, out, flags);
    }
}
