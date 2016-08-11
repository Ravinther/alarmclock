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
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.Players;
import com.google.android.gms.games.Players.LoadExtendedPlayersResult;
import com.google.android.gms.games.Players.LoadOwnerCoverPhotoUrisResult;
import com.google.android.gms.games.Players.LoadPlayersResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class PlayersImpl implements Players {

    private static abstract class LoadPlayersImpl extends BaseGamesApiMethodImpl {

        /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.LoadPlayersImpl.1 */
        class C16911 implements LoadPlayersResult {
            final /* synthetic */ LoadPlayersImpl KN;
            final /* synthetic */ Status wz;

            C16911(LoadPlayersImpl loadPlayersImpl, Status status) {
                this.KN = loadPlayersImpl;
                this.wz = status;
            }

            public PlayerBuffer getPlayers() {
                return new PlayerBuffer(DataHolder.empty(14));
            }

            public Status getStatus() {
                return this.wz;
            }

            public void release() {
            }
        }

        private LoadPlayersImpl() {
        }

        public LoadPlayersResult m7590M(Status status) {
            return new C16911(this, status);
        }

        public /* synthetic */ Result m7591d(Status status) {
            return m7590M(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.10 */
    class AnonymousClass10 extends LoadPlayersImpl {
        final /* synthetic */ boolean JQ;
        final /* synthetic */ int Kb;

        protected void m7593a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7051b((C1401d) this, this.Kb, false, this.JQ);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.11 */
    class AnonymousClass11 extends LoadPlayersImpl {
        final /* synthetic */ int Kb;

        protected void m7595a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7051b((C1401d) this, this.Kb, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.12 */
    class AnonymousClass12 extends LoadPlayersImpl {
        final /* synthetic */ boolean JQ;
        final /* synthetic */ int Kb;

        protected void m7597a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7065c(this, this.Kb, false, this.JQ);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.13 */
    class AnonymousClass13 extends LoadPlayersImpl {
        final /* synthetic */ int Kb;

        protected void m7599a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7065c(this, this.Kb, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.14 */
    class AnonymousClass14 extends LoadPlayersImpl {
        final /* synthetic */ boolean JQ;
        final /* synthetic */ int Kb;

        protected void m7601a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7074d(this, this.Kb, false, this.JQ);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.15 */
    class AnonymousClass15 extends LoadPlayersImpl {
        final /* synthetic */ int Kb;

        protected void m7603a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7074d(this, this.Kb, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.16 */
    class AnonymousClass16 extends LoadPlayersImpl {
        final /* synthetic */ boolean JQ;
        final /* synthetic */ int Kb;
        final /* synthetic */ String Kd;

        protected void m7605a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7077d(this, this.Kd, this.Kb, false, this.JQ);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.17 */
    class AnonymousClass17 extends LoadPlayersImpl {
        final /* synthetic */ int Kb;
        final /* synthetic */ String Kd;

        protected void m7607a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7077d(this, this.Kd, this.Kb, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.18 */
    class AnonymousClass18 extends LoadPlayersImpl {
        final /* synthetic */ boolean JQ;
        final /* synthetic */ String JT;
        final /* synthetic */ int KJ;

        protected void m7609a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7024a((C1401d) this, this.JT, this.KJ, this.JQ);
        }
    }

    private static abstract class LoadExtendedPlayersImpl extends BaseGamesApiMethodImpl {

        /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.LoadExtendedPlayersImpl.1 */
        class C16891 implements LoadExtendedPlayersResult {
            final /* synthetic */ LoadExtendedPlayersImpl KL;
            final /* synthetic */ Status wz;

            C16891(LoadExtendedPlayersImpl loadExtendedPlayersImpl, Status status) {
                this.KL = loadExtendedPlayersImpl;
                this.wz = status;
            }

            public Status getStatus() {
                return this.wz;
            }

            public void release() {
            }
        }

        private LoadExtendedPlayersImpl() {
        }

        public LoadExtendedPlayersResult m7610K(Status status) {
            return new C16891(this, status);
        }

        public /* synthetic */ Result m7611d(Status status) {
            return m7610K(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.19 */
    class AnonymousClass19 extends LoadExtendedPlayersImpl {
        final /* synthetic */ boolean JQ;
        final /* synthetic */ int Kb;

        protected void m7613a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7078e(this, this.Kb, false, this.JQ);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.1 */
    class C16801 extends LoadPlayersImpl {
        final /* synthetic */ String JS;
        final /* synthetic */ PlayersImpl KI;

        C16801(PlayersImpl playersImpl, String str) {
            this.KI = playersImpl;
            this.JS = str;
            super();
        }

        protected void m7615a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7021a((C1401d) this, this.JS);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.20 */
    class AnonymousClass20 extends LoadExtendedPlayersImpl {
        final /* synthetic */ int Kb;

        protected void m7617a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7078e(this, this.Kb, true, false);
        }
    }

    private static abstract class LoadOwnerCoverPhotoUrisImpl extends BaseGamesApiMethodImpl {

        /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.LoadOwnerCoverPhotoUrisImpl.1 */
        class C16901 implements LoadOwnerCoverPhotoUrisResult {
            final /* synthetic */ LoadOwnerCoverPhotoUrisImpl KM;
            final /* synthetic */ Status wz;

            C16901(LoadOwnerCoverPhotoUrisImpl loadOwnerCoverPhotoUrisImpl, Status status) {
                this.KM = loadOwnerCoverPhotoUrisImpl;
                this.wz = status;
            }

            public Status getStatus() {
                return this.wz;
            }
        }

        private LoadOwnerCoverPhotoUrisImpl() {
        }

        public LoadOwnerCoverPhotoUrisResult m7618L(Status status) {
            return new C16901(this, status);
        }

        public /* synthetic */ Result m7619d(Status status) {
            return m7618L(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.21 */
    class AnonymousClass21 extends LoadOwnerCoverPhotoUrisImpl {
        protected void m7621a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7084h(this);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.2 */
    class C16812 extends LoadPlayersImpl {
        final /* synthetic */ String[] KK;

        protected void m7623a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7042a((C1401d) this, this.KK);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.3 */
    class C16823 extends LoadPlayersImpl {
        final /* synthetic */ boolean JQ;
        final /* synthetic */ PlayersImpl KI;
        final /* synthetic */ int Kb;

        C16823(PlayersImpl playersImpl, int i, boolean z) {
            this.KI = playersImpl;
            this.Kb = i;
            this.JQ = z;
            super();
        }

        protected void m7625a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7017a((C1401d) this, this.Kb, false, this.JQ);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.4 */
    class C16834 extends LoadPlayersImpl {
        final /* synthetic */ PlayersImpl KI;
        final /* synthetic */ int Kb;

        C16834(PlayersImpl playersImpl, int i) {
            this.KI = playersImpl;
            this.Kb = i;
            super();
        }

        protected void m7627a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7017a((C1401d) this, this.Kb, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.5 */
    class C16845 extends LoadPlayersImpl {
        final /* synthetic */ boolean JQ;
        final /* synthetic */ PlayersImpl KI;
        final /* synthetic */ int Kb;

        C16845(PlayersImpl playersImpl, int i, boolean z) {
            this.KI = playersImpl;
            this.Kb = i;
            this.JQ = z;
            super();
        }

        protected void m7629a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7025a((C1401d) this, "playedWith", this.Kb, false, this.JQ);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.6 */
    class C16856 extends LoadPlayersImpl {
        final /* synthetic */ PlayersImpl KI;
        final /* synthetic */ int Kb;

        C16856(PlayersImpl playersImpl, int i) {
            this.KI = playersImpl;
            this.Kb = i;
            super();
        }

        protected void m7631a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7025a((C1401d) this, "playedWith", this.Kb, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.7 */
    class C16867 extends LoadPlayersImpl {
        final /* synthetic */ boolean JQ;
        final /* synthetic */ String JT;
        final /* synthetic */ int Kb;

        protected void m7633a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7033a((C1401d) this, "playedWith", this.JT, this.Kb, false, this.JQ);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.8 */
    class C16878 extends LoadPlayersImpl {
        final /* synthetic */ String JT;
        final /* synthetic */ int Kb;

        protected void m7635a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7033a((C1401d) this, "playedWith", this.JT, this.Kb, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.9 */
    class C16889 extends LoadPlayersImpl {
        final /* synthetic */ boolean JQ;
        final /* synthetic */ PlayersImpl KI;

        C16889(PlayersImpl playersImpl, boolean z) {
            this.KI = playersImpl;
            this.JQ = z;
            super();
        }

        protected void m7637a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7040a((C1401d) this, this.JQ);
        }
    }

    public Player getCurrentPlayer(GoogleApiClient apiClient) {
        return Games.m6753c(apiClient).gn();
    }

    public String getCurrentPlayerId(GoogleApiClient apiClient) {
        return Games.m6753c(apiClient).gm();
    }

    public Intent getPlayerSearchIntent(GoogleApiClient apiClient) {
        return Games.m6753c(apiClient).gw();
    }

    public PendingResult loadConnectedPlayers(GoogleApiClient apiClient, boolean forceReload) {
        return apiClient.m6238a(new C16889(this, forceReload));
    }

    public PendingResult loadInvitablePlayers(GoogleApiClient apiClient, int pageSize, boolean forceReload) {
        return apiClient.m6238a(new C16823(this, pageSize, forceReload));
    }

    public PendingResult loadMoreInvitablePlayers(GoogleApiClient apiClient, int pageSize) {
        return apiClient.m6238a(new C16834(this, pageSize));
    }

    public PendingResult loadMoreRecentlyPlayedWithPlayers(GoogleApiClient apiClient, int pageSize) {
        return apiClient.m6238a(new C16856(this, pageSize));
    }

    public PendingResult loadPlayer(GoogleApiClient apiClient, String playerId) {
        return apiClient.m6238a(new C16801(this, playerId));
    }

    public PendingResult loadRecentlyPlayedWithPlayers(GoogleApiClient apiClient, int pageSize, boolean forceReload) {
        return apiClient.m6238a(new C16845(this, pageSize, forceReload));
    }
}
