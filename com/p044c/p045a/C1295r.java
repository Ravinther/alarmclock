package com.p044c.p045a;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.widget.ImageView;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;
import com.p044c.p045a.C1252a.C1251a;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;

/* renamed from: com.c.a.r */
public class C1295r {
    static final Handler f3906a;
    static C1295r f3907b;
    final Context f3908c;
    final C1276i f3909d;
    final C1266d f3910e;
    final C1307x f3911f;
    final Map f3912g;
    final Map f3913h;
    final ReferenceQueue f3914i;
    boolean f3915j;
    volatile boolean f3916k;
    boolean f3917l;
    private final C1291c f3918m;
    private final C1293e f3919n;
    private final C1290b f3920o;

    /* renamed from: com.c.a.r.1 */
    static class C12871 extends Handler {
        C12871(Looper x0) {
            super(x0);
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    C1252a action = msg.obj;
                    action.f3800a.m5499a(action.m5363d());
                case Base64.URL_SAFE /*8*/:
                    List batch = msg.obj;
                    int n = batch.size();
                    for (int i = 0; i < n; i++) {
                        C1260c hunter = (C1260c) batch.get(i);
                        hunter.f3816a.m5506a(hunter);
                    }
                default:
                    throw new AssertionError("Unknown handler message received: " + msg.what);
            }
        }
    }

    /* renamed from: com.c.a.r.a */
    public static class C1288a {
        private final Context f3888a;
        private C1254j f3889b;
        private ExecutorService f3890c;
        private C1266d f3891d;
        private C1291c f3892e;
        private C1293e f3893f;
        private boolean f3894g;
        private boolean f3895h;

        public C1288a(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null.");
            }
            this.f3888a = context.getApplicationContext();
        }

        public C1295r m5492a() {
            Context context = this.f3888a;
            if (this.f3889b == null) {
                this.f3889b = ab.m5380a(context);
            }
            if (this.f3891d == null) {
                this.f3891d = new C1281m(context);
            }
            if (this.f3890c == null) {
                this.f3890c = new C1297t();
            }
            if (this.f3893f == null) {
                this.f3893f = C1293e.f3905a;
            }
            C1307x stats = new C1307x(this.f3891d);
            C1276i dispatcher = new C1276i(context, this.f3890c, C1295r.f3906a, this.f3889b, this.f3891d, stats);
            return new C1295r(context, dispatcher, this.f3891d, this.f3892e, this.f3893f, stats, this.f3894g, this.f3895h);
        }
    }

    /* renamed from: com.c.a.r.b */
    private static class C1290b extends Thread {
        private final ReferenceQueue f3898a;
        private final Handler f3899b;

        /* renamed from: com.c.a.r.b.1 */
        class C12891 implements Runnable {
            final /* synthetic */ Exception f3896a;
            final /* synthetic */ C1290b f3897b;

            C12891(C1290b this$0, Exception exception) {
                this.f3897b = this$0;
                this.f3896a = exception;
            }

            public void run() {
                throw new RuntimeException(this.f3896a);
            }
        }

        C1290b(ReferenceQueue referenceQueue, Handler handler) {
            this.f3898a = referenceQueue;
            this.f3899b = handler;
            setDaemon(true);
            setName("Picasso-refQueue");
        }

        public void run() {
            Process.setThreadPriority(10);
            while (true) {
                try {
                    this.f3899b.sendMessage(this.f3899b.obtainMessage(3, ((C1251a) this.f3898a.remove()).f3799a));
                } catch (InterruptedException e) {
                    return;
                } catch (Exception e2) {
                    this.f3899b.post(new C12891(this, e2));
                    return;
                }
            }
        }
    }

    /* renamed from: com.c.a.r.c */
    public interface C1291c {
        void m5493a(C1295r c1295r, Uri uri, Exception exception);
    }

    /* renamed from: com.c.a.r.d */
    public enum C1292d {
        MEMORY(-16711936),
        DISK(-256),
        NETWORK(-65536);
        
        final int f3904d;

        private C1292d(int debugColor) {
            this.f3904d = debugColor;
        }
    }

    /* renamed from: com.c.a.r.e */
    public interface C1293e {
        public static final C1293e f3905a;

        /* renamed from: com.c.a.r.e.1 */
        static class C12941 implements C1293e {
            C12941() {
            }

            public C1300u m5495a(C1300u request) {
                return request;
            }
        }

        C1300u m5494a(C1300u c1300u);

        static {
            f3905a = new C12941();
        }
    }

    static {
        f3906a = new C12871(Looper.getMainLooper());
        f3907b = null;
    }

    C1295r(Context context, C1276i dispatcher, C1266d cache, C1291c listener, C1293e requestTransformer, C1307x stats, boolean indicatorsEnabled, boolean loggingEnabled) {
        this.f3908c = context;
        this.f3909d = dispatcher;
        this.f3910e = cache;
        this.f3918m = listener;
        this.f3919n = requestTransformer;
        this.f3911f = stats;
        this.f3912g = new WeakHashMap();
        this.f3913h = new WeakHashMap();
        this.f3915j = indicatorsEnabled;
        this.f3916k = loggingEnabled;
        this.f3914i = new ReferenceQueue();
        this.f3920o = new C1290b(this.f3914i, f3906a);
        this.f3920o.start();
    }

    public void m5503a(ImageView view) {
        m5499a((Object) view);
    }

    public C1303v m5502a(int resourceId) {
        if (resourceId != 0) {
            return new C1303v(this, null, resourceId);
        }
        throw new IllegalArgumentException("Resource ID must not be zero.");
    }

    C1300u m5501a(C1300u request) {
        C1300u transformed = this.f3919n.m5494a(request);
        if (transformed != null) {
            return transformed;
        }
        throw new IllegalStateException("Request transformer " + this.f3919n.getClass().getCanonicalName() + " returned null for " + request);
    }

    void m5504a(ImageView view, C1271h request) {
        this.f3913h.put(view, request);
    }

    void m5505a(C1252a action) {
        Object target = action.m5363d();
        if (target != null) {
            m5499a(target);
            this.f3912g.put(target, action);
        }
        m5507b(action);
    }

    void m5507b(C1252a action) {
        this.f3909d.m5453a(action);
    }

    Bitmap m5500a(String key) {
        Bitmap cached = this.f3910e.m5429a(key);
        if (cached != null) {
            this.f3911f.m5536a();
        } else {
            this.f3911f.m5540b();
        }
        return cached;
    }

    void m5506a(C1260c hunter) {
        boolean hasMultiple;
        boolean shouldDeliver = false;
        C1252a single = hunter.m5420j();
        List joined = hunter.m5422l();
        if (joined == null || joined.isEmpty()) {
            hasMultiple = false;
        } else {
            hasMultiple = true;
        }
        if (single != null || hasMultiple) {
            shouldDeliver = true;
        }
        if (shouldDeliver) {
            Uri uri = hunter.m5419i().f3944c;
            Exception exception = hunter.m5423m();
            Bitmap result = hunter.m5417g();
            C1292d from = hunter.m5407a();
            if (single != null) {
                m5497a(result, from, single);
            }
            if (hasMultiple) {
                int n = joined.size();
                for (int i = 0; i < n; i++) {
                    m5497a(result, from, (C1252a) joined.get(i));
                }
            }
            if (this.f3918m != null && exception != null) {
                this.f3918m.m5493a(this, uri, exception);
            }
        }
    }

    private void m5497a(Bitmap result, C1292d from, C1252a action) {
        if (!action.m5365f()) {
            if (!action.m5366g()) {
                this.f3912g.remove(action.m5363d());
            }
            if (result == null) {
                action.m5359a();
                if (this.f3916k) {
                    ab.m5388a("Main", "errored", action.f3801b.m5518a());
                }
            } else if (from == null) {
                throw new AssertionError("LoadedFrom cannot be null.");
            } else {
                action.m5360a(result, from);
                if (this.f3916k) {
                    ab.m5389a("Main", "completed", action.f3801b.m5518a(), "from " + from);
                }
            }
        }
    }

    private void m5499a(Object target) {
        ab.m5386a();
        C1252a action = (C1252a) this.f3912g.remove(target);
        if (action != null) {
            action.m5361b();
            this.f3909d.m5458b(action);
        }
        if (target instanceof ImageView) {
            C1271h deferredRequestCreator = (C1271h) this.f3913h.remove((ImageView) target);
            if (deferredRequestCreator != null) {
                deferredRequestCreator.m5444a();
            }
        }
    }

    public static C1295r m5496a(Context context) {
        if (f3907b == null) {
            synchronized (C1295r.class) {
                if (f3907b == null) {
                    f3907b = new C1288a(context).m5492a();
                }
            }
        }
        return f3907b;
    }
}
