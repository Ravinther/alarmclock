package com.anglelabs.alarmclock.redesign.alarm;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.anglelabs.alarmclock.redesign.model.RedesignAlarm;
import com.anglelabs.alarmclock.redesign.p039d.C0694b;
import com.anglelabs.alarmclock.redesign.utils.C0850q;
import com.anglelabs.alarmclock.redesign.utils.C0856t;
import com.anglelabs.alarmclock.redesign.utils.C0856t.C0596a;
import com.avg.toolkit.p049e.C0970a;
import java.util.HashMap;

public class AlarmService extends Service {
    private C0856t f1649a;
    private RedesignAlarm f1650b;
    private AlarmStateManager f1651c;
    private Handler f1652d;
    private final HashMap f1653e;
    private C0598a f1654f;
    private C0598a f1655g;
    private final String f1656h;
    private final String f1657i;

    /* renamed from: com.anglelabs.alarmclock.redesign.alarm.AlarmService.1 */
    class C05971 implements C0596a {
        final /* synthetic */ AlarmService f1642a;

        C05971(AlarmService alarmService) {
            this.f1642a = alarmService;
        }

        public void m2763a(boolean isInCall) {
            if (this.f1642a.f1650b != null) {
                C0644b.m2954a(this.f1642a.getBaseContext(), this.f1642a.f1650b, isInCall);
            }
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.alarm.AlarmService.a */
    private interface C0598a {
        void m2764a(RedesignAlarm redesignAlarm);
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.alarm.AlarmService.2 */
    class C05992 implements C0598a {
        final /* synthetic */ AlarmService f1643a;

        C05992(AlarmService alarmService) {
            this.f1643a = alarmService;
        }

        public void m2765a(RedesignAlarm instance) {
            try {
                AlarmStateManager.m2795e(this.f1643a.getApplicationContext(), instance);
                this.f1643a.m2780b((long) instance.f2010k);
                this.f1643a.m2778a((long) instance.f2010k);
            } catch (Exception e) {
                C0970a.m4325b("AlarmService failed to auto-snooze alarm " + e);
                e.printStackTrace();
            }
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.alarm.AlarmService.3 */
    class C06003 implements C0598a {
        final /* synthetic */ AlarmService f1644a;

        C06003(AlarmService alarmService) {
            this.f1644a = alarmService;
        }

        public void m2766a(RedesignAlarm instance) {
            try {
                AlarmStateManager.m2794d(this.f1644a.getApplicationContext(), instance);
                this.f1644a.m2778a((long) instance.f2010k);
                this.f1644a.m2780b((long) instance.f2010k);
            } catch (Exception e) {
                C0970a.m4325b("AlarmService failed to auto-dismiss alarm" + e);
            }
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.alarm.AlarmService.b */
    private class C0601b implements Runnable {
        final /* synthetic */ AlarmService f1645a;
        private final C0598a f1646b;
        private final RedesignAlarm f1647c;
        private final String f1648d;

        C0601b(AlarmService alarmService, RedesignAlarm instance, String key, C0598a callback) {
            this.f1645a = alarmService;
            this.f1647c = instance;
            this.f1646b = callback;
            this.f1648d = key;
        }

        public void run() {
            this.f1646b.m2764a(this.f1647c);
        }
    }

    public AlarmService() {
        this.f1650b = null;
        this.f1653e = new HashMap();
        this.f1656h = "AUTO_SNOOZE";
        this.f1657i = "AUTO_DISMISS";
    }

    public static void m2770a(Context context, RedesignAlarm instance) {
        Intent intent = RedesignAlarm.m3608a(context, AlarmService.class, (long) instance.f2010k);
        intent.setAction("START_ALARM");
        C0641a.m2947c(context);
        context.startService(intent);
    }

    public static void m2773b(Context context, RedesignAlarm instance) {
        Intent intent = RedesignAlarm.m3608a(context, AlarmService.class, (long) instance.f2010k);
        intent.setAction("START_ALARM_PREVIEW");
        intent.putExtra("intent.extra.alarm", instance);
        C0641a.m2947c(context);
        context.startService(intent);
    }

    public static void m2774c(Context context, RedesignAlarm instance) {
        Intent intent = RedesignAlarm.m3608a(context, AlarmService.class, (long) instance.f2010k);
        intent.setAction("STOP_ALARM");
        context.startService(intent);
    }

    public static void m2776d(Context context, RedesignAlarm instance) {
        Intent intent = RedesignAlarm.m3608a(context, AlarmService.class, (long) instance.f2010k);
        intent.setAction("SNOOZE_ALARM");
        context.startService(intent);
    }

    private void m2775c(RedesignAlarm instance) {
        if (!(this.f1650b == null || this.f1650b.f2010k == -1)) {
            C0850q.m3988c("Alarm with id :" + instance.f2010k + " played while alarm with id: " + this.f1650b.f2010k + " is playing, canceling previous alarm");
            AlarmStateManager.m2793c(getApplicationContext(), this.f1650b);
            stopForeground(true);
            C0645c.m2973e(getApplicationContext(), this.f1650b);
            m2769a();
        }
        m2779a(instance);
        m2781b(instance);
        AlarmStateManager.m2787a(getApplicationContext(), instance);
        this.f1650b = instance;
        this.f1651c = new AlarmStateManager(this.f1650b);
        registerReceiver(this.f1651c, this.f1651c.m2796a());
        C0641a.m2947c(this);
        startForeground(instance.hashCode(), C0645c.m2971c(this, instance));
        if (this.f1649a != null) {
            this.f1649a.m4021a();
        }
        C0644b.m2953a((Context) this, this.f1650b);
        sendBroadcast(new Intent("com.android.deskclock.ALARM_ALERT"));
    }

    private void m2769a() {
        C0644b.m2952a((Context) this, 0);
        if (this.f1649a != null) {
            this.f1649a.m4022b();
        }
        sendBroadcast(new Intent("com.android.deskclock.ALARM_DONE"));
        C0641a.m2945a();
        if (this.f1651c != null) {
            unregisterReceiver(this.f1651c);
            this.f1651c = null;
        }
        if (this.f1650b == null) {
            C0850q.m3988c("stopCurrentAlarm called with no alarm instance to stop");
        } else {
            C0850q.m3986a("AlarmService.stop with instance: " + this.f1650b.f2010k);
        }
    }

    public void onCreate() {
        super.onCreate();
        this.f1649a = new C0856t(getBaseContext(), new C05971(this));
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        C0850q.m3986a("AlarmService.onStartCommand() with intent: " + intent.toString());
        long instanceId = RedesignAlarm.m3607a(intent.getData());
        if ("START_ALARM".equals(intent.getAction()) || "START_ALARM_PREVIEW".equals(intent.getAction())) {
            RedesignAlarm instance;
            if ("START_ALARM_PREVIEW".equals(intent.getAction())) {
                instance = (RedesignAlarm) intent.getParcelableExtra("intent.extra.alarm");
                instanceId = -99;
            } else {
                instance = C0694b.m3129a(getContentResolver(), instanceId);
            }
            if (instance == null) {
                C0850q.m3987b("No instance found to start alarm: " + instanceId);
                if (this.f1650b != null) {
                    C0641a.m2945a();
                }
            } else if (this.f1650b == null || ((long) this.f1650b.f2010k) != instanceId) {
                m2775c(instance);
            } else {
                C0850q.m3987b("Alarm already started for instance: " + instanceId);
            }
        } else if ("STOP_ALARM".equals(intent.getAction()) || "SNOOZE_ALARM".equals(intent.getAction())) {
            m2778a(instanceId);
            m2780b(instanceId);
            if (this.f1650b != null && this.f1650b.f2010k != -1 && ((long) this.f1650b.f2010k) != instanceId) {
                C0850q.m3987b("Can't stop alarm for instance: " + instanceId + " because current alarm is: " + this.f1650b.f2010k);
            } else if ("SNOOZE_ALARM".equals(intent.getAction())) {
                if (this.f1650b != null) {
                    m2777d(this.f1650b);
                }
                onDestroy();
            } else {
                stopSelf();
            }
        }
        return 2;
    }

    private void m2777d(RedesignAlarm instance) {
        startForeground(instance.hashCode(), C0645c.m2967a(getApplicationContext(), instance));
    }

    public void onDestroy() {
        C0850q.m3986a("AlarmService.onDestroy() called");
        super.onDestroy();
        m2769a();
        if (this.f1650b == null) {
            return;
        }
        if (this.f1650b.m3616b(getApplicationContext())) {
            this.f1650b.f2010k = -1;
            if (this.f1650b.f1993F != 6) {
                C0644b.m2951a(getApplicationContext());
                return;
            }
            return;
        }
        stopForeground(true);
        C0644b.m2951a(getApplicationContext());
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    synchronized void m2779a(RedesignAlarm instance) {
        if (instance != null) {
            boolean isAutoSnooze = (instance.f2004e <= 0 || instance.f1992E == 4 || instance.m3621g(getApplicationContext())) ? false : true;
            if (isAutoSnooze) {
                if (this.f1654f == null) {
                    this.f1654f = new C05992(this);
                }
                m2771a(new C0601b(this, instance, instance.f2010k + "AUTO_SNOOZE", this.f1654f), (long) instance.f2004e);
            }
        }
    }

    synchronized void m2781b(RedesignAlarm instance) {
        if (instance != null) {
            if (instance.f2003d > 0) {
                if (this.f1655g == null) {
                    this.f1655g = new C06003(this);
                }
                m2771a(new C0601b(this, instance, instance.f2010k + "AUTO_DISMISS", this.f1655g), (long) instance.f2003d);
            }
        }
    }

    private synchronized void m2771a(C0601b runnable, long timeToPost) {
        if (this.f1652d == null) {
            this.f1652d = new Handler(getMainLooper());
        }
        this.f1653e.put(runnable.f1648d, runnable);
        this.f1652d.postDelayed(runnable, timeToPost);
    }

    void m2778a(long alarmId) {
        C0850q.m3986a("stopAutoSnooze for alarmId: " + alarmId);
        m2772a(alarmId + "AUTO_SNOOZE");
    }

    void m2780b(long alarmId) {
        C0850q.m3986a("stopAutoDismiss for instance: " + alarmId);
        m2772a(alarmId + "AUTO_DISMISS");
    }

    private void m2772a(String key) {
        if (this.f1652d != null) {
            C0601b scheduleAlarmRunnable = (C0601b) this.f1653e.get(key);
            if (scheduleAlarmRunnable != null) {
                this.f1653e.remove(key);
                this.f1652d.removeCallbacks(scheduleAlarmRunnable);
            }
        }
    }
}
