package android.support.v4.app;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;

/* renamed from: android.support.v4.app.q */
class C0099q {
    public static Intent m441a(Activity activity) {
        return activity.getParentActivityIntent();
    }

    public static boolean m443a(Activity activity, Intent targetIntent) {
        return activity.shouldUpRecreateTask(targetIntent);
    }

    public static void m444b(Activity activity, Intent upIntent) {
        activity.navigateUpTo(upIntent);
    }

    public static String m442a(ActivityInfo info) {
        return info.parentActivityName;
    }
}
