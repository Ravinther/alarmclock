package com.google.android.gms.common.api;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.Api.C1456a;
import com.google.android.gms.common.api.Api.C1457c;
import com.google.android.gms.common.api.C1469b.C1403c;
import com.google.android.gms.common.api.C1469b.C1462a;
import com.google.android.gms.common.api.PendingResult.C1458a;
import com.google.android.gms.internal.fk;
import com.google.android.gms.internal.fq;
import com.mopub.mobileads.util.Base64;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.android.gms.common.api.a */
public class C1461a {

    /* renamed from: com.google.android.gms.common.api.a.d */
    public interface C1401d {
        void m6049b(Object obj);
    }

    /* renamed from: com.google.android.gms.common.api.a.a */
    public static abstract class C1402a implements PendingResult, C1401d {
        private final Object AB;
        private C1460c AC;
        private final CountDownLatch AD;
        private final ArrayList AE;
        private ResultCallback AF;
        private volatile Result AG;
        private volatile boolean AH;
        private boolean AI;
        private boolean AJ;
        private fk AK;

        C1402a() {
            this.AB = new Object();
            this.AD = new CountDownLatch(1);
            this.AE = new ArrayList();
        }

        public C1402a(Looper looper) {
            this.AB = new Object();
            this.AD = new CountDownLatch(1);
            this.AE = new ArrayList();
            this.AC = new C1460c(looper);
        }

        public C1402a(C1460c c1460c) {
            this.AB = new Object();
            this.AD = new CountDownLatch(1);
            this.AE = new ArrayList();
            this.AC = c1460c;
        }

        private void m6051b(Result result) {
            this.AG = result;
            this.AK = null;
            this.AD.countDown();
            Status status = this.AG.getStatus();
            if (this.AF != null) {
                this.AC.eg();
                if (!this.AI) {
                    this.AC.m6241a(this.AF, eb());
                }
            }
            Iterator it = this.AE.iterator();
            while (it.hasNext()) {
                ((C1458a) it.next()).m6225l(status);
            }
            this.AE.clear();
        }

        private void m6052c(Result result) {
            if (result instanceof Releasable) {
                try {
                    ((Releasable) result).release();
                } catch (Throwable e) {
                    Log.w("AbstractPendingResult", "Unable to release " + this, e);
                }
            }
        }

        private Result eb() {
            Result result;
            synchronized (this.AB) {
                fq.m8515a(!this.AH, "Result has already been consumed.");
                fq.m8515a(isReady(), "Result is not ready.");
                result = this.AG;
                ec();
            }
            return result;
        }

        private void ed() {
            synchronized (this.AB) {
                if (!isReady()) {
                    m6054a(m6058d(Status.Bw));
                    this.AJ = true;
                }
            }
        }

        private void ee() {
            synchronized (this.AB) {
                if (!isReady()) {
                    m6054a(m6058d(Status.By));
                    this.AJ = true;
                }
            }
        }

        public final void m6053a(C1458a c1458a) {
            fq.m8515a(!this.AH, "Result has already been consumed.");
            synchronized (this.AB) {
                if (isReady()) {
                    c1458a.m6225l(this.AG.getStatus());
                } else {
                    this.AE.add(c1458a);
                }
            }
        }

        public final void m6054a(Result result) {
            boolean z = true;
            synchronized (this.AB) {
                if (this.AJ || this.AI) {
                    m6052c(result);
                    return;
                }
                fq.m8515a(!isReady(), "Results have already been set");
                if (this.AH) {
                    z = false;
                }
                fq.m8515a(z, "Result has already been consumed");
                m6051b(result);
            }
        }

        protected void m6055a(C1460c c1460c) {
            this.AC = c1460c;
        }

        protected final void m6056a(fk fkVar) {
            synchronized (this.AB) {
                this.AK = fkVar;
            }
        }

        public final Result await() {
            boolean z = false;
            fq.m8515a(!this.AH, "Result has already been consumed");
            if (isReady() || Looper.myLooper() != Looper.getMainLooper()) {
                z = true;
            }
            fq.m8515a(z, "await must not be called on the UI thread");
            try {
                this.AD.await();
            } catch (InterruptedException e) {
                ed();
            }
            fq.m8515a(isReady(), "Result is not ready.");
            return eb();
        }

