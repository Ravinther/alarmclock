package com.alarmclock.xtreme.free;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.anglelabs.alarmclock.redesign.utils.C0830k;
import com.anglelabs.alarmclock.redesign.utils.C0830k.C0817d;
import com.anglelabs.alarmclock.redesign.utils.C0832m;
import com.avg.ui.general.rateus.C1186c;
import com.google.android.gms.cast.Cast;

public class AlarmClock extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        C1186c rateUsManager = C1186c.m4956a((Context) this);
        rateUsManager.m4985a("app_launch");
        rateUsManager.m4983a(R.string.rate_us_key_back_button, null, null, "rate_us_exit_app");
        Intent intent = getIntent();
        if (intent != null) {
            m2369a(intent);
        }
        Intent nextIntent = m2368a();
        nextIntent.addFlags(Cast.MAX_MESSAGE_LENGTH);
        startActivity(nextIntent);
        finish();
    }

    private void m2369a(Intent intent) {
        if (intent.getBooleanExtra("extra_clock_widget", false)) {
            C0830k.m3896a((Context) this, C0817d.ClockWidget);
        }
        if (intent.getBooleanExtra("extra_next_alarm_widget", false)) {
            C0830k.m3896a((Context) this, C0817d.NextAlarmWidget);
        }
    }

    private Intent m2368a() {
        Intent intent = getIntent();
        if (intent == null || !intent.getBooleanExtra("extra_timer", false)) {
            return C0832m.m3927e(this);
        }
        return C0832m.m3910a((Context) this, 0);
    }
}
