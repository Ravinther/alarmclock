package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.api.C1461a.C1402a;
import com.google.android.gms.common.api.C1461a.C1460c;
import com.google.android.gms.common.api.PendingResult.C1458a;
import java.util.ArrayList;
import java.util.List;

public final class Batch extends C1402a {
    private int AM;
    private boolean AN;
    private boolean AO;
    private final PendingResult[] AP;
    private final Object li;

    /* renamed from: com.google.android.gms.common.api.Batch.1 */
    class C14591 implements C1458a {
        final /* synthetic */ Batch AQ;

        C14591(Batch batch) {
            this.AQ = batch;
        }

        public void m6226l(Status status) {
            synchronized (this.AQ.li) {
                if (this.AQ.isCanceled()) {
                    return;
                }
                if (status.isCanceled()) {
                    this.AQ.AO = true;
                } else if (!status.isSuccess()) {
                    this.AQ.AN = true;
                }
                this.AQ.AM = this.AQ.AM - 1;
                if (this.AQ.AM == 0) {
                    if (this.AQ.AO) {
                        super.cancel();
                    } else {
                        this.AQ.m6054a(new BatchResult(this.AQ.AN ? new Status(13) : Status.Bv, this.AQ.AP));
                    }
                }
            }
        }
    }

    public static final class Builder {
        private List AR;
        private Looper AS;

        public Builder(GoogleApiClient googleApiClient) {
            this.AR = new ArrayList();
            this.AS = googleApiClient.getLooper();
        }

        public BatchResultToken add(PendingResult pendingResult) {
            BatchResultToken batchResultToken = new BatchResultToken(this.AR.size());
            this.AR.add(pendingResult);
            return batchResultToken;
        }

        public Batch build() {
            return new Batch(this.AS, null);
        }
    }

    private Batch(List pendingResultList, Looper looper) {
        super(new C1460c(looper));
        this.li = new Object();
        this.AM = pendingResultList.size();
        this.AP = new PendingResult[this.AM];
        for (int i = 0; i < pendingResultList.size(); i++) {
            PendingResult pendingResult = (PendingResult) pendingResultList.get(i);
            this.AP[i] = pendingResult;
            pendingResult.m6048a(new C14591(this));
        }
    }

    public void cancel() {
        super.cancel();
        for (PendingResult cancel : this.AP) {
            cancel.cancel();
        }
    }

    public BatchResult createFailedResult(Status status) {
        return new BatchResult(status, this.AP);
    }

    public /* synthetic */ Result m6236d(Status status) {
        return createFailedResult(status);
    }
}
