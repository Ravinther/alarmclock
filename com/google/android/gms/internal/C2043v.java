package com.google.android.gms.internal;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.ViewSwitcher;
import com.google.android.gms.dynamic.C1615d;
import com.google.android.gms.dynamic.C1618e;
import com.google.android.gms.internal.ap.C1745a;
import com.google.android.gms.internal.cr.C1804a;
import com.google.android.gms.internal.cx.C1815a;
import java.util.ArrayList;
import java.util.HashSet;

/* renamed from: com.google.android.gms.internal.v */
public class C2043v extends C1745a implements az, bc, bk, cf, ci, C1804a, dl, C2039u {
    private final C2048x kA;
    private final aa kB;
    private boolean kC;
    private final ComponentCallbacks kD;
    private final bq ky;
    private final C2042b kz;

    /* renamed from: com.google.android.gms.internal.v.1 */
    class C20401 implements ComponentCallbacks {
        final /* synthetic */ C2043v kE;

        C20401(C2043v c2043v) {
            this.kE = c2043v;
        }

        public void onConfigurationChanged(Configuration newConfig) {
            if (this.kE.kz != null && this.kE.kz.kO != null && this.kE.kz.kO.oj != null) {
                this.kE.kz.kO.oj.bE();
            }
        }

        public void onLowMemory() {
        }
    }

    /* renamed from: com.google.android.gms.internal.v.a */
    private static final class C2041a extends ViewSwitcher {
        private final dr kF;

        public C2041a(Context context) {
            super(context);
            this.kF = new dr(context);
        }

        public boolean onInterceptTouchEvent(MotionEvent event) {
            this.kF.m8197c(event);
            return false;
        }
    }

    /* renamed from: com.google.android.gms.internal.v.b */
    private static final class C2042b {
        public final C2041a kG;
        public final String kH;
        public final Context kI;
        public final C2026l kJ;
        public final dx kK;
        public ao kL;
        public C1810do kM;
        public ak kN;
        public dh kO;
        public di kP;
        public ar kQ;
        public co kR;
        public dm kS;
        private HashSet kT;

        public C2042b(Context context, ak akVar, String str, dx dxVar) {
            this.kS = null;
            this.kT = null;
            if (akVar.lT) {
                this.kG = null;
            } else {
                this.kG = new C2041a(context);
                this.kG.setMinimumWidth(akVar.widthPixels);
                this.kG.setMinimumHeight(akVar.heightPixels);
                this.kG.setVisibility(4);
            }
            this.kN = akVar;
            this.kH = str;
            this.kI = context;
            this.kJ = new C2026l(C2018k.m8891a(dxVar.rq, context));
            this.kK = dxVar;
        }

        public void m8991a(HashSet hashSet) {
            this.kT = hashSet;
        }

        public HashSet ak() {
            return this.kT;
        }
    }

    public C2043v(Context context, ak akVar, String str, bq bqVar, dx dxVar) {
        this.kD = new C20401(this);
        this.kz = new C2042b(context, akVar, str, dxVar);
        this.ky = bqVar;
        this.kA = new C2048x(this);
        this.kB = new aa();
        dw.m8219x("Use AdRequest.Builder.addTestDevice(\"" + dv.m8211l(context) + "\") to get test ads on this device.");
        dq.m8188i(context);
        m8992S();
    }

    private void m8992S() {
        if (VERSION.SDK_INT >= 14 && this.kz != null && this.kz.kI != null) {
            this.kz.kI.registerComponentCallbacks(this.kD);
        }
    }

    private void m8993T() {
        if (VERSION.SDK_INT >= 14 && this.kz != null && this.kz.kI != null) {
            this.kz.kI.unregisterComponentCallbacks(this.kD);
        }
    }

