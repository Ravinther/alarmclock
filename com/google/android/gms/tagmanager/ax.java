package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.C1732a;
import com.google.android.gms.internal.C1750b;
import com.google.android.gms.internal.C1817d.C1816a;
import java.util.Map;

class ax extends aj {
    private static final String ID;
    private static final String WA;
    private final Context kI;

    static {
        ID = C1732a.INSTALL_REFERRER.toString();
        WA = C1750b.COMPONENT.toString();
    }

    public ax(Context context) {
        super(ID, new String[0]);
        this.kI = context;
    }

    public boolean jX() {
        return true;
    }

    public C1816a m9350x(Map map) {
        String d = ay.m9352d(this.kI, ((C1816a) map.get(WA)) != null ? dh.m9520j((C1816a) map.get(WA)) : null);
        return d != null ? dh.m9531r(d) : dh.lT();
    }
}
