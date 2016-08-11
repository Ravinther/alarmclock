package com.p044c.p045a;

import android.content.Context;
import android.net.Uri;
import android.net.http.HttpResponseCache;
import android.os.Build.VERSION;
import com.avg.toolkit.crashReport.CrashReport;
import com.p044c.p045a.C1254j.C1277a;
import com.p044c.p045a.C1254j.C1278b;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* renamed from: com.c.a.aa */
public class aa implements C1254j {
    static volatile Object f3810a;
    private static final Object f3811b;
    private final Context f3812c;

    /* renamed from: com.c.a.aa.a */
    private static class C1253a {
        static Object m5368a(Context context) {
            File cacheDir = ab.m5391b(context);
            HttpResponseCache cache = HttpResponseCache.getInstalled();
            if (cache == null) {
                return HttpResponseCache.install(cacheDir, ab.m5378a(cacheDir));
            }
            return cache;
        }
    }

    static {
        f3811b = new Object();
    }

    public aa(Context context) {
        this.f3812c = context.getApplicationContext();
    }

    protected HttpURLConnection m5372a(Uri path) {
        HttpURLConnection connection = (HttpURLConnection) new URL(path.toString()).openConnection();
        connection.setConnectTimeout(CrashReport.FEATURE_ID);
        connection.setReadTimeout(20000);
        return connection;
    }

    public C1277a m5371a(Uri uri, boolean localCacheOnly) {
        if (VERSION.SDK_INT >= 14) {
            aa.m5370a(this.f3812c);
        }
        HttpURLConnection connection = m5372a(uri);
        connection.setUseCaches(true);
        if (localCacheOnly) {
            connection.setRequestProperty("Cache-Control", "only-if-cached,max-age=2147483647");
        }
        int responseCode = connection.getResponseCode();
        if (responseCode >= 300) {
            connection.disconnect();
            throw new C1278b(responseCode + " " + connection.getResponseMessage());
        }
        long contentLength = (long) connection.getHeaderFieldInt("Content-Length", -1);
        return new C1277a(connection.getInputStream(), ab.m5390a(connection.getHeaderField("X-Android-Response-Source")), contentLength);
    }

    private static void m5370a(Context context) {
        if (f3810a == null) {
            try {
                synchronized (f3811b) {
                    if (f3810a == null) {
                        f3810a = C1253a.m5368a(context);
                    }
                }
            } catch (IOException e) {
            }
        }
    }
}
