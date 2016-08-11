package com.avg.toolkit.license;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.WebView;
import com.avg.toolkit.p049e.C0970a;
import java.net.HttpURLConnection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.avg.toolkit.license.d */
public class C1024d {
    private final String f3152a;
    private C1020c f3153b;
    private String f3154c;
    private OcmCampaigns f3155d;
    private Runnable f3156e;
    private String f3157f;
    private Runnable f3158g;

    /* renamed from: com.avg.toolkit.license.d.1 */
    class C10211 implements Runnable {
        final /* synthetic */ Context f3140a;
        final /* synthetic */ C1024d f3141b;

        C10211(C1024d c1024d, Context context) {
            this.f3141b = c1024d;
            this.f3140a = context;
        }

        public void run() {
            new WebView(this.f3140a).clearCache(true);
            if (this.f3141b.f3156e != null) {
                this.f3141b.f3156e.run();
            }
        }
    }

    /* renamed from: com.avg.toolkit.license.d.a */
    public static class C1022a extends Exception {
        private static final long serialVersionUID = 6502324459335336494L;
        public boolean f3142a;
        Exception f3143b;

        public C1022a(Exception e, boolean isNetworkError) {
            super(e.getMessage());
            this.f3143b = null;
            this.f3143b = e;
            this.f3142a = isNetworkError;
        }

        public C1022a(String strError, boolean isNetworkError) {
            super(strError);
            this.f3143b = null;
            this.f3142a = isNetworkError;
        }
    }

    /* renamed from: com.avg.toolkit.license.d.b */
    private enum C1023b {
        BEFORE_KEY,
        IN_KEY,
        BEFORE_VALUE,
        IN_VALUE,
        IN_QUOTES_START,
        IN_QUOTES_END,
        IN_QUOTES_VALUE
    }

    public C1024d(Context context, String lsProductName, Runnable initRequestDoneListener, Runnable ocmReceivedListener) {
        String licAppName;
        this.f3156e = ocmReceivedListener;
        if (lsProductName == null) {
            lsProductName = "";
        }
        this.f3157f = lsProductName;
        this.f3158g = initRequestDoneListener;
        this.f3153b = new C1020c(context);
        Display display = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        if (metrics.ydpi <= 0.0f || metrics.xdpi <= 0.0f) {
            licAppName = "U";
        } else {
            double heightDp = ((double) metrics.heightPixels) / (((double) metrics.densityDpi) / 160.0d);
            double widthDp = ((double) metrics.widthPixels) / (((double) metrics.densityDpi) / 160.0d);
            licAppName = heightDp > widthDp ? widthDp >= 600.0d ? "T" : "P" : heightDp >= 600.0d ? "T" : "P";
        }
        this.f3152a = "AVGMOBILE-DRO" + licAppName + VERSION.SDK_INT;
    }

