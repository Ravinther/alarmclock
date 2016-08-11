package com.anglelabs.alarmclock.redesign.alarm.p028a;

import android.content.Context;
import com.anglelabs.alarmclock.redesign.alarm.p028a.p029b.C0615a;
import com.anglelabs.alarmclock.redesign.alarm.p028a.p033e.C0634a;
import com.anglelabs.alarmclock.redesign.alarm.p028a.p033e.C0635b;
import com.anglelabs.alarmclock.redesign.alarm.p028a.p033e.C0636c;
import com.anglelabs.alarmclock.redesign.alarm.p028a.p033e.C0637d;
import com.anglelabs.alarmclock.redesign.alarm.p028a.p033e.C0638e;
import com.anglelabs.alarmclock.redesign.alarm.p028a.p033e.C0639f;
import com.anglelabs.alarmclock.redesign.model.RedesignAlarm;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

/* renamed from: com.anglelabs.alarmclock.redesign.alarm.a.e */
public final class C0640e {
    public static C0615a m2943a(Context context, RedesignAlarm alarm) {
        switch (alarm.f1993F) {
            case Base64.NO_PADDING /*1*/:
                return new C0638e(context, alarm);
            case Base64.NO_WRAP /*2*/:
                return new C0636c(context, alarm);
            case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                return new C0639f();
            case Base64.CRLF /*4*/:
                return new C0635b(context, alarm);
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                return new C0637d(context, alarm);
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                return new C0634a(context, alarm);
            default:
                return new C0638e(context, alarm);
        }
    }
}
