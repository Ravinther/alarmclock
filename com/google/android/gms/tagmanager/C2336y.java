package com.google.android.gms.tagmanager;

import android.content.Context;
import java.net.URLEncoder;

/* renamed from: com.google.android.gms.tagmanager.y */
class C2336y implements aq {
    private static C2336y XM;
    private static final Object sf;
    private String XN;
    private String XO;
    private ar XP;
    private cf Xa;

    static {
        sf = new Object();
    }

    private C2336y(Context context) {
        this(as.m9337H(context), new cv());
    }

    C2336y(ar arVar, cf cfVar) {
        this.XP = arVar;
        this.Xa = cfVar;
    }

    public static aq m9610F(Context context) {
        aq aqVar;
        synchronized (sf) {
            if (XM == null) {
                XM = new C2336y(context);
            }
            aqVar = XM;
        }
        return aqVar;
    }

    public boolean bz(String str) {
        if (this.Xa.cS()) {
            if (!(this.XN == null || this.XO == null)) {
                try {
                    str = this.XN + "?" + this.XO + "=" + URLEncoder.encode(str, "UTF-8");
                    bh.m9375y("Sending wrapped url hit: " + str);
                } catch (Throwable e) {
                    bh.m9371c("Error wrapping URL for testing.", e);
                    return false;
                }
            }
            this.XP.bC(str);
            return true;
        }
        bh.m9376z("Too many urls sent too quickly with the TagManagerSender, rate limiting invoked.");
        return false;
    }
}
