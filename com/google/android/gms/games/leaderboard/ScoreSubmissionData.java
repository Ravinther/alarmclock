package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.constants.TimeSpan;
import com.google.android.gms.internal.fo;
import com.google.android.gms.internal.fo.C1908a;
import com.google.android.gms.internal.fq;
import java.util.HashMap;

public final class ScoreSubmissionData {
    private static final String[] LN;
    private int Ah;
    private String Ie;
    private String LP;
    private HashMap Mt;

    public static final class Result {
        public final String formattedScore;
        public final boolean newBest;
        public final long rawScore;
        public final String scoreTag;

        public Result(long rawScore, String formattedScore, String scoreTag, boolean newBest) {
            this.rawScore = rawScore;
            this.formattedScore = formattedScore;
            this.scoreTag = scoreTag;
            this.newBest = newBest;
        }

        public String toString() {
            return fo.m8511e(this).m8510a("RawScore", Long.valueOf(this.rawScore)).m8510a("FormattedScore", this.formattedScore).m8510a("ScoreTag", this.scoreTag).m8510a("NewBest", Boolean.valueOf(this.newBest)).toString();
        }
    }

    static {
        LN = new String[]{"leaderboardId", "playerId", "timeSpan", "hasResult", "rawScore", "formattedScore", "newBest", "scoreTag"};
    }

    public ScoreSubmissionData(DataHolder dataHolder) {
        this.Ah = dataHolder.getStatusCode();
        this.Mt = new HashMap();
        int count = dataHolder.getCount();
        fq.m8522z(count == 3);
        for (int i = 0; i < count; i++) {
            int G = dataHolder.m6272G(i);
            if (i == 0) {
                this.LP = dataHolder.getString("leaderboardId", i, G);
                this.Ie = dataHolder.getString("playerId", i, G);
            }
            if (dataHolder.getBoolean("hasResult", i, G)) {
                m7730a(new Result(dataHolder.getLong("rawScore", i, G), dataHolder.getString("formattedScore", i, G), dataHolder.getString("scoreTag", i, G), dataHolder.getBoolean("newBest", i, G)), dataHolder.getInteger("timeSpan", i, G));
            }
        }
    }

    private void m7730a(Result result, int i) {
        this.Mt.put(Integer.valueOf(i), result);
    }

    public String getLeaderboardId() {
        return this.LP;
    }

    public String getPlayerId() {
        return this.Ie;
    }

    public Result getScoreResult(int timeSpan) {
        return (Result) this.Mt.get(Integer.valueOf(timeSpan));
    }

    public String toString() {
        C1908a a = fo.m8511e(this).m8510a("PlayerId", this.Ie).m8510a("StatusCode", Integer.valueOf(this.Ah));
        for (int i = 0; i < 3; i++) {
            Result result = (Result) this.Mt.get(Integer.valueOf(i));
            a.m8510a("TimesSpan", TimeSpan.bd(i));
            a.m8510a("Result", result == null ? "null" : result.toString());
        }
        return a.toString();
    }
}
