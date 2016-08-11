package com.avg.toolkit.p034b;

import android.os.Build;
import android.os.Build.VERSION;
import android.util.Xml;
import com.avg.toolkit.crashReport.CrashReport;
import com.mopub.mobileads.CustomEventBannerAdapter;
import java.net.URI;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.xmlpull.v1.XmlSerializer;
import p000a.p001a.p002a.p003a.p005b.C0003a;

/* renamed from: com.avg.toolkit.b.h */
public class C0959h {
    public URI f2897a;
    private final String f2898b;
    private final String f2899c;
    private final String f2900d;
    private final String f2901e;
    private final String f2902f;
    private final String f2903g;
    private final String f2904h;
    private final String f2905i;
    private final String f2906j;
    private HttpClient f2907k;
    private HttpPost f2908l;
    private XmlSerializer f2909m;

    /* renamed from: com.avg.toolkit.b.h.a */
    public static class C0958a extends Exception {
        private static final long serialVersionUID = 7499675036625522379L;
        public boolean f2895a;
        Exception f2896b;

        public C0958a(Exception e, boolean isNetworkError) {
            this.f2896b = null;
            this.f2896b = e;
            this.f2895a = isNetworkError;
        }

        public C0958a(String strError, boolean isNetworkError) {
            super(strError);
            this.f2896b = null;
            this.f2895a = isNetworkError;
        }
    }

