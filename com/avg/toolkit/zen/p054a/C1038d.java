package com.avg.toolkit.zen.p054a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Base64;
import com.avg.toolkit.license.C1017a;
import com.avg.toolkit.license.C1019b;
import com.avg.toolkit.p034b.C0952b;
import com.avg.toolkit.p034b.C0954c;
import com.avg.toolkit.p049e.C0970a;
import com.avg.toolkit.uid.UUID;
import com.avg.toolkit.zen.C1045b;
import com.avg.toolkit.zen.C1048c;
import com.avg.toolkit.zen.C1050e;
import com.avg.toolkit.zen.pojo.DeviceReportsWrapper;
import com.avg.toolkit.zen.pojo.SharedData;
import com.google.android.gms.wallet.WalletConstants;
import java.io.UnsupportedEncodingException;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.avg.toolkit.zen.a.d */
public class C1038d {

    /* renamed from: com.avg.toolkit.zen.a.d.a */
    public enum C1036a {
        SUCCESS,
        UNAUTHORIZED,
        CONNECTION_ERROR,
        DATA_ERROR,
        DEFAULT_ERROR,
        DEVICE_REMOVED,
        VERIFICATION_ERROR
    }

    /* renamed from: com.avg.toolkit.zen.a.d.b */
    public enum C1037b {
        PUT,
        POST,
        GET,
        DELETE
    }

    protected static String m4513a() {
        C1017a avgFeatures = C1019b.m4431a();
        if (avgFeatures == null || !avgFeatures.m4429d()) {
            return "zas-api.avg.com";
        }
        return "zas-api-beta.avg.com";
    }

    protected static String m4525b() {
        return "https://" + C1038d.m4513a();
    }

    public static void m4517a(Context context) {
        C1038d.m4518a(context, null);
    }

    public static void m4518a(Context context, Bundle bundle) {
        Intent intent = new Intent("com.avg.zen.loginreceiver");
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        context.sendBroadcast(intent);
    }

    public static void m4521a(Context appContext, boolean login) {
        Intent intent = new Intent("com.avg.zen.action.GLOBAL_LOGIN_STATUS_CHANGE");
        intent.putExtra("is_logged_in", login);
        intent.putExtra("package_name", appContext.getPackageName());
        appContext.sendBroadcast(intent);
    }

    public static void m4520a(Context context, String trigger) {
        Intent intent = new Intent("com.avg.zen.reportsreceiver");
        intent.putExtra("extra_trigger", trigger);
        context.sendBroadcast(intent);
    }

    public static void m4519a(Context appContext, C1045b reportBuilder, String Trigger) {
        appContext = appContext.getApplicationContext();
        if (!C1050e.m4568r(appContext)) {
            return;
        }
        if (C0952b.m4281a(appContext)) {
            new C1042h(appContext, reportBuilder, null, Trigger).execute(new Void[0]);
        } else {
            C1050e.m4541a(appContext, true);
        }
    }

