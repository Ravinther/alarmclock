package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.C1576a;

/* renamed from: com.google.android.gms.drive.metadata.internal.d */
public class C1582d extends C1576a {
    public C1582d(String str, int i) {
        super(str, i);
    }

    protected void m6661a(Bundle bundle, Integer num) {
        bundle.putInt(getName(), num.intValue());
    }

    protected /* synthetic */ Object m6663b(DataHolder dataHolder, int i, int i2) {
        return m6665f(dataHolder, i, i2);
    }

    protected /* synthetic */ Object m6664e(Bundle bundle) {
        return m6666h(bundle);
    }

    protected Integer m6665f(DataHolder dataHolder, int i, int i2) {
        return Integer.valueOf(dataHolder.getInteger(getName(), i, i2));
    }

    protected Integer m6666h(Bundle bundle) {
        return Integer.valueOf(bundle.getInt(getName()));
    }
}
