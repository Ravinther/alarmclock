package com.google.android.gms.internal;

import com.google.android.gms.common.data.C1420b;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.C2019a;
import com.google.android.gms.wearable.C2021c;

public final class kc extends C1420b implements C2019a {
    private final int LE;

    public kc(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.LE = i2;
    }

    public /* synthetic */ Object freeze() {
        return me();
    }

    public int getType() {
        return getInteger("event_type");
    }

    public C2021c lZ() {
        return new kg(this.BB, this.BD, this.LE);
    }

    public C2019a me() {
        return new kb(this);
    }
}
