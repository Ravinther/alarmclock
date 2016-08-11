package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.android.gms.common.C1455a;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.C2036t;
import com.google.android.gms.internal.C2036t.C2038a;
import com.google.android.gms.internal.fq;
import java.io.IOException;

public final class AdvertisingIdClient {

    public static final class Info {
        private final String kw;
        private final boolean kx;

        public Info(String advertisingId, boolean limitAdTrackingEnabled) {
            this.kw = advertisingId;
            this.kx = limitAdTrackingEnabled;
        }

        public String getId() {
            return this.kw;
        }

        public boolean isLimitAdTrackingEnabled() {
            return this.kx;
        }
    }

    static Info m5875a(Context context, C1455a c1455a) {
        try {
            C2036t b = C2038a.m8988b(c1455a.dV());
            Info info = new Info(b.getId(), b.m8982a(true));
            try {
                context.unbindService(c1455a);
            } catch (Throwable e) {
                Log.i("AdvertisingIdClient", "getAdvertisingIdInfo unbindService failed.", e);
            }
            return info;
        } catch (Throwable e2) {
            Log.i("AdvertisingIdClient", "GMS remote exception ", e2);
            throw new IOException("Remote exception");
        } catch (InterruptedException e3) {
            throw new IOException("Interrupted exception");
        } catch (Throwable th) {
            try {
                context.unbindService(c1455a);
            } catch (Throwable e4) {
                Log.i("AdvertisingIdClient", "getAdvertisingIdInfo unbindService failed.", e4);
            }
        }
    }

    static C1455a m5876g(Context context) {
        try {
            context.getPackageManager().getPackageInfo(GooglePlayServicesUtil.GOOGLE_PLAY_STORE_PACKAGE, 0);
            try {
                GooglePlayServicesUtil.m6220s(context);
                Object c1455a = new C1455a();
                Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                intent.setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE);
                if (context.bindService(intent, c1455a, 1)) {
                    return c1455a;
                }
                throw new IOException("Connection failure");
            } catch (Throwable e) {
                throw new IOException(e);
            }
        } catch (NameNotFoundException e2) {
            throw new GooglePlayServicesNotAvailableException(9);
        }
    }

    public static Info getAdvertisingIdInfo(Context context) {
        fq.ak("Calling this from your main thread can lead to deadlock");
        return m5875a(context, m5876g(context));
    }
}
