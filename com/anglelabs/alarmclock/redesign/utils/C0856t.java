package com.anglelabs.alarmclock.redesign.utils;

import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import com.anglelabs.alarmclock.redesign.alarm.C0644b;

/* renamed from: com.anglelabs.alarmclock.redesign.utils.t */
public class C0856t {
    private final C0596a f2452a;
    private final TelephonyManager f2453b;
    private int f2454c;
    private boolean f2455d;
    private final PhoneStateListener f2456e;

    /* renamed from: com.anglelabs.alarmclock.redesign.utils.t.a */
    public interface C0596a {
        void m2762a(boolean z);
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.utils.t.1 */
    class C08551 extends PhoneStateListener {
        final /* synthetic */ C0856t f2451a;

        C08551(C0856t c0856t) {
            this.f2451a = c0856t;
        }

        public void onCallStateChanged(int state, String ignored) {
            if (state != this.f2451a.f2454c) {
                this.f2451a.f2455d = state != 0;
                this.f2451a.f2454c = state;
                C0644b.f1719a = this.f2451a.f2455d;
                if (this.f2451a.f2452a != null) {
                    this.f2451a.f2452a.m2762a(this.f2451a.f2455d);
                }
            }
        }
    }

    public C0856t(Context context, C0596a iPhoneStateUpdater) {
        this.f2456e = new C08551(this);
        this.f2452a = iPhoneStateUpdater;
        this.f2453b = (TelephonyManager) context.getSystemService("phone");
    }

    public void m4021a() {
        this.f2453b.listen(this.f2456e, 32);
        this.f2454c = this.f2453b.getCallState();
        this.f2455d = this.f2454c != 0;
        C0644b.f1719a = this.f2455d;
    }

    public void m4022b() {
        this.f2453b.listen(this.f2456e, 0);
    }
}
