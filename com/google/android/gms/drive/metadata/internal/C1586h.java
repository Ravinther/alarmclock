package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.drive.metadata.C1576a;
import java.util.Collection;

/* renamed from: com.google.android.gms.drive.metadata.internal.h */
public abstract class C1586h extends C1576a {
    public C1586h(String str, int i) {
        super(str, i);
    }

    public C1586h(String str, Collection collection, int i) {
        super(str, collection, i);
    }

    protected void m6678a(Bundle bundle, Parcelable parcelable) {
        bundle.putParcelable(getName(), parcelable);
    }

    protected /* synthetic */ Object m6680e(Bundle bundle) {
        return m6681k(bundle);
    }

    protected Parcelable m6681k(Bundle bundle) {
        return bundle.getParcelable(getName());
    }
}
