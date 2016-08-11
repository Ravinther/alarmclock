package com.avg.toolkit.license;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import com.avg.toolkit.license.C1017a.C0987b;
import com.avg.toolkit.p049e.C0970a;
import com.p015a.p016a.p017a.C0496c;
import java.util.Date;

/* renamed from: com.avg.toolkit.license.c */
public class C1020c {
    private C0496c f3139a;

    public C1020c(Context context) {
        this.f3139a = new C0496c(context, "nahche", 0, true);
    }

    public boolean m4445a() {
        return this.f3139a.m2363a("haimhauserlahatz", false);
    }

    public long m4447b() {
        return this.f3139a.m2361a("zmanshehauserlahatz", 0);
    }

    public void m4450c() {
        if (this.f3139a.m2361a("zmanshehauserlahatz", 0) == 0) {
            Editor editor = this.f3139a.m2367b("haimhauserlahatz", true);
            if (editor != null) {
                editor.putLong("zmanshehauserlahatz", System.currentTimeMillis());
                editor.commit();
            }
            m4455f();
        }
    }

    public String m4453d() {
        return this.f3139a.m2362a("rishuy", "");
    }

    public void m4444a(String lic) {
        this.f3139a.m2366b("rishuy", lic).commit();
        m4455f();
    }

    public String m4454e() {
        return this.f3139a.m2362a("id", "0-0");
    }

    public void m4449b(String id) {
        this.f3139a.m2366b("id", id).commit();
    }

    public void m4452c(String id) {
        this.f3139a.m2366b("newLicMode", id).commit();
    }

    public boolean m4446a(int vendorId) {
        int i = this.f3139a.m2360a("originalvendorid", -1);
        if (i == -1) {
            Editor editor = this.f3139a.m2364b("originalvendorid", vendorId);
            if (editor != null) {
                editor.commit();
                return true;
            }
        }
        if (vendorId != i) {
            return false;
        }
        return true;
    }

    public long m4455f() {
        if (!m4445a()) {
            return 0;
        }
        try {
            long datelong = new Date().getTime();
            Editor editor = this.f3139a.m2365b("taarihsfira", datelong);
            if (editor == null) {
                return datelong;
            }
            editor.commit();
            return datelong;
        } catch (Exception e) {
            C0970a.m4322a(e);
            return 0;
        }
    }

    public long m4456g() {
        return this.f3139a.m2361a("taarihsfira", 0);
    }

    public boolean m4457h() {
        return this.f3139a.m2360a("ficherimtvmbeyote", 0) > 0;
    }

    public void m4443a(C0987b pt) {
        if (!m4457h() && pt.ordinal() > 0) {
            Editor editor = this.f3139a.m2364b("ficherimtvmbeyote", 1);
            if (editor != null) {
                editor.commit();
            }
        }
    }

    public int m4458i() {
        return this.f3139a.m2360a("aruz", 0);
    }

    public void m4448b(int id) {
        this.f3139a.m2364b("aruz", id).commit();
    }

    public int m4459j() {
        return this.f3139a.m2360a("girsashelap", 0);
    }

    public void m4451c(int ver) {
        this.f3139a.m2364b("girsashelap", ver).commit();
    }
}
