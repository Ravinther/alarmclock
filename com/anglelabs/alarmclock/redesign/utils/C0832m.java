package com.anglelabs.alarmclock.redesign.utils;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.p006a.C0022i;
import android.text.TextUtils;
import com.alarmclock.xtreme.free.AlarmClock;
import com.alarmclock.xtreme.free.R;
import com.anglelabs.alarmclock.redesign.activities.NewMainActivity;
import com.anglelabs.alarmclock.redesign.activities.RedesignAlarmAlertActivity;
import com.anglelabs.alarmclock.redesign.activities.RedesignAlarmSettingsActivity;
import com.anglelabs.alarmclock.redesign.activities.RedesignChooseBackgroundActivity;
import com.anglelabs.alarmclock.redesign.activities.RedesignGeneralSettingActivity;
import com.anglelabs.alarmclock.redesign.activities.RedesignMainSettingsActivity;
import com.anglelabs.alarmclock.redesign.activities.RedesignSetSoundTypeActivity;
import com.anglelabs.alarmclock.redesign.activities.RedesignStopwatchPreferenceActivity;
import com.anglelabs.alarmclock.redesign.model.RedesignAlarm;
import com.anglelabs.alarmclock.redesign.model.Stopwatch;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.drive.DriveFile;
import java.text.DateFormat;
import java.util.Date;

/* renamed from: com.anglelabs.alarmclock.redesign.utils.m */
public class C0832m {
    private static Intent m3914a(Context context, Class clazz) {
        Intent intent = new Intent(context, clazz);
        if (!(context instanceof Activity)) {
            intent.addFlags(DriveFile.MODE_READ_ONLY);
        }
        return intent;
    }

    public static Intent m3909a(Context context) {
        Intent intent = C0832m.m3914a(context, RedesignAlarmSettingsActivity.class);
        intent.putExtra("extra_mode", 1);
        return intent;
    }

    public static Intent m3917b(Context context) {
        Intent intent = C0832m.m3914a(context, RedesignAlarmSettingsActivity.class);
        intent.putExtra("extra_mode", 0);
        return intent;
    }

    public static Intent m3911a(Context context, RedesignAlarm alarm) {
        Intent intent = C0832m.m3914a(context, RedesignAlarmSettingsActivity.class);
        intent.putExtra("extra_mode", 1);
        intent.putExtra("extra_alarm", alarm);
        return intent;
    }

    public static Intent m3919b(Context context, RedesignAlarm alarm) {
        Intent intent = C0832m.m3914a(context, RedesignAlarmSettingsActivity.class);
        intent.putExtra("extra_mode", 2);
        intent.putExtra("extra_alarm", alarm);
        return intent;
    }

    public static Intent m3921c(Context context) {
        Intent intent = C0832m.m3914a(context, RedesignAlarmSettingsActivity.class);
        intent.putExtra("extra_mode", 3);
        return intent;
    }

    public static Intent m3908a(int timerId, String intentAction) {
        Intent intent = new Intent();
        intent.setAction(intentAction);
        if (timerId != -1) {
            intent.putExtra("extra_timer_id", timerId);
        }
        if (C0810h.f2131e) {
            intent.addFlags(DriveFile.MODE_READ_ONLY);
        }
        return intent;
    }

    public static Intent m3924d(Context context) {
        return C0832m.m3914a(context, RedesignStopwatchPreferenceActivity.class);
    }

    public static Intent m3922c(Context context, RedesignAlarm alarm) {
        Intent intent = C0832m.m3914a(context, RedesignAlarmAlertActivity.class);
        intent.putExtra("intent.extra.alarm", alarm);
        return intent;
    }

    public static Intent m3925d(Context context, RedesignAlarm alarm) {
        return C0832m.m3922c(context, alarm);
    }

    public static Intent m3928e(Context context, RedesignAlarm alarm) {
        Intent alarmSnoozed = C0832m.m3914a(context, RedesignAlarmAlertActivity.class);
        alarmSnoozed.putExtra("com.anglelabs.alarmclock.redesign.activities.RedesignAlarmAlertActivity.show_snoozed_Display", true);
        alarmSnoozed.putExtra("intent.extra.alarm", alarm);
        alarmSnoozed.putExtra("CAME_FROM_NOTIFICATION", true);
        alarmSnoozed.addFlags(Cast.MAX_MESSAGE_LENGTH);
        return alarmSnoozed;
    }

    public static Intent m3927e(Context context) {
        Intent intent = C0832m.m3914a(context, NewMainActivity.class);
        intent.putExtra("alarmclock.select.tab", 0);
        return intent;
    }

    public static Intent m3931f(Context context, RedesignAlarm alarm) {
        Intent intent = C0832m.m3927e(context);
        intent.putExtra("intent.extra.alarm", alarm);
        return intent;
    }

    public static Intent m3930f(Context context) {
        Intent intent = C0832m.m3914a(context, NewMainActivity.class);
        intent.putExtra("alarmclock.select.tab", 0);
        return intent;
    }

