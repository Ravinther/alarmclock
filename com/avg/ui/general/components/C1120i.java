package com.avg.ui.general.components;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.widget.Toast;
import com.avg.toolkit.license.C1017a;
import com.avg.toolkit.p034b.C0956f;
import com.avg.toolkit.p047a.C0905a;
import com.avg.toolkit.p049e.C0970a;
import com.avg.ui.general.C1091c.C1085i;

/* renamed from: com.avg.ui.general.components.i */
public class C1120i {
    public static void m4751a(Context context, C1017a avgFeatures, String source) {
        if (C1120i.m4752a(context)) {
            C1120i.m4753b(context, avgFeatures, source);
        } else {
            C1120i.m4754c(context, avgFeatures, source);
        }
    }

    public static boolean m4752a(Context context) {
        try {
            PackageManager pm = context.getPackageManager();
            if (pm == null) {
                return true;
            }
            pm.getPackageInfo("com.avg.zen", 1);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static void m4753b(Context context, C1017a avgFeatures, String source) {
        Intent launchIntent = null;
        try {
            if (context.getPackageManager() != null) {
                launchIntent = context.getPackageManager().getLaunchIntentForPackage("com.avg.zen");
            }
            if (launchIntent != null) {
                context.startActivity(launchIntent);
            }
        } catch (Exception e) {
            C0970a.m4325b("Unable to start zen admin activity");
            C1120i.m4754c(context, avgFeatures, source);
        }
    }

    private static void m4754c(Context context, C1017a avgFeatures, String source) {
        try {
            String url;
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.BROWSABLE");
            intent.setFlags(335544320);
            if (avgFeatures.m4428c()) {
                url = C1120i.m4755d(context, avgFeatures, source);
                StringBuilder append = new StringBuilder().append(new C0956f(context).m4297a());
                if (url == null) {
                    url = "";
                }
                url = append.append(url).toString();
            } else {
                url = "market://details?id=com.avg.zen";
            }
            intent.setData(Uri.parse(url));
            if (context.getPackageManager().queryIntentActivities(intent, 0).size() == 0) {
                intent.setPackage(null);
                intent.removeExtra("com.android.browser.application_id");
            }
            context.startActivity(intent);
        } catch (NullPointerException e) {
            if (context != null) {
                Toast.makeText(context.getApplicationContext(), context.getString(C1085i.connection_error), 1).show();
            }
        }
    }

    private static String m4755d(Context context, C1017a avgFeatures, String source) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("/purchase/cross?sid=" + C0905a.m4154a().m4151a());
            sb.append("&pid=545");
            sb.append("&varCode=" + avgFeatures.f3120f);
            sb.append("&scr=" + source);
            return sb.toString();
        } catch (Exception e) {
            if (context != null) {
                Toast.makeText(context.getApplicationContext(), context.getString(C1085i.connection_error), 1).show();
            }
            C0970a.m4322a(e);
            return "";
        }
    }
}
