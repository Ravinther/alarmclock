package com.google.android.gms.analytics;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.google.android.gms.analytics.C1391u.C1390a;
import com.google.android.gms.location.LocationStatusCodes;

/* renamed from: com.google.android.gms.analytics.r */
class C1375r extends af {
    private static final Object sF;
    private static C1375r sR;
    private Context mContext;
    private Handler mHandler;
    private C1352d sG;
    private volatile C1364f sH;
    private int sI;
    private boolean sJ;
    private boolean sK;
    private String sL;
    private boolean sM;
    private boolean sN;
    private C1363e sO;
    private C1372q sP;
    private boolean sQ;

    /* renamed from: com.google.android.gms.analytics.r.1 */
    class C13731 implements C1363e {
        final /* synthetic */ C1375r sS;

        C13731(C1375r c1375r) {
            this.sS = c1375r;
        }

        public void m5994r(boolean z) {
            this.sS.m6000a(z, this.sS.sM);
        }
    }

    /* renamed from: com.google.android.gms.analytics.r.2 */
    class C13742 implements Callback {
        final /* synthetic */ C1375r sS;

        C13742(C1375r c1375r) {
            this.sS = c1375r;
        }

        public boolean handleMessage(Message msg) {
            if (1 == msg.what && C1375r.sF.equals(msg.obj)) {
                C1391u.cy().m6036t(true);
                this.sS.dispatchLocalHits();
                C1391u.cy().m6036t(false);
                if (this.sS.sI > 0 && !this.sS.sQ) {
                    this.sS.mHandler.sendMessageDelayed(this.sS.mHandler.obtainMessage(1, C1375r.sF), (long) (this.sS.sI * LocationStatusCodes.GEOFENCE_NOT_AVAILABLE));
                }
            }
            return true;
        }
    }

    static {
        sF = new Object();
    }

    private C1375r() {
        this.sI = 1800;
        this.sJ = true;
        this.sM = true;
        this.sN = true;
        this.sO = new C13731(this);
        this.sQ = false;
    }

    public static C1375r ci() {
        if (sR == null) {
            sR = new C1375r();
        }
        return sR;
    }

    private void cj() {
        this.sP = new C1372q(this);
        this.sP.m5993o(this.mContext);
    }

    private void ck() {
        this.mHandler = new Handler(this.mContext.getMainLooper(), new C13742(this));
        if (this.sI > 0) {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, sF), (long) (this.sI * LocationStatusCodes.GEOFENCE_NOT_AVAILABLE));
        }
    }

    synchronized void m5999a(Context context, C1364f c1364f) {
        if (this.mContext == null) {
            this.mContext = context.getApplicationContext();
            if (this.sH == null) {
                this.sH = c1364f;
                if (this.sJ) {
                    dispatchLocalHits();
                    this.sJ = false;
                }
                if (this.sK) {
                    bY();
                    this.sK = false;
                }
            }
        }
    }

    synchronized void m6000a(boolean z, boolean z2) {
        if (!(this.sQ == z && this.sM == z2)) {
            if (z || !z2) {
                if (this.sI > 0) {
                    this.mHandler.removeMessages(1, sF);
                }
            }
            if (!z && z2 && this.sI > 0) {
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, sF), (long) (this.sI * LocationStatusCodes.GEOFENCE_NOT_AVAILABLE));
            }
            StringBuilder append = new StringBuilder().append("PowerSaveMode ");
            String str = (z || !z2) ? "initiated." : "terminated.";
            aa.m5915y(append.append(str).toString());
            this.sQ = z;
            this.sM = z2;
        }
    }

    void bY() {
        if (this.sH == null) {
            aa.m5915y("setForceLocalDispatch() queued. It will be called once initialization is complete.");
            this.sK = true;
            return;
        }
        C1391u.cy().m6035a(C1390a.SET_FORCE_LOCAL_DISPATCH);
        this.sH.bY();
    }

    synchronized C1352d cl() {
        if (this.sG == null) {
            if (this.mContext == null) {
                throw new IllegalStateException("Cant get a store unless we have a context");
            }
            this.sG = new ac(this.sO, this.mContext);
            if (this.sL != null) {
                this.sG.bX().m5939F(this.sL);
                this.sL = null;
            }
        }
        if (this.mHandler == null) {
            ck();
        }
        if (this.sP == null && this.sN) {
            cj();
        }
        return this.sG;
    }

    synchronized void cm() {
        if (!this.sQ && this.sM && this.sI > 0) {
            this.mHandler.removeMessages(1, sF);
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1, sF));
        }
    }

    synchronized void dispatchLocalHits() {
        if (this.sH == null) {
            aa.m5915y("Dispatch call queued. Dispatch will run once initialization is complete.");
            this.sJ = true;
        } else {
            C1391u.cy().m6035a(C1390a.DISPATCH);
            this.sH.bW();
        }
    }

    synchronized void m6001s(boolean z) {
        m6000a(this.sQ, z);
    }

    synchronized void setLocalDispatchPeriod(int dispatchPeriodInSeconds) {
        if (this.mHandler == null) {
            aa.m5915y("Dispatch period set with null handler. Dispatch will run once initialization is complete.");
            this.sI = dispatchPeriodInSeconds;
        } else {
            C1391u.cy().m6035a(C1390a.SET_DISPATCH_PERIOD);
            if (!this.sQ && this.sM && this.sI > 0) {
                this.mHandler.removeMessages(1, sF);
            }
            this.sI = dispatchPeriodInSeconds;
            if (dispatchPeriodInSeconds > 0 && !this.sQ && this.sM) {
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, sF), (long) (dispatchPeriodInSeconds * LocationStatusCodes.GEOFENCE_NOT_AVAILABLE));
            }
        }
    }
}
