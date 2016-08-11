package com.alarmclock.xtreme.free;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import com.anglelabs.alarmclock.receivers.AlarmInitReceiver;
import com.anglelabs.alarmclock.redesign.utils.C0810h;
import com.anglelabs.alarmclock.redesign.utils.C0849p;
import com.anglelabs.alarmclock.redesign.utils.ac;
import com.avg.toolkit.ITKSvc;
import com.avg.toolkit.crashReport.CrashReport;

public class AlarmClockApplication extends Application {
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        C0810h.m3833a((Context) this, ac.m3774b(this));
    }

    public void onCreate() {
        super.onCreate();
        CrashReport.init(this);
        C0849p.m3981b(getApplicationContext());
        AlarmInitReceiver.m2433a((Context) this);
        C0810h.m3833a((Context) this, ac.m3774b(this));
        ITKSvc.DoEmptyMessage(getApplicationContext());
    }
}
