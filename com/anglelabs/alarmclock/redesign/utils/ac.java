package com.anglelabs.alarmclock.redesign.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.anglelabs.alarmclock.redesign.alarm.AlarmService;
import com.anglelabs.alarmclock.redesign.alarm.AlarmStateManager;
import com.anglelabs.alarmclock.redesign.alarm.C0646d;
import com.anglelabs.alarmclock.redesign.model.C0773a;
import com.anglelabs.alarmclock.redesign.model.RedesignAlarm;
import com.anglelabs.alarmclock.redesign.p039d.C0694b;
import com.anglelabs.alarmclock.redesign.utils.C0830k.C0824l;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.drive.DriveFile;

public class ac {

    /* renamed from: com.anglelabs.alarmclock.redesign.utils.ac.a */
    public static class C0791a {
        public static void m3762a(Activity activity) {
            activity.getWindow().addFlags(2097152);
        }

        public static void m3763b(Activity activity) {
            if (!C0810h.m3835a()) {
                activity.getWindow().addFlags(4718592);
            }
        }

        public static void m3764c(Activity activity) {
            activity.getWindow().clearFlags(6291584);
        }

        public static void m3765d(Activity activity) {
            if (!Build.PRODUCT.startsWith("NOOK")) {
                activity.getWindow().addFlags(Cast.MAX_NAMESPACE_LENGTH);
            }
        }
    }

    public static void m3768a(Context context, View view) {
        view.requestFocus();
        ((InputMethodManager) context.getSystemService("input_method")).showSoftInput(view, 0);
    }

    public static void m3775b(Context context, View view) {
        ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(view.getApplicationWindowToken(), 0);
    }

    public static void m3767a(Context context) {
        m3771a(context, "utm_source%3DACXF%26utm_medium%3DInAppBanner%26utm_campaign%3DNoAds");
    }

    public static void m3771a(Context context, String referrer) {
        Intent upgradeIntent;
        try {
            upgradeIntent = C0832m.m3907a();
            if (context instanceof Activity) {
                upgradeIntent.addFlags(DriveFile.MODE_READ_ONLY);
            }
            context.startActivity(upgradeIntent);
        } catch (Exception e) {
            C0850q.m3986a("Market app not installed.");
            upgradeIntent = C0832m.m3915a(referrer);
            if (context instanceof Activity) {
                upgradeIntent.addFlags(DriveFile.MODE_READ_ONLY);
            }
            context.startActivity(upgradeIntent);
        }
    }

    public static SharedPreferences m3774b(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
    }

    public static void m3770a(Context context, RedesignAlarm alarm, int hour, int minutes) {
        RedesignAlarm previewAlarm = C0694b.m3134a(context, alarm);
        previewAlarm.m3612a(hour, minutes, new C0773a(0));
        previewAlarm.m3618d(context);
        m3769a(context, previewAlarm);
    }

    private static void m3769a(Context context, RedesignAlarm previewAlarm) {
        C0646d.m2982b(context, previewAlarm.f2010k, true);
        C0646d.m2986e(context, previewAlarm.f2010k);
        context.startActivity(C0832m.m3922c(context, previewAlarm));
        AlarmService.m2773b(context, previewAlarm);
        C0830k.m3896a(context, C0824l.Preview);
    }

    public static boolean m3773a(SharedPreferences prefs, RedesignAlarm alarm) {
        boolean isVacationMode = C0860w.m4036a(prefs);
        boolean showToastAtVacationMode;
        if (!isVacationMode || alarm.f2005f.m3661c()) {
            showToastAtVacationMode = false;
        } else {
            showToastAtVacationMode = true;
        }
        if (!isVacationMode || showToastAtVacationMode) {
            return true;
        }
        return false;
    }

    public static void m3772a(Context context, boolean enable) {
        C0860w.m4032a(context, enable);
        AlarmStateManager.m2789a(context, false);
    }

    public static CharSequence m3766a(String fullString, String stringToColor, int color) {
        int startIndex = fullString.lastIndexOf(stringToColor);
        int endIndex = startIndex + stringToColor.length();
        if (startIndex < 0) {
            return fullString;
        }
        SpannableString spannableString = new SpannableString(fullString);
        spannableString.setSpan(new ForegroundColorSpan(color), startIndex, endIndex, 0);
        return spannableString;
    }
}
