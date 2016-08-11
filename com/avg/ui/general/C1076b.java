package com.avg.ui.general;

import android.content.Context;
import com.avg.toolkit.ganalytics.GoogleAnalyticsWrapper;

/* renamed from: com.avg.ui.general.b */
public class C1076b {
    public static void m4635a(Context context, String notificationName) {
        GoogleAnalyticsWrapper.trackEvent(context, "Notificatoin", notificationName, "open", null);
    }
}
