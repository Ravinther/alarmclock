package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.C1576a;

/* renamed from: com.google.android.gms.drive.metadata.internal.e */
public class C1583e extends C1576a {
    public C1583e(String str, int i) {
        super(str, i);
    }

    protected void m6667a(Bundle bundle, Long l) {
        bundle.putLong(getName(), l.longValue());
    }

    protected /* synthetic */ Object m6669b(DataHolder dataHolder, int i, int i2) {
        return m6671g(dataHolder, i, i2);
    }

    protected /* synthetic */ Object m6670e(Bundle bundle) {
        return m6672i(bundle);
    }

    protected Long m6671g(DataHolder dataHolder, int i, int i2) {
        return Long.valueOf(dataHolder.getLong(getName(), i, i2));
    }

    protected Long m6672i(Bundle bundle) {
        return Long.valueOf(bundle.getLong(getName()));
    }
}
