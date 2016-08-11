package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.C1461a.C1401d;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.GamesMetadata;
import com.google.android.gms.games.GamesMetadata.LoadExtendedGamesResult;
import com.google.android.gms.games.GamesMetadata.LoadGameInstancesResult;
import com.google.android.gms.games.GamesMetadata.LoadGameSearchSuggestionsResult;
import com.google.android.gms.games.GamesMetadata.LoadGamesResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class GamesMetadataImpl implements GamesMetadata {

    private static abstract class LoadExtendedGamesImpl extends BaseGamesApiMethodImpl {

        /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.LoadExtendedGamesImpl.1 */
        class C16501 implements LoadExtendedGamesResult {
            final /* synthetic */ LoadExtendedGamesImpl Kg;
            final /* synthetic */ Status wz;

            C16501(LoadExtendedGamesImpl loadExtendedGamesImpl, Status status) {
                this.Kg = loadExtendedGamesImpl;
                this.wz = status;
            }

            public Status getStatus() {
                return this.wz;
            }

            public void release() {
            }
        }

        private LoadExtendedGamesImpl() {
        }

        public /* synthetic */ Result m7494d(Status status) {
            return m7495y(status);
        }

        public LoadExtendedGamesResult m7495y(Status status) {
            return new C16501(this, status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.10 */
    class AnonymousClass10 extends LoadExtendedGamesImpl {
        final /* synthetic */ String Ka;
        final /* synthetic */ int Kb;
        final /* synthetic */ boolean Kc;

        protected void m7497a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7026a((C1401d) this, this.Ka, this.Kb, false, true, false, this.Kc);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.11 */
    class AnonymousClass11 extends LoadExtendedGamesImpl {
        final /* synthetic */ boolean JQ;
        final /* synthetic */ String Ka;
        final /* synthetic */ int Kb;
        final /* synthetic */ boolean Kc;

        protected void m7499a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7026a((C1401d) this, this.Ka, this.Kb, true, false, this.JQ, this.Kc);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.12 */
    class AnonymousClass12 extends LoadExtendedGamesImpl {
        final /* synthetic */ String Ka;
        final /* synthetic */ int Kb;
        final /* synthetic */ boolean Kc;

        protected void m7501a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7026a((C1401d) this, this.Ka, this.Kb, true, true, false, this.Kc);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.13 */
    class AnonymousClass13 extends LoadExtendedGamesImpl {
        final /* synthetic */ boolean JQ;
        final /* synthetic */ int Kb;
        final /* synthetic */ String Kd;

        protected void m7503a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7068c(this, this.Kd, this.Kb, false, this.JQ);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.14 */
    class AnonymousClass14 extends LoadExtendedGamesImpl {
        final /* synthetic */ int Kb;
        final /* synthetic */ String Kd;

        protected void m7505a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7068c(this, this.Kd, this.Kb, true, false);
        }
    }

    private static abstract class LoadGameSearchSuggestionsImpl extends BaseGamesApiMethodImpl {

        /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.LoadGameSearchSuggestionsImpl.1 */
        class C16521 implements LoadGameSearchSuggestionsResult {
            final /* synthetic */ LoadGameSearchSuggestionsImpl Ki;
            final /* synthetic */ Status wz;

            C16521(LoadGameSearchSuggestionsImpl loadGameSearchSuggestionsImpl, Status status) {
                this.Ki = loadGameSearchSuggestionsImpl;
                this.wz = status;
            }

            public Status getStatus() {
                return this.wz;
            }

            public void release() {
            }
        }

        private LoadGameSearchSuggestionsImpl() {
        }

        public LoadGameSearchSuggestionsResult m7506A(Status status) {
            return new C16521(this, status);
        }

        public /* synthetic */ Result m7507d(Status status) {
            return m7506A(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.15 */
    class AnonymousClass15 extends LoadGameSearchSuggestionsImpl {
        final /* synthetic */ String Kd;

        protected void m7509a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7091k(this, this.Kd);
        }
    }

    private static abstract class LoadGamesImpl extends BaseGamesApiMethodImpl {

        /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.LoadGamesImpl.1 */
        class C16531 implements LoadGamesResult {
            final /* synthetic */ LoadGamesImpl Kj;
            final /* synthetic */ Status wz;

            C16531(LoadGamesImpl loadGamesImpl, Status status) {
                this.Kj = loadGamesImpl;
                this.wz = status;
            }

            public GameBuffer getGames() {
                return new GameBuffer(DataHolder.empty(14));
            }

            public Status getStatus() {
                return this.wz;
            }

            public void release() {
            }
        }

        private LoadGamesImpl() {
        }

        public LoadGamesResult m7510B(Status status) {
            return new C16531(this, status);
        }

        public /* synthetic */ Result m7511d(Status status) {
            return m7510B(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.1 */
    class C16411 extends LoadGamesImpl {
        final /* synthetic */ GamesMetadataImpl JZ;

        C16411(GamesMetadataImpl gamesMetadataImpl) {
            this.JZ = gamesMetadataImpl;
            super();
        }

        protected void m7513a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7082g(this);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.2 */
    class C16422 extends LoadExtendedGamesImpl {
        final /* synthetic */ String JT;

        protected void m7515a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7088i((C1401d) this, this.JT);
        }
    }

    private static abstract class LoadGameInstancesImpl extends BaseGamesApiMethodImpl {

        /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.LoadGameInstancesImpl.1 */
        class C16511 implements LoadGameInstancesResult {
            final /* synthetic */ LoadGameInstancesImpl Kh;
            final /* synthetic */ Status wz;

            C16511(LoadGameInstancesImpl loadGameInstancesImpl, Status status) {
                this.Kh = loadGameInstancesImpl;
                this.wz = status;
            }

            public Status getStatus() {
                return this.wz;
            }

            public void release() {
            }
        }

        private LoadGameInstancesImpl() {
        }

        public /* synthetic */ Result m7516d(Status status) {
            return m7517z(status);
        }

        public LoadGameInstancesResult m7517z(Status status) {
            return new C16511(this, status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.3 */
    class C16433 extends LoadGameInstancesImpl {
        final /* synthetic */ String JT;

        protected void m7519a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7090j(this, this.JT);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.4 */
    class C16444 extends LoadExtendedGamesImpl {
        final /* synthetic */ boolean JQ;
        final /* synthetic */ int Kb;

        protected void m7521a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7055b(this, null, this.Kb, false, this.JQ);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.5 */
    class C16455 extends LoadExtendedGamesImpl {
        final /* synthetic */ int Kb;

        protected void m7523a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7055b(this, null, this.Kb, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.6 */
    class C16466 extends LoadExtendedGamesImpl {
        final /* synthetic */ boolean JQ;
        final /* synthetic */ String JS;
        final /* synthetic */ int Kb;

        protected void m7525a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7055b(this, this.JS, this.Kb, false, this.JQ);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.7 */
    class C16477 extends LoadExtendedGamesImpl {
        final /* synthetic */ String JS;
        final /* synthetic */ int Kb;

        protected void m7527a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7055b(this, this.JS, this.Kb, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.8 */
    class C16488 extends LoadExtendedGamesImpl {
        final /* synthetic */ boolean JQ;
        final /* synthetic */ int Kb;
        final /* synthetic */ int Ke;
        final /* synthetic */ boolean Kf;

        protected void m7529a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7016a((C1401d) this, this.Kb, this.Ke, this.Kf, this.JQ);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.9 */
    class C16499 extends LoadExtendedGamesImpl {
        final /* synthetic */ boolean JQ;
        final /* synthetic */ String Ka;
        final /* synthetic */ int Kb;
        final /* synthetic */ boolean Kc;

        protected void m7531a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7026a((C1401d) this, this.Ka, this.Kb, false, false, this.JQ, this.Kc);
        }
    }

    public Game getCurrentGame(GoogleApiClient apiClient) {
        return Games.m6753c(apiClient).go();
    }

    public PendingResult loadGame(GoogleApiClient apiClient) {
        return apiClient.m6238a(new C16411(this));
    }
}
