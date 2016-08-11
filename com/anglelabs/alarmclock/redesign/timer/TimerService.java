package com.anglelabs.alarmclock.redesign.timer;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.anglelabs.alarmclock.redesign.alarm.C0641a;
import com.anglelabs.alarmclock.redesign.alarm.C0644b;
import com.anglelabs.alarmclock.redesign.model.RedesignAlarm;
import com.anglelabs.alarmclock.redesign.p039d.C0694b;
import com.anglelabs.alarmclock.redesign.utils.C0856t;
import com.anglelabs.alarmclock.redesign.utils.C0856t.C0596a;

public class TimerService extends Service {
    private boolean f2082a;
    private C0856t f2083b;
    private RedesignAlarm f2084c;

    /* renamed from: com.anglelabs.alarmclock.redesign.timer.TimerService.1 */
    class C07811 implements C0596a {
        final /* synthetic */ TimerService f2081a;

        C07811(TimerService timerService) {
            this.f2081a = timerService;
        }

        public void m3709a(boolean isInCall) {
            if (this.f2081a.f2084c != null) {
                C0644b.m2954a(this.f2081a.getBaseContext(), this.f2081a.f2084c, isInCall);
            }
        }
    }

    public TimerService() {
        this.f2084c = null;
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        C0641a.m2948d(this);
        this.f2083b = new C0856t(getBaseContext(), new C07811(this));
        this.f2084c = C0694b.m3148b(getApplicationContext(), getContentResolver());
    }

    public void onDestroy() {
        m3711a();
        C0641a.m2945a();
    }

    private void m3711a() {
        C0644b.m2952a((Context) this, 0);
        this.f2082a = false;
        if (this.f2083b != null) {
            this.f2083b.m4022b();
        }
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent == null) {
            stopSelf();
            return 2;
        }
        m3712b();
        return 1;
    }

    private void m3712b() {
        if (!this.f2082a) {
            if (this.f2083b != null) {
                this.f2083b.m4021a();
            }
            C0644b.m2953a((Context) this, this.f2084c);
            this.f2082a = true;
        }
    }
}
