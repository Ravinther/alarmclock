package com.anglelabs.alarmclock.redesign.activities;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.C0066l;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.widget.TextView;
import com.alarmclock.xtreme.free.R;
import com.anglelabs.alarmclock.redesign.alarm.AlarmStateManager;
import com.anglelabs.alarmclock.redesign.alarm.C0641a;
import com.anglelabs.alarmclock.redesign.alarm.C0645c;
import com.anglelabs.alarmclock.redesign.alarm.C0646d;
import com.anglelabs.alarmclock.redesign.alarm.p028a.C0618b;
import com.anglelabs.alarmclock.redesign.alarm.p028a.C0631d;
import com.anglelabs.alarmclock.redesign.alarm.p028a.p029b.C0605c;
import com.anglelabs.alarmclock.redesign.alarm.p028a.p029b.C0605c.C0567a;
import com.anglelabs.alarmclock.redesign.alarm.p028a.p029b.C0605c.C0609b;
import com.anglelabs.alarmclock.redesign.model.RedesignAlarm;
import com.anglelabs.alarmclock.redesign.p021b.p025a.C0564a;
import com.anglelabs.alarmclock.redesign.p026e.C0739e;
import com.anglelabs.alarmclock.redesign.p026e.C0756h;
import com.anglelabs.alarmclock.redesign.p039d.C0694b;
import com.anglelabs.alarmclock.redesign.utils.C0794b;
import com.anglelabs.alarmclock.redesign.utils.C0795c;
import com.anglelabs.alarmclock.redesign.utils.C0832m;
import com.anglelabs.alarmclock.redesign.utils.C0850q;
import com.anglelabs.alarmclock.redesign.utils.C0858u;
import com.anglelabs.alarmclock.redesign.utils.C0860w;
import com.anglelabs.alarmclock.redesign.utils.ac;
import com.anglelabs.alarmclock.redesign.utils.ac.C0791a;
import com.avg.toolkit.p049e.C0970a;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.location.LocationStatusCodes;
import com.millennialmedia.android.MMException;

public class RedesignAlarmAlertActivity extends C0564a implements C0567a {
    public RedesignAlarm f1518o;
    public final Object f1519p;
    private int f1520r;
    private int f1521s;
    private boolean f1522t;
    private SharedPreferences f1523u;
    private final C0795c f1524v;
    private C0739e f1525w;
    private C0609b f1526x;
    private C0609b f1527y;
    private final BroadcastReceiver f1528z;

    /* renamed from: com.anglelabs.alarmclock.redesign.activities.RedesignAlarmAlertActivity.1 */
    class C05661 extends BroadcastReceiver {
        final /* synthetic */ RedesignAlarmAlertActivity f1517a;

        C05661(RedesignAlarmAlertActivity redesignAlarmAlertActivity) {
            this.f1517a = redesignAlarmAlertActivity;
        }

        public void onReceive(Context context, Intent intent) {
            if (!C0641a.m2944a(context).isScreenOn()) {
                this.f1517a.finish();
            }
        }
    }

    public RedesignAlarmAlertActivity() {
        this.f1522t = false;
        this.f1524v = new C0795c(this);
        this.f1519p = new Object();
        this.f1528z = new C05661(this);
    }

    protected void onNewIntent(Intent intent) {
        if (!intent.hasExtra("CAME_FROM_NOTIFICATION") && intent.hasExtra("intent.extra.alarm")) {
            this.f1518o = (RedesignAlarm) intent.getParcelableExtra("intent.extra.alarm");
        }
        setIntent(intent);
        C0739e alertFragment = m2600q();
        boolean updatedUI = false;
        if (alertFragment != null) {
            m2602s();
            updatedUI = alertFragment.m3461a(intent);
        }
        if (!updatedUI) {
            m2599p();
        }
    }

    private void m2599p() {
        startActivity(getIntent());
        finish();
        overridePendingTransition(0, 0);
    }

    private C0739e m2600q() {
        if (this.f1525w != null && this.f1525w.isAdded()) {
            return this.f1525w;
        }
        Fragment f = m258g().m260a((int) R.id.fragments_container);
        if (f instanceof C0739e) {
            return (C0739e) f;
        }
        return null;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        IntentFilter alarmRingingIntentFilter = new IntentFilter("com.anglelabs.alarmclock.free.ALARM_ALERT");
        alarmRingingIntentFilter.setPriority(100);
        registerReceiver(this.f1528z, alarmRingingIntentFilter);
        setContentView((int) R.layout.redesign_activity_simple_container);
        this.f1523u = ac.m3774b(this);
        C0794b.m3778a((Activity) this);
        C0794b.m3782a(this, getString(R.string.ads_category_alarm_on), true, false);
        if (bundle != null) {
            m2597b(bundle);
        } else {
            m2598c(getIntent());
        }
        if (C0646d.m2989h(this, this.f1518o.f2010k) || C0646d.m2987f(this, this.f1518o.f2010k)) {
            m2603t();
            m2596a(bundle);
            m2602s();
            return;
        }
        m2601r();
    }

