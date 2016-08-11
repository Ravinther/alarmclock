package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.C1615d;
import com.google.android.gms.dynamic.C1615d.C1617a;
import com.google.android.gms.internal.bq.C1763a;
import com.mopub.mobileads.util.Base64;

public interface aq extends IInterface {

    /* renamed from: com.google.android.gms.internal.aq.a */
    public static abstract class C1747a extends Binder implements aq {

        /* renamed from: com.google.android.gms.internal.aq.a.a */
        private static class C1746a implements aq {
            private IBinder kn;

            C1746a(IBinder iBinder) {
                this.kn = iBinder;
            }

            public IBinder m7853a(C1615d c1615d, ak akVar, String str, bq bqVar, int i) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                    obtain.writeStrongBinder(c1615d != null ? c1615d.asBinder() : null);
                    if (akVar != null) {
                        obtain.writeInt(1);
                        akVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (bqVar != null) {
                        iBinder = bqVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    this.kn.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    iBinder = obtain2.readStrongBinder();
                    return iBinder;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.kn;
            }
        }

        public static aq m7854g(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof aq)) ? new C1746a(iBinder) : (aq) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) {
            switch (code) {
                case Base64.NO_PADDING /*1*/:
                    data.enforceInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                    IBinder a = m7852a(C1617a.m6732K(data.readStrongBinder()), data.readInt() != 0 ? ak.CREATOR.m7832b(data) : null, data.readString(), C1763a.m7927i(data.readStrongBinder()), data.readInt());
                    reply.writeNoException();
                    reply.writeStrongBinder(a);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    IBinder m7852a(C1615d c1615d, ak akVar, String str, bq bqVar, int i);
}
