package com.google.android.gms.internal;

import android.content.Context;

public final class bh {
    private final bq ky;
    private final Object li;
    private final Context mContext;
    private final cx mQ;
    private final bj mR;
    private boolean mS;
    private bm mT;

    /* renamed from: com.google.android.gms.internal.bh.1 */
    class C17591 implements Runnable {
        final /* synthetic */ bn mU;
        final /* synthetic */ bh mV;

        C17591(bh bhVar, bn bnVar) {
            this.mV = bhVar;
            this.mU = bnVar;
        }

        public void run() {
            try {
                this.mU.ny.destroy();
            } catch (Throwable e) {
                dw.m8215c("Could not destroy mediation adapter.", e);
            }
        }
    }

    public bh(Context context, cx cxVar, bq bqVar, bj bjVar) {
        this.li = new Object();
        this.mS = false;
        this.mContext = context;
        this.mQ = cxVar;
        this.ky = bqVar;
        this.mR = bjVar;
    }

    public bn m7902a(long j, long j2) {
        dw.m8217v("Starting mediation.");
        for (bi biVar : this.mR.nc) {
            dw.m8219x("Trying mediation network: " + biVar.mX);
            for (String str : biVar.mY) {
                synchronized (this.li) {
                    if (this.mS) {
                        bn bnVar = new bn(-1);
                        return bnVar;
                    }
                    this.mT = new bm(this.mContext, str, this.ky, this.mR, biVar, this.mQ.pg, this.mQ.kN, this.mQ.kK);
                    bnVar = this.mT.m7922b(j, j2);
                    if (bnVar.nw == 0) {
                        dw.m8217v("Adapter succeeded.");
                        return bnVar;
                    } else if (bnVar.ny != null) {
                        dv.rp.post(new C17591(this, bnVar));
                    }
                }
            }
        }
        return new bn(1);
    }

    public void cancel() {
        synchronized (this.li) {
            this.mS = true;
            if (this.mT != null) {
                this.mT.cancel();
            }
        }
    }
}