    public static Intent m3932g(Context context) {
        Intent intent = C0832m.m3930f(context);
        intent.putExtra("=com.alarmclock.xtreme.create.new", true);
        return intent;
    }

    public static Intent m3933h(Context context) {
        Intent intent = C0832m.m3914a(context, NewMainActivity.class);
        intent.putExtra("alarmclock.select.tab", 2);
        return intent;
    }

    public static Intent m3910a(Context context, int timerId) {
        Intent intent = C0832m.m3914a(context, NewMainActivity.class);
        intent.putExtra("alarmclock.select.tab", 1);
        intent.putExtra("extra_timer_id", timerId);
        return intent;
    }

    public static Intent m3918b(Context context, int timerId) {
        Intent intent = C0832m.m3910a(context, timerId);
        intent.putExtra("timer_ringing", true);
        return intent;
    }

    public static Intent m3934i(Context context) {
        Intent intent = C0832m.m3914a(context, NewMainActivity.class);
        intent.putExtra("alarmclock.select.tab", 1);
        intent.putExtra("extra_timer_setup", true);
        return intent;
    }

    public static void m3935j(Context context) {
        C0022i.m108a(context).m113a(new Intent().setAction("RedesignViewAlarmsFragment.refreshAlarms"));
    }

    public static Intent m3936k(Context context) {
        return C0832m.m3914a(context, RedesignMainSettingsActivity.class);
    }

    public static Intent m3937l(Context context) {
        return C0832m.m3914a(context, RedesignGeneralSettingActivity.class);
    }

    public static Intent m3938m(Context context) {
        return C0832m.m3914a(context, RedesignChooseBackgroundActivity.class);
    }

    private static Intent m3916a(String subject, String body) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.EMAIL", "");
        intent.putExtra("android.intent.extra.SUBJECT", subject);
        intent.putExtra("android.intent.extra.TEXT", body);
        return intent;
    }

    public static Intent m3939n(Context context) {
        Stopwatch stopwatch = new Stopwatch(context);
        return C0832m.m3916a(context.getString(R.string.stopwatch_email_times_subject) + " " + DateFormat.getDateInstance(3).format(new Date()), (context.getString(R.string.stopwatch_total_label) + ": " + C0870z.m4066b(context, stopwatch.m3640g())) + "\n\r\n\r" + stopwatch.m3636d(context));
    }

    public static Intent m3940o(Context context) {
        return Intent.createChooser(C0832m.m3939n(context), context.getString(R.string.share_using));
    }

    public static Intent m3912a(Context context, CharSequence selectedArtist) {
        return C0832m.m3913a(context, selectedArtist, 1);
    }

    public static Intent m3920b(Context context, CharSequence selectedPlaylist) {
        return C0832m.m3913a(context, selectedPlaylist, 0);
    }

    public static Intent m3923c(Context context, CharSequence selectedSong) {
        return C0832m.m3913a(context, selectedSong, 2);
    }

    public static Intent m3926d(Context context, CharSequence selectedApplicationName) {
        return C0832m.m3913a(context, selectedApplicationName, 3);
    }

    public static Intent m3929e(Context context, CharSequence selectedApplicationName) {
        return C0832m.m3913a(context, selectedApplicationName, 4);
    }

    private static Intent m3913a(Context context, CharSequence selectedItem, int mode) {
        Intent intent = C0832m.m3914a(context, RedesignSetSoundTypeActivity.class);
        intent.putExtra("key_mode", mode);
        intent.putExtra("selected_item_name", selectedItem);
        return intent;
    }

    public static Intent m3907a() {
        Intent upgradeIntent = new Intent("android.intent.action.VIEW");
        upgradeIntent.setData(Uri.parse("market://details?id=com.alarmclock.xtreme"));
        return upgradeIntent;
    }

    public static Intent m3915a(String referrer) {
        Intent upgradeIntent = new Intent("android.intent.action.VIEW");
        String proUrl = "http://play.google.com/store/apps/details?id=com.alarmclock.xtreme";
        if (!TextUtils.isEmpty(referrer)) {
            int trimStartIndex = referrer.indexOf("referrer=");
            if (trimStartIndex != -1) {
                referrer = referrer.substring("referrer=".length() + trimStartIndex, referrer.length());
            }
            proUrl = "http://play.google.com/store/apps/details?id=com.alarmclock.xtreme" + referrer;
        }
        upgradeIntent.setData(Uri.parse(proUrl));
        return upgradeIntent;
    }

    public static PendingIntent m3941p(Context context) {
        Intent intent = new Intent(context, AlarmClock.class);
        intent.putExtra("extra_next_alarm_widget", true);
        return PendingIntent.getActivity(context, 2, intent, 134217728);
    }

    public static PendingIntent m3942q(Context context) {
        Intent intent = new Intent(context, AlarmClock.class);
        intent.putExtra("extra_clock_widget", true);
        return PendingIntent.getActivity(context, 1, intent, 134217728);
    }
}
