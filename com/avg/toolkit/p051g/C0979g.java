package com.avg.toolkit.p051g;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.avg.toolkit.p050f.C0971a;

/* renamed from: com.avg.toolkit.g.g */
public class C0979g {
    private static SharedPreferences m4356i(Context appContext) {
        return appContext.getSharedPreferences("ua_prefs", 0);
    }

    public static void m4345a(Context appContext) {
        C0971a.m4330a(appContext, "ua_user_name", "");
        C0971a.m4330a(appContext, "ua_id", "");
        C0971a.m4330a(appContext, "ua_hash", "");
    }

    public static String m4347b(Context appContext) {
        return C0979g.m4356i(appContext).getString("transactionId", "");
    }

    public static String m4349c(Context appContext) {
        return C0979g.m4356i(appContext).getString("productId", "");
    }

    public static String m4351d(Context appContext) {
        return C0979g.m4356i(appContext).getString("purchase_token", "");
    }

    public static void m4352e(Context appContext) {
        Editor editor = C0979g.m4356i(appContext).edit();
        editor.remove("transactionId");
        editor.remove("productId");
        editor.remove("purchase_token");
        editor.commit();
    }

    public static String m4353f(Context appContext) {
        return C0971a.m4329a(appContext, "ua_id");
    }

    public static void m4346a(Context appContext, String uaID) {
        C0971a.m4330a(appContext, "ua_id", uaID);
    }

    public static String m4354g(Context appContext) {
        return C0971a.m4329a(appContext, "ua_hash");
    }

    public static void m4348b(Context appContext, String uaHash) {
        C0971a.m4330a(appContext, "ua_hash", uaHash);
    }

    public static boolean m4355h(Context appContext) {
        return !"".equals(C0979g.m4353f(appContext));
    }

    public static void m4350c(Context appContext, String uaUserName) {
        C0971a.m4330a(appContext, "ua_user_name", uaUserName);
    }
}
