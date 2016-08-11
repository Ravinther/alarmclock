package com.google.android.gms.internal;

import android.app.Activity;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.C1611c;
import com.google.android.gms.dynamic.C1618e;
import com.google.android.gms.dynamic.C1620g;
import com.google.android.gms.internal.jc.C2002a;
import com.google.android.gms.wallet.fragment.WalletFragmentOptions;

public class jh extends C1620g {
    private static jh adc;

    protected jh() {
        super("com.google.android.gms.wallet.dynamite.WalletDynamiteCreatorImpl");
    }

    public static iz m8881a(Activity activity, C1611c c1611c, WalletFragmentOptions walletFragmentOptions, ja jaVar) {
        int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(activity);
        if (isGooglePlayServicesAvailable != 0) {
            throw new GooglePlayServicesNotAvailableException(isGooglePlayServicesAvailable);
        }
        try {
            return ((jc) lY().m6736z(activity)).m8838a(C1618e.m6734h(activity), c1611c, walletFragmentOptions, jaVar);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } catch (Throwable e2) {
            throw new RuntimeException(e2);
        }
    }

    private static jh lY() {
        if (adc == null) {
            adc = new jh();
        }
        return adc;
    }

    protected jc aZ(IBinder iBinder) {
        return C2002a.aV(iBinder);
    }

    protected /* synthetic */ Object m8882d(IBinder iBinder) {
        return aZ(iBinder);
    }
}
