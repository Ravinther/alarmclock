package com.avg.toolkit.p051g;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import com.avg.toolkit.ITKSvc;
import com.avg.toolkit.p049e.C0970a;
import com.avg.toolkit.zen.C1050e;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

/* renamed from: com.avg.toolkit.g.b */
public class C0973b extends C0972a {
    public boolean load(Context context) {
        if (!C1050e.m4568r(context) || C0979g.m4355h(context)) {
            return false;
        }
        String token = C1050e.m4567q(context) ? C1050e.m4566p(context) : C1050e.m4562l(context);
        this.b = new Bundle();
        this.b.putString("authToken", token);
        this.b.putBoolean("fromLoad", true);
        return true;
    }

    public int getMessageId() {
        return 35003;
    }

    public boolean prepare(Context context) {
        if (this.b == null) {
            C0970a.m4325b("Missing data in createUACommClient. aborting action");
        }
        HttpResponse response = new C0975d(context.getApplicationContext(), C0977e.f2939a, C0977e.f2940b).m4339a(this.b.getString("authToken"));
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
        } else if (this.b.getBoolean("fromLoad")) {
            return m4332a(context, response);
        }
        return true;
    }

    private boolean m4332a(Context context, HttpResponse response) {
        if (response == null) {
            return false;
        }
        Boolean success = Boolean.valueOf(false);
        if (response.getStatusLine().getStatusCode() == 200) {
            try {
                JSONObject json = new JSONObject(EntityUtils.toString(response.getEntity(), "UTF-8"));
                String uaID = json.getString("accountId");
                String uaHash = json.getString("hash");
                String uaUserName = json.getString("login");
                C0979g.m4346a(context, uaID);
                C0979g.m4348b(context, uaHash);
                C0979g.m4350c(context, uaUserName);
                success = Boolean.valueOf(true);
            } catch (Exception e) {
                C0970a.m4325b("Error while trying to parse the UA LOGIN response in AuthUACommClient");
            }
        }
        return success.booleanValue();
    }

    public static void m4331a(Context appContext, Handler callbackHandler, String authToken) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("isUI", true);
        bundle.putString("authToken", authToken);
        if (callbackHandler != null) {
            bundle.putParcelable("messenger", new Messenger(callbackHandler));
        }
        ITKSvc.Do(appContext, 4000, 35003, bundle);
    }
}
