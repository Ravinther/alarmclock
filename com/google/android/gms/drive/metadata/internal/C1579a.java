package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.C1576a;

/* renamed from: com.google.android.gms.drive.metadata.internal.a */
public class C1579a extends C1576a {
    public C1579a(String str, int i) {
        super(str, i);
    }

    protected void m6648a(Bundle bundle, Boolean bool) {
        bundle.putBoolean(getName(), bool.booleanValue());
    }

    protected /* synthetic */ Object m6650b(DataHolder dataHolder, int i, int i2) {
        return m6651d(dataHolder, i, i2);
    }

    protected Boolean m6651d(DataHolder dataHolder, int i, int i2) {
        return Boolean.valueOf(dataHolder.getBoolean(getName(), i, i2));
    }

    protected /* synthetic */ Object m6652e(Bundle bundle) {
        return m6653f(bundle);
    }

    protected Boolean m6653f(Bundle bundle) {
        return Boolean.valueOf(bundle.getBoolean(getName()));
    }
}
