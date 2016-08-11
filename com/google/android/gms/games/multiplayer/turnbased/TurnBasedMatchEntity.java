package com.google.android.gms.games.multiplayer.turnbased;

import android.database.CharArrayBuffer;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.multiplayer.Multiplayer;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.internal.fo;
import com.google.android.gms.internal.gm;
import java.util.ArrayList;

public final class TurnBasedMatchEntity implements SafeParcelable, TurnBasedMatch {
    public static final TurnBasedMatchEntityCreator CREATOR;
    private final String HD;
    private final String Jb;
    private final GameEntity Lt;
    private final Bundle MO;
    private final String MS;
    private final long Mu;
    private final ArrayList Mx;
    private final int My;
    private final String Na;
    private final long Nb;
    private final String Nc;
    private final int Nd;
    private final int Ne;
    private final byte[] Nf;
    private final String Ng;
    private final byte[] Nh;
    private final int Ni;
    private final int Nj;
    private final boolean Nk;
    private final String Nl;
    private final int xH;

    static {
        CREATOR = new TurnBasedMatchEntityCreator();
    }

    TurnBasedMatchEntity(int versionCode, GameEntity game, String matchId, String creatorId, long creationTimestamp, String lastUpdaterId, long lastUpdatedTimestamp, String pendingParticipantId, int matchStatus, int variant, int version, byte[] data, ArrayList participants, String rematchId, byte[] previousData, int matchNumber, Bundle autoMatchCriteria, int turnStatus, boolean isLocallyModified, String description, String descriptionParticipantId) {
        this.xH = versionCode;
        this.Lt = game;
        this.Jb = matchId;
        this.MS = creatorId;
        this.Mu = creationTimestamp;
        this.Na = lastUpdaterId;
        this.Nb = lastUpdatedTimestamp;
        this.Nc = pendingParticipantId;
        this.Nd = matchStatus;
        this.Nj = turnStatus;
        this.My = variant;
        this.Ne = version;
        this.Nf = data;
        this.Mx = participants;
        this.Ng = rematchId;
        this.Nh = previousData;
        this.Ni = matchNumber;
        this.MO = autoMatchCriteria;
        this.Nk = isLocallyModified;
        this.HD = description;
        this.Nl = descriptionParticipantId;
    }

