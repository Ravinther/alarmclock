package com.google.android.gms.plus.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.fo;
import java.util.Arrays;

/* renamed from: com.google.android.gms.plus.internal.h */
public class C2236h implements SafeParcelable {
    public static final C2238j CREATOR;
    private final String[] Uk;
    private final String[] Ul;
    private final String[] Um;
    private final String Un;
    private final String Uo;
    private final String Up;
    private final String Uq;
    private final PlusCommonExtras Ur;
    private final String wG;
    private final int xH;

    static {
        CREATOR = new C2238j();
    }

    C2236h(int i, String str, String[] strArr, String[] strArr2, String[] strArr3, String str2, String str3, String str4, String str5, PlusCommonExtras plusCommonExtras) {
        this.xH = i;
        this.wG = str;
        this.Uk = strArr;
        this.Ul = strArr2;
        this.Um = strArr3;
        this.Un = str2;
        this.Uo = str3;
        this.Up = str4;
        this.Uq = str5;
        this.Ur = plusCommonExtras;
    }

    public C2236h(String str, String[] strArr, String[] strArr2, String[] strArr3, String str2, String str3, String str4, PlusCommonExtras plusCommonExtras) {
        this.xH = 1;
        this.wG = str;
        this.Uk = strArr;
        this.Ul = strArr2;
        this.Um = strArr3;
        this.Un = str2;
        this.Uo = str3;
        this.Up = str4;
        this.Uq = null;
        this.Ur = plusCommonExtras;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C2236h)) {
            return false;
        }
        C2236h c2236h = (C2236h) obj;
        return this.xH == c2236h.xH && fo.equal(this.wG, c2236h.wG) && Arrays.equals(this.Uk, c2236h.Uk) && Arrays.equals(this.Ul, c2236h.Ul) && Arrays.equals(this.Um, c2236h.Um) && fo.equal(this.Un, c2236h.Un) && fo.equal(this.Uo, c2236h.Uo) && fo.equal(this.Up, c2236h.Up) && fo.equal(this.Uq, c2236h.Uq) && fo.equal(this.Ur, c2236h.Ur);
    }

    public String getAccountName() {
        return this.wG;
    }

    public int getVersionCode() {
        return this.xH;
    }

    public int hashCode() {
        return fo.hashCode(Integer.valueOf(this.xH), this.wG, this.Uk, this.Ul, this.Um, this.Un, this.Uo, this.Up, this.Uq, this.Ur);
    }

    public String[] iP() {
        return this.Uk;
    }

    public String[] iQ() {
        return this.Ul;
    }

    public String[] iR() {
        return this.Um;
    }

    public String iS() {
        return this.Un;
    }

    public String iT() {
        return this.Uo;
    }

    public String iU() {
        return this.Up;
    }

    public String iV() {
        return this.Uq;
    }

    public PlusCommonExtras iW() {
        return this.Ur;
    }

    public Bundle iX() {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(PlusCommonExtras.class.getClassLoader());
        this.Ur.m9183m(bundle);
        return bundle;
    }

    public String toString() {
        return fo.m8511e(this).m8510a("versionCode", Integer.valueOf(this.xH)).m8510a("accountName", this.wG).m8510a("requestedScopes", this.Uk).m8510a("visibleActivities", this.Ul).m8510a("requiredFeatures", this.Um).m8510a("packageNameForAuth", this.Un).m8510a("callingPackageName", this.Uo).m8510a("applicationName", this.Up).m8510a("extra", this.Ur.toString()).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        C2238j.m9269a(this, out, flags);
    }
}