    private void m8995a(int i) {
        dw.m8221z("Failed to load ad: " + i);
        if (this.kz.kL != null) {
            try {
                this.kz.kL.onAdFailedToLoad(i);
            } catch (Throwable e) {
                dw.m8215c("Could not call AdListener.onAdFailedToLoad().", e);
            }
        }
    }

    private void ad() {
        dw.m8219x("Ad closing.");
        if (this.kz.kL != null) {
            try {
                this.kz.kL.onAdClosed();
            } catch (Throwable e) {
                dw.m8215c("Could not call AdListener.onAdClosed().", e);
            }
        }
    }

    private void ae() {
        dw.m8219x("Ad leaving application.");
        if (this.kz.kL != null) {
            try {
                this.kz.kL.onAdLeftApplication();
            } catch (Throwable e) {
                dw.m8215c("Could not call AdListener.onAdLeftApplication().", e);
            }
        }
    }

    private void af() {
        dw.m8219x("Ad opening.");
        if (this.kz.kL != null) {
            try {
                this.kz.kL.onAdOpened();
            } catch (Throwable e) {
                dw.m8215c("Could not call AdListener.onAdOpened().", e);
            }
        }
    }

    private void ag() {
        dw.m8219x("Ad finished loading.");
        if (this.kz.kL != null) {
            try {
                this.kz.kL.onAdLoaded();
            } catch (Throwable e) {
                dw.m8215c("Could not call AdListener.onAdLoaded().", e);
            }
        }
    }

    private boolean ah() {
        boolean z = true;
        if (!dq.m8182a(this.kz.kI.getPackageManager(), this.kz.kI.getPackageName(), "android.permission.INTERNET")) {
            if (!this.kz.kN.lT) {
                dv.m8210a(this.kz.kG, this.kz.kN, "Missing internet permission in AndroidManifest.xml.", "Missing internet permission in AndroidManifest.xml. You must have the following declaration: <uses-permission android:name=\"android.permission.INTERNET\" />");
            }
            z = false;
        }
        if (!dq.m8187h(this.kz.kI)) {
            if (!this.kz.kN.lT) {
                dv.m8210a(this.kz.kG, this.kz.kN, "Missing AdActivity with android:configChanges in AndroidManifest.xml.", "Missing AdActivity with android:configChanges in AndroidManifest.xml. You must have the following declaration within the <application> element: <activity android:name=\"com.google.android.gms.ads.AdActivity\" android:configChanges=\"keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize\" />");
            }
            z = false;
        }
        if (!(z || this.kz.kN.lT)) {
            this.kz.kG.setVisibility(0);
        }
        return z;
    }

    private void ai() {
        if (this.kz.kO == null) {
            dw.m8221z("Ad state was null when trying to ping click URLs.");
            return;
        }
        dw.m8217v("Pinging click URLs.");
        this.kz.kP.bl();
        if (this.kz.kO.ne != null) {
            dq.m8177a(this.kz.kI, this.kz.kK.rq, this.kz.kO.ne);
        }
        if (this.kz.kO.qt != null && this.kz.kO.qt.ne != null) {
            bo.m7925a(this.kz.kI, this.kz.kK.rq, this.kz.kO, this.kz.kH, false, this.kz.kO.qt.ne);
        }
    }

    private void aj() {
        if (this.kz.kO != null) {
            this.kz.kO.oj.destroy();
            this.kz.kO = null;
        }
    }

    private void m8996b(View view) {
        this.kz.kG.addView(view, new LayoutParams(-2, -2));
    }

    private void m8997b(boolean z) {
        if (this.kz.kO == null) {
            dw.m8221z("Ad state was null when trying to ping impression URLs.");
            return;
        }
        dw.m8217v("Pinging Impression URLs.");
        this.kz.kP.bk();
        if (this.kz.kO.nf != null) {
            dq.m8177a(this.kz.kI, this.kz.kK.rq, this.kz.kO.nf);
        }
        if (!(this.kz.kO.qt == null || this.kz.kO.qt.nf == null)) {
            bo.m7925a(this.kz.kI, this.kz.kK.rq, this.kz.kO, this.kz.kH, z, this.kz.kO.qt.nf);
        }
        if (this.kz.kO.nx != null && this.kz.kO.nx.na != null) {
            bo.m7925a(this.kz.kI, this.kz.kK.rq, this.kz.kO, this.kz.kH, z, this.kz.kO.nx.na);
        }
    }

