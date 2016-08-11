package com.google.android.gms.games.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.avg.toolkit.ITKSvc;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.LocationStatusCodes;

public interface IRoomService extends IInterface {

    public static abstract class Stub extends Binder implements IRoomService {

        private static class Proxy implements IRoomService {
            private IBinder kn;

            public void m7420B(boolean z) {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.kn.transact(1008, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m7421a(IBinder iBinder, IRoomServiceCallbacks iRoomServiceCallbacks) {
                IBinder iBinder2 = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    obtain.writeStrongBinder(iBinder);
                    if (iRoomServiceCallbacks != null) {
                        iBinder2 = iRoomServiceCallbacks.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder2);
                    this.kn.transact(LocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m7422a(DataHolder dataHolder, boolean z) {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.kn.transact(1006, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m7423a(String str, String str2, String str3) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.kn.transact(ITKSvc.ACTION_NOTIFY_ABOUT_NEW_LICENSE, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m7424a(byte[] bArr, String str, int i) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    obtain.writeByteArray(bArr);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.kn.transact(1009, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m7425a(byte[] bArr, String[] strArr) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    obtain.writeByteArray(bArr);
                    obtain.writeStringArray(strArr);
                    this.kn.transact(1010, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void aM(String str) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    obtain.writeString(str);
                    this.kn.transact(1013, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void aN(String str) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    obtain.writeString(str);
                    this.kn.transact(1014, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.kn;
            }

            public void gM() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    this.kn.transact(LocationStatusCodes.GEOFENCE_TOO_MANY_PENDING_INTENTS, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void gN() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    this.kn.transact(ITKSvc.ACTION_ALARM, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void gO() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    this.kn.transact(1005, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void gP() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    this.kn.transact(1007, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m7426p(String str, int i) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.kn.transact(1011, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m7427q(String str, int i) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.kn.transact(1012, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.google.android.gms.games.internal.IRoomService");
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) {
            boolean z = false;
            switch (code) {
                case LocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES /*1001*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    m7413a(data.readStrongBinder(), com.google.android.gms.games.internal.IRoomServiceCallbacks.Stub.m7454Q(data.readStrongBinder()));
                    return true;
                case LocationStatusCodes.GEOFENCE_TOO_MANY_PENDING_INTENTS /*1002*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    gM();
                    return true;
                case ITKSvc.ACTION_ALARM /*1003*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    gN();
                    return true;
                case ITKSvc.ACTION_NOTIFY_ABOUT_NEW_LICENSE /*1004*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    m7415a(data.readString(), data.readString(), data.readString());
                    return true;
                case 1005:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    gO();
                    return true;
                case 1006:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    DataHolder createFromParcel = data.readInt() != 0 ? DataHolder.CREATOR.createFromParcel(data) : null;
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    m7414a(createFromParcel, z);
                    return true;
                case 1007:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    gP();
                    return true;
                case 1008:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    m7412B(z);
                    return true;
                case 1009:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    m7416a(data.createByteArray(), data.readString(), data.readInt());
                    return true;
                case 1010:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    m7417a(data.createByteArray(), data.createStringArray());
                    return true;
                case 1011:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    m7418p(data.readString(), data.readInt());
                    return true;
                case 1012:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    m7419q(data.readString(), data.readInt());
                    return true;
                case 1013:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    aM(data.readString());
                    return true;
                case 1014:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    aN(data.readString());
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.games.internal.IRoomService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void m7412B(boolean z);

    void m7413a(IBinder iBinder, IRoomServiceCallbacks iRoomServiceCallbacks);

    void m7414a(DataHolder dataHolder, boolean z);

    void m7415a(String str, String str2, String str3);

    void m7416a(byte[] bArr, String str, int i);

    void m7417a(byte[] bArr, String[] strArr);

    void aM(String str);

    void aN(String str);

    void gM();

    void gN();

    void gO();

    void gP();

    void m7418p(String str, int i);

    void m7419q(String str, int i);
}
