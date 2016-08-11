package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.api.C1461a.C1401d;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.InitiateMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LeaveMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchesResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult;
import java.util.List;

public final class TurnBasedMultiplayerImpl implements TurnBasedMultiplayer {

    private static abstract class LoadMatchImpl extends BaseGamesApiMethodImpl {

        /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.LoadMatchImpl.1 */
        class C17161 implements LoadMatchResult {
            final /* synthetic */ LoadMatchImpl Lm;
            final /* synthetic */ Status wz;

            C17161(LoadMatchImpl loadMatchImpl, Status status) {
                this.Lm = loadMatchImpl;
                this.wz = status;
            }

            public TurnBasedMatch getMatch() {
                return null;
            }

            public Status getStatus() {
                return this.wz;
            }
        }

        private LoadMatchImpl() {
        }

        public LoadMatchResult m7662U(Status status) {
            return new C17161(this, status);
        }

        public /* synthetic */ Result m7663d(Status status) {
            return m7662U(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.10 */
    class AnonymousClass10 extends LoadMatchImpl {
        final /* synthetic */ TurnBasedMultiplayerImpl Lc;
        final /* synthetic */ String Ld;

        AnonymousClass10(TurnBasedMultiplayerImpl turnBasedMultiplayerImpl, String str) {
            this.Lc = turnBasedMultiplayerImpl;
            this.Ld = str;
            super();
        }

        protected void m7665a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7085h(this, this.Ld);
        }
    }

    private static abstract class InitiateMatchImpl extends BaseGamesApiMethodImpl {

        /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.InitiateMatchImpl.1 */
        class C17141 implements InitiateMatchResult {
            final /* synthetic */ InitiateMatchImpl Lk;
            final /* synthetic */ Status wz;

            C17141(InitiateMatchImpl initiateMatchImpl, Status status) {
                this.Lk = initiateMatchImpl;
                this.wz = status;
            }

            public TurnBasedMatch getMatch() {
                return null;
            }

            public Status getStatus() {
                return this.wz;
            }
        }

        private InitiateMatchImpl() {
        }

        public InitiateMatchResult m7666S(Status status) {
            return new C17141(this, status);
        }

        public /* synthetic */ Result m7667d(Status status) {
            return m7666S(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.11 */
    class AnonymousClass11 extends InitiateMatchImpl {
        final /* synthetic */ String JT;
        final /* synthetic */ String Ld;

        protected void m7669a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7056b((C1401d) this, this.JT, this.Ld);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.12 */
    class AnonymousClass12 extends InitiateMatchImpl {
        final /* synthetic */ String JT;
        final /* synthetic */ String Ld;

        protected void m7671a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7069c((C1401d) this, this.JT, this.Ld);
        }
    }

    private static abstract class LoadMatchesImpl extends BaseGamesApiMethodImpl {

        /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.LoadMatchesImpl.1 */
        class C17171 implements LoadMatchesResult {
            final /* synthetic */ LoadMatchesImpl Ln;
            final /* synthetic */ Status wz;

            C17171(LoadMatchesImpl loadMatchesImpl, Status status) {
                this.Ln = loadMatchesImpl;
                this.wz = status;
            }

            public LoadMatchesResponse getMatches() {
                return new LoadMatchesResponse(new Bundle());
            }

            public Status getStatus() {
                return this.wz;
            }

            public void release() {
            }
        }

        private LoadMatchesImpl() {
        }

        public LoadMatchesResult m7672V(Status status) {
            return new C17171(this, status);
        }

        public /* synthetic */ Result m7673d(Status status) {
            return m7672V(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.13 */
    class AnonymousClass13 extends LoadMatchesImpl {
        final /* synthetic */ String JT;
        final /* synthetic */ int Le;
        final /* synthetic */ int[] Lf;

        protected void m7675a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7027a((C1401d) this, this.JT, this.Le, this.Lf);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.1 */
    class C17041 extends InitiateMatchImpl {
        final /* synthetic */ TurnBasedMatchConfig Lb;
        final /* synthetic */ TurnBasedMultiplayerImpl Lc;

        C17041(TurnBasedMultiplayerImpl turnBasedMultiplayerImpl, TurnBasedMatchConfig turnBasedMatchConfig) {
            this.Lc = turnBasedMultiplayerImpl;
            this.Lb = turnBasedMatchConfig;
            super();
        }

        protected void m7677a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7020a((C1401d) this, this.Lb);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.2 */
    class C17052 extends InitiateMatchImpl {
        final /* synthetic */ TurnBasedMultiplayerImpl Lc;
        final /* synthetic */ String Ld;

        C17052(TurnBasedMultiplayerImpl turnBasedMultiplayerImpl, String str) {
            this.Lc = turnBasedMultiplayerImpl;
            this.Ld = str;
            super();
        }

        protected void m7679a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7075d((C1401d) this, this.Ld);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.3 */
    class C17063 extends InitiateMatchImpl {
        final /* synthetic */ String Km;
        final /* synthetic */ TurnBasedMultiplayerImpl Lc;

        C17063(TurnBasedMultiplayerImpl turnBasedMultiplayerImpl, String str) {
            this.Lc = turnBasedMultiplayerImpl;
            this.Km = str;
            super();
        }

        protected void m7681a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7079e(this, this.Km);
        }
    }

    private static abstract class UpdateMatchImpl extends BaseGamesApiMethodImpl {

        /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.UpdateMatchImpl.1 */
        class C17181 implements UpdateMatchResult {
            final /* synthetic */ UpdateMatchImpl Lo;
            final /* synthetic */ Status wz;

            C17181(UpdateMatchImpl updateMatchImpl, Status status) {
                this.Lo = updateMatchImpl;
                this.wz = status;
            }

            public TurnBasedMatch getMatch() {
                return null;
            }

            public Status getStatus() {
                return this.wz;
            }
        }

        private UpdateMatchImpl() {
        }

        public UpdateMatchResult m7682W(Status status) {
            return new C17181(this, status);
        }

        public /* synthetic */ Result m7683d(Status status) {
            return m7682W(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.4 */
    class C17074 extends UpdateMatchImpl {
        final /* synthetic */ TurnBasedMultiplayerImpl Lc;
        final /* synthetic */ String Ld;
        final /* synthetic */ byte[] Lg;
        final /* synthetic */ String Lh;
        final /* synthetic */ ParticipantResult[] Li;

        C17074(TurnBasedMultiplayerImpl turnBasedMultiplayerImpl, String str, byte[] bArr, String str2, ParticipantResult[] participantResultArr) {
            this.Lc = turnBasedMultiplayerImpl;
            this.Ld = str;
            this.Lg = bArr;
            this.Lh = str2;
            this.Li = participantResultArr;
            super();
        }

        protected void m7685a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7037a((C1401d) this, this.Ld, this.Lg, this.Lh, this.Li);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.5 */
    class C17085 extends UpdateMatchImpl {
        final /* synthetic */ TurnBasedMultiplayerImpl Lc;
        final /* synthetic */ String Ld;
        final /* synthetic */ byte[] Lg;
        final /* synthetic */ ParticipantResult[] Li;

        C17085(TurnBasedMultiplayerImpl turnBasedMultiplayerImpl, String str, byte[] bArr, ParticipantResult[] participantResultArr) {
            this.Lc = turnBasedMultiplayerImpl;
            this.Ld = str;
            this.Lg = bArr;
            this.Li = participantResultArr;
            super();
        }

        protected void m7687a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7038a((C1401d) this, this.Ld, this.Lg, this.Li);
        }
    }

    private static abstract class LeaveMatchImpl extends BaseGamesApiMethodImpl {

        /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.LeaveMatchImpl.1 */
        class C17151 implements LeaveMatchResult {
            final /* synthetic */ LeaveMatchImpl Ll;
            final /* synthetic */ Status wz;

            C17151(LeaveMatchImpl leaveMatchImpl, Status status) {
                this.Ll = leaveMatchImpl;
                this.wz = status;
            }

            public TurnBasedMatch getMatch() {
                return null;
            }

            public Status getStatus() {
                return this.wz;
            }
        }

        private LeaveMatchImpl() {
        }

        public LeaveMatchResult m7688T(Status status) {
            return new C17151(this, status);
        }

        public /* synthetic */ Result m7689d(Status status) {
            return m7688T(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.6 */
    class C17096 extends LeaveMatchImpl {
        final /* synthetic */ TurnBasedMultiplayerImpl Lc;
        final /* synthetic */ String Ld;

        C17096(TurnBasedMultiplayerImpl turnBasedMultiplayerImpl, String str) {
            this.Lc = turnBasedMultiplayerImpl;
            this.Ld = str;
            super();
        }

        protected void m7691a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7081f(this, this.Ld);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.7 */
    class C17107 extends LeaveMatchImpl {
        final /* synthetic */ TurnBasedMultiplayerImpl Lc;
        final /* synthetic */ String Ld;
        final /* synthetic */ String Lh;

        C17107(TurnBasedMultiplayerImpl turnBasedMultiplayerImpl, String str, String str2) {
            this.Lc = turnBasedMultiplayerImpl;
            this.Ld = str;
            this.Lh = str2;
            super();
        }

        protected void m7693a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7029a((C1401d) this, this.Ld, this.Lh);
        }
    }

    private static abstract class CancelMatchImpl extends BaseGamesApiMethodImpl {
        private final String wp;

        /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.CancelMatchImpl.1 */
        class C17131 implements CancelMatchResult {
            final /* synthetic */ CancelMatchImpl Lj;
            final /* synthetic */ Status wz;

            C17131(CancelMatchImpl cancelMatchImpl, Status status) {
                this.Lj = cancelMatchImpl;
                this.wz = status;
            }

            public String getMatchId() {
                return this.Lj.wp;
            }

            public Status getStatus() {
                return this.wz;
            }
        }

        public CancelMatchImpl(String id) {
            this.wp = id;
        }

        public CancelMatchResult m7695R(Status status) {
            return new C17131(this, status);
        }

        public /* synthetic */ Result m7696d(Status status) {
            return m7695R(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.8 */
    class C17118 extends CancelMatchImpl {
        final /* synthetic */ TurnBasedMultiplayerImpl Lc;
        final /* synthetic */ String Ld;

        C17118(TurnBasedMultiplayerImpl turnBasedMultiplayerImpl, String x0, String str) {
            this.Lc = turnBasedMultiplayerImpl;
            this.Ld = str;
            super(x0);
        }

        protected void m7698a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7083g(this, this.Ld);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.9 */
    class C17129 extends LoadMatchesImpl {
        final /* synthetic */ TurnBasedMultiplayerImpl Lc;
        final /* synthetic */ int Le;
        final /* synthetic */ int[] Lf;

        C17129(TurnBasedMultiplayerImpl turnBasedMultiplayerImpl, int i, int[] iArr) {
            this.Lc = turnBasedMultiplayerImpl;
            this.Le = i;
            this.Lf = iArr;
            super();
        }

        protected void m7700a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7018a((C1401d) this, this.Le, this.Lf);
        }
    }

    public PendingResult acceptInvitation(GoogleApiClient apiClient, String invitationId) {
        return apiClient.m6239b(new C17063(this, invitationId));
    }

    public PendingResult cancelMatch(GoogleApiClient apiClient, String matchId) {
        return apiClient.m6239b(new C17118(this, matchId, matchId));
    }

    public PendingResult createMatch(GoogleApiClient apiClient, TurnBasedMatchConfig config) {
        return apiClient.m6239b(new C17041(this, config));
    }

    public void declineInvitation(GoogleApiClient apiClient, String invitationId) {
        Games.m6753c(apiClient).m7095m(invitationId, 1);
    }

    public void dismissInvitation(GoogleApiClient apiClient, String invitationId) {
        Games.m6753c(apiClient).m7093l(invitationId, 1);
    }

    public void dismissMatch(GoogleApiClient apiClient, String matchId) {
        Games.m6753c(apiClient).aB(matchId);
    }

    public PendingResult finishMatch(GoogleApiClient apiClient, String matchId) {
        return finishMatch(apiClient, matchId, null, (ParticipantResult[]) null);
    }

    public PendingResult finishMatch(GoogleApiClient apiClient, String matchId, byte[] matchData, List results) {
        return finishMatch(apiClient, matchId, matchData, results == null ? null : (ParticipantResult[]) results.toArray(new ParticipantResult[results.size()]));
    }

    public PendingResult finishMatch(GoogleApiClient apiClient, String matchId, byte[] matchData, ParticipantResult... results) {
        return apiClient.m6239b(new C17085(this, matchId, matchData, results));
    }

    public Intent getInboxIntent(GoogleApiClient apiClient) {
        return Games.m6753c(apiClient).gr();
    }

    public int getMaxMatchDataSize(GoogleApiClient apiClient) {
        return Games.m6753c(apiClient).gA();
    }

    public Intent getSelectOpponentsIntent(GoogleApiClient apiClient, int minPlayers, int maxPlayers) {
        return Games.m6753c(apiClient).m7010a(minPlayers, maxPlayers, true);
    }

    public Intent getSelectOpponentsIntent(GoogleApiClient apiClient, int minPlayers, int maxPlayers, boolean allowAutomatch) {
        return Games.m6753c(apiClient).m7010a(minPlayers, maxPlayers, allowAutomatch);
    }

    public PendingResult leaveMatch(GoogleApiClient apiClient, String matchId) {
        return apiClient.m6239b(new C17096(this, matchId));
    }

    public PendingResult leaveMatchDuringTurn(GoogleApiClient apiClient, String matchId, String pendingParticipantId) {
        return apiClient.m6239b(new C17107(this, matchId, pendingParticipantId));
    }

    public PendingResult loadMatch(GoogleApiClient apiClient, String matchId) {
        return apiClient.m6238a(new AnonymousClass10(this, matchId));
    }

    public PendingResult loadMatchesByStatus(GoogleApiClient apiClient, int invitationSortOrder, int[] matchTurnStatuses) {
        return apiClient.m6238a(new C17129(this, invitationSortOrder, matchTurnStatuses));
    }

    public PendingResult loadMatchesByStatus(GoogleApiClient apiClient, int[] matchTurnStatuses) {
        return loadMatchesByStatus(apiClient, 0, matchTurnStatuses);
    }

    public void registerMatchUpdateListener(GoogleApiClient apiClient, OnTurnBasedMatchUpdateReceivedListener listener) {
        Games.m6753c(apiClient).m7046a(listener);
    }

    public PendingResult rematch(GoogleApiClient apiClient, String matchId) {
        return apiClient.m6239b(new C17052(this, matchId));
    }

    public PendingResult takeTurn(GoogleApiClient apiClient, String matchId, byte[] matchData, String pendingParticipantId) {
        return takeTurn(apiClient, matchId, matchData, pendingParticipantId, (ParticipantResult[]) null);
    }

    public PendingResult takeTurn(GoogleApiClient apiClient, String matchId, byte[] matchData, String pendingParticipantId, List results) {
        return takeTurn(apiClient, matchId, matchData, pendingParticipantId, results == null ? null : (ParticipantResult[]) results.toArray(new ParticipantResult[results.size()]));
    }

    public PendingResult takeTurn(GoogleApiClient apiClient, String matchId, byte[] matchData, String pendingParticipantId, ParticipantResult... results) {
        return apiClient.m6239b(new C17074(this, matchId, matchData, pendingParticipantId, results));
    }

    public void unregisterMatchUpdateListener(GoogleApiClient apiClient) {
        Games.m6753c(apiClient).gu();
    }
}
