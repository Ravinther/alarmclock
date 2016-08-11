package com.avg.toolkit.zen;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.avg.toolkit.ITKSvc;

public class GlobalLoginReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        ITKSvc.Do(context, 23000, 23001, intent.getExtras());
    }
}