    private boolean m8998b(dh dhVar) {
        View view;
        if (dhVar.po) {
            try {
                view = (View) C1618e.m6733d(dhVar.ny.getView());
                View nextView = this.kz.kG.getNextView();
                if (nextView != null) {
                    this.kz.kG.removeView(nextView);
                }
                try {
                    m8996b(view);
                } catch (Throwable th) {
                    dw.m8215c("Could not add mediation view to view hierarchy.", th);
                    return false;
                }
            } catch (Throwable th2) {
                dw.m8215c("Could not get View from mediation adapter.", th2);
                return false;
            }
        } else if (dhVar.qu != null) {
            dhVar.oj.m8228a(dhVar.qu);
            this.kz.kG.removeAllViews();
            this.kz.kG.setMinimumWidth(dhVar.qu.widthPixels);
            this.kz.kG.setMinimumHeight(dhVar.qu.heightPixels);
            m8996b(dhVar.oj);
        }
        if (this.kz.kG.getChildCount() > 1) {
            this.kz.kG.showNext();
        }
        if (this.kz.kO != null) {
            view = this.kz.kG.getNextView();
            if (view instanceof dz) {
                ((dz) view).m8227a(this.kz.kI, this.kz.kN);
            } else if (view != null) {
                this.kz.kG.removeView(view);
            }
            if (this.kz.kO.ny != null) {
                try {
                    this.kz.kO.ny.destroy();
                } catch (RemoteException e) {
                    dw.m8221z("Could not destroy previous mediation adapter.");
                }
            }
        }
        this.kz.kG.setVisibility(0);
        return true;
    }

    private C1815a m8999c(ah ahVar) {
        PackageInfo packageInfo;
        Bundle bundle;
        ApplicationInfo applicationInfo = this.kz.kI.getApplicationInfo();
        try {
            packageInfo = this.kz.kI.getPackageManager().getPackageInfo(applicationInfo.packageName, 0);
        } catch (NameNotFoundException e) {
            packageInfo = null;
        }
        if (this.kz.kN.lT || this.kz.kG.getParent() == null) {
            bundle = null;
        } else {
            int[] iArr = new int[2];
            this.kz.kG.getLocationOnScreen(iArr);
            int i = iArr[0];
            int i2 = iArr[1];
            DisplayMetrics displayMetrics = this.kz.kI.getResources().getDisplayMetrics();
            int width = this.kz.kG.getWidth();
            int height = this.kz.kG.getHeight();
            int i3 = (!this.kz.kG.isShown() || i + width <= 0 || i2 + height <= 0 || i > displayMetrics.widthPixels || i2 > displayMetrics.heightPixels) ? 0 : 1;
            bundle = new Bundle(5);
            bundle.putInt("x", i);
            bundle.putInt("y", i2);
            bundle.putInt(MMLayout.KEY_WIDTH, width);
            bundle.putInt(MMLayout.KEY_HEIGHT, height);
            bundle.putInt("visible", i3);
        }
        String bs = dj.bs();
        this.kz.kP = new di(bs, this.kz.kH);
        this.kz.kP.m8155f(ahVar);
        return new C1815a(bundle, ahVar, this.kz.kN, this.kz.kH, applicationInfo, packageInfo, bs, dj.qK, this.kz.kK, dj.m8160a((dl) this, bs));
    }

    public void m9000P() {
        ai();
    }

    public C1615d m9001Q() {
        fq.aj("getAdFrame must be called on the main UI thread.");
        return C1618e.m6734h(this.kz.kG);
    }

