package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.Filter;
import java.util.ArrayList;
import java.util.List;

public class LogicalFilter implements SafeParcelable, Filter {
    public static final Creator CREATOR;
    private List GD;
    final Operator GG;
    final List GS;
    final int xH;

    static {
        CREATOR = new C1597g();
    }

    LogicalFilter(int versionCode, Operator operator, List filterHolders) {
        this.xH = versionCode;
        this.GG = operator;
        this.GS = filterHolders;
    }

    public LogicalFilter(Operator operator, Filter filter, Filter... additionalFilters) {
        this.xH = 1;
        this.GG = operator;
        this.GS = new ArrayList(additionalFilters.length + 1);
        this.GS.add(new FilterHolder(filter));
        this.GD = new ArrayList(additionalFilters.length + 1);
        this.GD.add(filter);
        for (Filter filter2 : additionalFilters) {
            this.GS.add(new FilterHolder(filter2));
            this.GD.add(filter2);
        }
    }

    public LogicalFilter(Operator operator, Iterable filters) {
        this.xH = 1;
        this.GG = operator;
        this.GD = new ArrayList();
        this.GS = new ArrayList();
        for (Filter filter : filters) {
            this.GD.add(filter);
            this.GS.add(new FilterHolder(filter));
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        C1597g.m6703a(this, out, flags);
    }
}
