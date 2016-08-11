package com.p044c.p045a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;

/* renamed from: com.c.a.i */
class C1276i {
    final C1274b f3846a;
    final Context f3847b;
    final ExecutorService f3848c;
    final C1254j f3849d;
    final Map f3850e;
    final Map f3851f;
    final Handler f3852g;
    final Handler f3853h;
    final C1266d f3854i;
    final C1307x f3855j;
    final List f3856k;
    final C1275c f3857l;
    final boolean f3858m;
    boolean f3859n;

    /* renamed from: com.c.a.i.a */
    private static class C1273a extends Handler {
        private final C1276i f3844a;

        /* renamed from: com.c.a.i.a.1 */
        class C12721 implements Runnable {
            final /* synthetic */ Message f3842a;
            final /* synthetic */ C1273a f3843b;

            C12721(C1273a this$0, Message message) {
                this.f3843b = this$0;
                this.f3842a = message;
            }

            public void run() {
                throw new AssertionError("Unknown handler message received: " + this.f3842a.what);
            }
        }

        public C1273a(Looper looper, C1276i dispatcher) {
            super(looper);
            this.f3844a = dispatcher;
        }

        public void handleMessage(Message msg) {
            boolean z = true;
            switch (msg.what) {
                case Base64.NO_PADDING /*1*/:
                    this.f3844a.m5461c(msg.obj);
                case Base64.NO_WRAP /*2*/:
                    this.f3844a.m5463d((C1252a) msg.obj);
                case Base64.CRLF /*4*/:
                    this.f3844a.m5465e(msg.obj);
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    this.f3844a.m5464d((C1260c) msg.obj);
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                    this.f3844a.m5455a((C1260c) msg.obj, false);
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                    this.f3844a.m5451a();
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor /*9*/:
                    this.f3844a.m5457b(msg.obj);
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                    C1276i c1276i = this.f3844a;
                    if (msg.arg1 != 1) {
                        z = false;
                    }
                    c1276i.m5460b(z);
                default:
                    C1295r.f3906a.post(new C12721(this, msg));
            }
        }
    }

    /* renamed from: com.c.a.i.b */
    static class C1274b extends HandlerThread {
        C1274b() {
            super("Picasso-Dispatcher", 10);
        }
    }

    /* renamed from: com.c.a.i.c */
    static class C1275c extends BroadcastReceiver {
        private final C1276i f3845a;

        C1275c(C1276i dispatcher) {
            this.f3845a = dispatcher;
        }

