package com.google.android.gms.drive.internal;

import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* renamed from: com.google.android.gms.drive.internal.j */
public final class C1511j extends Metadata {
    private final MetadataBundle ED;

    public C1511j(MetadataBundle metadataBundle) {
        this.ED = metadataBundle;
    }

    protected Object m6458a(MetadataField metadataField) {
        return this.ED.m6646a(metadataField);
    }

    public Metadata fB() {
        return new C1511j(MetadataBundle.m6645a(this.ED));
    }

    public /* synthetic */ Object freeze() {
        return fB();
    }

    public boolean isDataValid() {
        return this.ED != null;
    }

    public String toString() {
        return "Metadata [mImpl=" + this.ED + "]";
    }
}
