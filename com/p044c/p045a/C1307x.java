package com.p044c.p045a;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

/* renamed from: com.c.a.x */
class C1307x {
    final HandlerThread f3973a;
    final C1266d f3974b;
    final Handler f3975c;
    long f3976d;
    long f3977e;
    long f3978f;
    long f3979g;
    long f3980h;
    long f3981i;
    long f3982j;
    long f3983k;
    int f3984l;
    int f3985m;
    int f3986n;

    /* renamed from: com.c.a.x.a */
    private static class C1306a extends Handler {
        private final C1307x f3972a;

        /* renamed from: com.c.a.x.a.1 */
        class C13051 implements Runnable {
            final /* synthetic */ Message f3970a;
            final /* synthetic */ C1306a f3971b;

            C13051(C1306a this$0, Message message) {
                this.f3971b = this$0;
                this.f3970a = message;
            }

            public void run() {
                throw new AssertionError("Unhandled stats message." + this.f3970a.what);
            }
        }

        public C1306a(Looper looper, C1307x stats) {
            super(looper);
            this.f3972a = stats;
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case Base64.DEFAULT /*0*/:
                    this.f3972a.m5543c();
                case Base64.NO_PADDING /*1*/:
                    this.f3972a.m5545d();
                case Base64.NO_WRAP /*2*/:
                    this.f3972a.m5541b((long) msg.arg1);
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    this.f3972a.m5544c((long) msg.arg1);
                case Base64.CRLF /*4*/:
                    this.f3972a.m5539a((Long) msg.obj);
                default:
                    C1295r.f3906a.post(new C13051(this, msg));
            }
        }
    }

    C1307x(C1266d cache) {
        this.f3974b = cache;
        this.f3973a = new HandlerThread("Picasso-Stats", 10);
        this.f3973a.start();
        this.f3975c = new C1306a(this.f3973a.getLooper(), this);
    }

    void m5538a(Bitmap bitmap) {
        m5535a(bitmap, 2);
    }

    void m5542b(Bitmap bitmap) {
        m5535a(bitmap, 3);
    }

    void m5537a(long size) {
        this.f3975c.sendMessage(this.f3975c.obtainMessage(4, Long.valueOf(size)));
    }

    void m5536a() {
        this.f3975c.sendEmptyMessage(0);
    }

    void m5540b() {
        this.f3975c.sendEmptyMessage(1);
    }

    void m5543c() {
        this.f3976d++;
    }

    void m5545d() {
        this.f3977e++;
    }

    void m5539a(Long size) {
        this.f3984l++;
        this.f3978f += size.longValue();
        this.f3981i = C1307x.m5534a(this.f3984l, this.f3978f);
    }

    void m5541b(long size) {
        this.f3985m++;
        this.f3979g += size;
        this.f3982j = C1307x.m5534a(this.f3985m, this.f3979g);
    }

    void m5544c(long size) {
        this.f3986n++;
        this.f3980h += size;
        this.f3983k = C1307x.m5534a(this.f3985m, this.f3980h);
    }

    C1308y m5546e() {
        return new C1308y(this.f3974b.m5431b(), this.f3974b.m5428a(), this.f3976d, this.f3977e, this.f3978f, this.f3979g, this.f3980h, this.f3981i, this.f3982j, this.f3983k, this.f3984l, this.f3985m, this.f3986n, System.currentTimeMillis());
    }

    private void m5535a(Bitmap bitmap, int what) {
        this.f3975c.sendMessage(this.f3975c.obtainMessage(what, ab.m5377a(bitmap), 0));
    }

    private static long m5534a(int count, long totalSize) {
        return totalSize / ((long) count);
    }
}
