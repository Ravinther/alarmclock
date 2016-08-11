package com.avg.toolkit.license;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.avg.toolkit.p049e.C0970a;

/* renamed from: com.avg.toolkit.license.f */
public class C1026f {
    public boolean m4471a(Context context) {
        return m4472b(context) || m4473c(context) || m4474d(context);
    }

    public boolean m4472b(Context context) {
        return m4470a("org.antivirus.plugin.app_locker", context);
    }

    public boolean m4473c(Context context) {
        return m4470a("org.antivirus_feature.feature", context);
    }

    public boolean m4474d(Context context) {
        return m4470a("org.antivirus.plugin.trial_to_pro", context);
    }

    private boolean m4470a(String packageName, Context context) {
        PackageManager pm = context.getPackageManager();
        try {
            if (pm.checkSignatures(context.getPackageName(), pm.getPackageInfo(packageName, 0).packageName) == 0) {
                return true;
            }
            return false;
        } catch (NameNotFoundException e) {
            return false;
        } catch (Exception e2) {
            C0970a.m4322a(e2);
            return false;
        }
    }
}
