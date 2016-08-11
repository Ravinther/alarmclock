package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.query.Filter;

public class ComparisonFilter implements SafeParcelable, Filter {
    public static final C1591a CREATOR;
    final Operator GG;
    final MetadataBundle GH;
    final MetadataField GI;
    final int xH;

    static {
        CREATOR = new C1591a();
    }

    ComparisonFilter(int versionCode, Operator operator, MetadataBundle value) {
        this.xH = versionCode;
        this.GG = operator;
        this.GH = value;
        this.GI = C1595e.m6701b(value);
    }

    public ComparisonFilter(Operator operator, SearchableMetadataField field, Object value) {
        this(1, operator, MetadataBundle.m6644a(field, value));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        C1591a.m6697a(this, out, flags);
    }
}
