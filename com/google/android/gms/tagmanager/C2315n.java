package com.google.android.gms.tagmanager;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tagmanager.ContainerHolder.ContainerAvailableListener;
import com.mopub.mobileads.util.Base64;

/* renamed from: com.google.android.gms.tagmanager.n */
class C2315n implements ContainerHolder {
    private final Looper AS;
    private Container WR;
    private Container WS;
    private C2314b WT;
    private C2313a WU;
    private boolean WV;
    private TagManager WW;
    private Status wJ;

    /* renamed from: com.google.android.gms.tagmanager.n.a */
    public interface C2313a {
        void br(String str);

        String ke();

        void kg();
    }

    /* renamed from: com.google.android.gms.tagmanager.n.b */
    private class C2314b extends Handler {
        private final ContainerAvailableListener WX;
        final /* synthetic */ C2315n WY;

        public C2314b(C2315n c2315n, ContainerAvailableListener containerAvailableListener, Looper looper) {
            this.WY = c2315n;
            super(looper);
            this.WX = containerAvailableListener;
        }

        public void bs(String str) {
            sendMessage(obtainMessage(1, str));
        }

        protected void bt(String str) {
            this.WX.onContainerAvailable(this.WY, str);
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case Base64.NO_PADDING /*1*/:
                    bt((String) msg.obj);
                default:
                    bh.m9373w("Don't know how to handle this message.");
            }
        }
    }

    public C2315n(Status status) {
        this.wJ = status;
        this.AS = null;
    }

    public C2315n(TagManager tagManager, Looper looper, Container container, C2313a c2313a) {
        this.WW = tagManager;
        if (looper == null) {
            looper = Looper.getMainLooper();
        }
        this.AS = looper;
        this.WR = container;
        this.WU = c2313a;
        this.wJ = Status.Bv;
        tagManager.m9304a(this);
    }

    private void kf() {
        if (this.WT != null) {
            this.WT.bs(this.WS.kc());
        }
    }

    public synchronized void m9555a(Container container) {
        if (!this.WV) {
            if (container == null) {
                bh.m9373w("Unexpected null container.");
            } else {
                this.WS = container;
                kf();
            }
        }
    }

    public synchronized void bp(String str) {
        if (!this.WV) {
            this.WR.bp(str);
        }
    }

    void br(String str) {
        if (this.WV) {
            bh.m9373w("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
        } else {
            this.WU.br(str);
        }
    }

    public synchronized Container getContainer() {
        Container container = null;
        synchronized (this) {
            if (this.WV) {
                bh.m9373w("ContainerHolder is released.");
            } else {
                if (this.WS != null) {
                    this.WR = this.WS;
                    this.WS = null;
                }
                container = this.WR;
            }
        }
        return container;
    }

    String getContainerId() {
        if (!this.WV) {
            return this.WR.getContainerId();
        }
        bh.m9373w("getContainerId called on a released ContainerHolder.");
        return "";
    }

    public Status getStatus() {
        return this.wJ;
    }

    String ke() {
        if (!this.WV) {
            return this.WU.ke();
        }
        bh.m9373w("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
        return "";
    }

    public synchronized void refresh() {
        if (this.WV) {
            bh.m9373w("Refreshing a released ContainerHolder.");
        } else {
            this.WU.kg();
        }
    }

    public synchronized void release() {
        if (this.WV) {
            bh.m9373w("Releasing a released ContainerHolder.");
        } else {
            this.WV = true;
            this.WW.m9305b(this);
            this.WR.release();
            this.WR = null;
            this.WS = null;
            this.WU = null;
            this.WT = null;
        }
    }

    public synchronized void setContainerAvailableListener(ContainerAvailableListener listener) {
        if (this.WV) {
            bh.m9373w("ContainerHolder is released.");
        } else if (listener == null) {
            this.WT = null;
        } else {
            this.WT = new C2314b(this, listener, this.AS);
            if (this.WS != null) {
                kf();
            }
        }
    }
}
