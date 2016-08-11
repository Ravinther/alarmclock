package com.anglelabs.alarmclock.receivers;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.BroadcastReceiver.PendingResult;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.PowerManager.WakeLock;
import android.os.Process;
import com.anglelabs.alarmclock.redesign.alarm.AlarmStateManager;
import com.anglelabs.alarmclock.redesign.alarm.C0641a;
import com.anglelabs.alarmclock.redesign.alarm.C0645c;
import com.anglelabs.alarmclock.redesign.alarm.C0646d;
import com.anglelabs.alarmclock.redesign.model.RedesignAlarm;
import com.anglelabs.alarmclock.redesign.stopwatch.StopwatchNotifications;
import com.anglelabs.alarmclock.redesign.timer.C0783a;
import com.anglelabs.alarmclock.redesign.utils.C0808f;
import com.anglelabs.alarmclock.redesign.utils.C0810h;
import com.anglelabs.alarmclock.redesign.utils.C0850q;
import com.anglelabs.alarmclock.redesign.utils.ac;
import java.util.ArrayList;
import java.util.Iterator;

public class AlarmInitReceiver extends BroadcastReceiver {

    /* renamed from: com.anglelabs.alarmclock.receivers.AlarmInitReceiver.1 */
    class C05081 implements Runnable {
        final /* synthetic */ Context f1365a;
        final /* synthetic */ Intent f1366b;
        final /* synthetic */ PendingResult f1367c;
        final /* synthetic */ WakeLock f1368d;
        final /* synthetic */ AlarmInitReceiver f1369e;

        C05081(AlarmInitReceiver alarmInitReceiver, Context context, Intent intent, PendingResult pendingResult, WakeLock wakeLock) {
            this.f1369e = alarmInitReceiver;
            this.f1365a = context;
            this.f1366b = intent;
            this.f1367c = pendingResult;
            this.f1368d = wakeLock;
        }

        public void run() {
            this.f1369e.m2439b(this.f1365a, this.f1366b);
            this.f1367c.finish();
            this.f1368d.release();
        }
    }

    public void onReceive(Context context, Intent intent) {
        if (context.getContentResolver() == null) {
            C0850q.m3987b("AlarmInitReceiver: FAILURE unable to get content resolver. Alarms inactive.");
        } else if (C0810h.f2129c) {
            m2434a(context, intent);
        } else {
            m2439b(context, intent);
        }
    }

    @TargetApi(11)
    private void m2434a(Context context, Intent intent) {
        PendingResult result = goAsync();
        WakeLock wl = C0641a.m2946b(context);
        wl.acquire();
        C0808f.m3825a(new C05081(this, context, intent, result, wl));
    }

    private void m2439b(Context context, Intent intent) {
        String action = intent.getAction();
        SharedPreferences prefs = ac.m3774b(context);
        AlarmStateManager.m2789a(context, false);
        if (action.equals("android.intent.action.PACKAGE_REPLACED") && Process.myUid() == intent.getIntExtra("android.intent.extra.UID", -1)) {
            if (prefs.getInt("version_number", 0) < 198109) {
                m2436a(prefs);
            }
            m2438b(context);
            m2435a(context, prefs);
        } else if (action.equals("android.intent.action.BOOT_COMPLETED")) {
            StopwatchNotifications.m3665a(context);
            C0783a.m3717b(prefs);
            m2435a(context, prefs);
        }
    }

    private void m2436a(SharedPreferences prefs) {
        prefs.edit().remove("currentVersion").putBoolean("upgraded", true).putString("updated_from_version_name", prefs.getString("version_name", "")).putInt("updated_from_version", prefs.getInt("version_number", 0)).putInt("version_number", 198109).putString("version_name", "4.0.1").apply();
    }

    public static void m2433a(Context context) {
        SharedPreferences prefs = ac.m3774b(context);
        if (!prefs.contains("version_name") || !prefs.contains("version_number")) {
            prefs.edit().putInt("version_number", 198109).putString("version_name", "4.0.1").apply();
        }
    }

    public static void m2438b(Context context) {
        C0850q.m3986a(" all alarms after update");
        AlarmStateManager.m2784a(context, ac.m3774b(context));
    }

    private static void m2435a(Context context, SharedPreferences prefs) {
        C0646d.m2983b(context, prefs);
        ArrayList snoozedAlarms = C0646d.m2977a(context, prefs);
        if (!snoozedAlarms.isEmpty()) {
            Iterator i$ = snoozedAlarms.iterator();
            while (i$.hasNext()) {
                C0645c.m2970b(context, (RedesignAlarm) i$.next());
            }
            C0645c.m2969b(context);
        }
    }
}
