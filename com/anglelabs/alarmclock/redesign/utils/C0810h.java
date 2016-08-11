package com.anglelabs.alarmclock.redesign.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import com.alarmclock.xtreme.free.R;
import com.anglelabs.alarmclock.redesign.activities.RedesignChooseBackgroundActivity;
import com.avg.toolkit.p049e.C0970a;
import java.util.Locale;

/* renamed from: com.anglelabs.alarmclock.redesign.utils.h */
public class C0810h {
    public static final boolean f2127a;
    public static final boolean f2128b;
    public static final boolean f2129c;
    public static final boolean f2130d;
    public static final boolean f2131e;
    private static volatile Boolean f2132f;
    private static final Object f2133g;

    static {
        boolean z;
        boolean z2 = true;
        f2127a = VERSION.SDK_INT >= 19;
        if (VERSION.SDK_INT >= 13) {
            z = true;
        } else {
            z = false;
        }
        f2128b = z;
        if (VERSION.SDK_INT >= 11) {
            z = true;
        } else {
            z = false;
        }
        f2129c = z;
        if (VERSION.SDK_INT >= 14) {
            z = true;
        } else {
            z = false;
        }
        f2130d = z;
        if (VERSION.SDK_INT < 16) {
            z2 = false;
        }
        f2131e = z2;
        f2133g = new Object();
    }

    public static final boolean m3835a() {
        return Build.BRAND.equalsIgnoreCase("Amazon") || Build.MODEL.startsWith("Kindle");
    }

    public static boolean m3836a(Context context) {
        boolean z = true;
        Boolean isSmall = f2132f;
        if (isSmall == null) {
            synchronized (f2133g) {
                isSmall = f2132f;
                if (isSmall == null) {
                    if ((context.getApplicationContext().getResources().getConfiguration().screenLayout & 15) != 1) {
                        z = false;
                    }
                    Boolean isSmall2 = Boolean.valueOf(z);
                    f2132f = isSmall2;
                    isSmall = isSmall2;
                }
            }
        }
        return isSmall.booleanValue();
    }

    public static void m3833a(Context context, SharedPreferences prefs) {
        try {
            String languageCodePref = prefs.getString("language", context.getString(R.string.language_default));
            if (languageCodePref.equals(context.getString(R.string.language_default))) {
                languageCodePref = Locale.getDefault().toString();
            }
            Resources res = context.getResources();
            Configuration conf = res.getConfiguration();
            String country = null;
            if (languageCodePref != null && languageCodePref.contains("_")) {
                country = languageCodePref.substring(3);
            }
            if (languageCodePref != null && country == null) {
                conf.locale = new Locale(languageCodePref);
            } else if (languageCodePref != null) {
                conf.locale = new Locale(languageCodePref.substring(0, 2), country);
            }
            res.updateConfiguration(conf, res.getDisplayMetrics());
        } catch (Exception e) {
            C0970a.m4322a(e);
        }
    }

    public static Locale m3837b(Context context) {
        return context.getResources().getConfiguration().locale;
    }

    public static boolean m3838c(Context context) {
        return ac.m3774b(context).getBoolean("tos_oked", false);
    }

    public static void m3834a(Context context, boolean accepted) {
        ac.m3774b(context).edit().putBoolean("tos_oked", accepted).commit();
    }

    public static boolean m3839d(Context context) {
        return !ac.m3774b(context).contains("tos_oked");
    }

    public static void m3832a(Activity activity) {
        if (activity != null) {
            try {
                C0831l.m3905a(activity, RedesignChooseBackgroundActivity.m2709a((Context) activity));
            } catch (Exception e) {
                C0850q.m3984a(e);
                try {
                    C0831l.m3905a(activity, RedesignChooseBackgroundActivity.m2714b((Context) activity));
                } catch (Exception e1) {
                    C0850q.m3984a(e1);
                    activity.getWindow().setBackgroundDrawableResource(R.color.black);
                }
            }
        }
    }
}
