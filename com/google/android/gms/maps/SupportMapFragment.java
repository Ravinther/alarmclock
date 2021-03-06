package com.google.android.gms.maps;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.dynamic.C1601f;
import com.google.android.gms.dynamic.C1610a;
import com.google.android.gms.dynamic.C1618e;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.internal.fq;
import com.google.android.gms.maps.internal.C2155t;
import com.google.android.gms.maps.internal.C2156u;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.IMapFragmentDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class SupportMapFragment extends Fragment {
    private GoogleMap RT;
    private final C2109b Sw;

    /* renamed from: com.google.android.gms.maps.SupportMapFragment.a */
    static class C2108a implements LifecycleDelegate {
        private final Fragment Hz;
        private final IMapFragmentDelegate RU;

        public C2108a(Fragment fragment, IMapFragmentDelegate iMapFragmentDelegate) {
            this.RU = (IMapFragmentDelegate) fq.m8520f(iMapFragmentDelegate);
            this.Hz = (Fragment) fq.m8520f(fragment);
        }

        public IMapFragmentDelegate io() {
            return this.RU;
        }

        public void onCreate(Bundle savedInstanceState) {
            if (savedInstanceState == null) {
                try {
                    savedInstanceState = new Bundle();
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                }
            }
            Bundle arguments = this.Hz.getArguments();
            if (arguments != null && arguments.containsKey("MapOptions")) {
                C2155t.m9092a(savedInstanceState, "MapOptions", arguments.getParcelable("MapOptions"));
            }
            this.RU.onCreate(savedInstanceState);
        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            try {
                return (View) C1618e.m6733d(this.RU.onCreateView(C1618e.m6734h(inflater), C1618e.m6734h(container), savedInstanceState));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroy() {
            try {
                this.RU.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroyView() {
            try {
                this.RU.onDestroyView();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onInflate(Activity activity, Bundle attrs, Bundle savedInstanceState) {
            try {
                this.RU.onInflate(C1618e.m6734h(activity), (GoogleMapOptions) attrs.getParcelable("MapOptions"), savedInstanceState);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onLowMemory() {
            try {
                this.RU.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onPause() {
            try {
                this.RU.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onResume() {
            try {
                this.RU.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onSaveInstanceState(Bundle outState) {
            try {
                this.RU.onSaveInstanceState(outState);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onStart() {
        }

        public void onStop() {
        }
    }

    /* renamed from: com.google.android.gms.maps.SupportMapFragment.b */
    static class C2109b extends C1610a {
        private final Fragment Hz;
        protected C1601f RV;
        private Activity nS;

        C2109b(Fragment fragment) {
            this.Hz = fragment;
        }

        private void setActivity(Activity activity) {
            this.nS = activity;
            ip();
        }

        protected void m9061a(C1601f c1601f) {
            this.RV = c1601f;
            ip();
        }

        public void ip() {
            if (this.nS != null && this.RV != null && fW() == null) {
                try {
                    MapsInitializer.initialize(this.nS);
                    this.RV.m6708a(new C2108a(this.Hz, C2156u.m9093A(this.nS).m9072h(C1618e.m6734h(this.nS))));
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                } catch (GooglePlayServicesNotAvailableException e2) {
                }
            }
        }
    }

    public SupportMapFragment() {
        this.Sw = new C2109b(this);
    }

    public static SupportMapFragment newInstance() {
        return new SupportMapFragment();
    }

    public static SupportMapFragment newInstance(GoogleMapOptions options) {
        SupportMapFragment supportMapFragment = new SupportMapFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("MapOptions", options);
        supportMapFragment.setArguments(bundle);
        return supportMapFragment;
    }

    public final GoogleMap getMap() {
        IMapFragmentDelegate io = io();
        if (io == null) {
            return null;
        }
        try {
            IGoogleMapDelegate map = io.getMap();
            if (map == null) {
                return null;
            }
            if (this.RT == null || this.RT.m9051if().asBinder() != map.asBinder()) {
                this.RT = new GoogleMap(map);
            }
            return this.RT;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    protected IMapFragmentDelegate io() {
        this.Sw.ip();
        return this.Sw.fW() == null ? null : ((C2108a) this.Sw.fW()).io();
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            savedInstanceState.setClassLoader(SupportMapFragment.class.getClassLoader());
        }
        super.onActivityCreated(savedInstanceState);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.Sw.setActivity(activity);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.Sw.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return this.Sw.onCreateView(inflater, container, savedInstanceState);
    }

    public void onDestroy() {
        this.Sw.onDestroy();
        super.onDestroy();
    }

    public void onDestroyView() {
        this.Sw.onDestroyView();
        super.onDestroyView();
    }

    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(activity, attrs, savedInstanceState);
        this.Sw.setActivity(activity);
        Parcelable createFromAttributes = GoogleMapOptions.createFromAttributes(activity, attrs);
        Bundle bundle = new Bundle();
        bundle.putParcelable("MapOptions", createFromAttributes);
        this.Sw.onInflate(activity, bundle, savedInstanceState);
    }

    public void onLowMemory() {
        this.Sw.onLowMemory();
        super.onLowMemory();
    }

    public void onPause() {
        this.Sw.onPause();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.Sw.onResume();
    }

    public void onSaveInstanceState(Bundle outState) {
        if (outState != null) {
            outState.setClassLoader(SupportMapFragment.class.getClassLoader());
        }
        super.onSaveInstanceState(outState);
        this.Sw.onSaveInstanceState(outState);
    }

    public void setArguments(Bundle args) {
        super.setArguments(args);
    }
}
