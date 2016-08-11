package com.avg.ui.general.p059d;

/* renamed from: com.avg.ui.general.d.a */
public class C1161a extends Exception {
    public C1161a(Throwable throwable) {
        super("Navigation exception occurred. Reason: " + throwable.getMessage(), throwable);
    }

    public C1161a() {
        super("Navigation exception occurred - fragment detached");
    }

    public C1161a(String message) {
        super(message);
    }
}
