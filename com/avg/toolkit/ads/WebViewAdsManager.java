package com.avg.toolkit.ads;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.avg.toolkit.crashReport.CrashReport;
import com.avg.toolkit.license.C1017a;
import com.avg.toolkit.p034b.C0952b;
import com.avg.toolkit.p047a.C0905a.C0903b;
import com.avg.toolkit.p049e.C0970a;
import com.mopub.mobileads.CustomEventBannerAdapter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p000a.p001a.p002a.p003a.p005b.C0003a;

public class WebViewAdsManager extends FrameLayout {
    public static final String CATEGORY_ANTITHEFT = "antitheft";
    public static final String CATEGORY_FILE_SCANNER = "FileScanner";
    public static final String CATEGORY_PERFORMANCE = "performance";
    public static final String CATEGORY_PERFORMANCE_BATTERY = "PerformanceBattery";
    public static final String CATEGORY_PERFORMANCE_BATTERY_SETTINGS = "PerformanceBatterySettings";
    public static final String CATEGORY_PERFORMANCE_STORAGE = "PerformanceStorage";
    public static final String CATEGORY_PRIVACY = "privacy";
    public static final String CATEGORY_PROTECTION = "protection";
    public static final String CATEGORY_SCAN_RESULTS = "ScanResults";
    private static final Object f2741o;
    private WebView f2742a;
    private boolean f2743b;
    private boolean f2744c;
    private Activity f2745d;
    private Integer f2746e;
    private boolean f2747f;
    private final int f2748g;
    private final String f2749h;
    private final String f2750i;
    private final String f2751j;
    private final String f2752k;
    private final String f2753l;
    private final int f2754m;
    private final String f2755n;
    private C0923a f2756p;
    private C0923a f2757q;
    private Runnable f2758r;

    /* renamed from: com.avg.toolkit.ads.WebViewAdsManager.1 */
    class C09161 implements Runnable {
        final /* synthetic */ HandlerThread f2717a;
        final /* synthetic */ WebViewAdsManager f2718b;

        C09161(WebViewAdsManager webViewAdsManager, HandlerThread handlerThread) {
            this.f2718b = webViewAdsManager;
            this.f2717a = handlerThread;
        }

        public void run() {
            this.f2717a.quit();
        }
    }

    /* renamed from: com.avg.toolkit.ads.WebViewAdsManager.2 */
    class C09192 implements Runnable {
        final /* synthetic */ String f2721a;
        final /* synthetic */ Bitmap f2722b;
        final /* synthetic */ String f2723c;
        final /* synthetic */ WebViewAdsManager f2724d;

        /* renamed from: com.avg.toolkit.ads.WebViewAdsManager.2.1 */
        class C09171 implements Comparator {
            final /* synthetic */ C09192 f2719a;

            C09171(C09192 c09192) {
                this.f2719a = c09192;
            }

            public /* synthetic */ int compare(Object x0, Object x1) {
                return m4195a((File) x0, (File) x1);
            }

            public int m4195a(File lhs, File rhs) {
                return (int) (lhs.lastModified() - rhs.lastModified());
            }
        }

        /* renamed from: com.avg.toolkit.ads.WebViewAdsManager.2.2 */
        class C09182 implements Runnable {
            final /* synthetic */ C09192 f2720a;

            C09182(C09192 c09192) {
                this.f2720a = c09192;
            }

            public void run() {
                if (this.f2720a.f2724d.f2742a != null && this.f2720a.f2724d.f2743b) {
                    this.f2720a.f2724d.f2742a.clearCache(false);
                }
            }
        }

        C09192(WebViewAdsManager webViewAdsManager, String str, Bitmap bitmap, String str2) {
            this.f2724d = webViewAdsManager;
            this.f2721a = str;
            this.f2722b = bitmap;
            this.f2723c = str2;
        }

