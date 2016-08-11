package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C1732a;
import com.google.android.gms.internal.C1750b;
import com.google.android.gms.internal.C1817d.C1816a;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.w */
class C2334w extends df {
    private static final String ID;
    private static final String VALUE;
    private static final String XL;
    private final DataLayer WK;

    static {
        ID = C1732a.DATA_LAYER_WRITE.toString();
        VALUE = C1750b.VALUE.toString();
        XL = C1750b.CLEAR_PERSISTENT_DATA_LAYER_PREFIX.toString();
    }

    public C2334w(DataLayer dataLayer) {
        super(ID, VALUE);
        this.WK = dataLayer;
    }

    private void m9600a(C1816a c1816a) {
        if (c1816a != null && c1816a != dh.lN()) {
            String j = dh.m9520j(c1816a);
            if (j != dh.lS()) {
                this.WK.bv(j);
            }
        }
    }

    private void m9601b(C1816a c1816a) {
        if (c1816a != null && c1816a != dh.lN()) {
            Object o = dh.m9528o(c1816a);
            if (o instanceof List) {
                for (Object o2 : (List) o2) {
                    if (o2 instanceof Map) {
                        this.WK.push((Map) o2);
                    }
                }
            }
        }
    }

    public void m9602z(Map map) {
        m9601b((C1816a) map.get(VALUE));
        m9600a((C1816a) map.get(XL));
    }
}
