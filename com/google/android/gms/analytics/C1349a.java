package com.google.android.gms.analytics;

import android.content.Context;
import com.avg.toolkit.ITKSvc;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

/* renamed from: com.google.android.gms.analytics.a */
class C1349a implements C1348m {
    private static Object sf;
    private static C1349a sg;
    private Context mContext;
    private Info sh;
    private long si;

    static {
        sf = new Object();
    }

    C1349a(Context context) {
        this.mContext = context;
    }

    private Info bQ() {
        Info info = null;
        try {
            info = AdvertisingIdClient.getAdvertisingIdInfo(this.mContext);
        } catch (IllegalStateException e) {
            aa.m5916z("IllegalStateException getting Ad Id Info. If you would like to see Audience reports, please ensure that you have added '<meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />' to your application manifest file. See http://goo.gl/naFqQk for details.");
        } catch (GooglePlayServicesRepairableException e2) {
            aa.m5916z("GooglePlayServicesRepairableException getting Ad Id Info");
        } catch (IOException e3) {
            aa.m5916z("IOException getting Ad Id Info");
        } catch (GooglePlayServicesNotAvailableException e4) {
            aa.m5916z("GooglePlayServicesNotAvailableException getting Ad Id Info");
        } catch (Exception e5) {
            aa.m5916z("Unknown exception. Could not get the ad Id.");
        }
        return info;
    }

    public static C1348m m5912m(Context context) {
        if (sg == null) {
            synchronized (sf) {
                if (sg == null) {
                    sg = new C1349a(context);
                }
            }
        }
        return sg;
    }

    public String getValue(String field) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.si > 1000) {
            this.sh = bQ();
            this.si = currentTimeMillis;
        }
        if (this.sh != null) {
            if ("&adid".equals(field)) {
                return this.sh.getId();
            }
            if ("&ate".equals(field)) {
                return this.sh.isLimitAdTrackingEnabled() ? ITKSvc.CODEREVISION : "1";
            }
        }
        return null;
    }
}
