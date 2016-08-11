package com.google.android.gms.games.request;

import com.google.android.gms.common.data.DataBuffer;

public final class GameRequestSummaryBuffer extends DataBuffer {
    public GameRequestSummary br(int i) {
        return new GameRequestSummaryRef(this.BB, i);
    }

    public /* synthetic */ Object get(int x0) {
        return br(x0);
    }
}
