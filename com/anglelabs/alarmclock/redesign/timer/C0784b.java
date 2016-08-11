package com.anglelabs.alarmclock.redesign.timer;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.C0119u.C0108d;
import com.alarmclock.xtreme.free.R;
import com.anglelabs.alarmclock.redesign.utils.C0810h;
import com.anglelabs.alarmclock.redesign.utils.C0832m;
import com.anglelabs.alarmclock.redesign.utils.C0860w;
import com.anglelabs.alarmclock.redesign.utils.C0870z;
import java.util.ArrayList;

/* renamed from: com.anglelabs.alarmclock.redesign.timer.b */
public class C0784b {
    private static PendingIntent f2085a;

    static {
        f2085a = null;
    }

    public static void m3727a(Context context, TimerObject nexRunningTimer) {
        int timerId = -1;
        if (nexRunningTimer != null) {
            timerId = nexRunningTimer.m3683a();
        }
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 1, C0832m.m3908a(timerId, "com.anglelabs.alarmclock.free.act_timer_times_up"), 1207959552);
        AlarmManager manager = (AlarmManager) context.getSystemService("alarm");
        if (timerId != -1) {
            C0784b.m3723a(nexRunningTimer.m3697g(), pendingIntent, manager);
        } else {
            manager.cancel(pendingIntent);
        }
    }

    public static void m3725a(Context context) {
        ((NotificationManager) context.getSystemService("notification")).cancel(2147483645);
        AlarmManager manager = (AlarmManager) context.getSystemService("alarm");
        if (f2085a != null) {
            manager.cancel(f2085a);
        }
    }

    public static void m3726a(Context context, SharedPreferences prefs, ArrayList runningTimerList, TimerObject nextRunningTimer) {
        if (C0860w.m4044f(prefs)) {
            int numTimersInUse = runningTimerList.size();
            if (!runningTimerList.isEmpty() && nextRunningTimer != null) {
                String title;
                long nextBroadcastTime;
                String contentText;
                long timeLeft = nextRunningTimer.m3684a(false);
                if (numTimersInUse == 1) {
                    title = nextRunningTimer.m3695e();
                    nextBroadcastTime = C0784b.m3722a(timeLeft);
                    contentText = C0870z.m4068c(context, timeLeft);
                } else {
                    title = String.format(context.getString(R.string.running_timers), new Object[]{Integer.valueOf(numTimersInUse)});
                    nextBroadcastTime = C0784b.m3722a(timeLeft);
                    contentText = C0870z.m4068c(context, timeLeft);
                    if (timeLeft >= 0) {
                        contentText = String.format(context.getString(R.string.next_timer_notif), new Object[]{contentText});
                    }
                }
                C0784b.m3728a(context, title, contentText, nextBroadcastTime, nextRunningTimer);
            }
        }
    }

    private static long m3722a(long timeLeft) {
        if (timeLeft > 60000) {
            return C0784b.m3730b(timeLeft);
        }
        return C0784b.m3721a();
    }

    private static void m3728a(Context context, String title, String text, long nextBroadcastTime, TimerObject nexRunningTimer) {
        Intent editTimers = C0832m.m3910a(context, nexRunningTimer.m3683a());
        editTimers.putExtra("alarmclock.select.notification", true);
        C0784b.m3729a(context, title, text, PendingIntent.getActivity(context, 12, editTimers, 134217728), PendingIntent.getBroadcast(context, 1, C0832m.m3908a(-1, "com.anglelabs.alarmclock.free.timer_hide"), 134217728), 2147483645);
        C0784b.m3723a(nextBroadcastTime, PendingIntent.getBroadcast(context, 1, new Intent("com.anglelabs.alarmclock.free.act_timer_notif_show"), 0), (AlarmManager) context.getSystemService("alarm"));
    }

    private static void m3729a(Context context, String title, String text, PendingIntent pendingIntent, PendingIntent pendingDeleteIntent, int notificationId) {
        ((NotificationManager) context.getSystemService("notification")).notify(notificationId, new C0108d(context).m463a(0).m466a((CharSequence) title).m470b((CharSequence) text).m469b(pendingDeleteIntent).m472c(2).m464a(pendingIntent).m468b(4).m460a((int) R.drawable.notification_timer).m459a());
    }

    private static long m3730b(long timeUntilBroadcast) {
        long seconds = timeUntilBroadcast / 1000;
        return TimerObject.m3681m() + ((seconds - ((seconds / 60) * 60)) * 1000);
    }

    private static long m3721a() {
        return TimerObject.m3681m() + 200;
    }

    private static void m3723a(long nextBroadcastTime, PendingIntent pendingNextBroadcast, AlarmManager alarmManager) {
        f2085a = pendingNextBroadcast;
        if (C0810h.f2127a) {
            C0784b.m3724a(alarmManager, Long.valueOf(nextBroadcastTime), pendingNextBroadcast);
        } else {
            C0784b.m3731b(alarmManager, Long.valueOf(nextBroadcastTime), pendingNextBroadcast);
        }
    }

    @TargetApi(19)
    private static void m3724a(AlarmManager alarmManager, Long nextBroadcastTime, PendingIntent pendingNextBroadcast) {
        alarmManager.setExact(2, nextBroadcastTime.longValue(), pendingNextBroadcast);
    }

    private static void m3731b(AlarmManager alarmManager, Long nextBroadcastTime, PendingIntent pendingNextBroadcast) {
        alarmManager.set(3, nextBroadcastTime.longValue(), pendingNextBroadcast);
    }
}