    private void m2596a(Bundle bundle) {
        if (bundle == null) {
            C0066l a = m258g().m262a();
            Fragment a2 = C0739e.m3452a();
            this.f1525w = a2;
            a.m189b(R.id.fragments_container, a2, "alert_fragment_tag").m188b();
            return;
        }
        this.f1525w = (C0739e) m258g().m261a("alert_fragment_tag");
    }

    private void m2601r() {
        try {
            m2615d(this.f1518o);
            C0645c.m2972d(this, this.f1518o);
        } catch (Exception e) {
            C0850q.m3984a(e);
        }
        startActivity(C0832m.m3927e(this));
        finish();
    }

    private void m2602s() {
        if (getIntent().getBooleanExtra("CAME_FROM_AUTO_SNOOZE", false)) {
            m2610a(this.f1518o);
            getIntent().removeExtra("CAME_FROM_AUTO_SNOOZE");
        } else if (getIntent().getBooleanExtra("CAME_FROM_AUTO_DISMISS", false)) {
            m2615d(this.f1518o);
            getIntent().removeExtra("CAME_FROM_AUTO_DISMISS");
        }
    }

    private void m2603t() {
        m2604u();
        if (this.f1518o.m3616b((Context) this)) {
            C0791a.m3764c(this);
        } else {
            C0791a.m3765d(this);
        }
    }

    private void m2604u() {
        boolean isUnlockScreenChecked = C0860w.m4041c(this.f1523u);
        C0791a.m3762a(this);
        if (isUnlockScreenChecked) {
            C0791a.m3763b(this);
        }
    }

    protected void onDestroy() {
        C0794b.m3788e(this);
        unregisterReceiver(this.f1528z);
        super.onDestroy();
    }

    private void m2597b(Bundle state) {
        if (state != null) {
            this.f1521s = state.getInt("timesSnoozed");
            this.f1518o = (RedesignAlarm) state.getParcelable("alarm");
            this.f1520r = state.getInt("numberProblemsSolved");
            this.f1521s = state.getInt("timesSnoozed");
        }
    }

    private void m2598c(Intent intent) {
        this.f1518o = (RedesignAlarm) intent.getParcelableExtra("intent.extra.alarm");
        this.f1521s = this.f1518o != null ? C0646d.m2975a(getApplicationContext(), this.f1518o.f2010k) : 0;
        intent.removeExtra("com.anglelabs.alarmclock.redesign.activities.RedesignAlarmAlertActivity.show_snoozed_Display");
    }

    public void onBackPressed() {
        if (m2608y()) {
            m2605v();
        } else if (this.f1518o.f2000a == 3) {
            m2615d(this.f1518o);
            C0858u.m4026a((Context) this, getString(R.string.preview_mode_cancelled));
            super.onBackPressed();
        } else if (this.f1518o.m3616b((Context) this)) {
            super.onBackPressed();
        }
    }

    private void m2605v() {
        C0066l a = m258g().m262a();
        Fragment a2 = C0739e.m3452a();
        this.f1525w = a2;
        a.m189b(R.id.fragments_container, a2, "alert_fragment_tag").m188b();
        m2606w();
    }

    protected void onSaveInstanceState(Bundle outState) {
        try {
            outState.putParcelable("alarm", this.f1518o);
            outState.putInt("numberProblemsSolved", this.f1520r);
            outState.putInt("timesSnoozed", this.f1521s);
        } catch (Exception e) {
        }
        super.onSaveInstanceState(outState);
    }

    protected void onPause() {
        m2607x();
        C0850q.m3986a("AlarmAlert onPause() finished");
        C0794b.m3787d(this);
        super.onPause();
    }

    protected void onResume() {
        super.onResume();
        m2606w();
        C0794b.m3786c(this);
    }

    private void m2606w() {
        if (this.f1526x != null) {
            this.f1526x.m2814e();
        }
        if (this.f1527y != null) {
            this.f1527y.m2814e();
        }
    }

    private void m2607x() {
        if (this.f1526x != null) {
            this.f1526x.m2813d();
        }
        if (this.f1527y != null) {
            this.f1527y.m2813d();
        }
    }

