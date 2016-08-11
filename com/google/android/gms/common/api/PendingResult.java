package com.google.android.gms.common.api;

import java.util.concurrent.TimeUnit;

public interface PendingResult {

    /* renamed from: com.google.android.gms.common.api.PendingResult.a */
    public interface C1458a {
        void m6225l(Status status);
    }

    void m6048a(C1458a c1458a);

    Result await();

    Result await(long j, TimeUnit timeUnit);

    void cancel();

    boolean isCanceled();

    void setResultCallback(ResultCallback resultCallback);

    void setResultCallback(ResultCallback resultCallback, long j, TimeUnit timeUnit);
}
