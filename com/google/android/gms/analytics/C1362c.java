package com.google.android.gms.analytics;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.eg;
import com.google.android.gms.internal.eg.C1845a;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.analytics.c */
class C1362c implements C1358b {
    private Context mContext;
    private ServiceConnection sj;
    private C1360b sk;
    private C1361c sl;
    private eg sm;

    /* renamed from: com.google.android.gms.analytics.c.a */
    final class C1359a implements ServiceConnection {
        final /* synthetic */ C1362c sn;

        C1359a(C1362c c1362c) {
            this.sn = c1362c;
        }

        public void onServiceConnected(ComponentName component, IBinder binder) {
            aa.m5915y("service connected, binder: " + binder);
            try {
                if ("com.google.android.gms.analytics.internal.IAnalyticsService".equals(binder.getInterfaceDescriptor())) {
                    aa.m5915y("bound to service");
                    this.sn.sm = C1845a.m8260t(binder);
                    this.sn.bU();
                    return;
                }
            } catch (RemoteException e) {
            }
            this.sn.mContext.unbindService(this);
            this.sn.sj = null;
            this.sn.sl.m5969a(2, null);
        }

        public void onServiceDisconnected(ComponentName component) {
            aa.m5915y("service disconnected: " + component);
            this.sn.sj = null;
            this.sn.sk.onDisconnected();
        }
    }

    /* renamed from: com.google.android.gms.analytics.c.b */
    public interface C1360b {
        void onConnected();

        void onDisconnected();
    }

    /* renamed from: com.google.android.gms.analytics.c.c */
    public interface C1361c {
        void m5969a(int i, Intent intent);
    }

    public C1362c(Context context, C1360b c1360b, C1361c c1361c) {
        this.mContext = context;
        if (c1360b == null) {
            throw new IllegalArgumentException("onConnectedListener cannot be null");
        }
        this.sk = c1360b;
        if (c1361c == null) {
            throw new IllegalArgumentException("onConnectionFailedListener cannot be null");
        }
        this.sl = c1361c;
    }

    private eg bS() {
        bT();
        return this.sm;
    }

    private void bU() {
        bV();
    }

    private void bV() {
        this.sk.onConnected();
    }

    public void m5976a(Map map, long j, String str, List list) {
        try {
            bS().m8258a(map, j, str, list);
        } catch (RemoteException e) {
            aa.m5913w("sendHit failed: " + e);
        }
    }

    public void bR() {
        try {
            bS().bR();
        } catch (RemoteException e) {
            aa.m5913w("clear hits failed: " + e);
        }
    }

    protected void bT() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public void connect() {
        Intent intent = new Intent("com.google.android.gms.analytics.service.START");
        intent.setComponent(new ComponentName(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE, "com.google.android.gms.analytics.service.AnalyticsService"));
        intent.putExtra("app_package_name", this.mContext.getPackageName());
        if (this.sj != null) {
            aa.m5913w("Calling connect() while still connected, missing disconnect().");
            return;
        }
        this.sj = new C1359a(this);
        boolean bindService = this.mContext.bindService(intent, this.sj, 129);
        aa.m5915y("connect: bindService returned " + bindService + " for " + intent);
        if (!bindService) {
            this.sj = null;
            this.sl.m5969a(1, null);
        }
    }

    public void disconnect() {
        this.sm = null;
        if (this.sj != null) {
            try {
                this.mContext.unbindService(this.sj);
            } catch (IllegalStateException e) {
            } catch (IllegalArgumentException e2) {
            }
            this.sj = null;
            this.sk.onDisconnected();
        }
    }

    public boolean isConnected() {
        return this.sm != null;
    }
}
