package com.google.analytics.tracking.android;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.mopub.mobileads.factories.HttpClientFactory;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import org.apache.http.Header;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;

class SimpleNetworkDispatcher implements Dispatcher {
    private final String f4227a;
    private final HttpClientFactory f4228b;
    private final Context f4229c;

    SimpleNetworkDispatcher(AnalyticsStore store, HttpClientFactory httpClientFactory, Context ctx) {
        this(httpClientFactory, ctx);
    }

    SimpleNetworkDispatcher(HttpClientFactory httpClientFactory, Context ctx) {
        this.f4229c = ctx.getApplicationContext();
        this.f4227a = m5798a("GoogleAnalytics", "2.0", VERSION.RELEASE, Utils.m5843a(Locale.getDefault()), Build.MODEL, Build.ID);
        this.f4228b = httpClientFactory;
    }

    public boolean m5799a() {
        NetworkInfo network = ((ConnectivityManager) this.f4229c.getSystemService("connectivity")).getActiveNetworkInfo();
        if (network != null && network.isConnected()) {
            return true;
        }
        Log.m5757g("...no network connectivity");
        return false;
    }

    public int m5797a(List hits) {
        int hitsDispatched = 0;
        int maxHits = Math.min(hits.size(), 40);
        for (int i = 0; i < maxHits; i++) {
            HttpClient client = this.f4228b.m5749a();
            Hit hit = (Hit) hits.get(i);
            URL url = m5794a(hit);
            if (url == null) {
                if (Log.m5751a()) {
                    Log.m5758h("No destination: discarding hit: " + hit.m5740a());
                } else {
                    Log.m5758h("No destination: discarding hit.");
                }
                hitsDispatched++;
            } else {
                HttpHost targetHost = new HttpHost(url.getHost(), url.getPort(), url.getProtocol());
                String path = url.getPath();
                String params = TextUtils.isEmpty(hit.m5740a()) ? "" : HitBuilder.m5746a(hit, System.currentTimeMillis());
                HttpEntityEnclosingRequest request = m5795a(params, path);
                if (request == null) {
                    hitsDispatched++;
                } else {
                    request.addHeader("Host", targetHost.toHostString());
                    m5796a(Log.m5751a(), request);
                    if (params.length() > HttpClientFactory.SOCKET_SIZE) {
                        Log.m5758h("Hit too long (> 8192 bytes)--not sent");
                    } else {
                        try {
                            HttpResponse response = client.execute(targetHost, request);
                            if (response.getStatusLine().getStatusCode() != 200) {
                                Log.m5758h("Bad response: " + response.getStatusLine().getStatusCode());
                                break;
                            }
                        } catch (ClientProtocolException e) {
                            Log.m5758h("ClientProtocolException sending hit; discarding hit...");
                        } catch (IOException e2) {
                            Log.m5758h("Exception sending hit: " + e2.getClass().getSimpleName());
                            Log.m5758h(e2.getMessage());
                        }
                    }
                    hitsDispatched++;
                }
            }
        }
        return hitsDispatched;
    }

    private HttpEntityEnclosingRequest m5795a(String params, String path) {
        if (TextUtils.isEmpty(params)) {
            Log.m5758h("Empty hit, discarding.");
            return null;
        }
        HttpEntityEnclosingRequest request;
        String full = path + "?" + params;
        if (full.length() < 2036) {
            request = new BasicHttpEntityEnclosingRequest("GET", full);
        } else {
            request = new BasicHttpEntityEnclosingRequest("POST", path);
            try {
                request.setEntity(new StringEntity(params));
            } catch (UnsupportedEncodingException e) {
                Log.m5758h("Encoding error, discarding hit");
                return null;
            }
        }
        request.addHeader("User-Agent", this.f4227a);
        return request;
    }

    private void m5796a(boolean debug, HttpEntityEnclosingRequest request) {
        if (debug) {
            StringBuffer httpHeaders = new StringBuffer();
            for (Header header : request.getAllHeaders()) {
                httpHeaders.append(header.toString()).append("\n");
            }
            httpHeaders.append(request.getRequestLine().toString()).append("\n");
            if (request.getEntity() != null) {
                try {
                    InputStream is = request.getEntity().getContent();
                    if (is != null) {
                        int avail = is.available();
                        if (avail > 0) {
                            byte[] b = new byte[avail];
                            is.read(b);
                            httpHeaders.append("POST:\n");
                            httpHeaders.append(new String(b)).append("\n");
                        }
                    }
                } catch (IOException e) {
                    Log.m5758h("Error Writing hit to log...");
                }
            }
            Log.m5754d(httpHeaders.toString());
        }
    }

    String m5798a(String product, String version, String release, String language, String model, String id) {
        return String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[]{product, version, release, language, model, id});
    }

    private URL m5794a(Hit hit) {
        if (TextUtils.isEmpty(hit.m5745d())) {
            return null;
        }
        try {
            return new URL(hit.m5745d());
        } catch (MalformedURLException e) {
            try {
                return new URL("http://www.google-analytics.com/collect");
            } catch (MalformedURLException e2) {
                return null;
            }
        }
    }
}
