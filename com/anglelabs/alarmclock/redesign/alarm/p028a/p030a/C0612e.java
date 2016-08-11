package com.anglelabs.alarmclock.redesign.alarm.p028a.p030a;

import android.content.Context;
import android.widget.TextView;
import com.alarmclock.xtreme.free.R;
import com.anglelabs.alarmclock.redesign.alarm.p028a.p029b.C0605c;
import com.anglelabs.alarmclock.redesign.alarm.p028a.p029b.C0605c.C0567a;
import com.anglelabs.alarmclock.redesign.model.RedesignAlarm;
import com.anglelabs.alarmclock.redesign.utils.C0858u;

/* renamed from: com.anglelabs.alarmclock.redesign.alarm.a.a.e */
public class C0612e extends C0605c {
    public C0612e(Context context, TextView view, RedesignAlarm alarm, C0567a callback, int id) {
        super(context, view, alarm, callback, id);
    }

    public void m2823a(TextView view) {
        view.setText(R.string.alarm_alert_dismiss_side_button_text);
    }

    public void m2822a() {
        C0858u.m4026a(m2802g(), m2802g().getString(R.string.dismiss_unclicked_side_buttons));
    }

    public boolean m2824b() {
        return false;
    }
}
