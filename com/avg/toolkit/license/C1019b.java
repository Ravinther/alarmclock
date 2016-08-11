package com.avg.toolkit.license;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.avg.toolkit.C0647c;
import com.avg.toolkit.ITKSvc;
import com.avg.toolkit.gcm.C0985a;
import com.avg.toolkit.license.p053a.C1010h.C1004d;
import com.avg.toolkit.license.p053a.C1010h.C1005e;
import com.avg.toolkit.p049e.C0970a;
import com.avg.toolkit.recurringTasks.C1031b;
import com.google.android.gms.location.LocationStatusCodes;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;
import junit.framework.Assert;
import p000a.p001a.p002a.p003a.p004a.C0000a;

/* renamed from: com.avg.toolkit.license.b */
public class C1019b implements C0647c {
    private static C1017a f3129d;
    private Context f3130a;
    private String f3131b;
    private String f3132c;
    private C1020c f3133e;
    private C1031b f3134f;
    private Runnable f3135g;
    private Runnable f3136h;
    private String f3137i;
    private int f3138j;

    /* renamed from: com.avg.toolkit.license.b.1 */
    static /* synthetic */ class C10181 {
        static final /* synthetic */ int[] f3127a;
        static final /* synthetic */ int[] f3128b;

        static {
            f3128b = new int[C1004d.values().length];
            try {
                f3128b[C1004d.LIC_EX_VALIDITY_PERIOD.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f3128b[C1004d.LIC_EX_FIXED_DATE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f3128b[C1004d.LIC_EX_UNDEFINED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            f3127a = new int[C1005e.values().length];
            try {
                f3127a[C1005e.LIC_LT_FREE.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f3127a[C1005e.LIC_LT_TRIAL.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f3127a[C1005e.LIC_LT_FULL.ordinal()] = 3;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    public C1019b(Context context, Properties properties, C0985a gcmManager) {
        this.f3130a = context;
        String base64Lic = properties.getProperty("prElement");
        Assert.assertNotNull("prElement was not found in properties file", base64Lic);
        this.f3131b = base64Lic;
        base64Lic = properties.getProperty("scElement");
        Assert.assertNotNull("scElement was not found in properties file", base64Lic);
        this.f3132c = base64Lic;
        this.f3133e = new C1020c(this.f3130a);
        String lsProductName = properties.getProperty("licenseServerProdName");
        Assert.assertNotNull("licenseServerProdName was not found in properties file", lsProductName);
        this.f3137i = lsProductName;
        int currentVersion = 0;
        try {
            currentVersion = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception e) {
            C0970a.m4322a(e);
        }
        int lastUsedVersion = this.f3133e.m4459j();
        if (currentVersion <= 0 || lastUsedVersion <= 0 || lastUsedVersion < currentVersion) {
            this.f3133e.m4451c(currentVersion);
            this.f3138j = this.f3133e.m4458i();
        } else {
            this.f3133e.m4451c(currentVersion);
            this.f3138j = this.f3133e.m4458i();
        }
        if (this.f3138j == 0 && this.f3133e.m4453d().length() != 0) {
            this.f3138j = -1;
            this.f3133e.m4448b(-1);
        }
        if (this.f3138j == 0) {
            String vendorId = properties.getProperty("vendorId");
            Assert.assertNotNull("vendorId was not found in properties file", vendorId);
            this.f3138j = Integer.parseInt(vendorId);
            this.f3133e.m4448b(this.f3138j);
        }
        gcmManager.m4380a(5000, this);
    }

    public static C1017a m4431a() {
        return f3129d;
    }

    private boolean m4436f() {
        try {
            String key = m4434b(this.f3132c);
            this.f3133e.m4444a(key);
            return m4432a(key, true);
        } catch (Exception e) {
            C0970a.m4322a(e);
            return false;
        }
    }

    public boolean m4439b() {
        boolean isNewLicense = false;
        String key = this.f3133e.m4453d();
        if (key.length() == 0) {
            try {
                key = m4434b(this.f3131b);
                this.f3133e.m4444a(key);
                isNewLicense = true;
            } catch (Exception e) {
                C0970a.m4322a(e);
            }
        }
        if (!(TextUtils.isEmpty(key) || m4432a(key, isNewLicense))) {
            m4436f();
        }
        return isNewLicense;
    }

    public boolean m4440c() {
        return this.f3133e.m4445a();
    }

    public void m4441d() {
        this.f3133e.m4450c();
    }

    public boolean m4438a(String license) {
        if (license.equals(this.f3133e.m4453d())) {
            this.f3133e.m4452c("");
            return false;
        } else if (m4432a(license, true)) {
            this.f3133e.m4444a(license);
            return true;
        } else {
            this.f3133e.m4452c("");
            return false;
        }
    }

    private String m4434b(String base64Str) {
        try {
            return new String(m4433a(C0000a.m7b(base64Str)), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    private byte[] m4433a(byte[] xorthis) {
        byte[] xorme = new byte[]{(byte) 13, (byte) 9, (byte) 7};
        for (int i = 0; i < xorthis.length; i++) {
            xorthis[i] = (byte) (xorthis[i] ^ xorme[i % xorme.length]);
        }
        return xorthis;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m4432a(java.lang.String r35, boolean r36) {
        /*
        r34 = this;
        r5 = android.text.TextUtils.isEmpty(r35);
        if (r5 == 0) goto L_0x0008;
    L_0x0006:
        r5 = 0;
    L_0x0007:
        return r5;
    L_0x0008:
        r35 = r35.toUpperCase();
        r22 = -1;
        r10 = com.avg.toolkit.license.C1017a.C0987b.FREE;
        r18 = new com.avg.toolkit.license.a.l;
        r18.<init>();
        r19 = new com.avg.toolkit.license.a.g;
        r19.<init>();
        r27 = new com.avg.toolkit.license.a.f;
        r27.<init>();
        r0 = r27;
        r1 = r18;
        r2 = r35;
        r3 = r19;
        r0.m4414a(r1, r2, r3);	 Catch:{ a -> 0x0042, Exception -> 0x0064 }
        r0 = r18;
        r5 = r0.f3107c;	 Catch:{ a -> 0x0042, Exception -> 0x0064 }
        r7 = com.avg.toolkit.license.p053a.C1010h.C1009i.LACV_VALID;	 Catch:{ a -> 0x0042, Exception -> 0x0064 }
        if (r5 == r7) goto L_0x004c;
    L_0x0032:
        r0 = r18;
        r5 = r0.f3107c;	 Catch:{ a -> 0x0042, Exception -> 0x0064 }
        r7 = com.avg.toolkit.license.p053a.C1010h.C1009i.LACV_GENERATED;	 Catch:{ a -> 0x0042, Exception -> 0x0064 }
        if (r5 == r7) goto L_0x004c;
    L_0x003a:
        r5 = new com.avg.toolkit.license.a.a;	 Catch:{ a -> 0x0042, Exception -> 0x0064 }
        r12 = 999; // 0x3e7 float:1.4E-42 double:4.936E-321;
        r5.<init>(r12);	 Catch:{ a -> 0x0042, Exception -> 0x0064 }
        throw r5;	 Catch:{ a -> 0x0042, Exception -> 0x0064 }
    L_0x0042:
        r23 = move-exception;
        r8 = r22;
    L_0x0045:
        r5 = "invalid license";
        com.avg.toolkit.p049e.C0970a.m4325b(r5);
        r5 = 0;
        goto L_0x0007;
    L_0x004c:
        r0 = r18;
        r5 = r0.f3108d;	 Catch:{ a -> 0x0042, Exception -> 0x0064 }
        r7 = com.avg.toolkit.license.p053a.C1010h.C1009i.LACV_VALID;	 Catch:{ a -> 0x0042, Exception -> 0x0064 }
        if (r5 == r7) goto L_0x006c;
    L_0x0054:
        r0 = r18;
        r5 = r0.f3108d;	 Catch:{ a -> 0x0042, Exception -> 0x0064 }
        r7 = com.avg.toolkit.license.p053a.C1010h.C1009i.LACV_GENERATED;	 Catch:{ a -> 0x0042, Exception -> 0x0064 }
        if (r5 == r7) goto L_0x006c;
    L_0x005c:
        r5 = new com.avg.toolkit.license.a.a;	 Catch:{ a -> 0x0042, Exception -> 0x0064 }
        r12 = 999; // 0x3e7 float:1.4E-42 double:4.936E-321;
        r5.<init>(r12);	 Catch:{ a -> 0x0042, Exception -> 0x0064 }
        throw r5;	 Catch:{ a -> 0x0042, Exception -> 0x0064 }
    L_0x0064:
        r23 = move-exception;
        r8 = r22;
    L_0x0067:
        com.avg.toolkit.p049e.C0970a.m4322a(r23);
        r5 = 0;
        goto L_0x0007;
    L_0x006c:
        r5 = com.avg.toolkit.license.C1019b.C10181.f3127a;	 Catch:{ a -> 0x0042, Exception -> 0x0064 }
        r0 = r18;
        r7 = r0.f3106b;	 Catch:{ a -> 0x0042, Exception -> 0x0064 }
        r7 = r7.f3080d;	 Catch:{ a -> 0x0042, Exception -> 0x0064 }
        r7 = r7.ordinal();	 Catch:{ a -> 0x0042, Exception -> 0x0064 }
        r5 = r5[r7];	 Catch:{ a -> 0x0042, Exception -> 0x0064 }
        switch(r5) {
            case 1: goto L_0x0085;
            case 2: goto L_0x00a8;
            case 3: goto L_0x00ad;
            default: goto L_0x007d;
        };	 Catch:{ a -> 0x0042, Exception -> 0x0064 }
    L_0x007d:
        r5 = new com.avg.toolkit.license.a.a;	 Catch:{ a -> 0x0042, Exception -> 0x0064 }
        r12 = 999; // 0x3e7 float:1.4E-42 double:4.936E-321;
        r5.<init>(r12);	 Catch:{ a -> 0x0042, Exception -> 0x0064 }
        throw r5;	 Catch:{ a -> 0x0042, Exception -> 0x0064 }
    L_0x0085:
        r10 = com.avg.toolkit.license.C1017a.C0987b.FREE;	 Catch:{ a -> 0x0042, Exception -> 0x0064 }
        r29 = r10;
    L_0x0089:
        r5 = com.avg.toolkit.license.C1019b.C10181.f3128b;	 Catch:{ a -> 0x00a2, Exception -> 0x01e9 }
        r0 = r18;
        r7 = r0.f3106b;	 Catch:{ a -> 0x00a2, Exception -> 0x01e9 }
        r7 = r7.f3084h;	 Catch:{ a -> 0x00a2, Exception -> 0x01e9 }
        r7 = r7.ordinal();	 Catch:{ a -> 0x00a2, Exception -> 0x01e9 }
        r5 = r5[r7];	 Catch:{ a -> 0x00a2, Exception -> 0x01e9 }
        switch(r5) {
            case 1: goto L_0x00b2;
            case 2: goto L_0x00c5;
            case 3: goto L_0x01e4;
            default: goto L_0x009a;
        };	 Catch:{ a -> 0x00a2, Exception -> 0x01e9 }
    L_0x009a:
        r5 = new com.avg.toolkit.license.a.a;	 Catch:{ a -> 0x00a2, Exception -> 0x01e9 }
        r12 = 999; // 0x3e7 float:1.4E-42 double:4.936E-321;
        r5.<init>(r12);	 Catch:{ a -> 0x00a2, Exception -> 0x01e9 }
        throw r5;	 Catch:{ a -> 0x00a2, Exception -> 0x01e9 }
    L_0x00a2:
        r23 = move-exception;
        r10 = r29;
        r8 = r22;
        goto L_0x0045;
    L_0x00a8:
        r10 = com.avg.toolkit.license.C1017a.C0987b.TRIAL;	 Catch:{ a -> 0x0042, Exception -> 0x0064 }
        r29 = r10;
        goto L_0x0089;
    L_0x00ad:
        r10 = com.avg.toolkit.license.C1017a.C0987b.PRO;	 Catch:{ a -> 0x0042, Exception -> 0x0064 }
        r29 = r10;
        goto L_0x0089;
    L_0x00b2:
        r0 = r18;
        r5 = r0.f3106b;	 Catch:{ a -> 0x00a2, Exception -> 0x01e9 }
        r8 = r5.f3085i;	 Catch:{ a -> 0x00a2, Exception -> 0x01e9 }
        if (r36 != 0) goto L_0x0150;
    L_0x00ba:
        r12 = r34.m4442e();	 Catch:{ a -> 0x01f5, Exception -> 0x01f0 }
        r5 = (int) r12;
        r8 = r8 - r5;
        if (r8 >= 0) goto L_0x0150;
    L_0x00c2:
        r5 = 0;
        goto L_0x0007;
    L_0x00c5:
        r20 = java.lang.System.currentTimeMillis();	 Catch:{ a -> 0x00a2, Exception -> 0x01e9 }
        r30 = new com.avg.toolkit.license.a.j;	 Catch:{ a -> 0x00a2, Exception -> 0x01e9 }
        r30.<init>();	 Catch:{ a -> 0x00a2, Exception -> 0x01e9 }
        r0 = r18;
        r5 = r0.f3106b;	 Catch:{ a -> 0x00a2, Exception -> 0x01e9 }
        r12 = r5.f3086j;	 Catch:{ a -> 0x00a2, Exception -> 0x01e9 }
        r0 = r30;
        r26 = r0.m4423a(r12);	 Catch:{ a -> 0x00a2, Exception -> 0x01e9 }
        r4 = new java.util.GregorianCalendar;	 Catch:{ a -> 0x00a2, Exception -> 0x01e9 }
        r5 = "GMT";
        r5 = java.util.TimeZone.getTimeZone(r5);	 Catch:{ a -> 0x00a2, Exception -> 0x01e9 }
        r4.<init>(r5);	 Catch:{ a -> 0x00a2, Exception -> 0x01e9 }
        r0 = r30;
        r12 = r0.f3098a;	 Catch:{ a -> 0x00a2, Exception -> 0x01e9 }
        r5 = (int) r12;	 Catch:{ a -> 0x00a2, Exception -> 0x01e9 }
        r0 = r30;
        r12 = r0.f3099b;	 Catch:{ a -> 0x00a2, Exception -> 0x01e9 }
        r32 = 1;
        r12 = r12 - r32;
        r6 = (int) r12;	 Catch:{ a -> 0x00a2, Exception -> 0x01e9 }
        r0 = r30;
        r12 = r0.f3100c;	 Catch:{ a -> 0x00a2, Exception -> 0x01e9 }
        r7 = (int) r12;	 Catch:{ a -> 0x00a2, Exception -> 0x01e9 }
        r8 = 9;
        r9 = 0;
        r10 = 0;
        r4.set(r5, r6, r7, r8, r9, r10);	 Catch:{ a -> 0x00a2, Exception -> 0x01e9 }
        r5 = r4.getTime();	 Catch:{ a -> 0x00a2, Exception -> 0x01e9 }
        r24 = r5.getTime();	 Catch:{ a -> 0x00a2, Exception -> 0x01e9 }
        r14 = 132605856000000000; // 0x1d71c52ce044000 float:-5.546967E8 double:8.627327245065053E-300;
        r16 = 131460192000000000; // 0x1d30a591e43c000 float:1.0362919E-20 double:7.107893378902279E-300;
        r0 = r18;
        r5 = r0.f3106b;	 Catch:{ a -> 0x00a2, Exception -> 0x01e9 }
        r12 = r5.f3086j;	 Catch:{ a -> 0x00a2, Exception -> 0x01e9 }
        r32 = 132606720000000000; // 0x1d71d1bf86e0000 float:-1.9308854E34 double:8.628473122792174E-300;
        r5 = (r12 > r32 ? 1 : (r12 == r32 ? 0 : -1));
        if (r5 >= 0) goto L_0x012f;
    L_0x0120:
        r0 = r18;
        r5 = r0.f3106b;	 Catch:{ a -> 0x00a2, Exception -> 0x01e9 }
        r12 = r5.f3086j;	 Catch:{ a -> 0x00a2, Exception -> 0x01e9 }
        r32 = 132604992000000000; // 0x1d71b89a39a8000 float:-1.6750924E-17 double:8.626181367337932E-300;
        r5 = (r12 > r32 ? 1 : (r12 == r32 ? 0 : -1));
        if (r5 > 0) goto L_0x014d;
    L_0x012f:
        r0 = r18;
        r5 = r0.f3106b;	 Catch:{ a -> 0x00a2, Exception -> 0x01e9 }
        r12 = r5.f3086j;	 Catch:{ a -> 0x00a2, Exception -> 0x01e9 }
        r32 = 131461056000000000; // 0x1d30b2248ad8000 float:355328.0 double:7.1090392566294E-300;
        r5 = (r12 > r32 ? 1 : (r12 == r32 ? 0 : -1));
        if (r5 >= 0) goto L_0x01d7;
    L_0x013e:
        r0 = r18;
        r5 = r0.f3106b;	 Catch:{ a -> 0x00a2, Exception -> 0x01e9 }
        r12 = r5.f3086j;	 Catch:{ a -> 0x00a2, Exception -> 0x01e9 }
        r32 = 131459328000000000; // 0x1d3098ff3da0000 float:-3.454348E31 double:7.106747501175158E-300;
        r5 = (r12 > r32 ? 1 : (r12 == r32 ? 0 : -1));
        if (r5 <= 0) goto L_0x01d7;
    L_0x014d:
        r8 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
    L_0x0150:
        r0 = r34;
        r5 = r0.f3138j;	 Catch:{ a -> 0x01f5, Exception -> 0x01f0 }
        r7 = -1;
        if (r5 != r7) goto L_0x016c;
    L_0x0157:
        r0 = r18;
        r5 = r0.f3106b;	 Catch:{ a -> 0x01f5, Exception -> 0x01f0 }
        r5 = r5.f3089m;	 Catch:{ a -> 0x01f5, Exception -> 0x01f0 }
        r0 = r34;
        r0.f3138j = r5;	 Catch:{ a -> 0x01f5, Exception -> 0x01f0 }
        r0 = r34;
        r5 = r0.f3133e;	 Catch:{ a -> 0x01f5, Exception -> 0x01f0 }
        r0 = r34;
        r7 = r0.f3138j;	 Catch:{ a -> 0x01f5, Exception -> 0x01f0 }
        r5.m4448b(r7);	 Catch:{ a -> 0x01f5, Exception -> 0x01f0 }
    L_0x016c:
        r28 = new com.avg.toolkit.license.f;
        r28.<init>();
        r0 = r34;
        r5 = r0.f3130a;
        r0 = r28;
        r5 = r0.m4471a(r5);
        if (r5 == 0) goto L_0x01fa;
    L_0x017d:
        r10 = com.avg.toolkit.license.C1017a.C0987b.PRO;
        r8 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
    L_0x0182:
        r5 = 1;
        r0 = r36;
        if (r0 != r5) goto L_0x018e;
    L_0x0187:
        r0 = r34;
        r5 = r0.f3133e;
        r5.m4455f();
    L_0x018e:
        r0 = r18;
        r5 = r0.f3106b;
        r5 = r5.f3081e;
        r6 = r5.m4418a();
        r5 = new com.avg.toolkit.license.a;
        r0 = r34;
        r7 = r0.f3133e;
        r7 = r7.m4457h();
        r0 = r34;
        r9 = r0.f3138j;
        r0 = r34;
        r11 = r0.f3133e;
        r0 = r34;
        r12 = r0.f3138j;
        r11 = r11.m4446a(r12);
        r0 = r34;
        r12 = r0.f3133e;
        r12 = r12.m4456g();
        r5.<init>(r6, r7, r8, r9, r10, r11, r12);
        f3129d = r5;
        r5 = f3129d;
        r0 = r18;
        r7 = r0.f3106b;
        r7 = r7.f3082f;
        r5.f3117c = r7;
        r0 = r34;
        r5 = r0.f3133e;
        r7 = f3129d;
        r7 = r7.f3116b;
        r5.m4443a(r7);
        r5 = 1;
        goto L_0x0007;
    L_0x01d7:
        r12 = r24 - r20;
        r32 = 86400000; // 0x5265c00 float:7.82218E-36 double:4.2687272E-316;
        r12 = r12 / r32;
        r8 = (int) r12;
        if (r8 >= 0) goto L_0x0150;
    L_0x01e1:
        r5 = 0;
        goto L_0x0007;
    L_0x01e4:
        r8 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        goto L_0x0150;
    L_0x01e9:
        r23 = move-exception;
        r10 = r29;
        r8 = r22;
        goto L_0x0067;
    L_0x01f0:
        r23 = move-exception;
        r10 = r29;
        goto L_0x0067;
    L_0x01f5:
        r23 = move-exception;
        r10 = r29;
        goto L_0x0045;
    L_0x01fa:
        r10 = r29;
        goto L_0x0182;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avg.toolkit.license.b.a(java.lang.String, boolean):boolean");
    }

    public long m4442e() {
        if (!this.f3133e.m4445a()) {
            return 0;
        }
        Calendar now = Calendar.getInstance();
        Calendar trialStartDate = Calendar.getInstance();
        trialStartDate.setTimeInMillis(this.f3133e.m4456g());
        return (now.getTimeInMillis() - trialStartDate.getTimeInMillis()) / 86400000;
    }

    private void m4437g() {
        try {
            String newLicense = new C1024d(this.f3130a, this.f3137i, this.f3136h, this.f3135g).m4468a(this.f3130a, f3129d);
            this.f3134f.m4479a(this.f3130a);
            if (newLicense != null) {
                Bundle bundle = new Bundle();
                bundle.putString(ITKSvc.c_actionData, newLicense);
                ITKSvc.Do(this.f3130a, 5000, 5001, bundle);
            }
        } catch (Exception e) {
            if (!e.f3142a) {
                C0970a.m4322a(e);
            }
        } catch (Exception e2) {
            C0970a.m4322a(e2);
        }
    }

    public void onAlarm(Bundle arguments) {
        if (this.f3134f.m4480a(this.f3130a, arguments)) {
            m4437g();
        }
    }

    public void onStart(boolean firstTime) {
        if (firstTime) {
            this.f3133e.m4450c();
        }
        this.f3134f = new C1031b(this.f3130a, "ALM", 86400000, true, true, 5000, true);
    }

    public void onDestroy() {
        if (this.f3134f != null) {
            this.f3134f.m4481b(this.f3130a);
        }
        f3129d = null;
    }

    public int getID() {
        return 5000;
    }

    public void onMessage(Bundle arguments) {
        switch (arguments.getInt(ITKSvc.c_actionSubAction, -1)) {
            case 5001:
                boolean result = m4438a(arguments.getString(ITKSvc.c_actionData));
                Bundle bundle = new Bundle();
                if (arguments.containsKey(ITKSvc.c_actionHandler)) {
                    bundle.putParcelable(ITKSvc.c_actionHandler, (Messenger) arguments.get(ITKSvc.c_actionHandler));
                }
                bundle.putBoolean("result", result);
                ITKSvc.Do(this.f3130a, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, ITKSvc.ACTION_NOTIFY_ABOUT_NEW_LICENSE, bundle);
            case 5002:
                this.f3134f.m4482c(this.f3130a);
            case 5003:
                if (arguments.containsKey(ITKSvc.c_actionHandler)) {
                    Message msg = Message.obtain();
                    msg.obj = Boolean.valueOf(true);
                    try {
                        ((Messenger) arguments.get(ITKSvc.c_actionHandler)).send(msg);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
                m4436f();
            case 24001:
                m4435c(arguments.getString("registration_id"));
            case 24002:
                if ("update".equals(arguments.getString("action"))) {
                    this.f3134f.m4482c(this.f3130a);
                }
            default:
                C0970a.m4321a();
        }
    }

    public void onNewLicense(C1017a avgFeatures) {
    }

    public void onDailyTask(C1017a avgFeatures) {
    }

    public void setComm(List commClients) {
        commClients.add(C1025e.class);
    }

    private void m4435c(String regId) {
        new Bundle().putString("registration_id", regId);
    }
}
