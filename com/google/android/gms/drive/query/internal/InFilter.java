package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.C1577b;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.query.Filter;
import java.util.Collections;

public class InFilter implements SafeParcelable, Filter {
    public static final C1596f CREATOR;
    final MetadataBundle GH;
    private final C1577b GR;
    final int xH;

    static {
        CREATOR = new C1596f();
    }

    InFilter(int versionCode, MetadataBundle value) {
        this.xH = versionCode;
        this.GH = value;
        this.GR = (C1577b) C1595e.m6701b(value);
    }

    public InFilter(SearchableCollectionMetadataField field, Object value) {
        this(1, MetadataBundle.m6644a(field, Collections.singleton(value)));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        C1596f.m6702a(this, out, flags);
    }
}
