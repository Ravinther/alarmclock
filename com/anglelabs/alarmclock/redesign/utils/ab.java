package com.anglelabs.alarmclock.redesign.utils;

import android.content.res.Resources;
import android.util.TypedValue;

public class ab {
    public static int m3759a(int dp, Resources resources) {
        return (int) TypedValue.applyDimension(1, (float) dp, resources.getDisplayMetrics());
    }

    public static float m3760b(int dp, Resources resources) {
        return TypedValue.applyDimension(1, (float) dp, resources.getDisplayMetrics());
    }

    public static float m3761c(int resId, Resources resources) {
        return resources.getDimension(resId) / resources.getDisplayMetrics().density;
    }
}
