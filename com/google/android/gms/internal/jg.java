package com.google.android.gms.internal;

import android.accounts.Account;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.ff.C1893e;
import com.google.android.gms.internal.jb.C2000a;
import com.google.android.gms.internal.je.C2006a;
import com.google.android.gms.wallet.FullWallet;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;
import com.google.android.gms.wallet.WalletConstants;

public class jg extends ff {
    private final int acq;
    private final int mTheme;
    private final Activity nS;
    private final String wG;

    /* renamed from: com.google.android.gms.internal.jg.a */
    private static class C2015a extends C2006a {
        private C2015a() {
        }

        public void m8864a(int i, FullWallet fullWallet, Bundle bundle) {
        }

        public void m8865a(int i, MaskedWallet maskedWallet, Bundle bundle) {
        }

        public void m8866a(int i, boolean z, Bundle bundle) {
        }

        public void m8867a(Status status, ix ixVar, Bundle bundle) {
        }

        public void m8868f(int i, Bundle bundle) {
        }
    }

    /* renamed from: com.google.android.gms.internal.jg.b */
    final class C2016b extends C2015a {
        private final int CV;
        final /* synthetic */ jg adb;

        public C2016b(jg jgVar, int i) {
            this.adb = jgVar;
            super();
            this.CV = i;
        }

        public void m8869a(int i, FullWallet fullWallet, Bundle bundle) {
            PendingIntent pendingIntent = null;
            if (bundle != null) {
                pendingIntent = (PendingIntent) bundle.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT");
            }
            ConnectionResult connectionResult = new ConnectionResult(i, pendingIntent);
            if (connectionResult.hasResolution()) {
                try {
                    connectionResult.startResolutionForResult(this.adb.nS, this.CV);
                    return;
                } catch (Throwable e) {
                    Log.w("WalletClientImpl", "Exception starting pending intent", e);
                    return;
                }
            }
            int i2;
            Intent intent = new Intent();
            if (connectionResult.isSuccess()) {
                i2 = -1;
                intent.putExtra(WalletConstants.EXTRA_FULL_WALLET, fullWallet);
            } else {
                i2 = i == 408 ? 0 : 1;
                intent.putExtra(WalletConstants.EXTRA_ERROR_CODE, i);
            }
            PendingIntent createPendingResult = this.adb.nS.createPendingResult(this.CV, intent, 1073741824);
            if (createPendingResult == null) {
                Log.w("WalletClientImpl", "Null pending result returned for onFullWalletLoaded");
                return;
            }
            try {
                createPendingResult.send(i2);
            } catch (Throwable e2) {
                Log.w("WalletClientImpl", "Exception setting pending result", e2);
            }
        }

        public void m8870a(int i, MaskedWallet maskedWallet, Bundle bundle) {
            PendingIntent pendingIntent = null;
            if (bundle != null) {
                pendingIntent = (PendingIntent) bundle.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT");
            }
            ConnectionResult connectionResult = new ConnectionResult(i, pendingIntent);
            if (connectionResult.hasResolution()) {
                try {
                    connectionResult.startResolutionForResult(this.adb.nS, this.CV);
                    return;
                } catch (Throwable e) {
                    Log.w("WalletClientImpl", "Exception starting pending intent", e);
                    return;
                }
            }
            int i2;
            Intent intent = new Intent();
            if (connectionResult.isSuccess()) {
                i2 = -1;
                intent.putExtra(WalletConstants.EXTRA_MASKED_WALLET, maskedWallet);
            } else {
                i2 = i == 408 ? 0 : 1;
                intent.putExtra(WalletConstants.EXTRA_ERROR_CODE, i);
            }
            PendingIntent createPendingResult = this.adb.nS.createPendingResult(this.CV, intent, 1073741824);
            if (createPendingResult == null) {
                Log.w("WalletClientImpl", "Null pending result returned for onMaskedWalletLoaded");
                return;
            }
            try {
                createPendingResult.send(i2);
            } catch (Throwable e2) {
                Log.w("WalletClientImpl", "Exception setting pending result", e2);
            }
        }

        public void m8871a(int i, boolean z, Bundle bundle) {
            Intent intent = new Intent();
            intent.putExtra(WalletConstants.EXTRA_IS_USER_PREAUTHORIZED, z);
            PendingIntent createPendingResult = this.adb.nS.createPendingResult(this.CV, intent, 1073741824);
            if (createPendingResult == null) {
                Log.w("WalletClientImpl", "Null pending result returned for onPreAuthorizationDetermined");
                return;
            }
            try {
                createPendingResult.send(-1);
            } catch (Throwable e) {
                Log.w("WalletClientImpl", "Exception setting pending result", e);
            }
        }

