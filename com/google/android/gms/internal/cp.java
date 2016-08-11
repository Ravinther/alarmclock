package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.internal.co.C1803a;

public final class cp extends C1803a {
    private final InAppPurchaseListener mp;

    public cp(InAppPurchaseListener inAppPurchaseListener) {
        this.mp = inAppPurchaseListener;
    }

    public void m8063a(cn cnVar) {
        this.mp.onInAppPurchaseRequested(new cq(cnVar));
    }
}
