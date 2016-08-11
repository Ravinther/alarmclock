package com.anglelabs.alarmclock.redesign.alarm.p028a.p032d;

import android.content.Context;
import android.widget.TextView;
import com.alarmclock.xtreme.free.R;
import com.anglelabs.alarmclock.redesign.alarm.p028a.p029b.C0605c;
import com.anglelabs.alarmclock.redesign.alarm.p028a.p029b.C0605c.C0567a;
import com.anglelabs.alarmclock.redesign.model.RedesignAlarm;

/* renamed from: com.anglelabs.alarmclock.redesign.alarm.a.d.a */
public class C0626a extends C0605c {
    public C0626a(Context context, TextView view, RedesignAlarm alarm, C0567a callback, int id) {
        super(context, view, alarm, callback, id);
    }

    public void m2885a(TextView view) {
        view.setText(R.string.alarm_alert_snooze_button_text);
    }

    public void m2884a() {
        m2804i();
    }
}
