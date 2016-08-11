package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.tagmanager.C2322o.C2276e;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class co implements C2276e {
    private final String WJ;
    private String Xg;
    private bg Zf;
    private C2325r Zg;
    private final ScheduledExecutorService Zi;
    private final C2274a Zj;
    private ScheduledFuture Zk;
    private boolean mClosed;
    private final Context mContext;

    /* renamed from: com.google.android.gms.tagmanager.co.b */
    interface C2272b {
        ScheduledExecutorService la();
    }

    /* renamed from: com.google.android.gms.tagmanager.co.1 */
    class C22731 implements C2272b {
        final /* synthetic */ co Zl;

        C22731(co coVar) {
            this.Zl = coVar;
        }

        public ScheduledExecutorService la() {
            return Executors.newSingleThreadScheduledExecutor();
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.co.a */
    interface C2274a {
        cn m9429a(C2325r c2325r);
    }

    /* renamed from: com.google.android.gms.tagmanager.co.2 */
    class C22752 implements C2274a {
        final /* synthetic */ co Zl;

        C22752(co coVar) {
            this.Zl = coVar;
        }

        public cn m9430a(C2325r c2325r) {
            return new cn(this.Zl.mContext, this.Zl.WJ, c2325r);
        }
    }

    public co(Context context, String str, C2325r c2325r) {
        this(context, str, c2325r, null, null);
    }

    co(Context context, String str, C2325r c2325r, C2272b c2272b, C2274a c2274a) {
        this.Zg = c2325r;
        this.mContext = context;
        this.WJ = str;
        if (c2272b == null) {
            c2272b = new C22731(this);
        }
        this.Zi = c2272b.la();
        if (c2274a == null) {
            this.Zj = new C22752(this);
        } else {
            this.Zj = c2274a;
        }
    }

    private cn bK(String str) {
        cn a = this.Zj.m9429a(this.Zg);
        a.m9428a(this.Zf);
        a.bu(this.Xg);
        a.bJ(str);
        return a;
    }

    private synchronized void kZ() {
        if (this.mClosed) {
            throw new IllegalStateException("called method after closed");
        }
    }

    public synchronized void m9435a(bg bgVar) {
        kZ();
        this.Zf = bgVar;
    }

    public synchronized void bu(String str) {
        kZ();
        this.Xg = str;
    }

    public synchronized void m9436d(long j, String str) {
        bh.m9375y("loadAfterDelay: containerId=" + this.WJ + " delay=" + j);
        kZ();
        if (this.Zf == null) {
            throw new IllegalStateException("callback must be set before loadAfterDelay() is called.");
        }
        if (this.Zk != null) {
            this.Zk.cancel(false);
        }
        this.Zk = this.Zi.schedule(bK(str), j, TimeUnit.MILLISECONDS);
    }

    public synchronized void release() {
        kZ();
        if (this.Zk != null) {
            this.Zk.cancel(false);
        }
        this.Zi.shutdown();
        this.mClosed = true;
    }
}
