package com.google.analytics.tracking.android;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.analytics.internal.IAnalyticsService;
import com.google.android.gms.analytics.internal.IAnalyticsService.Stub;
import java.util.List;
import java.util.Map;

class AnalyticsGmsCoreClient implements AnalyticsClient {
    private ServiceConnection f4036a;
    private OnConnectedListener f4037b;
    private OnConnectionFailedListener f4038c;
    private Context f4039d;
    private IAnalyticsService f4040e;

    final class AnalyticsServiceConnection implements ServiceConnection {
        final /* synthetic */ AnalyticsGmsCoreClient f4035a;

        AnalyticsServiceConnection(AnalyticsGmsCoreClient analyticsGmsCoreClient) {
            this.f4035a = analyticsGmsCoreClient;
        }

        public void onServiceConnected(ComponentName component, IBinder binder) {
            Log.m5752b("service connected, binder: " + binder);
            try {
                if ("com.google.android.gms.analytics.internal.IAnalyticsService".equals(binder.getInterfaceDescriptor())) {
                    Log.m5752b("bound to service");
                    this.f4035a.f4040e = Stub.asInterface(binder);
                    this.f4035a.m5574g();
                    return;
                }
            } catch (RemoteException e) {
            }
            this.f4035a.f4039d.unbindService(this);
            this.f4035a.f4036a = null;
            this.f4035a.f4038c.m5566a(2, null);
        }

        public void onServiceDisconnected(ComponentName component) {
            Log.m5752b("service disconnected: " + component);
            this.f4035a.f4036a = null;
            this.f4035a.f4037b.m5565b();
        }
    }

    public interface OnConnectedListener {
        void m5564a();

        void m5565b();
    }

    public interface OnConnectionFailedListener {
        void m5566a(int i, Intent intent);
    }

    public AnalyticsGmsCoreClient(Context context, OnConnectedListener onConnectedListener, OnConnectionFailedListener onConnectionFailedListener) {
        this.f4039d = context;
        if (onConnectedListener == null) {
            throw new IllegalArgumentException("onConnectedListener cannot be null");
        }
        this.f4037b = onConnectedListener;
        if (onConnectionFailedListener == null) {
            throw new IllegalArgumentException("onConnectionFailedListener cannot be null");
        }
        this.f4038c = onConnectionFailedListener;
    }

    public void m5578b() {
        Intent intent = new Intent("com.google.android.gms.analytics.service.START");
        intent.putExtra("app_package_name", this.f4039d.getPackageName());
        if (this.f4036a != null) {
            Log.m5753c("Calling connect() while still connected, missing disconnect().");
            return;
        }
        this.f4036a = new AnalyticsServiceConnection(this);
        boolean result = this.f4039d.bindService(intent, this.f4036a, 129);
        Log.m5755e("connect: bindService returned " + result + " for " + intent);
        if (!result) {
            this.f4036a = null;
            this.f4038c.m5566a(1, null);
        }
    }

    public void m5579c() {
        this.f4040e = null;
        if (this.f4036a != null) {
            try {
                this.f4039d.unbindService(this.f4036a);
            } catch (IllegalStateException e) {
            } catch (IllegalArgumentException e2) {
            }
            this.f4036a = null;
            this.f4037b.m5565b();
        }
    }

    public void m5577a(Map wireParams, long hitTimeInMilliseconds, String path, List commands) {
        try {
            m5573f().sendHit(wireParams, hitTimeInMilliseconds, path, commands);
        } catch (RemoteException e) {
            Log.m5753c("sendHit failed: " + e);
        }
    }

    public void m5576a() {
        try {
            m5573f().clearHits();
        } catch (RemoteException e) {
            Log.m5753c("clear hits failed: " + e);
        }
    }

    private IAnalyticsService m5573f() {
        m5580d();
        return this.f4040e;
    }

    protected void m5580d() {
        if (!m5581e()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public boolean m5581e() {
        return this.f4040e != null;
    }

    private void m5574g() {
        m5575h();
    }

    private void m5575h() {
        this.f4037b.m5564a();
    }
}
