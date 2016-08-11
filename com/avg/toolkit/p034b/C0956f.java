package com.avg.toolkit.p034b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import com.avg.toolkit.license.C1017a;
import com.avg.toolkit.p048d.C0969a;
import java.net.URI;

/* renamed from: com.avg.toolkit.b.f */
public class C0956f {
    private SharedPreferences f2888a;
    private Context f2889b;

    private void m4293b() {
        m4292a("use_aws_server", true);
    }

    private boolean m4294c() {
        return this.f2888a.getBoolean("use_aws_server", false);
    }

    public C0956f(Context context) {
        this.f2889b = null;
        this.f2888a = context.getApplicationContext().getSharedPreferences("av", 0);
        if (C0969a.m4318a(context) && !m4294c()) {
            m4293b();
        }
        this.f2889b = context;
    }

    public C0959h m4296a(C1017a avgFeatures, int productId, String serialNum) {
        PackageInfo pi = this.f2889b.getPackageManager().getPackageInfo(this.f2889b.getPackageName(), 0);
        if (avgFeatures != null) {
            return new C0959h(m4295d(), avgFeatures.f3120f, productId, serialNum, pi.versionName, Integer.toString(pi.versionCode));
        }
        return new C0959h(m4295d(), 0, 0, serialNum, pi.versionName, Integer.toString(pi.versionCode));
    }

    private URI m4295d() {
        return new URI(m4294c() ? "https://aws.droidsecurity.com/xmlrpc" : "https://avg-hrd.appspot.com/secure/xmlrpc");
    }

    private void m4292a(String key, boolean value) {
        Editor e = this.f2888a.edit();
        e.putBoolean(key, value);
        e.commit();
    }

    public String m4297a() {
        if (m4294c()) {
            return "https://aws.droidsecurity.com";
        }
        return "https://avg-hrd.appspot.com";
    }
}
