package com.google.android.gms.internal;

/* renamed from: com.google.android.gms.internal.do */
public abstract class C1810do {
    private final Runnable kW;
    private volatile Thread qY;

    /* renamed from: com.google.android.gms.internal.do.1 */
    class C18251 implements Runnable {
        final /* synthetic */ C1810do qZ;

        C18251(C1810do c1810do) {
            this.qZ = c1810do;
        }

        public final void run() {
            this.qZ.qY = Thread.currentThread();
            this.qZ.aY();
        }
    }

    public C1810do() {
        this.kW = new C18251(this);
    }

    public abstract void aY();

    public final void cancel() {
        onStop();
        if (this.qY != null) {
            this.qY.interrupt();
        }
    }

    public abstract void onStop();

    public final void start() {
        dp.execute(this.kW);
    }
}