    public ak m9002R() {
        fq.aj("getAdSize must be called on the main UI thread.");
        return this.kz.kN;
    }

    public void m9003U() {
        ae();
    }

    public void m9004V() {
        this.kB.m7787d(this.kz.kO);
        if (this.kz.kN.lT) {
            aj();
        }
        this.kC = false;
        ad();
        this.kz.kP.bm();
    }

    public void m9005W() {
        if (this.kz.kN.lT) {
            m8997b(false);
        }
        this.kC = true;
        af();
    }

    public void m9006X() {
        m9000P();
    }

    public void m9007Y() {
        m9004V();
    }

    public void m9008Z() {
        m9003U();
    }

    public void m9009a(ak akVar) {
        fq.aj("setAdSize must be called on the main UI thread.");
        this.kz.kN = akVar;
        if (this.kz.kO != null) {
            this.kz.kO.oj.m8228a(akVar);
        }
        if (this.kz.kG.getChildCount() > 1) {
            this.kz.kG.removeView(this.kz.kG.getNextView());
        }
        this.kz.kG.setMinimumWidth(akVar.widthPixels);
        this.kz.kG.setMinimumHeight(akVar.heightPixels);
        this.kz.kG.requestLayout();
    }

    public void m9010a(ao aoVar) {
        fq.aj("setAdListener must be called on the main UI thread.");
        this.kz.kL = aoVar;
    }

    public void m9011a(ar arVar) {
        fq.aj("setAppEventListener must be called on the main UI thread.");
        this.kz.kQ = arVar;
    }

    public void m9012a(co coVar) {
        fq.aj("setInAppPurchaseListener must be called on the main UI thread.");
        this.kz.kR = coVar;
    }

    public void m9013a(dh dhVar) {
        int i = 0;
        this.kz.kM = null;
        if (!(dhVar.errorCode == -2 || dhVar.errorCode == 3)) {
            dj.m8161b(this.kz.ak());
        }
        if (dhVar.errorCode != -1) {
            boolean z = dhVar.pg.extras != null ? dhVar.pg.extras.getBoolean("_noRefresh", false) : false;
            if (this.kz.kN.lT) {
                dq.m8179a(dhVar.oj);
            } else if (!z) {
                if (dhVar.ni > 0) {
                    this.kA.m9022a(dhVar.pg, dhVar.ni);
                } else if (dhVar.qt != null && dhVar.qt.ni > 0) {
                    this.kA.m9022a(dhVar.pg, dhVar.qt.ni);
                } else if (!dhVar.po && dhVar.errorCode == 2) {
                    this.kA.m9023d(dhVar.pg);
                }
            }
            if (!(dhVar.errorCode != 3 || dhVar.qt == null || dhVar.qt.ng == null)) {
                dw.m8217v("Pinging no fill URLs.");
                bo.m7925a(this.kz.kI, this.kz.kK.rq, dhVar, this.kz.kH, false, dhVar.qt.ng);
            }
            if (dhVar.errorCode != -2) {
                m8995a(dhVar.errorCode);
                return;
            }
            int i2;
            if (!this.kz.kN.lT) {
                if (!m8998b(dhVar)) {
                    m8995a(0);
                    return;
                } else if (this.kz.kG != null) {
                    this.kz.kG.kF.m8198t(dhVar.pt);
                }
            }
            if (!(this.kz.kO == null || this.kz.kO.nA == null)) {
                this.kz.kO.nA.m7910a(null);
            }
            if (dhVar.nA != null) {
                dhVar.nA.m7910a((bk) this);
            }
            this.kB.m7787d(this.kz.kO);
            this.kz.kO = dhVar;
            if (dhVar.qu != null) {
                this.kz.kN = dhVar.qu;
            }
            this.kz.kP.m8156h(dhVar.qv);
            this.kz.kP.m8157i(dhVar.qw);
            this.kz.kP.m8158m(this.kz.kN.lT);
            this.kz.kP.m8159n(dhVar.po);
            if (!this.kz.kN.lT) {
                m8997b(false);
            }
            if (this.kz.kS == null) {
                this.kz.kS = new dm(this.kz.kH);
            }
            if (dhVar.qt != null) {
                i2 = dhVar.qt.nj;
                i = dhVar.qt.nk;
            } else {
                i2 = 0;
            }
            this.kz.kS.m8169a(i2, i);
            if (!(this.kz.kN.lT || dhVar.oj == null || (!dhVar.oj.bI().bP() && dhVar.qs == null))) {
                ab a = this.kB.m7784a(this.kz.kN, this.kz.kO);
                if (dhVar.oj.bI().bP() && a != null) {
                    a.m7799a(new C2045w(dhVar.oj));
                }
            }
            this.kz.kO.oj.bE();
            ag();
        }
    }

