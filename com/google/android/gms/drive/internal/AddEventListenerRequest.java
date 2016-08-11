package com.google.android.gms.drive.internal;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class AddEventListenerRequest implements SafeParcelable {
    public static final Creator CREATOR;
    final int ES;
    final PendingIntent ET;
    final DriveId Ew;
    final int xH;

    static {
        CREATOR = new C1500a();
    }

    AddEventListenerRequest(int versionCode, DriveId driveId, int eventType, PendingIntent subscriptionIntent) {
        this.xH = versionCode;
        this.Ew = driveId;
        this.ES = eventType;
        this.ET = subscriptionIntent;
    }

    public AddEventListenerRequest(DriveId id, int eventType, PendingIntent subscriptionIntent) {
        this(1, id, eventType, subscriptionIntent);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C1500a.m6399a(this, dest, flags);
    }
}
