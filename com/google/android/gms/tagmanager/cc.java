package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C1750b;
import com.google.android.gms.internal.C1817d.C1816a;
import java.util.Map;

abstract class cc extends aj {
    private static final String XQ;
    private static final String YN;

    static {
        XQ = C1750b.ARG0.toString();
        YN = C1750b.ARG1.toString();
    }

    public cc(String str) {
        super(str, XQ, YN);
    }

    protected abstract boolean m9315a(C1816a c1816a, C1816a c1816a2, Map map);

    public boolean jX() {
        return true;
    }

    public C1816a m9316x(Map map) {
        for (C1816a c1816a : map.values()) {
            if (c1816a == dh.lT()) {
                return dh.m9531r(Boolean.valueOf(false));
            }
        }
        C1816a c1816a2 = (C1816a) map.get(XQ);
        C1816a c1816a3 = (C1816a) map.get(YN);
        boolean a = (c1816a2 == null || c1816a3 == null) ? false : m9315a(c1816a2, c1816a3, map);
        return dh.m9531r(Boolean.valueOf(a));
    }
}
