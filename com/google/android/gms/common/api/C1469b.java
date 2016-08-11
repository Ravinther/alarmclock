package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api.C1398b;
import com.google.android.gms.common.api.Api.C1456a;
import com.google.android.gms.common.api.Api.C1457c;
import com.google.android.gms.common.api.C1461a.C1404b;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.fc;
import com.google.android.gms.internal.fg;
import com.google.android.gms.internal.fg.C1465b;
import com.google.android.gms.internal.fq;
import com.mopub.mobileads.util.Base64;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.google.android.gms.common.api.b */
final class C1469b implements GoogleApiClient {
    private final C1462a AL;
    private final Looper AS;
    private final Lock Ba;
    private final Condition Bb;
    private final fg Bc;
    final Queue Bd;
    private ConnectionResult Be;
    private int Bf;
    private int Bg;
    private int Bh;
    private boolean Bi;
    private int Bj;
    private long Bk;
    final Handler Bl;
    private final Bundle Bm;
    private final Map Bn;
    private boolean Bo;
    final Set Bp;
    final ConnectionCallbacks Bq;
    private final C1465b Br;

    /* renamed from: com.google.android.gms.common.api.b.c */
    interface C1403c {
        void m6059a(C1462a c1462a);

        void m6060b(C1456a c1456a);

        void cancel();

        C1457c ea();

        int ef();

        void m6061k(Status status);
    }

    /* renamed from: com.google.android.gms.common.api.b.a */
    interface C1462a {
        void m6244b(C1403c c1403c);
    }

    /* renamed from: com.google.android.gms.common.api.b.1 */
    class C14631 implements C1462a {
        final /* synthetic */ C1469b Bs;

        C14631(C1469b c1469b) {
            this.Bs = c1469b;
        }

        public void m6245b(C1403c c1403c) {
            this.Bs.Ba.lock();
            try {
                this.Bs.Bp.remove(c1403c);
            } finally {
                this.Bs.Ba.unlock();
            }
        }
    }

    /* renamed from: com.google.android.gms.common.api.b.2 */
    class C14642 implements ConnectionCallbacks {
        final /* synthetic */ C1469b Bs;

        C14642(C1469b c1469b) {
            this.Bs = c1469b;
        }

        public void onConnected(Bundle connectionHint) {
            this.Bs.Ba.lock();
            try {
                if (this.Bs.Bg == 1) {
                    if (connectionHint != null) {
                        this.Bs.Bm.putAll(connectionHint);
                    }
                    this.Bs.ei();
                }
                this.Bs.Ba.unlock();
            } catch (Throwable th) {
                this.Bs.Ba.unlock();
            }
        }

        public void onConnectionSuspended(int cause) {
            this.Bs.Ba.lock();
            try {
                this.Bs.m6246E(cause);
                switch (cause) {
                    case Base64.NO_PADDING /*1*/:
                        if (!this.Bs.ek()) {
                            this.Bs.Bh = 2;
                            this.Bs.Bl.sendMessageDelayed(this.Bs.Bl.obtainMessage(1), this.Bs.Bk);
                            break;
                        }
                        this.Bs.Ba.unlock();
                        return;
                    case Base64.NO_WRAP /*2*/:
                        this.Bs.connect();
                        break;
                }
                this.Bs.Ba.unlock();
            } catch (Throwable th) {
                this.Bs.Ba.unlock();
            }
        }
    }

    /* renamed from: com.google.android.gms.common.api.b.3 */
    class C14663 implements C1465b {
        final /* synthetic */ C1469b Bs;

        C14663(C1469b c1469b) {
            this.Bs = c1469b;
        }

        public Bundle dG() {
            return null;
        }

        public boolean em() {
            return this.Bs.Bo;
        }

        public boolean isConnected() {
            return this.Bs.isConnected();
        }
    }

    /* renamed from: com.google.android.gms.common.api.b.4 */
    class C14674 implements OnConnectionFailedListener {
        final /* synthetic */ C1469b Bs;
        final /* synthetic */ C1398b Bt;

        C14674(C1469b c1469b, C1398b c1398b) {
            this.Bs = c1469b;
            this.Bt = c1398b;
        }

        public void onConnectionFailed(ConnectionResult result) {
            this.Bs.Ba.lock();
            try {
                if (this.Bs.Be == null || this.Bt.getPriority() < this.Bs.Bf) {
                    this.Bs.Be = result;
                    this.Bs.Bf = this.Bt.getPriority();
                }
                this.Bs.ei();
            } finally {
                this.Bs.Ba.unlock();
            }
        }
    }

    /* renamed from: com.google.android.gms.common.api.b.b */
    class C1468b extends Handler {
        final /* synthetic */ C1469b Bs;