        public void m8872f(int i, Bundle bundle) {
            fq.m8517b((Object) bundle, (Object) "Bundle should not be null");
            ConnectionResult connectionResult = new ConnectionResult(i, (PendingIntent) bundle.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT"));
            if (connectionResult.hasResolution()) {
                try {
                    connectionResult.startResolutionForResult(this.adb.nS, this.CV);
                    return;
                } catch (Throwable e) {
                    Log.w("WalletClientImpl", "Exception starting pending intent", e);
                    return;
                }
            }
            Log.e("WalletClientImpl", "Create Wallet Objects confirmation UI will not be shown connection result: " + connectionResult);
            Intent intent = new Intent();
            intent.putExtra(WalletConstants.EXTRA_ERROR_CODE, WalletConstants.ERROR_CODE_UNKNOWN);
            PendingIntent createPendingResult = this.adb.nS.createPendingResult(this.CV, intent, 1073741824);
            if (createPendingResult == null) {
                Log.w("WalletClientImpl", "Null pending result returned for onWalletObjectsCreated");
                return;
            }
            try {
                createPendingResult.send(1);
            } catch (Throwable e2) {
                Log.w("WalletClientImpl", "Exception setting pending result", e2);
            }
        }
    }

    public jg(Activity activity, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, int i, String str, int i2) {
        super(activity, looper, connectionCallbacks, onConnectionFailedListener, new String[0]);
        this.nS = activity;
        this.acq = i;
        this.wG = str;
        this.mTheme = i2;
    }

    public static Bundle m8873a(int i, String str, String str2, int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt("com.google.android.gms.wallet.EXTRA_ENVIRONMENT", i);
        bundle.putString("androidPackageName", str);
        if (!TextUtils.isEmpty(str2)) {
            bundle.putParcelable("com.google.android.gms.wallet.EXTRA_BUYER_ACCOUNT", new Account(str2, GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE));
        }
        bundle.putInt("com.google.android.gms.wallet.EXTRA_THEME", i2);
        return bundle;
    }

    private Bundle lX() {
        return m8873a(this.acq, this.nS.getPackageName(), this.wG, this.mTheme);
    }

    protected void m8875a(fm fmVar, C1893e c1893e) {
        fmVar.m8450a(c1893e, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE);
    }

    public void m8876a(FullWalletRequest fullWalletRequest, int i) {
        je c2016b = new C2016b(this, i);
        try {
            ((jb) eM()).m8824a(fullWalletRequest, lX(), c2016b);
        } catch (Throwable e) {
            Log.e("WalletClientImpl", "RemoteException getting full wallet", e);
            c2016b.m8869a(8, null, Bundle.EMPTY);
        }
    }

    public void m8877a(MaskedWalletRequest maskedWalletRequest, int i) {
        Bundle lX = lX();
        je c2016b = new C2016b(this, i);
        try {
            ((jb) eM()).m8826a(maskedWalletRequest, lX, c2016b);
        } catch (Throwable e) {
            Log.e("WalletClientImpl", "RemoteException getting masked wallet", e);
            c2016b.m8870a(8, null, Bundle.EMPTY);
        }
    }

    public void m8878a(NotifyTransactionStatusRequest notifyTransactionStatusRequest) {
        try {
            ((jb) eM()).m8827a(notifyTransactionStatusRequest, lX());
        } catch (RemoteException e) {
        }
    }

    protected jb aY(IBinder iBinder) {
        return C2000a.aU(iBinder);
    }

    protected String bg() {
        return "com.google.android.gms.wallet.service.BIND";
    }

    protected String bh() {
        return "com.google.android.gms.wallet.internal.IOwService";
    }

    public void cD(int i) {
        Bundle lX = lX();
        je c2016b = new C2016b(this, i);
        try {
            ((jb) eM()).m8822a(lX, c2016b);
        } catch (Throwable e) {
            Log.e("WalletClientImpl", "RemoteException during checkForPreAuthorization", e);
            c2016b.m8871a(8, false, Bundle.EMPTY);
        }
    }

    public void m8879d(String str, String str2, int i) {
        Bundle lX = lX();
        Object c2016b = new C2016b(this, i);
        try {
            ((jb) eM()).m8829a(str, str2, lX, c2016b);
        } catch (Throwable e) {
            Log.e("WalletClientImpl", "RemoteException changing masked wallet", e);
            c2016b.m8870a(8, null, Bundle.EMPTY);
        }
    }

    protected /* synthetic */ IInterface m8880r(IBinder iBinder) {
        return aY(iBinder);
    }
}
