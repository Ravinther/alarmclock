package com.anglelabs.alarmclock.redesign.app;

import android.content.ContentResolver;
import android.content.Context;
import com.anglelabs.alarmclock.redesign.model.C0773a;
import com.anglelabs.alarmclock.redesign.model.RedesignAlarm;
import com.anglelabs.alarmclock.redesign.p039d.C0694b;
import com.anglelabs.alarmclock.redesign.utils.C0808f;
import com.anglelabs.alarmclock.redesign.utils.C0810h;
import com.anglelabs.alarmclock.redesign.utils.C0832m;
import com.anglelabs.alarmclock.redesign.utils.C0850q;
import com.anglelabs.alarmclock.redesign.utils.C0860w;
import java.util.Calendar;
import java.util.Locale;

/* renamed from: com.anglelabs.alarmclock.redesign.app.b */
public class C0653b {

    /* renamed from: com.anglelabs.alarmclock.redesign.app.b.1 */
    static class C06521 implements Runnable {
        final /* synthetic */ Context f1731a;

        C06521(Context context) {
            this.f1731a = context;
        }

        public void run() {
            ContentResolver resolver = this.f1731a.getContentResolver();
            if (C0694b.m3147b(resolver).getCount() == 0) {
                RedesignAlarm defaultAlarm = C0694b.m3131a(this.f1731a, resolver);
                C0773a days = new C0773a(0);
                days.m3658b(this.f1731a);
                defaultAlarm.f2005f = days;
                defaultAlarm.f2012m = false;
                C0694b.m3153c(this.f1731a, defaultAlarm);
                days.m3660c(this.f1731a);
                defaultAlarm.f2010k = C0694b.m3128a(resolver);
                defaultAlarm.f2005f = days;
                defaultAlarm.f2009j = 9;
                defaultAlarm.f2023x = 30;
                C0694b.m3153c(this.f1731a, defaultAlarm);
                C0832m.m3935j(this.f1731a);
            }
        }
    }

    public static void m3001a(Context context) {
        if (C0810h.m3839d(context)) {
            C0653b.m3002b(context);
            C0653b.m3003c(context);
        }
    }

    private static void m3002b(Context context) {
        C0860w.m4030a(context, String.valueOf(Calendar.getInstance(Locale.getDefault()).getFirstDayOfWeek()));
    }

    private static void m3003c(Context context) {
        Context appContext = context.getApplicationContext();
        if (appContext == null) {
            C0850q.m3987b("context is null!");
        } else {
            C0808f.m3825a(new C06521(appContext));
        }
    }
}
