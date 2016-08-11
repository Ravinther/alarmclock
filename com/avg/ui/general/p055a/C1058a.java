package com.avg.ui.general.p055a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.C0069f;
import android.support.v4.app.Fragment;
import android.support.v7.p012a.C0328a.C0324c;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import com.avg.toolkit.ads.AdsManager;
import com.avg.ui.general.C1063a;
import com.avg.ui.general.C1076b;
import com.avg.ui.general.C1091c.C1082f;
import com.avg.ui.general.C1091c.C1084h;
import com.avg.ui.general.customviews.C1088a;
import com.avg.ui.general.p042g.C0719b;
import com.avg.ui.general.p042g.C1178c;
import com.avg.ui.general.p042g.C1178c.C1057a;
import com.avg.ui.general.p042g.C1179a;
import java.util.ArrayList;

/* renamed from: com.avg.ui.general.a.a */
public abstract class C1058a extends C1056c implements C1057a {
    public static boolean f3244o;
    protected C1178c f3245p;
    private C0324c f3246s;
    private boolean f3247t;
    private Menu f3248u;
    private AdsManager f3249v;
    private boolean f3250w;
    private C1054a f3251x;
    private Bundle f3252y;
    private boolean f3253z;

    /* renamed from: com.avg.ui.general.a.a.1 */
    class C10521 implements C0324c {
        final /* synthetic */ C1058a f3232a;

        C10521(C1058a c1058a) {
            this.f3232a = c1058a;
        }

        public void m4582a(boolean b) {
            this.f3232a.f3247t = b;
        }
    }

    /* renamed from: com.avg.ui.general.a.a.2 */
    class C10532 implements Runnable {
        final /* synthetic */ C1058a f3233a;

        C10532(C1058a c1058a) {
            this.f3233a = c1058a;
        }

        public void run() {
            this.f3233a.f3245p.m4902h();
        }
    }

    /* renamed from: com.avg.ui.general.a.a.a */
    private class C1054a extends BroadcastReceiver {
        final /* synthetic */ C1058a f3234a;

        public void onReceive(Context context, Intent intent) {
            if (this.f3234a.f3250w) {
                this.f3234a.m4611n();
            } else {
                this.f3234a.onBackPressed();
            }
        }
    }

    protected abstract C0719b m4613p();

    public C1058a() {
        this.f3247t = false;
        this.f3250w = false;
        this.f3252y = null;
        this.f3253z = false;
    }

    static {
        f3244o = false;
    }

    protected void onCreate(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            this.f3252y = savedInstanceState;
        }
        super.onCreate(savedInstanceState);
        this.f3253z = getIntent().getBooleanExtra("external_navigation", false);
        setContentView(m4612o());
        this.f3246s = new C10521(this);
        m1486h().m1451a(this.f3246s);
        m4608k();
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() != 16908332) {
            return super.onOptionsItemSelected(item);
        }
        this.f3245p.m4891a(item);
        return true;
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        for (Fragment fragment : m258g().m273f()) {
            if (fragment != null) {
                fragment.onActivityResult(requestCode, resultCode, data);
            }
        }
    }

    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode != 82) {
            return super.onKeyUp(keyCode, event);
        }
        this.f3245p.m4902h();
        return true;
    }

    protected void onDestroy() {
        if (this.f3245p != null) {
            this.f3245p.m4901g();
        }
        m1486h().m1456b(this.f3246s);
        m4604w();
        super.onDestroy();
    }

    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        this.f3247t = savedInstanceState.getBoolean("menu_state", false);
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("menu_state", this.f3247t);
    }

    protected void onResume() {
        super.onResume();
        m4602u();
        if (this.f3248u != null) {
            this.f3248u.close();
        }
        f3244o = false;
    }

    private void m4602u() {
        if (getIntent() != null && getIntent().hasExtra("EXTRA_NOTIFICATION_FROM")) {
            C1076b.m4635a(getApplicationContext(), getIntent().getStringExtra("EXTRA_NOTIFICATION_FROM"));
            getIntent().removeExtra("EXTRA_NOTIFICATION_FROM");
        }
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        if (this.f3247t) {
            new Handler().post(new C10532(this));
        }
        return super.onPrepareOptionsMenu(menu);
    }

    protected void m4608k() {
        this.f3249v = (AdsManager) findViewById(C1082f.banner);
        this.f3245p = m4610m();
        if (this.f3252y != null) {
            this.f3245p.m4893a(m255d(), this.f3252y);
        } else if (!m4603v()) {
            C0719b handheldLandingFragment = m4613p();
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                ((Fragment) handheldLandingFragment).setArguments(extras);
            }
            this.f3245p.m4892a(handheldLandingFragment);
        }
    }

    protected String m4609l() {
        return "";
    }

    protected C1178c m4610m() {
        return new C1179a(this, m4609l());
    }

    public void onBackPressed() {
        boolean isNormalBack = false;
        this.f3250w = false;
        if (this.f3245p.m4896b() && !this.f3253z) {
            isNormalBack = true;
        }
        if (isNormalBack || this.f3245p.m4897c()) {
            this.f3245p.m4895a(true);
        } else {
            this.f3245p.m4898d();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        this.f3248u = menu;
        return super.onCreateOptionsMenu(menu);
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f3253z = intent.getBooleanExtra("external_navigation", false);
        setIntent(intent);
        m4602u();
        if (m4603v() && this.f3248u != null) {
            this.f3248u.close();
        }
        if (intent.getExtras() != null) {
            this.f3245p.m4889a(intent.getExtras());
        }
    }

    private boolean m4603v() {
        ArrayList fragments = getIntent().getStringArrayListExtra("CHAIN_NAVIGATION_KEY");
        if (fragments == null) {
            return false;
        }
        getIntent().removeExtra("CHAIN_NAVIGATION_KEY");
        m4606a(fragments, getIntent().getExtras(), true);
        return true;
    }

    public void m4606a(ArrayList fragmentNames, Bundle bundle, boolean clearStackBefore) {
        this.f3245p.m4894a(fragmentNames, bundle, clearStackBefore);
    }

    public void m4611n() {
        this.f3250w = true;
        this.f3245p.m4899e();
        m4604w();
    }

    public void m4605a(C1088a dialogFragment, String tag) {
        this.f3245p.m4890a((C0069f) dialogFragment, tag);
    }

    public Object m4607c() {
        C1063a lastState = this.f3245p.m4900f();
        return lastState == null ? super.m254c() : lastState;
    }

    protected int m4612o() {
        return C1084h.landing;
    }

    private void m4604w() {
        if (this.f3251x != null) {
            try {
                unregisterReceiver(this.f3251x);
            } catch (IllegalArgumentException e) {
            }
        }
    }
}
