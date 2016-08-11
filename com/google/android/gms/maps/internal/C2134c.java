package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.C1615d;
import com.google.android.gms.dynamic.C1615d.C1617a;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.StreetViewPanoramaOptions;
import com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate.C2114a;
import com.google.android.gms.maps.internal.IMapFragmentDelegate.C2119a;
import com.google.android.gms.maps.internal.IMapViewDelegate.C2121a;
import com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate.C2127a;
import com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate.C2129a;
import com.google.android.gms.maps.model.internal.C2173a;
import com.google.android.gms.maps.model.internal.C2173a.C2175a;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

/* renamed from: com.google.android.gms.maps.internal.c */
public interface C2134c extends IInterface {

    /* renamed from: com.google.android.gms.maps.internal.c.a */
    public static abstract class C2136a extends Binder implements C2134c {

        /* renamed from: com.google.android.gms.maps.internal.c.a.a */
        private static class C2135a implements C2134c {
            private IBinder kn;

            C2135a(IBinder iBinder) {
                this.kn = iBinder;
            }

            public IMapViewDelegate m9074a(C1615d c1615d, GoogleMapOptions googleMapOptions) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    obtain.writeStrongBinder(c1615d != null ? c1615d.asBinder() : null);
                    if (googleMapOptions != null) {
                        obtain.writeInt(1);
                        googleMapOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kn.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    IMapViewDelegate ag = C2121a.ag(obtain2.readStrongBinder());
                    return ag;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IStreetViewPanoramaViewDelegate m9075a(C1615d c1615d, StreetViewPanoramaOptions streetViewPanoramaOptions) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    obtain.writeStrongBinder(c1615d != null ? c1615d.asBinder() : null);
                    if (streetViewPanoramaOptions != null) {
                        obtain.writeInt(1);
                        streetViewPanoramaOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kn.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    IStreetViewPanoramaViewDelegate az = C2129a.az(obtain2.readStrongBinder());
                    return az;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void m9076a(C1615d c1615d, int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    obtain.writeStrongBinder(c1615d != null ? c1615d.asBinder() : null);
                    obtain.writeInt(i);
                    this.kn.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.kn;
            }

            public void m9077g(C1615d c1615d) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    obtain.writeStrongBinder(c1615d != null ? c1615d.asBinder() : null);
                    this.kn.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IMapFragmentDelegate m9078h(C1615d c1615d) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    obtain.writeStrongBinder(c1615d != null ? c1615d.asBinder() : null);
                    this.kn.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    IMapFragmentDelegate af = C2119a.af(obtain2.readStrongBinder());
                    return af;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IStreetViewPanoramaFragmentDelegate m9079i(C1615d c1615d) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    obtain.writeStrongBinder(c1615d != null ? c1615d.asBinder() : null);
                    this.kn.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    IStreetViewPanoramaFragmentDelegate ay = C2127a.ay(obtain2.readStrongBinder());
                    return ay;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public ICameraUpdateFactoryDelegate ix() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    this.kn.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    ICameraUpdateFactoryDelegate Z = C2114a.m9065Z(obtain2.readStrongBinder());
                    return Z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public C2173a iy() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    this.kn.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    C2173a aB = C2175a.aB(obtain2.readStrongBinder());
                    return aB;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static C2134c ab(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.ICreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C2134c)) ? new C2135a(iBinder) : (C2134c) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) {
            IBinder iBinder = null;
            switch (code) {
                case Base64.NO_PADDING /*1*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    m9071g(C1617a.m6732K(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Base64.NO_WRAP /*2*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    IMapFragmentDelegate h = m9072h(C1617a.m6732K(data.readStrongBinder()));
                    reply.writeNoException();
                    if (h != null) {
                        iBinder = h.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    IMapViewDelegate a = m9068a(C1617a.m6732K(data.readStrongBinder()), data.readInt() != 0 ? GoogleMapOptions.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    if (a != null) {
                        iBinder = a.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case Base64.CRLF /*4*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    ICameraUpdateFactoryDelegate ix = ix();
                    reply.writeNoException();
                    if (ix != null) {
                        iBinder = ix.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    C2173a iy = iy();
                    reply.writeNoException();
                    if (iy != null) {
                        iBinder = iy.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    m9070a(C1617a.m6732K(data.readStrongBinder()), data.readInt());
                    reply.writeNoException();
                    return true;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    IStreetViewPanoramaViewDelegate a2 = m9069a(C1617a.m6732K(data.readStrongBinder()), data.readInt() != 0 ? StreetViewPanoramaOptions.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    if (a2 != null) {
                        iBinder = a2.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case Base64.URL_SAFE /*8*/:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    IStreetViewPanoramaFragmentDelegate i = m9073i(C1617a.m6732K(data.readStrongBinder()));
                    reply.writeNoException();
                    if (i != null) {
                        iBinder = i.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.internal.ICreator");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    IMapViewDelegate m9068a(C1615d c1615d, GoogleMapOptions googleMapOptions);

    IStreetViewPanoramaViewDelegate m9069a(C1615d c1615d, StreetViewPanoramaOptions streetViewPanoramaOptions);

    void m9070a(C1615d c1615d, int i);

    void m9071g(C1615d c1615d);

    IMapFragmentDelegate m9072h(C1615d c1615d);

    IStreetViewPanoramaFragmentDelegate m9073i(C1615d c1615d);

    ICameraUpdateFactoryDelegate ix();

    C2173a iy();
}
