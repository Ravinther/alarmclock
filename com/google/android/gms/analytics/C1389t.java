package com.google.android.gms.analytics;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.Command;
import com.google.android.gms.internal.ef;
import com.mopub.mobileads.CustomEventBannerAdapter;
import com.mopub.mobileads.factories.HttpClientFactory;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: com.google.android.gms.analytics.t */
class C1389t extends Thread implements C1364f {
    private static C1389t tA;
    private volatile boolean mClosed;
    private final Context mContext;
    private volatile String su;
    private volatile ag tB;
    private final LinkedBlockingQueue tw;
    private volatile boolean tx;
    private volatile List ty;
    private volatile String tz;

    /* renamed from: com.google.android.gms.analytics.t.1 */
    class C13851 implements Runnable {
        final /* synthetic */ Map tC;
        final /* synthetic */ C1389t tD;

        C13851(C1389t c1389t, Map map) {
            this.tD = c1389t;
            this.tC = map;
        }

        public void run() {
            if (TextUtils.isEmpty((CharSequence) this.tC.get("&cid"))) {
                this.tC.put("&cid", this.tD.su);
            }
            if (!GoogleAnalytics.getInstance(this.tD.mContext).getAppOptOut() && !this.tD.m6030s(this.tC)) {
                if (!TextUtils.isEmpty(this.tD.tz)) {
                    C1391u.cy().m6036t(true);
                    this.tC.putAll(new HitBuilder().setCampaignParamsFromUrl(this.tD.tz).build());
                    C1391u.cy().m6036t(false);
                    this.tD.tz = null;
                }
                this.tD.m6032u(this.tC);
                this.tD.m6031t(this.tC);
                this.tD.tB.m5938b(C1396y.m6044v(this.tC), Long.valueOf((String) this.tC.get("&ht")).longValue(), this.tD.m6029r(this.tC), this.tD.ty);
            }
        }
    }

    /* renamed from: com.google.android.gms.analytics.t.2 */
    class C13862 implements Runnable {
        final /* synthetic */ C1389t tD;

        C13862(C1389t c1389t) {
            this.tD = c1389t;
        }

        public void run() {
            this.tD.tB.bW();
        }
    }

    /* renamed from: com.google.android.gms.analytics.t.3 */
    class C13873 implements Runnable {
        final /* synthetic */ C1389t tD;

        C13873(C1389t c1389t) {
            this.tD = c1389t;
        }

        public void run() {
            this.tD.tB.bR();
        }
    }

    /* renamed from: com.google.android.gms.analytics.t.4 */
    class C13884 implements Runnable {
        final /* synthetic */ C1389t tD;

        C13884(C1389t c1389t) {
            this.tD = c1389t;
        }

        public void run() {
            this.tD.tB.bY();
        }
    }

    private C1389t(Context context) {
        super("GAThread");
        this.tw = new LinkedBlockingQueue();
        this.tx = false;
        this.mClosed = false;
        if (context != null) {
            this.mContext = context.getApplicationContext();
        } else {
            this.mContext = context;
        }
        start();
    }

    static int m6015H(String str) {
        int i = 1;
        if (!TextUtils.isEmpty(str)) {
            i = 0;
            for (int length = str.length() - 1; length >= 0; length--) {
                char charAt = str.charAt(length);
                i = (((i << 6) & 268435455) + charAt) + (charAt << 14);
                int i2 = 266338304 & i;
                if (i2 != 0) {
                    i ^= i2 >> 21;
                }
            }
        }
        return i;
    }

