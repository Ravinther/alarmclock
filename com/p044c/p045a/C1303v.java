package com.p044c.p045a;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.p044c.p045a.C1295r.C1292d;
import com.p044c.p045a.C1300u.C1299a;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.c.a.v */
public class C1303v {
    private static int f3959a;
    private final C1295r f3960b;
    private final C1299a f3961c;
    private boolean f3962d;
    private boolean f3963e;
    private boolean f3964f;
    private int f3965g;
    private int f3966h;
    private Drawable f3967i;
    private Drawable f3968j;

    /* renamed from: com.c.a.v.1 */
    static class C13011 implements Runnable {
        final /* synthetic */ AtomicInteger f3956a;
        final /* synthetic */ CountDownLatch f3957b;

        C13011(AtomicInteger atomicInteger, CountDownLatch countDownLatch) {
            this.f3956a = atomicInteger;
            this.f3957b = countDownLatch;
        }

        public void run() {
            this.f3956a.set(C1303v.m5527c());
            this.f3957b.countDown();
        }
    }

    /* renamed from: com.c.a.v.2 */
    static class C13022 implements Runnable {
        final /* synthetic */ InterruptedException f3958a;

        C13022(InterruptedException interruptedException) {
            this.f3958a = interruptedException;
        }

        public void run() {
            throw new RuntimeException(this.f3958a);
        }
    }

    static {
        f3959a = 0;
    }

    private static int m5527c() {
        if (ab.m5392b()) {
            int i = f3959a;
            f3959a = i + 1;
            return i;
        }
        CountDownLatch latch = new CountDownLatch(1);
        AtomicInteger id = new AtomicInteger();
        C1295r.f3906a.post(new C13011(id, latch));
        try {
            latch.await();
        } catch (InterruptedException e) {
            C1295r.f3906a.post(new C13022(e));
        }
        return id.get();
    }

    C1303v(C1295r picasso, Uri uri, int resourceId) {
        if (picasso.f3917l) {
            throw new IllegalStateException("Picasso instance already shut down. Cannot submit new requests.");
        }
        this.f3960b = picasso;
        this.f3961c = new C1299a(uri, resourceId);
    }

    C1303v() {
        this.f3960b = null;
        this.f3961c = new C1299a(null, 0);
    }

    C1303v m5528a() {
        this.f3964f = false;
        return this;
    }

    public C1303v m5529a(int targetWidth, int targetHeight) {
        this.f3961c.m5514a(targetWidth, targetHeight);
        return this;
    }

    public void m5530a(ImageView target, C0881e callback) {
        long started = System.nanoTime();
        ab.m5386a();
        if (target == null) {
            throw new IllegalArgumentException("Target must not be null.");
        } else if (this.f3961c.m5515a()) {
            if (this.f3964f) {
                if (this.f3961c.m5516b()) {
                    throw new IllegalStateException("Fit cannot be used with resize.");
                }
                int width = target.getWidth();
                int height = target.getHeight();
                if (width == 0 || height == 0) {
                    C1296s.m5510a(target, this.f3965g, this.f3967i);
                    this.f3960b.m5504a(target, new C1271h(this, target, callback));
                    return;
                }
                this.f3961c.m5514a(width, height);
            }
            C1300u request = m5525a(started);
            String requestKey = ab.m5384a(request);
            if (!this.f3962d) {
                Bitmap bitmap = this.f3960b.m5500a(requestKey);
                if (bitmap != null) {
                    this.f3960b.m5503a(target);
                    C1296s.m5511a(target, this.f3960b.f3908c, bitmap, C1292d.MEMORY, this.f3963e, this.f3960b.f3915j);
                    if (this.f3960b.f3916k) {
                        ab.m5389a("Main", "completed", request.m5519b(), "from " + C1292d.MEMORY);
                    }
                    if (callback != null) {
                        callback.m4096a();
                        return;
                    }
                    return;
                }
            }
            C1296s.m5510a(target, this.f3965g, this.f3967i);
            this.f3960b.m5505a(new C1280l(this.f3960b, target, request, this.f3962d, this.f3963e, this.f3966h, this.f3968j, requestKey, callback));
        } else {
            this.f3960b.m5503a(target);
            C1296s.m5510a(target, this.f3965g, this.f3967i);
        }
    }

    private C1300u m5525a(long started) {
        int id = C1303v.m5527c();
        C1300u request = this.f3961c.m5517c();
        request.f3942a = id;
        request.f3943b = started;
        boolean loggingEnabled = this.f3960b.f3916k;
        if (loggingEnabled) {
            ab.m5389a("Main", "created", request.m5519b(), request.toString());
        }
        C1300u transformed = this.f3960b.m5501a(request);
        if (transformed != request) {
            transformed.f3942a = id;
            transformed.f3943b = started;
            if (loggingEnabled) {
                ab.m5389a("Main", "changed", transformed.m5518a(), "into " + transformed);
            }
        }
        return transformed;
    }
}
