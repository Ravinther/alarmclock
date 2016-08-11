package com.google.android.gms.wearable;

import android.net.Uri;
import com.google.android.gms.common.data.Freezable;
import java.util.Map;
import java.util.Set;

/* renamed from: com.google.android.gms.wearable.c */
public interface C2021c extends Freezable {
    byte[] getData();

    Uri getUri();

    Map ma();

    @Deprecated
    Set mb();
}
