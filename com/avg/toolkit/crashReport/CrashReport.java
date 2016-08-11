package com.avg.toolkit.crashReport;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import com.avg.toolkit.C0647c;
import com.avg.toolkit.ITKSvc;
import com.avg.toolkit.license.C1017a;
import com.avg.toolkit.p034b.C0649d;
import com.avg.toolkit.p034b.C0950a.C0949c;
import com.avg.toolkit.p034b.C0955e;
import com.avg.toolkit.p049e.C0970a;
import com.mopub.mobileads.CustomEventBannerAdapter;
import com.mopub.mobileads.factories.HttpClientFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p005b.C0003a;

public class CrashReport extends C0649d implements C0647c {
    public static final int CRASH_REPORT = 15001;
    public static final int FEATURE_ID = 15000;
    public static final int REQUEST_FEATURE_NUM = 8;
    private static final Object f2913b;
    private static boolean f2914c = false;
    public static final String c_exceptionsFile = "eeexlfnn";
    public static final String c_exceptionsFileOld = "eeexlfn";
    public static final String c_exceptionsLogFile = "eeexlfnnl";
    public static final String c_exceptionsLogFileOld = "eeexlfnl";
    private static Context f2915d;
    private static List f2916e;
    private static List f2917f;
    private static List f2918g;
    private String[] f2919h;

    /* renamed from: com.avg.toolkit.crashReport.CrashReport.a */
    public interface C0963a {
        void m4307a(Context context);
    }

    /* renamed from: com.avg.toolkit.crashReport.CrashReport.b */
    public interface C0964b {
        C0965c m4308a(Context context, String str);
    }

    /* renamed from: com.avg.toolkit.crashReport.CrashReport.c */
    public static class C0965c {
        public String f2911a;
        public JSONObject f2912b;
    }

    /* renamed from: com.avg.toolkit.crashReport.CrashReport.d */
    public interface C0966d {
        void m4309a(Context context, Throwable th, String str);
    }

    static {
        f2913b = new Object();
        f2914c = false;
        f2916e = Collections.synchronizedList(new LinkedList());
        f2917f = Collections.synchronizedList(new LinkedList());
        f2918g = Collections.synchronizedList(new LinkedList());
    }

    public static void addCleanupListener(C0963a listener) {
        f2916e.add(listener);
    }

    public static boolean removeCleanupListener(C0963a listener) {
        return f2916e.remove(listener);
    }

    public static void addPreSaveCrashListener(C0966d listener) {
        f2917f.add(listener);
    }

    public static boolean removePreSaveCrashListener(C0966d listener) {
        return f2917f.remove(listener);
    }

    public static void addExtraDataProvider(C0964b listener) {
        f2918g.add(listener);
    }

    public static boolean removeExtraDataProvider(C0964b listener) {
        return f2918g.remove(listener);
    }

    public static void init(Context context) {
        if (!f2914c) {
            f2915d = context.getApplicationContext();
            DefaultExceptionHandler.setAsDefault(f2915d);
            f2914c = true;
        }
    }

