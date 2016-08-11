package com.google.android.gms.maps;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.dynamic.C1601f;
import com.google.android.gms.dynamic.C1610a;
import com.google.android.gms.dynamic.C1618e;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.internal.fq;
import com.google.android.gms.maps.internal.C2156u;
import com.google.android.gms.maps.internal.IMapViewDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class MapView extends FrameLayout {
    private GoogleMap RT;
    private final C2094b RW;

    /* renamed from: com.google.android.gms.maps.MapView.a */
    static class C2093a implements LifecycleDelegate {
        private final ViewGroup RX;
        private final IMapViewDelegate RY;
        private View RZ;

        public C2093a(ViewGroup viewGroup, IMapViewDelegate iMapViewDelegate) {
            this.RY = (IMapViewDelegate) fq.m8520f(iMapViewDelegate);
            this.RX = (ViewGroup) fq.m8520f(viewGroup);
        }

        public IMapViewDelegate iq() {
            return this.RY;
        }

        public void onCreate(Bundle savedInstanceState) {
            try {
                this.RY.onCreate(savedInstanceState);
                this.RZ = (View) C1618e.m6733d(this.RY.getView());
                this.RX.removeAllViews();
                this.RX.addView(this.RZ);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            throw new UnsupportedOperationException("onCreateView not allowed on MapViewDelegate");
        }

        public void onDestroy() {
            try {
                this.RY.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroyView() {
            throw new UnsupportedOperationException("onDestroyView not allowed on MapViewDelegate");
        }

        public void onInflate(Activity activity, Bundle attrs, Bundle savedInstanceState) {
            throw new UnsupportedOperationException("onInflate not allowed on MapViewDelegate");
        }

        public void onLowMemory() {
            try {
                this.RY.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onPause() {
            try {
                this.RY.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onResume() {
            try {
                this.RY.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onSaveInstanceState(Bundle outState) {
            try {
                this.RY.onSaveInstanceState(outState);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onStart() {
        }

        public void onStop() {
        }
    }

    /* renamed from: com.google.android.gms.maps.MapView.b */
    static class C2094b extends C1610a {
        protected C1601f RV;
        private final ViewGroup Sa;
        private final GoogleMapOptions Sb;
        private final Context mContext;

        C2094b(ViewGroup viewGroup, Context context, GoogleMapOptions googleMapOptions) {
            this.Sa = viewGroup;
            this.mContext = context;
            this.Sb = googleMapOptions;
        }

        protected void m9055a(C1601f c1601f) {
            this.RV = c1601f;
            ip();
        }

        public void ip() {
            if (this.RV != null && fW() == null) {
                try {
                    this.RV.m6708a(new C2093a(this.Sa, C2156u.m9093A(this.mContext).m9068a(C1618e.m6734h(this.mContext), this.Sb)));
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                } catch (GooglePlayServicesNotAvailableException e2) {
                }
            }
        }
    }

    public MapView(Context context) {
        super(context);
        this.RW = new C2094b(this, context, null);
    }

    public MapView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.RW = new C2094b(this, context, GoogleMapOptions.createFromAttributes(context, attrs));
    }

    public MapView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.RW = new C2094b(this, context, GoogleMapOptions.createFromAttributes(context, attrs));
    }

    public MapView(Context context, GoogleMapOptions options) {
        super(context);
        this.RW = new C2094b(this, context, options);
    }

    public final GoogleMap getMap() {
        if (this.RT != null) {
            return this.RT;
        }
        this.RW.ip();
        if (this.RW.fW() == null) {
            return null;
        }
        try {
            this.RT = new GoogleMap(((C2093a) this.RW.fW()).iq().getMap());
            return this.RT;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void onCreate(Bundle savedInstanceState) {
        this.RW.onCreate(savedInstanceState);
        if (this.RW.fW() == null) {
            C2094b c2094b = this.RW;
            C1610a.m6721b((FrameLayout) this);
        }
    }

    public final void onDestroy() {
        this.RW.onDestroy();
    }

    public final void onLowMemory() {
        this.RW.onLowMemory();
    }

    public final void onPause() {
        this.RW.onPause();
    }

    public final void onResume() {
        this.RW.onResume();
    }

    public final void onSaveInstanceState(Bundle outState) {
        this.RW.onSaveInstanceState(outState);
    }
}
