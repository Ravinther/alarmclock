package com.anglelabs.alarmclock.redesign.alarm.p028a.p030a;

import android.content.Context;
import android.widget.TextView;
import com.alarmclock.xtreme.free.R;
import com.anglelabs.alarmclock.redesign.alarm.p028a.p029b.C0605c;
import com.anglelabs.alarmclock.redesign.alarm.p028a.p029b.C0605c.C0567a;
import com.anglelabs.alarmclock.redesign.model.RedesignAlarm;

/* renamed from: com.anglelabs.alarmclock.redesign.alarm.a.a.b */
public class C0607b extends C0605c {
    public C0607b(Context context, TextView view, RedesignAlarm alarm, C0567a callback, int id) {
        super(context, view, alarm, callback, id);
    }

    public void m2810a(TextView view) {
        view.setText(R.string.alarm_alert_dismiss_captcha_text);
    }

    public void m2809a() {
        m2803h().m2591b(true);
    }
}
