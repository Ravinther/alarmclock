package com.anglelabs.alarmclock.redesign.stopwatch;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.support.v4.app.C0119u.C0108d;
import com.alarmclock.xtreme.free.R;
import com.anglelabs.alarmclock.redesign.model.Stopwatch;
import com.anglelabs.alarmclock.redesign.utils.C0810h;
import com.anglelabs.alarmclock.redesign.utils.C0830k;
import com.anglelabs.alarmclock.redesign.utils.C0830k.C0822j;
import com.anglelabs.alarmclock.redesign.utils.C0832m;
import com.anglelabs.alarmclock.redesign.utils.C0860w;
import com.anglelabs.alarmclock.redesign.utils.C0870z;
import com.anglelabs.alarmclock.redesign.utils.aa;
import com.anglelabs.alarmclock.redesign.utils.aa.C0776a;
import com.google.android.gms.location.LocationStatusCodes;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

public class StopwatchNotifications extends Service implements C0776a {
    private static volatile boolean f2038a;
    private final aa f2039b;
    private Stopwatch f2040c;
    private PendingIntent f2041d;
    private AlarmManager f2042e;

    public StopwatchNotifications() {
        this.f2039b = new aa(this, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE);
    }

    public static void m3665a(Context context) {
        if (!C0860w.m4043e(PreferenceManager.getDefaultSharedPreferences(context))) {
            return;
        }
        if (Stopwatch.m3628a(context)) {
            Intent intent = new Intent(context, StopwatchNotifications.class);
            intent.setAction("stopwatch_start");
            context.startService(intent);
        } else if (Stopwatch.m3629b(context)) {
            m3666a(context, new Stopwatch(context).m3640g());
        }
    }

    private static C0108d m3668c(Context context) {
        return new C0108d(context).m464a(PendingIntent.getActivity(context, 2, C0832m.m3933h(context), 134217728)).m460a((int) R.drawable.notification_stopwatch).m472c(2);
    }

    private static String m3664a(long time) {
        return C0870z.m4058a(time, false);
    }

    private static PendingIntent m3663a(Context context, Intent intent) {
        return PendingIntent.getService(context, 2, intent, 134217728);
    }

    private C0108d m3669d(Context context) {
        Intent stopIntent = new Intent(context, StopwatchNotifications.class);
        stopIntent.setAction("stopwatch_stop");
        Intent lapIntent = new Intent(context, StopwatchNotifications.class);
        lapIntent.setAction("stopwatch_lap");
        return m3668c(context).m466a(m3664a(this.f2040c.m3640g())).m470b(context.getString(R.string.stopwatch_notification_lap, new Object[]{Integer.valueOf(this.f2040c.m3645l())})).m462a((int) R.drawable.notification_icon_large_laps, context.getString(R.string.stopwatch_lap), m3663a(context, lapIntent)).m462a((int) R.drawable.notification_icon_large_stop, context.getString(R.string.stopwatch_stop), m3663a(context, stopIntent));
    }

    private void m3670e(Context context) {
        f2038a = true;
        NotificationManager notificationManager = (NotificationManager) context.getApplicationContext().getSystemService("notification");
        new Intent(context, StopwatchNotifications.class).setAction("stopwatch_stop");
        new Intent(context, StopwatchNotifications.class).setAction("stopwatch_lap");
        Intent deleteIntent = new Intent(context, StopwatchNotifications.class);
        deleteIntent.setAction("stopwatch_deleted");
        C0108d builder = m3669d(context).m469b(m3663a(context, deleteIntent));
        builder.m463a(0);
        notificationManager.notify(2147483646, builder.m459a());
    }

    @SuppressLint({"NewApi"})
    private void m3671f(Context context) {
        if (this.f2041d == null) {
            this.f2041d = PendingIntent.getBroadcast(context, 0, new Intent("stopwatch_update_time"), 0);
        }
        if (this.f2042e == null) {
            this.f2042e = (AlarmManager) context.getSystemService("alarm");
        }
        if (C0810h.f2127a) {
            this.f2042e.setExact(3, 1000, this.f2041d);
        } else {
            this.f2042e.set(3, 1000, this.f2041d);
        }
    }

