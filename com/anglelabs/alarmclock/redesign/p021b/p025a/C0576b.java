package com.anglelabs.alarmclock.redesign.p021b.p025a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.alarmclock.xtreme.free.R;
import com.anglelabs.alarmclock.preference.MultiSelectListPreference;
import com.anglelabs.alarmclock.preference.SeekBarPreference;
import com.anglelabs.alarmclock.redesign.alarm.C0646d;
import com.anglelabs.alarmclock.redesign.model.RedesignAlarm;
import com.anglelabs.alarmclock.redesign.p024c.C0676a;
import com.anglelabs.alarmclock.redesign.p024c.C0676a.C0563a;
import com.anglelabs.alarmclock.redesign.utils.C0810h;
import com.anglelabs.alarmclock.redesign.utils.C0832m;
import com.anglelabs.alarmclock.redesign.utils.ac;
import com.google.android.gms.cast.Cast;

/* renamed from: com.anglelabs.alarmclock.redesign.b.a.b */
public abstract class C0576b extends PreferenceActivity implements C0563a {
    private C0676a f1550a;
    private boolean f1551b;
    protected final OnPreferenceChangeListener f1552c;
    private final OnPreferenceChangeListener f1553d;
    private final OnPreferenceChangeListener f1554e;
    private final OnPreferenceChangeListener f1555f;
    private final OnPreferenceChangeListener f1556g;

    /* renamed from: com.anglelabs.alarmclock.redesign.b.a.b.1 */
    class C06541 implements OnClickListener {
        final /* synthetic */ C0576b f1732a;

        C06541(C0576b c0576b) {
            this.f1732a = c0576b;
        }

