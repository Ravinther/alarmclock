package com.google.android.gms.drive.metadata;

import com.google.android.gms.common.data.DataHolder;
import java.util.Collection;

/* renamed from: com.google.android.gms.drive.metadata.b */
public abstract class C1577b extends C1576a {
    protected C1577b(String str, int i) {
        super(str, i);
    }

    protected /* synthetic */ Object m6642b(DataHolder dataHolder, int i, int i2) {
        return m6643c(dataHolder, i, i2);
    }

    protected Collection m6643c(DataHolder dataHolder, int i, int i2) {
        throw new UnsupportedOperationException("Cannot read collections from a dataHolder.");
    }
}