    public C0959h(URI uri, int vendorId, int productId, String deviceId, String appVersion, String appVersionRevision) {
        this.f2897a = null;
        this.f2898b = "methodCall";
        this.f2899c = "methodName";
        this.f2900d = "methodResponse";
        this.f2901e = "params";
        this.f2902f = "param";
        this.f2903g = "fault";
        this.f2904h = "faultCode";
        this.f2905i = "faultString";
        this.f2906j = "d5544fG==*%877hT--==QQUPWeeY89904469==";
        this.f2897a = uri;
        this.f2908l = new HttpPost(uri);
        this.f2908l.addHeader(MraidCommandStorePicture.MIME_TYPE_HEADER, "text/xml");
        this.f2908l.addHeader("User-Agent", String.format("Mozilla/5.0 (Linux; U; Android %s; en-us; %s) pid/%s vc/%s (KHTML, like Gecko) Version/%s.%s", new Object[]{VERSION.RELEASE, Build.DEVICE, Integer.toString(productId), Integer.toString(vendorId), appVersion, appVersionRevision}));
        this.f2908l.addHeader("x-auth-token", C0003a.m36c(deviceId + "d5544fG==*%877hT--==QQUPWeeY89904469=="));
        HttpParams httpParams = this.f2908l.getParams();
        HttpProtocolParams.setUseExpectContinue(httpParams, false);
        HttpConnectionParams.setConnectionTimeout(httpParams, CustomEventBannerAdapter.DEFAULT_BANNER_TIMEOUT_DELAY);
        HttpConnectionParams.setSoTimeout(httpParams, CrashReport.FEATURE_ID);
        this.f2907k = new DefaultHttpClient();
        this.f2909m = Xml.newSerializer();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object m4302a(android.content.Context r31, java.lang.String r32, java.lang.String r33, java.lang.Object[] r34, java.util.HashMap r35, java.lang.String r36, java.io.File r37) {
        /*
        r30 = this;
        if (r32 == 0) goto L_0x0026;
    L_0x0002:
        if (r31 == 0) goto L_0x0026;
    L_0x0004:
        r14 = new android.content.Intent;	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r0 = r32;
        r14.<init>(r0);	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r26 = "result";
        r27 = 1;
        r0 = r26;
        r1 = r27;
        r14.putExtra(r0, r1);	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r26 = "progress";
        r27 = 1;
        r0 = r26;
        r1 = r27;
        r14.putExtra(r0, r1);	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r0 = r31;
        r0.sendBroadcast(r14);	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
    L_0x0026:
        r4 = new java.io.StringWriter;	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r4.<init>();	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r0 = r30;
        r0 = r0.f2909m;	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r26 = r0;
        r0 = r26;
        r0.setOutput(r4);	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r0 = r30;
        r0 = r0.f2909m;	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r26 = r0;
        r27 = 0;
        r28 = 0;
        r26.startDocument(r27, r28);	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r0 = r30;
        r0 = r0.f2909m;	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r26 = r0;
        r27 = 0;
        r28 = "methodCall";
        r26.startTag(r27, r28);	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r0 = r30;
        r0 = r0.f2909m;	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r26 = r0;
        r27 = 0;
        r28 = "methodName";
        r26 = r26.startTag(r27, r28);	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r0 = r26;
        r1 = r33;
        r26 = r0.text(r1);	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r27 = 0;
        r28 = "methodName";
        r26.endTag(r27, r28);	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r0 = r30;
        r0 = r0.f2909m;	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r26 = r0;
        r27 = 0;
        r28 = "params";
        r26.startTag(r27, r28);	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r0 = r30;
        r0 = r0.f2909m;	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r26 = r0;
        r27 = 0;
        r28 = "param";
        r26 = r26.startTag(r27, r28);	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r27 = 0;
        r28 = "value";
        r26.startTag(r27, r28);	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r0 = r30;
        r0 = r0.f2909m;	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r26 = r0;
        r0 = r26;
        r1 = r36;
        com.avg.toolkit.p034b.C0960i.m4304a(r0, r1);	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r0 = r30;
        r0 = r0.f2909m;	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r26 = r0;
        r27 = 0;
        r28 = "value";
        r26 = r26.endTag(r27, r28);	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r27 = 0;
        r28 = "param";
        r26.endTag(r27, r28);	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        if (r34 == 0) goto L_0x00fc;
    L_0x00b3:
        r0 = r34;
        r0 = r0.length;	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r26 = r0;
        if (r26 == 0) goto L_0x00fc;
    L_0x00ba:
        r12 = 0;
    L_0x00bb:
        r0 = r34;
        r0 = r0.length;	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r26 = r0;
        r0 = r26;
        if (r12 >= r0) goto L_0x00fc;
    L_0x00c4:
        r0 = r30;
        r0 = r0.f2909m;	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r26 = r0;
        r27 = 0;
        r28 = "param";
        r26 = r26.startTag(r27, r28);	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r27 = 0;
        r28 = "value";
        r26.startTag(r27, r28);	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r0 = r30;
        r0 = r0.f2909m;	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r26 = r0;
        r27 = r34[r12];	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        com.avg.toolkit.p034b.C0960i.m4304a(r26, r27);	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r0 = r30;
        r0 = r0.f2909m;	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r26 = r0;
        r27 = 0;
        r28 = "value";
        r26 = r26.endTag(r27, r28);	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r27 = 0;
        r28 = "param";
        r26.endTag(r27, r28);	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r12 = r12 + 1;
        goto L_0x00bb;
    L_0x00fc:
        r0 = r30;
        r0 = r0.f2909m;	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r26 = r0;
        r27 = 0;
        r28 = "params";
        r26.endTag(r27, r28);	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r0 = r30;
        r0 = r0.f2909m;	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r26 = r0;
        r27 = 0;
        r28 = "methodCall";
        r26.endTag(r27, r28);	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r0 = r30;
        r0 = r0.f2909m;	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r26 = r0;
        r26.endDocument();	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r7 = new org.apache.http.entity.StringEntity;	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r26 = r4.toString();	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r0 = r26;
        r7.<init>(r0);	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        if (r35 == 0) goto L_0x0191;
    L_0x012c:
        r26 = r35.keySet();	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r16 = r26.iterator();	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
    L_0x0134:
        r26 = r16.hasNext();	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        if (r26 == 0) goto L_0x0191;
    L_0x013a:
        r17 = r16.next();	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r17 = (java.lang.String) r17;	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r0 = r30;
        r0 = r0.f2908l;	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r27 = r0;
        r28 = "Cookie";
        r26 = new java.lang.StringBuilder;	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r26.<init>();	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r0 = r26;
        r1 = r17;
        r26 = r0.append(r1);	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r29 = "=";
        r0 = r26;
        r1 = r29;
        r29 = r0.append(r1);	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r0 = r35;
        r1 = r17;
        r26 = r0.get(r1);	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r26 = (java.lang.String) r26;	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r0 = r29;
        r1 = r26;
        r26 = r0.append(r1);	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r26 = r26.toString();	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r0 = r27;
        r1 = r28;
        r2 = r26;
        r0.setHeader(r1, r2);	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        goto L_0x0134;
    L_0x017f:
        r6 = move-exception;
        r26 = "XmlPullParserException";
        com.avg.toolkit.p049e.C0970a.m4325b(r26);
        r26 = new com.avg.toolkit.b.h$a;
        r27 = 0;
        r0 = r26;
        r1 = r27;
        r0.<init>(r6, r1);
        throw r26;
    L_0x0191:
        r0 = r30;
        r0 = r0.f2908l;	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r26 = r0;
        r0 = r26;
        r0.setEntity(r7);	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r23 = 0;
        r0 = r30;
        r0 = r0.f2907k;	 Catch:{ ClientProtocolException -> 0x01ed, IOException -> 0x0201 }
        r26 = r0;
        r0 = r30;
        r0 = r0.f2908l;	 Catch:{ ClientProtocolException -> 0x01ed, IOException -> 0x0201 }
        r27 = r0;
        r23 = r26.execute(r27);	 Catch:{ ClientProtocolException -> 0x01ed, IOException -> 0x0201 }
        r26 = r23.getStatusLine();	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r24 = r26.getStatusCode();	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r26 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        r0 = r24;
        r1 = r26;
        if (r0 == r1) goto L_0x021b;
    L_0x01be:
        r26 = new com.avg.toolkit.b.h$a;	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r27 = new java.lang.StringBuilder;	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r27.<init>();	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r28 = "HTTP status code: ";
        r27 = r27.append(r28);	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r0 = r27;
        r1 = r24;
        r27 = r0.append(r1);	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r27 = r27.toString();	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r28 = 0;
        r26.<init>(r27, r28);	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        throw r26;	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
    L_0x01dd:
        r6 = move-exception;
        r26 = "UnknownHostException";
        com.avg.toolkit.p049e.C0970a.m4325b(r26);
        r26 = new com.avg.toolkit.b.h$a;
        r27 = "UnknownHostException";
        r28 = 1;
        r26.<init>(r27, r28);
        throw r26;
    L_0x01ed:
        r6 = move-exception;
        r26 = "ClientProtocolException";
        com.avg.toolkit.p049e.C0970a.m4325b(r26);	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r26 = new com.avg.toolkit.b.h$a;	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r27 = 1;
        r0 = r26;
        r1 = r27;
        r0.<init>(r6, r1);	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        throw r26;	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
    L_0x01ff:
        r6 = move-exception;
        throw r6;
    L_0x0201:
        r6 = move-exception;
        r26 = new com.avg.toolkit.b.h$a;	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r27 = 1;
        r0 = r26;
        r1 = r27;
        r0.<init>(r6, r1);	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        throw r26;	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
    L_0x020e:
        r6 = move-exception;
        r26 = new com.avg.toolkit.b.h$a;
        r27 = 0;
        r0 = r26;
        r1 = r27;
        r0.<init>(r6, r1);
        throw r26;
    L_0x021b:
        r7 = r23.getEntity();	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        if (r7 != 0) goto L_0x0229;
    L_0x0221:
        r26 = "entity == null";
        com.avg.toolkit.p049e.C0970a.m4325b(r26);	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r20 = 0;
    L_0x0228:
        return r20;
    L_0x0229:
        if (r32 == 0) goto L_0x024f;
    L_0x022b:
        if (r31 == 0) goto L_0x024f;
    L_0x022d:
        r15 = new android.content.Intent;	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r0 = r32;
        r15.<init>(r0);	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r26 = "result";
        r27 = 1;
        r0 = r26;
        r1 = r27;
        r15.putExtra(r0, r1);	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r26 = "progress";
        r27 = 2;
        r0 = r26;
        r1 = r27;
        r15.putExtra(r0, r1);	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r0 = r31;
        r0.sendBroadcast(r15);	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
    L_0x024f:
        r13 = 0;
        if (r37 == 0) goto L_0x02d9;
    L_0x0252:
        r10 = 0;
        r13 = r7.getContent();	 Catch:{ Exception -> 0x02aa }
        r11 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x02aa }
        r0 = r37;
        r11.<init>(r0);	 Catch:{ Exception -> 0x02aa }
        r26 = 4084; // 0xff4 float:5.723E-42 double:2.018E-320;
        r0 = r26;
        r5 = new byte[r0];	 Catch:{ Exception -> 0x03b0, all -> 0x03ac }
        r18 = r13.read(r5);	 Catch:{ Exception -> 0x03b0, all -> 0x03ac }
    L_0x0268:
        r26 = -1;
        r0 = r18;
        r1 = r26;
        if (r0 == r1) goto L_0x027e;
    L_0x0270:
        r26 = 0;
        r0 = r26;
        r1 = r18;
        r11.write(r5, r0, r1);	 Catch:{ Exception -> 0x03b0, all -> 0x03ac }
        r18 = r13.read(r5);	 Catch:{ Exception -> 0x03b0, all -> 0x03ac }
        goto L_0x0268;
    L_0x027e:
        r13.close();	 Catch:{ Exception -> 0x03a9, all -> 0x03ac }
        r13 = 0;
    L_0x0282:
        r11.flush();	 Catch:{ Exception -> 0x029d, all -> 0x03ac }
        r11.close();	 Catch:{ Exception -> 0x029d, all -> 0x03ac }
        r10 = 0;
    L_0x0289:
        if (r13 == 0) goto L_0x028e;
    L_0x028b:
        r13.close();	 Catch:{ IOException -> 0x02a0 }
    L_0x028e:
        if (r10 == 0) goto L_0x0293;
    L_0x0290:
        r10.close();	 Catch:{ IOException -> 0x02a5 }
    L_0x0293:
        r7.consumeContent();	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r26 = 1;
        r20 = java.lang.Boolean.valueOf(r26);	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        goto L_0x0228;
    L_0x029d:
        r26 = move-exception;
        r10 = r11;
        goto L_0x0289;
    L_0x02a0:
        r6 = move-exception;
        com.avg.toolkit.p049e.C0970a.m4322a(r6);	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        goto L_0x028e;
    L_0x02a5:
        r6 = move-exception;
        com.avg.toolkit.p049e.C0970a.m4322a(r6);	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        goto L_0x0293;
    L_0x02aa:
        r6 = move-exception;
    L_0x02ab:
        com.avg.toolkit.p049e.C0970a.m4322a(r6);	 Catch:{ all -> 0x02c3 }
        if (r13 == 0) goto L_0x02b3;
    L_0x02b0:
        r13.close();	 Catch:{ IOException -> 0x02be }
    L_0x02b3:
        if (r10 == 0) goto L_0x0293;
    L_0x02b5:
        r10.close();	 Catch:{ IOException -> 0x02b9 }
        goto L_0x0293;
    L_0x02b9:
        r6 = move-exception;
        com.avg.toolkit.p049e.C0970a.m4322a(r6);	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        goto L_0x0293;
    L_0x02be:
        r6 = move-exception;
        com.avg.toolkit.p049e.C0970a.m4322a(r6);	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        goto L_0x02b3;
    L_0x02c3:
        r26 = move-exception;
    L_0x02c4:
        if (r13 == 0) goto L_0x02c9;
    L_0x02c6:
        r13.close();	 Catch:{ IOException -> 0x02cf }
    L_0x02c9:
        if (r10 == 0) goto L_0x02ce;
    L_0x02cb:
        r10.close();	 Catch:{ IOException -> 0x02d4 }
    L_0x02ce:
        throw r26;	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
    L_0x02cf:
        r6 = move-exception;
        com.avg.toolkit.p049e.C0970a.m4322a(r6);	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        goto L_0x02c9;
    L_0x02d4:
        r6 = move-exception;
        com.avg.toolkit.p049e.C0970a.m4322a(r6);	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        goto L_0x02ce;
    L_0x02d9:
        r22 = new java.io.InputStreamReader;	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r26 = r7.getContent();	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r0 = r22;
        r1 = r26;
        r0.<init>(r1);	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r26 = org.xmlpull.v1.XmlPullParserFactory.newInstance();	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r21 = r26.newPullParser();	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r21.setInput(r22);	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r21.nextTag();	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r26 = 2;
        r27 = 0;
        r28 = "methodResponse";
        r0 = r21;
        r1 = r26;
        r2 = r27;
        r3 = r28;
        r0.require(r1, r2, r3);	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r21.nextTag();	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r25 = r21.getName();	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r26 = "params";
        r26 = r25.equals(r26);	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        if (r26 == 0) goto L_0x0334;
    L_0x0314:
        r21.nextTag();	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r26 = 2;
        r27 = 0;
        r28 = "param";
        r0 = r21;
        r1 = r26;
        r2 = r27;
        r3 = r28;
        r0.require(r1, r2, r3);	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r21.nextTag();	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r20 = com.avg.toolkit.p034b.C0960i.m4303a(r21);	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r7.consumeContent();	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        goto L_0x0228;
    L_0x0334:
        r26 = "fault";
        r26 = r25.equals(r26);	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        if (r26 == 0) goto L_0x0387;
    L_0x033c:
        r21.nextTag();	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r19 = com.avg.toolkit.p034b.C0960i.m4303a(r21);	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r19 = (java.util.Map) r19;	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r26 = "faultString";
        r0 = r19;
        r1 = r26;
        r9 = r0.get(r1);	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r9 = (java.lang.String) r9;	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r26 = "faultCode";
        r0 = r19;
        r1 = r26;
        r26 = r0.get(r1);	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r26 = (java.lang.Integer) r26;	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r8 = r26.intValue();	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r7.consumeContent();	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r26 = new com.avg.toolkit.b.h$a;	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r27 = new java.lang.StringBuilder;	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r27.<init>();	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r0 = r27;
        r27 = r0.append(r9);	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r28 = ": ";
        r27 = r27.append(r28);	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r0 = r27;
        r27 = r0.append(r8);	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r27 = r27.toString();	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r28 = 0;
        r26.<init>(r27, r28);	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        throw r26;	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
    L_0x0387:
        r7.consumeContent();	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r26 = new com.avg.toolkit.b.h$a;	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r27 = new java.lang.StringBuilder;	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r27.<init>();	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r28 = "Bad tag ";
        r27 = r27.append(r28);	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r0 = r27;
        r1 = r25;
        r27 = r0.append(r1);	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r27 = r27.toString();	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        r28 = 0;
        r26.<init>(r27, r28);	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
        throw r26;	 Catch:{ XmlPullParserException -> 0x017f, UnknownHostException -> 0x01dd, a -> 0x01ff, Exception -> 0x020e }
    L_0x03a9:
        r26 = move-exception;
        goto L_0x0282;
    L_0x03ac:
        r26 = move-exception;
        r10 = r11;
        goto L_0x02c4;
    L_0x03b0:
        r6 = move-exception;
        r10 = r11;
        goto L_0x02ab;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avg.toolkit.b.h.a(android.content.Context, java.lang.String, java.lang.String, java.lang.Object[], java.util.HashMap, java.lang.String, java.io.File):java.lang.Object");
    }
}
