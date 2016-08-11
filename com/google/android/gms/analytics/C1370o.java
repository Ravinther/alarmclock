package com.google.android.gms.analytics;

/* renamed from: com.google.android.gms.analytics.o */
public final class C1370o {
    private static String m5988b(String str, int i) {
        if (i >= 1) {
            return str + i;
        }
        aa.m5913w("index out of range for " + str + " (" + i + ")");
        return "";
    }

    static String m5989q(int i) {
        return C1370o.m5988b("&cd", i);
    }

    static String m5990r(int i) {
        return C1370o.m5988b("&cm", i);
    }
}
