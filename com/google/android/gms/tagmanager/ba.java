package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C1750b;
import com.google.android.gms.internal.C1817d.C1816a;
import com.google.android.gms.tagmanager.cq.C2281a;
import com.google.android.gms.tagmanager.cq.C2283c;
import com.google.android.gms.tagmanager.cq.C2284d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

class ba {
    public static C2283c bG(String str) {
        C1816a k = m9361k(new JSONObject(str));
        C2284d lh = C2283c.lh();
        for (int i = 0; i < k.fP.length; i++) {
            lh.m9447a(C2281a.ld().m9445b(C1750b.INSTANCE_NAME.toString(), k.fP[i]).m9445b(C1750b.FUNCTION.toString(), dh.bX(C2312m.ka())).m9445b(C2312m.kb(), k.fQ[i]).lg());
        }
        return lh.lk();
    }

    private static C1816a m9361k(Object obj) {
        return dh.m9531r(m9362l(obj));
    }

    static Object m9362l(Object obj) {
        if (obj instanceof JSONArray) {
            throw new RuntimeException("JSONArrays are not supported");
        } else if (JSONObject.NULL.equals(obj)) {
            throw new RuntimeException("JSON nulls are not supported");
        } else if (!(obj instanceof JSONObject)) {
            return obj;
        } else {
            JSONObject jSONObject = (JSONObject) obj;
            Map hashMap = new HashMap();
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                hashMap.put(str, m9362l(jSONObject.get(str)));
            }
            return hashMap;
        }
    }
}
