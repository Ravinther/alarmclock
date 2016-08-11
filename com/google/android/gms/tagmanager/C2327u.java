package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C1732a;
import com.google.android.gms.internal.C1750b;
import com.google.android.gms.internal.C1817d.C1816a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.u */
class C2327u extends aj {
    private static final String ID;
    private static final String NAME;
    private static final String XA;
    private final DataLayer WK;

    static {
        ID = C1732a.CUSTOM_VAR.toString();
        NAME = C1750b.NAME.toString();
        XA = C1750b.DEFAULT_VALUE.toString();
    }

    public C2327u(DataLayer dataLayer) {
        super(ID, NAME);
        this.WK = dataLayer;
    }

    public boolean jX() {
        return false;
    }

    public C1816a m9582x(Map map) {
        Object obj = this.WK.get(dh.m9520j((C1816a) map.get(NAME)));
        if (obj != null) {
            return dh.m9531r(obj);
        }
        C1816a c1816a = (C1816a) map.get(XA);
        return c1816a != null ? c1816a : dh.lT();
    }
}
