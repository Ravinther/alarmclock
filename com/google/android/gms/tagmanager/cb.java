package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C1732a;
import com.google.android.gms.internal.C1817d.C1816a;
import java.util.Map;

class cb extends aj {
    private static final String ID;
    private static final C1816a YM;

    static {
        ID = C1732a.PLATFORM.toString();
        YM = dh.m9531r("Android");
    }

    public cb() {
        super(ID, new String[0]);
    }

    public boolean jX() {
        return true;
    }

    public C1816a m9421x(Map map) {
        return YM;
    }
}
