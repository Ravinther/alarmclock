package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C1732a;
import com.google.android.gms.internal.C1817d.C1816a;
import java.util.Map;

class dd extends aj {
    private static final String ID;

    static {
        ID = C1732a.TIME.toString();
    }

    public dd() {
        super(ID, new String[0]);
    }

    public boolean jX() {
        return false;
    }

    public C1816a m9514x(Map map) {
        return dh.m9531r(Long.valueOf(System.currentTimeMillis()));
    }
}
