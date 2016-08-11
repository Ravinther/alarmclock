package com.google.android.gms.appstate;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.C1398b;
import com.google.android.gms.common.api.Api.C1457c;
import com.google.android.gms.common.api.C1461a.C1401d;
import com.google.android.gms.common.api.C1461a.C1404b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.ei;
import com.google.android.gms.internal.fc;
import com.google.android.gms.internal.fq;

public final class AppStateManager {
    public static final Api API;
    public static final Scope SCOPE_APP_STATE;
    static final C1457c wx;
    private static final C1398b wy;

    /* renamed from: com.google.android.gms.appstate.AppStateManager.1 */
    static class C13991 implements C1398b {
        C13991() {
        }

        public ei m6047a(Context context, Looper looper, fc fcVar, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new ei(context, looper, connectionCallbacks, onConnectionFailedListener, fcVar.eC(), (String[]) fcVar.eE().toArray(new String[0]));
        }

        public int getPriority() {
            return Integer.MAX_VALUE;
        }
    }

    public interface StateResult extends Releasable, Result {
        StateConflictResult getConflictResult();

        StateLoadedResult getLoadedResult();
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager.2 */
    static class C14002 implements StateResult {
        final /* synthetic */ Status wz;

        C14002(Status status) {
            this.wz = status;
        }

        public StateConflictResult getConflictResult() {
            return null;
        }

        public StateLoadedResult getLoadedResult() {
            return null;
        }

        public Status getStatus() {
            return this.wz;
        }

