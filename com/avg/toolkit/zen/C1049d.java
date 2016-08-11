package com.avg.toolkit.zen;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import com.avg.toolkit.p034b.C0649d;
import com.avg.toolkit.p034b.C0950a.C0949c;
import com.avg.toolkit.p034b.C0955e;
import com.avg.toolkit.p049e.C0970a;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.avg.toolkit.zen.d */
public class C1049d extends C0649d {
    private Messenger f3226b;
    private int f3227c;

    public boolean load(Context context) {
        return false;
    }

    public C0949c getPriority() {
        return C0949c.ASAP;
    }

    public int getMessageId() {
        return 23001;
    }

    public String getXmlRpcMethod() {
        return null;
    }

    public boolean handleMessage(Context context, Message msg) {
        Bundle bundle = msg.obj;
        if (bundle != null) {
            this.f3226b = (Messenger) bundle.getParcelable("extra_messenger_callback");
            this.f3227c = bundle.getInt("extra_coupon_id");
        }
        return true;
    }

    public boolean prepare(Context context) {
        return false;
    }

    public boolean callFinished(Context context, Object result) {
        if (!(result instanceof JSONObject)) {
            return false;
        }
        boolean sendSuccess = ((JSONObject) result).optBoolean("status");
        Message message = Message.obtain(null, sendSuccess ? 1 : 2, 0, 0);
        if (this.f3226b == null) {
            return sendSuccess;
        }
        try {
            this.f3226b.send(message);
            return sendSuccess;
        } catch (Exception e) {
            C0970a.m4322a(e);
            return sendSuccess;
        }
    }

    public boolean handleDailyRun(Context context) {
        return false;
    }

    public boolean useDailyRun() {
        return false;
    }

    public int getJsonConfKey() {
        return 10;
    }

    public boolean prepareJson(Context context, JSONArray setParameters) {
        JSONObject tempReqParams = new JSONObject();
        boolean res = C0955e.m4288a(context, tempReqParams);
        if (!res) {
            return res;
        }
        try {
            tempReqParams.put("pver", "1");
            String mail = C1050e.m4557i(context);
            JSONObject tempReqFeatureParams = new JSONObject();
            tempReqFeatureParams.put("type", "ZEN_COUPON");
            tempReqFeatureParams.put("coupon", this.f3227c);
            tempReqFeatureParams.put("to", mail);
            this.jsonRequestParameters = tempReqParams;
            this.jsonRequestFeatureParameters = tempReqFeatureParams;
            return res;
        } catch (Exception e) {
            C0970a.m4322a(e);
            return false;
        }
    }
}
