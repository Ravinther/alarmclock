package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.ff.C1624b;
import com.google.android.gms.internal.ff.C1893e;
import com.google.android.gms.internal.gz.C1934a;
import com.google.android.gms.internal.ha.C1937a;
import com.google.android.gms.location.LocationClient.OnAddGeofencesResultListener;
import com.google.android.gms.location.LocationClient.OnRemoveGeofencesResultListener;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationStatusCodes;
import com.mopub.mobileads.util.Base64;
import java.util.List;

public class hc extends ff {
    private final hf Ok;
    private final hb Oq;
    private final hr Or;
    private final String Os;
    private final Context mContext;
    private final String wG;

    /* renamed from: com.google.android.gms.internal.hc.a */
    private final class C1943a extends C1624b {
        private final int Ah;
        private final String[] Ot;
        final /* synthetic */ hc Ou;

        public C1943a(hc hcVar, OnAddGeofencesResultListener onAddGeofencesResultListener, int i, String[] strArr) {
            this.Ou = hcVar;
            super(hcVar, onAddGeofencesResultListener);
            this.Ah = LocationStatusCodes.bz(i);
            this.Ot = strArr;
        }

        protected void m8677a(OnAddGeofencesResultListener onAddGeofencesResultListener) {
            if (onAddGeofencesResultListener != null) {
                onAddGeofencesResultListener.onAddGeofencesResult(this.Ah, this.Ot);
            }
        }

        protected void dx() {
        }
    }

    /* renamed from: com.google.android.gms.internal.hc.b */
    private static final class C1944b extends C1934a {
        private OnAddGeofencesResultListener Ov;
        private OnRemoveGeofencesResultListener Ow;
        private hc Ox;

        public C1944b(OnAddGeofencesResultListener onAddGeofencesResultListener, hc hcVar) {
            this.Ov = onAddGeofencesResultListener;
            this.Ow = null;
            this.Ox = hcVar;
        }

        public C1944b(OnRemoveGeofencesResultListener onRemoveGeofencesResultListener, hc hcVar) {
            this.Ow = onRemoveGeofencesResultListener;
            this.Ov = null;
            this.Ox = hcVar;
        }

        public void onAddGeofencesResult(int statusCode, String[] geofenceRequestIds) {
            if (this.Ox == null) {
                Log.wtf("LocationClientImpl", "onAddGeofenceResult called multiple times");
                return;
            }
            hc hcVar = this.Ox;
            hc hcVar2 = this.Ox;
            hcVar2.getClass();
            hcVar.m6504a(new C1943a(hcVar2, this.Ov, statusCode, geofenceRequestIds));
            this.Ox = null;
            this.Ov = null;
            this.Ow = null;
        }

        public void onRemoveGeofencesByPendingIntentResult(int statusCode, PendingIntent pendingIntent) {
            if (this.Ox == null) {
                Log.wtf("LocationClientImpl", "onRemoveGeofencesByPendingIntentResult called multiple times");
                return;
            }
            hc hcVar = this.Ox;
            hc hcVar2 = this.Ox;
            hcVar2.getClass();
            hcVar.m6504a(new C1946d(hcVar2, 1, this.Ow, statusCode, pendingIntent));
            this.Ox = null;
            this.Ov = null;
            this.Ow = null;
        }

        public void onRemoveGeofencesByRequestIdsResult(int statusCode, String[] geofenceRequestIds) {
            if (this.Ox == null) {
                Log.wtf("LocationClientImpl", "onRemoveGeofencesByRequestIdsResult called multiple times");
                return;
            }
            hc hcVar = this.Ox;
            hc hcVar2 = this.Ox;
            hcVar2.getClass();
            hcVar.m6504a(new C1946d(hcVar2, 2, this.Ow, statusCode, geofenceRequestIds));
            this.Ox = null;
            this.Ov = null;
            this.Ow = null;
        }
    }

    /* renamed from: com.google.android.gms.internal.hc.c */
    private final class C1945c implements hf {
        final /* synthetic */ hc Ou;

        private C1945c(hc hcVar) {
            this.Ou = hcVar;
        }

        public void bT() {
            this.Ou.bT();
        }

        public /* synthetic */ IInterface eM() {
            return hR();
        }

        public ha hR() {
            return (ha) this.Ou.eM();
        }
    }

    /* renamed from: com.google.android.gms.internal.hc.d */
    private final class C1946d extends C1624b {
        private final int Ah;
        private final String[] Ot;
        final /* synthetic */ hc Ou;
        private final int Oy;
        private final PendingIntent mPendingIntent;

        public C1946d(hc hcVar, int i, OnRemoveGeofencesResultListener onRemoveGeofencesResultListener, int i2, PendingIntent pendingIntent) {
            boolean z = true;
            this.Ou = hcVar;
            super(hcVar, onRemoveGeofencesResultListener);
            if (i != 1) {
                z = false;
            }
            fb.m8420x(z);
            this.Oy = i;
            this.Ah = LocationStatusCodes.bz(i2);
            this.mPendingIntent = pendingIntent;
            this.Ot = null;
        }

        public C1946d(hc hcVar, int i, OnRemoveGeofencesResultListener onRemoveGeofencesResultListener, int i2, String[] strArr) {
            this.Ou = hcVar;
            super(hcVar, onRemoveGeofencesResultListener);
            fb.m8420x(i == 2);
            this.Oy = i;
            this.Ah = LocationStatusCodes.bz(i2);
            this.Ot = strArr;
            this.mPendingIntent = null;
        }

