package com.anglelabs.alarmclock.redesign.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.anglelabs.alarmclock.redesign.utils.C0811i;
import com.anglelabs.alarmclock.redesign.utils.C0849p;
import com.anglelabs.alarmclock.redesign.utils.ac;
import com.avg.toolkit.p034b.C0955e;
import com.avg.toolkit.p035c.C0650a;
import com.avg.toolkit.p049e.C0970a;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.anglelabs.alarmclock.redesign.app.a */
public class C0651a extends C0650a {

    /* renamed from: com.anglelabs.alarmclock.redesign.app.a.a */
    final class C0648a {
        public String f1727a;
        public String f1728b;
        final /* synthetic */ C0651a f1729c;

        C0648a(C0651a c0651a, JSONObject jsonObject) {
            this.f1729c = c0651a;
            if (jsonObject != null) {
                this.f1728b = jsonObject.optString("uploadURL", "");
                this.f1727a = jsonObject.optString("HTTPMethod", "");
            }
        }

        public boolean m2993a() {
            return (TextUtils.isEmpty(this.f1727a) || TextUtils.isEmpty(this.f1728b)) ? false : true;
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
            tempJson.put("hasFile", true);
            this.jsonRequestFeatureParameters = tempJson;
            return true;
        } catch (Exception e) {
            C0970a.m4322a(e);
            return false;
        }
    }

    public boolean callFinished(Context context, Object result) {
        boolean isSuccess = super.callFinished(context, result);
        if (!isSuccess || !(result instanceof JSONObject)) {
            return isSuccess;
        }
        C0648a uploadInfo = new C0648a(this, (JSONObject) result);
        SharedPreferences prefs = ac.m3774b(context);
        File log = C0849p.m3974a();
        if (!m2999a(uploadInfo, prefs, log)) {
            return true;
        }
        C0849p.m3975a(context);
        if (m2997a(uploadInfo.f1728b, uploadInfo.f1727a, log) == 0) {
            prefs.edit().putLong("log_file_last_sent_time", System.currentTimeMillis()).apply();
        }
        return true;
    }

    private boolean m2999a(C0648a uploadInfo, SharedPreferences prefs, File log) {
        if (uploadInfo.m2993a() && log != null && log.exists() && log.canRead() && m2998a(prefs, log)) {
            return true;
        }
        return false;
    }

    private boolean m2998a(SharedPreferences prefs, File log) {
        long lastSentTime = prefs.getLong("log_file_last_sent_time", -1);
        long lastModifiedTime = log.lastModified();
        if (lastSentTime == -1 || lastModifiedTime > lastSentTime) {
            return true;
        }
        return false;
    }

    private int m2997a(String urlStr, String httpMethod, File fileToSend) {
        return C0811i.m3840a(urlStr, httpMethod, fileToSend, true);
    }

    public Class m3000a() {
        return getClass();
    }
}
