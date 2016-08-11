package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.internal.C1732a;
import com.google.android.gms.internal.C1817d.C1816a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.g */
class C2304g extends aj {
    private static final String ID;
    private final Context mContext;

    static {
        ID = C1732a.APP_NAME.toString();
    }

    public C2304g(Context context) {
        super(ID, new String[0]);
        this.mContext = context;
    }

    public boolean jX() {
        return true;
    }

    public C1816a m9549x(Map map) {
        try {
            PackageManager packageManager = this.mContext.getPackageManager();
            return dh.m9531r(packageManager.getApplicationLabel(packageManager.getApplicationInfo(this.mContext.getPackageName(), 0)).toString());
        } catch (Throwable e) {
            bh.m9370b("App name is not found.", e);
            return dh.lT();
        }
    }
}
