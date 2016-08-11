package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C1732a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.q */
class C2324q extends dc {
    private static final String ID;

    static {
        ID = C1732a.CONTAINS.toString();
    }

    public C2324q() {
        super(ID);
    }

    protected boolean m9580a(String str, String str2, Map map) {
        return str.contains(str2);
    }
}
