package com.anglelabs.alarmclock.redesign.alarm;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;
import com.alarmclock.xtreme.free.R;
import com.anglelabs.alarmclock.redesign.alarm.p028a.C0640e;
import com.anglelabs.alarmclock.redesign.alarm.p028a.p029b.C0615a;
import com.anglelabs.alarmclock.redesign.alarm.p028a.p029b.C0615a.C0614a;
import com.anglelabs.alarmclock.redesign.model.RedesignAlarm;
import com.anglelabs.alarmclock.redesign.utils.C0810h;
import com.anglelabs.alarmclock.redesign.utils.C0850q;
import com.google.android.gms.games.GamesStatusCodes;
import java.lang.ref.WeakReference;

/* renamed from: com.anglelabs.alarmclock.redesign.alarm.b */
public class C0644b {
    public static boolean f1719a;
    private static C0615a f1720b;
    private static boolean f1721c;
    private static final long[] f1722d;
    private static C0643a f1723e;
    private static boolean f1724f;
    private static Vibrator f1725g;
    private static final BroadcastReceiver f1726h;

    /* renamed from: com.anglelabs.alarmclock.redesign.alarm.b.1 */
    static class C06421 extends BroadcastReceiver {
        C06421() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.intent.action.SCREEN_OFF") && C0644b.f1725g != null) {
                C0644b.f1725g.vibrate(C0644b.f1722d, 0);
            }
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.alarm.b.a */
    private static class C0643a extends Handler {
        final WeakReference f1718a;

        private C0643a(Context context) {
            this.f1718a = new WeakReference(context.getApplicationContext());
        }

        public void m2949a() {
            if (this.f1718a.get() != null) {
                C0850q.m3986a("AlarmServiceHandler stopped called");
            }
            removeMessages(4000);
            removeMessages(5000);
        }

        public void handleMessage(Message msg) {
            if (this.f1718a.get() == null) {
                C0850q.m3987b("Context is null!");
                return;
            }
            switch (msg.what) {
                case 4000:
                    if (msg.obj == null || !(msg.obj instanceof RedesignAlarm)) {
                        C0850q.m3987b("handler didn't receive alarm as obj!");
                    } else if (C0644b.f1721c) {
                        C0644b.m2960b((RedesignAlarm) msg.obj);
                    }
                default:
            }
        }
    }

    static {
        f1720b = null;
        f1721c = false;
        f1719a = false;
        f1722d = new long[]{500, 500};
        f1726h = new C06421();
    }

    public static void m2951a(Context context) {
        C0850q.m3986a("AlarmHorn restoreVolume called");
        C0614a soundHorn = C0644b.m2966e();
        if (f1724f && soundHorn != null) {
            soundHorn.m2833d(context);
            f1724f = false;
            C0644b.m2964d();
        }
    }

    private static void m2964d() {
        C0850q.m3986a("AlarmHorn onDestroy called");
        f1720b = null;
        C0644b.m2950a(4000);
    }

    private static void m2950a(int massage) {
        if (f1723e != null) {
            f1723e.removeMessages(massage);
            f1723e.m2949a();
        }
    }

    public static synchronized void m2954a(Context context, RedesignAlarm alarm, boolean isInCall) {
        synchronized (C0644b.class) {
            if (isInCall) {
                C0850q.m3986a("Call received stopping alarm");
                C0644b.m2952a(context, 3);
                C0644b.m2965d(context);
            } else {
                C0850q.m3986a("Call ended, resuming alarm");
                C0644b.m2953a(context, alarm);
                C0644b.m2962c(context, alarm);
            }
        }
    }

    private static void m2961c(Context context) {
        C0644b.m2952a(context, 500);
    }

    public static synchronized void m2952a(Context context, int restoreDelay) {
        synchronized (C0644b.class) {
            C0644b.m2965d(context);
            if (f1721c && f1720b != null) {
                C0850q.m3986a("AlarmHorn.stop called");
                f1720b.m2836c(context);
                C0644b.m2950a(5000);
                f1721c = false;
            } else if (f1720b == null) {
                C0850q.m3988c("AlarmHorn.stop() called with horn == null");
            } else {
                C0850q.m3987b("AlarmHorn.stop() when sStarted == false");
            }
        }
    }

