package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class cx implements SafeParcelable {
    public static final cy CREATOR;
    public final ApplicationInfo applicationInfo;
    public final String kH;
    public final dx kK;
    public final ak kN;
    public final Bundle pf;
    public final ah pg;
    public final PackageInfo ph;
    public final String pi;
    public final String pj;
    public final String pk;
    public final Bundle pl;
    public final int versionCode;

    /* renamed from: com.google.android.gms.internal.cx.a */
    public static final class C1815a {
        public final ApplicationInfo applicationInfo;
        public final String kH;
        public final dx kK;
        public final ak kN;
        public final Bundle pf;
        public final ah pg;
        public final PackageInfo ph;
        public final String pj;
        public final String pk;
        public final Bundle pl;

        public C1815a(Bundle bundle, ah ahVar, ak akVar, String str, ApplicationInfo applicationInfo, PackageInfo packageInfo, String str2, String str3, dx dxVar, Bundle bundle2) {
            this.pf = bundle;
            this.pg = ahVar;
            this.kN = akVar;
            this.kH = str;
            this.applicationInfo = applicationInfo;
            this.ph = packageInfo;
            this.pj = str2;
            this.pk = str3;
            this.kK = dxVar;
            this.pl = bundle2;
        }
    }

    static {
        CREATOR = new cy();
    }

    cx(int i, Bundle bundle, ah ahVar, ak akVar, String str, ApplicationInfo applicationInfo, PackageInfo packageInfo, String str2, String str3, String str4, dx dxVar, Bundle bundle2) {
        this.versionCode = i;
        this.pf = bundle;
        this.pg = ahVar;
        this.kN = akVar;
        this.kH = str;
        this.applicationInfo = applicationInfo;
        this.ph = packageInfo;
        this.pi = str2;
        this.pj = str3;
        this.pk = str4;
        this.kK = dxVar;
        this.pl = bundle2;
    }

    public cx(Bundle bundle, ah ahVar, ak akVar, String str, ApplicationInfo applicationInfo, PackageInfo packageInfo, String str2, String str3, String str4, dx dxVar, Bundle bundle2) {
        this(2, bundle, ahVar, akVar, str, applicationInfo, packageInfo, str2, str3, str4, dxVar, bundle2);
    }

    public cx(C1815a c1815a, String str) {
        this(c1815a.pf, c1815a.pg, c1815a.kN, c1815a.kH, c1815a.applicationInfo, c1815a.ph, str, c1815a.pj, c1815a.pk, c1815a.kK, c1815a.pl);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        cy.m8099a(this, out, flags);
    }
}
