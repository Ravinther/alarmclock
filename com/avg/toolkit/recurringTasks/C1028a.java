package com.avg.toolkit.recurringTasks;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import com.avg.toolkit.p049e.C0970a;

/* renamed from: com.avg.toolkit.recurringTasks.a */
public class C1028a extends BroadcastReceiver {
    Runnable f3162a;
    boolean f3163b;

    public C1028a(Runnable onConnectivityAction) {
        this.f3162a = onConnectivityAction;
    }

    public void m4478a(Context context) {
        if (!this.f3163b) {
            this.f3163b = true;
            context.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
    }

    public void onReceive(Context ctx, Intent intent) {
        if (C1028a.m4477b(ctx) && this.f3163b) {
            this.f3163b = false;
            try {
                ctx.unregisterReceiver(this);
            } catch (Exception e) {
                C0970a.m4322a(e);
            }
            this.f3162a.run();
        }
    }

    public static boolean m4477b(Context context) {
        boolean b = true;
        try {
            String androidID = Build.PRODUCT;
            if (androidID == null || androidID.equalsIgnoreCase("9774D56D682E549C") || androidID.equalsIgnoreCase("google_sdk")) {
                return true;
            }
            NetworkInfo netinfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (!(netinfo != null && netinfo.isAvailable() && netinfo.isConnected())) {
                b = false;
            }
            return b;
        } catch (Exception e) {
            C0970a.m4322a(e);
            return false;
        }
    }
}
