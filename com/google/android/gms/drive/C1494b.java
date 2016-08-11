package com.google.android.gms.drive;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* renamed from: com.google.android.gms.drive.b */
public final class C1494b extends Metadata {
    private final MetadataBundle ED;

    public C1494b(MetadataBundle metadataBundle) {
        this.ED = metadataBundle;
    }

    protected Object m6390a(MetadataField metadataField) {
        return this.ED.m6646a(metadataField);
    }

    public Metadata fB() {
        return new C1494b(MetadataBundle.m6645a(this.ED));
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
