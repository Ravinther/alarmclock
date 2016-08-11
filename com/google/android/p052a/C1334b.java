package com.google.android.p052a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/* renamed from: com.google.android.a.b */
public class C1334b extends BroadcastReceiver {
    private static boolean f4257a;

    static {
        f4257a = false;
    }

    public final void onReceive(Context context, Intent intent) {
        Log.v("GCMBroadcastReceiver", "onReceive: " + intent.getAction());
        if (!f4257a) {
            f4257a = true;
            String myClass = getClass().getName();
            if (!myClass.equals(C1334b.class.getName())) {
                C1335c.m5857a(myClass);
            }
        }
        String className = m5850a(context);
        Log.v("GCMBroadcastReceiver", "GCM IntentService class: " + className);
        C0984a.m4366a(context, intent, className);
        setResult(-1, null, null);
    }

    protected String m5850a(Context context) {
        return C1334b.m5849b(context);
    }

    static final String m5849b(Context context) {
        return context.getPackageName() + ".GCMIntentService";
    }
}
