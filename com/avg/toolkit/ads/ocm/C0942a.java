package com.avg.toolkit.ads.ocm;

import android.content.Context;
import android.os.Bundle;
import com.avg.toolkit.C0647c;
import com.avg.toolkit.ITKSvc;
import com.avg.toolkit.ads.ocm.C0945b.C0943a;
import com.avg.toolkit.ads.ocm.C0945b.C0944b;
import com.avg.toolkit.license.OcmCampaign;

/* renamed from: com.avg.toolkit.ads.ocm.a */
public abstract class C0942a implements C0647c {
    public static boolean f2800a;

    /* renamed from: com.avg.toolkit.ads.ocm.a.a */
    public enum C0941a {
        PRE_LOAD,
        SHOW,
        SHOW_DDE_NOTIFICATION,
        BUY_PROCESS_STOPPED_ALARM,
        BAD_APK_DETECTED_ALARM
    }

    static {
        f2800a = false;
    }

    public static void m4265a(Context context, OcmCampaign campaign, C0944b errorStage, C0943a errorCode) {
        if (errorCode != null) {
            Bundle analyticsBundle = new Bundle();
            analyticsBundle.putSerializable("campaign", campaign);
            analyticsBundle.putString("ANALYTICS_TECH_CATEGORY", errorCode.m4266a());
            analyticsBundle.putInt("ANALYTICS_TECH_ERROR_STAGE", errorStage.m4268a());
            analyticsBundle.putInt("ANALYTICS_TECH_ERROR_CODE_INDEX", errorCode.m4267b());
            ITKSvc.Do(context, 27000, 6, analyticsBundle);
        }
    }
}
