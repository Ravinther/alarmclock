package com.anglelabs.alarmclock.redesign.p021b.p025a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.p012a.C0329b;
import com.anglelabs.alarmclock.redesign.activities.NewMainActivity;
import com.anglelabs.alarmclock.redesign.activities.RedesignAlarmAlertActivity;
import com.anglelabs.alarmclock.redesign.activities.RedesignChooseBackgroundActivity;
import com.anglelabs.alarmclock.redesign.alarm.C0646d;
import com.anglelabs.alarmclock.redesign.model.RedesignAlarm;
import com.anglelabs.alarmclock.redesign.p024c.C0676a;
import com.anglelabs.alarmclock.redesign.p024c.C0676a.C0563a;
import com.anglelabs.alarmclock.redesign.utils.C0790a;
import com.anglelabs.alarmclock.redesign.utils.C0810h;
import com.anglelabs.alarmclock.redesign.utils.C0832m;
import com.anglelabs.alarmclock.redesign.utils.ac;
import com.google.android.gms.cast.Cast;

/* renamed from: com.anglelabs.alarmclock.redesign.b.a.a */
public class C0564a extends C0329b implements C0563a {
    private C0676a f1511o;
    private C0790a f1512p;
    boolean f1513q;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if ((this instanceof NewMainActivity) || C0810h.m3838c(this)) {
            C0810h.m3833a((Context) this, ac.m3774b(this));
            if (!(this instanceof RedesignChooseBackgroundActivity)) {
                C0810h.m3832a((Activity) this);
            }
            this.f1511o = C0676a.m3091a(this, this);
            return;
        }
        startActivity(C0832m.m3927e(this));
        finish();
    }

    public final void m2571c(boolean monitor) {
        this.f1511o.m3101a(monitor);
    }

    public final void m2572d(boolean monitor) {
        this.f1511o.m3102b(monitor);
    }

    protected void onResume() {
        super.onResume();
        if (this.f1513q) {
            Intent refreshIntent = getIntent();
            refreshIntent.addFlags(Cast.MAX_MESSAGE_LENGTH);
            finish();
            startActivity(refreshIntent);
        } else if (!(this instanceof RedesignAlarmAlertActivity)) {
            RedesignAlarm activeAlarm = C0646d.m2976a(this);
            if (activeAlarm != null) {
                startActivity(C0832m.m3925d((Context) this, activeAlarm));
                finish();
            }
        }
    }

    protected void onStart() {
        super.onStart();
        this.f1511o.m3100a((Activity) this);
    }

    public C0790a m2573n() {
        if (this.f1512p == null) {
            this.f1512p = new C0790a(this);
        }
        return this.f1512p;
    }

    protected void onDestroy() {
        try {
            unregisterReceiver(this.f1511o);
        } catch (Exception e) {
        }
        super.onDestroy();
    }

    public void m2574o() {
        this.f1513q = true;
    }
}
