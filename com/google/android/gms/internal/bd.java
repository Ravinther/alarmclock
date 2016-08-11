package com.google.android.gms.internal;

import com.mopub.common.AdUrlGenerator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public final class bd implements bb {
    private final bc mP;

    public bd(bc bcVar) {
        this.mP = bcVar;
    }

    private static boolean m7895a(Map map) {
        return "1".equals(map.get("custom_close"));
    }

    private static int m7896b(Map map) {
        String str = (String) map.get("o");
        if (str != null) {
            if (AdUrlGenerator.DEVICE_ORIENTATION_PORTRAIT.equalsIgnoreCase(str)) {
                return dq.bA();
            }
            if (AdUrlGenerator.DEVICE_ORIENTATION_LANDSCAPE.equalsIgnoreCase(str)) {
                return dq.bz();
            }
        }
        return -1;
    }

    public void m7897b(dz dzVar, Map map) {
        String str = (String) map.get("a");
        if (str == null) {
            dw.m8221z("Action missing from an open GMSG.");
            return;
        }
        ea bI = dzVar.bI();
        if ("expand".equalsIgnoreCase(str)) {
            if (dzVar.bL()) {
                dw.m8221z("Cannot expand WebView that is already expanded.");
            } else {
                bI.m8245a(m7895a(map), m7896b(map));
            }
        } else if ("webapp".equalsIgnoreCase(str)) {
            str = (String) map.get(AdUrlGenerator.DEVICE_ORIENTATION_UNKNOWN);
            if (str != null) {
                bI.m8246a(m7895a(map), m7896b(map), str);
            } else {
                bI.m8247a(m7895a(map), m7896b(map), (String) map.get("html"), (String) map.get("baseurl"));
            }
        } else if ("in_app_purchase".equalsIgnoreCase(str)) {
            str = (String) map.get("product_id");
            String str2 = (String) map.get("report_urls");
            if (this.mP == null) {
                return;
            }
            if (str2 == null || str2.isEmpty()) {
                this.mP.m7894a(str, new ArrayList());
                return;
            }
            this.mP.m7894a(str, new ArrayList(Arrays.asList(str2.split(" "))));
        } else {
            bI.m8240a(new cb((String) map.get("i"), (String) map.get(AdUrlGenerator.DEVICE_ORIENTATION_UNKNOWN), (String) map.get("m"), (String) map.get(AdUrlGenerator.DEVICE_ORIENTATION_PORTRAIT), (String) map.get("c"), (String) map.get("f"), (String) map.get("e")));
        }
    }
}
