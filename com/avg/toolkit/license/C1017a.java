package com.avg.toolkit.license;

import com.avg.toolkit.license.p053a.C1010h.C1007g;
import com.google.android.gms.wallet.WalletConstants;

/* renamed from: com.avg.toolkit.license.a */
public class C1017a {
    public final C0986a f3115a;
    public final C0987b f3116b;
    public int f3117c;
    public final boolean f3118d;
    public final int f3119e;
    public final int f3120f;
    @Deprecated
    public final int f3121g;
    public final boolean f3122h;
    public final boolean f3123i;
    public final boolean f3124j;
    public final boolean f3125k;
    public final long f3126l;

    /* renamed from: com.avg.toolkit.license.a.a */
    public enum C0986a {
        Hidden,
        Disabled,
        Active
    }

    /* renamed from: com.avg.toolkit.license.a.b */
    public enum C0987b {
        FREE,
        TRIAL,
        PRO
    }

    public C1017a(int featureSetCode, boolean fullFeaturesEverAllowed, int daysLeftToEndTrial, int vendorId, C0987b productType, boolean coBrandingOriginal, long activationDate) {
        boolean z = true;
        boolean z2 = vendorId == 301 || vendorId == 403 || vendorId == 323;
        this.f3118d = z2;
        this.f3116b = productType;
        this.f3119e = daysLeftToEndTrial;
        this.f3120f = vendorId;
        this.f3121g = featureSetCode;
        C0986a inactiveFs = fullFeaturesEverAllowed ? C0986a.Disabled : C0986a.Hidden;
        if (this.f3119e >= 0 && (this.f3116b == C0987b.PRO || this.f3116b == C0987b.TRIAL)) {
            inactiveFs = C0986a.Active;
        }
        this.f3115a = inactiveFs;
        this.f3123i = coBrandingOriginal;
        if (this.f3120f == 0 || this.f3120f == 301 || this.f3120f == 300 || this.f3120f == 332) {
            z2 = false;
        } else {
            z2 = true;
        }
        this.f3122h = z2;
        if (this.f3120f == 301) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.f3124j = z2;
        if (!(this.f3116b == C0987b.FREE && vendorId == 332)) {
            z = false;
        }
        this.f3125k = z;
        this.f3126l = activationDate;
    }

    public boolean m4426a() {
        return this.f3116b == C0987b.PRO;
    }

    public boolean m4427b() {
        return this.f3116b == C0987b.TRIAL || this.f3116b == C0987b.FREE;
    }

    public boolean m4428c() {
        return this.f3120f != 301;
    }

    public boolean m4429d() {
        return this.f3120f == WalletConstants.ERROR_CODE_SERVICE_UNAVAILABLE;
    }

    public boolean m4430e() {
        return C1007g.LIC_PREP_GMS_PROTECTION.m4418a() == this.f3117c || C1007g.LIC_PREP_GMS_PERFORMANCE.m4418a() == this.f3117c;
    }
}
