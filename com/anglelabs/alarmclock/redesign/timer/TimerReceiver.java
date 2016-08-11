package com.anglelabs.alarmclock.redesign.timer;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.BroadcastReceiver.PendingResult;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.PowerManager.WakeLock;
import com.anglelabs.alarmclock.redesign.alarm.C0641a;
import com.anglelabs.alarmclock.redesign.timer.TimerObject.C0779b;
import com.anglelabs.alarmclock.redesign.utils.C0808f;
import com.anglelabs.alarmclock.redesign.utils.C0810h;
import com.anglelabs.alarmclock.redesign.utils.C0830k;
import com.anglelabs.alarmclock.redesign.utils.C0830k.C0822j;
import com.anglelabs.alarmclock.redesign.utils.C0832m;
import com.anglelabs.alarmclock.redesign.utils.ac;
import java.util.ArrayList;
import java.util.List;

public class TimerReceiver extends BroadcastReceiver {

    /* renamed from: com.anglelabs.alarmclock.redesign.timer.TimerReceiver.1 */
    class C07801 implements Runnable {
        final /* synthetic */ Context f2076a;
        final /* synthetic */ Intent f2077b;
        final /* synthetic */ PendingResult f2078c;
        final /* synthetic */ WakeLock f2079d;
        final /* synthetic */ TimerReceiver f2080e;

        C07801(TimerReceiver timerReceiver, Context context, Intent intent, PendingResult pendingResult, WakeLock wakeLock) {
            this.f2080e = timerReceiver;
            this.f2076a = context;
            this.f2077b = intent;
            this.f2078c = pendingResult;
            this.f2079d = wakeLock;
        }

        @SuppressLint({"NewApi"})
        public void run() {
            this.f2080e.m3705a(this.f2076a, this.f2077b);
            this.f2078c.finish();
            this.f2079d.release();
        }
    }

    public void onReceive(Context context, Intent intent) {
        WakeLock wl = C0641a.m2946b(context);
        wl.acquire();
        if (C0810h.f2129c) {
            C0808f.m3825a(new C07801(this, context, intent, goAsync(), wl));
            return;
        }
        m3705a(context, intent);
        wl.release();
    }

    private void m3705a(Context context, Intent intent) {
        String actionType = intent.getAction();
        SharedPreferences prefs = ac.m3774b(context);
        if ("com.anglelabs.alarmclock.free.act_timer_times_up".equals(actionType)) {
            m3706a(context, intent, prefs);
        }
        if ("com.anglelabs.alarmclock.free.timer_hide".equals(actionType)) {
            C0784b.m3725a(context);
            C0830k.m3896a(context, C0822j.TimerHide);
            return;
        }
        List timerList = C0783a.m3714a(prefs);
        ArrayList runningTimerList = C0785c.m3736b(timerList);
        TimerObject nextRunningTimer = C0785c.m3733a((ArrayList) timerList, false);
        if ("com.anglelabs.alarmclock.free.act_timer_notif_show".equals(actionType)) {
            C0784b.m3726a(context, prefs, timerList, nextRunningTimer);
            return;
        }
        if ("com.anglelabs.alarmclock.free.act_timer_action".equals(actionType)) {
            int timerActionId = intent.getIntExtra("timer_action", -1);
            if ((C0779b.Restart.m3678a() == timerActionId || C0779b.Delete.m3678a() == timerActionId || C0779b.Stop.m3678a() == timerActionId || C0779b.AddMinutes.m3678a() == timerActionId) && C0785c.m3734a(timerList) == null) {
                m3708b(context);
            }
        }
        C0784b.m3727a(context, nextRunningTimer);
        if (runningTimerList.isEmpty()) {
            C0784b.m3725a(context);
        } else {
            C0784b.m3726a(context, prefs, timerList, nextRunningTimer);
        }
    }

    private void m3706a(Context context, Intent intent, SharedPreferences prefs) {
        int timerId = intent.getIntExtra("extra_timer_id", -1);
        if (timerId != -1) {
            TimerObject timer = C0785c.m3732a(prefs, timerId);
            if (timer != null) {
                timer.m3691a(C0779b.TimeOver, prefs);
                m3703a(context);
                context.startActivity(C0832m.m3918b(context, timerId));
            }
        }
    }

    private void m3703a(Context context) {
        Intent si = new Intent();
        si.setClass(context, TimerService.class);
        context.startService(si);
    }

    private void m3708b(Context context) {
        Intent si = new Intent();
        si.setClass(context, TimerService.class);
        context.stopService(si);
    }

    public static void m3704a(Context context, int timerId, C0779b timerActionId) {
        Intent intent = C0832m.m3908a(timerId, "com.anglelabs.alarmclock.free.act_timer_action");
        intent.putExtra("timer_action", timerActionId.m3678a());
        context.sendBroadcast(intent);
    }
}
