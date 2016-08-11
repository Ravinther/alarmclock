package com.avg.toolkit.recurringTasks;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.avg.toolkit.ITKSvc;
import com.avg.toolkit.p049e.C0970a;
import com.google.android.gms.location.LocationStatusCodes;

public class RecurringTaskAlarmReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("alarm_code", intent.getIntExtra("alarm_code", -1));
            bundle.putString(ITKSvc.c_actionData, intent.getAction());
            ITKSvc.Do(context, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, ITKSvc.ACTION_ALARM, bundle);
        } catch (Exception e) {
            C0970a.m4322a(e);
        }
    }

    public static void setAlarm(Context context, String action, int alarmCodeExtra, int setRepeatingType, long triggerAtMillis, long intervalMillis) {
        if (!(setRepeatingType == 0 || setRepeatingType == 3)) {
            C0970a.m4321a();
        }
        Intent intent = new Intent(context, RecurringTaskAlarmReceiver.class);
        intent.setAction(action);
        intent.putExtra("alarm_code", alarmCodeExtra);
        ((AlarmManager) context.getSystemService("alarm")).setRepeating(setRepeatingType, triggerAtMillis, intervalMillis, PendingIntent.getBroadcast(context, 0, intent, 134217728));
    }

    public static void cancelAlarm(Context context, String action) {
        Intent intent = new Intent(context, RecurringTaskAlarmReceiver.class);
        intent.setAction(action);
        ((AlarmManager) context.getSystemService("alarm")).cancel(PendingIntent.getBroadcast(context, 0, intent, 134217728));
    }

    public static void triggerAlarmNow(Context context, String action, int alarmCodeExtra) {
        Intent intent = new Intent(context, RecurringTaskAlarmReceiver.class);
        intent.setAction(action);
        intent.putExtra("alarm_code", alarmCodeExtra);
        context.sendBroadcast(intent);
    }
}
