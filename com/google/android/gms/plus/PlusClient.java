package com.google.android.gms.plus;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.C1461a.C1401d;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.Moments.LoadMomentsResult;
import com.google.android.gms.plus.People.LoadPeopleResult;
import com.google.android.gms.plus.internal.C2232e;
import com.google.android.gms.plus.internal.C2237i;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.Collection;

@Deprecated
public class PlusClient implements GooglePlayServicesClient {
    final C2232e TL;

    /* renamed from: com.google.android.gms.plus.PlusClient.1 */
    class C22021 implements C1401d {
        final /* synthetic */ OnMomentsLoadedListener TM;
        final /* synthetic */ PlusClient TN;

        C22021(PlusClient plusClient, OnMomentsLoadedListener onMomentsLoadedListener) {
            this.TN = plusClient;
            this.TM = onMomentsLoadedListener;
        }

        public void m9165a(LoadMomentsResult loadMomentsResult) {
            this.TM.onMomentsLoaded(loadMomentsResult.getStatus().eq(), loadMomentsResult.getMomentBuffer(), loadMomentsResult.getNextPageToken(), loadMomentsResult.getUpdated());
        }

        public /* synthetic */ void m9166b(Object obj) {
            m9165a((LoadMomentsResult) obj);
        }
    }

    /* renamed from: com.google.android.gms.plus.PlusClient.2 */
    class C22032 implements C1401d {
        final /* synthetic */ OnMomentsLoadedListener TM;
        final /* synthetic */ PlusClient TN;

        C22032(PlusClient plusClient, OnMomentsLoadedListener onMomentsLoadedListener) {
            this.TN = plusClient;
            this.TM = onMomentsLoadedListener;
        }

        public void m9167a(LoadMomentsResult loadMomentsResult) {
            this.TM.onMomentsLoaded(loadMomentsResult.getStatus().eq(), loadMomentsResult.getMomentBuffer(), loadMomentsResult.getNextPageToken(), loadMomentsResult.getUpdated());
        }

        public /* synthetic */ void m9168b(Object obj) {
            m9167a((LoadMomentsResult) obj);
        }
    }

    /* renamed from: com.google.android.gms.plus.PlusClient.3 */
    class C22043 implements C1401d {
        final /* synthetic */ PlusClient TN;
        final /* synthetic */ OnPeopleLoadedListener TO;

        C22043(PlusClient plusClient, OnPeopleLoadedListener onPeopleLoadedListener) {
            this.TN = plusClient;
            this.TO = onPeopleLoadedListener;
        }

        public void m9169a(LoadPeopleResult loadPeopleResult) {
            this.TO.onPeopleLoaded(loadPeopleResult.getStatus().eq(), loadPeopleResult.getPersonBuffer(), loadPeopleResult.getNextPageToken());
        }

        public /* synthetic */ void m9170b(Object obj) {
            m9169a((LoadPeopleResult) obj);
        }
    }

    /* renamed from: com.google.android.gms.plus.PlusClient.4 */
    class C22054 implements C1401d {
        final /* synthetic */ PlusClient TN;
        final /* synthetic */ OnPeopleLoadedListener TO;

        C22054(PlusClient plusClient, OnPeopleLoadedListener onPeopleLoadedListener) {
            this.TN = plusClient;
            this.TO = onPeopleLoadedListener;
        }

        public void m9171a(LoadPeopleResult loadPeopleResult) {
            this.TO.onPeopleLoaded(loadPeopleResult.getStatus().eq(), loadPeopleResult.getPersonBuffer(), loadPeopleResult.getNextPageToken());
        }

        public /* synthetic */ void m9172b(Object obj) {
            m9171a((LoadPeopleResult) obj);
        }
    }

    /* renamed from: com.google.android.gms.plus.PlusClient.5 */
    class C22065 implements C1401d {
        final /* synthetic */ PlusClient TN;
        final /* synthetic */ OnPeopleLoadedListener TO;

        C22065(PlusClient plusClient, OnPeopleLoadedListener onPeopleLoadedListener) {
            this.TN = plusClient;
            this.TO = onPeopleLoadedListener;
        }

        public void m9173a(LoadPeopleResult loadPeopleResult) {
            this.TO.onPeopleLoaded(loadPeopleResult.getStatus().eq(), loadPeopleResult.getPersonBuffer(), loadPeopleResult.getNextPageToken());
        }

        public /* synthetic */ void m9174b(Object obj) {
            m9173a((LoadPeopleResult) obj);
        }
    }

    /* renamed from: com.google.android.gms.plus.PlusClient.6 */
    class C22076 implements C1401d {
        final /* synthetic */ PlusClient TN;
        final /* synthetic */ OnPeopleLoadedListener TO;

        C22076(PlusClient plusClient, OnPeopleLoadedListener onPeopleLoadedListener) {
            this.TN = plusClient;
            this.TO = onPeopleLoadedListener;
        }

        public void m9175a(LoadPeopleResult loadPeopleResult) {
            this.TO.onPeopleLoaded(loadPeopleResult.getStatus().eq(), loadPeopleResult.getPersonBuffer(), loadPeopleResult.getNextPageToken());
        }

        public /* synthetic */ void m9176b(Object obj) {
            m9175a((LoadPeopleResult) obj);
        }
    }

    /* renamed from: com.google.android.gms.plus.PlusClient.7 */
    class C22087 implements C1401d {
        final /* synthetic */ PlusClient TN;
        final /* synthetic */ OnAccessRevokedListener TP;

