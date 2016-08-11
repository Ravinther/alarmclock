package com.avg.utils;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.Serializable;

public class InstalledApp implements Parcelable, Serializable {
    public static final Creator CREATOR;
    public String f3606a;
    public String f3607b;
    public String f3608c;
    public long f3609d;
    public long f3610e;
    public long f3611f;
    public int f3612g;
    public byte f3613h;
    public int f3614i;
    public boolean f3615j;

    /* renamed from: com.avg.utils.InstalledApp.1 */
    static class C11891 implements Creator {
        C11891() {
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return m4995a(x0);
        }

        public /* synthetic */ Object[] newArray(int x0) {
            return m4996a(x0);
        }

        public InstalledApp m4995a(Parcel in) {
            return new InstalledApp(in);
        }

        public InstalledApp[] m4996a(int size) {
            return new InstalledApp[size];
        }
    }

    public InstalledApp() {
        this.f3610e = -1;
        this.f3611f = -1;
        this.f3615j = false;
    }

    public InstalledApp(Parcel in) {
        this.f3610e = -1;
        this.f3611f = -1;
        this.f3615j = false;
        this.f3606a = in.readString();
        this.f3607b = in.readString();
        this.f3608c = in.readString();
        this.f3609d = in.readLong();
        this.f3610e = in.readLong();
        this.f3611f = in.readLong();
        this.f3612g = in.readInt();
        this.f3613h = in.readByte();
        this.f3614i = in.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.f3606a);
        dest.writeString(this.f3607b);
        dest.writeString(this.f3608c);
        dest.writeLong(this.f3609d);
        dest.writeLong(this.f3610e);
        dest.writeLong(this.f3611f);
        dest.writeInt(flags);
        dest.writeByte(this.f3613h);
        dest.writeInt(this.f3614i);
    }

    static {
        CREATOR = new C11891();
    }
}
