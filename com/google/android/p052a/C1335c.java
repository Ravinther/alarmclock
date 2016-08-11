package com.google.android.p052a;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.util.Log;
import com.google.android.gms.games.GamesStatusCodes;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* renamed from: com.google.android.a.c */
public final class C1335c {
    private static C1334b f4258a;
    private static String f4259b;

    public static void m5853a(Context context) {
        int version = VERSION.SDK_INT;
        if (version < 8) {
            throw new UnsupportedOperationException("Device must be at least API Level 8 (instead of " + version + ")");
        }
        try {
            context.getPackageManager().getPackageInfo("com.google.android.gsf", 0);
        } catch (NameNotFoundException e) {
            throw new UnsupportedOperationException("Device does not have package com.google.android.gsf");
        }
    }

    public static void m5858b(Context context) {
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        String permissionName = packageName + ".permission.C2D_MESSAGE";
        try {
            packageManager.getPermissionInfo(permissionName, 4096);
            try {
                ActivityInfo[] receivers = packageManager.getPackageInfo(packageName, 2).receivers;
                if (receivers == null || receivers.length == 0) {
                    throw new IllegalStateException("No receiver for package " + packageName);
                }
                if (Log.isLoggable("GCMRegistrar", 2)) {
                    Log.v("GCMRegistrar", "number of receivers for " + packageName + ": " + receivers.length);
                }
                Set allowedReceivers = new HashSet();
                for (ActivityInfo receiver : receivers) {
                    if ("com.google.android.c2dm.permission.SEND".equals(receiver.permission)) {
                        allowedReceivers.add(receiver.name);
                    }
                }
                if (allowedReceivers.isEmpty()) {
                    throw new IllegalStateException("No receiver allowed to receive com.google.android.c2dm.permission.SEND");
                }
                C1335c.m5855a(context, allowedReceivers, "com.google.android.c2dm.intent.REGISTRATION");
                C1335c.m5855a(context, allowedReceivers, "com.google.android.c2dm.intent.RECEIVE");
            } catch (NameNotFoundException e) {
                throw new IllegalStateException("Could not get receivers for package " + packageName);
            }
        } catch (NameNotFoundException e2) {
            throw new IllegalStateException("Application does not define permission " + permissionName);
        }
    }

    private static void m5855a(Context context, Set allowedReceivers, String action) {
        PackageManager pm = context.getPackageManager();
        String packageName = context.getPackageName();
        Intent intent = new Intent(action);
        intent.setPackage(packageName);
        List<ResolveInfo> receivers = pm.queryBroadcastReceivers(intent, 32);
        if (receivers.isEmpty()) {
            throw new IllegalStateException("No receivers for action " + action);
        }
        if (Log.isLoggable("GCMRegistrar", 2)) {
            Log.v("GCMRegistrar", "Found " + receivers.size() + " receivers for action " + action);
        }
        for (ResolveInfo receiver : receivers) {
            String name = receiver.activityInfo.name;
            if (!allowedReceivers.contains(name)) {
                throw new IllegalStateException("Receiver " + name + " is not set with permission " + "com.google.android.c2dm.permission.SEND");
            }
        }
    }

    public static void m5856a(Context context, String... senderIds) {
        C1335c.m5865h(context);
        C1335c.m5859b(context, senderIds);
    }

    static void m5859b(Context context, String... senderIds) {
        String flatSenderIds = C1335c.m5852a(senderIds);
        Log.v("GCMRegistrar", "Registering app " + context.getPackageName() + " of senders " + flatSenderIds);
        Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
        intent.setPackage("com.google.android.gsf");
        intent.putExtra("app", PendingIntent.getBroadcast(context, 0, new Intent(), 0));
        intent.putExtra("sender", flatSenderIds);
        context.startService(intent);
    }

