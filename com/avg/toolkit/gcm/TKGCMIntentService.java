package com.avg.toolkit.gcm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.avg.toolkit.ITKSvc;
import com.avg.toolkit.p049e.C0970a;
import com.google.android.p052a.C0984a;

public class TKGCMIntentService extends C0984a {
    public TKGCMIntentService() {
        super("804293759086");
    }

    protected void m4376a(Context context, String errorId) {
    }

    protected void m4375a(Context context, Intent intent) {
        try {
            Bundle bundle = new Bundle();
            bundle.putBundle("extra", intent.getExtras());
            ITKSvc.Do(context, 24000, 24002, bundle);
        } catch (Exception e) {
            C0970a.m4322a(e);
        }
    }

    protected void m4377b(Context context, String regId) {
        Bundle bundle = new Bundle();
        bundle.putString("registration_id", regId);
        ITKSvc.Do(context, 24000, 24001, bundle);
    }

    protected void m4378c(Context context, String regId) {
    }
}
