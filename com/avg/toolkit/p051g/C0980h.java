package com.avg.toolkit.p051g;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import com.avg.toolkit.ITKSvc;
import com.avg.toolkit.p049e.C0970a;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

/* renamed from: com.avg.toolkit.g.h */
public class C0980h extends C0972a {
    public boolean load(Context context) {
        return false;
    }

    public int getMessageId() {
        return 35002;
    }

    public boolean prepare(Context context) {
        if (this.b == null) {
            C0970a.m4325b("Missing data in createUACommClient. aborting action");
        }
        HttpResponse response = new C0975d(context.getApplicationContext(), C0977e.f2939a, C0977e.f2940b).m4341a(this.b.getString("userName"), this.b.getString("password"), this.b.getBoolean("register"));
        Messenger messenger = (Messenger) this.b.getParcelable("messenger");
        if (messenger != null) {
            int responseCode = -1;
            try {
                String responseJson = "";
                if (response != null) {
                    responseCode = response.getStatusLine().getStatusCode();
                    responseJson = EntityUtils.toString(response.getEntity(), "UTF-8");
                }
                messenger.send(Message.obtain(null, responseCode, 0, 0, responseJson));
            } catch (Exception e) {
                C0970a.m4322a(e);
            }
        }
        return true;
    }

    public static void m4357a(Context appContext, Handler callbackHandler, String userName, String pwd, boolean register) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("isUI", true);
        bundle.putString("userName", userName);
        bundle.putString("password", pwd);
        bundle.putBoolean("register", register);
        if (callbackHandler != null) {
            bundle.putParcelable("messenger", new Messenger(callbackHandler));
        }
        ITKSvc.Do(appContext, 4000, 35002, bundle);
    }
}
