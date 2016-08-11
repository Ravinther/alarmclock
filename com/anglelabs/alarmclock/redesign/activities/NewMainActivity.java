package com.anglelabs.alarmclock.redesign.activities;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.C0066l;
import android.support.v4.app.Fragment;
import android.support.v4.p006a.C0022i;
import android.view.Menu;
import android.view.MenuItem;
import com.alarmclock.xtreme.free.R;
import com.anglelabs.alarmclock.redesign.alarm.AlarmStateManager;
import com.anglelabs.alarmclock.redesign.alarm.C0641a;
import com.anglelabs.alarmclock.redesign.alarm.C0645c;
import com.anglelabs.alarmclock.redesign.app.C0653b;
import com.anglelabs.alarmclock.redesign.p021b.p025a.C0564a;
import com.anglelabs.alarmclock.redesign.p026e.C0723c;
import com.anglelabs.alarmclock.redesign.p026e.C0745f;
import com.anglelabs.alarmclock.redesign.p026e.C0750g;
import com.anglelabs.alarmclock.redesign.p026e.p027a.C0707d;
import com.anglelabs.alarmclock.redesign.p026e.p027a.C0707d.C0565a;
import com.anglelabs.alarmclock.redesign.stopwatch.StopwatchNotifications;
import com.anglelabs.alarmclock.redesign.utils.C0794b;
import com.anglelabs.alarmclock.redesign.utils.C0810h;
import com.anglelabs.alarmclock.redesign.utils.C0830k;
import com.anglelabs.alarmclock.redesign.utils.C0830k.C0815b;
import com.anglelabs.alarmclock.redesign.utils.C0830k.C0817d;
import com.anglelabs.alarmclock.redesign.utils.C0830k.C0828p;
import com.anglelabs.alarmclock.redesign.utils.C0832m;
import com.anglelabs.alarmclock.redesign.utils.ac;
import com.anglelabs.alarmclock.redesign.utils.ac.C0791a;
import com.avg.toolkit.ITKSvc;
import com.avg.ui.general.rateus.C1186c;
import com.google.android.gms.location.LocationStatusCodes;
import java.util.List;

public class NewMainActivity extends C0564a implements C0565a {
    private C0707d f1514o;
    private BroadcastReceiver f1515p;
    private final BroadcastReceiver f1516r;

    /* renamed from: com.anglelabs.alarmclock.redesign.activities.NewMainActivity.1 */
    class C05581 extends BroadcastReceiver {
        final /* synthetic */ NewMainActivity f1508a;

        C05581(NewMainActivity newMainActivity) {
            this.f1508a = newMainActivity;
        }

