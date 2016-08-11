package com.google.android.gms.games.multiplayer.realtime;

import com.google.android.gms.common.data.C1474d;
import com.google.android.gms.common.data.DataHolder;

public final class RoomBuffer extends C1474d {
    public RoomBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    protected /* synthetic */ Object m7743c(int i, int i2) {
        return m7744e(i, i2);
    }

    protected Room m7744e(int i, int i2) {
        return new RoomRef(this.BB, i, i2);
    }

    protected String getPrimaryDataMarkerColumn() {
        return "external_match_id";
    }
}
