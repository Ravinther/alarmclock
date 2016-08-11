package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C1732a;
import java.util.Map;

class db extends dc {
    private static final String ID;

    static {
        ID = C1732a.STARTS_WITH.toString();
    }

    public db() {
        super(ID);
    }

    protected boolean m9513a(String str, String str2, Map map) {
        return str.startsWith(str2);
    }
}
