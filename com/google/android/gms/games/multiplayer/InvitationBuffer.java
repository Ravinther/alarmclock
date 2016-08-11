package com.google.android.gms.games.multiplayer;

import com.google.android.gms.common.data.C1474d;
import com.google.android.gms.common.data.DataHolder;

public final class InvitationBuffer extends C1474d {
    public InvitationBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    protected /* synthetic */ Object m7731c(int i, int i2) {
        return getEntry(i, i2);
    }

    protected Invitation getEntry(int rowIndex, int numChildren) {
        return new InvitationRef(this.BB, rowIndex, numChildren);
    }

    protected String getPrimaryDataMarkerColumn() {
        return "external_invitation_id";
    }
}
