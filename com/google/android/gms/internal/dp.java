package com.google.android.gms.internal;

import android.os.Process;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class dp {
    private static final ThreadFactory ra;
    private static final ThreadPoolExecutor rb;

    /* renamed from: com.google.android.gms.internal.dp.1 */
    static class C18261 implements Runnable {
        final /* synthetic */ Runnable rc;

        C18261(Runnable runnable) {
            this.rc = runnable;
        }

        public void run() {
            Process.setThreadPriority(10);
            this.rc.run();
        }
    }

    /* renamed from: com.google.android.gms.internal.dp.2 */
    static class C18272 implements ThreadFactory {
        private final AtomicInteger rd;

        C18272() {
            this.rd = new AtomicInteger(1);
        }

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "AdWorker #" + this.rd.getAndIncrement());
        }
    }

    static {
        ra = new C18272();
        rb = new ThreadPoolExecutor(0, 10, 65, TimeUnit.SECONDS, new SynchronousQueue(true), ra);
    }

    public static void execute(Runnable task) {
        try {
            rb.execute(new C18261(task));
        } catch (Throwable e) {
            dw.m8215c("Too many background threads already running. Aborting task.  Current pool size: " + getPoolSize(), e);
        }
    }

    public static int getPoolSize() {
        return rb.getPoolSize();
    }
}
