package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ef implements Parcelable {
    @Deprecated
    public static final Creator CREATOR;
    private String mValue;
    private String wp;
    private String wq;

    /* renamed from: com.google.android.gms.internal.ef.1 */
    static class C18431 implements Creator {
        C18431() {
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return m8256i(x0);
        }

        @Deprecated
        public ef m8256i(Parcel parcel) {
            return new ef(parcel);
        }

        public /* synthetic */ Object[] newArray(int x0) {
            return m8257u(x0);
        }

        @Deprecated
        public ef[] m8257u(int i) {
            return new ef[i];
        }
    }

    static {
        CREATOR = new C18431();
    }

    @Deprecated
    ef(Parcel parcel) {
        readFromParcel(parcel);
    }

    public ef(String str, String str2, String str3) {
        this.wp = str;
        this.wq = str2;
        this.mValue = str3;
    }

    @Deprecated
    private void readFromParcel(Parcel in) {
        this.wp = in.readString();
        this.wq = in.readString();
        this.mValue = in.readString();
    }

    @Deprecated
    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.wp;
    }

    public String getValue() {
        return this.mValue;
    }

    @Deprecated
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(this.wp);
        out.writeString(this.wq);
        out.writeString(this.mValue);
    }
}
