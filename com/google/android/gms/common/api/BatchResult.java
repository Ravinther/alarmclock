package com.google.android.gms.common.api;

import com.google.android.gms.internal.fq;

public final class BatchResult implements Result {
    private final PendingResult[] AP;
    private final Status wJ;

    BatchResult(Status status, PendingResult[] pendingResults) {
        this.wJ = status;
        this.AP = pendingResults;
    }

    public Status getStatus() {
        return this.wJ;
    }

    public Result take(BatchResultToken resultToken) {
        fq.m8519b(resultToken.mId < this.AP.length, (Object) "The result token does not belong to this batch");
        PendingResult pendingResult = this.AP[resultToken.mId];
        this.AP[resultToken.mId] = null;
        return pendingResult.await();
    }
}