    public String m4468a(Context context, C1017a features) {
        this.f3155d = OcmCampaigns.readCampaignsFromStorage(context);
        if (this.f3155d == null) {
            this.f3155d = new OcmCampaigns();
        }
        String avgId = this.f3153b.m4454e();
        String newLicense = m4463a(context, features, false);
        if (avgId.equals("0-0")) {
            newLicense = m4463a(context, features, false);
            if (!(this.f3153b.m4454e().equals("0-0") || this.f3158g == null)) {
                try {
                    this.f3158g.run();
                } catch (Exception e) {
                    C0970a.m4322a(e);
                }
            }
        }
        if (this.f3154c != null) {
            m4463a(context, features, true);
        }
        return newLicense;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String m4463a(android.content.Context r51, com.avg.toolkit.license.C1017a r52, boolean r53) {
        /*
        r50 = this;
        r43 = new java.lang.StringBuilder;
        r43.<init>();
        r44 = "avgmobile";
        r43 = r43.append(r44);
        r0 = r50;
        r0 = r0.f3157f;
        r44 = r0;
        r44 = r44.toLowerCase();
        r43 = r43.append(r44);
        r28 = r43.toString();
        if (r53 == 0) goto L_0x0099;
    L_0x001f:
        r43 = new java.lang.StringBuilder;
        r43.<init>();
        r0 = r43;
        r1 = r28;
        r43 = r0.append(r1);
        r44 = ".ocm.avg.com";
        r43 = r43.append(r44);
        r18 = r43.toString();
    L_0x0036:
        if (r53 == 0) goto L_0x00b1;
    L_0x0038:
        r4 = "/gls/ocm";
    L_0x003a:
        r43 = new java.lang.StringBuilder;
        r43.<init>();
        r44 = "http://";
        r43 = r43.append(r44);
        r0 = r43;
        r1 = r18;
        r43 = r0.append(r1);
        r0 = r43;
        r43 = r0.append(r4);
        r37 = r43.toString();
        r26 = 0;
        r8 = 0;
        r36 = new java.net.URL;	 Catch:{ Exception -> 0x0089 }
        r36.<init>(r37);	 Catch:{ Exception -> 0x0089 }
        r43 = r36.openConnection();	 Catch:{ Exception -> 0x0089 }
        r0 = r43;
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ Exception -> 0x0089 }
        r8 = r0;
        r43 = "GET";
        r0 = r43;
        r8.setRequestMethod(r0);	 Catch:{ Exception -> 0x0089 }
        r43 = r51.getPackageManager();	 Catch:{ Exception -> 0x0089 }
        r44 = r51.getPackageName();	 Catch:{ Exception -> 0x0089 }
        r45 = 0;
        r27 = r43.getPackageInfo(r44, r45);	 Catch:{ Exception -> 0x0089 }
        if (r27 != 0) goto L_0x00b4;
    L_0x007f:
        r43 = new com.avg.toolkit.license.d$a;	 Catch:{ Exception -> 0x0089 }
        r44 = "pi";
        r45 = 1;
        r43.<init>(r44, r45);	 Catch:{ Exception -> 0x0089 }
        throw r43;	 Catch:{ Exception -> 0x0089 }
    L_0x0089:
        r9 = move-exception;
        com.avg.toolkit.p049e.C0970a.m4322a(r9);
        r43 = new com.avg.toolkit.license.d$a;
        r44 = 1;
        r0 = r43;
        r1 = r44;
        r0.<init>(r9, r1);
        throw r43;
    L_0x0099:
        r43 = new java.lang.StringBuilder;
        r43.<init>();
        r0 = r43;
        r1 = r28;
        r43 = r0.append(r1);
        r44 = ".update.avg.com";
        r43 = r43.append(r44);
        r18 = r43.toString();
        goto L_0x0036;
    L_0x00b1:
        r4 = "/gls/avgmobile";
        goto L_0x003a;
    L_0x00b4:
        r43 = 0;
        r0 = r43;
        r8.setUseCaches(r0);
        r43 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r0 = r43;
        r8.setConnectTimeout(r0);
        r43 = 15000; // 0x3a98 float:2.102E-41 double:7.411E-320;
        r0 = r43;
        r8.setReadTimeout(r0);
        r43 = "Connection";
        r44 = "close";
        r0 = r43;
        r1 = r44;
        r8.setRequestProperty(r0, r1);
        r0 = r27;
        r0 = r0.versionName;
        r43 = r0;
        r44 = "[^0-9]";
        r45 = "";
        r6 = r43.replaceAll(r44, r45);
        r43 = "";
        r0 = r43;
        r43 = r6.equals(r0);
        if (r43 == 0) goto L_0x02cd;
    L_0x00ec:
        r6 = "00";
    L_0x00ee:
        if (r52 == 0) goto L_0x010b;
    L_0x00f0:
        r43 = r52.m4427b();
        if (r43 == 0) goto L_0x010b;
    L_0x00f6:
        r43 = new java.lang.StringBuilder;
        r43.<init>();
        r0 = r43;
        r43 = r0.append(r6);
        r44 = "FREE";
        r43 = r43.append(r44);
        r6 = r43.toString();
    L_0x010b:
        r0 = r50;
        r0 = r0.f3153b;
        r43 = r0;
        r22 = r43.m4453d();
        r43 = r22.length();
        r44 = 4;
        r0 = r43;
        r1 = r44;
        if (r0 <= r1) goto L_0x0133;
    L_0x0121:
        r43 = 0;
        r44 = r22.length();
        r44 = r44 + -4;
        r0 = r22;
        r1 = r43;
        r2 = r44;
        r22 = r0.substring(r1, r2);
    L_0x0133:
        r24 = java.util.Locale.getDefault();
        r44 = new java.lang.StringBuilder;
        r44.<init>();
        r43 = r24.getLanguage();
        r45 = "";
        r0 = r43;
        r1 = r45;
        r43 = r0.equals(r1);
        if (r43 == 0) goto L_0x02f0;
    L_0x014c:
        r43 = "xx";
    L_0x014e:
        r0 = r44;
        r1 = r43;
        r43 = r0.append(r1);
        r44 = "_";
        r44 = r43.append(r44);
        r43 = r24.getCountry();
        r45 = "";
        r0 = r43;
        r1 = r45;
        r43 = r0.equals(r1);
        if (r43 == 0) goto L_0x02f6;
    L_0x016c:
        r43 = "XX";
    L_0x016e:
        r0 = r44;
        r1 = r43;
        r43 = r0.append(r1);
        r23 = r43.toString();
        r0 = r50;
        r0 = r0.f3153b;
        r43 = r0;
        r10 = r43.m4447b();
        r31 = new java.text.SimpleDateFormat;
        r43 = "yMMddHHmmss";
        r0 = r31;
        r1 = r43;
        r0.<init>(r1);
        r43 = "GMT+0";
        r43 = java.util.TimeZone.getTimeZone(r43);
        r0 = r31;
        r1 = r43;
        r0.setTimeZone(r1);
        r43 = 0;
        r43 = (java.util.Locale) r43;
        r45 = "%s %s BUILD=%s LIC=%s LNG=%s PROD=%s EVA=%s EDA=%s PKG=%d";
        r44 = 9;
        r0 = r44;
        r0 = new java.lang.Object[r0];
        r46 = r0;
        r44 = 0;
        r0 = r50;
        r0 = r0.f3152a;
        r47 = r0;
        r46[r44] = r47;
        r44 = 1;
        r46[r44] = r6;
        r44 = 2;
        r0 = r27;
        r0 = r0.versionCode;
        r47 = r0;
        r47 = java.lang.Integer.toString(r47);
        r46[r44] = r47;
        r44 = 3;
        r46[r44] = r22;
        r44 = 4;
        r46[r44] = r23;
        r44 = 5;
        r0 = r50;
        r0 = r0.f3157f;
        r47 = r0;
        r47 = r47.toUpperCase();
        r46[r44] = r47;
        r44 = 6;
        r47 = "3";
        r46[r44] = r47;
        r47 = 7;
        r48 = 0;
        r44 = (r10 > r48 ? 1 : (r10 == r48 ? 0 : -1));
        if (r44 != 0) goto L_0x02fc;
    L_0x01ea:
        r44 = "0";
    L_0x01ec:
        r46[r47] = r44;
        r44 = 8;
        r0 = r52;
        r0 = r0.f3120f;
        r47 = r0;
        r47 = java.lang.Integer.valueOf(r47);
        r46[r44] = r47;
        r0 = r43;
        r1 = r45;
        r2 = r46;
        r38 = java.lang.String.format(r0, r1, r2);
        r0 = r50;
        r0 = r0.f3153b;
        r43 = r0;
        r25 = r43.m4454e();
        r43 = "User-Agent";
        r0 = r43;
        r1 = r38;
        r8.setRequestProperty(r0, r1);
        r43 = "Host";
        r0 = r43;
        r1 = r18;
        r8.setRequestProperty(r0, r1);
        r43 = "X-AVG-ID";
        r0 = r43;
        r1 = r25;
        r8.setRequestProperty(r0, r1);
        r43 = new com.avg.toolkit.uid.UUID;
        r0 = r43;
        r1 = r51;
        r0.<init>(r1);
        r17 = r43.getUUID();
        if (r17 == 0) goto L_0x030d;
    L_0x023a:
        r43 = r17.getBytes();
        r17 = p000a.p001a.p002a.p003a.p005b.C0003a.m39d(r43);
        r43 = 32;
        r0 = r17;
        r1 = r43;
        r19 = r0.substring(r1);
        r43 = 0;
        r44 = 32;
        r0 = r17;
        r1 = r43;
        r2 = r44;
        r17 = r0.substring(r1, r2);
        r43 = "x-avg-mid";
        r44 = new java.lang.StringBuilder;
        r44.<init>();
        r0 = r44;
        r1 = r17;
        r44 = r0.append(r1);
        r45 = "-";
        r44 = r44.append(r45);
        r0 = r44;
        r1 = r19;
        r44 = r0.append(r1);
        r44 = r44.toString();
        r0 = r43;
        r1 = r44;
        r8.setRequestProperty(r0, r1);
    L_0x0282:
        r12 = com.avg.toolkit.license.C1024d.m4460a(r51);
        r32 = new java.text.SimpleDateFormat;
        r43 = "yMMddHHmm";
        r0 = r32;
        r1 = r43;
        r0.<init>(r1);
        r43 = "GMT+0";
        r43 = java.util.TimeZone.getTimeZone(r43);
        r0 = r32;
        r1 = r43;
        r0.setTimeZone(r1);
        r44 = "x-avg-it";
        r46 = 0;
        r43 = (r12 > r46 ? 1 : (r12 == r46 ? 0 : -1));
        if (r43 != 0) goto L_0x031a;
    L_0x02a6:
        r43 = "0";
    L_0x02a8:
        r0 = r44;
        r1 = r43;
        r8.setRequestProperty(r0, r1);
        r0 = r50;
        r0 = r0.f3153b;
        r43 = r0;
        r0 = r50;
        r1 = r51;
        r2 = r43;
        r3 = r53;
        r43 = r0.m4467a(r1, r8, r2, r3);
        if (r43 != 0) goto L_0x032b;
    L_0x02c3:
        r43 = new com.avg.toolkit.license.d$a;
        r44 = "error setting headers";
        r45 = 1;
        r43.<init>(r44, r45);
        throw r43;
    L_0x02cd:
        r43 = r6.length();
        r44 = 2;
        r0 = r43;
        r1 = r44;
        if (r0 >= r1) goto L_0x00ee;
    L_0x02d9:
        r43 = new java.lang.StringBuilder;
        r43.<init>();
        r44 = "0";
        r43 = r43.append(r44);
        r0 = r43;
        r43 = r0.append(r6);
        r6 = r43.toString();
        goto L_0x00ee;
    L_0x02f0:
        r43 = r24.getLanguage();
        goto L_0x014e;
    L_0x02f6:
        r43 = r24.getCountry();
        goto L_0x016e;
    L_0x02fc:
        r44 = new java.util.Date;
        r0 = r44;
        r0.<init>(r10);
        r0 = r31;
        r1 = r44;
        r44 = r0.format(r1);
        goto L_0x01ec;
    L_0x030d:
        r43 = "x-avg-mid";
        r44 = "0-0";
        r0 = r43;
        r1 = r44;
        r8.setRequestProperty(r0, r1);
        goto L_0x0282;
    L_0x031a:
        r43 = new java.util.Date;
        r0 = r43;
        r0.<init>(r12);
        r0 = r32;
        r1 = r43;
        r43 = r0.format(r1);
        goto L_0x02a8;
    L_0x032b:
        r43 = com.avg.toolkit.zen.C1051f.m4573a();
        if (r43 == 0) goto L_0x037d;
    L_0x0331:
        r43 = com.avg.toolkit.zen.C1050e.m4568r(r51);
        if (r43 == 0) goto L_0x043d;
    L_0x0337:
        r42 = com.avg.toolkit.zen.C1050e.m4539a(r51);
        r41 = com.avg.toolkit.zen.C1050e.m4542b(r51);
        r43 = com.avg.toolkit.zen.C1050e.m4567q(r51);
        if (r43 == 0) goto L_0x0439;
    L_0x0345:
        r40 = 1;
    L_0x0347:
        r43 = "X-AVG-ZENID";
        r44 = new java.lang.StringBuilder;
        r44.<init>();
        r0 = r44;
        r1 = r42;
        r44 = r0.append(r1);
        r45 = "-";
        r44 = r44.append(r45);
        r0 = r44;
        r1 = r41;
        r44 = r0.append(r1);
        r45 = "-";
        r44 = r44.append(r45);
        r0 = r44;
        r1 = r40;
        r44 = r0.append(r1);
        r44 = r44.toString();
        r0 = r43;
        r1 = r44;
        r8.setRequestProperty(r0, r1);
    L_0x037d:
        r43 = com.avg.toolkit.p051g.C0977e.m4343a();
        if (r43 == 0) goto L_0x03d1;
    L_0x0383:
        r43 = com.avg.toolkit.p051g.C0977e.m4344b();
        r35 = r43.m4342a();
        r43 = r52.m4430e();
        if (r43 == 0) goto L_0x044a;
    L_0x0391:
        r14 = 1;
    L_0x0392:
        r43 = com.avg.toolkit.p051g.C0979g.m4355h(r51);
        if (r43 == 0) goto L_0x044d;
    L_0x0398:
        r5 = com.avg.toolkit.p051g.C0979g.m4353f(r51);
        r15 = com.avg.toolkit.p051g.C0979g.m4354g(r51);
    L_0x03a0:
        r43 = "X-AVG-GMS";
        r44 = java.util.Locale.ENGLISH;
        r45 = "%d-%s-%s-%d";
        r46 = 4;
        r0 = r46;
        r0 = new java.lang.Object[r0];
        r46 = r0;
        r47 = 0;
        r48 = java.lang.Integer.valueOf(r35);
        r46[r47] = r48;
        r47 = 1;
        r46[r47] = r5;
        r47 = 2;
        r46[r47] = r15;
        r47 = 3;
        r48 = java.lang.Integer.valueOf(r14);
        r46[r47] = r48;
        r44 = java.lang.String.format(r44, r45, r46);
        r0 = r43;
        r1 = r44;
        r8.setRequestProperty(r0, r1);
    L_0x03d1:
        r43 = "Cache-Control";
        r44 = "no-cache";
        r0 = r43;
        r1 = r44;
        r8.setRequestProperty(r0, r1);
        r43 = "Pragma";
        r44 = "no-cache";
        r0 = r43;
        r1 = r44;
        r8.setRequestProperty(r0, r1);
        r43 = "Accept";
        r44 = "*/*";
        r0 = r43;
        r1 = r44;
        r8.setRequestProperty(r0, r1);
        r20 = 0;
        r8.connect();	 Catch:{ IOException -> 0x0422, Exception -> 0x04b9 }
        r34 = r8.getResponseCode();	 Catch:{ IOException -> 0x0422, Exception -> 0x04b9 }
        r43 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        r0 = r34;
        r1 = r43;
        if (r0 == r1) goto L_0x0453;
    L_0x0403:
        r43 = new com.avg.toolkit.license.d$a;	 Catch:{ IOException -> 0x0422, Exception -> 0x04b9 }
        r44 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0422, Exception -> 0x04b9 }
        r44.<init>();	 Catch:{ IOException -> 0x0422, Exception -> 0x04b9 }
        r45 = "HTTP status code: ";
        r44 = r44.append(r45);	 Catch:{ IOException -> 0x0422, Exception -> 0x04b9 }
        r0 = r44;
        r1 = r34;
        r44 = r0.append(r1);	 Catch:{ IOException -> 0x0422, Exception -> 0x04b9 }
        r44 = r44.toString();	 Catch:{ IOException -> 0x0422, Exception -> 0x04b9 }
        r45 = 0;
        r43.<init>(r44, r45);	 Catch:{ IOException -> 0x0422, Exception -> 0x04b9 }
        throw r43;	 Catch:{ IOException -> 0x0422, Exception -> 0x04b9 }
    L_0x0422:
        r9 = move-exception;
        r43 = new com.avg.toolkit.license.d$a;	 Catch:{ all -> 0x042f }
        r44 = 1;
        r0 = r43;
        r1 = r44;
        r0.<init>(r9, r1);	 Catch:{ all -> 0x042f }
        throw r43;	 Catch:{ all -> 0x042f }
    L_0x042f:
        r43 = move-exception;
        if (r20 == 0) goto L_0x0435;
    L_0x0432:
        r20.close();	 Catch:{ IOException -> 0x04f0 }
    L_0x0435:
        r8.disconnect();
        throw r43;
    L_0x0439:
        r40 = 2;
        goto L_0x0347;
    L_0x043d:
        r43 = "X-AVG-ZENID";
        r44 = "0-0-0";
        r0 = r43;
        r1 = r44;
        r8.setRequestProperty(r0, r1);
        goto L_0x037d;
    L_0x044a:
        r14 = 0;
        goto L_0x0392;
    L_0x044d:
        r5 = "0";
        r15 = "0";
        goto L_0x03a0;
    L_0x0453:
        r16 = r8.getHeaderFields();	 Catch:{ IOException -> 0x0422, Exception -> 0x04b9 }
        r0 = r50;
        r1 = r51;
        r2 = r16;
        r26 = r0.m4464a(r1, r2);	 Catch:{ IOException -> 0x0422, Exception -> 0x04b9 }
        if (r53 == 0) goto L_0x04e5;
    L_0x0463:
        r20 = r8.getInputStream();	 Catch:{ IOException -> 0x0422, Exception -> 0x04b9 }
        r43 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r0 = r43;
        r7 = new char[r0];	 Catch:{ IOException -> 0x0422, Exception -> 0x04b9 }
        r33 = 0;
        r39 = new java.io.StringWriter;	 Catch:{ IOException -> 0x0422, Exception -> 0x04b9 }
        r39.<init>();	 Catch:{ IOException -> 0x0422, Exception -> 0x04b9 }
        r29 = new java.io.InputStreamReader;	 Catch:{ IOException -> 0x0422, Exception -> 0x04b9 }
        r43 = java.nio.charset.Charset.defaultCharset();	 Catch:{ IOException -> 0x0422, Exception -> 0x04b9 }
        r0 = r29;
        r1 = r20;
        r2 = r43;
        r0.<init>(r1, r2);	 Catch:{ IOException -> 0x0422, Exception -> 0x04b9 }
    L_0x0483:
        r0 = r29;
        r21 = r0.read(r7);	 Catch:{ IOException -> 0x0422, Exception -> 0x04b9 }
        r43 = -1;
        r0 = r21;
        r1 = r43;
        if (r0 == r1) goto L_0x04a7;
    L_0x0491:
        r43 = 65536; // 0x10000 float:9.18355E-41 double:3.2379E-319;
        r0 = r33;
        r1 = r43;
        if (r0 > r1) goto L_0x04a7;
    L_0x0499:
        r43 = 0;
        r0 = r39;
        r1 = r43;
        r2 = r21;
        r0.write(r7, r1, r2);	 Catch:{ IOException -> 0x0422, Exception -> 0x04b9 }
        r33 = r33 + r21;
        goto L_0x0483;
    L_0x04a7:
        r43 = 65536; // 0x10000 float:9.18355E-41 double:3.2379E-319;
        r0 = r33;
        r1 = r43;
        if (r0 <= r1) goto L_0x04c9;
    L_0x04af:
        r43 = new com.avg.toolkit.license.d$a;	 Catch:{ IOException -> 0x0422, Exception -> 0x04b9 }
        r44 = "error in response";
        r45 = 0;
        r43.<init>(r44, r45);	 Catch:{ IOException -> 0x0422, Exception -> 0x04b9 }
        throw r43;	 Catch:{ IOException -> 0x0422, Exception -> 0x04b9 }
    L_0x04b9:
        r9 = move-exception;
        com.avg.toolkit.p049e.C0970a.m4322a(r9);	 Catch:{ all -> 0x042f }
        r43 = new com.avg.toolkit.license.d$a;	 Catch:{ all -> 0x042f }
        r44 = 0;
        r0 = r43;
        r1 = r44;
        r0.<init>(r9, r1);	 Catch:{ all -> 0x042f }
        throw r43;	 Catch:{ all -> 0x042f }
    L_0x04c9:
        r30 = r39.toString();	 Catch:{ IOException -> 0x0422, Exception -> 0x04b9 }
        r0 = r50;
        r1 = r51;
        r2 = r52;
        r3 = r30;
        r43 = r0.m4469a(r1, r2, r3);	 Catch:{ IOException -> 0x0422, Exception -> 0x04b9 }
        if (r43 != 0) goto L_0x04e5;
    L_0x04db:
        r43 = new com.avg.toolkit.license.d$a;	 Catch:{ IOException -> 0x0422, Exception -> 0x04b9 }
        r44 = "error in response";
        r45 = 0;
        r43.<init>(r44, r45);	 Catch:{ IOException -> 0x0422, Exception -> 0x04b9 }
        throw r43;	 Catch:{ IOException -> 0x0422, Exception -> 0x04b9 }
    L_0x04e5:
        if (r20 == 0) goto L_0x04ea;
    L_0x04e7:
        r20.close();	 Catch:{ IOException -> 0x04ee }
    L_0x04ea:
        r8.disconnect();
        return r26;
    L_0x04ee:
        r43 = move-exception;
        goto L_0x04ea;
    L_0x04f0:
        r44 = move-exception;
        goto L_0x0435;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avg.toolkit.license.d.a(android.content.Context, com.avg.toolkit.license.a, boolean):java.lang.String");
    }

