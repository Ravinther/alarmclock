package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

public interface kh extends IInterface {

    /* renamed from: com.google.android.gms.internal.kh.a */
    public static abstract class C2022a extends Binder implements kh {
        public C2022a() {
            attachInterface(this, "com.google.android.gms.wearable.internal.IWearableListener");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) {
            kk kkVar = null;
            switch (code) {
                case Base64.NO_PADDING /*1*/:
                    DataHolder createFromParcel;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                    if (data.readInt() != 0) {
                        createFromParcel = DataHolder.CREATOR.createFromParcel(data);
                    }
                    m8894M(createFromParcel);
                    return true;
                case Base64.NO_WRAP /*2*/:
                    ki kiVar;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                    if (data.readInt() != 0) {
                        kiVar = (ki) ki.CREATOR.createFromParcel(data);
                    }
                    m8895a(kiVar);
                    return true;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                    if (data.readInt() != 0) {
                        kkVar = (kk) kk.CREATOR.createFromParcel(data);
                    }
                    m8896a(kkVar);
                    return true;
                case Base64.CRLF /*4*/:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                    if (data.readInt() != 0) {
                        kkVar = (kk) kk.CREATOR.createFromParcel(data);
                    }
                    m8897b(kkVar);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.wearable.internal.IWearableListener");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void m8894M(DataHolder dataHolder);

    void m8895a(ki kiVar);

    void m8896a(kk kkVar);

    void m8897b(kk kkVar);
}
