package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.C1732a;
import com.google.android.gms.internal.C1817d.C1816a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.c */
class C2267c extends aj {
    private static final String ID;
    private final C2257a Wz;

    static {
        ID = C1732a.ADVERTISING_TRACKING_ENABLED.toString();
    }

    public C2267c(Context context) {
        this(C2257a.m9307E(context));
    }

    C2267c(C2257a c2257a) {
        super(ID, new String[0]);
        this.Wz = c2257a;
    }

    public boolean jX() {
        return false;
    }

    public C1816a m9399x(Map map) {
        return dh.m9531r(Boolean.valueOf(!this.Wz.isLimitAdTrackingEnabled()));
    }
}
