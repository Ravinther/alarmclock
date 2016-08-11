package com.google.android.gms.tagmanager;

import android.util.Base64;
import com.google.android.gms.internal.C1732a;
import com.google.android.gms.internal.C1750b;
import com.google.android.gms.internal.C1817d.C1816a;
import java.util.Map;

class ac extends aj {
    private static final String ID;
    private static final String XQ;
    private static final String XR;
    private static final String XS;
    private static final String XT;

    static {
        ID = C1732a.ENCODE.toString();
        XQ = C1750b.ARG0.toString();
        XR = C1750b.NO_PADDING.toString();
        XS = C1750b.INPUT_FORMAT.toString();
        XT = C1750b.OUTPUT_FORMAT.toString();
    }

    public ac() {
        super(ID, XQ);
    }

    public boolean jX() {
        return true;
    }

    public C1816a m9314x(Map map) {
        C1816a c1816a = (C1816a) map.get(XQ);
        if (c1816a == null || c1816a == dh.lT()) {
            return dh.lT();
        }
        String j = dh.m9520j(c1816a);
        c1816a = (C1816a) map.get(XS);
        String j2 = c1816a == null ? "text" : dh.m9520j(c1816a);
        c1816a = (C1816a) map.get(XT);
        String j3 = c1816a == null ? "base16" : dh.m9520j(c1816a);
        c1816a = (C1816a) map.get(XR);
        int i = (c1816a == null || !dh.m9526n(c1816a).booleanValue()) ? 2 : 3;
        try {
            byte[] bytes;
            Object d;
            if ("text".equals(j2)) {
                bytes = j.getBytes();
            } else if ("base16".equals(j2)) {
                bytes = C2309j.bm(j);
            } else if ("base64".equals(j2)) {
                bytes = Base64.decode(j, i);
            } else if ("base64url".equals(j2)) {
                bytes = Base64.decode(j, i | 8);
            } else {
                bh.m9373w("Encode: unknown input format: " + j2);
                return dh.lT();
            }
            if ("base16".equals(j3)) {
                d = C2309j.m9552d(bytes);
            } else if ("base64".equals(j3)) {
                d = Base64.encodeToString(bytes, i);
            } else if ("base64url".equals(j3)) {
                d = Base64.encodeToString(bytes, i | 8);
            } else {
                bh.m9373w("Encode: unknown output format: " + j3);
                return dh.lT();
            }
            return dh.m9531r(d);
        } catch (IllegalArgumentException e) {
            bh.m9373w("Encode: invalid input:");
            return dh.lT();
        }
    }
}
