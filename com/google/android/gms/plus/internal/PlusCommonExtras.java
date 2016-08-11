package com.google.android.gms.plus.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C1489c;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.fo;

public class PlusCommonExtras implements SafeParcelable {
    public static final C2233f CREATOR;
    public static String TAG;
    private String Uh;
    private String Ui;
    private final int xH;

    static {
        TAG = "PlusCommonExtras";
        CREATOR = new C2233f();
    }

    public PlusCommonExtras() {
        this.xH = 1;
        this.Uh = "";
        this.Ui = "";
    }

    PlusCommonExtras(int versionCode, String gpsrc, String clientCallingPackage) {
        this.xH = versionCode;
        this.Uh = gpsrc;
        this.Ui = clientCallingPackage;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlusCommonExtras)) {
            return false;
        }
        PlusCommonExtras plusCommonExtras = (PlusCommonExtras) obj;
        return this.xH == plusCommonExtras.xH && fo.equal(this.Uh, plusCommonExtras.Uh) && fo.equal(this.Ui, plusCommonExtras.Ui);
    }

    public int getVersionCode() {
        return this.xH;
    }

    public int hashCode() {
        return fo.hashCode(Integer.valueOf(this.xH), this.Uh, this.Ui);
    }

    public String iN() {
        return this.Uh;
    }

    public String iO() {
        return this.Ui;
    }

    public void m9183m(Bundle bundle) {
        bundle.putByteArray("android.gms.plus.internal.PlusCommonExtras.extraPlusCommon", C1489c.m6381a(this));
    }

    public String toString() {
        return fo.m8511e(this).m8510a("versionCode", Integer.valueOf(this.xH)).m8510a("Gpsrc", this.Uh).m8510a("ClientCallingPackage", this.Ui).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        C2233f.m9264a(this, out, flags);
    }
}
