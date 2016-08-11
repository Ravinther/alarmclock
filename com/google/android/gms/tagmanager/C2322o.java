package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.C1461a.C1402a;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.C1788c.C1783f;
import com.google.android.gms.internal.C1788c.C1787j;
import com.google.android.gms.internal.gl;
import com.google.android.gms.internal.gn;
import com.google.android.gms.internal.it.C1992a;
import com.google.android.gms.tagmanager.C2315n.C2313a;
import com.google.android.gms.tagmanager.bg.C2264a;
import com.google.android.gms.tagmanager.cd.C2271a;
import com.google.android.gms.tagmanager.cq.C2283c;

/* renamed from: com.google.android.gms.tagmanager.o */
class C2322o extends C1402a {
    private final Looper AS;
    private final String WJ;
    private long WO;
    private final TagManager WW;
    private final C2321d WZ;
    private final gl Wv;
    private final cf Xa;
    private final int Xb;
    private C2279f Xc;
    private volatile C2315n Xd;
    private volatile boolean Xe;
    private C1787j Xf;
    private String Xg;
    private C2276e Xh;
    private C2317a Xi;
    private final Context mContext;

    /* renamed from: com.google.android.gms.tagmanager.o.e */
    interface C2276e extends Releasable {
        void m9431a(bg bgVar);

        void bu(String str);

        void m9432d(long j, String str);
    }

    /* renamed from: com.google.android.gms.tagmanager.o.f */
    interface C2279f extends Releasable {
        void m9437a(bg bgVar);

        void m9438b(C1992a c1992a);

        C2283c ca(int i);

        void km();
    }

    /* renamed from: com.google.android.gms.tagmanager.o.1 */
    class C23161 implements C2313a {
        final /* synthetic */ C2322o Xj;

        C23161(C2322o c2322o) {
            this.Xj = c2322o;
        }

        public void br(String str) {
            this.Xj.br(str);
        }

        public String ke() {
            return this.Xj.ke();
        }