    private String m4464a(Context context, Map headers) {
        String header;
        String newLicense = null;
        Map headersLowerCase = new HashMap();
        for (Entry entry : headers.entrySet()) {
            String key = (String) entry.getKey();
            headersLowerCase.put(key == null ? null : key.toLowerCase(Locale.ENGLISH), (List) entry.getValue());
        }
        List tempHList = (List) headersLowerCase.get("x-avg-id");
        if (tempHList != null) {
            header = (String) tempHList.get(0);
        } else {
            header = null;
        }
        if (header == null || !header.equals(this.f3153b.m4454e())) {
            tempHList = (List) headersLowerCase.get("x-avg-newid");
        } else {
            tempHList = (List) headersLowerCase.get("x-avg-newid");
        }
        if (tempHList != null) {
            header = (String) tempHList.get(0);
        } else {
            header = null;
        }
        if (header != null) {
            this.f3153b.m4449b(header);
        }
        tempHList = (List) headersLowerCase.get("x-avg-newlic");
        if (tempHList != null) {
            header = (String) tempHList.get(0);
        } else {
            header = null;
        }
        if (header != null) {
            newLicense = header;
        }
        tempHList = (List) headersLowerCase.get("x-avg-newlicmode");
        if (tempHList != null) {
            header = (String) tempHList.get(0);
        } else {
            header = null;
        }
        if (header != null) {
            this.f3153b.m4452c(header);
        }
        m4466a(context, headersLowerCase, this.f3153b);
        return newLicense;
    }

