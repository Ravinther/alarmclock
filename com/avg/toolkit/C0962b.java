package com.avg.toolkit;

import android.os.Binder;

/* renamed from: com.avg.toolkit.b */
public class C0962b extends Binder implements C0961d {
    private ITKSvc f2910a;

    public C0962b(ITKSvc service) {
        this.f2910a = service;
    }

    public C0647c m4306a(int featureID) {
        if (this.f2910a != null) {
            return this.f2910a.getFeature(featureID);
        }
        return null;
    }
}
