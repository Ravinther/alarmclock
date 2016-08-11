package com.google.android.gms.analytics;

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
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;

class ah implements C1353n {
    private final Context mContext;
    private GoogleAnalytics sX;
    private final String vI;
    private final HttpClient vJ;
    private URL vK;

    ah(HttpClient httpClient, Context context) {
        this(httpClient, GoogleAnalytics.getInstance(context), context);
    }

    ah(HttpClient httpClient, GoogleAnalytics googleAnalytics, Context context) {
        this.mContext = context.getApplicationContext();
        this.vI = m5946a("GoogleAnalytics", "3.0", VERSION.RELEASE, ak.m5964a(Locale.getDefault()), Build.MODEL, Build.ID);
        this.vJ = httpClient;
        this.sX = googleAnalytics;
    }

    private void m5941a(ab abVar, URL url, boolean z) {
        if (!TextUtils.isEmpty(abVar.cU()) && db()) {
            URL url2;
            if (url == null) {
                try {
                    url2 = this.vK != null ? this.vK : new URL("https://ssl.google-analytics.com/collect");
                } catch (MalformedURLException e) {
                    return;
                }
            }
            url2 = url;
            HttpHost httpHost = new HttpHost(url2.getHost(), url2.getPort(), url2.getProtocol());
            try {
                HttpEntityEnclosingRequest c = m5943c(abVar.cU(), url2.getPath());
                if (c != null) {
                    c.addHeader("Host", httpHost.toHostString());
                    if (aa.cT()) {
                        m5942a(c);
                    }
                    if (z) {
                        C1372q.m5992p(this.mContext);
                    }
                    HttpResponse execute = this.vJ.execute(httpHost, c);
                    int statusCode = execute.getStatusLine().getStatusCode();
                    HttpEntity entity = execute.getEntity();
                    if (entity != null) {
                        entity.consumeContent();
                    }
                    if (statusCode != 200) {
                        aa.m5916z("Bad response: " + execute.getStatusLine().getStatusCode());
                    }
                }
            } catch (ClientProtocolException e2) {
                aa.m5916z("ClientProtocolException sending monitoring hit.");
            } catch (IOException e3) {
                aa.m5916z("Exception sending monitoring hit: " + e3.getClass().getSimpleName());
                aa.m5916z(e3.getMessage());
            }
        }
    }

    private void m5942a(HttpEntityEnclosingRequest httpEntityEnclosingRequest) {
        StringBuffer stringBuffer = new StringBuffer();
        for (Object obj : httpEntityEnclosingRequest.getAllHeaders()) {
            stringBuffer.append(obj.toString()).append("\n");
        }
        stringBuffer.append(httpEntityEnclosingRequest.getRequestLine().toString()).append("\n");
        if (httpEntityEnclosingRequest.getEntity() != null) {
            try {
                InputStream content = httpEntityEnclosingRequest.getEntity().getContent();
                if (content != null) {
                    int available = content.available();
                    if (available > 0) {
                        byte[] bArr = new byte[available];
                        content.read(bArr);
                        stringBuffer.append("POST:\n");
                        stringBuffer.append(new String(bArr)).append("\n");
                    }
                }
            } catch (IOException e) {
                aa.m5915y("Error Writing hit to log...");
            }
        }
        aa.m5915y(stringBuffer.toString());
    }

