package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.C1574y;
import com.google.android.gms.internal.fq;
import com.google.android.gms.internal.ks;
import com.google.android.gms.internal.kt;

public class DriveId implements SafeParcelable {
    public static final Creator CREATOR;
    final String EH;
    final long EI;
    final long EJ;
    private volatile String EK;
    final int xH;

    static {
        CREATOR = new C1496d();
    }

    DriveId(int versionCode, String resourceId, long sqlId, long databaseInstanceId) {
        boolean z = false;
        this.EK = null;
        this.xH = versionCode;
        this.EH = resourceId;
        fq.m8522z(!"".equals(resourceId));
        if (!(resourceId == null && sqlId == -1)) {
            z = true;
        }
        fq.m8522z(z);
        this.EI = sqlId;
        this.EJ = databaseInstanceId;
    }

    public DriveId(String resourceId, long sqlId, long databaseInstanceId) {
        this(1, resourceId, sqlId, databaseInstanceId);
    }

    public static DriveId aw(String str) {
        fq.m8520f(str);
        return new DriveId(str, -1, -1);
    }

    public static DriveId decodeFromString(String s) {
        fq.m8519b(s.startsWith("DriveId:"), "Invalid DriveId: " + s);
        return m6384f(Base64.decode(s.substring("DriveId:".length()), 10));
    }

    static DriveId m6384f(byte[] bArr) {
        try {
            C1574y g = C1574y.m6624g(bArr);
            return new DriveId(g.versionCode, "".equals(g.FC) ? null : g.FC, g.FD, g.FE);
        } catch (ks e) {
            throw new IllegalArgumentException();
        }
    }

    public int describeContents() {
        return 0;
    }

    public final String encodeToString() {
        if (this.EK == null) {
            this.EK = "DriveId:" + Base64.encodeToString(fC(), 10);
        }
        return this.EK;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DriveId)) {
            return false;
        }
        DriveId driveId = (DriveId) obj;
        if (driveId.EJ != this.EJ) {
            Log.w("DriveId", "Attempt to compare invalid DriveId detected. Has local storage been cleared?");
            return false;
        } else if (driveId.EI == -1 && this.EI == -1) {
            return driveId.EH.equals(this.EH);
        } else {
            return driveId.EI == this.EI;
        }
    }

    final byte[] fC() {
        kt c1574y = new C1574y();
        c1574y.versionCode = this.xH;
        c1574y.FC = this.EH == null ? "" : this.EH;
        c1574y.FD = this.EI;
        c1574y.FE = this.EJ;
        return kt.m6617d(c1574y);
    }

    public String getResourceId() {
        return this.EH;
    }

    public int hashCode() {
        return this.EI == -1 ? this.EH.hashCode() : (String.valueOf(this.EJ) + String.valueOf(this.EI)).hashCode();
    }

    public String toString() {
        return encodeToString();
    }

    public void writeToParcel(Parcel out, int flags) {
        C1496d.m6391a(this, out, flags);
    }
}
