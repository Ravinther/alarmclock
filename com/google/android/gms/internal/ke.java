package com.google.android.gms.internal;

import com.google.android.gms.common.data.C1420b;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.C2020d;

public class ke extends C1420b implements C2020d {
    public ke(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    public /* synthetic */ Object freeze() {
        return mf();
    }

    public String getId() {
        return getString("asset_id");
    }

    public String mc() {
        return getString("asset_key");
    }

    public C2020d mf() {
        return new kd(this);
    }
}
