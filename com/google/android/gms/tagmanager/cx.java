package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;

class cx extends cw {
    private static cx aam;
    private static final Object sF;
    private Context aac;
    private at aad;
    private volatile ar aae;
    private int aaf;
    private boolean aag;
    private boolean aah;
    private boolean aai;
    private au aaj;
    private bn aak;
    private boolean aal;
    private boolean connected;
    private Handler handler;

    /* renamed from: com.google.android.gms.tagmanager.cx.1 */
    class C22961 implements au {
        final /* synthetic */ cx aan;

        C22961(cx cxVar) {
            this.aan = cxVar;
        }

        public void m9494r(boolean z) {
            this.aan.m9501a(z, this.aan.connected);
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cx.2 */
    class C22972 implements Callback {
        final /* synthetic */ cx aan;

        C22972(cx cxVar) {
            this.aan = cxVar;
        }

        public boolean handleMessage(Message msg) {
            if (1 == msg.what && cx.sF.equals(msg.obj)) {
                this.aan.bW();
                if (this.aan.aaf > 0 && !this.aan.aal) {
                    this.aan.handler.sendMessageDelayed(this.aan.handler.obtainMessage(1, cx.sF), (long) this.aan.aaf);
                }
            }
            return true;
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cx.3 */
    class C22983 implements Runnable {
        final /* synthetic */ cx aan;

        C22983(cx cxVar) {
            this.aan = cxVar;
        }

        public void run() {
            this.aan.aad.bW();
        }
    }

    static {
        sF = new Object();
    }

    private cx() {
        this.aaf = 1800000;
        this.aag = true;
        this.aah = false;
        this.connected = true;
        this.aai = true;
        this.aaj = new C22961(this);
        this.aal = false;
    }

    private void cj() {
        this.aak = new bn(this);
        this.aak.m9387o(this.aac);
    }

    private void ck() {
        this.handler = new Handler(this.aac.getMainLooper(), new C22972(this));
        if (this.aaf > 0) {
            this.handler.sendMessageDelayed(this.handler.obtainMessage(1, sF), (long) this.aaf);
        }
    }

    public static cx lG() {
        if (aam == null) {
            aam = new cx();
        }
        return aam;
    }

    synchronized void m9500a(Context context, ar arVar) {
        if (this.aac == null) {
            this.aac = context.getApplicationContext();
            if (this.aae == null) {
                this.aae = arVar;
            }
        }
    }

    synchronized void m9501a(boolean z, boolean z2) {
        if (!(this.aal == z && this.connected == z2)) {
            if (z || !z2) {
                if (this.aaf > 0) {
                    this.handler.removeMessages(1, sF);
                }
            }
            if (!z && z2 && this.aaf > 0) {
                this.handler.sendMessageDelayed(this.handler.obtainMessage(1, sF), (long) this.aaf);
            }
            StringBuilder append = new StringBuilder().append("PowerSaveMode ");
            String str = (z || !z2) ? "initiated." : "terminated.";
            bh.m9375y(append.append(str).toString());
            this.aal = z;
            this.connected = z2;
        }
    }

    public synchronized void bW() {
        if (this.aah) {
            this.aae.m9336a(new C22983(this));
        } else {
            bh.m9375y("Dispatch call queued. Dispatch will run once initialization is complete.");
            this.aag = true;
        }
    }

    synchronized void cm() {
        if (!this.aal && this.connected && this.aaf > 0) {
            this.handler.removeMessages(1, sF);
            this.handler.sendMessage(this.handler.obtainMessage(1, sF));
        }
    }

    synchronized at lH() {
        if (this.aad == null) {
            if (this.aac == null) {
                throw new IllegalStateException("Cant get a store unless we have a context");
            }
            this.aad = new ca(this.aaj, this.aac);
        }
        if (this.handler == null) {
            ck();
        }
        this.aah = true;
        if (this.aag) {
            bW();
            this.aag = false;
        }
        if (this.aak == null && this.aai) {
            cj();
        }
        return this.aad;
    }

    synchronized void m9502s(boolean z) {
        m9501a(this.aal, z);
    }
}
