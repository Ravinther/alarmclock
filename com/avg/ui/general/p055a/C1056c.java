package com.avg.ui.general.p055a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.avg.toolkit.license.C1017a;
import com.avg.toolkit.license.C1017a.C0987b;
import com.avg.toolkit.license.C1019b;
import com.avg.toolkit.p049e.C0970a;

/* renamed from: com.avg.ui.general.a.c */
public abstract class C1056c extends C1055d {
    private int f3240o;
    private C0987b f3241p;
    private IntentFilter f3242s;
    private BroadcastReceiver f3243t;

    /* renamed from: com.avg.ui.general.a.c.1 */
    class C10601 extends BroadcastReceiver {
        final /* synthetic */ C1056c f3254a;

        C10601(C1056c c1056c) {
            this.f3254a = c1056c;
        }

        public void onReceive(Context context, Intent intent) {
            if (!this.f3254a.m4592k()) {
                this.f3254a.m4593q();
            }
        }
    }

    public C1056c() {
        this.f3240o = -1;
        this.f3241p = null;
        this.f3242s = new IntentFilter("com.avg.LICENSE_CHANGED");
        this.f3243t = new C10601(this);
    }

    protected void onResume() {
        super.onResume();
        m4592k();
        registerReceiver(this.f3243t, this.f3242s);
    }

    protected void onPause() {
        super.onPause();
        try {
            unregisterReceiver(this.f3243t);
        } catch (IllegalArgumentException e) {
            C0970a.m4325b("license receiver is not registered. No need to unregister then");
        }
    }

    private boolean m4592k() {
        C1017a features = C1019b.m4431a();
        return features != null && m4589a(features);
    }

    private boolean m4589a(C1017a features) {
        if (!m4591b(features)) {
            return false;
        }
        m4593q();
        return true;
    }

    private boolean m4591b(C1017a features) {
        boolean needToUpdate = ((this.f3240o == -1 || this.f3240o == features.f3117c) && (this.f3241p == null || this.f3241p.ordinal() == features.f3116b.ordinal())) ? false : true;
        this.f3240o = features.f3117c;
        this.f3241p = features.f3116b;
        return needToUpdate;
    }

    protected void m4593q() {
        m4594r();
    }

    protected void m4594r() {
    }
}
