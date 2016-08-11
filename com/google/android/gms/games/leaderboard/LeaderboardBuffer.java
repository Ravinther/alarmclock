package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.C1474d;
import com.google.android.gms.common.data.DataHolder;

public final class LeaderboardBuffer extends C1474d {
    public LeaderboardBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    protected /* synthetic */ Object m7720c(int i, int i2) {
        return getEntry(i, i2);
    }

    protected Leaderboard getEntry(int rowIndex, int numChildren) {
        return new LeaderboardRef(this.BB, rowIndex, numChildren);
    }

    protected String getPrimaryDataMarkerColumn() {
        return "external_leaderboard_id";
    }
}