        C1468b(C1469b c1469b, Looper looper) {
            this.Bs = c1469b;
            super(looper);
        }

        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                this.Bs.Ba.lock();
                try {
                    if (!(this.Bs.isConnected() || this.Bs.isConnecting())) {
                        this.Bs.connect();
                    }
                    this.Bs.Ba.unlock();
                } catch (Throwable th) {
                    this.Bs.Ba.unlock();
                }
            } else {
                Log.wtf("GoogleApiClientImpl", "Don't know how to handle this message.");
            }
        }
    }

    public C1469b(Context context, Looper looper, fc fcVar, Map map, Set set, Set set2) {
        this.Ba = new ReentrantLock();
        this.Bb = this.Ba.newCondition();
        this.Bd = new LinkedList();
        this.Bg = 4;
        this.Bh = 0;
        this.Bi = false;
        this.Bk = 5000;
        this.Bm = new Bundle();
        this.Bn = new HashMap();
        this.Bp = new HashSet();
        this.AL = new C14631(this);
        this.Bq = new C14642(this);
        this.Br = new C14663(this);
        this.Bc = new fg(context, looper, this.Br);
        this.AS = looper;
        this.Bl = new C1468b(this, looper);
        for (ConnectionCallbacks registerConnectionCallbacks : set) {
            this.Bc.registerConnectionCallbacks(registerConnectionCallbacks);
        }
        for (OnConnectionFailedListener registerConnectionFailedListener : set2) {
            this.Bc.registerConnectionFailedListener(registerConnectionFailedListener);
        }
        for (Api api : map.keySet()) {
            C1398b dY = api.dY();
            Object obj = map.get(api);
            this.Bn.put(api.ea(), C1469b.m6248a(dY, obj, context, looper, fcVar, this.Bq, new C14674(this, dY)));
        }
    }

    private void m6246E(int i) {
        this.Ba.lock();
        try {
            if (this.Bg != 3) {
                if (i == -1) {
                    Iterator it;
                    C1403c c1403c;
                    if (isConnecting()) {
                        it = this.Bd.iterator();
                        while (it.hasNext()) {
                            c1403c = (C1403c) it.next();
                            if (c1403c.ef() != 1) {
                                c1403c.cancel();
                                it.remove();
                            }
                        }
                    } else {
                        this.Bd.clear();
                    }
                    for (C1403c c1403c2 : this.Bp) {
                        c1403c2.cancel();
                    }
                    this.Bp.clear();
                    if (this.Be == null && !this.Bd.isEmpty()) {
                        this.Bi = true;
                        return;
                    }
                }
                boolean isConnecting = isConnecting();
                boolean isConnected = isConnected();
                this.Bg = 3;
                if (isConnecting) {
                    if (i == -1) {
                        this.Be = null;
                    }
                    this.Bb.signalAll();
                }
                this.Bo = false;
                for (C1456a c1456a : this.Bn.values()) {
                    if (c1456a.isConnected()) {
                        c1456a.disconnect();
                    }
                }
                this.Bo = true;
                this.Bg = 4;
                if (isConnected) {
                    if (i != -1) {
                        this.Bc.m8428O(i);
                    }
                    this.Bo = false;
                }
            }
            this.Ba.unlock();
        } finally {
            this.Ba.unlock();
        }
    }

    private static C1456a m6248a(C1398b c1398b, Object obj, Context context, Looper looper, fc fcVar, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        return c1398b.m6045a(context, looper, fcVar, obj, connectionCallbacks, onConnectionFailedListener);
    }

    private void m6250a(C1403c c1403c) {
        boolean z = true;
        this.Ba.lock();
        try {
            boolean z2 = isConnected() || ek();
            fq.m8515a(z2, "GoogleApiClient is not connected yet.");
            if (c1403c.ea() == null) {
                z = false;
            }
            fq.m8519b(z, (Object) "This task can not be executed or enqueued (it's probably a Batch or malformed)");
            this.Bp.add(c1403c);
            c1403c.m6059a(this.AL);
            if (ek()) {
                c1403c.m6061k(new Status(8));
                return;
            }
            c1403c.m6060b(m6262a(c1403c.ea()));
            this.Ba.unlock();
        } finally {
            this.Ba.unlock();
        }
    }

    private void ei() {
        this.Ba.lock();
        try {
            this.Bj--;
            if (this.Bj == 0) {
                if (this.Be != null) {
                    this.Bi = false;
                    m6246E(3);
                    if (ek()) {
                        this.Bh--;
                    }
                    if (ek()) {
                        this.Bl.sendMessageDelayed(this.Bl.obtainMessage(1), this.Bk);
                    } else {
                        this.Bc.m8429a(this.Be);
                    }
                    this.Bo = false;
                } else {
                    this.Bg = 2;
                    el();
                    this.Bb.signalAll();
                    ej();
                    if (this.Bi) {
                        this.Bi = false;
                        m6246E(-1);
                    } else {
                        this.Bc.m8430b(this.Bm.isEmpty() ? null : this.Bm);
                    }
                }
            }
            this.Ba.unlock();
        } catch (Throwable th) {
            this.Ba.unlock();
        }
    }

    private void ej() {
        boolean z = isConnected() || ek();
        fq.m8515a(z, "GoogleApiClient is not connected yet.");
        this.Ba.lock();
        while (!this.Bd.isEmpty()) {
            try {
                m6250a((C1403c) this.Bd.remove());
            } catch (Throwable e) {
                Log.w("GoogleApiClientImpl", "Service died while flushing queue", e);
            } catch (Throwable th) {
                this.Ba.unlock();
            }
        }
        this.Ba.unlock();
    }

    private boolean ek() {
        this.Ba.lock();
        try {
            boolean z = this.Bh != 0;
            this.Ba.unlock();
            return z;
        } catch (Throwable th) {
            this.Ba.unlock();
        }
    }

    private void el() {
        this.Ba.lock();
        try {
            this.Bh = 0;
            this.Bl.removeMessages(1);
        } finally {
            this.Ba.unlock();
        }
    }

    public C1456a m6262a(C1457c c1457c) {
        Object obj = (C1456a) this.Bn.get(c1457c);
        fq.m8517b(obj, (Object) "Appropriate Api was not requested.");
        return obj;
    }

    public C1404b m6263a(C1404b c1404b) {
        this.Ba.lock();
        try {
            if (isConnected()) {
                m6264b(c1404b);
            } else {
                this.Bd.add(c1404b);
            }
            this.Ba.unlock();
            return c1404b;
        } catch (Throwable th) {
            this.Ba.unlock();
        }
    }

    public C1404b m6264b(C1404b c1404b) {
        boolean z = isConnected() || ek();
        fq.m8515a(z, "GoogleApiClient is not connected yet.");
        ej();
        try {
            m6250a((C1403c) c1404b);
        } catch (DeadObjectException e) {
            m6246E(1);
        }
        return c1404b;
    }

    public ConnectionResult blockingConnect(long timeout, TimeUnit unit) {
        ConnectionResult connectionResult;
        fq.m8515a(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        this.Ba.lock();
        try {
            connect();
            long toNanos = unit.toNanos(timeout);
            while (isConnecting()) {
                toNanos = this.Bb.awaitNanos(toNanos);
                if (toNanos <= 0) {
                    connectionResult = new ConnectionResult(14, null);
                    break;
                }
            }
            if (isConnected()) {
                connectionResult = ConnectionResult.Ag;
                this.Ba.unlock();
            } else if (this.Be != null) {
                connectionResult = this.Be;
                this.Ba.unlock();
            } else {
                connectionResult = new ConnectionResult(13, null);
                this.Ba.unlock();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            connectionResult = new ConnectionResult(15, null);
        } finally {
            this.Ba.unlock();
        }
        return connectionResult;
    }

    public void connect() {
        this.Ba.lock();
        try {
            this.Bi = false;
            if (isConnected() || isConnecting()) {
                this.Ba.unlock();
                return;
            }
            this.Bo = true;
            this.Be = null;
            this.Bg = 1;
            this.Bm.clear();
            this.Bj = this.Bn.size();
            for (C1456a connect : this.Bn.values()) {
                connect.connect();
            }
            this.Ba.unlock();
        } catch (Throwable th) {
            this.Ba.unlock();
        }
    }

    public void disconnect() {
        el();
        m6246E(-1);
    }

    public Looper getLooper() {
        return this.AS;
    }

    public boolean isConnected() {
        this.Ba.lock();
        try {
            boolean z = this.Bg == 2;
            this.Ba.unlock();
            return z;
        } catch (Throwable th) {
            this.Ba.unlock();
        }
    }

    public boolean isConnecting() {
        boolean z = true;
        this.Ba.lock();
        try {
            if (this.Bg != 1) {
                z = false;
            }
            this.Ba.unlock();
            return z;
        } catch (Throwable th) {
            this.Ba.unlock();
        }
    }

    public boolean isConnectionCallbacksRegistered(ConnectionCallbacks listener) {
        return this.Bc.isConnectionCallbacksRegistered(listener);
    }

    public boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener listener) {
        return this.Bc.isConnectionFailedListenerRegistered(listener);
    }

    public void reconnect() {
        disconnect();
        connect();
    }

    public void registerConnectionCallbacks(ConnectionCallbacks listener) {
        this.Bc.registerConnectionCallbacks(listener);
    }

    public void registerConnectionFailedListener(OnConnectionFailedListener listener) {
        this.Bc.registerConnectionFailedListener(listener);
    }

    public void unregisterConnectionCallbacks(ConnectionCallbacks listener) {
        this.Bc.unregisterConnectionCallbacks(listener);
    }

    public void unregisterConnectionFailedListener(OnConnectionFailedListener listener) {
        this.Bc.unregisterConnectionFailedListener(listener);
    }
}
