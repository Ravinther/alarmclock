package com.avg.toolkit.recurringTasks;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.avg.toolkit.ITKSvc;
import com.avg.toolkit.p049e.C0970a;
import java.util.Random;

/* renamed from: com.avg.toolkit.recurringTasks.b */
public class C1031b {
    String f3167a;
    long f3168b;
    int f3169c;
    boolean f3170d;
    boolean f3171e;
    C1028a f3172f;
    private Random f3173g;

    /* renamed from: com.avg.toolkit.recurringTasks.b.a */
    public abstract class C1029a implements Runnable {
        protected Context f3164b;
        final /* synthetic */ C1031b f3165c;

        public C1029a(C1031b c1031b, Context context) {
            this.f3165c = c1031b;
            this.f3164b = context;
        }
    }

    /* renamed from: com.avg.toolkit.recurringTasks.b.1 */
    class C10301 extends C1029a {
        final /* synthetic */ C1031b f3166a;

        C10301(C1031b c1031b, Context x0) {
            this.f3166a = c1031b;
            super(c1031b, x0);
        }

        public void run() {
            RecurringTaskAlarmReceiver.triggerAlarmNow(this.b, this.f3166a.f3167a, this.f3166a.f3169c);
        }
    }

    public C1031b(Context context, String alarmName, long alarmInterval, boolean firstTimeNow, boolean addRandomInterval, int alarmCodeExtra, boolean checkNetwork) {
        long alarmTime;
        this.f3167a = alarmName;
        this.f3168b = alarmInterval;
        this.f3169c = alarmCodeExtra;
        this.f3170d = checkNetwork;
        this.f3171e = addRandomInterval;
        this.f3173g = new Random();
        this.f3172f = new C1028a(new C10301(this, context));
        SharedPreferences pref = context.getSharedPreferences("HB", 0);
        long lastAlarmTime = pref.getLong(this.f3167a + "_re_last_succ", 0);
        long currentTime = System.currentTimeMillis();
        if (lastAlarmTime == 0) {
            alarmTime = currentTime + this.f3168b;
            if (this.f3171e) {
                alarmTime += Math.abs((long) ((this.f3167a.hashCode() + this.f3173g.nextInt()) % 43200000));
            }
            if (firstTimeNow) {
                RecurringTaskAlarmReceiver.triggerAlarmNow(context, this.f3167a, this.f3169c);
            } else {
                pref.edit().putLong(this.f3167a + "_re_last_succ", currentTime).commit();
            }
        } else if (lastAlarmTime >= currentTime) {
            alarmTime = currentTime;
        } else {
            alarmTime = lastAlarmTime + this.f3168b;
            if (this.f3171e) {
                alarmTime += Math.abs((long) ((this.f3167a.hashCode() + this.f3173g.nextInt()) % 43200000));
            }
        }
        RecurringTaskAlarmReceiver.setAlarm(context, this.f3167a, alarmCodeExtra, 0, alarmTime, this.f3168b);
    }

    public void m4479a(Context context) {
        long alarmTime = System.currentTimeMillis();
        context.getSharedPreferences("HB", 0).edit().putLong(this.f3167a + "_re_last_succ", alarmTime).commit();
        alarmTime += this.f3168b;
        if (this.f3171e) {
            alarmTime += Math.abs((long) ((this.f3167a.hashCode() + this.f3173g.nextInt()) % 43200000));
        }
        RecurringTaskAlarmReceiver.setAlarm(context, this.f3167a, this.f3169c, 0, alarmTime, this.f3168b);
    }

    public boolean m4480a(Context context, Bundle bundle) {
        if (!this.f3167a.equals(bundle.getString(ITKSvc.c_actionData))) {
            return false;
        }
        if (!this.f3170d) {
            return true;
        }
        if (C1028a.m4477b(context)) {
            return true;
        }
        this.f3172f.m4478a(context);
        return false;
    }

    public void m4481b(Context context) {
        if (this.f3172f != null && this.f3172f.f3163b) {
            try {
                context.unregisterReceiver(this.f3172f);
            } catch (Exception e) {
                C0970a.m4322a(e);
            }
        }
    }

    public void m4482c(Context context) {
        long alarmTime = this.f3168b + 60000;
        if (this.f3171e) {
            alarmTime += 43200000;
        }
        long successTime = System.currentTimeMillis();
        if (successTime > alarmTime) {
            context.getSharedPreferences("HB", 0).edit().putLong(this.f3167a + "_re_last_succ", successTime - alarmTime).commit();
        }
        RecurringTaskAlarmReceiver.triggerAlarmNow(context, this.f3167a, this.f3169c);
    }
}
