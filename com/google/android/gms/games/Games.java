package com.google.android.gms.games;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.view.View;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.C1398b;
import com.google.android.gms.common.api.Api.C1457c;
import com.google.android.gms.common.api.C1461a.C1401d;
import com.google.android.gms.common.api.C1461a.C1404b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.internal.api.AchievementsImpl;
import com.google.android.gms.games.internal.api.AclsImpl;
import com.google.android.gms.games.internal.api.GamesMetadataImpl;
import com.google.android.gms.games.internal.api.InvitationsImpl;
import com.google.android.gms.games.internal.api.LeaderboardsImpl;
import com.google.android.gms.games.internal.api.MultiplayerImpl;
import com.google.android.gms.games.internal.api.NotificationsImpl;
import com.google.android.gms.games.internal.api.PlayersImpl;
import com.google.android.gms.games.internal.api.RealTimeMultiplayerImpl;
import com.google.android.gms.games.internal.api.RequestsImpl;
import com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl;
import com.google.android.gms.games.internal.game.Acls;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.games.multiplayer.Invitations;
import com.google.android.gms.games.multiplayer.Multiplayer;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.internal.fc;
import com.google.android.gms.internal.fq;

public final class Games {
    public static final Api API;
    public static final Achievements Achievements;
    public static final String EXTRA_PLAYER_IDS = "players";
    public static final GamesMetadata GamesMetadata;
    public static final Scope HV;
    public static final Api HW;
    public static final Multiplayer HX;
    public static final Acls HY;
    public static final Invitations Invitations;
    public static final Leaderboards Leaderboards;
    public static final Notifications Notifications;
    public static final Players Players;
    public static final RealTimeMultiplayer RealTimeMultiplayer;
    public static final Requests Requests;
    public static final Scope SCOPE_GAMES;
    public static final TurnBasedMultiplayer TurnBasedMultiplayer;
    static final C1457c wx;
    private static final C1398b wy;

    /* renamed from: com.google.android.gms.games.Games.1 */
    static class C16221 implements C1398b {
        C16221() {
        }

        public GamesClientImpl m6748a(Context context, Looper looper, fc fcVar, GamesOptions gamesOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            if (gamesOptions == null) {
                GamesOptions gamesOptions2 = new GamesOptions();
            }
            return new GamesClientImpl(context, looper, fcVar.eG(), fcVar.eC(), connectionCallbacks, onConnectionFailedListener, fcVar.eF(), fcVar.eD(), fcVar.eH(), gamesOptions.HZ, gamesOptions.Ia, gamesOptions.Ib, gamesOptions.Ic, gamesOptions.Id);
        }

        public int getPriority() {
            return 1;
        }
    }

    public static abstract class BaseGamesApiMethodImpl extends C1404b {
        public BaseGamesApiMethodImpl() {
            super(Games.wx);
        }
    }

    private static abstract class SignOutImpl extends BaseGamesApiMethodImpl {
        private SignOutImpl() {
        }

        public /* synthetic */ Result m6749d(Status status) {
            return m6750f(status);
        }

        public Status m6750f(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.games.Games.2 */
    static class C16232 extends SignOutImpl {
        C16232() {
            super();
        }

        protected void m6752a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7050b((C1401d) this);
        }
    }

    public static final class GamesOptions implements Optional {
        final boolean HZ;
        final boolean Ia;
        final int Ib;
        final boolean Ic;
        final int Id;

        public static final class Builder {
            boolean HZ;
            boolean Ia;
            int Ib;
            boolean Ic;
            int Id;

            private Builder() {
                this.HZ = false;
                this.Ia = true;
                this.Ib = 17;
                this.Ic = false;
                this.Id = 4368;
            }

            public GamesOptions build() {
                return new GamesOptions();
            }

            public Builder setSdkVariant(int variant) {
                this.Id = variant;
                return this;
            }

            public Builder setShowConnectingPopup(boolean showConnectingPopup) {
                this.Ia = showConnectingPopup;
                this.Ib = 17;
                return this;
            }

            public Builder setShowConnectingPopup(boolean showConnectingPopup, int gravity) {
                this.Ia = showConnectingPopup;
                this.Ib = gravity;
                return this;
            }
        }

        private GamesOptions() {
            this.HZ = false;
            this.Ia = true;
            this.Ib = 17;
            this.Ic = false;
            this.Id = 4368;
        }

        private GamesOptions(Builder builder) {
            this.HZ = builder.HZ;
            this.Ia = builder.Ia;
            this.Ib = builder.Ib;
            this.Ic = builder.Ic;
            this.Id = builder.Id;
        }

        public static Builder builder() {
            return new Builder();
        }
    }

    static {
        wx = new C1457c();
        wy = new C16221();
        SCOPE_GAMES = new Scope(Scopes.GAMES);
        API = new Api(wy, wx, SCOPE_GAMES);
        HV = new Scope("https://www.googleapis.com/auth/games.firstparty");
        HW = new Api(wy, wx, HV);
        GamesMetadata = new GamesMetadataImpl();
        Achievements = new AchievementsImpl();
        Leaderboards = new LeaderboardsImpl();
        Invitations = new InvitationsImpl();
        TurnBasedMultiplayer = new TurnBasedMultiplayerImpl();
        RealTimeMultiplayer = new RealTimeMultiplayerImpl();
        HX = new MultiplayerImpl();
        Players = new PlayersImpl();
        Notifications = new NotificationsImpl();
        Requests = new RequestsImpl();
        HY = new AclsImpl();
    }

    private Games() {
    }

    public static GamesClientImpl m6753c(GoogleApiClient googleApiClient) {
        boolean z = true;
        fq.m8519b(googleApiClient != null, (Object) "GoogleApiClient parameter is required.");
        fq.m8515a(googleApiClient.isConnected(), "GoogleApiClient must be connected.");
        GamesClientImpl gamesClientImpl = (GamesClientImpl) googleApiClient.m6237a(wx);
        if (gamesClientImpl == null) {
            z = false;
        }
        fq.m8515a(z, "GoogleApiClient is not configured to use the Games Api. Pass Games.API into GoogleApiClient.Builder#addApi() to use this feature.");
        return gamesClientImpl;
    }

    public static String getAppId(GoogleApiClient apiClient) {
        return m6753c(apiClient).gz();
    }

    public static String getCurrentAccountName(GoogleApiClient apiClient) {
        return m6753c(apiClient).gl();
    }

    public static int getSdkVariant(GoogleApiClient apiClient) {
        return m6753c(apiClient).gy();
    }

    public static Intent getSettingsIntent(GoogleApiClient apiClient) {
        return m6753c(apiClient).gx();
    }

    public static void setGravityForPopups(GoogleApiClient apiClient, int gravity) {
        m6753c(apiClient).aX(gravity);
    }

    public static void setViewForPopups(GoogleApiClient apiClient, View gamesContentView) {
        fq.m8520f(gamesContentView);
        m6753c(apiClient).m7080f(gamesContentView);
    }

    public static PendingResult signOut(GoogleApiClient apiClient) {
        return apiClient.m6239b(new C16232());
    }
}
