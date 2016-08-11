package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.C1578c;
import java.util.Date;

/* renamed from: com.google.android.gms.drive.metadata.internal.b */
public class C1580b extends C1578c {
    public C1580b(String str, int i) {
        super(str, i);
    }

    protected void m6655a(Bundle bundle, Date date) {
        bundle.putLong(getName(), date.getTime());
    }

    protected /* synthetic */ Object m6656b(DataHolder dataHolder, int i, int i2) {
        return m6658e(dataHolder, i, i2);
    }

    protected /* synthetic */ Object m6657e(Bundle bundle) {
        return m6659g(bundle);
    }

    protected Date m6658e(DataHolder dataHolder, int i, int i2) {
        return new Date(dataHolder.getLong(getName(), i, i2));
    }

    protected Date m6659g(Bundle bundle) {
        return new Date(bundle.getLong(getName()));
    }
}
