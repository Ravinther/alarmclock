package com.google.android.gms.maps.model.internal;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.C1615d;
import com.google.android.gms.dynamic.C1615d.C1617a;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

/* renamed from: com.google.android.gms.maps.model.internal.a */
public interface C2173a extends IInterface {

    /* renamed from: com.google.android.gms.maps.model.internal.a.a */
    public static abstract class C2175a extends Binder implements C2173a {

        /* renamed from: com.google.android.gms.maps.model.internal.a.a.a */
        private static class C2174a implements C2173a {
            private IBinder kn;

            C2174a(IBinder iBinder) {
                this.kn = iBinder;
            }

            public IBinder asBinder() {
                return this.kn;
            }

            public C1615d m9136b(Bitmap bitmap) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    if (bitmap != null) {
                        obtain.writeInt(1);
                        bitmap.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kn.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    C1615d K = C1617a.m6732K(obtain2.readStrongBinder());
                    return K;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public C1615d bK(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    obtain.writeInt(i);
                    this.kn.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    C1615d K = C1617a.m6732K(obtain2.readStrongBinder());
                    return K;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public C1615d ba(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    obtain.writeString(str);
                    this.kn.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    C1615d K = C1617a.m6732K(obtain2.readStrongBinder());
                    return K;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public C1615d bb(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    obtain.writeString(str);
                    this.kn.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    C1615d K = C1617a.m6732K(obtain2.readStrongBinder());
                    return K;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public C1615d bc(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    obtain.writeString(str);
                    this.kn.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    C1615d K = C1617a.m6732K(obtain2.readStrongBinder());
                    return K;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public C1615d m9137c(float f) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    obtain.writeFloat(f);
                    this.kn.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    C1615d K = C1617a.m6732K(obtain2.readStrongBinder());
                    return K;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public C1615d iH() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    this.kn.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    C1615d K = C1617a.m6732K(obtain2.readStrongBinder());
                    return K;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static C2173a aB(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C2173a)) ? new C2174a(iBinder) : (C2173a) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) {
            IBinder iBinder = null;
            C1615d bK;
            switch (code) {
                case Base64.NO_PADDING /*1*/:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    bK = bK(data.readInt());
                    reply.writeNoException();
                    reply.writeStrongBinder(bK != null ? bK.asBinder() : null);
                    return true;
                case Base64.NO_WRAP /*2*/:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    bK = ba(data.readString());
                    reply.writeNoException();
                    if (bK != null) {
                        iBinder = bK.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    bK = bb(data.readString());
                    reply.writeNoException();
                    if (bK != null) {
                        iBinder = bK.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case Base64.CRLF /*4*/:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    bK = iH();
                    reply.writeNoException();
                    if (bK != null) {
                        iBinder = bK.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    bK = m9135c(data.readFloat());
                    reply.writeNoException();
                    if (bK != null) {
                        iBinder = bK.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    bK = m9134b(data.readInt() != 0 ? (Bitmap) Bitmap.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    if (bK != null) {
                        iBinder = bK.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    bK = bc(data.readString());
                    reply.writeNoException();
                    if (bK != null) {
                        iBinder = bK.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    C1615d m9134b(Bitmap bitmap);

    C1615d bK(int i);

    C1615d ba(String str);

    C1615d bb(String str);

    C1615d bc(String str);

    C1615d m9135c(float f);

    C1615d iH();
}
