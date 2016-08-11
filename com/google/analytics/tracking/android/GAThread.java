package com.google.analytics.tracking.android;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import com.avg.toolkit.ITKSvc;
import com.avg.toolkit.ganalytics.GoogleAnalyticsWrapper;
import com.google.analytics.tracking.android.AnalyticsThread.ClientIdCallback;
import com.google.analytics.tracking.android.GoogleAnalytics.AppOptOutCallback;
import com.google.android.gms.analytics.internal.Command;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.common.util.VisibleForTesting;
import com.mopub.mobileads.CustomEventBannerAdapter;
import com.mopub.mobileads.factories.HttpClientFactory;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingQueue;

class GAThread extends Thread implements AnalyticsThread {
    private static GAThread f4124i;
    private final LinkedBlockingQueue f4125a;
    private volatile boolean f4126b;
    private volatile boolean f4127c;
    private volatile boolean f4128d;
    private volatile List f4129e;
    private volatile MetaModel f4130f;
    private volatile String f4131g;
    private volatile String f4132h;
    private volatile ServiceProxy f4133j;
    private final Context f4134k;

    /* renamed from: com.google.analytics.tracking.android.GAThread.1 */
    class C13211 implements Runnable {
        final /* synthetic */ Map f4114a;
        final /* synthetic */ long f4115b;
        final /* synthetic */ GAThread f4116c;

        C13211(GAThread gAThread, Map map, long j) {
            this.f4116c = gAThread;
            this.f4114a = map;
            this.f4115b = j;
        }

        public void run() {
            this.f4114a.put("clientId", this.f4116c.f4132h);
            if (!this.f4116c.f4128d && !this.f4116c.m5709d(this.f4114a)) {
                if (!TextUtils.isEmpty(this.f4116c.f4131g)) {
                    this.f4114a.put("campaign", this.f4116c.f4131g);
                    this.f4116c.f4131g = null;
                }
                this.f4116c.m5713e(this.f4114a);
                this.f4116c.m5715f(this.f4114a);
                this.f4116c.m5706c(this.f4114a);
                this.f4116c.f4133j.m5662a(HitBuilder.m5748a(this.f4116c.f4130f, this.f4114a), this.f4115b, this.f4116c.m5701b(this.f4114a), this.f4116c.f4129e);
            }
        }
    }

    /* renamed from: com.google.analytics.tracking.android.GAThread.2 */
    class C13222 implements Runnable {
        final /* synthetic */ GAThread f4117a;

        C13222(GAThread gAThread) {
            this.f4117a = gAThread;
        }

        public void run() {
            this.f4117a.f4133j.m5663c();
        }
    }

    /* renamed from: com.google.analytics.tracking.android.GAThread.3 */
    class C13233 implements Runnable {
        final /* synthetic */ boolean f4118a;
        final /* synthetic */ GAThread f4119b;

        public void run() {
            if (this.f4119b.f4128d != this.f4118a) {
                if (this.f4118a) {
                    try {
                        this.f4119b.f4134k.getFileStreamPath("gaOptOut").createNewFile();
                    } catch (IOException e) {
                        Log.m5758h("Error creating optOut file.");
                    }
                    this.f4119b.f4133j.m5664d();
                } else {
                    this.f4119b.f4134k.deleteFile("gaOptOut");
                }
                this.f4119b.f4128d = this.f4118a;
            }
        }
    }

    /* renamed from: com.google.analytics.tracking.android.GAThread.4 */
    class C13244 implements Runnable {
        final /* synthetic */ AppOptOutCallback f4120a;
        final /* synthetic */ GAThread f4121b;

        C13244(GAThread gAThread, AppOptOutCallback appOptOutCallback) {
            this.f4121b = gAThread;
            this.f4120a = appOptOutCallback;
        }

        public void run() {
            this.f4120a.m5731a(this.f4121b.f4128d);
        }
    }

    /* renamed from: com.google.analytics.tracking.android.GAThread.5 */
    class C13255 implements Runnable {
        final /* synthetic */ ClientIdCallback f4122a;
        final /* synthetic */ GAThread f4123b;

        C13255(GAThread gAThread, ClientIdCallback clientIdCallback) {
            this.f4123b = gAThread;
            this.f4122a = clientIdCallback;
        }

        public void run() {
            this.f4122a.m5586a(this.f4123b.f4132h);
        }
    }

    static GAThread m5691a(Context ctx) {
        if (f4124i == null) {
            f4124i = new GAThread(ctx);
        }
        return f4124i;
    }

    private GAThread(Context ctx) {
        super("GAThread");
        this.f4125a = new LinkedBlockingQueue();
        this.f4126b = false;
        this.f4127c = false;
        if (ctx != null) {
            this.f4134k = ctx.getApplicationContext();
        } else {
            this.f4134k = ctx;
        }
        start();
    }

