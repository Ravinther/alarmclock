package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.internal.fe;
import com.google.android.gms.internal.fo;
import com.google.android.gms.internal.gm;

public final class GameEntity extends GamesDowngradeableSafeParcel implements Game {
    public static final Creator CREATOR;
    private final String HA;
    private final String HB;
    private final String HC;
    private final String HD;
    private final String HE;
    private final Uri HF;
    private final Uri HG;
    private final Uri HH;
    private final boolean HI;
    private final boolean HJ;
    private final String HK;
    private final int HL;
    private final int HM;
    private final int HN;
    private final boolean HO;
    private final boolean HP;
    private final String HQ;
    private final String HR;
    private final String HS;
    private final boolean HT;
    private final boolean HU;
    private final int xH;
    private final String xI;

    static final class GameEntityCreatorCompat extends GameEntityCreator {
        GameEntityCreatorCompat() {
        }

        public GameEntity an(Parcel parcel) {
            if (GamesDowngradeableSafeParcel.m6742c(fe.eJ()) || fe.al(GameEntity.class.getCanonicalName())) {
                return super.an(parcel);
            }
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            String readString7 = parcel.readString();
            Uri parse = readString7 == null ? null : Uri.parse(readString7);
            readString7 = parcel.readString();
            Uri parse2 = readString7 == null ? null : Uri.parse(readString7);
            readString7 = parcel.readString();
            return new GameEntity(3, readString, readString2, readString3, readString4, readString5, readString6, parse, parse2, readString7 == null ? null : Uri.parse(readString7), parcel.readInt() > 0, parcel.readInt() > 0, parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), false, false, null, null, null, false, false);
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return an(x0);
        }
    }

    static {
        CREATOR = new GameEntityCreatorCompat();
    }

    GameEntity(int versionCode, String applicationId, String displayName, String primaryCategory, String secondaryCategory, String description, String developerName, Uri iconImageUri, Uri hiResImageUri, Uri featuredImageUri, boolean playEnabledGame, boolean instanceInstalled, String instancePackageName, int gameplayAclStatus, int achievementTotalCount, int leaderboardCount, boolean realTimeEnabled, boolean turnBasedEnabled, String iconImageUrl, String hiResImageUrl, String featuredImageUrl, boolean muted, boolean identitySharingConfirmed) {
        this.xH = versionCode;
        this.xI = applicationId;
        this.HA = displayName;
        this.HB = primaryCategory;
        this.HC = secondaryCategory;
        this.HD = description;
        this.HE = developerName;
        this.HF = iconImageUri;
        this.HQ = iconImageUrl;
        this.HG = hiResImageUri;
        this.HR = hiResImageUrl;
        this.HH = featuredImageUri;
        this.HS = featuredImageUrl;
        this.HI = playEnabledGame;
        this.HJ = instanceInstalled;
        this.HK = instancePackageName;
        this.HL = gameplayAclStatus;
        this.HM = achievementTotalCount;
        this.HN = leaderboardCount;
        this.HO = realTimeEnabled;
        this.HP = turnBasedEnabled;
        this.HT = muted;
        this.HU = identitySharingConfirmed;
    }

    public GameEntity(Game game) {
        this.xH = 3;
        this.xI = game.getApplicationId();
        this.HB = game.getPrimaryCategory();
        this.HC = game.getSecondaryCategory();
        this.HD = game.getDescription();
        this.HE = game.getDeveloperName();
        this.HA = game.getDisplayName();
        this.HF = game.getIconImageUri();
        this.HQ = game.getIconImageUrl();
        this.HG = game.getHiResImageUri();
        this.HR = game.getHiResImageUrl();
        this.HH = game.getFeaturedImageUri();
        this.HS = game.getFeaturedImageUrl();
        this.HI = game.gb();
        this.HJ = game.gd();
        this.HK = game.ge();
        this.HL = game.gf();
        this.HM = game.getAchievementTotalCount();
        this.HN = game.getLeaderboardCount();
        this.HO = game.isRealTimeMultiplayerEnabled();
        this.HP = game.isTurnBasedMultiplayerEnabled();
        this.HT = game.isMuted();
        this.HU = game.gc();
    }

    static int m6743a(Game game) {
        return fo.hashCode(game.getApplicationId(), game.getDisplayName(), game.getPrimaryCategory(), game.getSecondaryCategory(), game.getDescription(), game.getDeveloperName(), game.getIconImageUri(), game.getHiResImageUri(), game.getFeaturedImageUri(), Boolean.valueOf(game.gb()), Boolean.valueOf(game.gd()), game.ge(), Integer.valueOf(game.gf()), Integer.valueOf(game.getAchievementTotalCount()), Integer.valueOf(game.getLeaderboardCount()), Boolean.valueOf(game.isRealTimeMultiplayerEnabled()), Boolean.valueOf(game.isTurnBasedMultiplayerEnabled()), Boolean.valueOf(game.isMuted()), Boolean.valueOf(game.gc()));
    }

    static boolean m6744a(Game game, Object obj) {
        if (!(obj instanceof Game)) {
            return false;
        }
        if (game == obj) {
            return true;
        }
        Game game2 = (Game) obj;
        if (fo.equal(game2.getApplicationId(), game.getApplicationId()) && fo.equal(game2.getDisplayName(), game.getDisplayName()) && fo.equal(game2.getPrimaryCategory(), game.getPrimaryCategory()) && fo.equal(game2.getSecondaryCategory(), game.getSecondaryCategory()) && fo.equal(game2.getDescription(), game.getDescription()) && fo.equal(game2.getDeveloperName(), game.getDeveloperName()) && fo.equal(game2.getIconImageUri(), game.getIconImageUri()) && fo.equal(game2.getHiResImageUri(), game.getHiResImageUri()) && fo.equal(game2.getFeaturedImageUri(), game.getFeaturedImageUri()) && fo.equal(Boolean.valueOf(game2.gb()), Boolean.valueOf(game.gb())) && fo.equal(Boolean.valueOf(game2.gd()), Boolean.valueOf(game.gd())) && fo.equal(game2.ge(), game.ge()) && fo.equal(Integer.valueOf(game2.gf()), Integer.valueOf(game.gf())) && fo.equal(Integer.valueOf(game2.getAchievementTotalCount()), Integer.valueOf(game.getAchievementTotalCount())) && fo.equal(Integer.valueOf(game2.getLeaderboardCount()), Integer.valueOf(game.getLeaderboardCount())) && fo.equal(Boolean.valueOf(game2.isRealTimeMultiplayerEnabled()), Boolean.valueOf(game.isRealTimeMultiplayerEnabled()))) {
            Boolean valueOf = Boolean.valueOf(game2.isTurnBasedMultiplayerEnabled());
            boolean z = game.isTurnBasedMultiplayerEnabled() && fo.equal(Boolean.valueOf(game2.isMuted()), Boolean.valueOf(game.isMuted())) && fo.equal(Boolean.valueOf(game2.gc()), Boolean.valueOf(game.gc()));
            if (fo.equal(valueOf, Boolean.valueOf(z))) {
                return true;
            }
        }
        return false;
    }

    static String m6745b(Game game) {
        return fo.m8511e(game).m8510a("ApplicationId", game.getApplicationId()).m8510a("DisplayName", game.getDisplayName()).m8510a("PrimaryCategory", game.getPrimaryCategory()).m8510a("SecondaryCategory", game.getSecondaryCategory()).m8510a("Description", game.getDescription()).m8510a("DeveloperName", game.getDeveloperName()).m8510a("IconImageUri", game.getIconImageUri()).m8510a("IconImageUrl", game.getIconImageUrl()).m8510a("HiResImageUri", game.getHiResImageUri()).m8510a("HiResImageUrl", game.getHiResImageUrl()).m8510a("FeaturedImageUri", game.getFeaturedImageUri()).m8510a("FeaturedImageUrl", game.getFeaturedImageUrl()).m8510a("PlayEnabledGame", Boolean.valueOf(game.gb())).m8510a("InstanceInstalled", Boolean.valueOf(game.gd())).m8510a("InstancePackageName", game.ge()).m8510a("AchievementTotalCount", Integer.valueOf(game.getAchievementTotalCount())).m8510a("LeaderboardCount", Integer.valueOf(game.getLeaderboardCount())).m8510a("RealTimeMultiplayerEnabled", Boolean.valueOf(game.isRealTimeMultiplayerEnabled())).m8510a("TurnBasedMultiplayerEnabled", Boolean.valueOf(game.isTurnBasedMultiplayerEnabled())).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return m6744a(this, obj);
    }

    public Game freeze() {
        return this;
    }

    public boolean gb() {
        return this.HI;
    }

    public boolean gc() {
        return this.HU;
    }

    public boolean gd() {
        return this.HJ;
    }

    public String ge() {
        return this.HK;
    }

    public int getAchievementTotalCount() {
        return this.HM;
    }

    public String getApplicationId() {
        return this.xI;
    }

    public String getDescription() {
        return this.HD;
    }

    public void getDescription(CharArrayBuffer dataOut) {
        gm.m8605b(this.HD, dataOut);
    }

    public String getDeveloperName() {
        return this.HE;
    }

    public void getDeveloperName(CharArrayBuffer dataOut) {
        gm.m8605b(this.HE, dataOut);
    }

    public String getDisplayName() {
        return this.HA;
    }

    public void getDisplayName(CharArrayBuffer dataOut) {
        gm.m8605b(this.HA, dataOut);
    }

    public Uri getFeaturedImageUri() {
        return this.HH;
    }

    public String getFeaturedImageUrl() {
        return this.HS;
    }

    public Uri getHiResImageUri() {
        return this.HG;
    }

    public String getHiResImageUrl() {
        return this.HR;
    }

    public Uri getIconImageUri() {
        return this.HF;
    }

    public String getIconImageUrl() {
        return this.HQ;
    }

    public int getLeaderboardCount() {
        return this.HN;
    }

    public String getPrimaryCategory() {
        return this.HB;
    }

    public String getSecondaryCategory() {
        return this.HC;
    }

    public int getVersionCode() {
        return this.xH;
    }

    public int gf() {
        return this.HL;
    }

    public int hashCode() {
        return m6743a(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public boolean isMuted() {
        return this.HT;
    }

    public boolean isRealTimeMultiplayerEnabled() {
        return this.HO;
    }

    public boolean isTurnBasedMultiplayerEnabled() {
        return this.HP;
    }

    public String toString() {
        return m6745b((Game) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        int i = 1;
        String str = null;
        if (eK()) {
            dest.writeString(this.xI);
            dest.writeString(this.HA);
            dest.writeString(this.HB);
            dest.writeString(this.HC);
            dest.writeString(this.HD);
            dest.writeString(this.HE);
            dest.writeString(this.HF == null ? null : this.HF.toString());
            dest.writeString(this.HG == null ? null : this.HG.toString());
            if (this.HH != null) {
                str = this.HH.toString();
            }
            dest.writeString(str);
            dest.writeInt(this.HI ? 1 : 0);
            if (!this.HJ) {
                i = 0;
            }
            dest.writeInt(i);
            dest.writeString(this.HK);
            dest.writeInt(this.HL);
            dest.writeInt(this.HM);
            dest.writeInt(this.HN);
            return;
        }
        GameEntityCreator.m6740a(this, dest, flags);
    }
}
