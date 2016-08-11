package com.avg.ui.general.p055a;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.p012a.C0329b;
import com.avg.toolkit.ITKSvc;
import com.avg.ui.general.p056h.C1064a;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Vector;

/* renamed from: com.avg.ui.general.a.d */
public abstract class C1055d extends C0329b {
    private ServiceConnection f3235o;
    private List f3236p;
    public boolean f3237q;
    protected IBinder f3238r;
    private final Object f3239s;

    /* renamed from: com.avg.ui.general.a.d.a */
    private static class C1061a implements ServiceConnection {
        private WeakReference f3255a;

        private C1061a(C1055d activity) {
            this.f3255a = new WeakReference(activity);
        }

        public void onServiceConnected(ComponentName className, IBinder binder) {
            C1055d activity = (C1055d) this.f3255a.get();
            if (activity != null && !activity.f3237q) {
                activity.f3237q = true;
                activity.f3238r = binder;
                activity.m4585a(activity);
            }
        }

        public void onServiceDisconnected(ComponentName className) {
        }
    }

    /* renamed from: com.avg.ui.general.a.d.1 */
    class C10621 extends C1061a {
        final /* synthetic */ C1064a f3256a;
        final /* synthetic */ C1055d f3257b;

        C10621(C1055d c1055d, C1055d x0, C1064a c1064a) {
            this.f3257b = c1055d;
            this.f3256a = c1064a;
            super(null);
        }

        public void onServiceConnected(ComponentName className, IBinder binder) {
            super.onServiceConnected(className, binder);
            this.f3256a.m4620a(binder);
            synchronized (this.f3257b.f3239s) {
                for (C1064a pendingCallback : this.f3257b.f3236p) {
                    pendingCallback.m4620a(binder);
                }
                this.f3257b.f3236p.clear();
            }
        }
    }

    public C1055d() {
        this.f3236p = new Vector();
        this.f3239s = new Object();
    }

    public synchronized void m4586a(C1064a callback) {
        if (!this.f3237q || this.f3238r == null) {
            synchronized (this.f3239s) {
                if (this.f3235o == null) {
                    this.f3235o = new C10621(this, this, callback);
                    m4587s();
                } else {
                    this.f3236p.add(callback);
                }
            }
        } else {
            callback.m4620a(this.f3238r);
        }
    }

    public void m4587s() {
        Intent serviceIntent = new Intent(ITKSvc.TK_SERVICE_ACTION);
        serviceIntent.setPackage(getPackageName());
        bindService(serviceIntent, this.f3235o, 1);
    }

    public void m4588t() {
        if (this.f3237q) {
            unbindService(this.f3235o);
            this.f3237q = false;
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        m4588t();
    }

    protected void m4585a(C1055d activity) {
    }
}
