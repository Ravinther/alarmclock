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
import com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class StreetViewPanoramaView extends FrameLayout {
    private StreetViewPanorama Sj;
    private final C2106a Ss;

    /* renamed from: com.google.android.gms.maps.StreetViewPanoramaView.a */
    static class C2106a extends C1610a {
        protected C1601f RV;
        private final ViewGroup Sa;
        private final StreetViewPanoramaOptions St;
        private final Context mContext;

        C2106a(ViewGroup viewGroup, Context context, StreetViewPanoramaOptions streetViewPanoramaOptions) {
            this.Sa = viewGroup;
            this.mContext = context;
            this.St = streetViewPanoramaOptions;
        }

        protected void m9059a(C1601f c1601f) {
            this.RV = c1601f;
            ip();
        }

        public void ip() {
            if (this.RV != null && fW() == null) {
                try {
                    this.RV.m6708a(new C2107b(this.Sa, C2156u.m9093A(this.mContext).m9069a(C1618e.m6734h(this.mContext), this.St)));
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                } catch (GooglePlayServicesNotAvailableException e2) {
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.maps.StreetViewPanoramaView.b */
    static class C2107b implements LifecycleDelegate {
        private final ViewGroup RX;
        private final IStreetViewPanoramaViewDelegate Su;
        private View Sv;

        public C2107b(ViewGroup viewGroup, IStreetViewPanoramaViewDelegate iStreetViewPanoramaViewDelegate) {
            this.Su = (IStreetViewPanoramaViewDelegate) fq.m8520f(iStreetViewPanoramaViewDelegate);
            this.RX = (ViewGroup) fq.m8520f(viewGroup);
        }

        public IStreetViewPanoramaViewDelegate iw() {
            return this.Su;
        }

        public void onCreate(Bundle savedInstanceState) {
            try {
                this.Su.onCreate(savedInstanceState);
                this.Sv = (View) C1618e.m6733d(this.Su.getView());
                this.RX.removeAllViews();
                this.RX.addView(this.Sv);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            throw new UnsupportedOperationException("onCreateView not allowed on StreetViewPanoramaViewDelegate");
        }

        public void onDestroy() {
            try {
                this.Su.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroyView() {
            throw new UnsupportedOperationException("onDestroyView not allowed on StreetViewPanoramaViewDelegate");
        }

        public void onInflate(Activity activity, Bundle attrs, Bundle savedInstanceState) {
            throw new UnsupportedOperationException("onInflate not allowed on StreetViewPanoramaViewDelegate");
        }

        public void onLowMemory() {
            try {
                this.Su.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onPause() {
            try {
                this.Su.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onResume() {
            try {
                this.Su.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onSaveInstanceState(Bundle outState) {
            try {
                this.Su.onSaveInstanceState(outState);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onStart() {
        }

        public void onStop() {
        }
    }

    public StreetViewPanoramaView(Context context) {
        super(context);
        this.Ss = new C2106a(this, context, null);
    }

    public StreetViewPanoramaView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.Ss = new C2106a(this, context, null);
    }

    public StreetViewPanoramaView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.Ss = new C2106a(this, context, null);
    }

    public StreetViewPanoramaView(Context context, StreetViewPanoramaOptions options) {
        super(context);
        this.Ss = new C2106a(this, context, options);
    }

    public final StreetViewPanorama getStreetViewPanorama() {
        if (this.Sj != null) {
            return this.Sj;
        }
        this.Ss.ip();
        if (this.Ss.fW() == null) {
            return null;
        }
        try {
            this.Sj = new StreetViewPanorama(((C2107b) this.Ss.fW()).iw().getStreetViewPanorama());
            return this.Sj;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void onCreate(Bundle savedInstanceState) {
        this.Ss.onCreate(savedInstanceState);
        if (this.Ss.fW() == null) {
            C2106a c2106a = this.Ss;
            C1610a.m6721b((FrameLayout) this);
        }
    }

    public final void onDestroy() {
        this.Ss.onDestroy();
    }

    public final void onLowMemory() {
        this.Ss.onLowMemory();
    }

    public final void onPause() {
        this.Ss.onPause();
    }

    public final void onResume() {
        this.Ss.onResume();
    }

    public final void onSaveInstanceState(Bundle outState) {
        this.Ss.onSaveInstanceState(outState);
    }
}
