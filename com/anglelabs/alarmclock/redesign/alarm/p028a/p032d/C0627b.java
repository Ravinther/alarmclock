package com.anglelabs.alarmclock.redesign.alarm.p028a.p032d;

import android.content.Context;
import android.widget.TextView;
import com.alarmclock.xtreme.free.R;
import com.anglelabs.alarmclock.redesign.alarm.p028a.p029b.C0605c;
import com.anglelabs.alarmclock.redesign.alarm.p028a.p029b.C0605c.C0567a;
import com.anglelabs.alarmclock.redesign.model.RedesignAlarm;

/* renamed from: com.anglelabs.alarmclock.redesign.alarm.a.d.b */
public class C0627b extends C0605c {
    public C0627b(Context context, TextView view, RedesignAlarm alarm, C0567a callback, int id) {
        super(context, view, alarm, callback, id);
    }

    public CharSequence m2888f() {
        return m2802g().getString(R.string.snooze_unclicked_disabled);
    }

    public void m2887a(TextView view) {
        view.setVisibility(4);
    }

    public void m2886a() {
    }
}
