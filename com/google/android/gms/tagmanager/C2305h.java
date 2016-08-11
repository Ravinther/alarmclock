package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.internal.C1732a;
import com.google.android.gms.internal.C1817d.C1816a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.h */
class C2305h extends aj {
    private static final String ID;
    private final Context mContext;

    static {
        ID = C1732a.APP_VERSION.toString();
    }

    public C2305h(Context context) {
        super(ID, new String[0]);
        this.mContext = context;
    }

    public boolean jX() {
        return true;
    }

    public C1816a m9550x(Map map) {
        try {
            return dh.m9531r(Integer.valueOf(this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0).versionCode));
        } catch (NameNotFoundException e) {
            bh.m9373w("Package name " + this.mContext.getPackageName() + " not found. " + e.getMessage());
            return dh.lT();
        }
    }
}
