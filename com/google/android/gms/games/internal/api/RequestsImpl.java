package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.google.android.gms.common.api.C1461a.C1401d;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestBuffer;
import com.google.android.gms.games.request.OnRequestReceivedListener;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.games.request.Requests.LoadRequestSummariesResult;
import com.google.android.gms.games.request.Requests.LoadRequestsResult;
import com.google.android.gms.games.request.Requests.SendRequestResult;
import com.google.android.gms.games.request.Requests.UpdateRequestsResult;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class RequestsImpl implements Requests {

    private static abstract class UpdateRequestsImpl extends BaseGamesApiMethodImpl {

        /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl.UpdateRequestsImpl.1 */
        class C17031 implements UpdateRequestsResult {
            final /* synthetic */ UpdateRequestsImpl La;
            final /* synthetic */ Status wz;

            C17031(UpdateRequestsImpl updateRequestsImpl, Status status) {
                this.La = updateRequestsImpl;
                this.wz = status;
            }

            public Set getRequestIds() {
                return null;
            }

            public int getRequestOutcome(String requestId) {
                throw new IllegalArgumentException("Unknown request ID " + requestId);
            }

            public Status getStatus() {
                return this.wz;
            }

            public void release() {
            }
        }

        private UpdateRequestsImpl() {
        }

        public UpdateRequestsResult m7638Q(Status status) {
            return new C17031(this, status);
        }

        public /* synthetic */ Result m7639d(Status status) {
            return m7638Q(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl.1 */
    class C16921 extends UpdateRequestsImpl {
        final /* synthetic */ String[] KO;
        final /* synthetic */ RequestsImpl KP;

        C16921(RequestsImpl requestsImpl, String[] strArr) {
            this.KP = requestsImpl;
            this.KO = strArr;
            super();
        }

        protected void m7641a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7061b((C1401d) this, this.KO);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl.2 */
    class C16932 extends UpdateRequestsImpl {
        final /* synthetic */ String[] KO;
        final /* synthetic */ RequestsImpl KP;

        C16932(RequestsImpl requestsImpl, String[] strArr) {
            this.KP = requestsImpl;
            this.KO = strArr;
            super();
        }

        protected void m7643a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7072c((C1401d) this, this.KO);
        }
    }

    private static abstract class LoadRequestsImpl extends BaseGamesApiMethodImpl {

        /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl.LoadRequestsImpl.1 */
        class C17011 implements LoadRequestsResult {
            final /* synthetic */ LoadRequestsImpl KY;
            final /* synthetic */ Status wz;

            C17011(LoadRequestsImpl loadRequestsImpl, Status status) {
                this.KY = loadRequestsImpl;
                this.wz = status;
            }

            public GameRequestBuffer getRequests(int type) {
                return null;
            }

            public Status getStatus() {
                return this.wz;
            }

            public void release() {
            }
        }

        private LoadRequestsImpl() {
        }

        public LoadRequestsResult m7644O(Status status) {
            return new C17011(this, status);
        }

        public /* synthetic */ Result m7645d(Status status) {
            return m7644O(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl.3 */
    class C16943 extends LoadRequestsImpl {
        final /* synthetic */ RequestsImpl KP;
        final /* synthetic */ int KQ;
        final /* synthetic */ int KR;
        final /* synthetic */ int Kk;

        C16943(RequestsImpl requestsImpl, int i, int i2, int i3) {
            this.KP = requestsImpl;
            this.KQ = i;
            this.KR = i2;
            this.Kk = i3;
            super();
        }

        protected void m7647a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7015a((C1401d) this, this.KQ, this.KR, this.Kk);
        }
    }

    private static abstract class SendRequestImpl extends BaseGamesApiMethodImpl {

        /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl.SendRequestImpl.1 */
        class C17021 implements SendRequestResult {
            final /* synthetic */ SendRequestImpl KZ;
            final /* synthetic */ Status wz;

            C17021(SendRequestImpl sendRequestImpl, Status status) {
                this.KZ = sendRequestImpl;
                this.wz = status;
            }

            public Status getStatus() {
                return this.wz;
            }
        }

        private SendRequestImpl() {
        }

        public SendRequestResult m7648P(Status status) {
            return new C17021(this, status);
        }

        public /* synthetic */ Result m7649d(Status status) {
            return m7648P(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl.4 */
    class C16954 extends SendRequestImpl {
        final /* synthetic */ String JT;
        final /* synthetic */ String[] KS;
        final /* synthetic */ int KT;
        final /* synthetic */ byte[] KU;
        final /* synthetic */ int KV;

        protected void m7651a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7039a((C1401d) this, this.JT, this.KS, this.KT, this.KU, this.KV);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl.5 */
    class C16965 extends SendRequestImpl {
        final /* synthetic */ String JT;
        final /* synthetic */ String[] KS;
        final /* synthetic */ int KT;
        final /* synthetic */ byte[] KU;
        final /* synthetic */ int KV;

        protected void m7653a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7039a((C1401d) this, this.JT, this.KS, this.KT, this.KU, this.KV);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl.6 */
    class C16976 extends UpdateRequestsImpl {
        final /* synthetic */ String JT;
        final /* synthetic */ String[] KO;
        final /* synthetic */ String KW;

        protected void m7655a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7035a((C1401d) this, this.JT, this.KW, this.KO);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl.7 */
    class C16987 extends LoadRequestsImpl {
        final /* synthetic */ String JT;
        final /* synthetic */ int KQ;
        final /* synthetic */ int KR;
        final /* synthetic */ String KW;
        final /* synthetic */ int Kk;

        protected void m7657a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7031a((C1401d) this, this.JT, this.KW, this.KQ, this.KR, this.Kk);
        }
    }

    private static abstract class LoadRequestSummariesImpl extends BaseGamesApiMethodImpl {

        /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl.LoadRequestSummariesImpl.1 */
        class C17001 implements LoadRequestSummariesResult {
            final /* synthetic */ LoadRequestSummariesImpl KX;
            final /* synthetic */ Status wz;

            C17001(LoadRequestSummariesImpl loadRequestSummariesImpl, Status status) {
                this.KX = loadRequestSummariesImpl;
                this.wz = status;
            }

            public Status getStatus() {
                return this.wz;
            }

            public void release() {
            }
        }

        private LoadRequestSummariesImpl() {
        }

        public LoadRequestSummariesResult m7658N(Status status) {
            return new C17001(this, status);
        }

        public /* synthetic */ Result m7659d(Status status) {
            return m7658N(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl.8 */
    class C16998 extends LoadRequestSummariesImpl {
        final /* synthetic */ int KR;
        final /* synthetic */ String KW;

        protected void m7661a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7076d(this, this.KW, this.KR);
        }
    }

    public PendingResult acceptRequest(GoogleApiClient apiClient, String requestId) {
        List arrayList = new ArrayList();
        arrayList.add(requestId);
        return acceptRequests(apiClient, arrayList);
    }

    public PendingResult acceptRequests(GoogleApiClient apiClient, List requestIds) {
        return apiClient.m6239b(new C16921(this, requestIds == null ? null : (String[]) requestIds.toArray(new String[requestIds.size()])));
    }

    public PendingResult dismissRequest(GoogleApiClient apiClient, String requestId) {
        List arrayList = new ArrayList();
        arrayList.add(requestId);
        return dismissRequests(apiClient, arrayList);
    }

    public PendingResult dismissRequests(GoogleApiClient apiClient, List requestIds) {
        return apiClient.m6239b(new C16932(this, requestIds == null ? null : (String[]) requestIds.toArray(new String[requestIds.size()])));
    }

    public ArrayList getGameRequestsFromBundle(Bundle extras) {
        if (extras == null || !extras.containsKey(Requests.EXTRA_REQUESTS)) {
            return new ArrayList();
        }
        ArrayList arrayList = (ArrayList) extras.get(Requests.EXTRA_REQUESTS);
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList2.add((GameRequest) arrayList.get(i));
        }
        return arrayList2;
    }

    public ArrayList getGameRequestsFromInboxResponse(Intent response) {
        return response == null ? new ArrayList() : getGameRequestsFromBundle(response.getExtras());
    }

    public Intent getInboxIntent(GoogleApiClient apiClient) {
        return Games.m6753c(apiClient).gB();
    }

    public int getMaxLifetimeDays(GoogleApiClient apiClient) {
        return Games.m6753c(apiClient).gD();
    }

    public int getMaxPayloadSize(GoogleApiClient apiClient) {
        return Games.m6753c(apiClient).gC();
    }

    public Intent getSendIntent(GoogleApiClient apiClient, int type, byte[] payload, int requestLifetimeDays, Bitmap icon, String description) {
        return Games.m6753c(apiClient).m7011a(type, payload, requestLifetimeDays, icon, description);
    }

    public PendingResult loadRequests(GoogleApiClient apiClient, int requestDirection, int types, int sortOrder) {
        return apiClient.m6238a(new C16943(this, requestDirection, types, sortOrder));
    }

    public void registerRequestListener(GoogleApiClient apiClient, OnRequestReceivedListener listener) {
        Games.m6753c(apiClient).m7047a(listener);
    }

    public void unregisterRequestListener(GoogleApiClient apiClient) {
        Games.m6753c(apiClient).gv();
    }
}
