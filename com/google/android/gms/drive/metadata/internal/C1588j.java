package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.C1576a;

/* renamed from: com.google.android.gms.drive.metadata.internal.j */
public class C1588j extends C1576a {
    public C1588j(String str, int i) {
        super(str, i);
    }

    protected void m6689a(Bundle bundle, String str) {
        bundle.putString(getName(), str);
    }

    protected /* synthetic */ Object m6690b(DataHolder dataHolder, int i, int i2) {
        return m6692h(dataHolder, i, i2);
    }

    protected /* synthetic */ Object m6691e(Bundle bundle) {
        return m6693l(bundle);
    }

    protected String m6692h(DataHolder dataHolder, int i, int i2) {
        return dataHolder.getString(getName(), i, i2);
    }

    protected String m6693l(Bundle bundle) {
        return bundle.getString(getName());
    }
}
