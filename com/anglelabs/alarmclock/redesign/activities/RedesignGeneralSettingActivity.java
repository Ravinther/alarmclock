package com.anglelabs.alarmclock.redesign.activities;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceManager;
import android.text.SpannableString;
import android.text.format.DateFormat;
import android.text.style.ForegroundColorSpan;
import com.alarmclock.xtreme.free.R;
import com.anglelabs.alarmclock.preference.MultiSelectListPreference;
import com.anglelabs.alarmclock.redesign.alarm.C0645c;
import com.anglelabs.alarmclock.redesign.p021b.p025a.C0576b;
import com.anglelabs.alarmclock.redesign.p024c.C0676a;
import com.anglelabs.alarmclock.redesign.p039d.C0694b;
import com.anglelabs.alarmclock.redesign.stopwatch.StopwatchNotifications;
import com.anglelabs.alarmclock.redesign.timer.C0784b;
import com.anglelabs.alarmclock.redesign.utils.C0810h;
import com.anglelabs.alarmclock.redesign.utils.C0830k;
import com.anglelabs.alarmclock.redesign.utils.C0830k.C0825m;
import com.anglelabs.alarmclock.redesign.utils.C0832m;
import com.anglelabs.alarmclock.redesign.utils.C0850q;
import com.anglelabs.alarmclock.redesign.utils.C0860w;
import com.anglelabs.alarmclock.redesign.utils.ac;
import com.mopub.mobileads.util.Base64;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class RedesignGeneralSettingActivity extends C0576b {
    SharedPreferences f1629a;
    CheckBoxPreference f1630b;
    private boolean f1631d;

    /* renamed from: com.anglelabs.alarmclock.redesign.activities.RedesignGeneralSettingActivity.1 */
    class C05841 implements OnPreferenceClickListener {
        final /* synthetic */ RedesignGeneralSettingActivity f1624a;

        C05841(RedesignGeneralSettingActivity redesignGeneralSettingActivity) {
            this.f1624a = redesignGeneralSettingActivity;
        }

        public boolean onPreferenceClick(Preference preference) {
            this.f1624a.startActivity(C0832m.m3938m(this.f1624a));
            C0830k.m3896a(this.f1624a, C0825m.GeneralSettingsBg);
            return true;
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.activities.RedesignGeneralSettingActivity.2 */
    class C05852 implements OnPreferenceClickListener {
        final /* synthetic */ RedesignGeneralSettingActivity f1625a;

        C05852(RedesignGeneralSettingActivity redesignGeneralSettingActivity) {
            this.f1625a = redesignGeneralSettingActivity;
        }

        public boolean onPreferenceClick(Preference preference) {
            C0830k.m3896a(this.f1625a, C0825m.GeneralSettingsShowNotifDialog);
            return true;
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.activities.RedesignGeneralSettingActivity.3 */
    class C05863 implements OnPreferenceClickListener {
        final /* synthetic */ RedesignGeneralSettingActivity f1626a;

        C05863(RedesignGeneralSettingActivity redesignGeneralSettingActivity) {
            this.f1626a = redesignGeneralSettingActivity;
        }

        public boolean onPreferenceClick(Preference preference) {
            if (this.f1626a.f1630b.isChecked()) {
                this.f1626a.m2728h();
                this.f1626a.f1630b.setChecked(false);
            } else {
                ac.m3772a(this.f1626a, false);
            }
            return true;
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.activities.RedesignGeneralSettingActivity.4 */
    class C05874 implements OnClickListener {
        final /* synthetic */ RedesignGeneralSettingActivity f1627a;

        C05874(RedesignGeneralSettingActivity redesignGeneralSettingActivity) {
            this.f1627a = redesignGeneralSettingActivity;
        }

        public void onClick(DialogInterface d, int w) {
            this.f1627a.f1631d = false;
            this.f1627a.f1630b.setChecked(false);
            C0830k.m3896a(this.f1627a, C0825m.GeneralSettingsVacationModeOff);
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.activities.RedesignGeneralSettingActivity.5 */
    class C05885 implements OnClickListener {
        final /* synthetic */ RedesignGeneralSettingActivity f1628a;

        C05885(RedesignGeneralSettingActivity redesignGeneralSettingActivity) {
            this.f1628a = redesignGeneralSettingActivity;
        }

        public void onClick(DialogInterface d, int w) {
            this.f1628a.f1631d = false;
            this.f1628a.f1630b.setChecked(true);
            ac.m3772a(this.f1628a, true);
            C0830k.m3896a(this.f1628a, C0825m.GeneralSettingsVacationModeOn);
        }
    }

    public /* synthetic */ CharSequence m2735d() {
        return m2736f();
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        C0830k.m3896a((Context) this, C0825m.GeneralSettingsScreen);
        m2641g();
        this.f1629a = PreferenceManager.getDefaultSharedPreferences(this);
        addPreferencesFromResource(R.xml.redesign_general_prefs);
        CheckBoxPreference isClock24HoursPref = (CheckBoxPreference) m2623a("use_24_hours");
        ListPreference languagePref = (ListPreference) m2623a("language");
        ListPreference firstDayOfWeek = (ListPreference) m2623a("first_day_of_week");
        MultiSelectListPreference showAllNotificationPref = (MultiSelectListPreference) m2623a("show_notification_dialog");
        Preference backgroundPref = m2623a("background");
        CheckBoxPreference unlockDeviceOnAlarmPref = (CheckBoxPreference) m2623a("unlock_phone_on_alarm");
        CheckBoxPreference usePhoneSpeakersPref = (CheckBoxPreference) m2623a("use_phone_speaker");
        this.f1630b = (CheckBoxPreference) m2623a("vacation_mode");
        m2632a((Preference) unlockDeviceOnAlarmPref, !C0810h.m3835a());
        if (!this.f1629a.contains("use_24_hours")) {
            isClock24HoursPref.setChecked(DateFormat.is24HourFormat(getApplicationContext()));
        }
        if (!this.f1629a.contains("first_day_of_week")) {
            firstDayOfWeek.setValueIndex(Calendar.getInstance(Locale.getDefault()).getFirstDayOfWeek());
        }
        m2629a(languagePref);
        m2629a(firstDayOfWeek);
        m2633a(showAllNotificationPref);
        m2627a(isClock24HoursPref);
        m2627a(usePhoneSpeakersPref);
        m2627a(unlockDeviceOnAlarmPref);
        m2723a(showAllNotificationPref, backgroundPref);
        m2722a(savedInstanceState);
    }

    protected void onResume() {
        super.onResume();
        if (this.f1630b == null) {
            return;
        }
        if (C0694b.m3135a((Context) this, this.f1629a).size() == 0) {
            this.f1630b.setSummary(R.string.general_settings_vacation_mode_summary);
            this.f1630b.setSelectable(true);
            return;
        }
        this.f1630b.setSummary(R.string.general_settings_vacation_mode_snoozed_alarm_exist_summary);
        this.f1630b.setSelectable(false);
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (this.f1631d) {
            outState.putBoolean("showing_vacation_alert_dialog", true);
        }
    }

    private void m2722a(Bundle savedInstanceState) {
        if (savedInstanceState != null && savedInstanceState.getBoolean("showing_vacation_alert_dialog", false)) {
            m2728h();
        }
    }

    private void m2723a(MultiSelectListPreference showAllNotificationPref, Preference backgroundPref) {
        backgroundPref.setOnPreferenceClickListener(new C05841(this));
        showAllNotificationPref.setOnPreferenceClickListener(new C05852(this));
        this.f1630b.setOnPreferenceClickListener(new C05863(this));
    }

    private void m2728h() {
        Builder builder = new Builder(this);
        SpannableString spannedString = new SpannableString(getString(R.string.general_settings_vacation_mode_title));
        spannedString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.bright_blue)), 0, spannedString.length(), 0);
        builder.setTitle(spannedString).setIcon(R.drawable.ic_stat_notify_error).setMessage(R.string.general_settings_vacation_mode_dialog_body).setPositiveButton(R.string.ok, new C05885(this)).setNegativeButton(R.string.cancel, new C05874(this)).create().show();
        this.f1631d = true;
    }

    public void m2729a(int index, Object newValue, String key) {
        if (key.equals("language")) {
            C0676a.m3098f(getBaseContext());
            C0830k.m3896a((Context) this, C0825m.GeneralSettingsLang);
            startActivity(C0832m.m3937l(this));
            finish();
        } else if (key.equals("first_day_of_week")) {
            C0676a.m3094b(getBaseContext());
            C0830k.m3896a((Context) this, C0825m.GeneralSettingsFirstDay);
        }
    }

    public void m2731a(Object newValue, String key) {
        if (!key.equals("show_notification_dialog")) {
            return;
        }
        if (newValue == null || !(newValue instanceof ArrayList)) {
            String name;
            StringBuilder append = new StringBuilder().append("handleMultiSelectListPrefChanged error casting newValue: ");
            if (newValue != null) {
                name = newValue.getClass().getName();
            } else {
                name = " is null";
            }
            C0850q.m3987b(append.append(name).toString());
            return;
        }
        ArrayList selectedArray = (ArrayList) newValue;
        String[] notificationOption = getResources().getStringArray(R.array.notification_entries);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        for (int index = 0; index < notificationOption.length; index++) {
            boolean isNotifShownNew = selectedArray.contains(String.valueOf(index));
            if (notificationOption[index].equals(getString(R.string.default_label))) {
                m2727c(prefs, isNotifShownNew);
            } else if (notificationOption[index].equals(getString(R.string.timer))) {
                m2726b(prefs, isNotifShownNew);
            } else if (notificationOption[index].equals(getString(R.string.stopwatch))) {
                m2721a(prefs, isNotifShownNew);
            }
        }
    }

    private void m2721a(SharedPreferences prefs, boolean shouldShowNotification) {
        if (C0860w.m4043e(prefs) != shouldShowNotification) {
            C0860w.m4037b(prefs, shouldShowNotification);
            if (shouldShowNotification) {
                StopwatchNotifications.m3665a(getApplicationContext());
                C0830k.m3896a((Context) this, C0825m.GeneralSettingsShowSWNotifOn);
                return;
            }
            StopwatchNotifications.m3667b(getApplicationContext());
            C0830k.m3896a((Context) this, C0825m.GeneralSettingsShowSWNotifOff);
        }
    }

    private void m2726b(SharedPreferences prefs, boolean shouldShowNotification) {
        if (C0860w.m4044f(prefs) != shouldShowNotification) {
            C0860w.m4040c(prefs, shouldShowNotification);
            if (shouldShowNotification) {
                sendBroadcast(C0832m.m3908a(-1, "com.anglelabs.alarmclock.free.act_timer_notif_settings"));
                C0830k.m3896a((Context) this, C0825m.GeneralSettingsShowTimerNotifOn);
                return;
            }
            C0784b.m3725a((Context) this);
            C0830k.m3896a((Context) this, C0825m.GeneralSettingsShowTimerNotifOff);
        }
    }

    private void m2727c(SharedPreferences prefs, boolean shouldShowNotification) {
        if (C0860w.m4042d(prefs) != shouldShowNotification) {
            C0860w.m4035a(prefs, shouldShowNotification);
            if (shouldShowNotification) {
                C0645c.m2968a(this);
                C0830k.m3896a((Context) this, C0825m.GeneralSettingsShowAlarmNotifOn);
                return;
            }
            C0645c.m2969b(this);
            C0830k.m3896a((Context) this, C0825m.GeneralSettingsShowAlarmNotifOff);
        }
    }

    public void m2730a(int progress, String key) {
    }

    public void m2732a(boolean isChecked, String key) {
        Object obj = -1;
        switch (key.hashCode()) {
            case -187918851:
                if (key.equals("unlock_phone_on_alarm")) {
                    obj = 2;
                    break;
                }
                break;
            case 185980278:
                if (key.equals("use_phone_speaker")) {
                    obj = 1;
                    break;
                }
                break;
            case 2115283594:
                if (key.equals("use_24_hours")) {
                    obj = null;
                    break;
                }
                break;
        }
        switch (obj) {
            case Base64.DEFAULT /*0*/:
                C0676a.m3095c(getBaseContext());
                C0830k.m3896a((Context) this, isChecked ? C0825m.GeneralSettings24hOn : C0825m.GeneralSettings24hOff);
            case Base64.NO_PADDING /*1*/:
                C0830k.m3896a((Context) this, isChecked ? C0825m.GeneralSettingsSpeakerOn : C0825m.GeneralSettingsSpeakerOff);
            case Base64.NO_WRAP /*2*/:
                C0830k.m3896a((Context) this, isChecked ? C0825m.GeneralSettingsUnlockOn : C0825m.GeneralSettingsUnlockOff);
            default:
        }
    }

    public boolean m2733b() {
        return false;
    }

    public boolean m2734c() {
        return false;
    }

    public String m2736f() {
        return getString(R.string.general_settings);
    }
}
