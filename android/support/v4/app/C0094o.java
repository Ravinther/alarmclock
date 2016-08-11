package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.app.C0092n.C0091a;
import android.support.v4.p006a.C0006h;
import android.support.v4.p006a.C0006h.C0018a;
import android.support.v4.p010d.C0140c;
import android.support.v4.p010d.C0149i;
import android.util.Log;
import com.google.android.gms.cast.Cast;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

/* renamed from: android.support.v4.app.o */
class C0094o extends C0092n {
    static boolean f278a;
    final C0149i f279b;
    final C0149i f280c;
    final String f281d;
    C0073g f282e;
    boolean f283f;
    boolean f284g;
    boolean f285h;

    /* renamed from: android.support.v4.app.o.a */
    final class C0093a implements C0018a {
        final int f263a;
        final Bundle f264b;
        C0091a f265c;
        C0006h f266d;
        boolean f267e;
        boolean f268f;
        Object f269g;
        boolean f270h;
        boolean f271i;
        boolean f272j;
        boolean f273k;
        boolean f274l;
        boolean f275m;
        C0093a f276n;
        final /* synthetic */ C0094o f277o;

        public C0093a(C0094o c0094o, int id, Bundle args, C0091a callbacks) {
            this.f277o = c0094o;
            this.f263a = id;
            this.f264b = args;
            this.f265c = callbacks;
        }

        void m398a() {
            if (this.f271i && this.f272j) {
                this.f270h = true;
            } else if (!this.f270h) {
                this.f270h = true;
                if (C0094o.f278a) {
                    Log.v("LoaderManager", "  Starting: " + this);
                }
                if (this.f266d == null && this.f265c != null) {
                    this.f266d = this.f265c.m392a(this.f263a, this.f264b);
                }
                if (this.f266d == null) {
                    return;
                }
                if (!this.f266d.getClass().isMemberClass() || Modifier.isStatic(this.f266d.getClass().getModifiers())) {
                    if (!this.f275m) {
                        this.f266d.m65a(this.f263a, this);
                        this.f275m = true;
                    }
                    this.f266d.m74j();
                    return;
                }
                throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.f266d);
            }
        }

        void m401b() {
            if (C0094o.f278a) {
                Log.v("LoaderManager", "  Retaining: " + this);
            }
            this.f271i = true;
            this.f272j = this.f270h;
            this.f270h = false;
            this.f265c = null;
        }

        void m403c() {
            if (this.f271i) {
                if (C0094o.f278a) {
                    Log.v("LoaderManager", "  Finished Retaining: " + this);
                }
                this.f271i = false;
                if (!(this.f270h == this.f272j || this.f270h)) {
                    m405e();
                }
            }
            if (this.f270h && this.f267e && !this.f273k) {
                m402b(this.f266d, this.f269g);
            }
        }

        void m404d() {
            if (this.f270h && this.f273k) {
                this.f273k = false;
                if (this.f267e) {
                    m402b(this.f266d, this.f269g);
                }
            }
        }

        void m405e() {
            if (C0094o.f278a) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.f270h = false;
            if (!this.f271i && this.f266d != null && this.f275m) {
                this.f275m = false;
                this.f266d.m66a(this);
                this.f266d.m77m();
            }
        }

        void m406f() {
            if (C0094o.f278a) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.f274l = true;
            boolean needReset = this.f268f;
            this.f268f = false;
            if (this.f265c != null && this.f266d != null && this.f267e && needReset) {
                if (C0094o.f278a) {
                    Log.v("LoaderManager", "  Reseting: " + this);
                }
                String lastBecause = null;
                if (this.f277o.f282e != null) {
                    lastBecause = this.f277o.f282e.f187b.f234u;
                    this.f277o.f282e.f187b.f234u = "onLoaderReset";
                }
                try {
                    this.f265c.m393a(this.f266d);
                } finally {
                    if (this.f277o.f282e != null) {
                        this.f277o.f282e.f187b.f234u = lastBecause;
                    }
                }
            }
            this.f265c = null;
            this.f269g = null;
            this.f267e = false;
            if (this.f266d != null) {
                if (this.f275m) {
                    this.f275m = false;
                    this.f266d.m66a(this);
                }
                this.f266d.m81q();
            }
            if (this.f276n != null) {
                this.f276n.m406f();
            }
        }

