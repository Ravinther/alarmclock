package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.C1732a;
import com.google.android.gms.internal.C1750b;
import com.google.android.gms.internal.C1817d.C1816a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.e */
class C2302e extends aj {
    private static final String ID;
    private static final String WA;
    private static final String WB;
    private final Context kI;

    static {
        ID = C1732a.ADWORDS_CLICK_REFERRER.toString();
        WA = C1750b.COMPONENT.toString();
        WB = C1750b.CONVERSION_ID.toString();
    }

    public C2302e(Context context) {
        super(ID, WB);
        this.kI = context;
    }

    public boolean jX() {
        return true;
    }

    public C1816a m9547x(Map map) {
        C1816a c1816a = (C1816a) map.get(WB);
        if (c1816a == null) {
            return dh.lT();
        }
        String j = dh.m9520j(c1816a);
        c1816a = (C1816a) map.get(WA);
        String e = ay.m9353e(this.kI, j, c1816a != null ? dh.m9520j(c1816a) : null);
        return e != null ? dh.m9531r(e) : dh.lT();
    }
}
