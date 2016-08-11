package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.internal.db.C1819a;
import com.google.android.gms.internal.ea.C1739a;
import com.google.android.gms.location.LocationStatusCodes;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public final class dc extends C1819a {
    private static final Object px;
    private static dc py;
    private final Context mContext;
    private final ax pA;
    private final bf pz;

    /* renamed from: com.google.android.gms.internal.dc.1 */
    static class C18201 implements Runnable {
        final /* synthetic */ Context pB;
        final /* synthetic */ cx pC;
        final /* synthetic */ de pD;
        final /* synthetic */ C1739a pE;
        final /* synthetic */ String pF;

        C18201(Context context, cx cxVar, de deVar, C1739a c1739a, String str) {
            this.pB = context;
            this.pC = cxVar;
            this.pD = deVar;
            this.pE = c1739a;
            this.pF = str;
        }

        public void run() {
            dz a = dz.m8225a(this.pB, new ak(), false, false, null, this.pC.kK);
            a.setWillNotDraw(true);
            this.pD.m8135b(a);
            ea bI = a.bI();
            bI.m8244a("/invalidRequest", this.pD.pK);
            bI.m8244a("/loadAdURL", this.pD.pL);
            bI.m8244a("/log", ba.mM);
            bI.m8242a(this.pE);
            dw.m8217v("Loading the JS library.");
            a.loadUrl(this.pF);
        }
    }

    /* renamed from: com.google.android.gms.internal.dc.2 */
    static class C18212 implements C1739a {
        final /* synthetic */ String pG;

        C18212(String str) {
            this.pG = str;
        }

        public void m8114a(dz dzVar) {
            String format = String.format("javascript:%s(%s);", new Object[]{"AFMA_buildAdURL", this.pG});
            dw.m8220y("About to execute: " + format);
            dzVar.loadUrl(format);
        }
    }

    static {
        px = new Object();
    }

    private dc(Context context, ax axVar, bf bfVar) {
        this.mContext = context;
        this.pz = bfVar;
        this.pA = axVar;
    }

    private static cz m8115a(Context context, ax axVar, bf bfVar, cx cxVar) {
        dw.m8217v("Starting ad request from service.");
        bfVar.init();
        dg dgVar = new dg(context);
        if (dgVar.qk == -1) {
            dw.m8217v("Device is offline.");
            return new cz(2);
        }
        de deVar = new de(cxVar.applicationInfo.packageName);
        if (cxVar.pg.extras != null) {
            String string = cxVar.pg.extras.getString("_ad");
            if (string != null) {
                return dd.m8121a(context, cxVar, string);
            }
        }
        Location a = bfVar.m7900a(250);
        String aH = axVar.aH();
        String a2 = dd.m8122a(cxVar, dgVar, a, axVar.aI());
        if (a2 == null) {
            return new cz(0);
        }
        dv.rp.post(new C18201(context, cxVar, deVar, m8119p(a2), aH));
        a2 = deVar.bj();
        return TextUtils.isEmpty(a2) ? new cz(deVar.getErrorCode()) : m8116a(context, cxVar.kK.rq, a2);
    }

    public static cz m8116a(Context context, String str, String str2) {
        HttpURLConnection httpURLConnection;
        try {
            int responseCode;
            cz czVar;
            df dfVar = new df();
            URL url = new URL(str2);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            URL url2 = url;
            int i = 0;
            while (true) {
                httpURLConnection = (HttpURLConnection) url2.openConnection();
                dq.m8178a(context, str, false, httpURLConnection);
                responseCode = httpURLConnection.getResponseCode();
                Map headerFields = httpURLConnection.getHeaderFields();
                if (responseCode < 200 || responseCode >= 300) {
                    m8118a(url2.toString(), headerFields, null, responseCode);
                    if (responseCode < 300 || responseCode >= 400) {
                        break;
                    }
                    Object headerField = httpURLConnection.getHeaderField("Location");
                    if (TextUtils.isEmpty(headerField)) {
                        dw.m8221z("No location header to follow redirect.");
                        czVar = new cz(0);
                        httpURLConnection.disconnect();
                        return czVar;
                    }
                    url2 = new URL(headerField);
                    i++;
                    if (i > 5) {
                        dw.m8221z("Too many redirects.");
                        czVar = new cz(0);
                        httpURLConnection.disconnect();
                        return czVar;
                    }
                    dfVar.m8150e(headerFields);
                    httpURLConnection.disconnect();
                } else {
                    String url3 = url2.toString();
                    String a = dq.m8172a(new InputStreamReader(httpURLConnection.getInputStream()));
                    m8118a(url3, headerFields, a, responseCode);
                    dfVar.m8149a(url3, headerFields, a);
                    czVar = dfVar.m8151g(elapsedRealtime);
                    httpURLConnection.disconnect();
                    return czVar;
                }
            }
            dw.m8221z("Received error HTTP response code: " + responseCode);
            czVar = new cz(0);
            httpURLConnection.disconnect();
            return czVar;
        } catch (IOException e) {
            dw.m8221z("Error while connecting to ad server: " + e.getMessage());
            return new cz(2);
        } catch (Throwable th) {
            httpURLConnection.disconnect();
        }
    }

    public static dc m8117a(Context context, ax axVar, bf bfVar) {
        dc dcVar;
        synchronized (px) {
            if (py == null) {
                py = new dc(context.getApplicationContext(), axVar, bfVar);
            }
            dcVar = py;
        }
        return dcVar;
    }

    private static void m8118a(String str, Map map, String str2, int i) {
        if (dw.m8216n(2)) {
            dw.m8220y("Http Response: {\n  URL:\n    " + str + "\n  Headers:");
            if (map != null) {
                for (String str3 : map.keySet()) {
                    dw.m8220y("    " + str3 + ":");
                    for (String str32 : (List) map.get(str32)) {
                        dw.m8220y("      " + str32);
                    }
                }
            }
            dw.m8220y("  Body:");
            if (str2 != null) {
                for (int i2 = 0; i2 < Math.min(str2.length(), 100000); i2 += LocationStatusCodes.GEOFENCE_NOT_AVAILABLE) {
                    dw.m8220y(str2.substring(i2, Math.min(str2.length(), i2 + LocationStatusCodes.GEOFENCE_NOT_AVAILABLE)));
                }
            } else {
                dw.m8220y("    null");
            }
            dw.m8220y("  Response Code:\n    " + i + "\n}");
        }
    }

    private static C1739a m8119p(String str) {
        return new C18212(str);
    }

    public cz m8120b(cx cxVar) {
        return m8115a(this.mContext, this.pA, this.pz, cxVar);
    }
}
