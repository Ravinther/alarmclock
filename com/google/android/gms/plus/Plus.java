package com.google.android.gms.plus;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.C1398b;
import com.google.android.gms.common.api.Api.C1457c;
import com.google.android.gms.common.api.C1461a.C1404b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.fc;
import com.google.android.gms.internal.fq;
import com.google.android.gms.internal.hy;
import com.google.android.gms.internal.hz;
import com.google.android.gms.internal.ia;
import com.google.android.gms.internal.ib;
import com.google.android.gms.plus.internal.C2232e;
import com.google.android.gms.plus.internal.C2236h;
import com.google.android.gms.plus.internal.PlusCommonExtras;
import java.util.HashSet;
import java.util.Set;

public final class Plus {
    public static final Api API;
    public static final Account AccountApi;
    public static final Moments MomentsApi;
    public static final People PeopleApi;
    public static final Scope SCOPE_PLUS_LOGIN;
    public static final Scope SCOPE_PLUS_PROFILE;
    public static final C1964a TI;
    public static final C1457c wx;
    static final C1398b wy;

    /* renamed from: com.google.android.gms.plus.Plus.a */
    public static abstract class C1961a extends C1404b {
        public C1961a() {
            super(Plus.wx);
        }
    }

    /* renamed from: com.google.android.gms.plus.Plus.1 */
    static class C22011 implements C1398b {
        C22011() {
        }

        public C2232e m9163a(Context context, Looper looper, fc fcVar, PlusOptions plusOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            if (plusOptions == null) {
                plusOptions = new PlusOptions();
            }
            return new C2232e(context, looper, connectionCallbacks, onConnectionFailedListener, new C2236h(fcVar.eC(), fcVar.eF(), (String[]) plusOptions.TK.toArray(new String[0]), new String[0], context.getPackageName(), context.getPackageName(), null, new PlusCommonExtras()));
        }

        public int getPriority() {
            return 2;
        }
    }

    public static final class PlusOptions implements Optional {
        final String TJ;
        final Set TK;

        public static final class Builder {
            String TJ;
            final Set TK;

            public Builder() {
                this.TK = new HashSet();
            }

            public Builder addActivityTypes(String... activityTypes) {
                fq.m8517b((Object) activityTypes, (Object) "activityTypes may not be null.");
                for (Object add : activityTypes) {
                    this.TK.add(add);
                }
                return this;
            }

            public PlusOptions build() {
                return new PlusOptions();
            }

            public Builder setServerClientId(String clientId) {
                this.TJ = clientId;
                return this;
            }
        }

        private PlusOptions() {
            this.TJ = null;
            this.TK = new HashSet();
        }

        private PlusOptions(Builder builder) {
            this.TJ = builder.TJ;
            this.TK = builder.TK;
        }

        public static Builder builder() {
            return new Builder();
        }
    }

    static {
        wx = new C1457c();
        wy = new C22011();
        API = new Api(wy, wx, new Scope[0]);
        SCOPE_PLUS_LOGIN = new Scope(Scopes.PLUS_LOGIN);
        SCOPE_PLUS_PROFILE = new Scope(Scopes.PLUS_ME);
        MomentsApi = new ia();
        PeopleApi = new ib();
        AccountApi = new hy();
        TI = new hz();
    }

    private Plus() {
    }

    public static C2232e m9164a(GoogleApiClient googleApiClient, C1457c c1457c) {
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
}