        public void run() {
            Throwable th;
            synchronized (WebViewAdsManager.f2741o) {
                FileOutputStream fileOutputStream = null;
                try {
                    File adsCacheDir = new File(this.f2724d.f2745d.getCacheDir(), "adsCache");
                    adsCacheDir.mkdir();
                    File[] filesArr = adsCacheDir.listFiles();
                    if (filesArr == null) {
                        adsCacheDir.delete();
                        adsCacheDir.mkdir();
                        filesArr = adsCacheDir.listFiles();
                    }
                    if (filesArr != null) {
                        File file;
                        int cacheSize = 0;
                        for (File file2 : filesArr) {
                            cacheSize = (int) (((long) cacheSize) + file2.length());
                        }
                        if (cacheSize >= 409600) {
                            int length = filesArr.length;
                            if (r0 > 1) {
                                List filesList = Arrays.asList(filesArr);
                                Collections.sort(filesList, new C09171(this));
                                Iterator it = filesList.iterator();
                                while (cacheSize >= 409600 && it.hasNext()) {
                                    file2 = (File) it.next();
                                    cacheSize = (int) (((long) cacheSize) - file2.length());
                                    file2.delete();
                                }
                            }
                        }
                    }
                    String adShaName = C0003a.m41e(this.f2721a);
                    String imgName = adShaName + "_ad_cache.png";
                    FileOutputStream fos = new FileOutputStream(adsCacheDir + "/" + imgName);
                    try {
                        this.f2722b.compress(CompressFormat.PNG, 100, fos);
                        fos.flush();
                        fos.close();
                        fileOutputStream = null;
                        fos = new FileOutputStream(adsCacheDir + "/" + adShaName + "_ad_cache.html");
                        PrintWriter printWriter = new PrintWriter(fos);
                        printWriter.print("<html xmlns=\"http://www.w3.org/1999/xhtml\" lang=\"en\">\n<head>\n\t<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\" />\n\t<style type=\"text/css\">\n\n\tbody {\n\tmargin: 0;\n\tpadding: 0;\n\t}\n\n\t</style>\n</head>\n");
                        printWriter.print("<body><a href=\"" + this.f2723c + "\"><img src=\"" + imgName + "\" width=\"100%\" height=\"100%\" /></a></body>\n</html>");
                        printWriter.flush();
                        printWriter.close();
                        fos.close();
                        fileOutputStream = null;
                        this.f2724d.post(new C09182(this));
                        this.f2722b.recycle();
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e) {
                            }
                        }
                    } catch (IOException e2) {
                        fileOutputStream = fos;
                        this.f2722b.recycle();
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e3) {
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream = fos;
                        this.f2722b.recycle();
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e4) {
                            }
                        }
                        throw th;
                    }
                } catch (IOException e5) {
                    this.f2722b.recycle();
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                } catch (Throwable th3) {
                    th = th3;
                    this.f2722b.recycle();
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw th;
                }
            }
        }
    }

    /* renamed from: com.avg.toolkit.ads.WebViewAdsManager.a */
    private class C0923a implements Runnable {
        public boolean f2730a;
        final /* synthetic */ WebViewAdsManager f2731b;
        private boolean f2732c;
        private boolean f2733d;
        private WebView f2734e;
        private Activity f2735f;
        private String f2736g;
        private String f2737h;
        private String f2738i;
        private String f2739j;
        private boolean f2740k;

        /* renamed from: com.avg.toolkit.ads.WebViewAdsManager.a.1 */
        class C09211 extends WebViewClient {
            final /* synthetic */ WebViewAdsManager f2726a;
            final /* synthetic */ C0923a f2727b;

            /* renamed from: com.avg.toolkit.ads.WebViewAdsManager.a.1.1 */
            class C09201 implements Runnable {
                final /* synthetic */ C09211 f2725a;

                C09201(C09211 c09211) {
                    this.f2725a = c09211;
                }

                public void run() {
                    synchronized (this.f2725a.f2727b) {
                        if (this.f2725a.f2727b.f2730a) {
                            this.f2725a.f2727b.f2731b.m4215a(this.f2725a.f2727b.f2736g, this.f2725a.f2727b.f2737h);
                        }
                    }
                }
            }

            C09211(C0923a c0923a, WebViewAdsManager webViewAdsManager) {
                this.f2727b = c0923a;
                this.f2726a = webViewAdsManager;
            }

            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (this.f2727b.f2732c) {
                    try {
                        this.f2727b.f2735f.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
                    } catch (Exception e) {
                        C0970a.m4322a(e);
                    }
                } else {
                    view.loadUrl(url);
                }
                return true;
            }

            public void onPageFinished(WebView webView, String url) {
                if (!this.f2727b.f2733d) {
                    synchronized (this.f2727b) {
                        if (this.f2727b.f2730a && !this.f2727b.f2732c) {
                            Display display = this.f2727b.f2735f.getWindowManager().getDefaultDisplay();
                            this.f2727b.f2731b.m4212a(this.f2727b.f2734e, this.f2727b.f2740k);
                            this.f2727b.f2732c = true;
                            if (!this.f2727b.f2740k) {
                                this.f2727b.f2731b.postDelayed(new C09201(this), 3000);
                            }
                        }
                    }
                }
            }

            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                this.f2727b.f2733d = true;
            }
        }

        /* renamed from: com.avg.toolkit.ads.WebViewAdsManager.a.2 */
        class C09222 implements OnTouchListener {
            final /* synthetic */ WebViewAdsManager f2728a;
            final /* synthetic */ C0923a f2729b;

            C09222(C0923a c0923a, WebViewAdsManager webViewAdsManager) {
                this.f2729b = c0923a;
                this.f2728a = webViewAdsManager;
            }

            public boolean onTouch(View v, MotionEvent event) {
                return event.getAction() == 2;
            }
        }

        public synchronized void m4206a() {
            if (this.f2730a) {
                this.f2730a = false;
                if (this.f2734e.getTag() != "tag") {
                    this.f2734e.stopLoading();
                    if (!this.f2732c) {
                        this.f2734e.destroy();
                    }
                }
            }
        }

        public C0923a(WebViewAdsManager webViewAdsManager, Activity activity, String lng, String category, boolean loadFromCache) {
            this.f2731b = webViewAdsManager;
            this.f2730a = true;
            this.f2732c = false;
            this.f2733d = false;
            this.f2735f = null;
            this.f2736g = null;
            this.f2737h = null;
            this.f2740k = false;
            this.f2735f = activity;
            this.f2738i = lng;
            this.f2739j = category;
            this.f2740k = loadFromCache;
            this.f2734e = new WebView(activity.getApplicationContext());
            this.f2734e.setVisibility(8);
            this.f2734e.getSettings().setLoadsImagesAutomatically(true);
            this.f2734e.getSettings().setJavaScriptEnabled(false);
            this.f2734e.setVerticalScrollBarEnabled(false);
            this.f2734e.setHorizontalScrollBarEnabled(false);
            this.f2734e.setFocusable(false);
            this.f2734e.setBackgroundColor(0);
            webViewAdsManager.setBackgroundColor(0);
            this.f2734e.setWebViewClient(new C09211(this, webViewAdsManager));
            this.f2734e.setOnTouchListener(new C09222(this, webViewAdsManager));
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private java.lang.String m4199b() {
            /*
            r24 = this;
            r5 = com.avg.toolkit.license.C1019b.m4431a();
            r14 = com.avg.toolkit.p047a.C0905a.m4154a();
            r17 = 0;
        L_0x000a:
            if (r5 == 0) goto L_0x000e;
        L_0x000c:
            if (r14 != 0) goto L_0x0026;
        L_0x000e:
            r21 = 10;
            r0 = r17;
            r1 = r21;
            if (r0 >= r1) goto L_0x0026;
        L_0x0016:
            r22 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
            java.lang.Thread.sleep(r22);	 Catch:{ InterruptedException -> 0x0221 }
        L_0x001b:
            r5 = com.avg.toolkit.license.C1019b.m4431a();
            r14 = com.avg.toolkit.p047a.C0905a.m4154a();
            r17 = r17 + 1;
            goto L_0x000a;
        L_0x0026:
            r21 = 10;
            r0 = r17;
            r1 = r21;
            if (r0 != r1) goto L_0x0031;
        L_0x002e:
            r21 = 0;
        L_0x0030:
            return r21;
        L_0x0031:
            if (r14 == 0) goto L_0x0216;
        L_0x0033:
            r21 = r14.m4151a();
            r13 = java.lang.String.valueOf(r21);
        L_0x003b:
            r0 = r24;
            r0 = r0.f2735f;
            r21 = r0;
            r6 = com.avg.toolkit.ads.WebViewAdsManager.m4216b(r21);
            r18 = "";
            r21 = r5.m4427b();
            if (r21 == 0) goto L_0x021a;
        L_0x004d:
            r15 = 1;
        L_0x004e:
            r0 = r5.f3120f;
            r20 = r0;
            r0 = r24;
            r0 = r0.f2735f;
            r21 = r0;
            r21 = r21.getWindowManager();
            r4 = r21.getDefaultDisplay();
            r9 = new android.util.DisplayMetrics;
            r9.<init>();
            r4.getMetrics(r9);
            r10 = "";
            r21 = android.os.Build.MODEL;	 Catch:{ Exception -> 0x0227 }
            if (r21 == 0) goto L_0x021d;
        L_0x006e:
            r10 = android.os.Build.MODEL;	 Catch:{ Exception -> 0x0227 }
        L_0x0070:
            r21 = "UTF-8";
            r0 = r21;
            r10 = java.net.URLEncoder.encode(r10, r0);	 Catch:{ Exception -> 0x0227 }
        L_0x0078:
            r8 = "";
            r21 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Exception -> 0x0224 }
            r22 = 3;
            r0 = r21;
            r1 = r22;
            if (r0 <= r1) goto L_0x0096;
        L_0x0084:
            r21 = android.os.Build.class;
            r22 = "MANUFACTURER";
            r21 = r21.getField(r22);	 Catch:{ Exception -> 0x0224 }
            r22 = 0;
            r21 = r21.get(r22);	 Catch:{ Exception -> 0x0224 }
            r8 = r21.toString();	 Catch:{ Exception -> 0x0224 }
        L_0x0096:
            r21 = "UTF-8";
            r0 = r21;
            r8 = java.net.URLEncoder.encode(r8, r0);	 Catch:{ Exception -> 0x0224 }
        L_0x009e:
            r0 = r24;
            r0 = r0.f2735f;
            r21 = r0;
            r21 = r21.getPackageManager();
            r0 = r24;
            r0 = r0.f2735f;
            r22 = r0;
            r22 = r22.getPackageName();
            r23 = 0;
            r12 = r21.getPackageInfo(r22, r23);
            r21 = new com.avg.toolkit.uid.UUID;
            r0 = r24;
            r0 = r0.f2735f;
            r22 = r0;
            r22 = r22.getApplicationContext();
            r21.<init>(r22);
            r19 = r21.getUUID();
            r21 = new java.lang.StringBuilder;
            r22 = "uuid=";
            r21.<init>(r22);
            r0 = r21;
            r1 = r19;
            r21 = r0.append(r1);
            r22 = " lng=";
            r21 = r21.append(r22);
            r0 = r24;
            r0 = r0.f2738i;
            r22 = r0;
            r21 = r21.append(r22);
            r22 = " screen=";
            r21 = r21.append(r22);
            r0 = r9.widthPixels;
            r22 = r0;
            r21 = r21.append(r22);
            r22 = 88;
            r21 = r21.append(r22);
            r0 = r9.heightPixels;
            r22 = r0;
            r21 = r21.append(r22);
            r22 = 88;
            r21 = r21.append(r22);
            r0 = r9.densityDpi;
            r22 = r0;
            r21 = r21.append(r22);
            r22 = " cat=";
            r21 = r21.append(r22);
            r0 = r24;
            r0 = r0.f2739j;
            r22 = r0;
            r21 = r21.append(r22);
            r22 = " model=";
            r21 = r21.append(r22);
            r0 = r21;
            r21 = r0.append(r10);
            r22 = " manufacturer=";
            r21 = r21.append(r22);
            r0 = r21;
            r21 = r0.append(r8);
            r22 = " os=Android-";
            r21 = r21.append(r22);
            r22 = android.os.Build.VERSION.SDK_INT;
            r21 = r21.append(r22);
            r22 = " pv=";
            r21 = r21.append(r22);
            r0 = r12.versionName;
            r22 = r0;
            r21 = r21.append(r22);
            r22 = 46;
            r21 = r21.append(r22);
            r0 = r12.versionCode;
            r22 = r0;
            r21 = r21.append(r22);
            r22 = " pid=";
            r21 = r21.append(r22);
            r0 = r21;
            r21 = r0.append(r13);
            r22 = " pt=";
            r21 = r21.append(r22);
            r0 = r21;
            r21 = r0.append(r15);
            r22 = " idate=";
            r21 = r21.append(r22);
            r0 = r21;
            r21 = r0.append(r6);
            r22 = " varc=";
            r21 = r21.append(r22);
            r0 = r21;
            r1 = r20;
            r21 = r0.append(r1);
            r22 = " lic=";
            r21 = r21.append(r22);
            r0 = r21;
            r1 = r18;
            r11 = r0.append(r1);
            r2 = r11.toString();
            r21 = new java.lang.StringBuilder;
            r21.<init>();
            r0 = r21;
            r21 = r0.append(r2);
            r22 = "d5544fG==*%877hT--==HHSYlWeeY89904444==";
            r21 = r21.append(r22);
            r21 = r21.toString();
            r21 = r21.getBytes();
            r16 = p000a.p001a.p002a.p003a.p005b.C0003a.m42e(r21);
            r21 = new java.lang.StringBuilder;
            r21.<init>();
            r0 = r21;
            r21 = r0.append(r2);
            r22 = " z=";
            r21 = r21.append(r22);
            r0 = r21;
            r1 = r16;
            r21 = r0.append(r1);
            r2 = r21.toString();
            r3 = new java.lang.String;
            r21 = r2.getBytes();
            r22 = 0;
            r21 = p000a.p001a.p002a.p003a.p004a.C0000a.m3a(r21, r22);
            r0 = r21;
            r3.<init>(r0);
            r21 = new java.lang.StringBuilder;
            r21.<init>();
            r22 = "http://www.avg.com/mobile-ads?a=";
            r21 = r21.append(r22);
            r0 = r21;
            r21 = r0.append(r3);
            r21 = r21.toString();
            r0 = r21;
            r1 = r24;
            r1.f2736g = r0;
            r0 = r24;
            r0 = r0.f2736g;
            r21 = r0;
            goto L_0x0030;
        L_0x0216:
            r13 = "";
            goto L_0x003b;
        L_0x021a:
            r15 = 3;
            goto L_0x004e;
        L_0x021d:
            r10 = "";
            goto L_0x0070;
        L_0x0221:
            r21 = move-exception;
            goto L_0x001b;
        L_0x0224:
            r21 = move-exception;
            goto L_0x009e;
        L_0x0227:
            r21 = move-exception;
            goto L_0x0078;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.avg.toolkit.ads.WebViewAdsManager.a.b():java.lang.String");
        }

        public void run() {
            Throwable th;
            InputStream is = null;
            Writer writer = null;
            InputStreamReader reader = null;
            HttpURLConnection conn = null;
            try {
                m4199b();
                if (this.f2736g == null) {
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (Exception e) {
                            C0970a.m4322a(e);
                        }
                    }
                    if (is != null) {
                        try {
                            is.close();
                        } catch (Exception e2) {
                            C0970a.m4322a(e2);
                        }
                    }
                    if (writer != null) {
                        try {
                            writer.close();
                        } catch (Exception e22) {
                            C0970a.m4322a(e22);
                        }
                    }
                    if (conn != null) {
                        conn.disconnect();
                        return;
                    }
                    return;
                }
                String adShaName = C0003a.m41e(this.f2736g);
                if (this.f2740k) {
                    this.f2734e.loadUrl("file://" + new File(this.f2731b.f2745d.getCacheDir(), "adsCache") + "/" + adShaName + "_ad_cache.html");
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (Exception e222) {
                            C0970a.m4322a(e222);
                        }
                    }
                    if (is != null) {
                        try {
                            is.close();
                        } catch (Exception e2222) {
                            C0970a.m4322a(e2222);
                        }
                    }
                    if (writer != null) {
                        try {
                            writer.close();
                        } catch (Exception e22222) {
                            C0970a.m4322a(e22222);
                        }
                    }
                    if (conn != null) {
                        conn.disconnect();
                        return;
                    }
                    return;
                }
                conn = (HttpURLConnection) new URL(this.f2736g).openConnection();
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Cache-Control", "no-cache");
                conn.setRequestProperty("Pragma", "no-cache");
                conn.setConnectTimeout(CustomEventBannerAdapter.DEFAULT_BANNER_TIMEOUT_DELAY);
                conn.setReadTimeout(CrashReport.FEATURE_ID);
                conn.connect();
                if (conn.getResponseCode() != 200) {
                    File adsCacheDir = new File(this.f2731b.f2745d.getCacheDir(), "adsCache");
                    new File(adsCacheDir, adShaName + "_ad_cache.html").delete();
                    new File(adsCacheDir, adShaName + "_ad_cache.png").delete();
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (Exception e222222) {
                            C0970a.m4322a(e222222);
                        }
                    }
                    if (is != null) {
                        try {
                            is.close();
                        } catch (Exception e2222222) {
                            C0970a.m4322a(e2222222);
                        }
                    }
                    if (writer != null) {
                        try {
                            writer.close();
                        } catch (Exception e22222222) {
                            C0970a.m4322a(e22222222);
                        }
                    }
                    if (conn != null) {
                        conn.disconnect();
                        return;
                    }
                    return;
                }
                is = conn.getInputStream();
                char[] buffer = new char[1024];
                Writer writer2 = new StringWriter();
                try {
                    InputStreamReader inputStreamReader = new InputStreamReader(is, Charset.defaultCharset());
                    while (this.f2730a && this.f2731b.f2743b) {
                        try {
                            int len = inputStreamReader.read(buffer);
                            if (len != -1) {
                                writer2.write(buffer, 0, len);
                            }
                        } catch (Exception e3) {
                            reader = inputStreamReader;
                            writer = writer2;
                        } catch (Throwable th2) {
                            th = th2;
                            reader = inputStreamReader;
                            writer = writer2;
                        }
                    }
                    break;
                    String page = writer2.toString();
                    Matcher matcher = Pattern.compile("<a\\s*href=\"([^\"]*+)\"").matcher(page);
                    while (matcher.find()) {
                        this.f2737h = matcher.group(1);
                    }
                    if (this.f2730a && this.f2731b.f2743b) {
                        this.f2734e.loadDataWithBaseURL(this.f2736g, page, "text/html", "UTF-8", null);
                    }
                    if (inputStreamReader != null) {
                        try {
                            inputStreamReader.close();
                        } catch (Exception e222222222) {
                            C0970a.m4322a(e222222222);
                        }
                    }
                    if (is != null) {
                        try {
                            is.close();
                        } catch (Exception e2222222222) {
                            C0970a.m4322a(e2222222222);
                        }
                    }
                    if (writer2 != null) {
                        try {
                            writer2.close();
                        } catch (Exception e22222222222) {
                            C0970a.m4322a(e22222222222);
                        }
                    }
                    if (conn != null) {
                        conn.disconnect();
                        reader = inputStreamReader;
                        writer = writer2;
                        return;
                    }
                    reader = inputStreamReader;
                    writer = writer2;
                } catch (Exception e4) {
                    writer = writer2;
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (Exception e222222222222) {
                            C0970a.m4322a(e222222222222);
                        }
                    }
                    if (is != null) {
                        try {
                            is.close();
                        } catch (Exception e2222222222222) {
                            C0970a.m4322a(e2222222222222);
                        }
                    }
                    if (writer != null) {
                        try {
                            writer.close();
                        } catch (Exception e22222222222222) {
                            C0970a.m4322a(e22222222222222);
                        }
                    }
                    if (conn != null) {
                        conn.disconnect();
                    }
                } catch (Throwable th3) {
                    th = th3;
                    writer = writer2;
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (Exception e222222222222222) {
                            C0970a.m4322a(e222222222222222);
                        }
                    }
                    if (is != null) {
                        try {
                            is.close();
                        } catch (Exception e2222222222222222) {
                            C0970a.m4322a(e2222222222222222);
                        }
                    }
                    if (writer != null) {
                        try {
                            writer.close();
                        } catch (Exception e22222222222222222) {
                            C0970a.m4322a(e22222222222222222);
                        }
                    }
                    if (conn != null) {
                        conn.disconnect();
                    }
                    throw th;
                }
            } catch (Exception e5) {
                if (reader != null) {
                    reader.close();
                }
                if (is != null) {
                    is.close();
                }
                if (writer != null) {
                    writer.close();
                }
                if (conn != null) {
                    conn.disconnect();
                }
            } catch (Throwable th4) {
                th = th4;
                if (reader != null) {
                    reader.close();
                }
                if (is != null) {
                    is.close();
                }
                if (writer != null) {
                    writer.close();
                }
                if (conn != null) {
                    conn.disconnect();
                }
                throw th;
            }
        }
    }

    public WebViewAdsManager(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f2742a = null;
        this.f2743b = true;
        this.f2744c = true;
        this.f2748g = 1024;
        this.f2749h = "http://www.avg.com/mobile-ads?a=";
        this.f2750i = "http://www.avg.com/mobile-ads-testing?a=";
        this.f2751j = "adsCache";
        this.f2752k = "_ad_cache.html";
        this.f2753l = "_ad_cache.png";
        this.f2754m = 409600;
        this.f2755n = "tag";
        this.f2756p = null;
        this.f2757q = null;
    }

    public WebViewAdsManager(Context context) {
        super(context);
        this.f2742a = null;
        this.f2743b = true;
        this.f2744c = true;
        this.f2748g = 1024;
        this.f2749h = "http://www.avg.com/mobile-ads?a=";
        this.f2750i = "http://www.avg.com/mobile-ads-testing?a=";
        this.f2751j = "adsCache";
        this.f2752k = "_ad_cache.html";
        this.f2753l = "_ad_cache.png";
        this.f2754m = 409600;
        this.f2755n = "tag";
        this.f2756p = null;
        this.f2757q = null;
    }

    static {
        f2741o = new Object();
    }

    public void setAdLoadedListener(Runnable adLoadedListener) {
        this.f2758r = adLoadedListener;
    }

    public void initAds(Activity activity, String lng, String category, Integer optionalHeightDP, boolean showAdsInLandscape) {
        this.f2746e = optionalHeightDP;
        this.f2747f = showAdsInLandscape;
        this.f2745d = activity;
        if (C0952b.m4281a((Context) activity)) {
            if (this.f2756p != null) {
                this.f2756p.m4206a();
                this.f2757q.m4206a();
            }
            this.f2756p = new C0923a(this, activity, lng, category, false);
            this.f2757q = new C0923a(this, activity, lng, category, true);
            this.f2744c = true;
            HandlerThread ht = new HandlerThread("adsLoader");
            ht.start();
            Handler handler = new Handler(ht.getLooper());
            handler.post(this.f2757q);
            handler.post(this.f2756p);
            handler.post(new C09161(this, ht));
        }
    }

    public void onConfigurationChanged(Activity activity, Configuration newConfig) {
        if (this.f2742a != null) {
            m4211a(activity);
        }
    }

    private synchronized void m4212a(WebView newWebView, boolean fromCache) {
        if (this.f2743b && (!fromCache || this.f2744c)) {
            this.f2744c = false;
            newWebView.setVisibility(8);
            if (this.f2742a == null) {
                this.f2742a = newWebView;
                addView(this.f2742a);
                m4211a(this.f2745d);
            } else {
                WebView oldWebView = this.f2742a;
                addView(newWebView, 0);
                this.f2742a = newWebView;
                m4211a(this.f2745d);
                removeView(oldWebView);
                oldWebView.setTag("tag");
                oldWebView.destroy();
            }
            if (this.f2758r != null) {
                this.f2758r.run();
            }
        }
    }

    private int m4207a(int screenHeight) {
        if (this.f2746e != null) {
            return this.f2746e.intValue();
        }
        if (screenHeight >= 800) {
            return 90;
        }
        if (screenHeight >= 480) {
            return 60;
        }
        return 50;
    }

    private void m4215a(String adUrl, String clickLink) {
        if (clickLink != null) {
            this.f2745d.getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
            if (this.f2742a.getWidth() != 0 && this.f2742a.getHeight() != 0) {
                Bitmap bitmap = Bitmap.createBitmap(this.f2742a.getWidth(), this.f2742a.getHeight(), Config.ARGB_8888);
                this.f2742a.draw(new Canvas(bitmap));
                new Thread(new C09192(this, adUrl, bitmap, clickLink)).start();
            }
        }
    }

    private void m4211a(Activity activity) {
        Display display = activity.getWindowManager().getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        this.f2742a.setLayoutParams(new LayoutParams(-1, (int) (((double) m4207a(metrics.heightPixels)) * (((double) metrics.densityDpi) / 160.0d))));
        double widthInch = (double) (((float) metrics.widthPixels) / metrics.xdpi);
        double heightInch = (double) (((float) metrics.heightPixels) / metrics.ydpi);
        double screenSize = Math.sqrt(Math.pow(widthInch, 2.0d) + Math.pow(heightInch, 2.0d));
        if (this.f2747f) {
            this.f2742a.setVisibility(0);
        } else if (widthInch > heightInch) {
            this.f2742a.setVisibility(8);
        } else {
            this.f2742a.setVisibility(0);
        }
    }

    public void stop() {
        if (this.f2756p != null) {
            this.f2757q.m4206a();
            this.f2756p.m4206a();
            if (this.f2742a != null) {
                removeView(this.f2742a);
                this.f2742a.destroy();
            }
        }
        this.f2743b = false;
    }

    @SuppressLint({"NewApi"})
    private static long m4216b(Context context) {
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

    protected C0903b getDebugProductId() {
        return null;
    }

    protected C1017a getDebugFeatures() {
        return null;
    }
}
