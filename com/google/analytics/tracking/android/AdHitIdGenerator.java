package com.google.analytics.tracking.android;

class AdHitIdGenerator {
    private boolean f4025a;

    AdHitIdGenerator() {
        try {
            boolean z;
            if (Class.forName("com.google.ads.AdRequest") != null) {
                z = true;
            } else {
                z = false;
            }
            this.f4025a = z;
        } catch (ClassNotFoundException e) {
            this.f4025a = false;
        }
    }

    int m5557a() {
        if (this.f4025a) {
            return AdMobInfo.m5558a().m5559b();
        }
        return 0;
    }
}