        public void m399a(C0006h loader, Object data) {
            if (C0094o.f278a) {
                Log.v("LoaderManager", "onLoadComplete: " + this);
            }
            if (this.f274l) {
                if (C0094o.f278a) {
                    Log.v("LoaderManager", "  Ignoring load complete -- destroyed");
                }
            } else if (this.f277o.f279b.m563a(this.f263a) == this) {
                C0093a pending = this.f276n;
                if (pending != null) {
                    if (C0094o.f278a) {
                        Log.v("LoaderManager", "  Switching to pending loader: " + pending);
                    }
                    this.f276n = null;
                    this.f277o.f279b.m567b(this.f263a, null);
                    m406f();
                    this.f277o.m411a(pending);
                    return;
                }
                if (!(this.f269g == data && this.f267e)) {
                    this.f269g = data;
                    this.f267e = true;
                    if (this.f270h) {
                        m402b(loader, data);
                    }
                }
                C0093a info = (C0093a) this.f277o.f280c.m563a(this.f263a);
                if (!(info == null || info == this)) {
                    info.f268f = false;
                    info.m406f();
                    this.f277o.f280c.m569c(this.f263a);
                }
                if (this.f277o.f282e != null && !this.f277o.m413a()) {
                    this.f277o.f282e.f187b.m328g();
                }
            } else if (C0094o.f278a) {
                Log.v("LoaderManager", "  Ignoring load complete -- not active");
            }
        }

        void m402b(C0006h loader, Object data) {
            if (this.f265c != null) {
                String lastBecause = null;
                if (this.f277o.f282e != null) {
                    lastBecause = this.f277o.f282e.f187b.f234u;
                    this.f277o.f282e.f187b.f234u = "onLoadFinished";
                }
                try {
                    if (C0094o.f278a) {
                        Log.v("LoaderManager", "  onLoadFinished in " + loader + ": " + loader.m69c(data));
                    }
                    this.f265c.m394a(loader, data);
                    this.f268f = true;
                } finally {
                    if (this.f277o.f282e != null) {
                        this.f277o.f282e.f187b.f234u = lastBecause;
                    }
                }
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.f263a);
            sb.append(" : ");
            C0140c.m548a(this.f266d, sb);
            sb.append("}}");
            return sb.toString();
        }

