package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.cv.C1813a;
import com.google.android.gms.internal.cv.C1814b;

public final class cu {

    /* renamed from: com.google.android.gms.internal.cu.a */
    public interface C1811a {
        void m8067a(cz czVar);
    }

    public static C1810do m8092a(Context context, cx cxVar, C1811a c1811a) {
        return cxVar.kK.rt ? m8093b(context, cxVar, c1811a) : m8094c(context, cxVar, c1811a);
    }

    private static C1810do m8093b(Context context, cx cxVar, C1811a c1811a) {
        dw.m8217v("Fetching ad response from local ad request service.");
        C1810do c1813a = new C1813a(context, cxVar, c1811a);
        c1813a.start();
        return c1813a;
    }

    private static C1810do m8094c(Context context, cx cxVar, C1811a c1811a) {
        dw.m8217v("Fetching ad response from remote ad request service.");
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(context) == 0) {
            return new C1814b(context, cxVar, c1811a);
        }
        dw.m8221z("Failed to connect to remote ad request service.");
        return null;
    }
}
