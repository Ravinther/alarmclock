package com.anglelabs.alarmclock.redesign.utils;

import android.annotation.SuppressLint;
import com.avg.toolkit.crashReport.CrashReport;
import com.avg.toolkit.p049e.C0970a;
import com.mopub.mobileads.CustomEventBannerAdapter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.GZIPOutputStream;

/* renamed from: com.anglelabs.alarmclock.redesign.utils.i */
public class C0811i {
    public static int m3840a(String urlStr, String httpMethod, File fileToSend, boolean useGzip) {
        Exception e;
        Throwable th;
        HttpURLConnection connection = null;
        FileInputStream fis = null;
        try {
            FileInputStream fis2 = new FileInputStream(fileToSend);
            try {
                connection = C0811i.m3841a(urlStr, httpMethod, fileToSend);
                C0811i.m3844a(connection, fis2, useGzip);
                if (connection.getResponseCode() == 200) {
                    C0811i.m3843a(connection);
                    C0811i.m3845a(fis2);
                    fis = fis2;
                    return 0;
                }
                C0811i.m3843a(connection);
                C0811i.m3845a(fis2);
                fis = fis2;
                return 2;
            } catch (Exception e2) {
                e = e2;
                fis = fis2;
                try {
                    C0970a.m4322a(e);
                    C0811i.m3843a(connection);
                    C0811i.m3845a(fis);
                    return 1;
                } catch (Throwable th2) {
                    th = th2;
                    C0811i.m3843a(connection);
                    C0811i.m3845a(fis);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fis = fis2;
                C0811i.m3843a(connection);
                C0811i.m3845a(fis);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            C0970a.m4322a(e);
            C0811i.m3843a(connection);
            C0811i.m3845a(fis);
            return 1;
        }
    }

    private static void m3844a(HttpURLConnection connection, FileInputStream fis, boolean useGzip) {
        OutputStream out = connection.getOutputStream();
        if (useGzip) {
            out = new GZIPOutputStream(connection.getOutputStream());
        }
        byte[] buffer = new byte[1024];
        while (true) {
            int len = fis.read(buffer);
            if (len != -1) {
                out.write(buffer, 0, len);
            } else {
                out.flush();
                out.close();
                return;
            }
        }
    }

    private static HttpURLConnection m3841a(String urlStr, String httpMethod, File fileToSend) {
        HttpURLConnection connection = (HttpURLConnection) new URL(urlStr).openConnection();
        connection.setUseCaches(false);
        connection.setRequestProperty("Cache-Control", "no-cache");
        connection.setRequestProperty("Pragma", "no-cache");
        connection.setRequestMethod(httpMethod);
        connection.setRequestProperty(MraidCommandStorePicture.MIME_TYPE_HEADER, "");
        C0811i.m3842a(fileToSend, connection);
        connection.setDoInput(true);
        connection.setDoOutput(true);
        connection.setConnectTimeout(CustomEventBannerAdapter.DEFAULT_BANNER_TIMEOUT_DELAY);
        connection.setReadTimeout(CrashReport.FEATURE_ID);
        connection.connect();
        return connection;
    }

    @SuppressLint({"NewApi"})
    private static void m3842a(File fileToSend, HttpURLConnection connection) {
        if (C0810h.f2127a) {
            connection.setFixedLengthStreamingMode(fileToSend.length());
        } else {
            connection.setFixedLengthStreamingMode((int) fileToSend.length());
        }
    }

    private static void m3845a(Closeable... closeable) {
        if (closeable != null) {
            for (Closeable currItem : closeable) {
                try {
                    currItem.close();
                } catch (Exception e) {
                    C0970a.m4322a(e);
                }
            }
        }
    }

    private static void m3843a(HttpURLConnection connection) {
        if (connection != null) {
            connection.disconnect();
        }
    }
}
