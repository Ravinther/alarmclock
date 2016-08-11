package android.support.v4.p006a;

import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import com.google.android.gms.cast.Cast;
import com.mopub.mobileads.util.Base64;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: android.support.v4.a.j */
abstract class C0004j {
    private static final ThreadFactory f19a;
    private static final BlockingQueue f20b;
    private static final C0029b f21c;
    public static final Executor f22d;
    private static volatile Executor f23e;
    private final C0024d f24f;
    private final FutureTask f25g;
    private volatile C0030c f26h;
    private final AtomicBoolean f27i;

    /* renamed from: android.support.v4.a.j.1 */
    static class C00231 implements ThreadFactory {
        private final AtomicInteger f59a;

        C00231() {
            this.f59a = new AtomicInteger(1);
        }

        public Thread newThread(Runnable r) {
            return new Thread(r, "ModernAsyncTask #" + this.f59a.getAndIncrement());
        }
    }

    /* renamed from: android.support.v4.a.j.d */
    private static abstract class C0024d implements Callable {
        Object[] f60b;

        private C0024d() {
        }
    }

    /* renamed from: android.support.v4.a.j.2 */
    class C00252 extends C0024d {
        final /* synthetic */ C0004j f61a;

        C00252(C0004j c0004j) {
            this.f61a = c0004j;
            super();
        }

        public Object call() {
            this.f61a.f27i.set(true);
            Process.setThreadPriority(10);
            return this.f61a.m49d(this.f61a.m52a(this.b));
        }
    }

    /* renamed from: android.support.v4.a.j.3 */
    class C00263 extends FutureTask {
        final /* synthetic */ C0004j f62a;

        C00263(C0004j c0004j, Callable x0) {
            this.f62a = c0004j;
            super(x0);
        }

        protected void done() {
            try {
                this.f62a.m48c(get());
            } catch (InterruptedException e) {
                Log.w("AsyncTask", e);
            } catch (ExecutionException e2) {
                throw new RuntimeException("An error occured while executing doInBackground()", e2.getCause());
            } catch (CancellationException e3) {
                this.f62a.m48c(null);
            } catch (Throwable t) {
                RuntimeException runtimeException = new RuntimeException("An error occured while executing doInBackground()", t);
            }
        }
    }

    /* renamed from: android.support.v4.a.j.4 */
    static /* synthetic */ class C00274 {
        static final /* synthetic */ int[] f63a;

        static {
            f63a = new int[C0030c.values().length];
            try {
                f63a[C0030c.RUNNING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f63a[C0030c.FINISHED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* renamed from: android.support.v4.a.j.a */
    private static class C0028a {
        final C0004j f64a;
        final Object[] f65b;

        C0028a(C0004j task, Object... data) {
            this.f64a = task;
            this.f65b = data;
        }
    }

    /* renamed from: android.support.v4.a.j.b */
    private static class C0029b extends Handler {
        private C0029b() {
        }

        public void handleMessage(Message msg) {
            C0028a result = msg.obj;
            switch (msg.what) {
                case Base64.NO_PADDING /*1*/:
                    result.f64a.m50e(result.f65b[0]);
                case Base64.NO_WRAP /*2*/:
                    result.f64a.m58b(result.f65b);
                default:
            }
        }
    }

    /* renamed from: android.support.v4.a.j.c */
    public enum C0030c {
        PENDING,
        RUNNING,
        FINISHED
    }

    protected abstract Object m52a(Object... objArr);

    static {
        f19a = new C00231();
        f20b = new LinkedBlockingQueue(10);
        f22d = new ThreadPoolExecutor(5, Cast.MAX_NAMESPACE_LENGTH, 1, TimeUnit.SECONDS, f20b, f19a);
        f21c = new C0029b();
        f23e = f22d;
    }

    public C0004j() {
        this.f26h = C0030c.PENDING;
        this.f27i = new AtomicBoolean();
        this.f24f = new C00252(this);
        this.f25g = new C00263(this, this.f24f);
    }

    private void m48c(Object result) {
        if (!this.f27i.get()) {
            m49d(result);
        }
    }

    private Object m49d(Object result) {
        f21c.obtainMessage(1, new C0028a(this, result)).sendToTarget();
        return result;
    }

    protected void m56b() {
    }

    protected void m54a(Object result) {
    }

    protected void m58b(Object... values) {
    }

    protected void m57b(Object result) {
        m53a();
    }

    protected void m53a() {
    }

    public final boolean m59c() {
        return this.f25g.isCancelled();
    }

    public final boolean m55a(boolean mayInterruptIfRunning) {
        return this.f25g.cancel(mayInterruptIfRunning);
    }

    public final C0004j m51a(Executor exec, Object... params) {
        if (this.f26h != C0030c.PENDING) {
            switch (C00274.f63a[this.f26h.ordinal()]) {
                case Base64.NO_PADDING /*1*/:
                    throw new IllegalStateException("Cannot execute task: the task is already running.");
                case Base64.NO_WRAP /*2*/:
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.f26h = C0030c.RUNNING;
        m56b();
        this.f24f.f60b = params;
        exec.execute(this.f25g);
        return this;
    }

    private void m50e(Object result) {
        if (m59c()) {
            m57b(result);
        } else {
            m54a(result);
        }
        this.f26h = C0030c.FINISHED;
    }
}
