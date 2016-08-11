package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C1732a;
import com.google.android.gms.internal.C1750b;
import com.google.android.gms.internal.C1817d.C1816a;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

class ch extends dc {
    private static final String ID;
    private static final String Zb;

    static {
        ID = C1732a.REGEX.toString();
        Zb = C1750b.IGNORE_CASE.toString();
    }

    public ch() {
        super(ID);
    }

    protected boolean m9426a(String str, String str2, Map map) {
        try {
            return Pattern.compile(str2, dh.m9526n((C1816a) map.get(Zb)).booleanValue() ? 66 : 64).matcher(str).find();
        } catch (PatternSyntaxException e) {
            return false;
        }
    }
}
