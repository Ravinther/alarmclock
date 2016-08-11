package com.anglelabs.alarmclock.redesign.alarm.p028a;

import android.content.Context;
import android.widget.TextView;
import com.anglelabs.alarmclock.redesign.alarm.p028a.p029b.C0605c;
import com.anglelabs.alarmclock.redesign.alarm.p028a.p029b.C0605c.C0567a;
import com.anglelabs.alarmclock.redesign.alarm.p028a.p030a.C0606a;
import com.anglelabs.alarmclock.redesign.alarm.p028a.p030a.C0607b;
import com.anglelabs.alarmclock.redesign.alarm.p028a.p030a.C0608c;
import com.anglelabs.alarmclock.redesign.alarm.p028a.p030a.C0611d;
import com.anglelabs.alarmclock.redesign.alarm.p028a.p030a.C0612e;
import com.anglelabs.alarmclock.redesign.model.RedesignAlarm;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

/* renamed from: com.anglelabs.alarmclock.redesign.alarm.a.b */
public final class C0618b {
    public static C0605c m2848a(Context context, C0567a callback, RedesignAlarm alarm, TextView text) {
        switch (alarm.f2007h) {
            case Base64.NO_PADDING /*1*/:
                return new C0606a(context, text, alarm, callback, alarm.f2007h);
            case Base64.CRLF /*4*/:
                return new C0607b(context, text, alarm, callback, alarm.f2007h);
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                return new C0608c(context, text, alarm, callback, alarm.f2007h);
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                return new C0611d(context, text, alarm, callback, alarm.f2007h);
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor /*9*/:
                return new C0612e(context, text, alarm, callback, alarm.f2007h);
            default:
                return new C0606a(context, text, alarm, callback, alarm.f2007h);
        }
    }
}
