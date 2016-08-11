package com.google.analytics.tracking.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

class GANetworkReceiver extends BroadcastReceiver {
    private final ServiceManager f4064a;

    GANetworkReceiver(ServiceManager manager) {
        this.f4064a = manager;
    }

    public void onReceive(Context ctx, Intent intent) {
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            Bundle b = intent.getExtras();
            Boolean notConnected = Boolean.FALSE;
            if (b != null) {
                notConnected = Boolean.valueOf(intent.getExtras().getBoolean("noConnectivity"));
            }
            this.f4064a.m5641a(!notConnected.booleanValue());
        }
    }
}
