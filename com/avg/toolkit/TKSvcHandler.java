package com.avg.toolkit;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

public class TKSvcHandler extends Handler {
    WeakReference f2661a;

    public TKSvcHandler(TKService service, Looper looper) {
        super(looper);
        this.f2661a = new WeakReference(service);
    }

    public void handleMessage(Message msg) {
        TKService service = (TKService) this.f2661a.get();
        if (service != null) {
            service.onHandlerMessage(msg);
        }
    }
}
