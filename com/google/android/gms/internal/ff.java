package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.Api.C1456a;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.fg.C1465b;
import com.google.android.gms.internal.fl.C1892a;
import com.google.android.gms.internal.fm.C1904a;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;
import java.util.ArrayList;

public abstract class ff implements GooglePlayServicesClient, C1456a, C1465b {
    public static final String[] Dg;
    private final Looper AS;
    private final fg Bc;
    private IInterface Da;
    private final ArrayList Db;
    private C1894f Dc;
    private volatile int Dd;
    private final String[] De;
    boolean Df;
    private final Context mContext;
    final Handler mHandler;

    /* renamed from: com.google.android.gms.internal.ff.b */
    protected abstract class C1624b {
        final /* synthetic */ ff Dh;
        private boolean Di;
        private Object mListener;

        public C1624b(ff ffVar, Object obj) {
            this.Dh = ffVar;
            this.mListener = obj;
            this.Di = false;
        }

        protected abstract void m6853a(Object obj);

        protected abstract void dx();

        public void eN() {
            synchronized (this) {
                Object obj = this.mListener;
                if (this.Di) {
                    Log.w("GmsClient", "Callback proxy " + this + " being reused. This is not safe.");
                }
            }
            if (obj != null) {
                try {
                    m6853a(obj);
                } catch (RuntimeException e) {
                    dx();
                    throw e;
                }
            }
            dx();
            synchronized (this) {
                this.Di = true;
            }
            unregister();
        }

        public void eO() {
            synchronized (this) {
                this.mListener = null;
            }
        }

