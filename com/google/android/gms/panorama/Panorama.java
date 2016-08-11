package com.google.android.gms.panorama;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.C1398b;
import com.google.android.gms.common.api.Api.C1456a;
import com.google.android.gms.common.api.Api.C1457c;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.fc;
import com.google.android.gms.internal.hw;
import com.google.android.gms.internal.hx;

public final class Panorama {
    public static final Api API;
    public static final PanoramaApi PanoramaApi;
    public static final C1457c wx;
    static final C1398b wy;

    /* renamed from: com.google.android.gms.panorama.Panorama.1 */
    static class C22001 implements C1398b {
        C22001() {
        }

        public /* synthetic */ C1456a m9160a(Context context, Looper looper, fc fcVar, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return m9161c(context, looper, fcVar, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public hx m9161c(Context context, Looper looper, fc fcVar, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new hx(context, looper, connectionCallbacks, onConnectionFailedListener);
        }

        public int getPriority() {
            return Integer.MAX_VALUE;
        }
    }

    static {
        wx = new C1457c();
        wy = new C22001();
        API = new Api(wy, wx, new Scope[0]);
        PanoramaApi = new hw();
    }

    private Panorama() {
    }
}
