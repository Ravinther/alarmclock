package com.avg.toolkit.license;

import android.content.Context;
import android.os.Message;
import com.avg.toolkit.p034b.C0649d;
import com.avg.toolkit.p034b.C0950a.C0949c;
import com.avg.toolkit.p034b.C0955e;
import com.avg.toolkit.p049e.C0970a;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.avg.toolkit.license.e */
public class C1025e extends C0649d {
    public boolean load(Context context) {
        return false;
    }

    public C0949c getPriority() {
        return C0949c.REGULAR;
    }

    public int getMessageId() {
        return 5001;
    }

    public String getXmlRpcMethod() {
        return null;
    }

    public boolean handleMessage(Context context, Message msg) {
        return true;
    }

    public boolean handleDailyRun(Context context) {
        return true;
    }

    public boolean prepare(Context context) {
        return false;
    }

    public boolean callFinished(Context context, Object result) {
        if (!(result instanceof JSONObject)) {
            return false;
        }
        JSONObject ocmJson = (JSONObject) result;
        if (!"ERROR".equals(ocmJson.optString("status"))) {
            context.getSharedPreferences(OcmCampaigns.OCM_CAMPAIGN, 0).edit().putBoolean(OcmCampaigns.OCM_KILL_SWITCH, ocmJson.optBoolean("kill")).commit();
            return true;
        } else if (ocmJson.optBoolean("retry")) {
            return false;
        } else {
            return true;
        }
    }

    public int getJsonConfKey() {
        return 3;
    }

    public boolean prepareJson(Context context, JSONArray setParameters) {
        JSONObject tempReqParams = new JSONObject();
        boolean res = C0955e.m4288a(context, tempReqParams);
        if (!res) {
            return res;
        }
        try {
            JSONObject tempReqFeatureParams = new JSONObject();
            tempReqFeatureParams.put("kill", context.getSharedPreferences(OcmCampaigns.OCM_CAMPAIGN, 0).getBoolean(OcmCampaigns.OCM_KILL_SWITCH, false));
            this.jsonRequestParameters = tempReqParams;
            this.jsonRequestFeatureParameters = tempReqFeatureParams;
            return res;
        } catch (Exception e) {
            C0970a.m4322a(e);
            return false;
        }
    }

    public void callFinishedNoChange(Context context) {
    }

    public boolean useDailyRun() {
        return true;
    }
}
