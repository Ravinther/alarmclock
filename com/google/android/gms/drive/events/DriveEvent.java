package com.google.android.gms.drive.events;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public interface DriveEvent extends SafeParcelable {
    public static final int TYPE_CHANGE = 1;

    public interface Listener {
        void onEvent(DriveEvent driveEvent);
    }

    DriveId getDriveId();

    int getType();
}