    public boolean dispatchKeyEvent(KeyEvent event) {
        if (this.f1518o != null && (this.f1518o.f1992E == 2 || this.f1518o.f2007h == 9)) {
            boolean up = event.getAction() == 1;
            switch (event.getKeyCode()) {
                case MMException.DISPLAY_AD_NOT_PERMITTED /*24*/:
                case MMException.AD_BROKEN_REFERENCE /*25*/:
                case 27:
                case 80:
                    if (up || m2608y()) {
                        return true;
                    }
                    boolean canSnooze;
                    if (this.f1518o.f2022w == 0 || this.f1521s < this.f1518o.f2022w) {
                        canSnooze = true;
                    } else {
                        canSnooze = false;
                    }
                    if (this.f1518o.f1992E == 2 && canSnooze) {
                        if (this.f1518o.m3616b((Context) this)) {
                            return true;
                        }
                        m2610a(this.f1518o);
                        m2616k();
                        return true;
                    } else if (this.f1518o.f2007h != 9) {
                        return true;
                    } else {
                        m2615d(this.f1518o);
                        return true;
                    }
            }
        }
        return super.dispatchKeyEvent(event);
    }

    private boolean m2608y() {
        Fragment fragment = m258g().m260a((int) R.id.fragments_container);
        return fragment != null && (fragment instanceof C0756h);
    }

    public synchronized void m2610a(RedesignAlarm snoozedAlarm) {
        if (snoozedAlarm == null) {
            C0850q.m3987b("AlarmAlert snooze method called with null alarm.");
        } else if (!(snoozedAlarm.m3616b((Context) this) || snoozedAlarm.m3621g(this))) {
            C0646d.m2981b((Context) this, snoozedAlarm.f2010k);
            AlarmStateManager.m2788a(getApplicationContext(), snoozedAlarm, m2614c(snoozedAlarm));
            C0832m.m3935j(this);
            getWindow().clearFlags(Cast.MAX_NAMESPACE_LENGTH);
        }
    }

    public void m2616k() {
        C0739e f = m2600q();
        if (f != null) {
            f.m3463c();
        } else {
            m2599p();
        }
    }

    public int m2611b(RedesignAlarm alarm) {
        boolean endActivity = this.f1518o.f2010k == alarm.f2010k;
        this.f1521s = m2618m();
        int temp = this.f1521s - 1;
        if (temp < 0) {
            C0970a.m4325b("time snooze was 0 when called");
            temp = 0;
        }
        int snoozeDuration = alarm.f1991D - (alarm.f2006g * temp);
        if (snoozeDuration < 1) {
            return 1;
        }
        if (endActivity || snoozeDuration <= 10) {
            return snoozeDuration;
        }
        return 10;
    }

    public long m2614c(RedesignAlarm alarm) {
        return System.currentTimeMillis() + ((long) ((m2611b(alarm) * 60) * LocationStatusCodes.GEOFENCE_NOT_AVAILABLE));
    }

    public synchronized void m2615d(RedesignAlarm alarm) {
        if (!this.f1522t) {
            if (alarm != null) {
                this.f1522t = true;
                if (this.f1523u == null) {
                    this.f1523u = ac.m3774b(this);
                }
                AlarmStateManager.m2792b((Context) this, alarm);
                C0850q.m3986a("AlarmAlert dismiss method finished for alarm with id = " + alarm.f2010k);
                if (alarm.f2000a == 3) {
                    C0694b.m3140a((Context) this, alarm.f2010k, false);
                }
                C0832m.m3935j(this);
                finish();
            } else {
                C0850q.m3987b("AlarmAlert dismiss method called with null alarm.");
            }
        }
    }

    public Handler m2617l() {
        return this.f1524v;
    }

    public int m2618m() {
        int a = this.f1518o != null ? C0646d.m2975a(getApplicationContext(), this.f1518o.f2010k) : 0;
        this.f1521s = a;
        return a;
    }

    public void m2613b(boolean isForDismiss) {
        m2607x();
        m258g().m262a().m183a((int) R.id.fragments_container, C0756h.m3511a(this.f1518o, isForDismiss)).m188b();
    }

    public C0605c m2609a(TextView textView) {
        C0605c instance = C0618b.m2848a(this, this, this.f1518o, textView);
        if (instance instanceof C0609b) {
            this.f1526x = (C0609b) instance;
        }
        return instance;
    }

    public C0605c m2612b(TextView textView) {
        C0605c instance = C0631d.m2902a(this, this, this.f1518o, textView);
        if (instance instanceof C0609b) {
            this.f1527y = (C0609b) instance;
        }
        return instance;
    }
}
