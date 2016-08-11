package com.avg.toolkit.recurringTasks;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.avg.toolkit.ITKSvc;
import com.avg.toolkit.p049e.C0970a;
import com.google.android.gms.location.LocationStatusCodes;

public class AlarmReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("alarm_code", intent.getIntExtra("alarm_code", -1));
            bundle.putInt("alarm_code2", intent.getIntExtra("alarm_code2", -1));
            ITKSvc.Do(context, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, ITKSvc.ACTION_ALARM, bundle);
        } catch (Exception e) {
            C0970a.m4322a(e);
        }
    }
}
