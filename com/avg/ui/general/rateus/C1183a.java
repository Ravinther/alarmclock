package com.avg.ui.general.rateus;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Message;
import com.avg.toolkit.ganalytics.GoogleAnalyticsWrapper;
import com.avg.toolkit.p034b.C0649d;
import com.avg.toolkit.p034b.C0950a.C0949c;
import com.avg.toolkit.p034b.C0955e;
import com.avg.toolkit.p049e.C0970a;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.avg.ui.general.rateus.a */
public class C1183a extends C0649d {
    public boolean prepareJson(Context context, JSONArray setParameters) {
        JSONObject tempReqParams = new JSONObject();
        boolean res = C0955e.m4288a(context, tempReqParams);
        if (!res) {
            return res;
        }
        try {
            JSONObject tempReqFeatureParams = new JSONObject();
            SharedPreferences pref = context.getSharedPreferences("RateUsSharedPrefs", 0);
            if (pref.contains("RateUsFeature_cver")) {
                tempReqFeatureParams.put(GoogleAnalyticsWrapper.PREFS_KEY_CVER, pref.getInt("RateUsFeature_cver", 0));
            }
            this.jsonRequestParameters = tempReqParams;
            this.jsonRequestFeatureParameters = tempReqFeatureParams;
            return res;
        } catch (Exception e) {
            C0970a.m4322a(e);
            return false;
        }
    }

    public int getJsonConfKey() {
        return 20;
    }

    public boolean useDailyRun() {
        return true;
    }

    public boolean handleDailyRun(Context context) {
        return true;
    }

    public boolean load(Context context) {
        return false;
    }

    public C0949c getPriority() {
        return C0949c.REGULAR;
    }

    public int getMessageId() {
        return 78001;
    }

    public String getXmlRpcMethod() {
        return null;
    }

    public boolean handleMessage(Context context, Message msg) {
        return false;
    }

    public boolean prepare(Context context) {
        return false;
    }

    public boolean callFinished(Context context, Object result) {
        if (!(result instanceof JSONObject)) {
            return false;
        }
        JSONObject responseJson = (JSONObject) result;
        if (!"ERROR".equals(responseJson.optString("status"))) {
            int cver = responseJson.optInt(GoogleAnalyticsWrapper.PREFS_KEY_CVER);
            int launch = responseJson.optInt("launch");
            int daysNT = responseJson.optInt("daysNT");
            int daysLTR = responseJson.optInt("daysLTR");
            String marketUrl = responseJson.optString("market_url", "market://details?id=" + context.getPackageName());
            String webUrl = responseJson.optString("web_url", "http://play.google.com/store/apps/details?id=" + context.getPackageName());
            context.getSharedPreferences("RateUsSharedPrefs", 0).edit().putInt("RateUsFeature_cver", cver).putInt("launch", launch).putInt("daysNT", daysNT).putInt("daysLTR", daysLTR).apply();
            return true;
        } else if (responseJson.optBoolean("retry")) {
            return false;
        } else {
            return true;
        }
    }

    public void callFinishedNoChange(Context context) {
    }
}
