package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Process;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.gl;
import com.google.android.gms.internal.gn;
import java.io.IOException;

/* renamed from: com.google.android.gms.tagmanager.a */
class C2257a {
    private static C2257a Wx;
    private static Object sf;
    private volatile long Ws;
    private volatile long Wt;
    private volatile long Wu;
    private final gl Wv;
    private C2254a Ww;
    private volatile boolean mClosed;
    private final Context mContext;
    private final Thread qY;
    private volatile Info sh;

    /* renamed from: com.google.android.gms.tagmanager.a.a */
    public interface C2254a {
        Info jW();
    }

    /* renamed from: com.google.android.gms.tagmanager.a.1 */
    class C22551 implements C2254a {
        final /* synthetic */ C2257a Wy;

        C22551(C2257a c2257a) {
            this.Wy = c2257a;
        }

        public Info jW() {
            Info info = null;
            try {
                info = AdvertisingIdClient.getAdvertisingIdInfo(this.Wy.mContext);
            } catch (IllegalStateException e) {
                bh.m9376z("IllegalStateException getting Advertising Id Info");
            } catch (GooglePlayServicesRepairableException e2) {
                bh.m9376z("GooglePlayServicesRepairableException getting Advertising Id Info");
            } catch (IOException e3) {
                bh.m9376z("IOException getting Ad Id Info");
            } catch (GooglePlayServicesNotAvailableException e4) {
                bh.m9376z("GooglePlayServicesNotAvailableException getting Advertising Id Info");
            } catch (Exception e5) {
                bh.m9376z("Unknown exception. Could not get the Advertising Id Info.");
            }
            return info;
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.a.2 */
    class C22562 implements Runnable {
        final /* synthetic */ C2257a Wy;

        C22562(C2257a c2257a) {
            this.Wy = c2257a;
        }

        public void run() {
            this.Wy.jU();
        }
    }

    static {
        sf = new Object();
    }

    private C2257a(Context context) {
        this(context, null, gn.ft());
    }

    C2257a(Context context, C2254a c2254a, gl glVar) {
        this.Ws = 900000;
        this.Wt = 30000;
        this.mClosed = false;
        this.Ww = new C22551(this);
        this.Wv = glVar;
        if (context != null) {
            this.mContext = context.getApplicationContext();
        } else {
            this.mContext = context;
        }
        if (c2254a != null) {
            this.Ww = c2254a;
        }
        this.qY = new Thread(new C22562(this));
    }

    static C2257a m9307E(Context context) {
        if (Wx == null) {
            synchronized (sf) {
                if (Wx == null) {
                    Wx = new C2257a(context);
                    Wx.start();
                }
            }
        }
        return Wx;
    }

    private void jU() {
        Process.setThreadPriority(10);
        while (!this.mClosed) {
            try {
                this.sh = this.Ww.jW();
                Thread.sleep(this.Ws);
            } catch (InterruptedException e) {
                bh.m9374x("sleep interrupted in AdvertiserDataPoller thread; continuing");
            }
        }
    }

    private void jV() {
        if (this.Wv.currentTimeMillis() - this.Wu >= this.Wt) {
            interrupt();
            this.Wu = this.Wv.currentTimeMillis();
        }
    }

    void interrupt() {
        this.qY.interrupt();
    }

    public boolean isLimitAdTrackingEnabled() {
        jV();
        return this.sh == null ? true : this.sh.isLimitAdTrackingEnabled();
    }

    public String jT() {
        jV();
        return this.sh == null ? null : this.sh.getId();
    }

    void start() {
        this.qY.start();
    }
}
