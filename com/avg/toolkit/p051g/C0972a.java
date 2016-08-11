package com.avg.toolkit.p051g;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import com.avg.toolkit.p034b.C0649d;
import com.avg.toolkit.p034b.C0950a.C0949c;

/* renamed from: com.avg.toolkit.g.a */
public abstract class C0972a extends C0649d {
    protected Bundle f2930b;

    public C0949c getPriority() {
        return C0949c.ASAP;
    }

    public String getXmlRpcMethod() {
        return null;
    }

    public boolean handleMessage(Context context, Message msg) {
        if (msg.obj instanceof Bundle) {
            this.f2930b = (Bundle) msg.obj;
        }
        return true;
    }

    public boolean callFinished(Context context, Object result) {
        return false;
    }
}
