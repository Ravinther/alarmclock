package com.google.android.gms.analytics;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.analytics.C1391u.C1390a;
import com.google.android.gms.analytics.GoogleAnalytics.C1341a;
import com.google.android.gms.internal.fq;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class Tracker {
    private final TrackerHandler vM;
    private final Map vN;
    private ad vO;
    private final C1367h vP;
    private final ae vQ;
    private final C1365g vR;
    private boolean vS;
    private C1347a vT;
    private aj vU;

    /* renamed from: com.google.android.gms.analytics.Tracker.a */
    private class C1347a implements C1341a {
        private C1344i tg;
        private Timer vV;
        private TimerTask vW;
        private boolean vX;
        private boolean vY;
        private int vZ;
        private long wa;
        private boolean wb;
        private long wc;
        final /* synthetic */ Tracker wd;

        /* renamed from: com.google.android.gms.analytics.Tracker.a.1 */
        class C13451 implements C1344i {
            final /* synthetic */ Tracker we;
            final /* synthetic */ C1347a wf;

            C13451(C1347a c1347a, Tracker tracker) {
                this.wf = c1347a;
                this.we = tracker;
            }

            public long currentTimeMillis() {
                return System.currentTimeMillis();
            }
        }

        /* renamed from: com.google.android.gms.analytics.Tracker.a.a */
        private class C1346a extends TimerTask {
            final /* synthetic */ C1347a wf;

            private C1346a(C1347a c1347a) {
                this.wf = c1347a;
            }

            public void run() {
                this.wf.vX = false;
            }
        }

        public C1347a(Tracker tracker) {
            this.wd = tracker;
            this.vX = false;
            this.vY = false;
            this.vZ = 0;
            this.wa = -1;
            this.wb = false;
            this.tg = new C13451(this, tracker);
        }

        private void df() {
            GoogleAnalytics cM = GoogleAnalytics.cM();
            if (cM == null) {
                aa.m5913w("GoogleAnalytics isn't initialized for the Tracker!");
            } else if (this.wa >= 0 || this.vY) {
                cM.m5902a(this.wd.vT);
            } else {
                cM.m5904b(this.wd.vT);
            }
        }

        private synchronized void dg() {
            if (this.vV != null) {
                this.vV.cancel();
                this.vV = null;
            }
        }

        public long dc() {
            return this.wa;
        }

        public boolean dd() {
            return this.vY;
        }

        public boolean de() {
            boolean z = this.wb;
            this.wb = false;
            return z;
        }

        boolean dh() {
            return this.wa == 0 || (this.wa > 0 && this.tg.currentTimeMillis() > this.wc + this.wa);
        }

        public void enableAutoActivityTracking(boolean enabled) {
            this.vY = enabled;
            df();
        }

        public void m5907f(Activity activity) {
            C1391u.cy().m6035a(C1390a.EASY_TRACKER_ACTIVITY_START);
            dg();
            if (!this.vX && this.vZ == 0 && dh()) {
                this.wb = true;
            }
            this.vX = true;
            this.vZ++;
            if (this.vY) {
                Map hashMap = new HashMap();
                hashMap.put("&t", "appview");
                C1391u.cy().m6036t(true);
                this.wd.set("&cd", this.wd.vU != null ? this.wd.vU.m5960h(activity) : activity.getClass().getCanonicalName());
                this.wd.send(hashMap);
                C1391u.cy().m6036t(false);
            }
        }

        public void m5908g(Activity activity) {
            C1391u.cy().m6035a(C1390a.EASY_TRACKER_ACTIVITY_STOP);
            this.vZ--;
            this.vZ = Math.max(0, this.vZ);
            this.wc = this.tg.currentTimeMillis();
            if (this.vZ == 0) {
                dg();
                this.vW = new C1346a();
                this.vV = new Timer("waitForActivityStart");
                this.vV.schedule(this.vW, 1000);
            }
        }

        public void setSessionTimeout(long sessionTimeout) {
            this.wa = sessionTimeout;
            df();
        }
    }

    Tracker(String trackingId, TrackerHandler handler) {
        this(trackingId, handler, C1367h.cb(), ae.cZ(), C1365g.ca(), new C1397z("tracking"));
    }

    Tracker(String trackingId, TrackerHandler handler, C1367h clientIdDefaultProvider, ae screenResolutionDefaultProvider, C1365g appFieldsDefaultProvider, ad rateLimiter) {
        this.vN = new HashMap();
        this.vM = handler;
        if (trackingId != null) {
            this.vN.put("&tid", trackingId);
        }
        this.vN.put("useSecure", "1");
        this.vP = clientIdDefaultProvider;
        this.vQ = screenResolutionDefaultProvider;
        this.vR = appFieldsDefaultProvider;
        this.vO = rateLimiter;
        this.vT = new C1347a(this);
    }

    void m5911a(Context context, aj ajVar) {
        aa.m5915y("Loading Tracker config values.");
        this.vU = ajVar;
        if (this.vU.dj()) {
            String dk = this.vU.dk();
            set("&tid", dk);
            aa.m5915y("[Tracker] trackingId loaded: " + dk);
        }
        if (this.vU.dl()) {
            dk = Double.toString(this.vU.dm());
            set("&sf", dk);
            aa.m5915y("[Tracker] sample frequency loaded: " + dk);
        }
        if (this.vU.dn()) {
            setSessionTimeout((long) this.vU.getSessionTimeout());
            aa.m5915y("[Tracker] session timeout loaded: " + dc());
        }
        if (this.vU.m5959do()) {
            enableAutoActivityTracking(this.vU.dp());
            aa.m5915y("[Tracker] auto activity tracking loaded: " + dd());
        }
        if (this.vU.dq()) {
            if (this.vU.dr()) {
                set("&aip", "1");
                aa.m5915y("[Tracker] anonymize ip loaded: true");
            }
            aa.m5915y("[Tracker] anonymize ip loaded: false");
        }
        this.vS = this.vU.ds();
        if (this.vU.ds()) {
            Thread.setDefaultUncaughtExceptionHandler(new ExceptionReporter(this, Thread.getDefaultUncaughtExceptionHandler(), context));
            aa.m5915y("[Tracker] report uncaught exceptions loaded: " + this.vS);
        }
    }

    long dc() {
        return this.vT.dc();
    }

    boolean dd() {
        return this.vT.dd();
    }

    public void enableAdvertisingIdCollection(boolean enabled) {
        if (enabled) {
            if (this.vN.containsKey("&ate")) {
                this.vN.remove("&ate");
            }
            if (this.vN.containsKey("&adid")) {
                this.vN.remove("&adid");
                return;
            }
            return;
        }
        this.vN.put("&ate", null);
        this.vN.put("&adid", null);
    }

    public void enableAutoActivityTracking(boolean enabled) {
        this.vT.enableAutoActivityTracking(enabled);
    }

    public String get(String key) {
        C1391u.cy().m6035a(C1390a.GET);
        if (TextUtils.isEmpty(key)) {
            return null;
        }
        if (this.vN.containsKey(key)) {
            return (String) this.vN.get(key);
        }
        if (key.equals("&ul")) {
            return ak.m5964a(Locale.getDefault());
        }
        if (this.vP != null && this.vP.m5986C(key)) {
            return this.vP.getValue(key);
        }
        if (this.vQ == null || !this.vQ.m5936C(key)) {
            return (this.vR == null || !this.vR.m5980C(key)) ? null : this.vR.getValue(key);
        } else {
            return this.vQ.getValue(key);
        }
    }

    public void send(Map params) {
        C1391u.cy().m6035a(C1390a.SEND);
        Map hashMap = new HashMap();
        hashMap.putAll(this.vN);
        if (params != null) {
            hashMap.putAll(params);
        }
        if (TextUtils.isEmpty((CharSequence) hashMap.get("&tid"))) {
            aa.m5916z(String.format("Missing tracking id (%s) parameter.", new Object[]{"&tid"}));
        }
        String str = (String) hashMap.get("&t");
        if (TextUtils.isEmpty(str)) {
            aa.m5916z(String.format("Missing hit type (%s) parameter.", new Object[]{"&t"}));
            str = "";
        }
        if (this.vT.de()) {
            hashMap.put("&sc", "start");
        }
        if (str.equals("transaction") || str.equals("item") || this.vO.cS()) {
            this.vM.m5895q(hashMap);
        } else {
            aa.m5916z("Too many hits sent too quickly, rate limiting invoked.");
        }
    }

    public void set(String key, String value) {
        fq.m8517b((Object) key, (Object) "Key should be non-null");
        C1391u.cy().m6035a(C1390a.SET);
        this.vN.put(key, value);
    }

    public void setAnonymizeIp(boolean anonymize) {
        set("&aip", ak.m5967u(anonymize));
    }

    public void setAppId(String appId) {
        set("&aid", appId);
    }

    public void setAppInstallerId(String appInstallerId) {
        set("&aiid", appInstallerId);
    }

    public void setAppName(String appName) {
        set("&an", appName);
    }

    public void setAppVersion(String appVersion) {
        set("&av", appVersion);
    }

    public void setClientId(String clientId) {
        set("&cid", clientId);
    }

    public void setEncoding(String encoding) {
        set("&de", encoding);
    }

    public void setHostname(String hostname) {
        set("&dh", hostname);
    }

    public void setLanguage(String language) {
        set("&ul", language);
    }

    public void setLocation(String location) {
        set("&dl", location);
    }

    public void setPage(String page) {
        set("&dp", page);
    }

    public void setReferrer(String referrer) {
        set("&dr", referrer);
    }

    public void setSampleRate(double sampleRate) {
        set("&sf", Double.toHexString(sampleRate));
    }

    public void setScreenColors(String screenColors) {
        set("&sd", screenColors);
    }

    public void setScreenName(String screenName) {
        set("&cd", screenName);
    }

    public void setScreenResolution(int width, int height) {
        if (width >= 0 || height >= 0) {
            set("&sr", width + "x" + height);
        } else {
            aa.m5916z("Invalid width or height. The values should be non-negative.");
        }
    }

    public void setSessionTimeout(long sessionTimeout) {
        this.vT.setSessionTimeout(1000 * sessionTimeout);
    }

    public void setTitle(String title) {
        set("&dt", title);
    }

    public void setUseSecure(boolean useSecure) {
        set("useSecure", ak.m5967u(useSecure));
    }

    public void setViewportSize(String viewportSize) {
        set("&vp", viewportSize);
    }
}
