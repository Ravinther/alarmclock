package com.avg.toolkit.p047a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.avg.toolkit.C0647c;
import com.avg.toolkit.ITKSvc;
import com.avg.toolkit.crashReport.CrashReport;
import com.avg.toolkit.license.C1017a;
import com.avg.toolkit.license.C1017a.C0987b;
import com.avg.toolkit.license.C1020c;
import com.avg.toolkit.p049e.C0970a;
import com.avg.toolkit.recurringTasks.C1031b;
import com.avg.toolkit.uid.UUID;
import com.mopub.mobileads.CustomEventBannerAdapter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.StringWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import junit.framework.Assert;
import p000a.p001a.p002a.p003a.p004a.C0000a;
import p000a.p001a.p002a.p003a.p005b.C0003a;

/* renamed from: com.avg.toolkit.a.a */
public class C0905a implements C0647c {
    private static C0903b f2680f;
    protected C0906b f2681a;
    private C1031b f2682b;
    private Context f2683c;
    private C1017a f2684d;
    private UUID f2685e;
    private LinkedList f2686g;

    /* renamed from: com.avg.toolkit.a.a.a */
    public enum C0902a {
        REGULAR_REPORT(0),
        INSTALLATION_SUCCESS(1),
        INSTALLATION_FAILED(2),
        UNINSTALLATION(3),
        LICENSE_CHANGE(4),
        ERROR_REPORTING(5),
        HEARTBEAT(6);
        
        private int f2675h;

        private C0902a(int a) {
            this.f2675h = a;
        }

        public int m4150a() {
            return this.f2675h;
        }
    }

    /* renamed from: com.avg.toolkit.a.a.b */
    public static class C0903b {
        private int f2676a;
        private String f2677b;

        public C0903b(int id, String server) {
            this.f2676a = id;
            this.f2677b = server.trim();
        }

        public int m4151a() {
            return this.f2676a;
        }

        public String m4152b() {
            return this.f2677b;
        }
    }

    /* renamed from: com.avg.toolkit.a.a.c */
    private static class C0904c implements Serializable {
        private static final long serialVersionUID = -303191011091612301L;
        public int f2678a;
        public String f2679b;

        public C0904c(int action, String desc) {
            this.f2678a = action;
            this.f2679b = desc;
        }
    }

    static {
        f2680f = null;
    }

    public static C0903b m4154a() {
        return f2680f;
    }

    public C0905a(Context context, C1017a avgFeatures, Properties properties, UUID uuid) {
        this.f2681a = null;
        this.f2683c = context;
        this.f2684d = avgFeatures;
        this.f2685e = uuid;
        String pidStr = properties.getProperty("productID");
        Assert.assertNotNull("productID not found in Cloud Services properties file", pidStr);
        int pid = Integer.parseInt(pidStr);
        String serverURL = properties.getProperty("cloudHostName");
        Assert.assertNotNull("unkown hostName in Cloud Services properties file", serverURL);
        f2680f = new C0903b(pid, serverURL);
        try {
            this.f2686g = (LinkedList) new ObjectInputStream(this.f2683c.openFileInput("csr_erl.obj")).readObject();
            if (this.f2686g == null) {
                this.f2686g = new LinkedList();
            }
        } catch (FileNotFoundException e) {
            if (this.f2686g == null) {
                this.f2686g = new LinkedList();
            }
        } catch (Exception e2) {
            C0970a.m4322a(e2);
            if (this.f2686g == null) {
                this.f2686g = new LinkedList();
            }
        } catch (Throwable th) {
            if (this.f2686g == null) {
                this.f2686g = new LinkedList();
            }
        }
    }

    public void onStart(boolean firstTime) {
        this.f2682b = new C1031b(this.f2683c, "CSR", 86400000, true, true, 8000, true);
    }

    public void onMessage(Bundle arguments) {
        int action = -1;
        String desc = "";
        if (arguments != null) {
            try {
                action = arguments.getInt(ITKSvc.c_actionSubAction, -1);
                desc = arguments.getString(ITKSvc.c_actionData);
                if (desc == null) {
                    desc = "";
                }
            } catch (Exception e) {
                C0970a.m4322a(e);
            }
        }
        if (action != -1) {
            if (action == C0902a.HEARTBEAT.f2675h) {
                m4158c();
                return;
            }
            if (action == C0902a.INSTALLATION_SUCCESS.f2675h) {
                desc = m4155a(desc);
                if (desc == null) {
                    return;
                }
            }
            if (this.f2686g.size() >= 100) {
                this.f2686g.removeFirst();
            }
            this.f2686g.addLast(new C0904c(action, desc));
            m4159d();
            if (this.f2685e.getUUID() != null) {
                m4157b();
            }
        }
    }

