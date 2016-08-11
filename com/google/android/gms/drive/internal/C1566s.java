package com.google.android.gms.drive.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.events.DriveEvent.Listener;
import com.google.android.gms.drive.internal.C1564w.C1565a;
import com.google.android.gms.internal.fq;
import com.mopub.mobileads.util.Base64;

/* renamed from: com.google.android.gms.drive.internal.s */
public class C1566s extends C1565a {
    private final int ES;
    private final C1563a FA;
    private final Listener Fz;

    /* renamed from: com.google.android.gms.drive.internal.s.a */
    private static class C1563a extends Handler {
        private C1563a(Looper looper) {
            super(looper);
        }

        public void m6558a(Listener listener, DriveEvent driveEvent) {
            sendMessage(obtainMessage(1, new Pair(listener, driveEvent)));
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case Base64.NO_PADDING /*1*/:
                    Pair pair = (Pair) msg.obj;
                    ((Listener) pair.first).onEvent((DriveEvent) pair.second);
                default:
                    Log.wtf("EventCallback", "Don't know how to handle this event");
            }
        }
    }

    public C1566s(Looper looper, int i, Listener listener) {
        this.ES = i;
        this.Fz = listener;
        this.FA = new C1563a(null);
    }

    public void m6561a(OnEventResponse onEventResponse) {
        fq.m8521x(this.ES == onEventResponse.getEventType());
        switch (onEventResponse.getEventType()) {
            case Base64.NO_PADDING /*1*/:
                this.FA.m6558a(this.Fz, onEventResponse.fL());
            case Base64.NO_WRAP /*2*/:
                this.FA.m6558a(this.Fz, onEventResponse.fM());
            default:
                Log.w("EventCallback", "Unexpected event type:" + onEventResponse.getEventType());
        }
    }
}
