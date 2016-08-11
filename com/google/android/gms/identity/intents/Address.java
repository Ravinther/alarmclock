package com.google.android.gms.identity.intents;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api.C1398b;
import com.google.android.gms.common.api.Api.C1457c;
import com.google.android.gms.common.api.C1461a.C1404b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.fc;
import com.google.android.gms.internal.fq;
import com.google.android.gms.internal.gw;

public final class Address {
    public static final Api API;
    static final C1457c wx;
    private static final C1398b wy;

    /* renamed from: com.google.android.gms.identity.intents.Address.1 */
    static class C17251 implements C1398b {
        C17251() {
        }

        public gw m7775a(Context context, Looper looper, fc fcVar, AddressOptions addressOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            fq.m8519b(context instanceof Activity, (Object) "An Activity must be used for Address APIs");
            if (addressOptions == null) {
                addressOptions = new AddressOptions();
            }
            return new gw((Activity) context, looper, connectionCallbacks, onConnectionFailedListener, fcVar.getAccountName(), addressOptions.theme);
        }

        public int getPriority() {
            return Integer.MAX_VALUE;
        }
    }

    /* renamed from: com.google.android.gms.identity.intents.Address.a */
    private static abstract class C1726a extends C1404b {
        public C1726a() {
            super(Address.wx);
        }

        public /* synthetic */ Result m7776d(Status status) {
            return m7777f(status);
        }

        public Status m7777f(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.identity.intents.Address.2 */
    static class C17272 extends C1726a {
        final /* synthetic */ UserAddressRequest Nw;
        final /* synthetic */ int Nx;

        C17272(UserAddressRequest userAddressRequest, int i) {
            this.Nw = userAddressRequest;
            this.Nx = i;
        }

        protected void m7779a(gw gwVar) {
            gwVar.m8619a(this.Nw, this.Nx);
            m6054a(Status.Bv);
        }
    }

    public static final class AddressOptions implements HasOptions {
        public final int theme;

        public AddressOptions() {
            this.theme = 0;
        }

        public AddressOptions(int theme) {
            this.theme = theme;
        }
    }

    static {
        wx = new C1457c();
        wy = new C17251();
        API = new Api(wy, wx, new Scope[0]);
    }

    public static void requestUserAddress(GoogleApiClient googleApiClient, UserAddressRequest request, int requestCode) {
        googleApiClient.m6238a(new C17272(request, requestCode));
    }
}
