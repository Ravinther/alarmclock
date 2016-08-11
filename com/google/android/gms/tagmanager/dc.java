package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C1817d.C1816a;
import java.util.Map;

abstract class dc extends cc {
    public dc(String str) {
        super(str);
    }

    protected boolean m9317a(C1816a c1816a, C1816a c1816a2, Map map) {
        String j = dh.m9520j(c1816a);
        String j2 = dh.m9520j(c1816a2);
        return (j == dh.lS() || j2 == dh.lS()) ? false : m9318a(j, j2, map);
    }

    protected abstract boolean m9318a(String str, String str2, Map map);
}
