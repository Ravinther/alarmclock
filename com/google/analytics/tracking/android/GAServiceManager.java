package com.google.analytics.tracking.android;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.google.analytics.tracking.android.GAUsage.Field;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.location.LocationStatusCodes;

public class GAServiceManager implements ServiceManager {
    private static final Object f4067a;
    private static GAServiceManager f4068m;
    private Context f4069b;
    private AnalyticsStore f4070c;
    private volatile AnalyticsThread f4071d;
    private int f4072e;
    private boolean f4073f;
    private boolean f4074g;
    private boolean f4075h;
    private AnalyticsStoreStateListener f4076i;
    private Handler f4077j;
    private GANetworkReceiver f4078k;
    private boolean f4079l;

    /* renamed from: com.google.analytics.tracking.android.GAServiceManager.1 */
    class C13161 implements AnalyticsStoreStateListener {
        final /* synthetic */ GAServiceManager f4065a;

        C13161(GAServiceManager gAServiceManager) {
            this.f4065a = gAServiceManager;
        }

        public void m5640a(boolean isEmpty) {
            this.f4065a.m5654a(isEmpty, this.f4065a.f4074g);
        }
    }

    /* renamed from: com.google.analytics.tracking.android.GAServiceManager.2 */
    class C13172 implements Callback {
        final /* synthetic */ GAServiceManager f4066a;

        C13172(GAServiceManager gAServiceManager) {
            this.f4066a = gAServiceManager;
        }

        public boolean handleMessage(Message msg) {
            if (1 == msg.what && GAServiceManager.f4067a.equals(msg.obj)) {
                GAUsage.m5726a().m5728a(true);
                this.f4066a.m5656c();
                GAUsage.m5726a().m5728a(false);
                if (this.f4066a.f4072e > 0 && !this.f4066a.f4079l) {
                    this.f4066a.f4077j.sendMessageDelayed(this.f4066a.f4077j.obtainMessage(1, GAServiceManager.f4067a), (long) (this.f4066a.f4072e * LocationStatusCodes.GEOFENCE_NOT_AVAILABLE));
                }
            }
            return true;
        }
    }

    static {
        f4067a = new Object();
    }

    public static GAServiceManager m5643a() {
        if (f4068m == null) {
            f4068m = new GAServiceManager();
        }
        return f4068m;
    }

    private GAServiceManager() {
        this.f4072e = 1800;
        this.f4073f = true;
        this.f4074g = true;
        this.f4075h = true;
        this.f4076i = new C13161(this);
        this.f4079l = false;
    }

    private void m5649e() {
        this.f4078k = new GANetworkReceiver(this);
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.f4069b.registerReceiver(this.f4078k, filter);
    }

    private void m5650f() {
        this.f4077j = new Handler(this.f4069b.getMainLooper(), new C13172(this));
        if (this.f4072e > 0) {
            this.f4077j.sendMessageDelayed(this.f4077j.obtainMessage(1, f4067a), (long) (this.f4072e * LocationStatusCodes.GEOFENCE_NOT_AVAILABLE));
        }
    }

    synchronized void m5652a(Context ctx, AnalyticsThread thread) {
        if (this.f4069b == null) {
            this.f4069b = ctx.getApplicationContext();
            if (this.f4071d == null) {
                this.f4071d = thread;
                if (this.f4073f) {
                    thread.m5587a();
                }
            }
        }
    }

    synchronized AnalyticsStore m5655b() {
        if (this.f4070c == null) {
            if (this.f4069b == null) {
                throw new IllegalStateException("Cant get a store unless we have a context");
            }
            this.f4070c = new PersistentAnalyticsStore(this.f4076i, this.f4069b);
        }
        if (this.f4077j == null) {
            m5650f();
        }
        if (this.f4078k == null && this.f4075h) {
            m5649e();
        }
        return this.f4070c;
    }

    public synchronized void m5656c() {
        if (this.f4071d == null) {
            Log.m5758h("dispatch call queued.  Need to call GAServiceManager.getInstance().initialize().");
            this.f4073f = true;
        } else {
            GAUsage.m5726a().m5727a(Field.DISPATCH);
            this.f4071d.m5587a();
        }
    }

    public synchronized void m5651a(int dispatchPeriodInSeconds) {
        if (this.f4077j == null) {
            Log.m5758h("Need to call initialize() and be in fallback mode to start dispatch.");
            this.f4072e = dispatchPeriodInSeconds;
        } else {
            GAUsage.m5726a().m5727a(Field.SET_DISPATCH_PERIOD);
            if (!this.f4079l && this.f4074g && this.f4072e > 0) {
                this.f4077j.removeMessages(1, f4067a);
            }
            this.f4072e = dispatchPeriodInSeconds;
            if (dispatchPeriodInSeconds > 0 && !this.f4079l && this.f4074g) {
                this.f4077j.sendMessageDelayed(this.f4077j.obtainMessage(1, f4067a), (long) (dispatchPeriodInSeconds * LocationStatusCodes.GEOFENCE_NOT_AVAILABLE));
            }
        }
    }

    @VisibleForTesting
    synchronized void m5654a(boolean storeIsEmpty, boolean connected) {
        if (!(this.f4079l == storeIsEmpty && this.f4074g == connected)) {
            if (storeIsEmpty || !connected) {
                if (this.f4072e > 0) {
                    this.f4077j.removeMessages(1, f4067a);
                }
            }
            if (!storeIsEmpty && connected && this.f4072e > 0) {
                this.f4077j.sendMessageDelayed(this.f4077j.obtainMessage(1, f4067a), (long) (this.f4072e * LocationStatusCodes.GEOFENCE_NOT_AVAILABLE));
            }
            StringBuilder append = new StringBuilder().append("PowerSaveMode ");
            String str = (storeIsEmpty || !connected) ? "initiated." : "terminated.";
            Log.m5755e(append.append(str).toString());
            this.f4079l = storeIsEmpty;
            this.f4074g = connected;
        }
    }

    public synchronized void m5653a(boolean connected) {
        m5654a(this.f4079l, connected);
    }
}
