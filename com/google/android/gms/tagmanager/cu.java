package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;
import com.google.android.gms.internal.C1732a;
import com.google.android.gms.internal.C1817d.C1816a;
import java.util.Map;

class cu extends aj {
    private static final String ID;

    static {
        ID = C1732a.SDK_VERSION.toString();
    }

    public cu() {
        super(ID, new String[0]);
    }

    public boolean jX() {
        return true;
    }

    public C1816a m9492x(Map map) {
        return dh.m9531r(Integer.valueOf(VERSION.SDK_INT));
    }
}
