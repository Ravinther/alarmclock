package com.avg.toolkit.marketing;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.avg.toolkit.ITKSvc;
import com.avg.toolkit.p049e.C0970a;
import com.google.android.gms.games.GamesStatusCodes;

public class MarketReferrerReceiver extends BroadcastReceiver {
    private final String f3159a;

    public MarketReferrerReceiver() {
        this.f3159a = "referrer";
    }

    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().compareTo("com.android.vending.INSTALL_REFERRER") == 0) {
            try {
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString(ITKSvc.c_actionData, extras.getString("referrer"));
                    ITKSvc.Do(context, GamesStatusCodes.STATUS_REAL_TIME_CONNECTION_FAILED, GamesStatusCodes.STATUS_REAL_TIME_MESSAGE_SEND_FAILED, bundle);
                }
            } catch (Exception e) {
                C0970a.m4322a(e);
            }
        }
    }
}
