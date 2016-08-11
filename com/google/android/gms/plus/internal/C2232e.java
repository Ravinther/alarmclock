package com.google.android.gms.plus.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.C1461a.C1401d;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.ff;
import com.google.android.gms.internal.ff.C1624b;
import com.google.android.gms.internal.ff.C1625d;
import com.google.android.gms.internal.ff.C1891c;
import com.google.android.gms.internal.ff.C1893e;
import com.google.android.gms.internal.ff.C1895g;
import com.google.android.gms.internal.fk;
import com.google.android.gms.internal.fm;
import com.google.android.gms.internal.gg;
import com.google.android.gms.internal.ie;
import com.google.android.gms.internal.ih;
import com.google.android.gms.plus.Moments.LoadMomentsResult;
import com.google.android.gms.plus.People.LoadPeopleResult;
import com.google.android.gms.plus.internal.C2221d.C2223a;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/* renamed from: com.google.android.gms.plus.internal.e */
public class C2232e extends ff implements GooglePlayServicesClient {
    private Person Ub;
    private final C2236h Uc;

    /* renamed from: com.google.android.gms.plus.internal.e.a */
    final class C2224a extends C2216a {
        private final C1401d TG;
        final /* synthetic */ C2232e Ud;

        public C2224a(C2232e c2232e, C1401d c1401d) {
            this.Ud = c2232e;
            this.TG = c1401d;
        }

        public void m9240Z(Status status) {
            this.Ud.m6504a(new C2227d(this.Ud, this.TG, status));
        }
    }

    /* renamed from: com.google.android.gms.plus.internal.e.b */
    final class C2225b extends C2216a {
        private final C1401d TG;
        final /* synthetic */ C2232e Ud;

        public C2225b(C2232e c2232e, C1401d c1401d) {
            this.Ud = c2232e;
            this.TG = c1401d;
        }

        public void m9241a(DataHolder dataHolder, String str, String str2) {
            DataHolder dataHolder2;
            Status status = new Status(dataHolder.getStatusCode(), null, dataHolder.getMetadata() != null ? (PendingIntent) dataHolder.getMetadata().getParcelable("pendingIntent") : null);
            if (status.isSuccess() || dataHolder == null) {
                dataHolder2 = dataHolder;
            } else {
                if (!dataHolder.isClosed()) {
                    dataHolder.close();
                }
                dataHolder2 = null;
            }
            this.Ud.m6504a(new C2226c(this.Ud, this.TG, status, dataHolder2, str, str2));
        }
    }

    /* renamed from: com.google.android.gms.plus.internal.e.c */
    final class C2226c extends C1625d implements LoadMomentsResult {
        private final String EM;
        final /* synthetic */ C2232e Ud;
        private final String Ue;
        private MomentBuffer Uf;
        private final Status wJ;

        public C2226c(C2232e c2232e, C1401d c1401d, Status status, DataHolder dataHolder, String str, String str2) {
            this.Ud = c2232e;
            super(c2232e, c1401d, dataHolder);
            this.wJ = status;
            this.EM = str;
            this.Ue = str2;
        }

        protected void m9242a(C1401d c1401d, DataHolder dataHolder) {
            this.Uf = dataHolder != null ? new MomentBuffer(dataHolder) : null;
            c1401d.m6049b(this);
        }

        public MomentBuffer getMomentBuffer() {
            return this.Uf;
        }

        public String getNextPageToken() {
            return this.EM;
        }

        public Status getStatus() {
            return this.wJ;
        }

        public String getUpdated() {
            return this.Ue;
        }

        public void release() {
            if (this.Uf != null) {
                this.Uf.close();
            }
        }
    }

    /* renamed from: com.google.android.gms.plus.internal.e.d */
    final class C2227d extends C1624b {
        final /* synthetic */ C2232e Ud;
        private final Status wJ;

        public C2227d(C2232e c2232e, C1401d c1401d, Status status) {
            this.Ud = c2232e;
            super(c2232e, c1401d);
            this.wJ = status;
        }

