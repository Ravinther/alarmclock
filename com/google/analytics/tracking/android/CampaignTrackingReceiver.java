package com.google.analytics.tracking.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public final class CampaignTrackingReceiver extends BroadcastReceiver {
    public void onReceive(Context ctx, Intent intent) {
        String campaign = intent.getStringExtra("referrer");
        if ("com.android.vending.INSTALL_REFERRER".equals(intent.getAction()) && campaign != null) {
            Intent serviceIntent = new Intent(ctx, CampaignTrackingService.class);
            serviceIntent.putExtra("referrer", campaign);
            ctx.startService(serviceIntent);
        }
    }
}
