package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.query.Filter;

public class FieldOnlyFilter implements SafeParcelable, Filter {
    public static final Creator CREATOR;
    final MetadataBundle GH;
    private final MetadataField GI;
    final int xH;

    static {
        CREATOR = new C1592b();
    }

    FieldOnlyFilter(int versionCode, MetadataBundle value) {
        this.xH = versionCode;
        this.GH = value;
        this.GI = C1595e.m6701b(value);
    }

    public FieldOnlyFilter(SearchableMetadataField field) {
        this(1, MetadataBundle.m6644a(field, null));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        C1592b.m6698a(this, out, flags);
    }
}
