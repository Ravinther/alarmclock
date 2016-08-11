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
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.games.leaderboard.Leaderboards.LeaderboardMetadataResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadPlayerScoreResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult;
import com.google.android.gms.games.leaderboard.Leaderboards.SubmitScoreResult;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;

public final class LeaderboardsImpl implements Leaderboards {

    private static abstract class LoadScoresImpl extends BaseGamesApiMethodImpl {

        /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl.LoadScoresImpl.1 */
        class C16691 implements LoadScoresResult {
            final /* synthetic */ LoadScoresImpl Kz;
            final /* synthetic */ Status wz;

            C16691(LoadScoresImpl loadScoresImpl, Status status) {
                this.Kz = loadScoresImpl;
                this.wz = status;
            }

            public Leaderboard getLeaderboard() {
                return null;
            }

            public LeaderboardScoreBuffer getScores() {
                return new LeaderboardScoreBuffer(DataHolder.empty(14));
            }

            public Status getStatus() {
                return this.wz;
            }

            public void release() {
            }
        }

        private LoadScoresImpl() {
        }

        public LoadScoresResult m7540F(Status status) {
            return new C16691(this, status);
        }

        public /* synthetic */ Result m7541d(Status status) {
            return m7540F(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl.10 */
    class AnonymousClass10 extends LoadScoresImpl {
        final /* synthetic */ boolean JQ;
        final /* synthetic */ String JT;
        final /* synthetic */ String Kp;
        final /* synthetic */ int Kq;
        final /* synthetic */ int Kr;
        final /* synthetic */ int Ks;

        protected void m7543a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7032a((C1401d) this, this.JT, this.Kp, this.Kq, this.Kr, this.Ks, this.JQ);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl.11 */
    class AnonymousClass11 extends LoadScoresImpl {
        final /* synthetic */ boolean JQ;
        final /* synthetic */ String JT;
        final /* synthetic */ String Kp;
        final /* synthetic */ int Kq;
        final /* synthetic */ int Kr;
        final /* synthetic */ int Ks;

        protected void m7545a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7057b(this, this.JT, this.Kp, this.Kq, this.Kr, this.Ks, this.JQ);
        }
    }

    private static abstract class LoadMetadataImpl extends BaseGamesApiMethodImpl {

        /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl.LoadMetadataImpl.1 */
        class C16671 implements LeaderboardMetadataResult {
            final /* synthetic */ LoadMetadataImpl Kx;
            final /* synthetic */ Status wz;

            C16671(LoadMetadataImpl loadMetadataImpl, Status status) {
                this.Kx = loadMetadataImpl;
                this.wz = status;
            }

            public LeaderboardBuffer getLeaderboards() {
                return new LeaderboardBuffer(DataHolder.empty(14));
            }

            public Status getStatus() {
                return this.wz;
            }

            public void release() {
            }
        }

        private LoadMetadataImpl() {
        }

        public LeaderboardMetadataResult m7546D(Status status) {
            return new C16671(this, status);
        }

        public /* synthetic */ Result m7547d(Status status) {
            return m7546D(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl.1 */
    class C16581 extends LoadMetadataImpl {
        final /* synthetic */ boolean JQ;
        final /* synthetic */ LeaderboardsImpl Ko;

        C16581(LeaderboardsImpl leaderboardsImpl, boolean z) {
            this.Ko = leaderboardsImpl;
            this.JQ = z;
            super();
        }

        protected void m7549a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7060b((C1401d) this, this.JQ);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl.2 */
    class C16592 extends LoadMetadataImpl {
        final /* synthetic */ boolean JQ;
        final /* synthetic */ LeaderboardsImpl Ko;
        final /* synthetic */ String Kp;

        C16592(LeaderboardsImpl leaderboardsImpl, String str, boolean z) {
            this.Ko = leaderboardsImpl;
            this.Kp = str;
            this.JQ = z;
            super();
        }

        protected void m7551a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7036a((C1401d) this, this.Kp, this.JQ);
        }
    }

    private static abstract class LoadPlayerScoreImpl extends BaseGamesApiMethodImpl {

        /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl.LoadPlayerScoreImpl.1 */
        class C16681 implements LoadPlayerScoreResult {
            final /* synthetic */ LoadPlayerScoreImpl Ky;
            final /* synthetic */ Status wz;

            C16681(LoadPlayerScoreImpl loadPlayerScoreImpl, Status status) {
                this.Ky = loadPlayerScoreImpl;
                this.wz = status;
            }

            public LeaderboardScore getScore() {
                return null;
            }

            public Status getStatus() {
                return this.wz;
            }
        }

        private LoadPlayerScoreImpl() {
        }

        public LoadPlayerScoreResult m7552E(Status status) {
            return new C16681(this, status);
        }

        public /* synthetic */ Result m7553d(Status status) {
            return m7552E(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl.3 */
    class C16603 extends LoadPlayerScoreImpl {
        final /* synthetic */ LeaderboardsImpl Ko;
        final /* synthetic */ String Kp;
        final /* synthetic */ int Kq;
        final /* synthetic */ int Kr;

        C16603(LeaderboardsImpl leaderboardsImpl, String str, int i, int i2) {
            this.Ko = leaderboardsImpl;
            this.Kp = str;
            this.Kq = i;
            this.Kr = i2;
            super();
        }

        protected void m7555a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7030a((C1401d) this, null, this.Kp, this.Kq, this.Kr);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl.4 */
    class C16614 extends LoadScoresImpl {
        final /* synthetic */ boolean JQ;
        final /* synthetic */ LeaderboardsImpl Ko;
        final /* synthetic */ String Kp;
        final /* synthetic */ int Kq;
        final /* synthetic */ int Kr;
        final /* synthetic */ int Ks;

        C16614(LeaderboardsImpl leaderboardsImpl, String str, int i, int i2, int i3, boolean z) {
            this.Ko = leaderboardsImpl;
            this.Kp = str;
            this.Kq = i;
            this.Kr = i2;
            this.Ks = i3;
            this.JQ = z;
            super();
        }

        protected void m7557a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7023a((C1401d) this, this.Kp, this.Kq, this.Kr, this.Ks, this.JQ);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl.5 */
    class C16625 extends LoadScoresImpl {
        final /* synthetic */ boolean JQ;
        final /* synthetic */ LeaderboardsImpl Ko;
        final /* synthetic */ String Kp;
        final /* synthetic */ int Kq;
        final /* synthetic */ int Kr;
        final /* synthetic */ int Ks;

        C16625(LeaderboardsImpl leaderboardsImpl, String str, int i, int i2, int i3, boolean z) {
            this.Ko = leaderboardsImpl;
            this.Kp = str;
            this.Kq = i;
            this.Kr = i2;
            this.Ks = i3;
            this.JQ = z;
            super();
        }

        protected void m7559a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7054b(this, this.Kp, this.Kq, this.Kr, this.Ks, this.JQ);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl.6 */
    class C16636 extends LoadScoresImpl {
        final /* synthetic */ LeaderboardsImpl Ko;
        final /* synthetic */ int Ks;
        final /* synthetic */ LeaderboardScoreBuffer Kt;
        final /* synthetic */ int Ku;

        C16636(LeaderboardsImpl leaderboardsImpl, LeaderboardScoreBuffer leaderboardScoreBuffer, int i, int i2) {
            this.Ko = leaderboardsImpl;
            this.Kt = leaderboardScoreBuffer;
            this.Ks = i;
            this.Ku = i2;
            super();
        }

        protected void m7561a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7019a((C1401d) this, this.Kt, this.Ks, this.Ku);
        }
    }

    protected static abstract class SubmitScoreImpl extends BaseGamesApiMethodImpl {

        /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl.SubmitScoreImpl.1 */
        class C16701 implements SubmitScoreResult {
            final /* synthetic */ SubmitScoreImpl KA;
            final /* synthetic */ Status wz;

            C16701(SubmitScoreImpl submitScoreImpl, Status status) {
                this.KA = submitScoreImpl;
                this.wz = status;
            }

            public ScoreSubmissionData getScoreData() {
                return new ScoreSubmissionData(DataHolder.empty(14));
            }

            public Status getStatus() {
                return this.wz;
            }

            public void release() {
            }
        }

        protected SubmitScoreImpl() {
        }

        public SubmitScoreResult m7562G(Status status) {
            return new C16701(this, status);
        }

        public /* synthetic */ Result m7563d(Status status) {
            return m7562G(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl.7 */
    class C16647 extends SubmitScoreImpl {
        final /* synthetic */ LeaderboardsImpl Ko;
        final /* synthetic */ String Kp;
        final /* synthetic */ long Kv;
        final /* synthetic */ String Kw;

        C16647(LeaderboardsImpl leaderboardsImpl, String str, long j, String str2) {
            this.Ko = leaderboardsImpl;
            this.Kp = str;
            this.Kv = j;
            this.Kw = str2;
        }

        protected void m7565a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7028a((C1401d) this, this.Kp, this.Kv, this.Kw);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl.8 */
    class C16658 extends LoadMetadataImpl {
        final /* synthetic */ boolean JQ;
        final /* synthetic */ String JT;

        protected void m7567a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7059b((C1401d) this, this.JT, this.JQ);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl.9 */
    class C16669 extends LoadMetadataImpl {
        final /* synthetic */ boolean JQ;
        final /* synthetic */ String JT;
        final /* synthetic */ String Kp;

        protected void m7569a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7034a((C1401d) this, this.JT, this.Kp, this.JQ);
        }
    }

    public Intent getAllLeaderboardsIntent(GoogleApiClient apiClient) {
        return Games.m6753c(apiClient).gp();
    }

    public Intent getLeaderboardIntent(GoogleApiClient apiClient, String leaderboardId) {
        return Games.m6753c(apiClient).aA(leaderboardId);
    }

    public PendingResult loadCurrentPlayerLeaderboardScore(GoogleApiClient apiClient, String leaderboardId, int span, int leaderboardCollection) {
        return apiClient.m6238a(new C16603(this, leaderboardId, span, leaderboardCollection));
    }

    public PendingResult loadLeaderboardMetadata(GoogleApiClient apiClient, String leaderboardId, boolean forceReload) {
        return apiClient.m6238a(new C16592(this, leaderboardId, forceReload));
    }

    public PendingResult loadLeaderboardMetadata(GoogleApiClient apiClient, boolean forceReload) {
        return apiClient.m6238a(new C16581(this, forceReload));
    }

    public PendingResult loadMoreScores(GoogleApiClient apiClient, LeaderboardScoreBuffer buffer, int maxResults, int pageDirection) {
        return apiClient.m6238a(new C16636(this, buffer, maxResults, pageDirection));
    }

    public PendingResult loadPlayerCenteredScores(GoogleApiClient apiClient, String leaderboardId, int span, int leaderboardCollection, int maxResults) {
        return loadPlayerCenteredScores(apiClient, leaderboardId, span, leaderboardCollection, maxResults, false);
    }

    public PendingResult loadPlayerCenteredScores(GoogleApiClient apiClient, String leaderboardId, int span, int leaderboardCollection, int maxResults, boolean forceReload) {
        return apiClient.m6238a(new C16625(this, leaderboardId, span, leaderboardCollection, maxResults, forceReload));
    }

    public PendingResult loadTopScores(GoogleApiClient apiClient, String leaderboardId, int span, int leaderboardCollection, int maxResults) {
        return loadTopScores(apiClient, leaderboardId, span, leaderboardCollection, maxResults, false);
    }

    public PendingResult loadTopScores(GoogleApiClient apiClient, String leaderboardId, int span, int leaderboardCollection, int maxResults, boolean forceReload) {
        return apiClient.m6238a(new C16614(this, leaderboardId, span, leaderboardCollection, maxResults, forceReload));
    }

    public void submitScore(GoogleApiClient apiClient, String leaderboardId, long score) {
        submitScore(apiClient, leaderboardId, score, null);
    }

    public void submitScore(GoogleApiClient apiClient, String leaderboardId, long score, String scoreTag) {
        Games.m6753c(apiClient).m7028a(null, leaderboardId, score, scoreTag);
    }

    public PendingResult submitScoreImmediate(GoogleApiClient apiClient, String leaderboardId, long score) {
        return submitScoreImmediate(apiClient, leaderboardId, score, null);
    }

    public PendingResult submitScoreImmediate(GoogleApiClient apiClient, String leaderboardId, long score, String scoreTag) {
        return apiClient.m6239b(new C16647(this, leaderboardId, score, scoreTag));
    }
}
