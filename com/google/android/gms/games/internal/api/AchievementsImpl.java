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
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult;
import com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class AchievementsImpl implements Achievements {

    private static abstract class LoadImpl extends BaseGamesApiMethodImpl {

        /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl.LoadImpl.1 */
        class C16361 implements LoadAchievementsResult {
            final /* synthetic */ LoadImpl JW;
            final /* synthetic */ Status wz;

            C16361(LoadImpl loadImpl, Status status) {
                this.JW = loadImpl;
                this.wz = status;
            }

            public AchievementBuffer getAchievements() {
                return new AchievementBuffer(DataHolder.empty(14));
            }

            public Status getStatus() {
                return this.wz;
            }

            public void release() {
            }
        }

        private LoadImpl() {
        }

        public /* synthetic */ Result m7459d(Status status) {
            return m7460t(status);
        }

        public LoadAchievementsResult m7460t(Status status) {
            return new C16361(this, status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl.10 */
    class AnonymousClass10 extends LoadImpl {
        final /* synthetic */ boolean JQ;
        final /* synthetic */ String JS;
        final /* synthetic */ String JT;

        public void m7462a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7058b((C1401d) this, this.JS, this.JT, this.JQ);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl.1 */
    class C16271 extends LoadImpl {
        final /* synthetic */ boolean JQ;
        final /* synthetic */ AchievementsImpl JR;

        C16271(AchievementsImpl achievementsImpl, boolean z) {
            this.JR = achievementsImpl;
            this.JQ = z;
            super();
        }

        public void m7464a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7071c((C1401d) this, this.JQ);
        }
    }

    private static abstract class UpdateImpl extends BaseGamesApiMethodImpl {
        private final String wp;

        /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl.UpdateImpl.1 */
        class C16371 implements UpdateAchievementResult {
            final /* synthetic */ UpdateImpl JX;
            final /* synthetic */ Status wz;

            C16371(UpdateImpl updateImpl, Status status) {
                this.JX = updateImpl;
                this.wz = status;
            }

            public String getAchievementId() {
                return this.JX.wp;
            }

            public Status getStatus() {
                return this.wz;
            }
        }

        public UpdateImpl(String id) {
            this.wp = id;
        }

        public /* synthetic */ Result m7466d(Status status) {
            return m7467u(status);
        }

        public UpdateAchievementResult m7467u(Status status) {
            return new C16371(this, status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl.2 */
    class C16282 extends UpdateImpl {
        final /* synthetic */ AchievementsImpl JR;
        final /* synthetic */ String JU;

        C16282(AchievementsImpl achievementsImpl, String x0, String str) {
            this.JR = achievementsImpl;
            this.JU = str;
            super(x0);
        }

        public void m7469a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7052b(null, this.JU);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl.3 */
    class C16293 extends UpdateImpl {
        final /* synthetic */ AchievementsImpl JR;
        final /* synthetic */ String JU;

        C16293(AchievementsImpl achievementsImpl, String x0, String str) {
            this.JR = achievementsImpl;
            this.JU = str;
            super(x0);
        }

        public void m7471a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7052b((C1401d) this, this.JU);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl.4 */
    class C16304 extends UpdateImpl {
        final /* synthetic */ AchievementsImpl JR;
        final /* synthetic */ String JU;

        C16304(AchievementsImpl achievementsImpl, String x0, String str) {
            this.JR = achievementsImpl;
            this.JU = str;
            super(x0);
        }

        public void m7473a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7066c(null, this.JU);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl.5 */
    class C16315 extends UpdateImpl {
        final /* synthetic */ AchievementsImpl JR;
        final /* synthetic */ String JU;

        C16315(AchievementsImpl achievementsImpl, String x0, String str) {
            this.JR = achievementsImpl;
            this.JU = str;
            super(x0);
        }

        public void m7475a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7066c((C1401d) this, this.JU);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl.6 */
    class C16326 extends UpdateImpl {
        final /* synthetic */ AchievementsImpl JR;
        final /* synthetic */ String JU;
        final /* synthetic */ int JV;

        C16326(AchievementsImpl achievementsImpl, String x0, String str, int i) {
            this.JR = achievementsImpl;
            this.JU = str;
            this.JV = i;
            super(x0);
        }

        public void m7477a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7022a(null, this.JU, this.JV);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl.7 */
    class C16337 extends UpdateImpl {
        final /* synthetic */ AchievementsImpl JR;
        final /* synthetic */ String JU;
        final /* synthetic */ int JV;

        C16337(AchievementsImpl achievementsImpl, String x0, String str, int i) {
            this.JR = achievementsImpl;
            this.JU = str;
            this.JV = i;
            super(x0);
        }

        public void m7479a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7022a((C1401d) this, this.JU, this.JV);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl.8 */
    class C16348 extends UpdateImpl {
        final /* synthetic */ AchievementsImpl JR;
        final /* synthetic */ String JU;
        final /* synthetic */ int JV;

        C16348(AchievementsImpl achievementsImpl, String x0, String str, int i) {
            this.JR = achievementsImpl;
            this.JU = str;
            this.JV = i;
            super(x0);
        }

        public void m7481a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7053b(null, this.JU, this.JV);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl.9 */
    class C16359 extends UpdateImpl {
        final /* synthetic */ AchievementsImpl JR;
        final /* synthetic */ String JU;
        final /* synthetic */ int JV;

        C16359(AchievementsImpl achievementsImpl, String x0, String str, int i) {
            this.JR = achievementsImpl;
            this.JU = str;
            this.JV = i;
            super(x0);
        }

        public void m7483a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7053b((C1401d) this, this.JU, this.JV);
        }
    }

    public Intent getAchievementsIntent(GoogleApiClient apiClient) {
        return Games.m6753c(apiClient).gq();
    }

    public void increment(GoogleApiClient apiClient, String id, int numSteps) {
        apiClient.m6239b(new C16326(this, id, id, numSteps));
    }

    public PendingResult incrementImmediate(GoogleApiClient apiClient, String id, int numSteps) {
        return apiClient.m6239b(new C16337(this, id, id, numSteps));
    }

    public PendingResult load(GoogleApiClient apiClient, boolean forceReload) {
        return apiClient.m6238a(new C16271(this, forceReload));
    }

    public void reveal(GoogleApiClient apiClient, String id) {
        apiClient.m6239b(new C16282(this, id, id));
    }

    public PendingResult revealImmediate(GoogleApiClient apiClient, String id) {
        return apiClient.m6239b(new C16293(this, id, id));
    }

    public void setSteps(GoogleApiClient apiClient, String id, int numSteps) {
        apiClient.m6239b(new C16348(this, id, id, numSteps));
    }

    public PendingResult setStepsImmediate(GoogleApiClient apiClient, String id, int numSteps) {
        return apiClient.m6239b(new C16359(this, id, id, numSteps));
    }

    public void unlock(GoogleApiClient apiClient, String id) {
        apiClient.m6239b(new C16304(this, id, id));
    }

    public PendingResult unlockImmediate(GoogleApiClient apiClient, String id) {
        return apiClient.m6239b(new C16315(this, id, id));
    }
}
