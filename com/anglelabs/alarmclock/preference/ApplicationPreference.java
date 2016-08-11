package com.anglelabs.alarmclock.preference;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.preference.Preference;
import android.util.AttributeSet;
import com.alarmclock.xtreme.free.R;

public class ApplicationPreference extends Preference {
    private String f1333a;

    public ApplicationPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f1333a = "";
    }

    public void m2395a(Context context, String packageName) {
        if (packageName == null || packageName.trim().length() <= 0) {
            setSummary("");
            return;
        }
        try {
            this.f1333a = packageName;
            PackageManager packageManager = context.getPackageManager();
            setSummary(packageManager.getApplicationLabel(packageManager.getApplicationInfo(this.f1333a, 0)));
        } catch (NameNotFoundException e) {
            setSummary(context.getString(R.string.no_applications_found));
            e.printStackTrace();
        }
    }
}
