package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.internal.bq.C1763a;
import java.util.Map;

public final class bp extends C1763a {
    private Map nB;
    private Map nC;

    private br m7928n(String str) {
        try {
            Class cls = Class.forName(str, false, bp.class.getClassLoader());
            if (MediationAdapter.class.isAssignableFrom(cls)) {
                MediationAdapter mediationAdapter = (MediationAdapter) cls.newInstance();
                return new bw(mediationAdapter, (NetworkExtras) this.nB.get(mediationAdapter.getAdditionalParametersType()));
            } else if (com.google.android.gms.ads.mediation.MediationAdapter.class.isAssignableFrom(cls)) {
                return new bu((com.google.android.gms.ads.mediation.MediationAdapter) cls.newInstance(), (Bundle) this.nC.get(cls));
            } else {
                dw.m8221z("Could not instantiate mediation adapter: " + str + " (not a valid adapter).");
                throw new RemoteException();
            }
        } catch (Throwable th) {
            dw.m8221z("Could not instantiate mediation adapter: " + str + ". " + th.getMessage());
            RemoteException remoteException = new RemoteException();
        }
    }

    public void m7929c(Map map) {
        this.nB = map;
    }

    public void m7930d(Map map) {
        this.nC = map;
    }

    public br m7931m(String str) {
        return m7928n(str);
    }
}
