package com.anglelabs.alarmclock.redesign.activities;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceCategory;
import android.preference.PreferenceScreen;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewParent;
import android.widget.BaseAdapter;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.TimePicker;
import com.alarmclock.xtreme.free.R;
import com.anglelabs.alarmclock.preference.ApplicationPreference;
import com.anglelabs.alarmclock.preference.ArtistPreference;
import com.anglelabs.alarmclock.preference.MusicPreference;
import com.anglelabs.alarmclock.preference.PlaylistPreference;
import com.anglelabs.alarmclock.preference.SeekBarPreference;
import com.anglelabs.alarmclock.preference.SelectRingtonePreference;
import com.anglelabs.alarmclock.preference.VolumeBarPreference;
import com.anglelabs.alarmclock.redesign.activities.p019a.C0503b;
import com.anglelabs.alarmclock.redesign.activities.p019a.C0592a;
import com.anglelabs.alarmclock.redesign.model.RedesignAlarm;
import com.anglelabs.alarmclock.redesign.p021b.p025a.C0576b;
import com.anglelabs.alarmclock.redesign.p039d.C0694b;
import com.anglelabs.alarmclock.redesign.utils.C0794b;
import com.anglelabs.alarmclock.redesign.utils.C0810h;
import com.anglelabs.alarmclock.redesign.utils.C0830k;
import com.anglelabs.alarmclock.redesign.utils.C0830k.C0813f;
import com.anglelabs.alarmclock.redesign.utils.C0830k.C0824l;
import com.anglelabs.alarmclock.redesign.utils.C0830k.C0827o;
import com.anglelabs.alarmclock.redesign.utils.C0832m;
import com.anglelabs.alarmclock.redesign.utils.C0850q;
import com.anglelabs.alarmclock.redesign.utils.C0870z;
import com.anglelabs.alarmclock.redesign.utils.ab;
import com.anglelabs.alarmclock.redesign.utils.ac;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;
import java.util.Calendar;
import java.util.Locale;

public class RedesignAlarmSettingsActivity extends C0576b implements OnTimeSetListener {
    private PlaylistPreference f1557A;
    private ApplicationPreference f1558B;
    private Preference f1559C;
    private Preference f1560D;
    private SharedPreferences f1561E;
    private int f1562F;
    private boolean f1563G;
    private int f1564H;
    private int f1565I;
    private int f1566J;
    private int f1567K;
    private int f1568L;
    private boolean f1569M;
    private boolean f1570N;
    private boolean f1571O;
    private RedesignAlarm f1572P;
    private AlertDialog f1573Q;
    private C0503b f1574R;
    private final OnPreferenceClickListener f1575S;
    private final String f1576a;
    private ListPreference f1577b;
    private ListPreference f1578d;
    private ListPreference f1579e;
    private ListPreference f1580f;
    private ListPreference f1581g;
    private ListPreference f1582h;
    private ListPreference f1583i;
    private SeekBarPreference f1584j;
    private SeekBarPreference f1585k;
    private SeekBarPreference f1586l;
    private SeekBarPreference f1587m;
    private SeekBarPreference f1588n;
    private VolumeBarPreference f1589o;
    private CheckBoxPreference f1590p;
    private CheckBoxPreference f1591q;
    private CheckBoxPreference f1592r;
    private CheckBoxPreference f1593s;
    private CheckBoxPreference f1594t;
    private CheckBoxPreference f1595u;
    private PreferenceCategory f1596v;
    private EditTextPreference f1597w;
    private SelectRingtonePreference f1598x;
    private MusicPreference f1599y;
    private ArtistPreference f1600z;

    /* renamed from: com.anglelabs.alarmclock.redesign.activities.RedesignAlarmSettingsActivity.1 */
    class C05681 implements OnClickListener {
        final /* synthetic */ RedesignAlarmSettingsActivity f1529a;

        C05681(RedesignAlarmSettingsActivity redesignAlarmSettingsActivity) {
            this.f1529a = redesignAlarmSettingsActivity;
        }

