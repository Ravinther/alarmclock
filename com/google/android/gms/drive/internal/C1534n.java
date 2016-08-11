package com.google.android.gms.drive.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.C1499c;
import com.google.android.gms.drive.events.DriveEvent.Listener;
import com.google.android.gms.drive.internal.C1531l.C1518j;
import com.google.android.gms.drive.internal.C1531l.C1530k;
import com.google.android.gms.drive.internal.C1568u.C1570a;
import com.google.android.gms.internal.fc;
import com.google.android.gms.internal.ff;
import com.google.android.gms.internal.ff.C1893e;
import com.google.android.gms.internal.fm;
import com.google.android.gms.internal.fq;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.drive.internal.n */
public class C1534n extends ff {
    private DriveId Fh;
    private DriveId Fi;
    final ConnectionCallbacks Fj;
    Map Fk;
    private final String wG;

    /* renamed from: com.google.android.gms.drive.internal.n.1 */
    class C15321 extends C1518j {
        final /* synthetic */ DriveId Fl;
        final /* synthetic */ int Fm;
        final /* synthetic */ C1566s Fn;
        final /* synthetic */ C1534n Fo;

        C15321(C1534n c1534n, DriveId driveId, int i, C1566s c1566s) {
            this.Fo = c1534n;
            this.Fl = driveId;
            this.Fm = i;
            this.Fn = c1566s;
        }

        protected void m6490a(C1534n c1534n) {
            c1534n.fE().m6566a(new AddEventListenerRequest(this.Fl, this.Fm, null), this.Fn, null, new al(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.n.2 */
    class C15332 extends C1518j {
        final /* synthetic */ DriveId Fl;
        final /* synthetic */ int Fm;
        final /* synthetic */ C1566s Fn;
        final /* synthetic */ C1534n Fo;

        C15332(C1534n c1534n, DriveId driveId, int i, C1566s c1566s) {
            this.Fo = c1534n;
            this.Fl = driveId;
            this.Fm = i;
            this.Fn = c1566s;
        }

        protected void m6492a(C1534n c1534n) {
            c1534n.fE().m6578a(new RemoveEventListenerRequest(this.Fl, this.Fm), this.Fn, null, new al(this));
        }
    }

    public C1534n(Context context, Looper looper, fc fcVar, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String[] strArr) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, strArr);
        this.Fk = new HashMap();
        this.wG = (String) fq.m8517b(fcVar.eC(), (Object) "Must call Api.ClientBuilder.setAccountName()");
        this.Fj = connectionCallbacks;
    }

    protected C1568u m6509F(IBinder iBinder) {
        return C1570a.m6602G(iBinder);
    }

    PendingResult m6510a(GoogleApiClient googleApiClient, DriveId driveId, int i, Listener listener) {
        PendingResult c1530k;
        fq.m8519b(C1499c.m6398a(i, driveId), (Object) "id");
        fq.m8517b((Object) listener, (Object) "listener");
        fq.m8515a(isConnected(), "Client must be connected");
        synchronized (this.Fk) {
            Map map = (Map) this.Fk.get(driveId);
            if (map == null) {
                map = new HashMap();
                this.Fk.put(driveId, map);
            }
            if (map.containsKey(listener)) {
                c1530k = new C1530k(googleApiClient, Status.Bv);
            } else {
                C1566s c1566s = new C1566s(getLooper(), i, listener);
                map.put(listener, c1566s);
                c1530k = googleApiClient.m6239b(new C15321(this, driveId, i, c1566s));
            }
        }
        return c1530k;
    }

    protected void m6511a(int i, IBinder iBinder, Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.Fh = (DriveId) bundle.getParcelable("com.google.android.gms.drive.root_id");
            this.Fi = (DriveId) bundle.getParcelable("com.google.android.gms.drive.appdata_id");
        }
        super.m6503a(i, iBinder, bundle);
    }

    protected void m6512a(fm fmVar, C1893e c1893e) {
        String packageName = getContext().getPackageName();
        fq.m8520f(c1893e);
        fq.m8520f(packageName);
        fq.m8520f(eL());
        fmVar.m8457a(c1893e, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, packageName, eL(), this.wG, new Bundle());
    }

    PendingResult m6513b(GoogleApiClient googleApiClient, DriveId driveId, int i, Listener listener) {
        PendingResult c1530k;
        fq.m8519b(C1499c.m6398a(i, driveId), (Object) "id");
        fq.m8517b((Object) listener, (Object) "listener");
        fq.m8515a(isConnected(), "Client must be connected");
        synchronized (this.Fk) {
            Map map = (Map) this.Fk.get(driveId);
            if (map == null) {
                c1530k = new C1530k(googleApiClient, Status.Bv);
            } else {
                C1566s c1566s = (C1566s) map.remove(listener);
                if (c1566s == null) {
                    c1530k = new C1530k(googleApiClient, Status.Bv);
                } else {
                    if (map.isEmpty()) {
                        this.Fk.remove(driveId);
                    }
                    c1530k = googleApiClient.m6239b(new C15332(this, driveId, i, c1566s));
                }
            }
        }
        return c1530k;
    }

    protected String bg() {
        return "com.google.android.gms.drive.ApiService.START";
    }

    protected String bh() {
        return "com.google.android.gms.drive.internal.IDriveService";
    }

    public void disconnect() {
        C1568u c1568u = (C1568u) eM();
        if (c1568u != null) {
            try {
                c1568u.m6573a(new DisconnectRequest());
            } catch (RemoteException e) {
            }
        }
        super.disconnect();
        this.Fk.clear();
    }

    public C1568u fE() {
        return (C1568u) eM();
    }

    public DriveId fF() {
        return this.Fh;
    }

    public DriveId fG() {
        return this.Fi;
    }

    protected /* synthetic */ IInterface m6514r(IBinder iBinder) {
        return m6509F(iBinder);
    }
}
