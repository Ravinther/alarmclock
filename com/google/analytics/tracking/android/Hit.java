package com.google.analytics.tracking.android;

class Hit {
    private String f4202a;
    private final long f4203b;
    private final long f4204c;
    private String f4205d;

    String m5740a() {
        return this.f4202a;
    }

    void m5741a(String hitString) {
        this.f4202a = hitString;
    }

    long m5742b() {
        return this.f4203b;
    }

    long m5744c() {
        return this.f4204c;
    }

    Hit(String hitString, long hitId, long hitTime) {
        this.f4202a = hitString;
        this.f4203b = hitId;
        this.f4204c = hitTime;
    }

    String m5745d() {
        return this.f4205d;
    }

    void m5743b(String hitUrl) {
        this.f4205d = hitUrl;
    }
}
