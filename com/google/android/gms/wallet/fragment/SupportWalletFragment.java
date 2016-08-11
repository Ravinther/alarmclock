package com.google.android.gms.wallet.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.C0075i;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.gms.C1336R;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.C1601f;
import com.google.android.gms.dynamic.C1610a;
import com.google.android.gms.dynamic.C1618e;
import com.google.android.gms.dynamic.C1621h;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.internal.iz;
import com.google.android.gms.internal.ja.C1998a;
import com.google.android.gms.wallet.MaskedWalletRequest;

public final class SupportWalletFragment extends Fragment {
    private final Fragment Hz;
    private WalletFragmentInitParams acA;
    private MaskedWalletRequest acB;
    private Boolean acC;
    private C2352b acv;
    private final C1621h acw;
    private final C2353c acx;
    private C2351a acy;
    private WalletFragmentOptions acz;
    private boolean mCreated;

    public interface OnStateChangedListener {
        void onStateChanged(SupportWalletFragment supportWalletFragment, int i, int i2, Bundle bundle);
    }

    /* renamed from: com.google.android.gms.wallet.fragment.SupportWalletFragment.a */
    static class C2351a extends C1998a {
        private OnStateChangedListener acD;
        private final SupportWalletFragment acE;

        C2351a(SupportWalletFragment supportWalletFragment) {
            this.acE = supportWalletFragment;
        }

        public void m9626a(int i, int i2, Bundle bundle) {
            if (this.acD != null) {
                this.acD.onStateChanged(this.acE, i, i2, bundle);
            }
        }

        public void m9627a(OnStateChangedListener onStateChangedListener) {
            this.acD = onStateChangedListener;
        }
    }

    /* renamed from: com.google.android.gms.wallet.fragment.SupportWalletFragment.b */
    private static class C2352b implements LifecycleDelegate {
        private final iz acF;

        private C2352b(iz izVar) {
            this.acF = izVar;
        }

