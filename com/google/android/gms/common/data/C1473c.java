package com.google.android.gms.common.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.common.data.c */
public class C1473c extends DataBuffer {
    private static final String[] BF;
    private final Creator BG;

    static {
        BF = new String[]{"data"};
    }

    public C1473c(DataHolder dataHolder, Creator creator) {
        super(dataHolder);
        this.BG = creator;
    }

    public SafeParcelable m6275F(int i) {
        byte[] byteArray = this.BB.getByteArray("data", i, 0);
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(byteArray, 0, byteArray.length);
        obtain.setDataPosition(0);
        SafeParcelable safeParcelable = (SafeParcelable) this.BG.createFromParcel(obtain);
        obtain.recycle();
        return safeParcelable;
    }

    public /* synthetic */ Object get(int x0) {
        return m6275F(x0);
    }
}
