package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.internal.cu.C1811a;

public abstract class cv extends C1810do {
    private final cx mQ;
    private final C1811a pc;

    /* renamed from: com.google.android.gms.internal.cv.a */
    public static final class C1813a extends cv {
        private final Context mContext;

        public C1813a(Context context, cx cxVar, C1811a c1811a) {
            super(cxVar, c1811a);
            this.mContext = context;
        }

        public void be() {
        }

        public db bf() {
            return dc.m8117a(this.mContext, new ax(), new bg());
        }
    }

    /* renamed from: com.google.android.gms.internal.cv.b */
    public static final class C1814b extends cv implements ConnectionCallbacks, OnConnectionFailedListener {
        private final Object li;
        private final C1811a pc;
        private final cw pd;

        public C1814b(Context context, cx cxVar, C1811a c1811a) {
            super(cxVar, c1811a);
            this.li = new Object();
            this.pc = c1811a;
            this.pd = new cw(context, this, this, cxVar.kK.rs);
            this.pd.connect();
        }

        public void be() {
            synchronized (this.li) {
                if (this.pd.isConnected() || this.pd.isConnecting()) {
                    this.pd.disconnect();
                }
            }
        }

        public db bf() {
            db bi;
            synchronized (this.li) {
                try {
                    bi = this.pd.bi();
                } catch (IllegalStateException e) {
                    bi = null;
                }
            }
            return bi;
        }

        public void onConnected(Bundle connectionHint) {
            start();
        }

        public void onConnectionFailed(ConnectionResult result) {
            this.pc.m8067a(new cz(0));
        }

        public void onDisconnected() {
            dw.m8217v("Disconnected from remote ad request service.");
        }
    }

    public cv(cx cxVar, C1811a c1811a) {
        this.mQ = cxVar;
        this.pc = c1811a;
    }

    private static cz m8095a(db dbVar, cx cxVar) {
        try {
            return dbVar.m8111b(cxVar);
        } catch (Throwable e) {
            dw.m8215c("Could not fetch ad response from ad request service.", e);
            return null;
        }
    }

    public final void aY() {
        try {
            cz czVar;
            db bf = bf();
            if (bf == null) {
                czVar = new cz(0);
            } else {
                czVar = m8095a(bf, this.mQ);
                if (czVar == null) {
                    czVar = new cz(0);
                }
            }
            be();
            this.pc.m8067a(czVar);
        } catch (Throwable th) {
            be();
        }
    }

    public abstract void be();

    public abstract db bf();

    public final void onStop() {
        be();
    }
}
