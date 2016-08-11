package com.google.android.gms.games.multiplayer.turnbased;

import com.google.android.gms.common.data.C1474d;
import com.google.android.gms.common.data.DataHolder;

public final class TurnBasedMatchBuffer extends C1474d {
    public TurnBasedMatchBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    protected /* synthetic */ Object m7755c(int i, int i2) {
        return getEntry(i, i2);
    }

    protected TurnBasedMatch getEntry(int rowIndex, int numChildren) {
        return new TurnBasedMatchRef(this.BB, rowIndex, numChildren);
    }

    protected String getPrimaryDataMarkerColumn() {
        return "external_match_id";
    }
}
