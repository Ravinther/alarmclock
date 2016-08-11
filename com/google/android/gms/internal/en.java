package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.Cast.ApplicationConnectionResult;
import com.google.android.gms.cast.Cast.Listener;
import com.google.android.gms.cast.Cast.MessageReceivedCallback;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.CastStatusCodes;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.C1461a.C1401d;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.internal.ep.C1866a;
import com.google.android.gms.internal.eq.C1861a;
import com.google.android.gms.internal.ff.C1893e;
import com.google.android.gms.location.LocationStatusCodes;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public final class en extends ff {
    private static final er zb;
    private static final Object zs;
    private static final Object zt;
    private final Handler mHandler;
    private final Listener xX;
    private double yC;
    private boolean yD;
    private ApplicationMetadata zc;
    private final CastDevice zd;
    private final eq ze;
    private final Map zf;
    private final long zg;
    private String zh;
    private boolean zi;
    private boolean zj;
    private final AtomicLong zk;
    private String zl;
    private String zm;
    private Bundle zn;
    private Map zo;
    private C1864b zp;
    private C1401d zq;
    private C1401d zr;

    /* renamed from: com.google.android.gms.internal.en.1 */
    class C18621 extends C1861a {
        final /* synthetic */ en zu;

        /* renamed from: com.google.android.gms.internal.en.1.1 */
        class C18581 implements Runnable {
            final /* synthetic */ int zv;
            final /* synthetic */ C18621 zw;

            C18581(C18621 c18621, int i) {
                this.zw = c18621;
                this.zv = i;
            }

            public void run() {
                if (this.zw.zu.xX != null) {
                    this.zw.zu.xX.onApplicationDisconnected(this.zv);
                }
            }
        }

        /* renamed from: com.google.android.gms.internal.en.1.2 */
        class C18592 implements Runnable {
            final /* synthetic */ double yQ;
            final /* synthetic */ boolean yR;
            final /* synthetic */ C18621 zw;
            final /* synthetic */ String zx;

            C18592(C18621 c18621, String str, double d, boolean z) {
                this.zw = c18621;
                this.zx = str;
                this.yQ = d;
                this.yR = z;
            }

            public void run() {
                this.zw.zu.m8336a(this.zx, this.yQ, this.yR);
            }
        }

        /* renamed from: com.google.android.gms.internal.en.1.3 */
        class C18603 implements Runnable {
            final /* synthetic */ String xN;
            final /* synthetic */ C18621 zw;
            final /* synthetic */ String zy;

            C18603(C18621 c18621, String str, String str2) {
                this.zw = c18621;
                this.xN = str;
                this.zy = str2;
            }

            public void run() {
                synchronized (this.zw.zu.zf) {
                    MessageReceivedCallback messageReceivedCallback = (MessageReceivedCallback) this.zw.zu.zf.get(this.xN);
                }
                if (messageReceivedCallback != null) {
                    messageReceivedCallback.onMessageReceived(this.zw.zu.zd, this.xN, this.zy);
                    return;
                }
                en.zb.m8388b("Discarded message for unknown namespace '%s'", this.xN);
            }
        }

        C18621(en enVar) {
            this.zu = enVar;
        }

        private boolean m8320D(int i) {
            synchronized (en.zt) {
                if (this.zu.zr != null) {
                    this.zu.zr.m6049b(new Status(i));
                    this.zu.zr = null;
                    return true;
                }
                return false;
            }
        }

        private void m8321b(long j, int i) {
            synchronized (this.zu.zo) {
                C1401d c1401d = (C1401d) this.zu.zo.remove(Long.valueOf(j));
            }
            if (c1401d != null) {
                c1401d.m6049b(new Status(i));
            }
        }

        public void m8322A(int i) {
            synchronized (en.zs) {
                if (this.zu.zq != null) {
                    this.zu.zq.m6049b(new C1863a(new Status(i)));
                    this.zu.zq = null;
                }
            }
        }

        public void m8323B(int i) {
            m8320D(i);
        }

        public void m8324C(int i) {
            m8320D(i);
        }

        public void m8325a(ApplicationMetadata applicationMetadata, String str, String str2, boolean z) {
            this.zu.zc = applicationMetadata;
            this.zu.zl = applicationMetadata.getApplicationId();
            this.zu.zm = str2;
            synchronized (en.zs) {
                if (this.zu.zq != null) {
                    this.zu.zq.m6049b(new C1863a(new Status(0), applicationMetadata, str, str2, z));
                    this.zu.zq = null;
                }
            }
        }

        public void m8326a(String str, long j) {
            m8321b(j, 0);
        }

        public void m8327a(String str, long j, int i) {
            m8321b(j, i);
        }

        public void m8328b(String str, double d, boolean z) {
            this.zu.mHandler.post(new C18592(this, str, d, z));
        }

        public void m8329b(String str, byte[] bArr) {
            en.zb.m8388b("IGNORING: Receive (type=binary, ns=%s) <%d bytes>", str, Integer.valueOf(bArr.length));
        }

        public void m8330d(String str, String str2) {
            en.zb.m8388b("Receive (type=text, ns=%s) %s", str, str2);
            this.zu.mHandler.post(new C18603(this, str, str2));
        }

        public void onApplicationDisconnected(int statusCode) {
            this.zu.zl = null;
            this.zu.zm = null;
            if (!m8320D(statusCode) && this.zu.xX != null) {
                this.zu.mHandler.post(new C18581(this, statusCode));
            }
        }

        public void m8331z(int i) {
            en.zb.m8388b("ICastDeviceControllerListener.onDisconnected: %d", Integer.valueOf(i));
            this.zu.zj = false;
            this.zu.zc = null;
            if (i != 0) {
                this.zu.m6502N(2);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.en.a */
    private static final class C1863a implements ApplicationConnectionResult {
        private final String qL;
        private final Status wJ;
        private final String zA;
        private final boolean zB;
        private final ApplicationMetadata zz;

        public C1863a(Status status) {
            this(status, null, null, null, false);
        }

        public C1863a(Status status, ApplicationMetadata applicationMetadata, String str, String str2, boolean z) {
            this.wJ = status;
            this.zz = applicationMetadata;
            this.zA = str;
            this.qL = str2;
            this.zB = z;
        }

        public ApplicationMetadata getApplicationMetadata() {
            return this.zz;
        }

        public String getApplicationStatus() {
            return this.zA;
        }

        public String getSessionId() {
            return this.qL;
        }

        public Status getStatus() {
            return this.wJ;
        }

        public boolean getWasLaunched() {
            return this.zB;
        }
    }

    /* renamed from: com.google.android.gms.internal.en.b */
    private class C1864b implements OnConnectionFailedListener {
        final /* synthetic */ en zu;

        private C1864b(en enVar) {
            this.zu = enVar;
        }

        public void onConnectionFailed(ConnectionResult result) {
            this.zu.dJ();
        }
    }

    static {
        zb = new er("CastClientImpl");
        zs = new Object();
        zt = new Object();
    }

    public en(Context context, Looper looper, CastDevice castDevice, long j, Listener listener, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, (String[]) null);
        this.zd = castDevice;
        this.xX = listener;
        this.zg = j;
        this.mHandler = new Handler(looper);
        this.zf = new HashMap();
        this.zj = false;
        this.zc = null;
        this.zh = null;
        this.yC = 0.0d;
        this.yD = false;
        this.zk = new AtomicLong(0);
        this.zo = new HashMap();
        this.zp = new C1864b();
        registerConnectionFailedListener(this.zp);
        this.ze = new C18621(this);
    }

    private void m8336a(String str, double d, boolean z) {
        boolean z2;
        if (eo.m8365a(str, this.zh)) {
            z2 = false;
        } else {
            this.zh = str;
            int i = 1;
        }
        if (this.xX != null && (r0 != 0 || this.zi)) {
            this.xX.onApplicationStatusChanged();
        }
        if (d != this.yC) {
            this.yC = d;
            z2 = true;
        } else {
            z2 = false;
        }
        if (z != this.yD) {
            this.yD = z;
            z2 = true;
        }
        zb.m8388b("hasChange=%b, mFirstStatusUpdate=%b", Boolean.valueOf(z2), Boolean.valueOf(this.zi));
        if (this.xX != null && (z2 || this.zi)) {
            this.xX.onVolumeChanged();
        }
        this.zi = false;
    }

    private void m8343d(C1401d c1401d) {
        synchronized (zs) {
            if (this.zq != null) {
                this.zq.m6049b(new C1863a(new Status(CastStatusCodes.CANCELED)));
            }
            this.zq = c1401d;
        }
    }

    private void dJ() {
        zb.m8388b("removing all MessageReceivedCallbacks", new Object[0]);
        synchronized (this.zf) {
            this.zf.clear();
        }
    }

    private void dK() {
        if (!this.zj) {
            throw new IllegalStateException("not connected to a device");
        }
    }

    private void m8346f(C1401d c1401d) {
        synchronized (zt) {
            if (this.zr != null) {
                c1401d.m6049b(new Status(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE));
                return;
            }
            this.zr = c1401d;
        }
    }

    public void m8350V(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Channel namespace cannot be null or empty");
        }
        synchronized (this.zf) {
            MessageReceivedCallback messageReceivedCallback = (MessageReceivedCallback) this.zf.remove(str);
        }
        if (messageReceivedCallback != null) {
            try {
                ((ep) eM()).aa(str);
            } catch (Throwable e) {
                zb.m8387a(e, "Error unregistering namespace (%s): %s", str, e.getMessage());
            }
        }
    }

    public void m8351a(double d) {
        if (Double.isInfinite(d) || Double.isNaN(d)) {
            throw new IllegalArgumentException("Volume cannot be " + d);
        }
        ((ep) eM()).m8370a(d, this.yC, this.yD);
    }

    protected void m8352a(int i, IBinder iBinder, Bundle bundle) {
        if (i == 0 || i == LocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES) {
            this.zj = true;
            this.zi = true;
        } else {
            this.zj = false;
        }
        if (i == LocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES) {
            this.zn = new Bundle();
            this.zn.putBoolean(Cast.EXTRA_APP_NO_LONGER_RUNNING, true);
            i = 0;
        }
        super.m6503a(i, iBinder, bundle);
    }

    protected void m8353a(fm fmVar, C1893e c1893e) {
        Bundle bundle = new Bundle();
        zb.m8388b("getServiceFromBroker(): mLastApplicationId=%s, mLastSessionId=%s", this.zl, this.zm);
        this.zd.putInBundle(bundle);
        bundle.putLong("com.google.android.gms.cast.EXTRA_CAST_FLAGS", this.zg);
        if (this.zl != null) {
            bundle.putString("last_application_id", this.zl);
            if (this.zm != null) {
                bundle.putString("last_session_id", this.zm);
            }
        }
        fmVar.m8453a((fl) c1893e, (int) GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName(), this.ze.asBinder(), bundle);
    }

    public void m8354a(String str, MessageReceivedCallback messageReceivedCallback) {
        eo.m8363W(str);
        m8350V(str);
        if (messageReceivedCallback != null) {
            synchronized (this.zf) {
                this.zf.put(str, messageReceivedCallback);
            }
            ((ep) eM()).m8369Z(str);
        }
    }

    public void m8355a(String str, C1401d c1401d) {
        m8346f(c1401d);
        ((ep) eM()).m8368Y(str);
    }

    public void m8356a(String str, String str2, C1401d c1401d) {
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("The message payload cannot be null or empty");
        } else if (str2.length() > Cast.MAX_MESSAGE_LENGTH) {
            throw new IllegalArgumentException("Message exceeds maximum size");
        } else {
            eo.m8363W(str);
            dK();
            long incrementAndGet = this.zk.incrementAndGet();
            ((ep) eM()).m8371a(str, str2, incrementAndGet);
            this.zo.put(Long.valueOf(incrementAndGet), c1401d);
        }
    }

    public void m8357a(String str, boolean z, C1401d c1401d) {
        m8343d(c1401d);
        ((ep) eM()).m8375e(str, z);
    }

    public void m8358b(String str, String str2, C1401d c1401d) {
        m8343d(c1401d);
        ((ep) eM()).m8374e(str, str2);
    }

    protected String bg() {
        return "com.google.android.gms.cast.service.BIND_CAST_DEVICE_CONTROLLER_SERVICE";
    }

    protected String bh() {
        return "com.google.android.gms.cast.internal.ICastDeviceController";
    }

    public Bundle dG() {
        if (this.zn == null) {
            return super.dG();
        }
        Bundle bundle = this.zn;
        this.zn = null;
        return bundle;
    }

    public void dH() {
        ((ep) eM()).dH();
    }

    public double dI() {
        dK();
        return this.yC;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void disconnect() {
        /*
        r5 = this;
        r5.dJ();
        r0 = r5.isConnected();	 Catch:{ RemoteException -> 0x0016 }
        if (r0 == 0) goto L_0x0012;
    L_0x0009:
        r0 = r5.eM();	 Catch:{ RemoteException -> 0x0016 }
        r0 = (com.google.android.gms.internal.ep) r0;	 Catch:{ RemoteException -> 0x0016 }
        r0.disconnect();	 Catch:{ RemoteException -> 0x0016 }
    L_0x0012:
        super.disconnect();
    L_0x0015:
        return;
    L_0x0016:
        r0 = move-exception;
        r1 = zb;	 Catch:{ all -> 0x002c }
        r2 = "Error while disconnecting the controller interface: %s";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x002c }
        r4 = 0;
        r0 = r0.getMessage();	 Catch:{ all -> 0x002c }
        r3[r4] = r0;	 Catch:{ all -> 0x002c }
        r1.m8388b(r2, r3);	 Catch:{ all -> 0x002c }
        super.disconnect();
        goto L_0x0015;
    L_0x002c:
        r0 = move-exception;
        super.disconnect();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.en.disconnect():void");
    }

    public void m8359e(C1401d c1401d) {
        m8346f(c1401d);
        ((ep) eM()).dO();
    }

    public ApplicationMetadata getApplicationMetadata() {
        dK();
        return this.zc;
    }

    public String getApplicationStatus() {
        dK();
        return this.zh;
    }

    public boolean isMute() {
        dK();
        return this.yD;
    }

    protected /* synthetic */ IInterface m8360r(IBinder iBinder) {
        return m8362x(iBinder);
    }

    public void m8361v(boolean z) {
        ((ep) eM()).m8373a(z, this.yC, this.yD);
    }

    protected ep m8362x(IBinder iBinder) {
        return C1866a.m8384y(iBinder);
    }
}
