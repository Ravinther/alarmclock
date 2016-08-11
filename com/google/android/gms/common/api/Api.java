package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.fc;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Api {
    private final ArrayList AA;
    private final C1398b Ay;
    private final C1457c Az;

    /* renamed from: com.google.android.gms.common.api.Api.b */
    public interface C1398b {
        C1456a m6045a(Context context, Looper looper, fc fcVar, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener);

        int getPriority();
    }

    public interface ApiOptions {

        public interface HasOptions extends ApiOptions {
        }

        public interface NotRequiredOptions extends ApiOptions {
        }

        public static final class NoOptions implements NotRequiredOptions {
            private NoOptions() {
            }
        }

        public interface Optional extends HasOptions, NotRequiredOptions {
        }
    }

    /* renamed from: com.google.android.gms.common.api.Api.a */
    public interface C1456a {
        void connect();

        void disconnect();

        Looper getLooper();

        boolean isConnected();
    }

    /* renamed from: com.google.android.gms.common.api.Api.c */
    public static final class C1457c {
    }

    public Api(C1398b clientBuilder, C1457c clientKey, Scope... impliedScopes) {
        this.Ay = clientBuilder;
        this.Az = clientKey;
        this.AA = new ArrayList(Arrays.asList(impliedScopes));
    }

    public C1398b dY() {
        return this.Ay;
    }

    public List dZ() {
        return this.AA;
    }

    public C1457c ea() {
        return this.Az;
    }
}
