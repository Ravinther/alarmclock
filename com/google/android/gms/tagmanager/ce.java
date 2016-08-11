package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C1732a;
import com.google.android.gms.internal.C1750b;
import com.google.android.gms.internal.C1817d.C1816a;
import java.util.Map;

class ce extends aj {
    private static final String ID;
    private static final String YX;
    private static final String YY;

    static {
        ID = C1732a.RANDOM.toString();
        YX = C1750b.MIN.toString();
        YY = C1750b.MAX.toString();
    }

    public ce() {
        super(ID, new String[0]);
    }

    public boolean jX() {
        return false;
    }

    public C1816a m9424x(Map map) {
        double doubleValue;
        double d;
        C1816a c1816a = (C1816a) map.get(YX);
        C1816a c1816a2 = (C1816a) map.get(YY);
        if (!(c1816a == null || c1816a == dh.lT() || c1816a2 == null || c1816a2 == dh.lT())) {
            dg k = dh.m9521k(c1816a);
            dg k2 = dh.m9521k(c1816a2);
            if (!(k == dh.lR() || k2 == dh.lR())) {
                double doubleValue2 = k.doubleValue();
                doubleValue = k2.doubleValue();
                if (doubleValue2 <= doubleValue) {
                    d = doubleValue2;
                    return dh.m9531r(Long.valueOf(Math.round(((doubleValue - d) * Math.random()) + d)));
                }
            }
        }
        doubleValue = 2.147483647E9d;
        d = 0.0d;
        return dh.m9531r(Long.valueOf(Math.round(((doubleValue - d) * Math.random()) + d)));
    }
}
