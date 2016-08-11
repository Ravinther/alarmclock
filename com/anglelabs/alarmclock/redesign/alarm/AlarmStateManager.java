package com.anglelabs.alarmclock.redesign.alarm;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.BroadcastReceiver;
import android.content.BroadcastReceiver.PendingResult;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Parcel;
import android.os.PowerManager.WakeLock;
import android.provider.Settings.System;
import android.widget.RemoteViews;
import com.alarmclock.xtreme.free.AlarmClock;
import com.alarmclock.xtreme.free.R;
import com.anglelabs.alarmclock.redesign.model.RedesignAlarm;
import com.anglelabs.alarmclock.redesign.p039d.C0694b;
import com.anglelabs.alarmclock.redesign.utils.C0808f;
import com.anglelabs.alarmclock.redesign.utils.C0810h;
import com.anglelabs.alarmclock.redesign.utils.C0830k;
import com.anglelabs.alarmclock.redesign.utils.C0830k.C0822j;
import com.anglelabs.alarmclock.redesign.utils.C0832m;
import com.anglelabs.alarmclock.redesign.utils.C0850q;
import com.anglelabs.alarmclock.redesign.utils.C0870z;
import com.anglelabs.alarmclock.redesign.utils.ac;
import com.anglelabs.alarmclock.widgetsproviders.NextAlarmTimeWidgetProvider;
import com.avg.toolkit.p049e.C0970a;
import com.avg.ui.general.rateus.C1186c;
import com.google.android.gms.drive.DriveFile;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;
import java.util.Calendar;
import java.util.Date;

public class AlarmStateManager extends BroadcastReceiver {
    private RedesignAlarm f1665a;

    /* renamed from: com.anglelabs.alarmclock.redesign.alarm.AlarmStateManager.1 */
    class C06021 implements Runnable {
        final /* synthetic */ Context f1658a;
        final /* synthetic */ Intent f1659b;
        final /* synthetic */ PendingResult f1660c;
        final /* synthetic */ WakeLock f1661d;
        final /* synthetic */ AlarmStateManager f1662e;

        C06021(AlarmStateManager alarmStateManager, Context context, Intent intent, PendingResult pendingResult, WakeLock wakeLock) {
            this.f1662e = alarmStateManager;
            this.f1658a = context;
            this.f1659b = intent;
            this.f1660c = pendingResult;
            this.f1661d = wakeLock;
        }

