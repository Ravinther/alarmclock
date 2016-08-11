package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;
import com.google.android.gms.internal.C1732a;
import com.google.android.gms.internal.C1817d.C1816a;
import java.util.Map;

class bz extends aj {
    private static final String ID;

    static {
        ID = C1732a.OS_VERSION.toString();
    }

    public bz() {
        super(ID, new String[0]);
    }

    public boolean jX() {
        return true;
    }

    public C1816a m9398x(Map map) {
        return dh.m9531r(VERSION.RELEASE);
    }
}
