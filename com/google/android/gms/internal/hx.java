package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.C1461a.C1401d;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.ff.C1624b;
import com.google.android.gms.internal.ff.C1893e;
import com.google.android.gms.internal.hu.C1950a;
import com.google.android.gms.internal.hv.C1952a;
import com.google.android.gms.panorama.PanoramaApi.C1957a;
import com.google.android.gms.panorama.PanoramaApi.PanoramaResult;

public class hx extends ff {

    /* renamed from: com.google.android.gms.internal.hx.a */
    final class C1958a extends C1624b implements C1957a {
        public final Status TC;
        public final Intent TD;
        final /* synthetic */ hx TE;
        public final int type;

        public C1958a(hx hxVar, C1401d c1401d, Status status, int i, Intent intent) {
            this.TE = hxVar;
            super(hxVar, c1401d);
            this.TC = status;
            this.type = i;
            this.TD = intent;
        }

        protected /* synthetic */ void m8711a(Object obj) {
            m8712c((C1401d) obj);
        }

        protected void m8712c(C1401d c1401d) {
            c1401d.m6049b(this);
        }

        protected void dx() {
        }

        public Status getStatus() {
            return this.TC;
        }

        public Intent getViewerIntent() {
            return this.TD;
        }
    }

    /* renamed from: com.google.android.gms.internal.hx.b */
    final class C1959b extends C1950a {
        final /* synthetic */ hx TE;
        private final C1401d TF;
        private final C1401d TG;
        private final Uri TH;

        public C1959b(hx hxVar, C1401d c1401d, C1401d c1401d2, Uri uri) {
            this.TE = hxVar;
            this.TF = c1401d;
            this.TG = c1401d2;
            this.TH = uri;
        }

        public void m8713a(int i, Bundle bundle, int i2, Intent intent) {
            if (this.TH != null) {
                this.TE.getContext().revokeUriPermission(this.TH, 1);
            }
            Status status = new Status(i, null, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null);
            if (this.TG != null) {
                this.TE.m6504a(new C1960c(this.TE, this.TG, status, intent));
            } else if (this.TF != null) {
                this.TE.m6504a(new C1958a(this.TE, this.TF, status, i2, intent));
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.hx.c */
    final class C1960c extends C1624b implements PanoramaResult {
        private final Status TC;
        private final Intent TD;
        final /* synthetic */ hx TE;

        public C1960c(hx hxVar, C1401d c1401d, Status status, Intent intent) {
            this.TE = hxVar;
            super(hxVar, c1401d);
            this.TC = status;
            this.TD = intent;
        }

        protected /* synthetic */ void m8714a(Object obj) {
            m8715c((C1401d) obj);
        }

        protected void m8715c(C1401d c1401d) {
            c1401d.m6049b(this);
        }

        protected void dx() {
        }

        public Status getStatus() {
            return this.TC;
        }

        public Intent getViewerIntent() {
            return this.TD;
        }
    }

    public hx(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, (String[]) null);
    }

    public void m8716a(C1401d c1401d, Uri uri, boolean z) {
        m8718a(new C1959b(this, null, c1401d, z ? uri : null), uri, null, z);
    }

    protected void m8717a(fm fmVar, C1893e c1893e) {
        fmVar.m8452a(c1893e, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName(), new Bundle());
    }

    public void m8718a(C1959b c1959b, Uri uri, Bundle bundle, boolean z) {
        bT();
        if (z) {
            getContext().grantUriPermission(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE, uri, 1);
        }
        try {
            ((hv) eM()).m8703a(c1959b, uri, bundle, z);
        } catch (RemoteException e) {
            c1959b.m8713a(8, null, 0, null);
        }
    }

    public hv aN(IBinder iBinder) {
        return C1952a.aM(iBinder);
    }

    protected String bg() {
        return "com.google.android.gms.panorama.service.START";
    }

    protected String bh() {
        return "com.google.android.gms.panorama.internal.IPanoramaService";
    }

    public /* synthetic */ IInterface m8719r(IBinder iBinder) {
        return aN(iBinder);
    }
}
