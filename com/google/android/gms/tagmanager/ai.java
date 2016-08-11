package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C1788c.C1780c;
import com.google.android.gms.internal.C1788c.C1781d;
import com.google.android.gms.internal.C1788c.C1786i;
import com.google.android.gms.internal.C1817d.C1816a;
import java.util.Map;

class ai {
    private static void m9322a(DataLayer dataLayer, C1781d c1781d) {
        for (C1816a j : c1781d.eS) {
            dataLayer.bv(dh.m9520j(j));
        }
    }

    public static void m9323a(DataLayer dataLayer, C1786i c1786i) {
        if (c1786i.fI == null) {
            bh.m9376z("supplemental missing experimentSupplemental");
            return;
        }
        m9322a(dataLayer, c1786i.fI);
        m9324b(dataLayer, c1786i.fI);
        m9326c(dataLayer, c1786i.fI);
    }

    private static void m9324b(DataLayer dataLayer, C1781d c1781d) {
        for (C1816a c : c1781d.eR) {
            Map c2 = m9325c(c);
            if (c2 != null) {
                dataLayer.push(c2);
            }
        }
    }

    private static Map m9325c(C1816a c1816a) {
        Object o = dh.m9528o(c1816a);
        if (o instanceof Map) {
            return (Map) o;
        }
        bh.m9376z("value: " + o + " is not a map value, ignored.");
        return null;
    }

    private static void m9326c(DataLayer dataLayer, C1781d c1781d) {
        for (C1780c c1780c : c1781d.eT) {
            if (c1780c.eM == null) {
                bh.m9376z("GaExperimentRandom: No key");
            } else {
                Object obj = dataLayer.get(c1780c.eM);
                Long valueOf = !(obj instanceof Number) ? null : Long.valueOf(((Number) obj).longValue());
                long j = c1780c.eN;
                long j2 = c1780c.eO;
                if (!c1780c.eP || valueOf == null || valueOf.longValue() < j || valueOf.longValue() > j2) {
                    if (j <= j2) {
                        obj = Long.valueOf(Math.round((Math.random() * ((double) (j2 - j))) + ((double) j)));
                    } else {
                        bh.m9376z("GaExperimentRandom: random range invalid");
                    }
                }
                dataLayer.bv(c1780c.eM);
                Map c = dataLayer.m9297c(c1780c.eM, obj);
                if (c1780c.eQ > 0) {
                    if (c.containsKey("gtm")) {
                        Object obj2 = c.get("gtm");
                        if (obj2 instanceof Map) {
                            ((Map) obj2).put("lifetime", Long.valueOf(c1780c.eQ));
                        } else {
                            bh.m9376z("GaExperimentRandom: gtm not a map");
                        }
                    } else {
                        c.put("gtm", DataLayer.mapOf("lifetime", Long.valueOf(c1780c.eQ)));
                    }
                }
                dataLayer.push(c);
            }
        }
    }
}
