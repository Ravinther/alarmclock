package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@Deprecated
public class CountrySpecification implements SafeParcelable {
    public static final Creator CREATOR;
    String qd;
    private final int xH;

    static {
        CREATOR = new C2346c();
    }

    CountrySpecification(int versionCode, String countryCode) {
        this.xH = versionCode;
        this.qd = countryCode;
    }

    public CountrySpecification(String countryCode) {
        this.xH = 1;
        this.qd = countryCode;
    }

    public int describeContents() {
        return 0;
    }

    public String getCountryCode() {
        return this.qd;
    }

    public int getVersionCode() {
        return this.xH;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C2346c.m9619a(this, dest, flags);
    }
}
