package com.google.android.gms.analytics;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.C1362c.C1360b;
import com.google.android.gms.analytics.C1362c.C1361c;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentLinkedQueue;

/* renamed from: com.google.android.gms.analytics.s */
class C1384s implements ag, C1360b, C1361c {
    private final Context mContext;
    private C1352d sG;
    private final C1364f sH;
    private boolean sJ;
    private volatile long sT;
    private volatile C1379a sU;
    private volatile C1358b sV;
    private C1352d sW;
    private final GoogleAnalytics sX;
    private final Queue sY;
    private volatile int sZ;
    private volatile Timer ta;
    private volatile Timer tb;
    private volatile Timer tc;
    private boolean td;
    private boolean te;
    private boolean tf;
    private C1344i tg;
    private long th;

    /* renamed from: com.google.android.gms.analytics.s.1 */
    class C13761 implements C1344i {
        final /* synthetic */ C1384s ti;

        C13761(C1384s c1384s) {
            this.ti = c1384s;
        }

        public long currentTimeMillis() {
            return System.currentTimeMillis();
        }
    }

    /* renamed from: com.google.android.gms.analytics.s.2 */
    class C13772 implements Runnable {
        final /* synthetic */ C1384s ti;

        C13772(C1384s c1384s) {
            this.ti = c1384s;
        }

        public void run() {
            this.ti.cq();
        }
    }

