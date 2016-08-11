package com.google.analytics.tracking.android;

import android.content.Context;
import android.content.Intent;
import com.google.analytics.tracking.android.AnalyticsGmsCoreClient.OnConnectedListener;
import com.google.analytics.tracking.android.AnalyticsGmsCoreClient.OnConnectionFailedListener;
import com.mopub.mobileads.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentLinkedQueue;

class GAServiceProxy implements OnConnectedListener, OnConnectionFailedListener, ServiceProxy {
    private volatile long f4098a;
    private volatile ConnectState f4099b;
    private volatile AnalyticsClient f4100c;
    private AnalyticsStore f4101d;
    private AnalyticsStore f4102e;
    private final AnalyticsThread f4103f;
    private final Context f4104g;
    private final Queue f4105h;
    private volatile int f4106i;
    private volatile Timer f4107j;
    private volatile Timer f4108k;
    private volatile Timer f4109l;
    private boolean f4110m;
    private boolean f4111n;
    private Clock f4112o;
    private long f4113p;

    /* renamed from: com.google.analytics.tracking.android.GAServiceProxy.1 */
    class C13181 implements Clock {
        final /* synthetic */ GAServiceProxy f4080a;

        C13181(GAServiceProxy gAServiceProxy) {
            this.f4080a = gAServiceProxy;
        }

        public long m5657a() {
            return System.currentTimeMillis();
        }
    }

    /* renamed from: com.google.analytics.tracking.android.GAServiceProxy.2 */
    class C13192 implements Runnable {
        final /* synthetic */ GAServiceProxy f4081a;

        C13192(GAServiceProxy gAServiceProxy) {
            this.f4081a = gAServiceProxy;
        }

        public void run() {
            this.f4081a.m5675g();
        }
    }

