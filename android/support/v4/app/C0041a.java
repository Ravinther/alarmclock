package android.support.v4.app;

import android.app.Activity;
import android.os.Build.VERSION;
import android.support.v4.p006a.C0008b;

/* renamed from: android.support.v4.app.a */
public class C0041a extends C0008b {
    public static void m136a(Activity activity) {
        if (VERSION.SDK_INT >= 16) {
            C0059d.m178a(activity);
        } else {
            activity.finish();
        }
    }

    public static void m137b(Activity activity) {
        if (VERSION.SDK_INT >= 21) {
            C0057b.m176a(activity);
        } else {
            activity.finish();
        }
    }
}