    static String m5852a(String... senderIds) {
        if (senderIds == null || senderIds.length == 0) {
            throw new IllegalArgumentException("No senderIds");
        }
        StringBuilder builder = new StringBuilder(senderIds[0]);
        for (int i = 1; i < senderIds.length; i++) {
            builder.append(',').append(senderIds[i]);
        }
        return builder.toString();
    }

    static void m5860c(Context context) {
        Log.v("GCMRegistrar", "Unregistering app " + context.getPackageName());
        Intent intent = new Intent("com.google.android.c2dm.intent.UNREGISTER");
        intent.setPackage("com.google.android.gsf");
        intent.putExtra("app", PendingIntent.getBroadcast(context, 0, new Intent(), 0));
        context.startService(intent);
    }

    static synchronized void m5861d(Context context) {
        synchronized (C1335c.class) {
            if (f4258a == null) {
                if (f4259b == null) {
                    Log.e("GCMRegistrar", "internal error: retry receiver class not set yet");
                    f4258a = new C1334b();
                } else {
                    try {
                        f4258a = (C1334b) Class.forName(f4259b).newInstance();
                    } catch (Exception e) {
                        Log.e("GCMRegistrar", "Could not create instance of " + f4259b + ". Using " + C1334b.class.getName() + " directly.");
                        f4258a = new C1334b();
                    }
                }
                String category = context.getPackageName();
                IntentFilter filter = new IntentFilter("com.google.android.gcm.intent.RETRY");
                filter.addCategory(category);
                String permission = category + ".permission.C2D_MESSAGE";
                Log.v("GCMRegistrar", "Registering receiver");
                context.registerReceiver(f4258a, filter, permission, null);
            }
        }
    }

    static void m5857a(String className) {
        Log.v("GCMRegistrar", "Setting the name of retry receiver class to " + className);
        f4259b = className;
    }

    public static String m5862e(Context context) {
        SharedPreferences prefs = C1335c.m5868k(context);
        String registrationId = prefs.getString("regId", "");
        int oldVersion = prefs.getInt("appVersion", Integer.MIN_VALUE);
        int newVersion = C1335c.m5867j(context);
        if (oldVersion == Integer.MIN_VALUE || oldVersion == newVersion) {
            return registrationId;
        }
        Log.v("GCMRegistrar", "App version changed from " + oldVersion + " to " + newVersion + "; resetting registration id");
        C1335c.m5864g(context);
        return "";
    }

    public static boolean m5863f(Context context) {
        return C1335c.m5862e(context).length() > 0;
    }

    static String m5864g(Context context) {
        return C1335c.m5851a(context, "");
    }

    static String m5851a(Context context, String regId) {
        SharedPreferences prefs = C1335c.m5868k(context);
        String oldRegistrationId = prefs.getString("regId", "");
        int appVersion = C1335c.m5867j(context);
        Log.v("GCMRegistrar", "Saving regId on app version " + appVersion);
        Editor editor = prefs.edit();
        editor.putString("regId", regId);
        editor.putInt("appVersion", appVersion);
        editor.commit();
        return oldRegistrationId;
    }

    private static int m5867j(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
            throw new RuntimeException("Coult not get package name: " + e);
        }
    }

    static void m5865h(Context context) {
        Log.d("GCMRegistrar", "resetting backoff for " + context.getPackageName());
        C1335c.m5854a(context, (int) GamesStatusCodes.STATUS_ACHIEVEMENT_UNLOCK_FAILURE);
    }

    static int m5866i(Context context) {
        return C1335c.m5868k(context).getInt("backoff_ms", GamesStatusCodes.STATUS_ACHIEVEMENT_UNLOCK_FAILURE);
    }

    static void m5854a(Context context, int backoff) {
        Editor editor = C1335c.m5868k(context).edit();
        editor.putInt("backoff_ms", backoff);
        editor.commit();
    }

    private static SharedPreferences m5868k(Context context) {
        return context.getSharedPreferences("com.google.android.gcm", 0);
    }
}
