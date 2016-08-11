package com.google.android.gms.wallet.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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
import com.google.android.gms.dynamic.C1613b;
import com.google.android.gms.dynamic.C1618e;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.internal.iz;
import com.google.android.gms.internal.ja.C1998a;
import com.google.android.gms.wallet.MaskedWalletRequest;

public final class WalletFragment extends Fragment {
    private final Fragment Hv;
    private WalletFragmentInitParams acA;
    private MaskedWalletRequest acB;
    private Boolean acC;
    private C2356b acH;
    private final C1613b acI;
    private final C2357c acJ;
    private C2355a acK;
    private WalletFragmentOptions acz;
    private boolean mCreated;

    public interface OnStateChangedListener {
        void onStateChanged(WalletFragment walletFragment, int i, int i2, Bundle bundle);
    }

    /* renamed from: com.google.android.gms.wallet.fragment.WalletFragment.a */
    static class C2355a extends C1998a {
        private OnStateChangedListener acL;
        private final WalletFragment acM;

        C2355a(WalletFragment walletFragment) {
            this.acM = walletFragment;
        }

        public void m9649a(int i, int i2, Bundle bundle) {
            if (this.acL != null) {
                this.acL.onStateChanged(this.acM, i, i2, bundle);
            }
        }

        public void m9650a(OnStateChangedListener onStateChangedListener) {
            this.acL = onStateChangedListener;
        }
    }

    /* renamed from: com.google.android.gms.wallet.fragment.WalletFragment.b */
    private static class C2356b implements LifecycleDelegate {
        private final iz acF;

        private C2356b(iz izVar) {
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

    /* renamed from: com.google.android.gms.wallet.fragment.WalletFragment.c */
    private class C2357c extends C1610a implements OnClickListener {
        final /* synthetic */ WalletFragment acN;

        private C2357c(WalletFragment walletFragment) {
            this.acN = walletFragment;
        }

        protected void m9656a(FrameLayout frameLayout) {
            View button = new Button(this.acN.Hv.getActivity());
            button.setText(C1336R.string.wallet_buy_button_place_holder);
            int i = -1;
            int i2 = -2;
            if (this.acN.acz != null) {
                WalletFragmentStyle fragmentStyle = this.acN.acz.getFragmentStyle();
                if (fragmentStyle != null) {
                    DisplayMetrics displayMetrics = this.acN.Hv.getResources().getDisplayMetrics();
                    i = fragmentStyle.m9689a("buyButtonWidth", displayMetrics, -1);
                    i2 = fragmentStyle.m9689a("buyButtonHeight", displayMetrics, -2);
                }
            }
            button.setLayoutParams(new LayoutParams(i, i2));
            button.setOnClickListener(this);
            frameLayout.addView(button);
        }

        protected void m9657a(C1601f c1601f) {
            Activity activity = this.acN.Hv.getActivity();
            if (this.acN.acH == null && this.acN.mCreated && activity != null) {
                try {
                    this.acN.acH = new C2356b(null);
                    this.acN.acz = null;
                    c1601f.m6708a(this.acN.acH);
                    if (this.acN.acA != null) {
                        this.acN.acH.initialize(this.acN.acA);
                        this.acN.acA = null;
                    }
                    if (this.acN.acB != null) {
                        this.acN.acH.updateMaskedWalletRequest(this.acN.acB);
                        this.acN.acB = null;
                    }
                    if (this.acN.acC != null) {
                        this.acN.acH.setEnabled(this.acN.acC.booleanValue());
                        this.acN.acC = null;
                    }
                } catch (GooglePlayServicesNotAvailableException e) {
                }
            }
        }

        public void onClick(View view) {
            Context activity = this.acN.Hv.getActivity();
            GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(activity), activity, -1);
        }
    }

    public WalletFragment() {
        this.mCreated = false;
        this.acI = C1613b.m6727a(this);
        this.acJ = new C2357c();
        this.acK = new C2355a(this);
        this.Hv = this;
    }

    public static WalletFragment newInstance(WalletFragmentOptions options) {
        WalletFragment walletFragment = new WalletFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("extraWalletFragmentOptions", options);
        walletFragment.Hv.setArguments(bundle);
        return walletFragment;
    }

    public int getState() {
        return this.acH != null ? this.acH.getState() : 0;
    }

    public void initialize(WalletFragmentInitParams initParams) {
        if (this.acH != null) {
            this.acH.initialize(initParams);
            this.acA = null;
        } else if (this.acA == null) {
            this.acA = initParams;
            if (this.acB != null) {
                Log.w("WalletFragment", "updateMaskedWallet() was called before initialize()");
            }
        } else {
            Log.w("WalletFragment", "initialize(WalletFragmentInitParams) was called more than once. Ignoring.");
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (this.acH != null) {
            this.acH.onActivityResult(requestCode, resultCode, data);
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            savedInstanceState.setClassLoader(WalletFragmentOptions.class.getClassLoader());
            WalletFragmentInitParams walletFragmentInitParams = (WalletFragmentInitParams) savedInstanceState.getParcelable("walletFragmentInitParams");
            if (walletFragmentInitParams != null) {
                if (this.acA != null) {
                    Log.w("WalletFragment", "initialize(WalletFragmentInitParams) was called more than once.Ignoring.");
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
        } else if (this.Hv.getArguments() != null) {
            WalletFragmentOptions walletFragmentOptions = (WalletFragmentOptions) this.Hv.getArguments().getParcelable("extraWalletFragmentOptions");
            if (walletFragmentOptions != null) {
                walletFragmentOptions.m9684I(this.Hv.getActivity());
                this.acz = walletFragmentOptions;
            }
        }
        this.mCreated = true;
        this.acJ.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return this.acJ.onCreateView(inflater, container, savedInstanceState);
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
        this.acJ.onInflate(activity, bundle, savedInstanceState);
    }

    public void onPause() {
        super.onPause();
        this.acJ.onPause();
    }

    public void onResume() {
        super.onResume();
        this.acJ.onResume();
        FragmentManager fragmentManager = this.Hv.getActivity().getFragmentManager();
        Fragment findFragmentByTag = fragmentManager.findFragmentByTag(GooglePlayServicesUtil.GMS_ERROR_DIALOG);
        if (findFragmentByTag != null) {
            fragmentManager.beginTransaction().remove(findFragmentByTag).commit();
            GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.Hv.getActivity()), this.Hv.getActivity(), -1);
        }
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.setClassLoader(WalletFragmentOptions.class.getClassLoader());
        this.acJ.onSaveInstanceState(outState);
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
        this.acJ.onStart();
    }

    public void onStop() {
        super.onStop();
        this.acJ.onStop();
    }

    public void setEnabled(boolean enabled) {
        if (this.acH != null) {
            this.acH.setEnabled(enabled);
            this.acC = null;
            return;
        }
        this.acC = Boolean.valueOf(enabled);
    }

    public void setOnStateChangedListener(OnStateChangedListener listener) {
        this.acK.m9650a(listener);
    }

    public void updateMaskedWalletRequest(MaskedWalletRequest request) {
        if (this.acH != null) {
            this.acH.updateMaskedWalletRequest(request);
            this.acB = null;
            return;
        }
        this.acB = request;
    }
}
