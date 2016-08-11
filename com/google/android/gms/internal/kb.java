package com.google.android.gms.internal;

import com.google.android.gms.wearable.C2019a;
import com.google.android.gms.wearable.C2021c;

public class kb implements C2019a {
    private int LF;
    private C2021c adC;

    public kb(C2019a c2019a) {
        this.LF = c2019a.getType();
        this.adC = (C2021c) c2019a.lZ().freeze();
    }

    public /* synthetic */ Object freeze() {
        return me();
    }

    public int getType() {
        return this.LF;
    }

    public boolean isDataValid() {
        return true;
    }

    public C2021c lZ() {
        return this.adC;
    }

    public C2019a me() {
        return this;
    }
}
