package com.google.android.gms.games.internal.api;

import android.content.Intent;
import com.google.android.gms.common.api.C1461a.C1401d;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.Invitations;
import com.google.android.gms.games.multiplayer.Invitations.LoadInvitationsResult;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;

public final class InvitationsImpl implements Invitations {

    private static abstract class LoadInvitationsImpl extends BaseGamesApiMethodImpl {

        /* renamed from: com.google.android.gms.games.internal.api.InvitationsImpl.LoadInvitationsImpl.1 */
        class C16571 implements LoadInvitationsResult {
            final /* synthetic */ LoadInvitationsImpl Kn;
            final /* synthetic */ Status wz;

            C16571(LoadInvitationsImpl loadInvitationsImpl, Status status) {
                this.Kn = loadInvitationsImpl;
                this.wz = status;
            }

            public InvitationBuffer getInvitations() {
                return new InvitationBuffer(DataHolder.empty(14));
            }

            public Status getStatus() {
                return this.wz;
            }

            public void release() {
            }
        }

        private LoadInvitationsImpl() {
        }

        public LoadInvitationsResult m7532C(Status status) {
            return new C16571(this, status);
        }

        public /* synthetic */ Result m7533d(Status status) {
            return m7532C(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.InvitationsImpl.1 */
    class C16541 extends LoadInvitationsImpl {
        final /* synthetic */ int Kk;
        final /* synthetic */ InvitationsImpl Kl;

        C16541(InvitationsImpl invitationsImpl, int i) {
            this.Kl = invitationsImpl;
            this.Kk = i;
            super();
        }

        protected void m7535a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7064c((C1401d) this, this.Kk);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.InvitationsImpl.2 */
    class C16552 extends LoadInvitationsImpl {
        final /* synthetic */ String JT;
        final /* synthetic */ int Kk;

        protected void m7537a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7067c((C1401d) this, this.JT, this.Kk);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.InvitationsImpl.3 */
    class C16563 extends LoadInvitationsImpl {
        final /* synthetic */ String Km;

        protected void m7539a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7092l((C1401d) this, this.Km);
        }
    }

    public Intent getInvitationInboxIntent(GoogleApiClient apiClient) {
        return Games.m6753c(apiClient).gs();
    }

    public PendingResult loadInvitations(GoogleApiClient apiClient) {
        return loadInvitations(apiClient, 0);
    }

    public PendingResult loadInvitations(GoogleApiClient apiClient, int sortOrder) {
        return apiClient.m6238a(new C16541(this, sortOrder));
    }

    public void registerInvitationListener(GoogleApiClient apiClient, OnInvitationReceivedListener listener) {
        Games.m6753c(apiClient).m7043a(listener);
    }

    public void unregisterInvitationListener(GoogleApiClient apiClient) {
        Games.m6753c(apiClient).gt();
    }
}
