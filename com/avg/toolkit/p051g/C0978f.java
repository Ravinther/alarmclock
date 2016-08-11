package com.avg.toolkit.p051g;

import android.os.Handler;
import android.os.Message;
import com.avg.toolkit.zen.p054a.C1033a;
import com.avg.toolkit.zen.p054a.C1033a.C1032a;

/* renamed from: com.avg.toolkit.g.f */
public class C0978f extends Handler {
    private C1033a f2943a;

    public C0978f(C1033a loginCallBack) {
        this.f2943a = loginCallBack;
    }

    public void handleMessage(Message msg) {
        String responseJson = "";
        int responseCode = -1;
        if (msg.obj instanceof String) {
            responseJson = msg.obj;
            responseCode = msg.what;
        }
        this.f2943a.m4509a(C1032a.UA, responseCode, responseJson);
    }
}
