package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import java.util.HashMap;
import java.util.Map;

class ay {
    private static String Yk;
    static Map Yl;

    static {
        Yl = new HashMap();
    }

    ay() {
    }

    static void bF(String str) {
        synchronized (ay.class) {
            Yk = str;
        }
    }

    static void m9351c(Context context, String str) {
        cy.m9503a(context, "gtm_install_referrer", "referrer", str);
        m9354e(context, str);
    }

    static String m9352d(Context context, String str) {
        if (Yk == null) {
            synchronized (ay.class) {
                if (Yk == null) {
                    SharedPreferences sharedPreferences = context.getSharedPreferences("gtm_install_referrer", 0);
                    if (sharedPreferences != null) {
                        Yk = sharedPreferences.getString("referrer", "");
                    } else {
                        Yk = "";
                    }
                }
            }
        }
        return m9355m(Yk, str);
    }

    static String m9353e(Context context, String str, String str2) {
        String str3 = (String) Yl.get(str);
        if (str3 == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("gtm_click_referrers", 0);
            str3 = sharedPreferences != null ? sharedPreferences.getString(str, "") : "";
            Yl.put(str, str3);
        }
        return m9355m(str3, str2);
    }

    static void m9354e(Context context, String str) {
        String m = m9355m(str, "conv");
        if (m != null && m.length() > 0) {
            Yl.put(m, str);
            cy.m9503a(context, "gtm_click_referrers", m, str);
        }
    }

    static String m9355m(String str, String str2) {
        return str2 == null ? str.length() > 0 ? str : null : Uri.parse("http://hostname/?" + str).getQueryParameter(str2);
    }
}
