package com.avg.toolkit.license.p053a;

import com.avg.toolkit.license.p053a.C1010h.C1001a;

/* renamed from: com.avg.toolkit.license.a.c */
public class C0991c {
    public static int m4394a(C1001a licAvgVersion, String value) {
        C0990b arrNumber = new C0990b(licAvgVersion);
        for (int i = 0; i < value.length(); i++) {
            arrNumber.m4386a(value.charAt(i));
        }
        return arrNumber.m4390b(0, value.length() * 5);
    }
}
