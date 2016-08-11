package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.C1461a.C1401d;
import com.google.android.gms.common.api.Status;

public class al extends C1503c {
    private final C1401d wH;

    public al(C1401d c1401d) {
        this.wH = c1401d;
    }

    public void m6440m(Status status) {
        this.wH.m6049b(status);
    }

    public void onSuccess() {
        this.wH.m6049b(Status.Bv);
    }
}