    static HttpResponse m4516a(Context appContext, String login, String pwd, boolean register, C1045b reportBuilder, String trigger) {
        if (!C0952b.m4281a(appContext)) {
            return null;
        }
        String urlPath = C1038d.m4525b() + "/zen";
        pwd = Base64.encodeToString(pwd.getBytes(), 2);
        String authFormat = "ZenAuth login=\"%s\" pwd=\"%s\" register=\"%s\"";
        Header[] headers = new Header[4];
        headers[0] = new BasicHeader("Host", C1038d.m4513a());
        headers[1] = new BasicHeader("Accept", "application/vnd.avg.zen-v1.2+json; charset=utf-8");
        headers[2] = new BasicHeader(MraidCommandStorePicture.MIME_TYPE_HEADER, "application/vnd.avg.zen-v1.2+json; charset=utf-8");
        String str = "Authorization";
        Object[] objArr = new Object[3];
        objArr[0] = login;
        objArr[1] = pwd;
        objArr[2] = register ? "true" : "false";
        headers[3] = new BasicHeader(str, String.format(authFormat, objArr));
        StringEntity body = null;
        if (reportBuilder != null) {
            try {
                body = new StringEntity(C1038d.m4526b(appContext, reportBuilder), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                C0970a.m4325b("Unsupported encoding exception throws for UTF-8 ");
            }
        }
        return C0954c.m4285a(appContext, urlPath, C1037b.POST, body, headers, trigger);
    }

    static HttpResponse m4515a(Context appContext, C1045b zenReporter, String invite, String trigger) {
        if (!C0952b.m4281a(appContext)) {
            return null;
        }
        String urlPath = C1038d.m4525b() + "/invite/accept";
        Header[] headers = new Header[4];
        headers[0] = new BasicHeader("Host", C1038d.m4513a());
        headers[1] = new BasicHeader(MraidCommandStorePicture.MIME_TYPE_HEADER, "application/vnd.avg.zen-v1.2+json; charset=utf-8");
        headers[2] = new BasicHeader("Accept", "application/vnd.avg.zen-v1.2+json; charset=utf-8");
        headers[3] = new BasicHeader("Authorization", String.format("ZenAuth token=\"%s\"", new Object[]{invite}));
        StringEntity body = null;
        try {
            body = new StringEntity(C1038d.m4526b(appContext, zenReporter), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            C0970a.m4325b("Unsupported encoding exception throws for UTF-8 ");
        }
        return C0954c.m4285a(appContext, urlPath, C1037b.POST, body, headers, trigger);
    }

    static C1036a m4522b(Context appContext, C1045b zenReporter, String trigger) {
        String zenID = C1050e.m4539a(appContext);
        String deviceID = C1050e.m4542b(appContext);
        String applicationID = zenReporter.m4537a();
        String deviceToken = C1050e.m4545c(appContext);
        String urlPath = C1038d.m4525b() + "/zen/" + zenID + "/device/" + deviceID + "/app/" + applicationID;
        headers = new Header[4];
        headers[0] = new BasicHeader("Host", C1038d.m4513a());
        headers[1] = new BasicHeader(MraidCommandStorePicture.MIME_TYPE_HEADER, "application/vnd.avg.zen-v1.2+json; charset=utf-8");
        headers[2] = new BasicHeader("Accept", "text/vnd.avg.zen-v1.2+plain; charset=utf-8");
        headers[3] = new BasicHeader("Authorization", String.format("ZenAuth token=\"%s\"", new Object[]{deviceToken}));
        StringEntity body = null;
        try {
            body = new StringEntity(C1038d.m4514a(appContext, zenReporter), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            C0970a.m4325b("Unsupported encoding exception throws for UTF-8 ");
        }
        HttpResponse response = C0954c.m4285a(appContext, urlPath, C1037b.PUT, body, headers, trigger);
        C1036a commResponse = C1036a.DEFAULT_ERROR;
        if (response == null) {
            C0970a.m4325b("Failed sending UPDATE DEVICE request");
            return C1036a.CONNECTION_ERROR;
        }
        int stausCode = response.getStatusLine().getStatusCode();
        if (stausCode == 200) {
            C1050e.m4541a(appContext, false);
            commResponse = C1036a.SUCCESS;
        } else if (stausCode == 410) {
            C1050e.m4541a(appContext, false);
            C1050e.m4569s(appContext);
            C1038d.m4517a(appContext);
            commResponse = C1036a.DEVICE_REMOVED;
        } else {
            C1050e.m4541a(appContext, true);
        }
        return commResponse;
    }

    static C1036a m4512a(Context appContext, String appID, String trigger) {
        if (!C0952b.m4281a(appContext)) {
            return C1036a.CONNECTION_ERROR;
        }
        String zenID = C1050e.m4539a(appContext);
        String deviceID = C1050e.m4542b(appContext);
        String userToken = C1050e.m4545c(appContext);
        String urlPath = C1038d.m4525b() + "/zen/" + zenID + "/device/" + deviceID + "/app/" + appID + "/alive";
        Header[] headers = new Header[3];
        headers[0] = new BasicHeader("Host", C1038d.m4513a());
        headers[1] = new BasicHeader("Accept", "text/vnd.avg.zen-v1.2+plain; charset=utf-8");
        headers[2] = new BasicHeader("Authorization", String.format("ZenAuth token=\"%s\"", new Object[]{userToken}));
        HttpResponse response = C0954c.m4285a(appContext, urlPath, C1037b.POST, null, headers, trigger);
        C1036a commResponse = C1036a.DEFAULT_ERROR;
        if (response == null) {
            C0970a.m4325b("Failed sending ALIVE request");
            return C1036a.CONNECTION_ERROR;
        }
        int stausCode = response.getStatusLine().getStatusCode();
        if (stausCode == 200) {
            return C1036a.SUCCESS;
        }
        if (stausCode != WalletConstants.ERROR_CODE_INVALID_TRANSACTION) {
            return commResponse;
        }
        C1050e.m4541a(appContext, false);
        C1050e.m4569s(appContext);
        C1038d.m4517a(appContext);
        return C1036a.DEVICE_REMOVED;
    }

    static C1036a m4523b(Context appContext, String trigger) {
        if (C0952b.m4281a(appContext)) {
            String zenID = C1050e.m4539a(appContext);
            String deviceID = C1050e.m4542b(appContext);
            String userToken = C1050e.m4545c(appContext);
            String urlPath = C1038d.m4525b() + "/zen/" + zenID + "/device/" + deviceID + "/unlink";
            Header[] headers = new Header[3];
            headers[0] = new BasicHeader("Host", C1038d.m4513a());
            headers[1] = new BasicHeader("Accept", "text/vnd.avg.zen-v1.2+plain; charset=utf-8");
            headers[2] = new BasicHeader("Authorization", String.format("ZenAuth token=\"%s\"", new Object[]{userToken}));
            HttpResponse response = C0954c.m4285a(appContext, urlPath, C1037b.POST, null, headers, trigger);
            C1036a commResponse = C1036a.DEFAULT_ERROR;
            if (response == null) {
                C0970a.m4325b("Failed sending UNLINK DEVICE request");
                C1050e.m4569s(appContext);
                return C1036a.CONNECTION_ERROR;
            }
            if (response.getStatusLine().getStatusCode() == 200) {
                commResponse = C1036a.SUCCESS;
            }
            C1050e.m4569s(appContext);
            return commResponse;
        }
        C1050e.m4569s(appContext);
        return C1036a.CONNECTION_ERROR;
    }

    static C1036a m4524b(Context appContext, String appID, String gcmToken) {
        boolean network = C0952b.m4281a(appContext);
        boolean connected = C1050e.m4568r(appContext);
        if (!network || !connected) {
            return C1036a.CONNECTION_ERROR;
        }
        boolean isAdmin = C1050e.m4570t(appContext);
        if (isAdmin && C1050e.m4567q(appContext)) {
            return C1036a.DEFAULT_ERROR;
        }
        String urlPath;
        String zenID = C1050e.m4539a(appContext);
        String deviceID = C1050e.m4542b(appContext);
        String userToken = isAdmin ? C1050e.m4562l(appContext) : C1050e.m4545c(appContext);
        if (isAdmin) {
            urlPath = C1038d.m4525b() + "/zen/" + zenID + "/device/" + deviceID + "/config";
        } else {
            urlPath = C1038d.m4525b() + "/zen/" + zenID + "/device/" + deviceID + "/app/" + appID + "/config";
        }
        headers = new Header[4];
        headers[0] = new BasicHeader("Host", C1038d.m4513a());
        headers[1] = new BasicHeader("Accept", "text/vnd.avg.zen-v1.2+plain; charset=utf-8");
        headers[2] = new BasicHeader(MraidCommandStorePicture.MIME_TYPE_HEADER, "application/vnd.avg.zen-v1.2+json; charset=utf-8");
        headers[3] = new BasicHeader("Authorization", String.format("ZenAuth token=\"%s\"", new Object[]{userToken}));
        StringEntity body = null;
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("reg_id", gcmToken);
            body = new StringEntity(jsonObject.toString(), "UTF-8");
        } catch (Exception e) {
            C0970a.m4325b("Error preparing sendAppConfs data");
        }
        HttpResponse response = C0954c.m4285a(appContext, urlPath, C1037b.PUT, body, headers, "AppConfigs");
        C1036a commResponse = C1036a.DEFAULT_ERROR;
        if (response == null) {
            C0970a.m4325b("Failed sending Application Configuration request");
            return C1036a.CONNECTION_ERROR;
        } else if (response.getStatusLine().getStatusCode() == 200) {
            return C1036a.SUCCESS;
        } else {
            return commResponse;
        }
    }

    private static String m4514a(Context context, C1045b zenReport) {
        context = context.getApplicationContext();
        String jsonReport = C1048c.m4538a().create().toJson(zenReport.m4536a(context));
        if (C1050e.m4554g(context)) {
            String gcmId = C1050e.m4551f(context);
            try {
                JSONObject jsonObject = new JSONObject(jsonReport);
                jsonObject.put("reg_id", gcmId);
                jsonReport = jsonObject.toString();
            } catch (JSONException e) {
            }
        }
        return jsonReport;
    }

    private static String m4526b(Context context, C1045b zenReport) {
        context = context.getApplicationContext();
        Object reports = zenReport.m4536a(context);
        Object wrapper = new DeviceReportsWrapper();
        if (reports == null) {
            wrapper.apps = new Object[0];
        } else {
            wrapper.apps = new Object[1];
            wrapper.apps[0] = reports;
        }
        wrapper.shared_data = new SharedData();
        wrapper.shared_data.device_type = C1038d.m4527b(context) ? "tablet" : "phone";
        wrapper.shared_data.name = Build.MODEL;
        String uuidText = new UUID(context).getUUID();
        if (uuidText == null) {
            uuidText = "";
        }
        wrapper.hw_id = uuidText;
        return C1048c.m4538a().create().toJson(wrapper);
    }

    @SuppressLint({"NewApi"})
    public static boolean m4527b(Context context) {
        boolean z = true;
        if (VERSION.SDK_INT < 11) {
            return false;
        }
        if (VERSION.SDK_INT < 13) {
            return true;
        }
        try {
            if (context.getResources().getConfiguration().smallestScreenWidthDp < 600) {
                z = false;
            }
            return z;
        } catch (Throwable th) {
            return false;
        }
    }
}
