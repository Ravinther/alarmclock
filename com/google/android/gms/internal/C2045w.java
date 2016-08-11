package com.google.android.gms.internal;

import com.avg.toolkit.ITKSvc;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.w */
class C2045w implements C2044y {
    private dz kU;

    public C2045w(dz dzVar) {
        this.kU = dzVar;
    }

    public void m9019a(ab abVar, boolean z) {
        Map hashMap = new HashMap();
        hashMap.put("isVisible", z ? "1" : ITKSvc.CODEREVISION);
        this.kU.m8230a("onAdVisibilityChanged", hashMap);
    }
}
