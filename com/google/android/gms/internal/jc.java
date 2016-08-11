package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.C1611c;
import com.google.android.gms.dynamic.C1611c.C1612a;
import com.google.android.gms.dynamic.C1615d;
import com.google.android.gms.dynamic.C1615d.C1617a;
import com.google.android.gms.internal.iz.C1994a;
import com.google.android.gms.internal.ja.C1998a;
import com.google.android.gms.wallet.fragment.WalletFragmentOptions;
import com.mopub.mobileads.util.Base64;

public interface jc extends IInterface {

    /* renamed from: com.google.android.gms.internal.jc.a */
    public static abstract class C2002a extends Binder implements jc {

        /* renamed from: com.google.android.gms.internal.jc.a.a */
        private static class C2001a implements jc {
            private IBinder kn;

            C2001a(IBinder iBinder) {
                this.kn = iBinder;
            }

            public iz m8839a(C1615d c1615d, C1611c c1611c, WalletFragmentOptions walletFragmentOptions, ja jaVar) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
                    obtain.writeStrongBinder(c1615d != null ? c1615d.asBinder() : null);
                    obtain.writeStrongBinder(c1611c != null ? c1611c.asBinder() : null);
                    if (walletFragmentOptions != null) {
                        obtain.writeInt(1);
                        walletFragmentOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (jaVar != null) {
                        iBinder = jaVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.kn.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    iz aS = C1994a.aS(obtain2.readStrongBinder());
                    return aS;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.kn;
            }
        }

        public static jc aV(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof jc)) ? new C2001a(iBinder) : (jc) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) {
            IBinder iBinder = null;
            switch (code) {
                case Base64.NO_PADDING /*1*/:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
                    iz a = m8838a(C1617a.m6732K(data.readStrongBinder()), C1612a.m6726J(data.readStrongBinder()), data.readInt() != 0 ? (WalletFragmentOptions) WalletFragmentOptions.CREATOR.createFromParcel(data) : null, C1998a.aT(data.readStrongBinder()));
                    reply.writeNoException();
                    if (a != null) {
                        iBinder = a.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    iz m8838a(C1615d c1615d, C1611c c1611c, WalletFragmentOptions walletFragmentOptions, ja jaVar);
}
