package com.google.android.gms.games.internal.game;

import com.google.android.gms.common.data.C1474d;
import com.google.android.gms.common.data.DataHolder;

public final class ExtendedGameBuffer extends C1474d {
    public ExtendedGameBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    protected /* synthetic */ Object m7701c(int i, int i2) {
        return m7702d(i, i2);
    }

    protected ExtendedGame m7702d(int i, int i2) {
        return new ExtendedGameRef(this.BB, i, i2);
    }

    protected String getPrimaryDataMarkerColumn() {
        return "external_game_id";
    }
}
