package com.anglelabs.alarmclock.redesign.alarm.p028a;

import android.content.Context;
import android.widget.TextView;
import com.alarmclock.xtreme.free.R;
import com.anglelabs.alarmclock.redesign.alarm.p028a.p029b.C0605c;
import com.anglelabs.alarmclock.redesign.alarm.p028a.p029b.C0605c.C0567a;
import com.anglelabs.alarmclock.redesign.alarm.p028a.p032d.C0626a;
import com.anglelabs.alarmclock.redesign.alarm.p028a.p032d.C0627b;
import com.anglelabs.alarmclock.redesign.alarm.p028a.p032d.C0628c;
import com.anglelabs.alarmclock.redesign.alarm.p028a.p032d.C0629d;
import com.anglelabs.alarmclock.redesign.alarm.p028a.p032d.C0630e;
import com.anglelabs.alarmclock.redesign.model.RedesignAlarm;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

/* renamed from: com.anglelabs.alarmclock.redesign.alarm.a.d */
public final class C0631d {
    public static C0605c m2902a(Context context, C0567a callback, RedesignAlarm alarm, TextView text) {
        switch (alarm.f1992E) {
            case Base64.NO_PADDING /*1*/:
                return new C0626a(context, text, alarm, callback, alarm.f1992E);
            case Base64.NO_WRAP /*2*/:
                return new C0630e(context, text, alarm, callback, alarm.f1992E);
            case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                return new C0629d(context, text, alarm, callback, alarm.f1992E);
            case Base64.CRLF /*4*/:
                return new C0627b(context, text, alarm, callback, alarm.f1992E);
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                return new C0628c(context, text, alarm, callback, alarm.f1992E);
            default:
                return new C0626a(context, text, alarm, callback, alarm.f1992E);
        }
    }

    public static void m2903a(TextView view) {
        view.setText(R.string.no_snoozes_left);
        view.setOnClickListener(null);
    }
}
