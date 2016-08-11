package com.anglelabs.alarmclock.redesign.alarm.p028a.p032d;

import android.content.Context;
import android.widget.TextView;
import com.alarmclock.xtreme.free.R;
import com.anglelabs.alarmclock.redesign.alarm.p028a.p029b.C0605c;
import com.anglelabs.alarmclock.redesign.alarm.p028a.p029b.C0605c.C0567a;
import com.anglelabs.alarmclock.redesign.alarm.p028a.p029b.C0605c.C0609b;
import com.anglelabs.alarmclock.redesign.alarm.p028a.p029b.C0605c.C0610c;
import com.anglelabs.alarmclock.redesign.model.RedesignAlarm;
import com.anglelabs.alarmclock.redesign.utils.C0859v;

/* renamed from: com.anglelabs.alarmclock.redesign.alarm.a.d.d */
public class C0629d extends C0605c implements C0609b, C0610c {
    final String f1694a;
    private final C0859v f1695b;

    public C0629d(Context context, TextView view, RedesignAlarm alarm, C0567a callback, int id) {
        int shakeDuration;
        super(context, view, alarm, callback, id);
        if (alarm.f2014o) {
            this.f1694a = context.getString(R.string.alarm_alert_shake_to_snooze, new Object[]{Integer.valueOf(alarm.f1989B + callback.m2595m())});
            shakeDuration = (alarm.f1989B + timesSnoozed) * 900;
        } else {
            this.f1694a = context.getString(R.string.alarm_alert_shake_to_snooze, new Object[]{Integer.valueOf(alarm.f1989B)});
            shakeDuration = alarm.f1989B * 900;
        }
        view.setText(this.f1694a);
        this.f1695b = new C0859v(context, this, callback.m2594l(), (long) shakeDuration);
    }

    public CharSequence m2897f() {
        return m2802g().getString(R.string.snooze_unclicked_shake);
    }

    public void m2892a(TextView view) {
        view.setText(m2802g().getString(R.string.alarm_alert_shake_to_snooze, new Object[]{Integer.valueOf(m2805j().f1989B + m2803h().m2595m())}));
        view.setCompoundDrawablesWithIntrinsicBounds(R.drawable.alarm_shake_device, 0, 0, 0);
        view.setBackgroundColor(0);
    }

    public void m2891a() {
    }

    public void m2894c() {
        m2804i();
    }

    public boolean m2893b() {
        return false;
    }

    public void m2895d() {
        this.f1695b.m4028b();
    }

    public void m2896e() {
        this.f1695b.m4027a();
    }
}