        public void onClick(View v) {
            this.f1732a.onBackPressed();
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.b.a.b.2 */
    class C06552 implements OnPreferenceChangeListener {
        final /* synthetic */ C0576b f1733a;

        C06552(C0576b c0576b) {
            this.f1733a = c0576b;
        }

        public boolean onPreferenceChange(Preference preference, Object newValue) {
            this.f1733a.m2635a(newValue, ((MultiSelectListPreference) preference).getKey());
            return true;
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.b.a.b.3 */
    class C06563 implements OnPreferenceChangeListener {
        final /* synthetic */ C0576b f1734a;

        C06563(C0576b c0576b) {
            this.f1734a = c0576b;
        }

        public boolean onPreferenceChange(Preference preference, Object newValue) {
            ListPreference listPref = (ListPreference) preference;
            int index = listPref.findIndexOfValue((String) newValue);
            listPref.setSummary(listPref.getEntries()[index]);
            this.f1734a.m2625a(index, newValue, listPref.getKey());
            return true;
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.b.a.b.4 */
    class C06574 implements OnPreferenceChangeListener {
        final /* synthetic */ C0576b f1735a;

        C06574(C0576b c0576b) {
            this.f1735a = c0576b;
        }

        public boolean onPreferenceChange(Preference preference, Object newValue) {
            ListPreference listPref = (ListPreference) preference;
            this.f1735a.m2625a(listPref.findIndexOfValue((String) newValue), newValue, listPref.getKey());
            return false;
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.b.a.b.5 */
    class C06585 implements OnPreferenceChangeListener {
        final /* synthetic */ C0576b f1736a;

        C06585(C0576b c0576b) {
            this.f1736a = c0576b;
        }

        public boolean onPreferenceChange(Preference preference, Object newValue) {
            this.f1736a.m2626a(((Integer) newValue).intValue(), preference.getKey());
            return true;
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.b.a.b.6 */
    class C06596 implements OnPreferenceChangeListener {
        final /* synthetic */ C0576b f1737a;

        C06596(C0576b c0576b) {
            this.f1737a = c0576b;
        }

        public boolean onPreferenceChange(Preference preference, Object newValue) {
            CheckBoxPreference checkBox = (CheckBoxPreference) preference;
            String key = preference.getKey();
            boolean isChecked = ((Boolean) newValue).booleanValue();
            checkBox.setChecked(isChecked);
            this.f1737a.m2636a(isChecked, key);
            return true;
        }
    }

    public abstract void m2625a(int i, Object obj, String str);

    public abstract void m2626a(int i, String str);

    public abstract void m2635a(Object obj, String str);

    public abstract void m2636a(boolean z, String str);

    public abstract boolean m2637b();

    public abstract boolean m2638c();

    public abstract CharSequence m2639d();

    public C0576b() {
        this.f1553d = new C06552(this);
        this.f1554e = new C06563(this);
        this.f1555f = new C06574(this);
        this.f1552c = new C06585(this);
        this.f1556g = new C06596(this);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (C0810h.m3838c(this)) {
            C0810h.m3833a((Context) this, ac.m3774b(this));
            C0810h.m3832a((Activity) this);
            setContentView(R.layout.redesign_activity_alarm_settings);
            this.f1550a = C0676a.m3091a(this, this);
            return;
        }
        startActivity(C0832m.m3927e(this));
        finish();
    }

    protected final void m2641g() {
        this.f1550a.m3099a();
    }

    protected void onStart() {
        super.onStart();
        this.f1550a.m3100a((Activity) this);
        findViewById(R.id.adsContainerView).setVisibility(m2638c() ? 0 : 8);
        if (m2637b()) {
            findViewById(R.id.fake_action_bar_layout).setVisibility(8);
            return;
        }
        findViewById(R.id.save_cancel_control_bar).setVisibility(8);
        TextView actionBarTitle = (TextView) findViewById(R.id.action_bar_title);
        if (actionBarTitle != null) {
            actionBarTitle.setText(m2639d());
            actionBarTitle.setOnClickListener(new C06541(this));
        }
    }

    protected void onResume() {
        super.onResume();
        if (this.f1551b) {
            Intent refreshIntent = getIntent();
            refreshIntent.addFlags(Cast.MAX_MESSAGE_LENGTH);
            finish();
            startActivity(refreshIntent);
            return;
        }
        RedesignAlarm activeAlarm = C0646d.m2976a(this);
        if (activeAlarm != null) {
            startActivity(C0832m.m3925d((Context) this, activeAlarm));
            finish();
        }
    }

    public void onBackPressed() {
        if (!m2637b()) {
            m2624a();
        }
        m2640e();
    }

    protected void m2624a() {
    }

    protected void m2640e() {
        super.onBackPressed();
    }

    protected void onDestroy() {
        try {
            unregisterReceiver(this.f1550a);
        } catch (Exception e) {
        }
        super.onDestroy();
    }

    public void m2642o() {
        this.f1551b = true;
    }

    protected Preference m2623a(String key) {
        return findPreference(key);
    }

    protected void m2632a(Preference pref, boolean visible) {
        if (pref == null) {
            return;
        }
        if (visible) {
            getPreferenceScreen().addPreference(pref);
        } else {
            getPreferenceScreen().removePreference(pref);
        }
    }

    protected void m2633a(MultiSelectListPreference multiSelectListPreference) {
        if (multiSelectListPreference != null) {
            multiSelectListPreference.m2409a(getString(R.string.all), getString(R.string.none));
            multiSelectListPreference.setOnPreferenceChangeListener(this.f1553d);
        }
    }

    protected void m2629a(ListPreference listPreference) {
        if (listPreference != null) {
            listPreference.setSummary(listPreference.getEntry());
            listPreference.setOnPreferenceChangeListener(this.f1554e);
        }
    }

    protected void m2630a(ListPreference listPreference, int chosenIndex) {
        m2631a(listPreference, chosenIndex, true);
    }

    protected void m2631a(ListPreference listPreference, int chosenIndex, boolean autoChangeSummary) {
        if (listPreference != null) {
            String valueToDisplay = String.valueOf(chosenIndex);
            listPreference.setValue(valueToDisplay);
            int index = listPreference.findIndexOfValue(valueToDisplay);
            if (index != -1) {
                listPreference.setSummary(listPreference.getEntries()[index]);
            }
            if (autoChangeSummary) {
                listPreference.setOnPreferenceChangeListener(this.f1554e);
            } else {
                listPreference.setOnPreferenceChangeListener(this.f1555f);
            }
        }
    }

    protected void m2634a(SeekBarPreference seekBarPreference, String summary, int progress) {
        if (seekBarPreference != null) {
            seekBarPreference.setSummary(summary);
            seekBarPreference.m2427b(progress);
            seekBarPreference.setOnPreferenceChangeListener(this.f1552c);
        }
    }

    protected void m2627a(CheckBoxPreference boxPreference) {
        if (boxPreference != null) {
            boxPreference.setOnPreferenceChangeListener(this.f1556g);
        }
    }

    protected void m2628a(CheckBoxPreference boxPreference, boolean isChecked) {
        if (boxPreference != null) {
            boxPreference.setChecked(isChecked);
            boxPreference.setOnPreferenceChangeListener(this.f1556g);
        }
    }
}
