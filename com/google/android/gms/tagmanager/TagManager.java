package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.tagmanager.DataLayer.C2248b;
import com.google.android.gms.tagmanager.cd.C2271a;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class TagManager {
    private static TagManager aay;
    private final DataLayer WK;
    private final C2325r Zg;
    private final C2251a aaw;
    private final ConcurrentMap aax;
    private final Context mContext;

    /* renamed from: com.google.android.gms.tagmanager.TagManager.1 */
    class C22501 implements C2248b {
        final /* synthetic */ TagManager aaz;

        C22501(TagManager tagManager) {
            this.aaz = tagManager;
        }

        public void m9300y(Map map) {
            Object obj = map.get(DataLayer.EVENT_KEY);
            if (obj != null) {
                this.aaz.bT(obj.toString());
            }
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.TagManager.a */
    interface C2251a {
        C2322o m9301a(Context context, TagManager tagManager, Looper looper, String str, int i, C2325r c2325r);
    }

    /* renamed from: com.google.android.gms.tagmanager.TagManager.2 */
    static class C22522 implements C2251a {
        C22522() {
        }

        public C2322o m9302a(Context context, TagManager tagManager, Looper looper, String str, int i, C2325r c2325r) {
            return new C2322o(context, tagManager, looper, str, i, c2325r);
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.TagManager.3 */
    static /* synthetic */ class C22533 {
        static final /* synthetic */ int[] aaA;

        static {
            aaA = new int[C2271a.values().length];
            try {
                aaA[C2271a.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                aaA[C2271a.CONTAINER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                aaA[C2271a.CONTAINER_DEBUG.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    TagManager(Context context, C2251a containerHolderLoaderProvider, DataLayer dataLayer) {
        if (context == null) {
            throw new NullPointerException("context cannot be null");
        }
        this.mContext = context.getApplicationContext();
        this.aaw = containerHolderLoaderProvider;
        this.aax = new ConcurrentHashMap();
        this.WK = dataLayer;
        this.WK.m9294a(new C22501(this));
        this.WK.m9294a(new C2300d(this.mContext));
        this.Zg = new C2325r();
    }

    private void bT(String str) {
        for (C2315n bp : this.aax.keySet()) {
            bp.bp(str);
        }
    }

    public static TagManager getInstance(Context context) {
        TagManager tagManager;
        synchronized (TagManager.class) {
            if (aay == null) {
                if (context == null) {
                    bh.m9373w("TagManager.getInstance requires non-null context.");
                    throw new NullPointerException();
                }
                aay = new TagManager(context, new C22522(), new DataLayer(new C2333v(context)));
            }
            tagManager = aay;
        }
        return tagManager;
    }

    void m9304a(C2315n c2315n) {
        this.aax.put(c2315n, Boolean.valueOf(true));
    }

    boolean m9305b(C2315n c2315n) {
        return this.aax.remove(c2315n) != null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    synchronized boolean m9306g(android.net.Uri r6) {
        /*
        r5 = this;
        monitor-enter(r5);
        r1 = com.google.android.gms.tagmanager.cd.kT();	 Catch:{ all -> 0x0049 }
        r0 = r1.m9423g(r6);	 Catch:{ all -> 0x0049 }
        if (r0 == 0) goto L_0x0085;
    L_0x000b:
        r2 = r1.getContainerId();	 Catch:{ all -> 0x0049 }
        r0 = com.google.android.gms.tagmanager.TagManager.C22533.aaA;	 Catch:{ all -> 0x0049 }
        r3 = r1.kU();	 Catch:{ all -> 0x0049 }
        r3 = r3.ordinal();	 Catch:{ all -> 0x0049 }
        r0 = r0[r3];	 Catch:{ all -> 0x0049 }
        switch(r0) {
            case 1: goto L_0x0021;
            case 2: goto L_0x004c;
            case 3: goto L_0x004c;
            default: goto L_0x001e;
        };
    L_0x001e:
        r0 = 1;
    L_0x001f:
        monitor-exit(r5);
        return r0;
    L_0x0021:
        r0 = r5.aax;	 Catch:{ all -> 0x0049 }
        r0 = r0.keySet();	 Catch:{ all -> 0x0049 }
        r1 = r0.iterator();	 Catch:{ all -> 0x0049 }
    L_0x002b:
        r0 = r1.hasNext();	 Catch:{ all -> 0x0049 }
        if (r0 == 0) goto L_0x001e;
    L_0x0031:
        r0 = r1.next();	 Catch:{ all -> 0x0049 }
        r0 = (com.google.android.gms.tagmanager.C2315n) r0;	 Catch:{ all -> 0x0049 }
        r3 = r0.getContainerId();	 Catch:{ all -> 0x0049 }
        r3 = r3.equals(r2);	 Catch:{ all -> 0x0049 }
        if (r3 == 0) goto L_0x002b;
    L_0x0041:
        r3 = 0;
        r0.br(r3);	 Catch:{ all -> 0x0049 }
        r0.refresh();	 Catch:{ all -> 0x0049 }
        goto L_0x002b;
    L_0x0049:
        r0 = move-exception;
        monitor-exit(r5);
        throw r0;
    L_0x004c:
        r0 = r5.aax;	 Catch:{ all -> 0x0049 }
        r0 = r0.keySet();	 Catch:{ all -> 0x0049 }
        r3 = r0.iterator();	 Catch:{ all -> 0x0049 }
    L_0x0056:
        r0 = r3.hasNext();	 Catch:{ all -> 0x0049 }
        if (r0 == 0) goto L_0x001e;
    L_0x005c:
        r0 = r3.next();	 Catch:{ all -> 0x0049 }
        r0 = (com.google.android.gms.tagmanager.C2315n) r0;	 Catch:{ all -> 0x0049 }
        r4 = r0.getContainerId();	 Catch:{ all -> 0x0049 }
        r4 = r4.equals(r2);	 Catch:{ all -> 0x0049 }
        if (r4 == 0) goto L_0x0077;
    L_0x006c:
        r4 = r1.kV();	 Catch:{ all -> 0x0049 }
        r0.br(r4);	 Catch:{ all -> 0x0049 }
        r0.refresh();	 Catch:{ all -> 0x0049 }
        goto L_0x0056;
    L_0x0077:
        r4 = r0.ke();	 Catch:{ all -> 0x0049 }
        if (r4 == 0) goto L_0x0056;
    L_0x007d:
        r4 = 0;
        r0.br(r4);	 Catch:{ all -> 0x0049 }
        r0.refresh();	 Catch:{ all -> 0x0049 }
        goto L_0x0056;
    L_0x0085:
        r0 = 0;
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.TagManager.g(android.net.Uri):boolean");
    }

    public DataLayer getDataLayer() {
        return this.WK;
    }

    public PendingResult loadContainerDefaultOnly(String containerId, int defaultContainerResourceId) {
        PendingResult a = this.aaw.m9301a(this.mContext, this, null, containerId, defaultContainerResourceId, this.Zg);
        a.kh();
        return a;
    }

    public PendingResult loadContainerDefaultOnly(String containerId, int defaultContainerResourceId, Handler handler) {
        PendingResult a = this.aaw.m9301a(this.mContext, this, handler.getLooper(), containerId, defaultContainerResourceId, this.Zg);
        a.kh();
        return a;
    }

    public PendingResult loadContainerPreferFresh(String containerId, int defaultContainerResourceId) {
        PendingResult a = this.aaw.m9301a(this.mContext, this, null, containerId, defaultContainerResourceId, this.Zg);
        a.kj();
        return a;
    }

    public PendingResult loadContainerPreferFresh(String containerId, int defaultContainerResourceId, Handler handler) {
        PendingResult a = this.aaw.m9301a(this.mContext, this, handler.getLooper(), containerId, defaultContainerResourceId, this.Zg);
        a.kj();
        return a;
    }

    public PendingResult loadContainerPreferNonDefault(String containerId, int defaultContainerResourceId) {
        PendingResult a = this.aaw.m9301a(this.mContext, this, null, containerId, defaultContainerResourceId, this.Zg);
        a.ki();
        return a;
    }

    public PendingResult loadContainerPreferNonDefault(String containerId, int defaultContainerResourceId, Handler handler) {
        PendingResult a = this.aaw.m9301a(this.mContext, this, handler.getLooper(), containerId, defaultContainerResourceId, this.Zg);
        a.ki();
        return a;
    }

    public void setVerboseLoggingEnabled(boolean enableVerboseLogging) {
        bh.setLogLevel(enableVerboseLogging ? 2 : 5);
    }
}
