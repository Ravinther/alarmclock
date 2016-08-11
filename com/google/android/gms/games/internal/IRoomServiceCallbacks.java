package com.google.android.gms.games.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import com.avg.toolkit.ITKSvc;
import com.google.android.gms.location.LocationStatusCodes;

public interface IRoomServiceCallbacks extends IInterface {

    public static abstract class Stub extends Binder implements IRoomServiceCallbacks {

        private static class Proxy implements IRoomServiceCallbacks {
            private IBinder kn;

            Proxy(IBinder remote) {
                this.kn = remote;
            }

            public void m7441P(IBinder iBinder) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeStrongBinder(iBinder);
                    this.kn.transact(1021, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m7442a(ParcelFileDescriptor parcelFileDescriptor, int i) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    if (parcelFileDescriptor != null) {
                        obtain.writeInt(1);
                        parcelFileDescriptor.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    this.kn.transact(1024, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m7443a(ConnectionInfo connectionInfo) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    if (connectionInfo != null) {
                        obtain.writeInt(1);
                        connectionInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kn.transact(1022, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m7444a(String str, byte[] bArr, int i) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    obtain.writeByteArray(bArr);
                    obtain.writeInt(i);
                    this.kn.transact(LocationStatusCodes.GEOFENCE_TOO_MANY_PENDING_INTENTS, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m7445a(String str, String[] strArr) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr);
                    this.kn.transact(1008, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void aO(String str) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    this.kn.transact(ITKSvc.ACTION_ALARM, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void aP(String str) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    this.kn.transact(ITKSvc.ACTION_NOTIFY_ABOUT_NEW_LICENSE, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void aQ(String str) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    this.kn.transact(1005, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void aR(String str) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    this.kn.transact(1006, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void aS(String str) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    this.kn.transact(1007, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void aT(String str) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    this.kn.transact(1018, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void aU(String str) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    this.kn.transact(1019, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.kn;
            }

            public void m7446b(String str, String[] strArr) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr);
                    this.kn.transact(1009, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void bb(int i) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeInt(i);
                    this.kn.transact(1020, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m7447c(int i, int i2, String str) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    this.kn.transact(LocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m7448c(String str, String[] strArr) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr);
                    this.kn.transact(1010, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m7449d(String str, String[] strArr) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr);
                    this.kn.transact(1011, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m7450e(String str, String[] strArr) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr);
                    this.kn.transact(1012, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m7451f(String str, String[] strArr) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr);
                    this.kn.transact(1013, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m7452g(String str, String[] strArr) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr);
                    this.kn.transact(1017, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void gQ() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    this.kn.transact(1016, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void gR() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    this.kn.transact(1023, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void onP2PConnected(String participantId) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(participantId);
                    this.kn.transact(1014, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void onP2PDisconnected(String participantId) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(participantId);
                    this.kn.transact(1015, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m7453r(String str, int i) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.kn.transact(1025, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.google.android.gms.games.internal.IRoomServiceCallbacks");
        }

        public static IRoomServiceCallbacks m7454Q(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IRoomServiceCallbacks)) ? new Proxy(iBinder) : (IRoomServiceCallbacks) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) {
            ParcelFileDescriptor parcelFileDescriptor = null;
            switch (code) {
                case LocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES /*1001*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    m7434c(data.readInt(), data.readInt(), data.readString());
                    return true;
                case LocationStatusCodes.GEOFENCE_TOO_MANY_PENDING_INTENTS /*1002*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    m7431a(data.readString(), data.createByteArray(), data.readInt());
                    return true;
                case ITKSvc.ACTION_ALARM /*1003*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    aO(data.readString());
                    return true;
                case ITKSvc.ACTION_NOTIFY_ABOUT_NEW_LICENSE /*1004*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    aP(data.readString());
                    return true;
                case 1005:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    aQ(data.readString());
                    return true;
                case 1006:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    aR(data.readString());
                    return true;
                case 1007:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    aS(data.readString());
                    return true;
                case 1008:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    m7432a(data.readString(), data.createStringArray());
                    return true;
                case 1009:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    m7433b(data.readString(), data.createStringArray());
                    return true;
                case 1010:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    m7435c(data.readString(), data.createStringArray());
                    return true;
                case 1011:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    m7436d(data.readString(), data.createStringArray());
                    return true;
                case 1012:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    m7437e(data.readString(), data.createStringArray());
                    return true;
                case 1013:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    m7438f(data.readString(), data.createStringArray());
                    return true;
                case 1014:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    onP2PConnected(data.readString());
                    return true;
                case 1015:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    onP2PDisconnected(data.readString());
                    return true;
                case 1016:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    gQ();
                    return true;
                case 1017:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    m7439g(data.readString(), data.createStringArray());
                    return true;
                case 1018:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    aT(data.readString());
                    return true;
                case 1019:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    aU(data.readString());
                    return true;
                case 1020:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    bb(data.readInt());
                    return true;
                case 1021:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    m7428P(data.readStrongBinder());
                    return true;
                case 1022:
                    ConnectionInfo ap;
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    if (data.readInt() != 0) {
                        ap = ConnectionInfo.CREATOR.ap(data);
                    }
                    m7430a(ap);
                    return true;
                case 1023:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    gR();
                    return true;
                case 1024:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    if (data.readInt() != 0) {
                        parcelFileDescriptor = (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(data);
                    }
                    m7429a(parcelFileDescriptor, data.readInt());
                    return true;
                case 1025:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    m7440r(data.readString(), data.readInt());
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.games.internal.IRoomServiceCallbacks");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void m7428P(IBinder iBinder);

    void m7429a(ParcelFileDescriptor parcelFileDescriptor, int i);

    void m7430a(ConnectionInfo connectionInfo);

    void m7431a(String str, byte[] bArr, int i);

    void m7432a(String str, String[] strArr);

    void aO(String str);

    void aP(String str);

    void aQ(String str);

    void aR(String str);

    void aS(String str);

    void aT(String str);

    void aU(String str);

    void m7433b(String str, String[] strArr);

    void bb(int i);

    void m7434c(int i, int i2, String str);

    void m7435c(String str, String[] strArr);

    void m7436d(String str, String[] strArr);

    void m7437e(String str, String[] strArr);

    void m7438f(String str, String[] strArr);

    void m7439g(String str, String[] strArr);

    void gQ();

    void gR();

    void onP2PConnected(String str);

    void onP2PDisconnected(String str);

    void m7440r(String str, int i);
}