    public TurnBasedMatchEntity(TurnBasedMatch match) {
        this.xH = 2;
        this.Lt = new GameEntity(match.getGame());
        this.Jb = match.getMatchId();
        this.MS = match.getCreatorId();
        this.Mu = match.getCreationTimestamp();
        this.Na = match.getLastUpdaterId();
        this.Nb = match.getLastUpdatedTimestamp();
        this.Nc = match.getPendingParticipantId();
        this.Nd = match.getStatus();
        this.Nj = match.getTurnStatus();
        this.My = match.getVariant();
        this.Ne = match.getVersion();
        this.Ng = match.getRematchId();
        this.Ni = match.getMatchNumber();
        this.MO = match.getAutoMatchCriteria();
        this.Nk = match.isLocallyModified();
        this.HD = match.getDescription();
        this.Nl = match.getDescriptionParticipantId();
        Object data = match.getData();
        if (data == null) {
            this.Nf = null;
        } else {
            this.Nf = new byte[data.length];
            System.arraycopy(data, 0, this.Nf, 0, data.length);
        }
        data = match.getPreviousMatchData();
        if (data == null) {
            this.Nh = null;
        } else {
            this.Nh = new byte[data.length];
            System.arraycopy(data, 0, this.Nh, 0, data.length);
        }
        ArrayList participants = match.getParticipants();
        int size = participants.size();
        this.Mx = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            this.Mx.add((ParticipantEntity) ((Participant) participants.get(i)).freeze());
        }
    }

    static int m7756a(TurnBasedMatch turnBasedMatch) {
        return fo.hashCode(turnBasedMatch.getGame(), turnBasedMatch.getMatchId(), turnBasedMatch.getCreatorId(), Long.valueOf(turnBasedMatch.getCreationTimestamp()), turnBasedMatch.getLastUpdaterId(), Long.valueOf(turnBasedMatch.getLastUpdatedTimestamp()), turnBasedMatch.getPendingParticipantId(), Integer.valueOf(turnBasedMatch.getStatus()), Integer.valueOf(turnBasedMatch.getTurnStatus()), turnBasedMatch.getDescription(), Integer.valueOf(turnBasedMatch.getVariant()), Integer.valueOf(turnBasedMatch.getVersion()), turnBasedMatch.getParticipants(), turnBasedMatch.getRematchId(), Integer.valueOf(turnBasedMatch.getMatchNumber()), turnBasedMatch.getAutoMatchCriteria(), Integer.valueOf(turnBasedMatch.getAvailableAutoMatchSlots()), Boolean.valueOf(turnBasedMatch.isLocallyModified()));
    }

    static int m7757a(TurnBasedMatch turnBasedMatch, String str) {
        ArrayList participants = turnBasedMatch.getParticipants();
        int size = participants.size();
        for (int i = 0; i < size; i++) {
            Participant participant = (Participant) participants.get(i);
            if (participant.getParticipantId().equals(str)) {
                return participant.getStatus();
            }
        }
        throw new IllegalStateException("Participant " + str + " is not in match " + turnBasedMatch.getMatchId());
    }

    static boolean m7758a(TurnBasedMatch turnBasedMatch, Object obj) {
        if (!(obj instanceof TurnBasedMatch)) {
            return false;
        }
        if (turnBasedMatch == obj) {
            return true;
        }
        TurnBasedMatch turnBasedMatch2 = (TurnBasedMatch) obj;
        return fo.equal(turnBasedMatch2.getGame(), turnBasedMatch.getGame()) && fo.equal(turnBasedMatch2.getMatchId(), turnBasedMatch.getMatchId()) && fo.equal(turnBasedMatch2.getCreatorId(), turnBasedMatch.getCreatorId()) && fo.equal(Long.valueOf(turnBasedMatch2.getCreationTimestamp()), Long.valueOf(turnBasedMatch.getCreationTimestamp())) && fo.equal(turnBasedMatch2.getLastUpdaterId(), turnBasedMatch.getLastUpdaterId()) && fo.equal(Long.valueOf(turnBasedMatch2.getLastUpdatedTimestamp()), Long.valueOf(turnBasedMatch.getLastUpdatedTimestamp())) && fo.equal(turnBasedMatch2.getPendingParticipantId(), turnBasedMatch.getPendingParticipantId()) && fo.equal(Integer.valueOf(turnBasedMatch2.getStatus()), Integer.valueOf(turnBasedMatch.getStatus())) && fo.equal(Integer.valueOf(turnBasedMatch2.getTurnStatus()), Integer.valueOf(turnBasedMatch.getTurnStatus())) && fo.equal(turnBasedMatch2.getDescription(), turnBasedMatch.getDescription()) && fo.equal(Integer.valueOf(turnBasedMatch2.getVariant()), Integer.valueOf(turnBasedMatch.getVariant())) && fo.equal(Integer.valueOf(turnBasedMatch2.getVersion()), Integer.valueOf(turnBasedMatch.getVersion())) && fo.equal(turnBasedMatch2.getParticipants(), turnBasedMatch.getParticipants()) && fo.equal(turnBasedMatch2.getRematchId(), turnBasedMatch.getRematchId()) && fo.equal(Integer.valueOf(turnBasedMatch2.getMatchNumber()), Integer.valueOf(turnBasedMatch.getMatchNumber())) && fo.equal(turnBasedMatch2.getAutoMatchCriteria(), turnBasedMatch.getAutoMatchCriteria()) && fo.equal(Integer.valueOf(turnBasedMatch2.getAvailableAutoMatchSlots()), Integer.valueOf(turnBasedMatch.getAvailableAutoMatchSlots())) && fo.equal(Boolean.valueOf(turnBasedMatch2.isLocallyModified()), Boolean.valueOf(turnBasedMatch.isLocallyModified()));
    }

    static String m7759b(TurnBasedMatch turnBasedMatch) {
        return fo.m8511e(turnBasedMatch).m8510a("Game", turnBasedMatch.getGame()).m8510a("MatchId", turnBasedMatch.getMatchId()).m8510a("CreatorId", turnBasedMatch.getCreatorId()).m8510a("CreationTimestamp", Long.valueOf(turnBasedMatch.getCreationTimestamp())).m8510a("LastUpdaterId", turnBasedMatch.getLastUpdaterId()).m8510a("LastUpdatedTimestamp", Long.valueOf(turnBasedMatch.getLastUpdatedTimestamp())).m8510a("PendingParticipantId", turnBasedMatch.getPendingParticipantId()).m8510a("MatchStatus", Integer.valueOf(turnBasedMatch.getStatus())).m8510a("TurnStatus", Integer.valueOf(turnBasedMatch.getTurnStatus())).m8510a("Description", turnBasedMatch.getDescription()).m8510a("Variant", Integer.valueOf(turnBasedMatch.getVariant())).m8510a("Data", turnBasedMatch.getData()).m8510a("Version", Integer.valueOf(turnBasedMatch.getVersion())).m8510a("Participants", turnBasedMatch.getParticipants()).m8510a("RematchId", turnBasedMatch.getRematchId()).m8510a("PreviousData", turnBasedMatch.getPreviousMatchData()).m8510a("MatchNumber", Integer.valueOf(turnBasedMatch.getMatchNumber())).m8510a("AutoMatchCriteria", turnBasedMatch.getAutoMatchCriteria()).m8510a("AvailableAutoMatchSlots", Integer.valueOf(turnBasedMatch.getAvailableAutoMatchSlots())).m8510a("LocallyModified", Boolean.valueOf(turnBasedMatch.isLocallyModified())).m8510a("DescriptionParticipantId", turnBasedMatch.getDescriptionParticipantId()).toString();
    }

    static String m7760b(TurnBasedMatch turnBasedMatch, String str) {
        ArrayList participants = turnBasedMatch.getParticipants();
        int size = participants.size();
        for (int i = 0; i < size; i++) {
            Participant participant = (Participant) participants.get(i);
            Player player = participant.getPlayer();
            if (player != null && player.getPlayerId().equals(str)) {
                return participant.getParticipantId();
            }
        }
        return null;
    }

    static Participant m7761c(TurnBasedMatch turnBasedMatch, String str) {
        ArrayList participants = turnBasedMatch.getParticipants();
        int size = participants.size();
        for (int i = 0; i < size; i++) {
            Participant participant = (Participant) participants.get(i);
            if (participant.getParticipantId().equals(str)) {
                return participant;
            }
        }
        throw new IllegalStateException("Participant " + str + " is not in match " + turnBasedMatch.getMatchId());
    }

    static ArrayList m7762c(TurnBasedMatch turnBasedMatch) {
        ArrayList participants = turnBasedMatch.getParticipants();
        int size = participants.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(((Participant) participants.get(i)).getParticipantId());
        }
        return arrayList;
    }

    public boolean canRematch() {
        return this.Nd == 2 && this.Ng == null;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return m7758a((TurnBasedMatch) this, obj);
    }

    public TurnBasedMatch freeze() {
        return this;
    }

    public Bundle getAutoMatchCriteria() {
        return this.MO;
    }

    public int getAvailableAutoMatchSlots() {
        return this.MO == null ? 0 : this.MO.getInt(Multiplayer.EXTRA_MAX_AUTOMATCH_PLAYERS);
    }

    public long getCreationTimestamp() {
        return this.Mu;
    }

    public String getCreatorId() {
        return this.MS;
    }

    public byte[] getData() {
        return this.Nf;
    }

    public String getDescription() {
        return this.HD;
    }

    public void getDescription(CharArrayBuffer dataOut) {
        gm.m8605b(this.HD, dataOut);
    }

    public Participant getDescriptionParticipant() {
        return getParticipant(getDescriptionParticipantId());
    }

    public String getDescriptionParticipantId() {
        return this.Nl;
    }

    public Game getGame() {
        return this.Lt;
    }

    public long getLastUpdatedTimestamp() {
        return this.Nb;
    }

    public String getLastUpdaterId() {
        return this.Na;
    }

    public String getMatchId() {
        return this.Jb;
    }

    public int getMatchNumber() {
        return this.Ni;
    }

    public Participant getParticipant(String participantId) {
        return m7761c(this, participantId);
    }

    public String getParticipantId(String playerId) {
        return m7760b(this, playerId);
    }

    public ArrayList getParticipantIds() {
        return m7762c(this);
    }

    public int getParticipantStatus(String participantId) {
        return m7757a((TurnBasedMatch) this, participantId);
    }

    public ArrayList getParticipants() {
        return new ArrayList(this.Mx);
    }

    public String getPendingParticipantId() {
        return this.Nc;
    }

    public byte[] getPreviousMatchData() {
        return this.Nh;
    }

    public String getRematchId() {
        return this.Ng;
    }

    public int getStatus() {
        return this.Nd;
    }

    public int getTurnStatus() {
        return this.Nj;
    }

    public int getVariant() {
        return this.My;
    }

    public int getVersion() {
        return this.Ne;
    }

    public int getVersionCode() {
        return this.xH;
    }

    public int hashCode() {
        return m7756a(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public boolean isLocallyModified() {
        return this.Nk;
    }

    public String toString() {
        return m7759b(this);
    }

    public void writeToParcel(Parcel out, int flags) {
        TurnBasedMatchEntityCreator.m7763a(this, out, flags);
    }
}