        protected /* synthetic */ void m9244a(Object obj) {
            m9245c((C1401d) obj);
        }

        protected void m9245c(C1401d c1401d) {
            if (c1401d != null) {
                c1401d.m6049b(this.wJ);
            }
        }

        protected void dx() {
        }
    }

    /* renamed from: com.google.android.gms.plus.internal.e.e */
    final class C2228e extends C2216a {
        private final C1401d TG;
        final /* synthetic */ C2232e Ud;

        public C2228e(C2232e c2232e, C1401d c1401d) {
            this.Ud = c2232e;
            this.TG = c1401d;
        }

        public void m9246a(DataHolder dataHolder, String str) {
            DataHolder dataHolder2;
            Status status = new Status(dataHolder.getStatusCode(), null, dataHolder.getMetadata() != null ? (PendingIntent) dataHolder.getMetadata().getParcelable("pendingIntent") : null);
            if (status.isSuccess() || dataHolder == null) {
                dataHolder2 = dataHolder;
            } else {
                if (!dataHolder.isClosed()) {
                    dataHolder.close();
                }
                dataHolder2 = null;
            }
            this.Ud.m6504a(new C2229f(this.Ud, this.TG, status, dataHolder2, str));
        }
    }

    /* renamed from: com.google.android.gms.plus.internal.e.f */
    final class C2229f extends C1625d implements LoadPeopleResult {
        private final String EM;
        final /* synthetic */ C2232e Ud;
        private PersonBuffer Ug;
        private final Status wJ;

        public C2229f(C2232e c2232e, C1401d c1401d, Status status, DataHolder dataHolder, String str) {
            this.Ud = c2232e;
            super(c2232e, c1401d, dataHolder);
            this.wJ = status;
            this.EM = str;
        }

        protected void m9247a(C1401d c1401d, DataHolder dataHolder) {
            this.Ug = dataHolder != null ? new PersonBuffer(dataHolder) : null;
            c1401d.m6049b(this);
        }

        public String getNextPageToken() {
            return this.EM;
        }

        public PersonBuffer getPersonBuffer() {
            return this.Ug;
        }

        public Status getStatus() {
            return this.wJ;
        }

        public void release() {
            if (this.Ug != null) {
                this.Ug.close();
            }
        }
    }

    /* renamed from: com.google.android.gms.plus.internal.e.g */
    final class C2230g extends C2216a {
        private final C1401d TG;
        final /* synthetic */ C2232e Ud;

        public C2230g(C2232e c2232e, C1401d c1401d) {
            this.Ud = c2232e;
            this.TG = c1401d;
        }

        public void m9249e(int i, Bundle bundle) {
            this.Ud.m6504a(new C2231h(this.Ud, this.TG, new Status(i, null, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null)));
        }
    }

    /* renamed from: com.google.android.gms.plus.internal.e.h */
    final class C2231h extends C1624b {
        final /* synthetic */ C2232e Ud;
        private final Status wJ;

        public C2231h(C2232e c2232e, C1401d c1401d, Status status) {
            this.Ud = c2232e;
            super(c2232e, c1401d);
            this.wJ = status;
        }

        protected /* synthetic */ void m9250a(Object obj) {
            m9251c((C1401d) obj);
        }

        protected void m9251c(C1401d c1401d) {
            this.Ud.disconnect();
            if (c1401d != null) {
                c1401d.m6049b(this.wJ);
            }
        }

        protected void dx() {
        }
    }

