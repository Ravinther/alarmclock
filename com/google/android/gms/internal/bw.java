package com.google.android.gms.internal;

import android.app.Activity;
import android.os.RemoteException;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.dynamic.C1615d;
import com.google.android.gms.dynamic.C1618e;
import com.google.android.gms.internal.br.C1766a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public final class bw extends C1766a {
    private final MediationAdapter nH;
    private final NetworkExtras nI;

    public bw(MediationAdapter mediationAdapter, NetworkExtras networkExtras) {
        this.nH = mediationAdapter;
        this.nI = networkExtras;
    }

    private MediationServerParameters m7948b(String str, int i, String str2) {
        Map hashMap;
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                hashMap = new HashMap(jSONObject.length());
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str3 = (String) keys.next();
                    hashMap.put(str3, jSONObject.getString(str3));
                }
            } catch (Throwable th) {
                dw.m8215c("Could not get MediationServerParameters.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            hashMap = new HashMap(0);
        }
        Class serverParametersType = this.nH.getServerParametersType();
        if (serverParametersType == null) {
            return null;
        }
        MediationServerParameters mediationServerParameters = (MediationServerParameters) serverParametersType.newInstance();
        mediationServerParameters.load(hashMap);
        return mediationServerParameters;
    }

    public void m7949a(C1615d c1615d, ah ahVar, String str, bs bsVar) {
        m7950a(c1615d, ahVar, str, null, bsVar);
    }

    public void m7950a(C1615d c1615d, ah ahVar, String str, String str2, bs bsVar) {
        if (this.nH instanceof MediationInterstitialAdapter) {
            dw.m8217v("Requesting interstitial ad from adapter.");
            try {
                ((MediationInterstitialAdapter) this.nH).requestInterstitialAd(new bx(bsVar), (Activity) C1618e.m6733d(c1615d), m7948b(str, ahVar.lL, str2), by.m7956e(ahVar), this.nI);
            } catch (Throwable th) {
                dw.m8215c("Could not request interstitial ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            dw.m8221z("MediationAdapter is not a MediationInterstitialAdapter: " + this.nH.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void m7951a(C1615d c1615d, ak akVar, ah ahVar, String str, bs bsVar) {
        m7952a(c1615d, akVar, ahVar, str, null, bsVar);
    }

    public void m7952a(C1615d c1615d, ak akVar, ah ahVar, String str, String str2, bs bsVar) {
        if (this.nH instanceof MediationBannerAdapter) {
            dw.m8217v("Requesting banner ad from adapter.");
            try {
                ((MediationBannerAdapter) this.nH).requestBannerAd(new bx(bsVar), (Activity) C1618e.m6733d(c1615d), m7948b(str, ahVar.lL, str2), by.m7955b(akVar), by.m7956e(ahVar), this.nI);
            } catch (Throwable th) {
                dw.m8215c("Could not request banner ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            dw.m8221z("MediationAdapter is not a MediationBannerAdapter: " + this.nH.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void destroy() {
        try {
            this.nH.destroy();
        } catch (Throwable th) {
            dw.m8215c("Could not destroy adapter.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public C1615d getView() {
        if (this.nH instanceof MediationBannerAdapter) {
            try {
                return C1618e.m6734h(((MediationBannerAdapter) this.nH).getBannerView());
            } catch (Throwable th) {
                dw.m8215c("Could not get banner view from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            dw.m8221z("MediationAdapter is not a MediationBannerAdapter: " + this.nH.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void pause() {
        throw new RemoteException();
    }

    public void resume() {
        throw new RemoteException();
    }

    public void showInterstitial() {
        if (this.nH instanceof MediationInterstitialAdapter) {
            dw.m8217v("Showing interstitial from adapter.");
            try {
                ((MediationInterstitialAdapter) this.nH).showInterstitial();
            } catch (Throwable th) {
                dw.m8215c("Could not show interstitial from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            dw.m8221z("MediationAdapter is not a MediationInterstitialAdapter: " + this.nH.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }
}
