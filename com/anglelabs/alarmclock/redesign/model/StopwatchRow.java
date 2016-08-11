package com.anglelabs.alarmclock.redesign.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class StopwatchRow implements Parcelable {
    public static final Creator CREATOR;
    public final String f2033a;
    public final String f2034b;

    /* renamed from: com.anglelabs.alarmclock.redesign.model.StopwatchRow.1 */
    static class C07721 implements Creator {
        C07721() {
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return m3647a(x0);
        }

        public /* synthetic */ Object[] newArray(int x0) {
            return m3648a(x0);
        }

        public StopwatchRow m3647a(Parcel p) {
            return new StopwatchRow(p);
        }

        public StopwatchRow[] m3648a(int size) {
            return new StopwatchRow[size];
        }
    }

    static {
        CREATOR = new C07721();
    }

    public StopwatchRow(Parcel p) {
        this.f2033a = p.readString();
        this.f2034b = p.readString();
    }

    public StopwatchRow(String lapTime, String totalTime) {
        this.f2033a = lapTime;
        this.f2034b = totalTime;
    }

    public String toString() {
        return this.f2033a + ";" + this.f2034b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.f2033a);
        dest.writeString(this.f2034b);
    }
}
