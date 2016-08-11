package com.anglelabs.alarmclock.redesign.alarm.p028a.p032d;

import android.content.Context;
import android.widget.TextView;
import com.alarmclock.xtreme.free.R;
import com.anglelabs.alarmclock.redesign.alarm.p028a.p029b.C0605c;
import com.anglelabs.alarmclock.redesign.alarm.p028a.p029b.C0605c.C0567a;
import com.anglelabs.alarmclock.redesign.model.RedesignAlarm;

/* renamed from: com.anglelabs.alarmclock.redesign.alarm.a.d.e */
public class C0630e extends C0605c {
    public C0630e(Context context, TextView view, RedesignAlarm alarm, C0567a callback, int id) {
        super(context, view, alarm, callback, id);
    }

    public CharSequence m2901f() {
        return m2802g().getString(R.string.snooze_unclicked_side_buttons);
    }

    public void m2899a(TextView view) {
        view.setText(R.string.alarm_alert_snooze_side_button_text);
    }

    public void m2898a() {
    }

    public boolean m2900b() {
        return false;
    }
}
