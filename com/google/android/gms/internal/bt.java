package com.google.android.gms.internal;

import com.google.android.gms.ads.mediation.MediationAdRequest;
import java.util.Date;
import java.util.Set;

public final class bt implements MediationAdRequest {
    private final Date f4299d;
    private final Set f4300f;
    private final boolean f4301g;
    private final int lZ;
    private final int nD;

    public bt(Date date, int i, Set set, boolean z, int i2) {
        this.f4299d = date;
        this.lZ = i;
        this.f4300f = set;
        this.f4301g = z;
        this.nD = i2;
    }

    public Date getBirthday() {
        return this.f4299d;
    }

    public int getGender() {
        return this.lZ;
    }

    public Set getKeywords() {
        return this.f4300f;
    }

    public boolean isTesting() {
        return this.f4301g;
    }

    public int taggedForChildDirectedTreatment() {
        return this.nD;
    }
}
