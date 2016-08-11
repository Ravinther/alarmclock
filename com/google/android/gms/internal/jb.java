package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.jd.C2004a;
import com.google.android.gms.internal.je.C2006a;
import com.google.android.gms.wallet.C2347d;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

public interface jb extends IInterface {

    /* renamed from: com.google.android.gms.internal.jb.a */
    public static abstract class C2000a extends Binder implements jb {

        /* renamed from: com.google.android.gms.internal.jb.a.a */
        private static class C1999a implements jb {
            private IBinder kn;

            C1999a(IBinder iBinder) {
                this.kn = iBinder;
            }

            public void m8830a(Bundle bundle, je jeVar) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (jeVar != null) {
                        iBinder = jeVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.kn.transact(5, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m8831a(iv ivVar, Bundle bundle, je jeVar) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (ivVar != null) {
                        obtain.writeInt(1);
                        ivVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (jeVar != null) {
                        iBinder = jeVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.kn.transact(8, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m8832a(FullWalletRequest fullWalletRequest, Bundle bundle, je jeVar) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (fullWalletRequest != null) {
                        obtain.writeInt(1);
                        fullWalletRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (jeVar != null) {
                        iBinder = jeVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.kn.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m8833a(MaskedWalletRequest maskedWalletRequest, Bundle bundle, jd jdVar) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (maskedWalletRequest != null) {
                        obtain.writeInt(1);
                        maskedWalletRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (jdVar != null) {
                        iBinder = jdVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.kn.transact(7, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m8834a(MaskedWalletRequest maskedWalletRequest, Bundle bundle, je jeVar) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (maskedWalletRequest != null) {
                        obtain.writeInt(1);
                        maskedWalletRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (jeVar != null) {
                        iBinder = jeVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.kn.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m8835a(NotifyTransactionStatusRequest notifyTransactionStatusRequest, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (notifyTransactionStatusRequest != null) {
                        obtain.writeInt(1);
                        notifyTransactionStatusRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kn.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m8836a(C2347d c2347d, Bundle bundle, je jeVar) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (c2347d != null) {
                        obtain.writeInt(1);
                        c2347d.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (jeVar != null) {
                        iBinder = jeVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.kn.transact(6, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m8837a(String str, String str2, Bundle bundle, je jeVar) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (jeVar != null) {
                        iBinder = jeVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.kn.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.kn;
            }
        }

        public static jb aU(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wallet.internal.IOwService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof jb)) ? new C1999a(iBinder) : (jb) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) {
            switch (code) {
                case Base64.NO_PADDING /*1*/:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    m8826a(data.readInt() != 0 ? (MaskedWalletRequest) MaskedWalletRequest.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null, C2006a.aX(data.readStrongBinder()));
                    return true;
                case Base64.NO_WRAP /*2*/:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    m8824a(data.readInt() != 0 ? (FullWalletRequest) FullWalletRequest.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null, C2006a.aX(data.readStrongBinder()));
                    return true;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    m8829a(data.readString(), data.readString(), data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null, C2006a.aX(data.readStrongBinder()));
                    return true;
                case Base64.CRLF /*4*/:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    m8827a(data.readInt() != 0 ? (NotifyTransactionStatusRequest) NotifyTransactionStatusRequest.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    return true;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    m8822a(data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null, C2006a.aX(data.readStrongBinder()));
                    return true;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    m8828a(data.readInt() != 0 ? (C2347d) C2347d.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null, C2006a.aX(data.readStrongBinder()));
                    return true;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    m8825a(data.readInt() != 0 ? (MaskedWalletRequest) MaskedWalletRequest.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null, C2004a.aW(data.readStrongBinder()));
                    return true;
                case Base64.URL_SAFE /*8*/:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    m8823a(data.readInt() != 0 ? (iv) iv.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null, C2006a.aX(data.readStrongBinder()));
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.wallet.internal.IOwService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void m8822a(Bundle bundle, je jeVar);

    void m8823a(iv ivVar, Bundle bundle, je jeVar);

    void m8824a(FullWalletRequest fullWalletRequest, Bundle bundle, je jeVar);

    void m8825a(MaskedWalletRequest maskedWalletRequest, Bundle bundle, jd jdVar);

    void m8826a(MaskedWalletRequest maskedWalletRequest, Bundle bundle, je jeVar);

    void m8827a(NotifyTransactionStatusRequest notifyTransactionStatusRequest, Bundle bundle);

    void m8828a(C2347d c2347d, Bundle bundle, je jeVar);

    void m8829a(String str, String str2, Bundle bundle, je jeVar);
}
