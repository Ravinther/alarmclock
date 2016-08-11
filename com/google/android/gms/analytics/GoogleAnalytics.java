package com.google.android.gms.analytics;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.google.android.gms.analytics.C1391u.C1390a;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class GoogleAnalytics extends TrackerHandler {
    private static boolean uY;
    private static GoogleAnalytics vf;
    private Context mContext;
    private C1364f sH;
    private String so;
    private String sp;
    private boolean uZ;
    private af va;
    private volatile Boolean vb;
    private Logger vc;
    private Set vd;
    private boolean ve;

    /* renamed from: com.google.android.gms.analytics.GoogleAnalytics.a */
    interface C1341a {
        void m5893f(Activity activity);

        void m5894g(Activity activity);
    }

    /* renamed from: com.google.android.gms.analytics.GoogleAnalytics.b */
    class C1342b implements ActivityLifecycleCallbacks {
        final /* synthetic */ GoogleAnalytics vg;

        C1342b(GoogleAnalytics googleAnalytics) {
            this.vg = googleAnalytics;
        }

        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        }

        public void onActivityStarted(Activity activity) {
            this.vg.m5900d(activity);
        }

        public void onActivityStopped(Activity activity) {
            this.vg.m5901e(activity);
        }
    }

    protected GoogleAnalytics(Context context) {
        this(context, C1389t.m6027q(context), C1375r.ci());
    }

    private GoogleAnalytics(Context context, C1364f thread, af serviceManager) {
        this.vb = Boolean.valueOf(false);
        this.ve = false;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.mContext = context.getApplicationContext();
        this.sH = thread;
        this.va = serviceManager;
        C1365g.m5979n(this.mContext);
        ae.m5935n(this.mContext);
        C1367h.m5985n(this.mContext);
        this.vc = new C1369l();
        this.vd = new HashSet();
        cN();
    }

    private int m5896I(String str) {
        String toLowerCase = str.toLowerCase();
        return "verbose".equals(toLowerCase) ? 0 : "info".equals(toLowerCase) ? 1 : "warning".equals(toLowerCase) ? 2 : "error".equals(toLowerCase) ? 3 : -1;
    }

    private Tracker m5897a(Tracker tracker) {
        if (this.so != null) {
            tracker.set("&an", this.so);
        }
        if (this.sp != null) {
            tracker.set("&av", this.sp);
        }
        return tracker;
    }

    static GoogleAnalytics cM() {
        GoogleAnalytics googleAnalytics;
        synchronized (GoogleAnalytics.class) {
            googleAnalytics = vf;
        }
        return googleAnalytics;
    }

    private void cN() {
        if (!uY) {
            ApplicationInfo applicationInfo;
            try {
                applicationInfo = this.mContext.getPackageManager().getApplicationInfo(this.mContext.getPackageName(), 129);
            } catch (NameNotFoundException e) {
                aa.m5915y("PackageManager doesn't know about package: " + e);
                applicationInfo = null;
            }
            if (applicationInfo == null) {
                aa.m5916z("Couldn't get ApplicationInfo to load gloabl config.");
                return;
            }
            Bundle bundle = applicationInfo.metaData;
            if (bundle != null) {
                int i = bundle.getInt("com.google.android.gms.analytics.globalConfigResource");
                if (i > 0) {
                    C1394w c1394w = (C1394w) new C1393v(this.mContext).m5957p(i);
                    if (c1394w != null) {
                        m5903a(c1394w);
                    }
                }
            }
        }
    }

    private void m5900d(Activity activity) {
        for (C1341a f : this.vd) {
            f.m5893f(activity);
        }
    }

    private void m5901e(Activity activity) {
        for (C1341a g : this.vd) {
            g.m5894g(activity);
        }
    }

    public static GoogleAnalytics getInstance(Context context) {
        GoogleAnalytics googleAnalytics;
        synchronized (GoogleAnalytics.class) {
            if (vf == null) {
                vf = new GoogleAnalytics(context);
            }
            googleAnalytics = vf;
        }
        return googleAnalytics;
    }

    void m5902a(C1341a c1341a) {
        this.vd.add(c1341a);
    }

    void m5903a(C1394w c1394w) {
        aa.m5915y("Loading global config values.");
        if (c1394w.cC()) {
            this.so = c1394w.cD();
            aa.m5915y("app name loaded: " + this.so);
        }
        if (c1394w.cE()) {
            this.sp = c1394w.cF();
            aa.m5915y("app version loaded: " + this.sp);
        }
        if (c1394w.cG()) {
            int I = m5896I(c1394w.cH());
            if (I >= 0) {
                aa.m5915y("log level loaded: " + I);
                getLogger().setLogLevel(I);
            }
        }
        if (c1394w.cI()) {
            this.va.setLocalDispatchPeriod(c1394w.cJ());
        }
        if (c1394w.cK()) {
            setDryRun(c1394w.cL());
        }
    }

    void m5904b(C1341a c1341a) {
        this.vd.remove(c1341a);
    }

    @Deprecated
    public void dispatchLocalHits() {
        this.va.dispatchLocalHits();
    }

    public void enableAutoActivityReports(Application application) {
        if (VERSION.SDK_INT >= 14 && !this.ve) {
            application.registerActivityLifecycleCallbacks(new C1342b(this));
            this.ve = true;
        }
    }

    public boolean getAppOptOut() {
        C1391u.cy().m6035a(C1390a.GET_APP_OPT_OUT);
        return this.vb.booleanValue();
    }

    public Logger getLogger() {
        return this.vc;
    }

    public boolean isDryRunEnabled() {
        C1391u.cy().m6035a(C1390a.GET_DRY_RUN);
        return this.uZ;
    }

    public Tracker newTracker(int configResId) {
        Tracker a;
        synchronized (this) {
            C1391u.cy().m6035a(C1390a.GET_TRACKER);
            Tracker tracker = new Tracker(null, this);
            if (configResId > 0) {
                aj ajVar = (aj) new ai(this.mContext).m5957p(configResId);
                if (ajVar != null) {
                    tracker.m5911a(this.mContext, ajVar);
                }
            }
            a = m5897a(tracker);
        }
        return a;
    }

    public Tracker newTracker(String trackingId) {
        Tracker a;
        synchronized (this) {
            C1391u.cy().m6035a(C1390a.GET_TRACKER);
            a = m5897a(new Tracker(trackingId, this));
        }
        return a;
    }

    void m5905q(Map map) {
        synchronized (this) {
            if (map == null) {
                throw new IllegalArgumentException("hit cannot be null");
            }
            ak.m5965a(map, "&ul", ak.m5964a(Locale.getDefault()));
            ak.m5965a(map, "&sr", ae.cZ().getValue("&sr"));
            map.put("&_u", C1391u.cy().cA());
            C1391u.cy().cz();
            this.sH.m5978q(map);
        }
    }

    public void reportActivityStart(Activity activity) {
        if (!this.ve) {
            m5900d(activity);
        }
    }

    public void reportActivityStop(Activity activity) {
        if (!this.ve) {
            m5901e(activity);
        }
    }

    public void setAppOptOut(boolean optOut) {
        C1391u.cy().m6035a(C1390a.SET_APP_OPT_OUT);
        this.vb = Boolean.valueOf(optOut);
        if (this.vb.booleanValue()) {
            this.sH.bR();
        }
    }

    public void setDryRun(boolean dryRun) {
        C1391u.cy().m6035a(C1390a.SET_DRY_RUN);
        this.uZ = dryRun;
    }

    @Deprecated
    public void setLocalDispatchPeriod(int dispatchPeriodInSeconds) {
        this.va.setLocalDispatchPeriod(dispatchPeriodInSeconds);
    }

    public void setLogger(Logger logger) {
        C1391u.cy().m6035a(C1390a.SET_LOGGER);
        this.vc = logger;
    }
}