        public final Result await(long time, TimeUnit units) {
            boolean z = false;
            fq.m8515a(!this.AH, "Result has already been consumed.");
            if (isReady() || Looper.myLooper() != Looper.getMainLooper()) {
                z = true;
            }
            fq.m8515a(z, "await must not be called on the UI thread");
            try {
                if (!this.AD.await(time, units)) {
                    ee();
                }
            } catch (InterruptedException e) {
                ed();
            }
            fq.m8515a(isReady(), "Result is not ready.");
            return eb();
        }

        public /* synthetic */ void m6057b(Object obj) {
            m6054a((Result) obj);
        }

        public void cancel() {
            synchronized (this.AB) {
                if (this.AI) {
                    return;
                }
                if (this.AK != null) {
                    try {
                        this.AK.cancel();
                    } catch (RemoteException e) {
                    }
                }
                m6052c(this.AG);
                this.AF = null;
                this.AI = true;
                m6051b(m6058d(Status.Bz));
            }
        }

        protected abstract Result m6058d(Status status);

        protected void ec() {
            this.AH = true;
            this.AG = null;
            this.AF = null;
        }

        public boolean isCanceled() {
            boolean z;
            synchronized (this.AB) {
                z = this.AI;
            }
            return z;
        }

        public final boolean isReady() {
            return this.AD.getCount() == 0;
        }

        public final void setResultCallback(ResultCallback callback) {
            fq.m8515a(!this.AH, "Result has already been consumed.");
            synchronized (this.AB) {
                if (isCanceled()) {
                    return;
                }
                if (isReady()) {
                    this.AC.m6241a(callback, eb());
                } else {
                    this.AF = callback;
                }
            }
        }

        public final void setResultCallback(ResultCallback callback, long time, TimeUnit units) {
            fq.m8515a(!this.AH, "Result has already been consumed.");
            synchronized (this.AB) {
                if (isCanceled()) {
                    return;
                }
                if (isReady()) {
                    this.AC.m6241a(callback, eb());
                } else {
                    this.AF = callback;
                    this.AC.m6242a(this, units.toMillis(time));
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.common.api.a.b */
    public static abstract class C1404b extends C1402a implements C1403c {
        private C1462a AL;
        private final C1457c Az;

        protected C1404b(C1457c c1457c) {
            this.Az = (C1457c) fq.m8520f(c1457c);
        }

        private void m6062a(RemoteException remoteException) {
            m6066k(new Status(8, remoteException.getLocalizedMessage(), null));
        }

        protected abstract void m6063a(C1456a c1456a);

        public void m6064a(C1462a c1462a) {
            this.AL = c1462a;
        }

        public final void m6065b(C1456a c1456a) {
            m6055a(new C1460c(c1456a.getLooper()));
            try {
                m6063a(c1456a);
            } catch (RemoteException e) {
                m6062a(e);
                throw e;
            } catch (RemoteException e2) {
                m6062a(e2);
            }
        }

        public final C1457c ea() {
            return this.Az;
        }

        protected void ec() {
            super.ec();
            if (this.AL != null) {
                this.AL.m6244b(this);
                this.AL = null;
            }
        }

        public int ef() {
            return 0;
        }

        public final void m6066k(Status status) {
            fq.m8519b(!status.isSuccess(), (Object) "Failed result must not be success");
            m6054a(m6058d(status));
        }
    }

    /* renamed from: com.google.android.gms.common.api.a.c */
    public static class C1460c extends Handler {
        public C1460c() {
            this(Looper.getMainLooper());
        }

        public C1460c(Looper looper) {
            super(looper);
        }

        public void m6241a(ResultCallback resultCallback, Result result) {
            sendMessage(obtainMessage(1, new Pair(resultCallback, result)));
        }

        public void m6242a(C1402a c1402a, long j) {
            sendMessageDelayed(obtainMessage(2, c1402a), j);
        }

        protected void m6243b(ResultCallback resultCallback, Result result) {
            resultCallback.onResult(result);
        }

        public void eg() {
            removeMessages(2);
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case Base64.NO_PADDING /*1*/:
                    Pair pair = (Pair) msg.obj;
                    m6243b((ResultCallback) pair.first, (Result) pair.second);
                case Base64.NO_WRAP /*2*/:
                    ((C1402a) msg.obj).ee();
                default:
                    Log.wtf("GoogleApi", "Don't know how to handle this message.");
            }
        }
    }
}
