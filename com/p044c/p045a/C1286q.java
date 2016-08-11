package com.p044c.p045a;

import android.content.Context;
import android.net.Uri;
import com.avg.toolkit.crashReport.CrashReport;
import com.p044c.p045a.C1254j.C1277a;
import com.p044c.p045a.C1254j.C1278b;
import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.OkUrlFactory;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* renamed from: com.c.a.q */
public class C1286q implements C1254j {
    private final OkUrlFactory f3887a;

    public C1286q(Context context) {
        this(ab.m5391b(context));
    }

    public C1286q(File cacheDir) {
        this(cacheDir, ab.m5378a(cacheDir));
    }

    public C1286q(File cacheDir, long maxSize) {
        this(new OkHttpClient());
        try {
            this.f3887a.client().setCache(new Cache(cacheDir, maxSize));
        } catch (IOException e) {
        }
    }

    public C1286q(OkHttpClient client) {
        this.f3887a = new OkUrlFactory(client);
    }

    protected HttpURLConnection m5491a(Uri uri) {
        HttpURLConnection connection = this.f3887a.open(new URL(uri.toString()));
        connection.setConnectTimeout(CrashReport.FEATURE_ID);
        connection.setReadTimeout(20000);
        return connection;
    }

    public C1277a m5490a(Uri uri, boolean localCacheOnly) {
        HttpURLConnection connection = m5491a(uri);
        connection.setUseCaches(true);
        if (localCacheOnly) {
            connection.setRequestProperty("Cache-Control", "only-if-cached,max-age=2147483647");
        }
        int responseCode = connection.getResponseCode();
        if (responseCode >= 300) {
            connection.disconnect();
            throw new C1278b(responseCode + " " + connection.getResponseMessage());
        }
        String responseSource = connection.getHeaderField("OkHttp-Response-Source");
        if (responseSource == null) {
            responseSource = connection.getHeaderField("X-Android-Response-Source");
        }
        long contentLength = (long) connection.getHeaderFieldInt("Content-Length", -1);
        return new C1277a(connection.getInputStream(), ab.m5390a(responseSource), contentLength);
    }
}