        public void onReceive(Context context, Intent intent) {
            if (!C0641a.m2944a(context).isScreenOn()) {
                this.f1508a.finish();
            }
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.activities.NewMainActivity.2 */
    class C05592 extends BroadcastReceiver {
        final /* synthetic */ NewMainActivity f1509a;

        C05592(NewMainActivity newMainActivity) {
            this.f1509a = newMainActivity;
        }

        public void onReceive(Context context, Intent intent) {
            this.f1509a.finish();
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.activities.NewMainActivity.3 */
    class C05603 implements Runnable {
        final /* synthetic */ NewMainActivity f1510a;

        C05603(NewMainActivity newMainActivity) {
            this.f1510a = newMainActivity;
        }

        public void run() {
            C0794b.m3779a(this.f1510a, (int) R.string.ads_category_main_screen, true);
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.activities.NewMainActivity.a */
    public interface C0561a {
        boolean m2568a();
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.activities.NewMainActivity.b */
    public interface C0562b {
        Fragment m2569a();
    }

    public NewMainActivity() {
        this.f1515p = new C05581(this);
        this.f1516r = new C05592(this);
    }

    public void onNewIntent(Intent newIntent) {
        super.onNewIntent(newIntent);
        setIntent(newIntent);
        m258g().m269b(null, 1);
        m2580p();
    }

    private void m2579m() {
        C0791a.m3762a(this);
        C0791a.m3763b(this);
    }

    private void m2580p() {
        Fragment displayedFragment = m2578b(false);
        if (!(displayedFragment instanceof C0750g)) {
            displayedFragment = m258g().m261a("com.RedesignMainFragment");
            if (displayedFragment == null || !(displayedFragment instanceof C0750g)) {
                displayedFragment = new C0750g();
            }
            m258g().m262a().m189b(R.id.fragments_container, displayedFragment, "com.RedesignMainFragment").m188b();
        }
        if (displayedFragment != null) {
            ((C0750g) displayedFragment).m3506d();
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        IntentFilter killActivityWhenScreenIsOff = new IntentFilter("com.anglelabs.alarmclock.free.act_timer_times_up");
        killActivityWhenScreenIsOff.setPriority(100);
        registerReceiver(this.f1515p, killActivityWhenScreenIsOff);
        C0022i.m108a((Context) this).m112a(this.f1516r, new IntentFilter("rate_us_exit_app"));
        setContentView((int) R.layout.redesign_activity_simple_container);
        C0794b.m3779a((Activity) this, (int) R.string.ads_category_main_screen, true);
        if (getIntent().getBooleanExtra("timer_ringing", false)) {
            m2579m();
        }
        if (savedInstanceState == null) {
            m258g().m262a().m184a(R.id.fragments_container, new C0750g(), "com.RedesignMainFragment").m188b();
            AlarmStateManager.m2789a((Context) this, false);
            C0794b.m3780a(this, "Alarms");
            C0830k.m3896a((Context) this, C0815b.Screen);
        }
        if (!C0810h.m3838c(this)) {
            m2581q();
        }
    }

    protected void onDestroy() {
        C0794b.m3788e(this);
        C0022i.m108a((Context) this).m111a(this.f1516r);
        unregisterReceiver(this.f1515p);
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        C0794b.m3786c(this);
        if ((this.f1514o == null || !this.f1514o.isAdded()) && !C0810h.m3838c(this)) {
            startActivity(getIntent());
            finish();
        }
        if (C0810h.m3839d(getApplicationContext())) {
            C0653b.m3001a(getApplicationContext());
        }
        StopwatchNotifications.m3667b(getApplicationContext());
    }

    private void m2581q() {
        if (this.f1514o == null || !this.f1514o.isAdded()) {
            this.f1514o = new C0707d();
            this.f1514o.show(m258g(), "TOSDialog");
        }
    }

    protected void onPause() {
        C0794b.m3787d(this);
        Fragment fragment = m2578b(false);
        if (fragment != null && (fragment instanceof C0750g)) {
            ((C0750g) fragment).m3504b();
        }
        if (this.f1514o != null && this.f1514o.isAdded()) {
            this.f1514o.dismissAllowingStateLoss();
        }
        C0645c.m2968a(getApplicationContext());
        StopwatchNotifications.m3665a(getApplicationContext());
        super.onPause();
    }

    private Fragment m2578b(boolean getLeafFragment) {
        Fragment a = m258g().m260a((int) R.id.fragments_container);
        if (getLeafFragment && (a instanceof C0562b)) {
            return ((C0562b) a).m2569a();
        }
        return a;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.redesign_main_menu, menu);
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 16908332:
                Fragment currentFragent = m2578b(true);
                if (currentFragent instanceof C0561a) {
                    ((C0561a) currentFragent).m2568a();
                    return true;
                }
                m258g().m270c();
                return true;
            case R.id.main_menu_upgrade:
                ac.m3767a(this);
                C0830k.m3896a((Context) this, C0817d.Upgrade);
                return true;
            case R.id.main_menu_settings:
                m2582r();
                return true;
            case R.id.main_menu_about:
                m2585a(new C0723c(), true);
                C0830k.m3896a((Context) this, C0817d.About);
                return true;
            case R.id.main_menu_help:
                m2585a(new C0745f(), true);
                C0830k.m3896a((Context) this, C0817d.Help);
                return true;
            default:
                return false;
        }
    }

    private void m2582r() {
        startActivity(C0832m.m3936k(this));
        C0830k.m3896a((Context) this, C0817d.Settings);
    }

    public void m2585a(Fragment fragment, boolean addToBackStack) {
        if (!m2577a(fragment.getClass())) {
            C0066l fragmentTransaction = m258g().m262a().m183a((int) R.id.fragments_container, fragment);
            if (addToBackStack) {
                fragmentTransaction.m187a(null);
            }
            fragmentTransaction.m188b();
            m258g().m268b();
        }
    }

    private boolean m2577a(Class fragmentClass) {
        Fragment visibleFragment = m2583s();
        return visibleFragment == null || (fragmentClass.equals(visibleFragment.getClass()) && visibleFragment.isVisible());
    }

    private Fragment m2583s() {
        List fragList = m258g().m273f();
        if (fragList == null || fragList.isEmpty()) {
            return null;
        }
        return (Fragment) fragList.get(m258g().m272e());
    }

    public void onBackPressed() {
        Fragment currentFragment = m2578b(true);
        if (!(currentFragment instanceof C0561a) || !((C0561a) currentFragment).m2568a()) {
            if (!m2584t() || !C1186c.m4956a((Context) this).m4986a((int) R.string.rate_us_key_back_button)) {
                super.onBackPressed();
            }
        }
    }

    private boolean m2584t() {
        return m258g().m272e() == 0;
    }

    public void m2586k() {
        C0830k.m3896a((Context) this, C0828p.Accept);
        C0810h.m3834a((Context) this, true);
        ITKSvc.Do(getApplicationContext(), LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, LocationStatusCodes.GEOFENCE_TOO_MANY_PENDING_INTENTS, null);
        new Handler().postDelayed(new C05603(this), 5000);
    }

    public void m2587l() {
        C0830k.m3896a((Context) this, C0828p.Cancel);
        C0810h.m3834a((Context) this, false);
        finish();
    }
}
