package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C1732a;
import com.google.android.gms.internal.C1817d.C1816a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.p */
class C2323p extends aj {
    private static final String ID;
    private final String Xl;

    static {
        ID = C1732a.CONTAINER_VERSION.toString();
    }

    public C2323p(String str) {
        super(ID, new String[0]);
        this.Xl = str;
    }

    public boolean jX() {
        return true;
    }

    public C1816a m9579x(Map map) {
        return this.Xl == null ? dh.lT() : dh.m9531r(this.Xl);
    }
}
