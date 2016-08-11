package com.google.android.gms.drive.events;

import com.google.android.gms.drive.DriveId;

/* renamed from: com.google.android.gms.drive.events.c */
public class C1499c {
    public static boolean m6398a(int i, DriveId driveId) {
        return (driveId == null && (4 & ((long) (1 << i))) == 0) ? false : true;
    }
}
