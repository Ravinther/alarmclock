package com.google.android.gms.wearable;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.C1474d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.kc;

/* renamed from: com.google.android.gms.wearable.b */
public class C2378b extends C1474d implements Result {
    private final Status wJ;

    public C2378b(DataHolder dataHolder) {
        super(dataHolder);
        this.wJ = new Status(dataHolder.getStatusCode());
    }

    protected /* synthetic */ Object m9709c(int i, int i2) {
        return m9710g(i, i2);
    }

    protected C2019a m9710g(int i, int i2) {
        return new kc(this.BB, i, i2);
    }

    protected String getPrimaryDataMarkerColumn() {
        return "path";
    }

    public Status getStatus() {
        return this.wJ;
    }
}
