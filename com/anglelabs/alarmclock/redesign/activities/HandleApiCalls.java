package com.anglelabs.alarmclock.redesign.activities;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.widget.Toast;
import com.alarmclock.xtreme.free.R;
import com.anglelabs.alarmclock.redesign.model.C0773a;
import com.anglelabs.alarmclock.redesign.model.RedesignAlarm;
import com.anglelabs.alarmclock.redesign.p039d.C0694b;
import com.anglelabs.alarmclock.redesign.timer.C0783a;
import com.anglelabs.alarmclock.redesign.timer.TimerObject;
import com.anglelabs.alarmclock.redesign.timer.TimerObject.C0779b;
import com.anglelabs.alarmclock.redesign.timer.TimerReceiver;
import com.anglelabs.alarmclock.redesign.utils.C0810h;
import com.anglelabs.alarmclock.redesign.utils.C0830k;
import com.anglelabs.alarmclock.redesign.utils.C0830k.C0819g;
import com.anglelabs.alarmclock.redesign.utils.C0832m;
import com.anglelabs.alarmclock.redesign.utils.C0850q;
import com.anglelabs.alarmclock.redesign.utils.C0870z;
import com.anglelabs.alarmclock.redesign.utils.ac;
import com.mopub.mobileads.util.Base64;
import java.util.ArrayList;

public class HandleApiCalls extends Activity {
    protected void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            if (C0810h.m3838c(getApplicationContext())) {
                Intent intent = getIntent();
                if (intent != null) {
                    String action = intent.getAction();
                    if (TextUtils.isEmpty(action)) {
                        finish();
                        return;
                    } else if (action.equals("android.intent.action.SET_ALARM")) {
                        m2563a(intent);
                    } else if (C0810h.f2127a) {
                        m2564a(intent, action);
                    }
                }
                finish();
                return;
            }
            Toast.makeText(getApplicationContext(), getString(R.string.tos_not_accepted), 1).show();
        } finally {
            finish();
        }
    }

    @TargetApi(19)
    private void m2564a(Intent intent, String action) {
        Object obj = -1;
        switch (action.hashCode()) {
            case 269581763:
                if (action.equals("android.intent.action.SET_TIMER")) {
                    obj = 1;
                    break;
                }
                break;
            case 1112785375:
                if (action.equals("android.intent.action.SHOW_ALARMS")) {
                    obj = null;
                    break;
                }
                break;
        }
        switch (obj) {
            case Base64.DEFAULT /*0*/:
                m2562a();
            case Base64.NO_PADDING /*1*/:
                m2567d(intent);
            default:
        }
    }

    private void m2563a(Intent intent) {
        int minutes;
        int hour = intent.getIntExtra("android.intent.extra.alarm.HOUR", -1);
        if (intent.hasExtra("android.intent.extra.alarm.MINUTES")) {
            minutes = intent.getIntExtra("android.intent.extra.alarm.MINUTES", -1);
        } else {
            minutes = 0;
        }
        if (hour < 0 || hour > 23 || minutes < 0 || minutes > 59) {
            startActivity(C0832m.m3932g(this));
            C0830k.m3896a((Context) this, C0819g.SetGoogleVoiceSetAlarm);
            return;
        }
        C0773a daysOfWeek;
        RedesignAlarm alarm = C0694b.m3131a((Context) this, getContentResolver());
        alarm.f2010k = C0694b.m3128a(getContentResolver());
        if (!TextUtils.isEmpty(m2565b(intent))) {
            alarm.f2020u = m2565b(intent);
        }
        boolean isShowToast = true;
        if (C0810h.f2127a) {
            daysOfWeek = m2566c(intent);
            isShowToast = ac.m3773a(ac.m3774b(getApplicationContext()), alarm);
        } else {
            daysOfWeek = new C0773a(0);
        }
        alarm.m3612a(hour, minutes, daysOfWeek);
        alarm.f2012m = true;
        C0694b.m3153c(this, alarm);
        C0832m.m3935j(this);
        if (isShowToast) {
            C0870z.m4065a((Context) this, alarm);
        }
        C0830k.m3896a((Context) this, C0819g.SetGoogleVoiceSetAlarmValue);
    }

    private void m2562a() {
        startActivity(C0832m.m3930f(this));
        C0830k.m3896a((Context) this, C0819g.SetGoogleVoiceShowAlarms);
    }

    private String m2565b(Intent intent) {
        if (intent.hasExtra("android.intent.extra.alarm.MESSAGE")) {
            return intent.getStringExtra("android.intent.extra.alarm.MESSAGE");
        }
        return null;
    }

    @TargetApi(19)
    private C0773a m2566c(Intent intent) {
        C0773a daysOfWeek = new C0773a(0);
        if (intent.hasExtra("android.intent.extra.alarm.DAYS")) {
            ArrayList daysArrayList = intent.getIntegerArrayListExtra("android.intent.extra.alarm.DAYS");
            boolean[] daysBooleanArray;
            int i;
            boolean z;
            if (daysArrayList != null) {
                daysBooleanArray = new boolean[daysArrayList.size()];
                for (i = 0; i < daysArrayList.size(); i++) {
                    if (((Integer) daysArrayList.get(i)).intValue() == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    daysBooleanArray[i] = z;
                }
                daysOfWeek.m3657a(daysBooleanArray);
            } else {
                int[] daysArray = intent.getIntArrayExtra("android.intent.extra.alarm.DAYS");
                if (daysArray != null) {
                    daysBooleanArray = new boolean[daysArray.length];
                    for (i = 0; i < daysArray.length; i++) {
                        if (daysArray[i] == 1) {
                            z = true;
                        } else {
                            z = false;
                        }
                        daysBooleanArray[i] = z;
                    }
                    daysOfWeek.m3657a(daysBooleanArray);
                }
            }
        }
        return daysOfWeek;
    }

    @TargetApi(19)
    private void m2567d(Intent intent) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        if (intent.hasExtra("android.intent.extra.alarm.LENGTH")) {
            long length = 1000 * ((long) intent.getIntExtra("android.intent.extra.alarm.LENGTH", 0));
            if (length < 0 || length > 359999000) {
                C0850q.m3986a("Invalid timer length requested: " + length);
                return;
            }
            String label = m2565b(intent);
            if (TextUtils.isEmpty(label)) {
                label = getString(R.string.timer_default_name) + (C0783a.m3719c(prefs) + 1);
            }
            TimerObject timer = new TimerObject(length, label);
            timer.m3691a(C0779b.Create, prefs);
            TimerReceiver.m3704a((Context) this, timer.m3683a(), C0779b.Create);
            C0830k.m3896a((Context) this, C0819g.SetGoogleVoiceSetTimerValue);
            startActivity(C0832m.m3910a((Context) this, timer.m3683a()));
            return;
        }
        startActivity(C0832m.m3934i(this));
        C0830k.m3896a((Context) this, C0819g.SetGoogleVoiceSetTimer);
    }
}
