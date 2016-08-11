package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.cast.ApplicationMetadata;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

public interface eq extends IInterface {

    /* renamed from: com.google.android.gms.internal.eq.a */
    public static abstract class C1861a extends Binder implements eq {
        public C1861a() {
            attachInterface(this, "com.google.android.gms.cast.internal.ICastDeviceControllerListener");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) {
            boolean z = false;
            switch (code) {
                case Base64.NO_PADDING /*1*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    m8319z(data.readInt());
                    return true;
                case Base64.NO_WRAP /*2*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    ApplicationMetadata applicationMetadata = data.readInt() != 0 ? (ApplicationMetadata) ApplicationMetadata.CREATOR.createFromParcel(data) : null;
                    String readString = data.readString();
                    String readString2 = data.readString();
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    m8313a(applicationMetadata, readString, readString2, z);
                    return true;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    m8310A(data.readInt());
                    return true;
                case Base64.CRLF /*4*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    String readString3 = data.readString();
                    double readDouble = data.readDouble();
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    m8316b(readString3, readDouble, z);
                    return true;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    m8318d(data.readString(), data.readString());
                    return true;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    m8317b(data.readString(), data.createByteArray());
                    return true;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    m8312C(data.readInt());
                    return true;
                case Base64.URL_SAFE /*8*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    m8311B(data.readInt());
                    return true;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor /*9*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    onApplicationDisconnected(data.readInt());
                    return true;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    m8315a(data.readString(), data.readLong(), data.readInt());
                    return true;
                case C2625R.styleable.MapAttrs_uiZoomGestures /*11*/:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    m8314a(data.readString(), data.readLong());
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void m8310A(int i);

    void m8311B(int i);

    void m8312C(int i);

    void m8313a(ApplicationMetadata applicationMetadata, String str, String str2, boolean z);

    void m8314a(String str, long j);

    void m8315a(String str, long j, int i);

    void m8316b(String str, double d, boolean z);

    void m8317b(String str, byte[] bArr);

    void m8318d(String str, String str2);

    void onApplicationDisconnected(int i);

    void m8319z(int i);
}