        C22087(PlusClient plusClient, OnAccessRevokedListener onAccessRevokedListener) {
            this.TN = plusClient;
            this.TP = onAccessRevokedListener;
        }

        public void m9177Y(Status status) {
            this.TP.onAccessRevoked(status.getStatus().eq());
        }

        public /* synthetic */ void m9178b(Object obj) {
            m9177Y((Status) obj);
        }
    }

    @Deprecated
    public static class Builder {
        private final ConnectionCallbacks TQ;
        private final OnConnectionFailedListener TR;
        private final C2237i TS;
        private final Context mContext;

        public Builder(Context context, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener connectionFailedListener) {
            this.mContext = context;
            this.TQ = connectionCallbacks;
            this.TR = connectionFailedListener;
            this.TS = new C2237i(this.mContext);
        }

        public PlusClient build() {
            return new PlusClient(new C2232e(this.mContext, this.TQ, this.TR, this.TS.iZ()));
        }

        public Builder clearScopes() {
            this.TS.iY();
            return this;
        }

        public Builder setAccountName(String accountName) {
            this.TS.bh(accountName);
            return this;
        }

        public Builder setActions(String... actions) {
            this.TS.m9268f(actions);
            return this;
        }

        public Builder setScopes(String... scopes) {
            this.TS.m9267e(scopes);
            return this;
        }
    }

    @Deprecated
    public interface OnAccessRevokedListener {
        void onAccessRevoked(ConnectionResult connectionResult);
    }

    @Deprecated
    public interface OnMomentsLoadedListener {
        @Deprecated
        void onMomentsLoaded(ConnectionResult connectionResult, MomentBuffer momentBuffer, String str, String str2);
    }

    @Deprecated
    public interface OnPeopleLoadedListener {
        void onPeopleLoaded(ConnectionResult connectionResult, PersonBuffer personBuffer, String str);
    }

    @Deprecated
    public interface OrderBy {
        @Deprecated
        public static final int ALPHABETICAL = 0;
        @Deprecated
        public static final int BEST = 1;
    }

    PlusClient(C2232e plusClientImpl) {
        this.TL = plusClientImpl;
    }

    @Deprecated
    public void clearDefaultAccount() {
        this.TL.clearDefaultAccount();
    }

    @Deprecated
    public void connect() {
        this.TL.connect();
    }

    @Deprecated
    public void disconnect() {
        this.TL.disconnect();
    }

    @Deprecated
    public String getAccountName() {
        return this.TL.getAccountName();
    }

    @Deprecated
    public Person getCurrentPerson() {
        return this.TL.getCurrentPerson();
    }

    C2232e iI() {
        return this.TL;
    }

    @Deprecated
    public boolean isConnected() {
        return this.TL.isConnected();
    }

    @Deprecated
    public boolean isConnecting() {
        return this.TL.isConnecting();
    }

    @Deprecated
    public boolean isConnectionCallbacksRegistered(ConnectionCallbacks listener) {
        return this.TL.isConnectionCallbacksRegistered(listener);
    }

    @Deprecated
    public boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener listener) {
        return this.TL.isConnectionFailedListenerRegistered(listener);
    }

    @Deprecated
    public void loadMoments(OnMomentsLoadedListener listener) {
        this.TL.m9259l(new C22021(this, listener));
    }

    @Deprecated
    public void loadMoments(OnMomentsLoadedListener listener, int maxResults, String pageToken, Uri targetUrl, String type, String userId) {
        this.TL.m9254a(new C22032(this, listener), maxResults, pageToken, targetUrl, type, userId);
    }

    @Deprecated
    public void loadPeople(OnPeopleLoadedListener listener, Collection personIds) {
        this.TL.m9256a(new C22065(this, listener), personIds);
    }

    @Deprecated
    public void loadPeople(OnPeopleLoadedListener listener, String... personIds) {
        this.TL.m9258d(new C22076(this, listener), personIds);
    }

    @Deprecated
    public void loadVisiblePeople(OnPeopleLoadedListener listener, int orderBy, String pageToken) {
        this.TL.m9252a(new C22043(this, listener), orderBy, pageToken);
    }

    @Deprecated
    public void loadVisiblePeople(OnPeopleLoadedListener listener, String pageToken) {
        this.TL.m9262o(new C22054(this, listener), pageToken);
    }

    @Deprecated
    public void registerConnectionCallbacks(ConnectionCallbacks listener) {
        this.TL.registerConnectionCallbacks(listener);
    }

    @Deprecated
    public void registerConnectionFailedListener(OnConnectionFailedListener listener) {
        this.TL.registerConnectionFailedListener(listener);
    }

    @Deprecated
    public void removeMoment(String momentId) {
        this.TL.removeMoment(momentId);
    }

    @Deprecated
    public void revokeAccessAndDisconnect(OnAccessRevokedListener listener) {
        this.TL.m9261n(new C22087(this, listener));
    }

    @Deprecated
    public void unregisterConnectionCallbacks(ConnectionCallbacks listener) {
        this.TL.unregisterConnectionCallbacks(listener);
    }

    @Deprecated
    public void unregisterConnectionFailedListener(OnConnectionFailedListener listener) {
        this.TL.unregisterConnectionFailedListener(listener);
    }

    @Deprecated
    public void writeMoment(Moment moment) {
        this.TL.m9255a(null, moment);
    }
}
