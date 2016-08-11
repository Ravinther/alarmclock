package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.C1615d;
import com.google.android.gms.dynamic.C1615d.C1617a;
import com.mopub.mobileads.util.Base64;

public interface fn extends IInterface {

    /* renamed from: com.google.android.gms.internal.fn.a */
    public static abstract class C1906a extends Binder implements fn {

        /* renamed from: com.google.android.gms.internal.fn.a.a */
        private static class C1905a implements fn {
            private IBinder kn;

            C1905a(IBinder iBinder) {
                this.kn = iBinder;
            }

            public C1615d m8508a(C1615d c1615d, int i, int i2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.ISignInButtonCreator");
                    obtain.writeStrongBinder(c1615d != null ? c1615d.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.kn.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    C1615d K = C1617a.m6732K(obtain2.readStrongBinder());
                    return K;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.kn;
            }
        }

        public static fn m8509D(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof fn)) ? new C1905a(iBinder) : (fn) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) {
            switch (code) {
                case Base64.NO_PADDING /*1*/:
                    data.enforceInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
                    C1615d a = m8507a(C1617a.m6732K(data.readStrongBinder()), data.readInt(), data.readInt());
                    reply.writeNoException();
                    reply.writeStrongBinder(a != null ? a.asBinder() : null);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.common.internal.ISignInButtonCreator");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    C1615d m8507a(C1615d c1615d, int i, int i2);
}
