package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.Filter;

public class NotFilter implements SafeParcelable, Filter {
    public static final Creator CREATOR;
    final FilterHolder GT;
    final int xH;

    static {
        CREATOR = new C1599i();
    }

    NotFilter(int versionCode, FilterHolder toNegate) {
        this.xH = versionCode;
        this.GT = toNegate;
    }

    public NotFilter(Filter toNegate) {
        this(1, new FilterHolder(toNegate));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        C1599i.m6705a(this, out, flags);
    }
}
