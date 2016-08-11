package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.Message;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.ff.C1894f;
import com.mopub.mobileads.util.Base64;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public final class fh implements Callback {
    private static final Object Du;
    private static fh Dv;
    private final HashMap Dw;
    private final Context lp;
    private final Handler mHandler;

    /* renamed from: com.google.android.gms.internal.fh.a */
    final class C1899a {
        private boolean DA;
        private IBinder DB;
        private ComponentName DC;
        final /* synthetic */ fh DD;
        private final String Dx;
        private final C1898a Dy;
        private final HashSet Dz;
        private int mState;

        /* renamed from: com.google.android.gms.internal.fh.a.a */
        public class C1898a implements ServiceConnection {
            final /* synthetic */ C1899a DE;

            public C1898a(C1899a c1899a) {
                this.DE = c1899a;
            }

            public void onServiceConnected(ComponentName component, IBinder binder) {
                synchronized (this.DE.DD.Dw) {
                    this.DE.DB = binder;
                    this.DE.DC = component;
                    Iterator it = this.DE.Dz.iterator();
                    while (it.hasNext()) {
                        ((C1894f) it.next()).onServiceConnected(component, binder);
                    }
                    this.DE.mState = 1;
                }
            }

            public void onServiceDisconnected(ComponentName component) {
                synchronized (this.DE.DD.Dw) {
                    this.DE.DB = null;
                    this.DE.DC = component;
                    Iterator it = this.DE.Dz.iterator();
                    while (it.hasNext()) {
                        ((C1894f) it.next()).onServiceDisconnected(component);
                    }
                    this.DE.mState = 2;
                }
            }
        }

        public C1899a(fh fhVar, String str) {
            this.DD = fhVar;
            this.Dx = str;
            this.Dy = new C1898a(this);
            this.Dz = new HashSet();
            this.mState = 0;
        }

        public void m8435a(C1894f c1894f) {
            this.Dz.add(c1894f);
        }

        public void m8436b(C1894f c1894f) {
            this.Dz.remove(c1894f);
        }

        public boolean m8437c(C1894f c1894f) {
            return this.Dz.contains(c1894f);
        }

        public C1898a eP() {
            return this.Dy;
        }

        public String eQ() {
            return this.Dx;
        }

        public boolean eR() {
            return this.Dz.isEmpty();
        }

        public IBinder getBinder() {
            return this.DB;
        }

        public ComponentName getComponentName() {
            return this.DC;
        }

        public int getState() {
            return this.mState;
        }

        public boolean isBound() {
            return this.DA;
        }

        public void m8438y(boolean z) {
            this.DA = z;
        }
    }

    static {
        Du = new Object();
    }

    private fh(Context context) {
        this.mHandler = new Handler(context.getMainLooper(), this);
        this.Dw = new HashMap();
        this.lp = context.getApplicationContext();
    }

    public static fh m8440x(Context context) {
        synchronized (Du) {
            if (Dv == null) {
                Dv = new fh(context.getApplicationContext());
            }
        }
        return Dv;
    }

    public boolean m8441a(String str, C1894f c1894f) {
        boolean isBound;
        synchronized (this.Dw) {
            C1899a c1899a = (C1899a) this.Dw.get(str);
            if (c1899a != null) {
                this.mHandler.removeMessages(0, c1899a);
                if (!c1899a.m8437c(c1894f)) {
                    c1899a.m8435a(c1894f);
                    switch (c1899a.getState()) {
                        case Base64.NO_PADDING /*1*/:
                            c1894f.onServiceConnected(c1899a.getComponentName(), c1899a.getBinder());
                            break;
                        case Base64.NO_WRAP /*2*/:
                            c1899a.m8438y(this.lp.bindService(new Intent(str).setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE), c1899a.eP(), 129));
                            break;
                        default:
                            break;
                    }
                }
                throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  startServiceAction=" + str);
            }
            c1899a = new C1899a(this, str);
            c1899a.m8435a(c1894f);
            c1899a.m8438y(this.lp.bindService(new Intent(str).setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE), c1899a.eP(), 129));
            this.Dw.put(str, c1899a);
            isBound = c1899a.isBound();
        }
        return isBound;
    }

    public void m8442b(String str, C1894f c1894f) {
        synchronized (this.Dw) {
            C1899a c1899a = (C1899a) this.Dw.get(str);
            if (c1899a == null) {
                throw new IllegalStateException("Nonexistent connection status for service action: " + str);
            } else if (c1899a.m8437c(c1894f)) {
                c1899a.m8436b(c1894f);
                if (c1899a.eR()) {
                    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0, c1899a), 5000);
                }
            } else {
                throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  startServiceAction=" + str);
            }
        }
    }

    public boolean handleMessage(Message msg) {
        switch (msg.what) {
            case Base64.DEFAULT /*0*/:
                C1899a c1899a = (C1899a) msg.obj;
                synchronized (this.Dw) {
                    if (c1899a.eR()) {
                        this.lp.unbindService(c1899a.eP());
                        this.Dw.remove(c1899a.eQ());
                    }
                    break;
                }
                return true;
            default:
                return false;
        }
    }
}