    private HttpEntityEnclosingRequest m5943c(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            aa.m5916z("Empty hit, discarding.");
            return null;
        }
        HttpEntityEnclosingRequest basicHttpEntityEnclosingRequest;
        String str3 = str2 + "?" + str;
        if (str3.length() < 2036) {
            basicHttpEntityEnclosingRequest = new BasicHttpEntityEnclosingRequest("GET", str3);
        } else {
            basicHttpEntityEnclosingRequest = new BasicHttpEntityEnclosingRequest("POST", str2);
            try {
                basicHttpEntityEnclosingRequest.setEntity(new StringEntity(str));
            } catch (UnsupportedEncodingException e) {
                aa.m5916z("Encoding error, discarding hit");
                return null;
            }
        }
        basicHttpEntityEnclosingRequest.addHeader("User-Agent", this.vI);
        return basicHttpEntityEnclosingRequest;
    }

    public void m5944F(String str) {
        try {
            this.vK = new URL(str);
        } catch (MalformedURLException e) {
            this.vK = null;
        }
    }

    public int m5945a(List list, ab abVar, boolean z) {
        int i = 0;
        int min = Math.min(list.size(), 40);
        abVar.m5917c("_hr", list.size());
        int i2 = 0;
        URL url = null;
        boolean z2 = true;
        int i3 = 0;
        while (i3 < min) {
            int i4;
            URL url2;
            C1395x c1395x = (C1395x) list.get(i3);
            URL a = m5947a(c1395x);
            if (a == null) {
                if (aa.cT()) {
                    aa.m5916z("No destination: discarding hit: " + c1395x.cO());
                } else {
                    aa.m5916z("No destination: discarding hit.");
                }
                i2++;
                URL url3 = url;
                i4 = i + 1;
                url2 = url3;
            } else {
                HttpHost httpHost = new HttpHost(a.getHost(), a.getPort(), a.getProtocol());
                String path = a.getPath();
                String a2 = TextUtils.isEmpty(c1395x.cO()) ? "" : C1396y.m6043a(c1395x, System.currentTimeMillis());
                HttpEntityEnclosingRequest c = m5943c(a2, path);
                if (c == null) {
                    i2++;
                    i4 = i + 1;
                    url2 = a;
                } else {
                    c.addHeader("Host", httpHost.toHostString());
                    if (aa.cT()) {
                        m5942a(c);
                    }
                    if (a2.length() > HttpClientFactory.SOCKET_SIZE) {
                        aa.m5916z("Hit too long (> 8192 bytes)--not sent");
                        i2++;
                    } else if (this.sX.isDryRunEnabled()) {
                        aa.m5914x("Dry run enabled. Hit not actually sent.");
                    } else {
                        if (z2) {
                            try {
                                C1372q.m5992p(this.mContext);
                                z2 = false;
                            } catch (ClientProtocolException e) {
                                aa.m5916z("ClientProtocolException sending hit; discarding hit...");
                                abVar.m5917c("_hd", i2);
                            } catch (IOException e2) {
                                aa.m5916z("Exception sending hit: " + e2.getClass().getSimpleName());
                                aa.m5916z(e2.getMessage());
                                abVar.m5917c("_de", 1);
                                abVar.m5917c("_hd", i2);
                                abVar.m5917c("_hs", i);
                                m5941a(abVar, a, z2);
                                return i;
                            }
                        }
                        HttpResponse execute = this.vJ.execute(httpHost, c);
                        int statusCode = execute.getStatusLine().getStatusCode();
                        HttpEntity entity = execute.getEntity();
                        if (entity != null) {
                            entity.consumeContent();
                        }
                        if (statusCode != 200) {
                            aa.m5916z("Bad response: " + execute.getStatusLine().getStatusCode());
                        }
                    }
                    abVar.m5917c("_td", a2.getBytes().length);
                    i4 = i + 1;
                    url2 = a;
                }
            }
            i3++;
            i = i4;
            url = url2;
        }
        abVar.m5917c("_hd", i2);
        abVar.m5917c("_hs", i);
        if (z) {
            m5941a(abVar, url, z2);
        }
        return i;
    }

    String m5946a(String str, String str2, String str3, String str4, String str5, String str6) {
        return String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[]{str, str2, str3, str4, str5, str6});
    }

    URL m5947a(C1395x c1395x) {
        if (this.vK != null) {
            return this.vK;
        }
        try {
            return new URL("http:".equals(c1395x.cR()) ? "http://www.google-analytics.com/collect" : "https://ssl.google-analytics.com/collect");
        } catch (MalformedURLException e) {
            aa.m5913w("Error trying to parse the hardcoded host url. This really shouldn't happen.");
            return null;
        }
    }

    public boolean ch() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        aa.m5915y("...no network connectivity");
        return false;
    }

    boolean db() {
        return Math.random() * 100.0d <= 1.0d;
    }
}
