package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.support.v4.p006a.C0016f;
import android.util.Log;
import com.google.android.gms.cast.Cast;

/* renamed from: android.support.v4.app.p */
public class C0098p {
    private static final C0095a f286a;

    /* renamed from: android.support.v4.app.p.a */
    interface C0095a {
        Intent m422a(Activity activity);

        String m423a(Context context, ActivityInfo activityInfo);

        boolean m424a(Activity activity, Intent intent);

        void m425b(Activity activity, Intent intent);
    }

    /* renamed from: android.support.v4.app.p.b */
    static class C0096b implements C0095a {
        C0096b() {
        }

        public Intent m426a(Activity activity) {
            Intent intent = null;
            String parentName = C0098p.m438b(activity);
            if (parentName != null) {
                ComponentName target = new ComponentName(activity, parentName);
                try {
                    intent = C0098p.m439b((Context) activity, target) == null ? C0016f.m105a(target) : new Intent().setComponent(target);
                } catch (NameNotFoundException e) {
                    Log.e("NavUtils", "getParentActivityIntent: bad parentActivityName '" + parentName + "' in manifest");
                }
            }
            return intent;
        }

        public boolean m428a(Activity activity, Intent targetIntent) {
            String action = activity.getIntent().getAction();
            return (action == null || action.equals("android.intent.action.MAIN")) ? false : true;
        }

        public void m429b(Activity activity, Intent upIntent) {
            upIntent.addFlags(67108864);
            activity.startActivity(upIntent);
            activity.finish();
        }

        public String m427a(Context context, ActivityInfo info) {
            if (info.metaData == null) {
                return null;
            }
            String parentActivity = info.metaData.getString("android.support.PARENT_ACTIVITY");
            if (parentActivity == null) {
                return null;
            }
            if (parentActivity.charAt(0) == '.') {
                return context.getPackageName() + parentActivity;
            }
            return parentActivity;
        }
    }

    /* renamed from: android.support.v4.app.p.c */
    static class C0097c extends C0096b {
        C0097c() {
        }

        public Intent m430a(Activity activity) {
            Intent result = C0099q.m441a(activity);
            if (result == null) {
                return m433b(activity);
            }
            return result;
        }

        Intent m433b(Activity activity) {
            return super.m426a(activity);
        }

        public boolean m432a(Activity activity, Intent targetIntent) {
            return C0099q.m443a(activity, targetIntent);
        }

        public void m434b(Activity activity, Intent upIntent) {
            C0099q.m444b(activity, upIntent);
        }

        public String m431a(Context context, ActivityInfo info) {
            String result = C0099q.m442a(info);
            if (result == null) {
                return super.m427a(context, info);
            }
            return result;
        }
    }

    static {
        if (VERSION.SDK_INT >= 16) {
            f286a = new C0097c();
        } else {
            f286a = new C0096b();
        }
    }

    public static boolean m437a(Activity sourceActivity, Intent targetIntent) {
        return f286a.m424a(sourceActivity, targetIntent);
    }

    public static void m440b(Activity sourceActivity, Intent upIntent) {
        f286a.m425b(sourceActivity, upIntent);
    }

    public static Intent m435a(Activity sourceActivity) {
        return f286a.m422a(sourceActivity);
    }

    public static Intent m436a(Context context, ComponentName componentName) {
        String parentActivity = C0098p.m439b(context, componentName);
        if (parentActivity == null) {
            return null;
        }
        ComponentName target = new ComponentName(componentName.getPackageName(), parentActivity);
        return C0098p.m439b(context, target) == null ? C0016f.m105a(target) : new Intent().setComponent(target);
    }

    public static String m438b(Activity sourceActivity) {
        try {
            return C0098p.m439b((Context) sourceActivity, sourceActivity.getComponentName());
        } catch (NameNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static String m439b(Context context, ComponentName componentName) {
        return f286a.m423a(context, context.getPackageManager().getActivityInfo(componentName, Cast.MAX_NAMESPACE_LENGTH));
    }
}
