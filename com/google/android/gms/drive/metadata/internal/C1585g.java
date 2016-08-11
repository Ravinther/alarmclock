package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.drive.metadata.C1577b;
import java.util.ArrayList;
import java.util.Collection;

/* renamed from: com.google.android.gms.drive.metadata.internal.g */
public class C1585g extends C1577b {
    public C1585g(String str, int i) {
        super(str, i);
    }

    protected void m6675a(Bundle bundle, Collection collection) {
        bundle.putParcelableArrayList(getName(), new ArrayList(collection));
    }

    protected /* synthetic */ Object m6676e(Bundle bundle) {
        return m6677j(bundle);
    }

    protected Collection m6677j(Bundle bundle) {
        return bundle.getParcelableArrayList(getName());
    }
}
