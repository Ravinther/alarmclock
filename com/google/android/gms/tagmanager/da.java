package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;

class da implements ab {
    private final Context aac;
    private final String aat;
    private final HttpClient aau;
    private C2268a aav;

    /* renamed from: com.google.android.gms.tagmanager.da.a */
    public interface C2268a {
        void m9400a(ap apVar);

        void m9401b(ap apVar);

        void m9402c(ap apVar);
    }

    da(HttpClient httpClient, Context context, C2268a c2268a) {
        this.aac = context.getApplicationContext();
        this.aat = m9510a("GoogleTagManager", "4.00", VERSION.RELEASE, m9509b(Locale.getDefault()), Build.MODEL, Build.ID);
        this.aau = httpClient;
        this.aav = c2268a;
    }

    private HttpEntityEnclosingRequest m9507a(URL url) {
        HttpEntityEnclosingRequest basicHttpEntityEnclosingRequest;
        URISyntaxException e;
        try {
            basicHttpEntityEnclosingRequest = new BasicHttpEntityEnclosingRequest("GET", url.toURI().toString());
            try {
                basicHttpEntityEnclosingRequest.addHeader("User-Agent", this.aat);
            } catch (URISyntaxException e2) {
                e = e2;
                bh.m9376z("Exception sending hit: " + e.getClass().getSimpleName());
                bh.m9376z(e.getMessage());
                return basicHttpEntityEnclosingRequest;
            }
        } catch (URISyntaxException e3) {
            URISyntaxException uRISyntaxException = e3;
            basicHttpEntityEnclosingRequest = null;
            e = uRISyntaxException;
            bh.m9376z("Exception sending hit: " + e.getClass().getSimpleName());
            bh.m9376z(e.getMessage());
            return basicHttpEntityEnclosingRequest;
        }
        return basicHttpEntityEnclosingRequest;
    }

    private void m9508a(HttpEntityEnclosingRequest httpEntityEnclosingRequest) {
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
                bh.m9375y("Error Writing hit to log...");
            }
        }
        bh.m9375y(stringBuffer.toString());
    }

    static String m9509b(Locale locale) {
        if (locale == null || locale.getLanguage() == null || locale.getLanguage().length() == 0) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(locale.getLanguage().toLowerCase());
        if (!(locale.getCountry() == null || locale.getCountry().length() == 0)) {
            stringBuilder.append("-").append(locale.getCountry().toLowerCase());
        }
        return stringBuilder.toString();
    }

    String m9510a(String str, String str2, String str3, String str4, String str5, String str6) {
        return String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[]{str, str2, str3, str4, str5, str6});
    }

    public boolean ch() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.aac.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        bh.m9375y("...no network connectivity");
        return false;
    }

    URL m9511d(ap apVar) {
        try {
            return new URL(apVar.kE());
        } catch (MalformedURLException e) {
            bh.m9373w("Error trying to parse the GTM url.");
            return null;
        }
    }

    public void m9512d(List list) {
        int min = Math.min(list.size(), 40);
        Object obj = 1;
        int i = 0;
        while (i < min) {
            Object obj2;
            ap apVar = (ap) list.get(i);
            URL d = m9511d(apVar);
            if (d == null) {
                bh.m9376z("No destination: discarding hit.");
                this.aav.m9401b(apVar);
                obj2 = obj;
            } else {
                HttpEntityEnclosingRequest a = m9507a(d);
                if (a == null) {
                    this.aav.m9401b(apVar);
                    obj2 = obj;
                } else {
                    HttpHost httpHost = new HttpHost(d.getHost(), d.getPort(), d.getProtocol());
                    a.addHeader("Host", httpHost.toHostString());
                    m9508a(a);
                    if (obj != null) {
                        try {
                            bn.m9386p(this.aac);
                            obj = null;
                        } catch (ClientProtocolException e) {
                            bh.m9376z("ClientProtocolException sending hit; discarding hit...");
                            this.aav.m9401b(apVar);
                            obj2 = obj;
                        } catch (IOException e2) {
                            bh.m9376z("Exception sending hit: " + e2.getClass().getSimpleName());
                            bh.m9376z(e2.getMessage());
                            this.aav.m9402c(apVar);
                            obj2 = obj;
                        }
                    }
                    HttpResponse execute = this.aau.execute(httpHost, a);
                    int statusCode = execute.getStatusLine().getStatusCode();
                    HttpEntity entity = execute.getEntity();
                    if (entity != null) {
                        entity.consumeContent();
                    }
                    if (statusCode != 200) {
                        bh.m9376z("Bad response: " + execute.getStatusLine().getStatusCode());
                        this.aav.m9402c(apVar);
                    } else {
                        this.aav.m9400a(apVar);
                    }
                    obj2 = obj;
                }
            }
            i++;
            obj = obj2;
        }
    }
}
