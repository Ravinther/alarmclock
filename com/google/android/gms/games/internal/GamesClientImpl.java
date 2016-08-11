package com.google.android.gms.games.internal;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.LocalSocket;
import android.net.LocalSocketAddress;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.C1461a.C1401d;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.GamesMetadata.LoadExtendedGamesResult;
import com.google.android.gms.games.GamesMetadata.LoadGameInstancesResult;
import com.google.android.gms.games.GamesMetadata.LoadGameSearchSuggestionsResult;
import com.google.android.gms.games.GamesMetadata.LoadGamesResult;
import com.google.android.gms.games.Notifications.ContactSettingLoadResult;
import com.google.android.gms.games.Notifications.GameMuteStatusChangeResult;
import com.google.android.gms.games.Notifications.GameMuteStatusLoadResult;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.Players.LoadExtendedPlayersResult;
import com.google.android.gms.games.Players.LoadOwnerCoverPhotoUrisResult;
import com.google.android.gms.games.Players.LoadPlayersResult;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult;
import com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult;
import com.google.android.gms.games.internal.IGamesService.Stub;
import com.google.android.gms.games.internal.constants.RequestType;
import com.google.android.gms.games.internal.game.Acls.LoadAclResult;
import com.google.android.gms.games.internal.game.ExtendedGameBuffer;
import com.google.android.gms.games.internal.game.GameInstanceBuffer;
import com.google.android.gms.games.internal.player.ExtendedPlayerBuffer;
import com.google.android.gms.games.internal.request.RequestUpdateOutcomes;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardEntity;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScoreEntity;
import com.google.android.gms.games.leaderboard.Leaderboards.LeaderboardMetadataResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadPlayerScoreResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult;
import com.google.android.gms.games.leaderboard.Leaderboards.SubmitScoreResult;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.Invitations.LoadInvitationsResult;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.ParticipantUtils;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessage;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessageReceivedListener;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer.ReliableMessageSentCallback;
import com.google.android.gms.games.multiplayer.realtime.RealTimeSocket;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomBuffer;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.RoomEntity;
import com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
import com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchBuffer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.InitiateMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LeaveMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchesResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestBuffer;
import com.google.android.gms.games.request.OnRequestReceivedListener;
import com.google.android.gms.games.request.Requests.LoadRequestSummariesResult;
import com.google.android.gms.games.request.Requests.LoadRequestsResult;
import com.google.android.gms.games.request.Requests.SendRequestResult;
import com.google.android.gms.games.request.Requests.UpdateRequestsResult;
import com.google.android.gms.internal.ff;
import com.google.android.gms.internal.ff.C1624b;
import com.google.android.gms.internal.ff.C1625d;
import com.google.android.gms.internal.ff.C1893e;
import com.google.android.gms.internal.fm;
import com.google.android.gms.internal.fq;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class GamesClientImpl extends ff implements ConnectionCallbacks, OnConnectionFailedListener {
    private boolean IA;
    private int IB;
    private final Binder IC;
    private final long IE;
    private final boolean IF;
    private final int IG;
    private final boolean IH;
    private final String Iu;
    private final Map Iv;
    private PlayerEntity Iw;
    private GameEntity Ix;
    private final PopupManager Iy;
    private boolean Iz;
    private final String wG;

    abstract class AbstractRoomStatusCallback extends C1625d {
        final /* synthetic */ GamesClientImpl IJ;

        AbstractRoomStatusCallback(GamesClientImpl gamesClientImpl, RoomStatusUpdateListener listener, DataHolder dataHolder) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, listener, dataHolder);
        }

        protected void m6856a(RoomStatusUpdateListener roomStatusUpdateListener, DataHolder dataHolder) {
            m6857a(roomStatusUpdateListener, this.IJ.m7005G(dataHolder));
        }

        protected abstract void m6857a(RoomStatusUpdateListener roomStatusUpdateListener, Room room);
    }

    abstract class AbstractPeerStatusCallback extends AbstractRoomStatusCallback {
        private final ArrayList II;
        final /* synthetic */ GamesClientImpl IJ;

        AbstractPeerStatusCallback(GamesClientImpl gamesClientImpl, RoomStatusUpdateListener listener, DataHolder dataHolder, String[] participantIds) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, listener, dataHolder);
            this.II = new ArrayList();
            for (Object add : participantIds) {
                this.II.add(add);
            }
        }

        protected void m6859a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            m6860a(roomStatusUpdateListener, room, this.II);
        }

        protected abstract void m6860a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList arrayList);
    }

    abstract class AbstractRoomCallback extends C1625d {
        final /* synthetic */ GamesClientImpl IJ;

        AbstractRoomCallback(GamesClientImpl gamesClientImpl, RoomUpdateListener listener, DataHolder dataHolder) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, listener, dataHolder);
        }

        protected void m6861a(RoomUpdateListener roomUpdateListener, DataHolder dataHolder) {
            m6862a(roomUpdateListener, this.IJ.m7005G(dataHolder), dataHolder.getStatusCode());
        }

        protected abstract void m6862a(RoomUpdateListener roomUpdateListener, Room room, int i);
    }

    final class AchievementUpdatedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl IJ;
        private final C1401d wH;

        AchievementUpdatedBinderCallback(GamesClientImpl gamesClientImpl, C1401d resultHolder) {
            this.IJ = gamesClientImpl;
            this.wH = (C1401d) fq.m8517b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void m6864e(int i, String str) {
            this.IJ.m6504a(new AchievementUpdatedCallback(this.IJ, this.wH, i, str));
        }
    }

    final class AchievementUpdatedCallback extends C1624b implements UpdateAchievementResult {
        final /* synthetic */ GamesClientImpl IJ;
        private final String IK;
        private final Status wJ;

        AchievementUpdatedCallback(GamesClientImpl gamesClientImpl, C1401d resultHolder, int statusCode, String achievementId) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, resultHolder);
            this.wJ = new Status(statusCode);
            this.IK = achievementId;
        }

        protected /* synthetic */ void m6865a(Object obj) {
            m6866c((C1401d) obj);
        }

        protected void m6866c(C1401d c1401d) {
            c1401d.m6049b(this);
        }

        protected void dx() {
        }

        public String getAchievementId() {
            return this.IK;
        }

        public Status getStatus() {
            return this.wJ;
        }
    }

    final class AchievementsLoadedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl IJ;
        private final C1401d wH;

        AchievementsLoadedBinderCallback(GamesClientImpl gamesClientImpl, C1401d resultHolder) {
            this.IJ = gamesClientImpl;
            this.wH = (C1401d) fq.m8517b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void m6867b(DataHolder dataHolder) {
            this.IJ.m6504a(new AchievementsLoadedCallback(this.IJ, this.wH, dataHolder));
        }
    }

    abstract class ResultDataHolderCallback extends C1625d implements Releasable, Result {
        final DataHolder BB;
        final /* synthetic */ GamesClientImpl IJ;
        final Status wJ;

        public ResultDataHolderCallback(GamesClientImpl gamesClientImpl, C1401d resultHolder, DataHolder dataHolder) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, resultHolder, dataHolder);
            this.wJ = new Status(dataHolder.getStatusCode());
            this.BB = dataHolder;
        }

        public Status getStatus() {
            return this.wJ;
        }

        public void release() {
            if (this.BB != null) {
                this.BB.close();
            }
        }
    }

    final class AchievementsLoadedCallback extends ResultDataHolderCallback implements LoadAchievementsResult {
        final /* synthetic */ GamesClientImpl IJ;
        private final AchievementBuffer IL;

        AchievementsLoadedCallback(GamesClientImpl gamesClientImpl, C1401d resultHolder, DataHolder dataHolder) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, resultHolder, dataHolder);
            this.IL = new AchievementBuffer(dataHolder);
        }

        protected void m6868a(C1401d c1401d, DataHolder dataHolder) {
            c1401d.m6049b(this);
        }

        public AchievementBuffer getAchievements() {
            return this.IL;
        }
    }

    final class ConnectedToRoomCallback extends AbstractRoomStatusCallback {
        final /* synthetic */ GamesClientImpl IJ;

        ConnectedToRoomCallback(GamesClientImpl gamesClientImpl, RoomStatusUpdateListener listener, DataHolder dataHolder) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, listener, dataHolder);
        }

        public void m6870a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onConnectedToRoom(room);
        }
    }

    final class ContactSettingsLoadedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl IJ;
        private final C1401d wH;

        ContactSettingsLoadedBinderCallback(GamesClientImpl gamesClientImpl, C1401d holder) {
            this.IJ = gamesClientImpl;
            this.wH = (C1401d) fq.m8517b((Object) holder, (Object) "Holder must not be null");
        }

        public void m6871B(DataHolder dataHolder) {
            this.IJ.m6504a(new ContactSettingsLoadedCallback(this.IJ, this.wH, dataHolder));
        }
    }

    final class ContactSettingsLoadedCallback extends ResultDataHolderCallback implements ContactSettingLoadResult {
        final /* synthetic */ GamesClientImpl IJ;

        ContactSettingsLoadedCallback(GamesClientImpl gamesClientImpl, C1401d resultHolder, DataHolder dataHolder) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, resultHolder, dataHolder);
        }

        protected void m6872a(C1401d c1401d, DataHolder dataHolder) {
            c1401d.m6049b(this);
        }
    }

    final class ContactSettingsUpdatedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl IJ;
        private final C1401d wH;

        ContactSettingsUpdatedBinderCallback(GamesClientImpl gamesClientImpl, C1401d holder) {
            this.IJ = gamesClientImpl;
            this.wH = (C1401d) fq.m8517b((Object) holder, (Object) "Holder must not be null");
        }

        public void aV(int i) {
            this.IJ.m6504a(new ContactSettingsUpdatedCallback(this.IJ, this.wH, i));
        }
    }

    final class ContactSettingsUpdatedCallback extends C1624b {
        final /* synthetic */ GamesClientImpl IJ;
        private final Status wJ;

        ContactSettingsUpdatedCallback(GamesClientImpl gamesClientImpl, C1401d resultHolder, int statusCode) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, resultHolder);
            this.wJ = new Status(statusCode);
        }

        protected /* synthetic */ void m6874a(Object obj) {
            m6875c((C1401d) obj);
        }

        protected void m6875c(C1401d c1401d) {
            c1401d.m6049b(this.wJ);
        }

        protected void dx() {
        }
    }

    final class DisconnectedFromRoomCallback extends AbstractRoomStatusCallback {
        final /* synthetic */ GamesClientImpl IJ;

        DisconnectedFromRoomCallback(GamesClientImpl gamesClientImpl, RoomStatusUpdateListener listener, DataHolder dataHolder) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, listener, dataHolder);
        }

        public void m6876a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onDisconnectedFromRoom(room);
        }
    }

    final class ExtendedGamesLoadedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl IJ;
        private final C1401d wH;

        ExtendedGamesLoadedBinderCallback(GamesClientImpl gamesClientImpl, C1401d holder) {
            this.IJ = gamesClientImpl;
            this.wH = (C1401d) fq.m8517b((Object) holder, (Object) "Holder must not be null");
        }

        public void m6877h(DataHolder dataHolder) {
            this.IJ.m6504a(new ExtendedGamesLoadedCallback(this.IJ, this.wH, dataHolder));
        }
    }

    final class ExtendedGamesLoadedCallback extends ResultDataHolderCallback implements LoadExtendedGamesResult {
        final /* synthetic */ GamesClientImpl IJ;
        private final ExtendedGameBuffer IM;

        ExtendedGamesLoadedCallback(GamesClientImpl gamesClientImpl, C1401d resultHolder, DataHolder dataHolder) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, resultHolder, dataHolder);
            this.IM = new ExtendedGameBuffer(dataHolder);
        }

        protected void m6878a(C1401d c1401d, DataHolder dataHolder) {
            c1401d.m6049b(this);
        }
    }

    final class ExtendedPlayersLoadedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl IJ;
        private final C1401d wH;

        ExtendedPlayersLoadedBinderCallback(GamesClientImpl gamesClientImpl, C1401d holder) {
            this.IJ = gamesClientImpl;
            this.wH = (C1401d) fq.m8517b((Object) holder, (Object) "Holder must not be null");
        }

        public void m6880f(DataHolder dataHolder) {
            this.IJ.m6504a(new ExtendedPlayersLoadedCallback(this.IJ, this.wH, dataHolder));
        }
    }

    final class ExtendedPlayersLoadedCallback extends ResultDataHolderCallback implements LoadExtendedPlayersResult {
        final /* synthetic */ GamesClientImpl IJ;
        private final ExtendedPlayerBuffer IN;

        ExtendedPlayersLoadedCallback(GamesClientImpl gamesClientImpl, C1401d resultHolder, DataHolder dataHolder) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, resultHolder, dataHolder);
            this.IN = new ExtendedPlayerBuffer(dataHolder);
        }

        protected void m6881a(C1401d c1401d, DataHolder dataHolder) {
            c1401d.m6049b(this);
        }
    }

    final class GameInstancesLoadedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl IJ;
        private final C1401d wH;

        GameInstancesLoadedBinderCallback(GamesClientImpl gamesClientImpl, C1401d holder) {
            this.IJ = gamesClientImpl;
            this.wH = (C1401d) fq.m8517b((Object) holder, (Object) "Holder must not be null");
        }

        public void m6883i(DataHolder dataHolder) {
            this.IJ.m6504a(new GameInstancesLoadedCallback(this.IJ, this.wH, dataHolder));
        }
    }

    final class GameInstancesLoadedCallback extends ResultDataHolderCallback implements LoadGameInstancesResult {
        final /* synthetic */ GamesClientImpl IJ;
        private final GameInstanceBuffer IO;

        GameInstancesLoadedCallback(GamesClientImpl gamesClientImpl, C1401d resultHolder, DataHolder dataHolder) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, resultHolder, dataHolder);
            this.IO = new GameInstanceBuffer(dataHolder);
        }

        protected void m6884a(C1401d c1401d, DataHolder dataHolder) {
            c1401d.m6049b(this);
        }
    }

    final class GameMuteStatusChangedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl IJ;
        private final C1401d wH;

        GameMuteStatusChangedBinderCallback(GamesClientImpl gamesClientImpl, C1401d holder) {
            this.IJ = gamesClientImpl;
            this.wH = (C1401d) fq.m8517b((Object) holder, (Object) "Holder must not be null");
        }

        public void m6886a(int i, String str, boolean z) {
            this.IJ.m6504a(new GameMuteStatusChangedCallback(this.IJ, this.wH, i, str, z));
        }
    }

    final class GameMuteStatusChangedCallback extends C1624b implements GameMuteStatusChangeResult {
        final /* synthetic */ GamesClientImpl IJ;
        private final String IP;
        private final boolean IQ;
        private final Status wJ;

        public GameMuteStatusChangedCallback(GamesClientImpl gamesClientImpl, C1401d resultHolder, int statusCode, String externalGameId, boolean isMuted) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, resultHolder);
            this.wJ = new Status(statusCode);
            this.IP = externalGameId;
            this.IQ = isMuted;
        }

        protected /* synthetic */ void m6887a(Object obj) {
            m6888c((C1401d) obj);
        }

        protected void m6888c(C1401d c1401d) {
            c1401d.m6049b(this);
        }

        protected void dx() {
        }

        public Status getStatus() {
            return this.wJ;
        }
    }

    final class GameMuteStatusLoadedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl IJ;
        private final C1401d wH;

        GameMuteStatusLoadedBinderCallback(GamesClientImpl gamesClientImpl, C1401d holder) {
            this.IJ = gamesClientImpl;
            this.wH = (C1401d) fq.m8517b((Object) holder, (Object) "Holder must not be null");
        }

        public void m6889z(DataHolder dataHolder) {
            this.IJ.m6504a(new GameMuteStatusLoadedCallback(this.IJ, this.wH, dataHolder));
        }
    }

    final class GameMuteStatusLoadedCallback extends C1624b implements GameMuteStatusLoadResult {
        final /* synthetic */ GamesClientImpl IJ;
        private final String IP;
        private final boolean IQ;
        private final Status wJ;

        public GameMuteStatusLoadedCallback(GamesClientImpl gamesClientImpl, C1401d resultHolder, DataHolder dataHolder) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, resultHolder);
            try {
                this.wJ = new Status(dataHolder.getStatusCode());
                if (dataHolder.getCount() > 0) {
                    this.IP = dataHolder.getString("external_game_id", 0, 0);
                    this.IQ = dataHolder.getBoolean("muted", 0, 0);
                } else {
                    this.IP = null;
                    this.IQ = false;
                }
                dataHolder.close();
            } catch (Throwable th) {
                dataHolder.close();
            }
        }

        protected /* synthetic */ void m6890a(Object obj) {
            m6891c((C1401d) obj);
        }

        protected void m6891c(C1401d c1401d) {
            c1401d.m6049b(this);
        }

        protected void dx() {
        }

        public Status getStatus() {
            return this.wJ;
        }
    }

    final class GameSearchSuggestionsLoadedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl IJ;
        private final C1401d wH;

        GameSearchSuggestionsLoadedBinderCallback(GamesClientImpl gamesClientImpl, C1401d holder) {
            this.IJ = gamesClientImpl;
            this.wH = (C1401d) fq.m8517b((Object) holder, (Object) "Holder must not be null");
        }

        public void m6892j(DataHolder dataHolder) {
            this.IJ.m6504a(new GameSearchSuggestionsLoadedCallback(this.IJ, this.wH, dataHolder));
        }
    }

    final class GameSearchSuggestionsLoadedCallback extends ResultDataHolderCallback implements LoadGameSearchSuggestionsResult {
        final /* synthetic */ GamesClientImpl IJ;
        private final DataHolder IR;

        GameSearchSuggestionsLoadedCallback(GamesClientImpl gamesClientImpl, C1401d resultHolder, DataHolder data) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, resultHolder, data);
            this.IR = data;
        }

        protected void m6893a(C1401d c1401d, DataHolder dataHolder) {
            c1401d.m6049b(this);
        }
    }

    final class GamesLoadedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl IJ;
        private final C1401d wH;

        GamesLoadedBinderCallback(GamesClientImpl gamesClientImpl, C1401d holder) {
            this.IJ = gamesClientImpl;
            this.wH = (C1401d) fq.m8517b((Object) holder, (Object) "Holder must not be null");
        }

        public void m6895g(DataHolder dataHolder) {
            this.IJ.m6504a(new GamesLoadedCallback(this.IJ, this.wH, dataHolder));
        }
    }

    final class GamesLoadedCallback extends ResultDataHolderCallback implements LoadGamesResult {
        final /* synthetic */ GamesClientImpl IJ;
        private final GameBuffer IS;

        GamesLoadedCallback(GamesClientImpl gamesClientImpl, C1401d resultHolder, DataHolder dataHolder) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, resultHolder, dataHolder);
            this.IS = new GameBuffer(dataHolder);
        }

        protected void m6896a(C1401d c1401d, DataHolder dataHolder) {
            c1401d.m6049b(this);
        }

        public GameBuffer getGames() {
            return this.IS;
        }
    }

    final class InvitationReceivedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl IJ;
        private final OnInvitationReceivedListener IT;

        InvitationReceivedBinderCallback(GamesClientImpl gamesClientImpl, OnInvitationReceivedListener listener) {
            this.IJ = gamesClientImpl;
            this.IT = listener;
        }

        public void m6898l(DataHolder dataHolder) {
            InvitationBuffer invitationBuffer = new InvitationBuffer(dataHolder);
            Invitation invitation = null;
            try {
                if (invitationBuffer.getCount() > 0) {
                    invitation = (Invitation) ((Invitation) invitationBuffer.get(0)).freeze();
                }
                invitationBuffer.close();
                if (invitation != null) {
                    this.IJ.m6504a(new InvitationReceivedCallback(this.IJ, this.IT, invitation));
                }
            } catch (Throwable th) {
                invitationBuffer.close();
            }
        }

        public void onInvitationRemoved(String invitationId) {
            this.IJ.m6504a(new InvitationRemovedCallback(this.IJ, this.IT, invitationId));
        }
    }

    final class InvitationReceivedCallback extends C1624b {
        final /* synthetic */ GamesClientImpl IJ;
        private final Invitation IU;

        InvitationReceivedCallback(GamesClientImpl gamesClientImpl, OnInvitationReceivedListener listener, Invitation invitation) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, listener);
            this.IU = invitation;
        }

        protected /* synthetic */ void m6899a(Object obj) {
            m6900b((OnInvitationReceivedListener) obj);
        }

        protected void m6900b(OnInvitationReceivedListener onInvitationReceivedListener) {
            onInvitationReceivedListener.onInvitationReceived(this.IU);
        }

        protected void dx() {
        }
    }

    final class InvitationRemovedCallback extends C1624b {
        final /* synthetic */ GamesClientImpl IJ;
        private final String IV;

        InvitationRemovedCallback(GamesClientImpl gamesClientImpl, OnInvitationReceivedListener listener, String invitationId) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, listener);
            this.IV = invitationId;
        }

        protected /* synthetic */ void m6901a(Object obj) {
            m6902b((OnInvitationReceivedListener) obj);
        }

        protected void m6902b(OnInvitationReceivedListener onInvitationReceivedListener) {
            onInvitationReceivedListener.onInvitationRemoved(this.IV);
        }

        protected void dx() {
        }
    }

    final class InvitationsLoadedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl IJ;
        private final C1401d wH;

        InvitationsLoadedBinderCallback(GamesClientImpl gamesClientImpl, C1401d resultHolder) {
            this.IJ = gamesClientImpl;
            this.wH = (C1401d) fq.m8517b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void m6903k(DataHolder dataHolder) {
            this.IJ.m6504a(new InvitationsLoadedCallback(this.IJ, this.wH, dataHolder));
        }
    }

    final class InvitationsLoadedCallback extends ResultDataHolderCallback implements LoadInvitationsResult {
        final /* synthetic */ GamesClientImpl IJ;
        private final InvitationBuffer IW;

        InvitationsLoadedCallback(GamesClientImpl gamesClientImpl, C1401d resultHolder, DataHolder dataHolder) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, resultHolder, dataHolder);
            this.IW = new InvitationBuffer(dataHolder);
        }

        protected void m6904a(C1401d c1401d, DataHolder dataHolder) {
            c1401d.m6049b(this);
        }

        public InvitationBuffer getInvitations() {
            return this.IW;
        }
    }

    final class JoinedRoomCallback extends AbstractRoomCallback {
        final /* synthetic */ GamesClientImpl IJ;

        public JoinedRoomCallback(GamesClientImpl gamesClientImpl, RoomUpdateListener listener, DataHolder dataHolder) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, listener, dataHolder);
        }

        public void m6906a(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onJoinedRoom(i, room);
        }
    }

    final class LeaderboardScoresLoadedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl IJ;
        private final C1401d wH;

        LeaderboardScoresLoadedBinderCallback(GamesClientImpl gamesClientImpl, C1401d resultHolder) {
            this.IJ = gamesClientImpl;
            this.wH = (C1401d) fq.m8517b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void m6907a(DataHolder dataHolder, DataHolder dataHolder2) {
            this.IJ.m6504a(new LeaderboardScoresLoadedCallback(this.IJ, this.wH, dataHolder, dataHolder2));
        }
    }

    final class LeaderboardScoresLoadedCallback extends ResultDataHolderCallback implements LoadScoresResult {
        final /* synthetic */ GamesClientImpl IJ;
        private final LeaderboardEntity IX;
        private final LeaderboardScoreBuffer IY;

        LeaderboardScoresLoadedCallback(GamesClientImpl gamesClientImpl, C1401d resultHolder, DataHolder leaderboard, DataHolder scores) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, resultHolder, scores);
            LeaderboardBuffer leaderboardBuffer = new LeaderboardBuffer(leaderboard);
            try {
                if (leaderboardBuffer.getCount() > 0) {
                    this.IX = (LeaderboardEntity) ((Leaderboard) leaderboardBuffer.get(0)).freeze();
                } else {
                    this.IX = null;
                }
                leaderboardBuffer.close();
                this.IY = new LeaderboardScoreBuffer(scores);
            } catch (Throwable th) {
                leaderboardBuffer.close();
            }
        }

        protected void m6908a(C1401d c1401d, DataHolder dataHolder) {
            c1401d.m6049b(this);
        }

        public Leaderboard getLeaderboard() {
            return this.IX;
        }

        public LeaderboardScoreBuffer getScores() {
            return this.IY;
        }
    }

    final class LeaderboardsLoadedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl IJ;
        private final C1401d wH;

        LeaderboardsLoadedBinderCallback(GamesClientImpl gamesClientImpl, C1401d resultHolder) {
            this.IJ = gamesClientImpl;
            this.wH = (C1401d) fq.m8517b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void m6910c(DataHolder dataHolder) {
            this.IJ.m6504a(new LeaderboardsLoadedCallback(this.IJ, this.wH, dataHolder));
        }
    }

    final class LeaderboardsLoadedCallback extends ResultDataHolderCallback implements LeaderboardMetadataResult {
        final /* synthetic */ GamesClientImpl IJ;
        private final LeaderboardBuffer IZ;

        LeaderboardsLoadedCallback(GamesClientImpl gamesClientImpl, C1401d resultHolder, DataHolder dataHolder) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, resultHolder, dataHolder);
            this.IZ = new LeaderboardBuffer(dataHolder);
        }

        protected void m6911a(C1401d c1401d, DataHolder dataHolder) {
            c1401d.m6049b(this);
        }

        public LeaderboardBuffer getLeaderboards() {
            return this.IZ;
        }
    }

    final class LeftRoomCallback extends C1624b {
        private final int Ah;
        final /* synthetic */ GamesClientImpl IJ;
        private final String Ja;

        LeftRoomCallback(GamesClientImpl gamesClientImpl, RoomUpdateListener listener, int statusCode, String roomId) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, listener);
            this.Ah = statusCode;
            this.Ja = roomId;
        }

        public void m6913a(RoomUpdateListener roomUpdateListener) {
            roomUpdateListener.onLeftRoom(this.Ah, this.Ja);
        }

        protected void dx() {
        }
    }

    final class MatchRemovedCallback extends C1624b {
        final /* synthetic */ GamesClientImpl IJ;
        private final String Jb;

        MatchRemovedCallback(GamesClientImpl gamesClientImpl, OnTurnBasedMatchUpdateReceivedListener listener, String matchId) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, listener);
            this.Jb = matchId;
        }

        protected /* synthetic */ void m6915a(Object obj) {
            m6916b((OnTurnBasedMatchUpdateReceivedListener) obj);
        }

        protected void m6916b(OnTurnBasedMatchUpdateReceivedListener onTurnBasedMatchUpdateReceivedListener) {
            onTurnBasedMatchUpdateReceivedListener.onTurnBasedMatchRemoved(this.Jb);
        }

        protected void dx() {
        }
    }

    final class MatchUpdateReceivedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl IJ;
        private final OnTurnBasedMatchUpdateReceivedListener Jc;

        MatchUpdateReceivedBinderCallback(GamesClientImpl gamesClientImpl, OnTurnBasedMatchUpdateReceivedListener listener) {
            this.IJ = gamesClientImpl;
            this.Jc = listener;
        }

        public void onTurnBasedMatchRemoved(String matchId) {
            this.IJ.m6504a(new MatchRemovedCallback(this.IJ, this.Jc, matchId));
        }

        public void m6917r(DataHolder dataHolder) {
            TurnBasedMatchBuffer turnBasedMatchBuffer = new TurnBasedMatchBuffer(dataHolder);
            TurnBasedMatch turnBasedMatch = null;
            try {
                if (turnBasedMatchBuffer.getCount() > 0) {
                    turnBasedMatch = (TurnBasedMatch) ((TurnBasedMatch) turnBasedMatchBuffer.get(0)).freeze();
                }
                turnBasedMatchBuffer.close();
                if (turnBasedMatch != null) {
                    this.IJ.m6504a(new MatchUpdateReceivedCallback(this.IJ, this.Jc, turnBasedMatch));
                }
            } catch (Throwable th) {
                turnBasedMatchBuffer.close();
            }
        }
    }

    final class MatchUpdateReceivedCallback extends C1624b {
        final /* synthetic */ GamesClientImpl IJ;
        private final TurnBasedMatch Jd;

        MatchUpdateReceivedCallback(GamesClientImpl gamesClientImpl, OnTurnBasedMatchUpdateReceivedListener listener, TurnBasedMatch match) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, listener);
            this.Jd = match;
        }

        protected /* synthetic */ void m6918a(Object obj) {
            m6919b((OnTurnBasedMatchUpdateReceivedListener) obj);
        }

        protected void m6919b(OnTurnBasedMatchUpdateReceivedListener onTurnBasedMatchUpdateReceivedListener) {
            onTurnBasedMatchUpdateReceivedListener.onTurnBasedMatchReceived(this.Jd);
        }

        protected void dx() {
        }
    }

    final class MessageReceivedCallback extends C1624b {
        final /* synthetic */ GamesClientImpl IJ;
        private final RealTimeMessage Je;

        MessageReceivedCallback(GamesClientImpl gamesClientImpl, RealTimeMessageReceivedListener listener, RealTimeMessage message) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, listener);
            this.Je = message;
        }

        public void m6920a(RealTimeMessageReceivedListener realTimeMessageReceivedListener) {
            if (realTimeMessageReceivedListener != null) {
                realTimeMessageReceivedListener.onRealTimeMessageReceived(this.Je);
            }
        }

        protected void dx() {
        }
    }

    final class NotifyAclLoadedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl IJ;
        private final C1401d wH;

        NotifyAclLoadedBinderCallback(GamesClientImpl gamesClientImpl, C1401d resultHolder) {
            this.IJ = gamesClientImpl;
            this.wH = (C1401d) fq.m8517b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void m6922A(DataHolder dataHolder) {
            this.IJ.m6504a(new NotifyAclLoadedCallback(this.IJ, this.wH, dataHolder));
        }
    }

    final class NotifyAclLoadedCallback extends ResultDataHolderCallback implements LoadAclResult {
        final /* synthetic */ GamesClientImpl IJ;

        NotifyAclLoadedCallback(GamesClientImpl gamesClientImpl, C1401d resultHolder, DataHolder dataHolder) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, resultHolder, dataHolder);
        }

        protected void m6923a(C1401d c1401d, DataHolder dataHolder) {
            c1401d.m6049b(this);
        }
    }

    final class NotifyAclUpdatedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl IJ;
        private final C1401d wH;

        NotifyAclUpdatedBinderCallback(GamesClientImpl gamesClientImpl, C1401d resultHolder) {
            this.IJ = gamesClientImpl;
            this.wH = (C1401d) fq.m8517b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void aU(int i) {
            this.IJ.m6504a(new NotifyAclUpdatedCallback(this.IJ, this.wH, i));
        }
    }

    final class NotifyAclUpdatedCallback extends C1624b {
        final /* synthetic */ GamesClientImpl IJ;
        private final Status wJ;

        NotifyAclUpdatedCallback(GamesClientImpl gamesClientImpl, C1401d resultHolder, int statusCode) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, resultHolder);
            this.wJ = new Status(statusCode);
        }

        protected /* synthetic */ void m6925a(Object obj) {
            m6926c((C1401d) obj);
        }

        protected void m6926c(C1401d c1401d) {
            c1401d.m6049b(this.wJ);
        }

        protected void dx() {
        }
    }

    final class OwnerCoverPhotoUrisLoadedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl IJ;
        private final C1401d wH;

        OwnerCoverPhotoUrisLoadedBinderCallback(GamesClientImpl gamesClientImpl, C1401d holder) {
            this.IJ = gamesClientImpl;
            this.wH = (C1401d) fq.m8517b((Object) holder, (Object) "Holder must not be null");
        }

        public void m6927c(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.IJ.m6504a(new OwnerCoverPhotoUrisLoadedCallback(this.IJ, this.wH, i, bundle));
        }
    }

    final class OwnerCoverPhotoUrisLoadedCallback extends C1624b implements LoadOwnerCoverPhotoUrisResult {
        final /* synthetic */ GamesClientImpl IJ;
        private final Bundle Jf;
        private final Status wJ;

        OwnerCoverPhotoUrisLoadedCallback(GamesClientImpl gamesClientImpl, C1401d resultHolder, int statusCode, Bundle bundle) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, resultHolder);
            this.wJ = new Status(statusCode);
            this.Jf = bundle;
        }

        protected /* synthetic */ void m6928a(Object obj) {
            m6929c((C1401d) obj);
        }

        protected void m6929c(C1401d c1401d) {
            c1401d.m6049b(this);
        }

        protected void dx() {
        }

        public Status getStatus() {
            return this.wJ;
        }
    }

    final class P2PConnectedCallback extends C1624b {
        final /* synthetic */ GamesClientImpl IJ;
        private final String Jg;

        P2PConnectedCallback(GamesClientImpl gamesClientImpl, RoomStatusUpdateListener listener, String participantId) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, listener);
            this.Jg = participantId;
        }

        public void m6930a(RoomStatusUpdateListener roomStatusUpdateListener) {
            if (roomStatusUpdateListener != null) {
                roomStatusUpdateListener.onP2PConnected(this.Jg);
            }
        }

        protected void dx() {
        }
    }

    final class P2PDisconnectedCallback extends C1624b {
        final /* synthetic */ GamesClientImpl IJ;
        private final String Jg;

        P2PDisconnectedCallback(GamesClientImpl gamesClientImpl, RoomStatusUpdateListener listener, String participantId) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, listener);
            this.Jg = participantId;
        }

        public void m6932a(RoomStatusUpdateListener roomStatusUpdateListener) {
            if (roomStatusUpdateListener != null) {
                roomStatusUpdateListener.onP2PDisconnected(this.Jg);
            }
        }

        protected void dx() {
        }
    }

    final class PeerConnectedCallback extends AbstractPeerStatusCallback {
        final /* synthetic */ GamesClientImpl IJ;

        PeerConnectedCallback(GamesClientImpl gamesClientImpl, RoomStatusUpdateListener listener, DataHolder dataHolder, String[] participantIds) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, listener, dataHolder, participantIds);
        }

        protected void m6934a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList arrayList) {
            roomStatusUpdateListener.onPeersConnected(room, arrayList);
        }
    }

    final class PeerDeclinedCallback extends AbstractPeerStatusCallback {
        final /* synthetic */ GamesClientImpl IJ;

        PeerDeclinedCallback(GamesClientImpl gamesClientImpl, RoomStatusUpdateListener listener, DataHolder dataHolder, String[] participantIds) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, listener, dataHolder, participantIds);
        }

        protected void m6935a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList arrayList) {
            roomStatusUpdateListener.onPeerDeclined(room, arrayList);
        }
    }

    final class PeerDisconnectedCallback extends AbstractPeerStatusCallback {
        final /* synthetic */ GamesClientImpl IJ;

        PeerDisconnectedCallback(GamesClientImpl gamesClientImpl, RoomStatusUpdateListener listener, DataHolder dataHolder, String[] participantIds) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, listener, dataHolder, participantIds);
        }

        protected void m6936a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList arrayList) {
            roomStatusUpdateListener.onPeersDisconnected(room, arrayList);
        }
    }

    final class PeerInvitedToRoomCallback extends AbstractPeerStatusCallback {
        final /* synthetic */ GamesClientImpl IJ;

        PeerInvitedToRoomCallback(GamesClientImpl gamesClientImpl, RoomStatusUpdateListener listener, DataHolder dataHolder, String[] participantIds) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, listener, dataHolder, participantIds);
        }

        protected void m6937a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList arrayList) {
            roomStatusUpdateListener.onPeerInvitedToRoom(room, arrayList);
        }
    }

    final class PeerJoinedRoomCallback extends AbstractPeerStatusCallback {
        final /* synthetic */ GamesClientImpl IJ;

        PeerJoinedRoomCallback(GamesClientImpl gamesClientImpl, RoomStatusUpdateListener listener, DataHolder dataHolder, String[] participantIds) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, listener, dataHolder, participantIds);
        }

        protected void m6938a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList arrayList) {
            roomStatusUpdateListener.onPeerJoined(room, arrayList);
        }
    }

    final class PeerLeftRoomCallback extends AbstractPeerStatusCallback {
        final /* synthetic */ GamesClientImpl IJ;

        PeerLeftRoomCallback(GamesClientImpl gamesClientImpl, RoomStatusUpdateListener listener, DataHolder dataHolder, String[] participantIds) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, listener, dataHolder, participantIds);
        }

        protected void m6939a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList arrayList) {
            roomStatusUpdateListener.onPeerLeft(room, arrayList);
        }
    }

    final class PlayerLeaderboardScoreLoadedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl IJ;
        private final C1401d wH;

        PlayerLeaderboardScoreLoadedBinderCallback(GamesClientImpl gamesClientImpl, C1401d resultHolder) {
            this.IJ = gamesClientImpl;
            this.wH = (C1401d) fq.m8517b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void m6940C(DataHolder dataHolder) {
            this.IJ.m6504a(new PlayerLeaderboardScoreLoadedCallback(this.IJ, this.wH, dataHolder));
        }
    }

    final class PlayerLeaderboardScoreLoadedCallback extends C1625d implements LoadPlayerScoreResult {
        final /* synthetic */ GamesClientImpl IJ;
        private final LeaderboardScoreEntity Jh;
        private final Status wJ;

        PlayerLeaderboardScoreLoadedCallback(GamesClientImpl gamesClientImpl, C1401d resultHolder, DataHolder scoreHolder) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, resultHolder, scoreHolder);
            this.wJ = new Status(scoreHolder.getStatusCode());
            LeaderboardScoreBuffer leaderboardScoreBuffer = new LeaderboardScoreBuffer(scoreHolder);
            try {
                if (leaderboardScoreBuffer.getCount() > 0) {
                    this.Jh = (LeaderboardScoreEntity) leaderboardScoreBuffer.get(0).freeze();
                } else {
                    this.Jh = null;
                }
                leaderboardScoreBuffer.close();
            } catch (Throwable th) {
                leaderboardScoreBuffer.close();
            }
        }

        protected void m6941a(C1401d c1401d, DataHolder dataHolder) {
            c1401d.m6049b(this);
        }

        public LeaderboardScore getScore() {
            return this.Jh;
        }

        public Status getStatus() {
            return this.wJ;
        }
    }

    final class PlayersLoadedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl IJ;
        private final C1401d wH;

        PlayersLoadedBinderCallback(GamesClientImpl gamesClientImpl, C1401d holder) {
            this.IJ = gamesClientImpl;
            this.wH = (C1401d) fq.m8517b((Object) holder, (Object) "Holder must not be null");
        }

        public void m6943e(DataHolder dataHolder) {
            this.IJ.m6504a(new PlayersLoadedCallback(this.IJ, this.wH, dataHolder));
        }
    }

    final class PlayersLoadedCallback extends ResultDataHolderCallback implements LoadPlayersResult {
        final /* synthetic */ GamesClientImpl IJ;
        private final PlayerBuffer Ji;

        PlayersLoadedCallback(GamesClientImpl gamesClientImpl, C1401d resultHolder, DataHolder dataHolder) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, resultHolder, dataHolder);
            this.Ji = new PlayerBuffer(dataHolder);
        }

        protected void m6944a(C1401d c1401d, DataHolder dataHolder) {
            c1401d.m6049b(this);
        }

        public PlayerBuffer getPlayers() {
            return this.Ji;
        }
    }

    final class RealTimeMessageSentCallback extends C1624b {
        private final int Ah;
        final /* synthetic */ GamesClientImpl IJ;
        private final String Jj;
        private final int Jk;

        RealTimeMessageSentCallback(GamesClientImpl gamesClientImpl, ReliableMessageSentCallback listener, int statusCode, int token, String recipientParticipantId) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, listener);
            this.Ah = statusCode;
            this.Jk = token;
            this.Jj = recipientParticipantId;
        }

        public void m6946a(ReliableMessageSentCallback reliableMessageSentCallback) {
            if (reliableMessageSentCallback != null) {
                reliableMessageSentCallback.onRealTimeMessageSent(this.Ah, this.Jk, this.Jj);
            }
        }

        protected void dx() {
        }
    }

    final class RealTimeReliableMessageBinderCallbacks extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl IJ;
        final ReliableMessageSentCallback Jl;

        public RealTimeReliableMessageBinderCallbacks(GamesClientImpl gamesClientImpl, ReliableMessageSentCallback messageSentCallbacks) {
            this.IJ = gamesClientImpl;
            this.Jl = messageSentCallbacks;
        }

        public void m6948b(int i, int i2, String str) {
            this.IJ.m6504a(new RealTimeMessageSentCallback(this.IJ, this.Jl, i, i2, str));
        }
    }

    final class RequestReceivedBinderCallback extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl IJ;
        private final OnRequestReceivedListener Jm;

        RequestReceivedBinderCallback(GamesClientImpl gamesClientImpl, OnRequestReceivedListener listener) {
            this.IJ = gamesClientImpl;
            this.Jm = listener;
        }

        public void m6949m(DataHolder dataHolder) {
            GameRequestBuffer gameRequestBuffer = new GameRequestBuffer(dataHolder);
            GameRequest gameRequest = null;
            try {
                if (gameRequestBuffer.getCount() > 0) {
                    gameRequest = (GameRequest) ((GameRequest) gameRequestBuffer.get(0)).freeze();
                }
                gameRequestBuffer.close();
                if (gameRequest != null) {
                    this.IJ.m6504a(new RequestReceivedCallback(this.IJ, this.Jm, gameRequest));
                }
            } catch (Throwable th) {
                gameRequestBuffer.close();
            }
        }

        public void onRequestRemoved(String requestId) {
            this.IJ.m6504a(new RequestRemovedCallback(this.IJ, this.Jm, requestId));
        }
    }

    final class RequestReceivedCallback extends C1624b {
        final /* synthetic */ GamesClientImpl IJ;
        private final GameRequest Jn;

        RequestReceivedCallback(GamesClientImpl gamesClientImpl, OnRequestReceivedListener listener, GameRequest request) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, listener);
            this.Jn = request;
        }

        protected /* synthetic */ void m6950a(Object obj) {
            m6951b((OnRequestReceivedListener) obj);
        }

        protected void m6951b(OnRequestReceivedListener onRequestReceivedListener) {
            onRequestReceivedListener.onRequestReceived(this.Jn);
        }

        protected void dx() {
        }
    }

    final class RequestRemovedCallback extends C1624b {
        final /* synthetic */ GamesClientImpl IJ;
        private final String Jo;

        RequestRemovedCallback(GamesClientImpl gamesClientImpl, OnRequestReceivedListener listener, String requestId) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, listener);
            this.Jo = requestId;
        }

        protected /* synthetic */ void m6952a(Object obj) {
            m6953b((OnRequestReceivedListener) obj);
        }

        protected void m6953b(OnRequestReceivedListener onRequestReceivedListener) {
            onRequestReceivedListener.onRequestRemoved(this.Jo);
        }

        protected void dx() {
        }
    }

    final class RequestSentBinderCallbacks extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl IJ;
        private final C1401d Jp;

        public RequestSentBinderCallbacks(GamesClientImpl gamesClientImpl, C1401d resultHolder) {
            this.IJ = gamesClientImpl;
            this.Jp = (C1401d) fq.m8517b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void m6954E(DataHolder dataHolder) {
            this.IJ.m6504a(new RequestSentCallback(this.IJ, this.Jp, dataHolder));
        }
    }

    final class RequestSentCallback extends ResultDataHolderCallback implements SendRequestResult {
        final /* synthetic */ GamesClientImpl IJ;
        private final GameRequest Jn;

        RequestSentCallback(GamesClientImpl gamesClientImpl, C1401d resultHolder, DataHolder dataHolder) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, resultHolder, dataHolder);
            GameRequestBuffer gameRequestBuffer = new GameRequestBuffer(dataHolder);
            try {
                if (gameRequestBuffer.getCount() > 0) {
                    this.Jn = (GameRequest) ((GameRequest) gameRequestBuffer.get(0)).freeze();
                } else {
                    this.Jn = null;
                }
                gameRequestBuffer.close();
            } catch (Throwable th) {
                gameRequestBuffer.close();
            }
        }

        protected void m6955a(C1401d c1401d, DataHolder dataHolder) {
            c1401d.m6049b(this);
        }
    }

    final class RequestSummariesLoadedBinderCallbacks extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl IJ;
        private final C1401d Jq;

        public RequestSummariesLoadedBinderCallbacks(GamesClientImpl gamesClientImpl, C1401d resultHolder) {
            this.IJ = gamesClientImpl;
            this.Jq = (C1401d) fq.m8517b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void m6957F(DataHolder dataHolder) {
            this.IJ.m6504a(new RequestSummariesLoadedCallback(this.IJ, this.Jq, dataHolder));
        }
    }

    final class RequestSummariesLoadedCallback extends ResultDataHolderCallback implements LoadRequestSummariesResult {
        final /* synthetic */ GamesClientImpl IJ;

        RequestSummariesLoadedCallback(GamesClientImpl gamesClientImpl, C1401d resultHolder, DataHolder dataHolder) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, resultHolder, dataHolder);
        }

        protected void m6958a(C1401d c1401d, DataHolder dataHolder) {
            c1401d.m6049b(this);
        }
    }

    final class RequestsLoadedBinderCallbacks extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl IJ;
        private final C1401d Jr;

        public RequestsLoadedBinderCallbacks(GamesClientImpl gamesClientImpl, C1401d resultHolder) {
            this.IJ = gamesClientImpl;
            this.Jr = (C1401d) fq.m8517b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void m6960b(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.IJ.m6504a(new RequestsLoadedCallback(this.IJ, this.Jr, new Status(i), bundle));
        }
    }

    final class RequestsLoadedCallback extends C1624b implements LoadRequestsResult {
        final /* synthetic */ GamesClientImpl IJ;
        private final Bundle Js;
        private final Status wJ;

        RequestsLoadedCallback(GamesClientImpl gamesClientImpl, C1401d resultHolder, Status status, Bundle requestData) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, resultHolder);
            this.wJ = status;
            this.Js = requestData;
        }

        protected /* synthetic */ void m6961a(Object obj) {
            m6962c((C1401d) obj);
        }

        protected void m6962c(C1401d c1401d) {
            c1401d.m6049b(this);
        }

        protected void dx() {
            release();
        }

        public GameRequestBuffer getRequests(int requestType) {
            String bd = RequestType.bd(requestType);
            return !this.Js.containsKey(bd) ? null : new GameRequestBuffer((DataHolder) this.Js.get(bd));
        }

        public Status getStatus() {
            return this.wJ;
        }

        public void release() {
            for (String parcelable : this.Js.keySet()) {
                DataHolder dataHolder = (DataHolder) this.Js.getParcelable(parcelable);
                if (dataHolder != null) {
                    dataHolder.close();
                }
            }
        }
    }

    final class RequestsUpdatedBinderCallbacks extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl IJ;
        private final C1401d Jt;

        public RequestsUpdatedBinderCallbacks(GamesClientImpl gamesClientImpl, C1401d resultHolder) {
            this.IJ = gamesClientImpl;
            this.Jt = (C1401d) fq.m8517b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void m6963D(DataHolder dataHolder) {
            this.IJ.m6504a(new RequestsUpdatedCallback(this.IJ, this.Jt, dataHolder));
        }
    }

    final class RequestsUpdatedCallback extends ResultDataHolderCallback implements UpdateRequestsResult {
        final /* synthetic */ GamesClientImpl IJ;
        private final RequestUpdateOutcomes Ju;

        RequestsUpdatedCallback(GamesClientImpl gamesClientImpl, C1401d resultHolder, DataHolder dataHolder) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, resultHolder, dataHolder);
            this.Ju = RequestUpdateOutcomes.m7719J(dataHolder);
        }

        protected void m6964a(C1401d c1401d, DataHolder dataHolder) {
            c1401d.m6049b(this);
        }

        public Set getRequestIds() {
            return this.Ju.getRequestIds();
        }

        public int getRequestOutcome(String requestId) {
            return this.Ju.getRequestOutcome(requestId);
        }
    }

    final class RoomAutoMatchingCallback extends AbstractRoomStatusCallback {
        final /* synthetic */ GamesClientImpl IJ;

        RoomAutoMatchingCallback(GamesClientImpl gamesClientImpl, RoomStatusUpdateListener listener, DataHolder dataHolder) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, listener, dataHolder);
        }

        public void m6966a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onRoomAutoMatching(room);
        }
    }

    final class RoomBinderCallbacks extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl IJ;
        private final RoomUpdateListener Jv;
        private final RoomStatusUpdateListener Jw;
        private final RealTimeMessageReceivedListener Jx;

        public RoomBinderCallbacks(GamesClientImpl gamesClientImpl, RoomUpdateListener roomCallbacks) {
            this.IJ = gamesClientImpl;
            this.Jv = (RoomUpdateListener) fq.m8517b((Object) roomCallbacks, (Object) "Callbacks must not be null");
            this.Jw = null;
            this.Jx = null;
        }

        public RoomBinderCallbacks(GamesClientImpl gamesClientImpl, RoomUpdateListener roomCallbacks, RoomStatusUpdateListener roomStatusCallbacks, RealTimeMessageReceivedListener realTimeMessageReceivedCallbacks) {
            this.IJ = gamesClientImpl;
            this.Jv = (RoomUpdateListener) fq.m8517b((Object) roomCallbacks, (Object) "Callbacks must not be null");
            this.Jw = roomStatusCallbacks;
            this.Jx = realTimeMessageReceivedCallbacks;
        }

        public void m6967a(DataHolder dataHolder, String[] strArr) {
            this.IJ.m6504a(new PeerInvitedToRoomCallback(this.IJ, this.Jw, dataHolder, strArr));
        }

        public void m6968b(DataHolder dataHolder, String[] strArr) {
            this.IJ.m6504a(new PeerJoinedRoomCallback(this.IJ, this.Jw, dataHolder, strArr));
        }

        public void m6969c(DataHolder dataHolder, String[] strArr) {
            this.IJ.m6504a(new PeerLeftRoomCallback(this.IJ, this.Jw, dataHolder, strArr));
        }

        public void m6970d(DataHolder dataHolder, String[] strArr) {
            this.IJ.m6504a(new PeerDeclinedCallback(this.IJ, this.Jw, dataHolder, strArr));
        }

        public void m6971e(DataHolder dataHolder, String[] strArr) {
            this.IJ.m6504a(new PeerConnectedCallback(this.IJ, this.Jw, dataHolder, strArr));
        }

        public void m6972f(DataHolder dataHolder, String[] strArr) {
            this.IJ.m6504a(new PeerDisconnectedCallback(this.IJ, this.Jw, dataHolder, strArr));
        }

        public void onLeftRoom(int statusCode, String externalRoomId) {
            this.IJ.m6504a(new LeftRoomCallback(this.IJ, this.Jv, statusCode, externalRoomId));
        }

        public void onP2PConnected(String participantId) {
            this.IJ.m6504a(new P2PConnectedCallback(this.IJ, this.Jw, participantId));
        }

        public void onP2PDisconnected(String participantId) {
            this.IJ.m6504a(new P2PDisconnectedCallback(this.IJ, this.Jw, participantId));
        }

        public void onRealTimeMessageReceived(RealTimeMessage message) {
            this.IJ.m6504a(new MessageReceivedCallback(this.IJ, this.Jx, message));
        }

        public void m6973s(DataHolder dataHolder) {
            this.IJ.m6504a(new RoomCreatedCallback(this.IJ, this.Jv, dataHolder));
        }

        public void m6974t(DataHolder dataHolder) {
            this.IJ.m6504a(new JoinedRoomCallback(this.IJ, this.Jv, dataHolder));
        }

        public void m6975u(DataHolder dataHolder) {
            this.IJ.m6504a(new RoomConnectingCallback(this.IJ, this.Jw, dataHolder));
        }

        public void m6976v(DataHolder dataHolder) {
            this.IJ.m6504a(new RoomAutoMatchingCallback(this.IJ, this.Jw, dataHolder));
        }

        public void m6977w(DataHolder dataHolder) {
            this.IJ.m6504a(new RoomConnectedCallback(this.IJ, this.Jv, dataHolder));
        }

        public void m6978x(DataHolder dataHolder) {
            this.IJ.m6504a(new ConnectedToRoomCallback(this.IJ, this.Jw, dataHolder));
        }

        public void m6979y(DataHolder dataHolder) {
            this.IJ.m6504a(new DisconnectedFromRoomCallback(this.IJ, this.Jw, dataHolder));
        }
    }

    final class RoomConnectedCallback extends AbstractRoomCallback {
        final /* synthetic */ GamesClientImpl IJ;

        RoomConnectedCallback(GamesClientImpl gamesClientImpl, RoomUpdateListener listener, DataHolder dataHolder) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, listener, dataHolder);
        }

        public void m6980a(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onRoomConnected(i, room);
        }
    }

    final class RoomConnectingCallback extends AbstractRoomStatusCallback {
        final /* synthetic */ GamesClientImpl IJ;

        RoomConnectingCallback(GamesClientImpl gamesClientImpl, RoomStatusUpdateListener listener, DataHolder dataHolder) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, listener, dataHolder);
        }

        public void m6981a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onRoomConnecting(room);
        }
    }

    final class RoomCreatedCallback extends AbstractRoomCallback {
        final /* synthetic */ GamesClientImpl IJ;

        public RoomCreatedCallback(GamesClientImpl gamesClientImpl, RoomUpdateListener listener, DataHolder dataHolder) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, listener, dataHolder);
        }

        public void m6982a(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onRoomCreated(i, room);
        }
    }

    final class SignOutCompleteBinderCallbacks extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl IJ;
        private final C1401d wH;

        public SignOutCompleteBinderCallbacks(GamesClientImpl gamesClientImpl, C1401d resultHolder) {
            this.IJ = gamesClientImpl;
            this.wH = (C1401d) fq.m8517b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void du() {
            this.IJ.m6504a(new SignOutCompleteCallback(this.IJ, this.wH, new Status(0)));
        }
    }

    final class SignOutCompleteCallback extends C1624b {
        final /* synthetic */ GamesClientImpl IJ;
        private final Status wJ;

        public SignOutCompleteCallback(GamesClientImpl gamesClientImpl, C1401d resultHolder, Status status) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, resultHolder);
            this.wJ = status;
        }

        public /* synthetic */ void m6983a(Object obj) {
            m6984c((C1401d) obj);
        }

        public void m6984c(C1401d c1401d) {
            c1401d.m6049b(this.wJ);
        }

        protected void dx() {
        }
    }

    final class SubmitScoreBinderCallbacks extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl IJ;
        private final C1401d wH;

        public SubmitScoreBinderCallbacks(GamesClientImpl gamesClientImpl, C1401d resultHolder) {
            this.IJ = gamesClientImpl;
            this.wH = (C1401d) fq.m8517b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void m6985d(DataHolder dataHolder) {
            this.IJ.m6504a(new SubmitScoreCallback(this.IJ, this.wH, dataHolder));
        }
    }

    final class SubmitScoreCallback extends ResultDataHolderCallback implements SubmitScoreResult {
        final /* synthetic */ GamesClientImpl IJ;
        private final ScoreSubmissionData Jy;

        public SubmitScoreCallback(GamesClientImpl gamesClientImpl, C1401d resultHolder, DataHolder dataHolder) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, resultHolder, dataHolder);
            try {
                this.Jy = new ScoreSubmissionData(dataHolder);
            } finally {
                dataHolder.close();
            }
        }

        public void m6986a(C1401d c1401d, DataHolder dataHolder) {
            c1401d.m6049b(this);
        }

        public ScoreSubmissionData getScoreData() {
            return this.Jy;
        }
    }

    abstract class TurnBasedMatchCallback extends ResultDataHolderCallback {
        final /* synthetic */ GamesClientImpl IJ;
        final TurnBasedMatch Jd;

        TurnBasedMatchCallback(GamesClientImpl gamesClientImpl, C1401d listener, DataHolder dataHolder) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, listener, dataHolder);
            TurnBasedMatchBuffer turnBasedMatchBuffer = new TurnBasedMatchBuffer(dataHolder);
            try {
                if (turnBasedMatchBuffer.getCount() > 0) {
                    this.Jd = (TurnBasedMatch) ((TurnBasedMatch) turnBasedMatchBuffer.get(0)).freeze();
                } else {
                    this.Jd = null;
                }
                turnBasedMatchBuffer.close();
            } catch (Throwable th) {
                turnBasedMatchBuffer.close();
            }
        }

        protected void m6988a(C1401d c1401d, DataHolder dataHolder) {
            m6990k(c1401d);
        }

        public TurnBasedMatch getMatch() {
            return this.Jd;
        }

        abstract void m6990k(C1401d c1401d);
    }

    final class TurnBasedMatchCanceledBinderCallbacks extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl IJ;
        private final C1401d Jz;

        public TurnBasedMatchCanceledBinderCallbacks(GamesClientImpl gamesClientImpl, C1401d resultHolder) {
            this.IJ = gamesClientImpl;
            this.Jz = (C1401d) fq.m8517b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void m6991f(int i, String str) {
            this.IJ.m6504a(new TurnBasedMatchCanceledCallback(this.IJ, this.Jz, new Status(i), str));
        }
    }

    final class TurnBasedMatchCanceledCallback extends C1624b implements CancelMatchResult {
        final /* synthetic */ GamesClientImpl IJ;
        private final String JA;
        private final Status wJ;

        TurnBasedMatchCanceledCallback(GamesClientImpl gamesClientImpl, C1401d resultHolder, Status status, String externalMatchId) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, resultHolder);
            this.wJ = status;
            this.JA = externalMatchId;
        }

        public /* synthetic */ void m6992a(Object obj) {
            m6993c((C1401d) obj);
        }

        public void m6993c(C1401d c1401d) {
            c1401d.m6049b(this);
        }

        protected void dx() {
        }

        public String getMatchId() {
            return this.JA;
        }

        public Status getStatus() {
            return this.wJ;
        }
    }

    final class TurnBasedMatchInitiatedBinderCallbacks extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl IJ;
        private final C1401d JB;

        public TurnBasedMatchInitiatedBinderCallbacks(GamesClientImpl gamesClientImpl, C1401d resultHolder) {
            this.IJ = gamesClientImpl;
            this.JB = (C1401d) fq.m8517b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void m6994o(DataHolder dataHolder) {
            this.IJ.m6504a(new TurnBasedMatchInitiatedCallback(this.IJ, this.JB, dataHolder));
        }
    }

    final class TurnBasedMatchInitiatedCallback extends TurnBasedMatchCallback implements InitiateMatchResult {
        final /* synthetic */ GamesClientImpl IJ;

        TurnBasedMatchInitiatedCallback(GamesClientImpl gamesClientImpl, C1401d resultHolder, DataHolder dataHolder) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, resultHolder, dataHolder);
        }

        protected void m6995k(C1401d c1401d) {
            c1401d.m6049b(this);
        }
    }

    final class TurnBasedMatchLeftBinderCallbacks extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl IJ;
        private final C1401d JC;

        public TurnBasedMatchLeftBinderCallbacks(GamesClientImpl gamesClientImpl, C1401d resultHolder) {
            this.IJ = gamesClientImpl;
            this.JC = (C1401d) fq.m8517b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void m6996q(DataHolder dataHolder) {
            this.IJ.m6504a(new TurnBasedMatchLeftCallback(this.IJ, this.JC, dataHolder));
        }
    }

    final class TurnBasedMatchLeftCallback extends TurnBasedMatchCallback implements LeaveMatchResult {
        final /* synthetic */ GamesClientImpl IJ;

        TurnBasedMatchLeftCallback(GamesClientImpl gamesClientImpl, C1401d resultHolder, DataHolder dataHolder) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, resultHolder, dataHolder);
        }

        protected void m6997k(C1401d c1401d) {
            c1401d.m6049b(this);
        }
    }

    final class TurnBasedMatchLoadedBinderCallbacks extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl IJ;
        private final C1401d JD;

        public TurnBasedMatchLoadedBinderCallbacks(GamesClientImpl gamesClientImpl, C1401d resultHolder) {
            this.IJ = gamesClientImpl;
            this.JD = (C1401d) fq.m8517b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void m6998n(DataHolder dataHolder) {
            this.IJ.m6504a(new TurnBasedMatchLoadedCallback(this.IJ, this.JD, dataHolder));
        }
    }

    final class TurnBasedMatchLoadedCallback extends TurnBasedMatchCallback implements LoadMatchResult {
        final /* synthetic */ GamesClientImpl IJ;

        TurnBasedMatchLoadedCallback(GamesClientImpl gamesClientImpl, C1401d resultHolder, DataHolder dataHolder) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, resultHolder, dataHolder);
        }

        protected void m6999k(C1401d c1401d) {
            c1401d.m6049b(this);
        }
    }

    final class TurnBasedMatchUpdatedBinderCallbacks extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl IJ;
        private final C1401d JE;

        public TurnBasedMatchUpdatedBinderCallbacks(GamesClientImpl gamesClientImpl, C1401d resultHolder) {
            this.IJ = gamesClientImpl;
            this.JE = (C1401d) fq.m8517b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void m7000p(DataHolder dataHolder) {
            this.IJ.m6504a(new TurnBasedMatchUpdatedCallback(this.IJ, this.JE, dataHolder));
        }
    }

    final class TurnBasedMatchUpdatedCallback extends TurnBasedMatchCallback implements UpdateMatchResult {
        final /* synthetic */ GamesClientImpl IJ;

        TurnBasedMatchUpdatedCallback(GamesClientImpl gamesClientImpl, C1401d resultHolder, DataHolder dataHolder) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, resultHolder, dataHolder);
        }

        protected void m7001k(C1401d c1401d) {
            c1401d.m6049b(this);
        }
    }

    final class TurnBasedMatchesLoadedBinderCallbacks extends AbstractGamesCallbacks {
        final /* synthetic */ GamesClientImpl IJ;
        private final C1401d JF;

        public TurnBasedMatchesLoadedBinderCallbacks(GamesClientImpl gamesClientImpl, C1401d resultHolder) {
            this.IJ = gamesClientImpl;
            this.JF = (C1401d) fq.m8517b((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void m7002a(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.IJ.m6504a(new TurnBasedMatchesLoadedCallback(this.IJ, this.JF, new Status(i), bundle));
        }
    }

    final class TurnBasedMatchesLoadedCallback extends C1624b implements LoadMatchesResult {
        final /* synthetic */ GamesClientImpl IJ;
        private final LoadMatchesResponse JG;
        private final Status wJ;

        TurnBasedMatchesLoadedCallback(GamesClientImpl gamesClientImpl, C1401d resultHolder, Status status, Bundle matchData) {
            this.IJ = gamesClientImpl;
            super(gamesClientImpl, resultHolder);
            this.wJ = status;
            this.JG = new LoadMatchesResponse(matchData);
        }

        protected /* synthetic */ void m7003a(Object obj) {
            m7004c((C1401d) obj);
        }

        protected void m7004c(C1401d c1401d) {
            c1401d.m6049b(this);
        }

        protected void dx() {
        }

        public LoadMatchesResponse getMatches() {
            return this.JG;
        }

        public Status getStatus() {
            return this.wJ;
        }

        public void release() {
            this.JG.close();
        }
    }

    public GamesClientImpl(Context context, Looper looper, String gamePackageName, String accountName, ConnectionCallbacks connectedListener, OnConnectionFailedListener connectionFailedListener, String[] scopes, int gravity, View gamesContentView, boolean isHeadless, boolean showConnectingPopup, int connectingPopupGravity, boolean retryingSignIn, int sdkVariant) {
        super(context, looper, connectedListener, connectionFailedListener, scopes);
        this.Iz = false;
        this.IA = false;
        this.Iu = gamePackageName;
        this.wG = (String) fq.m8520f(accountName);
        this.IC = new Binder();
        this.Iv = new HashMap();
        this.Iy = PopupManager.m7455a(this, gravity);
        m7080f(gamesContentView);
        this.IA = showConnectingPopup;
        this.IB = connectingPopupGravity;
        this.IE = (long) hashCode();
        this.IF = isHeadless;
        this.IH = retryingSignIn;
        this.IG = sdkVariant;
        registerConnectionCallbacks((ConnectionCallbacks) this);
        registerConnectionFailedListener((OnConnectionFailedListener) this);
    }

    private Room m7005G(DataHolder dataHolder) {
        RoomBuffer roomBuffer = new RoomBuffer(dataHolder);
        Room room = null;
        try {
            if (roomBuffer.getCount() > 0) {
                room = (Room) ((Room) roomBuffer.get(0)).freeze();
            }
            roomBuffer.close();
            return room;
        } catch (Throwable th) {
            roomBuffer.close();
        }
    }

    private RealTimeSocket aC(String str) {
        try {
            ParcelFileDescriptor aJ = ((IGamesService) eM()).aJ(str);
            RealTimeSocket libjingleNativeSocket;
            if (aJ != null) {
                GamesLog.m7099f("GamesClientImpl", "Created native libjingle socket.");
                libjingleNativeSocket = new LibjingleNativeSocket(aJ);
                this.Iv.put(str, libjingleNativeSocket);
                return libjingleNativeSocket;
            }
            GamesLog.m7099f("GamesClientImpl", "Unable to create native libjingle socket, resorting to old socket.");
            String aE = ((IGamesService) eM()).aE(str);
            if (aE == null) {
                return null;
            }
            LocalSocket localSocket = new LocalSocket();
            try {
                localSocket.connect(new LocalSocketAddress(aE));
                libjingleNativeSocket = new RealTimeSocketImpl(localSocket, str);
                this.Iv.put(str, libjingleNativeSocket);
                return libjingleNativeSocket;
            } catch (IOException e) {
                GamesLog.m7101h("GamesClientImpl", "connect() call failed on socket: " + e.getMessage());
                return null;
            }
        } catch (RemoteException e2) {
            GamesLog.m7101h("GamesClientImpl", "Unable to create socket. Service died.");
            return null;
        }
    }

    private void gE() {
        for (RealTimeSocket close : this.Iv.values()) {
            try {
                close.close();
            } catch (Throwable e) {
                GamesLog.m7098a("GamesClientImpl", "IOException:", e);
            }
        }
        this.Iv.clear();
    }

    private void gk() {
        this.Iw = null;
    }

    protected IGamesService m7007L(IBinder iBinder) {
        return Stub.m7386N(iBinder);
    }

    public int m7008a(ReliableMessageSentCallback reliableMessageSentCallback, byte[] bArr, String str, String str2) {
        try {
            return ((IGamesService) eM()).m7149a(new RealTimeReliableMessageBinderCallbacks(this, reliableMessageSentCallback), bArr, str, str2);
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
            return -1;
        }
    }

    public int m7009a(byte[] bArr, String str, String[] strArr) {
        fq.m8517b((Object) strArr, (Object) "Participant IDs must not be null");
        try {
            return ((IGamesService) eM()).m7197b(bArr, str, strArr);
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
            return -1;
        }
    }

    public Intent m7010a(int i, int i2, boolean z) {
        try {
            return ((IGamesService) eM()).m7150a(i, i2, z);
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
            return null;
        }
    }

    public Intent m7011a(int i, byte[] bArr, int i2, Bitmap bitmap, String str) {
        try {
            Intent a = ((IGamesService) eM()).m7151a(i, bArr, i2, str);
            fq.m8517b((Object) bitmap, (Object) "Must provide a non null icon");
            a.putExtra("com.google.android.gms.games.REQUEST_ITEM_ICON", bitmap);
            return a;
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
            return null;
        }
    }

    public Intent m7012a(Room room, int i) {
        try {
            return ((IGamesService) eM()).m7154a((RoomEntity) room.freeze(), i);
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
            return null;
        }
    }

    protected void m7013a(int i, IBinder iBinder, Bundle bundle) {
        if (i == 0 && bundle != null) {
            this.Iz = bundle.getBoolean("show_welcome_popup");
        }
        super.m6503a(i, iBinder, bundle);
    }

    public void m7014a(IBinder iBinder, Bundle bundle) {
        if (isConnected()) {
            try {
                ((IGamesService) eM()).m7157a(iBinder, bundle);
            } catch (RemoteException e) {
                GamesLog.m7100g("GamesClientImpl", "service died");
            }
        }
    }

    public void m7015a(C1401d c1401d, int i, int i2, int i3) {
        try {
            ((IGamesService) eM()).m7160a(new RequestsLoadedBinderCallbacks(this, c1401d), i, i2, i3);
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    public void m7016a(C1401d c1401d, int i, int i2, boolean z, boolean z2) {
        try {
            ((IGamesService) eM()).m7161a(new ExtendedGamesLoadedBinderCallback(this, c1401d), i, i2, z, z2);
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    public void m7017a(C1401d c1401d, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) eM()).m7163a(new PlayersLoadedBinderCallback(this, c1401d), i, z, z2);
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    public void m7018a(C1401d c1401d, int i, int[] iArr) {
        try {
            ((IGamesService) eM()).m7164a(new TurnBasedMatchesLoadedBinderCallbacks(this, c1401d), i, iArr);
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    public void m7019a(C1401d c1401d, LeaderboardScoreBuffer leaderboardScoreBuffer, int i, int i2) {
        try {
            ((IGamesService) eM()).m7167a(new LeaderboardScoresLoadedBinderCallback(this, c1401d), leaderboardScoreBuffer.hD().hE(), i, i2);
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    public void m7020a(C1401d c1401d, TurnBasedMatchConfig turnBasedMatchConfig) {
        try {
            ((IGamesService) eM()).m7162a(new TurnBasedMatchInitiatedBinderCallbacks(this, c1401d), turnBasedMatchConfig.getVariant(), turnBasedMatchConfig.getMinPlayers(), turnBasedMatchConfig.getInvitedPlayerIds(), turnBasedMatchConfig.getAutoMatchCriteria());
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    public void m7021a(C1401d c1401d, String str) {
        try {
            ((IGamesService) eM()).m7170a(new PlayersLoadedBinderCallback(this, c1401d), str);
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    public void m7022a(C1401d c1401d, String str, int i) {
        try {
            ((IGamesService) eM()).m7173a(c1401d == null ? null : new AchievementUpdatedBinderCallback(this, c1401d), str, i, this.Iy.gU(), this.Iy.gT());
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    public void m7023a(C1401d c1401d, String str, int i, int i2, int i3, boolean z) {
        try {
            ((IGamesService) eM()).m7172a(new LeaderboardScoresLoadedBinderCallback(this, c1401d), str, i, i2, i3, z);
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    public void m7024a(C1401d c1401d, String str, int i, boolean z) {
        try {
            ((IGamesService) eM()).m7174a(new PlayersLoadedBinderCallback(this, c1401d), str, i, z);
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    public void m7025a(C1401d c1401d, String str, int i, boolean z, boolean z2) {
        if (str.equals("playedWith")) {
            try {
                ((IGamesService) eM()).m7232d(new PlayersLoadedBinderCallback(this, c1401d), str, i, z, z2);
                return;
            } catch (RemoteException e) {
                GamesLog.m7100g("GamesClientImpl", "service died");
                return;
            }
        }
        throw new IllegalArgumentException("Invalid player collection: " + str);
    }

    public void m7026a(C1401d c1401d, String str, int i, boolean z, boolean z2, boolean z3, boolean z4) {
        try {
            ((IGamesService) eM()).m7176a(new ExtendedGamesLoadedBinderCallback(this, c1401d), str, i, z, z2, z3, z4);
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    public void m7027a(C1401d c1401d, String str, int i, int[] iArr) {
        try {
            ((IGamesService) eM()).m7177a(new TurnBasedMatchesLoadedBinderCallbacks(this, c1401d), str, i, iArr);
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    public void m7028a(C1401d c1401d, String str, long j, String str2) {
        try {
            ((IGamesService) eM()).m7179a(c1401d == null ? null : new SubmitScoreBinderCallbacks(this, c1401d), str, j, str2);
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    public void m7029a(C1401d c1401d, String str, String str2) {
        try {
            ((IGamesService) eM()).m7224c(new TurnBasedMatchLeftBinderCallbacks(this, c1401d), str, str2);
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    public void m7030a(C1401d c1401d, String str, String str2, int i, int i2) {
        try {
            ((IGamesService) eM()).m7182a(new PlayerLeaderboardScoreLoadedBinderCallback(this, c1401d), str, str2, i, i2);
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    public void m7031a(C1401d c1401d, String str, String str2, int i, int i2, int i3) {
        try {
            ((IGamesService) eM()).m7183a(new RequestsLoadedBinderCallbacks(this, c1401d), str, str2, i, i2, i3);
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    public void m7032a(C1401d c1401d, String str, String str2, int i, int i2, int i3, boolean z) {
        try {
            ((IGamesService) eM()).m7184a(new LeaderboardScoresLoadedBinderCallback(this, c1401d), str, str2, i, i2, i3, z);
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    public void m7033a(C1401d c1401d, String str, String str2, int i, boolean z, boolean z2) {
        if (str.equals("playedWith") || str.equals("circled")) {
            try {
                ((IGamesService) eM()).m7185a(new PlayersLoadedBinderCallback(this, c1401d), str, str2, i, z, z2);
                return;
            } catch (RemoteException e) {
                GamesLog.m7100g("GamesClientImpl", "service died");
                return;
            }
        }
        throw new IllegalArgumentException("Invalid player collection: " + str);
    }

    public void m7034a(C1401d c1401d, String str, String str2, boolean z) {
        try {
            ((IGamesService) eM()).m7212b(new LeaderboardsLoadedBinderCallback(this, c1401d), str, str2, z);
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    public void m7035a(C1401d c1401d, String str, String str2, String[] strArr) {
        try {
            ((IGamesService) eM()).m7187a(new RequestsUpdatedBinderCallbacks(this, c1401d), str, str2, strArr);
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    public void m7036a(C1401d c1401d, String str, boolean z) {
        try {
            ((IGamesService) eM()).m7225c(new LeaderboardsLoadedBinderCallback(this, c1401d), str, z);
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    public void m7037a(C1401d c1401d, String str, byte[] bArr, String str2, ParticipantResult[] participantResultArr) {
        try {
            ((IGamesService) eM()).m7189a(new TurnBasedMatchUpdatedBinderCallbacks(this, c1401d), str, bArr, str2, participantResultArr);
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    public void m7038a(C1401d c1401d, String str, byte[] bArr, ParticipantResult[] participantResultArr) {
        try {
            ((IGamesService) eM()).m7190a(new TurnBasedMatchUpdatedBinderCallbacks(this, c1401d), str, bArr, participantResultArr);
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    public void m7039a(C1401d c1401d, String str, String[] strArr, int i, byte[] bArr, int i2) {
        try {
            ((IGamesService) eM()).m7192a(new RequestSentBinderCallbacks(this, c1401d), str, strArr, i, bArr, i2);
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    public void m7040a(C1401d c1401d, boolean z) {
        try {
            ((IGamesService) eM()).m7226c(new PlayersLoadedBinderCallback(this, c1401d), z);
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    public void m7041a(C1401d c1401d, boolean z, Bundle bundle) {
        try {
            ((IGamesService) eM()).m7194a(new ContactSettingsUpdatedBinderCallback(this, c1401d), z, bundle);
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    public void m7042a(C1401d c1401d, String[] strArr) {
        try {
            ((IGamesService) eM()).m7227c(new PlayersLoadedBinderCallback(this, c1401d), strArr);
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    public void m7043a(OnInvitationReceivedListener onInvitationReceivedListener) {
        try {
            ((IGamesService) eM()).m7165a(new InvitationReceivedBinderCallback(this, onInvitationReceivedListener), this.IE);
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    public void m7044a(RoomConfig roomConfig) {
        try {
            ((IGamesService) eM()).m7168a(new RoomBinderCallbacks(this, roomConfig.getRoomUpdateListener(), roomConfig.getRoomStatusUpdateListener(), roomConfig.getMessageReceivedListener()), this.IC, roomConfig.getVariant(), roomConfig.getInvitedPlayerIds(), roomConfig.getAutoMatchCriteria(), roomConfig.isSocketEnabled(), this.IE);
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    public void m7045a(RoomUpdateListener roomUpdateListener, String str) {
        try {
            ((IGamesService) eM()).m7222c(new RoomBinderCallbacks(this, roomUpdateListener), str);
            gE();
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    public void m7046a(OnTurnBasedMatchUpdateReceivedListener onTurnBasedMatchUpdateReceivedListener) {
        try {
            ((IGamesService) eM()).m7202b(new MatchUpdateReceivedBinderCallback(this, onTurnBasedMatchUpdateReceivedListener), this.IE);
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    public void m7047a(OnRequestReceivedListener onRequestReceivedListener) {
        try {
            ((IGamesService) eM()).m7220c(new RequestReceivedBinderCallback(this, onRequestReceivedListener), this.IE);
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    protected void m7048a(fm fmVar, C1893e c1893e) {
        String locale = getContext().getResources().getConfiguration().locale.toString();
        Bundle bundle = new Bundle();
        bundle.putBoolean("com.google.android.gms.games.key.isHeadless", this.IF);
        bundle.putBoolean("com.google.android.gms.games.key.showConnectingPopup", this.IA);
        bundle.putInt("com.google.android.gms.games.key.connectingPopupGravity", this.IB);
        bundle.putBoolean("com.google.android.gms.games.key.retryingSignIn", this.IH);
        bundle.putInt("com.google.android.gms.games.key.sdkVariant", this.IG);
        fmVar.m8456a(c1893e, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName(), this.wG, eL(), this.Iu, this.Iy.gU(), locale, bundle);
    }

    public Intent aA(String str) {
        try {
            return ((IGamesService) eM()).aA(str);
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
            return null;
        }
    }

    public void aB(String str) {
        try {
            ((IGamesService) eM()).aI(str);
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    public void aX(int i) {
        this.Iy.setGravity(i);
    }

    public void aY(int i) {
        try {
            ((IGamesService) eM()).aY(i);
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    public Intent m7049b(int i, int i2, boolean z) {
        try {
            return ((IGamesService) eM()).m7198b(i, i2, z);
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
            return null;
        }
    }

    public void m7050b(C1401d c1401d) {
        try {
            ((IGamesService) eM()).m7158a(new SignOutCompleteBinderCallbacks(this, c1401d));
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    public void m7051b(C1401d c1401d, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) eM()).m7201b(new PlayersLoadedBinderCallback(this, c1401d), i, z, z2);
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    public void m7052b(C1401d c1401d, String str) {
        if (c1401d == null) {
            IGamesCallbacks iGamesCallbacks = null;
        } else {
            Object achievementUpdatedBinderCallback = new AchievementUpdatedBinderCallback(this, c1401d);
        }
        try {
            ((IGamesService) eM()).m7180a(iGamesCallbacks, str, this.Iy.gU(), this.Iy.gT());
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    public void m7053b(C1401d c1401d, String str, int i) {
        try {
            ((IGamesService) eM()).m7206b(c1401d == null ? null : new AchievementUpdatedBinderCallback(this, c1401d), str, i, this.Iy.gU(), this.Iy.gT());
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    public void m7054b(C1401d c1401d, String str, int i, int i2, int i3, boolean z) {
        try {
            ((IGamesService) eM()).m7205b(new LeaderboardScoresLoadedBinderCallback(this, c1401d), str, i, i2, i3, z);
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    public void m7055b(C1401d c1401d, String str, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) eM()).m7175a(new ExtendedGamesLoadedBinderCallback(this, c1401d), str, i, z, z2);
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    public void m7056b(C1401d c1401d, String str, String str2) {
        try {
            ((IGamesService) eM()).m7233d(new TurnBasedMatchInitiatedBinderCallbacks(this, c1401d), str, str2);
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    public void m7057b(C1401d c1401d, String str, String str2, int i, int i2, int i3, boolean z) {
        try {
            ((IGamesService) eM()).m7211b(new LeaderboardScoresLoadedBinderCallback(this, c1401d), str, str2, i, i2, i3, z);
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    public void m7058b(C1401d c1401d, String str, String str2, boolean z) {
        try {
            ((IGamesService) eM()).m7186a(new AchievementsLoadedBinderCallback(this, c1401d), str, str2, z);
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    public void m7059b(C1401d c1401d, String str, boolean z) {
        try {
            ((IGamesService) eM()).m7234d(new LeaderboardsLoadedBinderCallback(this, c1401d), str, z);
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    public void m7060b(C1401d c1401d, boolean z) {
        try {
            ((IGamesService) eM()).m7214b(new LeaderboardsLoadedBinderCallback(this, c1401d), z);
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    public void m7061b(C1401d c1401d, String[] strArr) {
        try {
            ((IGamesService) eM()).m7196a(new RequestsUpdatedBinderCallbacks(this, c1401d), strArr);
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    public void m7062b(RoomConfig roomConfig) {
        try {
            ((IGamesService) eM()).m7169a(new RoomBinderCallbacks(this, roomConfig.getRoomUpdateListener(), roomConfig.getRoomStatusUpdateListener(), roomConfig.getMessageReceivedListener()), this.IC, roomConfig.getInvitationId(), roomConfig.isSocketEnabled(), this.IE);
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    protected void m7063b(String... strArr) {
        int i = 0;
        boolean z = false;
        for (String str : strArr) {
            if (str.equals(Scopes.GAMES)) {
                z = true;
            } else if (str.equals("https://www.googleapis.com/auth/games.firstparty")) {
                i = 1;
            }
        }
        if (i != 0) {
            fq.m8515a(!z, String.format("Cannot have both %s and %s!", new Object[]{Scopes.GAMES, "https://www.googleapis.com/auth/games.firstparty"}));
            return;
        }
        fq.m8515a(z, String.format("Games APIs requires %s to function.", new Object[]{Scopes.GAMES}));
    }

    protected String bg() {
        return "com.google.android.gms.games.service.START";
    }

    protected String bh() {
        return "com.google.android.gms.games.internal.IGamesService";
    }

    public void m7064c(C1401d c1401d, int i) {
        try {
            ((IGamesService) eM()).m7159a(new InvitationsLoadedBinderCallback(this, c1401d), i);
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    public void m7065c(C1401d c1401d, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) eM()).m7219c(new PlayersLoadedBinderCallback(this, c1401d), i, z, z2);
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    public void m7066c(C1401d c1401d, String str) {
        if (c1401d == null) {
            IGamesCallbacks iGamesCallbacks = null;
        } else {
            Object achievementUpdatedBinderCallback = new AchievementUpdatedBinderCallback(this, c1401d);
        }
        try {
            ((IGamesService) eM()).m7209b(iGamesCallbacks, str, this.Iy.gU(), this.Iy.gT());
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    public void m7067c(C1401d c1401d, String str, int i) {
        try {
            ((IGamesService) eM()).m7207b(new InvitationsLoadedBinderCallback(this, c1401d), str, i, false);
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    public void m7068c(C1401d c1401d, String str, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) eM()).m7223c(new ExtendedGamesLoadedBinderCallback(this, c1401d), str, i, z, z2);
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    public void m7069c(C1401d c1401d, String str, String str2) {
        try {
            ((IGamesService) eM()).m7238e(new TurnBasedMatchInitiatedBinderCallbacks(this, c1401d), str, str2);
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    public void m7070c(C1401d c1401d, String str, boolean z) {
        try {
            ((IGamesService) eM()).m7188a(new GameMuteStatusChangedBinderCallback(this, c1401d), str, z);
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    public void m7071c(C1401d c1401d, boolean z) {
        try {
            ((IGamesService) eM()).m7193a(new AchievementsLoadedBinderCallback(this, c1401d), z);
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    public void m7072c(C1401d c1401d, String[] strArr) {
        try {
            ((IGamesService) eM()).m7215b(new RequestsUpdatedBinderCallbacks(this, c1401d), strArr);
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    public void connect() {
        gk();
        super.connect();
    }

    public int m7073d(byte[] bArr, String str) {
        try {
            return ((IGamesService) eM()).m7197b(bArr, str, null);
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
            return -1;
        }
    }

    public void m7074d(C1401d c1401d, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) eM()).m7236e(new PlayersLoadedBinderCallback(this, c1401d), i, z, z2);
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    public void m7075d(C1401d c1401d, String str) {
        try {
            ((IGamesService) eM()).m7253l(new TurnBasedMatchInitiatedBinderCallbacks(this, c1401d), str);
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    public void m7076d(C1401d c1401d, String str, int i) {
        try {
            ((IGamesService) eM()).m7171a(new RequestSummariesLoadedBinderCallbacks(this, c1401d), str, i);
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    public void m7077d(C1401d c1401d, String str, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) eM()).m7208b(new PlayersLoadedBinderCallback(this, c1401d), str, i, z, z2);
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    public Bundle dG() {
        try {
            Bundle dG = ((IGamesService) eM()).dG();
            if (dG == null) {
                return dG;
            }
            dG.setClassLoader(GamesClientImpl.class.getClassLoader());
            return dG;
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
            return null;
        }
    }

    public void disconnect() {
        this.Iz = false;
        if (isConnected()) {
            try {
                IGamesService iGamesService = (IGamesService) eM();
                iGamesService.gF();
                iGamesService.m7259o(this.IE);
            } catch (RemoteException e) {
                GamesLog.m7100g("GamesClientImpl", "Failed to notify client disconnect.");
            }
        }
        gE();
        super.disconnect();
    }

    public void m7078e(C1401d c1401d, int i, boolean z, boolean z2) {
        try {
            ((IGamesService) eM()).m7230d(new ExtendedPlayersLoadedBinderCallback(this, c1401d), i, z, z2);
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    public void m7079e(C1401d c1401d, String str) {
        try {
            ((IGamesService) eM()).m7255m(new TurnBasedMatchInitiatedBinderCallbacks(this, c1401d), str);
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    public void m7080f(View view) {
        this.Iy.m7456g(view);
    }

    public void m7081f(C1401d c1401d, String str) {
        try {
            ((IGamesService) eM()).m7260o(new TurnBasedMatchLeftBinderCallbacks(this, c1401d), str);
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    public void m7082g(C1401d c1401d) {
        try {
            ((IGamesService) eM()).m7229d(new GamesLoadedBinderCallback(this, c1401d));
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    public void m7083g(C1401d c1401d, String str) {
        try {
            ((IGamesService) eM()).m7257n(new TurnBasedMatchCanceledBinderCallbacks(this, c1401d), str);
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    public int gA() {
        try {
            return ((IGamesService) eM()).gA();
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
            return 2;
        }
    }

    public Intent gB() {
        try {
            return ((IGamesService) eM()).gB();
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
            return null;
        }
    }

    public int gC() {
        try {
            return ((IGamesService) eM()).gC();
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
            return 2;
        }
    }

    public int gD() {
        try {
            return ((IGamesService) eM()).gD();
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
            return 2;
        }
    }

    public void gF() {
        if (isConnected()) {
            try {
                ((IGamesService) eM()).gF();
            } catch (RemoteException e) {
                GamesLog.m7100g("GamesClientImpl", "service died");
            }
        }
    }

    public String gl() {
        try {
            return ((IGamesService) eM()).gl();
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
            return null;
        }
    }

    public String gm() {
        try {
            return ((IGamesService) eM()).gm();
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
            return null;
        }
    }

    public Player gn() {
        bT();
        synchronized (this) {
            if (this.Iw == null) {
                PlayerBuffer playerBuffer;
                try {
                    playerBuffer = new PlayerBuffer(((IGamesService) eM()).gG());
                    if (playerBuffer.getCount() > 0) {
                        this.Iw = (PlayerEntity) playerBuffer.get(0).freeze();
                    }
                    playerBuffer.close();
                } catch (RemoteException e) {
                    GamesLog.m7100g("GamesClientImpl", "service died");
                } catch (Throwable th) {
                    playerBuffer.close();
                }
            }
        }
        return this.Iw;
    }

    public Game go() {
        GameBuffer gameBuffer;
        bT();
        synchronized (this) {
            if (this.Ix == null) {
                try {
                    gameBuffer = new GameBuffer(((IGamesService) eM()).gI());
                    if (gameBuffer.getCount() > 0) {
                        this.Ix = (GameEntity) gameBuffer.get(0).freeze();
                    }
                    gameBuffer.close();
                } catch (RemoteException e) {
                    GamesLog.m7100g("GamesClientImpl", "service died");
                } catch (Throwable th) {
                    gameBuffer.close();
                }
            }
        }
        return this.Ix;
    }

    public Intent gp() {
        try {
            return ((IGamesService) eM()).gp();
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
            return null;
        }
    }

    public Intent gq() {
        try {
            return ((IGamesService) eM()).gq();
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
            return null;
        }
    }

    public Intent gr() {
        try {
            return ((IGamesService) eM()).gr();
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
            return null;
        }
    }

    public Intent gs() {
        try {
            return ((IGamesService) eM()).gs();
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
            return null;
        }
    }

    public void gt() {
        try {
            ((IGamesService) eM()).m7262p(this.IE);
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    public void gu() {
        try {
            ((IGamesService) eM()).m7264q(this.IE);
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    public void gv() {
        try {
            ((IGamesService) eM()).m7266r(this.IE);
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    public Intent gw() {
        try {
            return ((IGamesService) eM()).gw();
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
            return null;
        }
    }

    public Intent gx() {
        try {
            return ((IGamesService) eM()).gx();
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
            return null;
        }
    }

    public int gy() {
        try {
            return ((IGamesService) eM()).gy();
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
            return 4368;
        }
    }

    public String gz() {
        try {
            return ((IGamesService) eM()).gz();
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
            return null;
        }
    }

    public void m7084h(C1401d c1401d) {
        try {
            ((IGamesService) eM()).m7248j(new OwnerCoverPhotoUrisLoadedBinderCallback(this, c1401d));
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    public void m7085h(C1401d c1401d, String str) {
        try {
            ((IGamesService) eM()).m7263p(new TurnBasedMatchLoadedBinderCallbacks(this, c1401d), str);
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    public RealTimeSocket m7086i(String str, String str2) {
        if (str2 == null || !ParticipantUtils.aV(str2)) {
            throw new IllegalArgumentException("Bad participant ID");
        }
        RealTimeSocket realTimeSocket = (RealTimeSocket) this.Iv.get(str2);
        return (realTimeSocket == null || realTimeSocket.isClosed()) ? aC(str2) : realTimeSocket;
    }

    public void m7087i(C1401d c1401d) {
        try {
            ((IGamesService) eM()).m7245h(new NotifyAclLoadedBinderCallback(this, c1401d));
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    public void m7088i(C1401d c1401d, String str) {
        try {
            ((IGamesService) eM()).m7237e(new ExtendedGamesLoadedBinderCallback(this, c1401d), str);
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    public void m7089j(C1401d c1401d) {
        try {
            ((IGamesService) eM()).m7246i(new ContactSettingsLoadedBinderCallback(this, c1401d));
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    public void m7090j(C1401d c1401d, String str) {
        try {
            ((IGamesService) eM()).m7241f(new GameInstancesLoadedBinderCallback(this, c1401d), str);
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    public void m7091k(C1401d c1401d, String str) {
        try {
            ((IGamesService) eM()).m7265q(new GameSearchSuggestionsLoadedBinderCallback(this, c1401d), str);
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    public void m7092l(C1401d c1401d, String str) {
        try {
            ((IGamesService) eM()).m7251k(new InvitationsLoadedBinderCallback(this, c1401d), str);
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    public void m7093l(String str, int i) {
        try {
            ((IGamesService) eM()).m7254l(str, i);
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    public void m7094m(C1401d c1401d, String str) {
        try {
            ((IGamesService) eM()).m7249j(new NotifyAclUpdatedBinderCallback(this, c1401d), str);
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    public void m7095m(String str, int i) {
        try {
            ((IGamesService) eM()).m7256m(str, i);
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    public void m7096n(C1401d c1401d, String str) {
        try {
            ((IGamesService) eM()).m7247i(new GameMuteStatusLoadedBinderCallback(this, c1401d), str);
        } catch (RemoteException e) {
            GamesLog.m7100g("GamesClientImpl", "service died");
        }
    }

    public void onConnected(Bundle connectionHint) {
        if (this.Iz) {
            this.Iy.gS();
            this.Iz = false;
        }
    }

    public void onConnectionFailed(ConnectionResult result) {
        this.Iz = false;
    }

    public void onConnectionSuspended(int cause) {
    }

    protected /* synthetic */ IInterface m7097r(IBinder iBinder) {
        return m7007L(iBinder);
    }
}
