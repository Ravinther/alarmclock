package com.google.android.gms.internal;

import android.net.Uri;
import com.google.android.gms.common.api.C1461a.C1401d;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.Moments;
import com.google.android.gms.plus.Moments.LoadMomentsResult;
import com.google.android.gms.plus.Plus.C1961a;
import com.google.android.gms.plus.internal.C2232e;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;

public final class ia implements Moments {

    /* renamed from: com.google.android.gms.internal.ia.a */
    private static abstract class C1966a extends C1961a {

        /* renamed from: com.google.android.gms.internal.ia.a.1 */
        class C19731 implements LoadMomentsResult {
            final /* synthetic */ C1966a UC;
            final /* synthetic */ Status wz;

            C19731(C1966a c1966a, Status status) {
                this.UC = c1966a;
                this.wz = status;
            }

            public MomentBuffer getMomentBuffer() {
                return null;
            }

            public String getNextPageToken() {
                return null;
            }

            public Status getStatus() {
                return this.wz;
            }

            public String getUpdated() {
                return null;
            }

            public void release() {
            }
        }

        private C1966a() {
        }

        public LoadMomentsResult aa(Status status) {
            return new C19731(this, status);
        }

        public /* synthetic */ Result m8738d(Status status) {
            return aa(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.ia.1 */
    class C19671 extends C1966a {
        final /* synthetic */ ia Uv;

        C19671(ia iaVar) {
            this.Uv = iaVar;
            super();
        }

        protected void m8740a(C2232e c2232e) {
            c2232e.m9259l(this);
        }
    }

    /* renamed from: com.google.android.gms.internal.ia.2 */
    class C19682 extends C1966a {
        final /* synthetic */ int Ks;
        final /* synthetic */ ia Uv;
        final /* synthetic */ String Uw;
        final /* synthetic */ Uri Ux;
        final /* synthetic */ String Uy;
        final /* synthetic */ String Uz;

        C19682(ia iaVar, int i, String str, Uri uri, String str2, String str3) {
            this.Uv = iaVar;
            this.Ks = i;
            this.Uw = str;
            this.Ux = uri;
            this.Uy = str2;
            this.Uz = str3;
            super();
        }

        protected void m8742a(C2232e c2232e) {
            c2232e.m9254a(this, this.Ks, this.Uw, this.Ux, this.Uy, this.Uz);
        }
    }

    /* renamed from: com.google.android.gms.internal.ia.c */
    private static abstract class C1969c extends C1961a {
        private C1969c() {
        }

        public /* synthetic */ Result m8743d(Status status) {
            return m8744f(status);
        }

        public Status m8744f(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.internal.ia.3 */
    class C19703 extends C1969c {
        final /* synthetic */ Moment UA;
        final /* synthetic */ ia Uv;

        C19703(ia iaVar, Moment moment) {
            this.Uv = iaVar;
            this.UA = moment;
            super();
        }

        protected void m8746a(C2232e c2232e) {
            c2232e.m9255a((C1401d) this, this.UA);
        }
    }

    /* renamed from: com.google.android.gms.internal.ia.b */
    private static abstract class C1971b extends C1961a {
        private C1971b() {
        }

        public /* synthetic */ Result m8747d(Status status) {
            return m8748f(status);
        }

        public Status m8748f(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.internal.ia.4 */
    class C19724 extends C1971b {
        final /* synthetic */ String UB;
        final /* synthetic */ ia Uv;

        C19724(ia iaVar, String str) {
            this.Uv = iaVar;
            this.UB = str;
            super();
        }

        protected void m8750a(C2232e c2232e) {
            c2232e.removeMoment(this.UB);
            m6054a(Status.Bv);
        }
    }

    public PendingResult load(GoogleApiClient googleApiClient) {
        return googleApiClient.m6238a(new C19671(this));
    }

    public PendingResult load(GoogleApiClient googleApiClient, int maxResults, String pageToken, Uri targetUrl, String type, String userId) {
        return googleApiClient.m6238a(new C19682(this, maxResults, pageToken, targetUrl, type, userId));
    }

    public PendingResult remove(GoogleApiClient googleApiClient, String momentId) {
        return googleApiClient.m6239b(new C19724(this, momentId));
    }

    public PendingResult write(GoogleApiClient googleApiClient, Moment moment) {
        return googleApiClient.m6239b(new C19703(this, moment));
    }
}
