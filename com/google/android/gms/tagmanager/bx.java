package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C1817d.C1816a;
import java.util.Map;

abstract class bx extends cc {
    public bx(String str) {
        super(str);
    }

    protected boolean m9328a(C1816a c1816a, C1816a c1816a2, Map map) {
        dg k = dh.m9521k(c1816a);
        dg k2 = dh.m9521k(c1816a2);
        return (k == dh.lR() || k2 == dh.lR()) ? false : m9329a(k, k2, map);
    }

    protected abstract boolean m9329a(dg dgVar, dg dgVar2, Map map);
}
