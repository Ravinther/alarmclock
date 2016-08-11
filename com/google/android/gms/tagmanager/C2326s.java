package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C1732a;
import com.google.android.gms.internal.C1750b;
import com.google.android.gms.internal.C1817d.C1816a;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.google.android.gms.tagmanager.s */
class C2326s extends aj {
    private static final String ID;
    private static final String WC;
    private static final String Xn;
    private final C2240a Xo;

    /* renamed from: com.google.android.gms.tagmanager.s.a */
    public interface C2240a {
        Object m9270b(String str, Map map);
    }

    static {
        ID = C1732a.FUNCTION_CALL.toString();
        Xn = C1750b.FUNCTION_CALL_NAME.toString();
        WC = C1750b.ADDITIONAL_PARAMS.toString();
    }

    public C2326s(C2240a c2240a) {
        super(ID, Xn);
        this.Xo = c2240a;
    }

    public boolean jX() {
        return false;
    }

    public C1816a m9581x(Map map) {
        String j = dh.m9520j((C1816a) map.get(Xn));
        Map hashMap = new HashMap();
        C1816a c1816a = (C1816a) map.get(WC);
        if (c1816a != null) {
            Object o = dh.m9528o(c1816a);
            if (o instanceof Map) {
                for (Entry entry : ((Map) o).entrySet()) {
                    hashMap.put(entry.getKey().toString(), entry.getValue());
                }
            } else {
                bh.m9376z("FunctionCallMacro: expected ADDITIONAL_PARAMS to be a map.");
                return dh.lT();
            }
        }
        try {
            return dh.m9531r(this.Xo.m9270b(j, hashMap));
        } catch (Exception e) {
            bh.m9376z("Custom macro/tag " + j + " threw exception " + e.getMessage());
            return dh.lT();
        }
    }
}
