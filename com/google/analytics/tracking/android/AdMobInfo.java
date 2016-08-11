package com.google.analytics.tracking.android;

import java.util.Random;

class AdMobInfo {
    private static final AdMobInfo f4032a;
    private int f4033b;
    private Random f4034c;

    enum AdMobKey {
        CLIENT_ID_KEY("ga_cid"),
        HIT_ID_KEY("ga_hid"),
        PROPERTY_ID_KEY("ga_wpids"),
        VISITOR_ID_KEY("ga_uid");
        
        private String f4031e;

        private AdMobKey(String bowParameter) {
            this.f4031e = bowParameter;
        }
    }

    static {
        f4032a = new AdMobInfo();
    }

    private AdMobInfo() {
        this.f4034c = new Random();
    }

    static AdMobInfo m5558a() {
        return f4032a;
    }

    int m5559b() {
        this.f4033b = this.f4034c.nextInt(2147483646) + 1;
        return this.f4033b;
    }
}
