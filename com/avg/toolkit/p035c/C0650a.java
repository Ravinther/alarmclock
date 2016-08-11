package com.avg.toolkit.p035c;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.avg.toolkit.C0647c;
import com.avg.toolkit.ITKSvc;
import com.avg.toolkit.license.C1017a;
import com.avg.toolkit.p034b.C0649d;
import com.avg.toolkit.p034b.C0950a.C0949c;
import com.avg.toolkit.p034b.C0955e;
import com.avg.toolkit.p034b.C0956f;
import com.avg.toolkit.p049e.C0970a;
import com.google.android.gms.plus.PlusShare;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.avg.toolkit.c.a */
public class C0650a extends C0649d implements C0647c {
    public static void m2994a(Context context) {
        try {
            Bundle bundle = new Bundle();
            bundle.putBoolean("isUI", true);
            ITKSvc.Do(context, 4000, 14001, bundle);
        } catch (Exception e) {
            C0970a.m4322a(e);
        }
    }

    public boolean prepareJson(Context context, JSONArray setParameters) {
        JSONObject tempJson = new JSONObject();
        if (!C0955e.m4288a(context, tempJson)) {
            return false;
        }
        this.jsonRequestParameters = tempJson;
        tempJson = new JSONObject();
        try {
            tempJson.put("platform", "Android");
            tempJson.put("pckg", context.getPackageName());
            tempJson.put("devTime", System.currentTimeMillis());
            String arch = System.getProperty("os.arch");
            if (arch != null && arch.length() > 0) {
                tempJson.put("cpu_arch", arch);
            }
            tempJson.put("pver", 1);
            tempJson.put("extra", Build.FINGERPRINT + " " + Build.DISPLAY);
            this.jsonRequestFeatureParameters = tempJson;
            return true;
        } catch (Exception e) {
            C0970a.m4322a(e);
            return false;
        }
    }

    public boolean prepare(Context context) {
        return true;
    }

    public boolean handleMessage(Context context, Message msg) {
        return true;
    }

    public boolean load(Context context) {
        return false;
    }

    public C0949c getPriority() {
        return C0949c.ASAP;
    }

    public int getMessageId() {
        return 14001;
    }

    public String getXmlRpcMethod() {
        return null;
    }

    public int getJsonConfKey() {
        return 15;
    }

    public boolean callFinished(Context context, Object result) {
        Intent intent = new Intent("inAppIntentFilterScreen");
        if (result instanceof JSONObject) {
            JSONObject json = (JSONObject) result;
            boolean success = json.optBoolean("status", false);
            String resStr = json.optString("id", "");
            if (!success || TextUtils.isEmpty(resStr)) {
                m2995b(context);
                return false;
            }
            try {
                intent.putExtra(PlusShare.KEY_CALL_TO_ACTION_URL, new C0956f(context).m4297a() + ("/mobile/contact.jsp?requestID=" + resStr));
                intent.putExtra("result", true);
                context.sendBroadcast(intent);
                return true;
            } catch (Exception e) {
                C0970a.m4322a(e);
                m2995b(context);
                return false;
            }
        }
        C0970a.m4325b("response type mismatch");
        m2995b(context);
        return false;
    }

    private void m2995b(Context context) {
        Intent intent = new Intent("inAppIntentFilterScreen");
        intent.putExtra("result", false);
        context.sendBroadcast(intent);
    }

    public int getID() {
        return 14000;
    }

    public void setComm(List commClients) {
        commClients.add(m2996a());
    }

    public void onStart(boolean firstTime) {
    }

    public void onMessage(Bundle arguments) {
    }

    public void onAlarm(Bundle arguments) {
    }

    public void onDailyTask(C1017a avgFeatures) {
    }

    public void onNewLicense(C1017a avgFeatures) {
    }

    public void onDestroy() {
    }

    public Class m2996a() {
        return C0650a.class;
    }
}
