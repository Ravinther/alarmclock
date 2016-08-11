package com.google.android.gms.tagmanager;

import android.os.Build;
import com.google.android.gms.internal.C1732a;
import com.google.android.gms.internal.C1817d.C1816a;
import java.util.Map;

class aa extends aj {
    private static final String ID;

    static {
        ID = C1732a.DEVICE_NAME.toString();
    }

    public aa() {
        super(ID, new String[0]);
    }

    public boolean jX() {
        return true;
    }

    public C1816a m9312x(Map map) {
        String str = Build.MANUFACTURER;
        Object obj = Build.MODEL;
        if (!(obj.startsWith(str) || str.equals("unknown"))) {
            obj = str + " " + obj;
        }
        return dh.m9531r(obj);
    }
}
