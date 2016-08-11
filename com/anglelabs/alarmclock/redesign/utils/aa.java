package com.anglelabs.alarmclock.redesign.utils;

import android.os.Handler;
import android.os.Message;
import com.avg.toolkit.p049e.C0970a;
import com.mopub.mobileads.util.Base64;
import java.lang.ref.WeakReference;

public class aa extends Handler {
    WeakReference f2101a;
    private boolean f2102b;
    private int f2103c;

    /* renamed from: com.anglelabs.alarmclock.redesign.utils.aa.a */
    public interface C0776a {
        void m3662a();
    }

    public aa(C0776a receiver, int tickLength) {
        this.f2101a = new WeakReference(receiver);
        this.f2103c = tickLength;
    }

    public void m3756a() {
        if (!this.f2102b) {
            this.f2102b = true;
            sendEmptyMessage(0);
        }
    }

    public void m3757b() {
        if (this.f2102b) {
            this.f2102b = false;
            removeMessages(0);
        }
    }

    public void m3758c() {
        this.f2101a = null;
        this.f2103c = -1;
    }

    public void handleMessage(Message msg) {
        if (this.f2101a == null) {
            C0970a.m4325b("callback refrence is null, aborting");
            return;
        }
        C0776a receiver = (C0776a) this.f2101a.get();
        if (receiver == null || this.f2103c < 0) {
            C0970a.m4325b("callback refrence is null, aborting");
            m3758c();
            return;
        }
        switch (msg.what) {
            case Base64.DEFAULT /*0*/:
                receiver.m3662a();
                sendEmptyMessageDelayed(0, (long) this.f2103c);
            default:
        }
    }
}