    private HashMap m4465a(String rule) {
        boolean validCampaign = true;
        int ruleLen = rule.length();
        HashMap parameters = new HashMap();
        C1023b mode = C1023b.BEFORE_KEY;
        int seqStart = 0;
        String key = "";
        int i = 0;
        while (i < ruleLen) {
            if (Character.isWhitespace(rule.charAt(i))) {
                if (mode == C1023b.BEFORE_KEY) {
                    continue;
                } else if (mode == C1023b.IN_KEY) {
                    validCampaign = false;
                    break;
                } else if (mode == C1023b.BEFORE_VALUE) {
                    validCampaign = false;
                    break;
                } else if (mode == C1023b.IN_VALUE) {
                    parameters.put(key, rule.substring(seqStart, i));
                    mode = C1023b.BEFORE_KEY;
                } else if (mode == C1023b.IN_QUOTES_START) {
                    validCampaign = false;
                    break;
                } else if (mode == C1023b.IN_QUOTES_END) {
                    mode = C1023b.BEFORE_KEY;
                } else if (mode == C1023b.IN_QUOTES_VALUE) {
                }
            } else if (rule.charAt(i) == '=') {
                if (mode == C1023b.BEFORE_KEY) {
                    validCampaign = false;
                    break;
                } else if (mode == C1023b.IN_KEY) {
                    key = rule.substring(seqStart, i).toLowerCase(Locale.ENGLISH);
                    mode = C1023b.BEFORE_VALUE;
                } else if (mode == C1023b.BEFORE_VALUE) {
                    validCampaign = false;
                    break;
                } else if (mode == C1023b.IN_VALUE) {
                    validCampaign = false;
                    break;
                } else if (mode == C1023b.IN_QUOTES_START) {
                    seqStart = i;
                    mode = C1023b.IN_QUOTES_VALUE;
                } else if (mode == C1023b.IN_QUOTES_END) {
                    validCampaign = false;
                    break;
                } else if (mode == C1023b.IN_QUOTES_VALUE) {
                }
            } else if (rule.charAt(i) == '\"') {
                if (mode == C1023b.BEFORE_KEY) {
                    validCampaign = false;
                    break;
                } else if (mode == C1023b.IN_KEY) {
                    validCampaign = false;
                    break;
                } else if (mode == C1023b.BEFORE_VALUE) {
                    mode = C1023b.IN_QUOTES_START;
                } else if (mode == C1023b.IN_VALUE) {
                    validCampaign = false;
                    break;
                } else if (mode == C1023b.IN_QUOTES_START) {
                    parameters.put(key, "");
                    mode = C1023b.IN_QUOTES_END;
                } else if (mode == C1023b.IN_QUOTES_END) {
                    validCampaign = false;
                    break;
                } else if (mode == C1023b.IN_QUOTES_VALUE) {
                    parameters.put(key, rule.substring(seqStart, i));
                    mode = C1023b.IN_QUOTES_END;
                }
            } else if (rule.charAt(i) == ',') {
                if (mode == C1023b.BEFORE_KEY) {
                    validCampaign = false;
                    break;
                } else if (mode == C1023b.IN_KEY) {
                    validCampaign = false;
                    break;
                } else if (mode == C1023b.BEFORE_VALUE) {
                    seqStart = i;
                    mode = C1023b.IN_VALUE;
                } else if (mode == C1023b.IN_VALUE) {
                    continue;
                } else if (mode == C1023b.IN_QUOTES_START) {
                    seqStart = i;
                    mode = C1023b.IN_QUOTES_VALUE;
                } else if (mode == C1023b.IN_QUOTES_END) {
                    validCampaign = false;
                    break;
                } else if (mode == C1023b.IN_QUOTES_VALUE) {
                }
            } else if (mode == C1023b.BEFORE_KEY) {
                seqStart = i;
                mode = C1023b.IN_KEY;
            } else if (mode == C1023b.IN_KEY) {
                continue;
            } else if (mode == C1023b.BEFORE_VALUE) {
                seqStart = i;
                mode = C1023b.IN_VALUE;
            } else if (mode == C1023b.IN_VALUE) {
                continue;
            } else if (mode == C1023b.IN_QUOTES_START) {
                seqStart = i;
                mode = C1023b.IN_QUOTES_VALUE;
            } else if (mode == C1023b.IN_QUOTES_END) {
                validCampaign = false;
                break;
            } else if (mode == C1023b.IN_QUOTES_VALUE) {
            }
            i++;
        }
        if (validCampaign && mode != C1023b.BEFORE_KEY) {
            if (mode == C1023b.IN_KEY) {
                validCampaign = false;
            } else if (mode == C1023b.BEFORE_VALUE) {
                validCampaign = false;
            } else if (mode == C1023b.IN_VALUE) {
                parameters.put(key, rule.substring(seqStart, i));
                mode = C1023b.BEFORE_KEY;
            } else if (mode == C1023b.IN_QUOTES_START) {
                validCampaign = false;
            } else if (mode != C1023b.IN_QUOTES_END && mode == C1023b.IN_QUOTES_VALUE) {
                validCampaign = false;
            }
        }
        return validCampaign ? parameters : null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean m4469a(android.content.Context r43, com.avg.toolkit.license.C1017a r44, java.lang.String r45) {
        /*
        r42 = this;
        r11 = "";
        r35 = 0;
        r38 = 0;
        r23 = java.lang.Integer.valueOf(r38);
        r38 = 0;
        r24 = java.lang.Integer.valueOf(r38);
        r38 = "\\|\\s*\\|";
        r0 = r45;
        r1 = r38;
        r38 = r0.matches(r1);
        if (r38 == 0) goto L_0x008d;
    L_0x001c:
        r0 = r42;
        r0 = r0.f3155d;
        r38 = r0;
        r38.clear();
        r35 = 1;
    L_0x0027:
        if (r35 == 0) goto L_0x008c;
    L_0x0029:
        r0 = r42;
        r0 = r0.f3155d;
        r38 = r0;
        r0 = r42;
        r0 = r0.f3154c;
        r39 = r0;
        r0 = r39;
        r1 = r38;
        r1.ocmId = r0;
        r0 = r42;
        r0 = r0.f3155d;
        r38 = r0;
        r0 = r38;
        r1 = r23;
        r2 = r24;
        r0.updateInactiveDays(r1, r2);
        r0 = r42;
        r0 = r0.f3155d;
        r38 = r0;
        r39 = 1;
        r0 = r43;
        r1 = r38;
        r2 = r39;
        r35 = com.avg.toolkit.license.OcmCampaigns.writeCampaignsToStorage(r0, r1, r2);
        r20 = new android.os.Handler;
        r38 = r43.getMainLooper();
        r0 = r20;
        r1 = r38;
        r0.<init>(r1);
        r38 = new com.avg.toolkit.license.d$1;
        r0 = r38;
        r1 = r42;
        r2 = r43;
        r0.<init>(r1, r2);
        r0 = r20;
        r1 = r38;
        r0.post(r1);
        r38 = "OCM";
        r39 = "Rule_received";
        r40 = 0;
        r0 = r43;
        r1 = r38;
        r2 = r39;
        r3 = r40;
        com.avg.toolkit.ganalytics.GoogleAnalyticsWrapper.trackEvent(r0, r1, r2, r11, r3);
    L_0x008c:
        return r35;
    L_0x008d:
        r38 = "\\|";
        r0 = r45;
        r1 = r38;
        r32 = r0.split(r1);
        r27 = new com.avg.toolkit.license.OcmCampaigns;
        r27.<init>();
        r9 = 0;
        r6 = r32;
        r0 = r6.length;
        r25 = r0;
        r22 = 0;
        r10 = r9;
    L_0x00a5:
        r0 = r22;
        r1 = r25;
        if (r0 >= r1) goto L_0x06c3;
    L_0x00ab:
        r31 = r6[r22];
        r38 = "";
        r0 = r31;
        r1 = r38;
        r38 = r0.equals(r1);
        if (r38 != 0) goto L_0x06e7;
    L_0x00b9:
        r38 = "\r\n";
        r0 = r31;
        r1 = r38;
        r38 = r0.equals(r1);
        if (r38 == 0) goto L_0x00ca;
    L_0x00c5:
        r9 = r10;
    L_0x00c6:
        r22 = r22 + 1;
        r10 = r9;
        goto L_0x00a5;
    L_0x00ca:
        r0 = r42;
        r1 = r31;
        r30 = r0.m4465a(r1);
        if (r30 != 0) goto L_0x00d6;
    L_0x00d4:
        r9 = r10;
        goto L_0x00c6;
    L_0x00d6:
        r9 = new com.avg.toolkit.license.OcmCampaign;	 Catch:{ Exception -> 0x06e3 }
        r9.<init>();	 Catch:{ Exception -> 0x06e3 }
        r38 = "id";
        r0 = r30;
        r1 = r38;
        r36 = r0.get(r1);	 Catch:{ Exception -> 0x0355 }
        r36 = (java.lang.String) r36;	 Catch:{ Exception -> 0x0355 }
        if (r36 == 0) goto L_0x0368;
    L_0x00e9:
        r38 = java.lang.Integer.valueOf(r36);	 Catch:{ Exception -> 0x0355 }
        r38 = r38.intValue();	 Catch:{ Exception -> 0x0355 }
        r0 = r38;
        r9.id = r0;	 Catch:{ Exception -> 0x0355 }
        r38 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0355 }
        r38.<init>();	 Catch:{ Exception -> 0x0355 }
        r0 = r38;
        r38 = r0.append(r11);	 Catch:{ Exception -> 0x0355 }
        r0 = r9.id;	 Catch:{ Exception -> 0x0355 }
        r39 = r0;
        r38 = r38.append(r39);	 Catch:{ Exception -> 0x0355 }
        r39 = "_";
        r38 = r38.append(r39);	 Catch:{ Exception -> 0x0355 }
        r11 = r38.toString();	 Catch:{ Exception -> 0x0355 }
        r38 = "target";
        r0 = r30;
        r1 = r38;
        r36 = r0.get(r1);	 Catch:{ Exception -> 0x0355 }
        r36 = (java.lang.String) r36;	 Catch:{ Exception -> 0x0355 }
        if (r36 == 0) goto L_0x03a3;
    L_0x0120:
        r38 = "notification";
        r0 = r36;
        r1 = r38;
        r38 = r0.equals(r1);	 Catch:{ Exception -> 0x0355 }
        if (r38 == 0) goto L_0x0370;
    L_0x012c:
        r38 = com.avg.toolkit.license.OcmCampaign.TargetType.NOTIFICATION;	 Catch:{ Exception -> 0x0355 }
        r0 = r38;
        r9.setTarget(r0);	 Catch:{ Exception -> 0x0355 }
    L_0x0133:
        r38 = "sbn";
        r0 = r30;
        r1 = r38;
        r36 = r0.get(r1);	 Catch:{ Exception -> 0x0355 }
        r36 = (java.lang.String) r36;	 Catch:{ Exception -> 0x0355 }
        if (r36 == 0) goto L_0x0149;
    L_0x0141:
        r38 = java.lang.Integer.valueOf(r36);	 Catch:{ Exception -> 0x0355 }
        r0 = r38;
        r9.sbn = r0;	 Catch:{ Exception -> 0x0355 }
    L_0x0149:
        r38 = "ebn";
        r0 = r30;
        r1 = r38;
        r36 = r0.get(r1);	 Catch:{ Exception -> 0x0355 }
        r36 = (java.lang.String) r36;	 Catch:{ Exception -> 0x0355 }
        if (r36 == 0) goto L_0x015f;
    L_0x0157:
        r38 = java.lang.Integer.valueOf(r36);	 Catch:{ Exception -> 0x0355 }
        r0 = r38;
        r9.ebn = r0;	 Catch:{ Exception -> 0x0355 }
    L_0x015f:
        r38 = "sda";
        r0 = r30;
        r1 = r38;
        r36 = r0.get(r1);	 Catch:{ Exception -> 0x0355 }
        r36 = (java.lang.String) r36;	 Catch:{ Exception -> 0x0355 }
        if (r36 == 0) goto L_0x03ab;
    L_0x016d:
        r38 = 0;
        r0 = r42;
        r1 = r36;
        r2 = r38;
        r38 = r0.m4461a(r1, r2);	 Catch:{ Exception -> 0x0355 }
        r0 = r38;
        r9.sda = r0;	 Catch:{ Exception -> 0x0355 }
    L_0x017d:
        r38 = "eda";
        r0 = r30;
        r1 = r38;
        r36 = r0.get(r1);	 Catch:{ Exception -> 0x0355 }
        r36 = (java.lang.String) r36;	 Catch:{ Exception -> 0x0355 }
        if (r36 == 0) goto L_0x03b5;
    L_0x018b:
        r38 = 1;
        r0 = r42;
        r1 = r36;
        r2 = r38;
        r38 = r0.m4461a(r1, r2);	 Catch:{ Exception -> 0x0355 }
        r0 = r38;
        r9.eda = r0;	 Catch:{ Exception -> 0x0355 }
    L_0x019b:
        r38 = "bes";
        r0 = r30;
        r1 = r38;
        r36 = r0.get(r1);	 Catch:{ Exception -> 0x0355 }
        r36 = (java.lang.String) r36;	 Catch:{ Exception -> 0x0355 }
        if (r36 == 0) goto L_0x01b1;
    L_0x01a9:
        r38 = java.lang.Integer.valueOf(r36);	 Catch:{ Exception -> 0x0355 }
        r0 = r38;
        r9.bes = r0;	 Catch:{ Exception -> 0x0355 }
    L_0x01b1:
        r38 = "bee";
        r0 = r30;
        r1 = r38;
        r36 = r0.get(r1);	 Catch:{ Exception -> 0x0355 }
        r36 = (java.lang.String) r36;	 Catch:{ Exception -> 0x0355 }
        if (r36 == 0) goto L_0x01db;
    L_0x01bf:
        r38 = java.lang.Integer.valueOf(r36);	 Catch:{ Exception -> 0x0355 }
        r0 = r38;
        r9.bee = r0;	 Catch:{ Exception -> 0x0355 }
        r0 = r9.bee;	 Catch:{ Exception -> 0x0355 }
        r38 = r0;
        r38 = r38.intValue();	 Catch:{ Exception -> 0x0355 }
        if (r38 != 0) goto L_0x01db;
    L_0x01d1:
        r38 = 1;
        r38 = java.lang.Integer.valueOf(r38);	 Catch:{ Exception -> 0x0355 }
        r0 = r38;
        r9.bee = r0;	 Catch:{ Exception -> 0x0355 }
    L_0x01db:
        r18 = com.avg.toolkit.license.OcmCampaign.getAppFirstInstallTime(r43);	 Catch:{ Exception -> 0x0355 }
        r38 = -1;
        r38 = (r18 > r38 ? 1 : (r18 == r38 ? 0 : -1));
        if (r38 == 0) goto L_0x03cf;
    L_0x01e5:
        r38 = "ais";
        r0 = r30;
        r1 = r38;
        r36 = r0.get(r1);	 Catch:{ Exception -> 0x0355 }
        r36 = (java.lang.String) r36;	 Catch:{ Exception -> 0x0355 }
        if (r36 == 0) goto L_0x03bd;
    L_0x01f3:
        r38 = java.lang.Long.valueOf(r36);	 Catch:{ Exception -> 0x0355 }
        r38 = r38.longValue();	 Catch:{ Exception -> 0x0355 }
        r40 = 86400000; // 0x5265c00 float:7.82218E-36 double:4.2687272E-316;
        r38 = r38 * r40;
        r38 = r38 + r18;
        r0 = r38;
        r9.ais = r0;	 Catch:{ Exception -> 0x0355 }
    L_0x0206:
        r38 = "aie";
        r0 = r30;
        r1 = r38;
        r36 = r0.get(r1);	 Catch:{ Exception -> 0x0355 }
        r36 = (java.lang.String) r36;	 Catch:{ Exception -> 0x0355 }
        if (r36 == 0) goto L_0x03c7;
    L_0x0214:
        r38 = "0";
        r0 = r36;
        r1 = r38;
        r38 = r0.equals(r1);	 Catch:{ Exception -> 0x0355 }
        if (r38 == 0) goto L_0x0222;
    L_0x0220:
        r36 = "1";
    L_0x0222:
        r38 = java.lang.Long.valueOf(r36);	 Catch:{ Exception -> 0x0355 }
        r38 = r38.longValue();	 Catch:{ Exception -> 0x0355 }
        r40 = 86400000; // 0x5265c00 float:7.82218E-36 double:4.2687272E-316;
        r38 = r38 * r40;
        r38 = r38 + r18;
        r0 = r38;
        r9.aie = r0;	 Catch:{ Exception -> 0x0355 }
    L_0x0235:
        r38 = "lit";
        r0 = r30;
        r1 = r38;
        r36 = r0.get(r1);	 Catch:{ Exception -> 0x0355 }
        r36 = (java.lang.String) r36;	 Catch:{ Exception -> 0x0355 }
        if (r36 == 0) goto L_0x024b;
    L_0x0243:
        r38 = java.lang.Integer.valueOf(r36);	 Catch:{ Exception -> 0x0355 }
        r0 = r38;
        r9.lit = r0;	 Catch:{ Exception -> 0x0355 }
    L_0x024b:
        r38 = "prd";
        r0 = r30;
        r1 = r38;
        r36 = r0.get(r1);	 Catch:{ Exception -> 0x0355 }
        r36 = (java.lang.String) r36;	 Catch:{ Exception -> 0x0355 }
        if (r36 == 0) goto L_0x0261;
    L_0x0259:
        r38 = java.lang.Integer.valueOf(r36);	 Catch:{ Exception -> 0x0355 }
        r0 = r38;
        r9.prd = r0;	 Catch:{ Exception -> 0x0355 }
    L_0x0261:
        r38 = "var";
        r0 = r30;
        r1 = r38;
        r36 = r0.get(r1);	 Catch:{ Exception -> 0x0355 }
        r36 = (java.lang.String) r36;	 Catch:{ Exception -> 0x0355 }
        if (r36 == 0) goto L_0x0277;
    L_0x026f:
        r38 = java.lang.Integer.valueOf(r36);	 Catch:{ Exception -> 0x0355 }
        r0 = r38;
        r9.var = r0;	 Catch:{ Exception -> 0x0355 }
    L_0x0277:
        r38 = "cyc";
        r0 = r30;
        r1 = r38;
        r36 = r0.get(r1);	 Catch:{ Exception -> 0x0355 }
        r36 = (java.lang.String) r36;	 Catch:{ Exception -> 0x0355 }
        if (r36 == 0) goto L_0x03dd;
    L_0x0285:
        r0 = r36;
        r9.cyc = r0;	 Catch:{ Exception -> 0x0355 }
    L_0x0289:
        r38 = "per";
        r0 = r30;
        r1 = r38;
        r36 = r0.get(r1);	 Catch:{ Exception -> 0x0355 }
        r36 = (java.lang.String) r36;	 Catch:{ Exception -> 0x0355 }
        if (r36 == 0) goto L_0x03e5;
    L_0x0297:
        r38 = java.lang.Integer.valueOf(r36);	 Catch:{ Exception -> 0x0355 }
        r0 = r38;
        r9.per = r0;	 Catch:{ Exception -> 0x0355 }
    L_0x029f:
        r38 = "evt";
        r0 = r30;
        r1 = r38;
        r36 = r0.get(r1);	 Catch:{ Exception -> 0x0355 }
        r36 = (java.lang.String) r36;	 Catch:{ Exception -> 0x0355 }
        if (r36 == 0) goto L_0x0575;
    L_0x02ad:
        r0 = r36;
        r9.evt = r0;	 Catch:{ Exception -> 0x0355 }
        r0 = r9.evt;	 Catch:{ Exception -> 0x0355 }
        r38 = r0;
        r39 = "#";
        r38 = r38.contains(r39);	 Catch:{ Exception -> 0x0355 }
        if (r38 == 0) goto L_0x045c;
    L_0x02bd:
        r0 = r9.evt;	 Catch:{ Exception -> 0x0355 }
        r38 = r0;
        r39 = "#";
        r5 = r38.split(r39);	 Catch:{ Exception -> 0x0355 }
        r0 = r5.length;	 Catch:{ Exception -> 0x0355 }
        r38 = r0;
        r39 = 2;
        r0 = r38;
        r1 = r39;
        if (r0 != r1) goto L_0x056d;
    L_0x02d2:
        r38 = 0;
        r38 = r5[r38];	 Catch:{ Exception -> 0x0355 }
        r0 = r38;
        r9.evt = r0;	 Catch:{ Exception -> 0x0355 }
        r38 = 1;
        r15 = r5[r38];	 Catch:{ Exception -> 0x0355 }
        r8 = java.util.Calendar.getInstance();	 Catch:{ Exception -> 0x0355 }
        r13 = new java.util.Date;	 Catch:{ Exception -> 0x0355 }
        r13.<init>();	 Catch:{ Exception -> 0x0355 }
        r38 = "-";
        r0 = r38;
        r38 = r15.startsWith(r0);	 Catch:{ Exception -> 0x0355 }
        if (r38 != 0) goto L_0x02fb;
    L_0x02f1:
        r38 = "+";
        r0 = r38;
        r38 = r15.startsWith(r0);	 Catch:{ Exception -> 0x0355 }
        if (r38 == 0) goto L_0x04b0;
    L_0x02fb:
        r38 = r15.length();	 Catch:{ Exception -> 0x0355 }
        r39 = "+beHHMM";
        r39 = r39.length();	 Catch:{ Exception -> 0x0355 }
        r0 = r38;
        r1 = r39;
        if (r0 != r1) goto L_0x04b0;
    L_0x030b:
        r38 = 0;
        r39 = 1;
        r0 = r38;
        r1 = r39;
        r34 = r15.substring(r0, r1);	 Catch:{ Exception -> 0x0355 }
        r38 = "+";
        r0 = r34;
        r1 = r38;
        r38 = r0.equals(r1);	 Catch:{ Exception -> 0x0355 }
        if (r38 == 0) goto L_0x03ed;
    L_0x0323:
        r33 = 1;
    L_0x0325:
        r38 = 1;
        r39 = 3;
        r0 = r38;
        r1 = r39;
        r7 = r15.substring(r0, r1);	 Catch:{ Exception -> 0x0355 }
        r38 = 3;
        r39 = 5;
        r0 = r38;
        r1 = r39;
        r21 = r15.substring(r0, r1);	 Catch:{ Exception -> 0x0355 }
        r38 = 5;
        r39 = r15.length();	 Catch:{ Exception -> 0x0355 }
        r0 = r38;
        r1 = r39;
        r26 = r15.substring(r0, r1);	 Catch:{ Exception -> 0x0355 }
        if (r44 != 0) goto L_0x03f1;
    L_0x034d:
        r38 = new java.lang.Exception;	 Catch:{ Exception -> 0x0355 }
        r39 = "can't get days left to end trial - avg fetures is null!";
        r38.<init>(r39);	 Catch:{ Exception -> 0x0355 }
        throw r38;	 Catch:{ Exception -> 0x0355 }
    L_0x0355:
        r16 = move-exception;
    L_0x0356:
        com.avg.toolkit.p049e.C0970a.m4322a(r16);
        r38 = com.avg.toolkit.ads.ocm.C0945b.C0944b.PARSING;
        r39 = com.avg.toolkit.ads.ocm.C0945b.C0943a.GENERAL_PARSING_ERROR;
        r0 = r43;
        r1 = r38;
        r2 = r39;
        com.avg.toolkit.ads.ocm.C0942a.m4265a(r0, r9, r1, r2);
        goto L_0x00c6;
    L_0x0368:
        r38 = new java.lang.Exception;	 Catch:{ Exception -> 0x0355 }
        r39 = "bad campaign id";
        r38.<init>(r39);	 Catch:{ Exception -> 0x0355 }
        throw r38;	 Catch:{ Exception -> 0x0355 }
    L_0x0370:
        r38 = "ad_mob";
        r0 = r36;
        r1 = r38;
        r38 = r0.equals(r1);	 Catch:{ Exception -> 0x0355 }
        if (r38 == 0) goto L_0x0385;
    L_0x037c:
        r38 = com.avg.toolkit.license.OcmCampaign.TargetType.AD_MOB;	 Catch:{ Exception -> 0x0355 }
        r0 = r38;
        r9.setTarget(r0);	 Catch:{ Exception -> 0x0355 }
        goto L_0x0133;
    L_0x0385:
        r38 = "ovr_scrn";
        r0 = r36;
        r1 = r38;
        r38 = r0.equals(r1);	 Catch:{ Exception -> 0x0355 }
        if (r38 == 0) goto L_0x039a;
    L_0x0391:
        r38 = com.avg.toolkit.license.OcmCampaign.TargetType.OVERLAY;	 Catch:{ Exception -> 0x0355 }
        r0 = r38;
        r9.setTarget(r0);	 Catch:{ Exception -> 0x0355 }
        goto L_0x0133;
    L_0x039a:
        r38 = com.avg.toolkit.license.OcmCampaign.TargetType.UNDEFINED;	 Catch:{ Exception -> 0x0355 }
        r0 = r38;
        r9.setTarget(r0);	 Catch:{ Exception -> 0x0355 }
        goto L_0x0133;
    L_0x03a3:
        r38 = new java.lang.Exception;	 Catch:{ Exception -> 0x0355 }
        r39 = "bad campaign target";
        r38.<init>(r39);	 Catch:{ Exception -> 0x0355 }
        throw r38;	 Catch:{ Exception -> 0x0355 }
    L_0x03ab:
        r38 = com.avg.toolkit.license.OcmCampaign.getCurrentTimeInMillis();	 Catch:{ Exception -> 0x0355 }
        r0 = r38;
        r9.sda = r0;	 Catch:{ Exception -> 0x0355 }
        goto L_0x017d;
    L_0x03b5:
        r38 = -2;
        r0 = r38;
        r9.eda = r0;	 Catch:{ Exception -> 0x0355 }
        goto L_0x019b;
    L_0x03bd:
        r38 = com.avg.toolkit.license.OcmCampaign.getCurrentTimeInMillis();	 Catch:{ Exception -> 0x0355 }
        r0 = r38;
        r9.ais = r0;	 Catch:{ Exception -> 0x0355 }
        goto L_0x0206;
    L_0x03c7:
        r38 = -2;
        r0 = r38;
        r9.aie = r0;	 Catch:{ Exception -> 0x0355 }
        goto L_0x0235;
    L_0x03cf:
        r38 = -1;
        r0 = r38;
        r9.ais = r0;	 Catch:{ Exception -> 0x0355 }
        r38 = -1;
        r0 = r38;
        r9.aie = r0;	 Catch:{ Exception -> 0x0355 }
        goto L_0x0235;
    L_0x03dd:
        r38 = "010000";
        r0 = r38;
        r9.cyc = r0;	 Catch:{ Exception -> 0x0355 }
        goto L_0x0289;
    L_0x03e5:
        r38 = com.avg.toolkit.license.OcmCampaign.PER_DEFUALT;	 Catch:{ Exception -> 0x0355 }
        r0 = r38;
        r9.per = r0;	 Catch:{ Exception -> 0x0355 }
        goto L_0x029f;
    L_0x03ed:
        r33 = -1;
        goto L_0x0325;
    L_0x03f1:
        r0 = r44;
        r0 = r0.f3119e;	 Catch:{ Exception -> 0x0355 }
        r38 = r0;
        r0 = r38;
        r0 = (long) r0;	 Catch:{ Exception -> 0x0355 }
        r28 = r0;
        r38 = 86400000; // 0x5265c00 float:7.82218E-36 double:4.2687272E-316;
        r38 = r38 * r28;
        r40 = com.avg.toolkit.license.OcmCampaign.getCurrentTimeInMillis();	 Catch:{ Exception -> 0x0355 }
        r38 = r38 + r40;
        r0 = r38;
        r8.setTimeInMillis(r0);	 Catch:{ Exception -> 0x0355 }
        r38 = 5;
        r39 = java.lang.Integer.valueOf(r7);	 Catch:{ Exception -> 0x0355 }
        r39 = r39.intValue();	 Catch:{ Exception -> 0x0355 }
        r39 = r39 * -1;
        r39 = r39 * r33;
        r0 = r38;
        r1 = r39;
        r8.add(r0, r1);	 Catch:{ Exception -> 0x0355 }
        r38 = 11;
        r39 = java.lang.Integer.valueOf(r21);	 Catch:{ Exception -> 0x0355 }
        r39 = r39.intValue();	 Catch:{ Exception -> 0x0355 }
        r0 = r38;
        r1 = r39;
        r8.set(r0, r1);	 Catch:{ Exception -> 0x0355 }
        r38 = 12;
        r39 = java.lang.Integer.valueOf(r26);	 Catch:{ Exception -> 0x0355 }
        r39 = r39.intValue();	 Catch:{ Exception -> 0x0355 }
        r0 = r38;
        r1 = r39;
        r8.set(r0, r1);	 Catch:{ Exception -> 0x0355 }
        r38 = 13;
        r39 = 0;
        r0 = r38;
        r1 = r39;
        r8.set(r0, r1);	 Catch:{ Exception -> 0x0355 }
        r38 = r8.getTimeInMillis();	 Catch:{ Exception -> 0x0355 }
        r0 = r38;
        r9.dden_time = r0;	 Catch:{ Exception -> 0x0355 }
        r38 = 1;
        r0 = r38;
        r9.isDdeEvent = r0;	 Catch:{ Exception -> 0x0355 }
    L_0x045c:
        r38 = "ovl_evt";
        r0 = r30;
        r1 = r38;
        r36 = r0.get(r1);	 Catch:{ Exception -> 0x0355 }
        r36 = (java.lang.String) r36;	 Catch:{ Exception -> 0x0355 }
        if (r36 == 0) goto L_0x057d;
    L_0x046a:
        r38 = ",";
        r0 = r36;
        r1 = r38;
        r38 = r0.split(r1);	 Catch:{ Exception -> 0x0355 }
        r0 = r38;
        r9.ovl_evt = r0;	 Catch:{ Exception -> 0x0355 }
    L_0x0478:
        r38 = "overlay_uri";
        r0 = r30;
        r1 = r38;
        r36 = r0.get(r1);	 Catch:{ Exception -> 0x0355 }
        r36 = (java.lang.String) r36;	 Catch:{ Exception -> 0x0355 }
        if (r36 == 0) goto L_0x0591;
    L_0x0486:
        r0 = r36;
        r9.overlay_uri = r0;	 Catch:{ Exception -> 0x0355 }
    L_0x048a:
        r0 = r9.isDdeEvent;	 Catch:{ Exception -> 0x0355 }
        r38 = r0;
        if (r38 == 0) goto L_0x0624;
    L_0x0490:
        r38 = "dden_text";
        r0 = r30;
        r1 = r38;
        r36 = r0.get(r1);	 Catch:{ Exception -> 0x0355 }
        r36 = (java.lang.String) r36;	 Catch:{ Exception -> 0x0355 }
        if (r36 == 0) goto L_0x05d4;
    L_0x049e:
        r38 = r36.getBytes();	 Catch:{ Exception -> 0x0355 }
        r38 = p000a.p001a.p002a.p003a.p004a.C0000a.m2a(r38);	 Catch:{ Exception -> 0x0355 }
        if (r38 != 0) goto L_0x05a5;
    L_0x04a8:
        r38 = new java.lang.Exception;	 Catch:{ Exception -> 0x0355 }
        r39 = "bad dden_text, invalid Base64 string";
        r38.<init>(r39);	 Catch:{ Exception -> 0x0355 }
        throw r38;	 Catch:{ Exception -> 0x0355 }
    L_0x04b0:
        r38 = r15.length();	 Catch:{ Exception -> 0x0355 }
        r39 = "YYYYMMDDHHMM";
        r39 = r39.length();	 Catch:{ Exception -> 0x0355 }
        r0 = r38;
        r1 = r39;
        if (r0 != r1) goto L_0x04dc;
    L_0x04c0:
        r14 = new java.text.SimpleDateFormat;	 Catch:{ Exception -> 0x0355 }
        r38 = "yyyyMMddHHmm";
        r0 = r38;
        r14.<init>(r0);	 Catch:{ Exception -> 0x0355 }
        r13 = r14.parse(r15);	 Catch:{ Exception -> 0x0355 }
        r38 = r13.getTime();	 Catch:{ Exception -> 0x0355 }
        r0 = r38;
        r9.dden_time = r0;	 Catch:{ Exception -> 0x0355 }
        r38 = 1;
        r0 = r38;
        r9.isDdeEvent = r0;	 Catch:{ Exception -> 0x0355 }
        goto L_0x045c;
    L_0x04dc:
        r38 = r15.length();	 Catch:{ Exception -> 0x0355 }
        r39 = "aiHHMM";
        r39 = r39.length();	 Catch:{ Exception -> 0x0355 }
        r0 = r38;
        r1 = r39;
        if (r0 != r1) goto L_0x0565;
    L_0x04ec:
        r38 = 0;
        r39 = 2;
        r0 = r38;
        r1 = r39;
        r4 = r15.substring(r0, r1);	 Catch:{ Exception -> 0x0355 }
        r38 = 2;
        r39 = 4;
        r0 = r38;
        r1 = r39;
        r21 = r15.substring(r0, r1);	 Catch:{ Exception -> 0x0355 }
        r38 = 4;
        r39 = r15.length();	 Catch:{ Exception -> 0x0355 }
        r0 = r38;
        r1 = r39;
        r26 = r15.substring(r0, r1);	 Catch:{ Exception -> 0x0355 }
        r0 = r18;
        r8.setTimeInMillis(r0);	 Catch:{ Exception -> 0x0355 }
        r38 = 5;
        r39 = java.lang.Integer.valueOf(r4);	 Catch:{ Exception -> 0x0355 }
        r39 = r39.intValue();	 Catch:{ Exception -> 0x0355 }
        r0 = r38;
        r1 = r39;
        r8.add(r0, r1);	 Catch:{ Exception -> 0x0355 }
        r38 = 11;
        r39 = java.lang.Integer.valueOf(r21);	 Catch:{ Exception -> 0x0355 }
        r39 = r39.intValue();	 Catch:{ Exception -> 0x0355 }
        r0 = r38;
        r1 = r39;
        r8.set(r0, r1);	 Catch:{ Exception -> 0x0355 }
        r38 = 12;
        r39 = java.lang.Integer.valueOf(r26);	 Catch:{ Exception -> 0x0355 }
        r39 = r39.intValue();	 Catch:{ Exception -> 0x0355 }
        r0 = r38;
        r1 = r39;
        r8.set(r0, r1);	 Catch:{ Exception -> 0x0355 }
        r38 = 13;
        r39 = 0;
        r0 = r38;
        r1 = r39;
        r8.set(r0, r1);	 Catch:{ Exception -> 0x0355 }
        r38 = r8.getTimeInMillis();	 Catch:{ Exception -> 0x0355 }
        r0 = r38;
        r9.dden_time = r0;	 Catch:{ Exception -> 0x0355 }
        r38 = 1;
        r0 = r38;
        r9.isDdeEvent = r0;	 Catch:{ Exception -> 0x0355 }
        goto L_0x045c;
    L_0x0565:
        r38 = new java.lang.Exception;	 Catch:{ Exception -> 0x0355 }
        r39 = "bad DDE event, value not equals to any known format";
        r38.<init>(r39);	 Catch:{ Exception -> 0x0355 }
        throw r38;	 Catch:{ Exception -> 0x0355 }
    L_0x056d:
        r38 = new java.lang.Exception;	 Catch:{ Exception -> 0x0355 }
        r39 = "bad DDE event, size of variables is not OK";
        r38.<init>(r39);	 Catch:{ Exception -> 0x0355 }
        throw r38;	 Catch:{ Exception -> 0x0355 }
    L_0x0575:
        r38 = new java.lang.Exception;	 Catch:{ Exception -> 0x0355 }
        r39 = "bad campaign evt";
        r38.<init>(r39);	 Catch:{ Exception -> 0x0355 }
        throw r38;	 Catch:{ Exception -> 0x0355 }
    L_0x057d:
        r38 = r9.getTarget();	 Catch:{ Exception -> 0x0355 }
        r39 = com.avg.toolkit.license.OcmCampaign.TargetType.OVERLAY;	 Catch:{ Exception -> 0x0355 }
        r0 = r38;
        r1 = r39;
        if (r0 != r1) goto L_0x0478;
    L_0x0589:
        r38 = new java.lang.Exception;	 Catch:{ Exception -> 0x0355 }
        r39 = "bad campaign ovl_evt";
        r38.<init>(r39);	 Catch:{ Exception -> 0x0355 }
        throw r38;	 Catch:{ Exception -> 0x0355 }
    L_0x0591:
        r38 = r9.getTarget();	 Catch:{ Exception -> 0x0355 }
        r39 = com.avg.toolkit.license.OcmCampaign.TargetType.NOTIFICATION;	 Catch:{ Exception -> 0x0355 }
        r0 = r38;
        r1 = r39;
        if (r0 == r1) goto L_0x048a;
    L_0x059d:
        r38 = new java.lang.Exception;	 Catch:{ Exception -> 0x0355 }
        r39 = "bad campaign uri";
        r38.<init>(r39);	 Catch:{ Exception -> 0x0355 }
        throw r38;	 Catch:{ Exception -> 0x0355 }
    L_0x05a5:
        r37 = new java.lang.String;	 Catch:{ Exception -> 0x0355 }
        r38 = p000a.p001a.p002a.p003a.p004a.C0000a.m7b(r36);	 Catch:{ Exception -> 0x0355 }
        r39 = "UTF-8";
        r37.<init>(r38, r39);	 Catch:{ Exception -> 0x0355 }
        r0 = r37;
        r9.dden_text = r0;	 Catch:{ Exception -> 0x0355 }
        r38 = "dden_title";
        r0 = r30;
        r1 = r38;
        r36 = r0.get(r1);	 Catch:{ Exception -> 0x0355 }
        r36 = (java.lang.String) r36;	 Catch:{ Exception -> 0x0355 }
        if (r36 == 0) goto L_0x060b;
    L_0x05c2:
        r38 = r36.getBytes();	 Catch:{ Exception -> 0x0355 }
        r38 = p000a.p001a.p002a.p003a.p004a.C0000a.m2a(r38);	 Catch:{ Exception -> 0x0355 }
        if (r38 != 0) goto L_0x05dc;
    L_0x05cc:
        r38 = new java.lang.Exception;	 Catch:{ Exception -> 0x0355 }
        r39 = "bad dden_title, invalid Base64 string";
        r38.<init>(r39);	 Catch:{ Exception -> 0x0355 }
        throw r38;	 Catch:{ Exception -> 0x0355 }
    L_0x05d4:
        r38 = new java.lang.Exception;	 Catch:{ Exception -> 0x0355 }
        r39 = "bad dden_text, mandatory when using dde events";
        r38.<init>(r39);	 Catch:{ Exception -> 0x0355 }
        throw r38;	 Catch:{ Exception -> 0x0355 }
    L_0x05dc:
        r37 = new java.lang.String;	 Catch:{ Exception -> 0x0355 }
        r38 = p000a.p001a.p002a.p003a.p004a.C0000a.m7b(r36);	 Catch:{ Exception -> 0x0355 }
        r39 = "UTF-8";
        r37.<init>(r38, r39);	 Catch:{ Exception -> 0x0355 }
        r0 = r37;
        r9.dden_title = r0;	 Catch:{ Exception -> 0x0355 }
        r38 = "dden_ticker";
        r0 = r30;
        r1 = r38;
        r36 = r0.get(r1);	 Catch:{ Exception -> 0x0355 }
        r36 = (java.lang.String) r36;	 Catch:{ Exception -> 0x0355 }
        if (r36 == 0) goto L_0x0624;
    L_0x05f9:
        r38 = r36.getBytes();	 Catch:{ Exception -> 0x0355 }
        r38 = p000a.p001a.p002a.p003a.p004a.C0000a.m2a(r38);	 Catch:{ Exception -> 0x0355 }
        if (r38 != 0) goto L_0x0613;
    L_0x0603:
        r38 = new java.lang.Exception;	 Catch:{ Exception -> 0x0355 }
        r39 = "bad dden_ticker, invalid Base64 string";
        r38.<init>(r39);	 Catch:{ Exception -> 0x0355 }
        throw r38;	 Catch:{ Exception -> 0x0355 }
    L_0x060b:
        r38 = new java.lang.Exception;	 Catch:{ Exception -> 0x0355 }
        r39 = "bad dden_title, mandatory when using dde events";
        r38.<init>(r39);	 Catch:{ Exception -> 0x0355 }
        throw r38;	 Catch:{ Exception -> 0x0355 }
    L_0x0613:
        r37 = new java.lang.String;	 Catch:{ Exception -> 0x0355 }
        r38 = p000a.p001a.p002a.p003a.p004a.C0000a.m7b(r36);	 Catch:{ Exception -> 0x0355 }
        r39 = "UTF-8";
        r37.<init>(r38, r39);	 Catch:{ Exception -> 0x0355 }
        r0 = r37;
        r9.dden_ticker = r0;	 Catch:{ Exception -> 0x0355 }
        r36 = r37;
    L_0x0624:
        r38 = "cdtd";
        r0 = r30;
        r1 = r38;
        r36 = r0.get(r1);	 Catch:{ Exception -> 0x0355 }
        r36 = (java.lang.String) r36;	 Catch:{ Exception -> 0x0355 }
        if (r36 == 0) goto L_0x064c;
    L_0x0632:
        r38 = java.lang.Integer.valueOf(r36);	 Catch:{ Exception -> 0x0355 }
        r12 = r38.intValue();	 Catch:{ Exception -> 0x0355 }
        r38 = com.avg.toolkit.license.OcmCampaign.CDTD_MIN_VALUE;	 Catch:{ Exception -> 0x0355 }
        r38 = r38.intValue();	 Catch:{ Exception -> 0x0355 }
        r0 = r38;
        if (r12 < r0) goto L_0x064c;
    L_0x0644:
        r38 = java.lang.Integer.valueOf(r36);	 Catch:{ Exception -> 0x0355 }
        r0 = r38;
        r9.cdtd = r0;	 Catch:{ Exception -> 0x0355 }
    L_0x064c:
        r38 = "gen_tm_btw_ovrlys";
        r0 = r30;
        r1 = r38;
        r36 = r0.get(r1);	 Catch:{ Exception -> 0x0355 }
        r36 = (java.lang.String) r36;	 Catch:{ Exception -> 0x0355 }
        if (r36 == 0) goto L_0x0674;
    L_0x065a:
        r38 = r24.intValue();	 Catch:{ Exception -> 0x0355 }
        r0 = r9.id;	 Catch:{ Exception -> 0x0355 }
        r39 = r0;
        r0 = r38;
        r1 = r39;
        if (r0 >= r1) goto L_0x0674;
    L_0x0668:
        r23 = java.lang.Integer.valueOf(r36);	 Catch:{ Exception -> 0x0355 }
        r0 = r9.id;	 Catch:{ Exception -> 0x0355 }
        r38 = r0;
        r24 = java.lang.Integer.valueOf(r38);	 Catch:{ Exception -> 0x0355 }
    L_0x0674:
        r38 = "analytics";
        r0 = r30;
        r1 = r38;
        r38 = r0.get(r1);	 Catch:{ Exception -> 0x0355 }
        r38 = (java.lang.String) r38;	 Catch:{ Exception -> 0x0355 }
        r0 = r38;
        r9.analytics = r0;	 Catch:{ Exception -> 0x0355 }
        r38 = -2;
        r0 = r38;
        r9.lastAppearence = r0;	 Catch:{ Exception -> 0x0355 }
        r38 = com.avg.toolkit.license.OcmCampaign.CampaignState.ACTIVE;	 Catch:{ Exception -> 0x0355 }
        r0 = r38;
        r9.campaignState = r0;	 Catch:{ Exception -> 0x0355 }
        r38 = com.avg.toolkit.license.OcmCampaign.getCurrentTimeInMillis();	 Catch:{ Exception -> 0x0355 }
        r0 = r38;
        r9.cycleStateStartTimeStamp = r0;	 Catch:{ Exception -> 0x0355 }
        r0 = r42;
        r0 = r0.f3155d;	 Catch:{ Exception -> 0x0355 }
        r38 = r0;
        r0 = r9.id;	 Catch:{ Exception -> 0x0355 }
        r39 = r0;
        r39 = java.lang.Integer.valueOf(r39);	 Catch:{ Exception -> 0x0355 }
        r17 = r38.get(r39);	 Catch:{ Exception -> 0x0355 }
        r17 = (com.avg.toolkit.license.OcmCampaign) r17;	 Catch:{ Exception -> 0x0355 }
        r0 = r9.id;	 Catch:{ Exception -> 0x0355 }
        r38 = r0;
        r38 = java.lang.Integer.valueOf(r38);	 Catch:{ Exception -> 0x0355 }
        if (r17 != 0) goto L_0x06b8;
    L_0x06b6:
        r17 = r9;
    L_0x06b8:
        r0 = r27;
        r1 = r38;
        r2 = r17;
        r0.put(r1, r2);	 Catch:{ Exception -> 0x0355 }
        goto L_0x00c6;
    L_0x06c3:
        r38 = r27.size();
        if (r38 <= 0) goto L_0x0027;
    L_0x06c9:
        r0 = r42;
        r0 = r0.f3155d;
        r38 = r0;
        r38.clear();
        r0 = r42;
        r0 = r0.f3155d;
        r38 = r0;
        r0 = r38;
        r1 = r27;
        r0.putAll(r1);
        r35 = 1;
        goto L_0x0027;
    L_0x06e3:
        r16 = move-exception;
        r9 = r10;
        goto L_0x0356;
    L_0x06e7:
        r9 = r10;
        goto L_0x00c6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avg.toolkit.license.d.a(android.content.Context, com.avg.toolkit.license.a, java.lang.String):boolean");
    }

    private long m4461a(String strTime, boolean isEndOfDate) {
        String DATE_FORMAT = "yyyyMMdd";
        String TIME_FORMAT = "HHmm";
        String END_OF_DAY = "2359";
        long retMillis = 0;
        Calendar calendar = Calendar.getInstance();
        String dateFormat = "yyyyMMdd";
        if (strTime.length() == "yyyyMMdd".length() || strTime.length() == "yyyyMMdd".length() + "HHmm".length()) {
            if (strTime.length() > "yyyyMMdd".length()) {
                dateFormat = dateFormat + "HHmm";
            } else if (isEndOfDate) {
                dateFormat = dateFormat + "HHmm";
                strTime = strTime + "2359";
            }
            try {
                calendar.setTime(new SimpleDateFormat(dateFormat, Locale.getDefault()).parse(strTime));
                retMillis = calendar.getTimeInMillis();
            } catch (Exception e) {
                C0970a.m4322a(e);
            }
        }
        return retMillis;
    }

    private boolean m4467a(Context context, HttpURLConnection connection, C1020c licensePrefs, boolean useOcm) {
        connection.setRequestProperty("x-avg-mkid", this.f3155d.getAnalyticsString());
        connection.setRequestProperty("x-avg-ocm", useOcm ? this.f3154c : this.f3155d.ocmId);
        return true;
    }

    private void m4466a(Context context, Map headers, C1020c licensePrefs) {
        String header;
        List tempHList = (List) headers.get("x-avg-newocm");
        if (tempHList != null) {
            header = (String) tempHList.get(0);
        } else {
            header = null;
        }
        if (header != null) {
            this.f3154c = header;
        }
        tempHList = (List) headers.get("x-avg-newmkid");
        if (tempHList != null) {
            header = (String) tempHList.get(0);
        } else {
            header = null;
        }
        if (header == null) {
            return;
        }
        if (this.f3155d.setAnalyticsFromString(header)) {
            OcmCampaigns.writeCampaignsToStorage(context, this.f3155d, true);
            return;
        }
        throw new C1022a("error in response headers", false);
    }

    @SuppressLint({"NewApi"})
    private static long m4460a(Context context) {
        try {
            if (VERSION.SDK_INT > 8) {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).firstInstallTime;
            }
            return 0;
        } catch (Exception e) {
            C0970a.m4322a(e);
            return 0;
        }
    }
}
