package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.appstate.AppStateBuffer;
import com.google.android.gms.appstate.AppStateManager.StateConflictResult;
import com.google.android.gms.appstate.AppStateManager.StateDeletedResult;
import com.google.android.gms.appstate.AppStateManager.StateListResult;
import com.google.android.gms.appstate.AppStateManager.StateLoadedResult;
import com.google.android.gms.appstate.AppStateManager.StateResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.C1461a.C1401d;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.internal.ek.C1857a;
import com.google.android.gms.internal.ff.C1624b;
import com.google.android.gms.internal.ff.C1625d;
import com.google.android.gms.internal.ff.C1893e;

public final class ei extends ff {
    private final String wG;

    /* renamed from: com.google.android.gms.internal.ei.a */
    final class C1847a extends eh {
        private final C1401d wH;
        final /* synthetic */ ei wI;

        public C1847a(ei eiVar, C1401d c1401d) {
            this.wI = eiVar;
            this.wH = (C1401d) fq.m8517b((Object) c1401d, (Object) "Result holder must not be null");
        }

        public void m8270b(int i, int i2) {
            this.wI.m6504a(new C1848b(this.wI, this.wH, new Status(i), i2));
        }
    }

    /* renamed from: com.google.android.gms.internal.ei.b */
    final class C1848b extends C1624b implements StateDeletedResult {
        final /* synthetic */ ei wI;
        private final Status wJ;
        private final int wK;

        public C1848b(ei eiVar, C1401d c1401d, Status status, int i) {
            this.wI = eiVar;
            super(eiVar, c1401d);
            this.wJ = status;
            this.wK = i;
        }

        public /* synthetic */ void m8271a(Object obj) {
            m8272c((C1401d) obj);
        }

        public void m8272c(C1401d c1401d) {
            c1401d.m6049b(this);
        }

        protected void dx() {
        }

        public int getStateKey() {
            return this.wK;
        }

        public Status getStatus() {
            return this.wJ;
        }
    }

    /* renamed from: com.google.android.gms.internal.ei.c */
    final class C1849c extends eh {
        private final C1401d wH;
        final /* synthetic */ ei wI;

        public C1849c(ei eiVar, C1401d c1401d) {
            this.wI = eiVar;
            this.wH = (C1401d) fq.m8517b((Object) c1401d, (Object) "Result holder must not be null");
        }

        public void m8273a(DataHolder dataHolder) {
            this.wI.m6504a(new C1850d(this.wI, this.wH, new Status(dataHolder.getStatusCode()), dataHolder));
        }
    }

    /* renamed from: com.google.android.gms.internal.ei.d */
    final class C1850d extends C1625d implements StateListResult {
        final /* synthetic */ ei wI;
        private final Status wJ;
        private final AppStateBuffer wL;

        public C1850d(ei eiVar, C1401d c1401d, Status status, DataHolder dataHolder) {
            this.wI = eiVar;
            super(eiVar, c1401d, dataHolder);
            this.wJ = status;
            this.wL = new AppStateBuffer(dataHolder);
        }

        public void m8274a(C1401d c1401d, DataHolder dataHolder) {
            c1401d.m6049b(this);
        }

        public AppStateBuffer getStateBuffer() {
            return this.wL;
        }

        public Status getStatus() {
            return this.wJ;
        }
    }

    /* renamed from: com.google.android.gms.internal.ei.e */
    final class C1851e extends eh {
        private final C1401d wH;
        final /* synthetic */ ei wI;

        public C1851e(ei eiVar, C1401d c1401d) {
            this.wI = eiVar;
            this.wH = (C1401d) fq.m8517b((Object) c1401d, (Object) "Result holder must not be null");
        }

        public void m8276a(int i, DataHolder dataHolder) {
            this.wI.m6504a(new C1852f(this.wI, this.wH, i, dataHolder));
        }
    }

    /* renamed from: com.google.android.gms.internal.ei.f */
    final class C1852f extends C1625d implements StateConflictResult, StateLoadedResult, StateResult {
        final /* synthetic */ ei wI;
        private final Status wJ;
        private final int wK;
        private final AppStateBuffer wL;

        public C1852f(ei eiVar, C1401d c1401d, int i, DataHolder dataHolder) {
            this.wI = eiVar;
            super(eiVar, c1401d, dataHolder);
            this.wK = i;
            this.wJ = new Status(dataHolder.getStatusCode());
            this.wL = new AppStateBuffer(dataHolder);
        }