        public void m400a(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
            writer.print(prefix);
            writer.print("mId=");
            writer.print(this.f263a);
            writer.print(" mArgs=");
            writer.println(this.f264b);
            writer.print(prefix);
            writer.print("mCallbacks=");
            writer.println(this.f265c);
            writer.print(prefix);
            writer.print("mLoader=");
            writer.println(this.f266d);
            if (this.f266d != null) {
                this.f266d.m67a(prefix + "  ", fd, writer, args);
            }
            if (this.f267e || this.f268f) {
                writer.print(prefix);
                writer.print("mHaveData=");
                writer.print(this.f267e);
                writer.print("  mDeliveredData=");
                writer.println(this.f268f);
                writer.print(prefix);
                writer.print("mData=");
                writer.println(this.f269g);
            }
            writer.print(prefix);
            writer.print("mStarted=");
            writer.print(this.f270h);
            writer.print(" mReportNextStart=");
            writer.print(this.f273k);
            writer.print(" mDestroyed=");
            writer.println(this.f274l);
            writer.print(prefix);
            writer.print("mRetaining=");
            writer.print(this.f271i);
            writer.print(" mRetainingStarted=");
            writer.print(this.f272j);
            writer.print(" mListenerRegistered=");
            writer.println(this.f275m);
            if (this.f276n != null) {
                writer.print(prefix);
                writer.println("Pending Loader ");
                writer.print(this.f276n);
                writer.println(":");
                this.f276n.m400a(prefix + "  ", fd, writer, args);
            }
        }
    }

    static {
        f278a = false;
    }

    C0094o(String who, C0073g activity, boolean started) {
        this.f279b = new C0149i();
        this.f280c = new C0149i();
        this.f281d = who;
        this.f282e = activity;
        this.f283f = started;
    }

    void m410a(C0073g activity) {
        this.f282e = activity;
    }

    private C0093a m407c(int id, Bundle args, C0091a callback) {
        C0093a info = new C0093a(this, id, args, callback);
        info.f266d = callback.m392a(id, args);
        return info;
    }

    private C0093a m408d(int id, Bundle args, C0091a callback) {
        try {
            this.f285h = true;
            C0093a info = m407c(id, args, callback);
            m411a(info);
            return info;
        } finally {
            this.f285h = false;
        }
    }

    void m411a(C0093a info) {
        this.f279b.m567b(info.f263a, info);
        if (this.f283f) {
            info.m398a();
        }
    }

    public C0006h m409a(int id, Bundle args, C0091a callback) {
        if (this.f285h) {
            throw new IllegalStateException("Called while creating a loader");
        }
        C0093a info = (C0093a) this.f279b.m563a(id);
        if (f278a) {
            Log.v("LoaderManager", "initLoader in " + this + ": args=" + args);
        }
        if (info == null) {
            info = m408d(id, args, callback);
            if (f278a) {
                Log.v("LoaderManager", "  Created new loader " + info);
            }
        } else {
            if (f278a) {
                Log.v("LoaderManager", "  Re-using existing loader " + info);
            }
            info.f265c = callback;
        }
        if (info.f267e && this.f283f) {
            info.m402b(info.f266d, info.f269g);
        }
        return info.f266d;
    }

    public C0006h m414b(int id, Bundle args, C0091a callback) {
        if (this.f285h) {
            throw new IllegalStateException("Called while creating a loader");
        }
        C0093a info = (C0093a) this.f279b.m563a(id);
        if (f278a) {
            Log.v("LoaderManager", "restartLoader in " + this + ": args=" + args);
        }
        if (info != null) {
            C0093a inactive = (C0093a) this.f280c.m563a(id);
            if (inactive == null) {
                if (f278a) {
                    Log.v("LoaderManager", "  Making last loader inactive: " + info);
                }
                info.f266d.m79o();
                this.f280c.m567b(id, info);
            } else if (info.f267e) {
                if (f278a) {
                    Log.v("LoaderManager", "  Removing last inactive loader: " + info);
                }
                inactive.f268f = false;
                inactive.m406f();
                info.f266d.m79o();
                this.f280c.m567b(id, info);
            } else if (info.f270h) {
                if (info.f276n != null) {
                    if (f278a) {
                        Log.v("LoaderManager", "  Removing pending loader: " + info.f276n);
                    }
                    info.f276n.m406f();
                    info.f276n = null;
                }
                if (f278a) {
                    Log.v("LoaderManager", "  Enqueuing as new pending loader");
                }
                info.f276n = m407c(id, args, callback);
                return info.f276n.f266d;
            } else {
                if (f278a) {
                    Log.v("LoaderManager", "  Current loader is stopped; replacing");
                }
                this.f279b.m567b(id, null);
                info.m406f();
            }
        }
        return m408d(id, args, callback).f266d;
    }

    void m415b() {
        if (f278a) {
            Log.v("LoaderManager", "Starting in " + this);
        }
        if (this.f283f) {
            RuntimeException e = new RuntimeException("here");
            e.fillInStackTrace();
            Log.w("LoaderManager", "Called doStart when already started: " + this, e);
            return;
        }
        this.f283f = true;
        for (int i = this.f279b.m565b() - 1; i >= 0; i--) {
            ((C0093a) this.f279b.m571e(i)).m398a();
        }
    }

    void m416c() {
        if (f278a) {
            Log.v("LoaderManager", "Stopping in " + this);
        }
        if (this.f283f) {
            for (int i = this.f279b.m565b() - 1; i >= 0; i--) {
                ((C0093a) this.f279b.m571e(i)).m405e();
            }
            this.f283f = false;
            return;
        }
        RuntimeException e = new RuntimeException("here");
        e.fillInStackTrace();
        Log.w("LoaderManager", "Called doStop when not started: " + this, e);
    }

    void m417d() {
        if (f278a) {
            Log.v("LoaderManager", "Retaining in " + this);
        }
        if (this.f283f) {
            this.f284g = true;
            this.f283f = false;
            for (int i = this.f279b.m565b() - 1; i >= 0; i--) {
                ((C0093a) this.f279b.m571e(i)).m401b();
            }
            return;
        }
        RuntimeException e = new RuntimeException("here");
        e.fillInStackTrace();
        Log.w("LoaderManager", "Called doRetain when not started: " + this, e);
    }

    void m418e() {
        if (this.f284g) {
            if (f278a) {
                Log.v("LoaderManager", "Finished Retaining in " + this);
            }
            this.f284g = false;
            for (int i = this.f279b.m565b() - 1; i >= 0; i--) {
                ((C0093a) this.f279b.m571e(i)).m403c();
            }
        }
    }

    void m419f() {
        for (int i = this.f279b.m565b() - 1; i >= 0; i--) {
            ((C0093a) this.f279b.m571e(i)).f273k = true;
        }
    }

    void m420g() {
        for (int i = this.f279b.m565b() - 1; i >= 0; i--) {
            ((C0093a) this.f279b.m571e(i)).m404d();
        }
    }

    void m421h() {
        int i;
        if (!this.f284g) {
            if (f278a) {
                Log.v("LoaderManager", "Destroying Active in " + this);
            }
            for (i = this.f279b.m565b() - 1; i >= 0; i--) {
                ((C0093a) this.f279b.m571e(i)).m406f();
            }
            this.f279b.m568c();
        }
        if (f278a) {
            Log.v("LoaderManager", "Destroying Inactive in " + this);
        }
        for (i = this.f280c.m565b() - 1; i >= 0; i--) {
            ((C0093a) this.f280c.m571e(i)).m406f();
        }
        this.f280c.m568c();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(Cast.MAX_NAMESPACE_LENGTH);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        C0140c.m548a(this.f282e, sb);
        sb.append("}}");
        return sb.toString();
    }

    public void m412a(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        String innerPrefix;
        int i;
        if (this.f279b.m565b() > 0) {
            writer.print(prefix);
            writer.println("Active Loaders:");
            innerPrefix = prefix + "    ";
            for (i = 0; i < this.f279b.m565b(); i++) {
                C0093a li = (C0093a) this.f279b.m571e(i);
                writer.print(prefix);
                writer.print("  #");
                writer.print(this.f279b.m570d(i));
                writer.print(": ");
                writer.println(li.toString());
                li.m400a(innerPrefix, fd, writer, args);
            }
        }
        if (this.f280c.m565b() > 0) {
            writer.print(prefix);
            writer.println("Inactive Loaders:");
            innerPrefix = prefix + "    ";
            for (i = 0; i < this.f280c.m565b(); i++) {
                li = (C0093a) this.f280c.m571e(i);
                writer.print(prefix);
                writer.print("  #");
                writer.print(this.f280c.m570d(i));
                writer.print(": ");
                writer.println(li.toString());
                li.m400a(innerPrefix, fd, writer, args);
            }
        }
    }

    public boolean m413a() {
        boolean loadersRunning = false;
        int count = this.f279b.m565b();
        for (int i = 0; i < count; i++) {
            C0093a li = (C0093a) this.f279b.m571e(i);
            int i2 = (!li.f270h || li.f268f) ? 0 : 1;
            loadersRunning |= i2;
        }
        return loadersRunning;
    }
}
