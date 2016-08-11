package com.google.android.gms.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.net.UrlQuerySanitizer;
import android.net.UrlQuerySanitizer.ParameterValuePair;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.cast.Cast;
import com.millennialmedia.android.MMRequest;
import java.net.HttpURLConnection;
import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class dq {
    private static final Object px;
    private static boolean re;
    private static String rf;
    private static boolean rg;

    /* renamed from: com.google.android.gms.internal.dq.1 */
    static class C18281 implements Runnable {
        final /* synthetic */ Context pB;

        C18281(Context context) {
            this.pB = context;
        }

        public void run() {
            synchronized (dq.px) {
                dq.rf = dq.m8189j(this.pB);
                dq.px.notifyAll();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.dq.a */
    private static final class C1829a extends BroadcastReceiver {
        private C1829a() {
        }

        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
                dq.re = true;
            } else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                dq.re = false;
            }
        }
    }

    static {
        px = new Object();
        re = true;
        rg = false;
    }

    public static String m8172a(Readable readable) {
        StringBuilder stringBuilder = new StringBuilder();
        CharSequence allocate = CharBuffer.allocate(2048);
        while (true) {
            int read = readable.read(allocate);
            if (read == -1) {
                return stringBuilder.toString();
            }
            allocate.flip();
            stringBuilder.append(allocate, 0, read);
        }
    }

    private static JSONArray m8173a(Collection collection) {
        JSONArray jSONArray = new JSONArray();
        for (Object a : collection) {
            m8180a(jSONArray, a);
        }
        return jSONArray;
    }

    static JSONArray m8174a(Object[] objArr) {
        JSONArray jSONArray = new JSONArray();
        for (Object a : objArr) {
            m8180a(jSONArray, a);
        }
        return jSONArray;
    }

    private static JSONObject m8175a(Bundle bundle) {
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            m8181a(jSONObject, str, bundle.get(str));
        }
        return jSONObject;
    }

    public static void m8176a(Context context, String str, WebSettings webSettings) {
        webSettings.setUserAgentString(m8184b(context, str));
    }

    public static void m8177a(Context context, String str, List list) {
        for (String duVar : list) {
            new du(context, str, duVar).start();
        }
    }

    public static void m8178a(Context context, String str, boolean z, HttpURLConnection httpURLConnection) {
        httpURLConnection.setConnectTimeout(60000);
        httpURLConnection.setInstanceFollowRedirects(z);
        httpURLConnection.setReadTimeout(60000);
        httpURLConnection.setRequestProperty("User-Agent", m8184b(context, str));
        httpURLConnection.setUseCaches(false);
    }

    public static void m8179a(WebView webView) {
        if (VERSION.SDK_INT >= 11) {
            ds.m8201a(webView);
        }
    }

    private static void m8180a(JSONArray jSONArray, Object obj) {
        if (obj instanceof Bundle) {
            jSONArray.put(m8175a((Bundle) obj));
        } else if (obj instanceof Map) {
            jSONArray.put(m8192p((Map) obj));
        } else if (obj instanceof Collection) {
            jSONArray.put(m8173a((Collection) obj));
        } else if (obj instanceof Object[]) {
            jSONArray.put(m8174a((Object[]) obj));
        } else {
            jSONArray.put(obj);
        }
    }

    private static void m8181a(JSONObject jSONObject, String str, Object obj) {
        if (obj instanceof Bundle) {
            jSONObject.put(str, m8175a((Bundle) obj));
        } else if (obj instanceof Map) {
            jSONObject.put(str, m8192p((Map) obj));
        } else if (obj instanceof Collection) {
            if (str == null) {
                str = "null";
            }
            jSONObject.put(str, m8173a((Collection) obj));
        } else if (obj instanceof Object[]) {
            jSONObject.put(str, m8173a(Arrays.asList((Object[]) obj)));
        } else {
            jSONObject.put(str, obj);
        }
    }

    public static boolean m8182a(PackageManager packageManager, String str, String str2) {
        return packageManager.checkPermission(str2, str) == 0;
    }

    public static boolean m8183a(ClassLoader classLoader, Class cls, String str) {
        boolean z = false;
        try {
            z = cls.isAssignableFrom(Class.forName(str, false, classLoader));
        } catch (Throwable th) {
        }
        return z;
    }

    private static String m8184b(Context context, String str) {
        String str2;
        synchronized (px) {
            if (rf != null) {
                str2 = rf;
            } else {
                if (VERSION.SDK_INT >= 17) {
                    rf = dt.getDefaultUserAgent(context);
                } else if (dv.bD()) {
                    rf = m8189j(context);
                } else {
                    dv.rp.post(new C18281(context));
                    while (rf == null) {
                        try {
                            px.wait();
                        } catch (InterruptedException e) {
                            str2 = rf;
                        }
                    }
                }
                rf += " (Mobile; " + str + ")";
                str2 = rf;
            }
        }
        return str2;
    }

    public static Map m8185b(Uri uri) {
        if (uri == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        UrlQuerySanitizer urlQuerySanitizer = new UrlQuerySanitizer();
        urlQuerySanitizer.setAllowUnregisteredParamaters(true);
        urlQuerySanitizer.setUnregisteredParameterValueSanitizer(UrlQuerySanitizer.getAllButNulLegal());
        urlQuerySanitizer.parseUrl(uri.toString());
        for (ParameterValuePair parameterValuePair : urlQuerySanitizer.getParameterList()) {
            hashMap.put(parameterValuePair.mParameter, parameterValuePair.mValue);
        }
        return hashMap;
    }

    public static void m8186b(WebView webView) {
        if (VERSION.SDK_INT >= 11) {
            ds.m8202b(webView);
        }
    }

    public static int bA() {
        return VERSION.SDK_INT >= 9 ? 7 : 1;
    }

    public static boolean by() {
        return re;
    }

    public static int bz() {
        return VERSION.SDK_INT >= 9 ? 6 : 0;
    }

    public static boolean m8187h(Context context) {
        Intent intent = new Intent();
        intent.setClassName(context, AdActivity.CLASS_NAME);
        ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, Cast.MAX_MESSAGE_LENGTH);
        if (resolveActivity == null || resolveActivity.activityInfo == null) {
            dw.m8221z("Could not find com.google.android.gms.ads.AdActivity, please make sure it is declared in AndroidManifest.xml.");
            return false;
        }
        boolean z;
        String str = "com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".";
        if ((resolveActivity.activityInfo.configChanges & 16) == 0) {
            dw.m8221z(String.format(str, new Object[]{"keyboard"}));
            z = false;
        } else {
            z = true;
        }
        if ((resolveActivity.activityInfo.configChanges & 32) == 0) {
            dw.m8221z(String.format(str, new Object[]{"keyboardHidden"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & Cast.MAX_NAMESPACE_LENGTH) == 0) {
            dw.m8221z(String.format(str, new Object[]{MMRequest.KEY_ORIENTATION}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & 256) == 0) {
            dw.m8221z(String.format(str, new Object[]{"screenLayout"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & AdRequest.MAX_CONTENT_URL_LENGTH) == 0) {
            dw.m8221z(String.format(str, new Object[]{"uiMode"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & 1024) == 0) {
            dw.m8221z(String.format(str, new Object[]{"screenSize"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & 2048) != 0) {
            return z;
        }
        dw.m8221z(String.format(str, new Object[]{"smallestScreenSize"}));
        return false;
    }

    public static void m8188i(Context context) {
        if (!rg) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            context.getApplicationContext().registerReceiver(new C1829a(), intentFilter);
            rg = true;
        }
    }

    private static String m8189j(Context context) {
        return new WebView(context).getSettings().getUserAgentString();
    }

    public static JSONObject m8192p(Map map) {
        try {
            JSONObject jSONObject = new JSONObject();
            for (String str : map.keySet()) {
                m8181a(jSONObject, str, map.get(str));
            }
            return jSONObject;
        } catch (ClassCastException e) {
            throw new JSONException("Could not convert map to JSON: " + e.getMessage());
        }
    }

    public static String m8193r(String str) {
        return Uri.parse(str).buildUpon().query(null).build().toString();
    }
}
