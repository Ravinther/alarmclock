package com.avg.toolkit.ads.ocm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.avg.toolkit.ITKSvc;
import com.avg.toolkit.ads.ocm.C0942a.C0941a;
import com.avg.toolkit.p049e.C0970a;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

public class OcmAlarmReceiver extends BroadcastReceiver {

    /* renamed from: com.avg.toolkit.ads.ocm.OcmAlarmReceiver.1 */
    static /* synthetic */ class C09401 {
        static final /* synthetic */ int[] f2790a;

        static {
            f2790a = new int[C0941a.values().length];
            try {
                f2790a[C0941a.PRE_LOAD.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f2790a[C0941a.SHOW.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f2790a[C0941a.BUY_PROCESS_STOPPED_ALARM.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f2790a[C0941a.BAD_APK_DETECTED_ALARM.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public void onReceive(Context context, Intent intent) {
        try {
            if (intent.hasExtra("ALARM_TYPE") && intent.hasExtra("EVENT")) {
                C0941a alarmType = (C0941a) intent.getSerializableExtra("ALARM_TYPE");
                int eventId = intent.getIntExtra("EVENT", -1);
                if (alarmType != null) {
                    switch (C09401.f2790a[alarmType.ordinal()]) {
                        case Base64.NO_PADDING /*1*/:
                            m4261a(context.getApplicationContext(), eventId);
                            return;
                        case Base64.NO_WRAP /*2*/:
                            m4263b(context.getApplicationContext(), eventId);
                            return;
                        case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                            m4262a(context.getApplicationContext(), intent.getLongExtra("REPORT_UPGRADE_PROCESS_TIME_STAMP", 0));
                            return;
                        case Base64.CRLF /*4*/:
                            m4264b(context.getApplicationContext(), intent.getLongExtra("report_bad_apk_detected_time_stamp", 0));
                            return;
                        default:
                            C0970a.m4325b("Bad alarmType! value is:" + alarmType + " eventId is:" + eventId);
                            return;
                    }
                    C0970a.m4322a(e);
                }
            }
        } catch (Exception e) {
            C0970a.m4322a(e);
        }
    }

    private void m4261a(Context context, int eventId) {
        Bundle bundle = new Bundle();
        bundle.putInt("EVENT", eventId);
        bundle.putSerializable("OVERLAY_LOAD_TYPE", C0941a.PRE_LOAD);
        ITKSvc.Do(context, 27000, 0, bundle);
    }

    private void m4263b(Context context, int eventId) {
        Bundle bundle = new Bundle();
        bundle.putInt("EVENT", eventId);
        bundle.putSerializable("OVERLAY_LOAD_TYPE", C0941a.SHOW_DDE_NOTIFICATION);
        ITKSvc.Do(context, 27000, 0, bundle);
    }

    private void m4262a(Context context, long timeStamp) {
        Bundle bundle = new Bundle();
        bundle.putInt("REPORT_UPGRADE_PROCESS_SOURCE", 2);
        bundle.putLong("REPORT_UPGRADE_PROCESS_TIME_STAMP", timeStamp);
        ITKSvc.Do(context, 27000, 5, bundle);
    }

    private void m4264b(Context context, long timeStamp) {
        Bundle bundle = new Bundle();
        bundle.putInt("report_bad_apk_detected_action", 20);
        bundle.putLong("report_bad_apk_detected_time_stamp", timeStamp);
        ITKSvc.Do(context, 27000, 7, bundle);
    }
}