        protected void m8679a(OnRemoveGeofencesResultListener onRemoveGeofencesResultListener) {
            if (onRemoveGeofencesResultListener != null) {
                switch (this.Oy) {
                    case Base64.NO_PADDING /*1*/:
                        onRemoveGeofencesResultListener.onRemoveGeofencesByPendingIntentResult(this.Ah, this.mPendingIntent);
                    case Base64.NO_WRAP /*2*/:
                        onRemoveGeofencesResultListener.onRemoveGeofencesByRequestIdsResult(this.Ah, this.Ot);
                    default:
                        Log.wtf("LocationClientImpl", "Unsupported action: " + this.Oy);
                }
            }
        }

        protected void dx() {
        }
    }

    public hc(Context context, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str) {
        super(context, connectionCallbacks, onConnectionFailedListener, new String[0]);
        this.Ok = new C1945c();
        this.mContext = context;
        this.Oq = new hb(context, this.Ok);
        this.Os = str;
        this.wG = null;
        this.Or = new hr(getContext(), context.getPackageName(), this.Ok);
    }

    protected ha m8683X(IBinder iBinder) {
        return C1937a.m8675W(iBinder);
    }

    protected void m8684a(fm fmVar, C1893e c1893e) {
        Bundle bundle = new Bundle();
        bundle.putString("client_name", this.Os);
        fmVar.m8466e(c1893e, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName(), bundle);
    }

    public void addGeofences(List geofences, PendingIntent pendingIntent, OnAddGeofencesResultListener listener) {
        bT();
        boolean z = geofences != null && geofences.size() > 0;
        fq.m8519b(z, (Object) "At least one geofence must be specified.");
        fq.m8517b((Object) pendingIntent, (Object) "PendingIntent must be specified.");
        fq.m8517b((Object) listener, (Object) "OnAddGeofencesResultListener not provided.");
        if (listener == null) {
            gz gzVar = null;
        } else {
            Object c1944b = new C1944b(listener, this);
        }
        try {
            ((ha) eM()).m8650a(geofences, pendingIntent, gzVar, getContext().getPackageName());
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    protected String bg() {
        return "com.google.android.location.internal.GoogleLocationManagerService.START";
    }

    protected String bh() {
        return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
    }

    public void disconnect() {
        synchronized (this.Oq) {
            if (isConnected()) {
                this.Oq.removeAllListeners();
                this.Oq.hQ();
            }
            super.disconnect();
        }
    }

    public Location getLastLocation() {
        return this.Oq.getLastLocation();
    }

    protected /* synthetic */ IInterface m8685r(IBinder iBinder) {
        return m8683X(iBinder);
    }

    public void removeActivityUpdates(PendingIntent callbackIntent) {
        bT();
        fq.m8520f(callbackIntent);
        try {
            ((ha) eM()).removeActivityUpdates(callbackIntent);
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void removeGeofences(PendingIntent pendingIntent, OnRemoveGeofencesResultListener listener) {
        bT();
        fq.m8517b((Object) pendingIntent, (Object) "PendingIntent must be specified.");
        fq.m8517b((Object) listener, (Object) "OnRemoveGeofencesResultListener not provided.");
        if (listener == null) {
            gz gzVar = null;
        } else {
            Object c1944b = new C1944b(listener, this);
        }
        try {
            ((ha) eM()).m8633a(pendingIntent, gzVar, getContext().getPackageName());
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void removeGeofences(List geofenceRequestIds, OnRemoveGeofencesResultListener listener) {
        bT();
        boolean z = geofenceRequestIds != null && geofenceRequestIds.size() > 0;
        fq.m8519b(z, (Object) "geofenceRequestIds can't be null nor empty.");
        fq.m8517b((Object) listener, (Object) "OnRemoveGeofencesResultListener not provided.");
        String[] strArr = (String[]) geofenceRequestIds.toArray(new String[0]);
        if (listener == null) {
            gz gzVar = null;
        } else {
            Object c1944b = new C1944b(listener, this);
        }
        try {
            ((ha) eM()).m8651a(strArr, gzVar, getContext().getPackageName());
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void removeLocationUpdates(PendingIntent callbackIntent) {
        this.Oq.removeLocationUpdates(callbackIntent);
    }

    public void removeLocationUpdates(LocationListener listener) {
        this.Oq.removeLocationUpdates(listener);
    }

    public void requestActivityUpdates(long detectionIntervalMillis, PendingIntent callbackIntent) {
        boolean z = true;
        bT();
        fq.m8520f(callbackIntent);
        if (detectionIntervalMillis < 0) {
            z = false;
        }
        fq.m8519b(z, (Object) "detectionIntervalMillis must be >= 0");
        try {
            ((ha) eM()).m8631a(detectionIntervalMillis, true, callbackIntent);
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void requestLocationUpdates(LocationRequest request, PendingIntent callbackIntent) {
        this.Oq.requestLocationUpdates(request, callbackIntent);
    }

    public void requestLocationUpdates(LocationRequest request, LocationListener listener) {
        requestLocationUpdates(request, listener, null);
    }

    public void requestLocationUpdates(LocationRequest request, LocationListener listener, Looper looper) {
        synchronized (this.Oq) {
            this.Oq.requestLocationUpdates(request, listener, looper);
        }
    }

    public void setMockLocation(Location mockLocation) {
        this.Oq.setMockLocation(mockLocation);
    }

    public void setMockMode(boolean isMockMode) {
        this.Oq.setMockMode(isMockMode);
    }
}
