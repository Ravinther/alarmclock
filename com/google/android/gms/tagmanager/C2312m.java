package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C1732a;
import com.google.android.gms.internal.C1750b;
import com.google.android.gms.internal.C1817d.C1816a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.m */
class C2312m extends aj {
    private static final String ID;
    private static final String VALUE;

    static {
        ID = C1732a.CONSTANT.toString();
        VALUE = C1750b.VALUE.toString();
    }

    public C2312m() {
        super(ID, VALUE);
    }

    public static String ka() {
        return ID;
    }

    public static String kb() {
        return VALUE;
    }

    public boolean jX() {
        return true;
    }

    public C1816a m9554x(Map map) {
        return (C1816a) map.get(VALUE);
    }
}
