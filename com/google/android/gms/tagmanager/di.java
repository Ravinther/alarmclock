package com.google.android.gms.tagmanager;

import android.content.Context;
import com.avg.toolkit.ITKSvc;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.internal.C1732a;
import com.google.android.gms.internal.C1750b;
import com.google.android.gms.internal.C1817d.C1816a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class di extends df {
    private static final String ID;
    private static final String aaO;
    private static final String aaP;
    private static final String aaQ;
    private static final String aaR;
    private static final String aaS;
    private static final String aaT;
    private static Map aaU;
    private static Map aaV;
    private final DataLayer WK;
    private final Set aaW;
    private final de aaX;

    static {
        ID = C1732a.UNIVERSAL_ANALYTICS.toString();
        aaO = C1750b.ACCOUNT.toString();
        aaP = C1750b.ANALYTICS_PASS_THROUGH.toString();
        aaQ = C1750b.ANALYTICS_FIELDS.toString();
        aaR = C1750b.TRACK_TRANSACTION.toString();
        aaS = C1750b.TRANSACTION_DATALAYER_MAP.toString();
        aaT = C1750b.TRANSACTION_ITEM_DATALAYER_MAP.toString();
    }

    public di(Context context, DataLayer dataLayer) {
        this(context, dataLayer, new de(context));
    }

    di(Context context, DataLayer dataLayer, de deVar) {
        super(ID, new String[0]);
        this.WK = dataLayer;
        this.aaX = deVar;
        this.aaW = new HashSet();
        this.aaW.add("");
        this.aaW.add(ITKSvc.CODEREVISION);
        this.aaW.add("false");
    }

    private Map m9535H(Map map) {
        C1816a c1816a = (C1816a) map.get(aaS);
        if (c1816a != null) {
            return m9539c(c1816a);
        }
        if (aaU == null) {
            Map hashMap = new HashMap();
            hashMap.put("transactionId", "&ti");
            hashMap.put("transactionAffiliation", "&ta");
            hashMap.put("transactionTax", "&tt");
            hashMap.put("transactionShipping", "&ts");
            hashMap.put("transactionTotal", "&tr");
            hashMap.put("transactionCurrency", "&cu");
            aaU = hashMap;
        }
        return aaU;
    }

    private Map m9536I(Map map) {
        C1816a c1816a = (C1816a) map.get(aaT);
        if (c1816a != null) {
            return m9539c(c1816a);
        }
        if (aaV == null) {
            Map hashMap = new HashMap();
            hashMap.put("name", "&in");
            hashMap.put("sku", "&ic");
            hashMap.put("category", "&iv");
            hashMap.put("price", "&ip");
            hashMap.put("quantity", "&iq");
            hashMap.put("currency", "&cu");
            aaV = hashMap;
        }
        return aaV;
    }

    private void m9537a(Tracker tracker, Map map) {
        String cc = cc("transactionId");
        if (cc == null) {
            bh.m9373w("Cannot find transactionId in data layer.");
            return;
        }
        List<Map> linkedList = new LinkedList();
        try {
            Map p = m9541p((C1816a) map.get(aaQ));
            p.put("&t", "transaction");
            for (Entry entry : m9535H(map).entrySet()) {
                m9538b(p, (String) entry.getValue(), cc((String) entry.getKey()));
            }
            linkedList.add(p);
            List<Map> lU = lU();
            if (lU != null) {
                for (Map map2 : lU) {
                    if (map2.get("name") == null) {
                        bh.m9373w("Unable to send transaction item hit due to missing 'name' field.");
                        return;
                    }
                    Map p2 = m9541p((C1816a) map.get(aaQ));
                    p2.put("&t", "item");
                    p2.put("&ti", cc);
                    for (Entry entry2 : m9536I(map).entrySet()) {
                        m9538b(p2, (String) entry2.getValue(), (String) map2.get(entry2.getKey()));
                    }
                    linkedList.add(p2);
                }
            }
            for (Map map22 : linkedList) {
                tracker.send(map22);
            }
        } catch (Throwable e) {
            bh.m9370b("Unable to send transaction", e);
        }
    }

    private void m9538b(Map map, String str, String str2) {
        if (str2 != null) {
            map.put(str, str2);
        }
    }

    private Map m9539c(C1816a c1816a) {
        Object o = dh.m9528o(c1816a);
        if (!(o instanceof Map)) {
            return null;
        }
        Map map = (Map) o;
        Map linkedHashMap = new LinkedHashMap();
        for (Entry entry : map.entrySet()) {
            linkedHashMap.put(entry.getKey().toString(), entry.getValue().toString());
        }
        return linkedHashMap;
    }

    private String cc(String str) {
        Object obj = this.WK.get(str);
        return obj == null ? null : obj.toString();
    }

    private boolean m9540e(Map map, String str) {
        C1816a c1816a = (C1816a) map.get(str);
        return c1816a == null ? false : dh.m9526n(c1816a).booleanValue();
    }

    private List lU() {
        Object obj = this.WK.get("transactionProducts");
        if (obj == null) {
            return null;
        }
        if (obj instanceof List) {
            for (Object obj2 : (List) obj) {
                if (!(obj2 instanceof Map)) {
                    throw new IllegalArgumentException("Each element of transactionProducts should be of type Map.");
                }
            }
            return (List) obj;
        }
        throw new IllegalArgumentException("transactionProducts should be of type List.");
    }

    private Map m9541p(C1816a c1816a) {
        if (c1816a == null) {
            return new HashMap();
        }
        Map c = m9539c(c1816a);
        if (c == null) {
            return new HashMap();
        }
        String str = (String) c.get("&aip");
        if (str != null && this.aaW.contains(str.toLowerCase())) {
            c.remove("&aip");
        }
        return c;
    }

    public void m9542z(Map map) {
        Tracker bU = this.aaX.bU("_GTM_DEFAULT_TRACKER_");
        if (m9540e(map, aaP)) {
            bU.send(m9541p((C1816a) map.get(aaQ)));
        } else if (m9540e(map, aaR)) {
            m9537a(bU, map);
        } else {
            bh.m9376z("Ignoring unknown tag.");
        }
    }
}