        private boolean dy() {
            return this.wJ.getStatusCode() == GamesStatusCodes.STATUS_REQUEST_UPDATE_PARTIAL_SUCCESS;
        }

        public void m8277a(C1401d c1401d, DataHolder dataHolder) {
            c1401d.m6049b(this);
        }

        public StateConflictResult getConflictResult() {
            return dy() ? this : null;
        }

        public StateLoadedResult getLoadedResult() {
            return dy() ? null : this;
        }

        public byte[] getLocalData() {
            return this.wL.getCount() == 0 ? null : this.wL.get(0).getLocalData();
        }

        public String getResolvedVersion() {
            return this.wL.getCount() == 0 ? null : this.wL.get(0).getConflictVersion();
        }

        public byte[] getServerData() {
            return this.wL.getCount() == 0 ? null : this.wL.get(0).getConflictData();
        }

        public int getStateKey() {
            return this.wK;
        }

        public Status getStatus() {
            return this.wJ;
        }

        public void release() {
            this.wL.close();
        }
    }

    /* renamed from: com.google.android.gms.internal.ei.g */
    final class C1853g extends eh {
        C1401d wH;
        final /* synthetic */ ei wI;

        public C1853g(ei eiVar, C1401d c1401d) {
            this.wI = eiVar;
            this.wH = (C1401d) fq.m8517b((Object) c1401d, (Object) "Holder must not be null");
        }

        public void du() {
            this.wI.m6504a(new C1854h(this.wI, this.wH, new Status(0)));
        }
    }

    /* renamed from: com.google.android.gms.internal.ei.h */
    final class C1854h extends C1624b {
        final /* synthetic */ ei wI;
        private final Status wJ;

        public C1854h(ei eiVar, C1401d c1401d, Status status) {
            this.wI = eiVar;
            super(eiVar, c1401d);
            this.wJ = status;
        }

        public /* synthetic */ void m8279a(Object obj) {
            m8280c((C1401d) obj);
        }

        public void m8280c(C1401d c1401d) {
            c1401d.m6049b(this.wJ);
        }

        protected void dx() {
        }
    }

    public ei(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str, String[] strArr) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, strArr);
        this.wG = (String) fq.m8520f(str);
    }

    public void m8281a(C1401d c1401d) {
        try {
            ((ek) eM()).m8295a(new C1849c(this, c1401d));
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    public void m8282a(C1401d c1401d, int i) {
        try {
            ((ek) eM()).m8300b(new C1847a(this, c1401d), i);
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    public void m8283a(C1401d c1401d, int i, String str, byte[] bArr) {
        try {
            ((ek) eM()).m8297a(new C1851e(this, c1401d), i, str, bArr);
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    public void m8284a(C1401d c1401d, int i, byte[] bArr) {
        if (c1401d == null) {
            ej ejVar = null;
        } else {
            Object c1851e = new C1851e(this, c1401d);
        }
        try {
            ((ek) eM()).m8298a(ejVar, i, bArr);
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    protected void m8285a(fm fmVar, C1893e c1893e) {
        fmVar.m8454a((fl) c1893e, (int) GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName(), this.wG, eL());
    }

    public void m8286b(C1401d c1401d) {
        try {
            ((ek) eM()).m8299b(new C1853g(this, c1401d));
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    public void m8287b(C1401d c1401d, int i) {
        try {
            ((ek) eM()).m8296a(new C1851e(this, c1401d), i);
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    protected void m8288b(String... strArr) {
        boolean z = false;
        for (String equals : strArr) {
            if (equals.equals(Scopes.APP_STATE)) {
                z = true;
            }
        }
        fq.m8515a(z, String.format("App State APIs requires %s to function.", new Object[]{Scopes.APP_STATE}));
    }

    protected String bg() {
        return "com.google.android.gms.appstate.service.START";
    }

    protected String bh() {
        return "com.google.android.gms.appstate.internal.IAppStateService";
    }

    public int dv() {
        try {
            return ((ek) eM()).dv();
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
            return 2;
        }
    }

    public int dw() {
        try {
            return ((ek) eM()).dw();
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
            return 2;
        }
    }

    protected /* synthetic */ IInterface m8289r(IBinder iBinder) {
        return m8290u(iBinder);
    }

    protected ek m8290u(IBinder iBinder) {
        return C1857a.m8309w(iBinder);
    }
}