    private void m5712e() {
        this.f4133j.m5665e();
        this.f4129e = new ArrayList();
        this.f4129e.add(new Command(Command.APPEND_VERSION, "_v", "ma1b4"));
        this.f4129e.add(new Command(Command.APPEND_QUEUE_TIME, "qt", null));
        this.f4129e.add(new Command(Command.APPEND_CACHE_BUSTER, "z", null));
        this.f4130f = new MetaModel();
        MetaModelInitializer.m5769a(this.f4130f);
    }

    public void m5722a(Map hit) {
        Map hitCopy = new HashMap(hit);
        long hitTime = System.currentTimeMillis();
        hitCopy.put("hitTime", Long.toString(hitTime));
        m5695a(new C13211(this, hitCopy, hitTime));
    }

    private String m5701b(Map hit) {
        String hitUrl = (String) hit.get("internalHitUrl");
        if (hitUrl != null) {
            return hitUrl;
        }
        if (hit.containsKey("useSecure")) {
            return Utils.m5846c((String) hit.get("useSecure")) ? "https://ssl.google-analytics.com/collect" : "http://www.google-analytics.com/collect";
        } else {
            return "https://ssl.google-analytics.com/collect";
        }
    }

    private void m5706c(Map hit) {
        String rawExceptionString = (String) hit.get("rawException");
        if (rawExceptionString != null) {
            hit.remove("rawException");
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(Utils.m5848e(rawExceptionString)));
                Object readObject = objectInputStream.readObject();
                objectInputStream.close();
                if (readObject instanceof Throwable) {
                    Throwable exception = (Throwable) readObject;
                    hit.put("exDescription", new StandardExceptionParser(this.f4134k, new ArrayList()).m5637a((String) hit.get("exceptionThreadName"), exception));
                }
            } catch (IOException e) {
                Log.m5758h("IOException reading exception");
            } catch (ClassNotFoundException e2) {
                Log.m5758h("ClassNotFoundException reading exception");
            }
        }
    }

    private boolean m5709d(Map hit) {
        if (hit.get(GoogleAnalyticsWrapper.PROPERTY_SAMPLE_RATE) != null) {
            double sampleRate = Utils.m5845b((String) hit.get(GoogleAnalyticsWrapper.PROPERTY_SAMPLE_RATE));
            if (sampleRate <= 0.0d) {
                return true;
            }
            if (sampleRate < 100.0d) {
                String clientId = (String) hit.get("clientId");
                if (clientId != null && ((double) (Math.abs(clientId.hashCode()) % CustomEventBannerAdapter.DEFAULT_BANNER_TIMEOUT_DELAY)) >= 100.0d * sampleRate) {
                    return true;
                }
            }
        }
        return false;
    }

    private void m5713e(Map hit) {
        PackageManager pm = this.f4134k.getPackageManager();
        String appId = this.f4134k.getPackageName();
        String appInstallerId = pm.getInstallerPackageName(appId);
        String appName = appId;
        String appVersion = null;
        try {
            PackageInfo packageInfo = pm.getPackageInfo(this.f4134k.getPackageName(), 0);
            if (packageInfo != null) {
                appName = pm.getApplicationLabel(packageInfo.applicationInfo).toString();
                appVersion = packageInfo.versionName;
            }
        } catch (NameNotFoundException e) {
            Log.m5753c("Error retrieving package info: appName set to " + appName);
        }
        m5696a(hit, "appName", appName);
        m5696a(hit, "appVersion", appVersion);
        m5696a(hit, "appId", appId);
        m5696a(hit, "appInstallerId", appInstallerId);
        hit.put("apiVersion", "1");
    }

    private void m5696a(Map hit, String key, String value) {
        if (!hit.containsKey(key)) {
            hit.put(key, value);
        }
    }

    private void m5715f(Map hit) {
        String campaign = Utils.m5847d((String) hit.get("campaign"));
        if (!TextUtils.isEmpty(campaign)) {
            Map paramsMap = Utils.m5844a(campaign);
            hit.put("campaignContent", paramsMap.get("utm_content"));
            hit.put("campaignMedium", paramsMap.get("utm_medium"));
            hit.put("campaignName", paramsMap.get("utm_campaign"));
            hit.put("campaignSource", paramsMap.get("utm_source"));
            hit.put("campaignKeyword", paramsMap.get("utm_term"));
            hit.put("campaignId", paramsMap.get("utm_id"));
            hit.put("gclid", paramsMap.get("gclid"));
            hit.put("dclid", paramsMap.get("dclid"));
            hit.put("gmob_t", paramsMap.get("gmob_t"));
        }
    }

    public void m5719a() {
        m5695a(new C13222(this));
    }

    public void m5721a(AppOptOutCallback callback) {
        m5695a(new C13244(this, callback));
    }

    public void m5720a(ClientIdCallback callback) {
        m5695a(new C13255(this, callback));
    }

    private void m5695a(Runnable r) {
        this.f4125a.add(r);
    }

    private boolean m5716f() {
        return this.f4134k.getFileStreamPath("gaOptOut").exists();
    }

    private boolean m5699a(String clientId) {
        try {
            FileOutputStream fos = this.f4134k.openFileOutput("gaClientId", 0);
            fos.write(clientId.getBytes());
            fos.close();
            return true;
        } catch (FileNotFoundException e) {
            Log.m5753c("Error creating clientId file.");
            return false;
        } catch (IOException e2) {
            Log.m5753c("Error writing to clientId file.");
            return false;
        }
    }

    private String m5718g() {
        String result = UUID.randomUUID().toString().toLowerCase();
        if (m5699a(result)) {
            return result;
        }
        return ITKSvc.CODEREVISION;
    }

    @VisibleForTesting
    String m5725d() {
        String rslt = null;
        try {
            FileInputStream input = this.f4134k.openFileInput("gaClientId");
            byte[] bytes = new byte[Cast.MAX_NAMESPACE_LENGTH];
            int readLen = input.read(bytes, 0, Cast.MAX_NAMESPACE_LENGTH);
            if (input.available() > 0) {
                Log.m5753c("clientId file seems corrupted, deleting it.");
                input.close();
                this.f4134k.deleteFile("gaInstallData");
            }
            if (readLen <= 0) {
                Log.m5753c("clientId file seems empty, deleting it.");
                input.close();
                this.f4134k.deleteFile("gaInstallData");
            } else {
                String rslt2 = new String(bytes, 0, readLen);
                try {
                    input.close();
                    rslt = rslt2;
                } catch (FileNotFoundException e) {
                    rslt = rslt2;
                } catch (IOException e2) {
                    rslt = rslt2;
                    Log.m5753c("Error reading clientId file, deleting it.");
                    this.f4134k.deleteFile("gaInstallData");
                } catch (NumberFormatException e3) {
                    rslt = rslt2;
                    Log.m5753c("cliendId file doesn't have long value, deleting it.");
                    this.f4134k.deleteFile("gaInstallData");
                }
            }
        } catch (FileNotFoundException e4) {
        } catch (IOException e5) {
            Log.m5753c("Error reading clientId file, deleting it.");
            this.f4134k.deleteFile("gaInstallData");
        } catch (NumberFormatException e6) {
            Log.m5753c("cliendId file doesn't have long value, deleting it.");
            this.f4134k.deleteFile("gaInstallData");
        }
        if (rslt == null) {
            return m5718g();
        }
        return rslt;
    }

    @VisibleForTesting
    static String m5700b(Context context) {
        try {
            FileInputStream input = context.openFileInput("gaInstallData");
            byte[] inputBytes = new byte[HttpClientFactory.SOCKET_SIZE];
            int readLen = input.read(inputBytes, 0, HttpClientFactory.SOCKET_SIZE);
            if (input.available() > 0) {
                Log.m5753c("Too much campaign data, ignoring it.");
                input.close();
                context.deleteFile("gaInstallData");
                return null;
            }
            input.close();
            context.deleteFile("gaInstallData");
            if (readLen <= 0) {
                Log.m5758h("Campaign file is empty.");
                return null;
            }
            String campaignString = new String(inputBytes, 0, readLen);
            Log.m5754d("Campaign found: " + campaignString);
            return campaignString;
        } catch (FileNotFoundException e) {
            Log.m5754d("No campaign data found.");
            return null;
        } catch (IOException e2) {
            Log.m5753c("Error reading campaign data.");
            context.deleteFile("gaInstallData");
            return null;
        }
    }

    private String m5694a(Throwable t) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(baos);
        t.printStackTrace(stream);
        stream.flush();
        return new String(baos.toByteArray());
    }

    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Log.m5758h("sleep interrupted in GAThread initialize");
        }
        if (this.f4133j == null) {
            this.f4133j = new GAServiceProxy(this.f4134k, this);
        }
        m5712e();
        try {
            this.f4128d = m5716f();
            this.f4132h = m5725d();
            this.f4131g = m5700b(this.f4134k);
        } catch (Throwable t) {
            Log.m5753c("Error initializing the GAThread: " + m5694a(t));
            Log.m5753c("Google Analytics will not start up.");
            this.f4126b = true;
        }
        while (!this.f4127c) {
            try {
                Runnable r = (Runnable) this.f4125a.take();
                if (!this.f4126b) {
                    r.run();
                }
            } catch (InterruptedException e2) {
                Log.m5754d(e2.toString());
            } catch (Throwable t2) {
                Log.m5753c("Error on GAThread: " + m5694a(t2));
                Log.m5753c("Google Analytics is shutting down.");
                this.f4126b = true;
            }
        }
    }

    public LinkedBlockingQueue m5723b() {
        return this.f4125a;
    }

    public Thread m5724c() {
        return this;
    }
}
