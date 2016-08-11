package com.google.android.gms.internal;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.internal.ar.C1742a;

public final class am extends C1742a {
    private final AppEventListener lV;

    public am(AppEventListener appEventListener) {
        this.lV = appEventListener;
    }

    public void onAppEvent(String name, String info) {
        this.lV.onAppEvent(name, info);
    }
}