        public void unregister() {
            eO();
            synchronized (this.Dh.Db) {
                this.Dh.Db.remove(this);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.ff.d */
    public abstract class C1625d extends C1624b {
        private final DataHolder BB;
        final /* synthetic */ ff Dh;

        public C1625d(ff ffVar, Object obj, DataHolder dataHolder) {
            this.Dh = ffVar;
            super(ffVar, obj);
            this.BB = dataHolder;
        }

        protected final void m6854a(Object obj) {
            m6855a(obj, this.BB);
        }

        protected abstract void m6855a(Object obj, DataHolder dataHolder);

        protected void dx() {
            if (this.BB != null) {
                this.BB.close();
            }
        }

        public /* bridge */ /* synthetic */ void eN() {
            super.eN();
        }

        public /* bridge */ /* synthetic */ void eO() {
            super.eO();
        }

        public /* bridge */ /* synthetic */ void unregister() {
            super.unregister();
        }
    }

    /* renamed from: com.google.android.gms.internal.ff.a */
    final class C1890a extends Handler {
        final /* synthetic */ ff Dh;

        public C1890a(ff ffVar, Looper looper) {
            this.Dh = ffVar;
            super(looper);
        }

        public void handleMessage(Message msg) {
            C1624b c1624b;
            if (msg.what == 1 && !this.Dh.isConnecting()) {
                c1624b = (C1624b) msg.obj;
                c1624b.dx();
                c1624b.unregister();
            } else if (msg.what == 3) {
                this.Dh.Bc.m8429a(new ConnectionResult(((Integer) msg.obj).intValue(), null));
            } else if (msg.what == 4) {
                this.Dh.m6493M(1);
                this.Dh.Da = null;
                this.Dh.Bc.m8428O(((Integer) msg.obj).intValue());
            } else if (msg.what == 2 && !this.Dh.isConnected()) {
                c1624b = (C1624b) msg.obj;
                c1624b.dx();
                c1624b.unregister();
            } else if (msg.what == 2 || msg.what == 1) {
                ((C1624b) msg.obj).eN();
            } else {
                Log.wtf("GmsClient", "Don't know how to handle this message.");
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.ff.c */
    public static final class C1891c implements ConnectionCallbacks {
        private final GooglePlayServicesClient.ConnectionCallbacks Dj;

        public C1891c(GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks) {
            this.Dj = connectionCallbacks;
        }

        public boolean equals(Object other) {
            return other instanceof C1891c ? this.Dj.equals(((C1891c) other).Dj) : this.Dj.equals(other);
        }

        public void onConnected(Bundle connectionHint) {
            this.Dj.onConnected(connectionHint);
        }

        public void onConnectionSuspended(int cause) {
            this.Dj.onDisconnected();
        }
    }

    /* renamed from: com.google.android.gms.internal.ff.e */
    public static final class C1893e extends C1892a {
        private ff Dk;

        public C1893e(ff ffVar) {
            this.Dk = ffVar;
        }

        public void m8423b(int i, IBinder iBinder, Bundle bundle) {
            fq.m8517b((Object) "onPostInitComplete can be called only once per call to getServiceFromBroker", this.Dk);
            this.Dk.m6503a(i, iBinder, bundle);
            this.Dk = null;
        }
    }

    /* renamed from: com.google.android.gms.internal.ff.f */
    final class C1894f implements ServiceConnection {
        final /* synthetic */ ff Dh;

        C1894f(ff ffVar) {
            this.Dh = ffVar;
        }

        public void onServiceConnected(ComponentName component, IBinder binder) {
            this.Dh.m6508z(binder);
        }

        public void onServiceDisconnected(ComponentName component) {
            this.Dh.mHandler.sendMessage(this.Dh.mHandler.obtainMessage(4, Integer.valueOf(1)));
        }
    }

    /* renamed from: com.google.android.gms.internal.ff.g */
    public static final class C1895g implements OnConnectionFailedListener {
        private final GooglePlayServicesClient.OnConnectionFailedListener Dl;

        public C1895g(GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener) {
            this.Dl = onConnectionFailedListener;
        }

        public boolean equals(Object other) {
            return other instanceof C1895g ? this.Dl.equals(((C1895g) other).Dl) : this.Dl.equals(other);
        }

        public void onConnectionFailed(ConnectionResult result) {
            this.Dl.onConnectionFailed(result);
        }
    }

    /* renamed from: com.google.android.gms.internal.ff.h */
    protected final class C1896h extends C1624b {
        final /* synthetic */ ff Dh;
        public final Bundle Dm;
        public final IBinder Dn;
        public final int statusCode;

        public C1896h(ff ffVar, int i, IBinder iBinder, Bundle bundle) {
            this.Dh = ffVar;
            super(ffVar, Boolean.valueOf(true));
            this.statusCode = i;
            this.Dn = iBinder;
            this.Dm = bundle;
        }

        protected /* synthetic */ void m8424a(Object obj) {
            m8425b((Boolean) obj);
        }

        protected void m8425b(Boolean bool) {
            if (bool == null) {
                this.Dh.m6493M(1);
                return;
            }
            switch (this.statusCode) {
                case Base64.DEFAULT /*0*/:
                    try {
                        if (this.Dh.bh().equals(this.Dn.getInterfaceDescriptor())) {
                            this.Dh.Da = this.Dh.m6507r(this.Dn);
                            if (this.Dh.Da != null) {
                                this.Dh.m6493M(3);
                                this.Dh.Bc.bV();
                                return;
                            }
                        }
                    } catch (RemoteException e) {
                    }
                    fh.m8440x(this.Dh.mContext).m8442b(this.Dh.bg(), this.Dh.Dc);
                    this.Dh.Dc = null;
                    this.Dh.m6493M(1);
                    this.Dh.Da = null;
                    this.Dh.Bc.m8429a(new ConnectionResult(8, null));
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                    this.Dh.m6493M(1);
                    throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
                default:
                    PendingIntent pendingIntent = this.Dm != null ? (PendingIntent) this.Dm.getParcelable("pendingIntent") : null;
                    if (this.Dh.Dc != null) {
                        fh.m8440x(this.Dh.mContext).m8442b(this.Dh.bg(), this.Dh.Dc);
                        this.Dh.Dc = null;
                    }
                    this.Dh.m6493M(1);
                    this.Dh.Da = null;
                    this.Dh.Bc.m8429a(new ConnectionResult(this.statusCode, pendingIntent));
            }
        }

        protected void dx() {
        }
    }

    static {
        Dg = new String[]{"service_esmobile", "service_googleme"};
    }

    protected ff(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String... strArr) {
        this.Db = new ArrayList();
        this.Dd = 1;
        this.Df = false;
        this.mContext = (Context) fq.m8520f(context);
        this.AS = (Looper) fq.m8517b((Object) looper, (Object) "Looper must not be null");
        this.Bc = new fg(context, looper, this);
        this.mHandler = new C1890a(this, looper);
        m6506b(strArr);
        this.De = strArr;
        registerConnectionCallbacks((ConnectionCallbacks) fq.m8520f(connectionCallbacks));
        registerConnectionFailedListener((OnConnectionFailedListener) fq.m8520f(onConnectionFailedListener));
    }

    protected ff(Context context, GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener, String... strArr) {
        this(context, context.getMainLooper(), new C1891c(connectionCallbacks), new C1895g(onConnectionFailedListener), strArr);
    }

    private void m6493M(int i) {
        int i2 = this.Dd;
        this.Dd = i;
        if (i2 == i) {
            return;
        }
        if (i == 3) {
            onConnected();
        } else if (i2 == 3 && i == 1) {
            onDisconnected();
        }
    }

    public void m6502N(int i) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4, Integer.valueOf(i)));
    }

    protected void m6503a(int i, IBinder iBinder, Bundle bundle) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1, new C1896h(this, i, iBinder, bundle)));
    }

