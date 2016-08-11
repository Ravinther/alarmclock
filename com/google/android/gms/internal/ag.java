package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.C1618e;
import com.google.android.gms.dynamic.C1620g;
import com.google.android.gms.internal.ap.C1745a;
import com.google.android.gms.internal.aq.C1747a;

public final class ag extends C1620g {
    private static final ag lG;

    static {
        lG = new ag();
    }

    private ag() {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }

    public static ap m7820a(Context context, ak akVar, String str, bp bpVar) {
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(context) == 0) {
            ap b = lG.m7821b(context, akVar, str, bpVar);
            if (b != null) {
                return b;
            }
        }
        dw.m8217v("Using AdManager from the client jar.");
        return new C2043v(context, akVar, str, bpVar, new dx(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, true));
    }

    private ap m7821b(Context context, ak akVar, String str, bp bpVar) {
        try {
            return C1745a.m7851f(((aq) m6736z(context)).m7852a(C1618e.m6734h(context), akVar, str, bpVar, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE));
        } catch (Throwable e) {
            dw.m8215c("Could not create remote AdManager.", e);
            return null;
        } catch (Throwable e2) {
            dw.m8215c("Could not create remote AdManager.", e2);
            return null;
        }
    }

    protected aq m7822c(IBinder iBinder) {
        return C1747a.m7854g(iBinder);
    }

    protected /* synthetic */ Object m7823d(IBinder iBinder) {
        return m7822c(iBinder);
    }
}
