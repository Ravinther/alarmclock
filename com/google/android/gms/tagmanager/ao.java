package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C1732a;
import com.google.android.gms.internal.C1750b;
import com.google.android.gms.internal.C1817d.C1816a;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

class ao extends aj {
    private static final String ID;
    private static final String XQ;
    private static final String XS;
    private static final String XW;

    static {
        ID = C1732a.HASH.toString();
        XQ = C1750b.ARG0.toString();
        XW = C1750b.ALGORITHM.toString();
        XS = C1750b.INPUT_FORMAT.toString();
    }

    public ao() {
        super(ID, XQ);
    }

    private byte[] m9333c(String str, byte[] bArr) {
        MessageDigest instance = MessageDigest.getInstance(str);
        instance.update(bArr);
        return instance.digest();
    }

    public boolean jX() {
        return true;
    }

    public C1816a m9334x(Map map) {
        C1816a c1816a = (C1816a) map.get(XQ);
        if (c1816a == null || c1816a == dh.lT()) {
            return dh.lT();
        }
        byte[] bytes;
        String j = dh.m9520j(c1816a);
        c1816a = (C1816a) map.get(XW);
        String j2 = c1816a == null ? "MD5" : dh.m9520j(c1816a);
        c1816a = (C1816a) map.get(XS);
        String j3 = c1816a == null ? "text" : dh.m9520j(c1816a);
        if ("text".equals(j3)) {
            bytes = j.getBytes();
        } else if ("base16".equals(j3)) {
            bytes = C2309j.bm(j);
        } else {
            bh.m9373w("Hash: unknown input format: " + j3);
            return dh.lT();
        }
        try {
            return dh.m9531r(C2309j.m9552d(m9333c(j2, bytes)));
        } catch (NoSuchAlgorithmException e) {
            bh.m9373w("Hash: unknown algorithm: " + j2);
            return dh.lT();
        }
    }
}
