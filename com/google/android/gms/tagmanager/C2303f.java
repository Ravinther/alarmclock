package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.C1732a;
import com.google.android.gms.internal.C1817d.C1816a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.f */
class C2303f extends aj {
    private static final String ID;
    private final Context mContext;

    static {
        ID = C1732a.APP_ID.toString();
    }

    public C2303f(Context context) {
        super(ID, new String[0]);
        this.mContext = context;
    }

    public boolean jX() {
        return true;
    }

    public C1816a m9548x(Map map) {
        return dh.m9531r(this.mContext.getPackageName());
    }
}