    public static synchronized void m2953a(Context context, RedesignAlarm alarm) {
        synchronized (C0644b.class) {
            C0644b.m2961c(context);
            C0850q.m3986a("AlarmHorn start called");
            C0644b.m2950a(5000);
            f1723e = new C0643a(null);
            f1723e.removeMessages(5000);
            f1720b = C0640e.m2943a(context, alarm);
            f1720b.m2835a(context, f1719a);
            f1724f = true;
            if (alarm.f2018s) {
                C0644b.m2960b(alarm);
            }
            C0644b.m2962c(context, alarm);
            C0850q.m3986a("alarm with id: " + alarm.f2010k + "started to vibrate");
            f1721c = true;
        }
    }

    private static void m2962c(Context context, RedesignAlarm alarm) {
        C0644b.m2965d(context);
        if (alarm.f2017r) {
            context.registerReceiver(f1726h, new IntentFilter("android.intent.action.SCREEN_OFF"));
            f1725g = (Vibrator) context.getSystemService("vibrator");
            f1725g.vibrate(f1722d, 0);
        }
    }

    private static void m2965d(Context context) {
        C0850q.m3986a("stopVibrating");
        try {
            context.unregisterReceiver(f1726h);
        } catch (Exception e) {
        }
        if (f1725g != null) {
            f1725g.cancel();
            f1725g = null;
        }
    }

    private static void m2960b(RedesignAlarm alarm) {
        C0614a sound = C0644b.m2966e();
        if (sound == null || alarm == null) {
            C0850q.m3987b("increase sound called with sound = " + sound + " and alarm = " + alarm);
            return;
        }
        int nextVolume = sound.m2832d();
        if (nextVolume > 0) {
            Message message = f1723e.obtainMessage(4000);
            message.obj = alarm;
            f1723e.sendMessageDelayed(message, (long) (alarm.f1998K / nextVolume));
        }
    }

    private static C0614a m2966e() {
        if (f1720b == null || !(f1720b instanceof C0614a)) {
            return null;
        }
        return (C0614a) f1720b;
    }

    @SuppressLint({"NewApi"})
    public static synchronized void m2958b(Context context) {
        synchronized (C0644b.class) {
            if (f1721c) {
                C0614a sound = C0644b.m2966e();
                if (sound != null) {
                    C0850q.m3986a("muting alarm");
                    f1723e.removeMessages(GamesStatusCodes.STATUS_MULTIPLAYER_ERROR_CREATION_NOT_ALLOWED);
                    f1723e.removeMessages(4000);
                    sound.m2834e(context);
                    f1724f = true;
                    int muteLength = context.getResources().getInteger(R.integer.mute_length_default);
                    AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
                    PendingIntent sentIntent = PendingIntent.getBroadcast(context, 0, new Intent("com.anglelabs.alarmclock.UNMUTE"), 0);
                    if (C0810h.f2127a) {
                        alarmManager.setExact(0, System.currentTimeMillis() + ((long) muteLength), sentIntent);
                    } else {
                        alarmManager.set(0, System.currentTimeMillis() + ((long) muteLength), sentIntent);
                    }
                } else {
                    C0850q.m3988c("muting alarm when sound is null! ignored");
                }
                C0850q.m3986a("vibrator stopped due to mute command");
                C0644b.m2965d(context);
            }
        }
    }

    public static synchronized void m2959b(Context context, RedesignAlarm alarm) {
        synchronized (C0644b.class) {
            C0614a sound = C0644b.m2966e();
            if (sound != null) {
                C0850q.m3986a("unMute for alarm with id: " + alarm.f2010k);
                sound.m2831b(context, f1719a);
                f1724f = true;
                if (alarm.f2018s) {
                    C0644b.m2960b(alarm);
                }
            } else {
                C0850q.m3988c("unMuting alarm with id: " + alarm.f2010k + " when sound is null! ignored");
            }
            C0644b.m2962c(context, alarm);
        }
    }
}
