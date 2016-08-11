package android.support.v4.p006a;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.p010d.C0150j;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;

/* renamed from: android.support.v4.a.a */
public abstract class C0007a extends C0006h {
    volatile C0005a f40a;
    volatile C0005a f41b;
    long f42c;
    long f43d;
    Handler f44e;

    /* renamed from: android.support.v4.a.a.a */
    final class C0005a extends C0004j implements Runnable {
        Object f28a;
        boolean f29b;
        final /* synthetic */ C0007a f30c;
        private CountDownLatch f31e;

        C0005a(C0007a c0007a) {
            this.f30c = c0007a;
            this.f31e = new CountDownLatch(1);
        }

        protected Object m61a(Void... params) {
            this.f28a = this.f30c.m95e();
            return this.f28a;
        }

        protected void m63a(Object data) {
            try {
                this.f30c.m91b(this, data);
            } finally {
                this.f31e.countDown();
            }
        }

        protected void m62a() {
            try {
                this.f30c.m88a(this, this.f28a);
            } finally {
                this.f31e.countDown();
            }
        }

        public void run() {
            this.f29b = false;
            this.f30c.m93c();
        }
    }

    public abstract Object m94d();

    public C0007a(Context context) {
        super(context);
        this.f43d = -10000;
    }

    protected void m87a() {
        super.m64a();
        m92b();
        this.f40a = new C0005a(this);
        m93c();
    }

    public boolean m92b() {
        boolean cancelled = false;
        if (this.f40a != null) {
            if (this.f41b != null) {
                if (this.f40a.f29b) {
                    this.f40a.f29b = false;
                    this.f44e.removeCallbacks(this.f40a);
                }
                this.f40a = null;
            } else if (this.f40a.f29b) {
                this.f40a.f29b = false;
                this.f44e.removeCallbacks(this.f40a);
                this.f40a = null;
            } else {
                cancelled = this.f40a.m55a(false);
                if (cancelled) {
                    this.f41b = this.f40a;
                }
                this.f40a = null;
            }
        }
        return cancelled;
    }

    public void m89a(Object data) {
    }

    void m93c() {
        if (this.f41b == null && this.f40a != null) {
            if (this.f40a.f29b) {
                this.f40a.f29b = false;
                this.f44e.removeCallbacks(this.f40a);
            }
            if (this.f42c <= 0 || SystemClock.uptimeMillis() >= this.f43d + this.f42c) {
                this.f40a.m51a(C0004j.f22d, (Object[]) (Void[]) null);
                return;
            }
            this.f40a.f29b = true;
            this.f44e.postAtTime(this.f40a, this.f43d + this.f42c);
        }
    }

    void m88a(C0005a task, Object data) {
        m89a(data);
        if (this.f41b == task) {
            m85u();
            this.f43d = SystemClock.uptimeMillis();
            this.f41b = null;
            m93c();
        }
    }

    void m91b(C0005a task, Object data) {
        if (this.f40a != task) {
            m88a(task, data);
        } else if (m72h()) {
            m89a(data);
        } else {
            m84t();
            this.f43d = SystemClock.uptimeMillis();
            this.f40a = null;
            m68b(data);
        }
    }

    protected Object m95e() {
        return m94d();
    }

    public void m90a(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        super.m67a(prefix, fd, writer, args);
        if (this.f40a != null) {
            writer.print(prefix);
            writer.print("mTask=");
            writer.print(this.f40a);
            writer.print(" waiting=");
            writer.println(this.f40a.f29b);
        }
        if (this.f41b != null) {
            writer.print(prefix);
            writer.print("mCancellingTask=");
            writer.print(this.f41b);
            writer.print(" waiting=");
            writer.println(this.f41b.f29b);
        }
        if (this.f42c != 0) {
            writer.print(prefix);
            writer.print("mUpdateThrottle=");
            C0150j.m576a(this.f42c, writer);
            writer.print(" mLastLoadCompleteTime=");
            C0150j.m575a(this.f43d, SystemClock.uptimeMillis(), writer);
            writer.println();
        }
    }
}
