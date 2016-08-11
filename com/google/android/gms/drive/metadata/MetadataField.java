package com.google.android.gms.drive.metadata;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.Collection;

public interface MetadataField {
    Object m6631a(DataHolder dataHolder, int i, int i2);

    void m6632a(DataHolder dataHolder, MetadataBundle metadataBundle, int i, int i2);

    void m6633a(Object obj, Bundle bundle);

    Object m6634d(Bundle bundle);

    Collection fR();

    String getName();
}
