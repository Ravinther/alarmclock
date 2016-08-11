package com.avg.toolkit.ganalytics;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Message;
import com.avg.toolkit.p034b.C0649d;
import com.avg.toolkit.p034b.C0950a.C0949c;
import com.avg.toolkit.p034b.C0955e;
import com.avg.toolkit.p049e.C0970a;
import com.google.android.gms.games.GamesActivityResultCodes;
import org.json.JSONArray;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p005b.C0003a;

/* renamed from: com.avg.toolkit.ganalytics.a */
public class C0983a extends C0649d {
    private String f2955b;

    public C0983a() {
        this.f2955b = "";
    }

    public boolean load(Context context) {
        return false;
    }

    public C0949c getPriority() {
        return C0949c.REGULAR;
    }

    public int getMessageId() {
        return GamesActivityResultCodes.RESULT_RECONNECT_REQUIRED;
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
        JSONObject configuration = (JSONObject) result;
        if (!"ERROR".equals(configuration.optString("status"))) {
            try {
                long cver = configuration.getLong(GoogleAnalyticsWrapper.PREFS_KEY_CVER);
                float sampleRate = (float) configuration.getDouble(GoogleAnalyticsWrapper.PROPERTY_SAMPLE_RATE);
                int dispPeriod = configuration.getInt(GoogleAnalyticsWrapper.PREFS_KEY_DISPATCH_PERIOD);
                Editor editor = context.getSharedPreferences(GoogleAnalyticsWrapper.GA_PREFS_FILENAME, 0).edit();
                editor.putLong(GoogleAnalyticsWrapper.PREFS_KEY_CVER, cver);
                if (dispPeriod > 0) {
                    editor.putInt(GoogleAnalyticsWrapper.PREFS_KEY_DISPATCH_PERIOD, dispPeriod);
                }
                if (sampleRate >= 0.0f && sampleRate <= 100.0f) {
                    editor.putFloat(GoogleAnalyticsWrapper.PROPERTY_SAMPLE_RATE, sampleRate);
                }
                editor.putString(GoogleAnalyticsWrapper.PREFS_KEY_LAST_REQUEST, this.f2955b);
                editor.putInt(GoogleAnalyticsWrapper.PREFS_KEY_LAST_PVER, 1);
                editor.commit();
                return true;
            } catch (Exception e) {
                C0970a.m4322a(e);
                return false;
            }
        } else if (configuration.optBoolean("retry")) {
            return false;
        } else {
            return true;
        }
    }

    public void callFinishedNoChange(Context context) {
    }

    public int getJsonConfKey() {
        return 18;
    }

    public boolean prepareJson(Context context, JSONArray setParameters) {
        JSONObject tempReqParams = new JSONObject();
        if (!C0955e.m4289a(context, tempReqParams, false, true, true, true, true, false, true)) {
            return false;
        }
        try {
            JSONObject tempReqFeatureParams = new JSONObject();
            SharedPreferences prefs = context.getSharedPreferences(GoogleAnalyticsWrapper.GA_PREFS_FILENAME, 0);
            if (prefs.contains(GoogleAnalyticsWrapper.PREFS_KEY_CVER)) {
                tempReqFeatureParams.put(GoogleAnalyticsWrapper.PREFS_KEY_CVER, prefs.getLong(GoogleAnalyticsWrapper.PREFS_KEY_CVER, 0));
            }
            tempReqFeatureParams.put("pver", 1);
            this.f2955b = C0003a.m39d(tempReqParams.toString().getBytes());
            if (!(prefs.getInt(GoogleAnalyticsWrapper.PREFS_KEY_LAST_PVER, -1) == 1 && this.f2955b.equals(prefs.getString(GoogleAnalyticsWrapper.PREFS_KEY_LAST_REQUEST, "")))) {
                tempReqFeatureParams.put("mod", true);
            }
            this.jsonRequestFeatureParameters = tempReqFeatureParams;
            this.jsonRequestParameters = tempReqParams;
            return true;
        } catch (Exception e) {
            C0970a.m4322a(e);
            return false;
        }
    }

    public boolean useDailyRun() {
        return true;
    }

    public boolean handleDailyRun(Context context) {
        return true;
    }
}
