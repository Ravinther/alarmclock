package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C1732a;
import java.util.Map;

class ad extends dc {
    private static final String ID;

    static {
        ID = C1732a.ENDS_WITH.toString();
    }

    public ad() {
        super(ID);
    }

    protected boolean m9319a(String str, String str2, Map map) {
        return str.endsWith(str2);
    }
}