        public void run() {
            this.f1662e.m2783a(this.f1658a, this.f1659b);
            this.f1660c.finish();
            this.f1661d.release();
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.alarm.AlarmStateManager.2 */
    static class C06032 implements Runnable {
        final /* synthetic */ Context f1663a;
        final /* synthetic */ int f1664b;

        C06032(Context context, int i) {
            this.f1663a = context;
            this.f1664b = i;
        }

        public void run() {
            ContentValues values = new ContentValues(1);
            values.put("restartmath", Integer.valueOf(0));
            C0694b.m3138a(this.f1663a, this.f1664b, values, false);
            AlarmStateManager.m2789a(this.f1663a, false);
            C0832m.m3935j(this.f1663a);
        }
    }

    public AlarmStateManager(RedesignAlarm alarm) {
        this.f1665a = alarm;
    }

    @SuppressLint({"NewApi"})
    public void onReceive(Context context, Intent intent) {
        WakeLock wl = C0641a.m2946b(context);
        wl.acquire();
        if (C0810h.f2129c) {
            C0808f.m3825a(new C06021(this, context, intent, goAsync(), wl));
            return;
        }
        m2783a(context, intent);
        wl.release();
    }

    private void m2783a(Context context, Intent intent) {
        if (intent != null) {
            String actionType = intent.getAction();
            Object obj = -1;
            switch (actionType.hashCode()) {
                case -2096783672:
                    if (actionType.equals("com.anglelabs.alarmclock.MUTE")) {
                        obj = 2;
                        break;
                    }
                    break;
                case -1921409189:
                    if (actionType.equals("com.anglelabs.alarmclock.free.ALARM_ALERT")) {
                        obj = 1;
                        break;
                    }
                    break;
                case -447068895:
                    if (actionType.equals("com.anglelabs.alarmclock.UNMUTE")) {
                        obj = 3;
                        break;
                    }
                    break;
                case 809052963:
                    if (actionType.equals("com.anglelabs.alarmclock.free.alarm_hide")) {
                        obj = null;
                        break;
                    }
                    break;
            }
            switch (obj) {
                case Base64.DEFAULT /*0*/:
                    C0830k.m3896a(context, C0822j.AlarmHide);
                case Base64.NO_PADDING /*1*/:
                    m2791b(context, intent);
                case Base64.NO_WRAP /*2*/:
                    C0644b.m2958b(context);
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    C0644b.m2959b(context, this.f1665a);
                default:
            }
        }
    }

    private void m2791b(Context context, Intent intent) {
        if (C0810h.m3838c(context)) {
            this.f1665a = null;
            byte[] data = intent.getByteArrayExtra("intent.extra.alarm_raw");
            if (data != null) {
                Parcel in = Parcel.obtain();
                in.unmarshall(data, 0, data.length);
                in.setDataPosition(0);
                this.f1665a = (RedesignAlarm) RedesignAlarm.CREATOR.createFromParcel(in);
                in.recycle();
            }
            if (this.f1665a == null || this.f1665a.f2010k == -10) {
                C0850q.m3987b("AlarmReceiver failed to parse the alarm from the intent");
                return;
            }
            C0850q.m3986a("**********AlarmReceiver skipping alarm with id = " + this.f1665a.f2010k);
            if (this.f1665a.f1990C) {
                C0850q.m3986a("AlarmReceiver skipping alarm with id = " + this.f1665a.f2010k);
                m2782a(context, this.f1665a.f2010k);
                return;
            } else if (System.currentTimeMillis() > this.f1665a.f1994G + 2700000) {
                C0850q.m3987b("AlarmReceiver ignoring stale alarm id = " + this.f1665a.f2010k);
                return;
            } else {
                C0850q.m3986a("AlarmReceiver starting alarm with id = " + this.f1665a.f2010k);
                context.sendBroadcast(new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
                if (this.f1665a != null) {
                    C0646d.m2985d(context, this.f1665a.f2010k);
                }
                C0646d.m2982b(context, this.f1665a.f2010k, true);
                C0646d.m2986e(context, this.f1665a.f2010k);
                AlarmService.m2770a(context, this.f1665a);
                Intent alarmIntent = C0832m.m3925d(context, this.f1665a);
                alarmIntent.setFlags(268697600);
                context.startActivity(alarmIntent);
                return;
            }
        }
        C0850q.m3987b("TOS not accepted, not showing alarm");
    }

    private static void m2782a(Context context, int alarmId) {
        C0808f.m3825a(new C06032(context.getApplicationContext(), alarmId));
    }

    public static void m2789a(Context context, boolean showToast) {
        SharedPreferences prefs = ac.m3774b(context);
        RedesignAlarm alarm = C0694b.m3149b(context, prefs);
        if (alarm != null) {
            m2785a(context, prefs, alarm, alarm.f1994G);
            if (showToast && ac.m3773a(prefs, alarm)) {
                C0870z.m4065a(context, alarm);
                return;
            }
            return;
        }
        m2784a(context, prefs);
    }

    public static void m2787a(Context context, RedesignAlarm alarmToIgnore) {
        SharedPreferences prefs = ac.m3774b(context);
        RedesignAlarm alarm = C0694b.m3132a(context, prefs, alarmToIgnore);
        if (alarm != null) {
            m2785a(context, prefs, alarm, alarm.f1994G);
        }
    }

    public static void m2784a(Context context, SharedPreferences prefs) {
        ((AlarmManager) context.getSystemService("alarm")).cancel(PendingIntent.getBroadcast(context, 0, new Intent("com.anglelabs.alarmclock.free.ALARM_ALERT"), DriveFile.MODE_READ_ONLY));
        m2786a(context, prefs, null, "", false, 0);
    }

    @SuppressLint({"NewApi"})
    private static void m2785a(Context context, SharedPreferences prefs, RedesignAlarm alarm, long atTimeInMillis) {
        AlarmManager am = (AlarmManager) context.getSystemService("alarm");
        C0850q.m3986a("enabled Alarm: " + alarm.m3622h(context));
        Intent intent = new Intent("com.anglelabs.alarmclock.free.ALARM_ALERT");
        Parcel out = Parcel.obtain();
        alarm.writeToParcel(out, 0);
        out.setDataPosition(0);
        intent.putExtra("intent.extra.alarm_raw", out.marshall());
        out.recycle();
        PendingIntent sender = PendingIntent.getBroadcast(context, 0, intent, DriveFile.MODE_READ_ONLY);
        if (C0810h.f2127a) {
            am.setExact(0, atTimeInMillis, sender);
        } else {
            am.set(0, atTimeInMillis, sender);
        }
        Calendar c = Calendar.getInstance();
        c.setTime(new Date(atTimeInMillis));
        m2786a(context, prefs, alarm, C0870z.m4062a(context, c, true), alarm.f1990C, atTimeInMillis);
    }

    private static void m2786a(Context context, SharedPreferences prefs, RedesignAlarm alarm, String timeString, boolean skip, long atTimeInMillis) {
        prefs.edit().putLong("next_alarm_time_in_millis", atTimeInMillis).putString("next_alarm_time", timeString).putBoolean("skip_next", skip).commit();
        System.putString(context.getContentResolver(), "next_alarm_formatted", timeString);
        C0645c.m2968a(context);
        context.sendBroadcast(new Intent("com.anglelabs.alarmclock.free.ALARM_SET"));
        AppWidgetManager am = AppWidgetManager.getInstance(context);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, new Intent(context, AlarmClock.class), 0);
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.next_alarm_time_widget);
        views.setOnClickPendingIntent(R.id.next_alarm_time_widget, pendingIntent);
        if ("".equals(timeString)) {
            views.setImageViewResource(R.id.next_alarm_time_pic, R.drawable.stat_notify_alarm_set_smaller_strike);
            views.setTextViewText(R.id.next_alarm_time_text, "");
        } else {
            if (skip) {
                views.setImageViewResource(R.id.next_alarm_time_pic, R.drawable.stat_notify_alarm_set_smaller_strike);
            } else {
                views.setImageViewResource(R.id.next_alarm_time_pic, R.drawable.stat_notify_alarm_set_smaller);
            }
            views.setTextViewText(R.id.next_alarm_time_text, timeString);
        }
        am.updateAppWidget(new ComponentName(context, NextAlarmTimeWidgetProvider.class), views);
    }