    public final void m6504a(C1624b c1624b) {
        synchronized (this.Db) {
            this.Db.add(c1624b);
        }
        this.mHandler.sendMessage(this.mHandler.obtainMessage(2, c1624b));
    }

    protected abstract void m6505a(fm fmVar, C1893e c1893e);

    protected void m6506b(String... strArr) {
    }

    protected final void bT() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    protected abstract String bg();

    protected abstract String bh();

    public void connect() {
        this.Df = true;
        m6493M(2);
        int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.mContext);
        if (isGooglePlayServicesAvailable != 0) {
            m6493M(1);
            this.mHandler.sendMessage(this.mHandler.obtainMessage(3, Integer.valueOf(isGooglePlayServicesAvailable)));
            return;
        }
        if (this.Dc != null) {
            Log.e("GmsClient", "Calling connect() while still connected, missing disconnect().");
            this.Da = null;
            fh.m8440x(this.mContext).m8442b(bg(), this.Dc);
        }
        this.Dc = new C1894f(this);
        if (!fh.m8440x(this.mContext).m8441a(bg(), this.Dc)) {
            Log.e("GmsClient", "unable to connect to service: " + bg());
            this.mHandler.sendMessage(this.mHandler.obtainMessage(3, Integer.valueOf(9)));
        }
    }

    public Bundle dG() {
        return null;
    }

    public void disconnect() {
        this.Df = false;
        synchronized (this.Db) {
            int size = this.Db.size();
            for (int i = 0; i < size; i++) {
                ((C1624b) this.Db.get(i)).eO();
            }
            this.Db.clear();
        }
        m6493M(1);
        this.Da = null;
        if (this.Dc != null) {
            fh.m8440x(this.mContext).m8442b(bg(), this.Dc);
            this.Dc = null;
        }
    }

    public final String[] eL() {
        return this.De;
    }

    protected final IInterface eM() {
        bT();
        return this.Da;
    }

    public boolean em() {
        return this.Df;
    }

    public final Context getContext() {
        return this.mContext;
    }

    public final Looper getLooper() {
        return this.AS;
    }

    public boolean isConnected() {
        return this.Dd == 3;
    }

    public boolean isConnecting() {
        return this.Dd == 2;
    }

    public boolean isConnectionCallbacksRegistered(GooglePlayServicesClient.ConnectionCallbacks listener) {
        return this.Bc.isConnectionCallbacksRegistered(new C1891c(listener));
    }

    public boolean isConnectionFailedListenerRegistered(GooglePlayServicesClient.OnConnectionFailedListener listener) {
        return this.Bc.isConnectionFailedListenerRegistered(listener);
    }

    protected void onConnected() {
    }

    protected void onDisconnected() {
    }

    protected abstract IInterface m6507r(IBinder iBinder);

    public void registerConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks listener) {
        this.Bc.registerConnectionCallbacks(new C1891c(listener));
    }

    public void registerConnectionCallbacks(ConnectionCallbacks listener) {
        this.Bc.registerConnectionCallbacks(listener);
    }

    public void registerConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener listener) {
        this.Bc.registerConnectionFailedListener(listener);
    }

    public void registerConnectionFailedListener(OnConnectionFailedListener listener) {
        this.Bc.registerConnectionFailedListener(listener);
    }

    public void unregisterConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks listener) {
        this.Bc.unregisterConnectionCallbacks(new C1891c(listener));
    }

    public void unregisterConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener listener) {
        this.Bc.unregisterConnectionFailedListener(listener);
    }

    protected final void m6508z(IBinder iBinder) {
        try {
            m6505a(C1904a.m8506C(iBinder), new C1893e(this));
        } catch (RemoteException e) {
            Log.w("GmsClient", "service died");
        }
    }
}
