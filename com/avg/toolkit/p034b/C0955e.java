package com.avg.toolkit.p034b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.avg.toolkit.crashReport.CrashReport;
import com.avg.toolkit.license.C1017a;
import com.avg.toolkit.license.C1019b;
import com.avg.toolkit.license.C1020c;
import com.avg.toolkit.p049e.C0970a;
import com.mopub.mobileads.CustomEventBannerAdapter;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p005b.C0003a;

/* renamed from: com.avg.toolkit.b.e */
public class C0955e {
    private static Integer f2886a;
    private JSONObject f2887b;

    static void m4287a(int pid) {
        f2886a = Integer.valueOf(pid);
    }

    @SuppressLint({"NewApi"})
    private static long m4286a(Context context) {
        try {
            if (VERSION.SDK_INT > 8) {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).firstInstallTime;
            }
            return -1;
        } catch (Exception e) {
            C0970a.m4322a(e);
            return -1;
        }
    }

    public static boolean m4288a(Context context, JSONObject requestJson) {
        return C0955e.m4289a(context, requestJson, true, true, true, true, true, true, true);
    }

    public static boolean m4289a(Context context, JSONObject requestJson, boolean screen, boolean device, boolean language, boolean operator, boolean appVer, boolean dates, boolean license) {
        JSONObject tempJson = new JSONObject();
        C1017a features = C1019b.m4431a();
        if (features == null) {
            return false;
        }
        if (f2886a == null) {
            return false;
        }
        if (license) {
            tempJson.put("pid", f2886a);
            tempJson.put("lictype", features.m4427b() ? "free" : "pro");
            tempJson.put("vc", features.f3120f);
            tempJson.put("lic", new C1020c(context).m4453d());
        }
        if (dates) {
            tempJson.put("licdate", features.f3126l);
            long idate = C0955e.m4286a(context);
            if (idate > 0) {
                tempJson.put("idate", idate);
            }
        }
        if (screen) {
            WindowManager wm = (WindowManager) context.getSystemService("window");
            if (wm != null) {
                Display display = wm.getDefaultDisplay();
                DisplayMetrics metrics = new DisplayMetrics();
                display.getMetrics(metrics);
                tempJson.put("scrw", metrics.widthPixels);
                tempJson.put("scrh", metrics.heightPixels);
            }
        }
        if (device) {
            String model = "";
            try {
                model = Build.MODEL != null ? Build.MODEL : "";
            } catch (Exception e) {
            }
            try {
                if (!model.equals("")) {
                    tempJson.put("model", model);
                }
                String manufacturer = "";
                try {
                    if (VERSION.SDK_INT > 3) {
                        manufacturer = Build.class.getField("MANUFACTURER").get(null).toString();
                    }
                } catch (Exception e2) {
                }
                if (!manufacturer.equals("")) {
                    tempJson.put("mfr", manufacturer);
                }
                tempJson.put("os", VERSION.RELEASE);
                tempJson.put("osapil", String.valueOf(VERSION.SDK_INT));
            } catch (Exception e3) {
                C0970a.m4322a(e3);
                return false;
            }
        }
        if (language) {
            tempJson.put("lang", Locale.getDefault().toString());
        }
        if (operator) {
            TelephonyManager tm = (TelephonyManager) context.getSystemService("phone");
            if (tm != null) {
                String tmp = tm.getNetworkCountryIso();
                if (tmp != null) {
                    if (!tmp.equals("")) {
                        tempJson.put("nctr", tmp);
                    }
                }
                tmp = tm.getSimCountryIso();
                if (tmp != null) {
                    if (!tmp.equals("")) {
                        tempJson.put("ctr", tmp);
                    }
                }
                tmp = tm.getNetworkOperatorName();
                if (tmp != null) {
                    if (!tmp.equals("")) {
                        tempJson.put("oper", tmp);
                    }
                }
            }
        }
        if (appVer) {
            PackageInfo pkgInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            tempJson.put("mjver", pkgInfo.versionName);
            tempJson.put("minver", pkgInfo.versionCode);
        }
        Iterator keys = tempJson.keys();
        while (keys.hasNext()) {
            String key = (String) keys.next();
            requestJson.put(key, tempJson.get(key));
        }
        return true;
    }

    public int m4290a(Context context, JSONObject requestParams, JSONArray requestFeatures, JSONObject requestFeatureParams, String serialNum) {
        int i;
        HttpURLConnection connection = null;
        try {
            JSONObject json = new JSONObject();
            Iterator keys = requestParams.keys();
            while (keys.hasNext()) {
                String key = (String) keys.next();
                json.put(key, requestParams.get(key));
            }
            json.put("pver", 1);
            json.put("reqft", requestFeatures);
            json.put("ftparam", requestFeatureParams);
            C1017a features = C1019b.m4431a();
            if (features == null) {
                i = 1;
                if (connection != null) {
                    connection.disconnect();
                }
            } else if (f2886a == null) {
                i = 1;
                if (connection != null) {
                    connection.disconnect();
                }
            } else {
                URL url = new URL(new C0956f(context).m4297a() + "/rest/conf/" + serialNum);
                PackageInfo pkgInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                Object[] objArr = new Object[6];
                objArr[0] = VERSION.RELEASE;
                objArr[1] = Build.DEVICE;
                objArr[2] = Integer.toString(f2886a.intValue());
                objArr[3] = Integer.toString(features.f3120f);
                objArr[4] = pkgInfo.versionName;
                objArr[5] = Integer.valueOf(pkgInfo.versionCode);
                String userAgent = String.format("Mozilla/5.0 (Linux; U; Android %s; en-us; %s) pid/%s vc/%s (KHTML, like Gecko) Version/%s.%s", objArr);
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("POST");
                connection.setRequestProperty("User-Agent", userAgent);
                connection.setRequestProperty(MraidCommandStorePicture.MIME_TYPE_HEADER, "application/json");
                connection.setRequestProperty("x-auth-token", C0003a.m36c(serialNum + "d5544fG==*%877hT--==QQUPWeeY89904469=="));
                connection.setDoOutput(true);
                connection.setConnectTimeout(CustomEventBannerAdapter.DEFAULT_BANNER_TIMEOUT_DELAY);
                connection.setReadTimeout(CrashReport.FEATURE_ID);
                connection.connect();
                DataOutputStream out = new DataOutputStream(connection.getOutputStream());
                out.writeBytes(json.toString());
                out.writeBytes("\n\n");
                out.flush();
                int response = connection.getResponseCode();
                int contentLength = connection.getContentLength();
                if (response == 304) {
                    i = 3;
                    if (connection != null) {
                        connection.disconnect();
                    }
                } else {
                    InputStream is = connection.getInputStream();
                    char[] buffer = new char[1024];
                    Writer writer = new StringWriter();
                    InputStreamReader reader = new InputStreamReader(is, Charset.forName("UTF-8"));
                    while (true) {
                        int len = reader.read(buffer);
                        if (len == -1) {
                            break;
                        }
                        writer.write(buffer, 0, len);
                    }
                    connection.disconnect();
                    connection = null;
                    writer.flush();
                    String responseStr = writer.toString();
                    writer.close();
                    try {
                        this.f2887b = new JSONObject(responseStr);
                        i = response == 200 ? 0 : 2;
                        if (connection != null) {
                            connection.disconnect();
                        }
                    } catch (Exception e) {
                        C0970a.m4322a(e);
                        i = 2;
                        if (connection != null) {
                            connection.disconnect();
                        }
                    }
                }
            }
        } catch (Exception e2) {
            C0970a.m4322a(e2);
            i = 1;
            return i;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return i;
    }

    public JSONObject m4291a() {
        return this.f2887b;
    }
}
