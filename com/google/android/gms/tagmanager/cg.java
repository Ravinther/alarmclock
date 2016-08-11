package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C1732a;
import com.google.android.gms.internal.C1750b;
import com.google.android.gms.internal.C1817d.C1816a;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

class cg extends aj {
    private static final String ID;
    private static final String YZ;
    private static final String Za;
    private static final String Zb;
    private static final String Zc;

    static {
        ID = C1732a.REGEX_GROUP.toString();
        YZ = C1750b.ARG0.toString();
        Za = C1750b.ARG1.toString();
        Zb = C1750b.IGNORE_CASE.toString();
        Zc = C1750b.GROUP.toString();
    }

    public cg() {
        super(ID, YZ, Za);
    }

    public boolean jX() {
        return true;
    }

    public C1816a m9425x(Map map) {
        C1816a c1816a = (C1816a) map.get(YZ);
        C1816a c1816a2 = (C1816a) map.get(Za);
        if (c1816a == null || c1816a == dh.lT() || c1816a2 == null || c1816a2 == dh.lT()) {
            return dh.lT();
        }
        int intValue;
        int i = 64;
        if (dh.m9526n((C1816a) map.get(Zb)).booleanValue()) {
            i = 66;
        }
        C1816a c1816a3 = (C1816a) map.get(Zc);
        if (c1816a3 != null) {
            Long l = dh.m9522l(c1816a3);
            if (l == dh.lO()) {
                return dh.lT();
            }
            intValue = l.intValue();
            if (intValue < 0) {
                return dh.lT();
            }
        }
        intValue = 1;
        try {
            CharSequence j = dh.m9520j(c1816a);
            Object obj = null;
            Matcher matcher = Pattern.compile(dh.m9520j(c1816a2), i).matcher(j);
            if (matcher.find() && matcher.groupCount() >= intValue) {
                obj = matcher.group(intValue);
            }
            return obj == null ? dh.lT() : dh.m9531r(obj);
        } catch (PatternSyntaxException e) {
            return dh.lT();
        }
    }
}