        public void release() {
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager.a */
    public static abstract class C1405a extends C1404b {
        public C1405a() {
            super(AppStateManager.wx);
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager.e */
    private static abstract class C1406e extends C1405a {
        private C1406e() {
        }

        public /* synthetic */ Result m6067d(Status status) {
            return m6068g(status);
        }

        public StateResult m6068g(Status status) {
            return AppStateManager.m6089a(status);
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager.3 */
    static class C14073 extends C1406e {
        final /* synthetic */ int wA;
        final /* synthetic */ byte[] wB;

        C14073(int i, byte[] bArr) {
            this.wA = i;
            this.wB = bArr;
            super();
        }

        protected void m6070a(ei eiVar) {
            eiVar.m8284a(null, this.wA, this.wB);
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager.4 */
    static class C14084 extends C1406e {
        final /* synthetic */ int wA;
        final /* synthetic */ byte[] wB;

        C14084(int i, byte[] bArr) {
            this.wA = i;
            this.wB = bArr;
            super();
        }

        protected void m6072a(ei eiVar) {
            eiVar.m8284a(this, this.wA, this.wB);
        }
    }

    public interface StateDeletedResult extends Result {
        int getStateKey();
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager.b */
    private static abstract class C1410b extends C1405a {
        private C1410b() {
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager.5 */
    static class C14115 extends C1410b {
        final /* synthetic */ int wA;

        /* renamed from: com.google.android.gms.appstate.AppStateManager.5.1 */
        class C14091 implements StateDeletedResult {
            final /* synthetic */ C14115 wC;
            final /* synthetic */ Status wz;

            C14091(C14115 c14115, Status status) {
                this.wC = c14115;
                this.wz = status;
            }

            public int getStateKey() {
                return this.wC.wA;
            }

            public Status getStatus() {
                return this.wz;
            }
        }

        C14115(int i) {
            this.wA = i;
            super();
        }

        protected void m6074a(ei eiVar) {
            eiVar.m8282a((C1401d) this, this.wA);
        }

        public StateDeletedResult m6075c(Status status) {
            return new C14091(this, status);
        }

        public /* synthetic */ Result m6076d(Status status) {
            return m6075c(status);
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager.6 */
    static class C14126 extends C1406e {
        final /* synthetic */ int wA;

        C14126(int i) {
            this.wA = i;
            super();
        }

        protected void m6078a(ei eiVar) {
            eiVar.m8287b(this, this.wA);
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager.c */
    private static abstract class C1413c extends C1405a {

        /* renamed from: com.google.android.gms.appstate.AppStateManager.c.1 */
        class C14181 implements StateListResult {
            final /* synthetic */ C1413c wF;
            final /* synthetic */ Status wz;

            C14181(C1413c c1413c, Status status) {
                this.wF = c1413c;
                this.wz = status;
            }

            public AppStateBuffer getStateBuffer() {
                return new AppStateBuffer(null);
            }

            public Status getStatus() {
                return this.wz;
            }
        }

        private C1413c() {
        }

        public /* synthetic */ Result m6079d(Status status) {
            return m6080e(status);
        }

        public StateListResult m6080e(Status status) {
            return new C14181(this, status);
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager.7 */
    static class C14147 extends C1413c {
        C14147() {
            super();
        }

        protected void m6082a(ei eiVar) {
            eiVar.m8281a(this);
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager.8 */
    static class C14158 extends C1406e {
        final /* synthetic */ int wA;
        final /* synthetic */ String wD;
        final /* synthetic */ byte[] wE;

        C14158(int i, String str, byte[] bArr) {
            this.wA = i;
            this.wD = str;
            this.wE = bArr;
            super();
        }

        protected void m6084a(ei eiVar) {
            eiVar.m8283a(this, this.wA, this.wD, this.wE);
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager.d */
    private static abstract class C1416d extends C1405a {
        private C1416d() {
        }

        public /* synthetic */ Result m6085d(Status status) {
            return m6086f(status);
        }

        public Status m6086f(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager.9 */
    static class C14179 extends C1416d {
        C14179() {
            super();
        }

        protected void m6088a(ei eiVar) {
            eiVar.m8286b((C1401d) this);
        }
    }

    public interface StateConflictResult extends Releasable, Result {
        byte[] getLocalData();

        String getResolvedVersion();

        byte[] getServerData();

        int getStateKey();
    }

    public interface StateListResult extends Result {
        AppStateBuffer getStateBuffer();
    }

    public interface StateLoadedResult extends Releasable, Result {
        byte[] getLocalData();

        int getStateKey();
    }

    static {
        wx = new C1457c();
        wy = new C13991();
        SCOPE_APP_STATE = new Scope(Scopes.APP_STATE);
        API = new Api(wy, wx, SCOPE_APP_STATE);
    }

    private AppStateManager() {
    }

    private static StateResult m6089a(Status status) {
        return new C14002(status);
    }

    public static ei m6090a(GoogleApiClient googleApiClient) {
        boolean z = true;
        fq.m8519b(googleApiClient != null, (Object) "GoogleApiClient parameter is required.");
        fq.m8515a(googleApiClient.isConnected(), "GoogleApiClient must be connected.");
        ei eiVar = (ei) googleApiClient.m6237a(wx);
        if (eiVar == null) {
            z = false;
        }
        fq.m8515a(z, "GoogleApiClient is not configured to use the AppState API. Pass AppStateManager.API into GoogleApiClient.Builder#addApi() to use this feature.");
        return eiVar;
    }

    public static PendingResult delete(GoogleApiClient googleApiClient, int stateKey) {
        return googleApiClient.m6239b(new C14115(stateKey));
    }

    public static int getMaxNumKeys(GoogleApiClient googleApiClient) {
        return m6090a(googleApiClient).dw();
    }

    public static int getMaxStateSize(GoogleApiClient googleApiClient) {
        return m6090a(googleApiClient).dv();
    }

    public static PendingResult list(GoogleApiClient googleApiClient) {
        return googleApiClient.m6238a(new C14147());
    }

    public static PendingResult load(GoogleApiClient googleApiClient, int stateKey) {
        return googleApiClient.m6238a(new C14126(stateKey));
    }

    public static PendingResult resolve(GoogleApiClient googleApiClient, int stateKey, String resolvedVersion, byte[] resolvedData) {
        return googleApiClient.m6239b(new C14158(stateKey, resolvedVersion, resolvedData));
    }

    public static PendingResult signOut(GoogleApiClient googleApiClient) {
        return googleApiClient.m6239b(new C14179());
    }

    public static void update(GoogleApiClient googleApiClient, int stateKey, byte[] data) {
        googleApiClient.m6239b(new C14073(stateKey, data));
    }

    public static PendingResult updateImmediate(GoogleApiClient googleApiClient, int stateKey, byte[] data) {
        return googleApiClient.m6239b(new C14084(stateKey, data));
    }
}
