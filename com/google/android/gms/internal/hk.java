package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.concurrent.TimeUnit;

public final class hk implements SafeParcelable {
    public static final hl CREATOR;
    static final long OF;
    private final hg OG;
    private final long Oc;
    private final int mPriority;
    final int xH;

    static {
        CREATOR = new hl();
        OF = TimeUnit.HOURS.toMillis(1);
    }

    public hk(int i, hg hgVar, long j, int i2) {
        this.xH = i;
        this.OG = hgVar;
        this.Oc = j;
        this.mPriority = i2;
    }

    public int describeContents() {
        hl hlVar = CREATOR;
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof hk)) {
            return false;
        }
        hk hkVar = (hk) object;
        return this.OG.equals(hkVar.OG) && this.Oc == hkVar.Oc && this.mPriority == hkVar.mPriority;
    }

    public long getInterval() {
        return this.Oc;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public hg hZ() {
        return this.OG;
    }

    public int hashCode() {
        return fo.hashCode(this.OG, Long.valueOf(this.Oc), Integer.valueOf(this.mPriority));
    }

    public String toString() {
        return fo.m8511e(this).m8510a("filter", this.OG).m8510a("interval", Long.valueOf(this.Oc)).m8510a("priority", Integer.valueOf(this.mPriority)).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        hl hlVar = CREATOR;
        hl.m8692a(this, parcel, flags);
    }
}