    /* renamed from: com.google.android.gms.analytics.s.3 */
    static /* synthetic */ class C13783 {
        static final /* synthetic */ int[] tj;

        static {
            tj = new int[C1379a.values().length];
            try {
                tj[C1379a.CONNECTED_LOCAL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                tj[C1379a.CONNECTED_SERVICE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                tj[C1379a.CONNECTING.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                tj[C1379a.PENDING_CONNECTION.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                tj[C1379a.PENDING_DISCONNECT.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                tj[C1379a.DISCONNECTED.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    /* renamed from: com.google.android.gms.analytics.s.a */
    private enum C1379a {
        CONNECTING,
        CONNECTED_SERVICE,
        CONNECTED_LOCAL,
        BLOCKED,
        PENDING_CONNECTION,
        PENDING_DISCONNECT,
        DISCONNECTED
    }

    /* renamed from: com.google.android.gms.analytics.s.b */
    private class C1380b extends TimerTask {
        final /* synthetic */ C1384s ti;

        private C1380b(C1384s c1384s) {
            this.ti = c1384s;
        }

        public void run() {
            if (this.ti.sU == C1379a.CONNECTED_SERVICE && this.ti.sY.isEmpty() && this.ti.sT + this.ti.th < this.ti.tg.currentTimeMillis()) {
                aa.m5915y("Disconnecting due to inactivity");
                this.ti.be();
                return;
            }
            this.ti.tc.schedule(new C1380b(this.ti), this.ti.th);
        }
    }

    /* renamed from: com.google.android.gms.analytics.s.c */
    private class C1381c extends TimerTask {
        final /* synthetic */ C1384s ti;

        private C1381c(C1384s c1384s) {
            this.ti = c1384s;
        }

        public void run() {
            if (this.ti.sU == C1379a.CONNECTING) {
                this.ti.cs();
            }
        }
    }

    /* renamed from: com.google.android.gms.analytics.s.d */
    private static class C1382d {
        private final Map ts;
        private final long tt;
        private final String tu;
        private final List tv;

        public C1382d(Map map, long j, String str, List list) {
            this.ts = map;
            this.tt = j;
            this.tu = str;
            this.tv = list;
        }

        public Map cv() {
            return this.ts;
        }

        public long cw() {
            return this.tt;
        }

        public List cx() {
            return this.tv;
        }

        public String getPath() {
            return this.tu;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("PATH: ");
            stringBuilder.append(this.tu);
            if (this.ts != null) {
                stringBuilder.append("  PARAMS: ");
                for (Entry entry : this.ts.entrySet()) {
                    stringBuilder.append((String) entry.getKey());
                    stringBuilder.append("=");
                    stringBuilder.append((String) entry.getValue());
                    stringBuilder.append(",  ");
                }
            }
            return stringBuilder.toString();
        }
    }

    /* renamed from: com.google.android.gms.analytics.s.e */
    private class C1383e extends TimerTask {
        final /* synthetic */ C1384s ti;

        private C1383e(C1384s c1384s) {
            this.ti = c1384s;
        }

        public void run() {
            this.ti.ct();
        }
    }

    C1384s(Context context, C1364f c1364f) {
        this(context, c1364f, null, GoogleAnalytics.getInstance(context));
    }

    C1384s(Context context, C1364f c1364f, C1352d c1352d, GoogleAnalytics googleAnalytics) {
        this.sY = new ConcurrentLinkedQueue();
        this.th = 300000;
        this.sW = c1352d;
        this.mContext = context;
        this.sH = c1364f;
        this.sX = googleAnalytics;
        this.tg = new C13761(this);
        this.sZ = 0;
        this.sU = C1379a.DISCONNECTED;
    }

    private Timer m6002a(Timer timer) {
        if (timer != null) {
            timer.cancel();
        }
        return null;
    }

    private synchronized void be() {
        if (this.sV != null && this.sU == C1379a.CONNECTED_SERVICE) {
            this.sU = C1379a.PENDING_DISCONNECT;
            this.sV.disconnect();
        }
    }

    private void co() {
        this.ta = m6002a(this.ta);
        this.tb = m6002a(this.tb);
        this.tc = m6002a(this.tc);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void cq() {
        /*
        r8 = this;
        monitor-enter(r8);
        r2 = java.lang.Thread.currentThread();	 Catch:{ all -> 0x0074 }
        r3 = r8.sH;	 Catch:{ all -> 0x0074 }
        r3 = r3.getThread();	 Catch:{ all -> 0x0074 }
        r2 = r2.equals(r3);	 Catch:{ all -> 0x0074 }
        if (r2 != 0) goto L_0x0021;
    L_0x0011:
        r2 = r8.sH;	 Catch:{ all -> 0x0074 }
        r2 = r2.bZ();	 Catch:{ all -> 0x0074 }
        r3 = new com.google.android.gms.analytics.s$2;	 Catch:{ all -> 0x0074 }
        r3.<init>(r8);	 Catch:{ all -> 0x0074 }
        r2.add(r3);	 Catch:{ all -> 0x0074 }
    L_0x001f:
        monitor-exit(r8);
        return;
    L_0x0021:
        r2 = r8.td;	 Catch:{ all -> 0x0074 }
        if (r2 == 0) goto L_0x0028;
    L_0x0025:
        r8.bR();	 Catch:{ all -> 0x0074 }
    L_0x0028:
        r2 = com.google.android.gms.analytics.C1384s.C13783.tj;	 Catch:{ all -> 0x0074 }
        r3 = r8.sU;	 Catch:{ all -> 0x0074 }
        r3 = r3.ordinal();	 Catch:{ all -> 0x0074 }
        r2 = r2[r3];	 Catch:{ all -> 0x0074 }
        switch(r2) {
            case 1: goto L_0x0036;
            case 2: goto L_0x007f;
            case 3: goto L_0x0035;
            case 4: goto L_0x0035;
            case 5: goto L_0x0035;
            case 6: goto L_0x00da;
            default: goto L_0x0035;
        };	 Catch:{ all -> 0x0074 }
    L_0x0035:
        goto L_0x001f;
    L_0x0036:
        r2 = r8.sY;	 Catch:{ all -> 0x0074 }
        r2 = r2.isEmpty();	 Catch:{ all -> 0x0074 }
        if (r2 != 0) goto L_0x0077;
    L_0x003e:
        r2 = r8.sY;	 Catch:{ all -> 0x0074 }
        r2 = r2.poll();	 Catch:{ all -> 0x0074 }
        r0 = r2;
        r0 = (com.google.android.gms.analytics.C1384s.C1382d) r0;	 Catch:{ all -> 0x0074 }
        r7 = r0;
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0074 }
        r2.<init>();	 Catch:{ all -> 0x0074 }
        r3 = "Sending hit to store  ";
        r2 = r2.append(r3);	 Catch:{ all -> 0x0074 }
        r2 = r2.append(r7);	 Catch:{ all -> 0x0074 }
        r2 = r2.toString();	 Catch:{ all -> 0x0074 }
        com.google.android.gms.analytics.aa.m5915y(r2);	 Catch:{ all -> 0x0074 }
        r2 = r8.sG;	 Catch:{ all -> 0x0074 }
        r3 = r7.cv();	 Catch:{ all -> 0x0074 }
        r4 = r7.cw();	 Catch:{ all -> 0x0074 }
        r6 = r7.getPath();	 Catch:{ all -> 0x0074 }
        r7 = r7.cx();	 Catch:{ all -> 0x0074 }
        r2.m5920a(r3, r4, r6, r7);	 Catch:{ all -> 0x0074 }
        goto L_0x0036;
    L_0x0074:
        r2 = move-exception;
        monitor-exit(r8);
        throw r2;
    L_0x0077:
        r2 = r8.sJ;	 Catch:{ all -> 0x0074 }
        if (r2 == 0) goto L_0x001f;
    L_0x007b:
        r8.cr();	 Catch:{ all -> 0x0074 }
        goto L_0x001f;
    L_0x007f:
        r2 = r8.sY;	 Catch:{ all -> 0x0074 }
        r2 = r2.isEmpty();	 Catch:{ all -> 0x0074 }
        if (r2 != 0) goto L_0x00d0;
    L_0x0087:
        r2 = r8.sY;	 Catch:{ all -> 0x0074 }
        r2 = r2.peek();	 Catch:{ all -> 0x0074 }
        r0 = r2;
        r0 = (com.google.android.gms.analytics.C1384s.C1382d) r0;	 Catch:{ all -> 0x0074 }
        r7 = r0;
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0074 }
        r2.<init>();	 Catch:{ all -> 0x0074 }
        r3 = "Sending hit to service   ";
        r2 = r2.append(r3);	 Catch:{ all -> 0x0074 }
        r2 = r2.append(r7);	 Catch:{ all -> 0x0074 }
        r2 = r2.toString();	 Catch:{ all -> 0x0074 }
        com.google.android.gms.analytics.aa.m5915y(r2);	 Catch:{ all -> 0x0074 }
        r2 = r8.sX;	 Catch:{ all -> 0x0074 }
        r2 = r2.isDryRunEnabled();	 Catch:{ all -> 0x0074 }
        if (r2 != 0) goto L_0x00ca;
    L_0x00af:
        r2 = r8.sV;	 Catch:{ all -> 0x0074 }
        r3 = r7.cv();	 Catch:{ all -> 0x0074 }
        r4 = r7.cw();	 Catch:{ all -> 0x0074 }
        r6 = r7.getPath();	 Catch:{ all -> 0x0074 }
        r7 = r7.cx();	 Catch:{ all -> 0x0074 }
        r2.m5968a(r3, r4, r6, r7);	 Catch:{ all -> 0x0074 }
    L_0x00c4:
        r2 = r8.sY;	 Catch:{ all -> 0x0074 }
        r2.poll();	 Catch:{ all -> 0x0074 }
        goto L_0x007f;
    L_0x00ca:
        r2 = "Dry run enabled. Hit not actually sent to service.";
        com.google.android.gms.analytics.aa.m5915y(r2);	 Catch:{ all -> 0x0074 }
        goto L_0x00c4;
    L_0x00d0:
        r2 = r8.tg;	 Catch:{ all -> 0x0074 }
        r2 = r2.currentTimeMillis();	 Catch:{ all -> 0x0074 }
        r8.sT = r2;	 Catch:{ all -> 0x0074 }
        goto L_0x001f;
    L_0x00da:
        r2 = "Need to reconnect";
        com.google.android.gms.analytics.aa.m5915y(r2);	 Catch:{ all -> 0x0074 }
        r2 = r8.sY;	 Catch:{ all -> 0x0074 }
        r2 = r2.isEmpty();	 Catch:{ all -> 0x0074 }
        if (r2 != 0) goto L_0x001f;
    L_0x00e7:
        r8.ct();	 Catch:{ all -> 0x0074 }
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.s.cq():void");
    }

    private void cr() {
        this.sG.bW();
        this.sJ = false;
    }

    private synchronized void cs() {
        if (this.sU != C1379a.CONNECTED_LOCAL) {
            co();
            aa.m5915y("falling back to local store");
            if (this.sW != null) {
                this.sG = this.sW;
            } else {
                C1375r ci = C1375r.ci();
                ci.m5999a(this.mContext, this.sH);
                this.sG = ci.cl();
            }
            this.sU = C1379a.CONNECTED_LOCAL;
            cq();
        }
    }

    private synchronized void ct() {
        if (this.tf || this.sV == null || this.sU == C1379a.CONNECTED_LOCAL) {
            aa.m5916z("client not initialized.");
            cs();
        } else {
            try {
                this.sZ++;
                m6002a(this.tb);
                this.sU = C1379a.CONNECTING;
                this.tb = new Timer("Failed Connect");
                this.tb.schedule(new C1381c(), 3000);
                aa.m5915y("connecting to Analytics service");
                this.sV.connect();
            } catch (SecurityException e) {
                aa.m5916z("security exception on connectToService");
                cs();
            }
        }
    }

    private void cu() {
        this.ta = m6002a(this.ta);
        this.ta = new Timer("Service Reconnect");
        this.ta.schedule(new C1383e(), 5000);
    }

    public synchronized void m6013a(int i, Intent intent) {
        this.sU = C1379a.PENDING_CONNECTION;
        if (this.sZ < 2) {
            aa.m5916z("Service unavailable (code=" + i + "), will retry.");
            cu();
        } else {
            aa.m5916z("Service unavailable (code=" + i + "), using local store.");
            cs();
        }
    }

    public void m6014b(Map map, long j, String str, List list) {
        aa.m5915y("putHit called");
        this.sY.add(new C1382d(map, j, str, list));
        cq();
    }

    public void bR() {
        aa.m5915y("clearHits called");
        this.sY.clear();
        switch (C13783.tj[this.sU.ordinal()]) {
            case Base64.NO_PADDING /*1*/:
                this.sG.m5921j(0);
                this.td = false;
            case Base64.NO_WRAP /*2*/:
                this.sV.bR();
                this.td = false;
            default:
                this.td = true;
        }
    }

    public void bW() {
        switch (C13783.tj[this.sU.ordinal()]) {
            case Base64.NO_PADDING /*1*/:
                cr();
            case Base64.NO_WRAP /*2*/:
            default:
                this.sJ = true;
        }
    }

    public synchronized void bY() {
        if (!this.tf) {
            aa.m5915y("setForceLocalDispatch called.");
            this.tf = true;
            switch (C13783.tj[this.sU.ordinal()]) {
                case Base64.NO_PADDING /*1*/:
                case Base64.CRLF /*4*/:
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                    break;
                case Base64.NO_WRAP /*2*/:
                    be();
                    break;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    this.te = true;
                    break;
                default:
                    break;
            }
        }
    }

    public void cp() {
        if (this.sV == null) {
            this.sV = new C1362c(this.mContext, this, this);
            ct();
        }
    }

    public synchronized void onConnected() {
        this.tb = m6002a(this.tb);
        this.sZ = 0;
        aa.m5915y("Connected to service");
        this.sU = C1379a.CONNECTED_SERVICE;
        if (this.te) {
            be();
            this.te = false;
        } else {
            cq();
            this.tc = m6002a(this.tc);
            this.tc = new Timer("disconnect check");
            this.tc.schedule(new C1380b(), this.th);
        }
    }

    public synchronized void onDisconnected() {
        if (this.sU == C1379a.PENDING_DISCONNECT) {
            aa.m5915y("Disconnected from service");
            co();
            this.sU = C1379a.DISCONNECTED;
        } else {
            aa.m5915y("Unexpected disconnect.");
            this.sU = C1379a.PENDING_CONNECTION;
            if (this.sZ < 2) {
                cu();
            } else {
                cs();
            }
        }
    }
}
