package com.google.android.gms.games.request;

import com.google.android.gms.common.data.C1474d;
import com.google.android.gms.common.data.DataHolder;

public final class GameRequestBuffer extends C1474d {
    public GameRequestBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    protected /* synthetic */ Object m7764c(int i, int i2) {
        return getEntry(i, i2);
    }

    protected GameRequest getEntry(int rowIndex, int numChildren) {
        return new GameRequestRef(this.BB, rowIndex, numChildren);
    }

    protected String getPrimaryDataMarkerColumn() {
        return "external_request_id";
    }
}