        private int getState() {
            try {
                return this.acF.getState();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        private void initialize(WalletFragmentInitParams startParams) {
            try {
                this.acF.initialize(startParams);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        private void onActivityResult(int requestCode, int resultCode, Intent data) {
            try {
                this.acF.onActivityResult(requestCode, resultCode, data);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        private void setEnabled(boolean enabled) {
            try {
                this.acF.setEnabled(enabled);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        private void updateMaskedWalletRequest(MaskedWalletRequest request) {
            try {
                this.acF.updateMaskedWalletRequest(request);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onCreate(Bundle savedInstanceState) {
            try {
                this.acF.onCreate(savedInstanceState);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            try {
                return (View) C1618e.m6733d(this.acF.onCreateView(C1618e.m6734h(inflater), C1618e.m6734h(container), savedInstanceState));
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onDestroy() {
        }

        public void onDestroyView() {
        }

        public void onInflate(Activity activity, Bundle attrs, Bundle savedInstanceState) {
            try {
                this.acF.m8806a(C1618e.m6734h(activity), (WalletFragmentOptions) attrs.getParcelable("extraWalletFragmentOptions"), savedInstanceState);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onLowMemory() {
        }

        public void onPause() {
            try {
                this.acF.onPause();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onResume() {
            try {
                this.acF.onResume();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onSaveInstanceState(Bundle outState) {
            try {
                this.acF.onSaveInstanceState(outState);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onStart() {
            try {
                this.acF.onStart();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onStop() {
            try {
                this.acF.onStop();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* renamed from: com.google.android.gms.wallet.fragment.SupportWalletFragment.c */
    private class C2353c extends C1610a implements OnClickListener {
        final /* synthetic */ SupportWalletFragment acG;

        private C2353c(SupportWalletFragment supportWalletFragment) {
            this.acG = supportWalletFragment;
        }

        protected void m9633a(FrameLayout frameLayout) {
            View button = new Button(this.acG.Hz.getActivity());
            button.setText(C1336R.string.wallet_buy_button_place_holder);
            int i = -1;
            int i2 = -2;
            if (this.acG.acz != null) {
                WalletFragmentStyle fragmentStyle = this.acG.acz.getFragmentStyle();
                if (fragmentStyle != null) {
                    DisplayMetrics displayMetrics = this.acG.Hz.getResources().getDisplayMetrics();
                    i = fragmentStyle.m9689a("buyButtonWidth", displayMetrics, -1);
                    i2 = fragmentStyle.m9689a("buyButtonHeight", displayMetrics, -2);
                }
            }
            button.setLayoutParams(new LayoutParams(i, i2));
            button.setOnClickListener(this);
            frameLayout.addView(button);
        }

        protected void m9634a(C1601f c1601f) {
            Activity activity = this.acG.Hz.getActivity();
            if (this.acG.acv == null && this.acG.mCreated && activity != null) {
                try {
                    this.acG.acv = new C2352b(null);
                    this.acG.acz = null;
                    c1601f.m6708a(this.acG.acv);
                    if (this.acG.acA != null) {
                        this.acG.acv.initialize(this.acG.acA);
                        this.acG.acA = null;
                    }
                    if (this.acG.acB != null) {
                        this.acG.acv.updateMaskedWalletRequest(this.acG.acB);
                        this.acG.acB = null;
                    }
                    if (this.acG.acC != null) {
                        this.acG.acv.setEnabled(this.acG.acC.booleanValue());
                        this.acG.acC = null;
                    }
                } catch (GooglePlayServicesNotAvailableException e) {
                }
            }
        }

        public void onClick(View view) {
            Context activity = this.acG.Hz.getActivity();
            GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(activity), activity, -1);
        }
    }

    public SupportWalletFragment() {
        this.mCreated = false;
        this.acw = C1621h.m6737a(this);
        this.acx = new C2353c();
        this.acy = new C2351a(this);
        this.Hz = this;
    }

    public static SupportWalletFragment newInstance(WalletFragmentOptions options) {
        SupportWalletFragment supportWalletFragment = new SupportWalletFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("extraWalletFragmentOptions", options);
        supportWalletFragment.Hz.setArguments(bundle);
        return supportWalletFragment;
    }

    public int getState() {
        return this.acv != null ? this.acv.getState() : 0;
    }

    public void initialize(WalletFragmentInitParams initParams) {
        if (this.acv != null) {
            this.acv.initialize(initParams);
            this.acA = null;
        } else if (this.acA == null) {
            this.acA = initParams;
            if (this.acB != null) {
                Log.w("SupportWalletFragment", "updateMaskedWallet() was called before initialize()");
            }
        } else {
            Log.w("SupportWalletFragment", "initialize(WalletFragmentInitParams) was called more than once. Ignoring.");
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (this.acv != null) {
            this.acv.onActivityResult(requestCode, resultCode, data);
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            savedInstanceState.setClassLoader(WalletFragmentOptions.class.getClassLoader());
            WalletFragmentInitParams walletFragmentInitParams = (WalletFragmentInitParams) savedInstanceState.getParcelable("walletFragmentInitParams");
            if (walletFragmentInitParams != null) {
                if (this.acA != null) {
                    Log.w("SupportWalletFragment", "initialize(WalletFragmentInitParams) was called more than once.Ignoring.");
                }
                this.acA = walletFragmentInitParams;
            }
            if (this.acB == null) {
                this.acB = (MaskedWalletRequest) savedInstanceState.getParcelable("maskedWalletRequest");
            }
            if (savedInstanceState.containsKey("walletFragmentOptions")) {
                this.acz = (WalletFragmentOptions) savedInstanceState.getParcelable("walletFragmentOptions");
            }
            if (savedInstanceState.containsKey("enabled")) {
                this.acC = Boolean.valueOf(savedInstanceState.getBoolean("enabled"));
            }
        } else if (this.Hz.getArguments() != null) {
            WalletFragmentOptions walletFragmentOptions = (WalletFragmentOptions) this.Hz.getArguments().getParcelable("extraWalletFragmentOptions");
            if (walletFragmentOptions != null) {
                walletFragmentOptions.m9684I(this.Hz.getActivity());
                this.acz = walletFragmentOptions;
            }
        }
        this.mCreated = true;
        this.acx.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return this.acx.onCreateView(inflater, container, savedInstanceState);
    }

    public void onDestroy() {
        super.onDestroy();
        this.mCreated = false;
    }

    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(activity, attrs, savedInstanceState);
        if (this.acz == null) {
            this.acz = WalletFragmentOptions.m9680a((Context) activity, attrs);
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("attrKeyWalletFragmentOptions", this.acz);
        this.acx.onInflate(activity, bundle, savedInstanceState);
    }

    public void onPause() {
        super.onPause();
        this.acx.onPause();
    }

    public void onResume() {
        super.onResume();
        this.acx.onResume();
        C0075i g = this.Hz.getActivity().m258g();
        Fragment a = g.m261a(GooglePlayServicesUtil.GMS_ERROR_DIALOG);
        if (a != null) {
            g.m262a().m185a(a).m188b();
            GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.Hz.getActivity()), this.Hz.getActivity(), -1);
        }
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.setClassLoader(WalletFragmentOptions.class.getClassLoader());
        this.acx.onSaveInstanceState(outState);
        if (this.acA != null) {
            outState.putParcelable("walletFragmentInitParams", this.acA);
            this.acA = null;
        }
        if (this.acB != null) {
            outState.putParcelable("maskedWalletRequest", this.acB);
            this.acB = null;
        }
        if (this.acz != null) {
            outState.putParcelable("walletFragmentOptions", this.acz);
            this.acz = null;
        }
        if (this.acC != null) {
            outState.putBoolean("enabled", this.acC.booleanValue());
            this.acC = null;
        }
    }

    public void onStart() {
        super.onStart();
        this.acx.onStart();
    }

    public void onStop() {
        super.onStop();
        this.acx.onStop();
    }

    public void setEnabled(boolean enabled) {
        if (this.acv != null) {
            this.acv.setEnabled(enabled);
            this.acC = null;
            return;
        }
        this.acC = Boolean.valueOf(enabled);
    }

    public void setOnStateChangedListener(OnStateChangedListener listener) {
        this.acy.m9627a(listener);
    }

    public void updateMaskedWalletRequest(MaskedWalletRequest request) {
        if (this.acv != null) {
            this.acv.updateMaskedWalletRequest(request);
            this.acB = null;
            return;
        }
        this.acB = request;
    }
}
