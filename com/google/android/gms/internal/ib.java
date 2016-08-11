package com.google.android.gms.internal;

import com.google.android.gms.common.api.C1461a.C1401d;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.People;
import com.google.android.gms.plus.People.LoadPeopleResult;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.Plus.C1961a;
import com.google.android.gms.plus.internal.C2232e;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.Collection;

public final class ib implements People {

    /* renamed from: com.google.android.gms.internal.ib.a */
    private static abstract class C1974a extends C1961a {

        /* renamed from: com.google.android.gms.internal.ib.a.1 */
        class C19801 implements LoadPeopleResult {
            final /* synthetic */ C1974a UH;
            final /* synthetic */ Status wz;

            C19801(C1974a c1974a, Status status) {
                this.UH = c1974a;
                this.wz = status;
            }

            public String getNextPageToken() {
                return null;
            }

            public PersonBuffer getPersonBuffer() {
                return null;
            }

            public Status getStatus() {
                return this.wz;
            }

            public void release() {
            }
        }

        private C1974a() {
        }

        public LoadPeopleResult ab(Status status) {
            return new C19801(this, status);
        }

        public /* synthetic */ Result m8751d(Status status) {
            return ab(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.ib.1 */
    class C19751 extends C1974a {
        final /* synthetic */ int UD;
        final /* synthetic */ ib UE;
        final /* synthetic */ String Uw;

        C19751(ib ibVar, int i, String str) {
            this.UE = ibVar;
            this.UD = i;
            this.Uw = str;
            super();
        }

        protected void m8753a(C2232e c2232e) {
            m6056a(c2232e.m9252a((C1401d) this, this.UD, this.Uw));
        }
    }

    /* renamed from: com.google.android.gms.internal.ib.2 */
    class C19762 extends C1974a {
        final /* synthetic */ ib UE;
        final /* synthetic */ String Uw;

        C19762(ib ibVar, String str) {
            this.UE = ibVar;
            this.Uw = str;
            super();
        }

        protected void m8755a(C2232e c2232e) {
            m6056a(c2232e.m9262o(this, this.Uw));
        }
    }

    /* renamed from: com.google.android.gms.internal.ib.3 */
    class C19773 extends C1974a {
        final /* synthetic */ ib UE;

        C19773(ib ibVar) {
            this.UE = ibVar;
            super();
        }

        protected void m8757a(C2232e c2232e) {
            c2232e.m9260m(this);
        }
    }

    /* renamed from: com.google.android.gms.internal.ib.4 */
    class C19784 extends C1974a {
        final /* synthetic */ ib UE;
        final /* synthetic */ Collection UF;

        C19784(ib ibVar, Collection collection) {
            this.UE = ibVar;
            this.UF = collection;
            super();
        }

        protected void m8759a(C2232e c2232e) {
            c2232e.m9256a((C1401d) this, this.UF);
        }
    }

    /* renamed from: com.google.android.gms.internal.ib.5 */
    class C19795 extends C1974a {
        final /* synthetic */ ib UE;
        final /* synthetic */ String[] UG;

        C19795(ib ibVar, String[] strArr) {
            this.UE = ibVar;
            this.UG = strArr;
            super();
        }

        protected void m8761a(C2232e c2232e) {
            c2232e.m9258d(this, this.UG);
        }
    }

    public Person getCurrentPerson(GoogleApiClient googleApiClient) {
        return Plus.m9164a(googleApiClient, Plus.wx).getCurrentPerson();
    }

    public PendingResult load(GoogleApiClient googleApiClient, Collection personIds) {
        return googleApiClient.m6238a(new C19784(this, personIds));
    }

    public PendingResult load(GoogleApiClient googleApiClient, String... personIds) {
        return googleApiClient.m6238a(new C19795(this, personIds));
    }

    public PendingResult loadConnected(GoogleApiClient googleApiClient) {
        return googleApiClient.m6238a(new C19773(this));
    }

    public PendingResult loadVisible(GoogleApiClient googleApiClient, int orderBy, String pageToken) {
        return googleApiClient.m6238a(new C19751(this, orderBy, pageToken));
    }

    public PendingResult loadVisible(GoogleApiClient googleApiClient, String pageToken) {
        return googleApiClient.m6238a(new C19762(this, pageToken));
    }
}
