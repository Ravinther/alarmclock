package com.avg.ui.general.components;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import com.avg.toolkit.C0961d;
import com.avg.toolkit.zen.C1045b;
import com.avg.toolkit.zen.C1051f;
import com.avg.ui.general.C1091c.C1082f;
import com.avg.ui.general.C1091c.C1084h;
import com.avg.ui.general.C1091c.C1085i;
import com.avg.ui.general.p055a.C1059b;
import com.avg.ui.general.p056h.C1064a;

public class ZENLoginActivity extends C1059b implements C1096c, C1095d {
    public boolean f3316o;
    public boolean f3317p;
    private boolean f3318s;
    private C1045b f3319t;

    /* renamed from: com.avg.ui.general.components.ZENLoginActivity.1 */
    class C10981 implements C1064a {
        final /* synthetic */ ZENLoginActivity f3315a;

        C10981(ZENLoginActivity zENLoginActivity) {
            this.f3315a = zENLoginActivity;
        }

        public void m4685a(IBinder binder) {
            this.f3315a.m4686a(binder);
        }
    }

    public ZENLoginActivity() {
        this.f3316o = false;
        this.f3317p = false;
        this.f3318s = false;
    }

    public void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(C1084h.drawer_activity_layout);
        Intent intent = getIntent();
        this.f3316o = intent.getBooleanExtra("extra_skip", false);
        this.f3317p = intent.getBooleanExtra("show_promotion_bullets", false);
        this.f3318s = intent.getBooleanExtra("from_onboarding", false);
        if (this.f3318s) {
            m1486h().m1464e();
        } else {
            m4616a(C1085i.zen_log_in, false);
        }
        m4586a(new C10981(this));
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("extra_skip", this.f3316o);
        outState.putBoolean("show_promotion_bullets", this.f3317p);
        outState.putBoolean("from_onboarding", this.f3318s);
    }

    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        this.f3316o = savedInstanceState.getBoolean("extra_skip");
        this.f3317p = savedInstanceState.getBoolean("show_promotion_bullets");
        this.f3318s = savedInstanceState.getBoolean("from_onboarding");
    }

    protected void m4686a(IBinder service) {
        C1051f zenFeature = (C1051f) ((C0961d) service).m4305a(23000);
        this.f3319t = zenFeature.m4578b();
        m4615a(C1113f.m4721a(this.f3316o, this.f3317p ? zenFeature.m4579c().m4535d(getApplicationContext()) : null, this.f3318s), C1082f.fragmentContainer, "LoginFragment");
    }

    public C1045b m4687k() {
        return this.f3319t;
    }

    public void m4688m() {
        setResult(200);
        finish();
    }

    public void m4689n() {
        setResult(300);
        finish();
    }

    protected void onDestroy() {
        super.onDestroy();
        m4588t();
    }
}
