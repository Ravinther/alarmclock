package com.anglelabs.alarmclock.redesign.alarm;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.C0119u.C0108d;
import android.text.TextUtils;
import com.alarmclock.xtreme.free.R;
import com.anglelabs.alarmclock.redesign.model.RedesignAlarm;
import com.anglelabs.alarmclock.redesign.p039d.C0694b;
import com.anglelabs.alarmclock.redesign.utils.C0832m;
import com.anglelabs.alarmclock.redesign.utils.C0850q;
import com.anglelabs.alarmclock.redesign.utils.C0860w;
import com.anglelabs.alarmclock.redesign.utils.C0870z;
import com.anglelabs.alarmclock.redesign.utils.ac;
import com.google.android.gms.location.LocationStatusCodes;
import java.util.Calendar;

/* renamed from: com.anglelabs.alarmclock.redesign.alarm.c */
public class C0645c {
    public static Notification m2967a(Context context, RedesignAlarm alarm) {
        SharedPreferences prefs = ac.m3774b(context);
        C0850q.m3986a("Displaying snoozed notification for alarm instance: " + alarm.f2010k);
        CharSequence label = context.getString(R.string.alarm_notify_snooze_label, new Object[]{alarm.m3623i(context)});
        Calendar.getInstance().setTimeInMillis(prefs.getLong("snooze_time_" + alarm.f2010k, 0));
        C0108d notification = new C0108d(context).m466a(label).m470b(context.getString(R.string.alarm_notify_snooze_text, new Object[]{C0870z.m4061a(context, c)})).m460a((int) R.drawable.ic_notif_alarm_snoozed).m467a(true).m471b(false).m472c(1);
        notification.m464a(PendingIntent.getActivity(context, alarm.hashCode(), C0832m.m3928e(context, alarm), 134217728));
        return notification.m459a();
    }

    public static void m2970b(Context context, RedesignAlarm alarm) {
        C0850q.m3986a("Displaying snoozed notification for alarm instance: " + alarm.f2010k);
        ((NotificationManager) context.getSystemService("notification")).notify(alarm.hashCode(), C0645c.m2967a(context, alarm));
    }

    public static Notification m2971c(Context context, RedesignAlarm alarm) {
        C0645c.m2969b(context);
        PendingIntent pendingNotify = PendingIntent.getActivity(context, alarm.hashCode(), C0832m.m3925d(context, alarm), 134217728);
        String label = alarm.m3623i(context);
        return new C0108d(context).m466a(context.getString(R.string.alarm_notif_label, new Object[]{label})).m470b(context.getString(R.string.alarm_notify_text)).m460a((int) R.drawable.notification_alarm_ringing).m467a(true).m471b(false).m468b(0).m465a(null).m461a(-16711936, 500, 500).m464a(pendingNotify).m463a(0).m472c(1).m459a();
    }

    public static void m2968a(Context context) {
        SharedPreferences prefs = ac.m3774b(context);
        if (C0860w.m4042d(prefs)) {
            NotificationManager nm = (NotificationManager) context.getSystemService("notification");
            if (C0694b.m3135a(context, prefs).size() == 0) {
                if (TextUtils.isEmpty(prefs.getString("next_alarm_time", ""))) {
                    nm.cancel(-20);
                    return;
                }
                Intent editAlarms = C0832m.m3930f(context);
                editAlarms.putExtra("alarmclock.select.notification", true);
                PendingIntent broadcastShowAlarm = PendingIntent.getActivity(context, 10, editAlarms, 134217728);
                PendingIntent broadcastDeleteAlarm = PendingIntent.getBroadcast(context, 10, new Intent("com.anglelabs.alarmclock.free.alarm_hide"), 134217728);
                CharSequence message = context.getString(R.string.next_alarm_time_text, new Object[]{nextAlarmTime});
                if (prefs.getBoolean("skip_next", false)) {
                    message = message + " " + context.getString(R.string.will_be_skipped);
                }
                nm.notify(-20, new C0108d(context).m466a(context.getString(R.string.next_alarm_time_label)).m470b(message).m467a(true).m471b(false).m460a((int) R.drawable.notification_alarm).m464a(broadcastShowAlarm).m469b(broadcastDeleteAlarm).m472c(1).m459a());
                return;
            }
            nm.cancel(-20);
        }
    }

    public static void m2972d(Context context, RedesignAlarm instance) {
        C0850q.m3986a("Clearing notifications for alarm instance: " + instance.f2010k);
        ((NotificationManager) context.getSystemService("notification")).cancel(instance.hashCode());
    }

    public static void m2969b(Context context) {
        C0850q.m3986a("Clearing next alarm notification");
        ((NotificationManager) context.getSystemService("notification")).cancel(-20);
    }

    public static void m2973e(Context context, RedesignAlarm instance) {
        C0850q.m3986a("Displaying missed notification for alarm instance: " + instance.f2010k);
        NotificationManager nm = (NotificationManager) context.getSystemService("notification");
        String label = instance.m3623i(context);
        CharSequence contextText = context.getString(R.string.alarm_missed_text, new Object[]{C0870z.m4061a(context, instance.m3620f(context)), label});
        Intent showAlarms = C0832m.m3930f(context);
        showAlarms.putExtra("alarmclock.select.notification", true);
        C0108d notification = new C0108d(context).m466a(context.getString(R.string.alarm_missed_title)).m464a(PendingIntent.getActivity(context, 10, showAlarms, 134217728)).m470b(contextText).m471b(true).m460a((int) R.drawable.notification_missed_alarm).m472c(1);
        nm.cancel(instance.hashCode());
        nm.notify(instance.hashCode(), notification.m459a());
    }

    public static void m2974f(Context context, RedesignAlarm instance) {
        CharSequence message;
        C0850q.m3986a("Displaying AutoDismissed notification for alarm instance: " + instance.f2010k);
        NotificationManager nm = (NotificationManager) context.getSystemService("notification");
        Intent showAlarms = C0832m.m3930f(context);
        showAlarms.putExtra("alarmclock.select.notification", true);
        PendingIntent broadcastShowAlarm = PendingIntent.getActivity(context, 10, showAlarms, 134217728);
        CharSequence label = instance.m3623i(context);
        if (instance.f2003d < 60000) {
            message = context.getString(R.string.alarm_alert_silenced_seconds, new Object[]{Integer.valueOf(instance.f2003d / LocationStatusCodes.GEOFENCE_NOT_AVAILABLE)});
        } else {
            message = context.getString(R.string.alarm_alert_silenced_minutes, new Object[]{Integer.valueOf(instance.f2003d / 60000)});
        }
        nm.notify(-100 - instance.hashCode(), new C0108d(context).m466a(label).m464a(broadcastShowAlarm).m470b(message).m460a((int) R.drawable.notification_missed_alarm).m472c(1).m459a());
    }
}
