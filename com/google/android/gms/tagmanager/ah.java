package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C1732a;
import com.google.android.gms.internal.C1817d.C1816a;
import java.util.Map;

class ah extends aj {
    private static final String ID;
    private final cs WL;

    static {
        ID = C1732a.EVENT.toString();
    }

    public ah(cs csVar) {
        super(ID, new String[0]);
        this.WL = csVar;
    }

    public boolean jX() {
        return false;
    }

    public C1816a m9321x(Map map) {
        String lx = this.WL.lx();
        return lx == null ? dh.lT() : dh.m9531r(lx);
    }
}
