package com.google.android.gms.drive.metadata;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.fq;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.gms.drive.metadata.a */
public abstract class C1576a implements MetadataField {
    private final String FM;
    private final Set FN;
    private final int FO;

    protected C1576a(String str, int i) {
        this.FM = (String) fq.m8517b((Object) str, (Object) "fieldName");
        this.FN = Collections.singleton(str);
        this.FO = i;
    }

    protected C1576a(String str, Collection collection, int i) {
        this.FM = (String) fq.m8517b((Object) str, (Object) "fieldName");
        this.FN = Collections.unmodifiableSet(new HashSet(collection));
        this.FO = i;
    }

    public final Object m6635a(DataHolder dataHolder, int i, int i2) {
        for (String hasNull : this.FN) {
            if (dataHolder.hasNull(hasNull, i, i2)) {
                return null;
            }
        }
        return m6639b(dataHolder, i, i2);
    }

    protected abstract void m6636a(Bundle bundle, Object obj);

    public final void m6637a(DataHolder dataHolder, MetadataBundle metadataBundle, int i, int i2) {
        fq.m8517b((Object) dataHolder, (Object) "dataHolder");
        fq.m8517b((Object) metadataBundle, (Object) "bundle");
        metadataBundle.m6647b(this, m6635a(dataHolder, i, i2));
    }

    public final void m6638a(Object obj, Bundle bundle) {
        fq.m8517b((Object) bundle, (Object) "bundle");
        if (obj == null) {
            bundle.putString(getName(), null);
        } else {
            m6636a(bundle, obj);
        }
    }

    protected abstract Object m6639b(DataHolder dataHolder, int i, int i2);

    public final Object m6640d(Bundle bundle) {
        fq.m8517b((Object) bundle, (Object) "bundle");
        return bundle.get(getName()) != null ? m6641e(bundle) : null;
    }

    protected abstract Object m6641e(Bundle bundle);

    public final Collection fR() {
        return this.FN;
    }

    public final String getName() {
        return this.FM;
    }

    public String toString() {
        return this.FM;
    }
}