    public void m9014a(String str, ArrayList arrayList) {
        if (this.kz.kR == null) {
            dw.m8221z("InAppPurchaseListener is not set");
            return;
        }
        try {
            this.kz.kR.m8060a(new cm(str, arrayList, this.kz.kI, this.kz.kK.rq));
        } catch (RemoteException e) {
            dw.m8221z("Could not start In-App purchase.");
        }
    }

    public void m9015a(HashSet hashSet) {
        this.kz.m8991a(hashSet);
    }

    public boolean m9016a(ah ahVar) {
        fq.aj("loadAd must be called on the main UI thread.");
        if (this.kz.kM != null) {
            dw.m8221z("An ad request is already in progress. Aborting.");
            return false;
        } else if (this.kz.kN.lT && this.kz.kO != null) {
            dw.m8221z("An interstitial is already loading. Aborting.");
            return false;
        } else if (!ah()) {
            return false;
        } else {
            dz dzVar;
            dw.m8219x("Starting ad request.");
            this.kA.cancel();
            C1815a c = m8999c(ahVar);
            if (this.kz.kN.lT) {
                dz a = dz.m8225a(this.kz.kI, this.kz.kN, false, false, this.kz.kJ, this.kz.kK);
                a.bI().m8243a(this, null, this, this, true, this);
                dzVar = a;
            } else {
                dz dzVar2;
                View nextView = this.kz.kG.getNextView();
                if (nextView instanceof dz) {
                    dzVar2 = (dz) nextView;
                    dzVar2.m8227a(this.kz.kI, this.kz.kN);
                } else {
                    if (nextView != null) {
                        this.kz.kG.removeView(nextView);
                    }
                    nextView = dz.m8225a(this.kz.kI, this.kz.kN, false, false, this.kz.kJ, this.kz.kK);
                    if (this.kz.kN.lU == null) {
                        m8996b(nextView);
                    }
                }
                dzVar2.bI().m8243a(this, this, this, this, false, this);
                dzVar = dzVar2;
            }
            this.kz.kM = cr.m8065a(this.kz.kI, c, this.kz.kJ, dzVar, this.ky, this);
            return true;
        }
    }

    public void aa() {
        m9005W();
    }

    public void ab() {
        if (this.kz.kO != null) {
            dw.m8221z("Mediation adapter " + this.kz.kO.nz + " refreshed, but mediation adapters should never refresh.");
        }
        m8997b(true);
        ag();
    }

    public void ac() {
        fq.aj("recordManualImpression must be called on the main UI thread.");
        if (this.kz.kO == null) {
            dw.m8221z("Ad state was null when trying to ping manual tracking URLs.");
            return;
        }
        dw.m8217v("Pinging manual tracking URLs.");
        if (this.kz.kO.pq != null) {
            dq.m8177a(this.kz.kI, this.kz.kK.rq, this.kz.kO.pq);
        }
    }

