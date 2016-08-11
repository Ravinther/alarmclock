package com.google.android.gms.games.leaderboard;

import com.google.android.gms.games.internal.constants.LeaderboardCollection;
import com.google.android.gms.games.internal.constants.TimeSpan;
import com.google.android.gms.internal.fo;

public final class LeaderboardVariantEntity implements LeaderboardVariant {
    private final int Mh;
    private final int Mi;
    private final boolean Mj;
    private final long Mk;
    private final String Ml;
    private final long Mm;
    private final String Mn;
    private final String Mo;
    private final long Mp;
    private final String Mq;
    private final String Mr;
    private final String Ms;

    public LeaderboardVariantEntity(LeaderboardVariant variant) {
        this.Mh = variant.getTimeSpan();
        this.Mi = variant.getCollection();
        this.Mj = variant.hasPlayerInfo();
        this.Mk = variant.getRawPlayerScore();
        this.Ml = variant.getDisplayPlayerScore();
        this.Mm = variant.getPlayerRank();
        this.Mn = variant.getDisplayPlayerRank();
        this.Mo = variant.getPlayerScoreTag();
        this.Mp = variant.getNumScores();
        this.Mq = variant.hG();
        this.Mr = variant.hH();
        this.Ms = variant.hI();
    }

    static int m7727a(LeaderboardVariant leaderboardVariant) {
        return fo.hashCode(Integer.valueOf(leaderboardVariant.getTimeSpan()), Integer.valueOf(leaderboardVariant.getCollection()), Boolean.valueOf(leaderboardVariant.hasPlayerInfo()), Long.valueOf(leaderboardVariant.getRawPlayerScore()), leaderboardVariant.getDisplayPlayerScore(), Long.valueOf(leaderboardVariant.getPlayerRank()), leaderboardVariant.getDisplayPlayerRank(), Long.valueOf(leaderboardVariant.getNumScores()), leaderboardVariant.hG(), leaderboardVariant.hI(), leaderboardVariant.hH());
    }

    static boolean m7728a(LeaderboardVariant leaderboardVariant, Object obj) {
        if (!(obj instanceof LeaderboardVariant)) {
            return false;
        }
        if (leaderboardVariant == obj) {
            return true;
        }
        LeaderboardVariant leaderboardVariant2 = (LeaderboardVariant) obj;
        return fo.equal(Integer.valueOf(leaderboardVariant2.getTimeSpan()), Integer.valueOf(leaderboardVariant.getTimeSpan())) && fo.equal(Integer.valueOf(leaderboardVariant2.getCollection()), Integer.valueOf(leaderboardVariant.getCollection())) && fo.equal(Boolean.valueOf(leaderboardVariant2.hasPlayerInfo()), Boolean.valueOf(leaderboardVariant.hasPlayerInfo())) && fo.equal(Long.valueOf(leaderboardVariant2.getRawPlayerScore()), Long.valueOf(leaderboardVariant.getRawPlayerScore())) && fo.equal(leaderboardVariant2.getDisplayPlayerScore(), leaderboardVariant.getDisplayPlayerScore()) && fo.equal(Long.valueOf(leaderboardVariant2.getPlayerRank()), Long.valueOf(leaderboardVariant.getPlayerRank())) && fo.equal(leaderboardVariant2.getDisplayPlayerRank(), leaderboardVariant.getDisplayPlayerRank()) && fo.equal(Long.valueOf(leaderboardVariant2.getNumScores()), Long.valueOf(leaderboardVariant.getNumScores())) && fo.equal(leaderboardVariant2.hG(), leaderboardVariant.hG()) && fo.equal(leaderboardVariant2.hI(), leaderboardVariant.hI()) && fo.equal(leaderboardVariant2.hH(), leaderboardVariant.hH());
    }

    static String m7729b(LeaderboardVariant leaderboardVariant) {
        return fo.m8511e(leaderboardVariant).m8510a("TimeSpan", TimeSpan.bd(leaderboardVariant.getTimeSpan())).m8510a("Collection", LeaderboardCollection.bd(leaderboardVariant.getCollection())).m8510a("RawPlayerScore", leaderboardVariant.hasPlayerInfo() ? Long.valueOf(leaderboardVariant.getRawPlayerScore()) : "none").m8510a("DisplayPlayerScore", leaderboardVariant.hasPlayerInfo() ? leaderboardVariant.getDisplayPlayerScore() : "none").m8510a("PlayerRank", leaderboardVariant.hasPlayerInfo() ? Long.valueOf(leaderboardVariant.getPlayerRank()) : "none").m8510a("DisplayPlayerRank", leaderboardVariant.hasPlayerInfo() ? leaderboardVariant.getDisplayPlayerRank() : "none").m8510a("NumScores", Long.valueOf(leaderboardVariant.getNumScores())).m8510a("TopPageNextToken", leaderboardVariant.hG()).m8510a("WindowPageNextToken", leaderboardVariant.hI()).m8510a("WindowPagePrevToken", leaderboardVariant.hH()).toString();
    }

    public boolean equals(Object obj) {
        return m7728a(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return hJ();
    }

    public int getCollection() {
        return this.Mi;
    }

    public String getDisplayPlayerRank() {
        return this.Mn;
    }

    public String getDisplayPlayerScore() {
        return this.Ml;
    }

    public long getNumScores() {
        return this.Mp;
    }

    public long getPlayerRank() {
        return this.Mm;
    }

    public String getPlayerScoreTag() {
        return this.Mo;
    }

    public long getRawPlayerScore() {
        return this.Mk;
    }

    public int getTimeSpan() {
        return this.Mh;
    }

    public String hG() {
        return this.Mq;
    }

    public String hH() {
        return this.Mr;
    }

    public String hI() {
        return this.Ms;
    }

    public LeaderboardVariant hJ() {
        return this;
    }

    public boolean hasPlayerInfo() {
        return this.Mj;
    }

    public int hashCode() {
        return m7727a(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return m7729b(this);
    }
}
