package com.anglelabs.alarmclock.redesign.alarm.p028a.p030a;

import android.content.Context;
import android.widget.TextView;
import com.alarmclock.xtreme.free.R;
import com.anglelabs.alarmclock.redesign.alarm.p028a.p029b.C0605c;
import com.anglelabs.alarmclock.redesign.alarm.p028a.p029b.C0605c.C0567a;
import com.anglelabs.alarmclock.redesign.alarm.p028a.p029b.C0605c.C0609b;
import com.anglelabs.alarmclock.redesign.alarm.p028a.p029b.C0605c.C0610c;
import com.anglelabs.alarmclock.redesign.model.RedesignAlarm;
import com.anglelabs.alarmclock.redesign.utils.C0858u;
import com.anglelabs.alarmclock.redesign.utils.C0859v;

/* renamed from: com.anglelabs.alarmclock.redesign.alarm.a.a.d */
public class C0611d extends C0605c implements C0609b, C0610c {
    private final C0859v f1670a;

    public C0611d(Context context, TextView view, RedesignAlarm alarm, C0567a callback, int id) {
        String displayText;
        int shakeDuration;
        super(context, view, alarm, callback, id);
        if (alarm.f2014o) {
            displayText = context.getString(R.string.alarm_alert_shake_to_dismiss, new Object[]{Integer.valueOf(alarm.f1989B + callback.m2595m())});
            shakeDuration = (alarm.f1989B + timesSnoozed) * 900;
        } else {
            displayText = context.getString(R.string.alarm_alert_shake_to_dismiss, new Object[]{Integer.valueOf(alarm.f1989B)});
            shakeDuration = alarm.f1989B * 900;
        }
        view.setText(displayText);
        this.f1670a = new C0859v(context, this, callback.m2594l(), (long) shakeDuration);
    }

    public void m2817a(TextView view) {
        view.setText(R.string.alarm_alert_dismiss_shake_device_text);
        view.setCompoundDrawablesWithIntrinsicBounds(R.drawable.alarm_shake_device, 0, 0, 0);
        view.setBackgroundColor(0);
    }

    public void m2816a() {
        C0858u.m4026a(m2802g(), m2802g().getString(R.string.dismiss_unclicked_shake));
    }

    public boolean m2818b() {
        return false;
    }

    public void m2819c() {
        m2806k();
    }

    public void m2820d() {
        this.f1670a.m4028b();
    }

    public void m2821e() {
        this.f1670a.m4027a();
    }
}