    public void m9017b(ah ahVar) {
        ViewParent parent = this.kz.kG.getParent();
        if ((parent instanceof View) && ((View) parent).isShown() && dq.by() && !this.kC) {
            m9016a(ahVar);
            return;
        }
        dw.m8219x("Ad is not visible. Not refreshing ad.");
        this.kA.m9023d(ahVar);
    }

    public void destroy() {
        fq.aj("destroy must be called on the main UI thread.");
        m8993T();
        this.kz.kL = null;
        this.kz.kQ = null;
        this.kA.cancel();
        stopLoading();
        if (this.kz.kG != null) {
            this.kz.kG.removeAllViews();
        }
        if (!(this.kz.kO == null || this.kz.kO.oj == null)) {
            this.kz.kO.oj.destroy();
        }
        if (this.kz.kO != null && this.kz.kO.ny != null) {
            try {
                this.kz.kO.ny.destroy();
            } catch (RemoteException e) {
                dw.m8221z("Could not destroy mediation adapter.");
            }
        }
    }

    public boolean isReady() {
        fq.aj("isLoaded must be called on the main UI thread.");
        return this.kz.kM == null && this.kz.kO != null;
    }

    public void onAppEvent(String name, String info) {
        if (this.kz.kQ != null) {
            try {
                this.kz.kQ.onAppEvent(name, info);
            } catch (Throwable e) {
                dw.m8215c("Could not call the AppEventListener.", e);
            }
        }
    }

    public void pause() {
        fq.aj("pause must be called on the main UI thread.");
        if (this.kz.kO != null) {
            dq.m8179a(this.kz.kO.oj);
        }
        if (!(this.kz.kO == null || this.kz.kO.ny == null)) {
            try {
                this.kz.kO.ny.pause();
            } catch (RemoteException e) {
                dw.m8221z("Could not pause mediation adapter.");
            }
        }
        this.kA.pause();
    }

    public void resume() {
        fq.aj("resume must be called on the main UI thread.");
        if (this.kz.kO != null) {
            dq.m8186b(this.kz.kO.oj);
        }
        if (!(this.kz.kO == null || this.kz.kO.ny == null)) {
            try {
                this.kz.kO.ny.resume();
            } catch (RemoteException e) {
                dw.m8221z("Could not resume mediation adapter.");
            }
        }
        this.kA.resume();
    }

    public void showInterstitial() {
        fq.aj("showInterstitial must be called on the main UI thread.");
        if (!this.kz.kN.lT) {
            dw.m8221z("Cannot call showInterstitial on a banner ad.");
        } else if (this.kz.kO == null) {
            dw.m8221z("The interstitial has not loaded.");
        } else if (this.kz.kO.oj.bL()) {
            dw.m8221z("The interstitial is already showing.");
        } else {
            this.kz.kO.oj.m8233p(true);
            if (this.kz.kO.oj.bI().bP() || this.kz.kO.qs != null) {
                ab a = this.kB.m7784a(this.kz.kN, this.kz.kO);
                if (this.kz.kO.oj.bI().bP() && a != null) {
                    a.m7799a(new C2045w(this.kz.kO.oj));
                }
            }
            if (this.kz.kO.po) {
                try {
                    this.kz.kO.ny.showInterstitial();
                    return;
                } catch (Throwable e) {
                    dw.m8215c("Could not show interstitial.", e);
                    aj();
                    return;
                }
            }
            cc.m8023a(this.kz.kI, new ce((C2039u) this, (cf) this, (ci) this, this.kz.kO.oj, this.kz.kO.orientation, this.kz.kK, this.kz.kO.pt));
        }
    }

    public void stopLoading() {
        fq.aj("stopLoading must be called on the main UI thread.");
        if (this.kz.kO != null) {
            this.kz.kO.oj.stopLoading();
            this.kz.kO = null;
        }
        if (this.kz.kM != null) {
            this.kz.kM.cancel();
        }
    }
}
