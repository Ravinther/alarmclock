package com.anglelabs.alarmclock.redesign.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.alarmclock.xtreme.free.R;
import com.anglelabs.alarmclock.redesign.activities.RedesignAlarmAlertActivity;
import com.anglelabs.alarmclock.redesign.alarm.AlarmStateManager;
import com.anglelabs.alarmclock.redesign.model.RedesignAlarm;
import com.google.android.gms.games.GamesStatusCodes;
import java.lang.ref.WeakReference;

/* renamed from: com.anglelabs.alarmclock.redesign.utils.c */
public class C0795c extends Handler {
    private final WeakReference f2106a;

    public C0795c(RedesignAlarmAlertActivity context) {
        this.f2106a = new WeakReference(context);
    }

    public void handleMessage(Message msg) {
        boolean endActivity = true;
        Context activity = (RedesignAlarmAlertActivity) this.f2106a.get();
        if (activity != null) {
            switch (msg.what) {
                case GamesStatusCodes.STATUS_REQUEST_UPDATE_PARTIAL_SUCCESS /*2000*/:
                    if (msg.obj != null) {
                        RedesignAlarm alarm = null;
                        try {
                            alarm = (RedesignAlarm) msg.obj;
                        } catch (Exception e) {
                            C0850q.m3985a(e, "could not retrieve alarm from message Obj.!");
                        }
                        if (alarm != null && activity.f1518o != null) {
                            synchronized (activity.f1519p) {
                                if (activity.f1518o == null) {
                                    return;
                                }
                                AlarmStateManager.m2788a(activity, alarm, activity.m2614c(alarm));
                                if (alarm.f2010k != activity.f1518o.f2010k) {
                                    endActivity = false;
                                }
                                C0858u.m4026a(activity, activity.getString(R.string.alarm_alert_snooze_set, new Object[]{Integer.valueOf(activity.m2611b(alarm))}));
                                if (endActivity) {
                                    activity.startActivity(C0832m.m3928e(activity, alarm));
                                    activity.f1518o = null;
                                    activity.setResult(-1);
                                    activity.finish();
                                }
                            }
                        }
                    }
                default:
            }
        }
    }
}
