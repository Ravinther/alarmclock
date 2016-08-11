package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.C1732a;
import com.google.android.gms.internal.C1817d.C1816a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.b */
class C2261b extends aj {
    private static final String ID;
    private final C2257a Wz;

    static {
        ID = C1732a.ADVERTISER_ID.toString();
    }

    public C2261b(Context context) {
        this(C2257a.m9307E(context));
    }

    C2261b(C2257a c2257a) {
        super(ID, new String[0]);
        this.Wz = c2257a;
    }

    public boolean jX() {
        return false;
    }

    public C1816a m9360x(Map map) {
        String jT = this.Wz.jT();
        return jT == null ? dh.lT() : dh.m9531r(jT);
    }
}
