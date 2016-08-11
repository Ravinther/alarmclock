package com.google.android.gms.internal;

import android.os.Handler;
import java.lang.ref.WeakReference;

/* renamed from: com.google.android.gms.internal.x */
public final class C2048x {
    private final C2047a kV;
    private final Runnable kW;
    private ah kX;
    private boolean kY;
    private boolean kZ;
    private long la;

    /* renamed from: com.google.android.gms.internal.x.1 */
    class C20461 implements Runnable {
        private final WeakReference lb;
        final /* synthetic */ C2043v lc;
        final /* synthetic */ C2048x ld;

        C20461(C2048x c2048x, C2043v c2043v) {
            this.ld = c2048x;
            this.lc = c2043v;
            this.lb = new WeakReference(this.lc);
        }

        public void run() {
            this.ld.kY = false;
            C2043v c2043v = (C2043v) this.lb.get();
            if (c2043v != null) {
                c2043v.m9017b(this.ld.kX);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.x.a */
    public static class C2047a {
        private final Handler mHandler;

        public C2047a(Handler handler) {
            this.mHandler = handler;
        }

        public boolean postDelayed(Runnable runnable, long timeFromNowInMillis) {
            return this.mHandler.postDelayed(runnable, timeFromNowInMillis);
        }

        public void removeCallbacks(Runnable runnable) {
            this.mHandler.removeCallbacks(runnable);
        }
    }

    public C2048x(C2043v c2043v) {
        this(c2043v, new C2047a(dv.rp));
    }

    C2048x(C2043v c2043v, C2047a c2047a) {
        this.kY = false;
        this.kZ = false;
        this.la = 0;
        this.kV = c2047a;
        this.kW = new C20461(this, c2043v);
    }

    public void m9022a(ah ahVar, long j) {
        if (this.kY) {
            dw.m8221z("An ad refresh is already scheduled.");
            return;
        }
        this.kX = ahVar;
        this.kY = true;
        this.la = j;
        if (!this.kZ) {
            dw.m8219x("Scheduling ad refresh " + j + " milliseconds from now.");
            this.kV.postDelayed(this.kW, j);
        }
    }

    public void cancel() {
        this.kY = false;
        this.kV.removeCallbacks(this.kW);
    }

    public void m9023d(ah ahVar) {
        m9022a(ahVar, 60000);
    }

    public void pause() {
        this.kZ = true;
        if (this.kY) {
            this.kV.removeCallbacks(this.kW);
        }
    }

    public void resume() {
        this.kZ = false;
        if (this.kY) {
            this.kY = false;
            m9022a(this.kX, this.la);
        }
    }
}
