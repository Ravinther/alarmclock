package com.google.android.gms.internal;

import android.os.SystemClock;
import org.json.JSONObject;

public final class ev {
    public static final Object Ab;
    private static final er zb;
    private eu Aa;
    private long zX;
    private long zY;
    private long zZ;

    static {
        zb = new er("RequestTracker");
        Ab = new Object();
    }

    public ev(long j) {
        this.zX = j;
        this.zY = -1;
        this.zZ = 0;
    }

    private void dT() {
        this.zY = -1;
        this.Aa = null;
        this.zZ = 0;
    }

    public void m8391a(long j, eu euVar) {
        synchronized (Ab) {
            eu euVar2 = this.Aa;
            long j2 = this.zY;
            this.zY = j;
            this.Aa = euVar;
            this.zZ = SystemClock.elapsedRealtime();
        }
        if (euVar2 != null) {
            euVar2.m6192l(j2);
        }
    }

    public boolean m8392b(long j, int i, JSONObject jSONObject) {
        boolean z = true;
        eu euVar = null;
        synchronized (Ab) {
            if (this.zY == -1 || this.zY != j) {
                z = false;
            } else {
                zb.m8388b("request %d completed", Long.valueOf(this.zY));
                euVar = this.Aa;
                dT();
            }
        }
        if (euVar != null) {
            euVar.m6191a(j, i, jSONObject);
        }
        return z;
    }

    public boolean m8393c(long j, int i) {
        return m8392b(j, i, null);
    }

    public void clear() {
        synchronized (Ab) {
            if (this.zY != -1) {
                dT();
            }
        }
    }

    public boolean m8394d(long j, int i) {
        eu euVar;
        boolean z = true;
        long j2 = 0;
        synchronized (Ab) {
            if (this.zY == -1 || j - this.zZ < this.zX) {
                z = false;
                euVar = null;
            } else {
                zb.m8388b("request %d timed out", Long.valueOf(this.zY));
                j2 = this.zY;
                euVar = this.Aa;
                dT();
            }
        }
        if (euVar != null) {
            euVar.m6191a(j2, i, null);
        }
        return z;
    }

    public boolean dU() {
        boolean z;
        synchronized (Ab) {
            z = this.zY != -1;
        }
        return z;
    }

    public boolean m8395n(long j) {
        boolean z;
        synchronized (Ab) {
            z = this.zY != -1 && this.zY == j;
        }
        return z;
    }
}
