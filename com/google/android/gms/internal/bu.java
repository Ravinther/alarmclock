package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.C1338a;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.dynamic.C1615d;
import com.google.android.gms.dynamic.C1618e;
import com.google.android.gms.internal.br.C1766a;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONObject;

public final class bu extends C1766a {
    private final MediationAdapter nE;
    private final Bundle nF;

    public bu(MediationAdapter mediationAdapter, Bundle bundle) {
        this.nE = mediationAdapter;
        this.nF = bundle;
    }

    private Bundle m7943a(String str, int i, String str2) {
        dw.m8221z("Server parameters: " + str);
        try {
            Bundle bundle = new Bundle();
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                Bundle bundle2 = new Bundle();
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str3 = (String) keys.next();
                    bundle2.putString(str3, jSONObject.getString(str3));
                }
                bundle = bundle2;
            }
            if (this.nE instanceof AdMobAdapter) {
                bundle.putString("adJson", str2);
                bundle.putInt("tagForChildDirectedTreatment", i);
            }
            return bundle;
        } catch (Throwable th) {
            dw.m8215c("Could not get Server Parameters Bundle.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public void m7944a(C1615d c1615d, ah ahVar, String str, bs bsVar) {
        m7945a(c1615d, ahVar, str, null, bsVar);
    }

    public void m7945a(C1615d c1615d, ah ahVar, String str, String str2, bs bsVar) {
        if (this.nE instanceof MediationInterstitialAdapter) {
            dw.m8217v("Requesting interstitial ad from adapter.");
            try {
                MediationInterstitialAdapter mediationInterstitialAdapter = (MediationInterstitialAdapter) this.nE;
                mediationInterstitialAdapter.requestInterstitialAd((Context) C1618e.m6733d(c1615d), new bv(bsVar), m7943a(str, ahVar.lL, str2), new bt(new Date(ahVar.lH), ahVar.lI, ahVar.lJ != null ? new HashSet(ahVar.lJ) : null, ahVar.lK, ahVar.lL), this.nF);
            } catch (Throwable th) {
                dw.m8215c("Could not request interstitial ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            dw.m8221z("MediationAdapter is not a MediationInterstitialAdapter: " + this.nE.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void m7946a(C1615d c1615d, ak akVar, ah ahVar, String str, bs bsVar) {
        m7947a(c1615d, akVar, ahVar, str, null, bsVar);
    }

    public void m7947a(C1615d c1615d, ak akVar, ah ahVar, String str, String str2, bs bsVar) {
        if (this.nE instanceof MediationBannerAdapter) {
            dw.m8217v("Requesting banner ad from adapter.");
            try {
                MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter) this.nE;
                mediationBannerAdapter.requestBannerAd((Context) C1618e.m6733d(c1615d), new bv(bsVar), m7943a(str, ahVar.lL, str2), C1338a.m5872a(akVar.width, akVar.height, akVar.lS), new bt(new Date(ahVar.lH), ahVar.lI, ahVar.lJ != null ? new HashSet(ahVar.lJ) : null, ahVar.lK, ahVar.lL), this.nF);
            } catch (Throwable th) {
                dw.m8215c("Could not request banner ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            dw.m8221z("MediationAdapter is not a MediationBannerAdapter: " + this.nE.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void destroy() {
        try {
            this.nE.onDestroy();
        } catch (Throwable th) {
            dw.m8215c("Could not destroy adapter.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public C1615d getView() {
        if (this.nE instanceof MediationBannerAdapter) {
            try {
                return C1618e.m6734h(((MediationBannerAdapter) this.nE).getBannerView());
            } catch (Throwable th) {
                dw.m8215c("Could not get banner view from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            dw.m8221z("MediationAdapter is not a MediationBannerAdapter: " + this.nE.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void pause() {
        try {
            this.nE.onPause();
        } catch (Throwable th) {
            dw.m8215c("Could not pause adapter.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public void resume() {
        try {
            this.nE.onResume();
        } catch (Throwable th) {
            dw.m8215c("Could not resume adapter.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public void showInterstitial() {
        if (this.nE instanceof MediationInterstitialAdapter) {
            dw.m8217v("Showing interstitial from adapter.");
            try {
                ((MediationInterstitialAdapter) this.nE).showInterstitial();
            } catch (Throwable th) {
                dw.m8215c("Could not show interstitial from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            dw.m8221z("MediationAdapter is not a MediationInterstitialAdapter: " + this.nE.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }
}