    public C2232e(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, C2236h c2236h) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, c2236h.iP());
        this.Uc = c2236h;
    }

    @Deprecated
    public C2232e(Context context, GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener, C2236h c2236h) {
        this(context, context.getMainLooper(), new C1891c(connectionCallbacks), new C1895g(onConnectionFailedListener), c2236h);
    }

    public fk m9252a(C1401d c1401d, int i, String str) {
        bT();
        Object c2228e = new C2228e(this, c1401d);
        try {
            return ((C2221d) eM()).m9212a(c2228e, 1, i, -1, str);
        } catch (RemoteException e) {
            c2228e.m9246a(DataHolder.empty(8), null);
            return null;
        }
    }

    protected void m9253a(int i, IBinder iBinder, Bundle bundle) {
        if (i == 0 && bundle != null && bundle.containsKey("loaded_person")) {
            this.Ub = ih.m8786i(bundle.getByteArray("loaded_person"));
        }
        super.m6503a(i, iBinder, bundle);
    }

    public void m9254a(C1401d c1401d, int i, String str, Uri uri, String str2, String str3) {
        bT();
        Object c2225b = c1401d != null ? new C2225b(this, c1401d) : null;
        try {
            ((C2221d) eM()).m9215a(c2225b, i, str, uri, str2, str3);
        } catch (RemoteException e) {
            c2225b.m9241a(DataHolder.empty(8), null, null);
        }
    }

    public void m9255a(C1401d c1401d, Moment moment) {
        bT();
        C2214b c2224a = c1401d != null ? new C2224a(this, c1401d) : null;
        try {
            ((C2221d) eM()).m9217a(c2224a, gg.m8580a((ie) moment));
        } catch (Throwable e) {
            if (c2224a == null) {
                throw new IllegalStateException(e);
            }
            c2224a.m9240Z(new Status(8, null, null));
        }
    }

    public void m9256a(C1401d c1401d, Collection collection) {
        bT();
        C2214b c2228e = new C2228e(this, c1401d);
        try {
            ((C2221d) eM()).m9220a(c2228e, new ArrayList(collection));
        } catch (RemoteException e) {
            c2228e.m9246a(DataHolder.empty(8), null);
        }
    }

    protected void m9257a(fm fmVar, C1893e c1893e) {
        Bundle iX = this.Uc.iX();
        iX.putStringArray(GoogleAuthUtil.KEY_REQUEST_VISIBLE_ACTIVITIES, this.Uc.iQ());
        fmVar.m8455a(c1893e, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, this.Uc.iT(), this.Uc.iS(), eL(), this.Uc.getAccountName(), iX);
    }

    protected C2221d aR(IBinder iBinder) {
        return C2223a.aQ(iBinder);
    }

    protected String bg() {
        return "com.google.android.gms.plus.service.START";
    }

    public boolean bg(String str) {
        return Arrays.asList(eL()).contains(str);
    }

    protected String bh() {
        return "com.google.android.gms.plus.internal.IPlusService";
    }

    public void clearDefaultAccount() {
        bT();
        try {
            this.Ub = null;
            ((C2221d) eM()).clearDefaultAccount();
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void m9258d(C1401d c1401d, String[] strArr) {
        m9256a(c1401d, Arrays.asList(strArr));
    }

    public String getAccountName() {
        bT();
        try {
            return ((C2221d) eM()).getAccountName();
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public Person getCurrentPerson() {
        bT();
        return this.Ub;
    }

    public void m9259l(C1401d c1401d) {
        m9254a(c1401d, 20, null, null, null, "me");
    }

    public void m9260m(C1401d c1401d) {
        bT();
        Object c2228e = new C2228e(this, c1401d);
        try {
            ((C2221d) eM()).m9212a(c2228e, 2, 1, -1, null);
        } catch (RemoteException e) {
            c2228e.m9246a(DataHolder.empty(8), null);
        }
    }

    public void m9261n(C1401d c1401d) {
        bT();
        clearDefaultAccount();
        Object c2230g = new C2230g(this, c1401d);
        try {
            ((C2221d) eM()).m9221b(c2230g);
        } catch (RemoteException e) {
            c2230g.m9249e(8, null);
        }
    }

    public fk m9262o(C1401d c1401d, String str) {
        return m9252a(c1401d, 0, str);
    }

    protected /* synthetic */ IInterface m9263r(IBinder iBinder) {
        return aR(iBinder);
    }

    public void removeMoment(String momentId) {
        bT();
        try {
            ((C2221d) eM()).removeMoment(momentId);
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }
}
