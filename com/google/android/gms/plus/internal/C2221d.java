package com.google.android.gms.plus.internal;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.avg.ui.general.C1091c.C1087k;
import com.google.android.gms.internal.fk;
import com.google.android.gms.internal.fk.C1901a;
import com.google.android.gms.internal.gg;
import com.google.android.gms.plus.internal.C2214b.C2215a;
import com.millennialmedia.android.C2513R;
import com.millennialmedia.android.MMException;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;
import java.util.List;

/* renamed from: com.google.android.gms.plus.internal.d */
public interface C2221d extends IInterface {

    /* renamed from: com.google.android.gms.plus.internal.d.a */
    public static abstract class C2223a extends Binder implements C2221d {

        /* renamed from: com.google.android.gms.plus.internal.d.a.a */
        private static class C2222a implements C2221d {
            private IBinder kn;

            C2222a(IBinder iBinder) {
                this.kn = iBinder;
            }

            public fk m9226a(C2214b c2214b, int i, int i2, int i3, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c2214b != null ? c2214b.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    this.kn.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                    fk A = C1901a.m8448A(obtain2.readStrongBinder());
                    return A;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m9227a(gg ggVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    if (ggVar != null) {
                        obtain.writeInt(1);
                        ggVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kn.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m9228a(C2214b c2214b) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c2214b != null ? c2214b.asBinder() : null);
                    this.kn.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m9229a(C2214b c2214b, int i, String str, Uri uri, String str2, String str3) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c2214b != null ? c2214b.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.kn.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m9230a(C2214b c2214b, Uri uri, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c2214b != null ? c2214b.asBinder() : null);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kn.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m9231a(C2214b c2214b, gg ggVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c2214b != null ? c2214b.asBinder() : null);
                    if (ggVar != null) {
                        obtain.writeInt(1);
                        ggVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kn.transact(45, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m9232a(C2214b c2214b, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c2214b != null ? c2214b.asBinder() : null);
                    obtain.writeString(str);
                    this.kn.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m9233a(C2214b c2214b, String str, String str2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c2214b != null ? c2214b.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.kn.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m9234a(C2214b c2214b, List list) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c2214b != null ? c2214b.asBinder() : null);
                    obtain.writeStringList(list);
                    this.kn.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.kn;
            }

            public void m9235b(C2214b c2214b) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c2214b != null ? c2214b.asBinder() : null);
                    this.kn.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m9236b(C2214b c2214b, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c2214b != null ? c2214b.asBinder() : null);
                    obtain.writeString(str);
                    this.kn.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m9237c(C2214b c2214b, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c2214b != null ? c2214b.asBinder() : null);
                    obtain.writeString(str);
                    this.kn.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void clearDefaultAccount() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    this.kn.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m9238d(C2214b c2214b, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c2214b != null ? c2214b.asBinder() : null);
                    obtain.writeString(str);
                    this.kn.transact(40, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m9239e(C2214b c2214b, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c2214b != null ? c2214b.asBinder() : null);
                    obtain.writeString(str);
                    this.kn.transact(44, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getAccountName() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    this.kn.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String iK() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    this.kn.transact(41, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean iL() {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    this.kn.transact(42, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String iM() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    this.kn.transact(43, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void removeMoment(String momentId) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeString(momentId);
                    this.kn.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static C2221d aQ(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.plus.internal.IPlusService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C2221d)) ? new C2222a(iBinder) : (C2221d) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) {
            gg ggVar = null;
            String accountName;
            switch (code) {
                case Base64.NO_PADDING /*1*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    m9218a(C2215a.aO(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case Base64.NO_WRAP /*2*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    m9219a(C2215a.aO(data.readStrongBinder()), data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    m9222b(C2215a.aO(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case Base64.CRLF /*4*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    m9213a(data.readInt() != 0 ? gg.CREATOR.m8594x(data) : null);
                    reply.writeNoException();
                    return true;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    accountName = getAccountName();
                    reply.writeNoException();
                    reply.writeString(accountName);
                    return true;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    clearDefaultAccount();
                    reply.writeNoException();
                    return true;
                case Base64.URL_SAFE /*8*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    m9214a(C2215a.aO(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor /*9*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    m9216a(C2215a.aO(data.readStrongBinder()), data.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case C2513R.styleable.MMAdView_height /*14*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    m9215a(C2215a.aO(data.readStrongBinder()), data.readInt(), data.readString(), data.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(data) : null, data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                case Base64.NO_CLOSE /*16*/:
                    IBinder asBinder;
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    fk a = m9212a(C2215a.aO(data.readStrongBinder()), data.readInt(), data.readInt(), data.readInt(), data.readString());
                    reply.writeNoException();
                    if (a != null) {
                        asBinder = a.asBinder();
                    }
                    reply.writeStrongBinder(asBinder);
                    return true;
                case MMException.CACHE_NOT_EMPTY /*17*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    removeMoment(data.readString());
                    reply.writeNoException();
                    return true;
                case C1087k.ActionBar_itemPadding /*18*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    m9223c(C2215a.aO(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case Encoder.LINE_GROUPS /*19*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    m9221b(C2215a.aO(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 34:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    m9220a(C2215a.aO(data.readStrongBinder()), data.createStringArrayList());
                    reply.writeNoException();
                    return true;
                case 40:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    m9224d(C2215a.aO(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 41:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    accountName = iK();
                    reply.writeNoException();
                    reply.writeString(accountName);
                    return true;
                case 42:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    boolean iL = iL();
                    reply.writeNoException();
                    reply.writeInt(iL ? 1 : 0);
                    return true;
                case 43:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    accountName = iM();
                    reply.writeNoException();
                    reply.writeString(accountName);
                    return true;
                case 44:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    m9225e(C2215a.aO(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 45:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    C2214b aO = C2215a.aO(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        ggVar = gg.CREATOR.m8594x(data);
                    }
                    m9217a(aO, ggVar);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.plus.internal.IPlusService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    fk m9212a(C2214b c2214b, int i, int i2, int i3, String str);

    void m9213a(gg ggVar);

    void m9214a(C2214b c2214b);

    void m9215a(C2214b c2214b, int i, String str, Uri uri, String str2, String str3);

    void m9216a(C2214b c2214b, Uri uri, Bundle bundle);

    void m9217a(C2214b c2214b, gg ggVar);

    void m9218a(C2214b c2214b, String str);

    void m9219a(C2214b c2214b, String str, String str2);

    void m9220a(C2214b c2214b, List list);

    void m9221b(C2214b c2214b);

    void m9222b(C2214b c2214b, String str);

    void m9223c(C2214b c2214b, String str);

    void clearDefaultAccount();

    void m9224d(C2214b c2214b, String str);

    void m9225e(C2214b c2214b, String str);

    String getAccountName();

    String iK();

    boolean iL();

    String iM();

    void removeMoment(String str);
}
