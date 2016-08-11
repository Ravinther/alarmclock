package com.anglelabs.alarmclock.redesign.activities;

import android.content.Context;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import com.alarmclock.xtreme.free.R;
import com.anglelabs.alarmclock.redesign.p021b.p025a.C0576b;
import com.anglelabs.alarmclock.redesign.p024c.C0676a;
import com.anglelabs.alarmclock.redesign.utils.C0830k;
import com.anglelabs.alarmclock.redesign.utils.C0830k.C0825m;
import com.anglelabs.alarmclock.redesign.utils.C0832m;

public class RedesignStopwatchPreferenceActivity extends C0576b {

    /* renamed from: com.anglelabs.alarmclock.redesign.activities.RedesignStopwatchPreferenceActivity.1 */
    class C05911 implements OnPreferenceClickListener {
        final /* synthetic */ RedesignStopwatchPreferenceActivity f1635a;

        C05911(RedesignStopwatchPreferenceActivity redesignStopwatchPreferenceActivity) {
            this.f1635a = redesignStopwatchPreferenceActivity;
        }

        public boolean onPreferenceClick(Preference preference) {
            this.f1635a.startActivity(C0832m.m3939n(this.f1635a.getApplicationContext()));
            C0830k.m3896a(this.f1635a, C0825m.StopwatchEmail);
            return true;
        }
    }

    public /* synthetic */ CharSequence m2746d() {
        return m2747f();
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.redesign_stopwatch_prefs);
        CheckBoxPreference volumeControlPref = (CheckBoxPreference) m2623a("control_with_volume");
        CheckBoxPreference keepScreenOnPref = (CheckBoxPreference) m2623a("keep_screen_on");
        Preference emailTimesPref = m2623a("email_stopwatch_times");
        m2627a(keepScreenOnPref);
        m2627a(volumeControlPref);
        emailTimesPref.setOnPreferenceClickListener(new C05911(this));
        C0830k.m3896a((Context) this, C0825m.StopwatchScreen);
    }

    public void m2740a(int index, Object newValue, String key) {
    }

    public void m2742a(Object newValue, String key) {
    }

    public void m2741a(int progress, String key) {
    }

    public void m2743a(boolean isChecked, String key) {
        if (key.equals("keep_screen_on")) {
            C0676a.m3096d(getBaseContext());
            C0830k.m3896a((Context) this, isChecked ? C0825m.StopWatchKeepAwakeOn : C0825m.StopWatchKeepAwakeOff);
        } else if (key.equals("control_with_volume")) {
            C0676a.m3097e(getBaseContext());
            C0830k.m3896a((Context) this, isChecked ? C0825m.StopWatchVolumeOn : C0825m.StopWatchVolumeOff);
        }
    }

    public boolean m2744b() {
        return false;
    }

    public boolean m2745c() {
        return false;
    }

    public String m2747f() {
        return getString(R.string.settings_stopwatch);
    }

    public void onBackPressed() {
        startActivity(C0832m.m3936k(this));
        super.onBackPressed();
    }
}