    private void m4157b() {
        Iterator iter = this.f2686g.iterator();
        while (iter.hasNext()) {
            C0904c item = (C0904c) iter.next();
            if (m4153a(this.f2683c, item.f2678a, item.f2679b) != 1) {
                iter.remove();
                m4159d();
            } else {
                return;
            }
        }
    }

    private void m4158c() {
        if (m4153a(this.f2683c, C0902a.HEARTBEAT.f2675h, "") == 0) {
            this.f2682b.m4479a(this.f2683c);
        }
        m4157b();
    }

    public void onAlarm(Bundle arguments) {
        if (this.f2682b.m4480a(this.f2683c, arguments) && this.f2685e.getUUID() != null) {
            m4158c();
        }
    }

    private void m4159d() {
        try {
            FileOutputStream reportsStream = this.f2683c.openFileOutput("csr_erl.obj", 0);
            ObjectOutputStream out = new ObjectOutputStream(reportsStream);
            out.writeObject(this.f2686g);
            out.close();
            reportsStream.close();
        } catch (Exception e) {
            C0970a.m4322a(e);
        }
    }

    public void onDestroy() {
        if (this.f2682b != null) {
            this.f2682b.m4481b(this.f2683c);
        }
        m4159d();
    }

    private int m4153a(Context context, int action, String description) {
        HttpURLConnection connection = null;
        C0907c params = new C0907c();
        String urlStr = "http://" + f2680f.m4152b();
        String hmid = C0003a.m39d(this.f2685e.getUUID().getBytes("UTF-8"));
        String hwid = hmid.substring(32) + "00000000";
        hmid = hmid.substring(0, 32);
        int licType = 0;
        if (this.f2684d.f3116b == C0987b.FREE) {
            licType = 1;
        } else {
            if (this.f2684d.f3116b == C0987b.TRIAL) {
                licType = 2;
            } else {
                if (this.f2684d.f3116b == C0987b.PRO) {
                    licType = 3;
                }
            }
        }
        String devType = URLEncoder.encode(Build.MODEL != null ? Build.MODEL : "", "UTF-8");
        String mnufacturer = "";
        try {
            if (VERSION.SDK_INT > 3) {
                mnufacturer = Build.class.getField("MANUFACTURER").get(null).toString();
            }
        } catch (Exception e) {
        }
        try {
            mnufacturer = URLEncoder.encode(mnufacturer, "UTF-8");
            String usedLicense = new C1020c(context).m4453d();
            if (usedLicense.length() > 4) {
                usedLicense = usedLicense.substring(0, usedLicense.length() - 4);
            }
            String str = "";
            try {
                str = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperatorName();
            } catch (Exception e2) {
                C0970a.m4322a(e2);
            }
            str = URLEncoder.encode(str, "UTF-8");
            description = URLEncoder.encode(description, "UTF-8");
            PackageInfo pkgInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            r32 = new Object[17];
            r32[2] = pkgInfo.versionName;
            r32[3] = Integer.valueOf(pkgInfo.versionCode);
            r32[4] = hmid;
            r32[5] = hwid;
            r32[6] = Integer.valueOf(licType);
            r32[7] = "";
            r32[8] = Integer.valueOf(action);
            r32[9] = description;
            r32[10] = Integer.valueOf(0);
            r32[11] = "Android-" + VERSION.SDK_INT;
            r32[12] = mnufacturer;
            r32[13] = devType;
            r32[14] = usedLicense;
            r32[15] = str;
            r32[16] = Integer.valueOf(this.f2684d.f3120f);
            String report = String.format(Locale.ENGLISH, "v=%d&pid=%d&pv=%s.%d&mid=%s-%s&lic=%s&components=%s&action=%d&desc=%s&usage=%d&os=%s&manufacturer=%s&model=%s&license=%s&carrier=%s&marketing_id=%d", r32);
            String encodedReport = new String(C0000a.m3a(report.getBytes("UTF-8"), false));
            String signature = C0003a.m42e((encodedReport + "d5544fG==*%877hT--==HHSYlWeeY89904444==").getBytes("UTF-8"));
            connection = (HttpURLConnection) new URL(urlStr + "/?" + encodedReport + "&z=" + signature).openConnection();
            connection.setUseCaches(false);
            connection.setRequestProperty("Cache-Control", "no-cache");
            connection.setRequestProperty("Pragma", "no-cache");
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Host", f2680f.m4152b());
            connection.setConnectTimeout(CustomEventBannerAdapter.DEFAULT_BANNER_TIMEOUT_DELAY);
            connection.setReadTimeout(CrashReport.FEATURE_ID);
            connection.connect();
            int response = connection.getResponseCode();
            int contentLength = connection.getContentLength();
            params.m4162a(action);
            params.m4163a(description);
            params.m4165b(report);
            params.m4166c(encodedReport);
            params.m4167d(signature);
            params.m4164b(response);
            if (response != 200) {
                connection.disconnect();
                m4160a(params);
                return 2;
            }
            try {
                InputStream is = connection.getInputStream();
                char[] buffer = new char[1024];
                Writer writer = new StringWriter();
                InputStreamReader inputStreamReader = new InputStreamReader(is, Charset.defaultCharset());
                while (true) {
                    int len = inputStreamReader.read(buffer);
                    if (len == -1) {
                        break;
                    }
                    writer.write(buffer, 0, len);
                }
                is.close();
                connection.disconnect();
                String response2 = writer.toString();
                if (response2.indexOf("AppUsage") != -1) {
                    context.getSharedPreferences("HB", 0).edit().putBoolean("SEND_APP_USAGE", true).commit();
                }
                m4156a(response2, "NextCall=");
            } catch (Exception e22) {
                if (connection != null) {
                    connection.disconnect();
                }
                C0970a.m4322a(e22);
            }
            m4160a(params);
            return 0;
        } catch (Exception e3) {
            if (connection != null) {
                connection.disconnect();
            }
            m4160a(params);
            return 1;
        }
    }