        public void onClick(View v) {
            this.f1529a.m2697a();
            C0830k.m3897a(v.getContext(), C0824l.Done, this.f1529a.m2696z());
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.activities.RedesignAlarmSettingsActivity.2 */
    class C05692 implements OnClickListener {
        final /* synthetic */ RedesignAlarmSettingsActivity f1530a;

        C05692(RedesignAlarmSettingsActivity redesignAlarmSettingsActivity) {
            this.f1530a = redesignAlarmSettingsActivity;
        }

        public void onClick(View v) {
            C0830k.m3897a(v.getContext(), C0824l.Cancel, this.f1530a.m2696z());
            this.f1530a.m2705e();
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.activities.RedesignAlarmSettingsActivity.3 */
    class C05703 implements OnPreferenceChangeListener {
        final /* synthetic */ RedesignAlarmSettingsActivity f1531a;

        C05703(RedesignAlarmSettingsActivity redesignAlarmSettingsActivity) {
            this.f1531a = redesignAlarmSettingsActivity;
        }

        public boolean onPreferenceChange(Preference p, Object newValue) {
            this.f1531a.f1572P.f2020u = (String) newValue;
            this.f1531a.m2655b(this.f1531a.f1572P.f2020u);
            return true;
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.activities.RedesignAlarmSettingsActivity.4 */
    class C05714 implements OnPreferenceClickListener {
        final /* synthetic */ RedesignAlarmSettingsActivity f1532a;

        C05714(RedesignAlarmSettingsActivity redesignAlarmSettingsActivity) {
            this.f1532a = redesignAlarmSettingsActivity;
        }

        public boolean onPreferenceClick(Preference preference) {
            if (preference == this.f1532a.f1599y) {
                this.f1532a.m2693w();
            } else if (preference == this.f1532a.f1600z) {
                this.f1532a.m2694x();
            } else if (preference == this.f1532a.f1557A) {
                this.f1532a.m2695y();
            } else if (preference == this.f1532a.f1558B) {
                this.f1532a.m2691u();
            } else if (preference == this.f1532a.f1560D) {
                ac.m3770a(this.f1532a, this.f1532a.f1572P, this.f1532a.f1566J, this.f1532a.f1567K);
            } else if (preference == this.f1532a.f1598x) {
                this.f1532a.m2692v();
            } else if (preference != this.f1532a.f1559C) {
                return false;
            } else {
                this.f1532a.m2677l();
                this.f1532a.startActivityForResult(C0832m.m3919b(this.f1532a, this.f1532a.f1572P), 5);
            }
            C0830k.m3896a(this.f1532a, C0824l.SelectSoundAtSelectedType);
            return true;
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.activities.RedesignAlarmSettingsActivity.5 */
    class C05725 implements DialogInterface.OnClickListener {
        final /* synthetic */ RedesignAlarmSettingsActivity f1533a;

        C05725(RedesignAlarmSettingsActivity redesignAlarmSettingsActivity) {
            this.f1533a = redesignAlarmSettingsActivity;
        }

        public void onClick(DialogInterface d, int w) {
            this.f1533a.f1573Q.dismiss();
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.activities.RedesignAlarmSettingsActivity.6 */
    class C05736 implements DialogInterface.OnClickListener {
        final /* synthetic */ RedesignAlarmSettingsActivity f1534a;

        C05736(RedesignAlarmSettingsActivity redesignAlarmSettingsActivity) {
            this.f1534a = redesignAlarmSettingsActivity;
        }

        public void onClick(DialogInterface d, int w) {
            this.f1534a.m2691u();
            this.f1534a.f1573Q.dismiss();
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.activities.RedesignAlarmSettingsActivity.a */
    private enum C0574a {
        SCREEN_BUTTON(R.string.press_on_screen_button, String.valueOf(1)),
        SHAKE_DEVICE(R.string.shake_device, String.valueOf(7)),
        MATH(R.string.solve_math_problems, String.valueOf(5)),
        CAPTCHA(R.string.enter_captcha, String.valueOf(4)),
        SIDE_BUTTONS(R.string.press_side_buttons, String.valueOf(9));
        
        final int f1541f;
        final String f1542g;

        private C0574a(int resId, String index) {
            this.f1541f = resId;
            this.f1542g = index;
        }

        public String m2620a(Context context) {
            return context.getString(this.f1541f);
        }

        public int m2619a() {
            return Integer.parseInt(this.f1542g);
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.activities.RedesignAlarmSettingsActivity.b */
    private enum C0575b {
        SCREEN_BUTTON(R.string.press_on_screen_button, String.valueOf(1)),
        SIDE_BUTTONS(R.string.press_side_buttons, String.valueOf(2)),
        SHAKE_DEVICE(R.string.shake_device, String.valueOf(3)),
        MATH(R.string.solve_math_problems, String.valueOf(6));
        
        final int f1548e;
        final String f1549f;

        private C0575b(int resId, String index) {
            this.f1548e = resId;
            this.f1549f = index;
        }

        public String m2622a(Context context) {
            return context.getString(this.f1548e);
        }

        public int m2621a() {
            return Integer.parseInt(this.f1549f);
        }
    }

    public RedesignAlarmSettingsActivity() {
        this.f1576a = "RedesignAlarmSettingsActivity";
        this.f1562F = -1;
        this.f1568L = -1;
        this.f1575S = new C05714(this);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        m2654b(savedInstanceState);
        m2662f();
        this.f1561E = ac.m3774b(this);
        C0810h.m3833a((Context) this, this.f1561E);
        this.f1597w = (EditTextPreference) m2623a("alarm_name");
        this.f1577b = (ListPreference) m2623a("sound_type");
        this.f1598x = (SelectRingtonePreference) m2623a("set_ringtone");
        this.f1599y = (MusicPreference) m2623a("set_music");
        this.f1600z = (ArtistPreference) m2623a("set_artist");
        this.f1557A = (PlaylistPreference) m2623a("set_playlist");
        this.f1558B = (ApplicationPreference) m2623a("set_application");
        this.f1578d = (ListPreference) m2623a("dismiss_method");
        this.f1579e = (ListPreference) m2623a("snooze_method");
        this.f1585k = (SeekBarPreference) m2623a("snooze_duration");
        this.f1584j = (SeekBarPreference) m2623a("snooze_decrease_duration");
        this.f1586l = (SeekBarPreference) m2623a("max_snoozes");
        this.f1590p = (CheckBoxPreference) m2623a("large_snooze_button");
        this.f1580f = (ListPreference) m2623a("auto_snooze");
        this.f1581g = (ListPreference) m2623a("auto_dismiss");
        this.f1591q = (CheckBoxPreference) m2623a("vibrate");
        this.f1592r = (CheckBoxPreference) m2623a("use_volume_cresendo");
        this.f1594t = (CheckBoxPreference) m2623a("keep_screen_on");
        this.f1589o = (VolumeBarPreference) m2623a("alarm_volume");
        this.f1582h = (ListPreference) m2623a("volume_increase_duration");
        this.f1593s = (CheckBoxPreference) m2623a("alarm_in_silent_mode");
        this.f1583i = (ListPreference) m2623a("math_difficulty");
        this.f1588n = (SeekBarPreference) m2623a("math_dismiss_num");
        this.f1587m = (SeekBarPreference) m2623a("math_snooze_num");
        this.f1596v = (PreferenceCategory) m2623a("category_math_settings");
        this.f1560D = m2623a("preview");
        this.f1559C = m2623a("advanced_settings");
        this.f1595u = (CheckBoxPreference) m2623a("allow_passing_questions");
        m2667h();
        m2679m();
        m2681n();
        m2689s();
        m2684p();
        m2685q();
        m2688r();
        m2675k();
        m2645a(savedInstanceState);
    }

    private void m2645a(Bundle state) {
        if (state != null && state.getBoolean("displaying_alert_dialog", false)) {
            if (state.getBoolean("displaying_beta_dialog", false)) {
                m2690t();
                return;
            }
            this.f1569M = state.getBoolean("user_editing_dismiss_alert", false);
            this.f1573Q = m2651b(this.f1569M);
            this.f1573Q.show();
        }
    }

    private void m2654b(Bundle state) {
        if (state != null) {
            this.f1563G = state.getBoolean("add_if_saved");
            this.f1564H = state.getInt("id");
            this.f1566J = state.getInt("hour");
            this.f1567K = state.getInt("minute");
            this.f1572P = (RedesignAlarm) state.getParcelable("extra_alarm");
            this.f1562F = state.getInt("extra_mode", -1);
            this.f1568L = state.getInt("pending_index", -1);
        } else {
            Intent i = getIntent();
            this.f1572P = (RedesignAlarm) i.getParcelableExtra("extra_alarm");
            this.f1564H = i.getIntExtra("alarm_id", -99);
            this.f1563G = i.getBooleanExtra("add_if_saved", false);
            this.f1562F = i.getIntExtra("extra_mode", -1);
        }
        if (this.f1562F < 0) {
            C0850q.m3987b("Edit alarm was started without specifying a mode!");
            finish();
        }
        if (this.f1572P != null) {
            this.f1564H = this.f1572P.f2010k;
        } else if (this.f1564H != -99) {
            this.f1572P = C0694b.m3129a(getContentResolver(), (long) this.f1564H);
        } else if (this.f1562F == 1 || this.f1562F == 0) {
            this.f1572P = C0694b.m3131a((Context) this, getContentResolver());
            this.f1563G = true;
        } else if (this.f1562F == 3) {
            this.f1572P = C0694b.m3148b((Context) this, getContentResolver());
        }
    }

    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
        View view = getCurrentFocus();
        if (view != null) {
            ac.m3775b(this, view);
            view.clearFocus();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.clearChildFocus(view);
            }
        }
        String key = preference.getKey();
        C0813f googleAnalyticAction = null;
        if (key.compareTo("alarm_set_time") == 0) {
            googleAnalyticAction = C0824l.Preview;
        } else if (key.compareTo("alarm_name") == 0) {
            googleAnalyticAction = C0824l.Label;
        } else if (key.compareTo("sound_type") == 0) {
            googleAnalyticAction = C0824l.SoundType;
        } else if (key.compareTo("volume_increase_duration") == 0) {
            googleAnalyticAction = C0824l.TimeToMaxVolume;
        } else if (key.compareTo("alarm_volume") == 0) {
            googleAnalyticAction = C0824l.MaxVolume;
        } else if (key.compareTo("dismiss_method") == 0) {
            googleAnalyticAction = C0824l.Dismiss;
        } else if (key.compareTo("auto_dismiss") == 0) {
            googleAnalyticAction = C0824l.AutoDismiss;
        } else if (key.compareTo("math_snooze_num") == 0) {
            googleAnalyticAction = C0824l.MathToDismiss;
        } else if (key.compareTo("math_difficulty") == 0) {
            googleAnalyticAction = C0824l.MathLevel;
        } else if (key.compareTo("snooze_method") == 0) {
            googleAnalyticAction = C0824l.Snooze;
        } else if (key.compareTo("snooze_duration") == 0) {
            googleAnalyticAction = C0824l.SnoozeDuration;
        } else if (key.compareTo("snooze_decrease_duration") == 0) {
            googleAnalyticAction = C0824l.SnoozeDecreaseDuration;
        } else if (key.compareTo("max_snoozes") == 0) {
            googleAnalyticAction = C0824l.SnoozeMax;
        } else if (key.compareTo("auto_snooze") == 0) {
            googleAnalyticAction = C0824l.AutoSnooze;
        }
        if (googleAnalyticAction != null) {
            C0830k.m3897a(this, googleAnalyticAction, m2696z());
        }
        return super.onPreferenceTreeClick(preferenceScreen, preference);
    }

    private void m2662f() {
        switch (this.f1562F) {
            case Base64.DEFAULT /*0*/:
                this.f1565I = 2;
                addPreferencesFromResource(R.xml.redesign_alarm_default_prefs);
                C0830k.m3896a((Context) this, C0824l.DefaultAlarmSettingScreen);
            case Base64.NO_PADDING /*1*/:
                this.f1565I = 0;
                addPreferencesFromResource(R.xml.redesign_alarm_basic_prefs);
                C0830k.m3896a((Context) this, C0824l.BaseAlarmSettingScreen);
                C0794b.m3779a((Activity) this, (int) R.string.ads_category_set_alarm, true);
                C0794b.m3780a(this, "set_basic_alarm");
            case Base64.NO_WRAP /*2*/:
                addPreferencesFromResource(R.xml.redesign_alarm_adavanced_prefs);
                C0830k.m3896a((Context) this, C0824l.AdvancedAlarmSettingScreen);
                C0794b.m3779a((Activity) this, (int) R.string.ads_category_set_alarm, true);
                C0794b.m3780a(this, "set_advanced_alarm");
            case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                this.f1565I = 1;
                addPreferencesFromResource(R.xml.redesign_timer_prefs);
                C0830k.m3896a((Context) this, C0824l.TimerSettingScreen);
            default:
        }
    }

    private void m2667h() {
        m2671i();
        if (this.f1562F == 1) {
            findViewById(R.id.fake_action_bar_layout).setVisibility(8);
            m2672j();
        }
        if (!(this.f1562F == 1 || this.f1562F == 0)) {
            m2632a(this.f1560D, false);
            findViewById(R.id.save_cancel_control_bar).setVisibility(8);
        }
        if (this.f1562F != 3) {
            m2632a(this.f1594t, false);
        }
        if (this.f1562F == 3) {
            m2632a(m2623a("basic_settings_category"), false);
        }
    }

    private void m2671i() {
        boolean shouldShowTimeEditControlls;
        boolean z = true;
        boolean isLandscape;
        if (findViewById(R.id.time_display_container) != null) {
            isLandscape = true;
        } else {
            isLandscape = false;
        }
        if (this.f1562F == 1 || this.f1562F == 0) {
            shouldShowTimeEditControlls = true;
        } else {
            shouldShowTimeEditControlls = false;
        }
        Preference findPreference = findPreference("alarm_set_time");
        if (!shouldShowTimeEditControlls || isLandscape) {
            z = false;
        }
        m2632a(findPreference, z);
        if (shouldShowTimeEditControlls && isLandscape) {
            findViewById(R.id.time_display_container).setVisibility(0);
        }
        if (shouldShowTimeEditControlls) {
            this.f1566J = this.f1572P.f2009j;
            this.f1567K = this.f1572P.f2023x;
            this.f1574R = new C0592a().m2749a(this, this);
            this.f1574R.m2387a(this.f1572P.f2005f);
            this.f1574R.m2386a(this.f1572P.f2009j, this.f1572P.f2023x);
        }
    }

    private void m2672j() {
        findViewById(R.id.save).setOnClickListener(new C05681(this));
        findViewById(R.id.cancel).setOnClickListener(new C05692(this));
    }

    private void m2675k() {
        if (this.f1599y != null) {
            this.f1599y.m2414a(this.f1572P.f1996I);
            this.f1599y.setOnPreferenceClickListener(this.f1575S);
        }
        if (this.f1598x != null) {
            this.f1598x.m2429a(this.f1572P.f1995H);
            this.f1598x.setOnPreferenceClickListener(this.f1575S);
        }
        if (this.f1600z != null) {
            this.f1600z.m2397a((Context) this, this.f1572P.f2002c);
            this.f1600z.setOnPreferenceClickListener(this.f1575S);
        }
        if (this.f1557A != null) {
            this.f1557A.m2418a((Context) this, this.f1572P.f1988A);
            this.f1557A.setOnPreferenceClickListener(this.f1575S);
        }
        if (this.f1558B != null) {
            this.f1558B.m2395a(this, this.f1572P.f2001b);
            this.f1558B.setOnPreferenceClickListener(this.f1575S);
        }
        if (this.f1559C != null) {
            this.f1559C.setOnPreferenceClickListener(this.f1575S);
        }
        if (this.f1560D != null) {
            this.f1560D.setOnPreferenceClickListener(this.f1575S);
        }
        if (this.f1597w != null) {
            m2655b(this.f1572P.f2020u);
            this.f1597w.setOnPreferenceChangeListener(new C05703(this));
        }
    }

    private void m2655b(String label) {
        if (TextUtils.isEmpty(label)) {
            this.f1597w.setSummary(getString(R.string.empty_alarm_name_default_summary));
            this.f1597w.getEditText().setHint(R.string.empty_alarm_name_hint);
            return;
        }
        this.f1597w.setSummary(this.f1572P.f2020u);
        this.f1597w.setText(this.f1572P.f2020u);
    }

    private void m2677l() {
        if (this.f1574R != null) {
            Calendar calendar = this.f1574R.m2385a();
            this.f1572P.f2009j = calendar.get(11);
            this.f1572P.f2023x = calendar.get(12);
        }
    }

    protected void onPause() {
        C0794b.m3787d(this);
        try {
            if (this.f1573Q != null && this.f1573Q.isShowing()) {
                this.f1570N = true;
                this.f1573Q.dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onPause();
    }

    protected void onResume() {
        super.onResume();
        C0794b.m3786c(this);
    }

    protected void onDestroy() {
        C0794b.m3788e(this);
        super.onDestroy();
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        m2677l();
        try {
            outState.putBoolean("add_if_saved", this.f1563G);
            outState.putInt("alarm_type", this.f1565I);
            outState.putParcelable("extra_alarm", this.f1572P);
            outState.putInt("extra_mode", this.f1562F);
            outState.putInt("id", this.f1564H);
            outState.putInt("hour", this.f1566J);
            outState.putInt("minute", this.f1567K);
            outState.putInt("pending_index", this.f1568L);
            if (this.f1573Q != null && this.f1570N) {
                outState.putBoolean("displaying_alert_dialog", true);
                outState.putBoolean("displaying_beta_dialog", this.f1571O);
                outState.putBoolean("user_editing_dismiss_alert", this.f1569M);
            }
        } catch (Exception e) {
        }
    }

    private void m2679m() {
        if (this.f1578d != null) {
            boolean shake = getPackageManager().hasSystemFeature("android.hardware.sensor.accelerometer");
            CharSequence[] dismissEntries = new CharSequence[C0574a.values().length];
            CharSequence[] dismissValues = new CharSequence[C0574a.values().length];
            int index = 0;
            Context context = getApplicationContext();
            for (C0574a dismissOptions : C0574a.values()) {
                if (shake || !dismissOptions.f1542g.equals(C0574a.SHAKE_DEVICE.f1542g)) {
                    dismissEntries[index] = dismissOptions.m2620a(context);
                    dismissValues[index] = dismissOptions.f1542g;
                    index++;
                }
            }
            this.f1578d.setEntries(dismissEntries);
            this.f1578d.setEntryValues(dismissValues);
        }
    }

    private void m2681n() {
        boolean shake = getPackageManager().hasSystemFeature("android.hardware.sensor.accelerometer");
        if (this.f1579e != null) {
            CharSequence[] snoozeEntries = new CharSequence[C0575b.values().length];
            CharSequence[] snoozeValues = new CharSequence[C0575b.values().length];
            int index = 0;
            Context context = getApplicationContext();
            for (C0575b snoozeOptions : C0575b.values()) {
                if (shake || !snoozeOptions.f1549f.equals(C0575b.SHAKE_DEVICE.f1549f)) {
                    snoozeEntries[index] = snoozeOptions.m2622a(context);
                    snoozeValues[index] = snoozeOptions.f1549f;
                    index++;
                }
            }
            this.f1579e.setEntries(snoozeEntries);
            this.f1579e.setEntryValues(snoozeValues);
        }
    }

    private void m2684p() {
        m2631a(this.f1577b, this.f1572P.f1993F, false);
        m2631a(this.f1579e, this.f1572P.f1992E, false);
        m2631a(this.f1580f, this.f1572P.f2004e, false);
        m2631a(this.f1578d, this.f1572P.f2007h, false);
        m2631a(this.f1581g, this.f1572P.f2003d, false);
        m2630a(this.f1582h, this.f1572P.f1998K);
        m2630a(this.f1583i, this.f1572P.f2021v);
        m2658d(this.f1572P.f1992E);
        m2663f(this.f1572P.f1993F);
    }

    private void m2685q() {
        String string;
        SeekBarPreference seekBarPreference = this.f1586l;
        if (this.f1572P.f2022w == 0) {
            string = getString(R.string.unlimited);
        } else {
            string = getString(R.string.max_snoozes_summary, new Object[]{Integer.valueOf(this.f1572P.f2022w)});
        }
        m2634a(seekBarPreference, string, this.f1572P.f2022w);
        if (this.f1586l != null) {
            this.f1586l.m2426a(true);
        }
        if (this.f1584j != null) {
            this.f1584j.m2425a(0);
        }
        m2634a(this.f1585k, getString(R.string.minutes, new Object[]{Integer.valueOf(this.f1572P.f1991D)}), this.f1572P.f1991D);
        m2634a(this.f1584j, getString(R.string.decrease_snooze_duration_by_summary, new Object[]{Integer.valueOf(this.f1572P.f2006g)}), this.f1572P.f2006g);
        seekBarPreference = this.f1588n;
        if (this.f1572P.f2024y == 1) {
            string = getString(R.string.problem);
        } else {
            string = getString(R.string.problems, new Object[]{Integer.valueOf(this.f1572P.f2024y)});
        }
        m2634a(seekBarPreference, string, this.f1572P.f2024y);
        seekBarPreference = this.f1587m;
        if (this.f1572P.f2025z == 1) {
            string = getString(R.string.problem);
        } else {
            string = getString(R.string.problems, new Object[]{Integer.valueOf(this.f1572P.f2025z)});
        }
        m2634a(seekBarPreference, string, this.f1572P.f2025z);
        if (this.f1589o != null) {
            this.f1589o.setSummary(this.f1572P.f1997J + "%");
            this.f1589o.m2431a(this.f1572P.f1997J);
            this.f1589o.setOnPreferenceChangeListener(this.c);
        }
    }

    private void m2688r() {
        m2628a(this.f1591q, this.f1572P.f2017r);
        m2628a(this.f1592r, this.f1572P.f2018s);
        m2628a(this.f1593s, this.f1572P.f2016q);
        m2628a(this.f1590p, this.f1572P.f2015p);
        m2628a(this.f1595u, this.f1572P.f1999L);
        if (this.f1562F == 3) {
            m2628a(this.f1594t, this.f1572P.f2019t);
        }
    }

    @SuppressLint({"NewApi"})
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case Base64.DEFAULT /*0*/:
                if (resultCode == -1 && data != null) {
                    this.f1599y.m2415a(data.getData(), data.getStringExtra("item_display_text"));
                    this.f1572P.f1996I = Uri.parse(this.f1599y.m2413a());
                    m2644a(2);
                    break;
                }
            case Base64.NO_PADDING /*1*/:
                if (resultCode == -1 && data != null && data.hasExtra("artist_id")) {
                    this.f1600z.m2398a(data.getStringExtra("artist_id"), data.getStringExtra("item_display_text"));
                    this.f1572P.f2002c = this.f1600z.m2396a();
                    m2644a(4);
                    break;
                }
            case Base64.NO_WRAP /*2*/:
                if (resultCode == -1 && data != null && data.hasExtra("item_display_text") && data.hasExtra("playlist_key")) {
                    this.f1557A.m2419a(data.getStringExtra("item_display_text"), data.getStringExtra("playlist_key"));
                    this.f1557A.setSummary(data.getStringExtra("item_display_text"));
                    this.f1572P.f1988A = this.f1557A.m2417a();
                    m2644a(5);
                    break;
                }
            case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                if (!(resultCode != -1 || data == null || data.getData() == null)) {
                    this.f1572P.f1995H = data.getData();
                    this.f1598x.m2430a(this.f1572P.f1995H, data.getStringExtra("item_display_text"));
                    m2644a(1);
                    break;
                }
            case Base64.CRLF /*4*/:
                if (resultCode == -1 && data != null && data.hasExtra("extra_selected_application")) {
                    String appName = data.getStringExtra("extra_selected_application");
                    if (!TextUtils.isEmpty(appName)) {
                        this.f1558B.m2395a(this, appName);
                        this.f1572P.f2001b = appName;
                        m2644a(6);
                        break;
                    }
                }
                break;
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                if (resultCode == -1 && data != null && data.hasExtra("extra_alarm")) {
                    this.f1572P = (RedesignAlarm) data.getParcelableExtra("extra_alarm");
                    this.f1574R.m2387a(this.f1572P.f2005f);
                    break;
                }
        }
        if (resultCode == 0) {
            this.f1577b.setValue(String.valueOf(this.f1572P.f1993F));
            this.f1568L = -1;
        }
    }

    private void m2644a(int selectedSoundType) {
        m2663f(selectedSoundType);
        this.f1572P.f1993F = selectedSoundType;
        if (this.f1568L >= 0) {
            this.f1577b.setValue(String.valueOf(selectedSoundType));
            this.f1577b.setSummary(this.f1577b.getEntries()[this.f1568L]);
            this.f1568L = -1;
        }
    }

    private boolean m2650a(boolean isSettingDismiss, int selectedOptionIndex) {
        boolean isShakeAlreadyTaken;
        boolean isSideButtonAlreadyTaken;
        if (isSettingDismiss) {
            if (this.f1572P.f1992E == 3 && selectedOptionIndex == 7) {
                isShakeAlreadyTaken = true;
            } else {
                isShakeAlreadyTaken = false;
            }
            if (this.f1572P.f1992E == 2 && selectedOptionIndex == 9) {
                isSideButtonAlreadyTaken = true;
            } else {
                isSideButtonAlreadyTaken = false;
            }
        } else {
            if (this.f1572P.f2007h == 7 && selectedOptionIndex == 3) {
                isShakeAlreadyTaken = true;
            } else {
                isShakeAlreadyTaken = false;
            }
            if (this.f1572P.f2007h == 9 && selectedOptionIndex == 2) {
                isSideButtonAlreadyTaken = true;
            } else {
                isSideButtonAlreadyTaken = false;
            }
        }
        if (!isShakeAlreadyTaken && !isSideButtonAlreadyTaken) {
            return true;
        }
        this.f1573Q = m2651b(isSettingDismiss);
        this.f1573Q.show();
        return false;
    }

    private void m2653b(int value) {
        if (m2650a(false, value)) {
            this.f1572P.f1992E = value;
            this.f1579e.setValue(String.valueOf(value));
            this.f1579e.setSummary(this.f1579e.getEntry());
            if (value == C0575b.MATH.m2621a()) {
                this.f1572P.f2021v = Integer.valueOf(this.f1583i.getValue()).intValue();
                this.f1572P.f2024y = this.f1588n.m2424a();
                this.f1572P.f2025z = this.f1587m.m2424a();
            }
            m2689s();
        }
    }

    private void m2657c(int value) {
        if (m2650a(true, value)) {
            this.f1572P.f2007h = value;
            this.f1578d.setValue(String.valueOf(value));
            this.f1578d.setSummary(this.f1578d.getEntry());
            if (value == C0574a.MATH.m2619a()) {
                this.f1572P.f2021v = Integer.valueOf(this.f1583i.getValue()).intValue();
                this.f1572P.f2024y = this.f1588n.m2424a();
                this.f1572P.f2025z = this.f1587m.m2424a();
            }
            m2689s();
        }
    }

    private void m2646a(Preference prefToShow) {
        boolean z;
        boolean z2 = true;
        if (this.f1598x != null) {
            m2632a(this.f1598x, this.f1598x == prefToShow);
        }
        if (this.f1600z != null) {
            Preference preference = this.f1600z;
            if (this.f1600z == prefToShow) {
                z = true;
            } else {
                z = false;
            }
            m2632a(preference, z);
        }
        if (this.f1557A != null) {
            preference = this.f1557A;
            if (this.f1557A == prefToShow) {
                z = true;
            } else {
                z = false;
            }
            m2632a(preference, z);
        }
        if (this.f1558B != null) {
            preference = this.f1558B;
            if (this.f1558B == prefToShow) {
                z = true;
            } else {
                z = false;
            }
            m2632a(preference, z);
        }
        if (this.f1599y != null) {
            Preference preference2 = this.f1599y;
            if (this.f1599y != prefToShow) {
                z2 = false;
            }
            m2632a(preference2, z2);
        }
    }

    private void m2658d(int snoozeType) {
        switch (snoozeType) {
            case Base64.CRLF /*4*/:
                m2649a(false);
            default:
                m2632a(this.f1585k, true);
                m2632a(this.f1584j, true);
        }
    }

    private void m2661e(int soundType) {
        switch (soundType) {
            case Base64.NO_PADDING /*1*/:
                C0830k.m3896a((Context) this, C0824l.SoundTypeDialogRingtone);
                m2692v();
            case Base64.NO_WRAP /*2*/:
                C0830k.m3896a((Context) this, C0824l.SoundTypeDialogMusic);
                m2693w();
            case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                C0830k.m3896a((Context) this, C0824l.SoundTypeDialogSilent);
                m2644a(3);
            case Base64.CRLF /*4*/:
                C0830k.m3896a((Context) this, C0824l.SoundTypeDialogArtist);
                m2694x();
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                C0830k.m3896a((Context) this, C0824l.SoundTypeDialogPlaylist);
                m2695y();
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                C0830k.m3896a((Context) this, C0824l.SoundTypeDialogLaunchApp);
                m2690t();
            default:
        }
    }

    private void m2663f(int newValue) {
        switch (newValue) {
            case Base64.NO_PADDING /*1*/:
                m2646a(this.f1598x);
            case Base64.NO_WRAP /*2*/:
                m2646a(this.f1599y);
            case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                m2646a(null);
            case Base64.CRLF /*4*/:
                m2646a(this.f1600z);
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                m2646a(this.f1557A);
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                m2646a(this.f1558B);
            default:
        }
    }

    private void m2649a(boolean show) {
        m2632a(this.f1579e, show);
        m2632a(this.f1585k, show);
        m2632a(this.f1585k, show);
        m2632a(this.f1586l, show);
    }

    private void m2689s() {
        boolean isSnoozeMath;
        boolean isDismissMath;
        if (this.f1572P.f1992E == 6) {
            isSnoozeMath = true;
        } else {
            isSnoozeMath = false;
        }
        if (this.f1572P.f2007h == 5) {
            isDismissMath = true;
        } else {
            isDismissMath = false;
        }
        boolean show = isSnoozeMath | isDismissMath;
        m2632a(this.f1596v, show);
        m2632a(this.f1583i, show);
        m2632a(this.f1595u, show);
        m2632a(this.f1588n, isDismissMath);
        m2632a(this.f1587m, isSnoozeMath);
    }

    private AlertDialog m2651b(boolean isUserEditingDismissMethod) {
        this.f1569M = isUserEditingDismissMethod;
        this.f1571O = false;
        Builder builder = new Builder(this);
        SpannableString spannedString = new SpannableString(getString(R.string.option_already_used_title));
        spannedString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.bright_blue)), 0, spannedString.length(), 0);
        Builder icon = builder.setTitle(spannedString).setIcon(R.drawable.ic_stat_notify_error);
        Object[] objArr = new Object[1];
        objArr[0] = getString(isUserEditingDismissMethod ? R.string.snooze : R.string.dismiss).toLowerCase(Locale.getDefault());
        icon.setMessage(getString(R.string.option_already_used_message, objArr)).setPositiveButton(R.string.ok, new C05725(this));
        return builder.create();
    }

    private void m2690t() {
        Builder builder = new Builder(this);
        SpannableString spannedString = new SpannableString(getString(R.string.warning));
        spannedString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.bright_blue)), 0, spannedString.length(), 0);
        builder.setTitle(spannedString).setIcon(R.drawable.ic_stat_notify_error).setMessage(getString(R.string.launch_app_message)).setPositiveButton(R.string.ok, new C05736(this));
        this.f1573Q = builder.create();
        this.f1573Q.show();
        this.f1571O = true;
    }

    private void m2691u() {
        startActivityForResult(C0832m.m3929e((Context) this, getPreferenceScreen().findPreference("set_application") != null ? this.f1558B.getSummary() : ""), 4);
    }

    private void m2692v() {
        startActivityForResult(C0832m.m3926d((Context) this, getPreferenceScreen().findPreference("set_ringtone") != null ? this.f1598x.m2428a() : ""), 3);
    }

    private void m2693w() {
        startActivityForResult(C0832m.m3923c((Context) this, getPreferenceScreen().findPreference("set_music") != null ? this.f1599y.m2416b() : ""), 0);
    }

    private void m2694x() {
        startActivityForResult(C0832m.m3912a((Context) this, getPreferenceScreen().findPreference("set_artist") != null ? this.f1600z.getSummary() : ""), 1);
    }

    private void m2695y() {
        startActivityForResult(C0832m.m3920b((Context) this, getPreferenceScreen().findPreference("set_playlist") != null ? this.f1557A.getSummary() : ""), 2);
    }

    protected void m2697a() {
        this.f1572P.f2000a = this.f1565I;
        switch (this.f1562F) {
            case Base64.DEFAULT /*0*/:
                m2677l();
                this.f1572P.f2005f = this.f1574R.m2388b();
                C0694b.m3141a((Context) this, getContentResolver(), this.f1572P, this.f1564H);
                break;
            case Base64.NO_PADDING /*1*/:
                m2677l();
                this.f1572P.f2012m = true;
                this.f1572P.f2005f = this.f1574R.m2388b();
                if (this.f1563G) {
                    this.f1572P.f2010k = C0694b.m3128a(getContentResolver());
                }
                if (!this.f1572P.f2005f.m3661c() && this.f1572P.f1990C) {
                    this.f1572P.f1990C = false;
                }
                C0694b.m3153c(this, this.f1572P);
                startActivity(C0832m.m3931f(this, this.f1572P));
                if (this.f1565I == 0 && this.f1572P.f2012m && ac.m3773a(this.f1561E, this.f1572P)) {
                    C0870z.m4065a((Context) this, this.f1572P);
                    break;
                }
            case Base64.NO_WRAP /*2*/:
                Intent resultIntent = new Intent();
                resultIntent.putExtra("extra_alarm", this.f1572P);
                setResult(-1, resultIntent);
                break;
            case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                C0694b.m3150b((Context) this, this.f1572P);
                break;
        }
        m2705e();
    }

    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        this.f1572P.f2009j = hourOfDay;
        this.f1566J = hourOfDay;
        this.f1572P.f2023x = minute;
        this.f1567K = minute;
        this.f1574R.m2386a(hourOfDay, minute);
        m2647a(getListAdapter());
        C0830k.m3897a(this, C0824l.SetTime, m2696z());
    }

    private void m2647a(ListAdapter adapter) {
        if (adapter != null) {
            if (adapter instanceof BaseAdapter) {
                ((BaseAdapter) adapter).notifyDataSetChanged();
            } else if (adapter instanceof HeaderViewListAdapter) {
                ListAdapter wrappedAdapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
                if (wrappedAdapter instanceof BaseAdapter) {
                    ((BaseAdapter) wrappedAdapter).notifyDataSetChanged();
                } else {
                    C0850q.m3986a("adapter is HeaderViewListAdapter but not instanceof HeaderViewListAdapter ");
                }
            } else {
                C0850q.m3986a("adapter is of unhandled instance: " + adapter.getClass().getSimpleName());
            }
        }
    }

    public void m2698a(int index, Object newValue, String key) {
        int value = Integer.valueOf((String) newValue).intValue();
        Object obj = -1;
        switch (key.hashCode()) {
            case -1244874122:
                if (key.equals("auto_snooze")) {
                    obj = 2;
                    break;
                }
                break;
            case -1192619694:
                if (key.equals("math_difficulty")) {
                    obj = 6;
                    break;
                }
                break;
            case -1171789556:
                if (key.equals("volume_increase_duration")) {
                    obj = 4;
                    break;
                }
                break;
            case -1060631498:
                if (key.equals("dismiss_method")) {
                    obj = 5;
                    break;
                }
                break;
            case -503572486:
                if (key.equals("auto_dismiss")) {
                    obj = 3;
                    break;
                }
                break;
            case -342437782:
                if (key.equals("sound_type")) {
                    obj = null;
                    break;
                }
                break;
            case -203689638:
                if (key.equals("snooze_method")) {
                    obj = 1;
                    break;
                }
                break;
        }
        switch (obj) {
            case Base64.DEFAULT /*0*/:
                this.f1568L = index;
                m2661e(value);
            case Base64.NO_PADDING /*1*/:
                m2653b(value);
            case Base64.NO_WRAP /*2*/:
                m2666g(value);
            case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                m2668h(value);
            case Base64.CRLF /*4*/:
                this.f1572P.f1998K = value;
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                m2657c(value);
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                this.f1572P.f2021v = Integer.valueOf((String) newValue).intValue();
            default:
        }
    }

    private void m2666g(int value) {
        if (value != this.f1572P.f2004e) {
            this.f1572P.f2004e = value;
            this.f1580f.setValue(String.valueOf(value));
            this.f1580f.setSummary(this.f1580f.getEntry());
        }
    }

    private void m2668h(int value) {
        if (value != this.f1572P.f2003d) {
            this.f1572P.f2003d = value;
            this.f1581g.setValue(String.valueOf(value));
            this.f1581g.setSummary(this.f1581g.getEntry());
        }
    }

    public void m2700a(Object newValue, String key) {
    }

    public void m2699a(int progress, String key) {
        int i = -1;
        switch (key.hashCode()) {
            case -2025203854:
                if (key.equals("max_snoozes")) {
                    i = 0;
                    break;
                }
                break;
            case -1901781180:
                if (key.equals("math_snooze_num")) {
                    i = 3;
                    break;
                }
                break;
            case -567979622:
                if (key.equals("math_dismiss_num")) {
                    i = 4;
                    break;
                }
                break;
            case -49062712:
                if (key.equals("alarm_volume")) {
                    i = 5;
                    break;
                }
                break;
            case 95605244:
                if (key.equals("snooze_decrease_duration")) {
                    i = 2;
                    break;
                }
                break;
            case 273953741:
                if (key.equals("snooze_duration")) {
                    i = 1;
                    break;
                }
                break;
        }
        SeekBarPreference seekBarPreference;
        CharSequence string;
        switch (i) {
            case Base64.DEFAULT /*0*/:
                this.f1572P.f2022w = progress;
                seekBarPreference = this.f1586l;
                if (progress == 0) {
                    string = getString(R.string.unlimited);
                } else {
                    string = getString(R.string.max_snoozes_summary, new Object[]{Integer.valueOf(progress)});
                }
                seekBarPreference.setSummary(string);
            case Base64.NO_PADDING /*1*/:
                this.f1572P.f1991D = progress;
                this.f1585k.setSummary(getString(R.string.minutes, new Object[]{Integer.valueOf(progress)}));
            case Base64.NO_WRAP /*2*/:
                this.f1572P.f2006g = progress;
                this.f1584j.setSummary(getString(R.string.decrease_snooze_duration_by_summary, new Object[]{Integer.valueOf(progress)}));
            case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                this.f1572P.f2025z = progress;
                seekBarPreference = this.f1587m;
                if (this.f1572P.f2025z == 1) {
                    string = getString(R.string.problem);
                } else {
                    string = getString(R.string.problems, new Object[]{Integer.valueOf(this.f1572P.f2025z)});
                }
                seekBarPreference.setSummary(string);
            case Base64.CRLF /*4*/:
                this.f1572P.f2024y = progress;
                seekBarPreference = this.f1588n;
                if (this.f1572P.f2024y == 1) {
                    string = getString(R.string.problem);
                } else {
                    string = getString(R.string.problems, new Object[]{Integer.valueOf(this.f1572P.f2024y)});
                }
                seekBarPreference.setSummary(string);
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                this.f1572P.f1997J = progress;
                this.f1589o.setSummary(progress + "%");
            default:
        }
    }

    public void m2701a(boolean isChecked, String key) {
        Object obj = -1;
        switch (key.hashCode()) {
            case -1953944930:
                if (key.equals("use_volume_cresendo")) {
                    obj = 1;
                    break;
                }
                break;
            case 119868745:
                if (key.equals("allow_passing_questions")) {
                    obj = 5;
                    break;
                }
                break;
            case 324276647:
                if (key.equals("large_snooze_button")) {
                    obj = 3;
                    break;
                }
                break;
            case 451310959:
                if (key.equals("vibrate")) {
                    obj = null;
                    break;
                }
                break;
            case 1564413528:
                if (key.equals("keep_screen_on")) {
                    obj = 4;
                    break;
                }
                break;
            case 1907789537:
                if (key.equals("alarm_in_silent_mode")) {
                    obj = 2;
                    break;
                }
                break;
        }
        switch (obj) {
            case Base64.DEFAULT /*0*/:
                this.f1572P.f2017r = isChecked;
                C0830k.m3897a(this, isChecked ? C0824l.VibrateOn : C0824l.VibrateOff, m2696z());
            case Base64.NO_PADDING /*1*/:
                this.f1572P.f2018s = isChecked;
                C0830k.m3897a(this, isChecked ? C0824l.VolumeCrescendoOn : C0824l.VolumeCrescendoOff, m2696z());
            case Base64.NO_WRAP /*2*/:
                this.f1572P.f2016q = isChecked;
                C0830k.m3897a(this, isChecked ? C0824l.SilentModeOn : C0824l.SilentModeOff, m2696z());
            case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                this.f1572P.f2015p = isChecked;
                C0830k.m3897a(this, isChecked ? C0824l.SnoozeButtonSizeOn : C0824l.SnoozeButtonSizeOff, m2696z());
            case Base64.CRLF /*4*/:
                this.f1572P.f2019t = isChecked;
                this.f1561E.edit().putBoolean("keep_screen_on", isChecked).apply();
                C0830k.m3896a((Context) this, isChecked ? C0824l.KeepScreenOn : C0824l.KeepScreenOff);
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                this.f1572P.f1999L = isChecked;
                C0830k.m3897a(this, isChecked ? C0824l.PassingQuestionOn : C0824l.PassingQuestionOff, m2696z());
            default:
        }
    }

    private C0827o m2696z() {
        if (2 == this.f1562F) {
            return C0827o.AlarmAdvanced;
        }
        if (1 == this.f1562F) {
            return C0827o.BaseAlarmSettings;
        }
        if (this.f1562F == 0) {
            return C0827o.DefaultAlarmSettings;
        }
        return C0827o.TimerEdit;
    }

    public boolean m2702b() {
        return this.f1562F == 1;
    }

    public boolean m2703c() {
        return (this.f1562F == 3 || this.f1562F == 0) ? false : true;
    }

    public CharSequence m2704d() {
        if (this.f1562F == 3) {
            return getString(R.string.settings_timer);
        }
        if (this.f1562F == 0) {
            return getString(R.string.settings_alarm);
        }
        if (this.f1562F != 2) {
            return "";
        }
        StringBuilder title = new StringBuilder();
        String alarmName = this.f1572P.m3623i(this);
        title.append(getString(R.string.settings_alarm_advanced)).append("\n").append(alarmName);
        CharSequence alarmTitle = new SpannableString(title);
        int start = title.indexOf(alarmName);
        int end = start + alarmName.length();
        if (start <= 0 || end <= start) {
            return title.toString();
        }
        title.setLength(0);
        alarmTitle.setSpan(new AbsoluteSizeSpan(ab.m3759a(12, getResources())), start, end, 18);
        return alarmTitle;
    }

    protected void m2705e() {
        if (this.f1562F == 1) {
            startActivity(C0832m.m3927e(this));
            C0832m.m3935j(this);
        } else if (this.f1562F == 3 || this.f1562F == 0) {
            startActivity(C0832m.m3936k(this));
        }
        finish();
    }
}