    public static String[] getKeyAndTraceFromThrowable(Context context, Throwable e, String extraForHash) {
        int length;
        StringWriter sw = new StringWriter();
        e.printStackTrace(new PrintWriter(sw));
        String[] ret = new String[2];
        ret[1] = new String(sw.toString());
        String traceStrModified = ret[1];
        Throwable cause = e;
        while (cause != null) {
            if (!(cause.getMessage() == null || cause.getMessage().equals(""))) {
                traceStrModified = traceStrModified.replaceFirst(Pattern.quote(cause.getMessage()), "");
            }
            cause = cause.getCause();
        }
        BufferedReader reader = new BufferedReader(new StringReader(traceStrModified), HttpClientFactory.SOCKET_SIZE);
        int length2 = traceStrModified.length();
        if (extraForHash != null) {
            length = extraForHash.length();
        } else {
            length = 0;
        }
        StringBuilder traceBuilder = new StringBuilder(length + length2);
        if (extraForHash != null && extraForHash.length() > 0) {
            traceBuilder.append(extraForHash);
        }
        traceBuilder.append("\nex\n");
        while (true) {
            try {
                String tmpStr = reader.readLine();
                if (tmpStr == null) {
                    break;
                } else if (tmpStr.startsWith("\tat ") && !tmpStr.startsWith("\tat " + context.getPackageName())) {
                    traceBuilder.append('\n').append(tmpStr.replaceFirst("\\.java:\\d+\\)", ".java)"));
                } else if (traceBuilder.length() == 0) {
                    traceBuilder.append(tmpStr);
                } else {
                    traceBuilder.append('\n').append(tmpStr);
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        ret[0] = C0003a.m42e(traceBuilder.toString().getBytes());
        return ret;
    }

    private static JSONObject m4311a(Context context, String filename) {
        FileInputStream fis;
        Exception e;
        FileInputStream fileInputStream;
        Throwable th;
        synchronized (f2913b) {
            File exceptionsFile = new File(context.getFilesDir(), filename);
            InputStreamReader reader = null;
            Writer writer = null;
            if (exceptionsFile.exists()) {
                char[] buffer;
                Writer writer2;
                try {
                    fis = new FileInputStream(exceptionsFile);
                    try {
                        buffer = new char[1024];
                        writer2 = new StringWriter();
                    } catch (Exception e2) {
                        e = e2;
                        fileInputStream = fis;
                        try {
                            C0970a.m4322a(e);
                            if (reader != null) {
                                try {
                                    reader.close();
                                } catch (Exception e3) {
                                    C0970a.m4322a(e3);
                                }
                            }
                            if (writer != null) {
                                try {
                                    writer.close();
                                } catch (Exception e32) {
                                    C0970a.m4322a(e32);
                                }
                            }
                            return null;
                        } catch (Throwable th2) {
                            th = th2;
                            if (reader != null) {
                                try {
                                    reader.close();
                                } catch (Exception e322) {
                                    C0970a.m4322a(e322);
                                }
                            }
                            if (writer != null) {
                                try {
                                    writer.close();
                                } catch (Exception e3222) {
                                    C0970a.m4322a(e3222);
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        fileInputStream = fis;
                        if (reader != null) {
                            reader.close();
                        }
                        if (writer != null) {
                            writer.close();
                        }
                        throw th;
                    }
                } catch (Exception e4) {
                    e3222 = e4;
                    C0970a.m4322a(e3222);
                    if (reader != null) {
                        reader.close();
                    }
                    if (writer != null) {
                        writer.close();
                    }
                    return null;
                }
                try {
                    InputStreamReader reader2 = new InputStreamReader(fis, Charset.forName("UTF-8"));
                    while (true) {
                        try {
                            int len = reader2.read(buffer);
                            if (len == -1) {
                                break;
                            }
                            writer2.write(buffer, 0, len);
                        } catch (Exception e5) {
                            e3222 = e5;
                            writer = writer2;
                            reader = reader2;
                            fileInputStream = fis;
                        } catch (Throwable th4) {
                            th = th4;
                            writer = writer2;
                            reader = reader2;
                            fileInputStream = fis;
                        }
                    }
                    writer2.flush();
                    JSONObject jSONObject = new JSONObject(writer2.toString());
                    if (reader2 != null) {
                        try {
                            reader2.close();
                        } catch (Exception e32222) {
                            C0970a.m4322a(e32222);
                        }
                    }
                    if (writer2 != null) {
                        try {
                            writer2.close();
                        } catch (Exception e322222) {
                            C0970a.m4322a(e322222);
                        }
                    }
                    writer = writer2;
                    reader = reader2;
                    fileInputStream = fis;
                    return jSONObject;
                } catch (Exception e6) {
                    e322222 = e6;
                    writer = writer2;
                    fileInputStream = fis;
                    C0970a.m4322a(e322222);
                    if (reader != null) {
                        reader.close();
                    }
                    if (writer != null) {
                        writer.close();
                    }
                    return null;
                } catch (Throwable th5) {
                    th = th5;
                    writer = writer2;
                    fileInputStream = fis;
                    if (reader != null) {
                        reader.close();
                    }
                    if (writer != null) {
                        writer.close();
                    }
                    throw th;
                }
            }
            return null;
        }
    }

    private static void m4313a(Context context, String filename, JSONObject jobj) {
        FileOutputStream fileOutputStream;
        Exception e;
        Throwable th;
        synchronized (f2913b) {
            OutputStreamWriter writer = null;
            try {
                FileOutputStream fos = new FileOutputStream(new File(context.getFilesDir(), filename));
                try {
                    OutputStreamWriter writer2 = new OutputStreamWriter(fos, Charset.forName("UTF-8"));
                    try {
                        writer2.write(jobj.toString());
                        writer2.flush();
                        if (writer2 != null) {
                            try {
                                writer2.close();
                                writer = writer2;
                                fileOutputStream = fos;
                            } catch (Exception e2) {
                                C0970a.m4322a(e2);
                                writer = writer2;
                                fileOutputStream = fos;
                            }
                        } else {
                            fileOutputStream = fos;
                        }
                    } catch (Exception e3) {
                        e2 = e3;
                        writer = writer2;
                        fileOutputStream = fos;
                        try {
                            C0970a.m4322a(e2);
                            if (writer != null) {
                                try {
                                    writer.close();
                                } catch (Exception e22) {
                                    C0970a.m4322a(e22);
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (writer != null) {
                                try {
                                    writer.close();
                                } catch (Exception e222) {
                                    C0970a.m4322a(e222);
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        writer = writer2;
                        fileOutputStream = fos;
                        if (writer != null) {
                            writer.close();
                        }
                        throw th;
                    }
                } catch (Exception e4) {
                    e222 = e4;
                    fileOutputStream = fos;
                    C0970a.m4322a(e222);
                    if (writer != null) {
                        writer.close();
                    }
                } catch (Throwable th4) {
                    th = th4;
                    fileOutputStream = fos;
                    if (writer != null) {
                        writer.close();
                    }
                    throw th;
                }
            } catch (Exception e5) {
                e222 = e5;
                C0970a.m4322a(e222);
                if (writer != null) {
                    writer.close();
                }
            }
        }
    }

    private static boolean m4315a(Context context, Throwable exception, String extraForHash, JSONObject newExceptionObj) {
        boolean z;
        synchronized (f2913b) {
            JSONObject exceptions = m4311a(context, c_exceptionsFile);
            if (exceptions == null) {
                exceptions = new JSONObject();
            }
            JSONObject exceptionsLog = m4311a(context, c_exceptionsLogFile);
            if (exceptionsLog == null) {
                exceptionsLog = new JSONObject();
            }
            String[] keyAndTrace = getKeyAndTraceFromThrowable(context, exception, extraForHash);
            if (!exceptionsLog.has(keyAndTrace[0])) {
                boolean save = false;
                if (newExceptionObj == null) {
                    try {
                        newExceptionObj = new JSONObject();
                    } catch (Exception e) {
                        C0970a.m4322a(e);
                    }
                }
                newExceptionObj.put("exception", keyAndTrace[1]);
                newExceptionObj.put("sha", keyAndTrace[0]);
                newExceptionObj.put("ts", new Date().getTime());
                exceptions.put(keyAndTrace[0], newExceptionObj);
                exceptionsLog.put(keyAndTrace[0], 1);
                save = true;
                if (save) {
                    for (C0966d listener : f2917f) {
                        listener.m4309a(context, exception, keyAndTrace[0]);
                    }
                    m4313a(context, c_exceptionsFile, exceptions);
                    m4313a(context, c_exceptionsLogFile, exceptionsLog);
                    z = true;
                }
            }
            z = false;
        }
        return z;
    }

    public static boolean reportNativeCrash(Throwable exception, String additionalFileName, int sigNum, int sigNumGen, String sigName, int sigCode, String relInsAddr, String libname, String accessAddr) {
        boolean z = false;
        if (f2915d != null) {
            StringBuilder extraForHash = new StringBuilder();
            extraForHash.append(sigNumGen).append('&').append(sigCode).append('&').append(relInsAddr).append('&').append(libname);
            try {
                JSONObject newExceptionObj = new JSONObject();
                newExceptionObj.put("sigNum", sigNum);
                newExceptionObj.put("sigGen", sigNumGen);
                if (!(sigName == null || sigName.equals(""))) {
                    newExceptionObj.put("sigName", sigName);
                }
                newExceptionObj.put("sigCode", sigCode);
                if (!(relInsAddr == null || relInsAddr.equals(""))) {
                    newExceptionObj.put("relInsAddr", relInsAddr);
                }
                if (!(libname == null || libname.equals(""))) {
                    newExceptionObj.put("libName", libname);
                }
                if (!(accessAddr == null || accessAddr.equals(""))) {
                    newExceptionObj.put("accessAddr", accessAddr);
                }
                if (!(additionalFileName == null || additionalFileName.equals(""))) {
                    newExceptionObj.put("file", additionalFileName);
                }
                z = m4315a(f2915d, exception, extraForHash.toString(), newExceptionObj);
            } catch (Exception e) {
                C0970a.m4322a(e);
            }
        }
        return z;
    }

    public static boolean reportCrash(Context context, Throwable exception) {
        return m4315a(context, exception, null, null);
    }

    public void setComm(List commClients) {
        commClients.add(CrashReport.class);
    }

    public boolean load(Context context) {
        boolean z = false;
        m4316b(context);
        synchronized (f2913b) {
            JSONObject exceptions = m4311a(context, c_exceptionsFile);
            JSONObject exceptionsLog = m4311a(context, c_exceptionsLogFile);
            if (exceptions == null || exceptions.length() <= 0 || exceptionsLog == null) {
                m4314a(context, false);
            } else {
                long currTime = new Date().getTime();
                JSONArray names = exceptions.names();
                int len = names.length();
                for (int i = 0; i < len; i++) {
                    try {
                        if (Math.abs(currTime - exceptions.getJSONObject(names.getString(i)).getLong("ts")) > 172800000) {
                            exceptions.remove(names.getString(i));
                            exceptionsLog.remove(names.getString(i));
                        }
                    } catch (JSONException e) {
                    }
                }
                if (exceptions.length() > 0) {
                    if (exceptions.length() < len) {
                        m4313a(context, c_exceptionsFile, exceptions);
                        m4313a(context, c_exceptionsLogFile, exceptionsLog);
                    }
                    z = true;
                } else {
                    m4313a(context, c_exceptionsLogFile, exceptionsLog);
                    m4314a(context, false);
                }
            }
        }
        return z;
    }

    public C0949c getPriority() {
        return C0949c.REGULAR;
    }

    public int getMessageId() {
        return CRASH_REPORT;
    }

    public String getXmlRpcMethod() {
        return null;
    }

    public boolean handleMessage(Context context, Message msg) {
        JSONObject exceptions = m4311a(context, c_exceptionsFile);
        if (exceptions == null || exceptions.length() <= 0) {
            return false;
        }
        return true;
    }

    public boolean prepare(Context context) {
        return false;
    }

    private void m4312a(Context context) {
        if (this.f2919h != null) {
            synchronized (f2913b) {
                JSONObject savedExceptions = m4311a(context, c_exceptionsFile);
                for (String str : this.f2919h) {
                    savedExceptions.remove(str);
                }
                if (savedExceptions.length() > 0) {
                    m4313a(context, c_exceptionsFile, savedExceptions);
                    ITKSvc.Do(context, 4000, CRASH_REPORT, null);
                } else {
                    m4314a(context, false);
                }
            }
            this.f2919h = null;
        }
    }

    public boolean callFinished(Context context, Object result) {
        if (!(result instanceof JSONObject)) {
            return false;
        }
        JSONObject responseJson = (JSONObject) result;
        if (!"ERROR".equals(responseJson.optString("status"))) {
            JSONObject uploadList = responseJson.optJSONObject("UploadURLs");
            if (uploadList != null) {
                try {
                    String httpMethod = responseJson.getString("HTTPMethod");
                    JSONObject exceptions = m4311a(context, c_exceptionsFile);
                    JSONArray names = uploadList.names();
                    if (!(exceptions == null || names == null)) {
                        int len = names.length();
                        for (int i = 0; i < len; i++) {
                            String fileName = exceptions.getJSONObject(names.getString(i)).optString("file");
                            if (!(fileName == null || fileName.equals(""))) {
                                m4310a(uploadList.getString(names.getString(i)), httpMethod, fileName);
                            }
                        }
                    }
                } catch (Exception e) {
                    C0970a.m4322a(e);
                }
            }
            m4312a(context);
            return true;
        } else if (responseJson.optBoolean("retry")) {
            return false;
        } else {
            return true;
        }
    }

    public void callFinishedNoChange(Context context) {
        m4312a(context);
    }

    public int getJsonConfKey() {
        return REQUEST_FEATURE_NUM;
    }

    public boolean prepareJson(Context context, JSONArray setParameters) {
        JSONObject tempReqParams = new JSONObject();
        boolean res = C0955e.m4289a(context, tempReqParams, false, true, true, true, true, false, true);
        if (!res) {
            return res;
        }
        try {
            JSONObject tempReqFeatureParams = new JSONObject();
            tempReqFeatureParams.put("pver", 1);
            tempReqFeatureParams.put("pckg", context.getPackageName());
            tempReqFeatureParams.put("devTime", new Date().getTime());
            String arch = System.getProperty("os.arch");
            if (arch != null && arch.length() > 0) {
                tempReqFeatureParams.put("cpu_arch", arch);
            }
            tempReqFeatureParams.put("extra", Build.FINGERPRINT + " " + Build.DISPLAY);
            JSONArray exceptions = new JSONArray();
            JSONObject savedExceptions = m4311a(context, c_exceptionsFile);
            if (savedExceptions == null) {
                return false;
            }
            JSONArray names = savedExceptions.names();
            int len = names.length();
            if (len > 7) {
                len = 7;
            }
            String[] pendingCrashes = new String[len];
            for (int i = 0; i < len; i++) {
                String name = names.getString(i);
                JSONObject tempObj = savedExceptions.getJSONObject(name);
                String additionalFile = tempObj.optString("file");
                if (additionalFile == null || additionalFile.equals("")) {
                    tempObj.put("hasFile", false);
                } else {
                    tempObj.remove("file");
                    tempObj.put("hasFile", true);
                }
                for (C0964b adder : f2918g) {
                    C0965c pair = adder.m4308a(context, tempObj.optString("sha"));
                    if (!(pair == null || pair.f2911a == null || pair.f2912b == null)) {
                        tempObj.put(pair.f2911a, pair.f2912b);
                    }
                }
                exceptions.put(tempObj);
                pendingCrashes[i] = name;
            }
            tempReqFeatureParams.put("exceptions", exceptions);
            this.jsonRequestParameters = tempReqParams;
            this.jsonRequestFeatureParameters = tempReqFeatureParams;
            this.f2919h = pendingCrashes;
            return res;
        } catch (Exception e) {
            C0970a.m4322a(e);
            return false;
        }
    }

    private void m4316b(Context context) {
        PackageInfo pi = null;
        try {
            pi = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (NameNotFoundException e) {
        }
        if (pi == null) {
            C0970a.m4325b("could not get self package info");
            return;
        }
        int currVersionCode = pi.versionCode;
        SharedPreferences prefs = context.getSharedPreferences("ajvcrshrp", 0);
        if (currVersionCode > prefs.getInt("vc", 0)) {
            context.getSharedPreferences(c_exceptionsFileOld, 0).edit().clear().commit();
            context.getSharedPreferences(c_exceptionsLogFileOld, 0).edit().clear().commit();
            m4314a(context, true);
            prefs.edit().putInt("vc", currVersionCode).commit();
        }
    }

    public int getID() {
        return FEATURE_ID;
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

    private int m4310a(String urlStr, String httpMethod, String fileToSend) {
        Exception e;
        Throwable th;
        HttpURLConnection connection = null;
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fis = new FileInputStream(new File(fileToSend));
            try {
                int len;
                connection = (HttpURLConnection) new URL(urlStr).openConnection();
                connection.setUseCaches(false);
                connection.setRequestProperty("Cache-Control", "no-cache");
                connection.setRequestProperty("Pragma", "no-cache");
                connection.setRequestMethod(httpMethod);
                connection.setRequestProperty(MraidCommandStorePicture.MIME_TYPE_HEADER, "");
                connection.setDoInput(true);
                connection.setDoOutput(true);
                connection.setConnectTimeout(CustomEventBannerAdapter.DEFAULT_BANNER_TIMEOUT_DELAY);
                connection.setReadTimeout(FEATURE_ID);
                connection.connect();
                GZIPOutputStream out = new GZIPOutputStream(connection.getOutputStream());
                byte[] buffer = new byte[1024];
                while (true) {
                    len = fis.read(buffer);
                    if (len == -1) {
                        break;
                    }
                    out.write(buffer, 0, len);
                }
                out.flush();
                out.close();
                int response = connection.getResponseCode();
                int contentLength = connection.getContentLength();
                if (response != 200) {
                    connection.disconnect();
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (Exception e2) {
                            C0970a.m4322a(e2);
                        }
                    }
                    fileInputStream = fis;
                    return 2;
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (Exception e22) {
                        C0970a.m4322a(e22);
                    }
                }
                try {
                    InputStream is = connection.getInputStream();
                    char[] buffer2 = new char[1024];
                    Writer writer = new StringWriter();
                    InputStreamReader reader = new InputStreamReader(is, Charset.defaultCharset());
                    while (true) {
                        len = reader.read(buffer2);
                        if (len == -1) {
                            break;
                        }
                        writer.write(buffer2, 0, len);
                    }
                    is.close();
                    connection.disconnect();
                    connection = null;
                    writer.toString();
                } catch (Exception e222) {
                    if (connection != null) {
                        connection.disconnect();
                    }
                    C0970a.m4322a(e222);
                }
                fileInputStream = fis;
                return 0;
            } catch (Exception e3) {
                e222 = e3;
                fileInputStream = fis;
                if (connection != null) {
                    try {
                        connection.disconnect();
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e2222) {
                                C0970a.m4322a(e2222);
                            }
                        }
                        throw th;
                    }
                }
                C0970a.m4322a(e2222);
                if (fileInputStream != null) {
                    return 1;
                }
                try {
                    fileInputStream.close();
                    return 1;
                } catch (Exception e22222) {
                    C0970a.m4322a(e22222);
                    return 1;
                }
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = fis;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        } catch (Exception e4) {
            e22222 = e4;
            if (connection != null) {
                connection.disconnect();
            }
            C0970a.m4322a(e22222);
            if (fileInputStream != null) {
                return 1;
            }
            fileInputStream.close();
            return 1;
        }
    }

    private static void m4314a(Context context, boolean cleanLog) {
        Context applicationContext = context.getApplicationContext();
        try {
            for (C0963a listener : f2916e) {
                listener.m4307a(applicationContext);
            }
        } catch (Exception e) {
            C0970a.m4322a(e);
        }
        synchronized (f2913b) {
            m4313a(applicationContext, c_exceptionsFile, new JSONObject());
            if (cleanLog) {
                m4313a(applicationContext, c_exceptionsLogFile, new JSONObject());
            }
        }
    }

    public void releaseData() {
        super.releaseData();
        this.f2919h = null;
    }
}
