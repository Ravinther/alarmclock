package com.avg.toolkit.zen;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import com.avg.toolkit.zen.p054a.C1038d;

public class ZENConnectivityReciever extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        NetworkInfo networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.getState() == State.CONNECTED && C1050e.m4550e(context)) {
            C1050e.m4541a(context, false);
            C1038d.m4520a(context, "ConnectivityChangeReceiver");
        }
    }
}