        public void kg() {
            bh.m9376z("Refresh ignored: container loaded as default only.");
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.o.a */
    interface C2317a {
        boolean m9556b(Container container);
    }

    /* renamed from: com.google.android.gms.tagmanager.o.2 */
    class C23182 implements C2317a {
        final /* synthetic */ C2322o Xj;
        final /* synthetic */ boolean Xk;

        C23182(C2322o c2322o, boolean z) {
            this.Xj = c2322o;
            this.Xk = z;
        }

        public boolean m9557b(Container container) {
            return this.Xk ? container.getLastRefreshTime() + 43200000 >= this.Xj.Wv.currentTimeMillis() : !container.isDefault();
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.o.b */
    private class C2319b implements bg {
        final /* synthetic */ C2322o Xj;

        private C2319b(C2322o c2322o) {
            this.Xj = c2322o;
        }

        public void m9558a(C1992a c1992a) {
            C1787j c1787j;
            if (c1992a.aaZ != null) {
                c1787j = c1992a.aaZ;
            } else {
                C1783f c1783f = c1992a.fK;
                c1787j = new C1787j();
                c1787j.fK = c1783f;
                c1787j.fJ = null;
                c1787j.fL = c1783f.fg;
            }
            this.Xj.m9567a(c1787j, c1992a.aaY, true);
        }

        public void m9559a(C2264a c2264a) {
            if (!this.Xj.Xe) {
                this.Xj.m9577t(0);
            }
        }

        public /* synthetic */ void m9560i(Object obj) {
            m9558a((C1992a) obj);
        }

        public void kl() {
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.o.c */
    private class C2320c implements bg {
        final /* synthetic */ C2322o Xj;

        private C2320c(C2322o c2322o) {
            this.Xj = c2322o;
        }

        public void m9561a(C2264a c2264a) {
            if (this.Xj.Xd != null) {
                this.Xj.m6054a(this.Xj.Xd);
            } else {
                this.Xj.m6054a(this.Xj.ac(Status.By));
            }
            this.Xj.m9577t(3600000);
        }

        public void m9562b(C1787j c1787j) {
            synchronized (this.Xj) {
                if (c1787j.fK == null) {
                    if (this.Xj.Xf.fK == null) {
                        bh.m9373w("Current resource is null; network resource is also null");
                        this.Xj.m9577t(3600000);
                        return;
                    }
                    c1787j.fK = this.Xj.Xf.fK;
                }
                this.Xj.m9567a(c1787j, this.Xj.Wv.currentTimeMillis(), false);
                bh.m9375y("setting refresh time to current time: " + this.Xj.WO);
                if (!this.Xj.kk()) {
                    this.Xj.m9566a(c1787j);
                }
            }
        }

        public /* synthetic */ void m9563i(Object obj) {
            m9562b((C1787j) obj);
        }

        public void kl() {
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.o.d */
    private class C2321d implements C2313a {
        final /* synthetic */ C2322o Xj;

        private C2321d(C2322o c2322o) {
            this.Xj = c2322o;
        }

        public void br(String str) {
            this.Xj.br(str);
        }

        public String ke() {
            return this.Xj.ke();
        }

        public void kg() {
            if (this.Xj.Xa.cS()) {
                this.Xj.m9577t(0);
            }
        }
    }

    C2322o(Context context, TagManager tagManager, Looper looper, String str, int i, C2279f c2279f, C2276e c2276e, gl glVar, cf cfVar) {
        super(looper == null ? Looper.getMainLooper() : looper);
        this.mContext = context;
        this.WW = tagManager;
        if (looper == null) {
            looper = Looper.getMainLooper();
        }
        this.AS = looper;
        this.WJ = str;
        this.Xb = i;
        this.Xc = c2279f;
        this.Xh = c2276e;
        this.WZ = new C2321d();
        this.Xf = new C1787j();
        this.Wv = glVar;
        this.Xa = cfVar;
        if (kk()) {
            br(cd.kT().kV());
        }
    }

    public C2322o(Context context, TagManager tagManager, Looper looper, String str, int i, C2325r c2325r) {
        this(context, tagManager, looper, str, i, new cp(context, str), new co(context, str, c2325r), gn.ft(), new bf(30, 900000, 5000, "refreshing", gn.ft()));
    }

    private void m9564C(boolean z) {
        this.Xc.m9437a(new C2319b());
        this.Xh.m9431a(new C2320c());
        C2283c ca = this.Xc.ca(this.Xb);
        if (ca != null) {
            this.Xd = new C2315n(this.WW, this.AS, new Container(this.mContext, this.WW.getDataLayer(), this.WJ, 0, ca), this.WZ);
        }
        this.Xi = new C23182(this, z);
        if (kk()) {
            this.Xh.m9432d(0, "");
        } else {
            this.Xc.km();
        }
    }

    private synchronized void m9566a(C1787j c1787j) {
        if (this.Xc != null) {
            C1992a c1992a = new C1992a();
            c1992a.aaY = this.WO;
            c1992a.fK = new C1783f();
            c1992a.aaZ = c1787j;
            this.Xc.m9438b(c1992a);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void m9567a(com.google.android.gms.internal.C1788c.C1787j r9, long r10, boolean r12) {
        /*
        r8 = this;
        r6 = 43200000; // 0x2932e00 float:2.1626111E-37 double:2.1343636E-316;
        monitor-enter(r8);
        if (r12 == 0) goto L_0x000c;
    L_0x0006:
        r0 = r8.Xe;	 Catch:{ all -> 0x006a }
        if (r0 == 0) goto L_0x000c;
    L_0x000a:
        monitor-exit(r8);
        return;
    L_0x000c:
        r0 = r8.isReady();	 Catch:{ all -> 0x006a }
        if (r0 == 0) goto L_0x0016;
    L_0x0012:
        r0 = r8.Xd;	 Catch:{ all -> 0x006a }
        if (r0 != 0) goto L_0x0016;
    L_0x0016:
        r8.Xf = r9;	 Catch:{ all -> 0x006a }
        r8.WO = r10;	 Catch:{ all -> 0x006a }
        r0 = 0;
        r2 = 43200000; // 0x2932e00 float:2.1626111E-37 double:2.1343636E-316;
        r4 = r8.WO;	 Catch:{ all -> 0x006a }
        r4 = r4 + r6;
        r6 = r8.Wv;	 Catch:{ all -> 0x006a }
        r6 = r6.currentTimeMillis();	 Catch:{ all -> 0x006a }
        r4 = r4 - r6;
        r2 = java.lang.Math.min(r2, r4);	 Catch:{ all -> 0x006a }
        r0 = java.lang.Math.max(r0, r2);	 Catch:{ all -> 0x006a }
        r8.m9577t(r0);	 Catch:{ all -> 0x006a }
        r0 = new com.google.android.gms.tagmanager.Container;	 Catch:{ all -> 0x006a }
        r1 = r8.mContext;	 Catch:{ all -> 0x006a }
        r2 = r8.WW;	 Catch:{ all -> 0x006a }
        r2 = r2.getDataLayer();	 Catch:{ all -> 0x006a }
        r3 = r8.WJ;	 Catch:{ all -> 0x006a }
        r4 = r10;
        r6 = r9;
        r0.<init>(r1, r2, r3, r4, r6);	 Catch:{ all -> 0x006a }
        r1 = r8.Xd;	 Catch:{ all -> 0x006a }
        if (r1 != 0) goto L_0x006d;
    L_0x0049:
        r1 = new com.google.android.gms.tagmanager.n;	 Catch:{ all -> 0x006a }
        r2 = r8.WW;	 Catch:{ all -> 0x006a }
        r3 = r8.AS;	 Catch:{ all -> 0x006a }
        r4 = r8.WZ;	 Catch:{ all -> 0x006a }
        r1.<init>(r2, r3, r0, r4);	 Catch:{ all -> 0x006a }
        r8.Xd = r1;	 Catch:{ all -> 0x006a }
    L_0x0056:
        r1 = r8.isReady();	 Catch:{ all -> 0x006a }
        if (r1 != 0) goto L_0x000a;
    L_0x005c:
        r1 = r8.Xi;	 Catch:{ all -> 0x006a }
        r0 = r1.m9556b(r0);	 Catch:{ all -> 0x006a }
        if (r0 == 0) goto L_0x000a;
    L_0x0064:
        r0 = r8.Xd;	 Catch:{ all -> 0x006a }
        r8.m6054a(r0);	 Catch:{ all -> 0x006a }
        goto L_0x000a;
    L_0x006a:
        r0 = move-exception;
        monitor-exit(r8);
        throw r0;
    L_0x006d:
        r1 = r8.Xd;	 Catch:{ all -> 0x006a }
        r1.m9555a(r0);	 Catch:{ all -> 0x006a }
        goto L_0x0056;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.o.a(com.google.android.gms.internal.c$j, long, boolean):void");
    }

    private boolean kk() {
        cd kT = cd.kT();
        return (kT.kU() == C2271a.CONTAINER || kT.kU() == C2271a.CONTAINER_DEBUG) && this.WJ.equals(kT.getContainerId());
    }

    private synchronized void m9577t(long j) {
        if (this.Xh == null) {
            bh.m9376z("Refresh requested, but no network load scheduler.");
        } else {
            this.Xh.m9432d(j, this.Xf.fL);
        }
    }

    protected ContainerHolder ac(Status status) {
        if (this.Xd != null) {
            return this.Xd;
        }
        if (status == Status.By) {
            bh.m9373w("timer expired: setting result to failure");
        }
        return new C2315n(status);
    }

    synchronized void br(String str) {
        this.Xg = str;
        if (this.Xh != null) {
            this.Xh.bu(str);
        }
    }

    protected /* synthetic */ Result m9578d(Status status) {
        return ac(status);
    }

    synchronized String ke() {
        return this.Xg;
    }

    public void kh() {
        C2283c ca = this.Xc.ca(this.Xb);
        if (ca != null) {
            m6054a(new C2315n(this.WW, this.AS, new Container(this.mContext, this.WW.getDataLayer(), this.WJ, 0, ca), new C23161(this)));
        } else {
            String str = "Default was requested, but no default container was found";
            bh.m9373w(str);
            m6054a(ac(new Status(10, str, null)));
        }
        this.Xh = null;
        this.Xc = null;
    }

    public void ki() {
        m9564C(false);
    }

    public void kj() {
        m9564C(true);
    }
}
