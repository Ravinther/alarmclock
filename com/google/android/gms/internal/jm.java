package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;

public final class jm implements SafeParcelable {
    public static final Creator CREATOR;
    String add;
    String ade;
    ArrayList adf;
    private final int xH;

    static {
        CREATOR = new jn();
    }

    jm() {
        this.xH = 1;
        this.adf = gi.fs();
    }

    jm(int i, String str, String str2, ArrayList arrayList) {
        this.xH = i;
        this.add = str;
        this.ade = str2;
        this.adf = arrayList;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.xH;
    }

    public void writeToParcel(Parcel dest, int flags) {
        jn.m8884a(this, dest, flags);
    }
}
