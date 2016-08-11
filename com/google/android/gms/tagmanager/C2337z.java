package com.google.android.gms.tagmanager;

import android.content.Context;
import android.provider.Settings.Secure;
import com.google.android.gms.internal.C1732a;
import com.google.android.gms.internal.C1817d.C1816a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.z */
class C2337z extends aj {
    private static final String ID;
    private final Context mContext;

    static {
        ID = C1732a.DEVICE_ID.toString();
    }

    public C2337z(Context context) {
        super(ID, new String[0]);
        this.mContext = context;
    }

    protected String m9611G(Context context) {
        return Secure.getString(context.getContentResolver(), "android_id");
    }

    public boolean jX() {
        return true;
    }

    public C1816a m9612x(Map map) {
        String G = m9611G(this.mContext);
        return G == null ? dh.lT() : dh.m9531r(G);
    }
}
