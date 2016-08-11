package com.google.android.gms.internal;

import com.google.android.gms.common.api.Api.C1457c;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.Account;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.Plus.C1961a;
import com.google.android.gms.plus.internal.C2232e;

public final class hy implements Account {

    /* renamed from: com.google.android.gms.internal.hy.a */
    private static abstract class C1962a extends C1961a {
        private C1962a() {
        }

        public /* synthetic */ Result m8720d(Status status) {
            return m8721f(status);
        }

        public Status m8721f(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.internal.hy.1 */
    class C19631 extends C1962a {
        final /* synthetic */ hy Uu;

        C19631(hy hyVar) {
            this.Uu = hyVar;
            super();
        }

        protected void m8723a(C2232e c2232e) {
            c2232e.m9261n(this);
        }
    }

    private static C2232e m8724a(GoogleApiClient googleApiClient, C1457c c1457c) {
        boolean z = true;
        fq.m8519b(googleApiClient != null, (Object) "GoogleApiClient parameter is required.");
        fq.m8515a(googleApiClient.isConnected(), "GoogleApiClient must be connected.");
        C2232e c2232e = (C2232e) googleApiClient.m6237a(c1457c);
        if (c2232e == null) {
            z = false;
        }
        fq.m8515a(z, "GoogleApiClient is not configured to use the Plus.API Api. Pass this into GoogleApiClient.Builder#addApi() to use this feature.");
        return c2232e;
    }

    public void clearDefaultAccount(GoogleApiClient googleApiClient) {
        m8724a(googleApiClient, Plus.wx).clearDefaultAccount();
    }

    public String getAccountName(GoogleApiClient googleApiClient) {
        return m8724a(googleApiClient, Plus.wx).getAccountName();
    }

    public PendingResult revokeAccessAndDisconnect(GoogleApiClient googleApiClient) {
        return googleApiClient.m6239b(new C19631(this));
    }
}
