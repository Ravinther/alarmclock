package com.avg.toolkit.recurringTasks;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.avg.toolkit.ITKSvc;

public class BootReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        ITKSvc.DoEmptyMessage(context);
    }
}
