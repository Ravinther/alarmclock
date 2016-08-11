package com.avg.toolkit.zen;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.avg.toolkit.p050f.C0971a;
import com.avg.toolkit.p051g.C0979g;
import com.avg.toolkit.zen.p054a.C1038d;

/* renamed from: com.avg.toolkit.zen.e */
public class C1050e {
    private static SharedPreferences m4571u(Context appContext) {
        return appContext.getSharedPreferences("zen_prefs", 0);
    }

    public static String m4539a(Context appContext) {
        return C1050e.m4567q(appContext) ? C1050e.m4561k(appContext) : C1050e.m4559j(appContext);
    }

    public static String m4542b(Context appContext) {
        return C1050e.m4567q(appContext) ? C1050e.m4564n(appContext) : C1050e.m4563m(appContext);
    }

    public static String m4545c(Context appContext) {
        return C1050e.m4567q(appContext) ? C1050e.m4566p(appContext) : C1050e.m4565o(appContext);
    }

    public static String m4547d(Context appContext) {
        return C1050e.m4567q(appContext) ? C1050e.m4555h(appContext) : C1050e.m4557i(appContext);
    }

    public static void m4541a(Context appContext, boolean active) {
        Editor editor = C1050e.m4571u(appContext).edit();
        editor.putBoolean("available_reports", active);
        editor.commit();
    }

    public static boolean m4550e(Context appContext) {
        return C1050e.m4571u(appContext).getBoolean("available_reports", false);
    }

    public static void m4540a(Context appContext, String id) {
        Editor editor = C1050e.m4571u(appContext).edit();
        editor.putString("gcm_id", id);
        editor.putBoolean("new_gcm_id", true);
        editor.commit();
    }

    public static String m4551f(Context appContext) {
        return C1050e.m4571u(appContext).getString("gcm_id", "");
    }

    public static boolean m4554g(Context appContext) {
        return C1050e.m4571u(appContext).getBoolean("new_gcm_id", false);
    }

    public static void m4544b(Context appContext, boolean isNew) {
        Editor editor = C1050e.m4571u(appContext).edit();
        editor.putBoolean("new_gcm_id", isNew);
        editor.commit();
    }

    public static void m4543b(Context appContext, String name) {
        C0971a.m4330a(appContext, "joined_login_name", name);
    }

    public static String m4555h(Context appContext) {
        return C0971a.m4329a(appContext, "joined_login_name");
    }

    public static void m4546c(Context appContext, String name) {
        C0971a.m4330a(appContext, "login_name", name);
    }

    public static String m4557i(Context appContext) {
        return C0971a.m4329a(appContext, "login_name");
    }

    public static void m4548d(Context appContext, String id) {
        C0971a.m4330a(appContext, "zen_id", id);
    }

    public static String m4559j(Context appContext) {
        return C0971a.m4329a(appContext, "zen_id");
    }

    public static void m4549e(Context appContext, String id) {
        C0971a.m4330a(appContext, "joined_zen_id", id);
    }

    public static String m4561k(Context appContext) {
        return C0971a.m4329a(appContext, "joined_zen_id");
    }

    public static void m4552f(Context appContext, String token) {
        C0971a.m4330a(appContext, "admin_token", token);
    }

    public static String m4562l(Context appContext) {
        return C0971a.m4329a(appContext, "admin_token");
    }

    public static void m4553g(Context appContext, String id) {
        C0971a.m4330a(appContext, "device_id", id);
    }

    public static String m4563m(Context appContext) {
        return C0971a.m4329a(appContext, "device_id");
    }

    public static void m4556h(Context appContext, String id) {
        C0971a.m4330a(appContext, "joined_device_id", id);
    }

    public static String m4564n(Context appContext) {
        return C0971a.m4329a(appContext, "joined_device_id");
    }

    public static void m4558i(Context appContext, String token) {
        C0971a.m4330a(appContext, "device_token", token);
    }

    public static String m4565o(Context appContext) {
        return C0971a.m4329a(appContext, "device_token");
    }

    public static void m4560j(Context appContext, String token) {
        C0971a.m4330a(appContext, "joined_device_token", token);
    }

    public static String m4566p(Context appContext) {
        return C0971a.m4329a(appContext, "joined_device_token");
    }

    public static boolean m4567q(Context appContext) {
        return ("".equals(C1050e.m4561k(appContext)) || "".equals(C1050e.m4564n(appContext)) || "".equals(C1050e.m4566p(appContext))) ? false : true;
    }

    public static boolean m4568r(Context appcontext) {
        return !"".equals(C1050e.m4539a(appcontext));
    }

    public static void m4569s(Context appContext) {
        C0971a.m4330a(appContext, "joined_login_name", "");
        C0971a.m4330a(appContext, "joined_zen_id", "");
        C0971a.m4330a(appContext, "joined_device_id", "");
        C0971a.m4330a(appContext, "joined_device_token", "");
        C0971a.m4330a(appContext, "zen_id", "");
        C0971a.m4330a(appContext, "admin_token", "");
        C0971a.m4330a(appContext, "device_id", "");
        C0971a.m4330a(appContext, "device_token", "");
        C0971a.m4330a(appContext, "login_name", "");
        C0979g.m4345a(appContext);
        C1038d.m4521a(appContext, false);
    }

    public static boolean m4570t(Context appContext) {
        return "com.avg.zen".equals(appContext.getPackageName());
    }
}
