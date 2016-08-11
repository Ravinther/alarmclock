package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.dynamic.C1618e;
import com.google.android.gms.dynamic.C1620g;
import com.google.android.gms.internal.ck.C1793a;
import com.google.android.gms.internal.cl.C1799a;

public final class cj extends C1620g {
    private static final cj oC;

    /* renamed from: com.google.android.gms.internal.cj.a */
    private static final class C1796a extends Exception {
        public C1796a(String str) {
            super(str);
        }
    }

    static {
        oC = new cj();
    }

    private cj() {
        super("com.google.android.gms.ads.AdOverlayCreatorImpl");
    }

    public static ck m8048a(Activity activity) {
        try {
            if (!m8049b(activity)) {
                return oC.m8050c(activity);
            }
            dw.m8217v("Using AdOverlay from the client jar.");
            return new cc(activity);
        } catch (C1796a e) {
            dw.m8221z(e.getMessage());
            return null;
        }
    }

    private static boolean m8049b(Activity activity) {
        Intent intent = activity.getIntent();
        if (intent.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
            return intent.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
        }
        throw new C1796a("Ad overlay requires the useClientJar flag in intent extras.");
    }

    private ck m8050c(Activity activity) {
        try {
            return C1793a.m8021m(((cl) m6736z(activity)).m8054a(C1618e.m6734h(activity)));
        } catch (Throwable e) {
            dw.m8215c("Could not create remote AdOverlay.", e);
            return null;
        } catch (Throwable e2) {
            dw.m8215c("Could not create remote AdOverlay.", e2);
            return null;
        }
    }

    protected /* synthetic */ Object m8051d(IBinder iBinder) {
        return m8052l(iBinder);
    }

    protected cl m8052l(IBinder iBinder) {
        return C1799a.m8056n(iBinder);
    }
}