        void m5445a() {
            IntentFilter filter = new IntentFilter();
            filter.addAction("android.intent.action.AIRPLANE_MODE");
            if (this.f3845a.f3858m) {
                filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            }
            this.f3845a.f3847b.registerReceiver(this, filter);
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String action = intent.getAction();
                if ("android.intent.action.AIRPLANE_MODE".equals(action)) {
                    if (intent.hasExtra("state")) {
                        this.f3845a.m5456a(intent.getBooleanExtra("state", false));
                    }
                } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                    this.f3845a.m5452a(((ConnectivityManager) ab.m5381a(context, "connectivity")).getActiveNetworkInfo());
                }
            }
        }
    }

    C1276i(Context context, ExecutorService service, Handler mainThreadHandler, C1254j downloader, C1266d cache, C1307x stats) {
        this.f3846a = new C1274b();
        this.f3846a.start();
        this.f3847b = context;
        this.f3848c = service;
        this.f3850e = new LinkedHashMap();
        this.f3851f = new WeakHashMap();
        this.f3852g = new C1273a(this.f3846a.getLooper(), this);
        this.f3849d = downloader;
        this.f3853h = mainThreadHandler;
        this.f3854i = cache;
        this.f3855j = stats;
        this.f3856k = new ArrayList(4);
        this.f3859n = ab.m5397d(this.f3847b);
        this.f3858m = ab.m5393b(context, "android.permission.ACCESS_NETWORK_STATE");
        this.f3857l = new C1275c(this);
        this.f3857l.m5445a();
    }

    void m5453a(C1252a action) {
        this.f3852g.sendMessage(this.f3852g.obtainMessage(1, action));
    }

    void m5458b(C1252a action) {
        this.f3852g.sendMessage(this.f3852g.obtainMessage(2, action));
    }

    void m5454a(C1260c hunter) {
        this.f3852g.sendMessage(this.f3852g.obtainMessage(4, hunter));
    }

    void m5459b(C1260c hunter) {
        this.f3852g.sendMessageDelayed(this.f3852g.obtainMessage(5, hunter), 500);
    }

    void m5462c(C1260c hunter) {
        this.f3852g.sendMessage(this.f3852g.obtainMessage(6, hunter));
    }

    void m5452a(NetworkInfo info) {
        this.f3852g.sendMessage(this.f3852g.obtainMessage(9, info));
    }

    void m5456a(boolean airplaneMode) {
        int i;
        Handler handler = this.f3852g;
        Handler handler2 = this.f3852g;
        if (airplaneMode) {
            i = 1;
        } else {
            i = 0;
        }
        handler.sendMessage(handler2.obtainMessage(10, i, 0));
    }

    void m5461c(C1252a action) {
        C1260c hunter = (C1260c) this.f3850e.get(action.m5364e());
        if (hunter != null) {
            hunter.m5409a(action);
        } else if (!this.f3848c.isShutdown()) {
            hunter = C1260c.m5400a(this.f3847b, action.m5367h(), this, this.f3854i, this.f3855j, action, this.f3849d);
            hunter.f3826k = this.f3848c.submit(hunter);
            this.f3850e.put(action.m5364e(), hunter);
            this.f3851f.remove(action.m5363d());
            if (action.m5367h().f3916k) {
                ab.m5388a("Dispatcher", "enqueued", action.f3801b.m5518a());
            }
        } else if (action.m5367h().f3916k) {
            ab.m5389a("Dispatcher", "ignored", action.f3801b.m5518a(), "because shut down");
        }
    }

    void m5463d(C1252a action) {
        String key = action.m5364e();
        C1260c hunter = (C1260c) this.f3850e.get(key);
        if (hunter != null) {
            hunter.m5412b(action);
            if (hunter.m5413c()) {
                this.f3850e.remove(key);
                if (action.m5367h().f3916k) {
                    ab.m5388a("Dispatcher", "canceled", action.m5362c().m5518a());
                }
            }
        }
        C1252a remove = (C1252a) this.f3851f.remove(action.m5363d());
        if (remove != null && remove.m5367h().f3916k) {
            ab.m5389a("Dispatcher", "canceled", remove.m5362c().m5518a(), "from replaying");
        }
    }

    void m5464d(C1260c hunter) {
        if (!hunter.m5414d()) {
            if (this.f3848c.isShutdown()) {
                m5455a(hunter, false);
                return;
            }
            NetworkInfo networkInfo = null;
            if (this.f3858m) {
                networkInfo = ((ConnectivityManager) ab.m5381a(this.f3847b, "connectivity")).getActiveNetworkInfo();
            }
            boolean hasConnectivity;
            if (networkInfo == null || !networkInfo.isConnected()) {
                hasConnectivity = false;
            } else {
                hasConnectivity = true;
            }
            boolean shouldRetryHunter = hunter.m5410a(this.f3859n, networkInfo);
            boolean supportsReplay = hunter.m5416f();
            if (!shouldRetryHunter) {
                boolean willReplay;
                if (this.f3858m && supportsReplay) {
                    willReplay = true;
                } else {
                    willReplay = false;
                }
                m5455a(hunter, willReplay);
                if (willReplay) {
                    m5449f(hunter);
                }
            } else if (!this.f3858m || hasConnectivity) {
                if (hunter.m5421k().f3916k) {
                    ab.m5388a("Dispatcher", "retrying", ab.m5382a(hunter));
                }
                hunter.f3826k = this.f3848c.submit(hunter);
            } else {
                m5455a(hunter, supportsReplay);
                if (supportsReplay) {
                    m5449f(hunter);
                }
            }
        }
    }

    void m5465e(C1260c hunter) {
        if (!hunter.m5415e()) {
            this.f3854i.m5430a(hunter.m5418h(), hunter.m5417g());
        }
        this.f3850e.remove(hunter.m5418h());
        m5450g(hunter);
        if (hunter.m5421k().f3916k) {
            ab.m5389a("Dispatcher", "batched", ab.m5382a(hunter), "for completion");
        }
    }

    void m5451a() {
        List copy = new ArrayList(this.f3856k);
        this.f3856k.clear();
        this.f3853h.sendMessage(this.f3853h.obtainMessage(8, copy));
        m5446a(copy);
    }

    void m5455a(C1260c hunter, boolean willReplay) {
        if (hunter.m5421k().f3916k) {
            ab.m5389a("Dispatcher", "batched", ab.m5382a(hunter), "for error" + (willReplay ? " (will replay)" : ""));
        }
        this.f3850e.remove(hunter.m5418h());
        m5450g(hunter);
    }

    void m5460b(boolean airplaneMode) {
        this.f3859n = airplaneMode;
    }

    void m5457b(NetworkInfo info) {
        if (this.f3848c instanceof C1297t) {
            ((C1297t) this.f3848c).m5513a(info);
        }
        if (info != null && info.isConnected()) {
            m5447b();
        }
    }

    private void m5447b() {
        if (!this.f3851f.isEmpty()) {
            Iterator iterator = this.f3851f.values().iterator();
            while (iterator.hasNext()) {
                C1252a action = (C1252a) iterator.next();
                iterator.remove();
                if (action.m5367h().f3916k) {
                    ab.m5388a("Dispatcher", "replaying", action.m5362c().m5518a());
                }
                m5461c(action);
            }
        }
    }

    private void m5449f(C1260c hunter) {
        C1252a action = hunter.m5420j();
        if (action != null) {
            m5448e(action);
        }
        List joined = hunter.m5422l();
        if (joined != null) {
            int n = joined.size();
            for (int i = 0; i < n; i++) {
                m5448e((C1252a) joined.get(i));
            }
        }
    }

    private void m5448e(C1252a action) {
        Object target = action.m5363d();
        if (target != null) {
            action.f3808i = true;
            this.f3851f.put(target, action);
        }
    }

    private void m5450g(C1260c hunter) {
        if (!hunter.m5414d()) {
            this.f3856k.add(hunter);
            if (!this.f3852g.hasMessages(7)) {
                this.f3852g.sendEmptyMessageDelayed(7, 200);
            }
        }
    }

    private void m5446a(List copy) {
        if (copy != null && !copy.isEmpty() && ((C1260c) copy.get(0)).m5421k().f3916k) {
            StringBuilder builder = new StringBuilder();
            for (C1260c bitmapHunter : copy) {
                if (builder.length() > 0) {
                    builder.append(", ");
                }
                builder.append(ab.m5382a(bitmapHunter));
            }
            ab.m5388a("Dispatcher", "delivered", builder.toString());
        }
    }
}