    private String m6018a(Throwable th) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        th.printStackTrace(printStream);
        printStream.flush();
        return new String(byteArrayOutputStream.toByteArray());
    }

    static C1389t m6027q(Context context) {
        if (tA == null) {
            tA = new C1389t(context);
        }
        return tA;
    }

    static String m6028r(Context context) {
        try {
            FileInputStream openFileInput = context.openFileInput("gaInstallData");
            byte[] bArr = new byte[HttpClientFactory.SOCKET_SIZE];
            int read = openFileInput.read(bArr, 0, HttpClientFactory.SOCKET_SIZE);
            if (openFileInput.available() > 0) {
                aa.m5913w("Too much campaign data, ignoring it.");
                openFileInput.close();
                context.deleteFile("gaInstallData");
                return null;
            }
            openFileInput.close();
            context.deleteFile("gaInstallData");
            if (read <= 0) {
                aa.m5916z("Campaign file is empty.");
                return null;
            }
            String str = new String(bArr, 0, read);
            aa.m5914x("Campaign found: " + str);
            return str;
        } catch (FileNotFoundException e) {
            aa.m5914x("No campaign data found.");
            return null;
        } catch (IOException e2) {
            aa.m5913w("Error reading campaign data.");
            context.deleteFile("gaInstallData");
            return null;
        }
    }

    private String m6029r(Map map) {
        return map.containsKey("useSecure") ? ak.m5966d((String) map.get("useSecure"), true) ? "https:" : "http:" : "https:";
    }

    private boolean m6030s(Map map) {
        if (map.get("&sf") == null) {
            return false;
        }
        double a = ak.m5963a((String) map.get("&sf"), 100.0d);
        if (a >= 100.0d) {
            return false;
        }
        if (((double) (C1389t.m6015H((String) map.get("&cid")) % CustomEventBannerAdapter.DEFAULT_BANNER_TIMEOUT_DELAY)) < a * 100.0d) {
            return false;
        }
        String str = map.get("&t") == null ? "unknown" : (String) map.get("&t");
        aa.m5915y(String.format("%s hit sampled out", new Object[]{str}));
        return true;
    }

    private void m6031t(Map map) {
        C1348m m = C1349a.m5912m(this.mContext);
        ak.m5965a(map, "&adid", m.getValue("&adid"));
        ak.m5965a(map, "&ate", m.getValue("&ate"));
    }

    private void m6032u(Map map) {
        C1348m ca = C1365g.ca();
        ak.m5965a(map, "&an", ca.getValue("&an"));
        ak.m5965a(map, "&av", ca.getValue("&av"));
        ak.m5965a(map, "&aid", ca.getValue("&aid"));
        ak.m5965a(map, "&aiid", ca.getValue("&aiid"));
        map.put("&v", "1");
    }

    void m6033a(Runnable runnable) {
        this.tw.add(runnable);
    }

    public void bR() {
        m6033a(new C13873(this));
    }

    public void bW() {
        m6033a(new C13862(this));
    }

    public void bY() {
        m6033a(new C13884(this));
    }

    public LinkedBlockingQueue bZ() {
        return this.tw;
    }

    public Thread getThread() {
        return this;
    }

    protected void init() {
        this.tB.cp();
        this.ty = new ArrayList();
        this.ty.add(new ef(Command.APPEND_VERSION, "&_v".substring(1), "ma4.0.1"));
        this.ty.add(new ef(Command.APPEND_QUEUE_TIME, "&qt".substring(1), null));
        this.ty.add(new ef(Command.APPEND_CACHE_BUSTER, "&z".substring(1), null));
    }

    public void m6034q(Map map) {
        Map hashMap = new HashMap(map);
        String str = (String) map.get("&ht");
        if (str != null) {
            try {
                Long.valueOf(str);
            } catch (NumberFormatException e) {
                str = null;
            }
        }
        if (str == null) {
            hashMap.put("&ht", Long.toString(System.currentTimeMillis()));
        }
        m6033a(new C13851(this, hashMap));
    }

    public void run() {
        Process.setThreadPriority(10);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            aa.m5916z("sleep interrupted in GAThread initialize");
        }
        try {
            if (this.tB == null) {
                this.tB = new C1384s(this.mContext, this);
            }
            init();
            this.su = C1367h.cb().getValue("&cid");
            if (this.su == null) {
                this.tx = true;
            }
            this.tz = C1389t.m6028r(this.mContext);
            aa.m5915y("Initialized GA Thread");
        } catch (Throwable th) {
            aa.m5913w("Error initializing the GAThread: " + m6018a(th));
            aa.m5913w("Google Analytics will not start up.");
            this.tx = true;
        }
        while (!this.mClosed) {
            try {
                Runnable runnable = (Runnable) this.tw.take();
                if (!this.tx) {
                    runnable.run();
                }
            } catch (InterruptedException e2) {
                aa.m5914x(e2.toString());
            } catch (Throwable th2) {
                aa.m5913w("Error on GAThread: " + m6018a(th2));
                aa.m5913w("Google Analytics is shutting down.");
                this.tx = true;
            }
        }
    }
}