    private String m4156a(String response, String param) {
        int start = response.indexOf(param);
        if (start == -1) {
            return "";
        }
        start += param.length();
        int len = response.length();
        int end = start;
        while (end < len && Character.isDigit(response.charAt(end))) {
            end++;
        }
        if (start == end) {
            return "";
        }
        return response.substring(start, end);
    }

    private String m4155a(String referrer) {
        if (referrer == null || referrer.length() > 600) {
            return "";
        }
        String[] params = referrer.split("&");
        Map paramsMap = new HashMap();
        for (String str : params) {
            String[] tmpVals = str.split("=");
            if (tmpVals.length == 2) {
                paramsMap.put(tmpVals[0], tmpVals[1]);
            }
        }
        StringBuilder formattedReferrer = new StringBuilder();
        String str2 = (String) paramsMap.get("utm_source");
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        formattedReferrer.append(str2);
        str2 = (String) paramsMap.get("utm_medium");
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        formattedReferrer.append("&");
        formattedReferrer.append(str2);
        str2 = (String) paramsMap.get("utm_campaign");
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        formattedReferrer.append("&");
        formattedReferrer.append(str2);
        formattedReferrer.append("&");
        str2 = (String) paramsMap.get("utm_term");
        if (!(str2 == null || str2.equals(""))) {
            formattedReferrer.append(str2);
        }
        formattedReferrer.append("&");
        str2 = (String) paramsMap.get("utm_content");
        if (!(str2 == null || str2.equals(""))) {
            formattedReferrer.append(str2);
        }
        return formattedReferrer.toString();
    }

    public void m4160a(C0907c params) {
        if (this.f2681a != null && params != null) {
            this.f2681a.m4161a(params);
        }
    }

    public int getID() {
        return 8000;
    }

    public void onNewLicense(C1017a avgFeatures) {
        this.f2684d = avgFeatures;
        ITKSvc.Do(this.f2683c, 8000, C0902a.LICENSE_CHANGE.m4150a(), null);
    }

    public void onDailyTask(C1017a avgFeatures) {
        this.f2684d = avgFeatures;
    }

    public void setComm(List commClients) {
    }
}