    public static void m2792b(Context context, RedesignAlarm instance) {
        SharedPreferences prefs = ac.m3774b(context);
        C0646d.m2982b(context, instance.f2010k, false);
        C0646d.m2984c(context, instance.f2010k);
        C0694b.m3139a(context, instance.f2010k, prefs);
        C0645c.m2972d(context, instance);
        AlarmService.m2774c(context, instance);
        if (instance.f2000a != 3) {
            C0850q.m3986a("ALARM_DISMISSED  for alarm with id = " + instance.f2010k);
            m2789a(context, true);
            C0645c.m2968a(context);
            C1186c.m4956a(context).m4986a((int) R.string.rate_us_key_alarm_dismissed);
            if (instance.f2005f != null && !instance.f2005f.m3661c()) {
                C0694b.m3140a(context, instance.f2010k, false);
                C0832m.m3935j(context);
            } else if (instance.f2005f == null) {
                C0850q.m3987b("daysOfWeek are null, this should never happen. trying to dismiss alarm anyway");
                try {
                    C0694b.m3140a(context, instance.f2010k, false);
                    C0832m.m3935j(context);
                } catch (Exception e) {
                    C0850q.m3984a(e);
                }
            }
        }
    }

    public static void m2793c(Context context, RedesignAlarm instance) {
        SharedPreferences prefs = ac.m3774b(context);
        C0646d.m2982b(context, instance.f2010k, false);
        C0645c.m2972d(context, instance);
        C0850q.m3986a("dismissAlarmFromService  for alarm with id = " + instance.f2010k);
        C0646d.m2984c(context, instance.f2010k);
        C0694b.m3139a(context, instance.f2010k, prefs);
        m2789a(context, true);
        C0645c.m2968a(context);
        C1186c.m4956a(context).m4986a((int) R.string.rate_us_key_alarm_dismissed);
    }

    public static void m2788a(Context context, RedesignAlarm snoozedAlarm, long snoozeTime) {
        C0646d.m2978a(context, snoozedAlarm.f2010k, snoozeTime);
        C0850q.m3986a("ALARM_SNOOZED  for alarm " + snoozedAlarm.m3622h(context));
        AlarmService.m2776d(context, snoozedAlarm);
    }

    public static void m2794d(Context context, RedesignAlarm instance) {
        if (instance == null) {
            C0970a.m4325b("autoDismissTriggered with empty alarm");
        } else if ((instance.f2000a == 3 || instance.f2012m) && instance.m3613a(context)) {
            C0850q.m3986a("autoDismissTriggered  for alarm " + instance.m3622h(context));
            Intent alarmAutoDismissedIntent = C0832m.m3925d(context, instance);
            alarmAutoDismissedIntent.putExtra("CAME_FROM_AUTO_DISMISS", true);
            context.startActivity(alarmAutoDismissedIntent);
            C0645c.m2974f(context, instance);
        } else {
            C0850q.m3986a("autoDismissTriggered  !isActive ");
        }
    }

    public static void m2795e(Context context, RedesignAlarm instance) {
        if (instance == null) {
            C0970a.m4325b("autoSnoozeTriggered with empty alarm");
            return;
        }
        C0850q.m3986a("autoSnoozeTriggered  for alarm " + instance.m3622h(context));
        if (instance.m3616b(context)) {
            C0850q.m3986a("autoSnoozeTriggered  isSnoozed ");
        } else if ((instance.f2000a != 3 && !instance.f2012m) || !instance.m3613a(context)) {
            C0850q.m3986a("autoSnoozeTriggered  !isActive ");
        } else if (instance.m3621g(context)) {
            m2794d(context, instance);
            C0850q.m3986a("autoSnoozeTriggered  hasReachedMaxSnoozes ");
        } else {
            Intent alarmAutoSnoozedIntent = C0832m.m3925d(context, instance);
            alarmAutoSnoozedIntent.putExtra("CAME_FROM_AUTO_SNOOZE", true);
            context.startActivity(alarmAutoSnoozedIntent);
        }
    }

    public IntentFilter m2796a() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.anglelabs.alarmclock.MUTE");
        intentFilter.addAction("com.anglelabs.alarmclock.UNMUTE");
        return intentFilter;
    }
}