    public static void m3666a(Context context, long elapsedTime) {
        NotificationManager notificationManager = (NotificationManager) context.getApplicationContext().getSystemService("notification");
        CharSequence timeDisplay = m3664a(elapsedTime);
        Intent startIntent = new Intent(context, StopwatchNotifications.class);
        startIntent.setAction("stopwatch_start");
        Intent resetIntent = new Intent(context, StopwatchNotifications.class);
        resetIntent.setAction("stopwatch_reset");
        Intent deleteIntent = new Intent(context, StopwatchNotifications.class);
        deleteIntent.setAction("stopwatch_deleted");
        notificationManager.notify(2147483646, m3668c(context).m466a(timeDisplay).m470b(context.getString(R.string.stopwatch_notification_stopped)).m469b(m3663a(context, deleteIntent)).m462a((int) R.drawable.notification_icon_large_reset, context.getString(R.string.stopwatch_reset), m3663a(context, resetIntent)).m462a((int) R.drawable.notification_icon_large_start, context.getString(R.string.stopwatch_play), m3663a(context, startIntent)).m459a());
    }

    public static void m3667b(Context context) {
        Intent intent = new Intent(context, StopwatchNotifications.class);
        intent.setAction("stopwatch_hide");
        context.startService(intent);
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        String action = intent.getAction();
        Context applicationContext = getApplicationContext();
        this.f2040c = new Stopwatch(applicationContext);
        boolean z = true;
        switch (action.hashCode()) {
            case -974360419:
                if (action.equals("stopwatch_reset")) {
                    z = true;
                    break;
                }
                break;
            case -973006928:
                if (action.equals("stopwatch_start")) {
                    z = true;
                    break;
                }
                break;
            case -31725516:
                if (action.equals("stopwatch_hide")) {
                    z = true;
                    break;
                }
                break;
            case -31386892:
                if (action.equals("stopwatch_stop")) {
                    z = false;
                    break;
                }
                break;
            case -1019799:
                if (action.equals("stopwatch_lap")) {
                    z = true;
                    break;
                }
                break;
            case 395896807:
                if (action.equals("stopwatch_deleted")) {
                    z = true;
                    break;
                }
                break;
        }
        switch (z) {
            case Base64.DEFAULT /*0*/:
                this.f2039b.m3757b();
                f2038a = false;
                this.f2040c.m3634c();
                m3666a(applicationContext, this.f2040c.m3640g());
                C0830k.m3896a(applicationContext, C0822j.StopwatchStop);
                break;
            case Base64.NO_PADDING /*1*/:
                this.f2040c.m3633b();
                C0830k.m3896a(applicationContext, C0822j.StopwatchLap);
                break;
            case Base64.NO_WRAP /*2*/:
                this.f2040c.m3637d();
                this.f2039b.m3756a();
                m3670e(applicationContext);
                C0830k.m3896a(applicationContext, C0822j.StopwatchStart);
                break;
            case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                this.f2039b.m3757b();
                this.f2040c.m3638e();
                m3666a(applicationContext, this.f2040c.m3640g());
                C0830k.m3896a(applicationContext, C0822j.StopwatchReset);
                break;
            case Base64.CRLF /*4*/:
                this.f2039b.m3757b();
                break;
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                m3672g(applicationContext);
                break;
        }
        return 2;
    }

    private void m3672g(Context context) {
        NotificationManager notificationManager = (NotificationManager) context.getApplicationContext().getSystemService("notification");
        f2038a = false;
        notificationManager.cancel(2147483646);
        stopSelf();
        this.f2039b.m3757b();
    }

    public void onDestroy() {
        this.f2039b.m3757b();
        super.onDestroy();
        f2038a = false;
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void m3673a() {
        if (f2038a) {
            m3670e(getApplicationContext());
            m3671f(getApplicationContext());
        }
    }
}