    /* renamed from: com.google.analytics.tracking.android.GAServiceProxy.3 */
    static /* synthetic */ class C13203 {
        static final /* synthetic */ int[] f4082a;

        static {
            f4082a = new int[ConnectState.values().length];
            try {
                f4082a[ConnectState.CONNECTED_LOCAL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f4082a[ConnectState.CONNECTED_SERVICE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f4082a[ConnectState.DISCONNECTED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    private enum ConnectState {
        CONNECTING,
        CONNECTED_SERVICE,
        CONNECTED_LOCAL,
        BLOCKED,
        PENDING_CONNECTION,
        PENDING_DISCONNECT,
        DISCONNECTED
    }

    private class DisconnectCheckTask extends TimerTask {
        final /* synthetic */ GAServiceProxy f4091a;

        private DisconnectCheckTask(GAServiceProxy gAServiceProxy) {
            this.f4091a = gAServiceProxy;
        }

        public void run() {
            if (this.f4091a.f4099b == ConnectState.CONNECTED_SERVICE && this.f4091a.f4105h.isEmpty() && this.f4091a.f4098a + this.f4091a.f4113p < this.f4091a.f4112o.m5593a()) {
                Log.m5755e("Disconnecting due to inactivity");
                this.f4091a.m5682k();
                return;
            }
            this.f4091a.f4109l.schedule(new DisconnectCheckTask(this.f4091a), this.f4091a.f4113p);
        }
    }

    private class FailedConnectTask extends TimerTask {
        final /* synthetic */ GAServiceProxy f4092a;

        private FailedConnectTask(GAServiceProxy gAServiceProxy) {
            this.f4092a = gAServiceProxy;
        }

        public void run() {
            if (this.f4092a.f4099b == ConnectState.CONNECTING) {
                this.f4092a.m5678i();
            }
        }
    }

    private static class HitParams {
        private final Map f4093a;
        private final long f4094b;
        private final String f4095c;
        private final List f4096d;

        public HitParams(Map wireFormatParams, long hitTimeInMilliseconds, String path, List commands) {
            this.f4093a = wireFormatParams;
            this.f4094b = hitTimeInMilliseconds;
            this.f4095c = path;
            this.f4096d = commands;
        }

        public Map m5658a() {
            return this.f4093a;
        }

        public long m5659b() {
            return this.f4094b;
        }

        public String m5660c() {
            return this.f4095c;
        }

        public List m5661d() {
            return this.f4096d;
        }
    }

    private class ReconnectTask extends TimerTask {
        final /* synthetic */ GAServiceProxy f4097a;

        private ReconnectTask(GAServiceProxy gAServiceProxy) {
            this.f4097a = gAServiceProxy;
        }

        public void run() {
            this.f4097a.m5681j();
        }
    }

    GAServiceProxy(Context ctx, AnalyticsThread thread, AnalyticsStore store) {
        this.f4105h = new ConcurrentLinkedQueue();
        this.f4113p = 300000;
        this.f4102e = store;
        this.f4104g = ctx;
        this.f4103f = thread;
        this.f4112o = new C13181(this);
        this.f4106i = 0;
        this.f4099b = ConnectState.DISCONNECTED;
    }

    GAServiceProxy(Context ctx, AnalyticsThread thread) {
        this(ctx, thread, null);
    }

    public void m5686a(Map wireFormatParams, long hitTimeInMilliseconds, String path, List commands) {
        Log.m5755e("putHit called");
        this.f4105h.add(new HitParams(wireFormatParams, hitTimeInMilliseconds, path, commands));
        m5675g();
    }

    public void m5688c() {
        switch (C13203.f4082a[this.f4099b.ordinal()]) {
            case Base64.NO_PADDING /*1*/:
                m5677h();
            case Base64.NO_WRAP /*2*/:
            default:
                this.f4110m = true;
        }
    }

    public void m5689d() {
        Log.m5755e("clearHits called");
        this.f4105h.clear();
        switch (C13203.f4082a[this.f4099b.ordinal()]) {
            case Base64.NO_PADDING /*1*/:
                this.f4101d.m5583a(0);
                this.f4111n = false;
            case Base64.NO_WRAP /*2*/:
                this.f4100c.m5560a();
                this.f4111n = false;
            default:
                this.f4111n = true;
        }
    }

    private Timer m5666a(Timer timer) {
        if (timer != null) {
            timer.cancel();
        }
        return null;
    }

    private void m5673f() {
        this.f4107j = m5666a(this.f4107j);
        this.f4108k = m5666a(this.f4108k);
        this.f4109l = m5666a(this.f4109l);
    }

    public void m5690e() {
        if (this.f4100c == null) {
            this.f4100c = new AnalyticsGmsCoreClient(this.f4104g, this, this);
            m5681j();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void m5675g() {
        /*
        r7 = this;
        monitor-enter(r7);
        r0 = java.lang.Thread.currentThread();	 Catch:{ all -> 0x0061 }
        r1 = r7.f4103f;	 Catch:{ all -> 0x0061 }
        r1 = r1.m5592c();	 Catch:{ all -> 0x0061 }
        r0 = r0.equals(r1);	 Catch:{ all -> 0x0061 }
        if (r0 != 0) goto L_0x0021;
    L_0x0011:
        r0 = r7.f4103f;	 Catch:{ all -> 0x0061 }
        r0 = r0.m5591b();	 Catch:{ all -> 0x0061 }
        r1 = new com.google.analytics.tracking.android.GAServiceProxy$2;	 Catch:{ all -> 0x0061 }
        r1.<init>(r7);	 Catch:{ all -> 0x0061 }
        r0.add(r1);	 Catch:{ all -> 0x0061 }
    L_0x001f:
        monitor-exit(r7);
        return;
    L_0x0021:
        r0 = r7.f4111n;	 Catch:{ all -> 0x0061 }
        if (r0 == 0) goto L_0x0028;
    L_0x0025:
        r7.m5689d();	 Catch:{ all -> 0x0061 }
    L_0x0028:
        r0 = com.google.analytics.tracking.android.GAServiceProxy.C13203.f4082a;	 Catch:{ all -> 0x0061 }
        r1 = r7.f4099b;	 Catch:{ all -> 0x0061 }
        r1 = r1.ordinal();	 Catch:{ all -> 0x0061 }
        r0 = r0[r1];	 Catch:{ all -> 0x0061 }
        switch(r0) {
            case 1: goto L_0x0036;
            case 2: goto L_0x006c;
            case 3: goto L_0x00a6;
            default: goto L_0x0035;
        };	 Catch:{ all -> 0x0061 }
    L_0x0035:
        goto L_0x001f;
    L_0x0036:
        r0 = r7.f4105h;	 Catch:{ all -> 0x0061 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x0061 }
        if (r0 != 0) goto L_0x0064;
    L_0x003e:
        r0 = r7.f4105h;	 Catch:{ all -> 0x0061 }
        r6 = r0.poll();	 Catch:{ all -> 0x0061 }
        r6 = (com.google.analytics.tracking.android.GAServiceProxy.HitParams) r6;	 Catch:{ all -> 0x0061 }
        r0 = "Sending hit to store";
        com.google.analytics.tracking.android.Log.m5755e(r0);	 Catch:{ all -> 0x0061 }
        r0 = r7.f4101d;	 Catch:{ all -> 0x0061 }
        r1 = r6.m5658a();	 Catch:{ all -> 0x0061 }
        r2 = r6.m5659b();	 Catch:{ all -> 0x0061 }
        r4 = r6.m5660c();	 Catch:{ all -> 0x0061 }
        r5 = r6.m5661d();	 Catch:{ all -> 0x0061 }
        r0.m5584a(r1, r2, r4, r5);	 Catch:{ all -> 0x0061 }
        goto L_0x0036;
    L_0x0061:
        r0 = move-exception;
        monitor-exit(r7);
        throw r0;
    L_0x0064:
        r0 = r7.f4110m;	 Catch:{ all -> 0x0061 }
        if (r0 == 0) goto L_0x001f;
    L_0x0068:
        r7.m5677h();	 Catch:{ all -> 0x0061 }
        goto L_0x001f;
    L_0x006c:
        r0 = r7.f4105h;	 Catch:{ all -> 0x0061 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x0061 }
        if (r0 != 0) goto L_0x009c;
    L_0x0074:
        r0 = r7.f4105h;	 Catch:{ all -> 0x0061 }
        r6 = r0.peek();	 Catch:{ all -> 0x0061 }
        r6 = (com.google.analytics.tracking.android.GAServiceProxy.HitParams) r6;	 Catch:{ all -> 0x0061 }
        r0 = "Sending hit to service";
        com.google.analytics.tracking.android.Log.m5755e(r0);	 Catch:{ all -> 0x0061 }
        r0 = r7.f4100c;	 Catch:{ all -> 0x0061 }
        r1 = r6.m5658a();	 Catch:{ all -> 0x0061 }
        r2 = r6.m5659b();	 Catch:{ all -> 0x0061 }
        r4 = r6.m5660c();	 Catch:{ all -> 0x0061 }
        r5 = r6.m5661d();	 Catch:{ all -> 0x0061 }
        r0.m5561a(r1, r2, r4, r5);	 Catch:{ all -> 0x0061 }
        r0 = r7.f4105h;	 Catch:{ all -> 0x0061 }
        r0.poll();	 Catch:{ all -> 0x0061 }
        goto L_0x006c;
    L_0x009c:
        r0 = r7.f4112o;	 Catch:{ all -> 0x0061 }
        r0 = r0.m5593a();	 Catch:{ all -> 0x0061 }
        r7.f4098a = r0;	 Catch:{ all -> 0x0061 }
        goto L_0x001f;
    L_0x00a6:
        r0 = "Need to reconnect";
        com.google.analytics.tracking.android.Log.m5755e(r0);	 Catch:{ all -> 0x0061 }
        r0 = r7.f4105h;	 Catch:{ all -> 0x0061 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x0061 }
        if (r0 != 0) goto L_0x001f;
    L_0x00b3:
        r7.m5681j();	 Catch:{ all -> 0x0061 }
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.analytics.tracking.android.GAServiceProxy.g():void");
    }

    private void m5677h() {
        this.f4101d.m5582a();
        this.f4110m = false;
    }

    private synchronized void m5678i() {
        if (this.f4099b != ConnectState.CONNECTED_LOCAL) {
            m5673f();
            Log.m5755e("falling back to local store");
            if (this.f4102e != null) {
                this.f4101d = this.f4102e;
            } else {
                GAServiceManager instance = GAServiceManager.m5643a();
                instance.m5652a(this.f4104g, this.f4103f);
                this.f4101d = instance.m5655b();
            }
            this.f4099b = ConnectState.CONNECTED_LOCAL;
            m5675g();
        }
    }

    private synchronized void m5681j() {
        if (this.f4100c == null || this.f4099b == ConnectState.CONNECTED_LOCAL) {
            Log.m5758h("client not initialized.");
            m5678i();
        } else {
            try {
                this.f4106i++;
                m5666a(this.f4108k);
                this.f4099b = ConnectState.CONNECTING;
                this.f4108k = new Timer("Failed Connect");
                this.f4108k.schedule(new FailedConnectTask(), 3000);
                Log.m5755e("connecting to Analytics service");
                this.f4100c.m5562b();
            } catch (SecurityException e) {
                Log.m5758h("security exception on connectToService");
                m5678i();
            }
        }
    }

    private synchronized void m5682k() {
        if (this.f4100c != null && this.f4099b == ConnectState.CONNECTED_SERVICE) {
            this.f4099b = ConnectState.PENDING_DISCONNECT;
            this.f4100c.m5563c();
        }
    }

    public synchronized void m5684a() {
        this.f4108k = m5666a(this.f4108k);
        this.f4106i = 0;
        Log.m5755e("Connected to service");
        this.f4099b = ConnectState.CONNECTED_SERVICE;
        m5675g();
        this.f4109l = m5666a(this.f4109l);
        this.f4109l = new Timer("disconnect check");
        this.f4109l.schedule(new DisconnectCheckTask(), this.f4113p);
    }

    public synchronized void m5687b() {
        if (this.f4099b == ConnectState.PENDING_DISCONNECT) {
            Log.m5755e("Disconnected from service");
            m5673f();
            this.f4099b = ConnectState.DISCONNECTED;
        } else {
            Log.m5755e("Unexpected disconnect.");
            this.f4099b = ConnectState.PENDING_CONNECTION;
            if (this.f4106i < 2) {
                m5683l();
            } else {
                m5678i();
            }
        }
    }

    public synchronized void m5685a(int errorCode, Intent resolution) {
        this.f4099b = ConnectState.PENDING_CONNECTION;
        if (this.f4106i < 2) {
            Log.m5758h("Service unavailable (code=" + errorCode + "), will retry.");
            m5683l();
        } else {
            Log.m5758h("Service unavailable (code=" + errorCode + "), using local store.");
            m5678i();
        }
    }

    private void m5683l() {
        this.f4107j = m5666a(this.f4107j);
        this.f4107j = new Timer("Service Reconnect");
        this.f4107j.schedule(new ReconnectTask(), 5000);
    }
}
