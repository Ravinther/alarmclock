package com.avg.toolkit.zen;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.avg.toolkit.C0647c;
import com.avg.toolkit.ITKSvc;
import com.avg.toolkit.license.C1017a;
import com.avg.toolkit.zen.p054a.C1034b;
import com.avg.toolkit.zen.p054a.C1035c;
import com.avg.toolkit.zen.p054a.C1038d;
import java.util.List;

/* renamed from: com.avg.toolkit.zen.f */
public class C1051f implements C0647c {
    private static boolean f3228d;
    private Context f3229a;
    private C1045b f3230b;
    private C1044a f3231c;

    static {
        f3228d = false;
    }

    public static boolean m4573a() {
        return f3228d;
    }

    public int getID() {
        return 23000;
    }

    public void onStart(boolean firstTime) {
    }

    public void onMessage(Bundle arguments) {
        boolean RegIdAvailable = false;
        if (arguments != null) {
            int action = arguments.getInt(ITKSvc.c_actionSubAction, -1);
            if (24001 == action) {
                m4574b(arguments.getString("registration_id"));
            } else if (action == 23001) {
                boolean adminApp = C1050e.m4570t(this.f3229a);
                boolean loggedIn = arguments.getBoolean("is_logged_in", false);
                if (!adminApp) {
                    if (!this.f3229a.getPackageName().equals(arguments.getString("package_name")) && loggedIn) {
                        C1038d.m4519a(this.f3229a, this.f3230b, "GotLoginBroadcast");
                    }
                    ITKSvc.Do(this.f3229a, 5000, 5002, null);
                }
                String regId = C1050e.m4551f(this.f3229a);
                if (!TextUtils.isEmpty(regId)) {
                    RegIdAvailable = true;
                }
                if (RegIdAvailable && loggedIn) {
                    m4572a(regId);
                }
            }
        }
    }

    public void onAlarm(Bundle arguments) {
    }

    public void onDailyTask(C1017a avgFeatures) {
        m4575d();
    }

    private void m4575d() {
        boolean connected = C1050e.m4568r(this.f3229a);
        boolean adminApp = C1050e.m4570t(this.f3229a);
        if (connected && !adminApp) {
            m4576e();
            m4577f();
        }
        boolean newGCMToken = C1050e.m4554g(this.f3229a);
        if (connected && adminApp && newGCMToken) {
            m4572a(C1050e.m4551f(this.f3229a));
        }
    }

    public void onNewLicense(C1017a avgFeatures) {
        if (C1050e.m4568r(this.f3229a)) {
            m4577f();
        }
    }

    public void onDestroy() {
    }

    public void setComm(List commClients) {
        commClients.add(C1049d.class);
    }

    private void m4576e() {
        new C1034b(this.f3229a, null, this.f3230b.m4537a(), "ZenFeatureDaily").execute(new Void[0]);
    }

    private void m4577f() {
        C1038d.m4519a(this.f3229a, this.f3230b, "ZenFeatureDaily");
    }

    private void m4572a(String regID) {
        new C1035c(this.f3229a, regID, this.f3230b.m4537a()).execute(new Void[0]);
    }

    public C1045b m4578b() {
        return this.f3230b;
    }

    public C1044a m4579c() {
        return this.f3231c;
    }

    private void m4574b(String regId) {
        if (!TextUtils.isEmpty(regId)) {
            C1050e.m4540a(this.f3229a, regId);
            boolean isConnected = C1050e.m4568r(this.f3229a);
            boolean isManaged = C1050e.m4567q(this.f3229a);
            boolean isAdmin = C1050e.m4570t(this.f3229a);
            boolean sendRegId = false;
            if (isConnected) {
                if (isAdmin && !isManaged) {
                    sendRegId = true;
                } else if (!isAdmin) {
                    sendRegId = true;
                }
            }
            if (sendRegId) {
                new C1035c(this.f3229a, regId, this.f3230b.m4537a()).execute(new Void[0]);
            }
        }
    }
}
